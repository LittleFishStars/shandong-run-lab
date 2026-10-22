package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.sport.page.campus_letter.CampusLetterActivity;
import com.huachenjie.sport.page.mine.appeallist.AppealListActivity;
import com.huachenjie.sport.page.mine.attendance.AttendanceActivity;
import com.huachenjie.sport.page.mine.attendance.period.AttendancePeriodActivity;
import com.huachenjie.sport.page.mine.attendance.photo.AttendancePhotoActivity;
import com.huachenjie.sport.page.mine.attendance.plan.AttendancePlanActivity;
import com.huachenjie.sport.page.mine.attendance.range.AttendanceRangeActivity;
import com.huachenjie.sport.page.mine.attendance.rule.AttendanceRuleActivity;
import com.huachenjie.sport.page.mine.choose_classes.ChooseClassesActivity;
import com.huachenjie.sport.page.mine.choose_classes.ChooseClassesFragment;
import com.huachenjie.sport.page.mine.choose_classes.MyChooseClassesActivity;
import com.huachenjie.sport.page.mine.exam.ExamAnswerActivity;
import com.huachenjie.sport.page.mine.exam.ExamDetailActivity;
import com.huachenjie.sport.page.mine.exam.ExamListActivity;
import com.huachenjie.sport.page.mine.helpercenter.FeedBackV2Activity;
import com.huachenjie.sport.page.mine.helpercenter.FeedbackDetailsActivity;
import com.huachenjie.sport.page.mine.huodong.SchoolyardActivity;
import com.huachenjie.sport.page.mine.qrcode.QRCodeDialog;
import com.huachenjie.sport.page.mine.sport_test.detail.SportTestDetailActivity;
import com.huachenjie.sport.page.mine.sport_test.result.SportTestResultScoreActivity;
import com.huachenjie.sport.page.mine.sport_test.test_list.SportTestListActivity;
import com.huachenjie.sport.page.mine.sport_test.time.SportTestChooseTimeActivity;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ARouter$$Group$$sport implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put(RoutePathConstants.Sport.m, RouteMeta.build(routeType, AppealListActivity.class, "/sport/appeallist", "sport", null, -1, 1));
        map.put(RoutePathConstants.Sport.r, RouteMeta.build(routeType, AttendanceActivity.class, RoutePathConstants.Sport.r, "sport", null, -1, 1));
        map.put(RoutePathConstants.Sport.u, RouteMeta.build(routeType, AttendancePeriodActivity.class, "/sport/attendanceperiod", "sport", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$sport.1
            {
                put(UserConstants.MINE_PARAMS.i, 10);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Sport.v, RouteMeta.build(routeType, AttendancePhotoActivity.class, "/sport/attendancephoto", "sport", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$sport.2
            {
                put(UserConstants.MINE_PARAMS.k, 8);
                put(UserConstants.MINE_PARAMS.i, 10);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Sport.s, RouteMeta.build(routeType, AttendancePlanActivity.class, "/sport/attendanceplan", "sport", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$sport.3
            {
                put(UserConstants.MINE_PARAMS.j, 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Sport.w, RouteMeta.build(routeType, AttendanceRangeActivity.class, "/sport/attendancerange", "sport", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$sport.4
            {
                put(UserConstants.MINE_PARAMS.o, 9);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Sport.t, RouteMeta.build(routeType, AttendanceRuleActivity.class, "/sport/attendancerule", "sport", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$sport.5
            {
                put(UserConstants.MINE_PARAMS.h, 8);
                put(UserConstants.MINE_PARAMS.j, 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Sport.j, RouteMeta.build(routeType, CampusLetterActivity.class, RoutePathConstants.Sport.j, "sport", null, -1, 1));
        map.put(RoutePathConstants.Sport.g, RouteMeta.build(routeType, ChooseClassesActivity.class, "/sport/chooseclasses", "sport", null, -1, 1));
        RouteType routeType2 = RouteType.FRAGMENT;
        map.put(RoutePathConstants.Sport.i, RouteMeta.build(routeType2, ChooseClassesFragment.class, "/sport/chooseclassesfragment", "sport", null, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Sport.p, RouteMeta.build(routeType, ExamAnswerActivity.class, "/sport/examanswer", "sport", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$sport.6
            {
                put("data", 10);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Sport.o, RouteMeta.build(routeType, ExamDetailActivity.class, "/sport/examdetail", "sport", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$sport.7
            {
                put("detail", 10);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Sport.n, RouteMeta.build(routeType, ExamListActivity.class, "/sport/examlist", "sport", null, -1, 1));
        map.put(RoutePathConstants.Sport.k, RouteMeta.build(routeType, FeedBackV2Activity.class, RoutePathConstants.Sport.k, "sport", null, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Sport.l, RouteMeta.build(routeType, FeedbackDetailsActivity.class, "/sport/feedbackdetails", "sport", null, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Sport.c, RouteMeta.build(routeType2, QRCodeDialog.class, "/sport/mineqrcode", "sport", null, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Sport.h, RouteMeta.build(routeType, MyChooseClassesActivity.class, "/sport/mychooseclasses", "sport", null, -1, 1));
        map.put(RoutePathConstants.Sport.b, RouteMeta.build(routeType, SchoolyardActivity.class, RoutePathConstants.Sport.b, "sport", null, -1, 1));
        map.put(RoutePathConstants.Sport.q, RouteMeta.build(routeType, SportTestResultScoreActivity.class, "/sport/sportachievement", "sport", null, -1, 1));
        map.put(RoutePathConstants.Sport.d, RouteMeta.build(routeType, SportTestListActivity.class, "/sport/sporttest", "sport", null, -1, 1));
        map.put(RoutePathConstants.Sport.e, RouteMeta.build(routeType, SportTestDetailActivity.class, "/sport/sporttestdetail", "sport", null, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Sport.f, RouteMeta.build(routeType, SportTestChooseTimeActivity.class, "/sport/sporttesttime", "sport", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$sport.8
            {
                put("testCode", 8);
                put("dayCode", 8);
                put("yearCode", 8);
                put("timeCode", 8);
            }
        }, -1, Integer.MIN_VALUE));
    }
}
