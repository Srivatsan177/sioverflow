import * as yup from "yup";

export const searchSchema = yup
  .object({
    search: yup.string().optional(),
    tags: yup.array().of(yup.string()).optional(),
    page: yup.number().default(0),
    size: yup.number().default(5),
  })
  .required();
