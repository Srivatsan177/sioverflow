import { useState } from 'react'
import { UserContext } from './UserContext';
import { User } from '../types/auth/User';

export const UserProvider = ({ children }: { children: React.ReactNode }) => {
    const [user, setUser] = useState<User>({ id: "", username: '', email: '', role: "", avatarUrl: "" });

    return (
        <UserContext.Provider value={{ user, setUser }}>
            {children}
        </UserContext.Provider>
    )
}


