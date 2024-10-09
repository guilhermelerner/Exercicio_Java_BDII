package org.example.dao;

import org.example.model.Estudante;
import org.example.model.EstudanteDisciplina;

import java.sql.SQLException;
import java.util.List;

public interface EstudanteDisciplinaDAO {
    public void insere(EstudanteDisciplina estudanteDisciplina) throws SQLException;
    //public void atualiza(EstudanteDisciplina estudanteDisciplina) throws SQLException;
    //public void remove(EstudanteDisciplina estudanteDisciplina) throws SQLException;
    //public EstudanteDisciplina buscaPorCodigo(int estudanteDisciplina_estudanteID) throws SQLException;
    public List<EstudanteDisciplina> listTodos() throws SQLException;
}
