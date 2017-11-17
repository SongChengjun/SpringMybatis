CREATE DATABASE IF NOT EXISTS mybatis;
use mybatis;

CREATE table IF NOT EXISTS bidder (
  id bigint(20) NOT NULL auto_increment,
  name varchar(20),
  password varchar(20),
  mobile varchar(11),
  idNum varchar(18),
  address varchar(18),
  primary key(id)
) ENGINE=innodb DEFAULT charset=utf8 COMMENT='竞买人信息表';

CREATE table IF NOT EXISTS lot (
  id bigint(20) NOT NULL auto_increment primary key,
  name varchar(20) NOT NULL,
  status varchar(1) NOT NULL,
  start_price decimal(19,2) NOT NULL,
  current_price decimal(19,2),
  bidder_id bigint,
  start_time datetime NOT NULL,
  end_time datetime NOT NULL
) ENGINE=innodb DEFAULT charset=utf8 COMMENT='拍品信息表';

CREATE table IF NOT EXISTS bidPriceLog (
  id bigint(20) NOT NULL auto_increment primary key,
  lot_id bigint NOT NULL,
  bidder_id bigint NOT NULL,
  price decimal(19,2) NOT NULL,
  bidTime datetime NOT NULL
) ENGINE=innodb DEFAULT charset=utf8 COMMENT='竞价记录表';

