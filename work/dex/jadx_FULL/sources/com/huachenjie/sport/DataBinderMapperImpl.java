package com.huachenjie.sport;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.coroutines.DataBinderMapper;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.alipay.sdk.m.c0.d;
import com.huachenjie.run.page.sun_run.success.SchoolActivitySuccessActivity;
import com.huachenjie.sport.databinding.ActivityAttendanceBindingImpl;
import com.huachenjie.sport.databinding.ActivityAttendancePeriodBindingImpl;
import com.huachenjie.sport.databinding.ActivityAttendancePhotoBindingImpl;
import com.huachenjie.sport.databinding.ActivityAttendancePlanBindingImpl;
import com.huachenjie.sport.databinding.ActivityAttendanceRangeBindingImpl;
import com.huachenjie.sport.databinding.ActivityAttendanceRuleBindingImpl;
import com.huachenjie.sport.databinding.ActivityCampusLetterBindingImpl;
import com.huachenjie.sport.databinding.ActivityChooseClassesBindingImpl;
import com.huachenjie.sport.databinding.ActivityClassesDetailBindingImpl;
import com.huachenjie.sport.databinding.ActivityCustomerServiceCenterBindingImpl;
import com.huachenjie.sport.databinding.ActivityExamAnswerBindingImpl;
import com.huachenjie.sport.databinding.ActivityExamDetailBindingImpl;
import com.huachenjie.sport.databinding.ActivityExamHistoryResultsBindingImpl;
import com.huachenjie.sport.databinding.ActivityExamListBindingImpl;
import com.huachenjie.sport.databinding.ActivityFeedbackDetailsBindingImpl;
import com.huachenjie.sport.databinding.ActivityFeedbackV2BindingImpl;
import com.huachenjie.sport.databinding.ActivityHuodongDetailBindingImpl;
import com.huachenjie.sport.databinding.ActivityHuodongRunRanksBindingImpl;
import com.huachenjie.sport.databinding.ActivityHuodongRunRanksHeaderBindingImpl;
import com.huachenjie.sport.databinding.ActivityLetterBindingImpl;
import com.huachenjie.sport.databinding.ActivityMyChooseClassesBindingImpl;
import com.huachenjie.sport.databinding.ActivityPeClassesSearchBindingImpl;
import com.huachenjie.sport.databinding.ActivitySportTestChooseTimeBindingImpl;
import com.huachenjie.sport.databinding.ActivitySportTestDetailBindingImpl;
import com.huachenjie.sport.databinding.ActivitySportTestListBindingImpl;
import com.huachenjie.sport.databinding.ActivitySportTestResultBindingImpl;
import com.huachenjie.sport.databinding.ActiviySchoolyardBindingImpl;
import com.huachenjie.sport.databinding.DialogBottomExamAnswerSheetBindingImpl;
import com.huachenjie.sport.databinding.DialogBottomSportTestDetailBindingImpl;
import com.huachenjie.sport.databinding.DialogHuodongLimitBottomBindingImpl;
import com.huachenjie.sport.databinding.DialogNumberSignInBindingImpl;
import com.huachenjie.sport.databinding.DialogQrCodeBindingImpl;
import com.huachenjie.sport.databinding.FragmentAttendanceInClassBindingImpl;
import com.huachenjie.sport.databinding.FragmentAttendanceOutClassBindingImpl;
import com.huachenjie.sport.databinding.FragmentChooseClassesBindingImpl;
import com.huachenjie.sport.databinding.FragmentExamDetailBindingImpl;
import com.huachenjie.sport.databinding.FragmentExamResultBindingImpl;
import com.huachenjie.sport.databinding.FragmentSchoolyardBindingImpl;
import com.huachenjie.sport.databinding.FragmentSportTestChooseTimeBindingImpl;
import com.huachenjie.sport.databinding.FragmentSportTestListBindingImpl;
import com.huachenjie.sport.databinding.ItemAttendanceBindingImpl;
import com.huachenjie.sport.databinding.ItemAttendancePeriodBindingImpl;
import com.huachenjie.sport.databinding.ItemAttendancePlanBindingImpl;
import com.huachenjie.sport.databinding.ItemAttendanceRuleBindingImpl;
import com.huachenjie.sport.databinding.ItemCampusLetterBindingImpl;
import com.huachenjie.sport.databinding.ItemExamAnswerSheetBindingImpl;
import com.huachenjie.sport.databinding.ItemExamHistoryResultsBindingImpl;
import com.huachenjie.sport.databinding.ItemExamInfoBindingImpl;
import com.huachenjie.sport.databinding.ItemExamListBindingImpl;
import com.huachenjie.sport.databinding.ItemExamQuestionBindingImpl;
import com.huachenjie.sport.databinding.ItemExamQuestionMultipleOptionBindingImpl;
import com.huachenjie.sport.databinding.ItemExamQuestionNameBindingImpl;
import com.huachenjie.sport.databinding.ItemExamQuestionSingleOptionBindingImpl;
import com.huachenjie.sport.databinding.ItemFeedbackDetailsBindingImpl;
import com.huachenjie.sport.databinding.ItemHuodongRunRanksBindingImpl;
import com.huachenjie.sport.databinding.ItemPeClassesBindingImpl;
import com.huachenjie.sport.databinding.ItemSchoolyardBindingImpl;
import com.huachenjie.sport.databinding.ItemSportTestBindingImpl;
import com.huachenjie.sport.databinding.ItemSportTestChooseDateBindingImpl;
import com.huachenjie.sport.databinding.ItemSportTestChooseTimeBindingImpl;
import com.huachenjie.sport.databinding.ItemSportTestResultAddScoreBindingImpl;
import com.huachenjie.sport.databinding.ItemSportTestResultScoreBindingImpl;
import com.huachenjie.sport.databinding.LayoutCampusLetterEmptyBindingImpl;
import com.huachenjie.sport.databinding.LayoutSportTestResultDetailBindingImpl;
import com.huachenjie.sport.databinding.LayoutSportTestResultSimpleBindingImpl;
import com.huachenjie.sport.databinding.SportDialogInformedBindingImpl;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    public static final int A = 27;
    public static final int B = 28;
    public static final int C = 29;
    public static final int D = 30;
    public static final int E = 31;
    public static final int F = 32;
    public static final int G = 33;
    public static final int H = 34;
    public static final int I = 35;
    public static final int J = 36;
    public static final int K = 37;
    public static final int L = 38;
    public static final int M = 39;
    public static final int N = 40;
    public static final int O = 41;
    public static final int P = 42;
    public static final int Q = 43;
    public static final int R = 44;
    public static final int S = 45;
    public static final int T = 46;
    public static final int U = 47;
    public static final int V = 48;
    public static final int W = 49;
    public static final int X = 50;
    public static final int Y = 51;
    public static final int Z = 52;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f36346a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final SparseIntArray f13089a;
    public static final int a0 = 53;
    public static final int b = 2;
    public static final int b0 = 54;
    public static final int c = 3;
    public static final int c0 = 55;
    public static final int d = 4;
    public static final int d0 = 56;
    public static final int e = 5;
    public static final int e0 = 57;
    public static final int f = 6;
    public static final int f0 = 58;
    public static final int g = 7;
    public static final int g0 = 59;
    public static final int h = 8;
    public static final int h0 = 60;
    public static final int i = 9;
    public static final int i0 = 61;
    public static final int j = 10;
    public static final int j0 = 62;
    public static final int k = 11;
    public static final int k0 = 63;
    public static final int l = 12;
    public static final int l0 = 64;
    public static final int m = 13;
    public static final int m0 = 65;
    public static final int n = 14;
    public static final int n0 = 66;
    public static final int o = 15;
    public static final int p = 16;
    public static final int q = 17;
    public static final int r = 18;
    public static final int s = 19;
    public static final int t = 20;
    public static final int u = 21;
    public static final int v = 22;
    public static final int w = 23;
    public static final int x = 24;
    public static final int y = 25;
    public static final int z = 26;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SparseArray<String> f36347a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(40);
            f36347a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "adapter");
            sparseArray.put(2, "appealTime");
            sparseArray.put(3, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
            sparseArray.put(4, "cardBg");
            sparseArray.put(5, "checked");
            sparseArray.put(6, "click");
            sparseArray.put(7, "contains");
            sparseArray.put(8, "content");
            sparseArray.put(9, "data");
            sparseArray.put(10, "date");
            sparseArray.put(11, SchoolActivitySuccessActivity.x);
            sparseArray.put(12, "flowAdapter");
            sparseArray.put(13, "index");
            sparseArray.put(14, "isEnable");
            sparseArray.put(15, "isFinish");
            sparseArray.put(16, "isSelect");
            sparseArray.put(17, "item");
            sparseArray.put(18, "layoutManage");
            sparseArray.put(19, "listType");
            sparseArray.put(20, "mState");
            sparseArray.put(21, "onClick");
            sparseArray.put(22, "pageChange");
            sparseArray.put(23, "position");
            sparseArray.put(24, d.x);
            sparseArray.put(25, "scroll");
            sparseArray.put(26, "selectedPosition");
            sparseArray.put(27, "sexType");
            sparseArray.put(28, "showAppealTime");
            sparseArray.put(29, "showContent");
            sparseArray.put(30, "showFace");
            sparseArray.put(31, "showGradient");
            sparseArray.put(32, "showTag");
            sparseArray.put(33, "size");
            sparseArray.put(34, "tagBg");
            sparseArray.put(35, "tagText");
            sparseArray.put(36, "time");
            sparseArray.put(37, "title");
            sparseArray.put(38, "type");
            sparseArray.put(39, "vm");
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashMap<String, Integer> f36348a;

        static {
            HashMap<String, Integer> map = new HashMap<>(66);
            f36348a = map;
            map.put("layout/activity_attendance_0", Integer.valueOf(R.layout.activity_attendance));
            map.put("layout/activity_attendance_period_0", Integer.valueOf(R.layout.activity_attendance_period));
            map.put("layout/activity_attendance_photo_0", Integer.valueOf(R.layout.activity_attendance_photo));
            map.put("layout/activity_attendance_plan_0", Integer.valueOf(R.layout.activity_attendance_plan));
            map.put("layout/activity_attendance_range_0", Integer.valueOf(R.layout.activity_attendance_range));
            map.put("layout/activity_attendance_rule_0", Integer.valueOf(R.layout.activity_attendance_rule));
            map.put("layout/activity_campus_letter_0", Integer.valueOf(R.layout.activity_campus_letter));
            map.put("layout/activity_choose_classes_0", Integer.valueOf(R.layout.activity_choose_classes));
            map.put("layout/activity_classes_detail_0", Integer.valueOf(R.layout.activity_classes_detail));
            map.put("layout/activity_customer_service_center_0", Integer.valueOf(R.layout.activity_customer_service_center));
            map.put("layout/activity_exam_answer_0", Integer.valueOf(R.layout.activity_exam_answer));
            map.put("layout/activity_exam_detail_0", Integer.valueOf(R.layout.activity_exam_detail));
            map.put("layout/activity_exam_history_results_0", Integer.valueOf(R.layout.activity_exam_history_results));
            map.put("layout/activity_exam_list_0", Integer.valueOf(R.layout.activity_exam_list));
            map.put("layout/activity_feedback_details_0", Integer.valueOf(R.layout.activity_feedback_details));
            map.put("layout/activity_feedback_v2_0", Integer.valueOf(R.layout.activity_feedback_v2));
            map.put("layout/activity_huodong_detail_0", Integer.valueOf(R.layout.activity_huodong_detail));
            map.put("layout/activity_huodong_run_ranks_0", Integer.valueOf(R.layout.activity_huodong_run_ranks));
            map.put("layout/activity_huodong_run_ranks_header_0", Integer.valueOf(R.layout.activity_huodong_run_ranks_header));
            map.put("layout/activity_letter_0", Integer.valueOf(R.layout.activity_letter));
            map.put("layout/activity_my_choose_classes_0", Integer.valueOf(R.layout.activity_my_choose_classes));
            map.put("layout/activity_pe_classes_search_0", Integer.valueOf(R.layout.activity_pe_classes_search));
            map.put("layout/activity_sport_test_choose_time_0", Integer.valueOf(R.layout.activity_sport_test_choose_time));
            map.put("layout/activity_sport_test_detail_0", Integer.valueOf(R.layout.activity_sport_test_detail));
            map.put("layout/activity_sport_test_list_0", Integer.valueOf(R.layout.activity_sport_test_list));
            map.put("layout/activity_sport_test_result_0", Integer.valueOf(R.layout.activity_sport_test_result));
            map.put("layout/activiy_schoolyard_0", Integer.valueOf(R.layout.activiy_schoolyard));
            map.put("layout/dialog_bottom_exam_answer_sheet_0", Integer.valueOf(R.layout.dialog_bottom_exam_answer_sheet));
            map.put("layout/dialog_bottom_sport_test_detail_0", Integer.valueOf(R.layout.dialog_bottom_sport_test_detail));
            map.put("layout/dialog_huodong_limit_bottom_0", Integer.valueOf(R.layout.dialog_huodong_limit_bottom));
            map.put("layout/dialog_number_sign_in_0", Integer.valueOf(R.layout.dialog_number_sign_in));
            map.put("layout/dialog_qr_code_0", Integer.valueOf(R.layout.dialog_qr_code));
            map.put("layout/fragment_attendance_in_class_0", Integer.valueOf(R.layout.fragment_attendance_in_class));
            map.put("layout/fragment_attendance_out_class_0", Integer.valueOf(R.layout.fragment_attendance_out_class));
            map.put("layout/fragment_choose_classes_0", Integer.valueOf(R.layout.fragment_choose_classes));
            map.put("layout/fragment_exam_detail_0", Integer.valueOf(R.layout.fragment_exam_detail));
            map.put("layout/fragment_exam_result_0", Integer.valueOf(R.layout.fragment_exam_result));
            map.put("layout/fragment_schoolyard_0", Integer.valueOf(R.layout.fragment_schoolyard));
            map.put("layout/fragment_sport_test_choose_time_0", Integer.valueOf(R.layout.fragment_sport_test_choose_time));
            map.put("layout/fragment_sport_test_list_0", Integer.valueOf(R.layout.fragment_sport_test_list));
            map.put("layout/item_attendance_0", Integer.valueOf(R.layout.item_attendance));
            map.put("layout/item_attendance_period_0", Integer.valueOf(R.layout.item_attendance_period));
            map.put("layout/item_attendance_plan_0", Integer.valueOf(R.layout.item_attendance_plan));
            map.put("layout/item_attendance_rule_0", Integer.valueOf(R.layout.item_attendance_rule));
            map.put("layout/item_campus_letter_0", Integer.valueOf(R.layout.item_campus_letter));
            map.put("layout/item_exam_answer_sheet_0", Integer.valueOf(R.layout.item_exam_answer_sheet));
            map.put("layout/item_exam_history_results_0", Integer.valueOf(R.layout.item_exam_history_results));
            map.put("layout/item_exam_info_0", Integer.valueOf(R.layout.item_exam_info));
            map.put("layout/item_exam_list_0", Integer.valueOf(R.layout.item_exam_list));
            map.put("layout/item_exam_question_0", Integer.valueOf(R.layout.item_exam_question));
            map.put("layout/item_exam_question_multiple_option_0", Integer.valueOf(R.layout.item_exam_question_multiple_option));
            map.put("layout/item_exam_question_name_0", Integer.valueOf(R.layout.item_exam_question_name));
            map.put("layout/item_exam_question_single_option_0", Integer.valueOf(R.layout.item_exam_question_single_option));
            map.put("layout/item_feedback_details_0", Integer.valueOf(R.layout.item_feedback_details));
            map.put("layout/item_huodong_run_ranks_0", Integer.valueOf(R.layout.item_huodong_run_ranks));
            map.put("layout/item_pe_classes_0", Integer.valueOf(R.layout.item_pe_classes));
            map.put("layout/item_schoolyard_0", Integer.valueOf(R.layout.item_schoolyard));
            map.put("layout/item_sport_test_0", Integer.valueOf(R.layout.item_sport_test));
            map.put("layout/item_sport_test_choose_date_0", Integer.valueOf(R.layout.item_sport_test_choose_date));
            map.put("layout/item_sport_test_choose_time_0", Integer.valueOf(R.layout.item_sport_test_choose_time));
            map.put("layout/item_sport_test_result_add_score_0", Integer.valueOf(R.layout.item_sport_test_result_add_score));
            map.put("layout/item_sport_test_result_score_0", Integer.valueOf(R.layout.item_sport_test_result_score));
            map.put("layout/layout_campus_letter_empty_0", Integer.valueOf(R.layout.layout_campus_letter_empty));
            map.put("layout/layout_sport_test_result_detail_0", Integer.valueOf(R.layout.layout_sport_test_result_detail));
            map.put("layout/layout_sport_test_result_simple_0", Integer.valueOf(R.layout.layout_sport_test_result_simple));
            map.put("layout/sport_dialog_informed_0", Integer.valueOf(R.layout.sport_dialog_informed));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(66);
        f13089a = sparseIntArray;
        sparseIntArray.put(R.layout.activity_attendance, 1);
        sparseIntArray.put(R.layout.activity_attendance_period, 2);
        sparseIntArray.put(R.layout.activity_attendance_photo, 3);
        sparseIntArray.put(R.layout.activity_attendance_plan, 4);
        sparseIntArray.put(R.layout.activity_attendance_range, 5);
        sparseIntArray.put(R.layout.activity_attendance_rule, 6);
        sparseIntArray.put(R.layout.activity_campus_letter, 7);
        sparseIntArray.put(R.layout.activity_choose_classes, 8);
        sparseIntArray.put(R.layout.activity_classes_detail, 9);
        sparseIntArray.put(R.layout.activity_customer_service_center, 10);
        sparseIntArray.put(R.layout.activity_exam_answer, 11);
        sparseIntArray.put(R.layout.activity_exam_detail, 12);
        sparseIntArray.put(R.layout.activity_exam_history_results, 13);
        sparseIntArray.put(R.layout.activity_exam_list, 14);
        sparseIntArray.put(R.layout.activity_feedback_details, 15);
        sparseIntArray.put(R.layout.activity_feedback_v2, 16);
        sparseIntArray.put(R.layout.activity_huodong_detail, 17);
        sparseIntArray.put(R.layout.activity_huodong_run_ranks, 18);
        sparseIntArray.put(R.layout.activity_huodong_run_ranks_header, 19);
        sparseIntArray.put(R.layout.activity_letter, 20);
        sparseIntArray.put(R.layout.activity_my_choose_classes, 21);
        sparseIntArray.put(R.layout.activity_pe_classes_search, 22);
        sparseIntArray.put(R.layout.activity_sport_test_choose_time, 23);
        sparseIntArray.put(R.layout.activity_sport_test_detail, 24);
        sparseIntArray.put(R.layout.activity_sport_test_list, 25);
        sparseIntArray.put(R.layout.activity_sport_test_result, 26);
        sparseIntArray.put(R.layout.activiy_schoolyard, 27);
        sparseIntArray.put(R.layout.dialog_bottom_exam_answer_sheet, 28);
        sparseIntArray.put(R.layout.dialog_bottom_sport_test_detail, 29);
        sparseIntArray.put(R.layout.dialog_huodong_limit_bottom, 30);
        sparseIntArray.put(R.layout.dialog_number_sign_in, 31);
        sparseIntArray.put(R.layout.dialog_qr_code, 32);
        sparseIntArray.put(R.layout.fragment_attendance_in_class, 33);
        sparseIntArray.put(R.layout.fragment_attendance_out_class, 34);
        sparseIntArray.put(R.layout.fragment_choose_classes, 35);
        sparseIntArray.put(R.layout.fragment_exam_detail, 36);
        sparseIntArray.put(R.layout.fragment_exam_result, 37);
        sparseIntArray.put(R.layout.fragment_schoolyard, 38);
        sparseIntArray.put(R.layout.fragment_sport_test_choose_time, 39);
        sparseIntArray.put(R.layout.fragment_sport_test_list, 40);
        sparseIntArray.put(R.layout.item_attendance, 41);
        sparseIntArray.put(R.layout.item_attendance_period, 42);
        sparseIntArray.put(R.layout.item_attendance_plan, 43);
        sparseIntArray.put(R.layout.item_attendance_rule, 44);
        sparseIntArray.put(R.layout.item_campus_letter, 45);
        sparseIntArray.put(R.layout.item_exam_answer_sheet, 46);
        sparseIntArray.put(R.layout.item_exam_history_results, 47);
        sparseIntArray.put(R.layout.item_exam_info, 48);
        sparseIntArray.put(R.layout.item_exam_list, 49);
        sparseIntArray.put(R.layout.item_exam_question, 50);
        sparseIntArray.put(R.layout.item_exam_question_multiple_option, 51);
        sparseIntArray.put(R.layout.item_exam_question_name, 52);
        sparseIntArray.put(R.layout.item_exam_question_single_option, 53);
        sparseIntArray.put(R.layout.item_feedback_details, 54);
        sparseIntArray.put(R.layout.item_huodong_run_ranks, 55);
        sparseIntArray.put(R.layout.item_pe_classes, 56);
        sparseIntArray.put(R.layout.item_schoolyard, 57);
        sparseIntArray.put(R.layout.item_sport_test, 58);
        sparseIntArray.put(R.layout.item_sport_test_choose_date, 59);
        sparseIntArray.put(R.layout.item_sport_test_choose_time, 60);
        sparseIntArray.put(R.layout.item_sport_test_result_add_score, 61);
        sparseIntArray.put(R.layout.item_sport_test_result_score, 62);
        sparseIntArray.put(R.layout.layout_campus_letter_empty, 63);
        sparseIntArray.put(R.layout.layout_sport_test_result_detail, 64);
        sparseIntArray.put(R.layout.layout_sport_test_result_simple, 65);
        sparseIntArray.put(R.layout.sport_dialog_informed, 66);
    }

    public final ViewDataBinding a(DataBindingComponent dataBindingComponent, View view, int i2, Object obj) {
        switch (i2) {
            case 1:
                if ("layout/activity_attendance_0".equals(obj)) {
                    return new ActivityAttendanceBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_attendance is invalid. Received: " + obj);
            case 2:
                if ("layout/activity_attendance_period_0".equals(obj)) {
                    return new ActivityAttendancePeriodBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_attendance_period is invalid. Received: " + obj);
            case 3:
                if ("layout/activity_attendance_photo_0".equals(obj)) {
                    return new ActivityAttendancePhotoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_attendance_photo is invalid. Received: " + obj);
            case 4:
                if ("layout/activity_attendance_plan_0".equals(obj)) {
                    return new ActivityAttendancePlanBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_attendance_plan is invalid. Received: " + obj);
            case 5:
                if ("layout/activity_attendance_range_0".equals(obj)) {
                    return new ActivityAttendanceRangeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_attendance_range is invalid. Received: " + obj);
            case 6:
                if ("layout/activity_attendance_rule_0".equals(obj)) {
                    return new ActivityAttendanceRuleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_attendance_rule is invalid. Received: " + obj);
            case 7:
                if ("layout/activity_campus_letter_0".equals(obj)) {
                    return new ActivityCampusLetterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_campus_letter is invalid. Received: " + obj);
            case 8:
                if ("layout/activity_choose_classes_0".equals(obj)) {
                    return new ActivityChooseClassesBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_choose_classes is invalid. Received: " + obj);
            case 9:
                if ("layout/activity_classes_detail_0".equals(obj)) {
                    return new ActivityClassesDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_classes_detail is invalid. Received: " + obj);
            case 10:
                if ("layout/activity_customer_service_center_0".equals(obj)) {
                    return new ActivityCustomerServiceCenterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_customer_service_center is invalid. Received: " + obj);
            case 11:
                if ("layout/activity_exam_answer_0".equals(obj)) {
                    return new ActivityExamAnswerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_exam_answer is invalid. Received: " + obj);
            case 12:
                if ("layout/activity_exam_detail_0".equals(obj)) {
                    return new ActivityExamDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_exam_detail is invalid. Received: " + obj);
            case 13:
                if ("layout/activity_exam_history_results_0".equals(obj)) {
                    return new ActivityExamHistoryResultsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_exam_history_results is invalid. Received: " + obj);
            case 14:
                if ("layout/activity_exam_list_0".equals(obj)) {
                    return new ActivityExamListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_exam_list is invalid. Received: " + obj);
            case 15:
                if ("layout/activity_feedback_details_0".equals(obj)) {
                    return new ActivityFeedbackDetailsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_feedback_details is invalid. Received: " + obj);
            case 16:
                if ("layout/activity_feedback_v2_0".equals(obj)) {
                    return new ActivityFeedbackV2BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_feedback_v2 is invalid. Received: " + obj);
            case 17:
                if ("layout/activity_huodong_detail_0".equals(obj)) {
                    return new ActivityHuodongDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_huodong_detail is invalid. Received: " + obj);
            case 18:
                if ("layout/activity_huodong_run_ranks_0".equals(obj)) {
                    return new ActivityHuodongRunRanksBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_huodong_run_ranks is invalid. Received: " + obj);
            case 19:
                if ("layout/activity_huodong_run_ranks_header_0".equals(obj)) {
                    return new ActivityHuodongRunRanksHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_huodong_run_ranks_header is invalid. Received: " + obj);
            case 20:
                if ("layout/activity_letter_0".equals(obj)) {
                    return new ActivityLetterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_letter is invalid. Received: " + obj);
            case 21:
                if ("layout/activity_my_choose_classes_0".equals(obj)) {
                    return new ActivityMyChooseClassesBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_my_choose_classes is invalid. Received: " + obj);
            case 22:
                if ("layout/activity_pe_classes_search_0".equals(obj)) {
                    return new ActivityPeClassesSearchBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_pe_classes_search is invalid. Received: " + obj);
            case 23:
                if ("layout/activity_sport_test_choose_time_0".equals(obj)) {
                    return new ActivitySportTestChooseTimeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_sport_test_choose_time is invalid. Received: " + obj);
            case 24:
                if ("layout/activity_sport_test_detail_0".equals(obj)) {
                    return new ActivitySportTestDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_sport_test_detail is invalid. Received: " + obj);
            case 25:
                if ("layout/activity_sport_test_list_0".equals(obj)) {
                    return new ActivitySportTestListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_sport_test_list is invalid. Received: " + obj);
            case 26:
                if ("layout/activity_sport_test_result_0".equals(obj)) {
                    return new ActivitySportTestResultBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_sport_test_result is invalid. Received: " + obj);
            case 27:
                if ("layout/activiy_schoolyard_0".equals(obj)) {
                    return new ActiviySchoolyardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activiy_schoolyard is invalid. Received: " + obj);
            case 28:
                if ("layout/dialog_bottom_exam_answer_sheet_0".equals(obj)) {
                    return new DialogBottomExamAnswerSheetBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_bottom_exam_answer_sheet is invalid. Received: " + obj);
            case 29:
                if ("layout/dialog_bottom_sport_test_detail_0".equals(obj)) {
                    return new DialogBottomSportTestDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_bottom_sport_test_detail is invalid. Received: " + obj);
            case 30:
                if ("layout/dialog_huodong_limit_bottom_0".equals(obj)) {
                    return new DialogHuodongLimitBottomBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_huodong_limit_bottom is invalid. Received: " + obj);
            case 31:
                if ("layout/dialog_number_sign_in_0".equals(obj)) {
                    return new DialogNumberSignInBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_number_sign_in is invalid. Received: " + obj);
            case 32:
                if ("layout/dialog_qr_code_0".equals(obj)) {
                    return new DialogQrCodeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_qr_code is invalid. Received: " + obj);
            case 33:
                if ("layout/fragment_attendance_in_class_0".equals(obj)) {
                    return new FragmentAttendanceInClassBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_attendance_in_class is invalid. Received: " + obj);
            case 34:
                if ("layout/fragment_attendance_out_class_0".equals(obj)) {
                    return new FragmentAttendanceOutClassBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_attendance_out_class is invalid. Received: " + obj);
            case 35:
                if ("layout/fragment_choose_classes_0".equals(obj)) {
                    return new FragmentChooseClassesBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_choose_classes is invalid. Received: " + obj);
            case 36:
                if ("layout/fragment_exam_detail_0".equals(obj)) {
                    return new FragmentExamDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_exam_detail is invalid. Received: " + obj);
            case 37:
                if ("layout/fragment_exam_result_0".equals(obj)) {
                    return new FragmentExamResultBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_exam_result is invalid. Received: " + obj);
            case 38:
                if ("layout/fragment_schoolyard_0".equals(obj)) {
                    return new FragmentSchoolyardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_schoolyard is invalid. Received: " + obj);
            case 39:
                if ("layout/fragment_sport_test_choose_time_0".equals(obj)) {
                    return new FragmentSportTestChooseTimeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_sport_test_choose_time is invalid. Received: " + obj);
            case 40:
                if ("layout/fragment_sport_test_list_0".equals(obj)) {
                    return new FragmentSportTestListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_sport_test_list is invalid. Received: " + obj);
            case 41:
                if ("layout/item_attendance_0".equals(obj)) {
                    return new ItemAttendanceBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_attendance is invalid. Received: " + obj);
            case 42:
                if ("layout/item_attendance_period_0".equals(obj)) {
                    return new ItemAttendancePeriodBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_attendance_period is invalid. Received: " + obj);
            case 43:
                if ("layout/item_attendance_plan_0".equals(obj)) {
                    return new ItemAttendancePlanBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_attendance_plan is invalid. Received: " + obj);
            case 44:
                if ("layout/item_attendance_rule_0".equals(obj)) {
                    return new ItemAttendanceRuleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_attendance_rule is invalid. Received: " + obj);
            case 45:
                if ("layout/item_campus_letter_0".equals(obj)) {
                    return new ItemCampusLetterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_campus_letter is invalid. Received: " + obj);
            case 46:
                if ("layout/item_exam_answer_sheet_0".equals(obj)) {
                    return new ItemExamAnswerSheetBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_exam_answer_sheet is invalid. Received: " + obj);
            case 47:
                if ("layout/item_exam_history_results_0".equals(obj)) {
                    return new ItemExamHistoryResultsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_exam_history_results is invalid. Received: " + obj);
            case 48:
                if ("layout/item_exam_info_0".equals(obj)) {
                    return new ItemExamInfoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_exam_info is invalid. Received: " + obj);
            case 49:
                if ("layout/item_exam_list_0".equals(obj)) {
                    return new ItemExamListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_exam_list is invalid. Received: " + obj);
            case 50:
                if ("layout/item_exam_question_0".equals(obj)) {
                    return new ItemExamQuestionBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_exam_question is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    public final ViewDataBinding b(DataBindingComponent dataBindingComponent, View view, int i2, Object obj) {
        switch (i2) {
            case 51:
                if ("layout/item_exam_question_multiple_option_0".equals(obj)) {
                    return new ItemExamQuestionMultipleOptionBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_exam_question_multiple_option is invalid. Received: " + obj);
            case 52:
                if ("layout/item_exam_question_name_0".equals(obj)) {
                    return new ItemExamQuestionNameBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_exam_question_name is invalid. Received: " + obj);
            case 53:
                if ("layout/item_exam_question_single_option_0".equals(obj)) {
                    return new ItemExamQuestionSingleOptionBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_exam_question_single_option is invalid. Received: " + obj);
            case 54:
                if ("layout/item_feedback_details_0".equals(obj)) {
                    return new ItemFeedbackDetailsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_feedback_details is invalid. Received: " + obj);
            case 55:
                if ("layout/item_huodong_run_ranks_0".equals(obj)) {
                    return new ItemHuodongRunRanksBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_huodong_run_ranks is invalid. Received: " + obj);
            case 56:
                if ("layout/item_pe_classes_0".equals(obj)) {
                    return new ItemPeClassesBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_pe_classes is invalid. Received: " + obj);
            case 57:
                if ("layout/item_schoolyard_0".equals(obj)) {
                    return new ItemSchoolyardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_schoolyard is invalid. Received: " + obj);
            case 58:
                if ("layout/item_sport_test_0".equals(obj)) {
                    return new ItemSportTestBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_sport_test is invalid. Received: " + obj);
            case 59:
                if ("layout/item_sport_test_choose_date_0".equals(obj)) {
                    return new ItemSportTestChooseDateBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_sport_test_choose_date is invalid. Received: " + obj);
            case 60:
                if ("layout/item_sport_test_choose_time_0".equals(obj)) {
                    return new ItemSportTestChooseTimeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_sport_test_choose_time is invalid. Received: " + obj);
            case 61:
                if ("layout/item_sport_test_result_add_score_0".equals(obj)) {
                    return new ItemSportTestResultAddScoreBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_sport_test_result_add_score is invalid. Received: " + obj);
            case 62:
                if ("layout/item_sport_test_result_score_0".equals(obj)) {
                    return new ItemSportTestResultScoreBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_sport_test_result_score is invalid. Received: " + obj);
            case 63:
                if ("layout/layout_campus_letter_empty_0".equals(obj)) {
                    return new LayoutCampusLetterEmptyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_campus_letter_empty is invalid. Received: " + obj);
            case 64:
                if ("layout/layout_sport_test_result_detail_0".equals(obj)) {
                    return new LayoutSportTestResultDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_sport_test_result_detail is invalid. Received: " + obj);
            case 65:
                if ("layout/layout_sport_test_result_simple_0".equals(obj)) {
                    return new LayoutSportTestResultSimpleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_sport_test_result_simple is invalid. Received: " + obj);
            case 66:
                if ("layout/sport_dialog_informed_0".equals(obj)) {
                    return new SportDialogInformedBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for sport_dialog_informed is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    @Override // androidx.coroutines.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(9);
        arrayList.add(new androidx.coroutines.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.flyco.tablayout.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.ad.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.base.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.common.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.pay.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.qrcode.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.run.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.step.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.coroutines.DataBinderMapper
    public String convertBrIdToString(int i2) {
        return a.f36347a.get(i2);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i2) {
        int i3 = f13089a.get(i2);
        if (i3 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        int i4 = (i3 - 1) / 50;
        if (i4 == 0) {
            return a(dataBindingComponent, view, i3, tag);
        }
        if (i4 != 1) {
            return null;
        }
        return b(dataBindingComponent, view, i3, tag);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f36348a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || f13089a.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
