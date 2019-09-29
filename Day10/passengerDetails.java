
public class passengerDetails {
	String pnrNumber;
	String mobileNumber;
	String passengerName;
	int fare;
	int cgst=100;
	int sgst=100;
	public void bookTicket() {
		pnrNumber="1234959";
		mobileNumber="984738982";
		passengerName="Prem Balaji";
		fare=1200+cgst+sgst;
		System.out.println("Hi! "+passengerName+"! You have Booked the Ticket");
		System.out.println("Your Mobile Number"+mobileNumber+"is added.");
		System.out.println("Total Fare is "+fare);
	}
	public void cancelTicket() {
		pnrNumber="123493";
		mobileNumber="983273892";
		passengerName="Roshan Thomas";
		fare=10000+cgst+sgst;
		System.out.println("Hi! "+passengerName+"! You have Booked the Ticket");
		System.out.println("Your Mobile Number"+mobileNumber+"is added.");
		System.out.println("Total Fare is "+fare);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		passengerDetails details=new passengerDetails();
		details.bookTicket();
		System.out.println("----------------------------------------------------");
		details.cancelTicket();

	}

}
