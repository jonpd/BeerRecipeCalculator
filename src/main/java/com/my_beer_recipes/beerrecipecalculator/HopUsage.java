package com.my_beer_recipes.beerrecipecalculator;

public class HopUsage {

	private HopType hopType;
	private int weightGrams;
	private int boilTimeMins;

	public HopUsage(HopType type, int weight, int boilTime) {
		hopType = type;
		weightGrams = weight;
		boilTimeMins = boilTime;
	}

	public HopType getHopType() {
		return hopType;
	}

	public void setHopType(HopType hopType) {
		this.hopType = hopType;
	}

	public int getWeightGrams() {
		return weightGrams;
	}

	public void setWeightGrams(int weightGrams) {
		this.weightGrams = weightGrams;
	}

	public int getBoilTimeMins() {
		return boilTimeMins;
	}

	public void setBoilTimeMins(int boilTimeMins) {
		this.boilTimeMins = boilTimeMins;
	}
}
