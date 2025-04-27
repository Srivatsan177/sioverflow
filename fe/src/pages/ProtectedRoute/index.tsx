import { Navigate } from "react-router";
import { useGetUser } from "../../utils/api/auth/user/getUser";
import { JSX, useEffect } from "react";
import { useUser } from "../../hooks/useUser";
import Navbar from "./Layout/Navbar";

const ProtectedRoute = ({ children }: { children: JSX.Element }) => {
    const { user, setUser } = useUser();
    const { data: userResponse, isLoading } = useGetUser({});

    useEffect(() => {
        if (user.email === "" && userResponse) {
            setUser(userResponse);
        }
    }, [setUser, user.email, userResponse])

    if (isLoading) {
        return <>Loding...</>
    }
    if (userResponse === undefined) {
        return <Navigate to="/login/github" />
    }

    return <>
        <Navbar />
        {children}
    </>;
}

export default ProtectedRoute;