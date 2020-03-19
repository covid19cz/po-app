import { useApi } from "@/hooks/useApi";
import { useAsyncEffect } from "@/hooks/useAsyncEffect";
import { PersoncontrollerApi, PersonResponse } from "@swaggerBase";
import { useState } from "react";

export const usePersonalDetails = (personUid: string) => {
  const api = useApi(PersoncontrollerApi);

  const [person, setPerson] = useState<PersonResponse>();

  useAsyncEffect(async () => {
    try {
      if (personUid) {
        setPerson(await api.personsPersonUidGet({ personUid }));
      }
    } catch (e) {}
  }, []);

  return person;
};
