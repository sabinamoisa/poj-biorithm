package com.sabina.biorithm;

public enum Cycle {
	PHYSICAL(23), EMOTIONAL(28), INTELLECTUAL(33);

	private final int period;

	Cycle(int period) {
		this.period = period;
	}

	public int period() {
		return period;
	}

	public int nextOccurenceDay(int previousOccurenceDay, int occurences) {
		return previousOccurenceDay + occurences * period;
	}
}