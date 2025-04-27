import { createTheme } from "@mui/material";

const theme = createTheme({
    palette: {
        primary: {
            main: '#5941A9',
            light: '#7A6BCF',
            dark: '#3F2F7F',
            contrastText: '#F7F7F7',
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
