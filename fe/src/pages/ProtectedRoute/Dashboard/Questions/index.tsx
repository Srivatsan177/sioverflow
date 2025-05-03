import { Box, FormControl, MenuItem, Pagination, Select } from "@mui/material";
import { useGetQuestions } from "../../../../utils/api/questions/getQuestions";
import { useDashboardContext } from "../hooks/useDashboardContext"
import Question from "./Question";
import { useEffect, useState } from "react";

const Questions = () => {
  const { search } = useDashboardContext();
  const [page, setPage] = useState(0);
  const [paginationCount, setPaginationCount] = useState(1);
  const [size, setSize] = useState(5);
  const { data: questions, isLoading } = useGetQuestions({ params: { search, page, size } });
  useEffect(() => {
    if (paginationCount - 1 === page && questions?.nextUri) {
      setPaginationCount(prev => ++prev);
    }
  }, [page, paginationCount, questions])
  if (isLoading) return <>Loding...</>
  if (!questions) {
    return <>Error loading questions</>
  }
  return (
    <Box>
      {questions.data.length > 0 ? questions.data.map(question => <Question key={question.id} question={question} />) : <>No Data</>}
      <Box
        sx={{
          display: "flex",
          flexDirection: "row",
          justifyContent: "end",
          alignItems: "center",
          gap: 2
        }}
      >
        <FormControl>
          <Select
            onChange={(e) => setSize(e.target.value as number)}
            value={size}
          >
            <MenuItem value={5}>5</MenuItem>
            <MenuItem value={10}>10</MenuItem>
            <MenuItem value={15}>15</MenuItem>
          </Select>
        </FormControl>
        <Pagination
          variant="outlined"
          color="primary"
          onChange={(_, value) => setPage(value - 1)}
          count={paginationCount}
          page={page + 1}
        />
      </Box>
    </Box>
  )
}

export default Questions;