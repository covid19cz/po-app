import { HostnameResolver } from "@/service/HostnameResolver";
import { DefaultApi as SecurityDefaultApi } from "@swaggerSecurity";
import { apiCallHandler } from "./defaults";

export const getSecurityApi = () =>
  new SecurityDefaultApi(apiCallHandler, HostnameResolver.getApiUrl());
