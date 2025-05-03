import { BrowserRouter, Routes, Route, Outlet } from 'react-router';
import Welcome from '../pages/Welcome';
import ProtectedRoute from '../pages/ProtectedRoute';
import NotFound from '../pages/NotFound';
import Github from '../pages/login/Github';
import { DASHBOARD, NEW_QUESTION, PROFILE } from '../constants/routes';
import Profile from '../pages/ProtectedRoute/Profile';
import Dashboard from '../pages/ProtectedRoute/Dashboard';
import QuestionDetail from '../pages/ProtectedRoute/QuestionDetail';
import NewQuestion from '../pages/ProtectedRoute/NewQuestion';

const Router = () => {
  return <BrowserRouter>
    <Routes>
      <Route path="/">
        <Route index element={<Welcome />} />
        <Route path="/login/github/code" element={<Github />} />

        {/* Protected routes example */}
        <Route path={DASHBOARD} element={
          <ProtectedRoute>
            <Outlet />
          </ProtectedRoute>
        }>
          <Route index element={<Dashboard />} />
          <Route path={PROFILE} element={<Profile />} />
          <Route path={"/dashboard/questions/:id"} element={<QuestionDetail />} />
          <Route path={NEW_QUESTION} element={<NewQuestion />} />
        </Route>

        {/* 404 route */}
        <Route path="*" element={<NotFound />} />
      </Route>
    </Routes>
  </BrowserRouter>
}

export default Router;