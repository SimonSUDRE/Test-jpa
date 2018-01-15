package banque.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Simon SUDRE
 * class Compte
 */
@Entity
@Table(name="COMPTE")
public class Compte {

	/** id : {@link Integer} */
	@Id
	@GeneratedValue
	private Integer id;
	
	/** numero : {@link Integer} */
	@Column(name="NUMERO", length=20, nullable=false)
	private Integer numero;
	
	/** solde : {@link Double} */
	@Column(name="SOLDE", length=50, nullable=false)
	private Double solde;
	
	/** clients : {@link Set}<{@link Client}> */
	@ManyToMany(mappedBy="comptes")
	private Set<Client> clients;
	
	/** operations : {@link Set}<{@link Operation}> */
	@OneToMany(mappedBy="compte")
	private Set<Operation> operations;
	
	/**
	 * Constructeur par default
	 */
	public Compte() {
		
	}
	
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
	 * GET numero of Compte
	 * @return {@link Integer} numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/** 
	 * SET numero of Compte
	 * @param numero {@link Integer}
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	/**
	 * GET solde of Compte
	 * @return {@link Double} solde
	 */
	public Double getSolde() {
		return solde;
	}

	/** 
	 * SET solde of Compte
	 * @param solde {@link Double}
	 */
	public void setSolde(Double solde) {
		this.solde = solde;
	}

	/**
	 * GET clients of Compte
	 * @return {@link Set}<{@link Client}> clients
	 */
	public Set<Client> getClients() {
		return clients;
	}

	/**
	 * SET clients of Compte
	 * @param clients {@link Set}<{@link Client}>
	 */
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	/**
	 * GET operations of Compte
	 * @return operations {@link Set}<{@link Operation}>
	 */
	public Set<Operation> getOperations() {
		return operations;
	}

	/**
	 * SET operations of Compte
	 * @param operations {@link Set}<{@link Operation}>
	 */
	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}
}
