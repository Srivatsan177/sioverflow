import { createContext } from "react"

interface DashboardContextProps {
  search: string;
  setSearch: React.Dispatch<React.SetStateAction<string>>;
  tags: string[];
  setTags: React.Dispatch<React.SetStateAction<string[]>>;
}

const DashboardContext = createContext<DashboardContextProps | undefined>(
  undefined,
)

export default DashboardContext;