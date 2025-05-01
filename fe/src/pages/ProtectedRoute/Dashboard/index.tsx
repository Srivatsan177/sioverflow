import { Stack } from "@mui/material";
import DashboardContextProvider from "./contexts/DashboardContextProvider";
import SearchBar from "./SearchBar";
import Questions from "./Questions";

const Dashboard = () => {
  return (
    <DashboardContextProvider>
      <Stack sx={{ gap: 2 }}>
        <SearchBar />
        <Questions />
      </Stack>
    </DashboardContextProvider>
  );
}

export default Dashboard;