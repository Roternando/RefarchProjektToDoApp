CREATE TABLE sub_todo_entity
(
    id                    UUID NOT NULL,
    parent_todo_entity_id UUID,
    name                  VARCHAR(255),
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

ALTER TABLE sub_todo_entity
    ADD CONSTRAINT FK_SUBTODOENTITY_ON_PARENTTODOENTITY FOREIGN KEY (parent_todo_entity_id) REFERENCES todo_entity (id);