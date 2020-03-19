const API_BASE_PATH = "/api/v1";
const API_PORT = "8080";
const PROXY_URL = "http://localhost:1337";

const getApiUrl = () => {
  return (
    process.env.REACT_APP_API_URL ||
    PROXY_URL.concat("/")
      .concat(getHostName())
      .concat(":")
      .concat(API_PORT)
  );
};

const getApiUrlWithBasePath = () => {
  return getApiUrl().concat(API_BASE_PATH);
};

const getHostName = () => {
  return typeof window !== "undefined" ? window.location.hostname : "localhost";
};

export const HostnameResolver = {
  getApiUrl,
  getApiUrlWithBasePath,
  getHostName
};
