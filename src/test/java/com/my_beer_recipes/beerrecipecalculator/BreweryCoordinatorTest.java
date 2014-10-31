package com.my_beer_recipes.beerrecipecalculator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BreweryCoordinatorTest {

	private BeerRecipe recipe;
	private BreweryCoordinator breweryCoord;
	private static final String RECIPE_NAME = "Mild";
	private static final int RECIPE_VOLUME_LTR = 23;
	private static final String OG_RESULT = "1033";
	private static final String FG_RESULT = "1008";
	private static final String ABV_RESULT = "3.3";
	private static final String COLOUR_RESULT = "301";
	private static final String EBU_RESULT = "29";
	private static final String MASH_VOL_RESULT = "9";
	private static final String TOTAL_VOL_RESULT = "28";

	@Before
	public void setUp() {

		breweryCoord = new BreweryCoordinator();
		recipe = breweryCoord.createNewRecipe(RECIPE_NAME, RECIPE_VOLUME_LTR);
		recipe.addGrist(GristType.PALE, 2.78);
		recipe.addGrist(GristType.CRYTAL, 0.42);
		recipe.addGrist(GristType.BLACK, 0.24);
		recipe.addGrist(GristType.TORRIFIED_WHEAT, 0.13);
		recipe.addHopUsage(HopType.CHALLENGER, 30, 90);
		recipe.addHopUsage(HopType.EAST_KENT_GOLDING, 9, 10);
		breweryCoord.calculateBeerRecipeAttributes(recipe);
	}

	@Test
	public void testNewRecipe() {

		assertEquals(RECIPE_NAME, recipe.getBeerName());
	}

	@Test
	public void testAddHopUsage() {

		assertEquals(30, recipe.getHopUsageList().get(0).getWeightGrams());
	}

	@Test
	public void testAddGristUsage() {

		assertTrue(recipe.getGristWeightsKgMap().get(GristType.PALE) == 2.78);
	}

	@Test
	public void testCalculateOriginalGravity() {

		String result = recipe.getBeerAttribute(CalculatedBeerAttributesEnum.ORIGINAL_GRAVITY);
		assertEquals(OG_RESULT, result);
	}

	@Test
	public void testCalculateFinalGravity() {

		String result = recipe.getBeerAttribute(CalculatedBeerAttributesEnum.FINAL_GRAVITY);
		assertEquals(FG_RESULT, result);
	}

	@Test
	public void testCalculateABV() {

		String result = recipe.getBeerAttribute(CalculatedBeerAttributesEnum.ABV);
		assertEquals(ABV_RESULT, result);
	}

	@Test
	public void testCalculateColour() {

		String result = recipe.getBeerAttribute(CalculatedBeerAttributesEnum.COLOUR);
		assertEquals(COLOUR_RESULT, result);
	}

	@Test
	public void testCalculateEbu() {

		String result = recipe.getBeerAttribute(CalculatedBeerAttributesEnum.EBU);
		assertEquals(EBU_RESULT, result);
	}

	@Test
	public void testCalculateMashVolume() {

		String result = recipe.getBeerAttribute(CalculatedBeerAttributesEnum.MASH_VOLUME);
		assertEquals(MASH_VOL_RESULT, result);
	}

	@Test
	public void testCalculateTotalVolume() {

		String result = recipe.getBeerAttribute(CalculatedBeerAttributesEnum.TOTAL_VOLUME);
		assertEquals(TOTAL_VOL_RESULT, result);
	}
}
