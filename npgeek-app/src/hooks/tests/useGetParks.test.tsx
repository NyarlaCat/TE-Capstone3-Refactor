import { renderHook, waitFor } from '@testing-library/react';
import { useGetParks } from '../useGetParks';
import type { Park } from '../../types/park';

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
];

describe('useGetParks', () => {
    beforeEach(() => {
        jest.resetAllMocks();
        globalThis.fetch = jest.fn() as jest.Mock;
    });

    afterEach(() => {
        jest.restoreAllMocks();
        delete (globalThis as { fetch?: typeof fetch }).fetch;
    });

    it('returns parks when successful', async () => {
        (globalThis.fetch as jest.Mock).mockResolvedValue({
            ok: true,
            json: async () => mockParks,
        });

        const { result } = renderHook(() => useGetParks('Test'));

        expect(result.current.loading).toBe(true);
        expect(result.current.parks).toEqual([]);
        expect(result.current.error).toBeNull();

        await waitFor(() => {
            expect(result.current.loading).toBe(false);
        });

        expect(result.current.parks).toEqual(mockParks);
        expect(result.current.error).toBeNull();
    });

    it('returns error when unsuccessful', async () => {
        (globalThis.fetch as jest.Mock).mockResolvedValue({
            ok: false,
            status: 500,
        });

        const { result } = renderHook(() => useGetParks('Test'));

        await waitFor(() => {
            expect(result.current.loading).toBe(false);
        });

        expect(result.current.parks).toEqual([]);
        expect(result.current.error).toBe('Test - /api/parks responded with status 500');
    });

    it('returns loading state while fetching: is true while fetching and becomes false when fetch completes', async () => {
        let resolveFetch!: (value: unknown) => void;

        (globalThis.fetch as jest.Mock).mockImplementation(
            () =>
                new Promise((resolve) => {
                    resolveFetch = resolve;
                })
        );

        const { result } = renderHook(() => useGetParks('Test'));

        expect(result.current.loading).toBe(true);
        expect(result.current.parks).toEqual([]);
        expect(result.current.error).toBeNull();

        resolveFetch!({
            ok: true,
            json: async () => mockParks,
        });

        await waitFor(() => {
            expect(result.current.loading).toBe(false);
        });
    });
});