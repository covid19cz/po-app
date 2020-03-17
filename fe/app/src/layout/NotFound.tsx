import React from "react";
import { useLocation } from "react-router";
import { Layout } from "../components/Layout";

export const NotFound = () => {
  const location = useLocation();
  return (
    <Layout>
      <code>{location.pathname}</code> neexistuje.
    </Layout>
  );
};
