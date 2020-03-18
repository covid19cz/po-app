import { Grid } from "@material-ui/core";
import { Field, Form, Formik } from "formik";
import { TextField } from "formik-material-ui";
import React from "react";
import { ButtonBack } from "../components/button/ButtonBack";
import { ButtonContinue } from "../components/button/ButtonContinue";
import { LoadingBackdrop } from "../components/feedback/Backdrop";
import { RadioGroupChip } from "../components/forms/RadioGroupChip";
import { RadioGroupRow } from "../components/forms/RadioGroupRow";
import { Layout } from "../components/Layout";
import { PageTitle } from "../components/PageTitle";
import { Yup } from "../schema";

const TestPlaceSchema = Yup.object().shape<TestPlaceFormData>({
  selectedTestPlace: Yup.string().required("Povinné pole"),
  carAvailable: Yup.string().required("Povinné pole")
});

const initData = {
  selectedTestPlace: "",
  carAvailable: ""
};

type TestPlaceFormData = typeof initData;

export const TestPlacePicker = () => {
  function handleSubmit(formData: TestPlaceFormData) {
    console.log(formData);
  }

  return (
    <Layout>
      <PageTitle paddingBottom={"30px"}>Žádost o otestování 4/4</PageTitle>
      <Grid container>
        <Formik<TestPlaceFormData>
          initialValues={initData}
          validationSchema={TestPlaceSchema}
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
                    component={TextField}
                    label="Vybrané odběrné místo"
                    name="selectedTestPlace"
                  />
                </Grid>
                <Grid item xs={12}>
                  <RadioGroupRow
                    name="carAvailable"
                    label={"Jste schopen se dopravit automobilem?"}
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
