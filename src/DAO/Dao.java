
package DAO;

import java.util.List;


public interface Dao<T> {
 
    public boolean salvar(T t);
    public boolean excluir(T t);
    public boolean editar(T t);
    public List<T> lista();
    
}
