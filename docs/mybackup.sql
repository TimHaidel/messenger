--
-- PostgreSQL database dump
--

-- Dumped from database version 11.2
-- Dumped by pg_dump version 11.2

-- Started on 2019-08-30 17:03:24

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 211 (class 1259 OID 41891)
-- Name: attachment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.attachment (
    id integer NOT NULL,
    content character varying NOT NULL,
    content_type integer,
    created time with time zone DEFAULT '12:41:01.223169+03'::time with time zone NOT NULL,
    updated time with time zone DEFAULT '12:41:01.223169+03'::time with time zone NOT NULL
);


ALTER TABLE public.attachment OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 41849)
-- Name: contact; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contact (
    id integer NOT NULL,
    initiator_id integer NOT NULL,
    acceptor_id integer NOT NULL,
    status integer NOT NULL,
    created timestamp with time zone DEFAULT '2019-08-14 12:41:01.223169+03'::timestamp with time zone NOT NULL,
    updated timestamp with time zone DEFAULT '2019-08-14 12:41:01.223169+03'::timestamp with time zone NOT NULL
);


ALTER TABLE public.contact OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 41847)
-- Name: contact_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.contact_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.contact_id_seq OWNER TO postgres;

--
-- TOC entry 2941 (class 0 OID 0)
-- Dependencies: 205
-- Name: contact_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.contact_id_seq OWNED BY public.contact.id;


--
-- TOC entry 203 (class 1259 OID 41833)
-- Name: message; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.message (
    id integer NOT NULL,
    message text,
    parent_message_id integer,
    user_id integer NOT NULL,
    user_group_id integer NOT NULL,
    created time with time zone DEFAULT '12:41:01.223169+03'::time with time zone NOT NULL,
    updated time with time zone DEFAULT '12:41:01.223169+03'::time with time zone NOT NULL
);


ALTER TABLE public.message OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 41831)
-- Name: message_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.message_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.message_id_seq OWNER TO postgres;

--
-- TOC entry 2942 (class 0 OID 0)
-- Dependencies: 202
-- Name: message_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.message_id_seq OWNED BY public.message.id;


--
-- TOC entry 204 (class 1259 OID 41844)
-- Name: pinned_message; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pinned_message (
    message_id integer NOT NULL,
    user_id integer NOT NULL
);


ALTER TABLE public.pinned_message OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 41859)
-- Name: smile; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.smile (
    id integer NOT NULL,
    name character varying NOT NULL,
    marker character varying DEFAULT '50'::character varying NOT NULL,
    smile_group_id integer NOT NULL,
    created timestamp with time zone DEFAULT '2019-08-14 12:41:01.223169+03'::timestamp with time zone NOT NULL,
    updated timestamp with time zone DEFAULT '2019-08-14 12:41:01.223169+03'::timestamp with time zone NOT NULL
);


ALTER TABLE public.smile OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 41877)
-- Name: smile_group; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.smile_group (
    id integer NOT NULL,
    name character varying DEFAULT '125'::character varying NOT NULL,
    created timestamp with time zone DEFAULT '2019-08-14 12:41:01.223169+03'::timestamp with time zone NOT NULL,
    updated timestamp with time zone DEFAULT '2019-08-14 12:41:01.223169+03'::timestamp with time zone NOT NULL
);


ALTER TABLE public.smile_group OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 41875)
-- Name: smile_group_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.smile_group_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.smile_group_id_seq OWNER TO postgres;

--
-- TOC entry 2943 (class 0 OID 0)
-- Dependencies: 209
-- Name: smile_group_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.smile_group_id_seq OWNED BY public.smile_group.id;


--
-- TOC entry 207 (class 1259 OID 41857)
-- Name: smile_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.smile_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.smile_id_seq OWNER TO postgres;

--
-- TOC entry 2944 (class 0 OID 0)
-- Dependencies: 207
-- Name: smile_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.smile_id_seq OWNED BY public.smile.id;


--
-- TOC entry 201 (class 1259 OID 41823)
-- Name: user_2_group; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_2_group (
    id integer NOT NULL,
    group_id integer NOT NULL,
    user_id integer NOT NULL,
    group_role integer NOT NULL,
    created timestamp with time zone DEFAULT '2019-08-14 12:41:01.223169+03'::timestamp with time zone NOT NULL,
    updated timestamp with time zone DEFAULT '2019-08-14 12:41:01.223169+03'::timestamp with time zone NOT NULL
);


ALTER TABLE public.user_2_group OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 41821)
-- Name: user_2_group_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_2_group_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_2_group_id_seq OWNER TO postgres;

--
-- TOC entry 2945 (class 0 OID 0)
-- Dependencies: 200
-- Name: user_2_group_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_2_group_id_seq OWNED BY public.user_2_group.id;


--
-- TOC entry 197 (class 1259 OID 41791)
-- Name: user_account; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_account (
    id integer NOT NULL,
    firstname character varying(50) NOT NULL,
    lastname character varying(50) NOT NULL,
    password character varying(100) NOT NULL,
    email character varying(50) NOT NULL,
    phone character varying(100),
    role character varying NOT NULL,
    avatar character varying NOT NULL,
    created timestamp with time zone DEFAULT '2019-08-14 12:41:01.223169+03'::timestamp with time zone NOT NULL,
    updated timestamp with time zone DEFAULT '2019-08-14 12:41:01.223169+03'::timestamp with time zone NOT NULL
);


ALTER TABLE public.user_account OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 41789)
-- Name: user_account_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_account_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_account_id_seq OWNER TO postgres;

--
-- TOC entry 2946 (class 0 OID 0)
-- Dependencies: 196
-- Name: user_account_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_account_id_seq OWNED BY public.user_account.id;


--
-- TOC entry 199 (class 1259 OID 41808)
-- Name: user_group; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_group (
    id integer NOT NULL,
    name character varying NOT NULL,
    users_count integer,
    created timestamp with time zone DEFAULT '2019-08-14 12:41:01.223169+03'::timestamp with time zone NOT NULL,
    updated timestamp with time zone DEFAULT '2019-08-14 12:41:01.223169+03'::timestamp with time zone NOT NULL
);


ALTER TABLE public.user_group OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 41806)
-- Name: user_group_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_group_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_group_id_seq OWNER TO postgres;

--
-- TOC entry 2947 (class 0 OID 0)
-- Dependencies: 198
-- Name: user_group_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_group_id_seq OWNED BY public.user_group.id;


--
-- TOC entry 2747 (class 2604 OID 41852)
-- Name: contact id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contact ALTER COLUMN id SET DEFAULT nextval('public.contact_id_seq'::regclass);


--
-- TOC entry 2744 (class 2604 OID 41836)
-- Name: message id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message ALTER COLUMN id SET DEFAULT nextval('public.message_id_seq'::regclass);


--
-- TOC entry 2750 (class 2604 OID 41862)
-- Name: smile id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.smile ALTER COLUMN id SET DEFAULT nextval('public.smile_id_seq'::regclass);


--
-- TOC entry 2754 (class 2604 OID 41880)
-- Name: smile_group id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.smile_group ALTER COLUMN id SET DEFAULT nextval('public.smile_group_id_seq'::regclass);


--
-- TOC entry 2741 (class 2604 OID 41826)
-- Name: user_2_group id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_2_group ALTER COLUMN id SET DEFAULT nextval('public.user_2_group_id_seq'::regclass);


--
-- TOC entry 2735 (class 2604 OID 41794)
-- Name: user_account id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account ALTER COLUMN id SET DEFAULT nextval('public.user_account_id_seq'::regclass);


--
-- TOC entry 2738 (class 2604 OID 41811)
-- Name: user_group id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_group ALTER COLUMN id SET DEFAULT nextval('public.user_group_id_seq'::regclass);


--
-- TOC entry 2935 (class 0 OID 41891)
-- Dependencies: 211
-- Data for Name: attachment; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2930 (class 0 OID 41849)
-- Dependencies: 206
-- Data for Name: contact; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.contact (id, initiator_id, acceptor_id, status, created, updated) VALUES (1, 1, 2, 1, '2019-08-14 13:02:17.059+03', '2019-08-14 13:02:17.059+03');
INSERT INTO public.contact (id, initiator_id, acceptor_id, status, created, updated) VALUES (2, 1, 3, 1, '2019-08-14 13:02:21.682+03', '2019-08-14 13:02:21.682+03');
INSERT INTO public.contact (id, initiator_id, acceptor_id, status, created, updated) VALUES (3, 1, 4, 1, '2019-08-14 13:02:28.88+03', '2019-08-14 13:02:28.88+03');
INSERT INTO public.contact (id, initiator_id, acceptor_id, status, created, updated) VALUES (4, 2, 4, 1, '2019-08-14 12:41:01.223169+03', '2019-08-14 12:41:01.223169+03');


--
-- TOC entry 2927 (class 0 OID 41833)
-- Dependencies: 203
-- Data for Name: message; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.message (id, message, parent_message_id, user_id, user_group_id, created, updated) VALUES (3, 'Message1', NULL, 1, 7, '12:41:01.223169+03', '12:41:01.223169+03');
INSERT INTO public.message (id, message, parent_message_id, user_id, user_group_id, created, updated) VALUES (5, 'Message2', NULL, 1, 7, '12:41:01.223169+03', '12:41:01.223169+03');
INSERT INTO public.message (id, message, parent_message_id, user_id, user_group_id, created, updated) VALUES (9, 'Message-3', NULL, 1, 2, '12:41:01.223169+03', '12:41:01.223169+03');
INSERT INTO public.message (id, message, parent_message_id, user_id, user_group_id, created, updated) VALUES (12, 'Message-4', NULL, 2, 9, '12:41:01.223169+03', '12:41:01.223169+03');
INSERT INTO public.message (id, message, parent_message_id, user_id, user_group_id, created, updated) VALUES (13, 'Message-5', NULL, 2, 9, '12:41:01.223169+03', '12:41:01.223169+03');
INSERT INTO public.message (id, message, parent_message_id, user_id, user_group_id, created, updated) VALUES (15, 'Message-6', NULL, 2, 9, '12:41:01.223169+03', '12:41:01.223169+03');
INSERT INTO public.message (id, message, parent_message_id, user_id, user_group_id, created, updated) VALUES (16, 'Message-7', NULL, 1, 9, '12:41:01.223169+03', '12:41:01.223169+03');


--
-- TOC entry 2928 (class 0 OID 41844)
-- Dependencies: 204
-- Data for Name: pinned_message; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2932 (class 0 OID 41859)
-- Dependencies: 208
-- Data for Name: smile; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2934 (class 0 OID 41877)
-- Dependencies: 210
-- Data for Name: smile_group; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2925 (class 0 OID 41823)
-- Dependencies: 201
-- Data for Name: user_2_group; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_2_group (id, group_id, user_id, group_role, created, updated) VALUES (1, 1, 1, 1, '2019-08-14 12:41:01.223169+03', '2019-08-14 12:41:01.223169+03');
INSERT INTO public.user_2_group (id, group_id, user_id, group_role, created, updated) VALUES (2, 1, 2, 1, '2019-08-14 12:41:01.223169+03', '2019-08-14 12:41:01.223169+03');
INSERT INTO public.user_2_group (id, group_id, user_id, group_role, created, updated) VALUES (3, 2, 3, 1, '2019-08-14 12:41:01.223169+03', '2019-08-14 12:41:01.223169+03');
INSERT INTO public.user_2_group (id, group_id, user_id, group_role, created, updated) VALUES (4, 7, 1, 1, '2019-08-21 16:14:53.353+03', '2019-08-21 16:14:53.353+03');
INSERT INTO public.user_2_group (id, group_id, user_id, group_role, created, updated) VALUES (5, 7, 3, 0, '2019-08-21 16:14:53.353+03', '2019-08-21 16:14:53.353+03');
INSERT INTO public.user_2_group (id, group_id, user_id, group_role, created, updated) VALUES (6, 8, 1, 1, '2019-08-26 13:45:22.504+03', '2019-08-26 13:45:22.504+03');
INSERT INTO public.user_2_group (id, group_id, user_id, group_role, created, updated) VALUES (7, 8, 4, 0, '2019-08-26 13:45:22.504+03', '2019-08-26 13:45:22.504+03');
INSERT INTO public.user_2_group (id, group_id, user_id, group_role, created, updated) VALUES (8, 9, 1, 1, '2019-08-26 13:45:30.205+03', '2019-08-26 13:45:30.205+03');
INSERT INTO public.user_2_group (id, group_id, user_id, group_role, created, updated) VALUES (9, 9, 2, 0, '2019-08-26 13:45:30.205+03', '2019-08-26 13:45:30.205+03');


--
-- TOC entry 2921 (class 0 OID 41791)
-- Dependencies: 197
-- Data for Name: user_account; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_account (id, firstname, lastname, password, email, phone, role, avatar, created, updated) VALUES (1, 'Ivan', 'Ivanov', 'admin', 'admin@admin', '1234567891', 'admin', 'adf', '2019-08-14 12:41:01.223169+03', '2019-08-14 12:41:01.223169+03');
INSERT INTO public.user_account (id, firstname, lastname, password, email, phone, role, avatar, created, updated) VALUES (2, 'Petr', 'Petrov', '123', 'petrov@ad', '1236549871', 'user', 'dsfa', '2019-08-14 13:00:53.999+03', '2019-08-14 13:00:53.999+03');
INSERT INTO public.user_account (id, firstname, lastname, password, email, phone, role, avatar, created, updated) VALUES (3, 'Monia', 'Mon', '123', 'mon@mail', '5161981961', 'user', 'we', '2019-08-14 13:01:34.564+03', '2019-08-14 13:01:34.564+03');
INSERT INTO public.user_account (id, firstname, lastname, password, email, phone, role, avatar, created, updated) VALUES (4, 'Alexandr', 'Alexandrov', '123', 'alex@mail', '1598416351', 'user', 'a', '2019-08-14 13:02:04.077+03', '2019-08-14 13:02:55.615+03');


--
-- TOC entry 2923 (class 0 OID 41808)
-- Dependencies: 199
-- Data for Name: user_group; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_group (id, name, users_count, created, updated) VALUES (1, 'aa', 1, '2019-08-14 12:48:45.623+03', '2019-08-14 12:48:45.623+03');
INSERT INTO public.user_group (id, name, users_count, created, updated) VALUES (2, 'bb
', 2, '2019-08-14 12:41:01.223169+03', '2019-08-14 12:41:01.223169+03');
INSERT INTO public.user_group (id, name, users_count, created, updated) VALUES (3, 'cc', 2, '2019-08-14 12:41:01.223169+03', '2019-08-14 12:41:01.223169+03');
INSERT INTO public.user_group (id, name, users_count, created, updated) VALUES (7, 'Group with 1 : 3', 2, '2019-08-21 16:14:50.369+03', '2019-08-21 16:14:50.369+03');
INSERT INTO public.user_group (id, name, users_count, created, updated) VALUES (8, 'Group with 4 : 1', 2, '2019-08-26 13:45:22.129+03', '2019-08-26 13:45:22.129+03');
INSERT INTO public.user_group (id, name, users_count, created, updated) VALUES (9, 'Group with 2 : 1', 2, '2019-08-26 13:45:30.203+03', '2019-08-26 13:45:30.203+03');


--
-- TOC entry 2948 (class 0 OID 0)
-- Dependencies: 205
-- Name: contact_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.contact_id_seq', 4, true);


--
-- TOC entry 2949 (class 0 OID 0)
-- Dependencies: 202
-- Name: message_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.message_id_seq', 18, true);


--
-- TOC entry 2950 (class 0 OID 0)
-- Dependencies: 209
-- Name: smile_group_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.smile_group_id_seq', 1, false);


--
-- TOC entry 2951 (class 0 OID 0)
-- Dependencies: 207
-- Name: smile_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.smile_id_seq', 1, false);


--
-- TOC entry 2952 (class 0 OID 0)
-- Dependencies: 200
-- Name: user_2_group_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_2_group_id_seq', 9, true);


--
-- TOC entry 2953 (class 0 OID 0)
-- Dependencies: 196
-- Name: user_account_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_account_id_seq', 4, true);


--
-- TOC entry 2954 (class 0 OID 0)
-- Dependencies: 198
-- Name: user_group_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_group_id_seq', 9, true);


--
-- TOC entry 2787 (class 2606 OID 41900)
-- Name: attachment attachment_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.attachment
    ADD CONSTRAINT attachment_pk PRIMARY KEY (id);


--
-- TOC entry 2775 (class 2606 OID 41856)
-- Name: contact contact_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contact
    ADD CONSTRAINT contact_pk PRIMARY KEY (id);


--
-- TOC entry 2773 (class 2606 OID 41843)
-- Name: message message_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT message_pk PRIMARY KEY (id);


--
-- TOC entry 2783 (class 2606 OID 41890)
-- Name: smile_group smile_group_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.smile_group
    ADD CONSTRAINT smile_group_name_key UNIQUE (name);


--
-- TOC entry 2785 (class 2606 OID 41888)
-- Name: smile_group smile_group_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.smile_group
    ADD CONSTRAINT smile_group_pk PRIMARY KEY (id);


--
-- TOC entry 2777 (class 2606 OID 41874)
-- Name: smile smile_marker_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.smile
    ADD CONSTRAINT smile_marker_key UNIQUE (marker);


--
-- TOC entry 2779 (class 2606 OID 41872)
-- Name: smile smile_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.smile
    ADD CONSTRAINT smile_name_key UNIQUE (name);


--
-- TOC entry 2781 (class 2606 OID 41870)
-- Name: smile smile_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.smile
    ADD CONSTRAINT smile_pk PRIMARY KEY (id);


--
-- TOC entry 2771 (class 2606 OID 41830)
-- Name: user_2_group user_2_group_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_2_group
    ADD CONSTRAINT user_2_group_pk PRIMARY KEY (id);


--
-- TOC entry 2761 (class 2606 OID 41803)
-- Name: user_account user_account_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account
    ADD CONSTRAINT user_account_email_key UNIQUE (email);


--
-- TOC entry 2763 (class 2606 OID 41805)
-- Name: user_account user_account_phone_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account
    ADD CONSTRAINT user_account_phone_key UNIQUE (phone);


--
-- TOC entry 2765 (class 2606 OID 41801)
-- Name: user_account user_account_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account
    ADD CONSTRAINT user_account_pk PRIMARY KEY (id);


--
-- TOC entry 2767 (class 2606 OID 41820)
-- Name: user_group user_group_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_group
    ADD CONSTRAINT user_group_name_key UNIQUE (name);


--
-- TOC entry 2769 (class 2606 OID 41818)
-- Name: user_group user_group_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_group
    ADD CONSTRAINT user_group_pk PRIMARY KEY (id);


--
-- TOC entry 2798 (class 2606 OID 41951)
-- Name: attachment attachment_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.attachment
    ADD CONSTRAINT attachment_fk0 FOREIGN KEY (id) REFERENCES public.message(id);


--
-- TOC entry 2795 (class 2606 OID 41936)
-- Name: contact contact_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contact
    ADD CONSTRAINT contact_fk0 FOREIGN KEY (initiator_id) REFERENCES public.user_account(id);


--
-- TOC entry 2796 (class 2606 OID 41941)
-- Name: contact contact_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contact
    ADD CONSTRAINT contact_fk1 FOREIGN KEY (acceptor_id) REFERENCES public.user_account(id);


--
-- TOC entry 2790 (class 2606 OID 41911)
-- Name: message message_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT message_fk0 FOREIGN KEY (parent_message_id) REFERENCES public.message(id);


--
-- TOC entry 2791 (class 2606 OID 41916)
-- Name: message message_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT message_fk1 FOREIGN KEY (user_id) REFERENCES public.user_account(id);


--
-- TOC entry 2792 (class 2606 OID 41921)
-- Name: message message_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT message_fk2 FOREIGN KEY (user_group_id) REFERENCES public.user_group(id);


--
-- TOC entry 2793 (class 2606 OID 41926)
-- Name: pinned_message pinned_message_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pinned_message
    ADD CONSTRAINT pinned_message_fk0 FOREIGN KEY (message_id) REFERENCES public.message(id);


--
-- TOC entry 2794 (class 2606 OID 41931)
-- Name: pinned_message pinned_message_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pinned_message
    ADD CONSTRAINT pinned_message_fk1 FOREIGN KEY (user_id) REFERENCES public.user_account(id);


--
-- TOC entry 2797 (class 2606 OID 41946)
-- Name: smile smile_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.smile
    ADD CONSTRAINT smile_fk0 FOREIGN KEY (smile_group_id) REFERENCES public.smile_group(id);


--
-- TOC entry 2788 (class 2606 OID 41901)
-- Name: user_2_group user_2_group_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_2_group
    ADD CONSTRAINT user_2_group_fk0 FOREIGN KEY (group_id) REFERENCES public.user_group(id);


--
-- TOC entry 2789 (class 2606 OID 41906)
-- Name: user_2_group user_2_group_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_2_group
    ADD CONSTRAINT user_2_group_fk1 FOREIGN KEY (user_id) REFERENCES public.user_account(id);


-- Completed on 2019-08-30 17:03:27

--
-- PostgreSQL database dump complete
--

