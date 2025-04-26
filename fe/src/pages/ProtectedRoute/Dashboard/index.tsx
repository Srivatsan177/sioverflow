import { useUser } from "../../../hooks/useUser";

const Dashboard = () => {
    const { user } = useUser();
    return <h1>Welcome {user.email}</h1>
}

export default Dashboard;