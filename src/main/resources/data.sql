INSERT INTO SHAPE (ID, POSX, POSY, COLOR, SHAPE_TYPE) VALUES (1, 0, 0, '#0088ff', 'square')
INSERT INTO SQUARE (ID, WIDTH) VALUES (1, 50)
INSERT INTO SHAPE (ID, POSX, POSY, COLOR, SHAPE_TYPE) VALUES (2, 600, 0, '#000000', 'rectangle')
INSERT INTO RECTANGLE (ID, WIDTH, LENGTH) VALUES (2, 100, 10)
INSERT INTO SHAPE (ID, POSX, POSY, COLOR, SHAPE_TYPE) VALUES (3, 200, 50, '#FF0000', 'circle')
INSERT INTO CIRCLE (ID, RAYON) VALUES (3, 15)
INSERT INTO SHAPE (ID, POSX, POSY, COLOR, SHAPE_TYPE) VALUES (4, 0, 0, '#FF0000', 'triangle')
INSERT INTO TRIANGLE (ID, A_POSX, B_POSX, C_POSX, A_POSY, B_POSY, C_POSY) VALUES (4,/* x : */ 300, 400, 350,/* y : */ 0, 0, 70)

INSERT INTO USERS (ID, USERNAME, IS_ADMIN) VALUES (1, 'daniel', true)
INSERT INTO USERS (ID, USERNAME, IS_ADMIN) VALUES (2, 'admin', true)
INSERT INTO USERS (ID, USERNAME, IS_ADMIN) VALUES (3, 'lambda', false )