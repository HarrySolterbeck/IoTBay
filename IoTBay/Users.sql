/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Joshua
 * Created: 27/04/2024
 */

CREATE TABLE USER
    (name   VARCHAR(100),
    DOB     DATE,
    email   VARCHAR(100),
    pWord   VARCHAR(100),
    CONSTRAINT name_PK PRIMARY KEY (name));