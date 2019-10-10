import java.util.HashMap;
import java.util.Map;

public class MapDemo {
	public static void main(String[] args) {
		Map<String, Integer> scores=new HashMap<String, Integer>();
		scores.put("PremBalaji", 100);
		scores.put("Roshan", 80);
		scores.put("Jishnu",45);
		System.out.println(scores);
	}
}
