import { Box, Button, FormControl, TextField } from "@mui/material";
import { useForm } from "react-hook-form";
import { useDashboardContext } from "../hooks/useDashboardContext";
import { searchSchema } from "../validators/searchValidators";
import { yupResolver } from "@hookform/resolvers/yup";
import initialSearchData from "../data/initialSearchData";
import { Search as SearchIcon } from "@mui/icons-material";

const SearchBar = () => {
  const { register, handleSubmit } = useForm(
    {
      resolver: yupResolver(searchSchema),
      defaultValues: { ...initialSearchData }
    }
  );
  const { setSearch } = useDashboardContext();
  const onSubmit = handleSubmit(data => {
    if (data.search !== undefined) {
      setSearch(data.search);
    }
  });
  return (
    <FormControl>
      <form onSubmit={onSubmit}>
        <Box
          sx={{
            display: "flex",
            flexDirection: "row",
            gap: 2
          }}
        >
          <TextField
            {...register('search')}
            placeholder="Search"
            sx={{ flexGrow: 1 }}
          />
          <Button variant="contained" aria-label="search" type="submit">
            <SearchIcon />
          </Button>
        </Box>
      </form>
    </FormControl>
  )
}

export default SearchBar;