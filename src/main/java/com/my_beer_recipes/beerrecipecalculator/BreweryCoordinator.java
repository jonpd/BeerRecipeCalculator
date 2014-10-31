package com.my_beer_recipes.beerrecipecalculator;

public class BreweryCoordinator {

	public BeerRecipe createNewRecipe(String name, int ltr) {

		return new BeerRecipe(name, ltr);
	}

	public BeerRecipe calculateBeerRecipeAttributes(BeerRecipe recipe) {

		BeerCalculator beerCalculator = new BeerCalculator(recipe);
		recipe.setBeerAttribute(CalculatedBeerAttributesEnum.ORIGINAL_GRAVITY, beerCalculator.getPrettyGravity(beerCalculator.calculateOriginalGravity()));
		recipe.setBeerAttribute(CalculatedBeerAttributesEnum.FINAL_GRAVITY, beerCalculator.getPrettyGravity(beerCalculator.calculateFinalGravity()));
		recipe.setBeerAttribute(CalculatedBeerAttributesEnum.ABV, beerCalculator.calculateAbv());
		recipe.setBeerAttribute(CalculatedBeerAttributesEnum.COLOUR, beerCalculator.calculateColour());
		recipe.setBeerAttribute(CalculatedBeerAttributesEnum.EBU, beerCalculator.calculateEbu());
		recipe.setBeerAttribute(CalculatedBeerAttributesEnum.MASH_VOLUME, beerCalculator.calculateMashVolume());
		recipe.setBeerAttribute(CalculatedBeerAttributesEnum.TOTAL_VOLUME, beerCalculator.calculateTotalVolume());

		return recipe;
	}

}
