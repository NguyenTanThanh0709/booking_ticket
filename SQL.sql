create database cinema;

use cinema;

CREATE TABLE `roles` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `role_name` varchar(50) not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `user` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `user` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `sdt` int(11) NOT NULL,
  `pass` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `user_roles` (
	`id` bigint PRIMARY KEY AUTO_INCREMENT,
    `id_user` bigint ,
    `id_roles` bigint ,
    FOREIGN KEY (`id_user`) REFERENCES `user`(`id`),
	FOREIGN KEY (`id_roles`) REFERENCES `roles`(`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `khuyenmai` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `tenkhuyenmai` text NOT NULL,
  `img` varchar(254) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `nhaxuatban` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `tennhaxuatban` varchar(254) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `phim` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `tenphim` varchar(254) NOT NULL,
  `tuoi` int(11) NOT NULL,
  `theloai` varchar(254) NOT NULL,
  `quocgia` varchar(254) NOT NULL,
  `dienvien` varchar(254) NOT NULL,
  `daodien` varchar(254) NOT NULL,
  `ngaychieu` varchar(254) NOT NULL,
  `rating` int(11) NOT NULL,
  `thoiluong` int(11) NOT NULL,
  `noidung` text NOT NULL,
  `trangthai` varchar(50) check (`trangthai` in ('1', '0')),
  `banner` varchar(254) NOT NULL,
  `anhphim` varchar(254) NOT NULL,
  `trailer` varchar(254) NOT NULL,
  `idnxb` bigint,
  FOREIGN KEY (`idnxb`) REFERENCES `nhaxuatban`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `danhgiaphim` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `id_user` bigint,
  `danhgia` text NOT NULL,
  `id_phim` bigint,
	FOREIGN KEY (`id_user`) REFERENCES `user`(`id`),
	FOREIGN KEY (`id_phim`) REFERENCES `phim`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `tinhthanh` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `tentinhthanh` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `rap` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `tenrap` varchar(50) NOT NULL,
  `diachi` varchar(50) NOT NULL,
  `idtinhthanh` bigint,
  FOREIGN KEY (`idtinhthanh`) REFERENCES `tinhthanh`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `phongchieu` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `tenphong` varchar(50) NOT NULL,
  `idrap` bigint,
  `trangthai` varchar(50) check (`trangthai` in ('1', '0')),
  FOREIGN KEY (`idrap`) REFERENCES `rap`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `hangghe` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `tenhangghe` varchar(50) NOT NULL,
  `idphong` bigint,
  FOREIGN KEY (`idphong`) REFERENCES `phongchieu`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `ghe` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `trangthai` varchar(50) check (`trangthai` in ('1', '0')),
  `tenghe` int(11) DEFAULT NULL,
  `idhangghe` bigint,
  `idphong` bigint,
  FOREIGN KEY (`idphong`) REFERENCES `phongchieu`(`id`),
  FOREIGN KEY (`idhangghe`) REFERENCES `hangghe`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `phim_rap` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `idphim` bigint,
  `idrap` bigint,
  FOREIGN KEY (`idphim`) REFERENCES `phim`(`id`),
  FOREIGN KEY (`idrap`) REFERENCES `rap`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `suatchieu` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `ngaychieu` varchar(50),
  `info` varchar(254),
  `thoigian` varchar(50) NOT NULL,
  `idrap` bigint,
  `idphongchieu` bigint,
  `idphim` bigint,
  FOREIGN KEY (`idrap`) REFERENCES `rap`(`id`),
  FOREIGN KEY (`idphongchieu`) REFERENCES `phongchieu`(`id`),
  FOREIGN KEY (`idphim`) REFERENCES `phim`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `thanhvien` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `diemtich` int default 0,
  `ngayvaothanhvieb` varchar(50),
  `id_user` bigint,
  FOREIGN KEY (`id_user`) REFERENCES `user`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `ve` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `tenphim` text DEFAULT NULL,
  `tenrap` varchar(50) DEFAULT NULL,
  `tenphongchieu` varchar(50) DEFAULT NULL,
  `ngaychieu` varchar(50) DEFAULT NULL,
  `suatchieu` varchar(50) DEFAULT NULL,
  `ghe` varchar(50) DEFAULT NULL,
  `iduser` bigint,
  FOREIGN KEY (`iduser`) REFERENCES `user`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `thanhtoan` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `phim` varchar(50) DEFAULT NULL,
  `rap` varchar(50) DEFAULT NULL,
  `suatchieu` varchar(50) DEFAULT NULL,
  `phongchieu` varchar(50) DEFAULT NULL,
  `ghe` varchar(50) DEFAULT NULL,
  `giave` varchar(50) DEFAULT NULL,
  `idphim` bigint,
  `idrap` bigint,
  `idsuatchieu` bigint,
  `idphongchieu` bigint,
  `idghe` bigint,
  `iduser` bigint,
  FOREIGN KEY (`idphim`) REFERENCES `phim`(`id`),
  FOREIGN KEY (`idrap`) REFERENCES `rap`(`id`),
  FOREIGN KEY (`idsuatchieu`) REFERENCES `suatchieu`(`id`),
  FOREIGN KEY (`idphongchieu`) REFERENCES `phongchieu`(`id`),
  FOREIGN KEY (`idghe`) REFERENCES `ghe`(`id`),
  FOREIGN KEY (`iduser`) REFERENCES `user`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;









