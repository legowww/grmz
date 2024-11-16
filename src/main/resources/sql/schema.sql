CREATE TABLE IF NOT EXISTS public.members (
	id bigserial NOT NULL,
	"name" varchar(50) NOT NULL,
	email varchar(255) NOT NULL,
	"password" varchar(255) NOT NULL,
	created_ts timestamptz(3) NULL,
	updated_ts timestamptz(3) NULL,
	CONSTRAINT member_entity_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.customers (
	id bigserial NOT NULL,
	member_id int8 NOT NULL,
	created_ts timestamptz(3) NOT NULL,
	updated_ts timestamptz(3) NULL,
	CONSTRAINT customers_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.barbers (
    id bigserial NOT NULL,
    member_id int8 NOT NULL,
    barber_shop_id int8 NOT NULL,
    introduction text NOT NULL,
    is_active bool DEFAULT true NULL,
    created_ts timestamptz(3) NOT NULL,
    updated_ts timestamptz(3) NULL,
    CONSTRAINT barbers_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.barber_shops (
	id bigserial NOT NULL,
    owner_id int8 NOT NULL,
    "name" varchar(50) NOT NULL,
    address varchar(50) NOT NULL,
    latitude numeric(10, 8) NULL,
    longitude numeric(11, 8) NULL,
    is_active bool DEFAULT true NULL,
    created_ts timestamptz(3) NOT NULL,
    updated_ts timestamptz(3) NULL,
    CONSTRAINT barbershops_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.barber_shop_schedules (
	id bigserial NOT NULL,
	barber_shop_id int8 NOT NULL,
	barber_id int8 NOT NULL,
	schedule_date date NOT NULL,
	schedule_time time NOT NULL,
	created_ts timestamptz(3) NOT NULL,
	updated_ts timestamptz(3) NULL,
	CONSTRAINT barber_shop_schedules_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.barber_shop_styles (
	id bigserial NOT NULL,
	barber_shop_id int8 NOT NULL,
	barber_id int8 NOT NULL,
	"name" varchar(50) NOT NULL,
	price DECIMAL(10,2) NOT NULL,
	description varchar(50) NOT NULL,
	created_ts timestamptz(3) NOT NULL,
	updated_ts timestamptz(3) NULL,
	CONSTRAINT barber_shop_styles_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.reservations (
	id bigserial NOT NULL,
	barber_shop_id int8 NOT NULL,
	barber_id int8 NOT NULL,
	customer_id int8 NOT NULL,
	style_id int8 NULL,
	barber_shop_schedule_id int8 NOT NULL,
	reservation_status varchar(10) NOT NULL,
	created_ts timestamptz(3) NOT NULL,
	updated_ts timestamptz(3) NULL,
	CONSTRAINT reservations_pk PRIMARY KEY (id)
);
