import { Typography } from "@material-ui/core";
import React from "react";
import { Button, ButtonProps } from "./Button";

type ButtonContinueProps = ButtonProps & {
  label?: string;
};

export const ButtonContinue: React.FC<ButtonContinueProps> = props => {
  const { label, ...otherProps } = props;
  return (
    <Button color="primary" variant="contained" fullWidth {...otherProps}>
      <Typography variant="button">{label || "Pokračovat"}</Typography>
    </Button>
  );
};
