import { render, screen } from '@testing-library/react';
import HomePage from '../HomePage';
import { useGetParks } from '../../hooks/useGetParks';
import type { Park } from '../../types/park';

jest.mock('../../hooks/useGetParks');

const mockedUseGetParks = jest.mocked(useGetParks);

const mockParks: Park[] = [
    {
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
    },
    {
        parkCode: 'GRCA',
        parkName: 'Grand Canyon',
        state: 'Arizona',
        acreage: 190261,
        elevationInFeet: 6865,
        milesOfTrail: 120,
        numberOfCampsites: 0,
        climate: 'Hot desert',
        yearFounded: 1919,
        annualVisitorCount: 5000000,
        inspirationalQuote: 'It is the grandest canyon of them all.',
        inspirationalQuoteSource: 'John Wesley Powell',
        parkDescription: 'A breathtaking canyon carved by the Colorado River.',
        entryFee: 35,
        numberOfAnimalSpecies: 447,
        imgCode: 'GRCA',
    },
];

describe('HomePage', () => {
    beforeEach(() => {
        jest.clearAllMocks();
    });

    describe('UI', () => {
        it('shows an error message if the API fails', () => {
            mockedUseGetParks.mockReturnValue({
                parks: [],
                loading: false,
                error: 'Failed to load parks',
            });

            render(<HomePage />);

            expect(screen.getByText('Error loading parks: Failed to load parks')).toBeInTheDocument();
        });

        it('shows skeletons while loading', () => {
            mockedUseGetParks.mockReturnValue({
                parks: [],
                loading: true,
                error: null,
            });

            render(<HomePage />);

            expect(document.querySelectorAll('.MuiSkeleton-root')).toHaveLength(2);
        });

        it('shows park cards if the API succeeds', () => {
            mockedUseGetParks.mockReturnValue({
                parks: mockParks,
                loading: false,
                error: null,
            });

            render(<HomePage />);

            expect(screen.getAllByTestId('park-card')).toHaveLength(mockParks.length);

        });
    });
});