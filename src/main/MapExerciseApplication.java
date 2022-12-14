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
		replacePlayer(winningHand, hand, "Rita Repulsa", "Zordon");
		addWin(winningHand, hand, "He Man");
		removePlayer(winningHand, hand, "He Man");
	}

	private static void addWin(String winningHand, Map<String, Integer> hand, String player) {
		int ctr = hand.get(player);
		hand.put(player, ++ctr);
		printResults(3, winningHand, hand);
	}

	private static void removePlayer(String winningHand, Map<String, Integer> hand, String removePlayer) {
		hand.remove(removePlayer);
		printResults(4, winningHand, hand);
	}

	private static void replacePlayer(String winningHand, Map<String, Integer> hand, String oldPlayer,
			String newPlayer) {
		int ctr = hand.get(oldPlayer);
		hand.remove(oldPlayer);
		hand.put(newPlayer, ctr);
		printResults(2, winningHand, hand);
	}

	private static void printResults(Integer task, String winningHand, Map<String, Integer> hand) {
		System.out.println("After Task " + task + ": " + winningHand);
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