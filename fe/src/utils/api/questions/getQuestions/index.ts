import { useQuery, UseQueryOptions } from "@tanstack/react-query";
import appClient, { api } from "../../appClient";
import { QuestionSearchParam } from "../../../../pages/ProtectedRoute/Dashboard/types/QuestionSearchParam";
import { QuestionsResponse } from "../../../../types/questions/QuestionsResponse";

const getQuestions = async (params: QuestionSearchParam): Promise<QuestionsResponse> => {
  try {
    const response = await appClient.get(api.getQuestions, { params });
    return response.data;
  } catch (error) {
    return Promise.reject(error);
  }
}

const useGetQuestions = ({ params, ...options }: { params: QuestionSearchParam, options?: UseQueryOptions<QuestionsResponse> }) => {
  return useQuery({
    queryKey: ['questions', params],
    queryFn: () => getQuestions(params),
    retry: false,
    ...options
  })
}

export { useGetQuestions };
export default getQuestions;
