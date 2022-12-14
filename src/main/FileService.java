package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileService {
	Map<String, Integer> round = new HashMap<>();
	String[] playerHand = null;

	public void readFromFile(String filename, String winningHand) {
		String line = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			reader.readLine();

			while ((line = reader.readLine()) != null) {
				playerHand = line.split(",");

				if (playerHand[1].equals(winningHand)) {
					setInitCounter("Patrick Stewart");
					setInitCounter("Rita Repulsa");
					setInitCounter("He Man");
					setInitCounter("TJ Hooker");
				}
			}

			reader.close();
		} catch (
		IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setInitCounter(String playerName) {
		if (playerHand[0].equals(playerName)) {
			if ((round.get(playerHand[0])) == null) {
				round.put(playerHand[0], 1);
			} else {
				int ctr = round.get(playerHand[0]);
				round.put(playerHand[0], ++ctr);
			}
		}
	}
}