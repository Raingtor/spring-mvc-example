CREATE PROCEDURE IMPORT_PRODUCTS_FROM_CSV
(
    file IN VARCHAR(250)
)
AS $$
BEGIN
    EXECUTE format('COPY products FROM %L (FORMAT CSV, HEADER, DELIMITER ";")'
        , $1);
END;
$$
LANGUAGE plpgsql
;