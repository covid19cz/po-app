import {
  Dialog,
  DialogActions,
  DialogContent,
  DialogTitle,
  Grid
} from "@material-ui/core";
import { Field, Form, Formik } from "formik";
import { TextField } from "formik-material-ui";
import { DatePicker, TimePicker } from "formik-material-ui-pickers";
import { FormikHelpers } from "formik/dist/types";
import React from "react";
import { Yup } from "../../schema";
import { Button } from "../button/Button";
import { ButtonContinue } from "../button/ButtonContinue";
import { LoadingBackdrop } from "../feedback/Backdrop";
import { FieldPlaces } from "../forms/FieldPlaces";

interface DialogProps {
  onClose?: () => void;
  open: boolean;
}

type NewLocationDialogProps = DialogProps & {
  onSubmit: (formData: NewLocationDialogFormData) => Promise<any> | any;
};

const NewLocationDialogSchema = Yup.object().shape<NewLocationDialogFormData>({
  date: Yup.date().required("Povinné pole"),
  presenceFrom: Yup.date()
    .nullable(false)
    .required("Povinné pole"),
  presenceTo: Yup.date()
    .nullable(false)
    .required("Povinné pole"),
  address: Yup.string().required("Povinné pole"),
  note: Yup.string().max(3000, "Poznámka je moc dlouhá")
});

const initData = {
  date: new Date(),
  presenceFrom: new Date(),
  presenceTo: new Date(),
  address: "",
  note: ""
};

export type NewLocationDialogFormData = typeof initData;

export const NewLocationDialog = ({
  open,
  onClose,
  onSubmit
}: NewLocationDialogProps) => {
  async function handleSubmit(
    formData: NewLocationDialogFormData,
    { setSubmitting }: FormikHelpers<NewLocationDialogFormData>
  ) {
    await onSubmit(formData);

    setSubmitting(false);
  }

  return (
    <Dialog open={open} onClose={onClose} fullScreen>
      <DialogTitle>Přidání místa pohybu</DialogTitle>
      <Formik<NewLocationDialogFormData>
        initialValues={initData}
        validationSchema={NewLocationDialogSchema}
        validateOnMount
        onSubmit={handleSubmit}
      >
        {formik => (
          <Form>
            <DialogContent>
              <LoadingBackdrop open={formik.isSubmitting} />
              <Grid container justify="center" spacing={4}>
                <Grid item xs={12}>
                  <Field
                    fullWidth
                    component={DatePicker}
                    label="Termín provedení testu"
                    name="date"
                    okLabel={"ok"}
                    cancelLabel="Zavřít"
                  />
                </Grid>
                <Grid item xs={12}>
                  <Grid container>
                    <Grid item xs={6}>
                      <Field
                        ampm={false}
                        showTodayButton
                        fullWidth
                        component={TimePicker}
                        label="Přibližně od"
                        name="presenceFrom"
                        todayLabel="NYNÍ"
                        okLabel={"ok"}
                        cancelLabel="Zavřít"
                      />
                    </Grid>
                    <Grid item xs={6}>
                      <Field
                        ampm={false}
                        showTodayButton
                        fullWidth
                        component={TimePicker}
                        label="Přibližně do"
                        name="presenceTo"
                        todayLabel="NYNÍ"
                        okLabel={"ok"}
                        cancelLabel="Zavřít"
                      />
                    </Grid>
                  </Grid>
                </Grid>
                <Grid item xs={12}>
                  <FieldPlaces name="address" label={"Adresa"} />
                </Grid>
                <Grid item xs={12}>
                  <Field
                    component={TextField}
                    name="note"
                    type="text"
                    fullWidth
                    multiline
                    label="Poznámka k místu (např. patro)"
                  />
                </Grid>
              </Grid>
            </DialogContent>
            <DialogActions>
              <Grid container spacing={4}>
                <Grid item xs={6}>
                  <Button onClick={onClose} color="primary">
                    Zavřít
                  </Button>
                </Grid>
                <Grid item xs={6}>
                  <ButtonContinue type="submit" fullWidth>
                    Uložit
                  </ButtonContinue>
                </Grid>
              </Grid>
            </DialogActions>
          </Form>
        )}
      </Formik>
    </Dialog>
  );
};
