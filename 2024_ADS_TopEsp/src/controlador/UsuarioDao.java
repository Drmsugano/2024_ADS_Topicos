/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import modelo.Usuario;

public class UsuarioDao {

    public void inserir(Usuario Obj) throws Exception {
        String sql = "INSERT INTO usuario (nome,email,senha)" + "values(?,?,?)";
        Connection conexao = Conexao.getConexao();
        try ( PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, Obj.getNome());
            ps.setString(2, Obj.getEmail());
            ps.setString(3, Obj.getSenha());
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        }
    }
}
