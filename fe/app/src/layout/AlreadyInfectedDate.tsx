import { FormControl, FormLabel, Grid, Typography } from "@material-ui/core";
import { Field, Form, Formik } from "formik";
import { TextField } from "formik-material-ui";
import { DatePicker } from "formik-material-ui-pickers";
import React from "react";
import { ButtonBack } from "../components/button/ButtonBack";
import { ButtonContinue } from "../components/button/ButtonContinue";
import { LoadingBackdrop } from "../components/feedback/Backdrop";
import { Layout } from "../components/Layout";
import { PageTitle } from "../components/PageTitle";
import { Yup } from "../schema";

const AlreadyInfectedDateSchema = Yup.object().shape<
  AlreadyInfectedDateFormData
>({
  expectedInfectionDate: Yup.date().required("Povinné pole"),
  inContactPhoneNumbers: Yup.string().required("Povinné pole")
});

const initData = {
  expectedInfectionDate: new Date(),
  inContactPhoneNumbers: ""
};

type AlreadyInfectedDateFormData = typeof initData;

export const AlreadyInfectedDate = () => {
  function handleSubmit(formData: AlreadyInfectedDateFormData) {}

  return (
    <Layout>
      <PageTitle paddingBottom={"15px"}>Dotazník pro infikované 2/3</PageTitle>

      <Grid container>
        <Formik<AlreadyInfectedDateFormData>
          initialValues={initData}
          validationSchema={AlreadyInfectedDateSchema}
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
                    label="Předpokládaný termín nákazy"
                    name="expectedInfectionDate"
                  />
                </Grid>
                <Grid item xs={12}>
                  <FormControl component="fieldset">
                    <FormLabel component="legend">
                      Seznam čárkou oddělených telefonních čísel
                      kolegů/kamarádů/příbuzných, se kterými jste od výše
                      uvedeného data byl/a v kontaktu:
                    </FormLabel>
                    <Field
                      component={TextField}
                      name="inContactPhoneNumbers"
                      type="text"
                      fullWidth
                    />
                  </FormControl>
                </Grid>
              </Grid>
              <Grid container wrap="nowrap" spacing={2}>
                <Grid item>*)</Grid>
                <Grid item xs>
                  <Typography>
                    Těmto kontaktům bude předána anonymní informace o nákaze v
                    jejich okolí a budou požádáni o zahájení karantény. Vaše
                    jméno ani telefonní číslo nebude zveřejněno. Nejbližší
                    rodině prosím informaci předejte telefonicky přímo vy.
                  </Typography>
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
