package com.sabina.biorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PeakCalculator {

	private PeakCase peakCase;

	public PeakCalculator(PeakCase peakCase) {
		this.peakCase = peakCase;
	}

	private int nextDay() {
		return numberOfDays() - peakCase.getGivenDay();
	}

	private int numberOfDays() {
		int days = 0;

		List<List<Integer>> peakDaysList = new ArrayList<>();
		for (Peak peak : peakCase.getPeaks()) {
			peakDaysList.add(peak.nextPeaksDays());
		}

		if (peakDaysList.size() > 0) {
			List<Integer> firstList = peakDaysList.get(0);

			for (int i = 1; i < peakDaysList.size(); i++) {
				firstList.retainAll(peakDaysList.get(i));
			}

			Collections.sort(firstList);

			if (firstList.size() > 0) {
				days = firstList.get(0);
			}
		}
		return days;
	}

	public void printNext() {
		if (!("".equals(peakCase.error()))) {
			System.out.println(peakCase.error());
		} else {
			System.out.println("Case " + peakCase.getId() + ": the next triple peak occurs in " + nextDay() + " days.");
		}
	}
}
