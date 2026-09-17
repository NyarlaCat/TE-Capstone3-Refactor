import Typography from '@mui/material/Typography';
import { useEffect, useState } from 'react';
import { useSearchParams } from 'react-router-dom';

export default function ParkDetailPage() {
    const [searchParams] = useSearchParams();
    const [parkDetail, setParkDetail] = useState(null);


    useEffect(() => {
        fetch(`/api/parkDetail?id=${searchParams.get('id')}`)
            .then((res) => {
                if (!res.ok) throw new Error(`/api/parks responded with status ${res.status}`);
                return res.json();
            }).then(setParkDetail).catch((err) => console.error(err.message))
    }, []);

    return (
        <Typography variant="h4" component="span">
            Park Detail Page {parkDetail ? JSON.stringify(parkDetail) : 'Loading...'}
        </Typography>
    )
}