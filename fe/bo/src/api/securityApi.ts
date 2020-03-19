import { HostnameResolver } from "@/service/HostnameResolver";
import { DefaultApi as SecurityDefaultApi, TokenDto } from "@swaggerSecurity";
import { apiCallHandler } from "./defaults";

export enum OauthGrantType {
  password = "password",
  refresh_token = "refresh_token"
}

export interface IOauthTokenRequest {
  username?: string; // clientGuid
  password?: string; // sms Password
  refreshToken?: string;
  grantType?: OauthGrantType;
}

export const DEFAULT_GRANT_TYPE = OauthGrantType.password;

export const getSecurityApi = () =>
  new SecurityDefaultApi(apiCallHandler, HostnameResolver.getApiUrl());

export const oauthTokenDefaultOptions = {
  Authorization: `Basic ${process.env.REACT_APP_OAUTH_SERVER_TOKEN}`
};

export const getOauthToken = (
  data: IOauthTokenRequest,
  repeated?: boolean
): Promise<TokenDto> => {
  return getSecurityApi().nullUsingPOST(
    { grantType: DEFAULT_GRANT_TYPE, ...data },
    { headers: oauthTokenDefaultOptions, repeated }
  );
};
