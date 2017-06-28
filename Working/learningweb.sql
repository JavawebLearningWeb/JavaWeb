/*
Navicat MySQL Data Transfer

Source Server         : rootconnection
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : learningweb

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-06-28 22:01:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for addcourse
-- ----------------------------
DROP TABLE IF EXISTS `addcourse`;
CREATE TABLE `addcourse` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `teacherid` varchar(50) NOT NULL COMMENT '教师id',
  `result` varchar(50) DEFAULT NULL COMMENT '审核结果',
  `course` varchar(50) NOT NULL COMMENT '课程名称',
  PRIMARY KEY (`id`),
  KEY `FK_addcourse_teacher` (`teacherid`),
  CONSTRAINT `FK_addcourse_teacher` FOREIGN KEY (`teacherid`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='申请加课表';

-- ----------------------------
-- Records of addcourse
-- ----------------------------

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `username` varchar(50) NOT NULL COMMENT '账号',
  `password` varchar(50) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('1', '余豪', '12345677');
INSERT INTO `administrator` VALUES ('402880845ce41d5c015ce41d60b60000', '余豪', '12345677');
INSERT INTO `administrator` VALUES ('402880845ce41d5c015ce41d60e10001', '余豪', '12345677');
INSERT INTO `administrator` VALUES ('402880845ce41d5c015ce41d60e70002', '余豪', '12345677');
INSERT INTO `administrator` VALUES ('402880845ce41d5c015ce41d60ef0003', '余豪', '12345677');
INSERT INTO `administrator` VALUES ('402880845ce41d5c015ce41d60f90004', '余豪', '12345677');
INSERT INTO `administrator` VALUES ('402880845ce41d5c015ce41d61010005', '余豪', '12345677');
INSERT INTO `administrator` VALUES ('402880845ce41d5c015ce41d61080006', '余豪', '12345677');
INSERT INTO `administrator` VALUES ('402880845ce41d5c015ce41d610f0007', '余豪', '12345677');
INSERT INTO `administrator` VALUES ('402880845ce41d5c015ce41d611a0008', '余豪', '12345677');
INSERT INTO `administrator` VALUES ('402880845ce41d5c015ce41d61220009', '余豪', '12345677');
INSERT INTO `administrator` VALUES ('ff8080815ce2f842015ce2f845820000', 'lijian', '123456');
INSERT INTO `administrator` VALUES ('ff8080815ce2f842015ce2f84da50001', 'lijian', '123456');

-- ----------------------------
-- Table structure for chapter
-- ----------------------------
DROP TABLE IF EXISTS `chapter`;
CREATE TABLE `chapter` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(50) NOT NULL COMMENT '章节名称',
  `courseid` varchar(50) NOT NULL COMMENT '课程id',
  `number` varchar(50) NOT NULL COMMENT '章节编号',
  PRIMARY KEY (`id`),
  KEY `FK_db_数据结构chapter_db_course` (`courseid`),
  CONSTRAINT `FK_db_数据结构chapter_db_course` FOREIGN KEY (`courseid`) REFERENCES `course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程章节表';

-- ----------------------------
-- Records of chapter
-- ----------------------------
INSERT INTO `chapter` VALUES ('1', '线性表', '1', '123456');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(50) NOT NULL COMMENT '课程名',
  `teacherid` varchar(50) NOT NULL COMMENT '老师id',
  PRIMARY KEY (`id`),
  KEY `FK_db_course_db_teacher` (`teacherid`),
  CONSTRAINT `FK_db_course_db_teacher` FOREIGN KEY (`teacherid`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程表';

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '数据结构', '1');

-- ----------------------------
-- Table structure for data
-- ----------------------------
DROP TABLE IF EXISTS `data`;
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

-- ----------------------------
-- Records of data
-- ----------------------------

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `chapterid` varchar(50) NOT NULL COMMENT '章节id',
  `answer` varchar(50) NOT NULL COMMENT '答案',
  `address` varchar(50) NOT NULL COMMENT '地址',
  PRIMARY KEY (`id`),
  KEY `FK_db_数据结构试题_db_数据结构chapter` (`chapterid`),
  CONSTRAINT `FK_db_数据结构试题_db_数据结构chapter` FOREIGN KEY (`chapterid`) REFERENCES `chapter` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程试题表';

-- ----------------------------
-- Records of exam
-- ----------------------------

-- ----------------------------
-- Table structure for progress
-- ----------------------------
DROP TABLE IF EXISTS `progress`;
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

-- ----------------------------
-- Records of progress
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
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
  `picture` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生表';

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'root', 'root', '唐湘龙', '2017-06-24', '男', '本科', '4', '7933', '计算机', '');
INSERT INTO `student` VALUES ('2', '余豪', '123456', ' 单', '2017-06-09', '男', '          本科', '          3', '          1668926294@qq.com', '          计算机', 'stuimg/头像2.jpg');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
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

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', 'root', 'maybe', 'root', '双性人', '大学', '123', '123');
