
    create sequence producer_seq start with 1 increment by 50;

    create sequence storage_object_meta_seq start with 1 increment by 50;

    create sequence storage_object_seq start with 1 increment by 50;

    create table producer (
        id bigint not null,
        shortname varchar(25),
        producer_name varchar(255),
        primary key (id)
    );

    create table storage (
        id bigint not null,
        name varchar(255),
        address bigint,
        primary key (id)
    )

    create table address (
        id bigint not null,
        street varchar(255),
        number bigint,
        address_Addition varchar(255),
        zip_Code bigint,
        city varchar(255),
            primary key (id)
    )

    create table storage_object (
        id bigint not null,
        storage_object_meta bigint,
        primary key (id)
    );

    create table storage_object_meta (
        consumables_per_box integer check (consumables_per_box>=0),
        fk_producer bigint,
        id bigint not null,
        interface_speed varchar(255),
        object_name varchar(255),
        os_version varchar(255),
        type varchar(255) check (type in ('IP_PHONE','ROUTER','SWITCH','SFP','CONSUMABLES')),
        wave_length varchar(255),
        primary key (id)
    );

    alter table if exists storage_object 
       add constraint StorageObject_2_StorageObejctMeta 
       foreign key (storage_object_meta) 
       references storage_object_meta;

    alter table if exists storage_object_meta 
       add constraint FK_producer_2_storageObjectMeta 
       foreign key (fk_producer) 
       references producer;
