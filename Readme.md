# Trabalho Java Web Agenda

### Create database

```
create database schedule;
```
```
use schedule;
```

### Create tables

```
CREATE TABLE `schedule`.`task` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NULL,
  `descricao` VARCHAR(100) NULL,
  `data_criacao` DATE NULL,
  `data_conclusao` DATE NULL,
  `status` VARCHAR(45) NULL,
  `id_user` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE task (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100),
    descricao VARCHAR(200),
    data_criacao DATE,
    data_conclusao DATE,
    status VARCHAR(20),
    id_user INT
);

```

### Query tables

```
select * from user;

select * from task order by id desc;		
```