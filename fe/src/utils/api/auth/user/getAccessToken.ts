import { useQuery, UseQueryOptions } from "@tanstack/react-query";
import { AccessToken } from "../../../../types/auth/AccessToken";
import appClient, { api } from "../../appClient";

const getAccessToken = async (code: string): Promise<AccessToken> => {
    try {
        const response = await appClient.get<AccessToken>(api.getAccessToken(code));
        return response.data;
    } catch (error) {
        return Promise.reject(error);
    }
}

export const useGetAccessToken = ({ code, ...options }: { code: string, options?: UseQueryOptions<AccessToken> }) => {
    return useQuery({
        queryKey: ['accessToken'],
        queryFn: () => getAccessToken(code),
        retry: false,
        ...options
    })
}