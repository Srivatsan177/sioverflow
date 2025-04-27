import axios from "axios";
import { Cookies } from "react-cookie";
import { GITHUB_LOGIN_URI } from "../../../constants/routes";

const cookies = new Cookies();

const axiosClient = axios.create({
    baseURL: import.meta.env.VITE_API_URL || 'http://localhost:8080',
    headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json'
    },
    timeout: 10000 // 10 seconds
});

axiosClient.interceptors.request.use(
    (config) => {
        // Get the token from cookies
        const token = cookies.get('github_access_token');
        // If token exists, add it to the headers
        if (token && token !== "undefined" && token !== "null") {
            config.headers.Authorization = `Bearer ${token}`;
        }

        return config;
    },
    (error) => {
        return Promise.reject(error);
    }
);

axiosClient.interceptors.response.use(
    (response) => {
        return response;
    },
    async (error) => {
        console.debug(error);
        // Handle 401 errors (unauthorized) - could be used for token refresh
        if (error.response && [401, 403].includes(error.response.status)) {

            try {
                // You could implement token refresh logic here
                // const refreshToken = Cookies.get('refreshToken');
                // const response = await refreshAuthToken(refreshToken);
                // const newToken = response.data.token;
                // Cookies.set('authToken', newToken);
                // originalRequest.headers.Authorization = `Bearer ${newToken}`;
                // return axiosClient(originalRequest);

                cookies.remove('github_access_token');
                
                window.location.href = GITHUB_LOGIN_URI;

                // For now, just clear the token and reject
            } catch (refreshError) {
                // Handle refresh token failure (e.g., redirect to login)
                console.error('Token refresh failed:', refreshError);
            }
        }
        return Promise.reject(error);
    }
);

export const api = {
    getUser: "/user/info",
    getAccessToken: (code: string) => `/auth/code/github?code=${code}`
}

export default axiosClient;