

import java.util.Comparator;

public class BilAmountComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2) {
		if (o1.getBillAmount() > o2.getBillAmount())
			return 0;
		else
			return -1;
	}

}
