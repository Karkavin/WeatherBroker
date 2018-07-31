DROP TABLE IF EXISTS public.location CASCADE;
DROP TABLE IF EXISTS public.condition CASCADE;

CREATE TABLE public.location
(
      id            SERIAL NOT NULL PRIMARY KEY,
      city          VARCHAR(100) NOT NULL,
      region        VARCHAR(100) NOT NULL,
      country       VARCHAR(100) NOT NULL,
      lat           DOUBLE PRECISION NOT NULL,
      lon           DOUBLE PRECISION NOT NULL
);

CREATE TABLE public.condition
(
      id          SERIAL NOT NULL PRIMARY KEY,
      date        TIMESTAMP NOT NULL,
      temp        SMALLINT NOT NULL,
      text        VARCHAR(150) NOT NULL,
      city_id     BIGINT NOT NULL,
      CONSTRAINT fk_condition_location FOREIGN KEY (city_id) REFERENCES location (id)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);

CREATE INDEX IX_condition_city_id ON public.condition (city_id);
CREATE INDEX IX_condition_date_city_id ON public.condition (date, city_id);
CREATE INDEX IX_condition_date ON public.condition (date);