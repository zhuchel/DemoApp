
package org.jboss.as.quickstarts.greeter.domain;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
        CREATE PROCEDURE REFRESH_REPORT_VIEW IS
        PRAGMA AUTONOMOUS_TRANSACTION;
        BEGIN
        DBMS_MVIEW.REFRESH('MV_MIFIR_REPORT1', method => 'cf', atomic_refresh => FALSE);
        END;

@Stateless
@LocalBean
public class SLEJBUserDao implements UserDao {

    //@Inject
    //private EntityManager entityManager;

    @PersistenceContext(unitName = "hui")
    private EntityManager entityManager;


    //https://stackoverflow.com/questions/828871/why-does-dbms-mview-refresh-have-an-implicit-commit
    @Override
    public User getForUsername(String username) {
        try {
            Query query = entityManager.createQuery("select u from User u where u.username = :username");
            query.setParameter("username", username);
            System.out.println("-------------- brfore refresh");
            String st = "{call DBMS_MVIEW.REFRESH('MV_MIFIR_REPORT1', method => 'cf', atomic_refresh => FALSE)}";
            entityManager.createNativeQuery(st).executeUpdate();
            System.out.println("-------------- after refresh");
            entityManager.createNativeQuery("{call REFRESH_REPORT_VIEW()}").executeUpdate();
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

}
