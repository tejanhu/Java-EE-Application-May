package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Transaction {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private long transaction_id;
	
	@Column(name = "ACCOUNT_ID")
	private long account_id;
	
	@Column(length = 32)
	@NotNull
	@NotEmpty
	private String name;
	
	private Transaction() {
	
	}
	
	private Transaction(long transaction_id, String name) {
		this.transaction_id = transaction_id;
		this.name = name;
	}
	
	public void setId(long transaction_id) {
		this.transaction_id = transaction_id;
	}
	
	public long getId() {
		return transaction_id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	

	public long getAccount() {
		return account_id;
	}

}
