package main;

import java.util.Map;
import java.util.Set;

public class MapExerciseApplication {

	public static void main(String[] args) {
		String winningHand = "FLUSH";
		String fileName = "PokerHands.csv";
		Map<String, Integer> pokerRound = extractDataFromCSV(fileName, winningHand);

		//Task 1
		printResults(1, winningHand, pokerRound);
		//Task 2
		replacePlayer(pokerRound, "Rita Repulsa", "Zordon");
		printResults(2, winningHand, pokerRound);
		//Task 3
		addToCount(pokerRound, "He Man");
		printResults(3, winningHand, pokerRound);
		//Task 4
		removePlayer(winningHand, pokerRound, "He Man");
		printResults(4, winningHand, pokerRound);
	}

	private static void addToCount(Map<String, Integer> hand, String player) {
		int ctr = hand.get(player);
		hand.put(player, ++ctr);
	}

	private static void removePlayer(String winningHand, Map<String, Integer> hand, String removePlayer) {
		hand.remove(removePlayer);
	}

	private static void replacePlayer(Map<String, Integer> hand, String oldPlayer,
			String newPlayer) {
		int ctr = hand.get(oldPlayer);
		hand.remove(oldPlayer);
		hand.put(newPlayer, ctr);
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