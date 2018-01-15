package banque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Simon SUDRE
 * class virement
 */
@Entity
@Table(name="VIREMENT")
public class Virement extends Operation{
	
	/** beneficiaire : {@link String} */
	@Column(name="BENEFICIAIRE", length=50, nullable=false)
	private String beneficiaire;
	
	/**
	 * Constructeur par default
	 */
	public Virement() {
		
	}

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
}
