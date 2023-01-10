/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import controle.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.TurmaModel;

/**
 *
 * @author Beatr
 */
public class TurmaDao {
    public boolean insertTurma (TurmaModel turma) {
        String SQL = "insert into Turma (nome_turma, obs_turma, turno_turma) values(?,?,?)";
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = ConnectionFactory.connect();
            
            pst = conn.prepareStatement(SQL);
            pst.setString(1, turma.getNome_turma());
            pst.setString(2, turma.getObs_turma());
            pst.setString(3, turma.getTurno_turma());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro na conexão ao inserir: " + e.getMessage());
            return false;
        }
        return true;
    }
    
    public List<TurmaModel> getTurma () {
        String SQL = "select * from Turma";
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet tabela = null;
        List<TurmaModel> lista = new ArrayList<TurmaModel>();

        try {
            conn = ConnectionFactory.connect();

            pst = conn.prepareStatement(SQL);
            tabela = pst.executeQuery();

            while (tabela.next()) {
        
                TurmaModel obj = new TurmaModel();
                
                obj.setCod_turma(tabela.getInt(1));
                obj.setNome_turma(tabela.getString(2));
                obj.setObs_turma(tabela.getString(3));
                obj.setTurno_turma(tabela.getString(4));
                lista.add(obj);
            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão ao consultar: " + e.getMessage(), "ERRO", 0);
        }
        return lista;
    }
    
    public List<TurmaModel> getTurma (String turno) {
        String SQL = "select * from Turma where turno_turma like '"+turno+"%'";
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet tabela = null;
        List<TurmaModel> lista = new ArrayList<TurmaModel>();

        try {
            conn = ConnectionFactory.connect();

            pst = conn.prepareStatement(SQL);
            tabela = pst.executeQuery();

            while (tabela.next()) {
        
                TurmaModel obj = new TurmaModel();
                
                obj.setCod_turma(tabela.getInt(1));
                obj.setNome_turma(tabela.getString(2));
                obj.setObs_turma(tabela.getString(3));
                obj.setTurno_turma(tabela.getString(4));
                lista.add(obj);
            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão ao consultar: " + e.getMessage(), "ERRO", 0);
        }
        return lista;
    }
   
    public boolean deletarTurma(int codigo) {
        String SQL = "delete from Turma where cod_turma=?";
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = ConnectionFactory.connect();

            pst = conn.prepareStatement(SQL);
            pst.setInt(1, codigo);

            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e.getMessage(), "ERRO", 0);
            return false;
        }
        return true;
    }
    
    public boolean alterarTurma(TurmaModel turma) {
        String SQL = "update Turma set nome_turma=?,obs_turma=?,turno_turma=? where cod_turma=?";
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = ConnectionFactory.connect();
            pst = conn.prepareStatement(SQL);
             pst.setString(1, turma.getNome_turma());
             pst.setString(2, turma.getObs_turma());
             pst.setString(3, turma.getTurno_turma());
             pst.setInt(4, turma.getCod_turma());
       
            
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + e.getMessage(), "ERRO", 0);
            return false;
        }
        return true;
    }
}
