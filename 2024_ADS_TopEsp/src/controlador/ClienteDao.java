package controlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import modelo.Cliente;
/**
 *
 * @author Marcelo Rafael Borth
 * DAO - Data Access Object
 */
public class ClienteDao {
    public int inserir (Cliente Obj) throws Exception {
        int retorno;
        String sql = "INSERT INTO CLIENTE (nome,cpfcnpj,tipo)" + "values(?,?,?)";
        Connection conexao = Conexao.getConexao();
        try (PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setString(1, Obj.getNome());
            ps.setString(2, Obj.getCpfcnpj());
            ps.setString(3, Obj.getTipo());
            retorno = ps.executeUpdate();
        }
        return retorno;
    }
}