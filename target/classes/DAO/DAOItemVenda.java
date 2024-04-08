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
import model.bo.ItemVenda;
import model.bo.Carteirinha;
import model.bo.Cliente;
import model.bo.ItemVenda;
import model.bo.Produto;
import model.bo.Venda;
import view.Busca.CarteirinhaView;
import view.Compra.PontoDeVendaView;

/**
 *
 * @author eduar
 */
public class DAOItemVenda implements InterfaceDAO<ItemVenda> {

    private static DAOItemVenda instance;
    protected EntityManager entityManager;

    public static DAOItemVenda getInstance() {
        if (instance == null) {
            instance = new DAOItemVenda();
        }
        return instance;
    }

    public DAOItemVenda() {
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
    public void create(ItemVenda objeto) {
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
    public void delete(ItemVenda objeto) {

    }

    @Override
    public void update(ItemVenda objeto) {
        try {
            ItemVenda ItemVenda = entityManager.find(ItemVenda.class,objeto);
            
            entityManager.getTransaction().begin();
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void retrieve(ItemVenda objeto) {

    }

    @Override
    public List<ItemVenda> retrieve() {
        List<ItemVenda> listaItemVenda;
        listaItemVenda = entityManager.createQuery("select b from ItemVenda b", ItemVenda.class).getResultList();
        return listaItemVenda;
    }

    @Override
    public ItemVenda retrieve(int parPK) {
        return entityManager.find(ItemVenda.class, parPK);
    }

    @Override
    public List<ItemVenda> retrieve(String parString) {
        
        List<ItemVenda> listaItemVenda;
        listaItemVenda = entityManager.createQuery("select b from ItemVenda b where b.descricao like :parDescricao",ItemVenda.class).setParameter("parDescricao","%" +parString + "%").getResultList();
        return listaItemVenda;

    }

   
}
