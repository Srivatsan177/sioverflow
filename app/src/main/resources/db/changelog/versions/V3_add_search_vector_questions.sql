-- search vector
ALTER TABLE questions ADD COLUMN search_vector tsvector;
UPDATE questions SET search_vector = to_tsvector('english', title || ' ' || body);
CREATE INDEX idx_questions_search ON questions USING GIN (search_vector);

-- function to handle search_vector population
CREATE OR REPLACE FUNCTION populate_question_search_vector() RETURNS trigger AS $$
BEGIN
    NEW.search_vector :=
        to_tsvector('pg_catalog.english', coalesce(NEW.title,'') || ' ' || coalesce(NEW.body,''));
    RETURN NEW;
END
$$ LANGUAGE plpgsql;


-- Insert or Update trigger
CREATE TRIGGER questions_insert_or_update
BEFORE INSERT OR UPDATE ON questions
FOR EACH ROW
EXECUTE FUNCTION populate_question_search_vector();
