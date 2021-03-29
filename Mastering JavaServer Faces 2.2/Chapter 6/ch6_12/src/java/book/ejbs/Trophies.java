package book.ejbs;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leonard
 */
@Entity
@Table(name = "TROPHIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trophies.findAll", query = "SELECT t FROM Trophies t"),
    @NamedQuery(name = "Trophies.findById", query = "SELECT t FROM Trophies t WHERE t.id = :id"),
    @NamedQuery(name = "Trophies.findByRanking", query = "SELECT t FROM Trophies t WHERE t.ranking = :ranking"),
    @NamedQuery(name = "Trophies.findByTrophy", query = "SELECT t FROM Trophies t WHERE t.trophy = :trophy")})
public class Trophies implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "RANKING")
    private Integer ranking;
    @Size(max = 100)
    @Column(name = "TROPHY")
    private String trophy;

    public Trophies() {
    }

    public Trophies(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public String getTrophy() {
        return trophy;
    }

    public void setTrophy(String trophy) {
        this.trophy = trophy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trophies)) {
            return false;
        }
        Trophies other = (Trophies) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "book.ejbs.Trophies[ id=" + id + " ]";
    }
    
}
