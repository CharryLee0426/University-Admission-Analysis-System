# initialization
drop database admission;

# create database zone
create database if not exists admimsion;

use admission;


# create table zone
create table if not exists province (
    province_id varchar(64),
    province_name varchar(64)
);

create table if not exists school (
    id bigint not null,
    province_id varchar(64),
    school_id varchar(64),
    school_name varchar(64),
    school_type varchar(64),
    school_level varchar(64),
    is_985 bool,
    is_211 bool,
    is_doubletoptier bool
);

create table if not exists majorscore (
    id bigint not null,
    year varchar(64),
    school_id varchar(64),
    province_id varchar(64),
    group_id varchar(64),
    category varchar(64),
    category_id varchar(64),
    round varchar(64),
    round_id varchar(64),
    lowest double,
    lowest_rank int8,
    selection varchar(64),
    line int8,
    is_selection bool
);

create table if not exists majorscore(
    id bigint not null,
    year varchar(64),
    province_id varchar(64),
    school_id varchar(64),
    group_id varchar(64),
    level_id varchar(64),
    level varchar(64),
    category_id varchar(64),
    category varchar(64),
    clams_id varchar(64),
    clams varchar(64),
    majorcategory_id varchar(64),
    majorcategory varchar(64),
    major varchar(64),
    lowest double,
    lowest_rank int8,
    degree_id varchar(64),
    degree varchar(64),
    selection varchar(64),
    is_selection bool
);

create table if not exists account (
    username varchar(64) not null,
    password varchar(64) not null
);

create table if not exists student (
    major_id bigint not null,
    major_rate double not null,
    male_number int not null,
    female_number int not null,
    total_number int not null,
    male_rate double not null,
    female_rate double not null
);
