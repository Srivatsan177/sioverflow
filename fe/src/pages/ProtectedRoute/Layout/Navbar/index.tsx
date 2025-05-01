import { AppBar, Avatar, Box, Button, ButtonGroup, IconButton, Menu, MenuItem, Toolbar, Tooltip, Typography } from "@mui/material";
import { useUser } from "../../../../hooks/useUser";
import React from "react";
import { useNavigate } from "react-router";
import { DASHBOARD, PROFILE } from "../../../../constants/routes";

const Navbar = () => {
  const { user } = useUser();
  const [anchorUserEl, setAnchorUserEl] = React.useState<null | HTMLElement>(null);
  const navigate = useNavigate();

  return (
    <Box sx={{ flexGrow: 1, mb: 2 }}>
      <AppBar color="primary" position="static">
        <Toolbar sx={{ flexGrow: 1 }}>
          <IconButton>
            <img src="/logo-white.png" style={{ width: '3rem', height: '3rem' }} alt="logo" />
          </IconButton>
          <ButtonGroup sx={{ flexGrow: 1 }} variant="outlined">
            <Button onClick={() => navigate(DASHBOARD)} color="inherit">Home</Button>
            <Button color="inherit">About</Button>
          </ButtonGroup>
          <Box>
            <Tooltip title="Open settings">
              <IconButton
                size="large"
                aria-label="account of current user"
                aria-controls="menu-appbar"
                aria-haspopup="true"
                onClick={(event: React.MouseEvent<HTMLElement>) => { setAnchorUserEl(event.currentTarget) }}
                color="inherit"
              >
                <Avatar alt={user.username} src={user.avatarUrl} />
              </IconButton>
            </Tooltip>
            <Menu
              sx={{ mt: "45px" }}
              id="menu-appbar"
              anchorEl={anchorUserEl}
              anchorOrigin={{
                vertical: "top",
                horizontal: "right",
              }}
              keepMounted
              transformOrigin={{
                vertical: 'top',
                horizontal: 'right',
              }}
              open={Boolean(anchorUserEl)}
              onClose={() => setAnchorUserEl(null)}
            >
              <MenuItem>
                <Typography
                  onClick={() => {
                    setAnchorUserEl(null)
                    navigate(PROFILE)
                  }}
                >
                  Profile
                </Typography>
              </MenuItem>
            </Menu>
          </Box>
        </Toolbar>
      </AppBar>
    </Box >
  )
}

export default Navbar;