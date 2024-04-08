/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;
import model.bo.Bairro;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOBairro implements InterfaceDAO<Bairro> {

    private static DAOBairro instance;
    protected EntityManager entityManager;

    public static DAOBairro getInstance() {
        if (instance == null) {
            instance = new DAOBairro();
        }
        return instance;
    }

    public DAOBairro() {
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
    public void create(Bairro objeto) {
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
    public void delete(Bairro objeto) {

    }

    @Override
    public void update(Bairro objeto) {
        try {
            Bairro bairro = entityManager.find(Bairro.class,objeto.getId());
            
            entityManager.getTransaction().begin();
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();  
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void retrieve(Bairro objeto) {

    }

    @Override
    public List<Bairro> retrieve() {
        List<Bairro> listaBairros;
        listaBairros = entityManager.createQuery("select b from Bairro b", Bairro.class).getResultList();
        return listaBairros;
    }

    @Override
    public Bairro retrieve(int parPK) {
        return entityManager.find(Bairro.class, parPK);
    }

    @Override
    public List<Bairro> retrieve(String parString) {
        
        List<Bairro> listaBairros;
        listaBairros = entityManager.createQuery("select b from Bairro b where b.descricao like :parDescricao",Bairro.class).setParameter("parDescricao","%" +parString + "%").getResultList();
        return listaBairros;

    }

}
