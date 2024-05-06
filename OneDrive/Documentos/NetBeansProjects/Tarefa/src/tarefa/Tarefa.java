package tarefa;
import java.sql.*;
public class Tarefa {
    
    public static void main(String[] args) {
     FuncoesDB db = new FuncoesDB();
     Connection con  =db.conexaoDB("tarefa","postgres","root");
     //create
     db.createTable(con, "pessoa");
     //insert
     db.insertTB(con, "pessoa", "Jorge", "Rua Bobo, 1200");
     //read
     db.read(con, "pessoa");
     //update
     db.updateNome(con, "pesso", "Jorge", "Carlos");
     db.read(con, "pessoa");
     //delete
     db.deleteNome(con, "pessoa", "Carlos");
    }
    
}
