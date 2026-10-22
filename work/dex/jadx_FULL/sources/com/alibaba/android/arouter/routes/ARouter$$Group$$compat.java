package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.compat.page.about_as.AboutAsActivity;
import com.huachenjie.compat.page.account.CancelAccountActivity;
import com.huachenjie.compat.page.account.CancelAccountSubmitActivity;
import com.huachenjie.compat.page.account.CancelAccountTipActivity;
import com.huachenjie.compat.page.account.ChangePasswordActivity;
import com.huachenjie.compat.page.login.AuthorizeActivity;
import com.huachenjie.compat.page.login.AuthorizeVerifyActivity;
import com.huachenjie.compat.page.login.LogoutDialogActivity;
import com.huachenjie.compat.page.login.SearchSchoolActivity;
import com.huachenjie.compat.page.personal.ChangeNickNameActivity;
import com.huachenjie.compat.page.personal.ModifyAddressActivity;
import com.huachenjie.compat.page.personal.PersonalV2Activity;
import com.huachenjie.compat.page.personal.PhoneModifyActivity;
import com.huachenjie.compat.page.settings.SettingActivity;
import com.huachenjie.compat.page.student.StudentCardActivity;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ARouter$$Group$$compat implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put(RoutePathConstants.Compat.j, RouteMeta.build(routeType, AboutAsActivity.class, RoutePathConstants.Compat.j, "compat", null, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Compat.c, RouteMeta.build(routeType, AuthorizeActivity.class, RoutePathConstants.Compat.c, "compat", null, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Compat.d, RouteMeta.build(routeType, AuthorizeVerifyActivity.class, RoutePathConstants.Compat.d, "compat", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$compat.1
            {
                put(UserConstants.LOGIN_PARAMS.c, 10);
                put(UserConstants.LOGIN_PARAMS.d, 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Compat.m, RouteMeta.build(routeType, CancelAccountActivity.class, "/compat/cancelaccount", "compat", null, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Compat.o, RouteMeta.build(routeType, CancelAccountSubmitActivity.class, "/compat/cancelaccountsubmit", "compat", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$compat.2
            {
                put(UserConstants.MINE_PARAMS.c, 8);
                put(UserConstants.MINE_PARAMS.b, 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Compat.n, RouteMeta.build(routeType, CancelAccountTipActivity.class, "/compat/cancelaccounttip", "compat", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$compat.3
            {
                put(UserConstants.MINE_PARAMS.c, 8);
                put(UserConstants.MINE_PARAMS.b, 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Compat.i, RouteMeta.build(routeType, ChangeNickNameActivity.class, "/compat/changenickname", "compat", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$compat.4
            {
                put(UserConstants.USER_PARAMS.b, 8);
                put(UserConstants.USER_PARAMS.f33739a, 3);
                put(UserConstants.USER_PARAMS.c, 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Compat.h, RouteMeta.build(routeType, ChangePasswordActivity.class, "/compat/changepassword", "compat", null, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Compat.b, RouteMeta.build(routeType, LogoutDialogActivity.class, RoutePathConstants.Compat.b, "compat", null, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Compat.l, RouteMeta.build(routeType, ModifyAddressActivity.class, "/compat/modifyaddress", "compat", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$compat.5
            {
                put("address", 10);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Compat.p, RouteMeta.build(routeType, PhoneModifyActivity.class, "/compat/modifyphone", "compat", null, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Compat.k, RouteMeta.build(routeType, PersonalV2Activity.class, RoutePathConstants.Compat.k, "compat", null, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Compat.e, RouteMeta.build(routeType, SearchSchoolActivity.class, "/compat/searchschool", "compat", null, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Compat.g, RouteMeta.build(routeType, SettingActivity.class, RoutePathConstants.Compat.g, "compat", null, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Compat.f, RouteMeta.build(routeType, StudentCardActivity.class, "/compat/studentcard", "compat", null, -1, 1));
    }
}
