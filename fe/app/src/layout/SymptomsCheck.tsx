import {
  FormControl,
  FormControlLabel,
  FormHelperText,
  FormLabel,
  Grid,
  Radio
} from "@material-ui/core";
import { ErrorMessage, Field, Form, Formik } from "formik";
import { RadioGroup } from "formik-material-ui";
import { DatePicker } from "formik-material-ui-pickers";
import React from "react";
import { ButtonBack } from "../components/button/ButtonBack";
import { ButtonContinue } from "../components/button/ButtonContinue";
import { LoadingBackdrop } from "../components/feedback/Backdrop";
import { Layout } from "../components/Layout";
import { PageDescription } from "../components/PageDescription";
import { PageTitle } from "../components/PageTitle";
import { Yup } from "../schema";

const SymptomsCheckSchema = Yup.object().shape<SymptomsCheckFormData>({
  firstSignDate: Yup.date().required("Povinné pole"),
  daysOfHighTemperature: Yup.string().required("Povinné pole"),
  daysOfDryCough: Yup.string().required("Povinné pole"),
  daysOfHeadache: Yup.string().required("Povinné pole")
});

const initData = {
  firstSignDate: new Date(),
  daysOfHighTemperature: "",
  daysOfDryCough: "",
  daysOfHeadache: ""
};
type SymptomsCheckFormData = typeof initData;

export const SymptomsCheck = () => {
  function handleSubmit(formData: SymptomsCheckFormData) {
    console.log(formData);
  }

  return (
    <Layout>
      <PageTitle>Žádost o otestování 2/4</PageTitle>
      <PageDescription>
        Pro vytvoření požadavku na otestování prosím vyplňte následující údaje.
        Díky tomu budete rychleji odbaveni na odběrném místě.
      </PageDescription>

      <Grid container>
        <Formik<SymptomsCheckFormData>
          initialValues={initData}
          validationSchema={SymptomsCheckSchema}
          validateOnMount
          onSubmit={handleSubmit}
        >
          {formik => (
            <Form>
              <LoadingBackdrop open={formik.isSubmitting} />

              <Grid container justify="center" spacing={4}>
                <Grid item xs={12}>
                  <Field
                    fullWidth
                    component={DatePicker}
                    label="Odkdy máte první příznaky"
                    name="firstSignDate"
                  />
                </Grid>
                <Grid item xs={12}>
                  <FormControl component="fieldset">
                    <FormLabel component="legend">
                      Kolik dnů máte teplotu nad 38°
                    </FormLabel>
                    <Field
                      component={RadioGroup}
                      name="daysOfHighTemperature"
                      row
                    >
                      <FormControlLabel
                        value="none"
                        control={<Radio />}
                        label="nemám"
                      />
                      <FormControlLabel
                        value="1-2"
                        control={<Radio />}
                        label="1-2"
                      />
                      <FormControlLabel
                        value="3-4"
                        control={<Radio />}
                        label="3-4"
                      />
                      <FormControlLabel
                        value="more"
                        control={<Radio />}
                        label="více"
                      />
                    </Field>
                    <ErrorMessage name="daysOfHighTemperature">
                      {errorMessage => (
                        <FormHelperText error>{errorMessage}</FormHelperText>
                      )}
                    </ErrorMessage>
                  </FormControl>
                </Grid>
                <Grid item xs={12}>
                  <FormControl component="fieldset">
                    <FormLabel component="legend">
                      Kolik dnů máte teplotu nad 38°
                    </FormLabel>
                    <Field component={RadioGroup} name="daysOfDryCough" row>
                      <FormControlLabel
                        value="none"
                        control={<Radio />}
                        label="nemám"
                      />
                      <FormControlLabel
                        value="1-2"
                        control={<Radio />}
                        label="1-2"
                      />
                      <FormControlLabel
                        value="3-4"
                        control={<Radio />}
                        label="3-4"
                      />
                      <FormControlLabel
                        value="more"
                        control={<Radio />}
                        label="více"
                      />
                    </Field>
                    <ErrorMessage name="daysOfDryCough">
                      {errorMessage => (
                        <FormHelperText error>{errorMessage}</FormHelperText>
                      )}
                    </ErrorMessage>
                  </FormControl>
                </Grid>
                <Grid item xs={12}>
                  <FormControl component="fieldset">
                    <FormLabel component="legend">
                      Máte bolesti hlavy?
                    </FormLabel>
                    <Field component={RadioGroup} name="daysOfHeadache" row>
                      <FormControlLabel
                        value="yes"
                        control={<Radio />}
                        label="Ano"
                      />
                      <FormControlLabel
                        value="no"
                        control={<Radio />}
                        label="Ne"
                      />
                    </Field>
                    <ErrorMessage name="daysOfHeadache">
                      {errorMessage => (
                        <FormHelperText error>{errorMessage}</FormHelperText>
                      )}
                    </ErrorMessage>
                  </FormControl>
                </Grid>
              </Grid>
              <Grid container spacing={4}>
                <Grid item xs={6}>
                  <ButtonBack />
                </Grid>
                <Grid item xs={6}>
                  <ButtonContinue type="submit" fullWidth>
                    Pokračovat
                  </ButtonContinue>
                </Grid>
              </Grid>
            </Form>
          )}
        </Formik>
      </Grid>
    </Layout>
  );
};
