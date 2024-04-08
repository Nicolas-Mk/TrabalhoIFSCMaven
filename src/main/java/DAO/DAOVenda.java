/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;
import controller.Busca.ControllerCarteirinhaView;
import static controller.Busca.ControllerCarteirinhaView.colunaFiltro;
import controller.Compra.ControllerPontoDeVenda;
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
import model.bo.Venda;
import model.bo.Carteirinha;
import model.bo.Cliente;
import model.bo.Funcionario;
import model.bo.ItemVenda;
import model.bo.Produto;
import model.bo.Venda;
import view.Busca.CarteirinhaView;
import view.Compra.PontoDeVendaView;

/**
 *
 * @author eduar
 */
public class DAOVenda implements InterfaceDAO<Venda> {

    private static DAOVenda instance;
    protected EntityManager entityManager;

    public static DAOVenda getInstance() {
        if (instance == null) {
            instance = new DAOVenda();
        }
        return instance;
    }

    public DAOVenda() {
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
    public void create(Venda objeto) {
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
    public void delete(Venda objeto) {

    }

    @Override
    public void update(Venda objeto) {
        try {
            Venda Venda = entityManager.find(Venda.class,objeto);
            
            entityManager.getTransaction().begin();
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void retrieve(Venda objeto) {

    }

    @Override
    public List<Venda> retrieve() {
        List<Venda> listaVendas;
        listaVendas = entityManager.createQuery("select b from Venda b", Venda.class).getResultList();
        return listaVendas;
    }

    @Override
    public Venda retrieve(int parPK) {
        return entityManager.find(Venda.class, parPK);
    }

    @Override
    public List<Venda> retrieve(String parString) {
        
        List<Venda> listaVendas;
        listaVendas = entityManager.createQuery("select b from Venda b where b.descricao like :parDescricao",Venda.class).setParameter("parDescricao","%" +parString + "%").getResultList();
        return listaVendas;

    }

    public String retornoNome(String info) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
