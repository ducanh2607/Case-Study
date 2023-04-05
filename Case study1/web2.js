let product2 = new Car("C 200 Avantgarde Plus", "White", "1.789.000.000", "C-Class", "c200plus.png")
let product3 = new Car("C 300 AMG", "Black", "2.089.000.000", "C-Class", "c300.png")
let product4 = new Car("C 300 AMG CBU", "Blue", "2.399.000.000", "C-Class", "c300cbu.png")
let product5 = new Car("E 180", "White", "2.050.000.000", "E-Class", "e180.png")
let product6 = new Car("E 200 Exclusive", "White", "2.470.000.000", "E-Class", "e200.png")
let product7 = new Car("E 300 AMG", "Red", "3.129.000.000", "E-Class", "e300.png")
let product8 = new Car("GLB 200", "Black", "1.999.000.000", "GLB", "glb200.png")
let product9 = new Car("AMG GLB 35 4Matic", "White", "2.849.000.000", "GLB", "glb35.png")
let product10 = new Car("GLC 200", "Black", "1.859.000.000", "GLC", "glc200.png")
let product11 = new Car("GLC 200 4Matic", "White", "2.129.000.000", "GLC", "glc200matic.png")
let product12 = new Car("GLC 300 4Matic", "Red", "2.569.000.000", "GLC", "glc300.png")
let product13 = new Car("GLS 450 4Matic", "White", "5.079.000.000", "GLS", "gls450.png")
let product14 = new Car("GLS 600 4Matic Maybach", "White", "11.619.000.000", "GLS", "gls600.png")
let product15 = new Car("S450", "Black", "5.199.000.000", "S-Class", "s450.png")
let product16 = new Car("S450 Luxury V1", "Black", "5.549.000.000", "S-Class", "s450v1.png")
let product17 = new Car("S450 Luxury V2", "Green", "5.689.000.000", "S-Class", "s450v2.png")
let arr = [[product2, product3, product4], [product5, product6, product7], [product8, product9], [product10, product11, product12], [product13, product14], [product15, product16, product17]];
let a = ["C-Class", "E-Class", "GLB", "GLC", "GLS", "S-Class"]
function display(arr) {
    let data = ""
    data += "<table>"
    for (let i = 0; i < arr.length; i++) {
        data += "<tr>"
        for (let j = 0; j < arr[i].length; j++) {
            data += `<td>
          <div class="all">
          <div class="image">
          <img src="${arr[i][j]._image}"></div>
          <div class="name">
          <span style="color: black">${arr[i][j]._name}</span></div>
          <div class="color"></div> 
          <span style="color: black">Màu: ${arr[i][j]._color}</span>
          <div class="price">
          <span style="color: black">Giá: ${arr[i][j]._price}</span></div>
          <div class="type"><span>Kiểu: ${arr[i][j]._type}</span></div>
          <div><button id="mua" onclick="buy()"><i class="fa-solid fa-cart-shopping"></i>  Đặt hàng</button></div>
          </div>
          </td>`
        }

        data += "</tr>"
    }
    data += "</table>"
    document.getElementById('products').innerHTML = data
}
display(arr)
let c = document.getElementById('cclass')
let e = document.getElementById('eclass')
let lb = document.getElementById('glb')
let lc = document.getElementById('glc')
let ls = document.getElementById('gls')
let s = document.getElementById('sclass')
function filterC() {
    let arrC = []
    if (c.checked === true) {
        arrC[0] = []
        for (let i = 0; i < arr.length; i++) {
            for (let j = 0; j < arr[i].length; j++) {
                if (arr[i][j].type === 'C-Class') {
                    arrC[0].push(arr[i][j])
                }
            }
        }
        e.checked = false
        lb.checked = false
        lc.checked = false
        ls.checked = false
        s.checked = false
        display(arrC)
    }else{
        display(arr)
    }
}
function filterE() {
    let arrC = []
    if (e.checked === true) {
        arrC[0] = []
        for (let i = 0; i < arr.length; i++) {
            for (let j = 0; j < arr[i].length; j++) {
                if (arr[i][j].type === 'E-Class') {
                    arrC[0].push(arr[i][j])
                }
            }
        }
        c.checked = false
        lb.checked = false
        lc.checked = false
        ls.checked = false
        s.checked = false
        display(arrC)
    }else{
        display(arr)
    }
}
function filterGlb() {
    let arrC = []
    if (lb.checked === true) {
        arrC[0] = []
        for (let i = 0; i < arr.length; i++) {
            for (let j = 0; j < arr[i].length; j++) {
                if (arr[i][j].type === 'GLB') {
                    arrC[0].push(arr[i][j])
                }
            }
        }
        c.checked = false
        e.checked = false
        lc.checked = false
        ls.checked = false
        s.checked = false
        display(arrC)
    }else{
        display(arr)
    }
}
function filterGlc() {
    let arrC = []
    if (lc.checked === true) {
        arrC[0] = []
        for (let i = 0; i < arr.length; i++) {
            for (let j = 0; j < arr[i].length; j++) {
                if (arr[i][j].type === 'GLC') {
                    arrC[0].push(arr[i][j])
                }
            }
        }
        e.checked = false
        lb.checked = false
        c.checked = false
        ls.checked = false
        s.checked = false
        display(arrC)
    }else{
        display(arr)
    }
}
function filterGls() {
    let arrC = []
    if (ls.checked === true) {
        arrC[0] = []
        for (let i = 0; i < arr.length; i++) {
            for (let j = 0; j < arr[i].length; j++) {
                if (arr[i][j].type === 'GLS') {
                    arrC[0].push(arr[i][j])
                }
            }
        }
        e.checked = false
        lb.checked = false
        lc.checked = false
        c.checked = false
        s.checked = false
        display(arrC)
    }else{
        display(arr)
    }
}
function filterS() {
    let arrS = []
    if (s.checked === true) {
        arrS[0] = []
        for (let i = 0; i < arr.length; i++) {
            for (let j = 0; j < arr[i].length; j++) {
                if (arr[i][j].type === 'S-Class') {
                    arrS[0].push(arr[i][j])
                }
            }
        }
        e.checked = false
        lb.checked = false
        lc.checked = false
        ls.checked = false
        c.checked = false
        display(arrS)
    }else{
        display(arr)
    }
}
function tuvan(){
    alert("Quý khách vui lòng gọi đến số 0123456789 để nghe tư vấn")
}
// function buy(){
//     let data=""
//     data+="<form>"
//     data+="<input type='text' id='name' placeholder='Nhập tên của bạn:' style='width: 500px; height: 50px'><label for='name'></label></br>"
//     data+="<input type='text' id='phone' placeholder='Nhập sđt của bạn:' style='width: 500px; height: 50px'><label for='phone'></label></br>"
//     data+="<input type='text' id='mail' placeholder='Nhập email của bạn:' style='width: 500px; height: 50px'><label for='mail'></label></br>"
//     data+="<input type='text' id='address' placeholder='Nhập địa chỉ của bạn:' style='width: 500px; height: 50px'><label for='address'></label></br>"
//     data+="<button type='submit' onclick='confirm()' style='width: 100px;height: 50px'>Xác nhận</button>"
//     data+="<button type='reset'style='width: 100px;height: 50px'>Reset</button>"
//     data+="</form>"
//     document.getElementById('products').innerHTML=data;
// }
function confirm1(){
    alert('Cảm ơn quý khách đã đặt hàng, cửa hàng sẽ liên lạc với quý khách!');
}
let modal_container = document.getElementById('modal_container');
let close = document.getElementById('close');
close.addEventListener('click', () => {
    modal_container.classList.remove('show')
    })
function buy(){
    modal_container.classList.add('show');
}
function login(){
    let data =''
    data+="<input type='text' id='loginId' placeholder='Tên đăng nhập' style='width: 500px; height: 50px; margin-left: 500px'  ><label for='loginId'></label></br>"
    data+="<input type='text' id='password' placeholder='Mật khẩu' style='width: 500px; height: 50px;margin-left: 500px'><label for='address'></label></br>"
    data+="<button type='submit' onclick='confirmLogin()' style='width: 250px; height: 50px;margin-left: 500px'>Xác nhận</button>"
    data+="<button type='submit' onclick='tailai()' style='width: 250px; height: 50px;'>Đóng</button>"
    document.getElementById('formdn').innerHTML=data;
}
function tailai(){
    let data=''
    document.getElementById('formdn').innerText=data
}
function confirmLogin(){
    let a='ducanh'
    let b=123
    let c= document.getElementById('loginId')
    let d= document.getElementById('password')
    if (c.value==a&&d.value==b){
        document.getElementById('login1').innerHTML="Duc Anh"+"<button onclick='logOut()'>Thoát</button>"
    }else{
        alert('Sai ')
    }
    tailai()
}
function logOut(){
    document.getElementById('login1').innerHTML="Đăng nhập"
    tailai()
}










