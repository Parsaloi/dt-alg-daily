import 'dart:convert';

class CoinGame {

	static int getMaximumWinnings(List<int> coins) {

		if(coins.isEmpty) {
			return 0;
		}

		int firstCoin = coin.first;
		int lastCoin = coin.last;
		List<int> restCoins = coins.sublist(1, coins.length - 1);

		int withoutFirstCoinValue = getMaximumWinnings(restCoins);
		int withoutLastCoinValue = getMaximumWinnings(restCoins.reversed.toList());

		return math.max(firstCoin + withoutLastCoinValue, lastCoin + withoutFirstCoinValue);
	}
}

void main() {

	// Get the input from the input field in the browser
	String input = document.querySelector('#input-field')!.value;

	// Convert the input to a list of integers
	List<int> coins = json.decode(input);

	// Calculate the maximum amount of money you can win with certainty.
	int maximumWinnings = CoinsGame.getMaximumWinnings(coins);

	// Print the result on the browser as a string
	document.querySelector('#output-field')!.innerHTML = maximumWinnings.toString();
}
