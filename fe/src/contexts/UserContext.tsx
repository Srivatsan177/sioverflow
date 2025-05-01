import { createContext } from 'react';
import { User } from '../types/auth/User';

export type IUserContext = {
    user: User;
    setUser: (user: User) => void
}


export const UserContext = createContext<IUserContext>({
    user: { id: "", username: '', email: '', role: "", avatarUrl: "" },
    setUser: () => { },
});
