import { useEffect, useState } from "react";
import type { Park } from '../types/park';

/**
 * Custom hook to fetch parks data from the `/api/parks` endpoint.
 * 
 * @param caller (Optional) A string representing the name of the component or 
 * function calling this hook, used for error logging.
 * 
 * @returns An object containing an array of {@link parks Park} data, loading 
 * state, and error message (if any).
 */
export function useGetParks(caller?: string): { parks: Park[]; loading: boolean; error: string | null } {
    const [parks, setParks] = useState<Park[]>([]);
    const [isLoading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        fetch('/api/parks')
            .then((res) => {
                if (!res.ok) throw new Error(`${caller} - /api/parks responded with status ${res.status}`);
                return res.json() as Promise<Park[]>;
            })
            .then(setParks)
            .catch((err) => setError(err.message))
            .finally(() => setLoading(false));
    }, [caller]);

    return { parks, loading: isLoading, error };
}