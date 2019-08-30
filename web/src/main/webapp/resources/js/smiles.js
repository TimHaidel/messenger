$(document).ready(function () {
    $(".smile").click(function () {
        let smile = $(this).attr('alt');
        let text = $.trim($("#icon_prefix2").val());
        $("#icon_prefix2").val(text + ' ' + smile + ' ');
    })
});