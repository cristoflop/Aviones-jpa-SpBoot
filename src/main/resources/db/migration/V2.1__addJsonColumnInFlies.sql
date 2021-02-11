SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

ALTER TABLE `flies` ADD `data` JSON DEFAULT NULL;

UPDATE `flies`
set `data` = (
    select JSON_OBJECT('crewmate_ids', JSON_ARRAYAGG(`fc`.`crewmates_id`))
    from `flies_crewmates` `fc`
    where `fc`.`fly_id` = `id`);

COMMIT;