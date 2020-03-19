import { ButtonBack } from "@/components/button/ButtonBack";
import { ButtonContinue } from "@/components/button/ButtonContinue";
import { LoadingBackdrop } from "@/components/feedback/Backdrop";
import { RadioGroupChip } from "@/components/forms/RadioGroupChip";
import { RadioGroupRow } from "@/components/forms/RadioGroupRow";
import { Layout } from "@/components/Layout";
import { PageTitle } from "@/components/PageTitle";
import { goToPath, PageNames } from "@/components/Routes";
import { useApi } from "@/hooks/useApi";
import { usePathParams } from "@/hooks/usePathParams";
import {
  FormControl,
  FormHelperText,
  FormLabel,
  Grid,
  InputLabel,
  MenuItem
} from "@material-ui/core";
import {
  CodebookItemDto,
  ExposureRequestInfectedInContactEnum,
  HealthcheckcontrollerApi
} from "@swaggerBase";
import { ErrorMessage, Field, Form, Formik } from "formik";
import { Select, TextField } from "formik-material-ui";
import { DatePicker } from "formik-material-ui-pickers";
import { FormikHelpers } from "formik/dist/types";
import React from "react";
import { useHistory } from "react-router-dom";
import { CodeBookItemSchema, Yup } from "../schema";

const contactWithInfectedValues = {
  Y: "Y",
  N: "N",
  "?": "?"
};

const ExposureCheckSchema = Yup.object().shape<ExposureCheckFormData>({
  contactWithInfected: Yup.mixed()
    .oneOf(Object.keys(contactWithInfectedValues))
    .required("Povinné pole"),
  contactWithInfectedDate: Yup.date().required("Povinné pole"),
  contactWithInfectedContacts: Yup.string(),
  visitedRiskArea: CodeBookItemSchema
});

const initData = {
  contactWithInfected: "" as ExposureRequestInfectedInContactEnum,
  contactWithInfectedDate: new Date(),
  contactWithInfectedContacts: "",
  visitedRiskArea: { code: "" } as CodebookItemDto
};

type ExposureCheckFormData = typeof initData;

// TODO load from BE
const codebook = [
  { code: "1", text: "Čína" },
  { code: "2", text: "Írán" },
  { code: "3", text: "Itálie" },
  { code: "4", text: "Jižní Korea" },
  { code: "5", text: "Francie" },
  { code: "6", text: "Španělsko" },
  { code: "7", text: "Německo" },
  { code: "8", text: "Švýcarsko" },
  { code: "9", text: "Norsko" },
  { code: "10", text: "Dánsko" },
  { code: "11", text: "Nizozemsko" },
  { code: "12", text: "Švédsko" },
  { code: "13", text: "Velká Británie" },
  { code: "14", text: "Belgie" },
  { code: "15", text: "Rakousko" }
];

export const ExposureCheck = () => {
  const history = useHistory();
  const api = useApi(HealthcheckcontrollerApi);
  const { patientId = "" } = usePathParams();

  async function handleSubmit(
    formData: ExposureCheckFormData,
    { setSubmitting }: FormikHelpers<ExposureCheckFormData>
  ) {
    try {
      await api.personsPersonUidHealthCheckExposurePut({
        personUid: patientId,
        exposureDto: {
          infectedInContact: formData.contactWithInfected,
          infectedInContactDate: formData.contactWithInfectedDate,
          infectedPhoneNumbers: formData.contactWithInfectedContacts,
          visitedRiskArea: formData.visitedRiskArea
        }
      });

      goToPath(history, PageNames.TestPlacePicker, { patientId });
    } catch (e) {
      setSubmitting(false);
    }
  }

  return (
    <Layout>
      <PageTitle paddingBottom={"30px"}>Žádost o otestování 3/4</PageTitle>
      <Grid container>
        <Formik<ExposureCheckFormData>
          initialValues={initData}
          validationSchema={ExposureCheckSchema}
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
                      value={contactWithInfectedValues.Y}
                      label="ano"
                    />
                    <RadioGroupChip
                      value={contactWithInfectedValues.N}
                      label="ne"
                    />
                    <RadioGroupChip
                      value={contactWithInfectedValues["?"]}
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
                  <FormControl component="fieldset" fullWidth>
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
                <Grid item xs={12}>
                  <FormControl component="fieldset" fullWidth>
                    <InputLabel htmlFor="visitedRiskArea.code">
                      Byl/a jste v rizikové oblasti, které?
                    </InputLabel>
                    <Field
                      component={Select}
                      name="visitedRiskArea.code"
                      inputProps={{
                        id: "visitedRiskArea.code"
                      }}
                    >
                      {codebook.map(item => {
                        return (
                          <MenuItem value={item.code}>{item.text}</MenuItem>
                        );
                      })}
                    </Field>
                    <ErrorMessage name="visitedRiskArea.code">
                      {error => <FormHelperText error>{error}</FormHelperText>}
                    </ErrorMessage>
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
