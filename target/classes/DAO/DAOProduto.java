/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.Persiste.produtoList;
import controller.Busca.ControllerProdutoView;
import static controller.Busca.ControllerProdutoView.colunaFiltro;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;
import model.bo.Produto;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import model.bo.Produto;
import view.Busca.ProdutoView;

public class DAOProduto implements InterfaceDAO<Produto> {

    private static DAOProduto instance;
    protected EntityManager entityManager;

    public static DAOProduto getInstance() {
        if (instance == null) {
            instance = new DAOProduto();
        }
        return instance;
    }

    public DAOProduto() {
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
    public void create(Produto objeto) {
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
    public void delete(Produto objeto) {

    }

    @Override
    public void update(Produto objeto) {
        try {
            Produto Produto = entityManager.find(Produto.class,objeto.getId());
            
            entityManager.getTransaction().begin();
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void retrieve(Produto objeto) {

    }

    @Override
    public List<Produto> retrieve() {
        List<Produto> listaProdutos;
        listaProdutos = entityManager.createQuery("select b from Produto b", Produto.class).getResultList();
        return listaProdutos;
    }

    @Override
    public Produto retrieve(int parPK) {
        return entityManager.find(Produto.class, parPK);
    }

    @Override
    public List<Produto> retrieve(String parString) {
        
        List<Produto> listaProdutos;
        listaProdutos = entityManager.createQuery("select b from Produto b where b.descricao like :parDescricao",Produto.class).setParameter("parDescricao","%" +parString + "%").getResultList();
        return listaProdutos;

    }

    public Produto RetornaDeLadinho(String cod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
