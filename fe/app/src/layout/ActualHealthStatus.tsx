import { Grid } from "@material-ui/core";
import { Field, Form, Formik } from "formik";
import React from "react";
import { LoadingBackdrop } from "../components/feedback/Backdrop";
import { Layout } from "../components/Layout";
import { PageTitle } from "../components/PageTitle";
import { Yup } from "../schema";
import { DatePicker } from "formik-material-ui-pickers";
import { Button } from "@/components/button/Button";
import { RadioGroupRow } from "@/components/forms/RadioGroupRow";
import { RadioGroupChip } from "@/components/forms/RadioGroupChip";
import { SymptomEnum } from "@swaggerBase";

const headacheValues = {
  yes: "yes",
  no: "no"
};
const symptomValues: Record<SymptomEnum, string> = {
  NONE: "NONE",
  ONE_OR_TWO: "ONE_OR_TWO",
  THREE_OR_FOUR: "THREE_OR_FOUR",
  MORE: "MORE"
};

const ActualHealthStatusSchema = Yup.object().shape<ActualHealthStatusFormData>(
  {
    firstIssuesDate: Yup.date().required("Povinné pole"),
    fever_days: Yup.mixed()
      .oneOf(Object.keys(symptomValues))
      .required("Povinné pole"),
    cough_days: Yup.mixed()
      .oneOf(Object.keys(symptomValues))
      .required("Povinné pole"),
    headache: Yup.mixed()
      .oneOf(Object.keys(headacheValues))
      .required("Povinné pole")
  }
);

const initData = {
  firstIssuesDate: new Date(),
  fever_days: "" as SymptomEnum,
  cough_days: "" as SymptomEnum,
  headache: ""
};
type ActualHealthStatusFormData = typeof initData;

const DayRow = (props: { name: string; label: string }) => (
  <RadioGroupRow name={props.name} label={props.label}>
    <RadioGroupChip value={symptomValues.NONE} label="nemám" />
    <RadioGroupChip value={symptomValues.ONE_OR_TWO} label="1-2" />
    <RadioGroupChip value={symptomValues.THREE_OR_FOUR} label="3-4" />
    <RadioGroupChip value={symptomValues.MORE} label="více" />
  </RadioGroupRow>
);

export const ActualHealthStatus = () => {
  function handleSubmit() {}

  return (
    <Layout>
      <PageTitle paddingBottom={"15px"}>
        Nahlášení aktuálního zdravotního stavu
      </PageTitle>

      <Grid container>
        <Formik<ActualHealthStatusFormData>
          initialValues={initData}
          validationSchema={ActualHealthStatusSchema}
          validateOnMount
          onSubmit={handleSubmit}
        >
          {formik => (
            <Form>
              <LoadingBackdrop open={formik.isSubmitting} />

              <Grid container justify="center" spacing={4}>
                <Grid item xs={12}>
                  <Field
                    component={DatePicker}
                    name="firstIssuesDate"
                    type="date"
                    variant="inline"
                    label="Odkdy máte první příznaky"
                    fullWidth
                    props={{ shrink: false }}
                  />
                </Grid>
                <Grid item xs={12}>
                  <DayRow
                    name="fever_days"
                    label="Kolik dnů máte teplotu nad 38°?"
                  />
                </Grid>
                <Grid item xs={12}>
                  <DayRow
                    name="cough_days"
                    label="Kolik dnů máte suchý kašel?"
                  />
                </Grid>
                <Grid item xs={12}>
                  <RadioGroupRow name="headache" label="Máte bolesti hlavy?">
                    <RadioGroupChip value={headacheValues.yes} label="Ano" />
                    <RadioGroupChip value={headacheValues.no} label="Ne" />
                  </RadioGroupRow>
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
