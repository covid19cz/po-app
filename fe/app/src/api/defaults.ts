import { StorageKeys, storageService } from "@/service/ClientStorageService";
import { isFunction } from "@/utils/objectUtils";
import { ErrorMessageDto, ErrorMessageDtoErrorCodeEnum } from "@swaggerBase";
import { ReactElement } from "react";
// @ts-ignore
import * as isomorphicFetch from "isomorphic-fetch";
import { getSecurityApi } from "./GetSecurityApi";

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

export interface TokenDto {
  accessToken?: string;
  expiresIn?: number;
  refreshToken?: string;
  tokenType?: string;
}

const ACCESS_TOKEN: StorageKeys = "access_token";
const REFRESH_TOKEN: StorageKeys = "refresh_token";
const TOKEN_TYPE: StorageKeys = "token_type";
const EXPIRES_IN: StorageKeys = "expires_in";

interface IProgressEvent<T extends EventTarget = EventTarget> extends Event {
  readonly lengthComputable: boolean;
  readonly loaded: number;
  readonly target: T | null;
  readonly total: number;
}

export type ProgressCallback = (event: IProgressEvent<XMLHttpRequest>) => void;

export interface IApiCallHandlerError {
  status?: number;
  error?: {
    additionalMessages?: any;
    errorCode?: ErrorMessageDtoErrorCodeEnum;
    message?: string | ReactElement;
  };
}

const defaultErrorResponse: IApiCallHandlerError = {
  status: 500,
  error: { errorCode: "UNKNOWN" }
};

export function setOauthData(data: TokenDto): void {
  // @ts-ignore
  storageService.setItem(ACCESS_TOKEN, data[ACCESS_TOKEN] || data.accessToken);
  // @ts-ignore
  storageService.setItem(TOKEN_TYPE, data[TOKEN_TYPE] || data.tokenType);
  storageService.setItem(
    EXPIRES_IN,
    // @ts-ignore
    (data[EXPIRES_IN] || data.expiresIn).toString(10)
  );
  storageService.setItem(
    REFRESH_TOKEN,
    // @ts-ignore
    data[REFRESH_TOKEN] || data.refreshToken
  );
}

export function tokenExists(): boolean {
  // TODO @jv change when validation implemented
  return true;

  /*return (
    storageService.getItem(ACCESS_TOKEN) !== null &&
    storageService.getItem(REFRESH_TOKEN) !== null
  );*/
}

function getTokenForQuery(): string | null {
  /*  if (tokenExists()) {
    return `${storageService.getItem(TOKEN_TYPE)} ${storageService.getItem(
      ACCESS_TOKEN
    )}`;
  }*/

  // TODO @jv change when validation implemented
  return "Basic dXNlcjpwYXNzd29yZA==";
}

function getRefreshToken(): string {
  if (tokenExists()) {
    return storageService.getItem(REFRESH_TOKEN);
  }

  return "";
}

async function handleUnauthorisedRequest(url: string, config: any) {
  const refreshToken: string = getRefreshToken();

  if (!refreshToken) {
    throw defaultErrorResponse;
  }

  try {
    const response = await refreshOauthToken({
      refreshToken,
      grantType: OauthGrantType.refresh_token
    });
    setOauthData(response);
    setAuthorizationHeader(config, true);
    return apiCallHandler(url, config, true);
  } catch (e) {
    return redirectToDefault();
  }
}

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

function refreshOauthToken(data: IOauthTokenRequest): Promise<TokenDto> {
  return getOauthToken(data);
}

// TODO @jv set correct url
function redirectToDefault() {
  window.location.assign("/error");
}

const setAuthorizationHeader = (
  options: any,
  overrideAuthorization = false
) => {
  if (overrideAuthorization) {
    options.headers = { ...options.headers, Authorization: getTokenForQuery() };
  } else {
    options.headers = { Authorization: getTokenForQuery(), ...options.headers };
  }

  if (!options.headers.Authorization) {
    delete options.headers.Authorization;
  }
};

export const apiCallHandler = async (
  url: string,
  options: any,
  repeated = false
): Promise<any> => {
  setAuthorizationHeader(options);

  const response: Response = await isomorphicFetch(url, options).catch(() => {
    return { ok: false };
  });

  if (!response.ok) {
    if (!isFunction(response.json)) {
      redirectToDefault();
      return;
    }

    const responseBody: ErrorMessageDto = await response.json().catch(() => {
      throw defaultErrorResponse;
    });

    if (response.status === 401) {
      if (
        responseBody.errorCode === "ERROR_LOGIN_REQUIRED" &&
        !repeated &&
        tokenExists()
      ) {
        return handleUnauthorisedRequest(url, options);
      }

      redirectToDefault();
    }

    throw { status: response.status, error: responseBody };
  }

  return Promise.resolve(response);
};
