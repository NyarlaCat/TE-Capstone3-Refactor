import { Box, Divider, Link } from "@mui/material";
import { colors } from "../../designTokens/colors";

export default function Header() {
    return (
        <Box sx={{ background: colors.lightGreen, position: 'sticky', top: 0, zIndex: 1, boxShadow: `0px 5px 10px ${colors.darkBrown}` }}>
            <img src="logo.png" alt="Header Image" style={{ width: '30%' }} />
            <Divider />
            <Box sx={{ padding: '4px 0px' }}>
                <Link href="/" sx={{ color: colors.darkBlue, fontSize: '1.5rem', margin: '0 .75rem 0 16px' }} underline="hover"> Home </Link>
                <Link href="/survey" sx={{ color: colors.darkBlue, fontSize: '1.5rem', margin: '0 .75rem' }} underline="hover" > Survey </Link>
            </Box>
        </Box>
    )
}