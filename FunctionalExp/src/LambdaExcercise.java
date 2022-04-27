import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class LambdaExcercise {
	
	public static List<String> countries = Arrays.asList("Inida","USA","Uk","xxxxxxxxxx");
	public static final Map<String, String> countryCapitals;
	static {
		countryCapitals= new HashMap<>();
		countryCapitals.put("india", "delhi");
		countryCapitals.put("USA", "washinghton");
		countryCapitals.put("Uk", "london");
		countryCapitals.put("xxxxxxxxx","yyyyyyyyyyyy");
		}
	
	static void displayCountries() {
		System.out.println("countries: ");
		 countries.forEach(new Consumer<String>() {
	            @Override
	            public void accept(String k) {
	                System.out.println("country: " + k );
	            }
	        });
	}
	
	static void displayCountryCapitals() {
		System.out.println("diaplying key as country and value as capital : ");
		 countryCapitals.forEach(new BiConsumer < String, String > () {
	            @Override
	            public void accept(String k, String v) {
	                System.out.println("Key: " + k + " Value: " + v);
	            }
	        });
	}
	static void sortCountriesByName(){
		System.out.println("Sorting in reverse alphabetical order: ");
		List < String > sortedList= countries.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	     System.out.println(sortedList);
		
	}
	
	static void sortCountriesBylength() {
		 System.out.println("sorting on length of country : ");
		 List<String> sortedList2= countries.stream().sorted(Comparator.comparingInt(String::length).reversed()).collect(Collectors.toList());
		 System.out.println(sortedList2);
	}
	
	static void removeCountry() {
		System.out.println("Removing countries whose name isgreater than 6");
		List<String> con=countries.stream().filter(e->e.length()<=6).collect(Collectors.toList());
		System.out.println(con);
		
		}
	
}

