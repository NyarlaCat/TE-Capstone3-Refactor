import { useEffect } from 'react';
import ParkCard from '../components/ParkCard';
import { Skeleton, Stack } from '@mui/material';
import { useGetParks } from '../hooks/useGetParks';
import { colors } from '../../designTokens/colors';

export default function HomePage() {
  const { parks, loading: isLoading, error } = useGetParks('HomePage');

  useEffect(() => {
    if (error) {
      console.error(error);
    }
  }, [error]);

  if (error) return <p>Error loading parks: {error}</p>;

  return (
    <main style={{ width: '80%', margin: '0 auto' }} >
      <Stack spacing={2} sx={{ alignItems: 'center' }}>
        {isLoading ? (
          <>
            <Skeleton variant="rectangular" width='100%' height='350px' sx={{ backgroundColor: colors.mediumGreen, borderRadius: '8px' }} />
            <Skeleton variant="rectangular" width='100%' height='350px' sx={{ backgroundColor: colors.mediumGreen, borderRadius: '8px' }} />
          </>
        ) : (
          parks.map((park) => (
            <ParkCard key={park.parkCode} park={park} />
          ))
        )
        }
      </Stack>

    </main>
  );
}