/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.GrupoUsuario;
public class GrupoUsuarioDao {
    public void inserir (GrupoUsuario obj) throws Exception{
        String sql = "INSERT INTO usuario_grupo (nome) VALUES (nome)";
        Connection conn = Conexao.getConexao();
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, obj.getNomeGrupo());
        }catch(Exception ex){
            throw ex;
        }
    }
}
