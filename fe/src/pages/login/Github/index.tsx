import { useCookies } from "react-cookie";
import { useNavigate, useSearchParams } from "react-router"
import { useGetAccessToken } from "../../../utils/api/auth/user/getAccessToken";
import { useEffect } from "react";

const Github = () => {
    const [searchParams] = useSearchParams();
    const code = searchParams.get('code');
    const [, setCookie] = useCookies(['github_access_token']);
    const { data: accessToken } = useGetAccessToken({ code: (code as string) ?? "" });
    const navigate = useNavigate();
    useEffect(() => {
        if (accessToken && accessToken.accessToken) {
            setCookie('github_access_token', accessToken.accessToken);
            navigate('/dashboard');
        }
    }, [accessToken, navigate, setCookie])
    return <>Logging you in</>;
}

export default Github