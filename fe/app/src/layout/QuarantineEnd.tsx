import { Grid, InputLabel, MenuItem } from "@material-ui/core";
import { Field, Form, Formik } from "formik";
import { TextField, Select } from "formik-material-ui";
import React from "react";
import { ButtonBack } from "../components/button/ButtonBack";
import { ButtonContinue } from "../components/button/ButtonContinue";
import { LoadingBackdrop } from "../components/feedback/Backdrop";
import { Layout } from "../components/Layout";
import { PageTitle } from "../components/PageTitle";
import { Yup } from "../schema";
import { DatePicker } from "formik-material-ui-pickers";
import { Button } from "@/components/button/Button";

const QuarantineEndSchema = Yup.object().shape<QuarantineEndFormData>({
  reason: Yup.string().required("Povinné pole"),
  toDate: Yup.date().required("Povinné pole"),
  peopleCount: Yup.number().required("Povinné pole")
});

const initData = {
  reason: "",
  toDate: new Date(),
  peopleCount: 1
};
type QuarantineEndFormData = typeof initData;

export const QuarantineEnd = () => {
  function handleSubmit() {}

  return (
    <Layout>
      <PageTitle paddingBottom={"15px"}>Ukončení karantény</PageTitle>

      <Grid container>
        <Formik<QuarantineEndFormData>
          initialValues={initData}
          validationSchema={QuarantineEndSchema}
          validateOnMount
          onSubmit={handleSubmit}
        >
          {formik => (
            <Form>
              <LoadingBackdrop open={formik.isSubmitting} />

              <Grid container justify="center" spacing={4}>
                <Grid item xs={12}>
                  <InputLabel id="quarantine-end-reason-label">
                    Důvod ukončení karantény
                  </InputLabel>
                  <Field
                    fullWidth
                    component={Select}
                    id="quarantine-end-reason"
                    name="reason"
                    labelId="quarantine-end-reason-label"
                  >
                    <MenuItem value={1}>během 14 dní bez příznaků</MenuItem>
                    <MenuItem value={2}>něco</MenuItem>
                    <MenuItem value={3}>něco2</MenuItem>
                  </Field>                  
                </Grid>
                <Grid item xs={12}>
                  <Field
                    component={DatePicker}
                    name="toDate"
                    type="date"
                    variant="inline"
                    label="Datum ukončení karantény"
                    fullWidth
                    props={{ shrink: false }}
                  />
                </Grid>
                <Grid item xs={12}>
                  <Field
                    fullWidth
                    component={TextField}
                    label="Kolik vás bylo ve společné karanténě"
                    name="healthCheckDate"
                  />
                </Grid>
              </Grid>

              <Grid container spacing={4}>
                <Grid item xs={6}>
                  <Button
                    color="primary"
                    variant="contained"
                    type="submit"
                    fullWidth
                  >
                    Uložit
                  </Button>
                </Grid>
              </Grid>
            </Form>
          )}
        </Formik>
      </Grid>
    </Layout>
  );
};
