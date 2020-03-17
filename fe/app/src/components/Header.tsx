import { Box, Grid, Hidden, Typography } from "@material-ui/core";
import { makeStyles } from "@material-ui/core/styles";
import React from "react";

const PhoneNumBox = () => (
  <Box display="inline-flex" alignItems="center">
    <Typography>800 123 456</Typography>
  </Box>
);

const useStyles = makeStyles(theme => ({
  container: {
    [theme.breakpoints.only("xs")]: {
      justifyContent: "center"
    }
  }
}));

export const Header = () => {
  const classes = useStyles();
  return (
    <Box width="100%"  paddingTop="20px">
      <Grid
        container
        className={classes.container}
        justify="space-between"
        alignItems="center"
      >
        <Grid item>
          <Box height="40px" width="auto">
            LOGO
          </Box>
        </Grid>
        <Hidden xsDown>
          <Grid item>
            <PhoneNumBox />
          </Grid>
        </Hidden>
      </Grid>
    </Box>
  );
};
