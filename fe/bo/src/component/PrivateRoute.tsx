import { tokenExists } from "@/api/defaults";
import { LoginPage } from "@/layout/LoginPage";
import React from "react";
import { Route, RouteProps } from "react-router-dom";

export const PrivateRoute = ({ children, ...rest }: RouteProps) => (
  <Route
    {...rest}
    children={() => (tokenExists() ? children : <LoginPage />)}
  />
);
