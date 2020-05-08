--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12rc1

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

--
-- Name: Yetkililer; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA "Yetkililer";


ALTER SCHEMA "Yetkililer" OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: Kisiler; Type: TABLE; Schema: Yetkililer; Owner: postgres
--

CREATE TABLE "Yetkililer"."Kisiler" (
    numara integer NOT NULL,
    "kullaniciAdi" character varying(40) NOT NULL,
    sifre character varying(40) NOT NULL
);


ALTER TABLE "Yetkililer"."Kisiler" OWNER TO postgres;

--
-- Name: Kisiler_numara_seq; Type: SEQUENCE; Schema: Yetkililer; Owner: postgres
--

CREATE SEQUENCE "Yetkililer"."Kisiler_numara_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Yetkililer"."Kisiler_numara_seq" OWNER TO postgres;

--
-- Name: Kisiler_numara_seq; Type: SEQUENCE OWNED BY; Schema: Yetkililer; Owner: postgres
--

ALTER SEQUENCE "Yetkililer"."Kisiler_numara_seq" OWNED BY "Yetkililer"."Kisiler".numara;


--
-- Name: SicaklikDegerleri; Type: TABLE; Schema: Yetkililer; Owner: postgres
--

CREATE TABLE "Yetkililer"."SicaklikDegerleri" (
    "Sicaklik" integer NOT NULL,
    "EklenmeTarihi" character varying(40) NOT NULL
);


ALTER TABLE "Yetkililer"."SicaklikDegerleri" OWNER TO postgres;

--
-- Name: Kisiler numara; Type: DEFAULT; Schema: Yetkililer; Owner: postgres
--

ALTER TABLE ONLY "Yetkililer"."Kisiler" ALTER COLUMN numara SET DEFAULT nextval('"Yetkililer"."Kisiler_numara_seq"'::regclass);


--
-- Data for Name: Kisiler; Type: TABLE DATA; Schema: Yetkililer; Owner: postgres
--

INSERT INTO "Yetkililer"."Kisiler" VALUES (1, 'Melih Ensar', 'Barışık');
INSERT INTO "Yetkililer"."Kisiler" VALUES (2, 'Ömer Can', 'Çalışır');
INSERT INTO "Yetkililer"."Kisiler" VALUES (3, 'Admin', '123');


--
-- Data for Name: SicaklikDegerleri; Type: TABLE DATA; Schema: Yetkililer; Owner: postgres
--



--
-- Name: Kisiler_numara_seq; Type: SEQUENCE SET; Schema: Yetkililer; Owner: postgres
--

SELECT pg_catalog.setval('"Yetkililer"."Kisiler_numara_seq"', 1, false);


--
-- Name: Kisiler numaraPK; Type: CONSTRAINT; Schema: Yetkililer; Owner: postgres
--

ALTER TABLE ONLY "Yetkililer"."Kisiler"
    ADD CONSTRAINT "numaraPK" PRIMARY KEY (numara);


--
-- PostgreSQL database dump complete
--

