insert into cb__codebook(id, name, description)
values ('cbHealthCheckLocation', '', '');
insert into cb__codebook(id, name, description)
values ('cbHealthCheckType', '', '');
insert into cb__codebook(id, name, description)
values ('cbHealthStatus', '', '');
insert into cb__codebook(id, name, description)
values ('cbRiskArea', '', '');

insert into cb_risk_area(id, default_item, item_order, text, codebook_id)
values ('1', false, 1, 'Čína', 'cbRiskArea');
insert into cb_risk_area(id, default_item, item_order, text, codebook_id)
values ('2', false, 2, 'Írán', 'cbRiskArea');
insert into cb_risk_area(id, default_item, item_order, text, codebook_id)
values ('3', false, 3, 'Itálie', 'cbRiskArea');
insert into cb_risk_area(id, default_item, item_order, text, codebook_id)
values ('4', false, 4, 'Jižní Korea', 'cbRiskArea');
insert into cb_risk_area(id, default_item, item_order, text, codebook_id)
values ('5', false, 5, 'Francie', 'cbRiskArea');
insert into cb_risk_area(id, default_item, item_order, text, codebook_id)
values ('6', false, 6, 'Španělsko', 'cbRiskArea');
insert into cb_risk_area(id, default_item, item_order, text, codebook_id)
values ('7', false, 7, 'Německo', 'cbRiskArea');
insert into cb_risk_area(id, default_item, item_order, text, codebook_id)
values ('8', false, 8, 'Švýcarsko', 'cbRiskArea');
insert into cb_risk_area(id, default_item, item_order, text, codebook_id)
values ('9', false, 9, 'Norsko', 'cbRiskArea');
insert into cb_risk_area(id, default_item, item_order, text, codebook_id)
values ('10', false, 10, 'Dánsko', 'cbRiskArea');
insert into cb_risk_area(id, default_item, item_order, text, codebook_id)
values ('11', false, 11, 'Nizozemsko', 'cbRiskArea');
insert into cb_risk_area(id, default_item, item_order, text, codebook_id)
values ('12', false, 12, 'Švédsko', 'cbRiskArea');
insert into cb_risk_area(id, default_item, item_order, text, codebook_id)
values ('13', false, 13, 'Velká Británie', 'cbRiskArea');
insert into cb_risk_area(id, default_item, item_order, text, codebook_id)
values ('14', false, 14, 'Belgie', 'cbRiskArea');
insert into cb_risk_area(id, default_item, item_order, text, codebook_id)
values ('15', false, 15, 'Rakousko', 'cbRiskArea');

insert into cb_health_check_type(id, default_item, item_order, text, codebook_id)
values ('EMERGENCY', false, 1, 'Přijede sanitka', 'cbHealthCheckType');
insert into cb_health_check_type(id, default_item, item_order, text, codebook_id)
values ('HOSPITAL', false, 2, 'Návštěva v nemocnici', 'cbHealthCheckType');
insert into cb_health_check_type(id, default_item, item_order, text, codebook_id)
values ('3RD_PARTY', false, 3, 'Nestátní odběrové místo', 'cbHealthCheckType');

insert into cb_health_check_location(id, default_item, item_order, text, codebook_id)
values ('1', false, 1, 'Fakultní nemocnice v Motole', 'cbHealthCheckLocation');
insert into cb_health_check_location(id, default_item, item_order, text, codebook_id)
values ('2', false, 2, 'Thomayerova nemocnice', 'cbHealthCheckLocation');
insert into cb_health_check_location(id, default_item, item_order, text, codebook_id)
values ('3', false, 3, 'Ústřední vojenská nemocnice', 'cbHealthCheckLocation');
insert into cb_health_check_location(id, default_item, item_order, text, codebook_id)
values ('4', false, 4, 'Nemocnice na Bulovce', 'cbHealthCheckLocation');
insert into cb_health_check_location(id, default_item, item_order, text, codebook_id)
values ('5', false, 5, 'Lab In – Institut laboratorní medicíny', 'cbHealthCheckLocation');
insert into cb_health_check_location(id, default_item, item_order, text, codebook_id)
values ('6', false, 6, 'Fakultní nemocnice Plzeň', 'cbHealthCheckLocation');
insert into cb_health_check_location(id, default_item, item_order, text, codebook_id)
values ('7', false, 7, 'Fakultní nemocnice Hradec Králové', 'cbHealthCheckLocation');
insert into cb_health_check_location(id, default_item, item_order, text, codebook_id)
values ('8', false, 8, 'Nemocnice České Budějovice', 'cbHealthCheckLocation');
insert into cb_health_check_location(id, default_item, item_order, text, codebook_id)
values ('9', false, 9, 'Nemocnice Tábor', 'cbHealthCheckLocation');
insert into cb_health_check_location(id, default_item, item_order, text, codebook_id)
values ('10', false, 10, 'Nemocnice Strakonice', 'cbHealthCheckLocation');
insert into cb_health_check_location(id, default_item, item_order, text, codebook_id)
values ('11', false, 11, 'Nemocnice Jindřichův Hradec', 'cbHealthCheckLocation');
insert into cb_health_check_location(id, default_item, item_order, text, codebook_id)
values ('12', false, 12, 'Fakultní nemocnice Brno Bohunice', 'cbHealthCheckLocation');
insert into cb_health_check_location(id, default_item, item_order, text, codebook_id)
values ('13', false, 13, 'Fakultní nemocnice Ostrava', 'cbHealthCheckLocation');
insert into cb_health_check_location(id, default_item, item_order, text, codebook_id)
values ('14', false, 14, 'Slezská nemocnice v Opavě', 'cbHealthCheckLocation');
insert into cb_health_check_location(id, default_item, item_order, text, codebook_id)
values ('15', false, 15, 'Fakultní nemocnice Olomouc', 'cbHealthCheckLocation');
insert into cb_health_check_location(id, default_item, item_order, text, codebook_id)
values ('16', false, 16, 'Oblastní nemocnice Kladno, a. s.', 'cbHealthCheckLocation');
insert into cb_health_check_location(id, default_item, item_order, text, codebook_id)
values ('17', false, 17, 'Oblastní nemocnice Kolín, a. s.', 'cbHealthCheckLocation');
insert into cb_health_check_location(id, default_item, item_order, text, codebook_id)
values ('18', false, 18, 'Oblastní nemocnice Mladá Boleslav, a. s.', 'cbHealthCheckLocation');
insert into cb_health_check_location(id, default_item, item_order, text, codebook_id)
values ('19', false, 19, 'Nemocnice Rudolfa a Stefanie Benešov, a. s.', 'cbHealthCheckLocation');
