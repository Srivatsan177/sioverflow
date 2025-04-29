CREATE TABLE IF NOT EXISTS public.users (
	id uuid NOT NULL,
	email varchar(255) NULL,
	"role" varchar(255) NULL,
	username varchar(255) NULL,
	avatar_url varchar(255) NULL,
	CONSTRAINT users_email_unique UNIQUE (email),
	CONSTRAINT users_username_unique UNIQUE (username),
	CONSTRAINT users_pkey PRIMARY KEY (id),
	CONSTRAINT users_role_check CHECK (((role)::text = ANY ((ARRAY['USER'::character varying, 'ADMIN'::character varying, 'MODERATOR'::character varying])::text[])))
);