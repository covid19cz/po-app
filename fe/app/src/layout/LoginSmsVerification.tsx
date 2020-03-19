import {setOauthData} from "@/api/defaults";
import { getOauthToken, getSecurityApi } from "@/api/securityApi";
import { ButtonBack } from "@/components/button/ButtonBack";
import { ButtonContinue } from "@/components/button/ButtonContinue";
import { LoadingBackdrop } from "@/components/feedback/Backdrop";
import { Layout } from "@/components/Layout";
import { goToPath, PageNames } from "@/components/Routes";
import { useApi } from "@/hooks/useApi";
import { usePathParams } from "@/hooks/usePathParams";
import { Grid, Typography } from "@material-ui/core";
import { AuthorizationcontrollerApi } from "@swaggerBase";
import { DefaultApi } from "@swaggerSecurity";
import { Field, Form, Formik } from "formik";
import { TextField } from "formik-material-ui";
import { FormikHelpers } from "formik/dist/types";
import React from "react";
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
  const { patientId } = usePathParams();
  const history = useHistory();

  const authorizationApi = useApi(AuthorizationcontrollerApi);
  async function handleSubmit(
    formData: LoginSmsVerificationFormData,
    { setSubmitting }: FormikHelpers<LoginSmsVerificationFormData>
  ) {
    try {
      const response = await authorizationApi.verifyCodeUsingPOST({
        personUid: patientId,
        smsCode: formData.verificationCode
      });

      const token = await getOauthToken({
        username: patientId,
        password: response.password
      });

      setOauthData(token)

      setSubmitting(false);
      goToPath(history, PageNames.Dashboard, {
        patientId
      });
    } catch (e) {}
  }

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
