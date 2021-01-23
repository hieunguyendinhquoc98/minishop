-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: dbminishop
-- ------------------------------------------------------
-- Server version	5.7.18

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
-- Table structure for table `CHITIETHOADON`
--

DROP TABLE IF EXISTS `CHITIETHOADON`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CHITIETHOADON` (
  `mahoadon` int(11) NOT NULL,
  `machitietsanpham` int(11) NOT NULL,
  `soluong` int(11) DEFAULT NULL,
  `giatien` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`mahoadon`,`machitietsanpham`),
  KEY `FK_CTHOADON_CTSANPHAM` (`machitietsanpham`),
  CONSTRAINT `FK_CTHOADON_CTSANPHAM` FOREIGN KEY (`machitietsanpham`) REFERENCES `CHITIETSANPHAM` (`machitietsanpham`),
  CONSTRAINT `FK_CTHOADON_HOADON` FOREIGN KEY (`mahoadon`) REFERENCES `HOADON` (`mahoadon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CHITIETHOADON`
--

LOCK TABLES `CHITIETHOADON` WRITE;
/*!40000 ALTER TABLE `CHITIETHOADON` DISABLE KEYS */;
/*!40000 ALTER TABLE `CHITIETHOADON` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CHITIETKHUYENMAI`
--

DROP TABLE IF EXISTS `CHITIETKHUYENMAI`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CHITIETKHUYENMAI` (
  `makhuyenmai` int(11) NOT NULL,
  `masanpham` int(11) NOT NULL,
  `giagia` int(11) DEFAULT NULL,
  PRIMARY KEY (`makhuyenmai`,`masanpham`),
  KEY `FK_CHITIETKHUYENMAI_SANPHAM` (`masanpham`),
  CONSTRAINT `FK_CHITIETKHUYENMAI_SANPHAM` FOREIGN KEY (`masanpham`) REFERENCES `SANPHAM` (`masanpham`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CHITIETKHUYENMAI`
--

LOCK TABLES `CHITIETKHUYENMAI` WRITE;
/*!40000 ALTER TABLE `CHITIETKHUYENMAI` DISABLE KEYS */;
/*!40000 ALTER TABLE `CHITIETKHUYENMAI` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CHITIETSANPHAM`
--

DROP TABLE IF EXISTS `CHITIETSANPHAM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CHITIETSANPHAM` (
  `machitietsanpham` int(11) NOT NULL AUTO_INCREMENT,
  `masanpham` int(11) DEFAULT NULL,
  `masize` int(11) DEFAULT NULL,
  `mamau` int(11) DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  `ngaynhap` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`machitietsanpham`),
  KEY `FK_CHITIET_SANPHAM` (`masanpham`),
  KEY `FK_CHITIET_SIZE` (`masize`),
  KEY `FK_CHITIET_MAUSANPHAM` (`mamau`),
  CONSTRAINT `FK_CHITIET_MAUSANPHAM` FOREIGN KEY (`mamau`) REFERENCES `MAUSANPHAM` (`mamau`),
  CONSTRAINT `FK_CHITIET_SANPHAM` FOREIGN KEY (`masanpham`) REFERENCES `SANPHAM` (`masanpham`),
  CONSTRAINT `FK_CHITIET_SIZE` FOREIGN KEY (`masize`) REFERENCES `SIZESANPHAM` (`masize`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CHITIETSANPHAM`
--

LOCK TABLES `CHITIETSANPHAM` WRITE;
/*!40000 ALTER TABLE `CHITIETSANPHAM` DISABLE KEYS */;
INSERT INTO `CHITIETSANPHAM` VALUES (4,1,1,1,15,'24/11/2017'),(5,1,2,2,10,'24/11/2017'),(6,1,3,1,8,'24/11/2017'),(10,2,1,1,30,'24/11/2017'),(11,2,1,2,20,'24/11/2017'),(12,2,2,2,10,'24/11/2017'),(17,3,1,1,5,'24/11/2017'),(18,3,1,2,3,'24/11/2017'),(19,3,2,1,5,'24/11/2017'),(20,3,3,2,3,'24/11/2017'),(21,4,1,1,4,'24/11/2017'),(22,4,1,2,6,'24/11/2017'),(23,4,2,1,5,'24/11/2017'),(24,5,1,1,6,'24/11/2017'),(25,6,1,2,7,'24/11/2017'),(26,7,1,1,7,'24/11/2017'),(27,7,2,1,7,'24/11/2017'),(28,7,3,2,8,'24/11/2017'),(29,7,2,2,8,'24/11/2017'),(30,8,1,1,7,'24/11/2017'),(31,9,1,2,7,'24/11/2017'),(32,10,2,2,5,'24/11/2017'),(33,11,3,1,4,'24/11/2017'),(34,12,1,1,5,'24/11/2017'),(35,13,1,5,5,'24/11/2017'),(36,14,1,3,5,'24/11/2017'),(37,15,1,2,4,'24/11/2017'),(38,16,1,2,3,'24/11/2017'),(39,17,1,2,4,'24/11/2017'),(40,18,2,2,6,'24/11/2017'),(41,19,1,2,6,'24/11/2017'),(42,20,2,3,4,'24/11/2017'),(43,21,1,5,6,'24/11/2017');
/*!40000 ALTER TABLE `CHITIETSANPHAM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CHUCVU`
--

DROP TABLE IF EXISTS `CHUCVU`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CHUCVU` (
  `machucvu` int(11) NOT NULL AUTO_INCREMENT,
  `tenchucvu` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`machucvu`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CHUCVU`
--

LOCK TABLES `CHUCVU` WRITE;
/*!40000 ALTER TABLE `CHUCVU` DISABLE KEYS */;
INSERT INTO `CHUCVU` VALUES (1,'Nhân Viên'),(2,'Admin'),(3,'Người Dùng');
/*!40000 ALTER TABLE `CHUCVU` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DANHMUCSANPHAM`
--

DROP TABLE IF EXISTS `DANHMUCSANPHAM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DANHMUCSANPHAM` (
  `madanhmuc` int(11) NOT NULL AUTO_INCREMENT,
  `tendanhmuc` varchar(100) DEFAULT NULL,
  `hinhdanhmuc` text,
  PRIMARY KEY (`madanhmuc`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DANHMUCSANPHAM`
--

LOCK TABLES `DANHMUCSANPHAM` WRITE;
/*!40000 ALTER TABLE `DANHMUCSANPHAM` DISABLE KEYS */;
INSERT INTO `DANHMUCSANPHAM` VALUES (1,'Áo Sơ Mi',NULL),(2,'Áo Thun',NULL),(3,'Quần Sort',NULL),(4,'Đồ Kiểu',NULL),(5,'Áo Khoác',NULL),(6,'Áo Đôi',NULL),(7,'Áo Sơ Mi Adachi Nữ',NULL),(8,'Quần Tây',NULL),(9,'Quần Jean Adachi Nam',NULL);
/*!40000 ALTER TABLE `DANHMUCSANPHAM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HOADON`
--

DROP TABLE IF EXISTS `HOADON`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `HOADON` (
  `mahoadon` int(11) NOT NULL AUTO_INCREMENT,
  `tenkhachhang` varchar(100) DEFAULT NULL,
  `sodt` char(12) DEFAULT NULL,
  `diachigiaohang` varchar(200) DEFAULT NULL,
  `tinhtrang` tinyint(4) DEFAULT NULL,
  `ngaylap` varchar(50) DEFAULT NULL,
  `hinhthucgiaohang` varchar(50) DEFAULT NULL,
  `ghichu` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`mahoadon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HOADON`
--

LOCK TABLES `HOADON` WRITE;
/*!40000 ALTER TABLE `HOADON` DISABLE KEYS */;
/*!40000 ALTER TABLE `HOADON` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `KHUYENMAI`
--

DROP TABLE IF EXISTS `KHUYENMAI`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `KHUYENMAI` (
  `makhuyenmai` int(11) NOT NULL AUTO_INCREMENT,
  `tenkhuyenmai` varchar(200) DEFAULT NULL,
  `thoigianbatdau` varchar(50) DEFAULT NULL,
  `thoigianketthuc` varchar(50) DEFAULT NULL,
  `mota` text,
  `hinhkhuyenmai` text,
  PRIMARY KEY (`makhuyenmai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `KHUYENMAI`
--

LOCK TABLES `KHUYENMAI` WRITE;
/*!40000 ALTER TABLE `KHUYENMAI` DISABLE KEYS */;
/*!40000 ALTER TABLE `KHUYENMAI` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MAUSANPHAM`
--

DROP TABLE IF EXISTS `MAUSANPHAM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MAUSANPHAM` (
  `mamau` int(11) NOT NULL AUTO_INCREMENT,
  `tenmau` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`mamau`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MAUSANPHAM`
--

LOCK TABLES `MAUSANPHAM` WRITE;
/*!40000 ALTER TABLE `MAUSANPHAM` DISABLE KEYS */;
INSERT INTO `MAUSANPHAM` VALUES (1,'Xanh Dương'),(2,'Xám'),(3,'Trắng'),(4,'Hồng'),(5,'Xanh Dương'),(6,'Xanh Lá'),(7,'Xanh Ngọc');
/*!40000 ALTER TABLE `MAUSANPHAM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `NHANVIEN`
--

DROP TABLE IF EXISTS `NHANVIEN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `NHANVIEN` (
  `manhanvien` int(11) NOT NULL AUTO_INCREMENT,
  `hoten` varchar(30) DEFAULT NULL,
  `diachi` varchar(200) DEFAULT NULL,
  `gioitinh` tinyint(4) DEFAULT NULL,
  `cmnd` char(14) DEFAULT NULL,
  `machucvu` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `tendangnhap` varchar(50) DEFAULT NULL,
  `matkhau` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`manhanvien`),
  KEY `FK_NHANVIEN_CHUCVU` (`machucvu`),
  CONSTRAINT `FK_NHANVIEN_CHUCVU` FOREIGN KEY (`machucvu`) REFERENCES `CHUCVU` (`machucvu`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `NHANVIEN`
--

LOCK TABLES `NHANVIEN` WRITE;
/*!40000 ALTER TABLE `NHANVIEN` DISABLE KEYS */;
INSERT INTO `NHANVIEN` VALUES (1,'Nguyễn Đình Quốc Hiếu','393 Trần Hưng Đạo Phường Cầu Kho Quận 1',1,'285731226',2,'nguyendinhquochieu98@gmail.com','','123'),(2,NULL,NULL,NULL,NULL,NULL,'nguyenvana@gmail.com','nguyenvana@gmail.com','123456'),(3,NULL,NULL,NULL,NULL,NULL,'nguyenvanb@gmail.com','nguyenvanb@gmail.com','123');
/*!40000 ALTER TABLE `NHANVIEN` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SANPHAM`
--

DROP TABLE IF EXISTS `SANPHAM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SANPHAM` (
  `masanpham` int(11) NOT NULL AUTO_INCREMENT,
  `madanhmuc` int(11) DEFAULT NULL,
  `tensanpham` varchar(100) DEFAULT NULL,
  `giatien` varchar(50) DEFAULT NULL,
  `mota` text,
  `hinhsanpham` text,
  `gianhcho` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`masanpham`),
  KEY `FK_SANPHAM_DANHMUC` (`madanhmuc`),
  CONSTRAINT `FK_SANPHAM_DANHMUC` FOREIGN KEY (`madanhmuc`) REFERENCES `DANHMUCSANPHAM` (`madanhmuc`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SANPHAM`
--

LOCK TABLES `SANPHAM` WRITE;
/*!40000 ALTER TABLE `SANPHAM` DISABLE KEYS */;
INSERT INTO `SANPHAM` VALUES (1,1,'Sơ Mi Nam No Style TN O01','185000','- Thiết kế áo sơ mi kiểu dáng basic, dễ dàng mix với nhiều trang phục khác nhau. \n- Chất liệu Kate mềm mịn, thoáng mát. \n- Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,..\n- Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng.\n- Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu.','79fb5c06-b673-9300-96da-00140b96c912.jpg','nam'),(2,1,'Sơ Mi Nam No Style TD R02','225000','- Thiết kế áo sơ mi kiểu dáng basic, dễ dàng mix với nhiều trang phục khác nhau. \n- Chất liệu Kate mềm mịn, thoáng mát. \n- Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,..\n- Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng.\n- Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu.','b443d8c7-54cc-4500-4a2e-0013ff9ccb91.jpg','nam'),(3,1,'Sơ Mi Nam No Style TN O02','185000','- Thiết kế áo sơ mi kiểu dáng basic, dễ dàng mix với nhiều trang phục khác nhau. \n- Chất liệu Kate mềm mịn, thoáng mát. \n- Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,..\n- Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng.\n- Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu.','7cb8e2db-a600-9c00-0d22-00140b981d57.jpg','nam'),(4,1,'Sơ Mi Nam No Style TN L01','225000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn. \n- Điểm nhấn ở túi áo và tay áo\n- Chất liệu Kate mang lại cảm giác thoáng mát.\n- Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,..\n- Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng.\n- Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','4364f967-2c49-6600-0912-0013c7dbecf6.jpg','nam'),(5,1,'Sơ Mi Nam No Style TD ST01','225000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','d5ebdfa6-2945-2300-e7fe-0013fe31f537.jpg','nam'),(6,1,'Sơ Mi Nam No Style TN N03','225000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','71be5178-0fd9-3300-3f2f-001402e4a70d.jpg','nam'),(7,7,'Sơ Mi Adachi / 0012655','225000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','d5ebdfa6-2945-2300-e7fe-0013fe31f537.jpg','nu'),(8,7,'Sơ Mi Adachi / 0012738','225000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','a4f67968-f23e-0100-8167-00129a10884e.jpg','nu'),(9,7,'Sơ Mi Adachi / 0012658','225000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','deec8c60-24e0-2400-041b-001266560db2.jpg','nu'),(10,7,'Sơ Mi Adachi / 0012658','225000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','c115c69d-008c-9900-eea8-00125b42fa42.jpg','nu'),(11,7,'Sơ Mi Nữ Ada / 0011510','225000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','235dbdd4-3e4c-0601-d255-0011b3196395.jpg','nu'),(12,7,'Sơ Mi Nữ Ada / 0011527','225000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','d0876922-7a1a-1000-d878-0011cac12000.jpg','nu'),(13,5,'Áo Khoác Nam / 0012847','350000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','dbd236b7-632a-4d00-e24c-0012c7cebae9.jpg','nam'),(14,5,'Áo Khoác Nam / 0015281','350000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','f68cced6-1260-1800-8aba-0013f7c75d9d.jpg','nam'),(15,8,'Quần Tây Nam / 0013221','255000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','bc9c9562-4f7b-5000-3996-00130c201f8b.jpg','nam'),(16,8,'Quần Tây Nam / 0013149','255000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','1a210540-fc63-4f00-8a10-00130c1f9f3e.jpg','nam'),(17,9,'Quần Kaki Na / 0013761','255000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','6a77c9a8-65a8-7100-099b-00132237c111.jpg','nam'),(18,9,'Quần Jean Na / 0011530','255000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','14980579-6ccf-4700-8f83-0011bef478d3.jpg','nam'),(19,9,'Quần Jean Na / 0012764','255000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','f77d145c-d029-c000-b518-0012843a733b.jpg','nam'),(20,9,'Quần Jean Na / 0013631','255000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','aa1bf585-0b70-6300-c372-00131679d75e,1771f301-dfcf-6200-1841-00131679d749.gif','nam'),(21,9,'Quần Kaki Na / 0013757','255000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','cb3e216d-6429-0100-8fd0-00132239b82b.jpg','nam');
/*!40000 ALTER TABLE `SANPHAM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SIZESANPHAM`
--

DROP TABLE IF EXISTS `SIZESANPHAM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SIZESANPHAM` (
  `masize` int(11) NOT NULL AUTO_INCREMENT,
  `size` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`masize`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SIZESANPHAM`
--

LOCK TABLES `SIZESANPHAM` WRITE;
/*!40000 ALTER TABLE `SIZESANPHAM` DISABLE KEYS */;
INSERT INTO `SIZESANPHAM` VALUES (1,'M'),(2,'L'),(3,'XL'),(4,'XXL');
/*!40000 ALTER TABLE `SIZESANPHAM` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-26  9:26:00
