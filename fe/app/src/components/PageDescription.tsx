import { Box, Grid, Typography } from "@material-ui/core";
import React, { ReactNode } from "react";

export const PageDescription = ({ children }: { children: ReactNode }) => {
  return (
    <Box marginBottom="30px">
      <Grid container wrap="wrap" alignContent="flex-start">
        <Grid item xs>
          <Typography component={"div"}>
            <Box textAlign="left">
              {children}
            </Box>
          </Typography>
        </Grid>
      </Grid>
    </Box>
  );
};
