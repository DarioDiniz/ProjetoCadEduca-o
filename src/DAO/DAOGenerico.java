package DAO;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;


public class DAOGenerico<T> implements Dao<T> {

    private Session sessao;
    private Transaction transacao;
    private Class classe;

    public DAOGenerico(Class classe) {
        this.classe = classe;
    }

    SessionFactory getSession() {
        return new Configuration().configure().buildSessionFactory();
    }

    @Override
    public boolean salvar(T t) {
        Session sessao = null;
        try {
            sessao = getSession().openSession();
            sessao.beginTransaction();
            sessao.save(t);

            sessao.getTransaction().commit();
        } catch (Exception e) {
            return false;
        } finally {
            sessao.close();
        }
        return true;
    }

    @Override
    public boolean excluir(T t) {
        Session sessao = null;
        try {
            sessao = getSession().openSession();
            sessao.beginTransaction();
            sessao.delete(t);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!", "Erro!", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            sessao.close();
        }
        return true;
    }

    @Override
    public boolean editar(T t) {
        Session sessao = null;

		try {
			sessao = getSession().openSession();
			sessao.beginTransaction();

			sessao.update(t);
			sessao.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			sessao.close();
		}
		return true;
    }

    @Override
    public List<T> lista() {
       List<T> lista = null;
		Session sessao = null;
		try {
			sessao = getSession().openSession();
			lista = sessao.createCriteria(classe).list();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
		return lista;
    }

    public List<T> listar(String campo, Object value) {
     List<T> lista = null;
		Session sessao = null;
		try {
			sessao = getSession().openSession();
			lista = sessao.createCriteria(classe).add(Restrictions.eq(campo, value)).list();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		} finally {
			sessao.close();
		}
		return lista;

    }
}
