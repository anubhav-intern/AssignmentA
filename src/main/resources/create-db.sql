CREATE TABLE demo4 (id INTEGER GENERATED BY DEFAULT AS IDENTITY, name VARCHAR(50) NOT NULL,address VARCHAR(50), state VARCHAR(20), country VARCHAR(20), mobile VARCHAR(20),email VARCHAR(50) UNIQUE, PRIMARY KEY (id) );

CREATE TABLE tag4 (id INTEGER , tagName VARCHAR(50) NOT NULL,UNIQUE(id,tagName), FOREIGN KEY (id) REFERENCES demo4(id) );