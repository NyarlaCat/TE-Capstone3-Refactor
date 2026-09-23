/**
 * Converts imperial unit of feet to the metric unit of meters
 * @param feet The number of feet to convert to meters
 * @returns The equivalent number of meters rounded to the nearest two decimal 
 * places.
 */
export const convertFeetToMeters = (feet: number) => {
    return _roundToNearestTwoPlaces(feet * 0.3048)
}

/**
 * Converts imperial unit of miles to the metric unit of kilometers
 * @param miles 
 * @returns The equivalent number of kilometers rounded to the nearest two decimal 
 * places.
 */
export const convertMilesToKilometers = (miles: number) => {
    return _roundToNearestTwoPlaces(miles * 1.60934)
}

/**
 * Converts imperial unit of acres to the metric unit of square hectares
 * @param acres 
 * @returns The equivalent number of square hectares rounded to the nearest two decimal 
 * places.
 */
export const convertAcresToHectares = (acres: number) => {
    return _roundToNearestTwoPlaces(acres * 0.404686)
}


/**
 * A private helper function for rounding
 * @param n number to round
 * @returns The provided number rounded to the nearest two 
 * decimal places
 */
const _roundToNearestTwoPlaces = (n: number) => {
    return Math.round(n * 100) / 100
}