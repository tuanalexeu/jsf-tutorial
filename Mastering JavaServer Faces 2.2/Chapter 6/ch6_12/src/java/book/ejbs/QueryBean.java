package book.ejbs;

import java.util.HashSet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Leonard
 */
@Stateless
public class QueryBean {

    @PersistenceContext(unitName = "ch6_12PU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public HashSet<Object> populateData(String selectedTable) {

        HashSet<Object> data = new HashSet<>();

        if (selectedTable != null) {
            Query query = em.createNamedQuery(selectedTable + ".findAll");
            data = new HashSet(query.getResultList());
        }

        return data;
    }
}
