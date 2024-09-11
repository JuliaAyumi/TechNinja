import express from "express";
import mongoose from "mongoose";
import cors from "cors";
import bcrypt from "bcryptjs";
import jwt from "jsonwebtoken";
import dotenv from "dotenv"

dotenv.config()

const app = express();
const PORT = 5000;

app.use(cors());
app.use(express.json());

mongoose
  .connect()
  .then(() => {
    console.log("Conectado ao MongoDB Atlas");
  })
  .catch((error) => {
    console.error("Erro ao conectar no MongoDB:", error);
  });

const userSchema = new mongoose.Schema({
  nome: { type: String, required: true },
  email: { type: String, required: true, unique: true },
  matricula: { type: String, default: "" },
  senha: { type: String, required: true },
  usuario: { type: String, default: "" },
  avatar: { type: String, default: "" },
  pontuacao: { type: String, default: "" },
  nivelmodulo: { type: String, default: "" },
  ranking: { type: String, default: "" },
}, { collection: "Usuarios" });

const User = mongoose.model("Usuário", userSchema, "Usuarios");

// Rota de Registrar Usuário
app.post("/api/register", async (req, res) => {
  try {
    const { nome, email, senha } = req.body;

    if (!nome || !email || !senha) {
      return res.status(400).json({ message: "Todos os campos são obrigatórios" });
    }

    const userExists = await User.findOne({ email });
    if (userExists) {
      return res.status(400).json({ message: "Usuário já existe" });
    }

    const hashedPassword = await bcrypt.hash(senha, 10);

    const newUser = new User({
      nome,
      email,
      senha: hashedPassword,
    });

    await newUser.save();
    res.status(201).json({ message: "Usuário registrado com sucesso" });
  } catch (error) {
    console.error("Erro na rota de registro:", error);
    res.status(500).json({ error: "Internal server error" });
  }
});

// Rota de Login
app.post("/api/login", async (req, res) => {
  try {
    const { email, senha } = req.body;

    if (!email || !senha) {
      return res.status(400).json({ message: "Email e senha são obrigatórios" });
    }

    const user = await User.findOne({ email });
    if (!user) {
      return res.status(400).json({ message: "Usuário não encontrado" });
    }

    const isMatch = await bcrypt.compare(senha, user.senha);
    if (!isMatch) {
      return res.status(400).json({ message: "Senha incorreta" });
    }

    const token = jwt.sign({ id: user._id }, "secret", { expiresIn: "1h" });

    res.status(200).json({ token });
  } catch (error) {
    console.error("Erro na rota de login:", error);
    res.status(500).json({ error: "Internal server error" });
  }
});

app.listen(PORT, () => {
  console.log(`Servidor rodando em http://localhost:${PORT}`);
});
