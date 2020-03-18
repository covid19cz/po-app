export type StorageKeys =
  | "personUid"
  | "expires_in"
  | "token_type"
  | "refresh_token"
  | "access_token";

const getStorageItem = (code: StorageKeys) => {
  return sessionStorage.getItem(code)
    ? JSON.parse(sessionStorage.getItem(code) || "")
    : null;
};

const setStorageItem = (code: StorageKeys, value: any) => {
  sessionStorage.setItem(code, JSON.stringify(value));
};

const removeStorageItem = (code: StorageKeys) => {
  sessionStorage.removeItem(code);
};

const clearStorage = () => {
  sessionStorage.clear();
};

export const storageService = {
  clear: clearStorage,
  getItem: getStorageItem,
  removeItem: removeStorageItem,
  setItem: setStorageItem
};
