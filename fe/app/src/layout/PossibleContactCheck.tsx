import {
  FormControl,
  FormLabel,
  Grid,
} from "@material-ui/core";
import { Field, Form, Formik } from "formik";
import { TextField } from "formik-material-ui";
import { DatePicker } from "formik-material-ui-pickers";
import React from "react";
import { ButtonBack } from "../components/button/ButtonBack";
import { ButtonContinue } from "../components/button/ButtonContinue";
import { LoadingBackdrop } from "../components/feedback/Backdrop";
import {RadioGroupChip} from "../components/forms/RadioGroupChip";
import { RadioGroupRow } from "../components/forms/RadioGroupRow";
import { Layout } from "../components/Layout";
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
                  <RadioGroupRow
                    name="contactWithInfected"
                    label="Přišli jste do kontaktu s nakaženým?"
                  >
                    <RadioGroupChip
                      value="yes"
                      label="ano"
                    />
                    <RadioGroupChip
                      value="no"
                      label="ne"
                    />
                    <RadioGroupChip
                      value="notSure"
                      label="nevím jistě"
                    />
                  </RadioGroupRow>
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
