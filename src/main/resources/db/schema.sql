CREATE TABLE IF NOT EXISTS REPORT
(
    ID                int AUTO_INCREMENT COMMENT '아이디'
    PRIMARY KEY,
    TITLE             varchar(500) NULL COMMENT '제목',
    CONTENT           text         NULL COMMENT '내용',
    IP                varchar(45)  NULL COMMENT 'IP 주소',
    REGISTRATION_DATE datetime     NULL COMMENT '등록날짜'
)
COMMENT '게시판';

CREATE TABLE IF NOT EXISTS SUBWAY_STATION
(
    STATION_ID          int          NOT NULL COMMENT '지하철역 ID'
    PRIMARY KEY,
    SUBWAY_ID           int          NULL COMMENT '호선 ID',
    STATION_NAME        varchar(100) NULL COMMENT '지하철역명',
    PREVIOUS_STATION_ID int          NULL COMMENT '이전역 ID',
    FR_CODE             varchar(10)  NULL COMMENT '외부코드',
    CONSTRAINT SUBWAY_STATION_SUBWAY_STATION_STATION_ID_fk
    FOREIGN KEY (PREVIOUS_STATION_ID) REFERENCES SUBWAY_STATION (STATION_ID)
)
COMMENT '지하철역';
