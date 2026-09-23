import Typography from '@mui/material/Typography';
import { useEffect, useState } from 'react';
import { useSearchParams } from 'react-router-dom';
import type { Park } from '../types/park';
import { Box, Button, Card, CardContent, CardHeader, CardMedia, Divider, Grid } from '@mui/material';
import { colors } from '../../designTokens/colors';
import { convertAcresToHectares, convertFeetToMeters, convertMilesToKilometers } from '../utils/unit-conversion-utils';

export default function ParkDetailPage() {
    const [searchParams] = useSearchParams();
    const [parkDetail, setParkDetail] = useState<Park>();
    const [isImperial, setIsImperial] = useState<boolean>(true)

    useEffect(() => {
        fetch(`/api/parkDetail?id=${searchParams.get('id')}`)
            .then((res) => {
                if (!res.ok) throw new Error(`/api/parks responded with status ${res.status}`);
                return res.json() as Promise<Park>;
            }).then(setParkDetail).catch((err) => console.error(err.message))
    }, []);

    const handleClick = () => {
        if (isImperial) {
            setIsImperial(false)
        } else {
            setIsImperial(true)
        }
    }

    return (
        <Box sx={{ margin: '1rem' }}>
            <Card sx={{ backgroundColor: colors.mediumGreen, padding: '8px', display: 'flex', flexDirection: 'column', width: { lg: '50%', md: '60%', sm: '80%' }, margin: '32px auto', alignItems: 'center' }}>
                <CardHeader
                    title={parkDetail?.parkName}
                    variant='h1'
                    style={{ textAlign: 'center', textWrap: 'balance', fontSize: '3rem', color: colors.darkBrown }}
                />
                {parkDetail &&
                    <CardMedia >
                        <img style={{ width: '100%' }} src={`/parks/${parkDetail.imgCode}.jpg`} alt={`Photo of ${parkDetail.parkName}`} />
                    </CardMedia>
                }
                <Typography component='span' variant='subtitle1' sx={{ fontStyle: 'italic', textAlign: 'center' }}>
                    {parkDetail && parkDetail.inspirationalQuote}
                </Typography>
                <Typography variant='subtitle2' component='span'>
                    {parkDetail && `~ ${parkDetail.inspirationalQuoteSource}`}
                </Typography>
                <CardContent sx={{ padding: '32px 16px', background: colors.lightGreen, borderRadius: '8px', marginTop: '8px', display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
                    <Typography component='p' sx={{ fontSize: '1rem' }}>
                        {parkDetail && parkDetail.parkDescription}
                    </Typography>
                    <Button sx={{ position: 'relative', bottom: '-1.75rem', fontSize: '0.75rem' }} variant='contained' onClick={handleClick}>Convert units </Button>
                    <Divider sx={{ width: '100%', margin: '16px 0px' }} />
                    <Grid container spacing={2} sx={{ marginTop: '0.5rem' }} >
                        <Grid sx={{ fontSize: '1rem' }} >
                            <Typography >
                                <b>State: </b>{parkDetail && parkDetail.state}
                            </Typography>
                        </Grid>
                        <Grid sx={{ fontSize: '1rem' }}>
                            <Typography>
                                <b>Area: </b>{isImperial ? parkDetail?.acreage : convertAcresToHectares(parkDetail?.acreage || 0)}{isImperial ? ' Acres' : ' Hectares'}
                            </Typography>
                        </Grid>
                        <Grid>
                            <Typography>
                                <b>Elevation: </b>{isImperial ? parkDetail?.elevationInFeet : convertFeetToMeters(parkDetail?.elevationInFeet || 0)}{isImperial ? ' Feet' : '  Meters'}
                            </Typography>
                        </Grid>
                        <Grid>
                            <Typography>
                                <b>{isImperial ? ' Miles' : '  Kilometers'} of Trail: </b>{isImperial ? parkDetail?.milesOfTrail : convertMilesToKilometers(parkDetail?.milesOfTrail || 0)}
                            </Typography>
                        </Grid>
                        <Grid>
                            <Typography>
                                <b>Number of Campsites: </b>{parkDetail && parkDetail.numberOfCampsites}
                            </Typography>
                        </Grid>
                        <Grid>
                            <Typography>
                                <b>Climate: </b>{parkDetail && parkDetail.climate}
                            </Typography>
                        </Grid>
                        <Grid>
                            <Typography>
                                <b>Year Founded: </b>{parkDetail && parkDetail.yearFounded}
                            </Typography>
                        </Grid>
                        <Grid>
                            <Typography>
                                <b>Annual Visitor Count: </b>{parkDetail && parkDetail.annualVisitorCount}
                            </Typography>
                        </Grid>
                        <Grid>
                            <Typography>
                                <b>Entry Fee (USD): </b>${parkDetail && parkDetail.entryFee}
                            </Typography>
                        </Grid>
                        <Grid>
                            <Typography>
                                <b>Number of Animal Species: </b>{parkDetail && parkDetail.numberOfAnimalSpecies}
                            </Typography>
                        </Grid>
                    </Grid>
                </CardContent>
            </Card>
        </Box >
    )
}