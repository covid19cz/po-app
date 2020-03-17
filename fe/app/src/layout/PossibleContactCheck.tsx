import {
  FormControl,
  FormControlLabel,
  FormHelperText,
  FormLabel,
  Grid,
  Radio
} from "@material-ui/core";
import { ErrorMessage, Field, Form, Formik } from "formik";
import { RadioGroup, TextField } from "formik-material-ui";
import { DatePicker } from "formik-material-ui-pickers";
import React from "react";
import { ButtonBack } from "../components/button/ButtonBack";
import { ButtonContinue } from "../components/button/ButtonContinue";
import { LoadingBackdrop } from "../components/feedback/Backdrop";
import { Layout } from "../components/Layout";
import { PageDescription } from "../components/PageDescription";
import { PageTitle } from "../components/PageTitle";
import { Yup } from "../schema";

const PossibleContactSchema = Yup.object().shape<PossibleContactFormData>({
  contactWithInfected: Yup.string().required("Povinné pole"),
  contactWithInfectedDate: Yup.date().required("Povinné pole"),
  contactWithInfectedContacts: Yup.string().required("Povinné pole"),
  riskyArea: Yup.string().required("Povinné pole")
});

const initData = {
  contactWithInfected: "",
  contactWithInfectedDate: new Date(),
  contactWithInfectedContacts: "",
  riskyArea: ""
};
type PossibleContactFormData = typeof initData;

export const PossibleContact = () => {
  function handleSubmit(formData: PossibleContactFormData) {
    console.log(formData);
  }

  return (
    <Layout>
      <PageTitle paddingBottom={"30px"}>Žádost o otestování 3/4</PageTitle>
      <Grid container>
        <Formik<PossibleContactFormData>
          initialValues={initData}
          validationSchema={PossibleContactSchema}
          validateOnMount
          onSubmit={handleSubmit}
        >
          {formik => (
            <Form>
              <LoadingBackdrop open={formik.isSubmitting} />

              <Grid container justify="center" spacing={4}>
                <Grid item xs={12}>
                  <FormControl component="fieldset">
                    <FormLabel component="legend">
                      Přišli jste do kontaktu s nakaženým?
                    </FormLabel>
                    <Field
                      component={RadioGroup}
                      name="contactWithInfected"
                      row
                    >
                      <FormControlLabel
                        value="yes"
                        control={<Radio />}
                        label="ano"
                      />
                      <FormControlLabel
                        value="no"
                        control={<Radio />}
                        label="ne"
                      />
                      <FormControlLabel
                        value="notSure"
                        control={<Radio />}
                        label="nevím jistě"
                      />
                    </Field>
                    <ErrorMessage name="contactWithInfected">
                      {errorMessage => (
                        <FormHelperText error>{errorMessage}</FormHelperText>
                      )}
                    </ErrorMessage>
                  </FormControl>
                </Grid>
                <Grid item xs={12}>
                  <Field
                    fullWidth
                    component={DatePicker}
                    label="Kdy?"
                    name="contactWithInfectedDate"
                  />
                </Grid>
                <Grid item xs={12}>
                  <FormControl component="fieldset">
                    <FormLabel component="legend">
                      Uveďte čárkou oddělená telefonní čísla lidí, se kterýmí
                      jste byl v kontaktu a byl jim Covid19 potvrzen:
                    </FormLabel>
                    <Field
                      component={TextField}
                      name="contactWithInfectedContacts"
                      type="text"
                      fullWidth
                    />
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
