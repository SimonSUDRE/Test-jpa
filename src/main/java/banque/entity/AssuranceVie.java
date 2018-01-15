package banque.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Simon SUDRE
 * class Assurance vie
 */
@Entity
@Table(name="ASSURANCEVIE")
public class AssuranceVie extends Compte {

	/** dateFin : {@link LocalDate} */
	@Column(name="DATE_FIN")
	private LocalDate dateFin;
	
	/**	taux : {@link Double} */
	@Column(name="TAUX", length=4, nullable=false)
	private Double taux;
	
	/**
	 * Constructeur par default
	 */
	public AssuranceVie() {
		
	}

	/**
	 * GET dateFin of AssuranceVie
	 * @return {@link LocalDate} dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**
	 * SET datFin of AssuranceVie
	 * @param dateFin {@link LocalDate}
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * GET taux of AssuranceVie
	 * @return taux {@link Double}
	 */
	public Double getTaux() {
		return taux;
	}

	/**
	 * SET taux of AssuranceVie
	 * @param taux {@link Double}
	 */
	public void setTaux(Double taux) {
		this.taux = taux;
	}
}
