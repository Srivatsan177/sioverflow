import { useState } from 'react'
import { UserContext } from './UserContext';
import { User } from '../types/auth/User';

export const UserProvider = ({ children }: { children: React.ReactNode }) => {
    const [user, setUser] = useState<User>({ username: '', email: '' });

    return (
        <UserContext.Provider value={{ user, setUser }}>
            {children}
        </UserContext.Provider>
    )
}


