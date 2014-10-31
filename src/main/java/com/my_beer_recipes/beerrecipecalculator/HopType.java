package com.my_beer_recipes.beerrecipecalculator;

public enum HopType implements HopTypeInterface {

	ADMIRAL {
		public double getAlphaAcid() {
			return 15.0;
		}
	},
	BRAMLING_CROSS {
		public double getAlphaAcid() {
			return 6.0;
		}
	},
	CHALLENGER {
		public double getAlphaAcid() {
			return 7.6;
		}
	},
	EAST_KENT_GOLDING {
		public double getAlphaAcid() {
			return 6.0;
		}
	},
	FIRST_GOLD {
		public double getAlphaAcid() {
			return 9.0;
		}
	},
	FUGGLES {
		public double getAlphaAcid() {
			return 5.0;
		}
	},
	HALLERTAUER_HERSBRUCKER {
		public double getAlphaAcid() {
			return 2.8;
		}
	},
	NORTHDOWN {
		public double getAlphaAcid() {
			return 8.0;
		}
	},
	PILGRIM {
		public double getAlphaAcid() {
			return 11.0;
		}
	},
	PROGRESS {
		public double getAlphaAcid() {
			return 6.0;
		}
	},
	SOVEREIGN {
		public double getAlphaAcid() {
			return 5.5;
		}
	},
	TARGET {
		public double getAlphaAcid() {
			return 10.5;
		}
	},
	WGV {
		public double getAlphaAcid() {
			return 6.0;
		}
	}
}
