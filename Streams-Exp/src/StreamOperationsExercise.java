import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperationsExercise {
	
		static List<Player> p= Arrays.asList(new Player("Navya", 210, 5000, 120, new Country(123, "india")),new Player(
				"kavya", 201, 6000, 110, new Country(124, "Usa")),new Player("sravya", 6, 5500, 160, new Country(123, "india"))
				,new Player("bhavya", 5, 4000, 180, new Country(125, "Uk")),new Player("Nitya", 6, 6500, 90, new Country(123, "india"))
				,new Player("jaashu", 8, 5200, 100, new Country(125, "Uk")),new Player("Naveen", 250, 10001, 97, new Country(124, "Usa")));
		
		

	static void displayPlayersForCountry(String country){
		System.out.println("Displaying players list having score >= 100 and which is matching with input country: ");
		p.stream().filter(e->e.getHighestScore()>=100 && e.getCountry().getCountryName().equals(country)).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("---------------------------------");
	
	}
	
	
	static void getAverageRunsByCountry(String country) {
		/*Map<String, Double> playerToAvgScore = al.stream().collect(Collectors.groupingBy(
        Bowling_score_tracker::getPlayerName, 
        Collectors.averagingInt(Bowling_score_tracker::getScore)));*/
		System.out.println("Average runs of country matching: ");
		List<Player> result= p.stream().filter(e->e.getCountry().getCountryName().equals(country)).collect(Collectors.toList());
		OptionalDouble avgRuns= result.stream().mapToInt(runs->runs.getRuns()).average();
		System.out.println(avgRuns);
		System.out.println("---------------------------------");
	}
	static void getPlayerNamesSorted() {
		System.out.println("players sorted by country name ");
		List<Player> sortedplayer=p.stream().sorted((o1, o2) -> o2.getCountry().getCountryName().compareTo(o1.getCountry().getCountryName())).collect(Collectors.toList());
		for(Player Player:sortedplayer) {
			System.out.println(Player.getPlayerName());
			
		}
		System.out.println("---------------------------------");
	}

	static void displayPlayers() {
		System.out.println("Player name: ");
		for(Player Player:p) {
			System.out.println(Player.getPlayerName());
			
		}
		System.out.println("---------------------------------");
		
	} 
	//Return a LinkedList containing names of all Players, whose have scored more than 5000 runs, 
	//sorted in descending order of names
	static void getPlayerNames(){
		System.out.println("get player names who has runs>5000: ");
		List<Player> result= p.stream().filter(e->e.getRuns()>5000).collect(Collectors.toList());
		System.out.println(result);
		System.out.println("---------------------------------");
		
	}
	static void getMaxRunsPlayer() {
		Player playerwithmaxruns= p.stream().sorted((o1, o2)->o2.getRuns()-o1.getRuns()).collect(Collectors.toList()).get(0);
		System.out.println("Player having Max runs: " +playerwithmaxruns);
		System.out.println("---------------------------------");
	}
	
	static void findPlayer(String name, String country) {
		
		System.out.println("Players matching with given name and country: ");
		p.stream().filter(e->e.getPlayerName().equals(name) && e.getCountry().getCountryName().equals(country)).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("---------------------------------");
	}
	
	static void checkHighScorerByCountry() {
		p.stream().filter(null).collect(Collectors.groupingBy(Player::getCountry));
		System.out.println("---------------------------------");
	}
	
	static void getPlayerCountry(){
		
		System.out.println("names and country of players who has played more than 200 matches: ");
		
	List<Player> match=p.stream().filter(e->e.getMatchesPlayed()>200).collect(Collectors.toList());
	for(Player Player:match) {
		System.out.println("name: " +Player.getPlayerName()+ " country: "+ Player.getCountry().getCountryName());
		System.out.println("---------------------------------");
	}
	}
	
	static boolean checkHighScorerByCountry(String country){
		System.out.println("Checking hishest score: ");
		List<Player> result=p.stream().filter(e->e.getRuns()>10000 && e.getCountry().getCountryName().equals(country)).collect(Collectors.toList());
		if(result.equals(p)) {
			return true;
			}else {
				return false;
			}
	}
	}


	/*private static void populate(List<Player> p) {
		p.add(new Player("Navya", 7, 5000, 120, new Country(123, "india")));
		p.add(new Player("kavya", 8, 6000, 110, new Country(124, "Usa")));
		p.add(new Player("sravya", 6, 5500, 160, new Country(123, "india")));
		p.add(new Player("bhavya", 5, 4000, 180, new Country(125, "Uk")));
		p.add(new Player("Nitya", 6, 6500, 90, new Country(123, "india")));
		p.add(new Player("Naveen", 7, 4900, 97, new Country(124, "Usa")));
		p.add(new Player("jaashu", 8, 5200, 100, new Country(125, "Uk")));
		
		
	}*/

