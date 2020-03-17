import * as Yup from "yup";

export { Yup };

const phoneRegExp = /^((\\+[1-9]{1,4}[ \\-]*)|(\\([0-9]{2,3}\\)[ \\-]*)|([0-9]{2,4})[ \\-]*)*?[0-9]{3,4}?[ \\-]*[0-9]{3,4}?$/;

export const phoneNumberSchema = Yup.string().matches(
  phoneRegExp,
  "Neplatné telefonní číslo"
);
