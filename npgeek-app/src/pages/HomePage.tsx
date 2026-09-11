import { useEffect } from 'react';
import ParkCard from '../components/ParkCard';
import { Skeleton, Stack } from '@mui/material';
import { useGetParks } from '../hooks/useGetParks';

export default function HomePage() {
  const { parks, loading: isLoading, error } = useGetParks('HomePage');

  useEffect(() => {
    if (error) {
      console.error(error);
    }
  }, [error]);

  if (error) return <p>Error loading parks: {error}</p>;

  return (
    <main style={{width: '80%', margin: '0 auto'}} >
      {loading ? (
        <Skeleton variant="rectangular" width='300px' height='500px' sx={{ backgroundColor: '#D0DBCC', borderRadius: '8px' }} />
      ) : (
      <Stack spacing={2} sx={{ alignItems: 'center' }}>
        {parks.map((park) => (
          <ParkCard key={park.parkCode} park={park} />
        ))}
      </Stack>)}
    </main>
  );
}