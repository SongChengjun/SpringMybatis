create DATABASE mybatis;
use mybatis;

CREATE TABLE bidder (
  id bigint(20) NOT NULL auto_increment,
  name varchar(20),
  password varchar(20),
  mobile varchar(11),
  idNum varchar(18),
  address varchar(18),
  primary key(id)
) ENGINE=innodb DEFAULT charset=utf8 COMMENT='竞买人信息表';

