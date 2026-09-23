import {
    convertAcresToHectares,
    convertFeetToMeters,
    convertMilesToKilometers,
} from '../unit-conversion-utils'

describe('unit conversion utils', () => {
    it('converts feet to meters', () => {
        expect(convertFeetToMeters(10)).toBe(3.05)
        expect(convertFeetToMeters(100)).toBe(30.48)
        expect(convertFeetToMeters(0)).toBe(0)
    })

    it('converts miles to kilometers', () => {
        expect(convertMilesToKilometers(1)).toBe(1.61)
        expect(convertMilesToKilometers(5)).toBe(8.05)
        expect(convertMilesToKilometers(10)).toBe(16.09)
    })

    it('converts acres to hectares', () => {
        expect(convertAcresToHectares(1)).toBe(0.4)
        expect(convertAcresToHectares(10)).toBe(4.05)
        expect(convertAcresToHectares(0)).toBe(0)
    })
})
