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

    @PersistenceContext(unitName = "ch6_10_2-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public int countPlayersAction() {
        Query query = em.createNamedQuery("Players.countAll");

        return ((Long)query.getSingleResult()).intValue();
    }

    public HashSet<Players> loadPlayersAction(int first, int max) {

        Query query = em.createNamedQuery("Players.findAll");
        query.setFirstResult(first);
        query.setMaxResults(max);

        return new HashSet(query.getResultList());
    }
}
