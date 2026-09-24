import { fireEvent, render, screen } from '@testing-library/react';
import ParkDetailPage from '../ParkDetailPage';
import type { Park } from '../../types/park';
import { useGetParkDetails } from '../../hooks/useGetParkDetails';
import {
    convertAcresToHectares,
    convertFeetToMeters,
    convertMilesToKilometers,
} from '../../utils/unit-conversion-utils';

jest.mock('react-router-dom', () => ({
    useSearchParams: () => [new URLSearchParams('id=YEL')],
}));

jest.mock('../../hooks/useGetParkDetails');

const mockedUseGetParkDetails = jest.mocked(useGetParkDetails);

const mockPark: Park = {
    parkCode: 'YEL',
    parkName: 'Yellowstone',
    state: 'Wyoming',
    acreage: 2219791,
    elevationInFeet: 7733,
    milesOfTrail: 900,
    numberOfCampsites: 273,
    climate: 'Temperate',
    yearFounded: 1872,
    annualVisitorCount: 4000000,
    inspirationalQuote: 'The mountains are calling.',
    inspirationalQuoteSource: 'John Muir',
    parkDescription: 'A vast wilderness with geysers and wildlife.',
    entryFee: 35,
    numberOfAnimalSpecies: 67,
    imgCode: 'YSNP',
};

describe('ParkDetailPage', () => {
    beforeEach(() => {
        jest.clearAllMocks();
        mockedUseGetParkDetails.mockReturnValue({
            parkDetail: mockPark,
            isLoading: false,
            error: null,
        });
    });

    it('loads the selected park and displays the details in imperial units by default', () => {
        render(<ParkDetailPage />);

        expect(mockedUseGetParkDetails).toHaveBeenCalledWith({
            id: 'id=YEL',
            caller: 'Park details page',
        });

        expect(screen.getByText('Yellowstone')).toBeInTheDocument();
        expect(screen.getByText('The mountains are calling.')).toBeInTheDocument();
        expect(screen.getByText(/~ John Muir/i)).toBeInTheDocument();
        expect(screen.getByText(/A vast wilderness with geysers and wildlife\./i)).toBeInTheDocument();

        const areaText = screen.getByText(/Area:/i).closest('p');
        expect(areaText?.textContent).toContain('2219791');
        expect(areaText?.textContent).toContain('Acres');

        const elevationText = screen.getByText(/Elevation:/i).closest('p');
        expect(elevationText?.textContent).toContain('7733');
        expect(elevationText?.textContent).toContain('Feet');

        const trailText = screen.getByText(/Trail:/i).closest('p');
        expect(trailText?.textContent).toContain('900');
    });

    it('toggles the displayed units when the Convert units button is clicked', () => {
        render(<ParkDetailPage />);

        const areaTextBefore = screen.getByText(/Area:/i).closest('p');
        expect(areaTextBefore?.textContent).toContain('2219791');
        expect(areaTextBefore?.textContent).toContain('Acres');

        const elevationTextBefore = screen.getByText(/Elevation:/i).closest('p');
        expect(elevationTextBefore?.textContent).toContain('7733');
        expect(elevationTextBefore?.textContent).toContain('Feet');

        fireEvent.click(screen.getByRole('button', { name: /convert units/i }));

        const areaTextAfter = screen.getByText(/Area:/i).closest('p');
        expect(areaTextAfter?.textContent).toContain('Hectares');
        expect(areaTextAfter?.textContent).toContain(String(convertAcresToHectares(mockPark.acreage)));

        const elevationTextAfter = screen.getByText(/Elevation:/i).closest('p');
        expect(elevationTextAfter?.textContent).toContain('Meters');
        expect(elevationTextAfter?.textContent).toContain(String(convertFeetToMeters(mockPark.elevationInFeet)));

        const trailTextAfter = screen.getByText(/Trail:/i).closest('p');
        expect(trailTextAfter?.textContent).toContain('Kilometers');
        expect(trailTextAfter?.textContent).toContain(String(convertMilesToKilometers(mockPark.milesOfTrail)));
    });
});
