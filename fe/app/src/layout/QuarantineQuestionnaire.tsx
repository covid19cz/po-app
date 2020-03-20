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

const QuarantineQuestionnaireSchema = Yup.object().shape<
  QuarantineQuestionnaireFormData
>({
  reason: Yup.string().required("Povinné pole"),
  fromDate: Yup.date().required("Povinné pole"),
  peopleCount: Yup.number().required("Povinné pole")
});

const initData = {
  reason: "",
  fromDate: new Date(),
  peopleCount: 1
};
type QuarantineQuestionnaireFormData = typeof initData;

export const QuarantineQuestionnaire = () => {
  function handleSubmit() {}

  return (
    <Layout>
      <PageTitle paddingBottom={"15px"}>Dotazník pro karantenu</PageTitle>

      <Grid container>
        <Formik<QuarantineQuestionnaireFormData>
          initialValues={initData}
          validationSchema={QuarantineQuestionnaireSchema}
          validateOnMount
          onSubmit={handleSubmit}
        >
          {formik => (
            <Form>
              <LoadingBackdrop open={formik.isSubmitting} />

              <Grid container justify="center" spacing={4}>
                <Grid item xs={12}>
                  <InputLabel id="quarantine-reason-label">
                    Důvod karantény
                  </InputLabel>
                  <Field
                    fullWidth
                    component={Select}
                    id="quarantine-reason"
                    name="reason"
                    labelId="quarantine-reason-label"
                  >
                      <MenuItem value={1}>preventivní opatření (home-office)</MenuItem>
                      <MenuItem value={2}>něco</MenuItem>
                      <MenuItem value={3}>něco2</MenuItem>
                  </Field>
                </Grid>
                <Grid item xs={12}>
                  <Field
                    component={DatePicker}
                    name="fromDate"
                    type="date"
                    format="dd.MM.yyyy"
                    label="Od kdy jste v karanténě"
                    fullWidth
                    props={{ shrink: false }}
                  />
                </Grid>
                <Grid item xs={12}>
                  <Field
                    fullWidth
                    component={TextField}
                    label="Kolik je vás v karanténě ve společné domácnosti"
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
