--use mailDb;

DROP TABLE Users;
--DELETE FROM Users

CREATE TABLE Users (
  Id serial PRIMARY KEY NOT NULL, --serial
  Name NVARCHAR(255),
  LastName NVARCHAR(255),
  City NVARCHAR(255),
  Email VARCHAR(255)
);

INSERT INTO Users (Name, LastName, City, Email) VALUES
  ('stas1','Pr','City','Email@mail'),
  ('Stas2','Pr','City','Email@mail'),
  ('Stas3','Pr','City','Email@mail');

