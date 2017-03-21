use mailDb
go;
DROP TABLE Users
--DELETE FROM Users
go;
CREATE TABLE Users (
  Id int IDENTITY PRIMARY KEY NOT NULL,
  Name NVARCHAR(255),
  LastName NVARCHAR(255),
  City NVARCHAR(255),
  Email VARCHAR(255)
);
go;
INSERT INTO Users (Name, LastName, City, Email) VALUES ('stas1','Pr','City','Email@mail')
INSERT INTO Users (Name, LastName, City, Email) VALUES ('Stas2','Pr','City','Email@mail')
INSERT INTO Users (Name, LastName, City, Email) VALUES ('Stas3','Pr','City','Email@mail')