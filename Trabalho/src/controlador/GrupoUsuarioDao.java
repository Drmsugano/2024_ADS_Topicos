/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.GrupoUsuario;

public class GrupoUsuarioDao {

    public void inserir(GrupoUsuario obj) throws Exception {
        String sql = "INSERT INTO usuario_grupo (nome) VALUES (?)";
        Connection conn = Conexao.getConexao();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, obj.getNomeGrupo());
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        }
    }

    public List<GrupoUsuario> buscar(String nome) throws Exception {
        List<GrupoUsuario> lista = new ArrayList<>();

        String sql = "select * from usuario_grupo";
        sql += (!nome.equals("")) ? " where nome like ?" : "";

        Connection conexao = Conexao.getConexao();

        //try-with-resourses fecha o recurso automaticamente, dispensa o uso de .close()
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            if (!nome.equals("")) {
                ps.setString(1, "%" + nome + "%");
            }

            try (java.sql.ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    GrupoUsuario u = new GrupoUsuario();
                    u.setId(rs.getInt("id"));
                    u.setNomeGrupo(rs.getString("nome"));
                    lista.add(u);
                }
            }

        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM usuario_grupo WHERE id = ?";
        Connection conexao = Conexao.getConexao();
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public GrupoUsuario getGrupoUsuario(int id) throws Exception {
        Connection conexao = Conexao.getConexao();
        String sql = "select * from usuario_grupo where id = ?";

        GrupoUsuario obj = null;

        try ( PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);

            try ( java.sql.ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    obj = new GrupoUsuario();
                    obj.setId(rs.getInt("id"));
                    obj.setNomeGrupo(rs.getString("nome"));
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return obj;
    }

    public boolean atualizar(GrupoUsuario u) throws Exception {
        String sql = "update usuario_grupo"
                + "      set nome   = ?"
                + "    where id     = ?";

        Connection conexao = Conexao.getConexao();
        try ( PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, u.getNomeGrupo());
            ps.setInt(2, u.getId());

            return ps.executeUpdate() == 1;
        }
    }
}
