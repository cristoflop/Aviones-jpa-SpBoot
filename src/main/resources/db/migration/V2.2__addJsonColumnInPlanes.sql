SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

ALTER TABLE `planes` ADD `data` JSON DEFAULT NULL;

UPDATE `planes`
set `data` = (
    select JSON_OBJECT('revisions', JSON_ARRAYAGG(JSON_OBJECT('id', `r`.`id`,
                                                              'description', `r`.`description`,
                                                              'end_date', `r`.`end_date`,
                                                              'init_date', `r`.`init_date`,
                                                              'revision_type', `r`.`revision_type`,
                                                              'spent_hours', `r`.`spent_hours`,
                                                              'airport_iata', `r`.`airport_iata`,
                                                              'mechanic_in_charge_id', `r`.`mechanic_in_charge_id`,
                                                              'plane_plate', `r`.`plane_plate`)))
    from `revisions` `r`
    where `r`.`plane_plate` = `plate`);

COMMIT;