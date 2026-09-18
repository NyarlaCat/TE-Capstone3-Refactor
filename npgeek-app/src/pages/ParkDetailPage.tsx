import Typography from '@mui/material/Typography';
import { useEffect, useState } from 'react';
import { useSearchParams } from 'react-router-dom';
import type { Park } from '../types/park';
import { Box, Card, CardContent, CardHeader, CardMedia } from '@mui/material';
import { colors } from '../../designTokens/colors';

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
            <Card sx={{ backgroundColor: colors.mediumGreen, padding: '8px', display: 'flex', flexDirection: 'column', width: '50%', margin: '32px auto', alignItems: 'center' }}>
                <CardHeader
                    title={parkDetail?.parkName}
                    variant='h1'
                />
                {parkDetail &&
                    <CardMedia >
                        <img src={`/parks/${parkDetail.imgCode}.jpg`} alt={`Photo of ${parkDetail.parkName}`} />
                    </CardMedia>
                }
                <CardContent>
                    <Typography variant='subtitle1' sx={{ fontStyle: 'italic' }}>
                        {parkDetail && parkDetail.inspirationalQuote}
                    </Typography>
                    <Typography variant='subtitle2'>
                        {parkDetail && `~ ${parkDetail.inspirationalQuoteSource}`}
                    </Typography>

                </CardContent>
            </Card>

            <Typography>
                State: {parkDetail && parkDetail.state}
            </Typography>
            <Typography>
                Park Description: {parkDetail && parkDetail.parkDescription}
            </Typography>
            <Typography>
                Acreage: {parkDetail && parkDetail.acreage}
            </Typography>
            <Typography>
                Elevation (ft): {parkDetail && parkDetail.elevationInFeet}
            </Typography>
            <Typography>
                Miles of Trail: {parkDetail && parkDetail.milesOfTrail}
            </Typography>
            <Typography>
                Number of Campsites: {parkDetail && parkDetail.numberOfCampsites}
            </Typography>
            <Typography>
                Climate: {parkDetail && parkDetail.climate}
            </Typography>
            <Typography>
                Year Founded: {parkDetail && parkDetail.yearFounded}
            </Typography>
            <Typography>
                Annual Visitor Count: {parkDetail && parkDetail.annualVisitorCount}
            </Typography>
            <Typography>
                Entry Fee: {parkDetail && parkDetail.entryFee}
            </Typography>
            <Typography>
                Number of Animal Species: {parkDetail && parkDetail.numberOfAnimalSpecies}
            </Typography>
        </Box>
    )
}