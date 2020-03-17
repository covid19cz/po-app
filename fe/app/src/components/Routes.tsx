import { stringify } from "query-string";
import React from "react";
import { ContactDetails } from "../layout/ContactDetails";
import { Dashboard } from "../layout/Dashboard";
import { GetPhoneNumber } from "../layout/GetPhoneNumber";
import { LoginSmsVerification } from "../layout/LoginSmsVerification";
import { PossibleContact } from "../layout/PossibleContactCheck";
import { SymptomsCheck } from "../layout/SymptomsCheck";
import {TestPlacePicker} from "../layout/TestPlacePicker";
import { PageProps } from "./Page";
import { History } from "history";
import { generatePath } from "react-router";

export enum PageNames {
  GetPhoneNumber = "GetPhoneNumber",
  LoginSmsVerification = "LoginSmsVerification",
  Dashboard = "Dashboard",
  ContactDetails = "ContactDetails",
  SymptomsCheck = "SymptomsCheck",
  PossibleContact = "PossibleContact",
  TestPlacePicker = "TestPlacePicker"
}

export type PathParameterNames = "patientId";

type PathParamsType = Partial<
  Record<PathParameterNames, string | boolean | number | undefined>
>;

export const Routes: Record<PageNames, PageProps> = {
  GetPhoneNumber: {
    link: "/",
    exact: true,
    children: <GetPhoneNumber />,
    title: "Přihlášení"
  },
  LoginSmsVerification: {
    link: "/login-sms-verification",
    exact: true,
    children: <LoginSmsVerification />,
    title: "Přihlášení"
  },
  Dashboard: {
    link: "/app/:patientId/dashboard",
    exact: true,
    children: <Dashboard />,
    title: "Přehled"
  },
  ContactDetails: {
    link: "/app/:patientId/contact-details",
    exact: true,
    children: <ContactDetails />,
    title: "Žádost o otestování"
  },
  SymptomsCheck: {
    link: "/app/:patientId/symptoms-check",
    exact: true,
    children: <SymptomsCheck />,
    title: "Žádost o otestování"
  },
  PossibleContact: {
    link: "/app/:patientId/possible-contact-check",
    exact: true,
    children: <PossibleContact />,
    title: "Žádost o otestování"
  },
  TestPlacePicker: {
    link: "/app/:patientId/test-place-picker",
    exact: true,
    children: <TestPlacePicker />,
    title: "Žádost o otestování"
  }
};

function getPath(
  link: PageProps,
  pathParams?: PathParamsType,
  queryParams?: { [p: string]: any }
) {
  let result = generatePath(link.link, pathParams);
  if (queryParams) result += `?${stringify(queryParams)}`;
  return result;
}

export const goToPath = (
  history: History,
  pathName: PageNames,
  pathParams: PathParamsType = {},
  queryParams?: { [p: string]: string | boolean | number | null | undefined }
) => history.push(getPath(Routes[pathName], pathParams, queryParams));
