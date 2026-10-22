package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.run.page.activities_run.ActivityReadyActivity;
import com.huachenjie.run.page.activities_run.ActivityRunListActivity;
import com.huachenjie.run.page.activities_run.DetailActivity;
import com.huachenjie.run.page.activities_run.GPSDiagnosisActivity;
import com.huachenjie.run.page.appeal.AppealActivity;
import com.huachenjie.run.page.free.FreeRunActivity;
import com.huachenjie.run.page.free.TargetSettingActivity;
import com.huachenjie.run.page.free_record.FreeRecordActivity;
import com.huachenjie.run.page.free_run.FreeRunExperienceActivity;
import com.huachenjie.run.page.free_run.FreeRunMainActivity;
import com.huachenjie.run.page.geofence.GeoFenceV2Activity;
import com.huachenjie.run.page.geofence.GiftWebActivity;
import com.huachenjie.run.page.rankinglist.SunshineRankingActivity;
import com.huachenjie.run.page.rule.RuleV3Activity;
import com.huachenjie.run.page.run_detail.RunDetailActivity;
import com.huachenjie.run.page.run_index.RunIndexActivity;
import com.huachenjie.run.page.settings.RunSettingsActivity;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ARouter$$Group$$run implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> atlas) {
        RouteType routeType = RouteType.ACTIVITY;
        atlas.put(RoutePathConstants.Run.r, RouteMeta.build(routeType, ActivityReadyActivity.class, "/run/activityready", "run", null, -1, Integer.MIN_VALUE));
        atlas.put(RoutePathConstants.Run.m, RouteMeta.build(routeType, RuleV3Activity.class, "/run/activityrulev3", "run", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$run.1
            {
                put(RuleV3Activity.x, 10);
            }
        }, -1, Integer.MIN_VALUE));
        atlas.put(RoutePathConstants.Run.k, RouteMeta.build(routeType, ActivityRunListActivity.class, "/run/activityrun", "run", null, -1, 1));
        atlas.put(RoutePathConstants.Run.i, RouteMeta.build(routeType, DetailActivity.class, "/run/activityrundetail", "run", null, -1, 1));
        atlas.put(RoutePathConstants.Run.h, RouteMeta.build(routeType, AppealActivity.class, RoutePathConstants.Run.h, "run", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$run.2
            {
                put("semesterCode", 8);
                put("runRecordCode", 8);
            }
        }, -1, Integer.MIN_VALUE));
        atlas.put(RoutePathConstants.Run.c, RouteMeta.build(routeType, GeoFenceV2Activity.class, "/run/fencedetail_v2", "run", null, -1, Integer.MIN_VALUE));
        atlas.put(RoutePathConstants.Run.e, RouteMeta.build(routeType, FreeRunActivity.class, "/run/freerun", "run", null, -1, Integer.MIN_VALUE));
        atlas.put(RoutePathConstants.Run.o, RouteMeta.build(routeType, FreeRunExperienceActivity.class, "/run/freerunexperience", "run", null, -1, Integer.MIN_VALUE));
        atlas.put(RoutePathConstants.Run.n, RouteMeta.build(routeType, FreeRunMainActivity.class, "/run/freerunmain", "run", null, -1, Integer.MIN_VALUE));
        atlas.put(RoutePathConstants.Run.f, RouteMeta.build(routeType, FreeRecordActivity.class, "/run/freerunrecord", "run", null, -1, Integer.MIN_VALUE));
        atlas.put(RoutePathConstants.Run.q, RouteMeta.build(routeType, GiftWebActivity.class, "/run/giftwebview", "run", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$run.3
            {
                put("title", 8);
                put("url", 8);
            }
        }, -1, Integer.MIN_VALUE));
        atlas.put(RoutePathConstants.Run.l, RouteMeta.build(routeType, GPSDiagnosisActivity.class, "/run/gpsdiagnosis", "run", null, -1, Integer.MIN_VALUE));
        atlas.put(RoutePathConstants.Run.g, RouteMeta.build(routeType, RunSettingsActivity.class, "/run/runsettings", "run", null, -1, Integer.MIN_VALUE));
        atlas.put(RoutePathConstants.Run.p, RouteMeta.build(routeType, SunshineRankingActivity.class, "/run/sunshinerank", "run", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$run.4
            {
                put(SunshineRankingActivity.x, 9);
            }
        }, -1, 1));
        atlas.put(RoutePathConstants.Run.b, RouteMeta.build(routeType, RunDetailActivity.class, "/run/sunshinerundetail", "run", null, -1, Integer.MIN_VALUE));
        atlas.put(RoutePathConstants.Run.j, RouteMeta.build(routeType, RunIndexActivity.class, "/run/sunshinerunv3", "run", null, -1, 1));
        atlas.put(RoutePathConstants.Run.d, RouteMeta.build(routeType, TargetSettingActivity.class, "/run/targetsetting", "run", null, -1, Integer.MIN_VALUE));
    }
}
