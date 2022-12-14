package main;

import java.util.Map;
import java.util.Set;

public class MapExerciseApplication {

	// instatiate new hashset

	public static void main(String[] args) {
		// extract the data from the CSV
		String winningHand = "FLUSH";
		String fileName = "PokerHands.csv";

		Map<String, Integer> hand = extractDataFromCSV(fileName, winningHand);
		
		printResults(1, winningHand, hand);
		
		int ritaR = hand.get("Rita Repulsa");
		hand.remove("Rita Repulsa");
		hand.put("Zordon", ritaR);
		printResults(2, winningHand, hand);
		
		int heMan = hand.get("He Man");
		hand.put("He Man", ++heMan);
		printResults(3, winningHand, hand);
		
		hand.remove("He Man");
		printResults(4, winningHand, hand);
	}

	private static void printResults(Integer task, String winningHand, Map<String, Integer> hand) {
		System.out.println("After Task "+ task +": " + winningHand);
		hand.forEach((key, value) -> System.out.println(key + ": " + value));
		System.out.println("");
	}

	public static void printToConsole(Map<Integer, Set<String>> hand, Integer task) {
		System.out.println("After Task " + task + ":");
		System.out.println(hand);
		System.out.println("");
	}

	public static Map<String, Integer> extractDataFromCSV(String fileName, String winningHand) {
		FileService reader = new FileService();
		reader.readFromFile(fileName, winningHand);
		Map<String, Integer> pokerHand = reader.round;
		return pokerHand;
	}
}