import { User } from "../auth/User";

export type Question = {
  id: string;
  title: string;
  tags?: string[];
  body: string;
  author: User;
}