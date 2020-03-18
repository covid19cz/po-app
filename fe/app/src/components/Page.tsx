import React, { useEffect } from "react";
import { Route, RouteProps } from "react-router";

export type PageProps = RouteProps & {
  title: string;
  link: string;
  protected?: boolean;
};

export const Page: React.FC<PageProps> = props => {
  useEffect(() => {
    document.title = "Portál občana | " + props.title;
  });
  const { title, ...rest } = props;
  return <Route {...rest} />;
};
