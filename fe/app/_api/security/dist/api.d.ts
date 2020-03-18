export interface FetchAPI {
    (url: string, init?: any): Promise<any>;
}
export interface FetchArgs {
    url: string;
    options: any;
}
export declare class BaseAPI {
    basePath: string;
    fetch: FetchAPI;
    constructor(fetch?: FetchAPI, basePath?: string);
}
export interface TokenDto {
    "accessToken"?: string;
    "expiresIn"?: number;
    "refreshToken"?: string;
    "tokenType"?: string;
}
/**
 * DefaultApi - fetch parameter creator
 */
export declare const DefaultApiFetchParamCreator: {
    nullUsingPOST(params: {
        "grantType": string;
        "password"?: string;
        "refreshToken"?: string;
        "username"?: string;
    }, options?: any): FetchArgs;
};
/**
 * DefaultApi - functional programming interface
 */
export declare const DefaultApiFp: {
    nullUsingPOST(params: {
        "grantType": string;
        "password"?: string;
        "refreshToken"?: string;
        "username"?: string;
    }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<TokenDto>;
};
/**
 * DefaultApi - object-oriented interface
 */
export declare class DefaultApi extends BaseAPI {
    /**
     * Method for generate access and refresh token
     * @param grantType grant type
     * @param password password
     * @param refreshToken refresh token
     * @param username username
     */
    nullUsingPOST(params: {
        "grantType": string;
        "password"?: string;
        "refreshToken"?: string;
        "username"?: string;
    }, options?: any): Promise<TokenDto>;
}
/**
 * DefaultApi - factory interface
 */
export declare const DefaultApiFactory: (fetch?: FetchAPI, basePath?: string) => {
    nullUsingPOST(params: {
        "grantType": string;
        "password"?: string;
        "refreshToken"?: string;
        "username"?: string;
    }, options?: any): Promise<TokenDto>;
};
