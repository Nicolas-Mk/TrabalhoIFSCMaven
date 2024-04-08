/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.Persiste.fornecedorList;
import static controller.Busca.ControllerFornecedorView.colunaFiltro;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.bo.Fornecedor;
import model.bo.Cidade;
import model.bo.Endereco;
import model.bo.Fornecedor;

public class DAOFornecedor implements InterfaceDAO<Fornecedor> {

    private static DAOFornecedor instance;
    protected EntityManager entityManager;

    public static DAOFornecedor getInstance() {
        if (instance == null) {
            instance = new DAOFornecedor();
        }
        return instance;
    }

    public DAOFornecedor() {
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
    public void create(Fornecedor objeto) {
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
    public void delete(Fornecedor objeto) {

    }

    @Override
    public void update(Fornecedor objeto) {
        try {
            Fornecedor Fornecedor = entityManager.find(Fornecedor.class,objeto);
            
            entityManager.getTransaction().begin();
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void retrieve(Fornecedor objeto) {

    }

    @Override
    public List<Fornecedor> retrieve() {
        List<Fornecedor> listaFornecedor;
        listaFornecedor = entityManager.createQuery("select b from Fornecedor b", Fornecedor.class).getResultList();
        return listaFornecedor;
    }

    @Override
    public Fornecedor retrieve(int parPK) {
        return entityManager.find(Fornecedor.class, parPK);
    }

    @Override
    public List<Fornecedor> retrieve(String parString) {
        
        List<Fornecedor> listaFornecedor;
        listaFornecedor = entityManager.createQuery("select b from Fornecedor b where b.descricao like :parDescricao",Fornecedor.class).setParameter("parDescricao","%" +parString + "%").getResultList();
        return listaFornecedor;

    }
    
}
