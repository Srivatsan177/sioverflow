import { BrowserRouter, Routes, Route } from 'react-router';
import Welcome from '../pages/Welcome';
import ProtectedRoute from '../pages/ProtectedRoute';
import NotFound from '../pages/NotFound';
import Dashboard from '../pages/ProtectedRoute/Dashboard';
import Github from '../pages/login/Github';

const Router = () => {
  return <BrowserRouter>
    <Routes>
      <Route path="/">
        <Route index element={<Welcome />} />
        <Route path="/login/github/code" element={<Github />} />

        {/* Protected routes example */}
        <Route path="dashboard" element={
          <ProtectedRoute>
            <Dashboard />
          </ProtectedRoute>
        }>
          <Route index element={<></>} />
        </Route>

        {/* 404 route */}
        <Route path="*" element={<NotFound />} />
      </Route>
    </Routes>
  </BrowserRouter>
}

export default Router;