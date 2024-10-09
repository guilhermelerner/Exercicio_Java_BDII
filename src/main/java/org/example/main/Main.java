package org.example.main;

import java.sql.SQLException;

import org.example.dao.DisciplinaDBDAO;
import org.example.dao.EstudanteDBDAO;
import org.example.dao.EstudanteDisciplinaDBDAO;
import org.example.model.Disciplina;
import org.example.model.Estudante;
import org.example.model.EstudanteDisciplina;

public class Main {

    public static void main(String[] args) throws SQLException {
        Estudante estudante = new Estudante(1, "Andre", 22);
        EstudanteDBDAO estudanteDAO = new EstudanteDBDAO();

        System.out.println("######### Operacoes sobre a tabela Estudante ###########");

        System.out.println("Insere o estudante Andr:");
        estudanteDAO.insere(estudante);

        System.out.println("Lista os estudantes no banco:");
        //Chamadas a println com apenas um objeto fazem com que toString seja chamado
        //automaticamente.
        System.out.println(estudanteDAO.listTodos());

        System.out.println("Muda o nome de Andre para Andre Galvao e idade de 22 para 17:");
        Estudante estudante01 = new Estudante(1, "Andre Galvao", 17);
        estudanteDAO.atualiza(estudante01);

        System.out.println("Lista os estudantes no banco:");
        System.out.println(estudanteDAO.listTodos());

        System.out.println("Insere o estudante Mario:");
        Estudante estudante02 = new Estudante(2, "Mario", 23);
        estudanteDAO.insere(estudante02);

        System.out.println("Lista os estudantes no banco:");
        System.out.println(estudanteDAO.listTodos());

        System.out.println("Insere a estudante Mariane:");
        Estudante estudante03 = new Estudante(3, "Mariane", 19);
        estudanteDAO.insere(estudante03);

        System.out.println("Lista os estudantes no banco:");
        System.out.println(estudanteDAO.listTodos());

        System.out.println("Retorna o estudante Mario:");
        System.out.println(estudanteDAO.buscaPorCodigo(2));

        System.out.println("Remove o estudante Mario:");
        estudanteDAO.remove(estudanteDAO.buscaPorCodigo(2));

        System.out.println("Lista os estudantes no banco:");
        System.out.println(estudanteDAO.listTodos());

        System.out.println("\n######### Operacoes sobre a tabela Disciplina ###########");

        Disciplina disciplina = new Disciplina("matematica", 1);
        DisciplinaDBDAO disciplinaDAO = new DisciplinaDBDAO();

        System.out.println("Insere a disciplina Matemetica:");
        disciplinaDAO.insere(disciplina);

        System.out.println("Lista as disciplinas no banco:");
        System.out.println(disciplinaDAO.listTodos());

        System.out.println("Muda o nome de Matemetica para Calculo I:");
        Disciplina disciplina01 = new Disciplina("Calculo I", 1);
        disciplinaDAO.atualiza(disciplina01);

        System.out.println("Lista as disciplinas no banco:");
        System.out.println(disciplinaDAO.listTodos());

        System.out.println("Insere a disciplina Portugues:");
        Disciplina disciplina02 = new Disciplina("Portugues", 2);
        disciplinaDAO.insere(disciplina02);

        System.out.println("Lista as disciplinas no banco:");
        System.out.println(disciplinaDAO.listTodos());

        System.out.println("Insere a disciplina Ingles:");
        Disciplina disciplina03 = new Disciplina("Ingles", 3);
        disciplinaDAO.insere(disciplina03);

        System.out.println("Lista as disciplinas no banco:");
        System.out.println(disciplinaDAO.listTodos());

        System.out.println("Retorna a disciplina Portugues:");
        System.out.println(disciplinaDAO.buscaPorCodigo(2));

        System.out.println("Remove a disciplina Portugues:");
        disciplinaDAO.remove(disciplinaDAO.buscaPorCodigo(2));

        System.out.println("Lista as disciplinas no banco:");
        System.out.println(disciplinaDAO.listTodos());

        System.out.println("\n######### Operacoes sobre a tabela EstudanteDisciplina ###########");

        EstudanteDisciplina estudanteDisciplina = new EstudanteDisciplina();
        estudanteDisciplina.setEstudante(estudanteDAO.buscaPorCodigo(1));
        estudanteDisciplina.setDisciplina(disciplinaDAO.buscaPorCodigo(1));

        System.out.println("Cria relacao entre estudante e disciplina:");
        EstudanteDisciplinaDBDAO estudanteDisciplinaDAO = new EstudanteDisciplinaDBDAO();
        estudanteDisciplinaDAO.insere(estudanteDisciplina);

        System.out.println("Lista todas as relacoes entre estudante e disciplina:");
        System.out.println(estudanteDisciplinaDAO.listTodos());
    }
}