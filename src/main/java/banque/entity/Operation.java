package banque.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Simon SUDRE
 * class Operation
 */
@Entity
@Table(name="OPARATION")
public class Operation {

	/** id : {@link Integer} */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	/** date : {@link LocalDate} */
	@Column(name="DATE", nullable=false)
	private LocalDateTime date;
	
	/** montant : {@link Double} */
	@Column(name="MONTANT", nullable=false)
	private Double montant;
	
	/** motif : {@link String} */
	@Column(name="MOTIF", length=255, nullable=false)
	private String motif;
	
	/** compte : {@link Compte}*/
	@ManyToOne
	@JoinColumn(name="ID_COMPTE")
	private Compte compte;
	
	/**
	 * GET id of Client
	 * @return {@link Integer} id
	 */
	public Integer getId() {
		return id;
	}

	/** 
	 * SET id of Client
	 * @param id {@link Integer}
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * GET date of Operation
	 * @return {@link LocalDate} date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * SET date of Operation
	 * @param date {@link LocalDate}
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	/**
	 * GET montant of Operation
	 * @return {@link Double} montant
	 */
	public Double getMontant() {
		return montant;
	}

	/** 
	 * SET montant of Operation
	 * @param montant {@link Double}
	 */
	public void setMontant(Double montant) {
		this.montant = montant;
	}

	/**
	 * GET motif of Operation
	 * @return {@link String} motif
	 */
	public String getMotif() {
		return motif;
	}

	/**
	 * SET motif of Operation
	 * @param motif {@link String}
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

	/**
	 * GET compte of Operation
	 * @return compte {@link Compte}
	 */
	public Compte getCompte() {
		return compte;
	}

	/**
	 * SET compte of Operation
	 * @param compte {@link Compte}
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Operation [id=" + id + ", date=" + date + ", montant=" + montant + ", motif=" + motif + "]";
	}
}
