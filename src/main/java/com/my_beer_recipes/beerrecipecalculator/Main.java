package com.my_beer_recipes.beerrecipecalculator;

public class Main {

	public static void main(String[] args) {

		BreweryCoordinator breweryCoord = new BreweryCoordinator();
//		BeerRecipe recipe = breweryCoord.createNewRecipe("mild", 5);
//		recipe.addGrist(GristType.PALE, 2.78);
//		recipe.addGrist(GristType.CRYTAL, 0.42);
//		recipe.addGrist(GristType.BLACK, 0.24);
//		recipe.addGrist(GristType.TORRIFIED_WHEAT, 0.13);
//		recipe.addHopUsage(HopType.CHALLENGER, 30, 90);
//		recipe.addHopUsage(HopType.EAST_KENT_GOLDING, 9, 10);

		BeerRecipe recipe = breweryCoord.createNewRecipe("porter", 5);
		recipe.addGrist(GristType.PALE, 0.8);
		recipe.addGrist(GristType.MUNICH, 0.16);
		recipe.addGrist(GristType.CRYTAL, 0.24);
		recipe.addGrist(GristType.BLACK, 0.08);
		recipe.addGrist(GristType.CHOCOLATE, 0.04);
		recipe.addGrist(GristType.HONEY, 0.1);
		recipe.addHopUsage(HopType.HALLERTAUER_HERSBRUCKER, 20, 90);
		recipe.addHopUsage(HopType.HALLERTAUER_HERSBRUCKER, 8, 10);

		recipe = breweryCoord.calculateBeerRecipeAttributes(recipe);
		System.out.println("ABV: " + recipe.getBeerAttribute(CalculatedBeerAttributesEnum.ABV));
		System.out.println("Colour: " + recipe.getBeerAttribute(CalculatedBeerAttributesEnum.COLOUR));
		System.out.println("EBU: " + recipe.getBeerAttribute(CalculatedBeerAttributesEnum.EBU));
		System.out.println("Mash vol: " + recipe.getBeerAttribute(CalculatedBeerAttributesEnum.MASH_VOLUME));
		System.out.println("Total vol: " + recipe.getBeerAttribute(CalculatedBeerAttributesEnum.TOTAL_VOLUME));

	}

}
