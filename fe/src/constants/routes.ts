export const WELCOME = '/';
export const DASHBOARD = '/dashboard';
export const GITHUB_LOGIN_URI = 'https://github.com/login/oauth/authorize?client_id=Ov23liA2Hr0kEPO2EaZ8&redirect_uri=http%3A%2F%2Flocalhost%3A5173%2Flogin%2Fgithub%2Fcode';
export const PROFILE = `${DASHBOARD}/profile`;
export const QUESTION_DETAIL = (id: string) => `${DASHBOARD}/questions/${id}`;
export const NEW_QUESTION = `${DASHBOARD}/questions/new`;