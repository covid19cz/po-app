import { tokenExists } from "@/api/defaults";
import React from "react";
import { Route, Redirect, RouteProps } from "react-router-dom";
import { Routes } from "./Routes";

export const PrivateRoute = ({ children, ...rest }: RouteProps) => (
  <Route
    {...rest}
    children={props =>
      tokenExists() ? (
        children
      ) : (
        <Redirect
          to={{
            pathname: Routes.GetPhoneNumber.link, // TODO @jv create login page?
            state: { from: props.location.pathname }
          }}
        />
      )
    }
  />
);
