import { Chip, useRadioGroup } from "@material-ui/core";
import { makeStyles } from "@material-ui/core/styles";
import { useField } from "formik";
import React, { MouseEventHandler } from "react";

type Props = {
  value: any;
  label: string;
};

const useStyles = makeStyles({
  container: {
    marginRight: "10px"
  }
});

export const RadioGroupChip = (props: Props) => {
  const style = useStyles();
  const radioGroup = useRadioGroup();

  const [field, meta, handlers] = useField(radioGroup.name || "");

  const handleClicks: MouseEventHandler = e => {
    setTimeout(() => {
      handlers.setValue(props.value);
      handlers.setTouched(true);
    });
  };

  return (
    <Chip
      className={style.container}
      {...field}
      variant={meta.value === props.value ? "outlined" : "default"}
      label={props.label}
      onClick={handleClicks}
      onBlur={() => null}
      clickable={false}
    />
  );
};
