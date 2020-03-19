import React from "react";
import { LoadingBackdrop } from "./feedback/Backdrop";
import { useApiState } from "@/api/ApiContext";

export const FetchingIndicator = () => {
  const { loadingInProgress } = useApiState();

  return loadingInProgress ? <LoadingBackdrop open /> : null;
};
