import {  Grid } from "@material-ui/core";
import { Field, Form, Formik } from "formik";
import { DatePicker } from "formik-material-ui-pickers";
import React from "react";
import { ButtonBack } from "../components/button/ButtonBack";
import { ButtonContinue } from "../components/button/ButtonContinue";
import { LoadingBackdrop } from "../components/feedback/Backdrop";
import { RadioGroupChip } from "../components/forms/RadioGroupChip";
import { RadioGroupRow } from "../components/forms/RadioGroupRow";
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
                  <RadioGroupRow
                    name="daysOfHighTemperature"
                    label="Kolik dnů máte teplotu nad 38°"
                  >
                    <RadioGroupChip value="none" label="nemám" />
                    <RadioGroupChip value="1-2" label="1-2" />
                    <RadioGroupChip value="3-4" label="3-4" />
                    <RadioGroupChip value="more" label="více" />
                  </RadioGroupRow>
                </Grid>
                <Grid item xs={12}>
                  <RadioGroupRow
                    name="daysOfDryCough"
                    label="Kolik dnů máte teplotu nad 38°"
                  >
                    <RadioGroupChip value="none" label="nemám" />
                    <RadioGroupChip value="1-2" label="1-2" />
                    <RadioGroupChip value="3-4" label="3-4" />
                    <RadioGroupChip value="more" label="více" />
                  </RadioGroupRow>
                </Grid>
                <Grid item xs={12}>
                  <RadioGroupRow
                    name="daysOfHeadache"
                    label="Máte bolesti hlavy?"
                  >
                    <RadioGroupChip value="yes" label="Ano" />
                    <RadioGroupChip value="no" label="Ne" />
                  </RadioGroupRow>
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
