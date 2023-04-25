use cinema;

select * from phongchieu;

insert into hangghe(tenhangghe, idphong) values('h1', 5);
insert into hangghe(tenhangghe, idphong) values('h2', 5);
insert into hangghe(tenhangghe, idphong) values('h3', 5);
insert into hangghe(tenhangghe, idphong) values('h4', 5);
insert into hangghe(tenhangghe, idphong) values('h5', 5);

select * from hangghe;


DELIMITER $$
CREATE PROCEDURE insert_hangghe()
BEGIN
    DECLARE i INT DEFAULT 6;
    WHILE (i <= 56) DO
        INSERT INTO hangghe (tenhangghe, idphong) VALUES ('h1', i);
        INSERT INTO hangghe (tenhangghe, idphong) VALUES ('h2', i);
        INSERT INTO hangghe (tenhangghe, idphong) VALUES ('h3', i);
        INSERT INTO hangghe (tenhangghe, idphong) VALUES ('h4', i);
        INSERT INTO hangghe (tenhangghe, idphong) VALUES ('h5', i);
        SET i = i + 1;
    END WHILE;
END$$
DELIMITER ;

CALL insert_hangghe();

select * from hangghe;

DELIMITER $$
CREATE PROCEDURE insert_ghe()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE (i <= 280) DO
insert into ghe(tenghe,trangthai,idhangghe) values('1', 'trống',i );
insert into ghe(tenghe,trangthai,idhangghe) values('2', 'trống', i);
insert into ghe(tenghe,trangthai,idhangghe) values('3', 'trống', i);
insert into ghe(tenghe,trangthai,idhangghe) values('4', 'trống', i);
insert into ghe(tenghe,trangthai,idhangghe) values('5', 'trống', i);
insert into ghe(tenghe,trangthai,idhangghe) values('6', 'trống', i);
insert into ghe(tenghe,trangthai,idhangghe) values('7', 'trống', i);
insert into ghe(tenghe,trangthai,idhangghe) values('8', 'trống', i);
insert into ghe(tenghe,trangthai,idhangghe) values('9', 'trống', i);
insert into ghe(tenghe,trangthai,idhangghe) values('10', 'trống', i);
insert into ghe(tenghe,trangthai,idhangghe) values('11', 'trống', i);
insert into ghe(tenghe,trangthai,idhangghe) values('12', 'trống', i);
        SET i = i + 1;
    END WHILE;
END$$
DELIMITER ;
alter table danhgiaphim MODIFY COLUMN  danhgia text;
CALL insert_ghe();

select * from danhgiaphim;
delete  danhgiaphim
select * from phim;

insert into danhgiaphim(phim_danhgia,user_id,danhgia,tieude) values(1,1,'Thanh Gươm Diệt Quỷ / Demon Slayer / Kimetsu No Yaiba là một thương hiệu sở hữu nhiều thành tích vô tiền khoáng hậu trong lịch sử ngành anime và manga Nhật Bản. Khởi đầu tốt nhưng không quá xuất sắc, phiên bản hoạt hình trung thành nguyên tác đã giúp truyện tranh phá vỡ hàng loạt cột mốc xuất bản. Thậm chí, phim điện ảnh hoạt hình Demon Slayer: Kimetsu no Yaiba – The Movie: Mugen Train còn đang nắm giữ kỉ lục ăn khách nhất lịch sử phim chiếu rạp tại xứ sở mặt trời mọc với doanh thu 507 triệu $. Nhân vật chính Kamado Tanjiro vốn là một cậu bé nông thôn bình thường, chăm chỉ làm việc và giúp mẹ chăm sóc đàn em. Ngày nọ, biến cố ập tới, gia đình Tanjiro bị sát hại gần hết. Em gái Nezuko hóa quỷ. Căm hận chúa quỷ Muzan và mong muốn cứu chữa cho em, Tanjiro cố công rèn luyện thành kiếm sĩ  diệt quỷ, chiến đấu chống lại kẻ thù mạnh hơn mình gấp hàng trăm ngàn lần. Cõng Nezuko trong chiếc hộp gỗ, trên hành trình nhọc nhằn, cậu kết bạn với cậu bé nhát gan Zenitsu và đầu heo nóng nảy Inosuke. Ở tập phim điện ảnh trước – Mugen Train, Tanjiro và bạn bè đã lên Chuyến Tàu Vô Tận cùng Viêm Trụ Rengoku Kyoujuro. Cả bọn thành công tiêu diệt Hạ Huyền Nhất Enmu. Tuy nhiên, Thượng Huyền Tam Akaza đột ngột xuất hiện, Kyoujuro hi sinh. Sau khi dưỡng thương; Tanjiro, Zenitsu và Inosuke bị Âm Trụ Uzui Tengen đưa tới Phố đèn đỏ để giả làm kỹ nữ, điều tra về một con quỷ đang lẩn trốn nơi đây. Họ thành công tìm bắt ả Daki xảo trá nhưng lại rơi vào tình thế vô cùng khó khắn. Hóa ra Daki và người anh Gyutaro là quỷ Thượng Huyền hùng mạnh! Xem thêm tại: https://www.galaxycine.vn/binh-luan-phim/review-demon-slayer-to-the-swordsmith-village-phim-tri-an-man-nhanXem thêm tại: https://www.galaxycine.vn/binh-luan-phim/review-demon-slayer-to-the-swordsmith-village-phim-tri-an-man-nhan','review vui về phim, just for fun ^^');
insert into danhgiaphim(phim_danhgia,user_id,danhgia,tieude) values(1,2,'Ngay từ bản truyện tranh, Thanh Gươm Diệt Quỷ đã thu hút người xem bởi dàn nhân vật mỗi người một vẻ, mười phân vẹn mười. Đội diệt quỷ, Trụ Cột đến quỷ Thượng Hạ Huyền… mỗi kẻ mỗi câu chuyện riêng. Khán giả tha hồ lựa chọn danh sách yêu thích. Chưa mê Tanjiro nhân hậu thì có Zenitsu nhí nhố, chẳng thích Thủy Trụ ít nói thì có Viêm Trụ vui vẻ. Shinobu nghiêm túc, Mitsuri nhiệt tình hay Nezuko dễ thương dễ dàng “gom” cả fan nam lẫn nữ. Chưa kể, đám quỷ với tạo hình bắt mắt và tính cách độc đáo cũng góp phần nâng tầm tác phẩm. Khi những trang truyện lên màn ảnh, mọi thứ còn tuyệt hơn gấp bội! Điểm cộng đầu tiên ở anime Kimetsu No Yaiba là mặt hình ảnh. Một tràng pháo tay tặng hãng Ufotable!. Từ trang phục, bối cảnh, chiêu thức đánh nhau... không chê vào đâu được. Tác phẩm có nhiều trận chiến nên Ufotable đã cho ra đời hàng tá thước phim xáp lá cà cực kì mãn nhãn. Hơi thở của nước, hơi thở của lửa, hơi thở của dã thú… hoàn toàn làm hài lòng công chúng. Ngắm Hơi thở của sấm sét – Thức thứ nhất: Tích Lịch Nhất Thiểm trên màn ảnh rộng đủ khiến đa số khán giả cảm thấy thỏa mãn. Ngoài ra, khâu âm thanh cũng hấp dẫn. Nhạc nền và tiếng động lúc chiến đấu đều được chăm chút kĩ lưỡng, giúp người xem trải nghiệm tốt nhất. Xem thêm tại: https://www.galaxycine.vn/binh-luan-phim/review-demon-slayer-to-the-swordsmith-village-phim-tri-an-man-nhan

Xem thêm tại: https://www.galaxycine.vn/binh-luan-phim/review-demon-slayer-to-the-swordsmith-village-phim-tri-an-man-nhan','review vui về phim, just for fun ^^');
insert into danhgiaphim(phim_danhgia,user_id,danhgia,tieude) values(1,3,'Phim hoạt hình Thanh Gươm Diệt Quỷ bám sát nguyên tác. Hiếm nhân vật nào bị thêm thắt tình tiết dẫn đến sai lệch so với bản gốc truyện tranh. Chắc chắn khiến fan hài lòng tuyệt đối. Nhiều bộ truyện tranh nổi tiếng khi chuyển thể thành hoạt hình mắc lỗi này, làm nổ ra vô số cuộc tranh cãi bất tận. Có thể nhắc đến One Piece, Doraemon và Thám Tử Lừng Danh Conan. Kimetsu no Yaiba – To the Swordsmith Village là phần phim chiếu rạp nhằm tri ân người hâm mộ. Phim sẽ bao gồm 2 tập ở Phố Đèn Đỏ, 1 tập mở đầu nơi Làng Rèn Gươm và phần tất cả mong chờ – Cuộc họp của các Thượng Huyền tại Vô Hạn Thành. Lần đầu tiên trên màn ảnh; Kokushibo, Douma, Akaza, Hantengu, Gyokko hội tụ. Tất nhiên, không thể thiếu chúa quỷ Muzan!  Vô Hạn Thành chỉ được giới thiệu ít ỏi trên truyện tranh, nay bước ra màn ảnh rộng với một đẳng cấp khác. Chắc chắn, ngay cả fan khó tính nhất cũng hài lòng và mãn nhãn. Ngoài ra, Luyến Trụ Mitsuri và Hà Trụ Muichiro đồng thời lên hình, dù đất diễn chưa nhiều vẫn kịp khiến khán giả ấn tượng. Đặc biệt, câu thoại gây sốc ở nguyên tác của Mitsuri xuất hiện! Dẫu từng thưởng thức trận đánh ở Phố Đèn Đỏ, chắc chắn rằng, trải nghiệm Tengen cùng nhóm Tanjiro quyết đấu anh em Thượng Huyền Lục tại rạp chiếu phim đem lại cảm giác hoàn toàn khác.   Thanh Gươm Diệt Quỷ: Đường Tới Làng Rèn Gươm xứng đáng là phần phim dành tặng fan! Xem thêm tại: https://www.galaxycine.vn/binh-luan-phim/review-demon-slayer-to-the-swordsmith-village-phim-tri-an-man-nhan

Xem thêm tại: https://www.galaxycine.vn/binh-luan-phim/review-demon-slayer-to-the-swordsmith-village-phim-tri-an-man-nhan','review vui về phim, just for fun ^^');
insert into danhgiaphim(phim_danhgia,user_id,danhgia,tieude) values(2,1,'Nếu nghĩ Nhện nhí nhà Marvel hay gã phản anh hùng Deadpool là những tên siêu năng lực nói nhiều nhất vũ trụ phim siêu anh hùng thì bạn nhầm to rồi. Chàng Shazam có khi ồn ào bằng cả đôi Spiderpool cộng lại! Là cậu nhóc ăn chưa no và lo chưa tới, thậm chí còn chẳng biết mình sẽ học gì làm gì ở mốc 18 tuổi, Billy Baston trở thành chiến thần bảo vệ nhân loại. Ở đoạn kết phần trước, sau khi đánh bại gã tiến sĩ Sivana, cậu nhóc và các anh chị em nuôi đều sở hữu sức mạnh siêu phàm. Khổ nỗi, dù là siêu anh hùng nhưng thực chất đây vẫn là đám choai choai mười mấy tuổi. Hậu quả là, thay vì được vinh danh như Liên Minh Công Lý hay Hội Công lý, gia đình nhỏ bị gán cho danh hiệu Báo thủ Philadelphia! Chưa hết, trong khi “bầy báo” đang vật lộn cùng sự ngốc nghếch và tâm tình tuổi mới lớn, những cô con gái nhà Atlas tới tìm họ để đòi sức mạnh. À, nào phải đòi, họ tước đoạt! Vẫn do đạo diễn phần trước David F. Sanberg cầm trịch, phim mới Shazam! Fury Of The Gods tiếp tục sử dụng màu phim tươi sáng và theo phong cách vui nhộn, đặc biệt hẳn so với các tác phẩm khác thuộc vũ trụ điện ảnh DC mở rộng. Hàng loạt miếng hài cười lăn cười bò rải xuyên suốt phim, đến tận phút cuối của after credit.  Xem thêm tại: https://www.galaxycine.vn/binh-luan-phim/review-shazam-fury-of-the-gods-lon-xon-nhung-rat-nhon

Xem thêm tại: https://www.galaxycine.vn/binh-luan-phim/review-shazam-fury-of-the-gods-lon-xon-nhung-rat-nhon','review vui về phim, just for fun ^^');
insert into danhgiaphim(phim_danhgia,user_id,danhgia,tieude) values(2,2,'Vẫn do đạo diễn phần trước David F. Sanberg cầm trịch, phim mới Shazam! Fury Of The Gods tiếp tục sử dụng màu phim tươi sáng và theo phong cách vui nhộn, đặc biệt hẳn so với các tác phẩm khác thuộc vũ trụ điện ảnh DC mở rộng. Hàng loạt miếng hài cười lăn cười bò rải xuyên suốt phim, đến tận phút cuối của after credit.  Kịch bản Shazam! Fury Of The Gods đơn giản, dễ đoán và gần như không có pha bẻ lái ngoạn mục nào. Tuy vậy, đây lại là điểm cộng cho phim. Nhân vật chính chỉ là cậu thiếu niên bốc đồng, ngây thơ, chưa trải sự đời. Thực tế, với một kịch bản hổng-cần-não, Shazam! và Black Adam chiếm được cảm tình của kha khá khán giả. Doanh thu lần lượt là 366 triệu $ và 393 triệu $   Shazam! Fury Of The Gods thể hiện rõ ràng việc đề cao “gia đình”. Thậm chí, Shazam! còn nhắc tới bộ phim hành động Fast & Furious với câu thoại “Quan trọng là gia đình”. Đây vừa là trứng phục sinh vì người thủ vai Hespera - nữ diễn viên kì cựu Helen Mirren cũng tham gia Quá Nhanh Quá Nguy Hiểm. Kĩ xảo cộng điểm rất lớn cho Shazam! 2. Con rồng Ladon gây ấn tượng mạnh mẽ. Trường đoạn quái vật xuất hiện và quậy tưng bừng thành phố đủ sức làm khán giả ám ảnh. Thật đáng ngạc nhiên khi kinh phí vỏn vẹn 125 triệu $. Có lẽ thời gian hậu kì đủ lâu đã giúp Fury Of The Gods “khéo co thì ấm”. Người anh em Marvel nên học hỏi và để đội ngũ sản xuất VFX nhà mình thêm thời gian hoàn thiện. So với phần trước, Shazam! Sự Phẫn Nộ Của Các Vị Thần ít cảnh xáp lá cà bởi con gái Atlas chủ yếu xài phép thuật. Dẫu vậy, trận chiến giữa các chiến thần Shazam! và hội nữ thần vài ngàn tuổi cũng vô cùng hài hước. Nhất là đoạn đánh hội đồng Hespera. Xem thêm tại: https://www.galaxycine.vn/binh-luan-phim/review-shazam-fury-of-the-gods-lon-xon-nhung-rat-nhon

Xem thêm tại: https://www.galaxycine.vn/binh-luan-phim/review-shazam-fury-of-the-gods-lon-xon-nhung-rat-nhon','review vui về phim, just for fun ^^');
insert into danhgiaphim(phim_danhgia,user_id,danhgia,tieude) values(2,3,'Tuy vậy, sức nặng ấy ảnh hưởng lớn đến màn thể hiện của Rachel Zegler. Nàng Bạch Tuyết tương lai thủ vai cô em út. Nữ thần 6000 tuổi Anthea lép vế hẳn. Zegler mờ nhạt và non nớt, thua xa màn hóa thân thành María ở tác phẩm được đề cử Oscar – West Side Story. Dẫu vậy, lúc đứng một mình, ngôi sao nhỏ nhắn chỉ 1m57 này lại khiến khán giả mê đắm bởi vẻ đẹp trong trẻo và nụ cười ngọt ngào. Trẻ trung và có thực lực nhưng Zegler phải cố gắng rất nhiều nếu muốn “ngang tài ngang sức” Gal Gadot – người thủ vai hoàng hậu độc ác trong Snow White (2024). Trùng hợp làm sao, ở vũ trụ DC mở rộng, Gadot cũng góp mặt với vai diễn Wonder Woman. Hài hước, tươi sáng mà vẫn ấn tượng… Shazam! là thương hiệu phim anh hùng đặc biệt nhất nhì của nhà DC. Tuy nhiên, chẳng ai có thể khẳng định người hùng trẻ con này có còn tồn tại khi tương lai DCEU quá mơ hồ. Hi vọng sau ngày bộ phim chiếu rạp thay đổi cả DCEU - The Flash trình chiếu vào 06.2023, các đầu tàu DC Comic và Warner Bros sẽ cho người hâm mộ câu trả lời.    Xem thêm tại: https://www.galaxycine.vn/binh-luan-phim/review-shazam-fury-of-the-gods-lon-xon-nhung-rat-nhon

Xem thêm tại: https://www.galaxycine.vn/binh-luan-phim/review-shazam-fury-of-the-gods-lon-xon-nhung-rat-nhon','review vui về phim, just for fun ^^');
insert into danhgiaphim(phim_danhgia,user_id,danhgia,tieude) values(3,1,'Câu chuyện về gia đình người phụ nữ châu Á Evelyn Wang làm chấn động cả thế giới. Đưa khán giả trải nghiệm hàng loạt cung bậc cảm xúc khác nhau, đi từ bất ngờ này đến bất ngờ khác, mở ra đa vũ trụ hỗn loạn hơn cả “multiverse of madness” của Doctor Strange. Evelyn Wang (Dương Tử Quỳnh) là người phụ nữ trung niên gốc Trung sống tại Mỹ nhiều năm. Bà sở hữu cửa tiệm giặt ủi đang dần xuống cấp. Cơm áo gạo tiền dần khiến Evelyn ngày càng cáu bẳn. Ông chồng Waymond (Quan Kế Huy) nhu nhược, người cha (James Hong) dần lú lẫn, con gái Joy (Stephanie Hsu) chẳng sống chung. Năm mới đến gần, Evelyn nào có tâm trạng vui vẻ đón lễ, bà phải đau đầu tính toán các khoản thuế để “đấu trí” cùng nhân viên cục Deirdre (Jamie Lee Curtis). Một biến cố khiến mọi nhận thức về thế giới này của Evelyn thay đổi. Hóa ra có hàng triệu triệu Evelyn khác nhau đã đang và sẽ tồn tại. Bà chỉ là con kiến nhỏ giữa muôn vàn vũ trụ. Tất cả mọi thứ tưởng là quan trọng đều chẳng ý nghĩa gì! Bộ đôi Daniel Scheinert và Daniel Kwan thành công nên tác phẩm đa tầng, đa nghĩa nhưng lại diễn giải vô cùng dễ hiểu. Kịch bản chặt chẽ, logic và liên kết từng cảnh quay. Họ chứng tỏ bản thân đúng là cặp bài trùng xuất sắc khi cùng viết kịch bản và chỉ đạo Everything Everywhere All At Once! Nhịp nhàng, ăn khớp và hoàn hảo! Scheinert và Kwan gặp nhau khi học làm phim tại Cao đẳng Emerson. Từ năm 2011, cả hai cùng nhau đạo diễn nhiều MV ca nhạc trong đó có Turn Down For What nổi tiếng. Năm 2016, họ lấn sân sang mảng điện ảnh, cùng biên kịch và đạo diễn Swiss Army Man. Tuy tác phẩm hài kì ảo với sự tham gia của Daniel Radcliffe và Paul Dano không đạt doanh thu khả quan nhưng giúp Scheinert và Kwan giành giải đạo diễn tại liên hoan phim Sundance 2016. Đây là bệ phóng quan trọng giúp họ đạt Everything Everywhere All At Once chẳng phải tác phẩm kinh phí lớn. Thậm chí, đội ngũ VFX cả bộ phim chỉ vỏn vẹn chín người, bao gồm luôn cặp đôi đồng biên kịch – đạo diễn. Chỉ học miễn phí từ các lớp online, nhóm đã tạo nên siêu phẩm giành Oscar. Thật khó tin nhưng có thật! Xem thêm tại: https://www.galaxycine.vn/binh-luan-phim/review-everything-everywhere-all-at-once-phim-oscar-khong-he-kho-hieu

Xem thêm tại: https://www.galaxycine.vn/binh-luan-phim/review-everything-everywhere-all-at-once-phim-oscar-khong-he-kho-hieu','review vui về phim, just for fun ^^');
insert into danhgiaphim(phim_danhgia,user_id,danhgia,tieude) values(3,2,'Những gì mà Siêu Lừa Gặp Siêu Lầy đem tới không đơn thuần là những tràng cười sảng khoái, mà còn có sự cao thấp hơn thua khi các bộ não hoạt động tối đa công suất. Đi cùng đấy vẫn có khoảnh khắc lắng đọng về thân phận, cuộc đời và nỗi niềm của từng người. Dẫn đến thông điệp cuối cùng là tình đồng đội, tình bạn bè, sẵn sàng xả thân bên nhau lúc hoạn nạn và cùng chia niềm vui hạnh phúc nhất. Sau khi “lỡ hẹn” với khán giả vào dịp Tết Nguyên Đán, giờ đây phim mới nhất của đạo diễn Võ Thanh Hòa tiếp tục chứng minh tài năng của nhà làm phim dày dặn kinh nghiệm này với thể loại sở trường: hành động pha hài hước. Phim kể về sự đụng độ bất đắc dĩ giữa Tú (Anh Tú) và Khoa (Mạc Văn Khoa), hai người đều kiếm sống bằng nghề lừa gạt. Sau khi chứng kiến “đẳng cấp” của Tú và đồng bọn thì Khoa tìm cách để xin nhập hội. Từ đây nhóm siêu lừa với mỗi thành viên đều có biệt tài riêng bắt đầu con đường chinh chiến. Ngoại trừ Tú và Khoa làm lãnh đạo thì còn có bé Mã Lai (Ngọc Phước) – một chuyên gia công nghệ đầy bản lĩnh. Còn lại là chú Năm (Trung Lùn) – “người vận chuyển” với biệt tài lái xe siêu hạng. Sau nhiều lần “phạm tội” thành công, cả nhóm tiếp cận một “người bị hại” trông có vẻ đầy tiềm năng, mục đích là gom trọn vố lớn để sống thoải mái về sau. Tuy nhiên có thật sự lúc nào cũng dễ dàng đạt thành công như vậy? Nổi bật nhất khi xem Siêu Lừa Gặp Siêu Lầy chắc chắn là những tình tiết gây cười duyên dáng đầy thông minh. Nếu Mạc Văn Khoa chỉ cần đứng im cũng đủ làm người xem khó lòng”nhăn mặt”, thì đến Ngọc Phước và Trung Lùn chính thức khiến cả rạp chiếu phim náo loạn bởi những chiêu trò quá trời quá đất. Xem thêm tại: https://www.galaxycine.vn/binh-luan-phim/review-sieu-lua-gap-sieu-lay-phi-vu-hoan-hao-cua-dien-anh-viet
Xem thêm tại: https://www.galaxycine.vn/binh-luan-phim/review-sieu-lua-gap-sieu-lay-phi-vu-hoan-hao-cua-dien-anh-viet','review vui về phim, just for fun ^^');

select * from suatchieu;

insert into suatchieu(id,ngaychieu,thoigian, idphongchieu,idrap,idphim) values
(6314, '2022-04-04', '11:41', 51, 2, 1),
(6315, '2022-04-04', '05:23', 51, 2, 1),
(6316, '2022-04-04', '07:06', 51, 2, 1),
(6317, '2022-04-04', '06:58', 51, 2, 1),
(6318, '2022-08-19', '12:23', 51, 2, 1),
(6319, '2022-08-19', '05:15', 51, 2, 1),
(6320, '2022-08-19', '09:33', 51, 2, 1),
(6321, '2022-08-19', '12:08', 51, 2, 1),
(6322, '2022-10-11', '11:11', 51, 2, 1),
(6323, '2022-10-11', '11:36', 51, 2, 1),
(6324, '2022-10-11', '03:54', 51, 2, 1),
(6325, '2022-10-11', '06:44', 51, 2, 1),
(6326, '2022-04-20', '05:02', 52, 13, 1),
(6327, '2022-04-20', '07:50', 52, 13, 1),
(6328, '2022-04-20', '07:19', 52, 13, 1),
(6329, '2022-04-20', '10:15', 52, 13, 1),
(6330, '2022-12-31', '20:35', 52, 13, 1),
(6331, '2022-12-31', '02:11', 52, 13, 1),
(6332, '2022-12-31', '00:07', 52, 13, 1),
(6333, '2022-12-31', '13:54', 52, 13, 1),
(6334, '2022-01-18', '20:23', 52, 13, 1),
(6335, '2022-01-18', '14:15', 52, 13, 1),
(6336, '2022-01-18', '07:02', 52, 13, 1),
(6337, '2022-01-18', '09:09', 52, 13, 1),
(6338, '2022-01-02', '07:29', 52, 13, 1),
(6339, '2022-01-02', '06:08', 52, 13, 1),
(6340, '2022-01-02', '04:49', 52, 13, 1),
(6341, '2022-01-02', '07:41', 52, 13, 1),
(6342, '2022-10-30', '08:07', 52, 14, 1),
(6343, '2022-10-30', '23:08', 52, 14, 1),
(6344, '2022-10-30', '05:31', 52, 14, 1),
(6345, '2022-10-30', '22:38', 52, 14, 1),
(6346, '2022-01-31', '13:37', 52, 14, 1),
(6347, '2022-01-31', '08:11', 52, 14, 1),
(6348, '2022-01-31', '11:57', 52, 14, 1),
(6349, '2022-01-31', '13:36', 52, 14, 1),
(6350, '2022-10-31', '08:28', 52, 14, 1),
(6351, '2022-10-31', '09:55', 52, 14, 1),
(6352, '2022-10-31', '10:31', 52, 14, 1),
(6353, '2022-10-31', '06:05', 52, 14, 1),
(6354, '2022-05-31', '05:27', 52, 14, 1),
(6355, '2022-05-31', '05:03', 52, 14, 1),
(6356, '2022-05-31', '02:45', 52, 14, 1),
(6357, '2022-05-31', '08:08', 52, 14, 1),
(6358, '2022-05-30', '24:19', 8, 10, 1),
(6359, '2022-05-30', '05:01', 8, 10, 1),
(6360, '2022-05-30', '07:34', 8, 10, 1),
(6361, '2022-05-30', '00:26', 8, 10, 1),
(6362, '2022-03-07', '08:17', 8, 10, 1),
(6363, '2022-03-07', '14:11', 8, 10, 1),
(6364, '2022-03-07', '08:53', 8, 10, 1),
(6365, '2022-03-07', '05:33', 8, 10, 1),
(6370, '2022-12-05', '12:36', 8, 10, 1),
(6375, '2022-12-16', '05:19', 8, 2, 1),
(6376, '2022-12-16', '07:33', 8, 2, 1),
(6377, '2022-12-16', '03:54', 8, 2, 1),
(6378, '2022-07-29', '04:38', 8, 2, 1),
(6379, '2022-07-29', '07:21', 8, 2, 1),
(6380, '2022-07-29', '02:36', 8, 2, 1),
(6381, '2022-07-29', '10:00', 8, 2, 1),
(6382, '2022-10-06', '08:10', 8, 2, 1),
(6383, '2022-10-06', '08:11', 8, 2, 1),
(6384, '2022-10-06', '04:30', 8, 2, 1),
(6385, '2022-10-06', '09:02', 8, 2, 1),
(6386, '2022-12-13', '08:23', 8, 2, 1),
(6387, '2022-12-13', '04:59', 8, 2, 1),
(6388, '2022-12-13', '14:49', 8, 2, 1),
(6389, '2022-12-13', '08:10', 8, 2, 1);

update  phim set rating = 5
select * from phim;

select * from tinhthanh
select * from rap


ALTER TABLE ve
DROP COLUMN ngaychieu;

ALTER TABLE thanhtoan
DROP COLUMN giave;

ALTER TABLE ve
DROP COLUMN iduser;




select * from ve;

insert into ve(tenve,noidung,giave) values('Người Lớn - member - 2D', 'Vé 2D áp dụng cho khách hàng thành viên', 70000);
insert into ve(tenve,noidung,giave) values('Người Lớn - member - 3D', 'Vé 3D áp dụng cho khách hàng thành viên', 70000);
insert into ve(tenve,noidung,giave) values('Ghế Đôi', 'Vé Đôi Bao Gồm 2 vé', 150000);

select * from food;
insert into food(namefood, noidung, gia)
values('iCombo 1 Big STD', '1 Ly nước ngọt size L + 01 Hộp bắp + 1 Snack', 450000);

insert into food(namefood, noidung, gia)
values('iCombo 2 Big STD', '2 Ly nước ngọt size L + 01 Hộp bắp + 2 Snack', 500000);

insert into food(namefood, noidung, gia)
values('iCombo 3 Big STD', '2 Ly nước ngọt size L + 02 Hộp bắp + 3 Snack', 550000);

select * from suatchieu where id = 5782

select * from phongchieu where id = 13

select count(*) from suatchieu where idphim = 1 and idrap = 14

select * from thanhtoan
select * from user


CREATE TRIGGER occupy_trig AFTER INSERT ON thanhtoan 
FOR EACH ROW
  UPDATE user
     SET diemtich = diemtich+1
   WHERE id = NEW.iduser


select * from danhgiaphim where phim_danhgia = 1

  
select * from user where id = 3

select * from user

select * from phim

DELIMITER $$
CREATE TRIGGER `insert_phongchieu` AFTER INSERT ON `rap`
FOR EACH ROW
BEGIN
    INSERT INTO `phongchieu` (`tenphong`, `idrap`, `trangthai`)
    VALUES ('Phòng 1', NEW.id, 'hoạt động'),
           ('Phòng 2', NEW.id, 'hoạt động'),
           ('Phòng 3', NEW.id, 'hoạt động'),
           ('Phòng 4', NEW.id, 'hoạt động'),
           ('Phòng 5', NEW.id, 'hoạt động');
END;$$
DELIMITER ;

select * from hangghe


DELIMITER $$
CREATE TRIGGER `insert_hangghe` AFTER INSERT ON `phongchieu`
FOR EACH ROW
BEGIN
    INSERT INTO `hangghe` (`tenhangghe`, `idphong`)
    VALUES ('H1', NEW.id),
           ('H2', NEW.id),
           ('H3', NEW.id),
           ('H4', NEW.id),
           ('H5', NEW.id);
END;$$
DELIMITER ;

select * from ghe

DELIMITER $$
CREATE TRIGGER `insert_ghe` AFTER INSERT ON `hangghe`
FOR EACH ROW
BEGIN
    INSERT INTO `ghe` (`tenghe`,`trangthai`, `idhangghe`)
    VALUES ('G1', 'trống' ,NEW.id),
           ('G2','trống' ,NEW.id),
           ('G3', 'trống',NEW.id),
           ('G4','trống' ,NEW.id),
           ('G5', 'trống',NEW.id),
           ('G6','trống' ,NEW.id),
           ('G7','trống' ,NEW.id),
           ('G8','trống' ,NEW.id),
           ('G9', 'trống',NEW.id);
END;$$
DELIMITER ;

update suatchieu set info = 'sắp chiếu'


	







