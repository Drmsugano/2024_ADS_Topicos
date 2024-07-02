package controlador;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe de conexao usando o padrão de projetos Singleton O padrão Singleton
 * permite instanciar apenas uma única classe de Conexao no projeto inteiro.
 * Nunca haverá 2 conexões abertas no projeto
 *
 * @author Marcelo Rafael Borth
 */
public class Conexao {

    private static Connection conexao;

    /**
     * Construtor privado
     */
    private Conexao() throws Exception {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://127.0.0.1/ifpr";
            String usuario = "root";
            String senha = "";

            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            conexao.setAutoCommit(true);
        } catch (Exception e) {
            throw e;
        }
    }

    public static Connection getConexao() throws Exception {
        if (conexao == null) {
            new Conexao();
        }
        return conexao;
    }
}
