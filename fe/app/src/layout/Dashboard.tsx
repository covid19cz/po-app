import { usePersonalDetails } from "@/hooks/usePersonalDetails";
import React from "react";
import { Layout } from "@/components/Layout";
import { goToPath, PageNames } from "@/components/Routes";
import { usePathParams } from "@/hooks/usePathParams";
import { Button, Grid, Typography } from "@material-ui/core";
import { format } from "date-fns";
import { useHistory } from "react-router-dom";

export const Dashboard = () => {
  const { patientId } = usePathParams();
  const history = useHistory();
  const person = usePersonalDetails(patientId || "");

  function handleNeedTest() {
    goToPath(history, PageNames.ContactDetails, { patientId });
  }

  function handleIsInfected() {
    goToPath(history, PageNames.AlreadyInfectedGeneral, { patientId });
  }

  return (
    <Layout>
      <Grid container wrap="wrap" spacing={2}>
        <Grid item>
          <Typography>Váš aktuální stav:</Typography>
        </Grid>
        <Grid item>
          <Typography>{person?.healthStatus?.text}</Typography>
        </Grid>
      </Grid>

      <Grid container wrap="wrap" spacing={2}>
        <Grid item>
          <Typography>Poslední změna:</Typography>
        </Grid>
        <Grid item>
          <Typography>
            {person?.healthStatusLastChange &&
              format(new Date(person?.healthStatusLastChange), "dd.MM.yyyy")}
          </Typography>
        </Grid>
      </Grid>

      <Grid container spacing={2}>
        <Grid item xs={12}>
          <Button variant="contained" fullWidth onClick={handleNeedTest}>
            Mám příznaky Covid19, chci otestovat
          </Button>
        </Grid>
        <Grid item xs={12}>
          <Button variant="contained" fullWidth onClick={handleIsInfected}>
            Mám Covid19 potvrzen
          </Button>
        </Grid>
       {/* <Grid item xs={12}>
          <Button variant="contained" fullWidth>
            Jsem v karanténě *)
          </Button>
        </Grid>*/}
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
