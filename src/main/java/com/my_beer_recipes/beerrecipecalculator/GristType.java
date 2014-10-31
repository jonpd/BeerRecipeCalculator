package com.my_beer_recipes.beerrecipecalculator;

public enum GristType implements GristTypeInterface {

	PALE {
		public int getColour() {
			return 5;
		}

		public int getExtractPotential() {
			return 300;
		}
	},
	CRYTAL {
		public int getColour() {
			return 130;
		}

		public int getExtractPotential() {
			return 240;
		}
	},

	HONEY {
		public int getColour() {
			return 3;
		}

		public int getExtractPotential() {
			return 240;
		}
	},

	BLACK {
		public int getColour() {
			return 1300;
		}

		public int getExtractPotential() {
			return 240;
		}
	},
	CHOCOLATE {
		public int getColour() {
			return 1050;
		}

		public int getExtractPotential() {
			return 240;
		}
	},
	TORRIFIED_WHEAT {
		public int getColour() {
			return 5;
		}

		public int getExtractPotential() {
			return 240;
		}
	},
	MALTED_WHEAT {
		public int getColour() {
			return 3;
		}

		public int getExtractPotential() {
			return 300;
		}
	},

	MUNICH {
		public int getColour() {
			return 5;
		}

		public int getExtractPotential() {
			return 300;
		}
	}
}
