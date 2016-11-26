
package DAO;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;


public class DAOGenerico<T> implements Dao<T>{

    private Session sessao;
    private Transaction transacao;
    private Class classe;

    public DAOGenerico(Class classe) {
        this.classe = classe;
    }
    
    
    
    @Override
    public boolean salvar(T t) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(t);
            
            transacao.commit();
        } catch (Exception e) {
            return false;
        }finally{
            sessao.close();
        }
        return true;
    }

    @Override
    public boolean excluir(T t) {
    try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.delete(t);
            
            transacao.commit();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"falha ao remover");
        return false;
    } finally {
        sessao.close();
    }
    return true;
    }

    @Override
    public boolean editar(T t) {
    try {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.update(t);
        
        transacao.commit();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"falha ao editar");
        return false;
    } finally {
        sessao.close();
    }
    return true;
    }
    

    @Override
    public List<T> lista() {
    List<T> lista = null;
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            lista = sessao.createCriteria(Object.class).list();
            
        } catch (Exception e){
            JOptionPane.showConfirmDialog(null,"Falha ao lista");
            return null;
        }finally{
            sessao.close();
        }
        return lista;
    }
    
    public List<T> listar(String campo,Object value){
        List<T> lista = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            lista = sessao.createCriteria(classe).add(Restrictions.eq(campo,value)).list();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Falha ao pesquisar");
            return null;
        }finally {
            sessao.close();
        }
        return lista;
            
        }
    }
    
    
    
 
    

