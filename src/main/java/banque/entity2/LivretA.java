package banque.entity2;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Simon SUDRE
 * class Livret A
 */
@Entity
public class LivretA extends Compte {

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

	/* (non-Javadoc)
	 * @see banque.entity.Compte#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + " LivretA [taux=" + taux + "]";
	}
}