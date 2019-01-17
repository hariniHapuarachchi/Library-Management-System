CREATE TABLE Member(
  mId VARCHAR(10) NOT NULL PRIMARY KEY ,
  mName VARCHAR(30) NOT NULL ,
  mAddress VARCHAR(50) NOT NULL ,
  mobile varchar(11),
  nic varchar(10),
  mType varchar(30)
);

CREATE TABLE Author(
  aId VARCHAR(10) NOT NULL PRIMARY KEY ,
  aName VARCHAR(30) NOT NULL

);

CREATE TABLE Publisher(
  pId VARCHAR(10) NOT NULL PRIMARY KEY ,
  pName VARCHAR(30) NOT NULL

);

CREATE TABLE Book(
  bId VARCHAR(10) NOT NULL PRIMARY KEY ,
  bName VARCHAR(30) NOT NULL ,
  copies INT
);

CREATE TABLE ReturnBook(
  rId VARCHAR(10) NOT NULL PRIMARY KEY ,
  rDate varchar(20),
  fine DOUBLE,
  exDate VARCHAR(20),
  status VARCHAR(30)
);

CREATE TABLE BookWithAuthor(
  baId VARCHAR(10) NOT NULL PRIMARY KEY ,
  bookId VARCHAR(10) NOT NULL,
  authorId VARCHAR(10) NOT NULL ,

  CONSTRAINT FOREIGN KEY(bookId) REFERENCES Book(bId),
  CONSTRAINT FOREIGN KEY (authorId) REFERENCES Author(aId)
);



CREATE TABLE BookWithPublisher(
  bpId VARCHAR(10) NOT NULL PRIMARY KEY ,
  pBookId VARCHAR(10) NOT NULL,
  pubId VARCHAR(10) NOT NULL ,
  publishDate VARCHAR(30),

  CONSTRAINT FOREIGN KEY(pBookId) REFERENCES Book(bId),
  CONSTRAINT FOREIGN KEY (pubId) REFERENCES Publisher(pId)
);

CREATE TABLE IssuedBook(
  issueId VARCHAR(10) NOT NULL PRIMARY KEY ,
  iBookId VARCHAR(10) NOT NULL,
  iMemId VARCHAR(10) NOT NULL ,
  issuedDate VARCHAR(30),
  returnId VARCHAR(10) NOT NULL ,

  CONSTRAINT FOREIGN KEY(iBookId) REFERENCES Book(bId),
  CONSTRAINT FOREIGN KEY (iMemId) REFERENCES Member(mId),
  CONSTRAINT FOREIGN KEY (returnId) REFERENCES ReturnBook(rId)
);

SELECT * FROM Publisher;
SELECT * FROM Book;
SELECT * FROM Author;
SELECT * FROM BookWithAuthor;
SELECT * FROM BookWithPublisher;
SELECT * FROM Member;
SELECT * FROM IssuedBook;
SELECT * FROM ReturnBook;

truncate IssuedBook;
truncate ReturnBook;

DELETE FROM Book where bId="20";
DELETE FROM BookWithPublisher where bpId="";
drop table IssuedBook;

ALTER TABLE Book ADD COLUMN availableBooks INT;

INSERT INTO IssuedBook VALUES ("1","1","1","2018-12-04","1");
INSERT INTO IssuedBook VALUES ("2","2","2","2018-12-05","2");
INSERT INTO IssuedBook VALUES ("3","3","3","2018-12-06","3");
INSERT INTO IssuedBook VALUES ("4","4","4","2018-12-07","4");
INSERT INTO IssuedBook VALUES ("5","5","5","2018-12-08","5");
INSERT INTO IssuedBook VALUES ("6","6","6","2018-12-09","6");
INSERT INTO IssuedBook VALUES ("7","7","7","2018-12-10","7");
INSERT INTO IssuedBook VALUES ("8","8","8","2018-12-11","8");
INSERT INTO IssuedBook VALUES ("9","9","9","2018-12-12","9");
INSERT INTO IssuedBook VALUES ("10","10","10","2018-12-13","10");

INSERT INTO ReturnBook(rId,exDate,status) VALUES ("1","2018-12-11","NOT RETURNED");
INSERT INTO ReturnBook(rId,exDate,status) VALUES ("2","2018-12-12","NOT RETURNED");
INSERT INTO ReturnBook(rId,exDate,status) VALUES ("3","2018-12-13","NOT RETURNED");
INSERT INTO ReturnBook(rId,exDate,status) VALUES ("4","2018-12-14","NOT RETURNED");
INSERT INTO ReturnBook(rId,exDate,status) VALUES ("5","2018-12-15","NOT RETURNED");
INSERT INTO ReturnBook(rId,exDate,status) VALUES ("6","2018-12-16","NOT RETURNED");
INSERT INTO ReturnBook(rId,exDate,status) VALUES ("7","2018-12-17","NOT RETURNED");
INSERT INTO ReturnBook(rId,exDate,status) VALUES ("8","2018-12-18","NOT RETURNED");
INSERT INTO ReturnBook(rId,exDate,status) VALUES ("9","2018-12-19","NOT RETURNED");
INSERT INTO ReturnBook(rId,exDate,status) VALUES ("10","2018-12-20","NOT RETURNED");

UPDATE Author SET aName="Piyadasa Sirisena" WHERE aId="7";
