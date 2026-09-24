import { renderHook, waitFor } from '@testing-library/react';
import { useGetParkDetails } from '../useGetParkDetails';
import type { Park } from '../../types/park';

const mockParkDetail: Park = {
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

describe('useGetParkDetails', () => {
    beforeEach(() => {
        jest.resetAllMocks();
        globalThis.fetch = jest.fn() as jest.Mock;
    });

    afterEach(() => {
        jest.restoreAllMocks();
        delete (globalThis as { fetch?: typeof fetch }).fetch;
    });

    it('returns park details when successful', async () => {
        (globalThis.fetch as jest.Mock).mockResolvedValue({
            ok: true,
            json: async () => mockParkDetail,
        });

        const { result } = renderHook(() =>
            useGetParkDetails({ id: 'YEL', caller: 'ParkDetailPage' })
        );

        expect(result.current.isLoading).toBe(true);
        expect(result.current.parkDetail).toBeNull();
        expect(result.current.error).toBeNull();

        await waitFor(() => {
            expect(result.current.isLoading).toBe(false);
        });

        expect(result.current.parkDetail).toEqual(mockParkDetail);
        expect(result.current.error).toBeNull();
    });

    it('returns an error when the fetch fails', async () => {
        (globalThis.fetch as jest.Mock).mockResolvedValue({
            ok: false,
            status: 500,
        });

        const { result } = renderHook(() =>
            useGetParkDetails({ id: 'YEL', caller: 'ParkDetailPage' })
        );

        await waitFor(() => {
            expect(result.current.isLoading).toBe(false);
        });

        expect(result.current.parkDetail).toBeNull();
        expect(result.current.error).toBe('ParkDetailPage - /api/parks responded with status 500');
    });

    it('keeps the loading state true until the fetch resolves', async () => {
        let resolveFetch!: (value: unknown) => void;

        (globalThis.fetch as jest.Mock).mockImplementation(
            () =>
                new Promise((resolve) => {
                    resolveFetch = resolve;
                })
        );

        const { result } = renderHook(() =>
            useGetParkDetails({ id: 'YEL', caller: 'ParkDetailPage' })
        );

        expect(result.current.isLoading).toBe(true);
        expect(result.current.parkDetail).toBeNull();
        expect(result.current.error).toBeNull();

        resolveFetch!({
            ok: true,
            json: async () => mockParkDetail,
        });

        await waitFor(() => {
            expect(result.current.isLoading).toBe(false);
        });
    });
});
