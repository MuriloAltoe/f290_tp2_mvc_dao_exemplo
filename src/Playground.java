import model.contato.ContatoVO;
import model.contato.dao.ConexaoFactory;
import model.contato.dao.ContatoDAO;
import model.contato.dao.IContatoDAO;
import services.ContatoService;
import services.IContatoService;
import java.sql.Connection;
import java.util.List;

public class Playground {
    public static void main(String[] args) {
        Connection conexao;
        try {
            conexao = ConexaoFactory.getConexao();
        } catch (Exception e) {
            System.out.println("Erro ao obter conexão: " + e.getMessage());
            return;
        }

        IContatoDAO dao = new ContatoDAO(conexao);

        IContatoService service = new ContatoService(dao);

        try {
            ContatoVO contato1 = new ContatoVO();
            // Criar Contato
            contato1.setNome("Contato 1");
            contato1.setEmail("contato1@example.com");
            service.salvar(contato1);

            // Buscar Todos os Contatos
            //List<ContatoVO> contato = service.buscarTodos();
            //System.out.println(contato);

            // Buscar Contatos por Email
            //System.out.println(service.buscarPorEmail("contato1@example.com"));

            // Buscar Contatos por ID
            //System.out.println(service.buscarPorId(1));
            
            // Deletar Contato
            //contato1.setId(1);
            //service.excluir(contato1.getId());
            
            // Atualizar Contato
            //contato1.setId(1);
            //contato1.setNome("testeatualizado");
            //contato1.setEmail("testeatualizado@testeatualizado.com");
            //service.atualizar(contato1);
        } catch (Exception e) {
            System.out.println("Erro ao executar a operação: " + e.getMessage());
        } finally {
            try {
                conexao.close();
            } catch (Exception e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}
