CREATE OR REPLACE FUNCTION array_some_overlap(text[], text[])
RETURNS boolean AS $$
SELECT $1 && $2;
$$ LANGUAGE SQL;