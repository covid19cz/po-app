insert into po_user(id, created_at, updated_at, login, password, role, invalid_login_attempts)
values (nextval('po_user_seq'), now(), now(), 'covid19', '$2a$10$rlzmOMoN0tRHXEyzpoaldut0FlW.wSnRNW8UTwMAyJXL/g3N65r/C', 'ADMIN', 0);

insert into po_operator(id, created_at, updated_at, name, active, user_id)
values (nextval('po_operator_seq'), now(), now(), 'covid19', true, (select id from po_user where login='covid19'));
