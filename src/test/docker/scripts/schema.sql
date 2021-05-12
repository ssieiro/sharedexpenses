SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema sharedexpenses
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sharedexpenses
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sharedexpenses` DEFAULT CHARACTER SET utf8 ;
USE `sharedexpenses` ;

-- -----------------------------------------------------
-- Table `sharedexpenses`.`friends_group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sharedexpenses`.`friends_group` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `sharedexpenses`.`friend`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `sharedexpenses`.`friend` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `group_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idFriendsGroup_idx` (`group_id`),
    CONSTRAINT `group_id` FOREIGN KEY (`group_id`) REFERENCES `friends_group` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `sharedexpenses`.`payment`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `sharedexpenses`.`payment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `concept` varchar(255) DEFAULT NULL,
    `amount` decimal(10,0) DEFAULT NULL,
    `date` datetime DEFAULT NULL,
    `friend_id` bigint DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `friend_id_idx` (`friend_id`),
    CONSTRAINT `friend_id` FOREIGN KEY (`friend_id`) REFERENCES `friend` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

