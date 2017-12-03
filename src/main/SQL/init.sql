/!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT /;
/!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS /;
/!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION /;
/!40101 SET NAMES utf8 /;

/*基础用户信息表*/
DROP TABLE IF EXISTS `sys`.`base_user_userInfo`;
CREATE TABLE `sys`.`base_user_userInfo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `group_id` INT NULL DEFAULT 组id,
  `userName` VARCHAR(45) NULL   comment '用户名',
  `passWord` VARCHAR(45) NULL  comment '密码',
  `mobile` VARCHAR(25) NULL   comment '手机',
  `email` VARCHAR(45) NULL  comment '邮箱',
  `crete_time` DATETIME NULL comment '创建时间',
  `crate_userId` INT NULL  comment '创建人ID',
  `update_time` DATETIME NULL  comment '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)
) DEFAULT CHARSET=utf8;

