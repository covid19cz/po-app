import { Backdrop, CircularProgress } from "@material-ui/core";
import React from "react";

type LoadingBackdropProps = { open: boolean; timeoutMs?: number };

export const LoadingBackdrop = (props: LoadingBackdropProps) => (
  <Backdrop
    open={props.open}
    timeout={props.timeoutMs || {}}
    style={{ zIndex: 500, color: "white" }}
  >
    <CircularProgress color="inherit" />
  </Backdrop>
);
