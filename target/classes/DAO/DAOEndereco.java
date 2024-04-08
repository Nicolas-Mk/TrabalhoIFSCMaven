/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.Persiste.enderecoList;
import static controller.Busca.ControllerEnderecoView.colunaFiltro;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;
import model.bo.Endereco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.bo.Endereco;
import model.bo.Cidade;

public class DAOEndereco implements InterfaceDAO<Endereco> {

private static DAOEndereco instance;
    protected EntityManager entityManager;

    public static DAOEndereco getInstance() {
        if (instance == null) {
            instance = new DAOEndereco();
        }
        return instance;
    }

    public DAOEndereco() {
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
    public void create(Endereco objeto) {
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
    public void delete(Endereco objeto) {

    }

    @Override
    public void update(Endereco objeto) {
        try {
            Endereco Endereco = entityManager.find(Endereco.class,objeto);
            
            entityManager.getTransaction().begin();
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void retrieve(Endereco objeto) {

    }

    @Override
    public List<Endereco> retrieve() {
        List<Endereco> listaEnderecos;
        listaEnderecos = entityManager.createQuery("select b from Endereco b", Endereco.class).getResultList();
        return listaEnderecos;
    }

    @Override
    public Endereco retrieve(int parPK) {
        return entityManager.find(Endereco.class, parPK);
    }

    @Override
    public List<Endereco> retrieve(String parString) {
        
        List<Endereco> listaEnderecos;
        listaEnderecos = entityManager.createQuery("select b from Endereco b where b.descricao like :parDescricao",Endereco.class).setParameter("parDescricao","%" +parString + "%").getResultList();
        return listaEnderecos;

    }    
    
    
}
