package br.com.fatec.techninja.model;

import java.util.ArrayList;
import java.util.List;

//está sendo implementado o padrão de projeto Builder.
//O objetivo é facilitar a criação de instâncias da classe Modulo permitindo a definição de seus atributos de forma fluente e flexível.
public class Modulo {

    // Declaração do campo título, que armazenará o título do módulo
    private String titulo;

    // Construtor privado de Modulo, recebendo um objeto Builder como parâmetro
    private Modulo(Builder builder)
    {
        // Atribui o título fornecido pelo Builder ao campo título
        this.titulo = builder.titulo;
    }

    // Classe interna estática Builder para construir instâncias de Modulo
    public static class Builder {
        // Campo para armazenar temporariamente o título do módulo durante a construção

        private String titulo;

        // Método para definir o título do módulo, retornando o próprio Builder para chamadas encadeadas
        public Builder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        // Método para criar e retornar uma nova instância de Modulo usando o construtor privado de Modulo
        public Modulo build() {

            return new Modulo(this);
        }
    }
}