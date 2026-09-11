import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import type { Park } from '../types/park';
import { Stack } from '@mui/material';

export default function ParkCard({ park }: { park: Park }) {
    return (
        <Card sx={{ backgroundColor: '#D0DBCC', display: 'flex', padding: '8px', flexDirection: { md: 'row', xs: 'column' }, width: '100%' }}>
            <CardMedia>
                <img src={`/parks/${park.imgCode}.jpg`} alt={`Photo of ${park.parkName}`} style={{ width: 'stretch' }} />
            </CardMedia>
            <Stack spacing={2} useFlexGap sx={{ justifyContent: 'space-between', alignItems: 'center' }}>
                <CardContent>
                    <Typography variant='h1' sx={{ fontSize: '2rem', color: '#401502', justifySelf: 'center' }} >{park.parkName}</Typography>
                    <Typography variant='body1' sx={{ fontSize: '1rem', padding: '16px', background: '#DDE3DD', borderRadius: '8px', marginTop: '8px' }}>{park.parkDescription}</Typography>
                </CardContent>
                <CardActions>
                    <Button size='small' href={`/parkDetail?id=${park.parkCode}`} sx={{ color: '#064360' }}>Learn More</Button>
                </CardActions>
            </Stack>
        </Card>
    )
}