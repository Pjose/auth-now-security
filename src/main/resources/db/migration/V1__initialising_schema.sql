alter table if exists _user
       drop constraint if exists FK1na6sk0dwedjh2ou0ae6e32mj;

alter table if exists token
       drop constraint if exists FKiblu4cjwvyntq3ugo31klp1c6;

alter table if exists user_profile_patients
       drop constraint if exists FK1m1a5xdlxv4690l9by2xncnkt;

alter table if exists user_profile_patients
       drop constraint if exists FK37qewu15i7pt7cd067h5psdg2;

drop table if exists _user cascade;

drop table if exists patient cascade;

drop table if exists token cascade;

drop table if exists user_profile cascade;

drop table if exists user_profile_patients cascade;

drop sequence if exists _user_seq;

drop sequence if exists patient_seq;

drop sequence if exists token_seq;

drop sequence if exists user_profile_seq;

create sequence _user_seq start with 1 increment by 50;

create sequence patient_seq start with 1 increment by 50;

create sequence token_seq start with 1 increment by 50;

create sequence user_profile_seq start with 1 increment by 50;

create table _user (
        has_drive boolean not null,
        id bigint not null,
        user_profile_id bigint unique,
        active_subscription varchar(255),
        drive_access_key varchar(255),
        email varchar(255),
        o_auth_key varchar(255),
        password varchar(255),
        role varchar(255) check (role in ('USER','ADMIN','MANAGER')),
        user_history varchar(255),
        primary key (id)
    );

create table patient (
        id bigint not null,
        name varchar(255),
        patient_profile varchar(255),
        medical_events varchar(255) array,
        primary key (id)
    );

create table token (
        expired boolean not null,
        id integer not null,
        revoked boolean not null,
        user_id bigint,
        token varchar(255) unique,
        token_type varchar(255) check (token_type in ('BEARER')),
        primary key (id)
    );

create table user_profile (
        dob timestamp(6),
        id bigint not null,
        name varchar(255),
        phone varchar(255),
        workspace varchar(255),
        primary key (id)
    );

create table user_profile_patients (
        patients_id bigint not null unique,
        user_profile_id bigint not null,
        primary key (patients_id, user_profile_id)
    );

alter table if exists _user
       add constraint FK1na6sk0dwedjh2ou0ae6e32mj
       foreign key (user_profile_id)
       references user_profile;

alter table if exists token
       add constraint FKiblu4cjwvyntq3ugo31klp1c6
       foreign key (user_id)
       references _user;

alter table if exists user_profile_patients
       add constraint FK1m1a5xdlxv4690l9by2xncnkt
       foreign key (patients_id)
       references patient;

alter table if exists user_profile_patients
       add constraint FK37qewu15i7pt7cd067h5psdg2
       foreign key (user_profile_id)
       references user_profile;