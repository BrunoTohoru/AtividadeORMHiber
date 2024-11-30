/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividadelp3.dao;

import com.mycompany.atividadelp3.bean.Locacao;
import java.sql.Connection;
import java.sql.Date;
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
public class LocacaoDao implements Dao<Integer, Locacao> {

    protected Connection con;

    public LocacaoDao(Connection con) {
        this.con = con;
    }

    @Override
    public void create(Locacao entity) {
        String sql = "INSERT INTO locacao(emissao, devolucao, valor, filme_id, cliente_id) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement query = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            query.setDate(1, new Date(entity.getEmissao().getTime()));
            query.setDate(2, new Date(entity.getDevolucao().getTime()));
            query.setDouble(3, entity.getValor());
            query.setInt(4, entity.getFilme().getId());
            query.setInt(5, entity.getCliente().getId());

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
    public Locacao retrieve(Integer pk) {
        Locacao locacao = null;
        String sql = "SELECT * FROM locacao WHERE id = ?";
        try {
            FilmeDao daoFilme = new FilmeDao(con);
            ClienteDao daoCliente = new ClienteDao(con);
            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, pk);
            ResultSet rs = query.executeQuery();
            if (rs.next()) {
                locacao.setId(rs.getInt("id"));
                locacao.setEmissao(rs.getDate("emissao"));
                locacao.setDevolucao(rs.getDate("devolucao"));
                locacao.setValor(rs.getDouble("valor"));
                locacao.setFilme(daoFilme.retrieve(rs.getInt("filme_id")));
                locacao.setCliente(daoCliente.retrieve(rs.getInt("cliente_id")));
            }
            query.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return locacao;
    }

    @Override
    public void update(Locacao entity) {
        String sql = "UPDATE locacao SET emissao = ?, devolucao = ?, valor = ?, filme_id = ?, cliente_id = ? WHERE id = ?";
        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setDate(1, new Date(entity.getEmissao().getTime()));
            query.setDate(2, new Date(entity.getDevolucao().getTime()));
            query.setDouble(3, entity.getValor());
            query.setInt(4, entity.getFilme().getId());
            query.setInt(5, entity.getCliente().getId());
            query.executeUpdate();
            query.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Integer pk) {
        String sql = "DELETE FROM locacao WHERE id = ?";
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
    public List<Locacao> findAll() {
        List<Locacao> locacoes = new LinkedList<Locacao>();

        String sql = "SELECT * FROM locacao";
        try {
            FilmeDao daoFilme = new FilmeDao(con);
            ClienteDao daoCliente = new ClienteDao(con);
            PreparedStatement query = con.prepareStatement(sql);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                Locacao locacao = new Locacao();
                locacao.setId(rs.getInt("id"));
                locacao.setEmissao(rs.getDate("emissao"));
                locacao.setDevolucao(rs.getDate("devolucao"));
                locacao.setValor(rs.getDouble("valor"));
                locacao.setFilme(daoFilme.retrieve(rs.getInt("filme_id")));
                locacao.setCliente(daoCliente.retrieve(rs.getInt("cliente_id")));

                locacoes.add(locacao);
            }
            query.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return locacoes;
    }

}
