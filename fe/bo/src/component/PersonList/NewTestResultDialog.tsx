import { useApi } from "@/hooks/useApi";
import {
  Box,
  Button,
  Dialog,
  DialogActions,
  DialogContent,
  DialogTitle
} from "@material-ui/core";
import { HealthcheckcontrollerApi, HealthCheckResultDto } from "@swaggerBase";
import { Field, Form, Formik, FormikHelpers } from "formik";
import { CheckboxWithLabel } from "formik-material-ui";
import { DatePicker } from "formik-material-ui-pickers";
import React from "react";
import { Yup } from "../../schema";

interface DialogProps {
  onClose?: () => void;
  open: boolean;
}

const NewTestResultDialogSchema = Yup.object().shape<
  NewTestResultDialogFormData
>({
  testDate: Yup.date()
    .nullable(false)
    .required("Povinné pole"),
  positive: Yup.boolean().required("Povinné pole")
});

const initData: HealthCheckResultDto = {
  positive: false,
  testDate: new Date()
};

export type NewTestResultDialogFormData = typeof initData;

type NewTestResultDialogProps = DialogProps & {
  personUid: string;
};

export const NewTestResultDialog = ({
  open,
  onClose,
  personUid
}: NewTestResultDialogProps) => {
  const healthCheckApi = useApi(HealthcheckcontrollerApi);

  async function handleSubmit(formData: NewTestResultDialogFormData) {
    try {
      await healthCheckApi.postHeathCheckTestResult({
        personUid,
        testResultDto: formData
      });
    } finally {
      if (onClose) {
        onClose();
      }
      window.location.reload();
    }
  }

  return (
    <Dialog open={open} onClose={onClose} maxWidth="md" fullWidth>
      <DialogTitle>Přidání místa pohybu</DialogTitle>
      <Formik<NewTestResultDialogFormData>
        initialValues={initData}
        validationSchema={NewTestResultDialogSchema}
        validateOnMount
        onSubmit={handleSubmit}
      >
        {() => (
          <Form>
            <DialogContent>
              <Field
                fullWidth
                component={DatePicker}
                label="Datum provedení testu"
                name="testDate"
                okLabel={"ok"}
                cancelLabel="Zavřít"
              />
              <Box paddingTop={"30px"}>
                <Field
                  component={CheckboxWithLabel}
                  name="positive"
                  Label={{ label: "Covid-19 pozitivní" }}
                />
              </Box>
            </DialogContent>
            <DialogActions>
              <Button onClick={onClose} color="primary">
                Zavřít
              </Button>
              <Button type="submit" color="primary">
                Uložit
              </Button>
            </DialogActions>
          </Form>
        )}
      </Formik>
    </Dialog>
  );
};
