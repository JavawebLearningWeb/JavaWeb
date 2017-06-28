-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: learningweb
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrator`
--

drop database if exists learningweb;
create database learningweb;
use learningweb;

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrator` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `username` varchar(50) NOT NULL COMMENT '账号',
  `password` varchar(50) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chapter`
--

DROP TABLE IF EXISTS `chapter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chapter` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(50) NOT NULL COMMENT '章节名称',
  `courseid` varchar(50) NOT NULL COMMENT '课程id',
  `number` varchar(50) NOT NULL COMMENT '章节编号',
  PRIMARY KEY (`id`),
  KEY `FK_db_数据结构chapter_db_course` (`courseid`),
  CONSTRAINT `FK_db_数据结构chapter_db_course` FOREIGN KEY (`courseid`) REFERENCES `course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程章节表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chapter`
--

LOCK TABLES `chapter` WRITE;
/*!40000 ALTER TABLE `chapter` DISABLE KEYS */;
/*!40000 ALTER TABLE `chapter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(50) NOT NULL COMMENT '课程名',
  `teacherid` varchar(50) NOT NULL COMMENT '老师id',
  PRIMARY KEY (`id`),
  KEY `FK_db_course_db_teacher` (`teacherid`),
  CONSTRAINT `FK_db_course_db_teacher` FOREIGN KEY (`teacherid`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data`
--

DROP TABLE IF EXISTS `data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `address` varchar(50) NOT NULL COMMENT '地址',
  `chapterid` varchar(50) NOT NULL COMMENT '章节id',
  `kind` varchar(50) NOT NULL COMMENT '资料类型',
  PRIMARY KEY (`id`),
  KEY `FK_db_数据结构data_db_数据结构chapter` (`chapterid`),
  CONSTRAINT `FK_db_数据结构data_db_数据结构chapter` FOREIGN KEY (`chapterid`) REFERENCES `chapter` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程学习资料表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data`
--

LOCK TABLES `data` WRITE;
/*!40000 ALTER TABLE `data` DISABLE KEYS */;
/*!40000 ALTER TABLE `data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `chapterid` varchar(50) NOT NULL COMMENT '章节id',
  `answer` varchar(50) NOT NULL COMMENT '答案',
  `address` varchar(50) NOT NULL COMMENT '地址',
  PRIMARY KEY (`id`),
  KEY `FK_db_数据结构试题_db_数据结构chapter` (`chapterid`),
  CONSTRAINT `FK_db_数据结构试题_db_数据结构chapter` FOREIGN KEY (`chapterid`) REFERENCES `chapter` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程试题表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `progress`
--

DROP TABLE IF EXISTS `progress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `progress` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `progress`
--

LOCK TABLES `progress` WRITE;
/*!40000 ALTER TABLE `progress` DISABLE KEYS */;
/*!40000 ALTER TABLE `progress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `username` varchar(50) NOT NULL COMMENT '工号',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `gender` varchar(50) NOT NULL COMMENT '性别',
  `status` varchar(50) NOT NULL COMMENT '学历',
  `email` varchar(50) NOT NULL COMMENT '邮箱',
  `major` varchar(50) NOT NULL COMMENT '专业',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='老师表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-24 15:50:24
