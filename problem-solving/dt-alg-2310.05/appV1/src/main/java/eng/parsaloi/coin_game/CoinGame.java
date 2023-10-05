package eng.parsaloi.coin_game;

import java.util.*;

public class CoinGame {

	public static int maxCoinWin(int [] coins) {

		// Create a list of the coins
		List<Integer> coinList = new ArrayList<>();
		for (int coin: coins) {
			coinList.add(coin);
		}

		// Create a comparator to compare coins in decreasing order.
		Comparator<Integer> coinComparator = (coin1, coin2) -> Integer.compare(coin2, coin1);

		// Sort the coins in decreasing order
		Collections.sort(coinList, coinComparator);

		// Create an iterator to iterate over the coins
		Iterator<Integer> coinIterator = coinList.iterator();

		// Initialize the maximum amount of money that can be won.
		int maxCoinWin = 0;

		// Iterate over the coins and choose the first or last coin
		while (coinIterator.hasNext()) {
			int firstCoin = coinIterator.next();
			int lastCoin = coinIterator.hasNext() ? coinIterator.next() : firstCoin;

			// Choose the first coin
			int firstCoinWin = firstCoin;

			// Choose the last coin
			int lastCoinWin = lastCoin;

			// Update the maximum amount of money that can be won
			maxCoinWin = Math.max(maxCoinWin, Math.max(firstCoinWin, lastCoinWin));
		}

		// Return the maximum amount of money that can be won
		return maxCoinWin;
	}

	public static void main(String[] args) {

		int [] coins = {20, 10, 5, 20, 20, 35};

		System.out.println(maxCoinWin(coins));
	}
}
