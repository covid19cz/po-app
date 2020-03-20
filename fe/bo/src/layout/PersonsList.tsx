import { Button } from "@/component/button/Button";
import { NewTestResultDialog } from "@/component/PersonList/NewTestResultDialog";
import { useApi } from "@/hooks/useApi";
import { useAsyncEffect } from "@/hooks/useAsyncEffect";
import { useToggler } from "@/hooks/useToggler";
import {
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow
} from "@material-ui/core";
import { PersoncontrollerApi, PersonResponse } from "@swaggerBase";
import { format } from "date-fns";
import React, { useState } from "react";

export const PersonsList = () => {
  const personApi = useApi(PersoncontrollerApi);
  const [persons, setPersons] = useState<PersonResponse[]>([]);
  const [addResultTo, setAddResultTo] = useState<PersonResponse>();
  useAsyncEffect(async () => {
    setPersons(await personApi.getAllPersons());
  }, []);

  const [addLocationOpen, openAddLocation, closeAddLocation] = useToggler(
    false
  );

  const handleOpenAddResult = (person: PersonResponse) => () => {
    setAddResultTo(person);
    openAddLocation();
  };

  return (
    <TableContainer component={Paper}>
      <Table aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>Jméno</TableCell>
            <TableCell>Telefonní číslo</TableCell>
            <TableCell>Výsledek testu</TableCell>
            <TableCell>Datum výsledku</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {persons.map(person => (
            <TableRow key={person.personUid}>
              <TableCell>
                {person.firstname &&
                  person.surname &&
                  `${person.firstname} ${person.surname}`}
              </TableCell>
              <TableCell>{person.phoneNumber}</TableCell>
              <TableCell align="center">
                {person.healthStatus?.code === "UNKNOWN" ? (
                  <Button
                    variant="outlined"
                    onClick={handleOpenAddResult(person)}
                  >
                    Vyplnit výsledek
                  </Button>
                ) : (
                  person.healthStatus?.text
                )}
              </TableCell>
              <TableCell>
                {person.healthStatusLastChange &&
                  format(new Date(person.healthStatusLastChange), "dd.MM.yyyy")}
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
      <NewTestResultDialog
        personUid={addResultTo?.personUid || ""}
        open={addLocationOpen}
        onClose={closeAddLocation}
      />
    </TableContainer>
  );
};
