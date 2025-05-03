import { Avatar, Box, Paper, Typography } from "@mui/material";
import { Question as QuestionType } from "../../../../../types/questions/Question";
import { QUESTION_DETAIL } from "../../../../../constants/routes";
import { useNavigate } from "react-router";

const Question = ({ question }: { question: QuestionType }) => {
  const navigate = useNavigate();
  return (
    <Paper
      elevation={4}
      sx={{
        my: 2
      }}
    >
      <Box
        sx={{
          mx: 2,
          p: 2,
          display: "flex",
          flexDirection: "row",
          gap: 3,
          cursor: "pointer"
        }}
        onClick={() => navigate(QUESTION_DETAIL(question.id))}
      >
        <Avatar alt={question.author.username} src={question.author.avatarUrl} />
        <Typography variant="h5">{question.title}</Typography>
      </Box>

    </Paper>
  );
};

export default Question;