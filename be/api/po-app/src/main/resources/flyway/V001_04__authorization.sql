create sequence po_operator_seq;
create sequence po_user_seq;
create sequence po_authorization_seq;

create table po_authorization
(
    id         bigint not null
        constraint pk_po_authorization
            primary key,
    created_at timestamp with time zone,
    updated_at timestamp with time zone,
    code       varchar(255),
    attempts   int,
    state      varchar(255),
    person_id  bigint
        constraint fk_po_authorization_po_person
            references po_person (id)
);

CREATE INDEX fk_po_authorization_po_person_idx
    ON po_authorization(person_id);

create table po_user
(
    id                     bigint not null
        constraint pk_po_user
            primary key,
    created_at             timestamp with time zone,
    updated_at             timestamp with time zone,
    login                  varchar(255),
    password               varchar(255),
    role                   varchar(255),
    invalid_login_attempts int
);

create table po_operator
(
    id         bigint  not null
        constraint pk_po_operator
            primary key,
    created_at timestamp with time zone,
    updated_at timestamp with time zone,
    name       varchar(255),
    active     boolean not null,
    user_id    bigint
        constraint fk_po_operator_po_user
            references po_user (id)
);

CREATE INDEX fk_po_operator_po_user_idx
    ON po_operator(user_id);

alter table po_person
    add user_id bigint
        constraint fk_po_person_po_user
            references po_user (id);

CREATE INDEX fk_po_person_po_user_idx
    ON po_person(user_id);
