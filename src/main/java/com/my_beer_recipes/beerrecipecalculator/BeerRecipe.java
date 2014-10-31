package com.my_beer_recipes.beerrecipecalculator;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class BeerRecipe {

	private String beerName;
	private int beerFinalVolume;
	private List<HopUsage> hopUsageList;
    private EnumMap<GristType, Double> gristWeightsKgMap;
	private EnumMap<CalculatedBeerAttributesEnum, String> attributesMap;

	public BeerRecipe(String name) {
		gristWeightsKgMap = new EnumMap<GristType, Double>(GristType.class);
		attributesMap = new EnumMap<CalculatedBeerAttributesEnum, String>(CalculatedBeerAttributesEnum.class);
		hopUsageList = new ArrayList<HopUsage>();
		beerName = name;
	}

	public BeerRecipe(String name, int vol) {
		gristWeightsKgMap = new EnumMap<GristType, Double>(GristType.class);
		attributesMap = new EnumMap<CalculatedBeerAttributesEnum, String>(CalculatedBeerAttributesEnum.class);
		hopUsageList = new ArrayList<HopUsage>();
		beerName = name;
		beerFinalVolume = vol;
	}

	public void setBeerAttribute(CalculatedBeerAttributesEnum attr, String info) {
		attributesMap.put(attr, info);
	}

	public String getBeerAttribute(CalculatedBeerAttributesEnum attr) {
		return attributesMap.get(attr);
	}

	public void addGrist(GristType aGristType, double weight) {
		gristWeightsKgMap.put(aGristType, weight);
	}

	public String getBeerName() {
		return beerName;
	}

	public void setBeerName(String name) {
		beerName = name;
	}

	public int getBeerFinalVolume() {
		return beerFinalVolume;
	}

	public void setBeerFinalVolume(int vol) {
		beerFinalVolume = vol;
	}

	public void addHopUsage(HopType type, int weight, int boilTime) {
		hopUsageList.add(new HopUsage(type, weight, boilTime));
	}

	public List<HopUsage> getHopUsageList() {
		return hopUsageList;
	}

	public void setHopUsageList(List<HopUsage> list) {
		hopUsageList = list;
	}

	public EnumMap<GristType, Double> getGristWeightsKgMap() {
		return gristWeightsKgMap;
	}

	public void setGristWeightsMap(EnumMap<GristType, Double> map) {
		gristWeightsKgMap = map;
	}

}
