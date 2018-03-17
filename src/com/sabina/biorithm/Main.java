package com.sabina.biorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static List<PeakCase> parseInput() {
		List<PeakCase> peakCases = new ArrayList<PeakCase>();

		try (Scanner scanner = new Scanner(System.in)) {
			int p = scanner.nextInt();
			int e = scanner.nextInt();
			int i = scanner.nextInt();
			int d = scanner.nextInt();

			int id = 0;
			while (!(p == -1 && e == -1 && i == -1 && d == -1)) {
				List<Peak> peaks = new ArrayList<>();
				peaks.add(new Peak(Cycle.PHYSICAL, p));
				peaks.add(new Peak(Cycle.EMOTIONAL, e));
				peaks.add(new Peak(Cycle.INTELLECTUAL, i));
				peakCases.add(new PeakCase(++id, peaks, d));

				scanner.nextLine();

				p = scanner.nextInt();
				e = scanner.nextInt();
				i = scanner.nextInt();
				d = scanner.nextInt();
			}
		}

		return peakCases;
	}

	public static void main(String args[]) throws Exception {

		List<PeakCase> peakCases = parseInput();

		for (PeakCase peakCase : peakCases) {
			new PeakCalculator(peakCase).printNext();
		}

	}
}
