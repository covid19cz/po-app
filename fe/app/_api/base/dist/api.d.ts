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
export interface CodebookValueDto {
    "code"?: string;
    "createdAt"?: Date;
    "id"?: number;
    "modifiedAt"?: Date;
    "name"?: string;
}
/**
 * CodebookcontrollerApi - fetch parameter creator
 */
export declare const CodebookcontrollerApiFetchParamCreator: {
    createCodebookValueUsingPOST(params: {
        "codebookName": string;
        "codebookValueDto": CodebookValueDto;
    }, options?: any): FetchArgs;
    deleteCodebookValueUsingDELETE(params: {
        "codebookName": string;
        "id": number;
    }, options?: any): FetchArgs;
    findCodebookValuesUsingGET(params: {
        "codebookName": string;
        "id": number;
    }, options?: any): FetchArgs;
    getCodebookValuesUsingGET(params: {
        "codebookName": string;
    }, options?: any): FetchArgs;
    updateCodebookValueUsingPUT(params: {
        "codebookName": string;
        "codebookValueDto": CodebookValueDto;
        "id": number;
    }, options?: any): FetchArgs;
};
/**
 * CodebookcontrollerApi - functional programming interface
 */
export declare const CodebookcontrollerApiFp: {
    createCodebookValueUsingPOST(params: {
        "codebookName": string;
        "codebookValueDto": CodebookValueDto;
    }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<CodebookValueDto>;
    deleteCodebookValueUsingDELETE(params: {
        "codebookName": string;
        "id": number;
    }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<any>;
    findCodebookValuesUsingGET(params: {
        "codebookName": string;
        "id": number;
    }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<CodebookValueDto>;
    getCodebookValuesUsingGET(params: {
        "codebookName": string;
    }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<CodebookValueDto[]>;
    updateCodebookValueUsingPUT(params: {
        "codebookName": string;
        "codebookValueDto": CodebookValueDto;
        "id": number;
    }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<CodebookValueDto>;
};
/**
 * CodebookcontrollerApi - object-oriented interface
 */
export declare class CodebookcontrollerApi extends BaseAPI {
    /**
     *
     * @summary createCodebookValue
     * @param codebookName codebookName
     * @param codebookValueDto codebookValueDto
     */
    createCodebookValueUsingPOST(params: {
        "codebookName": string;
        "codebookValueDto": CodebookValueDto;
    }, options?: any): Promise<CodebookValueDto>;
    /**
     *
     * @summary deleteCodebookValue
     * @param codebookName codebookName
     * @param id id
     */
    deleteCodebookValueUsingDELETE(params: {
        "codebookName": string;
        "id": number;
    }, options?: any): Promise<any>;
    /**
     *
     * @summary findCodebookValues
     * @param codebookName codebookName
     * @param id id
     */
    findCodebookValuesUsingGET(params: {
        "codebookName": string;
        "id": number;
    }, options?: any): Promise<CodebookValueDto>;
    /**
     *
     * @summary getCodebookValues
     * @param codebookName codebookName
     */
    getCodebookValuesUsingGET(params: {
        "codebookName": string;
    }, options?: any): Promise<CodebookValueDto[]>;
    /**
     *
     * @summary updateCodebookValue
     * @param codebookName codebookName
     * @param codebookValueDto codebookValueDto
     * @param id id
     */
    updateCodebookValueUsingPUT(params: {
        "codebookName": string;
        "codebookValueDto": CodebookValueDto;
        "id": number;
    }, options?: any): Promise<CodebookValueDto>;
}
/**
 * CodebookcontrollerApi - factory interface
 */
export declare const CodebookcontrollerApiFactory: (fetch?: FetchAPI, basePath?: string) => {
    createCodebookValueUsingPOST(params: {
        "codebookName": string;
        "codebookValueDto": CodebookValueDto;
    }, options?: any): Promise<CodebookValueDto>;
    deleteCodebookValueUsingDELETE(params: {
        "codebookName": string;
        "id": number;
    }, options?: any): Promise<any>;
    findCodebookValuesUsingGET(params: {
        "codebookName": string;
        "id": number;
    }, options?: any): Promise<CodebookValueDto>;
    getCodebookValuesUsingGET(params: {
        "codebookName": string;
    }, options?: any): Promise<CodebookValueDto[]>;
    updateCodebookValueUsingPUT(params: {
        "codebookName": string;
        "codebookValueDto": CodebookValueDto;
        "id": number;
    }, options?: any): Promise<CodebookValueDto>;
};
