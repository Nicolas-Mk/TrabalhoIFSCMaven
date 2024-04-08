/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.Persiste.funcionarioList;
import static controller.Busca.ControllerFuncionarioView.colunaFiltro;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.bo.Funcionario;
import model.bo.Endereco;
import model.bo.Funcionario;

public class DAOFuncionario implements InterfaceDAO<Funcionario> {

    private static DAOFuncionario instance;
    protected EntityManager entityManager;

    public static DAOFuncionario getInstance() {
        if (instance == null) {
            instance = new DAOFuncionario();
        }
        return instance;
    }

    public DAOFuncionario() {
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
    public void create(Funcionario objeto) {
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
    public void delete(Funcionario objeto) {

    }

    @Override
    public void update(Funcionario objeto) {
        try {
            Funcionario Funcionario = entityManager.find(Funcionario.class,objeto);
            
            entityManager.getTransaction().begin();
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void retrieve(Funcionario objeto) {

    }

    @Override
    public List<Funcionario> retrieve() {
        List<Funcionario> listaFuncionarios;
        listaFuncionarios = entityManager.createQuery("select b from Funcionario b", Funcionario.class).getResultList();
        return listaFuncionarios;
    }

    @Override
    public Funcionario retrieve(int parPK) {
        return entityManager.find(Funcionario.class, parPK);
    }

    @Override
    public List<Funcionario> retrieve(String parString) {
        
        List<Funcionario> listaFuncionarios;
        listaFuncionarios = entityManager.createQuery("select b from Funcionario b where b.descricao like :parDescricao",Funcionario.class).setParameter("parDescricao","%" +parString + "%").getResultList();
        return listaFuncionarios;

    }
   

}
