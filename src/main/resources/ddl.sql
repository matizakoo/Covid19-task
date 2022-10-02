create table population
(
    idpopulation              int auto_increment
        primary key,
    symulations_idsymulations int not null,
    infected_pi               int not null,
    healthyunprotected_pv     int not null,
    deaths_pm                 int not null,
    healthyprotected_pr       int not null,
    constraint fk_population_symulations
        foreign key (symulations_idsymulations) references symulations (idsymulations)
);

create index fk_population_symulations_idx
    on population (symulations_idsymulations);


create table symulations
(
    idsymulations   int auto_increment
        primary key,
    name_n          varchar(45) not null,
    size_p          int         not null,
    start_i         int         not null,
    indicator_r     int         not null,
    deathratio_m    int         not null,
    recoverindex_ti int         not null,
    deathindex_tm   int         not null,
    daysindex_ts    int         not null
);

