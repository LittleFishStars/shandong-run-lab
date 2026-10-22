package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huachenjie.mall.external.page.share_goods.SelectGoodsActivity;
import com.huachenjie.mall.page.goods_detail.GoodsDetailActivity;
import com.huachenjie.mall.page.home_tab.MallActivity;
import com.huachenjie.mall.page.home_tab.cat.MallCatActivity;
import com.huachenjie.mall.page.merchants.MerchantsActivity;
import com.huachenjie.mall.page.my_order.MyOrderActivity;
import com.huachenjie.mall.page.order_detail.OrderDetailActivity;
import com.huachenjie.mall.page.shopping_message.ShoppingMessageActivity;
import com.zj.adlib.zj7;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ARouter$$Group$$mall implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put(zj7.g.GOOD_DETAIL, RouteMeta.build(routeType, GoodsDetailActivity.class, "/mall/gooddetail", "mall", null, -1, Integer.MIN_VALUE));
        map.put(zj7.g.MALL_CAT, RouteMeta.build(routeType, MallCatActivity.class, "/mall/mallcat", "mall", null, -1, Integer.MIN_VALUE));
        map.put(zj7.g.MALL_HOME, RouteMeta.build(routeType, MallActivity.class, "/mall/mallhome", "mall", null, -1, Integer.MIN_VALUE));
        map.put(zj7.g.MERCHANTS, RouteMeta.build(routeType, MerchantsActivity.class, zj7.g.MERCHANTS, "mall", null, -1, Integer.MIN_VALUE));
        map.put(zj7.g.MY_ORDER, RouteMeta.build(routeType, MyOrderActivity.class, "/mall/myorder", "mall", null, -1, Integer.MIN_VALUE));
        map.put(zj7.g.ORDER_DETAIL, RouteMeta.build(routeType, OrderDetailActivity.class, "/mall/orderdetail", "mall", null, -1, Integer.MIN_VALUE));
        map.put(zj7.g.SELECT_GOODS, RouteMeta.build(routeType, SelectGoodsActivity.class, "/mall/selectgoods", "mall", null, -1, Integer.MIN_VALUE));
        map.put(zj7.g.SHOPPING_MESSAGE, RouteMeta.build(routeType, ShoppingMessageActivity.class, "/mall/shoppingmessage", "mall", null, -1, Integer.MIN_VALUE));
    }
}
