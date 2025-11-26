-- ============================
-- USERS
-- ============================
INSERT INTO users (id, username, email, password)
VALUES ('11111111-1111-1111-1111-111111111111',
        'admin_user',
        'admin@example.com',
        'password123');

INSERT INTO users (id, username, email, password)
VALUES ('22222222-2222-2222-2222-222222222222',
        'manager_user',
        'manager@example.com',
        'password123');



-- ============================
-- RESIDENTS
-- ============================
INSERT INTO residents (id, first_name, last_name, service_name, user_id)
VALUES ('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
        'Michael',
        'Stone',
        'Nursing Home A',
        '11111111-1111-1111-1111-111111111111');

INSERT INTO residents (id, first_name, last_name, service_name, user_id)
VALUES ('bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb',
        'Emma',
        'Turner',
        'Nursing Home B',
        '22222222-2222-2222-2222-222222222222');

INSERT INTO residents (id, first_name, last_name, service_name, user_id)
VALUES ('cccccccc-cccc-cccc-cccc-cccccccccccc',
        'Liam',
        'Walker',
        'Nursing Home A',
        '11111111-1111-1111-1111-111111111111');



-- ============================
-- MEDICATIONS
-- ============================

-- Medications for Resident Michael Stone
INSERT INTO medications (id, name, form, strength, dose, resident_id)
VALUES ('11111111-1111-1111-1111-111111111111',
        'Paracetamol', 'Tablet', '500mg', '1 tablet twice daily',
        'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa');

INSERT INTO medications (id, name, form, strength, dose, resident_id)
VALUES ('22222222-2222-2222-2222-222222222222',
        'Ibuprofen', 'Capsule', '200mg', '1 capsule three times daily',
        'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa');


-- Medications for Resident Emma Turner
INSERT INTO medications (id, name, form, strength, dose, resident_id)
VALUES ('33333333-3333-3333-3333-333333333333',
        'Amlodipine', 'Tablet', '10mg', '1 tablet daily',
        'bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb');


-- Medications for Resident Liam Walker
INSERT INTO medications (id, name, form, strength, dose, resident_id)
VALUES ('44444444-4444-4444-4444-444444444444',
        'Metformin', 'Tablet', '500mg', '1 tablet twice daily',
        'cccccccc-cccc-cccc-cccc-cccccccccccc');
