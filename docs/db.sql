CREATE TABLE "user_account" (
	"id" serial NOT NULL,
	"firstname" character varying(50) NOT NULL,
	"lastname" character varying(50) NOT NULL,
	"password" character varying(100) NOT NULL,
	"email" character varying(50) NOT NULL UNIQUE,
	"phone" character varying(100) UNIQUE,
	"role" character varying NOT NULL,
	"avatar" character varying NOT NULL,
	"created" timestamp with time zone NOT NULL DEFAULT 'now()',
	"updated" timestamp with time zone NOT NULL DEFAULT 'now()',
	CONSTRAINT "user_account_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "user_group" (
	"id" serial NOT NULL,
	"name" character varying NOT NULL UNIQUE,
	"status" integer,
	"created" timestamp with time zone NOT NULL DEFAULT 'now()',
	"updated" timestamp with time zone NOT NULL DEFAULT 'now()',
	CONSTRAINT "user_group_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "user_2_group" (
	"id" serial NOT NULL,
	"group_id" integer NOT NULL,
	"user_id" integer NOT NULL,
	"group_role" integer NOT NULL,
	"created" timestamp with time zone NOT NULL DEFAULT 'now()',
	"updated" timestamp with time zone NOT NULL DEFAULT 'now()',
	CONSTRAINT "user_2_group_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "message" (
	"id" serial NOT NULL,
	"message" TEXT,
	"parent_message" integer,
	"user_id" integer NOT NULL,
	"group_id" integer NOT NULL,
	"created" time with time zone NOT NULL DEFAULT 'now()',
	"updated" time with time zone NOT NULL DEFAULT 'now()',
	CONSTRAINT "message_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "pinned_message" (
	"message_id" integer NOT NULL,
	"user_id" integer NOT NULL
) WITH (
  OIDS=FALSE
);



CREATE TABLE "contact" (
	"id" serial NOT NULL,
	"initiator_id" integer NOT NULL,
	"acceptor_id" integer NOT NULL,
	"status" integer NOT NULL,
	"created" timestamp with time zone NOT NULL DEFAULT 'now()',
	"updated" timestamp with time zone NOT NULL DEFAULT 'now()',
	CONSTRAINT "contact_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "smile" (
	"id" serial NOT NULL,
	"name" character varying NOT NULL UNIQUE,
	"marker" character varying NOT NULL UNIQUE DEFAULT '50',
	"smile_group_id" integer NOT NULL,
	"created" timestamp with time zone NOT NULL DEFAULT 'now()',
	"updated" timestamp with time zone NOT NULL DEFAULT 'now()',
	CONSTRAINT "smile_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "smile_group" (
	"id" serial NOT NULL,
	"name" character varying NOT NULL UNIQUE DEFAULT '125',
	"created" timestamp with time zone NOT NULL DEFAULT 'now()',
	"updated" timestamp with time zone NOT NULL DEFAULT 'now()',
	CONSTRAINT "smile_group_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "attachment" (
	"id" integer NOT NULL,
	"content" character varying NOT NULL,
	"content_type" integer,
	"created" time with time zone NOT NULL DEFAULT 'now()',
	"updated" time with time zone NOT NULL DEFAULT 'now()',
	CONSTRAINT "attachment_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);





ALTER TABLE "user_2_group" ADD CONSTRAINT "user_2_group_fk0" FOREIGN KEY ("group_id") REFERENCES "user_group"("id");
ALTER TABLE "user_2_group" ADD CONSTRAINT "user_2_group_fk1" FOREIGN KEY ("user_id") REFERENCES "user_account"("id");

ALTER TABLE "message" ADD CONSTRAINT "message_fk0" FOREIGN KEY ("parent_message") REFERENCES "message"("id");
ALTER TABLE "message" ADD CONSTRAINT "message_fk1" FOREIGN KEY ("user_id") REFERENCES "user_account"("id");
ALTER TABLE "message" ADD CONSTRAINT "message_fk2" FOREIGN KEY ("group_id") REFERENCES "user_group"("id");

ALTER TABLE "pinned_message" ADD CONSTRAINT "pinned_message_fk0" FOREIGN KEY ("message_id") REFERENCES "message"("id");
ALTER TABLE "pinned_message" ADD CONSTRAINT "pinned_message_fk1" FOREIGN KEY ("user_id") REFERENCES "user_account"("id");

ALTER TABLE "contact" ADD CONSTRAINT "contact_fk0" FOREIGN KEY ("initiator_id") REFERENCES "user_account"("id");
ALTER TABLE "contact" ADD CONSTRAINT "contact_fk1" FOREIGN KEY ("acceptor_id") REFERENCES "user_account"("id");

ALTER TABLE "smile" ADD CONSTRAINT "smile_fk0" FOREIGN KEY ("smile_group_id") REFERENCES "smile_group"("id");


ALTER TABLE "attachment" ADD CONSTRAINT "attachment_fk0" FOREIGN KEY ("id") REFERENCES "message"("id");
