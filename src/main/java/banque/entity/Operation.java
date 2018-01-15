package banque.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Simon SUDRE
 * class Operation
 */
public class Operation {

	/** date : {@link LocalDate} */
	@Column(name="DATE", nullable=false)
	private LocalDateTime date;
	
	/** montant : {@link Double} */
	@Column(name="MONTANT", length=50, nullable=false)
	private Double montant;
	
	/** motif : {@link String} */
	@Column(name="MOTIF", length=255, nullable=false)
	private String motif;
	
	/** compte : {@link Compte}*/
	@ManyToOne
	@JoinColumn(name="COMPTE", nullable=false)
	private Compte compte;
	
	/**
	 * Constructeur par default
	 */
	public Operation() {
		
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
	public String getPrenom() {
		return motif;
	}

	/** 
	 * SET motif of Operation
	 * @param motif {@link String}
	 */
	public void setPrenom(String motif) {
		this.motif = motif;
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
}
