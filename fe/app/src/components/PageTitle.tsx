import { Box, Grid, Typography } from "@material-ui/core";
import React, { ReactNode } from "react";

export const PageTitle = ({
  children,
  paddingBottom
}: {
  children: ReactNode;
  paddingBottom?: any;
}) => {
  return (
    <Box paddingBottom={paddingBottom}>
      <Grid container wrap="wrap" spacing={2} alignContent="center">
        <Grid item xs>
          <Typography component={"div"}>
            <Box fontSize={24} fontWeight={"fontWeightBold"}>
              {children}
            </Box>
          </Typography>
        </Grid>
      </Grid>
    </Box>
  );
};
