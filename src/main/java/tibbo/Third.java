package tibbo;

public class Third {

//    -- auto-generated definition
//    create table viewers_stats
//            (
//                      id         integer                             not null primary key,
//                      account_id integer                             not null,
//                      region     varchar(256)                        not null,
//                      created    timestamp default CURRENT_TIMESTAMP not null
//            );

    //написать запрос топ 5 регионов где большее количество уникальный аккаунтов за последний месяц

//  select region from
//    (select distinct on (account_id) * from viewers_stats where created > (now() - '1 month'::interval)) as views
//    group by region order by count(*) desc limit 5;
//



//    alter table viewers_stats
//    owner to postgres;
//
//    create index viewers_stats_account_id_idx
//    on viewers_stats (account_id);
//
//    create index viewers_stats_region_idx
//    on viewers_stats (region);




}
