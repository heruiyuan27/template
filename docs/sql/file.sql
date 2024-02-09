/*
 Navicat Premium Data Transfer

 Source Server         : local host 3306
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : java

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 09/02/2024 10:40:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `file_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `file_size` bigint(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES (1, 'bd5753b3-5f6f-496b-850f-a836155012c6', '8天8晚答案.rar', 5975251, '2024-02-09 10:39:33');
INSERT INTO `file` VALUES (2, '37e38b58-e731-4147-9336-6fa9448a6684', '数量关系系统课——刘文超.pdf', 6160772, '2024-02-09 10:39:33');

SET FOREIGN_KEY_CHECKS = 1;
