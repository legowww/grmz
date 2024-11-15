CREATE TABLE IF NOT EXISTS public.member_entity (
    id int8 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
    "name" varchar(255) NULL,
    "email" varchar(255) NULL,
    "password" varchar(255) NULL,
    created_ts timestamptz(3) NULL,
    updated_ts timestamptz(3) NULL,
    CONSTRAINT member_entity_pkey PRIMARY KEY (id)
);
