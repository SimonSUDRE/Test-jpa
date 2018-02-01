package banque.entity2;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Simon SUDRE
 * class virement
 */
@Entity
public class Virement extends Operation {
	
	/** beneficiaire : {@link String} */
	@Column(name="BENEFICIAIRE", length=50, nullable=false)
	private String beneficiaire;

	/**
	 * GET beneficiaire of Virement
	 * @return {@link String} beneficiaire
	 */
	public String getBeneficiaire() {
		return beneficiaire;
	}

	/**
	 * SET beneficiaire of Virement
	 * @param beneficiaire {@link String}
	 */
	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	/* (non-Javadoc)
	 * @see banque.entity.Operation#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + " Virement [beneficiaire=" + beneficiaire + "]";
	}
}
