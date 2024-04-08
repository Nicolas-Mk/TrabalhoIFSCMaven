/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.Busca.ControllerCarteirinhaView;
import static controller.Busca.ControllerCarteirinhaView.colunaFiltro;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import model.bo.Carteirinha;
import model.bo.Carteirinha;
import model.bo.Cliente;
import view.Busca.CarteirinhaView;

public class DAOCarteirinha implements InterfaceDAO<Carteirinha> {

    private static DAOCarteirinha instance;
    protected EntityManager entityManager;

    public static DAOCarteirinha getInstance() {
        if (instance == null) {
            instance = new DAOCarteirinha();
        }
        return instance;
    }

    public DAOCarteirinha() {
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
    public void create(Carteirinha objeto) {
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
    public void delete(Carteirinha objeto) {

    }

    @Override
    public void update(Carteirinha objeto) {
        try {
            Carteirinha Carteirinha = entityManager.find(Carteirinha.class,objeto);
            
            entityManager.getTransaction().begin();
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void retrieve(Carteirinha objeto) {

    }

    @Override
    public List<Carteirinha> retrieve() {
        List<Carteirinha> listaCarteirinhas;
        listaCarteirinhas = entityManager.createQuery("select b from Carteirinha b", Carteirinha.class).getResultList();
        return listaCarteirinhas;
    }

    @Override
    public Carteirinha retrieve(int parPK) {
        return entityManager.find(Carteirinha.class, parPK);
    }

    @Override
    public List<Carteirinha> retrieve(String parString) {
        
        List<Carteirinha> listaCarteirinhas;
        listaCarteirinhas = entityManager.createQuery("select b from Carteirinha b where b.descricao like :parDescricao",Carteirinha.class).setParameter("parDescricao","%" +parString + "%").getResultList();
        return listaCarteirinhas;

    }

    
}
