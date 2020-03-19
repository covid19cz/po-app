import {PrivateRoute} from "@/component/PrivateRoute";
import React from "react";
import { BrowserRouter } from "react-router-dom";
import { ApiProvider } from "@/api/ApiContext";
import { FetchingIndicator } from "@/component/FetchingIndicator";
import { PersonsList } from "@/layout/PersonsList";
import {
  Box,
  Container,
  CssBaseline,
  StylesProvider,
  ThemeProvider
} from "@material-ui/core";
import "./App.css";
import theme from "./theme/default";

function getContextPath() {
  return "/";
}

function App() {
  return (
    <BrowserRouter basename={getContextPath()}>
      <ThemeProvider theme={theme}>
        <StylesProvider injectFirst>
          <CssBaseline />
          <ApiProvider>
            <Box className="App">
              <Container maxWidth="md">
                <FetchingIndicator />
                <PrivateRoute path="*" exact>
                  <PersonsList />
                </PrivateRoute>
              </Container>
            </Box>
          </ApiProvider>
        </StylesProvider>
      </ThemeProvider>
    </BrowserRouter>
  );
}

export default App;
