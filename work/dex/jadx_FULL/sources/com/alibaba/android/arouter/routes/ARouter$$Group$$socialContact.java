package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.social_contact.dialog.ExchangeWorldCrystalsDialog;
import com.huachenjie.social_contact.page.PayActivity;
import com.huachenjie.social_contact.page.RechargeActivity;
import com.huachenjie.social_contact.page.SearchFriendIdActivity;
import com.huachenjie.social_contact.page.SuperPackActivity;
import com.huachenjie.social_contact.page.WorldLetterActivity;
import com.huachenjie.social_contact.page.emoji_sticker.EmojiStickerActivity;
import com.huachenjie.social_contact.page.emoji_sticker.detail.EmojiStickerDetailActivity;
import com.huachenjie.social_contact.page.emoji_sticker.mine.MineEmojiStickerActivity;
import com.huachenjie.social_contact.page.report.ReportUserActivity;
import com.huachenjie.social_contact.page.suit.UserWearActivity;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ARouter$$Group$$socialContact implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put(RoutePathConstants.SocialContact.g, RouteMeta.build(routeType, RechargeActivity.class, "/socialcontact/recharge", "socialcontact", null, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.SocialContact.j, RouteMeta.build(routeType, EmojiStickerActivity.class, "/socialcontact/emojisticker", "socialcontact", null, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.SocialContact.l, RouteMeta.build(routeType, EmojiStickerDetailActivity.class, "/socialcontact/emojistickerdetail", "socialcontact", null, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.SocialContact.k, RouteMeta.build(routeType, MineEmojiStickerActivity.class, "/socialcontact/emojistickermine", "socialcontact", null, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.SocialContact.h, RouteMeta.build(RouteType.FRAGMENT, ExchangeWorldCrystalsDialog.class, "/socialcontact/exchange", "socialcontact", null, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.SocialContact.i, RouteMeta.build(routeType, PayActivity.class, "/socialcontact/pay", "socialcontact", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$socialContact.1
            {
                put(UserConstants.SOCIAL_CONTACT_PARAMS.f33737a, 10);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.SocialContact.d, RouteMeta.build(routeType, ReportUserActivity.class, "/socialcontact/report_user", "socialcontact", null, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.SocialContact.c, RouteMeta.build(routeType, SearchFriendIdActivity.class, "/socialcontact/search_friend_id", "socialcontact", null, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.SocialContact.f, RouteMeta.build(routeType, SuperPackActivity.class, "/socialcontact/superpack", "socialcontact", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$socialContact.2
            {
                put(UserConstants.SOCIAL_CONTACT_PARAMS.c, 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.SocialContact.b, RouteMeta.build(routeType, UserWearActivity.class, "/socialcontact/userwear", "socialcontact", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$socialContact.3
            {
                put(UserConstants.SOCIAL_CONTACT_PARAMS.b, 3);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.SocialContact.e, RouteMeta.build(routeType, WorldLetterActivity.class, "/socialcontact/world_letter", "socialcontact", null, -1, Integer.MIN_VALUE));
    }
}
