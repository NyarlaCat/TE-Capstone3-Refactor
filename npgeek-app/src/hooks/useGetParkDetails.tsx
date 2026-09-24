import { useEffect, useState } from "react";
import type { Park } from "../types/park";

export const useGetParkDetails = (args: { id: string, caller?: string }): { parkDetail: Park | null; isLoading: boolean; error: string | null } => {
    const { id, caller } = args
    const [parkDetail, setParkDetail] = useState<Park | null>(null);
    const [isLoading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        fetch(`/api/parkDetail?id=${id}`)
            .then((res) => {
                if (!res.ok) throw new Error(`${caller} - /api/parks responded with status ${res.status}`);
                return res.json() as Promise<Park>;
            })
            .then(setParkDetail)
            .catch((err) => setError(err.message))
            .finally(() => setLoading(false));
    }, []);

    return {
        parkDetail,
        isLoading,
        error
    }
}