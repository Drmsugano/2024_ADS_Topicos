/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import modelo.Usuario;
public class UsuarioDao {
     public int inserir (Usuario Obj) throws Exception {
        int retorno;
        String sql = "INSERT INTO usuario (nome,email,senha)" + "values(?,?,?)";
        Connection conexao = Conexao.getConexao();
        try (PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setString(1, Obj.getNome());
            ps.setString(2, Obj.getEmail());
            ps.setString(3, Obj.getSenha());
            retorno = ps.executeUpdate();
        }
        return retorno;
    }
}
