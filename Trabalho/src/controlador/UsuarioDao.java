package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;

//todo DAO faz as transações de BD. Este DAO é o usuario. Logo, fará apenas transações com a tabela usuario;
public class UsuarioDao {

    public void inserir(Usuario u) throws Exception {
        String sql = "INSERT INTO usuario (nome,email,senha) values(?,?,?)";
        Connection conexao = Conexao.getConexao();
        try ( PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getSenha());
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        }

    }

    public List<Usuario> buscar(String nome) throws Exception {
        List<Usuario> lista = new ArrayList<>();

        String sql = "select * from usuario";
        sql += (!nome.equals("")) ? " where nome like ?" : "";

        Connection conexao = Conexao.getConexao();

        //try-with-resourses fecha o recurso automaticamente, dispensa o uso de .close()
        try ( PreparedStatement ps = conexao.prepareStatement(sql)) {
            if (!nome.equals("")) {
                ps.setString(1, "%" + nome + "%");
            }

            try ( java.sql.ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Usuario u = new Usuario();
                    u.setId(rs.getInt("id"));
                    u.setNome(rs.getString("nome"));
                    u.setEmail(rs.getString("email"));
                    u.setDataCadastro(rs.getString("datacadastro"));
                    lista.add(u);
                }
            }

        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM usuario WHERE id = ?";
        Connection conexao = Conexao.getConexao();
        try ( PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public Usuario getUsuario(int id) throws Exception {
        Connection conexao = Conexao.getConexao();
        String sql = "select * from usuario where id = ?";

        Usuario obj = null;

        try ( PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);

            try ( java.sql.ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    obj = new Usuario();
                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                    obj.setEmail(rs.getString("email"));
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return obj;
    }

    public boolean atualizar(Usuario u) throws Exception {
        String sql = "update usuario"
                + "      set nome   = ?,"
                + "          email  = ?"
                + "    where id     = ?";

        Connection conexao = Conexao.getConexao();
        try ( PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            ps.setInt(3, u.getId());

            return ps.executeUpdate() == 1;
        }
    }
    
    public boolean atualizarSenha(Usuario u) throws Exception {
        String sql = "update usuario"
                + "      set senha   = ?,"
                + "    where id     = ?";

        Connection conexao = Conexao.getConexao();
        try ( PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, u.getSenha());
            ps.setInt(2, u.getId());

            return ps.executeUpdate() == 1;
        }
    }
}
