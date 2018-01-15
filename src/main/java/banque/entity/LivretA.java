package banque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Simon SUDRE
 * class Livret A
 */
@Entity
@Table(name="LIVRETA")
public class LivretA {

	/** taux : {@link Double} */
	@Column(name="TAUX", length=4, nullable=false)
	private Double taux;
	
	/**
	 * Constructeur par default
	 */
	public LivretA() {
		
	}

	/**
	 * GET taux of LivretA
	 * @return taux {@link Double}
	 */
	public Double getTaux() {
		return taux;
	}

	/**
	 * SET taux of LivretA
	 * @param taux {@link Double}
	 */
	public void setTaux(Double taux) {
		this.taux = taux;
	}
}