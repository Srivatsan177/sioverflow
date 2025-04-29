CREATE TABLE questions (
    id UUID NOT NULL,
    title VARCHAR(255) NOT NULL,
    tags TEXT[],
    body TEXT NOT NULL,
    author_id UUID NOT NULL,
    CONSTRAINT questions_pkey PRIMARY KEY (id),
    FOREIGN KEY (author_id) REFERENCES users(id)
);