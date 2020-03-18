import { FormControl, FormLabel, Grid } from "@material-ui/core";
import { Field, Form, Formik } from "formik";
import { TextField } from "formik-material-ui";
import { DatePicker } from "formik-material-ui-pickers";
import React from "react";
import { ButtonBack } from "../components/button/ButtonBack";
import { ButtonContinue } from "../components/button/ButtonContinue";
import { LoadingBackdrop } from "../components/feedback/Backdrop";
import { RadioGroupChip } from "../components/forms/RadioGroupChip";
import { RadioGroupRow } from "../components/forms/RadioGroupRow";
import { Layout } from "../components/Layout";
import { PageTitle } from "../components/PageTitle";
import { Yup } from "../schema";

const AlreadyInfectedGeneralSchema = Yup.object().shape<
  AlreadyInfectedGeneralFormData
>({
  place: Yup.string().required("Povinné pole"),
  address: Yup.string().required("Povinné pole"),
  healthCheckDate: Yup.date().required("Povinné pole"),
  healthCheckLocation: Yup.string().required("Povinné pole")
});

const initData = {
  place: "",
  address: "",
  healthCheckDate: new Date(),
  healthCheckLocation: ""
};
type AlreadyInfectedGeneralFormData = typeof initData;

export const AlreadyInfectedGeneral = () => {
  function handleSubmit(formData: AlreadyInfectedGeneralFormData) {}

  return (
    <Layout>
      <PageTitle paddingBottom={"15px"}>Dotazník pro infikované 1/3</PageTitle>

      <Grid container>
        <Formik<AlreadyInfectedGeneralFormData>
          initialValues={initData}
          validationSchema={AlreadyInfectedGeneralSchema}
          validateOnMount
          onSubmit={handleSubmit}
        >
          {formik => (
            <Form>
              <LoadingBackdrop open={formik.isSubmitting} />

              <Grid container justify="center" spacing={4}>
                <Grid item xs={12}>
                  <RadioGroupRow name="place" label="Kde probíhá vaše léčba?">
                    <RadioGroupChip value="home" label="Doma" />
                    <RadioGroupChip
                      value="hospital"
                      label="Zdravotní zařízení"
                    />
                  </RadioGroupRow>
                </Grid>
                <Grid item xs={12}>
                  <Field
                    component={TextField}
                    name="address"
                    type="text"
                    label="Adresa místa léčby"
                    fullWidth
                  />
                </Grid>
                <Grid item xs={12}>
                  <Field
                    fullWidth
                    component={DatePicker}
                    label="Termín provedení testu"
                    name="healthCheckDate"
                  />
                </Grid>
                <Grid item xs={12}>
                  <FormControl component="fieldset" fullWidth>
                    <FormLabel component="legend">
                      Certifikovaná laboratoř, kt.provedla test
                    </FormLabel>
                    <Field
                      component={TextField}
                      name="healthCheckLocation"
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
