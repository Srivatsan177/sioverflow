import { useQuery, UseQueryOptions } from "@tanstack/react-query";
import { User } from "../../../../types/auth/User";
import appClient, { api } from "../../appClient";

const getUser = async (): Promise<User> => {
    try {
        const response = await appClient.get(api.getUser);
        return response.data.data[0]
    } catch (e) {
        return Promise.reject(e);
    }
}

export const useGetUser = ({ ...options }: { options?: UseQueryOptions<User> }) => useQuery({
    queryKey: ['user'],
    queryFn: getUser,
    retry: false,
    ...options,
})

export default getUser;