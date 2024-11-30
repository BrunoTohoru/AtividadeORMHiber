/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividadelp3.dao;

import com.mycompany.atividadelp3.bean.Estilo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class EstiloDao implements Dao<Integer, Estilo> {

    protected Connection con;

    public EstiloDao(Connection con) {
        this.con = con;
    }

    @Override
    public void create(Estilo entity) {
        String sql = "INSERT INTO estilo(nome) VALUES (?)";
        try {
            PreparedStatement query = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            query.setString(1, entity.getNome());
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
    public Estilo retrieve(Integer pk) {
        Estilo estilo = null;
        if (pk != null) {
            try {
                String sql = "SELECT id, nome FROM estilo WHERE id = ?";
                PreparedStatement query = con.prepareStatement(sql);
                query.setInt(1, pk);
                ResultSet rs = query.executeQuery();

                if (rs.next()) {
                    estilo = new Estilo();
                    estilo.setId(rs.getInt("id"));
                    estilo.setNome(rs.getString("nome"));
                }
                query.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return estilo;
    }

    @Override
    public void update(Estilo entity) {
        String sql = "UPDATE estilo SET nome = ? WHERE id = ?";

        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setString(1, entity.getNome());
            query.setInt(2, entity.getId());
            int rowsUpdated = query.executeUpdate();
            query.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Integer pk) {
        String sql = "DELETE FROM estilo WHERE id = ?";

        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, pk);
            int rowsUpdated = query.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Estilo> findAll() {
        List<Estilo> estilos = new LinkedList<Estilo>();
        String sql = "SELECT id, nome FROM estilo";
        try {
            PreparedStatement query = con.prepareStatement(sql);
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                Estilo estilo = new Estilo();
                estilo.setId(rs.getInt("id"));
                estilo.setNome(rs.getString("nome"));
                estilos.add(estilo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return estilos;
    }

}
