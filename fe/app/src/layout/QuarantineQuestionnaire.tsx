import { Grid } from "@material-ui/core";
import { Field, Form, Formik } from "formik";
import { TextField, Select } from "formik-material-ui";
import { DatePicker } from "git";
import React from "react";
import { ButtonBack } from "../components/button/ButtonBack";
import { ButtonContinue } from "../components/button/ButtonContinue";
import { LoadingBackdrop } from "../components/feedback/Backdrop";
import { Layout } from "../components/Layout";
import { PageTitle } from "../components/PageTitle";
import { Yup } from "../schema";

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
                  <Field
                    fullWidth
                    component={Select}
                    label="Duvod karanteny"
                    name="reason"
                  />
                </Grid>
                <Grid item xs={12}>
                  <Field
                    component={DatePicker}
                    name="fromDate"
                    type="date"
                    label="Od kdy jste v karantene"
                    fullWidth
                    props={{ shrink: false }}
                  />
                </Grid>
                <Grid item xs={12}>
                  <Field
                    fullWidth
                    component={TextField}
                    label="Kolik je vas v karantene ve spolecne domacnosti"
                    name="healthCheckDate"
                  />
                </Grid>
              </Grid>

              <Grid container spacing={4}>
                <Grid item xs={6}>
                  <ButtonBack />
                </Grid>
                <Grid item xs={6}>
                  <ButtonContinue type="submit" fullWidth>
                    Ulozit
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
