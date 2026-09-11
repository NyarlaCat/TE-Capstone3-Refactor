/**
 * The Park interface represents the structure of a park object as 
 * returned from the `/api/parks` endpoint.
 */
export interface Park {
  /** The unique code identifying the park */
  parkCode: string;
  parkName: string;
  state: string;
  acreage: number;
  elevationInFeet: number;
  milesOfTrail: number;
  numberOfCampsites: number;
  climate: string;
  yearFounded: number;
  annualVisitorCount: number;
  inspirationalQuote: string;
  inspirationalQuoteSource: string;
  parkDescription: string;
  entryFee: number;
  numberOfAnimalSpecies: number;
  /** The code used to reference the park's image path */
  imgCode: string;
}