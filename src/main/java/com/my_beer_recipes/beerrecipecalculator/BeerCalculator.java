package com.my_beer_recipes.beerrecipecalculator;

import java.math.*;
import java.util.EnumMap;
import java.util.List;

public class BeerCalculator implements BeerCalculatorInterface {

	private static final double EFFICIENCY = 0.75;
	private static final double YEAST_ATTENUATION = 0.75;
	private static final double THOUSANDTH = 0.001;
	private static final double ABV_CORRECTION_FACTOR = 1.25;
	private static final int ABV_CORRECTION = 105;
	private static final double VOLUME_CORRECTION_FACTOR = 1.10;
	private static final int EVAPORATION_LOSS = 3;
	private static final double GRIST_TO_LIQUOR_RATIO = 2.5; // ltr/kg
	private BeerRecipe beerRecipe;

	public BeerCalculator(BeerRecipe recipe) {
		beerRecipe = recipe;
	}

	public void setBeerRecipe(BeerRecipe recipe) {
		beerRecipe = recipe;
	}

	public String calculateAbv() {

		int gravityDifference = Integer.valueOf(calculateOriginalGravity()) - Integer.valueOf(calculateFinalGravity());
		double abv = gravityDifference * THOUSANDTH * ABV_CORRECTION * ABV_CORRECTION_FACTOR;
		BigDecimal aBigDecimalAbv = new BigDecimal(abv, new MathContext(2));

		return String.valueOf(aBigDecimalAbv.doubleValue());
	}

	public String getPrettyGravity(String gravity) {

		if (Integer.valueOf(gravity) < 10) {
			return "100" + gravity;
		}
		else {
			return "10" + gravity;
		}
	}

	public String calculateOriginalGravity() {

		double totalGravity = 0.0;
		EnumMap<GristType, Double> GristWeightsMap = beerRecipe.getGristWeightsKgMap();

		int finalVolume = beerRecipe.getBeerFinalVolume();

		for (EnumMap.Entry<GristType, Double> eachEntry : GristWeightsMap.entrySet()) {
			double sugarsExtracted = eachEntry.getKey().getExtractPotential() * eachEntry.getValue();
			totalGravity += (sugarsExtracted / finalVolume);
		}

		return String.valueOf((int) (totalGravity * EFFICIENCY));
	}

	public String calculateFinalGravity() {

		int originalGravity = Integer.valueOf(calculateOriginalGravity());
		return String.valueOf((int) (originalGravity - (YEAST_ATTENUATION * originalGravity)));
	}

	private double getHopUtilisationFactor(int og) {

		double util = 0.0;

		if ((og > 29) && (og < 37)) {
			util = 28.0;
		}
		if ((og > 36) && (og < 46)) {
			util = 26.0;
		}
		if ((og > 45) && (og < 51)) {
			util = 25.0;
		}
		if ((og > 50) && (og < 56)) {
			util = 24.0;
		}
		if ((og > 55) && (og < 61)) {
			util = 23.0;
		}

		return util;
	}

	public String calculateEbu() {

		double totalBitterness = 0.0;
		double util = getHopUtilisationFactor(Integer.valueOf(calculateOriginalGravity()));
		List<HopUsage> hopUsageList = beerRecipe.getHopUsageList();
		int volumeMils = beerRecipe.getBeerFinalVolume() * 10;
		double boilTimeAdjustment = 0.34;

		for(HopUsage eachUsage : hopUsageList) {

			if (eachUsage.getBoilTimeMins() > 45) {
				boilTimeAdjustment = 1.0;
			}
			double aa = eachUsage.getHopType().getAlphaAcid();
			double alphaAcidUtilised = eachUsage.getWeightGrams() * aa * util * boilTimeAdjustment;
			double eachBitterness = alphaAcidUtilised / volumeMils;
			totalBitterness += eachBitterness;
			boilTimeAdjustment = 0.34;
		}

		return String.valueOf((int) totalBitterness);
	}

	public String calculateColour() {

		double totalColour = 0.0;
		int volumeMils = beerRecipe.getBeerFinalVolume() * 10;
		EnumMap<GristType, Double> GristWeightsMap = beerRecipe.getGristWeightsKgMap();

		for (EnumMap.Entry<GristType, Double> eachEntry : GristWeightsMap.entrySet()) {
			double colourExtracted = eachEntry.getKey().getExtractPotential() * eachEntry.getValue() * eachEntry.getKey().getColour();
			totalColour += colourExtracted;
		}

		int intColour = (int) (totalColour * EFFICIENCY) / volumeMils;

		return String.valueOf(intColour);
	}

	public String calculateTotalVolume() {

		int finalVolume = beerRecipe.getBeerFinalVolume();
		int totalVolume = (int) (finalVolume * VOLUME_CORRECTION_FACTOR) + EVAPORATION_LOSS;
		return String.valueOf(totalVolume);
	}

	private double getTotalGristWeightKg() {

		double totalWeight = 0.0;
		EnumMap<GristType, Double> GristWeightsMap = beerRecipe.getGristWeightsKgMap();

		for (EnumMap.Entry<GristType, Double> eachEntry : GristWeightsMap.entrySet()) {
			totalWeight += eachEntry.getValue();
		}

		return totalWeight;
	}

	public String calculateMashVolume() {

		double mashVolume = getTotalGristWeightKg() * GRIST_TO_LIQUOR_RATIO;
		BigDecimal aBigDecimalMashVolume;

		if (mashVolume < 10.0) {
			aBigDecimalMashVolume = new BigDecimal(mashVolume, new MathContext(1));
		}
		else {
			aBigDecimalMashVolume = new BigDecimal(mashVolume, new MathContext(2));
		}

		return String.valueOf(aBigDecimalMashVolume.intValue());
	}

}
