use mailDb

DROP TABLE Users
--DELETE FROM Users

CREATE TABLE Users (
  Id int IDENTITY PRIMARY KEY NOT NULL,
  Name NVARCHAR(255),
  LastName NVARCHAR(255),
  City NVARCHAR(255),
  Email VARCHAR(255)
);

INSERT INTO Users (Name, LastName, City, Email) VALUES ('stas1','Pr','City','Email@mail')
INSERT INTO Users (Name, LastName, City, Email) VALUES ('Stas2','Pr','City','Email@mail')
INSERT INTO Users (Name, LastName, City, Email) VALUES ('Stas3','Pr','City','Email@mail')