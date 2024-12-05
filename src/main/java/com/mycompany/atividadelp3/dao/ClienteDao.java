package com.mycompany.atividadelp3.dao;

import com.mycompany.atividadelp3.bean.Cliente;

public class ClienteDao extends DaoGenerico<Cliente, Long> {

    public ClienteDao() {
        super(Cliente.class);
    }
}