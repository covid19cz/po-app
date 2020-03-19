import {Layout} from "@/components/Layout";
import React from "react";
import { useLocation } from "react-router";

export const NotFound = () => {
  const location = useLocation();
  return (
    <Layout>
      <code>{location.pathname}</code> neexistuje.
    </Layout>
  );
};
