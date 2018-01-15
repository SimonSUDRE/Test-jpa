package entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Simon SUDRE
 * class Livre
 */
@Entity
@Table(name="LIVRE")
public class Livre {

	/** id : {@link Integer} */
	@Id
	private Integer id;
	
	/** titre : {@link String} */
	@Column(name="TITRE", length=255, nullable=false)
	private String titre;
	
	/** auteur : {@link String} */
	@Column(name="AUTEUR", length=50, nullable=false)
	private String auteur;
	
	/** emprunts : {@link Set}<{@link Emprunt}> */
	@ManyToMany(mappedBy="livres")
	private Set<Emprunt> empruntsLivre;
	
	/**
	 * constructeur par default
	 */
	public Livre() {
		this.empruntsLivre = new HashSet<>();
	}

	/**
	 * GET id of Livre
	 * @return {@link Integer} id
	 */
	public Integer getId() {
		return id;
	}

	/** 
	 * SET id of Livre
	 * @param id {@link Integer}
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * GET titre of Livre
	 * @return {@link String} titre
	 */
	public String getTitre() {
		return titre;
	}

	/** 
	 * SET titre of Livre
	 * @param titre {@link String}
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	/**
	 * GET auteur of Livre
	 * @return {@link String} auteur
	 */
	public String getAuteur() {
		return auteur;
	}

	/** 
	 * SET auteur of Livre
	 * @param auteur {@link String}
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	/**
	 * GET empruntsLivre of Livre
	 * @return {@link Set}<{@link Emprunt}> empruntsLivre
	 */
	public Set<Emprunt> getEmprunt() {
		return this.empruntsLivre;
	}

	/**
	 * SET empruntsLivre of livre
	 * @param empruntsLivre {@link Set}<{@link Emprunt}>
	 */
	public void setEmprunt(Set<Emprunt> empruntsLivre) {
		this.empruntsLivre = empruntsLivre;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + "]";
	}
}
