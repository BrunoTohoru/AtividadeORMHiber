/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividadelp3.dao;

import com.mycompany.atividadelp3.bean.Filme;
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
public class FilmeDao implements Dao<Integer, Filme> {

    protected Connection con;

    public FilmeDao(Connection con) {
        this.con = con;
    }

    @Override
    public void create(Filme entity) {
        String sql = "INSERT INTO filme(nome, ano, duracao, foto, sinopse, estilo_id) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement query = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            query.setString(1, entity.getNome());
            query.setString(2, entity.getAno());
            query.setInt(3, entity.getDuracao());
            query.setBlob(4, entity.getFoto(), entity.getTamanhoFoto());
            query.setString(5, entity.getSinopse());
            query.setInt(6, entity.getEstilo().getId());
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
    public Filme retrieve(Integer pk) {
        Filme filme = null;
        String sql = "SELECT * FROM filme WHERE id = ?";

        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, pk);
            ResultSet rs = query.executeQuery();

            if (rs.next()) {
                EstiloDao daoEstilo = new EstiloDao(con);
                filme = new Filme();
                filme.setId(rs.getInt("id"));
                filme.setNome(rs.getString("nome"));
                filme.setAno(rs.getString("ano"));
                filme.setDuracao(rs.getInt("duracao"));
                filme.setFoto(rs.getBlob("foto").getBinaryStream());
                filme.setSinopse(rs.getString("sinopse"));
                filme.setEstilo(daoEstilo.retrieve(rs.getInt("estilo_id"))); //OLHA AQUI DEPOIS
            }
            query.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return filme;
    }

    @Override
    public void update(Filme entity) {
        String sql = "UPDATE filme SET nome = ?, ano = ?, duracao = ?, foto = ?, sinopse = ?, estilo_id = ? WHERE id = ?";
        try {
            EstiloDao daoEstilo = new EstiloDao(con);
            if (entity.getEstilo().getId() <= 0) {
                daoEstilo.create(entity.getEstilo());
            }
            PreparedStatement query = con.prepareStatement(sql);
            query.setString(1, entity.getNome());
            query.setString(2, entity.getAno());
            query.setInt(3, entity.getDuracao());
            query.setBlob(4, entity.getFoto(), entity.getTamanhoFoto());
            query.setString(5, entity.getSinopse());
            query.setInt(6, entity.getEstilo().getId());
            query.setInt(7, entity.getId());
            query.executeUpdate();
            query.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Integer pk) {
        String sql = "DELETE FROM filme WHERE id = ?";
        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, pk);
            query.executeUpdate();
            query.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Filme> findAll() {
        List<Filme> filmes = new LinkedList<Filme>();

        try {
            String sql = "SELECT id, nome, ano, duracao, foto, sinopse, estilo_id FROM filme";
            PreparedStatement query = con.prepareStatement(sql);
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                EstiloDao daoEstilo = new EstiloDao(con);
                Filme filme = new Filme();
                filme.setId(rs.getInt("id"));
                filme.setNome(rs.getString("nome"));
                filme.setAno(rs.getString("ano"));
                filme.setDuracao(rs.getInt("duracao"));
                filme.setFoto(rs.getBlob("foto").getBinaryStream());
                filme.setSinopse(rs.getString("sinopse"));
                filme.setEstilo(daoEstilo.retrieve(rs.getInt("estilo_id")));

                filmes.add(filme);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return filmes;
    }

}
