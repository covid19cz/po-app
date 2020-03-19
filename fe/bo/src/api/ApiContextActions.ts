import { ActionsUnion, createAction } from "@/utils/reduxHelpers";

export const START_LOADING = "START_LOADING";
export const END_LOADING = "END_LOADING";

export const startLoading = () => createAction(START_LOADING);
export const endLoading = () => createAction(END_LOADING);

export const ApiContextActions = {
  startLoading,
  endLoading
};

export type ApiContextActions = ActionsUnion<typeof ApiContextActions>;
