package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private long transaction_id;
	
	

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "ACCOUNT_ID")
//	private Account account;
	
	@Column(length = 32)
	private String name;
	
	
	
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
	
//	public void setAccount(Account account) {
//		this.account = account;
//	}
//	
//	public Account getAccount() {
//		return account;
//	}

}
