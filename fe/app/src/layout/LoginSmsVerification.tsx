import { Grid, Typography } from "@material-ui/core";
import { Field, Form, Formik } from "formik";
import { TextField } from "formik-material-ui";
import { FormikHelpers } from "formik/dist/types";
import React from "react";
import { ButtonBack } from "../components/button/ButtonBack";
import { ButtonContinue } from "../components/button/ButtonContinue";
import { LoadingBackdrop } from "../components/feedback/Backdrop";
import { Layout } from "../components/Layout";
import { goToPath, PageNames } from "../components/Routes";
import { useHistory } from "react-router-dom";
import { Yup } from "../schema";

const LoginSmsVerificationSchema = Yup.object().shape<
  LoginSmsVerificationFormData
>({
  verificationCode: Yup.string().required("Povinné pole")
});

const initData = { verificationCode: "" };
type LoginSmsVerificationFormData = typeof initData;

export const LoginSmsVerification = () => {
  const history = useHistory();
  const handleSubmit = (
    formData: LoginSmsVerificationFormData,
    { setSubmitting }: FormikHelpers<LoginSmsVerificationFormData>
  ) => {
    // TODO verify code
    console.log("your code is  ", formData.verificationCode);

    setSubmitting(false);

    goToPath(history, PageNames.Dashboard, { patientId: 123 });
  };

  return (
    <Layout>
      <Formik<LoginSmsVerificationFormData>
        initialValues={initData}
        validationSchema={LoginSmsVerificationSchema}
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
              <Grid item xs={12}>
                <Typography>
                  Zadejte ověřovací kód, který jsme Vám zaslali do SMS
                </Typography>
                <Field
                  component={TextField}
                  name="verificationCode"
                  type="text"
                  label="Ověřovací kód"
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
                  Přihlásit
                </ButtonContinue>
              </Grid>
            </Grid>
          </Form>
        )}
      </Formik>
    </Layout>
  );
};
