package org.example.dao;

import org.example.model.Disciplina;
import org.example.model.Estudante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDBDAO implements DisciplinaDAO, IConst{
    private String sql;
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet result;

    private void open() throws SQLException {
        connection = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
    }

    private void close() throws SQLException {
        connection.close();
    }
    @Override
    public void insere(Disciplina disciplina) throws SQLException {
        open();
        sql = "INSERT INTO disciplina (disciplina_id,nome) VALUES (?,?);";
        statement = connection.prepareStatement(sql);
        statement.setInt(1, disciplina.getDisciplinaId());
        statement.setString(2,disciplina.getNome());
        statement.executeUpdate();
        close();
    }

    @Override
    public void atualiza(Disciplina disciplina) throws SQLException {
        open();
        sql="UPDATE disciplina SET nome=? WHERE disciplina_id = ?;";
        statement = connection.prepareStatement(sql);

        statement.setString(1,disciplina.getNome());
        statement.setInt(2,disciplina.getDisciplinaId());
        statement.executeUpdate();
        close();
    }

    @Override
    public void remove(Disciplina disciplina) throws SQLException {
        open();
        sql = "DELETE FROM disciplina WHERE disciplina_id=?";
        statement = connection.prepareStatement(sql);
        statement.setInt(1,disciplina.getDisciplinaId());
        statement.executeUpdate();
        close();
    }

    @Override
    public Disciplina buscaPorCodigo(int disciplinaID) throws SQLException {
        open();
        sql = "SELECT * FROM disciplina WHERE disciplina_id= ?";
        statement = connection.prepareStatement(sql);
        statement.setInt(1,disciplinaID);
        result = statement.executeQuery();
        if(result.next()){
            Disciplina disciplina = new Disciplina();
            disciplina.setDisciplinaId(result.getInt("disciplina_id"));
            disciplina.setNome(result.getString("nome"));
            close();
            return disciplina;
        }
        else{
            close();
            return null;
        }
    }

    @Override
    public List<Disciplina> listTodos() throws SQLException {
        open();
        sql = "SELECT * FROM disciplina;";
        statement = connection.prepareStatement(sql);
        result = statement.executeQuery();
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        while(result.next()){
            Disciplina disciplina = new Disciplina();
            disciplina.setDisciplinaId(result.getInt("disciplina_id"));
            disciplina.setNome(result.getString("nome"));
            disciplinas.add(disciplina);

        }
        close();
        return disciplinas;
    }
}