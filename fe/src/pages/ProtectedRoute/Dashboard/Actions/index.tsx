import { Box, Button } from "@mui/material";
import { useNavigate } from "react-router";
import { NEW_QUESTION } from "../../../../constants/routes";

const Actions = () => {
  const navigate = useNavigate();
  return (
    <Box
      sx={{
        display: "flex",
        flexDirection: "row",
        gap: 2,
        justifyContent: "start",
        alignItems: "center",
      }}
    >
      <Button
        variant="outlined"
        color="info"
        onClick={() => { navigate(NEW_QUESTION) }}
      >
        Ask New Question ?
      </Button>
    </Box>
  );
}

export default Actions;