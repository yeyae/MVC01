���̺� �̸� movie

code number(4) primary key,
title varchar2(50),
price number(10),
director varchar2(20),
poster varchar2(100),
synopsis varchar2(200)

code�� �������� 1�� �ڵ� ����

drop table movie;
drop sequence movie_seq;

create sequence movie_seq increment by 1 start with 1 max;

