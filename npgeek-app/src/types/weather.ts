export interface Weather {
    /** Unique identifier */
    parkCode: string,
    /** Which day this is in a five day forecast */
    fiveDayForecastValue: number,
    low: number,
    high: number,
    forecast: string,
    /** Which weather image to show  */
    forecastImage: string,
}
