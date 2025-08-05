CREATE TABLE the_entity
(
    id             UUID       NOT NULL,
    text_attribute VARCHAR(8) NOT NULL,
    CONSTRAINT pk_theentity PRIMARY KEY (id)
);

CREATE TABLE todo_entity
(
    id   UUID NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_todoentity PRIMARY KEY (id)
);

CREATE TABLE todo_entity_sub_to_dos
(
    todo_entity_id UUID NOT NULL,
    sub_to_dos_id  UUID NOT NULL
);

ALTER TABLE todo_entity_sub_to_dos
    ADD CONSTRAINT uc_todo_entity_sub_to_dos_subtodos UNIQUE (sub_to_dos_id);

ALTER TABLE todo_entity_sub_to_dos
    ADD CONSTRAINT fk_todentsubtodos_on_subtodos FOREIGN KEY (sub_to_dos_id) REFERENCES todo_entity (id);

ALTER TABLE todo_entity_sub_to_dos
    ADD CONSTRAINT fk_todentsubtodos_on_todoentity FOREIGN KEY (todo_entity_id) REFERENCES todo_entity (id);