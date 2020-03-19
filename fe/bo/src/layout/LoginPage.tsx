import { setOauthData } from "@/api/defaults";
import { getOauthToken } from "@/api/securityApi";
import { ButtonContinue } from "@/component/button/ButtonContinue";
import { LoadingBackdrop } from "@/component/feedback/Backdrop";
import { Grid, Typography } from "@material-ui/core";
import { Field, Form, Formik } from "formik";
import { TextField } from "formik-material-ui";
import { FormikHelpers } from "formik/dist/types";
import React, { useEffect } from "react";
import { Yup } from "../schema";

const LoginPageSchema = Yup.object().shape<LoginPageFormData>({
  username: Yup.string().required("Povinné pole"),
  password: Yup.string().required("Povinné pole")
});

const initData = { username: "", password: "" };
type LoginPageFormData = typeof initData;

export const LoginPage = () => {
  useEffect(() => {
    sessionStorage.clear();
  }, []);

  async function handleSubmit(
    formData: LoginPageFormData,
    { setSubmitting }: FormikHelpers<LoginPageFormData>
  ) {
    try {
      const token = await getOauthToken({
        username: formData.username,
        password: formData.password
      });

      setOauthData(token);

      setSubmitting(false);

      window.location.reload();
    } catch (e) {}
  }

  return (
    <Formik<LoginPageFormData>
      initialValues={initData}
      validationSchema={LoginPageSchema}
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
                name="username"
                type="text"
                label="Zadejte uživatelské jméno"
                fullWidth
              />
            </Grid>
            <Grid item xs={12} md={6}>
              <Field
                  component={TextField}
                  name="password"
                  type="password"
                  label="Zadejte heslo"
                  fullWidth
              />
            </Grid>
          </Grid>

          <Grid container justify="center" spacing={4}>
            <Grid item xs={12} >
              <ButtonContinue type="submit">Přihlásit</ButtonContinue>
            </Grid>
          </Grid>
        </Form>
      )}
    </Formik>
  );
};
