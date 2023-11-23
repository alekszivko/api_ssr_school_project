create sequence producer_seq start with 1 increment by 50;
create sequence storage_object_meta_seq start with 1 increment by 50;
create sequence storage_object_seq start with 1 increment by 50;
create table producer
(
    id            number(19,0) not null,
    shortname     varchar2(25 char),
    producer_name varchar2(255 char),
    primary key (id)
);
create table storage_object
(
    id                  number(19,0) not null,
    storage_object_meta number(19,0),
    primary key (id)
);
create table storage_object_meta
(
    consumables_per_box number(10,0) check (consumables_per_box>=0),
    fk_producer         number(19,0),
    id                  number(19,0) not null,
    interface_speed     varchar2(255 char),
    object_name         varchar2(255 char),
    os_version          varchar2(255 char),
    type                varchar2(255 char) check (type in ('IP_PHONE','ROUTER','SWITCH','SFP','CONSUMABLES')),
    wave_length         varchar2(255 char),
    primary key (id)
);
alter table storage_object
    add constraint StorageObject_2_StorageObejctMeta foreign key (storage_object_meta) references storage_object_meta;
alter table storage_object_meta
    add constraint FK_producer_2_storageObjectMeta foreign key (fk_producer) references producer;
