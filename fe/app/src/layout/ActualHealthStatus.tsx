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
import { boolean } from "yup";
import { RadioGroupRow } from "@/components/forms/RadioGroupRow";
import { RadioGroupChip } from "@/components/forms/RadioGroupChip";

const ActualHealthStatusSchema = Yup.object().shape<ActualHealthStatusFormData>(
  {
    firstIssuesDate: Yup.date().required("Povinné pole"),
    headache: Yup.boolean().required("Povinné pole")
  }
);

const initData = {
  firstIssuesDate: new Date(),
  headache: boolean
};
type ActualHealthStatusFormData = typeof initData;
const symptomValues: Record<SymptomEnum, string> = {
  NONE: "NONE",
  ONE_OR_TWO: "ONE_OR_TWO",
  THREE_OR_FOUR: "THREE_OR_FOUR",
  MORE: "MORE"
};
const DayRow = (name:string, label:string) => (
  <RadioGroupRow name={name} label={label}>
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
        Nahlaseni aktualniho zdravotniho stavu
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
                    label="Odkdy mate prvni priznaky"
                    fullWidth
                    props={{ shrink: false }}
                  />
                </Grid>
                <Grid item xs={12}></Grid>
                <Grid item xs={12}></Grid>
                <Grid item xs={12}></Grid>
              </Grid>

              <Grid container spacing={4}>
                <Grid item xs={6}>
                  <Button
                    color="primary"
                    variant="contained"
                    type="submit"
                    fullWidth
                  >
                    Ulozit
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
