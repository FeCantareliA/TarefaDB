package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Patrimonio;

public class PatrimonioDAO {
    
    public void create(Patrimonio p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt=con.prepareStatement("INSERT INTO patrimonio(id,dtAquis,estado,observacao) VALUES (?,?,?,?,);");
            stmt.setString(1,String.valueOf(p.getId()) );
            stmt.setString(2, p.getDataAquisicao());
            stmt.setString(3, p.getEstado());
            stmt.setString(4, p.getObservacao());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar! "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
    }
}
