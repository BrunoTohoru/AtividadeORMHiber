package com.mycompany.atividadelp3.dao;

import com.mycompany.atividadelp3.bean.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class ClienteDao implements Dao<Integer, Cliente> {

    protected Connection con;

    public ClienteDao(Connection con) {
        this.con = con;
    }

    @Override
    public void create(Cliente entity) {
        String sql = "INSERT INTO cliente(nome, endereco, telefone) VALUES (?, ?, ?)";

        try {
            PreparedStatement query = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            query.setString(1, entity.getNome());
            query.setString(2, entity.getEndereco());
            query.setString(3, entity.getTelefone());
            query.executeUpdate();

            ResultSet rs = query.getGeneratedKeys();

            if (rs.next()) {
                int id = rs.getInt(1);
                entity.setId(id);
            }
            query.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Cliente retrieve(Integer pk) {
        Cliente cliente = null;

        if (pk != null) {
            String sql = "SELECT id, nome, endereco, telefone FROM cliente WHERE id = ?";

            try {
                PreparedStatement query = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                query.setInt(1, pk);
                ResultSet rs = query.executeQuery();

                if (rs.next()) {
                    cliente = new Cliente();
                    cliente.setId(rs.getInt("id"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setEndereco(rs.getString("endereco"));
                    cliente.setTelefone(rs.getString("telefone"));
                }
                query.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
        return cliente;
    }

    @Override
    public void update(Cliente entity) {
        String sql = "UPDATE cliente SET nome = ?, endereco = ?, telefone = ? WHERE id = ?";

        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setString(1, entity.getNome());
            query.setString(2, entity.getEndereco());
            query.setString(3, entity.getTelefone());
            int rowsUpdated = query.executeUpdate();

            query.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Integer pk) {
        String sql = "DELETE FROM cliente WHERE id = ?";

        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, pk);
            int rowsUpdated = query.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> clientes = new LinkedList<Cliente>();
        String sql = "SELECT id, nome, endereco, telefone FROM cliente";

        try {
            PreparedStatement query = con.prepareStatement(sql);
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));

                clientes.add(cliente);
            }

            query.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return clientes;
    }

}
