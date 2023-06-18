package services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.contato.ContatoVO;
import model.contato.dao.IContatoDAO;

public class ContatoService implements IContatoService {

    final private Logger logger = Logger.getLogger(ContatoService.class.getName());

    private final IContatoDAO dao;

    public ContatoService(IContatoDAO dao) {
        this.dao = dao;
    }

    @Override
    public void salvar(ContatoVO pContato) throws Exception {
        try {
            dao.salvar(pContato);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Falha ao salvar o contato.", e);
            throw e;
        }
    }

    @Override
    public ContatoVO atualizar(ContatoVO pContato) throws Exception {
        try {
            dao.atualizar(pContato);
            return pContato;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Falha ao atualizar o contato.", e);
            throw e;
        }
    }

    @Override
    public ContatoVO buscarPorEmail(String pEmail) throws Exception {
        try {
            return dao.buscarPorEmail(pEmail);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Falha ao buscar o contato por e-mail.", e);
            throw e;
        }
    }

    @Override
    public ContatoVO buscarPorId(Integer pId) throws Exception {
        try {
            return dao.buscarPorId(pId);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Falha ao buscar o contato por ID.", e);
            throw new Exception("Erro ao buscar contato por ID.", e);
        }
    }

    @Override
    public List<ContatoVO> buscarTodos() throws Exception {
        try {
            return dao.buscarTodos();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Falha ao buscar todos os contatos.", e);
            throw new Exception("Erro ao buscar todos os contatos.", e);
        }
    }

    @Override
    public void excluir(Integer pId) throws Exception {
        try {
            dao.excluir(pId);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Falha ao excluir o contato.", e);
            throw e;
        }
    }
}
