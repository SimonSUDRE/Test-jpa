package banque.entity2;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * @author Simon SUDRE
 * class Compte
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Compte {

	/** id : {@link Integer} */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	/** numero : {@link Integer} */
	@Column(name="NUMERO", nullable=false)
	private Integer numero;
	
	/** solde : {@link Double} */
	@Column(name="SOLDE", nullable=false)
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
		this.operations = new HashSet<>();
		this.clients = new HashSet<>();
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Compte [id=" + id + ", numero=" + numero + ", solde=" + solde + "]";
	}
}
