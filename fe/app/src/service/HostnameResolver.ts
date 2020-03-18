const API_BASE_PATH = "/api/v2/cl";
const API_PORT = "8080";
const API_PREFIX = "api.";
const APP_PREFIX = "app.";
const PROXY_URL = "http://localhost:1337";
const DEFAULT_PROTOCOL = "http://";

const getApiUrl = () => {
  // Return URL from config if set in .env
  if (process.env.REACT_APP_API_URL) {
    return process.env.REACT_APP_API_URL;
  }

  // Return localhost with port
  if (getHostName() === "localhost") {
    return PROXY_URL.concat("/")
      .concat(getHostName())
      .concat(":")
      .concat(API_PORT);
  }

  // Resolve hostname
  return getApiPrefix().concat(getHostName());
};

const getApiUrlWithBasePath = () => {
  return getApiUrl().concat(API_BASE_PATH);
};

const getHostName = () => {
  return typeof window !== "undefined"
    ? window.location.hostname.replace(new RegExp(APP_PREFIX), "")
    : "localhost";
};

const getProtocol = () => {
  return typeof window !== "undefined"
    ? window.location.protocol.concat("//")
    : DEFAULT_PROTOCOL;
};

const getApiPrefix = () => {
  return getProtocol().concat(API_PREFIX);
};

const getLandingPageUrl = () => {
  return getProtocol().concat(getHostName());
};

const getLandingPageUrlWithParams = (params: object) =>
  appendParamsToUrl(getLandingPageUrl(), params);

const appendParamsToUrl = (url: string, params: any) => {
  let str = "";
  for (const key of Object.keys(params)) {
    if (str !== "") {
      str += "&";
    }
    str += key + "=" + params[key];
  }

  return `${url}?${str}`;
};

export const HostnameResolver = {
  getApiUrl,
  getApiUrlWithBasePath,
  getApiPrefix,
  getHostName,
  getProtocol,
  getLandingPageUrl,
  getLandingPageUrlWithParams
};
