CREATE TABLE sub_todo_entity
(
    id        UUID NOT NULL,
    name      VARCHAR(255),
    parent_id UUID,
    CONSTRAINT pk_subtodoentity PRIMARY KEY (id)
);

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

CREATE TABLE todo_entity_sub_todos
(
    todo_entity_id UUID NOT NULL,
    sub_todos_id   UUID NOT NULL
);

ALTER TABLE todo_entity_sub_todos
    ADD CONSTRAINT uc_todo_entity_sub_todos_subtodos UNIQUE (sub_todos_id);

ALTER TABLE sub_todo_entity
    ADD CONSTRAINT FK_SUBTODOENTITY_ON_PARENT FOREIGN KEY (parent_id) REFERENCES todo_entity (id);

ALTER TABLE todo_entity_sub_todos
    ADD CONSTRAINT fk_todentsubtod_on_sub_todo_entity FOREIGN KEY (sub_todos_id) REFERENCES sub_todo_entity (id);

ALTER TABLE todo_entity_sub_todos
    ADD CONSTRAINT fk_todentsubtod_on_todo_entity FOREIGN KEY (todo_entity_id) REFERENCES todo_entity (id);