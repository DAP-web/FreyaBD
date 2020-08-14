-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema freya2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema freya2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `freya2` DEFAULT CHARACTER SET utf8 ;
USE `freya2` ;

-- -----------------------------------------------------
-- Table `freya2`.`restaurante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `freya2`.`restaurante` (
  `idRestaurante` INT NOT NULL,
  `nombre` VARCHAR(50) NOT NULL,
  `horaApertura` TIME NOT NULL,
  `horaCierre` TIME NOT NULL,
  `correoElectronico` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idRestaurante`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `freya2`.`direccionesRestaurante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `freya2`.`direccionesRestaurante` (
  `idDireccion` INT NOT NULL AUTO_INCREMENT,
  `localizacion` TEXT(100) NOT NULL,
  `codigoPostal` INT NOT NULL,
  `numeroTelefono` INT NOT NULL,
  PRIMARY KEY (`idDireccion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `freya2`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `freya2`.`cliente` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NOT NULL,
  `apellido` VARCHAR(30) NOT NULL,
  `numeroTelefono` INT NOT NULL,
  `correoElectronico` VARCHAR(45) NOT NULL,
  `contrasenia` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `freya2`.`platillos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `freya2`.`platillos` (
  `idplatillos` INT NOT NULL AUTO_INCREMENT,
  `nombrePlatillo` VARCHAR(50) NOT NULL,
  `precio` DECIMAL(5,2) NOT NULL,
  `detalle` TEXT NOT NULL,
  PRIMARY KEY (`idplatillos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `freya2`.`mesas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `freya2`.`mesas` (
  `idmesas` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(30) NOT NULL,
  `estado` VARCHAR(30) NOT NULL,
  `cantidad` INT NOT NULL,
  PRIMARY KEY (`idmesas`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `freya2`.`cliente_platillo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `freya2`.`cliente_platillo` (
  `idcliente_platillo` INT NOT NULL AUTO_INCREMENT,
  `idCliente` INT NOT NULL,
  `idPlato` INT NOT NULL,
  PRIMARY KEY (`idcliente_platillo`),
  INDEX `fk_idCliente_idx` (`idCliente` ASC) VISIBLE,
  INDEX `fk_idPlatillo_idx` (`idPlato` ASC) VISIBLE,
  CONSTRAINT `fk_idCliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `freya2`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_idPlatillo`
    FOREIGN KEY (`idPlato`)
    REFERENCES `freya2`.`platillos` (`idplatillos`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `freya2`.`cliente_mesa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `freya2`.`cliente_mesa` (
  `idcliente_mesa` INT NOT NULL AUTO_INCREMENT,
  `idCliente` INT NOT NULL,
  `idMesa` INT NOT NULL,
  `horaReserva` TIME NOT NULL,
  PRIMARY KEY (`idcliente_mesa`),
  INDEX `fk_idMesa_idx` (`idMesa` ASC) VISIBLE,
  INDEX `fk_idCliente_idx` (`idCliente` ASC) VISIBLE,
  CONSTRAINT `fk_idMesa`
    FOREIGN KEY (`idMesa`)
    REFERENCES `freya2`.`mesas` (`idmesas`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Cliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `freya2`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `freya2`.`factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `freya2`.`factura` (
  `idfactura` INT NOT NULL AUTO_INCREMENT,
  `idRestaurante` INT NOT NULL,
  `idDireccion` INT NOT NULL,
  `idCliente` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `hora` TIME NOT NULL,
  `IVA` DECIMAL(5,2) NOT NULL,
  `fastpass` TINYINT NOT NULL,
  `total` DECIMAL(10,2) NOT NULL,
  `idclienteplatillo` INT NOT NULL,
  PRIMARY KEY (`idfactura`),
  INDEX `fk_idCliente_idx` (`idCliente` ASC) VISIBLE,
  INDEX `fk_factura_restaurante1_idx` (`idRestaurante` ASC) VISIBLE,
  INDEX `fk_idDireccion_idx` (`idDireccion` ASC) VISIBLE,
  INDEX `fk_idclienteplatillo_idx` (`idclienteplatillo` ASC) VISIBLE,
  CONSTRAINT `fk_clienteID`
    FOREIGN KEY (`idCliente`)
    REFERENCES `freya2`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_idRestaurante`
    FOREIGN KEY (`idRestaurante`)
    REFERENCES `freya2`.`restaurante` (`idRestaurante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_idDireccion`
    FOREIGN KEY (`idDireccion`)
    REFERENCES `freya2`.`direccionesRestaurante` (`idDireccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_idclienteplatillo`
    FOREIGN KEY (`idclienteplatillo`)
    REFERENCES `freya2`.`cliente_platillo` (`idcliente_platillo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `freya2`.`reservas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `freya2`.`reservas` (
  `idreserva` int NOT NULL AUTO_INCREMENT,
  `idCliente` int NOT NULL,
  `idMesa` int NOT NULL,
  `horaReserva` time NOT NULL,
  PRIMARY KEY (`idreserva`),
  KEY `fk_idMesa_idx` (`idMesa`),
  KEY `fk_idCliente_idx` (`idCliente`),
  CONSTRAINT `fk_Cliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idcliente`) ON UPDATE CASCADE,
  CONSTRAINT `fk_idMesa` FOREIGN KEY (`idMesa`) REFERENCES `mesas` (`idmesas`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8


-- -----------------------------------------------------
-- Table `freya2`.`pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `freya2`.`pedidos` (
  `idcliente_platillo` int NOT NULL AUTO_INCREMENT,
  `idCliente` int NOT NULL,
  `idPlato` int NOT NULL,
  PRIMARY KEY (`idcliente_platillo`),
  KEY `fk_idCliente_idx` (`idCliente`),
  KEY `fk_idPlatillo_idx` (`idPlato`),
  CONSTRAINT `fk_idCliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idcliente`) ON UPDATE CASCADE,
  CONSTRAINT `fk_idPlatillo` FOREIGN KEY (`idPlato`) REFERENCES `platillos` (`idplatillos`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8

CREATE TABLE if not EXISTS `freya1`.`administrators` (
  `idadmin` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `lastName` VARCHAR(50) NOT NULL,
  `email` VARCHAR(70) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idadmin`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
