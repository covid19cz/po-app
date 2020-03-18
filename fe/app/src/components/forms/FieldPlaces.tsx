import { FormControl, FormHelperText } from "@material-ui/core";
import { Autocomplete } from "@material-ui/lab";
import { useLoadScript } from "@react-google-maps/api";
import { ErrorMessage, useField } from "formik";
import React, { useEffect, useState } from "react";
import TextField from "@material-ui/core/TextField";
import LocationOnIcon from "@material-ui/icons/LocationOn";
import Grid from "@material-ui/core/Grid";
import Typography from "@material-ui/core/Typography";
import { makeStyles } from "@material-ui/core/styles";
import throttle from "lodash/throttle";

const useStyles = makeStyles(theme => ({
  icon: {
    color: theme.palette.text.secondary,
    marginRight: theme.spacing(2)
  }
}));

const loadScriptOptions = {
  googleMapsApiKey: process.env.REACT_APP_GOOGLE_API_KEY,
  libraries: ["places"]
};

interface FieldPlacesProps {
  name: string;
  label: string;
}

export const FieldPlaces = ({ name, label }: FieldPlacesProps) => {
  const classes = useStyles();
  const [options, setOptions] = React.useState<
    google.maps.places.AutocompletePrediction[]
  >([]);
  const [field] = useField(name);
  const [autoCompleteService, setAutocompleteService] = useState<
    google.maps.places.AutocompleteService
  >();
  const { isLoaded } = useLoadScript(loadScriptOptions);

  useEffect(() => {
    if (isLoaded && !autoCompleteService) {
      setAutocompleteService(
        new window.google.maps.places.AutocompleteService()
      );
    }
  }, [isLoaded]);

  const fetch = React.useMemo(
    () =>
      throttle(
        (
          request: { input: string },
          callback: (
            result: google.maps.places.AutocompletePrediction[],
            status: google.maps.places.PlacesServiceStatus
          ) => void
        ) => {
          if (autoCompleteService) {
            autoCompleteService.getPlacePredictions(
              { ...request, componentRestrictions: { country: "CZ" } },
              callback
            );
          }
        },
        200
      ),
    [autoCompleteService]
  );

  React.useEffect(() => {
    let active = true;
    if (!autoCompleteService && (window as any).google) {
      setAutocompleteService(
        new window.google.maps.places.AutocompleteService()
      );
    }
    if (!autoCompleteService) {
      return undefined;
    }

    if (field.value === "") {
      setOptions([]);
      return undefined;
    }

    fetch(
      { input: field.value },
      (results: google.maps.places.AutocompletePrediction[]) => {
        if (active) {
          setOptions(results || []);
        }
      }
    );

    return () => {
      active = false;
    };
  }, [field.value, fetch]);

  return (
    <FormControl component="fieldset" fullWidth>
      <Autocomplete
        getOptionLabel={option =>
          typeof option === "string" ? option : option.description
        }
        filterOptions={x => x}
        noOptionsText={"Nic nenalezeno"}
        options={options}
        autoComplete
        includeInputInList
        onSelect={field.onChange}
        onBlur={field.onBlur}
        renderInput={params => (
          <TextField
            {...params}
            {...field}
            label={label}
            fullWidth
            onChange={field.onChange}
          />
        )}
        renderOption={option => {
          return (
            <Grid container alignItems="center">
              <Grid item>
                <LocationOnIcon className={classes.icon} />
              </Grid>
              <Grid item xs>
                {option.structured_formatting.main_text}
                <Typography variant="body2" color="textSecondary">
                  {option.structured_formatting.secondary_text}
                </Typography>
              </Grid>
            </Grid>
          );
        }}
      />
      <ErrorMessage name={field.name}>
        {errorMessage => <FormHelperText error>{errorMessage}</FormHelperText>}
      </ErrorMessage>
    </FormControl>
  );
};
