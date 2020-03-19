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
  Grid,
  InputLabel,
  MenuItem
} from "@material-ui/core";
import { CodebookItemDto, HealthcheckcontrollerApi } from "@swaggerBase";
import { ErrorMessage, Field, Form, Formik } from "formik";
import { Select } from "formik-material-ui";
import { FormikHelpers } from "formik/dist/types";
import React from "react";
import { useHistory } from "react-router-dom";
import { CodeBookItemSchema, Yup } from "../schema";

const TestPlaceSchema = Yup.object().shape<TestPlaceFormData>({
  selectedTestPlace: CodeBookItemSchema,
  carAvailable: Yup.string().required("Povinné pole")
});

const initData = {
  selectedTestPlace: { code: "" } as CodebookItemDto,
  carAvailable: ""
};

type TestPlaceFormData = typeof initData;

const locationCodebook = [
  { code: "1", text: "Fakultní nemocnice v Motole" },
  { code: "2", text: "Thomayerova nemocnice" },
  { code: "3", text: "Ústřední vojenská nemocnice" },
  { code: "4", text: "Nemocnice na Bulovce" },
  { code: "5", text: "Lab In – Institut laboratorní medicíny" },
  { code: "6", text: "Fakultní nemocnice Plzeň" },
  { code: "7", text: "Fakultní nemocnice Hradec Králové" },
  { code: "8", text: "Nemocnice České Budějovice" },
  { code: "9", text: "Nemocnice Tábor" },
  { code: "10", text: "Nemocnice Strakonice" },
  { code: "11", text: "Nemocnice Jindřichův Hradec" },
  { code: "12", text: "Fakultní nemocnice Brno Bohunice" },
  { code: "13", text: "Fakultní nemocnice Ostrava" },
  { code: "14", text: "Slezská nemocnice v Opavě" },
  { code: "15", text: "Fakultní nemocnice Olomouc" },
  { code: "16", text: "Oblastní nemocnice Kladno, a. s." },
  { code: "17", text: "Oblastní nemocnice Kolín, a. s." },
  { code: "18", text: "Oblastní nemocnice Mladá Boleslav, a. s." },
  { code: "19", text: "Nemocnice Rudolfa a Stefanie Benešov, a. s." }
];

export const TestPlacePicker = () => {
  const history = useHistory();
  const api = useApi(HealthcheckcontrollerApi);
  const { patientId = "" } = usePathParams();

  async function handleSubmit(
    formData: TestPlaceFormData,
    { setSubmitting }: FormikHelpers<TestPlaceFormData>
  ) {
    try {
      await api.putHealthCheckTestingPlace({
        personUid: patientId,
        testingPlaceDto: {
          ableToDrive: formData.carAvailable === "yes",
          preferredHealthCheckLocation: formData.selectedTestPlace
        }
      });

      goToPath(history, PageNames.HealthCheckInstructions, { patientId });
    } catch (e) {
      setSubmitting(false);
    }
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
                  <FormControl component="fieldset" fullWidth>
                    <InputLabel htmlFor="selectedTestPlace.code">
                      Byl/a jste v rizikové oblasti, které?
                    </InputLabel>
                    <Field
                      component={Select}
                      name="selectedTestPlace.code"
                      inputProps={{
                        id: "selectedTestPlace.code"
                      }}
                    >
                      {locationCodebook.map(item => (
                        <MenuItem value={item.code} key={item.code}>
                          {item.text}
                        </MenuItem>
                      ))}
                    </Field>
                    <ErrorMessage name="selectedTestPlace.code">
                      {error => <FormHelperText error>{error}</FormHelperText>}
                    </ErrorMessage>
                  </FormControl>
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
