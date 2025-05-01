import React, { useState } from 'react'
import DashboardContext from '../DashboardContext'



const DashboardContextProvider: React.FC<{ children: React.ReactNode }> = ({
  children,
}) => {
  const [search, setSearch] = useState<string>('');
  const [tags, setTags] = useState<string[]>([]);

  return (
    <DashboardContext.Provider value={{ search, setSearch, tags, setTags }}>
      {children}
    </DashboardContext.Provider>
  )
}
export default DashboardContextProvider;
