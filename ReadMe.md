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