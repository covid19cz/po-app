import DateFnsUtils from "@date-io/date-fns";
import { MuiPickersUtilsProvider } from "@material-ui/pickers";
import React from "react";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import {
  Box,
  Container,
  CssBaseline,
  StylesProvider,
  ThemeProvider
} from "@material-ui/core";
import "./App.css";
import { ApiProvider } from "./api/ApiContext";
import { FetchingIndicator } from "./components/FetchingIndicator";
import { Header } from "./components/Header";
import { Page } from "./components/Page";
import { PrivateRoute } from "./components/PrivateRoute";
import { Routes } from "./components/Routes";
import { NotFound } from "./layout/NotFound";
import theme from "./theme/default";

function getContextPath() {
  return "/";
}

const App = () => {
  return (
    <BrowserRouter basename={getContextPath()}>
      <MuiPickersUtilsProvider utils={DateFnsUtils}>
        <ThemeProvider theme={theme}>
          <StylesProvider injectFirst>
            <CssBaseline />
            <ApiProvider>
              <Box className="App">
                <Container maxWidth="md">
                  <FetchingIndicator />
                  <header>
                    <Header />
                  </header>
                  <Switch>
                    {Object.values(Routes).map(path => {
                      if (path.protected) {
                        return (
                          <PrivateRoute
                            key={path.link}
                            path={path.link}
                            {...path}
                          />
                        );
                      }

                      return (
                        <Page key={path.link} path={path.link} {...path} />
                      );
                    })}
                    <Route path="*" exact>
                      <NotFound />
                    </Route>
                  </Switch>
                </Container>
              </Box>
            </ApiProvider>
          </StylesProvider>
        </ThemeProvider>
      </MuiPickersUtilsProvider>
    </BrowserRouter>
  );
};

export default App;
