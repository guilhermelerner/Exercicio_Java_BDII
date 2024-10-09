package org.example.model;

public class Estudante {
    private int estudanteId;
    private String nome;
    private int idade;

    public Estudante(){}

    public Estudante(int estudanteId, String nome, int idade) {
        this.estudanteId = estudanteId;
        this.idade = idade;
        this.nome = nome;
    }

    public int getEstudanteId() {
        return estudanteId;
    }

    public void setEstudanteId(int estudanteId) {
        this.estudanteId = estudanteId;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}