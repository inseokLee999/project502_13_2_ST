## 의존성 추가

plugins {
id 'java'
id 'application'
}

group = 'org.choongang'
version = '1.0-SNAPSHOT'
mainClassName = 'org.choongang.Application'

repositories {
mavenCentral()
}

dependencies {
compileOnly 'org.projectlombok:lombok:1.18.32'
annotationProcessor 'org.projectlombok:lombok:1.18.32'
runtimeOnly 'com.oracle.database.jdbc:ojdbc11:23.4.0.24.05'
implementation 'com.oracle.database.nls:orai18n:23.4.0.24.05'
implementation 'org.mybatis:mybatis:3.5.16'
implementation 'org.slf4j:slf4j-api:2.0.13'
implementation 'ch.qos.logback:logback-classic:1.5.6'

    testImplementation platform('org.junit:junit-bom:5.10.0')
    testImplementation 'org.junit.jupiter:junit-jupiter'
}

test {
useJUnitPlatform()
}

tasks.jar{
manifest.attributes['Main-class'] = 'org.choongang.Application'
}
## DataBase 설정
CMD 에서
docker exec -it oracle-xe /bin/bash
sqlplus system/oracle
CREATE USER PROJECT2_2 IDENTIFIED BY oracle;
GRANT CONNECT, RESOURCE TO PROJECT2_2;
ALTER USER PROJECT2_2 QUOTA UNLIMITED ON USERS;

## STUDENT_INFO TABLE 구성
CREATE TABLE STUDENT_INFO (
STU_NO NUMBER(8) PRIMARY KEY,
STU_PW VARCHAR2(65) NOT NULL,
STU_NM VARCHAR2(10) NOT NULL,
STU_GENDER VARCHAR2(10) CHECK(STU_GENDER IN ('남','여')),
GRADE NUMBER(4) CHECK(GRADE IN (1,2,3,4)),
SEMESTER VARCHAR2(65) CHECK(SEMESTER IN ('1학기','2학기','계절학기')),
DEPT VARCHAR2(20),
STU_CREDIT NUMBER(8),
AD_YR DATE,
E_MAIL VARCHAR2(65),
TEL NUMBER(10)
);

## ATTEND TABLE 구성
CREATE TABLE ATTEND(
ATTEND_CODE NUMBER(10) PRIMARY KEY,
STUDENT_NAME VARCHAR(65) NOT NULL,
DEPARTMENT VARCHAR(65) NOT NULL,
STUDENT_ID VARCHAR(65) NOT NULL,
ONE_WEEK VARCHAR(20) NOT NULL,
TWO_WEEK VARCHAR(20) NOT NULL,
THREE_WEEK VARCHAR(20) NOT NULL,
FOUR_WEEK VARCHAR(20) NOT NULL,
FIVE_WEEK VARCHAR(20) NOT NULL,
SIX_WEEK VARCHAR(20) NOT NULL,
SEVEN_WEEK VARCHAR(20) NOT NULL
);  

## SUBJECT_INFO TABLE 
CREATE SEQUENCE SEQ_SUBJECT;
CREATE TABLE SUBJECT_INFO(
SUB_CODE NUMBER(10) PRIMARY KEY,
SUB_NAME VARCHAR2(65) NOT NULL,
PROFESSOR VARCHAR2(65) NOT NULL,
START_TIME VARCHAR2(65),
END_TIME VARCHAR2(65),
SUB_TYPE VARCHAR2(65),
SUB_CREDIT NUMBER(2),
SUB_HOUR NUMBER(2)
);

## MEMBER TABLE
CREATE SEQUENCE SEQ_MEMBER;
CREATE TABLE MEMBER (
USER_NO NUMBER(10) PRIMARY KEY,
USER_ID VARCHAR2(30) NOT NULL UNIQUE,
USER_PW VARCHAR2(65) NOT NULL,
USER_NM VARCHAR2(40) NOT NULL,
USER_TYPE VARCHAR2(30) DEFAULT 'STUDENT',


REG_DT DATE DEFAULT SYSDATE,
MOD_DT DATE
);

## 출석 정보 table
CREATE TABLE ATTEND(
ATTEND_CODE NUMBER(10) PRIMARY KEY,
STUDENT_NAME VARCHAR(65) NOT NULL,
DEPARTMENT VARCHAR(65) NOT NULL,
STUDENT_ID VARCHAR(65) NOT NULL,
ONE_WEEK VARCHAR(20) NOT NULL,
TWO_WEEK VARCHAR(20) NOT NULL,
THREE_WEEK VARCHAR(20) NOT NULL,
FOUR_WEEK VARCHAR(20) NOT NULL,
FIVE_WEEK VARCHAR(20) NOT NULL,
SIX_WEEK VARCHAR(20) NOT NULL,
SEVEN_WEEK VARCHAR(20) NOT NULL
);