use cdweb2022;

INSERT INTO `cdweb2022`.`category` (`id`, `name`) VALUES ('1', 'Laptop');
INSERT INTO `cdweb2022`.`category` (`id`, `name`) VALUES ('2', 'RAM');
INSERT INTO `cdweb2022`.`category` (`id`, `name`) VALUES ('3', 'SSD');
INSERT INTO `cdweb2022`.`category` (`id`, `name`) VALUES ('4', 'USB');

INSERT INTO `cdweb2022`.`attribute` (`id`, `name`, `value`, `category_id`) VALUES ('1', 'THƯƠNG HIỆU', 'Acer', '1');
INSERT INTO `cdweb2022`.`attribute` (`id`, `name`, `value`, `category_id`) VALUES ('2', 'THƯƠNG HIỆU', 'Asus', '1');
INSERT INTO `cdweb2022`.`attribute` (`id`, `name`, `value`, `category_id`) VALUES ('3', 'THƯƠNG HIỆU', 'Dell', '1');
INSERT INTO `cdweb2022`.`attribute` (`id`, `name`, `value`, `category_id`) VALUES ('4', 'THƯƠNG HIỆU', 'Gigabyte', '1');
INSERT INTO `cdweb2022`.`attribute` (`id`, `name`, `value`, `category_id`) VALUES ('5', 'THƯƠNG HIỆU', 'HP', '1');
INSERT INTO `cdweb2022`.`attribute` (`id`, `name`, `value`, `category_id`) VALUES ('6', 'THƯƠNG HIỆU', 'HUAWEI', '1');
INSERT INTO `cdweb2022`.`attribute` (`id`, `name`, `value`, `category_id`) VALUES ('7', 'THƯƠNG HIỆU', 'Intel', '1');
INSERT INTO `cdweb2022`.`attribute` (`id`, `name`, `value`, `category_id`) VALUES ('8', 'THƯƠNG HIỆU', 'Lenovo', '1');
INSERT INTO `cdweb2022`.`attribute` (`id`, `name`, `value`, `category_id`) VALUES ('9', 'THƯƠNG HIỆU', 'MSI', '1');
INSERT INTO `cdweb2022`.`attribute` (`id`, `name`, `value`, `category_id`) VALUES ('10', 'NHU CẦU', 'Mỏng nhẹ', '1');
INSERT INTO `cdweb2022`.`attribute` (`id`, `name`, `value`, `category_id`) VALUES ('11', 'NHU CẦU', 'Gaming và Đồ họa', '1');
INSERT INTO `cdweb2022`.`attribute` (`id`, `name`, `value`, `category_id`) VALUES ('12', 'KÍCH THƯỚC MÀN HÌNH', '13 Inch', '1');
INSERT INTO `cdweb2022`.`attribute` (`id`, `name`, `value`, `category_id`) VALUES ('13', 'KÍCH THƯỚC MÀN HÌNH', '14 Inch', '1');
INSERT INTO `cdweb2022`.`attribute` (`id`, `name`, `value`, `category_id`) VALUES ('14', 'KÍCH THƯỚC MÀN HÌNH', '15.6 Inch', '1');
INSERT INTO `cdweb2022`.`attribute` (`id`, `name`, `value`, `category_id`) VALUES ('15', 'KÍCH THƯỚC MÀN HÌNH', '17.3 Inch', '1');
INSERT INTO `cdweb2022`.`attribute` (`id`, `name`, `value`, `category_id`) VALUES ('16', 'CPU', 'Intel EVO', '1');
INSERT INTO `cdweb2022`.`attribute` (`id`, `name`, `value`, `category_id`) VALUES ('17', 'CPU', 'Ryzen 3', '1');
INSERT INTO `cdweb2022`.`attribute` (`id`, `name`, `value`, `category_id`) VALUES ('18', 'CPU', 'Ryzen 5', '1');
INSERT INTO `cdweb2022`.`attribute` (`id`, `name`, `value`, `category_id`) VALUES ('19', 'CPU', 'Ryzen 7', '1');
INSERT INTO `cdweb2022`.`attribute` (`id`, `name`, `value`, `category_id`) VALUES ('20', 'CPU', 'Ryzen 9', '1');
INSERT INTO `cdweb2022`.`attribute` (`id`, `name`, `value`, `category_id`) VALUES ('21', 'CPU', 'Intel Core i3', '1');
INSERT INTO `cdweb2022`.`attribute` (`id`, `name`, `value`, `category_id`) VALUES ('22', 'CPU', ' Intel Core i5', '1');
INSERT INTO `cdweb2022`.`attribute` (`id`, `name`, `value`, `category_id`) VALUES ('39', 'CPU', ' Intel Core i7', '1');
INSERT INTO `cdweb2022`.`attribute` (`id`, `name`, `value`, `category_id`) VALUES ('40', 'CPU', ' Intel Core i9', '1');

INSERT INTO `cdweb2022`.`attribute` (`id`, `name`, `value`, `category_id`) VALUES
  ('23', 'VGA', 'MX330', '1'),
  ('24', 'VGA', 'MX350', '1') ,
  ('25', 'VGA', 'MX450', '1') ,
  ('26', 'VGA', 'RX 5500M', '1') ,
  ('27', 'VGA', 'GTX 1650', '1') ,
  ('28', 'VGA', 'GTX 1660', '1') ,
  ('29', 'VGA', 'RTX 2070', '1') ,
  ('30', 'VGA', 'RTX A2000', '1') ,
  ('31', 'VGA', 'Quadro', '1') ,
  ('32', 'VGA', 'RX 6600', '1') ,
  ('33', 'VGA', 'RX 6700', '1') ,
  ('34', 'VGA', 'RTX 3050', '1') ,
  ('35', 'VGA', 'RTX 3050 Ti', '1') ,
  ('36', 'VGA', 'RTX 3060', '1') ,
  ('37', 'VGA', 'RTX 3070', '1') ,
  ('38', 'VGA', 'RTX 3080', '1') ;
  
INSERT INTO `cdweb2022`.`product` (`id`, `discount`, `name`, `price`, `quantity`, `status`, `summary`) VALUES ('1', '2', 'Laptop Gaming Gigabyte AORUS 17 XE5-73VN534GH (i7-12700H, RTX 3070 Ti 8GB, Ram 16GB DDR5, SSD 1TB, 17.3 Inch IPS 360Hz FHD)', '60990000', '3', '1', 'CPU: i7-12700H (Up to 4.7GHz) 14 Cores 20 Threads VGA: GeForce RTX 3070 Ti 8GB Ram: 16GB (2x8GB) DDR5 4800MHz SSD: 1TB SSD M.2 PCIe Gen4 x4 Màn hình: 17.3\'\' IPS 360Hz FHD BẢO HÀNH 2 năm');
INSERT INTO `cdweb2022`.`product` (`id`, `discount`, `name`, `price`, `quantity`, `status`,`summary`) VALUES ('2', '16', 'Laptop Dell Inspiron 16 5625 70281537 (Ryzen 5 5625U, Radeon Graphics, Ram 8GB DDR4, SSD 512GB, 16 Inch FHD)', '24990000', '6','1', 'CPU: Ryzen 5 5625U (2.3GHz~4.3GHz) 6 Cores 12 Threads VGA: AMD Radeon Graphics Ram: 8GB DDR4 3200MHz Ổ cứng: 512GB SSD M.2 PCIe Màn hình: 16\" FHD Bảo hành 1 năm.');
INSERT INTO `cdweb2022`.`product` (`id`, `discount`, `name`, `price`, `quantity`, `status`, `summary`) VALUES ('3', '12', 'Laptop Gaming Acer Predator Triton 300 PT315-53-7440 NH.QDRSV.003 (i7-11800H, RTX 3050 Ti 4GB, Ram 8GB, SSD 512GB, 15.6 Inch IPS 165Hz QHD)', '36990000', '2', '1', 'CPU: i7-11800H (2.4GHz~4.6GHz) 8 Cores 16 Threads VGA: GeForce RTX 3050 Ti 4GB Ram: 8GB DDR4 3200 MHz Ổ cứng: 512GB SSD M.2 PCIe Màn hình: 15.6\'\' IPS 165Hz QHD Bảo hành 1 năm.');
INSERT INTO `cdweb2022`.`product` (`id`, `discount`, `name`, `price`, `quantity`, `status`, `summary`) VALUES ('4', '8', 'Laptop Dell Inspiron 15 3511 70270652 (i7-1165G7, MX350 2GB, Ram 8GB DDR4, SSD 512GB, 15.6 Inch FHD)', '25490000', '1', '1', 'CPU: i7-1165G7 (Up to 4.7GHz) 4 Cores 8 Threads VGA: NVIDIA MX350 2GB Ram: 8GB DDR4 3200MHz Ổ cứng: 512GB SSD M.2 PCIe Màn hình: 15.6\" FHD Bảo hành 1 năm.');
INSERT INTO `cdweb2022`.`product` (`id`, `discount`, `name`, `price`, `quantity`, `status`, `summary`) VALUES ('5', '8', 'Laptop HP Probook 430 G8 614K7PA (i3-1115G4, UHD Graphics, Ram 8GB, SSD 256GB, 13.3 Inch HD)', '14890000', '15', '1', 'CPU: i3-1115G4 (Up to 4.1GHz) 2 Cores 4 Threads VGA: Intel UHD Graphics Ram: 8GB DDR4 3200MHz Ổ cứng: 256GB SSD M.2 PCIe Màn hình: 13.3\'\' HD Bảo hành 1 năm. Tình trạng: sẵn sàng');

INSERT INTO `cdweb2022`.`image` (`id`, `link`, `product_id`) VALUES ('1', 'https://bizweb.sapocdn.net/thumb/1024x1024/100/329/122/products/laptop-gaming-gigabyte-aorus-17-xe5-73vn534gh.png?v=1648702456317', '1');
INSERT INTO `cdweb2022`.`image` (`id`, `link`, `product_id`) VALUES ('2', 'https://bizweb.sapocdn.net/100/329/122/products/laptop-gaming-gigabyte-aorus-17-xe5-73vn534gh-3.png?v=1648702456317', '1');
INSERT INTO `cdweb2022`.`image` (`id`, `link`, `product_id`) VALUES ('3', 'https://bizweb.sapocdn.net/100/329/122/products/laptop-gaming-gigabyte-aorus-17-xe5-73vn534gh-2.png?v=1648702456317', '1');
INSERT INTO `cdweb2022`.`image` (`id`, `link`, `product_id`) VALUES ('4', 'https://bizweb.sapocdn.net/thumb/1024x1024/100/329/122/products/laptop-dell-inspiron-16-5625-70281537.png?v=1650264869833', '2');
INSERT INTO `cdweb2022`.`image` (`id`, `link`, `product_id`) VALUES ('5', 'https://bizweb.sapocdn.net/100/329/122/products/laptop-dell-inspiron-16-5625-2.png?v=1650264871713', '2');
INSERT INTO `cdweb2022`.`image` (`id`, `link`, `product_id`) VALUES ('6', 'https://bizweb.sapocdn.net/100/329/122/products/laptop-dell-inspiron-16-5625-1.png?v=1650264871713', '2');
INSERT INTO `cdweb2022`.`image` (`id`, `link`, `product_id`) VALUES ('7', 'https://bizweb.sapocdn.net/thumb/1024x1024/100/329/122/products/laptop-gaming-acer-predator-triton-300-pt315-53-7440-nh-qdrsv-003.png?v=1650623448350', '3');
INSERT INTO `cdweb2022`.`image` (`id`, `link`, `product_id`) VALUES ('8', 'https://bizweb.sapocdn.net/100/329/122/products/laptop-gaming-acer-predator-triton-300-pt315-53-7440-nh-qdrsv-003-3.png?v=1650623448350', '3');
INSERT INTO `cdweb2022`.`image` (`id`, `link`, `product_id`) VALUES ('9', 'https://bizweb.sapocdn.net/100/329/122/products/laptop-gaming-acer-predator-triton-300-pt315-53-7440-nh-qdrsv-003-2.png?v=1650623448350', '3');
INSERT INTO `cdweb2022`.`image` (`id`, `link`, `product_id`) VALUES ('10', 'https://bizweb.sapocdn.net/thumb/1024x1024/100/329/122/products/laptop-dell-inspiron-15-3511-70270652.png?v=1646630760913', '4');
INSERT INTO `cdweb2022`.`image` (`id`, `link`, `product_id`) VALUES ('11', 'https://bizweb.sapocdn.net/100/329/122/products/laptop-dell-inspiron-15-3511-70270650-6-a1ac66eb-4a80-4f42-aafe-58f031578cef.png?v=1646630762337', '4');
INSERT INTO `cdweb2022`.`image` (`id`, `link`, `product_id`) VALUES ('12', 'https://bizweb.sapocdn.net/100/329/122/products/laptop-dell-inspiron-15-3511-70270650-2-645e50dc-f1ad-4d61-831f-6f1df99cd063.png?v=1646630762337', '4');
INSERT INTO `cdweb2022`.`image` (`id`, `link`, `product_id`) VALUES ('13', 'https://bizweb.sapocdn.net/thumb/1024x1024/100/329/122/products/laptop-hp-probook-430-g8-614k7pa.png?v=1649315244117', '5');
INSERT INTO `cdweb2022`.`image` (`id`, `link`, `product_id`) VALUES ('14', 'https://bizweb.sapocdn.net/100/329/122/products/laptop-hp-probook-430-g8-614k9pa-4-2e0fab15-c0da-4156-b15a-953861447c3d.png?v=1649315245997', '5');
INSERT INTO `cdweb2022`.`image` (`id`, `link`, `product_id`) VALUES ('15', 'https://bizweb.sapocdn.net/100/329/122/products/laptop-hp-probook-430-g8-614k9pa-1-8e366d79-7676-4ac2-838e-a01262e11d8d.png?v=1649315245997', '5');

INSERT INTO `cdweb2022`.`product_attribute` (`product_id`, `attribute_id`) VALUES
  ('1', '4');
  
INSERT INTO `cdweb2022`.`product_attribute` (`product_id`, `attribute_id`) VALUES
  ('1', '11'),
  ('1', '15'),
  ('1', '19'),
  ('1', '37');

INSERT INTO `cdweb2022`.`product_attribute` (`product_id`, `attribute_id`) VALUES
  ('2', '3'),
  ('2', '10'),
  ('2', '14'),
  ('2', '18'),
  ('2', '26');

INSERT INTO `cdweb2022`.`product_attribute` (`product_id`, `attribute_id`) VALUES
  ('3', '1'),
  ('3', '10'),
  ('3', '14'),
  ('3', '39'),
  ('3', '35');

INSERT INTO `cdweb2022`.`product_attribute` (`product_id`, `attribute_id`) VALUES
  ('4', '3'),
  ('4', '10'),
  ('4', '14'),
  ('4', '39'),
  ('4', '24');
  
INSERT INTO `cdweb2022`.`product_attribute` (`product_id`, `attribute_id`) VALUES
  ('5', '5'),
  ('5', '12'),
  ('5', '21'),
  ('5', '10'),
  ('5', '23');

INSERT INTO `cdweb2022`.`role` (`id`, `name`) VALUES ('1', 'client');
INSERT INTO `cdweb2022`.`role` (`id`, `name`) VALUES ('2', 'admin');

INSERT INTO `cdweb2022`.`user` (`id`, `password`, `status`, `username`) VALUES ('1', '123', '1', 'u1');
INSERT INTO `cdweb2022`.`user` (`id`, `password`, `status`, `username`) VALUES ('2', '123', '1', 'u2');

INSERT INTO `cdweb2022`.`user_role` (`user_id`, `role_id`) VALUES
  ('1', '1'),
  ('2', '2');

INSERT INTO `cdweb2022`.`address` (`id`, `city`, `fullname`, `user_id`) VALUES ('1', 'HCM', 'AN', '1');
INSERT INTO `cdweb2022`.`address` (`id`, `city`, `fullname`, `user_id`) VALUES ('2', 'HCM', 'Hải', '2');

INSERT INTO `cdweb2022`.`voucher` (`id`, `code`, `cost`, `ended_date`, `started_date`) VALUES ('1', 'aaa', '10000', '2022-05-03, 12:15:00', '2022-05-10, 12:15:00');

INSERT INTO `cdweb2022`.`bill` (`id`, `created_date`, `shipping_cost`, `status`, `total`, `updated_date`, `address_id`, `voucher_id`) VALUES ('1', '2022-05-03, 12:15:00', '40000', '1', '60000000', '2022-05-03, 12:15:00', '1', '1');

INSERT INTO `cdweb2022`.`order_detail` (`id`, `price`, `quantity`, `bill_id`, `product_id`) VALUES ('1', '25000000', '1', '1', '2');
