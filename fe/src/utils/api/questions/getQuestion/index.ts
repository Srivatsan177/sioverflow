import { useQuery, UseQueryOptions } from "@tanstack/react-query";
import { Question } from "../../../../types/questions/Question";
import appClient, { api } from "../../appClient";

export const getQuestion = async (id: string): Promise<Question> => {
  try {
    const response = await appClient.get(api.getQuestion(id))
    return response.data.data[0]
  } catch (error) {
    return Promise.reject(error);
  }
}

export const useGetQuestion = ({ id, ...options }: { id: string, options?: UseQueryOptions<Question> }) => {
  return useQuery({
    queryKey: [api.getQuestion(id)],
    queryFn: () => getQuestion(id),
    ...options
  })
}
