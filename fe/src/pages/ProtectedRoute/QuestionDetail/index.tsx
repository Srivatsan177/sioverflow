import { useParams } from "react-router";
import { useGetQuestion } from "../../../utils/api/questions/getQuestion";
import { Avatar, Box, Divider, Stack, Typography } from "@mui/material";

const QuestionDetail = () => {
  const { id } = useParams<{ id: string }>();
  const { data: question, isLoading } = useGetQuestion({ id: id ?? "" });
  if (isLoading) return <>Loading...</>
  if (!question) return <>Unable to load question</>
  return <>
    <Stack
      sx={{
        gap: 3
      }}
    >
      <Box
        sx={{
          display: "flex",
          flexDirection: "column",
          gap: 3,
          border: "0.3vh solid",
          p: 2,
          borderColor: "primary.dark"
        }}
      >
        <Box
          sx={{
            display: "flex",
            flexDirection: "row",
            gap: 3,
            alignItems: "center",
          }}
        >
          <Avatar alt={question.author.username} src={question.author.avatarUrl} />
          <Typography variant="h4">{question.title}</Typography>
        </Box>
        <Typography sx={{ display: "flex", justifyContent: "flex-end" }}>~{question.author.username}</Typography>
      </Box>
      <Box
        sx={{
          display: "flex",
          flexDirection: "column",
          gap: 3,
          border: "0.3vh solid",
          p: 2,
          borderColor: "primary.dark"
        }}
      >
        <Typography variant="body1">{question.body}</Typography>
      </Box>
      <Divider />
    </Stack>
  </>
}

export default QuestionDetail;