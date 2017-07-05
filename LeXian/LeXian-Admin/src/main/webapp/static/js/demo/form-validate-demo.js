//以下为修改jQuery Validation插件兼容Bootstrap的方法，没有直接写在插件中是为了便于插件升级
$.validator.setDefaults({
    highlight: function (element) {
        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
    },
    success: function (element) {
        element.closest('.form-group').removeClass('has-error').addClass('has-success');
    },
    errorElement: "span",
    errorPlacement: function (error, element) {
        if (element.is(":radio") || element.is(":checkbox")) {
            error.appendTo(element.parent().parent().parent());
        } else {
            error.appendTo(element.parent());
        }
    },
    errorClass: "help-block m-b-none",
    validClass: "help-block m-b-none"


});

//以下为官方示例
$().ready(function () {
    // validate the comment form when it is submitted
    $("#commentForm").validate();

    // validate signup form on keyup and submit
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules: {
            proName: "required",
            proBar: {
                required: true,
                minlength: 7
            },
            proPrice: {
                required: true
            },
            proDscp: {
                required: true,
                minlength: 5
            },
            proPic: {
                required: true
            },
            proStorage: {
                required: true
            }
        },
        messages: {
            proName: icon + "请输入商品名称",
            proBar: {
                required: icon + "请输入条形码",
                minlength: icon + "至少7位"
            },
            proPrice: {
                required: icon + "请输入价格"
            },
            proDscp: {
                required: icon + "请输入商品描述",
                minlength: icon + "至少输入5个字描述"
            },
            proPic: {
                required: icon + "添加图片链接"
            },
            proSotrage: icon + "请输入商品库存"
        }
    });

    // propose username by combining first- and lastname
    $("#username").focus(function () {
        var firstname = $("#firstname").val();
        var lastname = $("#lastname").val();
        if (firstname && lastname && !this.value) {
            this.value = firstname + "." + lastname;
        }
    });
});
