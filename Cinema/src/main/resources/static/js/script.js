const body = $("body"),
    sidebar = $(".my-sidebar"),
    toggle = $(".toggle"),
    searchBox = $(".search-box"),
    modeSwitch = $(".toggle-switch"),
    modeText = $(".mode-text");
$(window).scroll(() => {
    if (!sidebar.hasClass("close")) sidebar.toggleClass("close");
});
toggle.click(() => sidebar.toggleClass("close"));
modeSwitch.click(() => {
    body.toggleClass("dark");
    if (body.hasClass("dark")) {
        modeText.text("Light Mode");
    } else {
        modeText.text("Dark Mode");
    }
});
$("#search-icon").click(() => {
    if (sidebar.hasClass("close")) {
        sidebar.toggleClass("close");
        $("#search-input").focus();
    }
});
$("input").attr("spellcheck", false);
const trig = $(".my-nav-bottom-link").toArray(); // Lay tat ca the nav
let lastClickElement = trig[0]; // Biến lưu lại phần tử vừa click, mặc định là trang home. Tối ưu thay vì dùng loop để duyệt và tìm
let preClickElement = trig[0]; // Biến lưu lại phần tử vừa click, mặc định là trang home. Tối ưu thay vì dùng loop để duyệt và tìm
// Gan su kien click cho cac the
trig.forEach((element) => {
    $(element).on("click", () => {
        // Xử lý trường hợp khi đang ở setting nhưng click vào setting một lần nữa thì mặc định trả lại trạng thái active ở trang hiện tại
        if (
            element === lastClickElement &&
            $(element).hasClass("has-sub-menu")
        ) {
            $(preClickElement).addClass("active");
            $(element).toggleClass("active");
            lastClickElement = preClickElement;
            return;
        }
        $(lastClickElement).removeClass("active"); // Xóa trạng thái active của thẻ đã click trước đó
        console.log("last", $(lastClickElement));
        if ($(element).hasClass("has-sub-menu")) {
            $(element).addClass("active");
        } else {
            if (!$(element).hasClass("active")) {
                $(element).addClass("active");
            }
        }
        preClickElement = lastClickElement;
        lastClickElement = element; // Ghi lại thẻ vừa click để xóa
    });
});

function showModal() {
        $('#myModal').modal('show');
}

// Xử lý active loại phim
let typeFilm = $(".button-type-film").toArray();
let typeClick = $("#all-film"); // Mặc định ban đầu là tất cả film
typeFilm.forEach((element) => {
    $(element).click(() => {
        typeClick.removeClass("active"); // Xóa trạng thái active
        $(element).addClass("active"); // Thêm trạng thái active
        typeClick = $(element); // Lưu lại button vừa click
    });
});

let slides = $(".slider > .card").toArray();
let widthCard = parseFloat($(".slider > .card").css("width"));
let marginCard = parseFloat(
    $(".slider > .card").first().next().css("margin-left")
); // Lấy margin left của thẻ thứ 2 vì thẻ thứ 1 đã margin-left 0
// console.log(parseFloat(widthCard), marginCard);
let numberOfSlides = slides.length;
let initialIndex = 0;

function prevSlide() {
    initialIndex = initialIndex - 1 < 0 ? numberOfSlides - 1 : initialIndex - 1;
    $(".slider").css({
        transform: `translate3d(${
            -initialIndex * (widthCard + marginCard)
        }px, 0px, 0px)`,
    });
}
function nextSlide() {
    initialIndex = initialIndex + 1 == numberOfSlides ? 0 : initialIndex + 1;
    $(".slider").css({
        transform: `translate3d(${
            -initialIndex * (widthCard + marginCard)
        }px, 0px, 0px)`,
    });
}
$("#pre-btn-slider").click(() => prevSlide());
$("#next-btn-slider").click(() => nextSlide());

// Auto chuyển slide
setInterval(() => {
    nextSlide();
}, 3000);
var count  = 0
const seats = document.querySelectorAll('.seat');
seats.forEach((seat) => {
seat.addEventListener('click', () => {








if(seat.classList.contains('selected')){
seat.classList.add('empty');
seat.classList.remove('selected');
count = count - 1;
document.querySelector("#thanhtoan_tenghe").innerHTML = "";
document.querySelector("#thanhtoan_maghe").innerHTML = "";
document.querySelector("#thanhtoan_tenhang").innerHTML = "";
document.querySelector("#thanhtoan_mahang").innerHTML = "";
return;
}
if(count >= document.querySelector("#thanhtoan_soluongve").innerHTML){
    alert("Không được chọn quá số ghế!");
    return;
}

    if (seat.classList.contains('sold')) {
        try {
                seat.classList.remove("empty");
                seat.classList.remove("selected");
            } catch (e){
                console.log(e.message);
            }
          return;
        }

//    if (!seat.classList.contains('empty')) {
//      return;
//    }

const idghe = seat.getAttribute("data-ghe_id");
const parent = seat.parentElement
const idhang = parent.getAttribute("data-hang_id");
console.log(idghe);
document.querySelector("#thanhtoan_tenghe").innerHTML = idghe;
document.querySelector("#thanhtoan_maghe").innerHTML = idghe;
console.log(idhang);
document.querySelector("#thanhtoan_tenhang").innerHTML = idhang;
document.querySelector("#thanhtoan_mahang").innerHTML = idhang;

    // Đổi màu ghế đã chọn
    seat.classList.toggle('selected');
    count = count + 1;
    try{
    seat.classList.remove("empty");
        seat.classList.remove("sold");
    }catch (e){
    console.log(e.message);
    }
  });
});

$("#clickbuttonfoodandve").click(() => {

if(parseInt(document.querySelector("#tongienthanhtoan_ve").innerHTML) == 0){
    alert("VUI LÒNG ĐẶT VÉ!")
    return;
}

$("#foodandve").addClass("d-none");
$("#thanhtoan").addClass("d-none");
$("#ghe").removeClass("d-none");


$("#buttonfoodandve").addClass("d-none");
$("#buttonghe").removeClass("d-none");
});

//============================

$("#clickqualaifood").click(() => {

$("#foodandve").removeClass("d-none");
$("#thanhtoan").addClass("d-none");
$("#ghe").addClass("d-none");


$("#buttonfoodandve").removeClass("d-none");
$("#buttonghe").addClass("d-none");
});

//============================
$("#clickghe").click(() => {

const matches = document.querySelectorAll(".selected");
console.log(matches);

if(document.querySelector("#thanhtoan_soluongve").innerHTML != matches.length){
    alert("Chọn Chưa đủ vé!");
    return;
}


$("#foodandve").addClass("d-none");
$("#ghe").addClass("d-none");
$("#thanhtoan").removeClass("d-none");


$("#buttonfoodandve").addClass("d-none");
$("#buttonghe").addClass("d-none");
});
//=====================================
$("#clickquaylaithanhtoan").click(() => {

$("#foodandve").addClass("d-none");
$("#ghe").removeClass("d-none");
$("#thanhtoan").addClass("d-none");


$("#buttonfoodandve").addClass("d-none");
$("#buttonghe").removeClass("d-none");
});


// =====================================loadRap(5)
function loadRap(idphim){
$.ajax({
		        url: '/api/user/rap/' + idphim ,
		        type : "GET", //send it through get method
				dataType : 'json',
		        success: function (data) {
		        $("#muaveListRap").html("");
		        $("#muavesuatchieu").html("");
		        	alert("success!");
		        	console.log(data);
                    const parent = document.querySelector('#muaveListRap');



		        	data.forEach((element) => {
                      const li = document.createElement('li');
                                          li.classList.add('list-group-item', 'd-flex', 'justify-content-between', 'align-items-center', 'muaveflim');
                                    li.setAttribute("data-phim", idphim);
                                    const idrap = element.id;
                                    li.setAttribute("data-rap", idrap);
                                          const span1 = document.createElement('span');
                                          span1.classList.add('fw-bold', 'text-danger');
                                          span1.textContent = element.tenRap;
                                          li.appendChild(span1);
                                          const span2 = document.createElement('span');
                                          span2.textContent = element.diaChi;
                                          li.appendChild(span2);
                                      parent.appendChild(li);


                        li.addEventListener('click', function() {
                          const  idphim = this.getAttribute("data-phim");
                          const  idrap = this.getAttribute("data-rap");
                          console.log(idphim);
                          console.log(idrap);
                          $.ajax({
                          		        url: '/api/user/suatchieu?idphim=' + idphim + "&idrap=" + idrap,
                          		        type : "GET", //send it through get method
                          				dataType : 'json',
                          		        success: function (data1) {
                          		        	alert("success!");

                          		        	console.log(data1);
                          		        	$("#muavesuatchieu").html("");
                                            const parent1 = document.querySelector('#muavesuatchieu');
                          		        	data1.forEach((element) => {

                          		        	    if(element.info == "sắp chiếu"){



                          		        	    const li = document.createElement("li");
                                                li.classList.add("list-group-item", "muaveflim", "d-flex", "flex-column", "justify-content-between", "align-items-center");
                                                const div1 = document.createElement("div");
                                                div1.textContent = element.ngayChieu;
                                                li.appendChild(div1);

                                                const div2 = document.createElement("div");
                                                div2.classList.add("d-flex", "flex-column", "justify-content-between", "align-items-center");

                                                const p1 = document.createElement("p");
                                                p1.textContent = "2D phụ đề";
                                                div2.appendChild(p1);

                                                const p3 = document.createElement("p");
                                                p3.textContent = "Giờ: " +  element.thoiGian;
                                                div2.appendChild(p3);

                                                const a = document.createElement("a");
                                                a.classList.add("btn", "btn-success");
                                                a.textContent = "mua vé";
                                                const href = "/foodBill/" + element.id;
                                                a.setAttribute("href", href);
                                                div2.appendChild(a);

                                                li.appendChild(div2);
                                                parent1.appendChild(li);

                                                }


                                            });



                          		        },
                          		        error: function (error) {
                          		        	alert("err!");
                          		        }
                          		    });



                        });


                    })
		        },
		        error: function (error) {
		        	alert("err!");
		        }
		    });
}
function onchangeTinh(this_){
        var selectedOption = this_.value;
        console.log(selectedOption);
        const filmId = document.getElementById("data-film_id").getAttribute("data-film_id");
        console.log(filmId);


        $.ajax({
        		        url: '/api/user/suatchieutinh?idphim=' + filmId + "&idtinh=" + selectedOption,
        		        type : "GET", //send it through get method
        				dataType : 'json',
        		        success: function (data) {
        		        	alert("success!");
        		        	$("#lichchieudetailfilm").html("");
        		        	const parent1 = document.querySelector('#lichchieudetailfilm');
        		        	data.forEach((element) => {
        		        	    const divDetailGroupCinema = document.createElement("div");
                                divDetailGroupCinema.className = "detail-group-cinema ng-scope margin-40";

                                const divTitleCinema = document.createElement("div");
                                divTitleCinema.className = "title-cinema";

                                const h5 = document.createElement("h5");
                                h5.className = "ng-binding";
                                h5.innerText = "Galaxy";

                                const divItemCinema = document.createElement("div");
                                  divItemCinema.className = "item-cinema";
                                  divItemCinema.style = "  ";

                                  const labelNgayChieu = document.createElement("label");
                                    labelNgayChieu.style = "   margin-right: 70px;";
                                    labelNgayChieu.innerHTML = `<b>Ngày Chiếu:</b> ${element.ngayChieu}`;

//                                    const labelPhongChieu = document.createElement("label");
//                                      labelPhongChieu.style = "   margin-right: 70px;";
//                                      labelPhongChieu.innerHTML = `<b>Phòng Chiếu:</b> ${element.phongChieu_suatchieu.tenPhong}`;

                                      const labelGioChieu = document.createElement("label");
                                        labelGioChieu.style = "   margin-right: 70px;";
                                        labelGioChieu.innerHTML = `<b>Giờ Chiếu:</b> ${element.thoiGian}`;

//                                        const labelLoaiPhim = document.createElement("label");
//                                          labelLoaiPhim.style = " color:red;  margin-right: 70px;";
//                                          labelLoaiPhim.innerText = `${element.phim_suatChieu.loaiphim}`;

                                          const aMuaVe = document.createElement("a");
                                            aMuaVe.className = "mt-2 btn btn-success";
                                            aMuaVe.href = `/foodBill/${element.id}`;
                                            aMuaVe.innerText = "mua vé";

                                            divTitleCinema.appendChild(h5);
                                              divItemCinema.appendChild(labelNgayChieu);
                                              //divItemCinema.appendChild(labelPhongChieu);
                                              divItemCinema.appendChild(labelGioChieu);
                                              //divItemCinema.appendChild(labelLoaiPhim);
                                              divItemCinema.appendChild(aMuaVe);

                                              divDetailGroupCinema.appendChild(divTitleCinema);
                                                divDetailGroupCinema.appendChild(divItemCinema);

                                                parent1.appendChild(divDetailGroupCinema);

        		        	});
        		        	console.log(data);
        		        },
        		        error: function (error) {
        		        	alert("err!");
        		        }
        		    });

}
function getDateValue(this_){
    const dateInput = document.getElementById("myDateInput");
  const selectedDate = dateInput.value;
  console.log(selectedDate);
  const filmId = document.getElementById("data-film_id").getAttribute("data-film_id");

  $.ajax({
          		        url: '/api/user/suatchieungay?idphim=' + filmId + "&ngay=" + selectedDate,
          		        type : "GET", //send it through get method
          				dataType : 'json',
          		        success: function (data) {
          		        	alert("success!");
          		        	$("#lichchieudetailfilm").html("");
          		        	const parent1 = document.querySelector('#lichchieudetailfilm');
          		        	data.forEach((element) => {
          		        	    const divDetailGroupCinema = document.createElement("div");
                                  divDetailGroupCinema.className = "detail-group-cinema ng-scope margin-40";

                                  const divTitleCinema = document.createElement("div");
                                  divTitleCinema.className = "title-cinema";

                                  const h5 = document.createElement("h5");
                                  h5.className = "ng-binding";
                                  h5.innerText = "Galaxy";

                                  const divItemCinema = document.createElement("div");
                                    divItemCinema.className = "item-cinema";
                                    divItemCinema.style = "  ";

                                    const labelNgayChieu = document.createElement("label");
                                      labelNgayChieu.style = "   margin-right: 70px;";
                                      labelNgayChieu.innerHTML = `<b>Ngày Chiếu:</b> ${element.ngayChieu}`;

  //                                    const labelPhongChieu = document.createElement("label");
  //                                      labelPhongChieu.style = "   margin-right: 70px;";
  //                                      labelPhongChieu.innerHTML = `<b>Phòng Chiếu:</b> ${element.phongChieu_suatchieu.tenPhong}`;

                                        const labelGioChieu = document.createElement("label");
                                          labelGioChieu.style = "   margin-right: 70px;";
                                          labelGioChieu.innerHTML = `<b>Giờ Chiếu:</b> ${element.thoiGian}`;

  //                                        const labelLoaiPhim = document.createElement("label");
  //                                          labelLoaiPhim.style = " color:red;  margin-right: 70px;";
  //                                          labelLoaiPhim.innerText = `${element.phim_suatChieu.loaiphim}`;

                                            const aMuaVe = document.createElement("a");
                                              aMuaVe.className = "mt-2 btn btn-success";
                                              aMuaVe.href = `/foodBill/${element.id}`;
                                              aMuaVe.innerText = "mua vé";

                                              divTitleCinema.appendChild(h5);
                                                divItemCinema.appendChild(labelNgayChieu);
                                                //divItemCinema.appendChild(labelPhongChieu);
                                                divItemCinema.appendChild(labelGioChieu);
                                                //divItemCinema.appendChild(labelLoaiPhim);
                                                divItemCinema.appendChild(aMuaVe);

                                                divDetailGroupCinema.appendChild(divTitleCinema);
                                                  divDetailGroupCinema.appendChild(divItemCinema);

                                                  parent1.appendChild(divDetailGroupCinema);

          		        	});
          		        	console.log(data);
          		        },
          		        error: function (error) {
          		        	alert("err!");
          		        }
          		    });



}
function onchangeRap(this_){
    var selectedOption = this_.value;
    console.log(selectedOption);
    const filmId = document.getElementById("data-film_id").getAttribute("data-film_id");

    $.ajax({
              		        url: '/api/user/suatchieuRap?idphim=' + filmId + "&idrap=" + selectedOption,
              		        type : "GET", //send it through get method
              				dataType : 'json',
              		        success: function (data) {
              		        	alert("success!");
              		        	$("#lichchieudetailfilm").html("");
              		        	const parent1 = document.querySelector('#lichchieudetailfilm');
              		        	data.forEach((element) => {
              		        	    const divDetailGroupCinema = document.createElement("div");
                                      divDetailGroupCinema.className = "detail-group-cinema ng-scope margin-40";

                                      const divTitleCinema = document.createElement("div");
                                      divTitleCinema.className = "title-cinema";

                                      const h5 = document.createElement("h5");
                                      h5.className = "ng-binding";
                                      h5.innerText = "Galaxy";

                                      const divItemCinema = document.createElement("div");
                                        divItemCinema.className = "item-cinema";
                                        divItemCinema.style = "  ";

                                        const labelNgayChieu = document.createElement("label");
                                          labelNgayChieu.style = "   margin-right: 70px;";
                                          labelNgayChieu.innerHTML = `<b>Ngày Chiếu:</b> ${element.ngayChieu}`;

      //                                    const labelPhongChieu = document.createElement("label");
      //                                      labelPhongChieu.style = "   margin-right: 70px;";
      //                                      labelPhongChieu.innerHTML = `<b>Phòng Chiếu:</b> ${element.phongChieu_suatchieu.tenPhong}`;

                                            const labelGioChieu = document.createElement("label");
                                              labelGioChieu.style = "   margin-right: 70px;";
                                              labelGioChieu.innerHTML = `<b>Giờ Chiếu:</b> ${element.thoiGian}`;

      //                                        const labelLoaiPhim = document.createElement("label");
      //                                          labelLoaiPhim.style = " color:red;  margin-right: 70px;";
      //                                          labelLoaiPhim.innerText = `${element.phim_suatChieu.loaiphim}`;

                                                const aMuaVe = document.createElement("a");
                                                  aMuaVe.className = "mt-2 btn btn-success";
                                                  aMuaVe.href = `/foodBill/${element.id}`;
                                                  aMuaVe.innerText = "mua vé";

                                                  divTitleCinema.appendChild(h5);
                                                    divItemCinema.appendChild(labelNgayChieu);
                                                    //divItemCinema.appendChild(labelPhongChieu);
                                                    divItemCinema.appendChild(labelGioChieu);
                                                    //divItemCinema.appendChild(labelLoaiPhim);
                                                    divItemCinema.appendChild(aMuaVe);

                                                    divDetailGroupCinema.appendChild(divTitleCinema);
                                                      divDetailGroupCinema.appendChild(divItemCinema);

                                                      parent1.appendChild(divDetailGroupCinema);

              		        	});
              		        	console.log(data);
              		        },
              		        error: function (error) {
              		        	alert("err!");
              		        }
              		    });
}
function chooseVe(this_){



    const soluong = this_.value;
    document.querySelector("#thanhtoan_soluongve").innerHTML  = soluong;
    //console.log(soluong);
    const idve = this_.getAttribute("data-ve_id");
    //console.log(idve);
    document.querySelector("#thanhtoan_mave").innerHTML  = idve;

    const tempgia = this_.parentElement.parentElement.parentElement.nextElementSibling;
        const spanElementgia = tempgia.querySelector('span');
            const spanTextgia = spanElementgia.textContent;
            //console.log(spanTextgia);
    const temp = this_.parentElement.parentElement.parentElement.nextElementSibling.nextElementSibling;
    const spanElement = temp.querySelector('span');
    const spanText = spanElement.textContent;
    const tong = soluong*spanTextgia;
    spanElement.textContent = tong;
    //console.log(spanText);

    document.querySelector("#tongienthanhtoan_ve").innerHTML = tong;
document.querySelector("#thhanhtoan_tongtien").innerHTML = parseInt(tong) + parseInt(document.querySelector("#tongtienthanhtoan_food").innerHTML);



// ================ set name
        const temp1 = this_.parentElement.parentElement.parentElement.previousElementSibling.firstElementChild.innerHTML;
document.querySelector("#thanhtoan_tenve").innerHTML  = temp1;
        console.log(temp1);


}
function chooseFood(this_){


    const soluong = this_.value;
document.querySelector("#thanhtoan_soluongmonan").innerHTML  = soluong;
    const idfood = this_.getAttribute("data-food_id");
    document.querySelector("#thanhtoan_mafood").innerHTML  = idfood;

    const tempgia = this_.parentElement.parentElement.parentElement.nextElementSibling;
            const spanElementgia = tempgia.querySelector('span');
                const spanTextgia = spanElementgia.textContent;
                console.log(spanTextgia);


                const temp = this_.parentElement.parentElement.parentElement.nextElementSibling.nextElementSibling;
                    const spanElement = temp.querySelector('span');
                    const spanText = spanElement.textContent;
                    const tong = soluong*spanTextgia;
                    spanElement.textContent = tong;
                    console.log(spanText);
document.querySelector("#tongtienthanhtoan_food").innerHTML = tong;


document.querySelector("#thhanhtoan_tongtien").innerHTML = parseInt(tong) + parseInt(document.querySelector("#tongienthanhtoan_ve").innerHTML);

// ==========================
const temp1 = this_.parentElement.parentElement.parentElement.previousElementSibling.lastElementChild.lastElementChild.innerHTML;
document.querySelector("#thanhtoan_tenmonan").innerHTML  = temp1;
        console.log(temp1);

}

$("#savethanhtoan").click(() => {


const idSuatchieu = document.querySelector("#thanhtoan_idsuatchieu").innerHTML;
const idFood = document.querySelector("#thanhtoan_mafood").innerHTML;
const soluongfood = document.querySelector("#thanhtoan_soluongmonan").innerHTML;
const idVe = document.querySelector("#thanhtoan_mave").innerHTML;
const tongtien = document.querySelector("#thhanhtoan_tongtien").innerHTML;
var idGhe = []

const listghe = document.querySelectorAll(".selected");
var div_array = [...listghe]; // converts NodeList to Array
div_array.forEach(element => {

    idGhe.push(element.getAttribute("data-ghe_id"));
});

const currentDate = new Date();
const year = currentDate.getFullYear();
const month = String(currentDate.getMonth() + 1).padStart(2, '0'); // Adding 1 because getMonth() returns month from 0-11
const day = String(currentDate.getDate()).padStart(2, '0');

const formattedDate = `${year}/${month}/${day}`;

model={
idSuatchieu: idSuatchieu,
idFood: idFood,
soluongfood: soluongfood,
idVe: idVe,
tongtien: tongtien,
idGhe:idGhe,
idUser: 3,
ngay: formattedDate
}

console.log(model);
addNew(model);
});


function addNew(data) {
	$.ajax({
        url: '/api/user/thanhtoan',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        success: function (result) {
        	alert("Thanh Toán Thành Công!")
        },
        error: function (error) {

        }
    });
}



$("#deleteComments").click(() => {

        var user = document.getElementById("idusercomment").value;
        var phim = document.getElementById("idfilmcomment").value;
        $.ajax({
                url: '/api/user/danhgia?iduser=' + user + '&idphim=' +phim,
                type: 'DELETE',
                contentType: 'application/json',
                dataType: 'json',
                success: function (result) {
                	alert("Xóa Thành Cônng!");
                	window.location.href = "/comments/" + phim;
                },
                error: function (error) {
                    alert("Xóa  ok Thành Cônng!");
                    window.location.href = "/comments/" + phim;
                }
            });


});


$("#senddanhgia").click(() => {
    var tieude = document.getElementById("tieude").value;
    var danhgia = document.getElementById("danhgia").value;

    var user = document.getElementById("idusercomment").value;
        var phim = document.getElementById("idfilmcomment").value;

    if(tieude == "" || danhgia ==""){
        alert("Fill Full Information!");
        return;
    }

    data ={
tieude :tieude,
danhgia :danhgia,
user_danhgia :user,
phim_danhgia :phim
    }

    console.log(data);

addNewdanhgia(data, phim);

});

function addNewdanhgia(data, idphim) {
	$.ajax({
        url: '/api/user/danhgia',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        success: function (result) {
        	alert("Đánh Giá Thành Cônng!");
        	window.location.href = "/comments/" + idphim;
        },
        error: function (error) {
            alert("Đánh Giá Không Thành CÔng!")
        }
    });
}



function searchfilm(id){
var loaiphim = ""
    if(id == 1){
    loaiphim = "2D";
    }else if(id ==2){
    loaiphim = "3D";
    }
console.log(loaiphim);
    $.ajax({
            url: '/api/user/loaiphim?loai=' +loaiphim ,
            type: 'GET',
            contentType: 'application/json',
            dataType: 'json',
            success: function (result) {
            	console.log(result);
            	var container = document.getElementById("home_listphim");
            	container.innerHTML ="";
                result.forEach((movie) => {

                var movieCard = document.createElement("div");
                movieCard.classList.add("card");


                movieCard.innerHTML = `
                            <div  class="card">
                                            <div class="poster position-relative">
                                                <img src="${movie.anhphim}" alt="poster" />
                                                    <div class="overlay position-absolute ">
                                                        <a href="{/detailfilm/${movie.id}" class="btn hrefmuafilm bg-warning secondary-white ">
                                                            mua vé
                                                        </a>
                                                    </div>
                                                </a>                </div>
                                            <div class="detail">
                                                <h2 class="name-film" >
                                                        ${movie.tenphim}
                                                </h2>
                                                <h3 class="director">Đạo diễn <span >${movie.daodien}</span></h3>

                                                <div
                                                        class="tags d-flex justify-content-center p-2"
                                                >
                                                    <span class="c16">C16</span>
                                                    <span
                                                            class="film-2d d-flex align-items-center justify-content-center"
                                                    >${movie.loaiphim}</span
                                                    >

                                                </div>
                                            </div>
                                        </div>
                `;


container.appendChild(movieCard);


              	});


            },
            error: function (error) {

            }
        });
}

function searchByName(thiss) {

				var txt = thiss.value;

				$.ajax({
					url : '/api/user/search?ten=' + txt,
					type : "get", //send it through get method
					dataType : 'json',
					success : function(result) {

            	var container = document.getElementById("home_listphim");
            	container.innerHTML ="";
                result.forEach((movie) => {

                var movieCard = document.createElement("div");
                movieCard.classList.add("card");


                movieCard.innerHTML = `
                            <div  class="card">
                                            <div class="poster position-relative">
                                                <img src="${movie.anhphim}" alt="poster" />
                                                    <div class="overlay position-absolute ">
                                                        <a href="{/detailfilm/${movie.id}" class="btn hrefmuafilm bg-warning secondary-white ">
                                                            mua vé
                                                        </a>
                                                    </div>
                                                </a>                </div>
                                            <div class="detail">
                                                <h2 class="name-film" >
                                                        ${movie.tenphim}
                                                </h2>
                                                <h3 class="director">Đạo diễn <span >${movie.daodien}</span></h3>

                                                <div
                                                        class="tags d-flex justify-content-center p-2"
                                                >
                                                    <span class="c16">C16</span>
                                                    <span
                                                            class="film-2d d-flex align-items-center justify-content-center"
                                                    >${movie.loaiphim}</span
                                                    >

                                                </div>
                                            </div>
                                        </div>
                `;


container.appendChild(movieCard);


              	});

					},
					error : function(xhr) {
						//Do Something to handle error
					}
				});
			}


//$('#btnAddOrUpdateNew_').click(function(e) {
//
//			var data = {};
//			var formData = $('#formSubmit_').serializeArray();
//			$.each(formData, function(i, v) {
//				data["" + v.name + ""] = v.value;
//			});
//
//
//			console.log(data);
//$.ajax({
//				url : '/api/user/updateu',
//				type : 'POST',
//				contentType : 'application/json',
//				data : JSON.stringify(data),
//				dataType : 'json',
//				success : function(result) {
//					alert("success")
//					window.location.href = "/inforuser";
//				},
//				error : function(error) {
//				}
//			});
//		});

$('#btnAddOrUpdateNewRapupdate__').click(function (e) {
    alert("ok");
    e.preventDefault();

    var data = {};
    var formData = $('#formSubmitRapupdate__').serializeArray();
    $.each(formData, function (i, v) {
        data[""+v.name+""] = v.value;
    });
    console.log(data);
    var id = data["id"];
    updateNewRAP(data,id);


});

function updateNewRAP(data, id) {
	$.ajax({
                    url: '/api/admin/rap' + id,
                    type: 'PUT',
                    contentType: 'application/json',
                    data: JSON.stringify(data),
                    dataType: 'json',
                    success: function (result) {
                    	//window.location.href = "/qlrap";
                    },
                    error: function (error) {

                    }
                });
}

function updateRap(id){


$.ajax({
				url : '/api/user/rapupdate/' + id,
				type : 'GET',
				contentType : 'application/json',

				dataType : 'json',
				success : function(result) {
					var container = document.getElementById("staticBackdrop");
                                	container.innerHTML ="";

                                	var movieCard = document.createElement("div");
                                                    movieCard.classList.add("modal-dialog");
                    movieCard.innerHTML = `
<div class="modal-content" style="width: 670px;">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <div class="container-fluid pt-4 w-100 px-4">
                                            <div class="row w-100 g-4">
                                                <div class="col-sm-12 w-100 col-xl-6">
                                                    <div class="bg-light rounded h-100 p-4">
                                                        <h6 class="mb-4">${result.tenRap}</h6>
                                                        <form action="/api/admin/updater" method="post">
                                                            <div class="row mb-3">
                                                                <label for="id" class="col-sm-2 col-form-label">Mã</label>
                                                                <div class="col-sm-10">
                                                                    <input type="hidden" value="${result.id}" class="form-control" id="id" name="id">
                                                                </div>
                                                            </div>
                                                            <div class="row mb-3">
                                                                <label for="tenRap" class="col-sm-2 col-form-label">Tên Rạp</label>
                                                                <div class="col-sm-10">
                                                                    <input type="text" required value="${result.tenRap}" class="form-control" id="tenRap" name="tenRap">
                                                                </div>
                                                            </div>
                                                            <div class="row mb-3">
                                                                <label for="imgRap" class="col-sm-2 col-form-label">Ảnh Rạp</label>
                                                                <div class="col-sm-10">
                                                                    <input type="text" required value="${result.imgRap}" class="form-control" id="imgRap" name="imgRap">
                                                                </div>
                                                            </div>
                                                            <div class="row mb-3">
                                                                <label for="diaChi" class="col-sm-2 col-form-label">Địa chỉ Rạp</label>
                                                                <div class="col-sm-10">
                                                                    <input type="text" required value="${result.diaChi}" class="form-control" id="diaChi" name="diaChi">
                                                                </div>
                                                            </div>
                                                            <div class="row mb-3">
                                                                <label for="trangthai" class="col-sm-2 col-form-label">Trạng thái Rạp</label>
                                                                <div class="col-sm-10">
                                                                    <input type="text" required value="${result.trangthai}" class="form-control" id="trangthai" name="trangthai">
                                                                </div>
                                                            </div>

                                                            <button type="submit"class="btn btn-primary">UP</button>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                    `;
                    container.appendChild(movieCard);
					console.log(result);
				},
				error : function(error) {
				}
			});
}



$('#btnAddOrUpdateNewRapupdate').click(function (e) {
    e.preventDefault();

    var data = {};
    var formData = $('#formSubmitRapupdate').serializeArray();
    $.each(formData, function (i, v) {
        data[""+v.name+""] = v.value;
    });
    console.log(data);
    var id = data["id"];
addNewRAP(data);


});

function addNewRAP(data) {
var id = $('#selecttinh_updateRap').val();
	$.ajax({
                url: '/api/admin/rap/' + id,
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (result) {
                	window.location.href = "/qlrap";
                },
                error: function (error) {

                }
            });
}













