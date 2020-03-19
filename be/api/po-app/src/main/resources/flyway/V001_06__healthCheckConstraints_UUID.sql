alter table po_health_check_result
    alter column result_date set not null;

alter table po_health_check_result
    alter column result_positive set not null;
