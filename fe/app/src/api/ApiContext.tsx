import React from "react";
import {
  ApiContextActions,
  END_LOADING,
  START_LOADING
} from "./ApiContextActions";

export type IState = typeof initialState;

const initialState = {
  loadingInProgress: 0
};

interface IApiProviderProps {
  children: React.ReactNode;
}

const ApiContext = React.createContext<IState | undefined>(undefined);
const ApiDispatchContext = React.createContext<
  ((action: ApiContextActions) => void) | undefined
>(undefined);

function apiReducer(state: IState, action: ApiContextActions): IState {
  switch (action.type) {
    case END_LOADING:
      return {
        ...state,
        loadingInProgress: Math.max(0, state.loadingInProgress - 1)
      };
    case START_LOADING:
      return { ...state, loadingInProgress: state.loadingInProgress + 1 };
    default: {
      return state;
    }
  }
}

function ApiProvider({ children }: IApiProviderProps) {
  const [state, dispatch] = React.useReducer(apiReducer, initialState);
  return (
    <ApiContext.Provider value={state}>
      <ApiDispatchContext.Provider value={dispatch}>
        {children}
      </ApiDispatchContext.Provider>
    </ApiContext.Provider>
  );
}

function useApiState() {
  const context = React.useContext(ApiContext);
  if (context === undefined) {
    throw new Error("useApiState must be used within a ApiProvider");
  }
  return context;
}

function useApiDispatch() {
  const context = React.useContext(ApiDispatchContext);
  if (context === undefined) {
    throw new Error("useApiDispatch must be used within a ApiProvider");
  }
  return context;
}

export { ApiProvider, useApiState, useApiDispatch };
