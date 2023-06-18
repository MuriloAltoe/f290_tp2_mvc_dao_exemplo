import java.sql.Connection;
import java.util.List;

import model.contato.ContatoVO;
import model.contato.dao.ConexaoFactory;
import model.contato.dao.ContatoDAO;

public class App {

    public static void main(String[] args) {

        try {
            Connection connection = ConexaoFactory.getConexao();
            ContatoDAO dao = new ContatoDAO(connection);
            ContatoVO ctt = new ContatoVO("Murilo Augusto", "maal@gmail.com");
            // dao.salvar(c1);
            List<ContatoVO> contatos = dao.buscarTodos();
            System.out.println(contatos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
