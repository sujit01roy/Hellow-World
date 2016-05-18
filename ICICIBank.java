package com.capgemini.mypack;

import java.util.LinkedList;

public class ICICIBank {

	LinkedList<Account> accounts=new LinkedList<Account>();
	
	
	public String createAccount(int accountNumber,int amount) throws MinimumFundLimitException{
		if(amount>500){
		Account account=new Account(accountNumber,amount);
		
		accounts.add(account);
		return "Acount successfully created";
		}
		
		throw new MinimumFundLimitException();
	}
	
	private Account searchAccount(int accountNumber) throws InvalidAccountNumberException{
		
		for(Account account:accounts)
		{
			if(account.getAccountNumber()==accountNumber)
			{
				return account;
			}
			
		}
		throw new InvalidAccountNumberException();
			
	}
	public int withdrawAmount(int accountNumber,int amount) throws InvalidAccountNumberException, InsufficientBalanceException{
		
Account account = searchAccount(accountNumber);
		
		if((account.getAmount()-amount)>=0)
		{
			account.setAmount(account.getAmount()-amount);
			return account.getAmount();
		}
		
		throw new InsufficientBalanceException();
	}
		
	public int depositAmount(int accountNumber,int amount) throws InvalidAccountNumberException{
		
		Account account=searchAccount(accountNumber);
		       account.setAmount(account.getAmount()+amount);
		      
		       return account.getAmount();
			
		}
		
	
	public int[] fundTransfer(int accountNumberSender,int accountNumberReceiver,int amount) throws InvalidAccountNumberException, InsufficientBalanceException{
		 
		 Account accountSender=searchAccount(accountNumberSender);
		 Account accountReceiver=searchAccount(accountNumberReceiver);
		 if(accountSender.getAmount()>amount){
			 
	    accountSender.setAmount(accountSender.getAmount()-amount);
	    accountReceiver.setAmount(accountReceiver.getAmount()+amount);
	        
	    
	    int[] balance=new int[2];
	    
	    balance[0]=accountSender.getAmount();
	    balance[1]=accountReceiver.getAmount();
	    return balance;
		 }
		
	       
	    throw new InsufficientBalanceException();
		 
		 
		
		
}
}