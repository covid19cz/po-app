import { ButtonBack } from "@/components/button/ButtonBack";
import { ButtonContinue } from "@/components/button/ButtonContinue";
import { LoadingBackdrop } from "@/components/feedback/Backdrop";
import { FieldPlaces } from "@/components/forms/FieldPlaces";
import { Layout } from "@/components/Layout";
import { PageDescription } from "@/components/PageDescription";
import { PageTitle } from "@/components/PageTitle";
import { goToPath, PageNames } from "@/components/Routes";
import { useApi } from "@/hooks/useApi";
import { usePathParams } from "@/hooks/usePathParams";
import { usePersonalDetails } from "@/hooks/usePersonalDetails";
import { Grid } from "@material-ui/core";
import { PersoncontrollerApi, PersonRequest } from "@swaggerBase";
import { Field, Form, Formik } from "formik";
import { TextField } from "formik-material-ui";
import { FormikHelpers } from "formik/dist/types";
import React, { useEffect, useState } from "react";
import { Yup } from "../schema";
import { useHistory } from "react-router-dom";

const initData: ContactDetailsFormData = {
  firstname: "",
  surname: "",
  address: "",
  email: ""
};
type ContactDetailsFormData = Omit<PersonRequest, "address"> & {
  address: string;
};

const ContactDetailsSchema = Yup.object().shape<ContactDetailsFormData>({
  firstname: Yup.string().required("Povinné pole"),
  surname: Yup.string().required("Povinné pole"),
  address: Yup.string().required("Povinné pole"),
  email: Yup.string()
    .email("Zadejte správnou emailovou adresu")
    .required("Povinné pole")
});

export const ContactDetails = () => {
  const api = useApi(PersoncontrollerApi);
  const history = useHistory();
  const { patientId = "" } = usePathParams();
  const person = usePersonalDetails(patientId);

  const [formData, setFormData] = useState<ContactDetailsFormData>(initData);

  useEffect(() => {
    if (!person) {
      return;
    }

    setFormData({
      address: person.addressHome?.city || "",
      surname: person.surname || "",
      firstname: person.firstname || "",
      email: person.email || ""
    });
  }, [person]);

  async function handleSubmit(
    formData: ContactDetailsFormData,
    { setSubmitting }: FormikHelpers<ContactDetailsFormData>
  ) {
    try {
      await api.putPerson({
        personUid: patientId,
        personDto: { ...formData, addressHome: { city: formData.address } }
      });

      goToPath(history, PageNames.SymptomsCheck, { patientId });
    } catch (e) {
      setSubmitting(false);
    }
  }

  return (
    <Layout>
      <PageTitle>Žádost o otestování 1/4</PageTitle>
      <PageDescription>
        Pro vytvoření požadavku na otestování prosím vyplňte následující údaje.
        Díky tomu budete rychleji odbaveni na odběrném místě.
      </PageDescription>

      <Grid container>
        <Formik<ContactDetailsFormData>
          initialValues={formData}
          validationSchema={ContactDetailsSchema}
          validateOnMount
          onSubmit={handleSubmit}
          enableReinitialize
        >
          {formik => (
            <Form>
              <LoadingBackdrop open={formik.isSubmitting} />

              <Grid container justify="center" spacing={4}>
                <Grid item xs={12}>
                  <Field
                    component={TextField}
                    name="firstname"
                    type="text"
                    label="Křestní jméno"
                    fullWidth
                  />
                </Grid>
                <Grid item xs={12}>
                  <Field
                    component={TextField}
                    name="surname"
                    type="text"
                    label="Příjmení"
                    fullWidth
                  />
                </Grid>
                <Grid item xs={12}>
                  <FieldPlaces
                    name={"address"}
                    label={"Adresa trvalého pobytu"}
                  />
                  {/*<Field
                    component={TextField}
                    name="address"
                    type="text"
                    label="Adresa trvalého pobytu"
                    fullWidth
                  />*/}
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
