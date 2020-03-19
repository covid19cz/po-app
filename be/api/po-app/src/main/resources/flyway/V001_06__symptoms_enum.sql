alter table po_health_check alter column dry_cough_duration type varchar using dry_cough_duration::varchar;

alter table po_health_check alter column high_temperature_duration type varchar using high_temperature_duration::varchar;
