package entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Simon SUDRE
 * class Emprunt
 */
@Entity
@Table(name="EMPRUNT")
public class Emprunt {

	/** id : {@link Integer} */
	@Id
	private Integer id;
	
	/** dateDebut : {@link LocalDate} */
	@Column(name="DATE_DEBUT", nullable=false)
	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDate dateDebut;
	
	/** dateFin : {@link LocalDate} */
	@Column(name="DATE_FIN")
	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDate dateFin;
	
	/** delai : {@link Integer} */
	@Column(name="DELAI", length=10)
	private Integer delai;
	
	/** client : {@link Client} */
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	
	/** livres : {@link Set}<{@link Livre}> */
	@ManyToMany
	@JoinTable(name="COMPO",
		joinColumns= @JoinColumn(name="ID_EMP", referencedColumnName="ID"),
		inverseJoinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID")
	)
	private Set<Livre> livres;
	
	/**
	 * constructeur par default
	 */
	public Emprunt() {
		this.livres = new HashSet<>();
	}

	/**
	 * GET id of Emprunt
	 * @return {@link Integer} id
	 */
	public Integer getId() {
		return id;
	}

	/** 
	 * SET id of Emprunt
	 * @param id {@link Integer}
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * GET dateDebut of Emprunt
	 * @return dateDebut {@link LocalDate}
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	/**
	 * SET dateDebut of Emprunt
	 * @param dateDebut {@link LocalDate}
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * GET dateFin of Emprunt
	 * @return dateFin {@link LocalDate} 
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**
	 * SET dateFin of Emprunt
	 * @param dateFin {@link LocalDate}
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * GET delai of Emprunt
	 * @return {@link Integer} delai
	 */
	public Integer getDelai() {
		return delai;
	}

	/** 
	 * SET delai of Emprunt
	 * @param delai {@link Integer}
	 */
	public void setDelai(Integer delai) {
		this.delai = delai;
	}
	
	/**
	 * GET client of Emprunt
	 * @return {@link Client} client
	 */
	public Client getClient() {
		return client;
	}

	/** 
	 * SET client of Emprunt
	 * @param client {@link Client}
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * GET livres of Emprunt
	 * @return {@link Set}<{@link Livre}> livres
	 */
	public Set<Livre> getLivres() {
		return this.livres;
	}

	/**
	 * SET livres of Emprunt
	 * @param livres {@link Set}<{@link Livre}>
	 */
	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", delai=" + delai + "]";
	}
}
