CREATE INDEX fk_cb_health_check_location_cb__codebook_idx
    ON cb_health_check_location(codebook_id);
CREATE INDEX fk_cb_health_check_type_cb__codebook_idx
    ON cb_health_check_type(codebook_id);
CREATE INDEX fk__cb_cb_health_status_codebook_idx
    ON cb_health_status(codebook_id);
CREATE INDEX fk_cb_risk_area_cb__codebook_idx
    ON cb_risk_area(codebook_id);

CREATE INDEX fk_po_person_home_po_address_idx
    ON po_person(address_home_id);
CREATE INDEX fk_po_person_cb_health_status_idx
    ON po_person(health_status);

CREATE INDEX fk_po_health_check_final_location_cb_health_check_location_idx
    ON po_health_check(final_health_check_location);
CREATE INDEX fk_po_health_check_cb_health_check_type_idx
    ON po_health_check(health_check_type);
CREATE INDEX fk_po_health_check_po_person_idx
    ON po_health_check(person_id);
CREATE INDEX fk_po_health_check_pref_location_cb_health_check_location_idx
    ON po_health_check(preferred_health_check_location);
CREATE INDEX fk_po_health_check_cb_risk_area_idx
    ON po_health_check(visited_risk_area_id);

CREATE INDEX fk_po_health_check_result_po_health_check_idx
    ON po_health_check_result(health_check_id);