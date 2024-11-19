// Ẩn thành phần sản phẩm
$(document).ready(function(){
    $("#toggleIcon").click(function(){
        // Kiểm tra xem phần tử #ingredientsContent có đang ẩn không
        if ($("#ingredientsContent").hasClass("d-none")) {
            // Hiện phần thành phần và đổi icon thành dấu trừ
            $("#ingredientsContent").removeClass("d-none");
            $(this).removeClass("bi-plus").addClass("bi-dash");
        } else {
            // Ẩn phần thành phần và đổi icon thành dấu cộng
            $("#ingredientsContent").addClass("d-none");
            $(this).removeClass("bi-dash").addClass("bi-plus");
        }
    });
});
// Tăng số lượng sp
let quantity = 1;
document.getElementById('decrease').onclick = () => {
    if (quantity > 1) document.getElementById('quantity').textContent = --quantity;
};
document.getElementById('increase').onclick = () => {
    document.getElementById('quantity').textContent = ++quantity;
};
