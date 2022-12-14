package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileService {
	Map<String, Integer> round = new HashMap<>();
	String[] pokerHand = null;

	public void readFromFile(String filename, String winningHand) {
		String line = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			reader.readLine();

			while ((line = reader.readLine()) != null) {
				pokerHand = line.split(",");

				if (pokerHand[1].equals(winningHand)) {
					setFlushCounter("Patrick Stewart");
					setFlushCounter("Rita Repulsa");
					setFlushCounter("He Man");
					setFlushCounter("TJ Hooker");
				}
			}

			reader.close();
		} catch (
		IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setFlushCounter(String name) {
		if (pokerHand[0].equals(name)) {
			if ((round.get(pokerHand[0])) == null) {
				round.put(pokerHand[0], 1);
			} else {
				int ctr = round.get(pokerHand[0]);
				round.put(pokerHand[0], ++ctr);
			}
		}
	}
}