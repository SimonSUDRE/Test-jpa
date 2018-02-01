package banque.entity2;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Simon SUDRE
 * class Adresse
 */
@Embeddable
public class Adresse {
	
	/** numero : {@link Integer} */
	@Column(name="NUMERO", nullable=false)
	private Integer numero;
	
	/** rue : {@link String} */
	@Column(name="RUE", length=255, nullable=false)
	private String rue;
	
	/** codePostal : {@link Integer} */
	@Column(name="CODEPOSTAL", nullable=false)
	private Integer codePostal;
	
	/** ville : {@link String} */
	@Column(name="VILLE", length=50, nullable=false)
	private String ville;
	
	/**
	 * GET numero of Adresse
	 * @return {@link Integer} numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * SET numero of Adresse
	 * @param nom {@link Integer}
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	/**
	 * GET rue of Adresse
	 * @return {@link String} rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * SET rue of Adresse
	 * @param rue {@link String}
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}
	
	/**
	 * GET codePostal of Adresse
	 * @return {@link Integer} codePostal
	 */
	public Integer getCodePostal() {
		return codePostal;
	}

	/**
	 * SET codePostal of Adresse
	 * @param codePostal {@link Integer}
	 */
	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}
	
	/**
	 * GET ville of Adresse
	 * @return {@link String} ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * SET ville of Adresse
	 * @param ville {@link String}
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Adresse : " + numero + "  " + rue + ", " + codePostal + " " + ville;
	}	
}
