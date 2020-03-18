create sequence po_address_seq;
create sequence po_health_check_result_seq;
create sequence po_health_check_seq;
create sequence po_person_seq;
create sequence po_visited_area_seq;

create table cb__codebook
(
	id varchar(255) not null
		constraint cb__codebook_pkey
			primary key,
	description varchar(255),
	name varchar(255)
);

create table cb_health_check_location
(
	id varchar(255) not null
		constraint cb_health_check_location_pkey
			primary key,
	default_item boolean,
	item_order integer,
	text varchar(255),
	codebook_id varchar(255) not null
		constraint fk_cb_health_check_location_cb__codebook
			references cb__codebook
);

create table cb_health_check_type
(
	id varchar(255) not null
		constraint cb_health_check_type_pkey
			primary key,
	default_item boolean,
	item_order integer,
	text varchar(255),
	codebook_id varchar(255) not null
		constraint fk_cb_health_check_type_cb__codebook
			references cb__codebook
);

create table cb_health_status
(
	id varchar(255) not null
		constraint cb_health_status_pkey
			primary key,
	default_item boolean,
	item_order integer,
	text varchar(255),
	codebook_id varchar(255) not null
		constraint fk__cb_cb_health_status_codebook
			references cb__codebook
);

create table cb_risk_area
(
	id varchar(255) not null
		constraint pk_cb_risk_area
			primary key,
	default_item boolean,
	item_order integer,
	text varchar(255),
	codebook_id varchar(255) not null
		constraint fk_cb_risk_area_cb__codebook
			references cb__codebook
);

create table po_address
(
	id bigint not null
		constraint pk_po_address
			primary key,
	created_at timestamp with time zone,
	updated_at timestamp with time zone,
	city varchar(255),
	number_descriptive varchar(255),
	number_evidence varchar(255),
	street varchar(255),
	zip_code varchar(255)
);

create table po_person
(
	id bigint not null
		constraint pk_po_person
			primary key,
	created_at timestamp with time zone,
	updated_at timestamp with time zone,
	email varchar(255),
	first_name varchar(255),
	health_status_last_change timestamp with time zone,
	phone_number varchar(255),
	return_hash varchar(255),
	surname varchar(255),
	uid uuid,
	address_home_id bigint
		constraint fk_po_person_home_po_address
			references po_address(id),
	health_status varchar(255)
		constraint fk_po_person_cb_health_status
			references cb_health_status(id)
);

create table po_health_check
(
	id bigint not null
		constraint pk_po_health_check
			primary key,
	created_at timestamp with time zone,
	updated_at timestamp with time zone,
	able_to_drive char,
	dry_cough_duration integer,
	headache char,
	health_check_code varchar(255),
	high_temperature_duration integer,
	infected_in_contact_date date,
	infected_phone_numbers varchar(255),
	infected_in_contact varchar(255),
	symtomps_since date,
	final_health_check_location varchar(255)
		constraint fk_po_health_check_final_location_cb_health_check_location
			references cb_health_check_location(id),
	health_check_type varchar(255)
		constraint fk_po_health_check_cb_health_check_type
			references cb_health_check_type(id),
	person_id bigint
		constraint fk_po_health_check_po_person
			references po_person(id),
	preferred_health_check_location varchar(255)
		constraint fk_po_health_check_preffered_location_cb_health_check_location
			references cb_health_check_location(id)
);

create table po_health_check_result
(
	id bigint not null
		constraint pk_po_health_check_result
			primary key,
	result_positive boolean,
	result_sent_at timestamp,
	result_date timestamp,
	health_check_id bigint
		constraint fk_po_health_check_result_po_health_check
			references po_health_check(id)
);

create table po_visited_area
(
	id bigint not null
		constraint pk_po_visited_area
			primary key,
	health_check_id bigint
		constraint fk_po_visited_area_po_health_check
			references po_health_check(id),
	cb_risk_area varchar(255)
		constraint fk_po_visited_area_po_risk_area
			references cb_risk_area
);
