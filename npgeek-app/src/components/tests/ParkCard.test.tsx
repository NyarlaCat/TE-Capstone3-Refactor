import { render, screen } from '@testing-library/react';
import ParkCard from '../ParkCard';
import type { Park } from '../../types/park';

describe('ParkCard', () => {
    const park: Park = {
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

    describe('UI ', () => {
        it('renders the park name as a heading', () => {
            render(<ParkCard park={park} />);

            expect(screen.getByRole('heading', { name: park.parkName })).toBeInTheDocument();
        });

        it('renders the description', () => {
            render(<ParkCard park={park} />);

            expect(screen.getByText(park.parkDescription)).toBeInTheDocument();
        });

        it('renders the image and alt text', () => {
            render(<ParkCard park={park} />);

            // Get by alt text makes sure the alt text is present and correct and the src attribute is verified to ensure the path is being set correctly. 
            expect(screen.getByRole('img', { name: `Photo of ${park.parkName}` })).toHaveAttribute(
                'src',
                `/parks/${park.imgCode}.jpg`
            );
        });

        it('renders "learn more" link', () => {
            render(<ParkCard park={park} />);

            expect(screen.getByRole('link', { name: 'Learn More' })).toHaveAttribute(
                'href',
                `/parkDetail?id=${park.parkCode}`
            );
        });
    });
});
