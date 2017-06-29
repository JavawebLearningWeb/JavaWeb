/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE IF NOT EXISTS `learningweb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `learningweb`;

CREATE TABLE IF NOT EXISTS `addcourse` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `teacherid` varchar(50) NOT NULL COMMENT '教师id',
  `result` varchar(50) DEFAULT NULL COMMENT '审核结果',
  `course` varchar(50) NOT NULL COMMENT '课程名称',
  PRIMARY KEY (`id`),
  KEY `FK_addcourse_teacher` (`teacherid`),
  CONSTRAINT `FK_addcourse_teacher` FOREIGN KEY (`teacherid`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='申请加课表';

/*!40000 ALTER TABLE `addcourse` DISABLE KEYS */;
/*!40000 ALTER TABLE `addcourse` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `administrator` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `username` varchar(50) NOT NULL COMMENT '账号',
  `password` varchar(50) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员表';

/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
REPLACE INTO `administrator` (`id`, `username`, `password`) VALUES
	('1', '余豪', '12345677'),
	('402880845ce41d5c015ce41d60b60000', '余豪', '12345677'),
	('402880845ce41d5c015ce41d60e10001', '余豪', '12345677'),
	('402880845ce41d5c015ce41d60e70002', '余豪', '12345677'),
	('402880845ce41d5c015ce41d60ef0003', '余豪', '12345677'),
	('402880845ce41d5c015ce41d60f90004', '余豪', '12345677'),
	('402880845ce41d5c015ce41d61010005', '余豪', '12345677'),
	('402880845ce41d5c015ce41d61080006', '余豪', '12345677'),
	('402880845ce41d5c015ce41d610f0007', '余豪', '12345677'),
	('402880845ce41d5c015ce41d611a0008', '余豪', '12345677'),
	('402880845ce41d5c015ce41d61220009', '余豪', '12345677'),
	('ff8080815ce2f842015ce2f845820000', 'lijian', '123456'),
	('ff8080815ce2f842015ce2f84da50001', 'lijian', '123456');
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `chapter` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(50) NOT NULL COMMENT '章节名称',
  `courseid` varchar(50) NOT NULL COMMENT '课程id',
  `number` varchar(50) NOT NULL COMMENT '章节编号',
  PRIMARY KEY (`id`),
  KEY `FK_db_数据结构chapter_db_course` (`courseid`),
  CONSTRAINT `FK_db_数据结构chapter_db_course` FOREIGN KEY (`courseid`) REFERENCES `course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程章节表';

/*!40000 ALTER TABLE `chapter` DISABLE KEYS */;
REPLACE INTO `chapter` (`id`, `name`, `courseid`, `number`) VALUES
	('1', '线性表', '1', '123456');
/*!40000 ALTER TABLE `chapter` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `course` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(50) NOT NULL COMMENT '课程名',
  `teacherid` varchar(50) NOT NULL COMMENT '老师id',
  `picture` varchar(50) DEFAULT NULL COMMENT '头像',
  `introduction` varchar(50) DEFAULT '无' COMMENT '简介',
  PRIMARY KEY (`id`),
  KEY `FK_db_course_db_teacher` (`teacherid`),
  CONSTRAINT `FK_db_course_db_teacher` FOREIGN KEY (`teacherid`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程表';

/*!40000 ALTER TABLE `course` DISABLE KEYS */;
REPLACE INTO `course` (`id`, `name`, `teacherid`, `picture`, `introduction`) VALUES
	('1', '数据结构', '1', NULL, NULL),
	('2', 'C语言', '1', NULL, NULL),
	('3', '计算机网络', '2', NULL, NULL);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `data` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `address` varchar(50) NOT NULL COMMENT '地址',
  `chapterid` varchar(50) NOT NULL COMMENT '章节id',
  `kind` varchar(50) NOT NULL COMMENT '资料类型',
  PRIMARY KEY (`id`),
  KEY `FK_db_数据结构data_db_数据结构chapter` (`chapterid`),
  CONSTRAINT `FK_db_数据结构data_db_数据结构chapter` FOREIGN KEY (`chapterid`) REFERENCES `chapter` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程学习资料表';

/*!40000 ALTER TABLE `data` DISABLE KEYS */;
/*!40000 ALTER TABLE `data` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `exam` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `chapterid` varchar(50) NOT NULL COMMENT '章节id',
  `answer` varchar(50) NOT NULL COMMENT '答案',
  `address` varchar(50) NOT NULL COMMENT '地址',
  PRIMARY KEY (`id`),
  KEY `FK_db_数据结构试题_db_数据结构chapter` (`chapterid`),
  CONSTRAINT `FK_db_数据结构试题_db_数据结构chapter` FOREIGN KEY (`chapterid`) REFERENCES `chapter` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程试题表';

/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `progress` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `studentid` varchar(50) NOT NULL COMMENT '学生id',
  `courseid` varchar(50) NOT NULL COMMENT '课程id',
  `chapterid` varchar(50) NOT NULL COMMENT '章节id',
  `examscore` varchar(50) NOT NULL COMMENT '测试成绩',
  PRIMARY KEY (`id`),
  KEY `FK_db_rateofprogress_db_student` (`studentid`),
  KEY `FK_db_rateofprogress_db_course` (`courseid`),
  KEY `FK_db_rateofprogress_db_数据结构chapter` (`chapterid`),
  CONSTRAINT `FK_db_rateofprogress_db_course` FOREIGN KEY (`courseid`) REFERENCES `course` (`id`),
  CONSTRAINT `FK_db_rateofprogress_db_student` FOREIGN KEY (`studentid`) REFERENCES `student` (`id`),
  CONSTRAINT `FK_db_rateofprogress_db_数据结构chapter` FOREIGN KEY (`chapterid`) REFERENCES `chapter` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学习进度表';

/*!40000 ALTER TABLE `progress` DISABLE KEYS */;
REPLACE INTO `progress` (`id`, `studentid`, `courseid`, `chapterid`, `examscore`) VALUES
	('1', '1', '2', '1', '2'),
	('2', '2', '3', '1', '3'),
	('3', '1', '2', '1', '50');
/*!40000 ALTER TABLE `progress` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `student` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `name` varchar(50) NOT NULL COMMENT '昵称',
  `birthday` date DEFAULT NULL COMMENT '出生年月',
  `gendar` varchar(50) NOT NULL COMMENT '性别',
  `status` varchar(50) NOT NULL COMMENT '学历',
  `grade` varchar(50) NOT NULL COMMENT '年级',
  `email` varchar(50) NOT NULL COMMENT '邮箱',
  `major` varchar(50) NOT NULL COMMENT '专业',
  `picture` varchar(50) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生表';

/*!40000 ALTER TABLE `student` DISABLE KEYS */;
REPLACE INTO `student` (`id`, `username`, `password`, `name`, `birthday`, `gendar`, `status`, `grade`, `email`, `major`, `picture`) VALUES
	('1', 'root', 'root', '唐湘龙', '2017-06-24', '男', '本科', '4', '7933', '计算机', ''),
	('2', '2', '2', '余豪', '2017-06-27', '1', '1', '1', '1', '1', '2'),
	('402855815cf2443d015cf24505fe0000', '余豪', '123', 'tomcat', '2017-06-09', '男', '本科', '大三', '1668926294@qq.com', '大学', 'stuimg/女孩2.jpg');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `teacher` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `username` varchar(50) NOT NULL COMMENT '工号',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `gender` varchar(50) NOT NULL COMMENT '性别',
  `status` varchar(50) NOT NULL COMMENT '学历',
  `email` varchar(50) NOT NULL COMMENT '邮箱',
  `major` varchar(50) NOT NULL COMMENT '专业',
  `picture` varchar(50) DEFAULT NULL COMMENT '头像',
  `introduction` varchar(50) DEFAULT '这个人很懒，什么也没有留下' COMMENT '简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='老师表';

/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
REPLACE INTO `teacher` (`id`, `username`, `name`, `password`, `gender`, `status`, `email`, `major`, `picture`, `introduction`) VALUES
	('1', 'root', 'maybe', 'root', '双性人', '大学', '123', '123', NULL, '这个人很懒，什么也没有留下'),
	('2', 'root', '曹春平', 'root', '1', '1', '1', '1', NULL, '这个人很懒，什么也没有留下');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
