# 测试表初始化

CREATE TABLE USER
(
    ROWKEY   varchar PRIMARY KEY,
    NAME     varchar,
    AGE      integer,
    BIRTHDAY date
);

UPSERT INTO USER VALUES('key333', 'Kalin', 25, '1992-12-11')
