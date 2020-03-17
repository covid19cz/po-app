import { Typography } from "@material-ui/core";
import React from "react";
import { Button, ButtonProps } from "./Button";
import { useHistory } from "react-router-dom";

export const ButtonBack: React.FC<ButtonProps> = props => {
  const history = useHistory();

  function handleGoBack() {
    history.goBack();
  }

  return (
    <Button
      type="button"
      variant="contained"
      onClick={handleGoBack}
      fullWidth
      {...props}
    >
      <Typography variant="button">Zpět</Typography>
    </Button>
  );
};
