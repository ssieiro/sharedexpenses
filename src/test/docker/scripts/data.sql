INSERT INTO `sharedexpenses`.`friends_group` (`name`) VALUES ('Prueba1');
INSERT INTO `sharedexpenses`.`friends_group` (`name`) VALUES ('Prueba2');
INSERT INTO `sharedexpenses`.`friend` (`name`, `group_id`) VALUES ('Sonia', '1');
INSERT INTO `sharedexpenses`.`friend` (`name`, `group_id`) VALUES ('Paco', '1');
INSERT INTO `sharedexpenses`.`friend` (`name`, `group_id`) VALUES ('Sonia', '2');
INSERT INTO `sharedexpenses`.`friend` (`name`, `group_id`) VALUES ('Paco', '2');
INSERT INTO `sharedexpenses`.`friend` (`name`, `group_id`) VALUES ('Alba', '2');
INSERT INTO `sharedexpenses`.`payment` (`concept`, `amount`, `date`, `friend_id`) VALUES ('pago prueba 1', '20', '2021-04-21T16:34:30.841789', '1');
INSERT INTO `sharedexpenses`.`payment` (`concept`, `amount`, `date`, `friend_id`) VALUES ('pago prueba 2', '30', '2021-04-21T16:34:30.841789', '3');
