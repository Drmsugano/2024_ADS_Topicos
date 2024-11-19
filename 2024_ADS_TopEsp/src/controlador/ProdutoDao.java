/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import modelo.Produto;

/**
 *
 * @author Douglas Sugano
 */
public class ProdutoDao {

    public void inserir(Produto obj) throws Exception {
        String sql = "INSERT INTO produto(nome,unidadeDeMedida) VALUES (?,?)";
        Connection conn = Conexao.getConexao();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, obj.getNomeProduto());
            ps.setString(2, obj.getUnidadeDeMedida());
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        }
    }

    public List<Produto> buscar(String nome) throws Exception {
        List<Produto> lista = new ArrayList<>();

        String sql = "select * from produto";
        sql += (!nome.equals("")) ? " where nome like ?" : "";

        Connection conexao = Conexao.getConexao();

        //try-with-resourses fecha o recurso automaticamente, dispensa o uso de .close()
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            if (!nome.equals("")) {
                ps.setString(1, "%" + nome + "%");
            }

            try (java.sql.ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Produto p = new Produto();
                    p.setId(rs.getInt("id"));
                    p.setNomeProduto(rs.getString("nome"));
                    p.setUnidadeDeMedida(rs.getString("unidadeDeMedida"));
                    p.setDataCadastro(rs.getString("datacadastro"));
                    lista.add(p);
                }
            }

        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public void excluir(Integer id) throws Exception {
        String sql = "DELETE FROM produto WHERE id = ?";
        Connection conexao = Conexao.getConexao();
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
        public Produto getProduto(int id) throws Exception {
        Connection conexao = Conexao.getConexao();
        String sql = "select * from produto where id = ?";

        Produto obj = null;

        try ( PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);

            try ( java.sql.ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    obj = new Produto();
                    obj.setId(rs.getInt("id"));
                    obj.setNomeProduto(rs.getString("nome"));
                    obj.setUnidadeDeMedida(rs.getString("unidadeDeMedida"));
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return obj;
    }

    public boolean atualizar(Produto p) throws Exception {
        String sql = "update produto"
                + "      set nome   = ?,"
                + "          unidadeDeMedida  = ?"
                + "    where id     = ?";

        Connection conexao = Conexao.getConexao();
        try ( PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, p.getNomeProduto());
            ps.setString(2, p.getUnidadeDeMedida());
            ps.setInt(3, p.getId());

            return ps.executeUpdate() == 1;
        }
    }

}
