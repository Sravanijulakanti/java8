package collectorsexp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamCollectorsExercise {

	  
   static List<Player> p= Arrays.asList(new Player("Navya", 7, 300, 70, new Country(123, "india"))
				   ,new Player("kavya", 101, 400, 75, new Country(124, "Usa")),new Player("sravya", 6, 200, 60, new Country(123, "india"))
				   ,new Player("bhavya", 5, 200, 80, new Country(125, "Uk")),new Player("Nitya", 105, 250, 90, new Country(123, "india"))
				   ,new Player("Naveen", 200, 300, 97, new Country(124, "Usa")),new Player("jaashu", 8, 420, 58, new Country(125, "Uk")));
		
		   
   static void getPlayersByCountry(String country) {
			System.out.println("Players with country:  ");
		   Map<Country, String> sorted= p.stream().filter(e->e.getCountry().getCountryName().equals(country)).collect(Collectors.toMap(Player::getCountry, Player::getPlayerName));
		   sorted.forEach((k,v)->System.out.println("country: " + k.getCountryName() + "  player Name :" + v)); 
		   System.out.println("----------------------------");
		}
	static void getPlayerNamesByCountry(String country) {
			System.out.println("Players with total matches>100 in a given country: ");
			Map<Country, String> sorted=p.stream().filter(e->e.getCountry().getCountryName().equals(country) && e.getMatchesPlayed()>100).collect(Collectors.toMap(Player::getCountry,Player::getPlayerName ));
			 sorted.forEach((k,v)->System.out.println("country: " + k.getCountryName() + "  player Name :" + v));
			 System.out.println("-----------------------------");
		}
	static void getTotalPlayersByCountry() {
			
			  Map<Object, Long> counting = p.stream().collect(Collectors.groupingBy(p->p.getCountry().getCountryName(), Collectors.counting()));
			  counting.forEach((k,v)->System.out.println("country: " + k + "  total players:" +v));
				 System.out.println("-----------------------------");
				

			/*Map<Country, String> sorted=p.stream().collect(Collectors.toMap(Player::getCountry, Player::getPlayerName));*/
			//sorted.forEach((k,v)->System.out.println("country: " + k.getCountryName() + "  player Name :" + v));
			 System.out.println("-----------------------------");
			
		}
	static void getTotalRunsByCountry(){
		Map<Object, Integer> sorted=p.stream().collect(Collectors.groupingBy(p->p.getCountry().getCountryName(), Collectors.summingInt(Player::getRuns)));
		 sorted.forEach((k,v)->System.out.println("country: " + k + "  total runs:" +v));
		 System.out.println("-----------------------------");
		
		
	}
	
	static void getMaxScoreByCountry(String country){
		System.out.println("max score by country: ");
		int sorted=p.stream().filter(e->e.getCountry().getCountryName().equals(country)).max((o1,o2)->o1.getRuns()-o2.getRuns()).get().getRuns();
		System.out.println(sorted);
		
	}
	static void getPlayerNamesStringByCountry(){
		 Map<Object, Map<String, List<Player>>> counting = p.stream().collect(Collectors.groupingBy(p->p.getCountry().getCountryName(), Collectors.groupingBy(Player::getPlayerName)));
		  counting.forEach((k,v)->System.out.println("country: " + k + "  players:" +v));
			 System.out.println("-----------------------------");
		
		
	}
	
	
			
	}
