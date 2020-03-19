import { useApi } from "@/hooks/useApi";
import { useAsyncEffect } from "@/hooks/useAsyncEffect";
import {
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow
} from "@material-ui/core";
import {
  HealthcheckcontrollerApi,
  PersoncontrollerApi,
  PersonResponse
} from "@swaggerBase";
import { format } from "date-fns";
import React, { useState } from "react";

export const PersonsList = () => {
  const healthCheckApi = useApi(HealthcheckcontrollerApi);
  const personApi = useApi(PersoncontrollerApi);
  const [persons, setPersons] = useState<PersonResponse[]>([]);

  useAsyncEffect(async () => {
    setPersons(await personApi.getAllPersons());
  }, []);

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
              <TableCell>{person.healthStatus?.code}</TableCell>
              <TableCell>{person.healthStatusLastChange && format(new Date(person.healthStatusLastChange), "dd.MM.yyyy")}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
};
