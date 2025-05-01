import { useGetQuestions } from "../../../../utils/api/questions/getQuestions";
import { useDashboardContext } from "../hooks/useDashboardContext"

const Questions = () => {
  const { search } = useDashboardContext();
  const { data: questions, isLoading } = useGetQuestions({ params: { search } });
  if (isLoading) return <>Loding...</>
  if (!questions) {
    return <>Error loading questions</>
  }
  return (
    <>

    </>
  )
}

export default Questions;