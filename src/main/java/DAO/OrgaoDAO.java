package main.java.DAO;

import main.java.Connection.ConnectionFactory;
import main.java.Model.Orgao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrgaoDAO {

    private Connection connection;

    public OrgaoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Orgao orgao){

        String sql = "INSERT INTO public.tb_orgao(torg_nome, torg_sigla, torg_descricao, torg_tag) VALUES(?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, orgao.getNome());
            stmt.setString(2, orgao.getSigla());
            stmt.setString(3, orgao.getDescricao());
            stmt.setString(4, orgao.getTag());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
}

