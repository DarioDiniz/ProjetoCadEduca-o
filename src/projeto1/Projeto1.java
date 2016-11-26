
package projeto1;

import util.HibernateUtil;


public class Projeto1 {


    public static void main(String[] args) {
        HibernateUtil.getSessionFactory().openSession();
    }
    
}
