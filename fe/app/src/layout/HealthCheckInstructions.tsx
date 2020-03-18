import { Box, Divider, Grid, Typography } from "@material-ui/core";
import React from "react";
import { Layout } from "../components/Layout";
import { PageTitle } from "../components/PageTitle";

export const HealthCheckInstructions = () => {
  return (
    <Layout>
      <PageTitle paddingBottom={"30px"}>Žádost o otestování - pokyny</PageTitle>
      <Grid container>
        <Grid item xs={12}>
          <Typography component={"div"}>
            <Box textAlign="left" paddingBottom={"15px"}>
              Prosím dostavte se v době 9:00-18:00 na odběrné místo na adresu
              XYZ do stanu č. 3.
            </Box>
          </Typography>
        </Grid>
        <Grid item xs={12}>
          <Typography component={"div"}>
            <Box textAlign="left" paddingBottom={"15px"}>
              Na místě uveďte své telefonní číslo 605 111 222 a identifikátor
              žádosti o otestování 28379.
            </Box>
          </Typography>
        </Grid>
        <Grid item xs={12}>
          <Typography component={"div"}>
            <Box textAlign="left">
              Údaje jsme vám zároveň zaslali do emailu a SMS.
            </Box>
          </Typography>
        </Grid>

        {/*TODO pick one of the variants */}
        <Box width="100%">
          <Divider variant={"fullWidth"} />
        </Box>
        <Grid item xs={12}>
          <Typography component={"div"}>
            <Box textAlign="left">
              Do 4 hodin vás bude kontaktovat operátor callcentra a dohodne se s
              vámi na dalším postupu.
            </Box>
          </Typography>
        </Grid>
      </Grid>
    </Layout>
  );
};
