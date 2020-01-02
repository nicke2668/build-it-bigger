package com.example.jokeslib;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JokeGenerator {

	private static final List<String> JOKES = Arrays.asList(
			"Q: What goes up and down but does not move?\n" +
					"A: Stairs",
			"Q: Where should a 500 pound alien go?\n" +
					"A: On a diet",
			"Q: What did one toilet say to the other?\n" +
					"A: You look a bit flushed.\n",
			"Q: Why did the picture go to jail?\n" +
					"A: Because it was framed.\n",
			"Q: What did one wall say to the other wall?\n" +
					"A: I'll meet you at the corner.\n",
			"Q: What did the paper say to the pencil?\n" +
				"A: Write on!\n",
			"Q: What do you call a boy named Lee that no one talks to?\n" +
					"A: Lonely"
	);
	private static final Random RANDOM = new Random();

	public static String generate() {
		return JOKES.get(RANDOM.nextInt(JOKES.size()));
	}

	private JokeGenerator() {
	}
}
