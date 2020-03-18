import { FormControl, FormHelperText, FormLabel } from "@material-ui/core";
import { makeStyles } from "@material-ui/core/styles";
import { ErrorMessage, Field } from "formik";
import { RadioGroup } from "formik-material-ui";
import React, { FC } from "react";
import { RadioGroupChip } from "./RadioGroupChip";

type RadioGroupRowProps = {
  label?: string;
  name: string;
  children: Array<ReturnType<typeof RadioGroupChip>>;
};

const useStyles = makeStyles(() => ({
  root: {
    display: "flex",
    textAlign: "left"
  }
}));

export const RadioGroupRow: FC<RadioGroupRowProps> = props => {
  const classes = useStyles();

  return (
    <FormControl component="fieldset" className={classes.root}>
      {props.label && <FormLabel component="legend">{props.label}</FormLabel>}
      <Field component={RadioGroup} name={props.name} row>
        {props.children}
      </Field>
      <ErrorMessage name={props.name}>
        {errorMessage => <FormHelperText error>{errorMessage}</FormHelperText>}
      </ErrorMessage>
    </FormControl>
  );
};
