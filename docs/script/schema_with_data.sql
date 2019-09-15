--
-- PostgreSQL database dump
--

-- Dumped from database version 11.2
-- Dumped by pg_dump version 11.2

-- Started on 2019-09-15 14:28:36

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
-- TOC entry 211 (class 1259 OID 42060)
-- Name: attachment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.attachment (
    id integer NOT NULL,
    content character varying NOT NULL,
    content_type integer,
    created time with time zone DEFAULT '13:24:43.280425+03'::time with time zone NOT NULL,
    updated time with time zone DEFAULT '13:24:43.280425+03'::time with time zone NOT NULL
);


ALTER TABLE public.attachment OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 42018)
-- Name: contact; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contact (
    id integer NOT NULL,
    initiator_id integer,
    acceptor_id integer,
    status integer NOT NULL,
    created timestamp with time zone DEFAULT '2019-09-14 13:24:43.280425+03'::timestamp with time zone NOT NULL,
    updated timestamp with time zone DEFAULT '2019-09-14 13:24:43.280425+03'::timestamp with time zone NOT NULL
);


ALTER TABLE public.contact OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 42016)
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
-- TOC entry 2940 (class 0 OID 0)
-- Dependencies: 205
-- Name: contact_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.contact_id_seq OWNED BY public.contact.id;


--
-- TOC entry 203 (class 1259 OID 42002)
-- Name: message; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.message (
    id integer NOT NULL,
    message text,
    user_id integer,
    user_group_id integer,
    created time with time zone DEFAULT '13:24:43.280425+03'::time with time zone NOT NULL,
    updated time with time zone DEFAULT '13:24:43.280425+03'::time with time zone NOT NULL
);


ALTER TABLE public.message OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 42000)
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
-- TOC entry 2941 (class 0 OID 0)
-- Dependencies: 202
-- Name: message_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.message_id_seq OWNED BY public.message.id;


--
-- TOC entry 204 (class 1259 OID 42013)
-- Name: pinned_message; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pinned_message (
    message_id integer,
    user_id integer
);


ALTER TABLE public.pinned_message OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 42028)
-- Name: smile; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.smile (
    id integer NOT NULL,
    name character varying NOT NULL,
    marker character varying DEFAULT '50'::character varying NOT NULL,
    smile_group_id integer NOT NULL,
    created timestamp with time zone DEFAULT '2019-09-14 13:24:43.280425+03'::timestamp with time zone NOT NULL,
    updated timestamp with time zone DEFAULT '2019-09-14 13:24:43.280425+03'::timestamp with time zone NOT NULL
);


ALTER TABLE public.smile OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 42046)
-- Name: smile_group; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.smile_group (
    id integer NOT NULL,
    name character varying DEFAULT '125'::character varying NOT NULL,
    created timestamp with time zone DEFAULT '2019-09-14 13:24:43.280425+03'::timestamp with time zone NOT NULL,
    updated timestamp with time zone DEFAULT '2019-09-14 13:24:43.280425+03'::timestamp with time zone NOT NULL
);


ALTER TABLE public.smile_group OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 42044)
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
-- TOC entry 2942 (class 0 OID 0)
-- Dependencies: 209
-- Name: smile_group_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.smile_group_id_seq OWNED BY public.smile_group.id;


--
-- TOC entry 207 (class 1259 OID 42026)
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
-- TOC entry 2943 (class 0 OID 0)
-- Dependencies: 207
-- Name: smile_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.smile_id_seq OWNED BY public.smile.id;


--
-- TOC entry 201 (class 1259 OID 41992)
-- Name: user_2_group; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_2_group (
    id integer NOT NULL,
    group_id integer,
    user_id integer,
    group_role integer NOT NULL,
    created timestamp with time zone DEFAULT '2019-09-14 13:24:43.280425+03'::timestamp with time zone NOT NULL,
    updated timestamp with time zone DEFAULT '2019-09-14 13:24:43.280425+03'::timestamp with time zone NOT NULL
);


ALTER TABLE public.user_2_group OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 41990)
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
-- TOC entry 2944 (class 0 OID 0)
-- Dependencies: 200
-- Name: user_2_group_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_2_group_id_seq OWNED BY public.user_2_group.id;


--
-- TOC entry 197 (class 1259 OID 41960)
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
    avatar character varying,
    created timestamp with time zone DEFAULT '2019-09-14 13:24:43.280425+03'::timestamp with time zone NOT NULL,
    updated timestamp with time zone DEFAULT '2019-09-14 13:24:43.280425+03'::timestamp with time zone NOT NULL
);


ALTER TABLE public.user_account OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 41958)
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
-- TOC entry 2945 (class 0 OID 0)
-- Dependencies: 196
-- Name: user_account_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_account_id_seq OWNED BY public.user_account.id;


--
-- TOC entry 199 (class 1259 OID 41977)
-- Name: user_group; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_group (
    id integer NOT NULL,
    name character varying NOT NULL,
    users_count integer,
    created timestamp with time zone DEFAULT '2019-09-14 13:24:43.280425+03'::timestamp with time zone NOT NULL,
    updated timestamp with time zone DEFAULT '2019-09-14 13:24:43.280425+03'::timestamp with time zone NOT NULL
);


ALTER TABLE public.user_group OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 41975)
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
-- TOC entry 2946 (class 0 OID 0)
-- Dependencies: 198
-- Name: user_group_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_group_id_seq OWNED BY public.user_group.id;


--
-- TOC entry 2747 (class 2604 OID 42021)
-- Name: contact id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contact ALTER COLUMN id SET DEFAULT nextval('public.contact_id_seq'::regclass);


--
-- TOC entry 2744 (class 2604 OID 42005)
-- Name: message id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message ALTER COLUMN id SET DEFAULT nextval('public.message_id_seq'::regclass);


--
-- TOC entry 2750 (class 2604 OID 42031)
-- Name: smile id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.smile ALTER COLUMN id SET DEFAULT nextval('public.smile_id_seq'::regclass);


--
-- TOC entry 2754 (class 2604 OID 42049)
-- Name: smile_group id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.smile_group ALTER COLUMN id SET DEFAULT nextval('public.smile_group_id_seq'::regclass);


--
-- TOC entry 2741 (class 2604 OID 41995)
-- Name: user_2_group id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_2_group ALTER COLUMN id SET DEFAULT nextval('public.user_2_group_id_seq'::regclass);


--
-- TOC entry 2735 (class 2604 OID 41963)
-- Name: user_account id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account ALTER COLUMN id SET DEFAULT nextval('public.user_account_id_seq'::regclass);


--
-- TOC entry 2738 (class 2604 OID 41980)
-- Name: user_group id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_group ALTER COLUMN id SET DEFAULT nextval('public.user_group_id_seq'::regclass);


--
-- TOC entry 2934 (class 0 OID 42060)
-- Dependencies: 211
-- Data for Name: attachment; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2929 (class 0 OID 42018)
-- Dependencies: 206
-- Data for Name: contact; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.contact (id, initiator_id, acceptor_id, status, created, updated) VALUES (1, 1, 2, 0, '2019-09-14 13:48:34.551+03', '2019-09-14 13:48:34.551+03');
INSERT INTO public.contact (id, initiator_id, acceptor_id, status, created, updated) VALUES (2, 1, 3, 0, '2019-09-14 13:50:22.937+03', '2019-09-14 13:50:22.937+03');


--
-- TOC entry 2926 (class 0 OID 42002)
-- Dependencies: 203
-- Data for Name: message; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.message (id, message, user_id, user_group_id, created, updated) VALUES (1, 'Hello', 1, 1, '13:48:48.995+03', '13:48:48.995+03');
INSERT INTO public.message (id, message, user_id, user_group_id, created, updated) VALUES (2, 'Hello!', 2, 1, '13:49:56.411+03', '13:49:56.411+03');
INSERT INTO public.message (id, message, user_id, user_group_id, created, updated) VALUES (3, 'How''re you', 1, 2, '13:50:41.87+03', '13:50:41.87+03');
INSERT INTO public.message (id, message, user_id, user_group_id, created, updated) VALUES (4, 'What''s up!!', 3, 2, '13:51:26.386+03', '13:51:26.386+03');
INSERT INTO public.message (id, message, user_id, user_group_id, created, updated) VALUES (5, 'Hello :ab: ', 1, 1, '01:08:08.53+03', '01:08:08.53+03');
INSERT INTO public.message (id, message, user_id, user_group_id, created, updated) VALUES (6, '1 :ab: ', 1, 2, '01:08:35.501+03', '01:08:35.501+03');
INSERT INTO public.message (id, message, user_id, user_group_id, created, updated) VALUES (7, 'hello', 1, 2, '11:57:45.336+03', '11:57:45.336+03');
INSERT INTO public.message (id, message, user_id, user_group_id, created, updated) VALUES (8, '2', 1, 2, '12:16:08.329+03', '12:16:08.329+03');
INSERT INTO public.message (id, message, user_id, user_group_id, created, updated) VALUES (9, '2', 1, 1, '12:28:55.847+03', '12:28:55.847+03');


--
-- TOC entry 2927 (class 0 OID 42013)
-- Dependencies: 204
-- Data for Name: pinned_message; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2931 (class 0 OID 42028)
-- Dependencies: 208
-- Data for Name: smile; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.smile (id, name, marker, smile_group_id, created, updated) VALUES (2, ' :ab: ', 'R0lGODlhFAAYANUCAEAUEP/mIP/////iHFVACPbKAPraEPrWDP/eGI1dAEA0EPK+AEgwBPK2AFlACP/aFHFVBG1MBO6yAP/eFO6qAOadAPrSBKVpBN6VAPbCAOaZAPrOBPLCAOqhAPbGAPLGAKVxBOqqALKNAM6NAKp1BO66AO6uAJVhBMqlAMKJAOalAJlxBK6JBNauAM6FALp1AK6FAK6BBMqFAN6uAK59AJlpBNalAMKNAJ19BN62AAAAAAAAAAAAAAAAAAAAAAAAACH/C05FVFNDQVBFMi4wAwEAAAAh/h1CdWlsdCB3aXRoIEdJRiBNb3ZpZSBHZWFyIDQuMAAh/iFEZXNpZ24gYnkgQWl3YW4gKGFpd2FuQHlhbmRleC5ydSkAIfkEAcgAOgAsAAAAABQAGAAABuBAnXBILBqPxATSqBQ2l0Wl9Al1JqhVgnZb1REgrJbHY4tBCEsCbnMAANqA0gptdKAOD4BAoOcvbg5FBCIHCHpuiHwNJHRCEBsIA4eIhxkhEUODhQF9fHt8BRIgdAQ5BgMDnG6qAAYFDSOkH6epAba3BhOvGLIHtbe3E64SvEIEM4UDCsC2BgoZFC6kMAWnAcu3ygULHReNEAvVkQrk5NshGpiZNOEHBrkGB9smFd5FDikNHAX8BRwLFCq8CGSEQA0VEho0kEChA4YTBI8QiABiRAUNMi5EaJRmi5YuIIUEAQAh+QQBDwA6ACwGAAcACQAGAAAGJ0CdzmDQWQpCHWIwQCAOyEGAOTUUClJpYPo46BgAQCDMEG4Dum0xCAAh+QQBFAA6ACwGAAcACQAGAAAGGkCdDgAYFoUAgSC5HC6JxOcT2lQurUiisRgEACH5BAEPADoALAYABwAJAAYAAAYnQJ3OYNBZCkIdYjBAIA7IQYA5NRQKUmlg+jjoGABAIMwQbgO6bTEIACH5BAEsAToALAYABwAJAAYAAAYaQJ0OABgWhQCBILkcLonE5xPaVC6tSKKxGAQAIfkEBQ8AOgAsBgAHAAkABgAABidAnc5g0FkKQh1iMEAgDshBgDk1FApSaWD6OOgYAEAgzBBuA7ptMQgAOw==', 1, '2019-09-14 13:24:43.280425+03', '2019-09-14 13:24:43.280425+03');
INSERT INTO public.smile (id, name, marker, smile_group_id, created, updated) VALUES (3, ':ac: ', 'R0lGODlhFAAYANUDAEA0EP/mIFVACP/////aFP/iHPbKAPraEP/eGPrSCPK+APK2APrWDP/eFPLCAFlACO6yAG1MBO6qAHFVBN6VAOadAPbOBKVpBLKNAKVxBK6BBM6NAOqhAPbGAOaZALp1AO66AMqlAOqqAJ19BMqFAOalAPLGAKp1BJlpBN6uAG1QBO6uAJVhBOKVAK6JBKVtANalAMKNAK6FAMKJAM6FAJlxBN62ANauAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACH/C05FVFNDQVBFMi4wAwEAAAAh/iREZXNpZ24gYnkgQWl3YW4gKHd3dy5rb2xvYm9rLndyZy5ydSkAIfkEAcgAOAAsAAAAABQAGAAABt5AnHBILBqPRADSqBQ2l0Wl9Al1AqhVgXZbxQkmrlvHAdOoBEvByMI4HBgJA6iGNj5CjMYVUNgrYg9FAhgMCAADiIeJCyd1QhMWCH0De1eUDiIRQ4MMBQGHlaAGEBl1AjYHnp9XqwAEBgsbpiapAba3tgSvCxSmDp24uAQHo71CAikJCMG3BAkOEjSmMga1ra67HC+OEwrVhrYFhgYKEi2amxreCQe6B3EKKxUXjkIPMwsOBvsGDgsSFT4EMiIARQkICxZAkMCBAot6giJk2FDBA4kLESAe2cKli0ccQQAAIfkEAQ8AOAAsBgAIAAkABQAABhvABqJARBwMikJguSQkDEwmwQmoAgLWa7RJCAIAIfkEARQAOAAsBgAIAAkABQAABhfABmBYGAIUgIEyuUwahwPo0xkwVoeEIAAh+QQBDwA4ACwGAAgACQAFAAAGG8AGokBEHAyKQmC5JCQMTCbBCagCAtZrtEkIAgAh+QQBLAE4ACwGAAgACQAFAAAGF8AGYFgYAhSAgTK5TBqHA+jTGTBWh4QgACH5BAUPADgALAYACAAJAAUAAAYbwAaiQEQcDIpCYLkkJAxMJsEJqAIC1mu0SQgCADs=', 1, '2019-09-14 13:24:43.280425+03', '2019-09-14 13:24:43.280425+03');
INSERT INTO public.smile (id, name, marker, smile_group_id, created, updated) VALUES (4, ':ae: ', 'R0lGODlhEgASANU7AP//8NjQyKiYgHhoOGBIEOjo4KCYeGhQCKiIENCwEOjIGMioEKCACNjY0HBgMJh4EOjQGP/YGPDQGPDIGOC4EJBwCODg2GhQGMCoEP/gIOjAELiQCP/w8JCIYKiQEEAwEJh4CJiIaNjQwHBYCNioEGhICOCwEJhwCHhgONi4GMCQCP8AAMiYCGBQGNiwELiICKiACNigCJhoAODAENCYCGhIANCgCLCQCKh4AJBoCIhgAAAAAAAAAAAAAAAAAAAAACH/C05FVFNDQVBFMi4wAwEAAAAh+QQFCgA7ACwAAAAAEgASAAAGs8CdcLgbEAgDonJ4QCQUigXjsBQ6HpCINiKZUCoO5QUTyZjPXM3mQvSUP/AM/BPxgoYjifzM/0g0JCVCCGV8hhEKJic7KCmFZnMfZnUUKkYKjx8rmyuSlCwtBJhxmpyScCagDgl6cpFzfy4vSTATj4deMTJCBzMSt5N/JDQ1QwwaE79bXRouNrtDFzcUGgoTEwoaFCQ2OGxEDjkkJhQUJi4xLDphVSUnGzY0LzKCVURGSFVBACH5BAUKADsALAYABwAGAAcAAAYTwIxwSCwOP8jkZ8VcIZvOiHISBAA7', 1, '2019-09-14 13:24:43.280425+03', '2019-09-14 13:24:43.280425+03');


--
-- TOC entry 2933 (class 0 OID 42046)
-- Dependencies: 210
-- Data for Name: smile_group; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.smile_group (id, name, created, updated) VALUES (1, 'faces', '2019-09-14 13:24:43.280425+03', '2019-09-14 13:24:43.280425+03');


--
-- TOC entry 2924 (class 0 OID 41992)
-- Dependencies: 201
-- Data for Name: user_2_group; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_2_group (id, group_id, user_id, group_role, created, updated) VALUES (1, 1, 1, 1, '2019-09-14 13:48:44.697+03', '2019-09-14 13:48:44.697+03');
INSERT INTO public.user_2_group (id, group_id, user_id, group_role, created, updated) VALUES (2, 1, 2, 0, '2019-09-14 13:48:44.697+03', '2019-09-14 13:48:44.697+03');
INSERT INTO public.user_2_group (id, group_id, user_id, group_role, created, updated) VALUES (3, 2, 1, 1, '2019-09-14 13:50:27.712+03', '2019-09-14 13:50:27.712+03');
INSERT INTO public.user_2_group (id, group_id, user_id, group_role, created, updated) VALUES (4, 2, 3, 0, '2019-09-14 13:50:27.712+03', '2019-09-14 13:50:27.712+03');
INSERT INTO public.user_2_group (id, group_id, user_id, group_role, created, updated) VALUES (5, 3, 3, 1, '2019-09-15 00:55:40.11+03', '2019-09-15 00:55:40.11+03');
INSERT INTO public.user_2_group (id, group_id, user_id, group_role, created, updated) VALUES (6, 3, 3, 0, '2019-09-15 00:55:40.11+03', '2019-09-15 00:55:40.11+03');


--
-- TOC entry 2920 (class 0 OID 41960)
-- Dependencies: 197
-- Data for Name: user_account; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_account (id, firstname, lastname, password, email, phone, role, avatar, created, updated) VALUES (1, 'Ivan', 'Ivanov', 'admin', 'admin@admin', '1234567891', 'admin', NULL, '2019-09-14 13:24:43.280425+03', '2019-09-14 13:24:43.280425+03');
INSERT INTO public.user_account (id, firstname, lastname, password, email, phone, role, avatar, created, updated) VALUES (2, 'Petr', 'Petrov', '123', 'petrov@mail', '4567912351', 'user', '', '2019-09-14 13:35:22.38+03', '2019-09-14 13:35:22.38+03');
INSERT INTO public.user_account (id, firstname, lastname, password, email, phone, role, avatar, created, updated) VALUES (3, 'Alexandr', 'Alexandrov', '123', 'alex@mail', '9876543214', 'user', '', '2019-09-14 13:35:40.306+03', '2019-09-14 13:35:40.306+03');
INSERT INTO public.user_account (id, firstname, lastname, password, email, phone, role, avatar, created, updated) VALUES (4, 'Maksim', 'Maksimov', '123', 'max@mail', '7894561234', 'user', '', '2019-09-14 13:36:05.443+03', '2019-09-14 13:36:05.443+03');
INSERT INTO public.user_account (id, firstname, lastname, password, email, phone, role, avatar, created, updated) VALUES (5, 'Chuck', 'Norris', '123', 'pepper@mail', '4567891231', 'user', '', '2019-09-14 13:40:56.5+03', '2019-09-14 13:40:56.5+03');


--
-- TOC entry 2922 (class 0 OID 41977)
-- Dependencies: 199
-- Data for Name: user_group; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_group (id, name, users_count, created, updated) VALUES (1, 'Petr Petrov, Ivan Ivanov', 2, '2019-09-14 13:48:44.692+03', '2019-09-14 13:48:44.692+03');
INSERT INTO public.user_group (id, name, users_count, created, updated) VALUES (2, 'Alexandr Alexandrov, Ivan Ivanov', 2, '2019-09-14 13:50:27.708+03', '2019-09-14 13:50:27.708+03');
INSERT INTO public.user_group (id, name, users_count, created, updated) VALUES (3, 'Alexandr Alexandrov, Alexandr Alexandrov', 2, '2019-09-15 00:55:40.107+03', '2019-09-15 00:55:40.107+03');


--
-- TOC entry 2947 (class 0 OID 0)
-- Dependencies: 205
-- Name: contact_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.contact_id_seq', 3, true);


--
-- TOC entry 2948 (class 0 OID 0)
-- Dependencies: 202
-- Name: message_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.message_id_seq', 9, true);


--
-- TOC entry 2949 (class 0 OID 0)
-- Dependencies: 209
-- Name: smile_group_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.smile_group_id_seq', 1, true);


--
-- TOC entry 2950 (class 0 OID 0)
-- Dependencies: 207
-- Name: smile_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.smile_id_seq', 4, true);


--
-- TOC entry 2951 (class 0 OID 0)
-- Dependencies: 200
-- Name: user_2_group_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_2_group_id_seq', 6, true);


--
-- TOC entry 2952 (class 0 OID 0)
-- Dependencies: 196
-- Name: user_account_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_account_id_seq', 5, true);


--
-- TOC entry 2953 (class 0 OID 0)
-- Dependencies: 198
-- Name: user_group_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_group_id_seq', 3, true);


--
-- TOC entry 2787 (class 2606 OID 42069)
-- Name: attachment attachment_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.attachment
    ADD CONSTRAINT attachment_pk PRIMARY KEY (id);


--
-- TOC entry 2775 (class 2606 OID 42025)
-- Name: contact contact_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contact
    ADD CONSTRAINT contact_pk PRIMARY KEY (id);


--
-- TOC entry 2773 (class 2606 OID 42012)
-- Name: message message_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT message_pk PRIMARY KEY (id);


--
-- TOC entry 2783 (class 2606 OID 42059)
-- Name: smile_group smile_group_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.smile_group
    ADD CONSTRAINT smile_group_name_key UNIQUE (name);


--
-- TOC entry 2785 (class 2606 OID 42057)
-- Name: smile_group smile_group_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.smile_group
    ADD CONSTRAINT smile_group_pk PRIMARY KEY (id);


--
-- TOC entry 2777 (class 2606 OID 42043)
-- Name: smile smile_marker_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.smile
    ADD CONSTRAINT smile_marker_key UNIQUE (marker);


--
-- TOC entry 2779 (class 2606 OID 42041)
-- Name: smile smile_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.smile
    ADD CONSTRAINT smile_name_key UNIQUE (name);


--
-- TOC entry 2781 (class 2606 OID 42039)
-- Name: smile smile_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.smile
    ADD CONSTRAINT smile_pk PRIMARY KEY (id);


--
-- TOC entry 2771 (class 2606 OID 41999)
-- Name: user_2_group user_2_group_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_2_group
    ADD CONSTRAINT user_2_group_pk PRIMARY KEY (id);


--
-- TOC entry 2761 (class 2606 OID 41972)
-- Name: user_account user_account_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account
    ADD CONSTRAINT user_account_email_key UNIQUE (email);


--
-- TOC entry 2763 (class 2606 OID 41974)
-- Name: user_account user_account_phone_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account
    ADD CONSTRAINT user_account_phone_key UNIQUE (phone);


--
-- TOC entry 2765 (class 2606 OID 41970)
-- Name: user_account user_account_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account
    ADD CONSTRAINT user_account_pk PRIMARY KEY (id);


--
-- TOC entry 2767 (class 2606 OID 41989)
-- Name: user_group user_group_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_group
    ADD CONSTRAINT user_group_name_key UNIQUE (name);


--
-- TOC entry 2769 (class 2606 OID 41987)
-- Name: user_group user_group_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_group
    ADD CONSTRAINT user_group_pk PRIMARY KEY (id);


--
-- TOC entry 2797 (class 2606 OID 42115)
-- Name: attachment attachment_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.attachment
    ADD CONSTRAINT attachment_fk0 FOREIGN KEY (id) REFERENCES public.message(id);


--
-- TOC entry 2794 (class 2606 OID 42100)
-- Name: contact contact_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contact
    ADD CONSTRAINT contact_fk0 FOREIGN KEY (initiator_id) REFERENCES public.user_account(id);


--
-- TOC entry 2795 (class 2606 OID 42105)
-- Name: contact contact_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contact
    ADD CONSTRAINT contact_fk1 FOREIGN KEY (acceptor_id) REFERENCES public.user_account(id);


--
-- TOC entry 2790 (class 2606 OID 42080)
-- Name: message message_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT message_fk0 FOREIGN KEY (user_id) REFERENCES public.user_account(id);


--
-- TOC entry 2791 (class 2606 OID 42085)
-- Name: message message_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT message_fk1 FOREIGN KEY (user_group_id) REFERENCES public.user_group(id);


--
-- TOC entry 2792 (class 2606 OID 42090)
-- Name: pinned_message pinned_message_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pinned_message
    ADD CONSTRAINT pinned_message_fk0 FOREIGN KEY (message_id) REFERENCES public.message(id);


--
-- TOC entry 2793 (class 2606 OID 42095)
-- Name: pinned_message pinned_message_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pinned_message
    ADD CONSTRAINT pinned_message_fk1 FOREIGN KEY (user_id) REFERENCES public.user_account(id);


--
-- TOC entry 2796 (class 2606 OID 42110)
-- Name: smile smile_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.smile
    ADD CONSTRAINT smile_fk0 FOREIGN KEY (smile_group_id) REFERENCES public.smile_group(id);


--
-- TOC entry 2788 (class 2606 OID 42070)
-- Name: user_2_group user_2_group_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_2_group
    ADD CONSTRAINT user_2_group_fk0 FOREIGN KEY (group_id) REFERENCES public.user_group(id);


--
-- TOC entry 2789 (class 2606 OID 42075)
-- Name: user_2_group user_2_group_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_2_group
    ADD CONSTRAINT user_2_group_fk1 FOREIGN KEY (user_id) REFERENCES public.user_account(id);


-- Completed on 2019-09-15 14:28:39

--
-- PostgreSQL database dump complete
--

