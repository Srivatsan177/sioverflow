import { createTheme } from "@mui/material";

const theme = createTheme({
    palette: {
        primary: {
            main: '#1976d2',
            light: '#42a5f5',
            dark: '#0d47a1',
            contrastText: '#fff',
        },
        secondary: {
            main: '#1a1a1a',
            light: '#424242',
            dark: '#0e0e0f',
            contrastText: '#fff',
        },
        error: {
            main: '#f44336',
        },
        warning: {
            main: '#ff9800',
        },
        info: {
            main: '#2196f3',
        },
        success: {
            main: '#4caf50',
        },
        background: {
            default: '#f5f5f5',
            paper: '#ffffff',
        },
        text: {
            primary: '#212121',
            secondary: '#757575',
        },
    },
});

export default theme;
