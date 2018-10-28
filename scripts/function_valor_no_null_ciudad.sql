DELIMITER $$

DROP FUNCTION IF EXISTS `juegosolimpicos`.`valor_no_null` $$
CREATE FUNCTION `juegosolimpicos`.`valor_no_null` (idCiudad INT) RETURNS INT
BEGIN
  DECLARE valor INT;
  SELECT valor_ciudad INTO valor FROM ciudad WHERE id_ciudad = idCiudad;
  IF valor IS NULL THEN
    SELECT valor_pais INTO valor FROM pais p, ciudad c WHERE c.id_ciudad = idCiudad AND p.id_pais = c.id_pais;
  END IF;
  RETURN valor;
END $$

DELIMITER ;