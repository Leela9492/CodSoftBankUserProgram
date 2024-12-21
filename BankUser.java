import java.util.Scanner;

class ATM{
	private int accno;
	private int balance;
	private String name;
	public ATM(int accno,String name,int balance){
		this.accno=accno;
		this.name=name;
		this.balance=balance;
	}
	public void deposit(int amnt){
		this.balance+=amnt;
	}
	public void withdraw(int amnt){
		if(amnt>this.balance){
			System.out.println("insufficient funds in your account");
		}else{
			this.balance-=amnt;
			System.out.println("Amount withdrawn successfully...!!!");
		}
	}
	public void checkBalance(){
		System.out.println("available balance: "+this.balance);
	}
	public String getDetails(){
		return "accno:\t"+this.accno+"\nacc holder name:\t"+this.name;
	}
}

public class BankUser{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		ATM obj=null;
		while(true){
			System.out.println("1.create account\t2.withdraw\t3.deposit\t4.check balance\t5.exit");
			System.out.print("Enter your choice:");
			int ch=sc.nextInt();
			switch(ch){
				case 1:if(obj==null){
							System.out.print("Enter your name:");
						   String name=sc.nextLine();sc.nextLine();
						   System.out.print("Enter deposit amount:");
						   int amount=sc.nextInt();
						   obj=new ATM(5006,name,amount);
						   System.out.println("Account created succesfully");
						}else{
							System.out.println("Account already exists...!!!");
						}
					   break;
				case 2:if(obj!=null){
							System.out.print("Enter withdraw amount: ");
					   		obj.withdraw(sc.nextInt());
					   }else{
					   	System.out.println("first you need to create account...!!!!");
					   }
					   break;
				case 4:if(obj!=null){
							obj.checkBalance();
					    }else{
					    	System.out.println("Account not exists");
					    }
						break;
				case 3:if(obj!=null){
							System.out.print("Enter amnt to deposit:");
							obj.deposit(sc.nextInt());
							System.out.println("Amount deposited successfully...!!!");
							obj.checkBalance();
					    }else{
					    	System.out.println("Account not exists");
					    }
						break;
				case 5:System.exit(0);
				default:System.out.println("Select valid option from the menu....!!!!");
			}
		}

	}
}