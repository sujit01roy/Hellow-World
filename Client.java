package com.capgemini.mypack;

public class Client {

	public static void main(String[] args) {
    ICICIBank bank=new ICICIBank();
		
		try {
			System.out.println(bank.createAccount(101, 3000));
			System.out.println(bank.createAccount(102,1000 ));
		} catch (MinimumFundLimitException e) {
			
			System.out.println("Minimum balance should be 500");
		}
		
		
		try
		{
			System.out.println("Remaining Balance after withdrawl = "+bank.withdrawAmount(101,500));
			System.out.println("New amount after deposit="+bank.depositAmount(102,5000));
			
		}catch(InvalidAccountNumberException ian)
		{
			System.out.println("Invalid account number");
		}catch(InsufficientBalanceException ibe)
		{
			System.out.println("insufficient balance");
		}
           
           
			int[] balance;
			try {
				balance = bank.fundTransfer(101,102, 500);
				System.out.println("sender balance="+balance[0]);
				System.out.println("receiver balance="+balance[1]);
			} catch (InvalidAccountNumberException | InsufficientBalanceException e) {
				System.out.println("Invalid account number");
			}
		
			
        
	}

}
