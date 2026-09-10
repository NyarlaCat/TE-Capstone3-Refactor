import { useEffect, useState } from 'react';
import type { Park } from '../types/park';
import ParkCard from '../components/ParkCard';
import { Stack } from '@mui/material';

export default function HomePage() {
  const [parks, setParks] = useState<Park[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    fetch('/api/parks')
      .then((res) => {
        if (!res.ok) throw new Error(`HTTP ${res.status}`);
        return res.json() as Promise<Park[]>;
      })
      .then(setParks)
      .catch((err) => setError(err.message))
      .finally(() => setLoading(false));
  }, []);

  if (loading) return <p>Loading parks…</p>;
  if (error) return <p>Error loading parks: {error}</p>;

  return (
    <main style={{width: '80%', margin: '0 auto'}} >
      <Stack spacing={2} sx={{alignItems: 'center'}}>
        {parks.map((park) => (
          <ParkCard key={park.parkCode} park={park} />
        ))}
        </Stack>
    </main>
  );
}