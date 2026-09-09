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
        <Card sx={{ display: 'flex'}}>
            <CardMedia>
                <img src={`/parks/${park.imgCode}.jpg`} alt={`Photo of ${park.parkName}`} />
            </CardMedia>
            <Stack direction='column' spacing={2}>
            <CardContent>
                <Typography variant='h1' sx={{fontSize: '2rem', color: '#000000'}} >{park.parkName}</Typography>
                <Typography variant='body1' sx={{fontSize: '1rem'}}>{park.parkDescription}</Typography>
            </CardContent>
            <CardActions>
                <Button size='small' href={`/parkDetail?id=${park.parkCode}`}>Learn More</Button>
            </CardActions>
            </Stack>
        </Card>
    )
}