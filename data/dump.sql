--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2
-- Dumped by pg_dump version 16.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    date_of_birth date,
    email character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    mobile_number character varying(255)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.users_id_seq OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, date_of_birth, email, first_name, last_name, mobile_number) FROM stdin;
1	1995-05-09	SaiKrishna@mysillydreams.com	Sai Krishna	Thota	8520857988
2	1995-05-09	SaiChatla@mysillydreams.com	Sai Charan	Chatla	8520857989
3	1995-05-09	sai@mysillydreams.com	Sai	Thota	8520857987
6	1995-05-09	kolusu@mysillydreams.com	Vijay	Kolusu	8520857986
9	1995-05-09	Bhavvi@mysillydreams.com	Bhavvi	Thota	1234567890
13	1995-05-09	leo@mysillydreams.com	Leo	ch	1234567567
14	1995-05-09	mary@mysillydreams.com	mary	ch	1234567123
15	1995-05-09	Charlie@mysillydreams.com	Charlie	ch	1234567329
16	1995-05-09	christopherry@mysillydreams.com	christopher	ch	1234567542
18	1995-05-09	vvv@mysillydreams.com	vvv	k	9705080663
24	1995-05-09	yyy@mysillydreams.com	yyy	k	9705080662
27	1995-05-09	iuhmij@mysillydreams.com	iuhmij	k	9705080123
30	\N	ihmij@mysillydreams.com	iuhmij	k	9705080120
31	\N	iij@mysillydreams.com	iuhmij	k	9705080121
32	\N	iimij@mysillydreams.com	iuhmij	k	9705080131
35	\N	iiij@mysillydreams.com	iuhmij	k	9775080131
36	\N	iiiuihj@mysillydreams.com	iuhmij	k	8775080131
37	\N	iiiukjojohj@mysillydreams.com	iuhmij	k	6775080131
38	\N	iiiujojohj@mysillydreams.com	iuhmij	k	4775080131
39	1995-05-09	iiuijiumijojohj@mysillydreams.com	iuhmij	k	3775080131
42	1995-05-09	saicrihmegjmo@mysillydreams.com	Anu	T	9705080657
43	1995-05-09	gbhanu@mysillydreams.com	bhanu	G	7702727183
\.


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 43, true);


--
-- Name: users uk_6dotkott2kjsp8vw4d0m25fb7; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk_6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email);


--
-- Name: users uk_r7c96a004bv8w16jgdm8imich; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk_r7c96a004bv8w16jgdm8imich UNIQUE (mobile_number);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

