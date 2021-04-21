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
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sharedexpenses`.`friend`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `sharedexpenses`.`friend` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `group_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idFriendsGroup_idx` (`group_id` ASC) VISIBLE,
  CONSTRAINT `idFriendsGroup`
    FOREIGN KEY (`group_id`)
    REFERENCES `sharedexpenses`.`friends_group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `sharedexpenses`.`payment`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `sharedexpenses`.`payment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `concept` VARCHAR(255) NULL,
  `amount` DECIMAL NULL,
  `date` DATETIME NULL,
  `friend_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `payer_idx` (`friend_id` ASC) VISIBLE,
  CONSTRAINT `payer`
    FOREIGN KEY (`friend_id`)
    REFERENCES `sharedexpenses`.`friend` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
