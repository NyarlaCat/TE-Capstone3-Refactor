import Typography from '@mui/material/Typography';
import { useEffect, useState } from 'react';
import { useSearchParams } from 'react-router-dom';
import type { Park } from '../types/park';
import { Box, Card, CardContent, CardHeader, CardMedia, Divider, Grid } from '@mui/material';
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
                <Typography variant='subtitle1' sx={{ fontStyle: 'italic' }}>
                    {parkDetail && parkDetail.inspirationalQuote}
                </Typography>
                <Typography variant='subtitle2'>
                    {parkDetail && `~ ${parkDetail.inspirationalQuoteSource}`}
                </Typography>
                <CardContent sx={{ padding: '32px 16px', background: colors.lightGreen, borderRadius: '8px', marginTop: '8px' }}>
                    <Typography sx={{ fontSize: '1rem' }}>
                        {parkDetail && parkDetail.parkDescription}
                    </Typography>
                    <Divider sx={{ width: '100%', margin: '16px 0px' }} />
                    <Grid container spacing={2}>
                        <Grid sx={{ fontSize: '1rem' }} >
                            <Typography >
                                <b>State: </b>{parkDetail && parkDetail.state}
                            </Typography>
                        </Grid>
                        <Grid sx={{ fontSize: '1rem' }}>
                            <Typography>
                                <b>Acreage: </b>{parkDetail && parkDetail.acreage}
                            </Typography>
                        </Grid>
                        <Grid>
                            <Typography>
                                <b>Elevation (ft): </b>{parkDetail && parkDetail.elevationInFeet}
                            </Typography>
                        </Grid>
                        <Grid>
                            <Typography>
                                <b>Miles of Trail: </b>{parkDetail && parkDetail.milesOfTrail}
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
                                <b>Entry Fee: </b>${parkDetail && parkDetail.entryFee}
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
        </Box>
    )
}