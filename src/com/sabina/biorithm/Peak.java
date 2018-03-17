package com.sabina.biorithm;

import java.util.ArrayList;
import java.util.List;

public class Peak {

	private static final int MAX_PEAK_DAY = 21252;

	private Cycle cycle;
	private int occurenceDay;

	public Peak(Cycle cycle, int occurenceDay) {
		this.cycle = cycle;
		this.occurenceDay = occurenceDay;
	}

	private int nextOccurenceDay(int occurences) {
		return cycle.nextOccurenceDay(occurenceDay, occurences);
	}

	public List<Peak> nextPeaks() {
		List<Peak> nextPeaks = new ArrayList<>();
		for (int i = 1;; i++) {
			if (nextOccurenceDay(i) <= MAX_PEAK_DAY) {
				nextPeaks.add(new Peak(cycle, nextOccurenceDay(i)));
			} else {
				break;
			}
		}
		return nextPeaks;
	}

	public List<Integer> nextPeaksDays() {
		List<Integer> nextPeaksDays = new ArrayList<>();
		for (Peak peak : nextPeaks()) {
			nextPeaksDays.add(new Integer(peak.occurenceDay));
		}
		return nextPeaksDays;
	}

	public boolean isDataCorrect() {
		return occurenceDay > -1 && occurenceDay <= 365;
	}
}
