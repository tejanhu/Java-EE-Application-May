package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(length = 32)
	private String firstName;
	@Column(length = 32)
	private String lastName;
	@Column(length = 4)
	private String accountNumber;
	@OneToMany(
	        mappedBy = "account", 
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true
	    )
	private List<Transaction> transactions;
	
	public Account() {
		
	}
	
	public Account(String firstName, String lastName, String accountNumber) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
	}
	
	public void setID(long id) {
		this.id = id;
	}
	
	public long getID() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String toString() {
		return "Account ID: "+ getID() + "\n"
				+ "First name: " + getFirstName() + "\n"
				+ "Last name: " + getLastName() + "\n"
				+ "Account number: " + getAccountNumber();
	}
	

	
	
	
	public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
 
    public void removeTransaction(Transaction transaction) {
        transactions.remove(transaction);
    }
	

}
