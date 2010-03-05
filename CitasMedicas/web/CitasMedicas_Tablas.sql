CREATE SCHEMA `cita_medica`;


CREATE TABLE  `cita_medica`.`especialidad` (
  `especialidadId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) NOT NULL,
  PRIMARY KEY (`especialidadId`)
);


CREATE TABLE  `cita_medica`.`persona` (
  `personaId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) NOT NULL,
  `apellidoPaterno` varchar(20) NOT NULL,
  `apellidoMaterno` varchar(20) NOT NULL,
  `nroDocumento` varchar(8) DEFAULT NULL,
  `fechaNacimiento` datetime NOT NULL,
  `peso` double DEFAULT NULL COMMENT 'Peso del paciente en kilogramos',
  `estatura` int(10) unsigned DEFAULT NULL COMMENT 'Estatura del paciente en centimetros',
  `nroColegiatura` varchar(5) DEFAULT NULL,
  `tipo` varchar(1) NOT NULL DEFAULT 'P' COMMENT 'Indica si es paciente (P) o medico (M)',
  PRIMARY KEY (`personaId`)
);


CREATE TABLE  `cita_medica`.`medico_especialidad` (
  `medicoId` int(10) unsigned NOT NULL,
  `especialidadId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`medicoId`,`especialidadId`),
  KEY `FK_Medico_Especialidad_2` (`especialidadId`),
  CONSTRAINT `FK_Medico_Especialidad_1` FOREIGN KEY (`medicoId`) REFERENCES `persona` (`personaId`),
  CONSTRAINT `FK_Medico_Especialidad_2` FOREIGN KEY (`especialidadId`) REFERENCES `especialidad` (`especialidadId`)
);


CREATE TABLE  `cita_medica`.`horario` (
  `horarioId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `medicoId` int(10) unsigned NOT NULL,
  `especialidadId` int(10) unsigned NOT NULL,
  `fechaInicio` datetime NOT NULL,
  `fechaFin` datetime NOT NULL,
  `citaId` int(10) unsigned,
  PRIMARY KEY (`horarioId`),
  KEY `FK_Horario_Especialidad` (`especialidadId`),
  KEY `FK_Horario_Medico` (`medicoId`),
  CONSTRAINT `FK_Horario_Especialidad` FOREIGN KEY (`especialidadId`) REFERENCES `especialidad` (`especialidadId`),
  CONSTRAINT `FK_Horario_Medico` FOREIGN KEY (`medicoId`) REFERENCES `persona` (`personaId`)
);


CREATE TABLE  `cita_medica`.`cita` (
  `citaId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pacienteId` int(10) unsigned NOT NULL,
  `horarioId` int(10) unsigned NOT NULL,
  `medicoId` int(10) unsigned NOT NULL COMMENT 'Medico que atiende la cita',
  `estado` varchar(13) NOT NULL DEFAULT 'RESERVADO',
  `sintoma` varchar(250) DEFAULT NULL,
  `diagnostico` varchar(45) DEFAULT NULL,
  `receta` varchar(250) DEFAULT NULL,
  `analisis` varchar(250) DEFAULT NULL,
  `fechaProximaCita` date DEFAULT NULL,
  `observaciones` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`citaId`),
  KEY `FK_cita_paciente` (`pacienteId`),
  KEY `FK_cita_medico` (`medicoId`),
  KEY `FK_cita_horario` (`horarioId`),
  CONSTRAINT `FK_cita_horario` FOREIGN KEY (`horarioId`) REFERENCES `horario` (`horarioId`),
  CONSTRAINT `FK_cita_medico` FOREIGN KEY (`medicoId`) REFERENCES `persona` (`personaId`),
  CONSTRAINT `FK_cita_paciente` FOREIGN KEY (`pacienteId`) REFERENCES `persona` (`personaId`)
);


CREATE TABLE  `cita_medica`.`usuario` (
  `usuarioId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `personaId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`usuarioId`),
  KEY `FK_Usuario_Persona` (`personaId`),
  CONSTRAINT `FK_Usuario_Persona` FOREIGN KEY (`personaId`) REFERENCES `persona` (`personaId`)
);


ALTER TABLE `cita_medica`.`horario` ADD CONSTRAINT `FK_Horario_Cita` FOREIGN KEY `FK_Horario_Cita` (`citaId`)
    REFERENCES `cita` (`citaId`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT;


CREATE VIEW `cita_medica`.`vw_cita_horario`
AS
select `c`.`citaId` AS `CITAID`,`c`.`estado` AS `ESTADO`,`c`.`diagnostico` AS `DIAGNOSTICO`,
	`c`.`pacienteId` AS `PACIENTEID`,`c`.`medicoId` AS `MEDICOATENCIONID`,`h`.`horarioId` AS `HORARIOID`,
	`h`.`fechaInicio` AS `FECHAINICIO`,`h`.`fechaFin` AS `FECHAFIN`,`h`.`especialidadId` AS `ESPECIALIDADID`,
	`h`.`medicoId` AS `MEDICOID`
from `cita` `c` join `horario` `h` on (`c`.`horarioId` = `h`.`horarioId`);