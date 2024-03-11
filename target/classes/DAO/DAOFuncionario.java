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
import model.bo.Endereco;
import model.bo.Funcionario;

public class DAOFuncionario implements InterfaceDAO<Funcionario> {

    @Override
    public void create(Funcionario objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO tblfuncionario "
                + "(nome,fone1,fone2,email,status,complementoEndereco,cpf,rg,usuario,senha,TBLENDERECO_ID) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,(SELECT id FROM TBLENDERECO WHERE logradouro LIKE ? ))";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2,objeto.getFone1());
            pstm.setString(3,objeto.getFone2());
            pstm.setString(4,objeto.getEmail());
            pstm.setString(5,objeto.getStatus());
            pstm.setString(6,objeto.getComplementoEndereco());
            pstm.setString(7, objeto.getCpf());
            pstm.setString(8,objeto.getRg());
            pstm.setString(9,objeto.getUsuario());
            pstm.setString(10,objeto.getSenha());
            pstm.setString(11,objeto.getEndereco().getLogradouro());
           
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);

        }

    }

    @Override
    public void delete(Funcionario objeto) {

    }

    @Override
    public void update(Funcionario objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE tblFuncionario SET nome = ? ,"
                                                 +"fone1 = ?,"
                                                 +"fone2 = ?,"
                                                 +"email = ?,"
                                                 +"status = ?,"
                                                 +"complementoEndereco = ?,"
                                                 +"cpf = ?,"
                                                 +"rg = ?,"
                                                 +"usuario = ?,"
                                                 +"senha = ?,"
                                                 +"TBLENDERECO_ID = (SELECT ID FROM TBLENDERECO WHERE logradouro = ?) "
                                                 +"WHERE id = ?";
        PreparedStatement pstm = null;
        Funcionario funcionario = new Funcionario();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2,objeto.getFone1());
            pstm.setString(3,objeto.getFone2());
            pstm.setString(4,objeto.getEmail());
            pstm.setString(5,objeto.getStatus());
            pstm.setString(6,objeto.getComplementoEndereco());
            pstm.setString(7, objeto.getCpf());
            pstm.setString(8,objeto.getRg());
            pstm.setString(9,objeto.getUsuario());
            pstm.setString(10, objeto.getSenha());
            pstm.setString(11,objeto.getEndereco().getLogradouro());
            pstm.setInt(12, objeto.getId());
            pstm.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }

    }

    @Override
    public void retrieve(Funcionario objeto) {

    }

    @Override
    public List<Funcionario> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT F.ID,F.NOME,F.FONE1,F.FONE2,"
                + "F.EMAIL,F.STATUS,F.CPF,F.RG,F.USUARIO,F.SENHA,"
                + "F.COMPLEMENTOENDERECO, E.LOGRADOURO,E.CEP "
                + "FROM TBLFUNCIONARIO F JOIN TBLENDERECO E "
                + "ON F.TBLENDERECO_ID = E.ID WHERE F.NOME = ?;";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Funcionario funcionario = new Funcionario();
        Endereco endereco = new Endereco();
        List<Funcionario> funcionarioList = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, "%" + funcionario.getNome() + "%");
            rst = pstm.executeQuery();

            while (rst.next()) {
                funcionario.setEndereco(endereco);
                funcionario.setId(rst.getInt("id"));
                funcionario.setNome(rst.getString("nome"));
                funcionario.setFone1(rst.getString("fone1"));
                funcionario.setFone2(rst.getString("fone2"));
                funcionario.setEmail(rst.getString("email"));
                funcionario.setStatus(rst.getString("status"));
                funcionario.setComplementoEndereco(rst.getString("complementoEndereco"));
                funcionario.setCpf(rst.getString("cpf"));
                funcionario.setRg(rst.getString("rg"));
                funcionario.setUsuario(rst.getString("usuario"));
                funcionario.setSenha(rst.getString("senha"));
                funcionario.getEndereco().setLogradouro(rst.getString("logradouro"));
                funcionario.getEndereco().setCep(rst.getString("cep"));
                funcionarioList.add(funcionario);
            }

        } catch (SQLException ex) {

            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return funcionarioList;
        }

    }

    @Override
    public Funcionario retrieve(int parPK) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT F.ID,F.NOME,F.FONE1,F.FONE2,"
                + "F.EMAIL,F.STATUS,F.CPF,F.RG,F.USUARIO,F.SENHA,"
                + "F.COMPLEMENTOENDERECO, E.LOGRADOURO,E.CEP "
                + "FROM TBLFUNCIONARIO F JOIN TBLENDERECO E "
                + "ON F.TBLENDERECO_ID = E.ID WHERE F.ID = ?;";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        Funcionario funcionario = new Funcionario();
        Endereco endereco = new Endereco();
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, parPK);
            rst = pstm.executeQuery();

            while(rst.next()){
               
                funcionario.setEndereco(endereco);
                funcionario.setId(rst.getInt("id"));
                funcionario.setNome(rst.getString("nome"));
                funcionario.setFone1(rst.getString("fone1"));
                funcionario.setFone2(rst.getString("fone2"));
                funcionario.setEmail(rst.getString("email"));
                funcionario.setStatus(rst.getString("status"));
                funcionario.setComplementoEndereco(rst.getString("complementoEndereco"));
                funcionario.setCpf(rst.getString("cpf"));
                funcionario.setRg(rst.getString("rg"));
                funcionario.setUsuario(rst.getString("usuario"));
                funcionario.setSenha(rst.getString("senha"));
                funcionario.getEndereco().setLogradouro(rst.getString("logradouro"));
                funcionario.getEndereco().setCep(rst.getString("cep"));
                
            }
            
            
        } catch (SQLException ex) {

            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return funcionario;

        }
    }

  @Override
    public List<Funcionario> retrieve(String parString) {
        Connection conexao = ConnectionFactory.getConnection();
       
        String sqlExecutar = "SELECT F.ID,F.NOME,F.FONE1,F.FONE2,"
                + "F.EMAIL,F.STATUS,F.CPF,F.RG,F.USUARIO,F.SENHA,"
                + "F.COMPLEMENTOENDERECO, E.LOGRADOURO,E.CEP "
                + "FROM TBLFUNCIONARIO F JOIN TBLENDERECO E "
                + "ON F.TBLENDERECO_ID = E.ID WHERE "+colunaFiltro+" LIKE ?;";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Funcionario> funcionarioList = new ArrayList<>();
        
        

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, "%" + parString + "%");
            rst = pstm.executeQuery();

            while (rst.next()) {
                Funcionario funcionario = new Funcionario();
                Endereco endereco = new Endereco();
                
               funcionario.setEndereco(endereco);
                funcionario.setId(rst.getInt("id"));
                funcionario.setNome(rst.getString("nome"));
                funcionario.setFone1(rst.getString("fone1"));
                funcionario.setFone2(rst.getString("fone2"));
                funcionario.setEmail(rst.getString("email"));
                funcionario.setStatus(rst.getString("status"));
                funcionario.setComplementoEndereco(rst.getString("complementoEndereco"));
                funcionario.setCpf(rst.getString("cpf"));
                funcionario.setRg(rst.getString("rg"));
                funcionario.setUsuario(rst.getString("usuario"));
                funcionario.setSenha(rst.getString("senha"));
                funcionario.getEndereco().setLogradouro(rst.getString("logradouro"));
                funcionario.getEndereco().setCep(rst.getString("cep"));
                funcionarioList.add(funcionario);
            }

        } catch (SQLException ex) {

            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);

            return funcionarioList;
        }
    }
   

}
