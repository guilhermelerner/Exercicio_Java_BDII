package org.example.model;

public class Disciplina {
    private int disciplinaId;
    private String nome;

    public Disciplina(){}

    public Disciplina(String nome, int Id){
        this.disciplinaId = Id;
        this.nome = nome;
    }

    public int getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(int disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "disciplinaId=" + disciplinaId +
                ", nome='" + nome + '\'' +
                '}';
    }
}
