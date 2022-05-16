DROP DATABASE IF EXISTS cdweb2022;

CREATE DATABASE cdweb2022;
USE cdweb2022;
SET NAMES utf8 ;


DROP TABLE IF EXISTS `role`;
  
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255)    DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `role` VALUES (1,'client'),(2,'admin');

DROP TABLE IF EXISTS `user`;
  
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `birthday` datetime DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `email` varchar(255)    DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `password` varchar(255)    DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `token` varchar(255)    DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `username` varchar(255)    DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `user` VALUES (1,NULL,NULL,NULL,NULL,'123',1,NULL,NULL,'u1'),(2,NULL,NULL,NULL,NULL,'123',1,NULL,NULL,'u2');

DROP TABLE IF EXISTS `user_role`;
  
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `user_role` VALUES (1,1),(2,2);

DROP TABLE IF EXISTS `address`;
  
CREATE TABLE `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(255)    DEFAULT NULL,
  `company` varchar(255)    DEFAULT NULL,
  `country` varchar(255)    DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `district` varchar(255)    DEFAULT NULL,
  `fullname` varchar(255)    DEFAULT NULL,
  `phone` varchar(255)    DEFAULT NULL,
  `street` varchar(255)    DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `ward` varchar(255)    DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKda8tuywtf0gb6sedwk7la1pgi` (`user_id`),
  CONSTRAINT `FKda8tuywtf0gb6sedwk7la1pgi` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `address` VALUES (1,'HCM',NULL,NULL,NULL,NULL,'AN',NULL,NULL,NULL,NULL,1),(2,'HCM',NULL,NULL,NULL,NULL,'Hải',NULL,NULL,NULL,NULL,2);

DROP TABLE IF EXISTS `category`;
  
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255)    DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `category` VALUES (1,'Laptop'),(2,'RAM'),(3,'SSD'),(4,'USB');

DROP TABLE IF EXISTS `attribute`;
  
CREATE TABLE `attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255)    DEFAULT NULL,
  `value` varchar(255)    DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1eji3t1hu871hkq00mx58v7w3` (`category_id`),
  CONSTRAINT `FK1eji3t1hu871hkq00mx58v7w3` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `attribute` VALUES (1,'THƯƠNG HIỆU','Acer',1),(2,'THƯƠNG HIỆU','Asus',1),(3,'THƯƠNG HIỆU','Dell',1),(4,'THƯƠNG HIỆU','Gigabyte',1),(5,'THƯƠNG HIỆU','HP',1),(6,'THƯƠNG HIỆU','HUAWEI',1),(7,'THƯƠNG HIỆU','Intel',1),(8,'THƯƠNG HIỆU','Lenovo',1),(9,'THƯƠNG HIỆU','MSI',1),(10,'NHU CẦU','Mỏng nhẹ',1),(11,'NHU CẦU','Gaming và Đồ họa',1),(12,'KÍCH THƯỚC MÀN HÌNH','13 Inch',1),(13,'KÍCH THƯỚC MÀN HÌNH','14 Inch',1),(14,'KÍCH THƯỚC MÀN HÌNH','15.6 Inch',1),(15,'KÍCH THƯỚC MÀN HÌNH','17.3 Inch',1),(16,'CPU','Intel EVO',1),(17,'CPU','Ryzen 3',1),(18,'CPU','Ryzen 5',1),(19,'CPU','Ryzen 7',1),(20,'CPU','Ryzen 9',1),(21,'CPU','Intel Core i3',1),(22,'CPU',' Intel Core i5',1),(23,'VGA','MX330',1),(24,'VGA','MX350',1),(25,'VGA','MX450',1),(26,'VGA','RX 5500M',1),(27,'VGA','GTX 1650',1),(28,'VGA','GTX 1660',1),(29,'VGA','RTX 2070',1),(30,'VGA','RTX A2000',1),(31,'VGA','Quadro',1),(32,'VGA','RX 6600',1),(33,'VGA','RX 6700',1),(34,'VGA','RTX 3050',1),(35,'VGA','RTX 3050 Ti',1),(36,'VGA','RTX 3060',1),(37,'VGA','RTX 3070',1),(38,'VGA','RTX 3080',1),(39,'CPU',' Intel Core i7',1),(40,'CPU',' Intel Core i9',1);

DROP TABLE IF EXISTS `voucher`;
  
CREATE TABLE `voucher` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255)    DEFAULT NULL,
  `cost` bigint(20) DEFAULT NULL,
  `ended_date` datetime DEFAULT NULL,
  `started_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


INSERT INTO `voucher` VALUES (1,'aaa',10000,'2022-05-03 12:15:00','2022-05-10 12:15:00');

DROP TABLE IF EXISTS `bill`;
  
CREATE TABLE `bill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `shipping_cost` bigint(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `total` bigint(20) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `address_id` bigint(20) DEFAULT NULL,
  `voucher_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1f5an6dq4k8u0idf4oxthpf8t` (`address_id`),
  KEY `FKsp8lqd3ijs9y7t59djo0y1g1c` (`voucher_id`),
  CONSTRAINT `FK1f5an6dq4k8u0idf4oxthpf8t` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`),
  CONSTRAINT `FKsp8lqd3ijs9y7t59djo0y1g1c` FOREIGN KEY (`voucher_id`) REFERENCES `voucher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `bill` VALUES (1,'2022-05-03 12:15:00',40000,1,60000000,'2022-05-03 12:15:00',1,1);


DROP TABLE IF EXISTS `product`;
  
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `discount` int(11) DEFAULT NULL,
  `long_description` text   ,
  `name` varchar(255)    DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  `quantity` bigint(20) DEFAULT NULL,
  `short_description` text   ,
  `status` int(11) DEFAULT NULL,
  `summary` varchar(255)    DEFAULT NULL,
  `view` bigint(20) DEFAULT NULL,
  `promotion` varchar(255)    DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `product` VALUES (1,2,'<div class=\"text-full\"><p><strong>Laptop Gaming Gigabyte AORUS 17 XE5-73VN534GH </strong> đáp ứng đủ các tiêu chuẩn của người chơi chuyên nghiệp. Được trang bị GPU GeForce RTX 30 series mới nhất, công nghệ làm mát Windforce Infinity độc quyền, cùng với bộ xử lý Intel Core H thế hệ thứ 12, đảm bảo sự ổn định trong việc cung cấp 100% hiệu suất đầu ra, mang đến cho bạn hiệu ứng hiển thị tốt nhất và chân thực trong các trò chơi. </p><p><img src=\"//bizweb.sapocdn.net/100/329/122/files/screenshot-1648700593.jpg?v=1648700644129\" style=\"width: 100%;\"></p><table cellpadding=\"1\" width=\"100%\" style=\"border-collapse: collapse; margin-bottom: 15px;\"><tbody><tr><td width=\"70%\" style=\"text-align: left; padding: 15px; border: 1px solid #e1e1e1;\"><p><span style=\"color: #000000;\"><span style=\"font-size: 24px;\"><b>Bộ xử lý Intel Core thế hệ 12</b></span></span></p><p><span style=\"color: #000000;\"><strong>AORUS 17&nbsp;XE5</strong>&nbsp;được trang bị bộ vi xử lý Intel Core thế hệ 12 với 14 nhân và xung nhịp lên đến 4.7GHz giúp tăng đến 32% hiệu suất so với thế hệ trước để bạn dễ dàng trải nghiệm các tác vụ nặng một cách dễ dàng.</span></p></td><td width=\"30%\" style=\"padding: 15px; border: 1px solid #e1e1e1;\"><span style=\"color: #000000;\"><img data-thumb=\"original\" original-height=\"631\" original-width=\"1019\" src=\"//bizweb.sapocdn.net/100/329/122/files/screenshot-1645002575.png?v=1645003425022\" style=\"width: 100%;\"></span></td></tr></tbody></table><table cellpadding=\"1\" width=\"100%\" style=\"border-collapse: collapse; margin-bottom: 15px;\"><tbody><tr><td width=\"30%\" style=\"padding: 15px; border: 1px solid #e1e1e1;\"><span style=\"color: #000000;\"><img data-thumb=\"original\" original-height=\"1080\" original-width=\"1920\" src=\"//bizweb.sapocdn.net/100/329/122/files/367-nvidia-ampere-gpu-general.jpg?v=1627703999772\" style=\"width: 100%;\"></span></td><td width=\"70%\" style=\"text-align: left; padding: 15px; border: 1px solid #e1e1e1;\"><p><span style=\"color: #000000;\"><span style=\"font-size: 18pt;\"><strong>GeForce RTX™ 30 Series</strong></span></span></p><p><span style=\"color: #000000;\">Trang bị GPU&nbsp;GeForce RTX&nbsp;30 Series giúp&nbsp;<em><strong>Gigabyte AORUS 17</strong></em>&nbsp;mang lại hiệu suất tối thượng cho game thủ và nhà&nbsp;sáng tạo video. Card hoạt động trên nền tảng Ampere, Kiến trúc RTX thế hệ thứ 2 của NVIDIA với nhân RT, nhân Tensor và bộ đa xử lý phát trực tuyến mới, cung cấp đồ họa dò tia chân thực nhất và các tính năng AI tiên tiến. </span></p></td></tr></tbody></table><table cellpadding=\"1\" width=\"100%\" style=\"border-collapse: collapse; margin-bottom: 15px;\"><tbody><tr><td width=\"70%\" style=\"text-align: left; padding: 15px; border: 1px solid #e1e1e1;\"><p><span style=\"color: #000000;\"><span style=\"font-size: 24px;\"><b>Bộ xử lý Intel Core thế hệ 12</b></span></span></p><p><span style=\"color: #000000;\"><strong>AORUS 17&nbsp;XE5</strong>&nbsp;được trang bị bộ vi xử lý Intel Core thế hệ 12 với 14 nhân và xung nhịp lên đến 4.7GHz giúp tăng đến 32% hiệu suất so với thế hệ trước để bạn dễ dàng trải nghiệm các tác vụ nặng một cách dễ dàng.</span></p></td><td width=\"30%\" style=\"padding: 15px; border: 1px solid #e1e1e1;\"><span style=\"color: #000000;\"><img data-thumb=\"original\" original-height=\"631\" original-width=\"1019\" src=\"//bizweb.sapocdn.net/100/329/122/files/screenshot-1645002575.png?v=1645003425022\" style=\"width: 100%;\"></span></td></tr></tbody></table><table cellpadding=\"1\" width=\"100%\" style=\"border-collapse: collapse; margin-bottom: 15px;\"><tbody><tr><td width=\"30%\" style=\"padding: 15px; border: 1px solid #e1e1e1;\"><span style=\"color: #000000;\"><img data-thumb=\"original\" original-height=\"1080\" original-width=\"1920\" src=\"//bizweb.sapocdn.net/100/329/122/files/367-nvidia-ampere-gpu-general.jpg?v=1627703999772\" style=\"width: 100%;\"></span></td><td width=\"70%\" style=\"text-align: left; padding: 15px; border: 1px solid #e1e1e1;\"><p><span style=\"color: #000000;\"><span style=\"font-size: 18pt;\"><strong>GeForce RTX™ 30 Series</strong></span></span></p><p><span style=\"color: #000000;\">Trang bị GPU&nbsp;GeForce RTX&nbsp;30 Series giúp&nbsp;<em><strong>Gigabyte AORUS 17</strong></em>&nbsp;mang lại hiệu suất tối thượng cho game thủ và nhà&nbsp;sáng tạo video. Card hoạt động trên nền tảng Ampere, Kiến trúc RTX thế hệ thứ 2 của NVIDIA với nhân RT, nhân Tensor và bộ đa xử lý phát trực tuyến mới, cung cấp đồ họa dò tia chân thực nhất và các tính năng AI tiên tiến. </span></p></td></tr></tbody></table></div>','Laptop Gaming Gigabyte AORUS 17 XE5-73VN534GH (i7-12700H, RTX 3070 Ti 8GB, Ram 16GB DDR5, SSD 1TB, 17.3 Inch IPS 360Hz FHD)',60990000,3,'đáp ứng đủ các tiêu chuẩn của người chơi chuyên nghiệp. Được trang bị GPU GeForce RTX 30 series mới nhất, công nghệ làm mát Windforce Infinity độc quyền, cùng với bộ xử lý Intel Core H thế hệ thứ 12, đảm bảo sự ổn định trong việc cung cấp 100% hiệu suất đầu ra, mang đến cho bạn hiệu ứng hiển thị tốt nhất và chân thực trong các trò chơi.',1,'CPU: i7-12700H (Up to 4.7GHz) 14 Cores 20 Threads; VGA: GeForce RTX 3070 Ti 8GB; Ram: 16GB (2x8GB) DDR5 4800MHz; SSD: 1TB SSD M.2 PCIe Gen4 x4; Màn hình: 17.3\'\' IPS 360Hz FHD; BẢO HÀNH 2 năm toàn cầu',NULL,'Balo Gaming Aorus.;USB Aorus Chibi 64GB.;Gấu bông Aorus Eagle.;Túi chống sốc.'),(2,16,'<div class=\"text-full\"><p><strong> Laptop Dell Inspiron 16 5625 70281537 </strong> mang vẻ bề ngoài thanh lịch, sang trọng cùng thiết kế mỏng, nhẹ và hiệu năng vượt trội từ bộ vi xử lý AMD Ryzen 5000 Series, mang đến khả năng di động vượt trội hơn bao giờ hết. </p><p><img src=\"//bizweb.sapocdn.net/100/329/122/files/laptop-inspiron-16-5625-pdp-mod01-fpr.jpg?v=1648199714183\" style=\"width: 100%;\"></p><table cellpadding=\"1\" width=\"100%\" style=\"border-collapse: collapse; margin-bottom: 15px;\"><tbody><tr><td width=\"70%\" style=\"text-align: left;\"><p><span style=\"color: #000000;\"><span style=\"font-size: 18pt;\"><strong>Hiệu suất vượt bật</strong></span></span></p><p><span style=\"color: #000000;\"><strong>Laptop Dell Inspiron 16 5625</strong>&nbsp;được trang bị vi xử lý AMD Ryzen 5000 Series mang đến hiệu năng xử lý vượt trội để máy trở nên cơ động giúp bạn dễ dàng làm việc một cách hiệu quả nhất.</span></p></td><td width=\"30%\"><span style=\"color: #000000;\"><img data-thumb=\"original\" original-height=\"501\" original-width=\"1000\" src=\"//bizweb.sapocdn.net/100/329/122/files/jtlhwyhukjr8g4sfqmtxad.jpg?v=1648199871059\" style=\"width: 100%;\"></span></td></tr></tbody></table><table cellpadding=\"1\" width=\"100%\" style=\"border-collapse: collapse; margin-bottom: 15px;\"><tbody><tr><td width=\"30%\"><span style=\"color: #000000;\"><img data-thumb=\"original\" original-height=\"750\" original-width=\"950\" src=\"//bizweb.sapocdn.net/100/329/122/files/laptop-inspiron-16-5625-pdp-mod02.jpg?v=1648199688017\" style=\"width: 100%;\"></span></td><td width=\"70%\" style=\"text-align: left;\"><p><span style=\"color: #000000;\"><span style=\"font-size: 18pt;\"><strong>Màn hình rực rỡ</strong></span></span></p><p><span style=\"color: #000000;\"><strong>Laptop Dell Inspiron 16 5625</strong>&nbsp;mang đến hình ảnh&nbsp;tươi sáng và đầy màu sắc. Ngoài ra&nbsp;ComfortView là giải pháp được chứng nhận bởi TÜV Rheinland&nbsp;giúp giảm phát thải ánh sáng xanh có hại cùng giảm nhấp nháy để thân thiện hơn với đôi mắt của bạn.</span></p></td></tr></tbody></table><table cellpadding=\"1\" width=\"100%\" style=\"border-collapse: collapse; margin-bottom: 15px;\"><tbody><tr><td width=\"70%\" style=\"text-align: left;\"><p><span style=\"color: #000000;\"><span style=\"font-size: 18pt;\"><strong>Camera 1080P</strong></span></span></p><p><span style=\"color: #000000;\"><strong>Laptop Dell Inspiron 16 5625&nbsp;</strong>với camera FHD được tích hợp Micro&nbsp;kép và AI giúp giảm tiếng ồn xung quanh. Khi bạn cần ngắt kết nối,&nbsp;màn trập riêng tư của camera giúp bạn yên tâm hơn về bảo mật.</span></p></td><td width=\"30%\"><span style=\"color: #000000;\"><img data-thumb=\"original\" original-height=\"1056\" original-width=\"1503\" src=\"//bizweb.sapocdn.net/100/329/122/files/laptop-inspiron-16-5625-pdp-mod03.jpg?v=1648199699688\" style=\"width: 100%;\"></span></td></tr></tbody></table></div>','Laptop Dell Inspiron 16 5625 70281537 (Ryzen 5 5625U, Radeon Graphics, Ram 8GB DDR4, SSD 512GB, 16 Inch FHD)',24990000,6,'mang vẻ bề ngoài thanh lịch, sang trọng cùng thiết kế mỏng, nhẹ và hiệu năng vượt trội từ bộ vi xử lý AMD Ryzen 5000 Series, mang đến khả năng di động vượt trội hơn bao giờ hết.',1,'CPU: Ryzen 5 5625U (2.3GHz~4.3GHz) 6 Cores 12 Threads; VGA: AMD Radeon Graphics; Ram: 8GB DDR4 3200MHz; Ổ cứng: 512GB SSD M.2 PCIe; Màn hình: 16\" FHD; Bảo hành 1 năm.',NULL,'Balo Gaming Aorus.;USB Aorus Chibi 64GB.;Gấu bông Aorus Eagle.;Túi chống sốc.'),(3,12,'<div class=\"text-full\"><p><strong> Laptop Gaming Acer Predator Triton 300 PT315-53-7440 NH.QDRSV.003 </strong> kết hợp vừa chơi game giải trí, vừa làm việc với bộ xử lý Intel Core-H thế hệ thứ 11 mạnh mẽ cùng card đồ họa RTX 30 series cho phép bạn xử lý nhiều tác vụ cùng lúc một cách dễ dàng. Hơn nữa, màn hình QHD lên đến 165Hz 3ms, cùng dung lượng lưu trữ lớn và công nghệ Wi-Fi 6 Killer hỗ trợ cho bạn thực hiện các vai trò khác nhau dễ dàng. </p><p><img src=\"https://bizweb.sapocdn.net/100/329/122/files/predator-triton-300.jpg?v=1650621081903\" style=\"width: 100%;\"></p><table cellpadding=\"1\" width=\"100%\" style=\"border-collapse: collapse; margin-bottom: 15px;\"><tbody><tr><td width=\"30%\"><img data-thumb=\"original\" original-height=\"800\" original-width=\"1440\" src=\"//bizweb.sapocdn.net/100/329/122/files/predator-triton-300-1.jpg?v=1650621897310\" style=\"width: 100%;\"></td><td width=\"70%\" style=\"text-align: left;\"><p><span style=\"color: #000000;\"><span style=\"font-size: 18pt;\"><strong>Hiệu năng mạnh mẽ</strong></span></span></p><p><span style=\"color: #000000;\"><strong>Acer Predator Triton 300</strong> trang bị&nbsp;bộ vi xử lý Intel Core-H thế hệ thứ 11 mạnh mẽ với 8&nbsp;nhân 16&nbsp;luồng,&nbsp;cho phép bạn xử lý nhiều tác vụ cùng lúc một cách dễ dàng.</span></p></td></tr></tbody></table><table cellpadding=\"1\" width=\"100%\" style=\"border-collapse: collapse; margin-bottom: 15px;\"><tbody><tr><td width=\"70%\" style=\"text-align: left;\"><p><span style=\"color: #000000;\"><span style=\"font-size: 18pt;\"><strong>GeForce RTX™ 30 Series</strong></span></span></p><p><span style=\"color: #000000;\"><strong>Acer Predator Triton 300&nbsp;</strong>trang bị GPU GeForce RTX 30 Series mang lại hiệu suất tối thượng cho game thủ và nhà sáng tạo video. Card hoạt động trên nền tảng Ampere, Kiến trúc RTX thế hệ thứ 2 của NVIDIA với nhân RT, nhân Tensor và bộ đa xử lý phát trực tuyến mới, cung cấp đồ họa dò tia chân thực nhất và các tính năng AI tiên tiến.</span></p></td><td width=\"30%\"><img data-thumb=\"original\" original-height=\"773\" original-width=\"1230\" src=\"//bizweb.sapocdn.net/100/329/122/files/screenshot-1633151838.png?v=1633151854151\" style=\"width: 100%;\"></td></tr></tbody></table><table cellpadding=\"1\" width=\"100%\" style=\"border-collapse: collapse; margin-bottom: 15px;\"><tbody><tr><td width=\"30%\"><span style=\"color: #000000;\"><img data-thumb=\"original\" original-height=\"800\" original-width=\"1123\" src=\"//bizweb.sapocdn.net/100/329/122/files/predator-helios300-ksp-6.jpg?v=1633152231367\" style=\"width: 100%;\"></span></td><td width=\"70%\" style=\"text-align: left;\"><p><span style=\"color: #000000;\"><span style=\"font-size: 18pt;\"><strong>Màn hình QHD&nbsp;165Hz chân thực</strong></span></span></p><p><span style=\"color: #000000;\">Trang bị màn hình IPS QHD trên&nbsp;<strong>Acer Predator Triton 300</strong>&nbsp;bùng nổ tần số quét&nbsp;lên đến 165Hz 3ms giúp cho việc&nbsp;trải nghiệm hình ảnh một cách liền mạch, không bị rách với độ mờ tối thiểu nhất.</span></p></td></tr></tbody></table></div>','Laptop Gaming Acer Predator Triton 300 PT315-53-7440 NH.QDRSV.003 (i7-11800H, RTX 3050 Ti 4GB, Ram 8GB, SSD 512GB, 15.6 Inch IPS 165Hz QHD)',36990000,2,'kết hợp vừa chơi game giải trí, vừa làm việc với bộ xử lý Intel Core-H thế hệ thứ 11 mạnh mẽ cùng card đồ họa RTX 30 series cho phép bạn xử lý nhiều tác vụ cùng lúc một cách dễ dàng. Hơn nữa, màn hình QHD lên đến 165Hz 3ms, cùng dung lượng lưu trữ lớn và công nghệ Wi-Fi 6 Killer hỗ trợ cho bạn thực hiện các vai trò khác nhau dễ dàng.',1,'CPU: i7-11800H (2.4GHz~4.6GHz) 8 Cores 16 Threads; VGA: GeForce RTX 3050 Ti 4GB; Ram: 8GB DDR4 3200 MHz; Ổ cứng: 512GB SSD M.2 PCIe; Màn hình: 15.6\'\' IPS 165Hz QHD; Bảo hành 1 năm.',NULL,'Balo Gaming Aorus.;USB Aorus Chibi 64GB.;Gấu bông Aorus Eagle.;Túi chống sốc.'),(4,8,'<div class=\"text-full\"><p><strong> Laptop Dell Inspiron 15 3511 70270652 </strong> mang vẻ bề ngoài thanh lịch, sang trọng cùng thiết kế mỏng, nhẹ và hiệu năng vượt trội từ bộ vi xử lý Intel Core thế hệ 11th, mang đến khả năng di động vượt trội hơn bao giờ hết. </p><p><img src=\"https://bizweb.sapocdn.net/100/329/122/files/predator-triton-300.jpg?v=1650621081903\" style=\"width: 100%;\"></p><table cellpadding=\"1\" width=\"100%\" style=\"border-collapse: collapse; margin-bottom: 15px;\"><tbody><tr><td width=\"30%\"><span style=\"color: #000000;\"><img data-thumb=\"original\" original-height=\"680\" original-width=\"1020\" src=\"//bizweb.sapocdn.net/100/329/122/files/dell-inspiron-15-3511-i5-70267060-7.jpg?v=1639383916391\" style=\"width: 100%;\"></span></td><td width=\"70%\" style=\"text-align: left;\"><p><span style=\"color: #000000;\"><span style=\"font-size: 18pt;\"><strong>Hiệu suất vượt bật</strong></span></span></p><p><span style=\"color: #000000;\"><strong>Laptop Dell Inspiron 15 3511</strong>&nbsp;được trang bị vi xử lý Intel Core Tiger Lake thế hệ 11 mang đến hiệu năng xử lý vượt trội để máy trở nên cơ động giúp bạn dễ dàng làm việc một cách hiệu quả nhất.</span></p></td></tr></tbody></table><table cellpadding=\"1\" width=\"100%\" style=\"border-collapse: collapse; margin-bottom: 15px;\"><tbody><tr><td width=\"70%\" style=\"text-align: left;\"><p><span style=\"color: #000000;\"><span style=\"font-size: 18pt;\"><strong>Trang bị card đồ họa rời</strong></span></span></p><p><span style=\"color: #000000;\">Card đồ họa NVIDIA GeForce MX350 giúp tăng tốc <strong>Laptop Dell Inspiron 15 3511</strong>&nbsp;của bạn cả trong công việc lẫn giải trí. Giờ đây bạn có thể nhận được tốc độ xử lí cao hơn với các tác vụ chỉnh sửa ảnh, video và chơi game.</span></p></td><td width=\"30%\"><img data-thumb=\"original\" original-height=\"350\" original-width=\"557\" src=\"//bizweb.sapocdn.net/100/329/122/files/nvidia-geforce-mx330-mx350.jpg?v=1635327843752\" style=\"width: 100%;\"></td></tr></tbody></table><table cellpadding=\"1\" width=\"100%\" style=\"border-collapse: collapse; margin-bottom: 15px;\"><tbody><tr><td width=\"30%\"><span style=\"color: #000000;\"><img data-thumb=\"original\" original-height=\"467\" original-width=\"514\" src=\"//bizweb.sapocdn.net/100/329/122/files/screenshot-1634889628.png?v=1634889640483\" style=\"width: 100%;\"></span></td><td width=\"70%\" style=\"text-align: left;\"><p><span style=\"color: #000000;\"><span style=\"font-size: 18pt;\"><strong>Ứng dụng&nbsp;Dell Mobile Connect</strong></span></span></p><p><span style=\"color: #000000;\"><strong>Laptop Dell Inspiron 15 3511</strong>&nbsp;hợp nhất với thiết bị di động của bạn qua ứng dụng Dell Mobile Connect. Bạn có thể dễ dàng làm việc như nhận cuộc gọi&nbsp;hay&nbsp;tin nhắn SMS trực tiếp từ Laptop Dell hay truyền tải các tệp tin từ điện thoại một cách dễ dàng hơn.</span></p></td></tr></tbody></table></div>','Laptop Dell Inspiron 15 3511 70270652 (i7-1165G7, MX350 2GB, Ram 8GB DDR4, SSD 512GB, 15.6 Inch FHD)',25490000,1,'mang vẻ bề ngoài thanh lịch, sang trọng cùng thiết kế mỏng, nhẹ và hiệu năng vượt trội từ bộ vi xử lý Intel Core thế hệ 11th, mang đến khả năng di động vượt trội hơn bao giờ hết.',1,'CPU: i7-1165G7 (Up to 4.7GHz) 4 Cores 8 Threads; VGA: NVIDIA MX350 2GB; Ram: 8GB DDR4 3200MHz; Ổ cứng: 512GB SSD M.2 PCIe; Màn hình: 15.6\" FHD; Bảo hành 1 năm.',NULL,'Balo Gaming Aorus.;USB Aorus Chibi 64GB.;Gấu bông Aorus Eagle.;Túi chống sốc.'),(5,8,'<div class=\"text-full\"><p><strong> Laptop HP Probook 430 G8 614K7PA </strong> mang đến vẻ bề ngoài thanh lịch và cực kỳ hiện đại với tông màu bạc sang trọng. Bên cạnh màu sắc đẹp mắt, laptop khiến người dùng ấn tượng bởi thiết kế siêu mỏng và nhẹ mang đến tính di động hơn bao giờ hết. </p><p><img src=\"https://bizweb.sapocdn.net/100/329/122/files/predator-triton-300.jpg?v=1650621081903\" style=\"width: 100%;\"></p><table cellpadding=\"1\" width=\"100%\" style=\"border-collapse: collapse; margin-bottom: 15px;\"><tbody><tr><td width=\"30%\"><img data-thumb=\"original\" original-height=\"1342\" original-width=\"2100\" src=\"//bizweb.sapocdn.net/100/329/122/files/c07046015.jpg?v=1638417362998\" style=\"width: 100%;\"></td><td width=\"70%\" style=\"text-align: left;\"><p><span style=\"color: #000000;\"><span style=\"font-size: 18pt;\"><strong>Thiết kế khung nhôm sang trọng</strong></span></span></p><p><span style=\"color: #000000;\"><strong>Laptop HP Probook 430 G8</strong> mang đến vẻ bề ngoài thanh lịch&nbsp;và cực kỳ hiện đại với tông&nbsp;màu bạc sang trọng. Bên cạnh màu sắc đẹp mắt, laptop khiến người dùng ấn tượng bởi&nbsp;thiết kế khung nhôm mỏng và nhẹ&nbsp;mang đến tính di động hơn bao giờ hết.</span></p></td></tr></tbody></table><table cellpadding=\"1\" width=\"100%\" style=\"border-collapse: collapse; margin-bottom: 15px;\"><tbody><tr><td width=\"70%\" style=\"text-align: left;\"><p><span style=\"color: #000000;\"><span style=\"font-size: 18pt;\"><strong>Trang bị card đồ họa rời</strong></span></span></p><p><span style=\"color: #000000;\">Card đồ họa NVIDIA GeForce MX350 giúp tăng tốc <strong>Laptop Dell Inspiron 15 3511</strong>&nbsp;của bạn cả trong công việc lẫn giải trí. Giờ đây bạn có thể nhận được tốc độ xử lí cao hơn với các tác vụ chỉnh sửa ảnh, video và chơi game.</span></p></td><td width=\"30%\"><img data-thumb=\"original\" original-height=\"350\" original-width=\"557\" src=\"//bizweb.sapocdn.net/100/329/122/files/nvidia-geforce-mx330-mx350.jpg?v=1635327843752\" style=\"width: 100%;\"></td></tr></tbody></table><table cellpadding=\"1\" width=\"100%\" style=\"border-collapse: collapse; margin-bottom: 15px;\"><tbody><tr><td width=\"30%\"><span style=\"color: #000000;\"><img data-thumb=\"original\" original-height=\"467\" original-width=\"514\" src=\"//bizweb.sapocdn.net/100/329/122/files/screenshot-1634889628.png?v=1634889640483\" style=\"width: 100%;\"></span></td><td width=\"70%\" style=\"text-align: left;\"><p><span style=\"color: #000000;\"><span style=\"font-size: 18pt;\"><strong>Ứng dụng&nbsp;Dell Mobile Connect</strong></span></span></p><p><span style=\"color: #000000;\"><strong>Laptop Dell Inspiron 15 3511</strong>&nbsp;hợp nhất với thiết bị di động của bạn qua ứng dụng Dell Mobile Connect. Bạn có thể dễ dàng làm việc như nhận cuộc gọi&nbsp;hay&nbsp;tin nhắn SMS trực tiếp từ Laptop Dell hay truyền tải các tệp tin từ điện thoại một cách dễ dàng hơn.</span></p></td></tr></tbody></table></div>','Laptop HP Probook 430 G8 614K7PA (i3-1115G4, UHD Graphics, Ram 8GB, SSD 256GB, 13.3 Inch HD)',14890000,15,'mang đến vẻ bề ngoài thanh lịch và cực kỳ hiện đại với tông màu bạc sang trọng. Bên cạnh màu sắc đẹp mắt, laptop khiến người dùng ấn tượng bởi thiết kế siêu mỏng và nhẹ mang đến tính di động hơn bao giờ hết.',1,'CPU: i3-1115G4 (Up to 4.1GHz) 2 Cores 4 Threads; VGA: Intel UHD Graphics; Ram: 8GB DDR4 3200MHz; Ổ cứng: 256GB SSD M.2 PCIe; Màn hình: 13.3\'\' HD; Bảo hành 1 năm.',NULL,'Balo Gaming Aorus.;USB Aorus Chibi 64GB.;Gấu bông Aorus Eagle.;Túi chống sốc.');


DROP TABLE IF EXISTS `image`;
  
CREATE TABLE `image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `link` varchar(255)    DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgpextbyee3uk9u6o2381m7ft1` (`product_id`),
  CONSTRAINT `FKgpextbyee3uk9u6o2381m7ft1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `image` VALUES (1,'https://bizweb.sapocdn.net/thumb/1024x1024/100/329/122/products/laptop-gaming-gigabyte-aorus-17-xe5-73vn534gh.png?v=1648702456317',1),(2,'https://bizweb.sapocdn.net/100/329/122/products/laptop-gaming-gigabyte-aorus-17-xe5-73vn534gh-3.png?v=1648702456317',1),(3,'https://bizweb.sapocdn.net/100/329/122/products/laptop-gaming-gigabyte-aorus-17-xe5-73vn534gh-2.png?v=1648702456317',1),(4,'https://bizweb.sapocdn.net/thumb/1024x1024/100/329/122/products/laptop-dell-inspiron-16-5625-70281537.png?v=1650264869833',2),(5,'https://bizweb.sapocdn.net/100/329/122/products/laptop-dell-inspiron-16-5625-2.png?v=1650264871713',2),(6,'https://bizweb.sapocdn.net/100/329/122/products/laptop-dell-inspiron-16-5625-1.png?v=1650264871713',2),(7,'https://bizweb.sapocdn.net/thumb/1024x1024/100/329/122/products/laptop-gaming-acer-predator-triton-300-pt315-53-7440-nh-qdrsv-003.png?v=1650623448350',3),(8,'https://bizweb.sapocdn.net/100/329/122/products/laptop-gaming-acer-predator-triton-300-pt315-53-7440-nh-qdrsv-003-3.png?v=1650623448350',3),(9,'https://bizweb.sapocdn.net/100/329/122/products/laptop-gaming-acer-predator-triton-300-pt315-53-7440-nh-qdrsv-003-2.png?v=1650623448350',3),(10,'https://bizweb.sapocdn.net/thumb/1024x1024/100/329/122/products/laptop-dell-inspiron-15-3511-70270652.png?v=1646630760913',4),(11,'https://bizweb.sapocdn.net/100/329/122/products/laptop-dell-inspiron-15-3511-70270650-6-a1ac66eb-4a80-4f42-aafe-58f031578cef.png?v=1646630762337',4),(12,'https://bizweb.sapocdn.net/100/329/122/products/laptop-dell-inspiron-15-3511-70270650-2-645e50dc-f1ad-4d61-831f-6f1df99cd063.png?v=1646630762337',4),(13,'https://bizweb.sapocdn.net/thumb/1024x1024/100/329/122/products/laptop-hp-probook-430-g8-614k7pa.png?v=1649315244117',5),(14,'https://bizweb.sapocdn.net/100/329/122/products/laptop-hp-probook-430-g8-614k9pa-4-2e0fab15-c0da-4156-b15a-953861447c3d.png?v=1649315245997',5),(15,'https://bizweb.sapocdn.net/100/329/122/products/laptop-hp-probook-430-g8-614k9pa-1-8e366d79-7676-4ac2-838e-a01262e11d8d.png?v=1649315245997',5),(16,'//bizweb.sapocdn.net/100/329/122/files/screenshot-1648700593.jpg?v=1648700644129',1),(17,'https://bizweb.sapocdn.net/100/329/122/files/laptop-inspiron-16-5625-pdp-mod01-fpr.jpg?v=1648199714183',2),(18,'https://bizweb.sapocdn.net/100/329/122/files/predator-triton-300.jpg?v=1650621081903',3),(19,'https://bizweb.sapocdn.net/100/329/122/files/dell-inspiron-15-3511-i5-70267060-8-1.jpg?v=1639383263823',4),(20,'https://bizweb.sapocdn.net/100/329/122/files/c07046023.jpg?v=1638416952108',5);


DROP TABLE IF EXISTS `comment`;
  
CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255)    DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `star` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `url` varchar(255)    DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm1rmnfcvq5mk26li4lit88pc5` (`product_id`),
  KEY `FK8kcum44fvpupyw6f5baccx25c` (`user_id`),
  CONSTRAINT `FK8kcum44fvpupyw6f5baccx25c` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKm1rmnfcvq5mk26li4lit88pc5` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


DROP TABLE IF EXISTS `order_detail`;
  
CREATE TABLE `order_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `price` bigint(20) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `bill_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8xyxpaxwufax0438f2rvtb2xs` (`bill_id`),
  KEY `FKb8bg2bkty0oksa3wiq5mp5qnc` (`product_id`),
  CONSTRAINT `FK8xyxpaxwufax0438f2rvtb2xs` FOREIGN KEY (`bill_id`) REFERENCES `bill` (`id`),
  CONSTRAINT `FKb8bg2bkty0oksa3wiq5mp5qnc` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `order_detail` VALUES (1,25000000,1,1,2);

DROP TABLE IF EXISTS `product_attribute`;
  
CREATE TABLE `product_attribute` (
  `product_id` bigint(20) NOT NULL,
  `attribute_id` bigint(20) NOT NULL,
  KEY `FKefc9famxhv98xs6686269a79` (`attribute_id`),
  KEY `FKlefs59y5kmsbu017n1wp10gf2` (`product_id`),
  CONSTRAINT `FKefc9famxhv98xs6686269a79` FOREIGN KEY (`attribute_id`) REFERENCES `attribute` (`id`),
  CONSTRAINT `FKlefs59y5kmsbu017n1wp10gf2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `product_attribute` VALUES (1,4),(1,11),(1,15),(1,19),(1,37),(2,3),(2,10),(2,14),(2,18),(2,26),(3,1),(3,10),(3,14),(3,39),(3,35),(4,3),(4,10),(4,14),(4,39),(4,24),(5,5),(5,12),(5,21),(5,10),(5,23);

DROP TABLE IF EXISTS `response`;
  
CREATE TABLE `response` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `comment_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjo7d296slarpmfr8p3oeqlsx2` (`comment_id`),
  KEY `FKo86so3ptvukgyfb2rkb63hab4` (`user_id`),
  CONSTRAINT `FKjo7d296slarpmfr8p3oeqlsx2` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`id`),
  CONSTRAINT `FKo86so3ptvukgyfb2rkb63hab4` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;





