import { Button as MatButton, ButtonProps as MatButtonProps } from "@material-ui/core";
import React from "react";
import styled from "styled-components";

export type ButtonProps = MatButtonProps & {
	fixedwidth?: string;
};

const ButtonFC: React.FC<ButtonProps> = props => {
	return <MatButton disableElevation {...props} />;
};

export const Button: React.FC<ButtonProps> = styled(ButtonFC)<ButtonProps>`
	min-width: ${({ fixedwidth }) => fixedwidth || null};
	max-width: ${({ fixedwidth }) => fixedwidth || null};
`;
