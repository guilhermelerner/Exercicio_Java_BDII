package org.example.dao;

import org.example.model.Disciplina;
import org.example.model.Estudante;
import org.example.model.EstudanteDisciplina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudanteDisciplinaDBDAO implements EstudanteDisciplinaDAO, IConst{
    private String sql;
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet result;
    private void open() throws SQLException {
        connection = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
    }
    public EstudanteDisciplina buscaIndividual(int estudanteID, int disciplinaID) throws SQLException {
        open();
        sql = "SELECT FROM * estudante_disciplina WHERE estuddante_ID = ? AND disciplina_ID = ?";
        statement= connection.prepareStatement(sql);
        statement.setInt(1,estudanteID);
        statement.setInt(2,disciplinaID);
        result = statement.executeQuery();

        EstudanteDBDAO estudanteDB = new EstudanteDBDAO();
        DisciplinaDBDAO disciplinaDB = new DisciplinaDBDAO();

        if(result.next()){
            EstudanteDisciplina estudanteDisciplina = new EstudanteDisciplina();
            estudanteDisciplina.setEstudante(estudanteDB.buscaPorCodigo(result.getInt("estudante_ID")));
            estudanteDisciplina.setDisciplina(disciplinaDB.buscaPorCodigo(result.getInt("disciplina_ID")));
            close();
            return estudanteDisciplina;
        } else {
            close();
            return null;
        }

    }

    private void close() throws SQLException {
        connection.close();
    }
    @Override
    public void insere(EstudanteDisciplina estudanteDisciplina) throws SQLException {
        open();
        sql = "INSERT INTO estudantedisciplina (estudante_id,disciplina_id) VALUES (?,?);";
        statement = connection.prepareStatement(sql);
        statement.setInt(1, estudanteDisciplina.getEstudante().getEstudanteId());
        statement.setInt(2,estudanteDisciplina.getDisciplina().getDisciplinaId());
        statement.executeUpdate();
        close();
    }

    @Override
    public List<EstudanteDisciplina> listTodos() throws SQLException {
        open();
        sql = "SELECT * FROM estudantedisciplina;";
        statement = connection.prepareStatement(sql);
        result = statement.executeQuery();

        ArrayList<EstudanteDisciplina> estudantedisciplinas = new ArrayList<>();
        while(result.next()) {
            EstudanteDisciplina estudaDisc = new EstudanteDisciplina();

            // Inicialize os objetos Estudante e Disciplina antes de acessá-los
            estudaDisc.setEstudante(new Estudante());
            estudaDisc.setDisciplina(new Disciplina());

            estudaDisc.getEstudante().setEstudanteId(result.getInt("estudante_id"));
            estudaDisc.getDisciplina().setDisciplinaId(result.getInt("disciplina_id"));

            estudantedisciplinas.add(estudaDisc);
        }
        close();
        return estudantedisciplinas;
    }
}
