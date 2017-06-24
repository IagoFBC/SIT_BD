package main.java.DAO;

import main.java.Connection.ConnectionFactory;
import main.java.Model.Conjunto;

import java.sql.*;

public class ConjuntoDAO {

    private Connection connection;

    public ConjuntoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Conjunto conjunto){

        String sql = "INSERT INTO public.tb_conjunto_dados(tcod_seq, tcod_torg_seq, tcod_serie, tcod_titulo, tcod_dataset, tcod_data_modif, tcod_data_ini, tcod_data_final, tcod_json) VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, conjunto.getId_conj());
            stmt.setInt(2, conjunto.getId_org());
            stmt.setInt(3, conjunto.getSerie());
            stmt.setString(4, conjunto.getNome());
            stmt.setString(5, conjunto.getDataset());;
            stmt.setDate(6, convertJavaDateToSqlDate(conjunto.getData_modif()));
            stmt.setDate(7, convertJavaDateToSqlDate(conjunto.getData_ini()));
            stmt.setDate(8, convertJavaDateToSqlDate(conjunto.getData_final()));
            stmt.setString(9, conjunto.getJson());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public static java.sql.Date convertJavaDateToSqlDate(java.util.Date data){
        return new java.sql.Date(data.getTime());
    }
}
