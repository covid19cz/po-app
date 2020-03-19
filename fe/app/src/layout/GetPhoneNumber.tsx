import { ButtonContinue } from "@/components/button/ButtonContinue";
import { LoadingBackdrop } from "@/components/feedback/Backdrop";
import { Layout } from "@/components/Layout";
import { goToPath, PageNames } from "@/components/Routes";
import { useApi } from "@/hooks/useApi";
import { Grid, Typography } from "@material-ui/core";
import { AuthorizationcontrollerApi } from "@swaggerBase";
import { Field, Form, Formik } from "formik";
import { TextField } from "formik-material-ui";
import { FormikHelpers } from "formik/dist/types";
import React from "react";
import { phoneNumberSchema, Yup } from "../schema";
import { useHistory } from "react-router-dom";

const GetPhoneNumberSchema = Yup.object().shape<GetPhoneNumberFormData>({
  phoneNumber: phoneNumberSchema.required("Povinné pole")
});

const initData = { phoneNumber: "" };
type GetPhoneNumberFormData = typeof initData;

export const GetPhoneNumber = () => {
  const history = useHistory();
  const api = useApi(AuthorizationcontrollerApi);
  async function handleSubmit(
    formData: GetPhoneNumberFormData,
    { setSubmitting }: FormikHelpers<GetPhoneNumberFormData>
  ) {
    try {
      const response = await api.sendCodeUsingPOST({
        sendCodeRequest: { phoneNumber: formData.phoneNumber }
      });

      setSubmitting(false);
      goToPath(history, PageNames.LoginSmsVerification, {
        patientId: response.personUid
      });
    } catch (e) {}
  }

  return (
    <Layout>
      <Formik<GetPhoneNumberFormData>
        initialValues={initData}
        validationSchema={GetPhoneNumberSchema}
        validateOnMount
        onSubmit={handleSubmit}
      >
        {formik => (
          <Form>
            <LoadingBackdrop open={formik.isSubmitting} />

            <Grid container direction="column" justify="flex-start" spacing={2}>
              <Grid item>
                <Typography variant="h3">Portál občana</Typography>
              </Grid>
            </Grid>
            <Grid container justify="center" spacing={4}>
              <Grid item xs={12} md={6}>
                <Field
                  component={TextField}
                  name="phoneNumber"
                  type="tel"
                  label="Zadejte své telefonní číslo"
                  fullWidth
                />
              </Grid>
            </Grid>

            <Grid container justify="center" spacing={4}>
              <Grid item xs={12} md={6}>
                <ButtonContinue type="submit">Přihlásit</ButtonContinue>
              </Grid>
            </Grid>
          </Form>
        )}
      </Formik>
    </Layout>
  );
};
