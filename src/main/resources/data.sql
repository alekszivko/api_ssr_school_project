---Just some reservations to use for list view
INSERT INTO reservations (completed, id, last_modified, reserved_at, reserved_by,
                          connection_no, reservation_description, reservation_id)
VALUES (false, 1, '2024-03-13 15:38:56.777071', '2024-03-13 15:38:56.777071', null, null,
        'Some relevant descriptions around the reservation', 'SyzPKNV7HK');
INSERT INTO public.reservations (completed, id, last_modified, reserved_at, reserved_by,
                                 connection_no, reservation_description, reservation_id)
VALUES (true, 2, '2024-03-13 15:38:56.777071', '2024-03-13 15:38:56.777178', null, null,
        'Another description', 'D82jbHeJV5');
INSERT INTO public.reservations (completed, id, last_modified, reserved_at, reserved_by,
                                 connection_no, reservation_description, reservation_id)
VALUES (true, 3, '2024-03-13 15:38:56.777071', '2024-03-13 15:38:56.777178', null, null,
        '', 'TJuNov6Wf5');
INSERT INTO public.reservations (completed, id, last_modified, reserved_at, reserved_by,
                                 connection_no, reservation_description, reservation_id)
VALUES (true, 4, '2024-03-13 15:38:56.777071', '2024-03-13 15:38:56.777178', null, null,
        'Customer has ........', 'xvrkqB2AKj');

