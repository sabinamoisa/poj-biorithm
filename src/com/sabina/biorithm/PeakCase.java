package com.sabina.biorithm;

import java.util.List;

public class PeakCase {

	private int id;
	private List<Peak> peaks;
	private int givenDay;

	public PeakCase(int id, List<Peak> peaks, int givenDay) {
		this.id = id;
		this.peaks = peaks;
		this.givenDay = givenDay;
	}

	public List<Peak> getPeaks() {
		return peaks;
	}

	public int getGivenDay() {
		return givenDay;
	}

	public boolean isDataCorrect() {
		boolean isDataCorrect = true;

		for (Peak peak : peaks) {
			isDataCorrect = isDataCorrect && peak.isDataCorrect();
		}

		return isDataCorrect;
	}

	public String error() {
		if (!isDataCorrect()) {
			return "Input values should be non-negative and at most 365!";
		}
		return "";
	}

	public int getId() {
		return id;
	}
}
