-- Schema freya1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `freya1` DEFAULT CHARACTER SET utf8 ;
USE `freya1` ;

-- -----------------------------------------------------
-- Table `freya1`.`restaurante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `freya1`.`restaurante` (
  `idRestaurante` INT NOT NULL,
  `nombre` VARCHAR(50) NOT NULL,
  `horaApertura` TIME NOT NULL,
  `horaCierre` TIME NOT NULL,
  `correoElectronico` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idRestaurante`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `freya1`.`direccionesRestaurante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `freya1`.`direccionesRestaurante` (
  `idDireccion` INT NOT NULL AUTO_INCREMENT,
  `localizacion` TEXT(100) NOT NULL,
  `codigoPostal` INT NOT NULL,
  `numeroTelefono` INT NOT NULL,
  PRIMARY KEY (`idDireccion`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `freya1`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `freya1`.`cliente` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NOT NULL,
  `apellido` VARCHAR(30) NOT NULL,
  `numeroTelefono` INT NOT NULL,
  `correoElectronico` VARCHAR(45) NOT NULL,
  `contrasenia` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcliente`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `freya1`.`platillos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `freya1`.`platillos` (
  `idplatillos` INT NOT NULL AUTO_INCREMENT,
  `nombrePlatillo` VARCHAR(50) NOT NULL,
  `precio` DECIMAL(5,2) NOT NULL,
  `detalle` TEXT NOT NULL,
  PRIMARY KEY (`idplatillos`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `freya1`.`mesas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `freya1`.`mesas` (
  `idmesas` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(30) NOT NULL,
  `estado` VARCHAR(30) NOT NULL,
  `cantidad` INT NOT NULL,
  PRIMARY KEY (`idmesas`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `freya1`.`cliente_platillo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `freya1`.`cliente_platillo` (
  `idcliente_platillo` INT NOT NULL AUTO_INCREMENT,
  `idCliente` INT NOT NULL,
  `idPlato` INT NOT NULL,
  PRIMARY KEY (`idcliente_platillo`),
  INDEX `fk_idCliente_idx` (`idCliente` ASC) VISIBLE,
  INDEX `fk_idPlatillo_idx` (`idPlato` ASC) VISIBLE,
  CONSTRAINT `fk_idCliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `freya1`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_idPlatillo`
    FOREIGN KEY (`idPlato`)
    REFERENCES `freya1`.`platillos` (`idplatillos`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `freya1`.`cliente_mesa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `freya1`.`cliente_mesa` (
  `idcliente_mesa` INT NOT NULL AUTO_INCREMENT,
  `idCliente` INT NOT NULL,
  `idMesa` INT NOT NULL,
  `horaReserva` TIME NOT NULL,
  PRIMARY KEY (`idcliente_mesa`),
  INDEX `fk_idMesa_idx` (`idMesa` ASC) VISIBLE,
  INDEX `fk_idCliente_idx` (`idCliente` ASC) VISIBLE,
  CONSTRAINT `fk_idMesa`
    FOREIGN KEY (`idMesa`)
    REFERENCES `freya1`.`mesas` (`idmesas`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Cliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `freya1`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `freya1`.`factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `freya1`.`factura` (
  `idfactura` INT NOT NULL AUTO_INCREMENT,
  `idRestaurante` INT NOT NULL,
  `idDireccion` INT NOT NULL,
  `idCliente` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `hora` TIME NOT NULL,
  `IVA` DECIMAL(5,2) NOT NULL,
  `fastpass` TINYINT NOT NULL,
  `total` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`idfactura`),
  INDEX `fk_idCliente_idx` (`idCliente` ASC) VISIBLE,
  INDEX `fk_factura_restaurante1_idx` (`idRestaurante` ASC) VISIBLE,
  INDEX `fk_idDireccion_idx` (`idDireccion` ASC) VISIBLE,
  CONSTRAINT `fk_clienteID`
    FOREIGN KEY (`idCliente`)
    REFERENCES `freya1`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_idRestaurante`
    FOREIGN KEY (`idRestaurante`)
    REFERENCES `freya1`.`restaurante` (`idRestaurante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_idDireccion`
    FOREIGN KEY (`idDireccion`)
    REFERENCES `freya1`.`direccionesRestaurante` (`idDireccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `freya1`.`detalle_factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `freya1`.`detalle_factura` (
  `iddetalle_factura` INT NOT NULL AUTO_INCREMENT,
  `idFactura` INT NOT NULL,
  `idClientePlatillo` INT NOT NULL,
  PRIMARY KEY (`iddetalle_factura`),
  INDEX `fk_detalle_factura_cliente_platillo1_idx` (`idClientePlatillo` ASC) VISIBLE,
  INDEX `fk_idFactura_idx` (`idFactura` ASC) VISIBLE,
  CONSTRAINT `fk_idClientePlatillo`
    FOREIGN KEY (`idClientePlatillo`)
    REFERENCES `freya1`.`cliente_platillo` (`idcliente_platillo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_idFactura`
    FOREIGN KEY (`idFactura`)
    REFERENCES `freya1`.`factura` (`idfactura`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

/* CODIGO PARA INSERTAR INFORMACION PREDETERMINADA*/
/*CLIENTE*/
INSERT INTO `freya1`.`cliente` (`idcliente`, `nombre`, `apellido`, `numeroTelefono`, `correoElectronico`, `contrasenia`) 
                        VALUES ('1', 'Diego', 'Portillo', '21645321', 'converse@jhs.com', 'rocknroll');

INSERT INTO `freya1`.`cliente` (`idcliente`, `nombre`, `apellido`, `numeroTelefono`, `correoElectronico`, `contrasenia`) 
                        VALUES ('2', 'Angela', 'Ruiz', '16497520', 'south@africa.com', 'cuscatlan');

INSERT INTO `freya1`.`cliente` (`idcliente`, `nombre`, `apellido`, `numeroTelefono`, `correoElectronico`, `contrasenia`) 
                        VALUES ('3', 'Marcela', 'Mata', '41265123', 'america@central.com', 'algebra');

INSERT INTO `freya1`.`cliente` (`idcliente`, `nombre`, `apellido`, `numeroTelefono`, `correoElectronico`, `contrasenia`)
                        VALUES ('4', 'Victoria', 'Zepeda', '71489560', 'europa@este.com', 'baloncesto');

INSERT INTO `freya1`.`cliente` (`idcliente`, `nombre`, `apellido`, `numeroTelefono`, `correoElectronico`, `contrasenia`) 
                        VALUES ('5', 'Aaron', 'Ramos', '72546180', 'arabia@saudita.com', 'porsche');

/*RESTAURANTE*/

INSERT INTO `freya1`.`restaurante` (`idRestaurante`, `nombre`, `horaApertura`, `horaCierre`, `correoElectronico`) 
                            VALUES ('1564', 'Big Joe', '9:00', '19:00', 'bigjoe@littlejoe.com');

/*MESAS*/
INSERT INTO `freya1`.`mesas` (`idmesas`, `tipo`, `estado`, `cantidad`) 
                      VALUES ('1', 'FastPass', 'Disponible', '10');
INSERT INTO `freya1`.`mesas` (`idmesas`, `tipo`, `estado`, `cantidad`) 
                      VALUES ('2', 'Normal', 'Ocupada', '5');
INSERT INTO `freya1`.`mesas` (`idmesas`, `tipo`, `estado`, `cantidad`) 
                      VALUES ('3', 'FastPass', 'Ocupado', '10');
INSERT INTO `freya1`.`mesas` (`idmesas`, `tipo`, `estado`, `cantidad`) 
                      VALUES ('4', 'FastPass', 'Ocupado', '8');
INSERT INTO `freya1`.`mesas` (`idmesas`, `tipo`, `estado`, `cantidad`) 
                      VALUES ('5', 'Normal', 'Disponible', '5');

/*PLATILLOS*/
INSERT INTO `freya1`.`platillos` (`idplatillos`, `nombrePlatillo`, `precio`, `detalle`) 
                          VALUES ('1', 'SpecialJoe', '38.50', 'Esta receta es especial del pais de origen de Joe');
INSERT INTO `freya1`.`platillos` (`idplatillos`, `nombrePlatillo`, `precio`, `detalle`) 
                          VALUES ('2', 'BigMammaJoe', '40', 'Receta especial de la mama de Joe');

/*CLIENTE_MESA*/
INSERT INTO `freya1`.`cliente_mesa` (`idcliente_mesa`, `idCliente`, `idMesa`, `horaReserva`)
                             VALUES ('1', '2', '3', '15:00');
INSERT INTO `freya1`.`cliente_mesa` (`idcliente_mesa`, `idCliente`, `idMesa`, `horaReserva`) 
                             VALUES ('2', '1', '5', '16:00');
INSERT INTO `freya1`.`cliente_mesa` (`idcliente_mesa`, `idCliente`, `idMesa`, `horaReserva`)
                             VALUES ('3', '3', '5', '8:00');

/*CLIENTE_PLATILLO*/
INSERT INTO `freya1`.`cliente_platillo` (`idcliente_platillo`, `idCliente`, `idPlato`)
                                 VALUES ('1', '2', '1');
INSERT INTO `freya1`.`cliente_platillo` (`idcliente_platillo`, `idCliente`, `idPlato`) 
                                 VALUES ('2', '3', '2');
INSERT INTO `freya1`.`cliente_platillo` (`idcliente_platillo`, `idCliente`, `idPlato`)
                                 VALUES ('3', '5', '2');
INSERT INTO `freya1`.`cliente_platillo` (`idcliente_platillo`, `idCliente`, `idPlato`)
                                 VALUES ('4', '1', '1');

/*DIRECCIONES_RESTAURANTE*/
INSERT INTO `freya1`.`direccionesrestaurante` (`idDireccion`, `localizacion`, `codigoPostal`, `numeroTelefono`)
                                       VALUES ('1', 'Calle Roosevelt', '10512', '20203636');
INSERT INTO `freya1`.`direccionesrestaurante` (`idDireccion`, `localizacion`, `codigoPostal`, `numeroTelefono`)
                                       VALUES ('2', 'Boulevard Constitucion', '154895', '21215252');
INSERT INTO `freya1`.`direccionesrestaurante` (`idDireccion`, `localizacion`, `codigoPostal`, `numeroTelefono`)
                                       VALUES ('3', 'Brooklyn', '156493', '20202020');

/*FACTURA*/
INSERT INTO `freya1`.`factura` (`idfactura`, `idRestaurante`, `idDireccion`, `idCliente`, `fecha`, `hora`, `IVA`, `fastpass`, `total`)
                        VALUES ('1', '1564', '2', '2', '2020-12-30', '15:00', '0.13', '1', '200');
INSERT INTO `freya1`.`factura` (`idfactura`, `idRestaurante`, `idDireccion`, `idCliente`, `fecha`, `hora`, `IVA`, `fastpass`, `total`) VALUES ('2', '1564', '3', '1', '2020-3-18', '8:00', '0.13', '0', '30');

/*DETALLE_FACTURA*/
INSERT INTO `freya1`.`detalle_factura` (`iddetalle_factura`, `idFactura`, `idClientePlatillo`)
                                VALUES ('1', '1', '2');
INSERT INTO `freya1`.`detalle_factura` (`iddetalle_factura`, `idFactura`, `idClientePlatillo`)
                                VALUES ('2', '2', '3');

