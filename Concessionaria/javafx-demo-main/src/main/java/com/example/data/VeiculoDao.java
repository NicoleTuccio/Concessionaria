package com.example.data;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.example.model.Veiculo;

public class VeiculoDao {

    final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    final String USER = "RM99711";
    final String PASS = "290204";
    
    public void inserir(Veiculo Veiculo) throws SQLException{
        var conexao = DriverManager.getConnection(URL, USER, PASS);

        var sql = "INSERT INTO tbl_veiculos_RM99711 (marca, modelo, ano, valor) VALUES (?, ?, ?, ?) ";
        var comando = conexao.prepareStatement(sql);
        comando.setString(1, Veiculo.getMarca());
        comando.setString(2, Veiculo.getModelo());
        comando.setInt(3, Veiculo.getAno());
        comando.setBigDecimal(4, Veiculo.getValor());

        comando.executeUpdate();

        conexao.close();
    }
}
