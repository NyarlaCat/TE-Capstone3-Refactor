import Typography from '@mui/material/Typography';
import { useEffect, useState } from 'react';
import { useSearchParams } from 'react-router-dom';
import type { Park } from '../types/park';
import { Box } from '@mui/material';

export default function ParkDetailPage() {
    const [searchParams] = useSearchParams();
    const [parkDetail, setParkDetail] = useState<Park>();


    useEffect(() => {
        fetch(`/api/parkDetail?id=${searchParams.get('id')}`)
            .then((res) => {
                if (!res.ok) throw new Error(`/api/parks responded with status ${res.status}`);
                return res.json() as Promise<Park>;
            }).then(setParkDetail).catch((err) => console.error(err.message))
    }, []);

    return (
        <Box>

            <Typography variant="h4" component="span">
                Park Detail Page
            </Typography>
            <Typography>
                {parkDetail && parkDetail.parkName}
            </Typography>
        </Box>
    )
}