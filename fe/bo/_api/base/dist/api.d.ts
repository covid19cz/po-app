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
export declare type ErrorMessageDtoErrorCodeEnum = "SMS_CODE_GEN_ERROR" | "UNAUTHORIZED" | "UNKNOWN" | "ERROR_LOGIN_REQUIRED" | "VALIDATION_FAILED";
export interface ExposureRequest {
    "infectedInContact"?: ExposureRequestInfectedInContactEnum;
    "infectedInContactDate"?: Date;
    "infectedPhoneNumbers"?: string;
    "visitedRiskArea"?: CodebookItemDto;
}
export declare type ExposureRequestInfectedInContactEnum = "Y" | "N" | "?";
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
export declare type HealthCheckRequestInfectedInContactEnum = "Y" | "N" | "?";
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
export declare type SymptomEnum = "NONE" | "MORE" | "ONE_OR_TWO" | "THREE_OR_FOUR";
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
export declare const AuthorizationcontrollerApiFetchParamCreator: {
    sendCodeUsingPOST(params: {
        "sendCodeRequest": SendCodeRequest;
    }, options?: any): FetchArgs;
    verifyCodeUsingPOST(params: {
        "personUid"?: string;
        "smsCode"?: string;
    }, options?: any): FetchArgs;
};
/**
 * AuthorizationcontrollerApi - functional programming interface
 */
export declare const AuthorizationcontrollerApiFp: {
    sendCodeUsingPOST(params: {
        "sendCodeRequest": SendCodeRequest;
    }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<SendCodeResponse>;
    verifyCodeUsingPOST(params: {
        "personUid"?: string;
        "smsCode"?: string;
    }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<VerifyCodeResponseDto>;
};
/**
 * AuthorizationcontrollerApi - object-oriented interface
 */
export declare class AuthorizationcontrollerApi extends BaseAPI {
    /**
     *
     * @summary Sent SMS with auth code
     * @param sendCodeRequest send sms login request dto
     */
    sendCodeUsingPOST(params: {
        "sendCodeRequest": SendCodeRequest;
    }, options?: any): Promise<SendCodeResponse>;
    /**
     *
     * @summary Verify code from SMS
     * @param personUid Uid of person
     * @param smsCode Code received in SMS
     */
    verifyCodeUsingPOST(params: {
        "personUid"?: string;
        "smsCode"?: string;
    }, options?: any): Promise<VerifyCodeResponseDto>;
}
/**
 * AuthorizationcontrollerApi - factory interface
 */
export declare const AuthorizationcontrollerApiFactory: (fetch?: FetchAPI, basePath?: string) => {
    sendCodeUsingPOST(params: {
        "sendCodeRequest": SendCodeRequest;
    }, options?: any): Promise<SendCodeResponse>;
    verifyCodeUsingPOST(params: {
        "personUid"?: string;
        "smsCode"?: string;
    }, options?: any): Promise<VerifyCodeResponseDto>;
};
/**
 * CodebookcontrollerApi - fetch parameter creator
 */
export declare const CodebookcontrollerApiFetchParamCreator: {
    getCodebookItemsUsingGET(params: {
        "codebook": string;
    }, options?: any): FetchArgs;
};
/**
 * CodebookcontrollerApi - functional programming interface
 */
export declare const CodebookcontrollerApiFp: {
    getCodebookItemsUsingGET(params: {
        "codebook": string;
    }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<CodebookItemDto[]>;
};
/**
 * CodebookcontrollerApi - object-oriented interface
 */
export declare class CodebookcontrollerApi extends BaseAPI {
    /**
     *
     * @summary getCodebookItems
     * @param codebook Codebook code
     */
    getCodebookItemsUsingGET(params: {
        "codebook": string;
    }, options?: any): Promise<CodebookItemDto[]>;
}
/**
 * CodebookcontrollerApi - factory interface
 */
export declare const CodebookcontrollerApiFactory: (fetch?: FetchAPI, basePath?: string) => {
    getCodebookItemsUsingGET(params: {
        "codebook": string;
    }, options?: any): Promise<CodebookItemDto[]>;
};
/**
 * HealthcheckcontrollerApi - fetch parameter creator
 */
export declare const HealthcheckcontrollerApiFetchParamCreator: {
    postHeathCheckTestResult(params: {
        "personUid": string;
        "healthCheckId": number;
        "testResultDto": HealthCheckResultDto;
    }, options?: any): FetchArgs;
    putHealthCheckExposure(params: {
        "personUid": string;
        "exposureDto": ExposureRequest;
    }, options?: any): FetchArgs;
    putHealthCheckSymptoms(params: {
        "personUid": string;
        "symptomsDto": SymptomsRequest;
    }, options?: any): FetchArgs;
    putHealthCheckTestingPlace(params: {
        "personUid": string;
        "testingPlaceDto": TestingPlaceRequest;
    }, options?: any): FetchArgs;
};
/**
 * HealthcheckcontrollerApi - functional programming interface
 */
export declare const HealthcheckcontrollerApiFp: {
    postHeathCheckTestResult(params: {
        "personUid": string;
        "healthCheckId": number;
        "testResultDto": HealthCheckResultDto;
    }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<HealthCheckDto>;
    putHealthCheckExposure(params: {
        "personUid": string;
        "exposureDto": ExposureRequest;
    }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<any>;
    putHealthCheckSymptoms(params: {
        "personUid": string;
        "symptomsDto": SymptomsRequest;
    }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<any>;
    putHealthCheckTestingPlace(params: {
        "personUid": string;
        "testingPlaceDto": TestingPlaceRequest;
    }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<TestingPlaceInstuctionsDto>;
};
/**
 * HealthcheckcontrollerApi - object-oriented interface
 */
export declare class HealthcheckcontrollerApi extends BaseAPI {
    /**
     *
     * @summary Add result of a health check test
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     * @param healthCheckId ID of a health check
     * @param testResultDto Health check test result
     */
    postHeathCheckTestResult(params: {
        "personUid": string;
        "healthCheckId": number;
        "testResultDto": HealthCheckResultDto;
    }, options?: any): Promise<HealthCheckDto>;
    /**
     *
     * @summary Fills exposure form
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     * @param exposureDto Health check&#39;s data - exposure
     */
    putHealthCheckExposure(params: {
        "personUid": string;
        "exposureDto": ExposureRequest;
    }, options?: any): Promise<any>;
    /**
     *
     * @summary Fills actual health check form
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     * @param symptomsDto Health check&#39;s data - simptoms
     */
    putHealthCheckSymptoms(params: {
        "personUid": string;
        "symptomsDto": SymptomsRequest;
    }, options?: any): Promise<any>;
    /**
     *
     * @summary Fills testing place form
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     * @param testingPlaceDto Health check&#39;s data - testing place
     */
    putHealthCheckTestingPlace(params: {
        "personUid": string;
        "testingPlaceDto": TestingPlaceRequest;
    }, options?: any): Promise<TestingPlaceInstuctionsDto>;
}
/**
 * HealthcheckcontrollerApi - factory interface
 */
export declare const HealthcheckcontrollerApiFactory: (fetch?: FetchAPI, basePath?: string) => {
    postHeathCheckTestResult(params: {
        "personUid": string;
        "healthCheckId": number;
        "testResultDto": HealthCheckResultDto;
    }, options?: any): Promise<HealthCheckDto>;
    putHealthCheckExposure(params: {
        "personUid": string;
        "exposureDto": ExposureRequest;
    }, options?: any): Promise<any>;
    putHealthCheckSymptoms(params: {
        "personUid": string;
        "symptomsDto": SymptomsRequest;
    }, options?: any): Promise<any>;
    putHealthCheckTestingPlace(params: {
        "personUid": string;
        "testingPlaceDto": TestingPlaceRequest;
    }, options?: any): Promise<TestingPlaceInstuctionsDto>;
};
/**
 * PersoncontrollerApi - fetch parameter creator
 */
export declare const PersoncontrollerApiFetchParamCreator: {
    getAllPersons(options?: any): FetchArgs;
    getPerson(params: {
        "personUid": string;
    }, options?: any): FetchArgs;
    putPerson(params: {
        "personUid": string;
        "personDto": PersonRequest;
    }, options?: any): FetchArgs;
};
/**
 * PersoncontrollerApi - functional programming interface
 */
export declare const PersoncontrollerApiFp: {
    getAllPersons(options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<PersonResponse[]>;
    getPerson(params: {
        "personUid": string;
    }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<PersonResponse>;
    putPerson(params: {
        "personUid": string;
        "personDto": PersonRequest;
    }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<PersonResponse>;
};
/**
 * PersoncontrollerApi - object-oriented interface
 */
export declare class PersoncontrollerApi extends BaseAPI {
    /**
     *
     * @summary GET all persons
     */
    getAllPersons(options?: any): Promise<PersonResponse[]>;
    /**
     *
     * @summary GET actual person and health status
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     */
    getPerson(params: {
        "personUid": string;
    }, options?: any): Promise<PersonResponse>;
    /**
     *
     * @summary Updates actual person's and health status
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     * @param personDto Person&#39;s data
     */
    putPerson(params: {
        "personUid": string;
        "personDto": PersonRequest;
    }, options?: any): Promise<PersonResponse>;
}
/**
 * PersoncontrollerApi - factory interface
 */
export declare const PersoncontrollerApiFactory: (fetch?: FetchAPI, basePath?: string) => {
    getAllPersons(options?: any): Promise<PersonResponse[]>;
    getPerson(params: {
        "personUid": string;
    }, options?: any): Promise<PersonResponse>;
    putPerson(params: {
        "personUid": string;
        "personDto": PersonRequest;
    }, options?: any): Promise<PersonResponse>;
};
/**
 * TreatmentcontrollerApi - fetch parameter creator
 */
export declare const TreatmentcontrollerApiFetchParamCreator: {
    putTreatment(params: {
        "personUid": string;
        "treatmentDto": TreatmentRequest;
    }, options?: any): FetchArgs;
};
/**
 * TreatmentcontrollerApi - functional programming interface
 */
export declare const TreatmentcontrollerApiFp: {
    putTreatment(params: {
        "personUid": string;
        "treatmentDto": TreatmentRequest;
    }, options?: any): (fetch?: FetchAPI, basePath?: string) => Promise<any>;
};
/**
 * TreatmentcontrollerApi - object-oriented interface
 */
export declare class TreatmentcontrollerApi extends BaseAPI {
    /**
     *
     * @summary Fills actual data about treatment for covid19 positive patients
     * @param personUid Unique Person&#39;s ID (person_uid.person)
     * @param treatmentDto Treatment&#39;s data
     */
    putTreatment(params: {
        "personUid": string;
        "treatmentDto": TreatmentRequest;
    }, options?: any): Promise<any>;
}
/**
 * TreatmentcontrollerApi - factory interface
 */
export declare const TreatmentcontrollerApiFactory: (fetch?: FetchAPI, basePath?: string) => {
    putTreatment(params: {
        "personUid": string;
        "treatmentDto": TreatmentRequest;
    }, options?: any): Promise<any>;
};
