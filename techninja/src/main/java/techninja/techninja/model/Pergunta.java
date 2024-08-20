package techninja.techninja.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

@Document(collection = "Perguntas")
public class Pergunta {

    @Id
    private String id;
    private String area;
    private String dificuldade;
    private String pergunta;

    private Alternativa[] alternativas;

    private String resposta;

    //Getters e Setters

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getArea(){
        return area;
    }

    public void setArea(String area){
        this.area = area;
    }

    public String getDificuldade(){
        return dificuldade;
    }

    public void setDificuldade(String dificuldade){
        this.dificuldade = dificuldade;
    }

    public String getPergunta(){
        return pergunta;
    }

    public void setPergunta(){
        this.pergunta = pergunta;
    }

    public Alternativa[] getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(Alternativa[] alternativas) {
        this.alternativas = alternativas;
    }

    public String getResposta(){return resposta;}

    public void setResposta(){this.resposta = resposta;}

}
