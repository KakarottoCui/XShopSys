var util = require('../../../utils/util.js');
var api = require('../../../config/api.js');

var app = getApp();

Page({
  data: {
    typeId: 0,
    collectList: []
  },
  getCollectList() {
    let that = this;
    util.request(api.CollectList, { typeId: that.data.typeId}).then(function (res) {
      if (res.errno === 0) {
        that.setData({
          collectList: res.data
        });
      }
    });
  },
  onLoad: function (options) {
    
  },
  onReady: function () {

  },
  onShow: function () {
    this.getCollectList();
  },
  onHide: function () {
    // 页面隐藏

  },
  onUnload: function () {
    // 页面关闭
  },
  openGoods(event) {
    
    let that = this;
    let goodsId = this.data.collectList[event.currentTarget.dataset.index].value_id;

    //触摸时间距离页面打开的毫秒数  
    var touchTime = that.data.touch_end - that.data.touch_start;
    //如果按下时间大于350为长按
    if (touchTime > 350) {
      wx.showModal({
        title: '',
        content: '确定删除收藏吗？',
        success: function (res) {
          if (res.confirm) {
            util.request(api.CollectAddOrDelete, { typeId: that.data.typeId, valueId: goodsId}).then(function (res) {
              if (res.errno === 0) {
                wx.showToast({
                  title: '删除成功',
                  icon: 'success',
                  duration: 2000
                });
                that.getCollectList();
              }
            });
          }
        }
      })
    } else {
      
      wx.navigateTo({
        url: '/pages/goods/goods?id=' + goodsId,
      });
    }  
  },
  //按下事件开始  
  touchStart: function (e) {
    let that = this;
    that.setData({
      touch_start: e.timeStamp
    })
  },
  //按下事件结束  
  touchEnd: function (e) {
    let that = this;
    that.setData({
      touch_end: e.timeStamp
    })
  },
})