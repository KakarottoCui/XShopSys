const util = require('../../utils/util.js');
const api = require('../../config/api.js');
const user = require('../../services/user.js');

//获取应用实例
const app = getApp()
Page({
    data: {
        newGoods: [],
        hotGoods: [],
        topics: [],
        brands: [],
        floorGoods: [],
        banner: [],
        channel: []
    },
    onShareAppMessage: function () {
        wx.showShareMenu({ 
            withShareTicket: true, 
            menus: ['shareAppMessage', 'shareTimeline'] 
          }) 
        return {
            title: 'NideShop',
            desc: '仿网易严选微信小程序商城',
            path: '/pages/index/index'
        }
    },onShareTimeline: function () {//用户点击右上角分享朋友圈 
        return { 
          title: 'NideShop', 
          query: "id=110101&name=heyzqt", 
          imageUrl: '/static/images/logo.png' 
        } 
    }, onPullDownRefresh() {
        // 增加下拉刷新数据的功能
        var self = this;
        this.getIndexData();
    },
    getIndexData: function () {
        let that = this;
        var data = new Object();
        util.request(api.IndexUrlNewGoods).then(function (res) {
            if (res.errno === 0) {
                data.newGoods = res.data.newGoodsList
                that.setData(data);
            }
        });
        util.request(api.IndexUrlHotGoods).then(function (res) {
            if (res.errno === 0) {
                data.hotGoods = res.data.hotGoodsList
                that.setData(data);
            }
        });
        util.request(api.IndexUrlTopic).then(function (res) {
            if (res.errno === 0) {
                data.topics = res.data.topicList
                that.setData(data);
            }
        });
        util.request(api.IndexUrlBrand).then(function (res) {
            if (res.errno === 0) {
                data.brand = res.data.brandList
                that.setData(data);
            }
        });
        util.request(api.IndexUrlCategory).then(function (res) {
            if (res.errno === 0) {
                data.floorGoods = res.data.categoryList
                that.setData(data);
            }
        });
        util.request(api.IndexUrlBanner).then(function (res) {

            if (res.errno === 0) {
                data.banner = res.data.banner
                that.setData(data);
            }
        });
        util.request(api.IndexUrlChannel).then(function (res) {
            if (res.errno === 0) {
                data.channel = res.data.channel
                that.setData(data);
            }
        });

    },
    onLoad: function (options) {
        this.getIndexData();
    },
    onReady: function () {
        // 页面渲染完成
    },
    onShow: function () {
        // 页面显示
    },
    onHide: function () {
        // 页面隐藏
    },
    onUnload: function () {
        // 页面关闭
    },
})
