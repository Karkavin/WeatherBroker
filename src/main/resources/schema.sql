DROP TABLE IF EXISTS public.location CASCADE;
DROP TABLE IF EXISTS public.condition CASCADE;

CREATE TABLE public.location
(
      city          VARCHAR(100) NOT NULL PRIMARY KEY,
      region        VARCHAR(100) NOT NULL,
      country       VARCHAR(100) NOT NULL,
      lat           DOUBLE PRECISION NOT NULL,
      lon           DOUBLE PRECISION NOT NULL
);

CREATE TABLE public.condition
(
      id          SERIAL NOT NULL PRIMARY KEY,
      date        DATE NOT NULL,
      temp        SMALLINT NOT NULL,
      text        VARCHAR(150) NOT NULL,
      city        VARCHAR(100) NOT NULL,
      CONSTRAINT fk_condition_location FOREIGN KEY (city) REFERENCES location (city)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);