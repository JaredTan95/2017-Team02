/**
 * Created by tanjian on 2017/7/2.
 */
/*id="toMyAccount"><
 id="toMyFav"><a hr
 id="toLoginOrReg">*/

jQuery.LeXian = {
    initWebTop: function () {
        if ($.LeXian.getMyToken() != null) {
            $('#toMyKeFu').show();
            $('#toMyAccount').html("<a target='_blank' href='shop-myaccount.html?userId=" + $.LeXian.getMyid() + "'>"
                + $.LeXian.getMyName() + "</a>").show();
            $('#toMyFav').show();
        } else {
            $('#toLoginOrReg').show();
        }
    },
    saveMyInfo: function (toSave) {
        $.cookie('myid', toSave.map.user.userid);
        $.cookie('myaccount', toSave.map.user.useraccount);
        $.cookie('myname', toSave.map.user.username);
        $.cookie('mymail', toSave.map.user.usermail);
        $.cookie('token', toSave.map.token);
    },
    getMyid: function () {
        return $.cookie('myid');
    },
    getMyAccount: function () {
        $.cookie('myaccount');
    },
    getMyName: function () {
        return $.cookie('myname');
    },
    getMyToken: function () {
        console.log($.cookie('token'));
        return $.cookie('token');
    },
    loadingTips: function (load, count, thisLayer) {
        load++;
        if (load >= count) {
            layer.close(thisLayer);
        }
    },
    add2ShopCart: function (token, proId) {
        $.ajax({
            url: '/user/shopcart/add',
            type: "POST",
            data: {token: token, productionId: proId, amount: 1},
            success: function (data) {
                layer.msg(data.info);
            }
        });
    }
};

$.getJSON("/user/category/query", function (data) {
    var categoryLists = new Vue({
        el: '#category',
        data: data
    });
    /*   $.LeXian.loadingTips(load,count,index);*/
});
function jump2KeFu() {
    $('#KeFu_username').attr('value', "LeXian_" + $.LeXian.getMyName());
    $('#KeFu_form').submit();
}
$('body').on('click', '.add2ShopCart', function () {
   // alert("你要添加到购物车了!");
    $.LeXian.add2ShopCart($.LeXian.getMyToken(), $(this).attr('proId'));
});
$('body').on('click', '.add2ShopCart2', function () {
    $.LeXian.add2ShopCart($.LeXian.getMyToken(), $(this).attr('proid'));
});

function add2ShopCartFunction() {
    $.LeXian.add2ShopCart($.LeXian.getMyToken(), $(this).attr('proId'));
}
$("#sureBuy").on('click',function(){
   // getCheckedProsId();
});
(function ($) {
    $.getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    }
})(jQuery);