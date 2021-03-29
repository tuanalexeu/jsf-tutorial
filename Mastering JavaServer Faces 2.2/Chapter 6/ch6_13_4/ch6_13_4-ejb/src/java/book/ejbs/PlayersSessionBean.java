package book.ejbs;

import java.util.HashSet;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Leonard
 */
@Stateless
@LocalBean
public class PlayersSessionBean {

    @PersistenceContext(unitName = "ch6_13_4-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public int countPlayersAction(String criteria) {

        if (criteria.equals("all")) {
            Query query = em.createNamedQuery("Players.countAll");
            return ((Long) query.getSingleResult()).intValue();
        }

        if (criteria.equals("<26")) {
            Query query = em.createQuery("SELECT COUNT(p) FROM Players p WHERE p.age < 26");
            return ((Long) query.getSingleResult()).intValue();
        }

        if (criteria.equals(">=26")) {
            Query query = em.createQuery("SELECT COUNT(p) FROM Players p WHERE p.age >= 26");
            return ((Long) query.getSingleResult()).intValue();
        }

        return 0;
    }

    public HashSet<Players> loadPlayersAction(int first, int max, String criteria) {

        if (criteria.equals("all")) {
            Query query = em.createNamedQuery("Players.findAll");
            query.setFirstResult(first);
            query.setMaxResults(max);
            return new HashSet(query.getResultList());
        }

        if (criteria.equals("<26")) {
            Query query = em.createQuery("SELECT p FROM Players p WHERE p.age < 26");
            query.setFirstResult(first);
            query.setMaxResults(max);
            return new HashSet(query.getResultList());
        }

        if (criteria.equals(">=26")) {
            Query query = em.createQuery("SELECT p FROM Players p WHERE p.age >= 26");
            query.setFirstResult(first);
            query.setMaxResults(max);
            return new HashSet(query.getResultList());
        }

        return null;
    }
}
