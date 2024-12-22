DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS field_instance;
DROP TABLE IF EXISTS object_instance;
DROP TABLE IF EXISTS field_definition;
DROP TABLE IF EXISTS object_definition;
DROP TABLE IF EXISTS tenant;

CREATE TABLE IF NOT EXISTS customer (
    id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS tenant (
    id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS object_definition (
    id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    tenant_id uuid NOT NULL,
    name VARCHAR(255) NOT NULL,
    label VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    CONSTRAINT fk_object_definition_tenant_id__tenant_id FOREIGN KEY (tenant_id) REFERENCES tenant (id)
);

CREATE TABLE IF NOT EXISTS field_definition (
    id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    tenant_id uuid NOT NULL,
    object_definition_id uuid NOT NULL,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    "default" VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS object_instance (
    id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    tenant_id uuid NOT NULL,
    object_definition_id uuid NOT NULL,
    name VARCHAR(255) NOT NULL,
    label VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS field_instance (
    id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    tenant_id uuid NOT NULL,
    object_instance_id uuid NOT NULL,
    field_definition_id uuid NOT NULL,
    "value" VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL
);


