import { ThemeProvider } from '@emotion/react'
import Welcome from './Welcome'
import theme from './themes/theme'
import "./index.css"

function App() {
  return (
    <ThemeProvider theme={theme}>
      <Welcome />
    </ThemeProvider>
  )
}

export default App
