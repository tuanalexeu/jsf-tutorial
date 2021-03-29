package book.ejbs;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leonard
 */
@Entity
@Table(name = "PLAYERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Players.findAll", query = "SELECT p FROM Players p"),
    @NamedQuery(name = "Players.findByRanking", query = "SELECT p FROM Players p WHERE p.ranking = :ranking"),
    @NamedQuery(name = "Players.findByPlayer", query = "SELECT p FROM Players p WHERE p.player = :player"),
    @NamedQuery(name = "Players.findByAge", query = "SELECT p FROM Players p WHERE p.age = :age"),
    @NamedQuery(name = "Players.findByBirthplace", query = "SELECT p FROM Players p WHERE p.birthplace = :birthplace"),
    @NamedQuery(name = "Players.findByResidence", query = "SELECT p FROM Players p WHERE p.residence = :residence"),
    @NamedQuery(name = "Players.findByHeight", query = "SELECT p FROM Players p WHERE p.height = :height"),
    @NamedQuery(name = "Players.findByWeight", query = "SELECT p FROM Players p WHERE p.weight = :weight"),
    @NamedQuery(name = "Players.findByCoach", query = "SELECT p FROM Players p WHERE p.coach = :coach"),
    @NamedQuery(name = "Players.findByBorn", query = "SELECT p FROM Players p WHERE p.born = :born")})
public class Players implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RANKING")
    private Integer ranking;
    @Size(max = 100)
    @Column(name = "PLAYER")
    private String player;
    @Column(name = "AGE")
    private Integer age;
    @Size(max = 100)
    @Column(name = "BIRTHPLACE")
    private String birthplace;
    @Size(max = 100)
    @Column(name = "RESIDENCE")
    private String residence;
    @Column(name = "HEIGHT")
    private Integer height;
    @Column(name = "WEIGHT")
    private Integer weight;
    @Size(max = 100)
    @Column(name = "COACH")
    private String coach;
    @Column(name = "BORN")
    @Temporal(TemporalType.DATE)
    private Date born;

    public Players() {
    }

    public Players(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ranking != null ? ranking.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Players)) {
            return false;
        }
        Players other = (Players) object;
        if ((this.ranking == null && other.ranking != null) || (this.ranking != null && !this.ranking.equals(other.ranking))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "book.ejbs.Players[ ranking=" + ranking + " ]";
    }
    
}
