import { Grid } from "@material-ui/core";
import { Field, Form, Formik } from "formik";
import { TextField } from "formik-material-ui";
import React from "react";
import { ButtonBack } from "../components/button/ButtonBack";
import { ButtonContinue } from "../components/button/ButtonContinue";
import { LoadingBackdrop } from "../components/feedback/Backdrop";
import { Layout } from "../components/Layout";
import { PageDescription } from "../components/PageDescription";
import { PageTitle } from "../components/PageTitle";
import { Yup } from "../schema";

const ContactDetailsSchema = Yup.object().shape<ContactDetailsFormData>({
  firstName: Yup.string().required("Povinné pole"),
  lastName: Yup.string().required("Povinné pole"),
  address: Yup.string().required("Povinné pole"),
  email: Yup.string()
    .email("Zadejte správnou emailovou adresu")
    .required("Povinné pole")
});

const initData = { firstName: "", lastName: "", address: "", email: "" };
type ContactDetailsFormData = typeof initData;

export const ContactDetails = () => {
  function handleSubmit(formData: ContactDetailsFormData) {}

  return (
    <Layout>
      <PageTitle>Žádost o otestování 1/4</PageTitle>
      <PageDescription>
        Pro vytvoření požadavku na otestování prosím vyplňte následující údaje.
        Díky tomu budete rychleji odbaveni na odběrném místě.
      </PageDescription>

      <Grid container>
        <Formik<ContactDetailsFormData>
          initialValues={initData}
          validationSchema={ContactDetailsSchema}
          validateOnMount
          onSubmit={handleSubmit}
        >
          {formik => (
            <Form>
              <LoadingBackdrop open={formik.isSubmitting} />

              <Grid container justify="center" spacing={4}>
                <Grid item xs={12}>
                  <Field
                    component={TextField}
                    name="firstName"
                    type="text"
                    label="Křestní jméno"
                    fullWidth
                  />
                </Grid>
                <Grid item xs={12}>
                  <Field
                    component={TextField}
                    name="lastName"
                    type="text"
                    label="Příjmení"
                    fullWidth
                  />
                </Grid>
                <Grid item xs={12}>
                  <Field
                    component={TextField}
                    name="address"
                    type="text"
                    label="Adresa trvalého pobytu"
                    fullWidth
                  />
                </Grid>
                <Grid item xs={12}>
                  <Field
                    component={TextField}
                    name="email"
                    type="email"
                    label="E-mail"
                    fullWidth
                  />
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
