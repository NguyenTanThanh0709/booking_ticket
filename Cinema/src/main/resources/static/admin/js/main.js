(function ($) {
    "use strict";

    // Spinner
    var spinner = function () {
        setTimeout(function () {
            if ($('#spinner').length > 0) {
                $('#spinner').removeClass('show');
            }
        }, 1);
    };
    spinner();
    
    
    // Back to top button
    $(window).scroll(function () {
        if ($(this).scrollTop() > 300) {
            $('.back-to-top').fadeIn('slow');
        } else {
            $('.back-to-top').fadeOut('slow');
        }
    });
    $('.back-to-top').click(function () {
        $('html, body').animate({scrollTop: 0}, 1500, 'easeInOutExpo');
        return false;
    });


    // Sidebar Toggler
    $('.sidebar-toggler').click(function () {
        $('.sidebar, .content').toggleClass("open");
        return false;
    });


    // Progress Bar
    $('.pg-bar').waypoint(function () {
        $('.progress .progress-bar').each(function () {
            $(this).css("width", $(this).attr("aria-valuenow") + '%');
        });
    }, {offset: '80%'});


    // Calender
    $('#calender').datetimepicker({
        inline: true,
        format: 'L'
    });


    // Testimonials carousel
    $(".testimonial-carousel").owlCarousel({
        autoplay: true,
        smartSpeed: 1000,
        items: 1,
        dots: true,
        loop: true,
        nav : false
    });


})(jQuery);

function vehandleadd(){
    $("#ve-id").val(-1);
    $("#ve-ten").val("");
    $("#ve-noidung").val("");
    $("#ve-gia").val(0);
    $("ve-trangthai").val("");
}

function vehandleupdate(id){
$.ajax({
				url : '/api/user/getoneve/' + id,
				type : 'GET',
				contentType : 'application/json',
				dataType : 'json',
				success : function(result) {
    $("#ve-id").val(result.id);
    $("#ve-ten").val(result.tenve);
    $("#ve-noidung").val(result.noidung);
    $("#ve-gia").val(result.giave);
    $("#ve-trangthai").val(result.trangthai);
    console.log(result.tenve);
    console.log(result.noidung);
    console.log(result.giave);
    console.log(result.id);
				},
				error : function(error) {
				}
			});
}

function foodhandleadd(){
$("#food-id").val(-1);
    $("#food-ten").val("");
    $("#food-anh").val("");
    $("#food-noidung").val("");
    $("#food-gia").val(0);
    $("food-trangthai").val("");
}


function foodhandleaddfood(id){
$.ajax({
				url : '/api/user/getonefood/' + id,
				type : 'GET',
				contentType : 'application/json',
				dataType : 'json',
				success : function(result) {
$("#food-id").val(result.id);
    $("#food-ten").val(result.namefood);
    $("#food-anh").val(result.image);
    $("#food-noidung").val(result.noidung);
    $("#food-gia").val(result.gia);
    $("#food-trangthai").val(result.trangthai);
				},
				error : function(error) {
				}
			});
}




function handleaddKM(){
    $("#km-m").val(-1);
    $("#km-tt").val("");
    $("#km-n").val("");
    $("#km-a").val("");
    $("#km-t").val(0);
}

function handleupdateKM(id){
$.ajax({
				url : '/api/user/getonekhuyenmai/' + id,
				type : 'GET',
				contentType : 'application/json',
				dataType : 'json',
				success : function(result) {
    $("#km-m").val(result.id);
    $("#km-tt").val(result.trangthai);
    $("#km-n").val(result.tenkhuyenmai);
    $("#km-a").val(result.img);
    $("#km-t").val(result.tienkhuyenmai);
				},
				error : function(error) {
				}
			});
}

function xemdanhsachdanhgia(this_){
var value = $("#chonphimmuonxe").val();
$.ajax({
				url : '/api/admin/danhgiaphim/' + value,
				type : 'GET',
				contentType : 'application/json',
				dataType : 'json',
				success : function(result) {
				console.log(result)
				var container = document.getElementById("listdanhgiaphim");
                            	container.innerHTML ="";
                    result.forEach((movie) => {

                                    var movieCard = document.createElement("tr");



                                    movieCard.innerHTML = `
                                                <td>${movie.id.user_danhgia}</td>
                                                <td>${movie.tieude}</td>
                                                <td>${movie.danhGia}</td>
                                                <td><button onclick="xoadanhgia(${movie.id.user_danhgia},${movie.id.phim_danhgia})" class="btn btn-primary">Xóa</button></td>
                                    `;


                                    container.appendChild(movieCard);


                                  	});
				},
				error : function(error) {
				}
			});

}

function xoadanhgia(user, phim){
$.ajax({
				url : '/api/admin/xoadanhgia?idu=' + user +'&idp=' + phim,
				type : 'DELETE',
				contentType : 'application/json',
				dataType : 'json',
				success : function(result) {
                      alert("Done");
                      window.location.href = "/qldanhgiaphim";
				},
				error : function(error) {
				}
			});
}

function xemsuatchieu(){
var idphim = $("#suatchieu_phim").val();
var idrap = $("#suatchieu_rap").val();
$.ajax({
				url : '/api/admin/xemsuatchieu?idphim=' + idphim +'&idrap=' + idrap,
				type : 'GET',
				contentType : 'application/json',
				dataType : 'json',
				success : function(result) {
                      console.log(result);
                      var container = document.getElementById("danhsachsuatchieu");
                      container.innerHTML ="";
                                          result.forEach((movie) => {

                                                          var movieCard = document.createElement("tr");



                                                          movieCard.innerHTML = `
                                                                      <td>${movie.ngayChieu}</td>
                                                                      <td>${movie.thoiGian}</td>

                                                                      <td>${movie.info}</td>
                                                                      <td><button onclick="xemchitiet(${movie.id})" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#updatesuatchieu">update</button></td>
                                                          `;


                                                          container.appendChild(movieCard);


                                                        	});
				},
				error : function(error) {
				}
			});
}

function hienthiphong(this_){
    var idrap = $(this_).val();
    $.ajax({
    				url : '/api/admin/phongrap?id=' + idrap,
    				type : 'GET',
    				contentType : 'application/json',
    				dataType : 'json',
    				success : function(result) {
                          console.log(result);
                          var container = document.querySelector("#allphongrap");
                          container.innerHTML = "";
                          var item1 = new Option("Chọn phong muốn thêm", "-1", true, true);
                          container.appendChild(item1);
                          result.forEach((i) => {

                            var item = new Option(i.tenPhong, i.id, true, true);

                            container.appendChild(item);


                          });
    				},
    				error : function(error) {
    				}
    			});
}

function xemchitiet(id){
$.ajax({
    				url : '/api/admin/getonesc?id=' + id,
    				type : 'GET',
    				contentType : 'application/json',
    				dataType : 'json',
    				success : function(result) {
                          console.log(result);

    $("#updatesc-id").val(result.id);
    $("#updatesc-ngaychieu").val(result.ngayChieu);
    $("#updatesc-giochieu").val(result.thoiGian);
    $("#updatesc-info").val(result.info);


    				},
    				error : function(error) {
    				}
    			});


}

function handelfill(){
        $("#id").val("");
        $("#tenphim").val("");
        $("#tuoi").val("");
        $("#theloai").val("");
        $("#quocgia").val("");
        $("#dienvien").val("");
                $("#daodien").val("");
                $("#ngaychieu").val("");
                $("#rating").val("");
                $("#thoiluong").val("");
                $("#loaiphim").val("");
                                $("#noidung").val("");
                                $("#trangthai").val("");
                                $("#anhphim").val("");
                                $("#trailer").val("");
}


function searchByName_admin(thiss) {

				var txt = thiss.value;
                console.log(txt);
				$.ajax({
					url : '/api/user/search?ten=' + txt,
					type : "get", //send it through get method
					dataType : 'json',
					success : function(result) {
                console.log(result);
            	var container = document.getElementById("listphimadmin");
            	container.innerHTML ="";
                result.forEach((phim) => {
                    var movieCard = document.createElement("tr");

                     movieCard.innerHTML = `
                                        <td><img style="width: 54px;height: 50px;" src="${phim.anhphim}"/></td>
                                        <td>${phim.tenphim}</td>
                                        <td>${phim.theloai}</td>
                                        <td>${phim.quocgia}</td>
                                        <td><button onclick="handlephimdetails(${phim.id})" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#quanliphim">Xem chi tiết</button></td>

                     `;
                container.appendChild(movieCard);
              	});

					},
					error : function(xhr) {
						//Do Something to handle error
					}
				});
			}


$('#formquanlyphim_submit').click(function (e) {
    e.preventDefault();

    var data = {};
    var formData = $('#formquanlyphim').serializeArray();
    $.each(formData, function (i, v) {
        data[""+v.name+""] = v.value;
    });
    //console.log(data);
    var filename = $('#avatar').val().replace(/.*(\/|\\)/, '');

    if(filename != ""){
        data["anhphim"] = "../assets/" + filename;
        uploadFile();
    }


    console.log(data);
    if(data["id"] == ""){
            addNew_(data);
    }else{
            updateNew(data, data["id"]);
    }

});

async function uploadFile() {
  let formData = new FormData();
  formData.append("file", avatar.files[0]);
  let response = await fetch('/api/admin/upload-file', {
    method: "POST",
    body: formData
  });

  if (response.status == 200) {
    alert("File successfully uploaded.");
  }
}

function addNew_(data) {
	$.ajax({
        url: '/api/admin/film',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        success: function (result) {
        	alert("success");
        	window.location.href = "/qlphim";
        },
        error: function (error) {

        }
    });
}
function updateNew(data, id) {
	$.ajax({
        url: '/api/admin/film/' + id,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        success: function (result) {
        alert("success");
        	window.location.href = "/qlphim";

        },
        error: function (error) {

        }
    });
}



function handlephimdetails(idPhim){

				$.ajax({
					url : '/api/user/getone/' + idPhim,
					type : "get", //send it through get method
					dataType : 'json',
					success : function(result) {
                    console.log(result);
        $("#id").val(result.id);
        $("#tenphim").val(result.tenphim);
        $("#tuoi").val(result.tuoi);
        $("#theloai").val(result.theloai);
        $("#quocgia").val(result.quocgia);
        $("#dienvien").val(result.dienvien);
                $("#daodien").val(result.daodien);
                $("#ngaychieu").val(result.ngaychieu);
                $("#rating").val(result.rating);
                $("#thoiluong").val(result.thoiluong);
                $("#loaiphim").val(result.loaiphim);
                                $("#noidung").val(result.noidung);
                                $("#trangthai").val(result.trangthai);
                                $("#anhphim").val(result.anhphim);
                                $("#trailer").val(result.trailer);
					},
					error : function(xhr) {
						//Do Something to handle error
					}
				});
}