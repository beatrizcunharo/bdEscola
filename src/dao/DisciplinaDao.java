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
import model.DisciplinaModel;

/**
 *
 * @author Beatr
 */
public class DisciplinaDao {
    public boolean insertDisciplina (DisciplinaModel d) {
        String SQL = "insert into Disciplina (nome_disciplina, obs_disciplina) values(?,?)";
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = ConnectionFactory.connect();
            
            pst = conn.prepareStatement(SQL);
            pst.setString(1, d.getNome_disciplina());
            pst.setString(2, d.getObs_disciplina());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro na conexão ao inserir: " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean alterarDisciplina(DisciplinaModel d) {
        String SQL = "update Disciplina set nome_disciplina=?,obs_disciplina=? where cod_disciplina=?";
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = ConnectionFactory.connect();
            pst = conn.prepareStatement(SQL);
             pst.setString(1, d.getNome_disciplina());
             pst.setString(2, d.getObs_disciplina());
             pst.setInt(3, d.getCod_disciplina());
       
            
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + e.getMessage(), "ERRO", 0);
            return false;
        }
        return true;
    }

    public List<DisciplinaModel> getDisciplina () {
        String SQL = "select * from Disciplina";
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet tabela = null;
        List<DisciplinaModel> lista = new ArrayList<DisciplinaModel>();

        try {
            conn = ConnectionFactory.connect();

            pst = conn.prepareStatement(SQL);
            tabela = pst.executeQuery();

            while (tabela.next()) {
        
                DisciplinaModel obj = new DisciplinaModel();
                
                obj.setCod_disciplina(tabela.getInt(1));
                obj.setNome_disciplina(tabela.getString(2));
                obj.setObs_disciplina(tabela.getString(3));
                lista.add(obj);
            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão ao consultar: " + e.getMessage(), "ERRO", 0);
        }
        return lista;
    }

    public List<DisciplinaModel> getDisciplina (String nome) {
        String SQL = "select * from Disciplina where nome_disciplina like '"+nome+"%'";
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet tabela = null;
        List<DisciplinaModel> lista = new ArrayList<DisciplinaModel>();

        try {
            conn = ConnectionFactory.connect();

            pst = conn.prepareStatement(SQL);
            tabela = pst.executeQuery();

            while (tabela.next()) {
        
                DisciplinaModel obj = new DisciplinaModel();
                
                obj.setCod_disciplina(tabela.getInt(1));
                obj.setNome_disciplina(tabela.getString(2));
                obj.setObs_disciplina(tabela.getString(3));
                lista.add(obj);
            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão ao consultar: " + e.getMessage(), "ERRO", 0);
        }
        return lista;
    }

    public boolean deletarDisciplina(int codigo) {
        String SQL = "delete from Disciplina where cod_disciplina=?";
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
}
