create database menaxhimi_i_fluturimeve_airoport;

use menaxhimi_i_fluturimeve_airoport;
CREATE TABLE perdoruesit (
  id INT PRIMARY KEY,
  emri VARCHAR(255),
  mbiemri VARCHAR(255),
  email VARCHAR(255),
  fjalekalimi VARCHAR(255),
  mosha INT,
  gjinia VARCHAR(10),
  adresa VARCHAR(255),
  numri_telefonit VARCHAR(20)
);

CREATE TABLE fluturimet (
  id INT PRIMARY KEY,
  airline VARCHAR(50),
  qyteti_nisjes VARCHAR(50),
  data_nisjes DATETIME,
  qyteti_arritjes VARCHAR(50),
  data_arritjes DATETIME,
  status VARCHAR(20)
);

CREATE TABLE bileta(
   id INT PRIMARY KEY,
   dy_drejtime boolean
   
);

