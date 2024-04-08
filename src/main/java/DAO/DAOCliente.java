/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static controller.Busca.ControllerClienteView.colunaFiltro;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.bo.Cliente;
import model.bo.Cliente;
import model.bo.Endereco;

public class DAOCliente implements InterfaceDAO<Cliente> {

    private static DAOCliente instance;
    protected EntityManager entityManager;

    public static DAOCliente getInstance() {
        if (instance == null) {
            instance = new DAOCliente();
        }
        return instance;
    }

    public DAOCliente() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu_Cantina");

        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;

    }

    @Override
    public void create(Cliente objeto) {
        try {
          entityManager.getTransaction().begin();
          entityManager.persist(objeto);
          entityManager.getTransaction().commit();
          
        } catch (Exception ex) {
          ex.printStackTrace();
          entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Cliente objeto) {

    }

    @Override
    public void update(Cliente objeto) {
        try {
            Cliente Cliente = entityManager.find(Cliente.class,objeto);
            
            entityManager.getTransaction().begin();
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void retrieve(Cliente objeto) {

    }

    @Override
    public List<Cliente> retrieve() {
        List<Cliente> listaClientes;
        listaClientes = entityManager.createQuery("select b from Cliente b", Cliente.class).getResultList();
        return listaClientes;
    }

    @Override
    public Cliente retrieve(int parPK) {
        return entityManager.find(Cliente.class, parPK);
    }

    @Override
    public List<Cliente> retrieve(String parString) {
        
        List<Cliente> listaClientes;
        listaClientes = entityManager.createQuery("select b from Cliente b where b.descricao like :parDescricao",Cliente.class).setParameter("parDescricao","%" +parString + "%").getResultList();
        return listaClientes;

    }

    
   

}
