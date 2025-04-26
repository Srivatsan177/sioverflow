import { ThemeProvider } from '@emotion/react'
import theme from './themes/theme'
import "./index.css"
import { CookiesProvider } from 'react-cookie'
import Router from './Router'
import { QueryClient, QueryClientProvider } from '@tanstack/react-query'
import { UserProvider } from './contexts/UserProvider'

function App() {
  const queryClient = new QueryClient({
    defaultOptions: {
      queries: {
        refetchOnWindowFocus: false,
        retry: false,
      }
    }
  });
  return (
    <ThemeProvider theme={theme}>
      <QueryClientProvider client={queryClient}>
        <UserProvider>
          <CookiesProvider defaultSetOptions={{ path: '/' }}>
            <Router />
          </CookiesProvider>
        </UserProvider>
      </QueryClientProvider>
    </ThemeProvider>
  )
}

export default App
