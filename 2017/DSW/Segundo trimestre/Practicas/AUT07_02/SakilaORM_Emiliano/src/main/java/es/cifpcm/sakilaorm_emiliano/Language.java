package es.cifpcm.sakilaorm_emiliano;
// Generated Jan 16, 2018 10:12:04 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Language generated by hbm2java
 */
@Entity
@Table(name="language"
    ,catalog="sakila"
)
public class Language  implements java.io.Serializable {


     private Byte languageId;
     private String name;
     private Date lastUpdate;
     private Set<Film> filmsForLanguageId = new HashSet<Film>(0);
     private Set<Film> filmsForOriginalLanguageId = new HashSet<Film>(0);

    public Language() {
    }

	
    public Language(String name, Date lastUpdate) {
        this.name = name;
        this.lastUpdate = lastUpdate;
    }
    public Language(String name, Date lastUpdate, Set<Film> filmsForLanguageId, Set<Film> filmsForOriginalLanguageId) {
       this.name = name;
       this.lastUpdate = lastUpdate;
       this.filmsForLanguageId = filmsForLanguageId;
       this.filmsForOriginalLanguageId = filmsForOriginalLanguageId;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="language_id", unique=true, nullable=false)
    public Byte getLanguageId() {
        return this.languageId;
    }
    
    public void setLanguageId(Byte languageId) {
        this.languageId = languageId;
    }

    
    @Column(name="name", nullable=false, length=20)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_update", nullable=false, length=19)
    public Date getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="languageByLanguageId")
    public Set<Film> getFilmsForLanguageId() {
        return this.filmsForLanguageId;
    }
    
    public void setFilmsForLanguageId(Set<Film> filmsForLanguageId) {
        this.filmsForLanguageId = filmsForLanguageId;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="languageByOriginalLanguageId")
    public Set<Film> getFilmsForOriginalLanguageId() {
        return this.filmsForOriginalLanguageId;
    }
    
    public void setFilmsForOriginalLanguageId(Set<Film> filmsForOriginalLanguageId) {
        this.filmsForOriginalLanguageId = filmsForOriginalLanguageId;
    }




}


