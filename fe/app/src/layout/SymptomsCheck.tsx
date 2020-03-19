import { ButtonBack } from "@/components/button/ButtonBack";
import { ButtonContinue } from "@/components/button/ButtonContinue";
import { LoadingBackdrop } from "@/components/feedback/Backdrop";
import { RadioGroupChip } from "@/components/forms/RadioGroupChip";
import { RadioGroupRow } from "@/components/forms/RadioGroupRow";
import { Layout } from "@/components/Layout";
import { PageDescription } from "@/components/PageDescription";
import { PageTitle } from "@/components/PageTitle";
import { goToPath, PageNames } from "@/components/Routes";
import { useApi } from "@/hooks/useApi";
import { usePathParams } from "@/hooks/usePathParams";
import { Grid } from "@material-ui/core";
import { Field, Form, Formik } from "formik";
import { DatePicker } from "formik-material-ui-pickers";
import { FormikHelpers } from "formik/dist/types";
import React from "react";
import { useHistory } from "react-router-dom";

import { Yup } from "../schema";
import { HealthcheckcontrollerApi, SymptomEnum } from "@swaggerBase";

const symptomValues: Record<SymptomEnum, string> = {
  NONE: "NONE",
  ONE_OR_TWO: "ONE_OR_TWO",
  THREE_OR_FOUR: "THREE_OR_FOUR",
  MORE: "MORE"
};

const SymptomsCheckSchema = Yup.object().shape<SymptomsCheckFormData>({
  firstSignDate: Yup.date().required("Povinné pole"),
  daysOfHighTemperature: Yup.mixed()
    .oneOf(Object.keys(symptomValues))
    .required("Povinné pole"),
  daysOfDryCough: Yup.mixed()
    .oneOf(Object.keys(symptomValues))
    .required("Povinné pole"),
  daysOfHeadache: Yup.string().required("Povinné pole")
});

const initData = {
  firstSignDate: new Date(),
  daysOfHighTemperature: "" as SymptomEnum,
  daysOfDryCough: "" as SymptomEnum,
  daysOfHeadache: ""
};

const headacheValues = {
  yes: "yes",
  no: "no"
};

type SymptomsCheckFormData = typeof initData;

export const SymptomsCheck = () => {
  const history = useHistory();
  const api = useApi(HealthcheckcontrollerApi);
  const { patientId = "" } = usePathParams();
  async function handleSubmit(
    formData: SymptomsCheckFormData,
    { setSubmitting }: FormikHelpers<SymptomsCheckFormData>
  ) {
    try {
      await api.personsPersonUidHealthCheckSymptomsPut({
        personUid: patientId,
        symptomsDto: {
          dryCoughDuration: formData.daysOfDryCough,
          headache: formData.daysOfHeadache === headacheValues.yes,
          highTemperatureDuration: formData.daysOfHighTemperature,
          symtomsSince: formData.firstSignDate
        }
      });

      goToPath(history, PageNames.ExposureCheck, { patientId });
    } catch (e) {
      setSubmitting(false);
    }
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
                    <RadioGroupChip value={symptomValues.NONE} label="nemám" />
                    <RadioGroupChip
                      value={symptomValues.ONE_OR_TWO}
                      label="1-2"
                    />
                    <RadioGroupChip
                      value={symptomValues.THREE_OR_FOUR}
                      label="3-4"
                    />
                    <RadioGroupChip value={symptomValues.MORE} label="více" />
                  </RadioGroupRow>
                </Grid>
                <Grid item xs={12}>
                  <RadioGroupRow
                    name="daysOfDryCough"
                    label="Kolik dnů máte teplotu nad 38°"
                  >
                    <RadioGroupChip value={symptomValues.NONE} label="nemám" />
                    <RadioGroupChip
                      value={symptomValues.ONE_OR_TWO}
                      label="1-2"
                    />
                    <RadioGroupChip
                      value={symptomValues.THREE_OR_FOUR}
                      label="3-4"
                    />
                    <RadioGroupChip value={symptomValues.MORE} label="více" />
                  </RadioGroupRow>
                </Grid>
                <Grid item xs={12}>
                  <RadioGroupRow
                    name="daysOfHeadache"
                    label="Máte bolesti hlavy?"
                  >
                    <RadioGroupChip value={headacheValues.yes} label="Ano" />
                    <RadioGroupChip value={headacheValues.no} label="Ne" />
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
