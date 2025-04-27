import { Button, Typography, Box, Paper, ButtonGroup, Stack } from '@mui/material';
import GitHubIcon from '@mui/icons-material/GitHub';
import { setBodyColor } from '../../utils/setBodyColor';
import { GITHUB_LOGIN_URI } from '../../constants/routes';

const Welcome = () => {
  setBodyColor("#87CEEB");
  return (
    <Box
      sx={{
        display: 'flex',
        minHeight: '100vh',
        alignItems: 'center',
        justifyContent: 'center'
      }}
    >
      <Paper
        elevation={3}
        square={false}
      >
        <Stack sx={{ margin: 2, padding: 2 }} spacing={2}>
          <Box
            sx={{
              display: "inline-flex",
              alignItems: "center",
            }}
          >
            <Typography variant='h3'>Welcome to</Typography>
            <img src="/logo.png" style={{ width: '10rem', height: '10rem' }} />
          </Box>
          <Box
            sx={{
              display: 'flex',
              alignItems: 'center',
              justifyContent: 'center',
            }}
          >
            <ButtonGroup variant='contained'>
              <Button onClick={() => window.location.href = GITHUB_LOGIN_URI} color='secondary' startIcon={<GitHubIcon />}>Login</Button>
            </ButtonGroup>
          </Box>
        </Stack>
      </Paper>
    </Box>
  );
}

export default Welcome;
