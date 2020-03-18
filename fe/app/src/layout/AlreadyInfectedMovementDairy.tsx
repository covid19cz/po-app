import { format } from "date-fns";
import React, { useState } from "react";
import { Button } from "../components/button/Button";
import { Layout } from "../components/Layout";
import {
  NewLocationDialog,
  NewLocationDialogFormData
} from "../components/MovementDairy/NewLocationDialog";
import { PageDescription } from "../components/PageDescription";
import { PageTitle } from "../components/PageTitle";
import { useToggler } from "../hooks/useToggler";
import { Box, Grid, List, ListItemText, Typography } from "@material-ui/core";

interface Place {
  date: string;
  presenceFrom: string;
  presenceTo: string;
  address: string;
  note?: string;
}

export const AlreadyInfectedMovementDairy = () => {
  const [places, setPlaces] = useState<Place[]>([]);

  const [addLocationOpen, openAddLocation, closeAddLocation] = useToggler(
    false
  );

  const handleAddNewLocation = (location: NewLocationDialogFormData) => {
    const newLocation: Place = {
      address: location.address,
      date: format(location.date, "dd.MM.yyyy"),
      note: location.note,
      presenceFrom: format(location.presenceFrom, "HH:mm"),
      presenceTo: format(location.presenceTo, "HH:mm")
    };
    setPlaces([...places, newLocation]);

    closeAddLocation();
  };

  return (
    <Layout>
      <PageTitle paddingBottom={"15px"}>Dotazník pro infikované 3/3</PageTitle>
      <PageDescription>
        Prosím o uvedení kde jste se od 8.3.2020 pohyboval/a pro lepší
        identifikaci
      </PageDescription>

      <Grid container>
        <List>
          {places.map((place, index) => {
            return (
              <ListItemText key={index}>
                <Typography component="div">
                  <Box fontWeight={"fontWeightBold"} textAlign={"left"}>
                    {`${place.date} ${place.presenceFrom} - ${place.presenceTo}`}
                  </Box>
                  <Box textAlign={"left"}>{place.address}</Box>
                </Typography>
              </ListItemText>
            );
          })}
        </List>
      </Grid>

      <Grid container>
        <Grid item>
          <Button onClick={openAddLocation}>Přidat</Button>
        </Grid>
      </Grid>
      <NewLocationDialog
        open={addLocationOpen}
        onClose={closeAddLocation}
        onSubmit={handleAddNewLocation}
      />
    </Layout>
  );
};
