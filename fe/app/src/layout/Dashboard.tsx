import { Button, Grid, Typography } from "@material-ui/core";
import { format } from "date-fns";
import React from "react";
import { usePathParams } from "../api/usePathParams";
import { Layout } from "../components/Layout";
import { goToPath, PageNames } from "../components/Routes";
import { useHistory } from "react-router-dom";

export const Dashboard = () => {
  const history = useHistory();
  const { patientId } = usePathParams();
  function handleNeedTest() {
    goToPath(history, PageNames.ContactDetails, { patientId });
  }

  return (
    <Layout>
      <Grid container wrap="wrap" spacing={2}>
        <Grid item>
          <Typography>Váš aktuální stav:</Typography>
        </Grid>
        <Grid item>
          <Typography>Bez záznamu</Typography>
        </Grid>
      </Grid>

      <Grid container wrap="wrap" spacing={2}>
        <Grid item>
          <Typography>Poslední změna:</Typography>
        </Grid>
        <Grid item>
          <Typography>{format(new Date(), "dd.MM.yyyy")}</Typography>
        </Grid>
      </Grid>

      <Grid container spacing={2}>
        <Grid item xs={12}>
          <Button variant="contained" fullWidth onClick={handleNeedTest}>
            Mám příznaky Covid19, chci otestovat
          </Button>
        </Grid>
        <Grid item xs={12}>
          <Button variant="contained" fullWidth>
            Mám Covid19 potvrzen
          </Button>
        </Grid>
        <Grid item xs={12}>
          <Button variant="contained" fullWidth>
            Jsem v karanténě *)
          </Button>
        </Grid>
      </Grid>

      <Grid container wrap="nowrap" spacing={2}>
        <Grid item>*)</Grid>
        <Grid item xs>
          <Typography>
            Setkal jsem se s nakaženým nebo jsem byl v rizikové oblasti nebo
            jsem v karanténě z preventivních důvodů.
          </Typography>
        </Grid>
      </Grid>
    </Layout>
  );
};
