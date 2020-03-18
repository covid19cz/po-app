alter table po_health_check add visited_risk_area_id varchar(255)
    constraint fk_po_health_check_cb_risk_area
        references cb_risk_area(id);
drop table po_visited_area;
