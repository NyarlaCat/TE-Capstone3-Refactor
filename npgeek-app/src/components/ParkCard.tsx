import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import type { Park } from '../types/park';
import { Stack } from '@mui/material';
import { colors } from '../../designTokens/colors';

export default function ParkCard({ park }: { park: Park }) {
    return (
        <Card data-testid="park-card" sx={{ backgroundColor: colors.mediumGreen, display: 'flex', padding: '8px', flexDirection: { lg: 'row', xs: 'column' }, width: '100%', alignItems: 'center' }}>
            <CardMedia>
                <img src={`/parks/${park.imgCode}.jpg`} alt={`Photo of ${park.parkName}`} style={{ width: 'stretch' }} />
            </CardMedia>
            <Stack spacing={2} useFlexGap sx={{ justifyContent: 'space-between', alignItems: 'center' }}>
                <CardContent sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }} >
                    <Typography variant='h1' sx={{ fontSize: '2rem', color: colors.darkBrown, justifySelf: 'center' }} >{park.parkName}</Typography>
                    <Typography variant='body1' sx={{ fontSize: '1rem', padding: '32px 16px', background: colors.lightGreen, borderRadius: '8px', marginTop: '8px' }}>{park.parkDescription}</Typography>
                </CardContent>
                <CardActions>
                    <Button size='small' href={`/parkDetail?id=${park.parkCode}`} sx={{ color: colors.darkBlue }}>Learn More</Button>
                </CardActions>
            </Stack>
        </Card>
    )
}