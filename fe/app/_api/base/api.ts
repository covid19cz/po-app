/**
 * Covid19 Citizen Portal
 * Covid19 Citizen Portal
 *
 * OpenAPI spec version: 0.0.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

import * as querystring from "querystring";
import * as url from "url";

import * as isomorphicFetch from "isomorphic-fetch";
import * as assign from "core-js/library/fn/object/assign";

interface Dictionary<T> { [index: string]: T; }
export interface FetchAPI { (url: string, init?: any): Promise<any>; }

const BASE_PATH = "https://covid19.int.xcp/api/v1".replace(/\/+$/, "");

export interface FetchArgs {
    url: string;
    options: any;
}

export class BaseAPI {
    basePath: string;
    fetch: FetchAPI;

    constructor(fetch: FetchAPI = isomorphicFetch, basePath: string = BASE_PATH) {
        this.basePath = basePath;
        this.fetch = fetch;
    }
};

export interface Address {
    "street"?: string;
    "streetNumberDescriptive"?: string;
    "streetNumberEvidence"?: string;
    "city"?: string;
    "zipCode"?: string;
}

export interface CodebookItemDto {
    "code"?: string;
    "default"?: boolean;
    "order"?: number;
    "text"?: string;
}

export interface ErrorMessageDto {
    "additionalMessages"?: any;
    "errorCode"?: ErrorMessageDtoErrorCodeEnum;
    "message"?: string;
}

export type ErrorMessageDtoErrorCodeEnum = "SMS_CODE_GEN_ERROR" | "UNAUTHORIZED" | "UNKNOWN" | "ERROR_LOGIN_REQUIRED" | "VALIDATION_FAILED";
export interface ExposureRequest {
    "infectedInContact"?: ExposureRequestInfectedInContactEnum;
    "infectedInContactDate"?: Date;
    "infectedPhoneNumbers"?: string;
    "visitedRiskArea"?: CodebookItemDto;
}

export type ExposureRequestInfectedInContactEnum = "Y" | "N" | "?";
export interface HealthCheckDto {
    "symtompsSince"?: Date;
    "highTemperatureDuration"?: SymptomEnum;
    "dryCoughDuration"?: SymptomEnum;
    "headache"?: boolean;
    "infectedInContact"?: string;
    "infectedInContactDate"?: Date;
    "infectedPhoneNumbers"?: string;
    "preferredHealthCheckLocation"?: CodebookItemDto;
    "ableToDrive"?: boolean;
    "healthCheckCode"?: string;
    "healthCheckType"?: CodebookItemDto;
    "finalHealthCheckLocation"?: CodebookItemDto;
    "healthCheckResults"?: Array<HealthCheckResultDto>;
    "visitedRiskArea"?: CodebookItemDto;
}

export interface HealthCheckRequest {
    "symtompsSince"?: Date;
    "highTemperatureDuration"?: number;
    "dryCoughDuration"?: number;
    "headache"?: boolean;
    "infectedInContact"?: HealthCheckRequestInfectedInContactEnum;
    "infectedInContactDate"?: Date;
    "infectedPhoneNumbers"?: string;
    "visitedRiskArea"?: CodebookItemDto;
    "preferredHealthCheckLocation"?: CodebookItemDto;
    "ableToDrive"?: boolean;
}

export type HealthCheckRequestInfectedInContactEnum = "Y" | "N" | "?";
export interface HealthCheckResponse {
    "timeSlot"?: string;
    "address"?: string;
    "healthCheckCode"?: string;
}

export interface HealthCheckResultDto {
    "positive"?: boolean;
    "testDate"?: Date;
    "resultSentAt"?: Date;
}

export interface PersonRequest {
    "firstname"?: string;
    "surname"?: string;
    "addressHome"?: Address;
    "email"?: string;
}

export interface PersonResponse {
    "personUid"?: string;
    "returnHash"?: string;
    "phoneNumber"?: string;
    "firstname"?: string;
    "surname"?: string;
    "addressHome"?: Address;
    "email"?: string;
    "healthStatus"?: CodebookItemDto;
    "healthStatusLastChange"?: Date;
}

export interface SendCodeRequest {
    /**
     * Phone number
     */
    "phoneNumber"?: string;
}

export interface SendCodeResponse {
    /**
     * Unique Person's ID (person_uid.person)
     */
    "personUid"?: string;
}

export type SymptomEnum = "NONE" | "MORE" | "ONE_OR_TWO" | "THREE_OR_FOUR";

export interface SymptomsRequest {
    "symtomsSince"?: Date;
    "highTemperatureDuration"?: SymptomEnum;
    "dryCoughDuration"?: SymptomEnum;
    "headache"?: boolean;
}

export interface TestingPlaceInstuctionsDto {
    "address"?: Address;
    "openingHours"?: string;
}

export interface TestingPlaceRequest {
    "preferredHealthCheckLocation"?: CodebookItemDto;
    "ableToDrive"?: boolean;
}

export interface TreatmentRequest {
    "place"?: CodebookItemDto;
    "address"?: Address;
    "healthCheckDate"?: Date;
    "healthCheckLocation"?: CodebookItemDto;
    "expectedInfectionDate"?: Date;
    "inContactPhoneNumbers"?: string;
}

/**
 * Sms code verification response
 */
export interface VerifyCodeResponseDto {
    /**
     * New password
     */
    "password"?: string;
}



/**
 * AuthorizationcontrollerApi - fetch parameter creator
 */
export const AuthorizationcontrollerApiFetchParamCreator = {
    /**
     * 
     * @summary Sent SMS with auth code
     * @param sendCodeRequest send sms login request dto
     */
    sendCodeUsingPOST(params: {  "sendCodeRequest": SendCodeRequest; }, options?: any): FetchArgs {
        // verify required parameter "sendCodeRequest" is set
        if (params["sendCodeRequest"] == null) {
            throw new Error("Missing required parameter sendCodeRequest when calling sendCodeUsingPOST");
        }
        const baseUrl = `/authorizations/send-code`;
        let urlObj = url.parse(baseUrl, true);
        let fetchOptions: RequestInit = assign({}, { method: "POST" }, options);

        let contentTypeHeader: Dictionary<string> = {};
        contentTypeHeader = { "Content-Type": "application/json" };
        if (params["sendCodeRequest"]) {
            fetchOptions.body = JSON.stringify(params["sendCodeRequest"] || {});
        }
        if (contentTypeHeader) {
            fetchOptions.headers = assign({}, contentTypeHeader, fetchOptions.headers);
        }
        return {
            url: url.format(urlObj),
            options: fetchOptions,
        };
    },
    /**
     * 
     * @summary Verify code from SMS
     * @param personUid Uid of person
     * @param smsCode Code received in SMS
     */
    verifyCodeUsingPOST(params: {  "personUid"?: string; "smsCode"?: string; }, options?: any): FetchArgs {
        const baseUrl = `/authorizations/verify-code`;
        let urlObj = url.parse(baseUrl, true);
        urlObj.query = assign({}, urlObj.query, {
            "personUid": params["personUid"],
            "smsCode": params["smsCode"],
        });
        let fetchOptions: RequestInit = assign({}, { method: "POST" }, options);

        let contentTypeHeader: Dictionary<string> = {};
        if (contentTypeHeader) {
            fetchOptions.headers = assign({}, contentTypeHeader, fetchOptions.headers);
        }
        return {
            url: url.format(urlObj),
            options: fetchOptions,
        };
    },
};

/**
 * AuthorizationcontrollerApi - functional programming interface
 */
export const AuthorizationcontrollerApiFp = {
    /**
     * 
     * @summary Sent SMS with auth code
     * @param sendCodeRequest send sms login request dto
     */
    sendCodeUsingPOST(params: { "sendCodeRequest": SendCodeRequest;  }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<SendCodeResponse> {
        const fetchArgs = AuthorizationcontrollerApiFetchParamCreator.sendCodeUsingPOST(params, options);
        return (fetch: FetchAPI = isomorphicFetch, basePath: string = BASE_PATH) => {
            return fetch(basePath + fetchArgs.url, fetchArgs.options).then((response) => {
                if (response.status >= 200 && response.status < 300) {
                    return response.json();
                } else {
                    throw response;
                }
            });
        };
    },
    /**
     * 
     * @summary Verify code from SMS
     * @param personUid Uid of person
     * @param smsCode Code received in SMS
     */
    verifyCodeUsingPOST(params: { "personUid"?: string; "smsCode"?: string;  }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<VerifyCodeResponseDto> {
        const fetchArgs = AuthorizationcontrollerApiFetchParamCreator.verifyCodeUsingPOST(params, options);
        return (fetch: FetchAPI = isomorphicFetch, basePath: string = BASE_PATH) => {
            return fetch(basePath + fetchArgs.url, fetchArgs.options).then((response) => {
                if (response.status >= 200 && response.status < 300) {
                    return response.json();
                } else {
                    throw response;
                }
            });
        };
    },
};

/**
 * AuthorizationcontrollerApi - object-oriented interface
 */
export class AuthorizationcontrollerApi extends BaseAPI {
    /**
     * 
     * @summary Sent SMS with auth code
     * @param sendCodeRequest send sms login request dto
     */
    sendCodeUsingPOST(params: {  "sendCodeRequest": SendCodeRequest; }, options?: any) {
        return AuthorizationcontrollerApiFp.sendCodeUsingPOST(params, options)(this.fetch, this.basePath);
    }
    /**
     * 
     * @summary Verify code from SMS
     * @param personUid Uid of person
     * @param smsCode Code received in SMS
     */
    verifyCodeUsingPOST(params: {  "personUid"?: string; "smsCode"?: string; }, options?: any) {
        return AuthorizationcontrollerApiFp.verifyCodeUsingPOST(params, options)(this.fetch, this.basePath);
    }
};

/**
 * AuthorizationcontrollerApi - factory interface
 */
export const AuthorizationcontrollerApiFactory = function (fetch?: FetchAPI, basePath?: string) {
    return {
        /**
         * 
         * @summary Sent SMS with auth code
         * @param sendCodeRequest send sms login request dto
         */
        sendCodeUsingPOST(params: {  "sendCodeRequest": SendCodeRequest; }, options?: any) {
            return AuthorizationcontrollerApiFp.sendCodeUsingPOST(params, options)(fetch, basePath);
        },
        /**
         * 
         * @summary Verify code from SMS
         * @param personUid Uid of person
         * @param smsCode Code received in SMS
         */
        verifyCodeUsingPOST(params: {  "personUid"?: string; "smsCode"?: string; }, options?: any) {
            return AuthorizationcontrollerApiFp.verifyCodeUsingPOST(params, options)(fetch, basePath);
        },
    };
};


/**
 * CodebookcontrollerApi - fetch parameter creator
 */
export const CodebookcontrollerApiFetchParamCreator = {
    /**
     * 
     * @summary getCodebookItems
     * @param codebook Codebook code
     */
    getCodebookItemsUsingGET(params: {  "codebook": string; }, options?: any): FetchArgs {
        // verify required parameter "codebook" is set
        if (params["codebook"] == null) {
            throw new Error("Missing required parameter codebook when calling getCodebookItemsUsingGET");
        }
        const baseUrl = `/codebooks/{codebook}`
            .replace(`{${"codebook"}}`, `${ params["codebook"] }`);
        let urlObj = url.parse(baseUrl, true);
        let fetchOptions: RequestInit = assign({}, { method: "GET" }, options);

        let contentTypeHeader: Dictionary<string> = {};
        if (contentTypeHeader) {
            fetchOptions.headers = assign({}, contentTypeHeader, fetchOptions.headers);
        }
        return {
            url: url.format(urlObj),
            options: fetchOptions,
        };
    },
};

/**
 * CodebookcontrollerApi - functional programming interface
 */
export const CodebookcontrollerApiFp = {
    /**
     * 
     * @summary getCodebookItems
     * @param codebook Codebook code
     */
    getCodebookItemsUsingGET(params: { "codebook": string;  }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<Array<CodebookItemDto>> {
        const fetchArgs = CodebookcontrollerApiFetchParamCreator.getCodebookItemsUsingGET(params, options);
        return (fetch: FetchAPI = isomorphicFetch, basePath: string = BASE_PATH) => {
            return fetch(basePath + fetchArgs.url, fetchArgs.options).then((response) => {
                if (response.status >= 200 && response.status < 300) {
                    return response.json();
                } else {
                    throw response;
                }
            });
        };
    },
};

/**
 * CodebookcontrollerApi - object-oriented interface
 */
export class CodebookcontrollerApi extends BaseAPI {
    /**
     * 
     * @summary getCodebookItems
     * @param codebook Codebook code
     */
    getCodebookItemsUsingGET(params: {  "codebook": string; }, options?: any) {
        return CodebookcontrollerApiFp.getCodebookItemsUsingGET(params, options)(this.fetch, this.basePath);
    }
};

/**
 * CodebookcontrollerApi - factory interface
 */
export const CodebookcontrollerApiFactory = function (fetch?: FetchAPI, basePath?: string) {
    return {
        /**
         * 
         * @summary getCodebookItems
         * @param codebook Codebook code
         */
        getCodebookItemsUsingGET(params: {  "codebook": string; }, options?: any) {
            return CodebookcontrollerApiFp.getCodebookItemsUsingGET(params, options)(fetch, basePath);
        },
    };
};


/**
 * HealthcheckcontrollerApi - fetch parameter creator
 */
export const HealthcheckcontrollerApiFetchParamCreator = {
    /**
     * 
     * @summary Add result of a health check test
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     * @param testResultDto Health check test result
     */
    postHeathCheckTestResult(params: {  "personUid": string; "testResultDto": HealthCheckResultDto; }, options?: any): FetchArgs {
        // verify required parameter "personUid" is set
        if (params["personUid"] == null) {
            throw new Error("Missing required parameter personUid when calling postHeathCheckTestResult");
        }
        // verify required parameter "testResultDto" is set
        if (params["testResultDto"] == null) {
            throw new Error("Missing required parameter testResultDto when calling postHeathCheckTestResult");
        }
        const baseUrl = `/bo/persons/{personUid}/health-check/test-result`
            .replace(`{${"personUid"}}`, `${ params["personUid"] }`);
        let urlObj = url.parse(baseUrl, true);
        let fetchOptions: RequestInit = assign({}, { method: "POST" }, options);

        let contentTypeHeader: Dictionary<string> = {};
        contentTypeHeader = { "Content-Type": "application/json" };
        if (params["testResultDto"]) {
            fetchOptions.body = JSON.stringify(params["testResultDto"] || {});
        }
        if (contentTypeHeader) {
            fetchOptions.headers = assign({}, contentTypeHeader, fetchOptions.headers);
        }
        return {
            url: url.format(urlObj),
            options: fetchOptions,
        };
    },
    /**
     * 
     * @summary Fills exposure form
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     * @param exposureDto Health check&#39;s data - exposure
     */
    putHealthCheckExposure(params: {  "personUid": string; "exposureDto": ExposureRequest; }, options?: any): FetchArgs {
        // verify required parameter "personUid" is set
        if (params["personUid"] == null) {
            throw new Error("Missing required parameter personUid when calling putHealthCheckExposure");
        }
        // verify required parameter "exposureDto" is set
        if (params["exposureDto"] == null) {
            throw new Error("Missing required parameter exposureDto when calling putHealthCheckExposure");
        }
        const baseUrl = `/app/persons/{personUid}/health-check/exposure`
            .replace(`{${"personUid"}}`, `${ params["personUid"] }`);
        let urlObj = url.parse(baseUrl, true);
        let fetchOptions: RequestInit = assign({}, { method: "PUT" }, options);

        let contentTypeHeader: Dictionary<string> = {};
        contentTypeHeader = { "Content-Type": "application/json" };
        if (params["exposureDto"]) {
            fetchOptions.body = JSON.stringify(params["exposureDto"] || {});
        }
        if (contentTypeHeader) {
            fetchOptions.headers = assign({}, contentTypeHeader, fetchOptions.headers);
        }
        return {
            url: url.format(urlObj),
            options: fetchOptions,
        };
    },
    /**
     * 
     * @summary Fills actual health check form
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     * @param symptomsDto Health check&#39;s data - simptoms
     */
    putHealthCheckSymptoms(params: {  "personUid": string; "symptomsDto": SymptomsRequest; }, options?: any): FetchArgs {
        // verify required parameter "personUid" is set
        if (params["personUid"] == null) {
            throw new Error("Missing required parameter personUid when calling putHealthCheckSymptoms");
        }
        // verify required parameter "symptomsDto" is set
        if (params["symptomsDto"] == null) {
            throw new Error("Missing required parameter symptomsDto when calling putHealthCheckSymptoms");
        }
        const baseUrl = `/app/persons/{personUid}/health-check/symptoms`
            .replace(`{${"personUid"}}`, `${ params["personUid"] }`);
        let urlObj = url.parse(baseUrl, true);
        let fetchOptions: RequestInit = assign({}, { method: "PUT" }, options);

        let contentTypeHeader: Dictionary<string> = {};
        contentTypeHeader = { "Content-Type": "application/json" };
        if (params["symptomsDto"]) {
            fetchOptions.body = JSON.stringify(params["symptomsDto"] || {});
        }
        if (contentTypeHeader) {
            fetchOptions.headers = assign({}, contentTypeHeader, fetchOptions.headers);
        }
        return {
            url: url.format(urlObj),
            options: fetchOptions,
        };
    },
    /**
     * 
     * @summary Fills testing place form
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     * @param testingPlaceDto Health check&#39;s data - testing place
     */
    putHealthCheckTestingPlace(params: {  "personUid": string; "testingPlaceDto": TestingPlaceRequest; }, options?: any): FetchArgs {
        // verify required parameter "personUid" is set
        if (params["personUid"] == null) {
            throw new Error("Missing required parameter personUid when calling putHealthCheckTestingPlace");
        }
        // verify required parameter "testingPlaceDto" is set
        if (params["testingPlaceDto"] == null) {
            throw new Error("Missing required parameter testingPlaceDto when calling putHealthCheckTestingPlace");
        }
        const baseUrl = `/app/persons/{personUid}/health-check/testing-place`
            .replace(`{${"personUid"}}`, `${ params["personUid"] }`);
        let urlObj = url.parse(baseUrl, true);
        let fetchOptions: RequestInit = assign({}, { method: "PUT" }, options);

        let contentTypeHeader: Dictionary<string> = {};
        contentTypeHeader = { "Content-Type": "application/json" };
        if (params["testingPlaceDto"]) {
            fetchOptions.body = JSON.stringify(params["testingPlaceDto"] || {});
        }
        if (contentTypeHeader) {
            fetchOptions.headers = assign({}, contentTypeHeader, fetchOptions.headers);
        }
        return {
            url: url.format(urlObj),
            options: fetchOptions,
        };
    },
};

/**
 * HealthcheckcontrollerApi - functional programming interface
 */
export const HealthcheckcontrollerApiFp = {
    /**
     * 
     * @summary Add result of a health check test
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     * @param testResultDto Health check test result
     */
    postHeathCheckTestResult(params: { "personUid": string; "testResultDto": HealthCheckResultDto;  }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<HealthCheckDto> {
        const fetchArgs = HealthcheckcontrollerApiFetchParamCreator.postHeathCheckTestResult(params, options);
        return (fetch: FetchAPI = isomorphicFetch, basePath: string = BASE_PATH) => {
            return fetch(basePath + fetchArgs.url, fetchArgs.options).then((response) => {
                if (response.status >= 200 && response.status < 300) {
                    return response.json();
                } else {
                    throw response;
                }
            });
        };
    },
    /**
     * 
     * @summary Fills exposure form
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     * @param exposureDto Health check&#39;s data - exposure
     */
    putHealthCheckExposure(params: { "personUid": string; "exposureDto": ExposureRequest;  }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<any> {
        const fetchArgs = HealthcheckcontrollerApiFetchParamCreator.putHealthCheckExposure(params, options);
        return (fetch: FetchAPI = isomorphicFetch, basePath: string = BASE_PATH) => {
            return fetch(basePath + fetchArgs.url, fetchArgs.options).then((response) => {
                if (response.status >= 200 && response.status < 300) {
                    return response;
                } else {
                    throw response;
                }
            });
        };
    },
    /**
     * 
     * @summary Fills actual health check form
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     * @param symptomsDto Health check&#39;s data - simptoms
     */
    putHealthCheckSymptoms(params: { "personUid": string; "symptomsDto": SymptomsRequest;  }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<any> {
        const fetchArgs = HealthcheckcontrollerApiFetchParamCreator.putHealthCheckSymptoms(params, options);
        return (fetch: FetchAPI = isomorphicFetch, basePath: string = BASE_PATH) => {
            return fetch(basePath + fetchArgs.url, fetchArgs.options).then((response) => {
                if (response.status >= 200 && response.status < 300) {
                    return response;
                } else {
                    throw response;
                }
            });
        };
    },
    /**
     * 
     * @summary Fills testing place form
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     * @param testingPlaceDto Health check&#39;s data - testing place
     */
    putHealthCheckTestingPlace(params: { "personUid": string; "testingPlaceDto": TestingPlaceRequest;  }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<TestingPlaceInstuctionsDto> {
        const fetchArgs = HealthcheckcontrollerApiFetchParamCreator.putHealthCheckTestingPlace(params, options);
        return (fetch: FetchAPI = isomorphicFetch, basePath: string = BASE_PATH) => {
            return fetch(basePath + fetchArgs.url, fetchArgs.options).then((response) => {
                if (response.status >= 200 && response.status < 300) {
                    return response.json();
                } else {
                    throw response;
                }
            });
        };
    },
};

/**
 * HealthcheckcontrollerApi - object-oriented interface
 */
export class HealthcheckcontrollerApi extends BaseAPI {
    /**
     * 
     * @summary Add result of a health check test
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     * @param testResultDto Health check test result
     */
    postHeathCheckTestResult(params: {  "personUid": string; "testResultDto": HealthCheckResultDto; }, options?: any) {
        return HealthcheckcontrollerApiFp.postHeathCheckTestResult(params, options)(this.fetch, this.basePath);
    }
    /**
     * 
     * @summary Fills exposure form
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     * @param exposureDto Health check&#39;s data - exposure
     */
    putHealthCheckExposure(params: {  "personUid": string; "exposureDto": ExposureRequest; }, options?: any) {
        return HealthcheckcontrollerApiFp.putHealthCheckExposure(params, options)(this.fetch, this.basePath);
    }
    /**
     * 
     * @summary Fills actual health check form
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     * @param symptomsDto Health check&#39;s data - simptoms
     */
    putHealthCheckSymptoms(params: {  "personUid": string; "symptomsDto": SymptomsRequest; }, options?: any) {
        return HealthcheckcontrollerApiFp.putHealthCheckSymptoms(params, options)(this.fetch, this.basePath);
    }
    /**
     * 
     * @summary Fills testing place form
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     * @param testingPlaceDto Health check&#39;s data - testing place
     */
    putHealthCheckTestingPlace(params: {  "personUid": string; "testingPlaceDto": TestingPlaceRequest; }, options?: any) {
        return HealthcheckcontrollerApiFp.putHealthCheckTestingPlace(params, options)(this.fetch, this.basePath);
    }
};

/**
 * HealthcheckcontrollerApi - factory interface
 */
export const HealthcheckcontrollerApiFactory = function (fetch?: FetchAPI, basePath?: string) {
    return {
        /**
         * 
         * @summary Add result of a health check test
         * @param personUid Unique Person&#39;s ID (person_uid.person)
         * @param testResultDto Health check test result
         */
        postHeathCheckTestResult(params: {  "personUid": string; "testResultDto": HealthCheckResultDto; }, options?: any) {
            return HealthcheckcontrollerApiFp.postHeathCheckTestResult(params, options)(fetch, basePath);
        },
        /**
         * 
         * @summary Fills exposure form
         * @param personUid Unique Person&#39;s ID (person_uid.person)
         * @param exposureDto Health check&#39;s data - exposure
         */
        putHealthCheckExposure(params: {  "personUid": string; "exposureDto": ExposureRequest; }, options?: any) {
            return HealthcheckcontrollerApiFp.putHealthCheckExposure(params, options)(fetch, basePath);
        },
        /**
         * 
         * @summary Fills actual health check form
         * @param personUid Unique Person&#39;s ID (person_uid.person)
         * @param symptomsDto Health check&#39;s data - simptoms
         */
        putHealthCheckSymptoms(params: {  "personUid": string; "symptomsDto": SymptomsRequest; }, options?: any) {
            return HealthcheckcontrollerApiFp.putHealthCheckSymptoms(params, options)(fetch, basePath);
        },
        /**
         * 
         * @summary Fills testing place form
         * @param personUid Unique Person&#39;s ID (person_uid.person)
         * @param testingPlaceDto Health check&#39;s data - testing place
         */
        putHealthCheckTestingPlace(params: {  "personUid": string; "testingPlaceDto": TestingPlaceRequest; }, options?: any) {
            return HealthcheckcontrollerApiFp.putHealthCheckTestingPlace(params, options)(fetch, basePath);
        },
    };
};


/**
 * PersoncontrollerApi - fetch parameter creator
 */
export const PersoncontrollerApiFetchParamCreator = {
    /**
     * 
     * @summary GET all persons
     */
    getAllPersons(options?: any): FetchArgs {
        const baseUrl = `/bo/persons/`;
        let urlObj = url.parse(baseUrl, true);
        let fetchOptions: RequestInit = assign({}, { method: "GET" }, options);

        let contentTypeHeader: Dictionary<string> = {};
        if (contentTypeHeader) {
            fetchOptions.headers = assign({}, contentTypeHeader, fetchOptions.headers);
        }
        return {
            url: url.format(urlObj),
            options: fetchOptions,
        };
    },
    /**
     * 
     * @summary GET actual person and health status
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     */
    getPerson(params: {  "personUid": string; }, options?: any): FetchArgs {
        // verify required parameter "personUid" is set
        if (params["personUid"] == null) {
            throw new Error("Missing required parameter personUid when calling getPerson");
        }
        const baseUrl = `/app/persons/{personUid}`
            .replace(`{${"personUid"}}`, `${ params["personUid"] }`);
        let urlObj = url.parse(baseUrl, true);
        let fetchOptions: RequestInit = assign({}, { method: "GET" }, options);

        let contentTypeHeader: Dictionary<string> = {};
        if (contentTypeHeader) {
            fetchOptions.headers = assign({}, contentTypeHeader, fetchOptions.headers);
        }
        return {
            url: url.format(urlObj),
            options: fetchOptions,
        };
    },
    /**
     * 
     * @summary Updates actual person's and health status
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     * @param personDto Person&#39;s data
     */
    putPerson(params: {  "personUid": string; "personDto": PersonRequest; }, options?: any): FetchArgs {
        // verify required parameter "personUid" is set
        if (params["personUid"] == null) {
            throw new Error("Missing required parameter personUid when calling putPerson");
        }
        // verify required parameter "personDto" is set
        if (params["personDto"] == null) {
            throw new Error("Missing required parameter personDto when calling putPerson");
        }
        const baseUrl = `/app/persons/{personUid}`
            .replace(`{${"personUid"}}`, `${ params["personUid"] }`);
        let urlObj = url.parse(baseUrl, true);
        let fetchOptions: RequestInit = assign({}, { method: "PUT" }, options);

        let contentTypeHeader: Dictionary<string> = {};
        contentTypeHeader = { "Content-Type": "application/json" };
        if (params["personDto"]) {
            fetchOptions.body = JSON.stringify(params["personDto"] || {});
        }
        if (contentTypeHeader) {
            fetchOptions.headers = assign({}, contentTypeHeader, fetchOptions.headers);
        }
        return {
            url: url.format(urlObj),
            options: fetchOptions,
        };
    },
};

/**
 * PersoncontrollerApi - functional programming interface
 */
export const PersoncontrollerApiFp = {
    /**
     * 
     * @summary GET all persons
     */
    getAllPersons(options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<Array<PersonResponse>> {
        const fetchArgs = PersoncontrollerApiFetchParamCreator.getAllPersons(options);
        return (fetch: FetchAPI = isomorphicFetch, basePath: string = BASE_PATH) => {
            return fetch(basePath + fetchArgs.url, fetchArgs.options).then((response) => {
                if (response.status >= 200 && response.status < 300) {
                    return response.json();
                } else {
                    throw response;
                }
            });
        };
    },
    /**
     * 
     * @summary GET actual person and health status
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     */
    getPerson(params: { "personUid": string;  }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<PersonResponse> {
        const fetchArgs = PersoncontrollerApiFetchParamCreator.getPerson(params, options);
        return (fetch: FetchAPI = isomorphicFetch, basePath: string = BASE_PATH) => {
            return fetch(basePath + fetchArgs.url, fetchArgs.options).then((response) => {
                if (response.status >= 200 && response.status < 300) {
                    return response.json();
                } else {
                    throw response;
                }
            });
        };
    },
    /**
     * 
     * @summary Updates actual person's and health status
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     * @param personDto Person&#39;s data
     */
    putPerson(params: { "personUid": string; "personDto": PersonRequest;  }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<PersonResponse> {
        const fetchArgs = PersoncontrollerApiFetchParamCreator.putPerson(params, options);
        return (fetch: FetchAPI = isomorphicFetch, basePath: string = BASE_PATH) => {
            return fetch(basePath + fetchArgs.url, fetchArgs.options).then((response) => {
                if (response.status >= 200 && response.status < 300) {
                    return response.json();
                } else {
                    throw response;
                }
            });
        };
    },
};

/**
 * PersoncontrollerApi - object-oriented interface
 */
export class PersoncontrollerApi extends BaseAPI {
    /**
     * 
     * @summary GET all persons
     */
    getAllPersons(options?: any) {
        return PersoncontrollerApiFp.getAllPersons(options)(this.fetch, this.basePath);
    }
    /**
     * 
     * @summary GET actual person and health status
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     */
    getPerson(params: {  "personUid": string; }, options?: any) {
        return PersoncontrollerApiFp.getPerson(params, options)(this.fetch, this.basePath);
    }
    /**
     * 
     * @summary Updates actual person's and health status
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     * @param personDto Person&#39;s data
     */
    putPerson(params: {  "personUid": string; "personDto": PersonRequest; }, options?: any) {
        return PersoncontrollerApiFp.putPerson(params, options)(this.fetch, this.basePath);
    }
};

/**
 * PersoncontrollerApi - factory interface
 */
export const PersoncontrollerApiFactory = function (fetch?: FetchAPI, basePath?: string) {
    return {
        /**
         * 
         * @summary GET all persons
         */
        getAllPersons(options?: any) {
            return PersoncontrollerApiFp.getAllPersons(options)(fetch, basePath);
        },
        /**
         * 
         * @summary GET actual person and health status
         * @param personUid Unique Person&#39;s ID (person_uid.person)
         */
        getPerson(params: {  "personUid": string; }, options?: any) {
            return PersoncontrollerApiFp.getPerson(params, options)(fetch, basePath);
        },
        /**
         * 
         * @summary Updates actual person's and health status
         * @param personUid Unique Person&#39;s ID (person_uid.person)
         * @param personDto Person&#39;s data
         */
        putPerson(params: {  "personUid": string; "personDto": PersonRequest; }, options?: any) {
            return PersoncontrollerApiFp.putPerson(params, options)(fetch, basePath);
        },
    };
};


/**
 * TreatmentcontrollerApi - fetch parameter creator
 */
export const TreatmentcontrollerApiFetchParamCreator = {
    /**
     * 
     * @summary Fills actual data about treatment for covid19 positive patients
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     * @param treatmentDto Treatment&#39;s data
     */
    putTreatment(params: {  "personUid": string; "treatmentDto": TreatmentRequest; }, options?: any): FetchArgs {
        // verify required parameter "personUid" is set
        if (params["personUid"] == null) {
            throw new Error("Missing required parameter personUid when calling putTreatment");
        }
        // verify required parameter "treatmentDto" is set
        if (params["treatmentDto"] == null) {
            throw new Error("Missing required parameter treatmentDto when calling putTreatment");
        }
        const baseUrl = `/app/persons/{personUid}/treatment`
            .replace(`{${"personUid"}}`, `${ params["personUid"] }`);
        let urlObj = url.parse(baseUrl, true);
        let fetchOptions: RequestInit = assign({}, { method: "PUT" }, options);

        let contentTypeHeader: Dictionary<string> = {};
        contentTypeHeader = { "Content-Type": "application/json" };
        if (params["treatmentDto"]) {
            fetchOptions.body = JSON.stringify(params["treatmentDto"] || {});
        }
        if (contentTypeHeader) {
            fetchOptions.headers = assign({}, contentTypeHeader, fetchOptions.headers);
        }
        return {
            url: url.format(urlObj),
            options: fetchOptions,
        };
    },
};

/**
 * TreatmentcontrollerApi - functional programming interface
 */
export const TreatmentcontrollerApiFp = {
    /**
     * 
     * @summary Fills actual data about treatment for covid19 positive patients
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     * @param treatmentDto Treatment&#39;s data
     */
    putTreatment(params: { "personUid": string; "treatmentDto": TreatmentRequest;  }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<any> {
        const fetchArgs = TreatmentcontrollerApiFetchParamCreator.putTreatment(params, options);
        return (fetch: FetchAPI = isomorphicFetch, basePath: string = BASE_PATH) => {
            return fetch(basePath + fetchArgs.url, fetchArgs.options).then((response) => {
                if (response.status >= 200 && response.status < 300) {
                    return response;
                } else {
                    throw response;
                }
            });
        };
    },
};

/**
 * TreatmentcontrollerApi - object-oriented interface
 */
export class TreatmentcontrollerApi extends BaseAPI {
    /**
     * 
     * @summary Fills actual data about treatment for covid19 positive patients
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     * @param treatmentDto Treatment&#39;s data
     */
    putTreatment(params: {  "personUid": string; "treatmentDto": TreatmentRequest; }, options?: any) {
        return TreatmentcontrollerApiFp.putTreatment(params, options)(this.fetch, this.basePath);
    }
};

/**
 * TreatmentcontrollerApi - factory interface
 */
export const TreatmentcontrollerApiFactory = function (fetch?: FetchAPI, basePath?: string) {
    return {
        /**
         * 
         * @summary Fills actual data about treatment for covid19 positive patients
         * @param personUid Unique Person&#39;s ID (person_uid.person)
         * @param treatmentDto Treatment&#39;s data
         */
        putTreatment(params: {  "personUid": string; "treatmentDto": TreatmentRequest; }, options?: any) {
            return TreatmentcontrollerApiFp.putTreatment(params, options)(fetch, basePath);
        },
    };
};

