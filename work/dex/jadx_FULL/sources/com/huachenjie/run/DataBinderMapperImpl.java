package com.huachenjie.run;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.coroutines.DataBinderMapper;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.alipay.sdk.m.c0.d;
import com.huachenjie.run.databinding.RunActivityActivityRuleBindingImpl;
import com.huachenjie.run.databinding.RunActivityActivityRunListBindingImpl;
import com.huachenjie.run.databinding.RunActivityAiDeductionDetailBindingImpl;
import com.huachenjie.run.databinding.RunActivityAppealBindingImpl;
import com.huachenjie.run.databinding.RunActivityCameraRunSuccessBindingImpl;
import com.huachenjie.run.databinding.RunActivityDetailBindingImpl;
import com.huachenjie.run.databinding.RunActivityDetailRouteBindingImpl;
import com.huachenjie.run.databinding.RunActivityFreeRunExperienceBindingImpl;
import com.huachenjie.run.databinding.RunActivityGpsDiagnosisBindingImpl;
import com.huachenjie.run.databinding.RunActivityIndexBindingImpl;
import com.huachenjie.run.databinding.RunActivityMorePermissionBindingImpl;
import com.huachenjie.run.databinding.RunActivityOutsideAttendDeductionDetailBindingImpl;
import com.huachenjie.run.databinding.RunActivityRunGeoGuideV3BindingImpl;
import com.huachenjie.run.databinding.RunActivityRunModeGuideBindingImpl;
import com.huachenjie.run.databinding.RunActivitySchoolActivityRunSuccessBindingImpl;
import com.huachenjie.run.databinding.RunActivitySchoolRuleV3BindingImpl;
import com.huachenjie.run.databinding.RunActivitySunshineRankingBindingImpl;
import com.huachenjie.run.databinding.RunActivitySunshineRunBindingImpl;
import com.huachenjie.run.databinding.RunActivitySunshineRunSuccessBindingImpl;
import com.huachenjie.run.databinding.RunActivityVenueDeductionDetailBindingImpl;
import com.huachenjie.run.databinding.RunActivityWearableDeductionDetailBindingImpl;
import com.huachenjie.run.databinding.RunActivityWebviewGiftBindingImpl;
import com.huachenjie.run.databinding.RunDialogActivityRuleBindingImpl;
import com.huachenjie.run.databinding.RunDialogAllFenceListBindingImpl;
import com.huachenjie.run.databinding.RunDialogDanmuBindingImpl;
import com.huachenjie.run.databinding.RunDialogFaceRecognitionTipBindingImpl;
import com.huachenjie.run.databinding.RunDialogFenceOpenTimeListBindingImpl;
import com.huachenjie.run.databinding.RunDialogGpsErrorBindingImpl;
import com.huachenjie.run.databinding.RunDialogMoreDistanceBindingImpl;
import com.huachenjie.run.databinding.RunDialogPauseBindingImpl;
import com.huachenjie.run.databinding.RunDialogQuitConfirmBindingImpl;
import com.huachenjie.run.databinding.RunDialogRankingTipBindingImpl;
import com.huachenjie.run.databinding.RunDialogShareBindingImpl;
import com.huachenjie.run.databinding.RunDialogSunshineRunShareBindingImpl;
import com.huachenjie.run.databinding.RunFootSunshineRankBindingImpl;
import com.huachenjie.run.databinding.RunFragmentActivityRunListBindingImpl;
import com.huachenjie.run.databinding.RunFragmentCustomCaloriesBindingImpl;
import com.huachenjie.run.databinding.RunFragmentCustomDistanceBindingImpl;
import com.huachenjie.run.databinding.RunFragmentGeoFenceV3BindingImpl;
import com.huachenjie.run.databinding.RunFragmentGuideVideoBindingImpl;
import com.huachenjie.run.databinding.RunFragmentSunshineRankingBindingImpl;
import com.huachenjie.run.databinding.RunHeadActivityRuleBindingImpl;
import com.huachenjie.run.databinding.RunHeadSunshineRankBindingImpl;
import com.huachenjie.run.databinding.RunItemActivityRuleBindingImpl;
import com.huachenjie.run.databinding.RunItemActivityRunListBindingImpl;
import com.huachenjie.run.databinding.RunItemAiDeductionDetailBindingImpl;
import com.huachenjie.run.databinding.RunItemDetailFaceMachineBindingImpl;
import com.huachenjie.run.databinding.RunItemGeofenceListV2BindingImpl;
import com.huachenjie.run.databinding.RunItemIndexRecordBindingImpl;
import com.huachenjie.run.databinding.RunItemOutsideAttendDeductionDetailBindingImpl;
import com.huachenjie.run.databinding.RunItemRunFaceDetectBindingImpl;
import com.huachenjie.run.databinding.RunItemRunRecordFaceThumbBindingImpl;
import com.huachenjie.run.databinding.RunItemRunRecordStatusBindingImpl;
import com.huachenjie.run.databinding.RunItemRunTimePeriodBindingImpl;
import com.huachenjie.run.databinding.RunItemSunshineRankingBindingImpl;
import com.huachenjie.run.databinding.RunItemSunshineRunSuccessMoodBindingImpl;
import com.huachenjie.run.databinding.RunItemVenueDeductionDetailBindingImpl;
import com.huachenjie.run.databinding.RunItemWearableDeductionDetailBindingImpl;
import com.huachenjie.run.databinding.RunLayoutCaloriesCostedTargetBindingImpl;
import com.huachenjie.run.databinding.RunLayoutDistanceTargetBindingImpl;
import com.huachenjie.run.databinding.RunLayoutDurationTargetBindingImpl;
import com.huachenjie.run.databinding.RunLayoutIndexHeaderBindingImpl;
import com.huachenjie.run.databinding.RunLayoutMetricsBindingImpl;
import com.huachenjie.run.databinding.RunLayoutMetricsContentBindingImpl;
import com.huachenjie.run.databinding.RunLayoutPaceListBindingImpl;
import com.huachenjie.run.databinding.RunLayoutPauseHeaderBindingImpl;
import com.huachenjie.run.databinding.RunLayoutRunFaceDetectBindingImpl;
import com.huachenjie.run.databinding.RunLayoutRunFaceMachineBindingImpl;
import com.huachenjie.run.databinding.RunLayoutRunGuideCustomerServiceBindingImpl;
import com.huachenjie.run.databinding.RunLayoutRunGuideTipBindingImpl;
import com.huachenjie.run.databinding.RunLayoutRunRecordStatusBindingImpl;
import com.huachenjie.run.databinding.RunLayoutRunStatusSheetBindingImpl;
import com.huachenjie.run.databinding.RunLayoutRunVisionBindingImpl;
import com.huachenjie.run.databinding.RunLayoutShareActionPanelBindingImpl;
import com.huachenjie.run.databinding.RunLayoutStaticsBindingImpl;
import com.huachenjie.run.databinding.RunLayoutStepListBindingImpl;
import com.huachenjie.run.databinding.RunLayoutSunRunDebugInfoBindingImpl;
import com.huachenjie.run.databinding.RunLayoutSunRunPaceInfoBindingImpl;
import com.huachenjie.run.databinding.RunLayoutSunRunQualifyConditionsBindingImpl;
import com.huachenjie.run.databinding.RunLayoutSunRunSideToolbarBindingImpl;
import com.huachenjie.run.databinding.RunRunActivityActivityReadyBindingImpl;
import com.huachenjie.run.databinding.RunRunActivityReadyBindingImpl;
import com.huachenjie.run.databinding.RunRunActivityRunRewardBindingImpl;
import com.huachenjie.run.databinding.RunRunFragmentRunRewardListBindingImpl;
import com.huachenjie.run.databinding.RunRunItemRunRewardBindingImpl;
import com.huachenjie.run.page.sun_run.success.SchoolActivitySuccessActivity;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    public static final int A = 27;
    public static final int A0 = 79;
    public static final int B = 28;
    public static final int B0 = 80;
    public static final int C = 29;
    public static final int C0 = 81;
    public static final int D = 30;
    public static final int D0 = 82;
    public static final int E = 31;
    public static final int E0 = 83;
    public static final int F = 32;
    public static final int F0 = 84;
    public static final int G = 33;
    public static final int G0 = 85;
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
    public static final int f35426a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final SparseIntArray f11392a;
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
    public static final int o0 = 67;
    public static final int p = 16;
    public static final int p0 = 68;
    public static final int q = 17;
    public static final int q0 = 69;
    public static final int r = 18;
    public static final int r0 = 70;
    public static final int s = 19;
    public static final int s0 = 71;
    public static final int t = 20;
    public static final int t0 = 72;
    public static final int u = 21;
    public static final int u0 = 73;
    public static final int v = 22;
    public static final int v0 = 74;
    public static final int w = 23;
    public static final int w0 = 75;
    public static final int x = 24;
    public static final int x0 = 76;
    public static final int y = 25;
    public static final int y0 = 77;
    public static final int z = 26;
    public static final int z0 = 78;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SparseArray<String> f35427a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(37);
            f35427a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "adapter");
            sparseArray.put(2, "appealTime");
            sparseArray.put(3, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
            sparseArray.put(4, "cardBg");
            sparseArray.put(5, "checked");
            sparseArray.put(6, "click");
            sparseArray.put(7, "commentType");
            sparseArray.put(8, "contains");
            sparseArray.put(9, "content");
            sparseArray.put(10, "data");
            sparseArray.put(11, SchoolActivitySuccessActivity.x);
            sparseArray.put(12, "flowAdapter");
            sparseArray.put(13, "fragment");
            sparseArray.put(14, "index");
            sparseArray.put(15, "isSelf");
            sparseArray.put(16, "item");
            sparseArray.put(17, "listType");
            sparseArray.put(18, "mState");
            sparseArray.put(19, "onClick");
            sparseArray.put(20, "position");
            sparseArray.put(21, "postType");
            sparseArray.put(22, d.x);
            sparseArray.put(23, "scroll");
            sparseArray.put(24, "sexType");
            sparseArray.put(25, "showAppealTime");
            sparseArray.put(26, "showContent");
            sparseArray.put(27, "showFace");
            sparseArray.put(28, "showGradient");
            sparseArray.put(29, "showRelation");
            sparseArray.put(30, "showTag");
            sparseArray.put(31, "source");
            sparseArray.put(32, "tagBg");
            sparseArray.put(33, "tagText");
            sparseArray.put(34, "time");
            sparseArray.put(35, "title");
            sparseArray.put(36, "vm");
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashMap<String, Integer> f35428a;

        static {
            HashMap<String, Integer> map = new HashMap<>(85);
            f35428a = map;
            map.put("layout/run_activity_activity_rule_0", Integer.valueOf(R.layout.run_activity_activity_rule));
            map.put("layout/run_activity_activity_run_list_0", Integer.valueOf(R.layout.run_activity_activity_run_list));
            map.put("layout/run_activity_ai_deduction_detail_0", Integer.valueOf(R.layout.run_activity_ai_deduction_detail));
            map.put("layout/run_activity_appeal_0", Integer.valueOf(R.layout.run_activity_appeal));
            map.put("layout/run_activity_camera_run_success_0", Integer.valueOf(R.layout.run_activity_camera_run_success));
            map.put("layout/run_activity_detail_0", Integer.valueOf(R.layout.run_activity_detail));
            map.put("layout/run_activity_detail_route_0", Integer.valueOf(R.layout.run_activity_detail_route));
            map.put("layout/run_activity_free_run_experience_0", Integer.valueOf(R.layout.run_activity_free_run_experience));
            map.put("layout/run_activity_gps_diagnosis_0", Integer.valueOf(R.layout.run_activity_gps_diagnosis));
            map.put("layout/run_activity_index_0", Integer.valueOf(R.layout.run_activity_index));
            map.put("layout/run_activity_more_permission_0", Integer.valueOf(R.layout.run_activity_more_permission));
            map.put("layout/run_activity_outside_attend_deduction_detail_0", Integer.valueOf(R.layout.run_activity_outside_attend_deduction_detail));
            map.put("layout/run_activity_run_geo_guide_v3_0", Integer.valueOf(R.layout.run_activity_run_geo_guide_v3));
            map.put("layout/run_activity_run_mode_guide_0", Integer.valueOf(R.layout.run_activity_run_mode_guide));
            map.put("layout/run_activity_school_activity_run_success_0", Integer.valueOf(R.layout.run_activity_school_activity_run_success));
            map.put("layout/run_activity_school_rule_v3_0", Integer.valueOf(R.layout.run_activity_school_rule_v3));
            map.put("layout/run_activity_sunshine_ranking_0", Integer.valueOf(R.layout.run_activity_sunshine_ranking));
            map.put("layout/run_activity_sunshine_run_0", Integer.valueOf(R.layout.run_activity_sunshine_run));
            map.put("layout/run_activity_sunshine_run_success_0", Integer.valueOf(R.layout.run_activity_sunshine_run_success));
            map.put("layout/run_activity_venue_deduction_detail_0", Integer.valueOf(R.layout.run_activity_venue_deduction_detail));
            map.put("layout/run_activity_wearable_deduction_detail_0", Integer.valueOf(R.layout.run_activity_wearable_deduction_detail));
            map.put("layout/run_activity_webview_gift_0", Integer.valueOf(R.layout.run_activity_webview_gift));
            map.put("layout/run_dialog_activity_rule_0", Integer.valueOf(R.layout.run_dialog_activity_rule));
            map.put("layout/run_dialog_all_fence_list_0", Integer.valueOf(R.layout.run_dialog_all_fence_list));
            map.put("layout/run_dialog_danmu_0", Integer.valueOf(R.layout.run_dialog_danmu));
            map.put("layout/run_dialog_face_recognition_tip_0", Integer.valueOf(R.layout.run_dialog_face_recognition_tip));
            map.put("layout/run_dialog_fence_open_time_list_0", Integer.valueOf(R.layout.run_dialog_fence_open_time_list));
            map.put("layout/run_dialog_gps_error_0", Integer.valueOf(R.layout.run_dialog_gps_error));
            map.put("layout/run_dialog_more_distance_0", Integer.valueOf(R.layout.run_dialog_more_distance));
            map.put("layout/run_dialog_pause_0", Integer.valueOf(R.layout.run_dialog_pause));
            map.put("layout/run_dialog_quit_confirm_0", Integer.valueOf(R.layout.run_dialog_quit_confirm));
            map.put("layout/run_dialog_ranking_tip_0", Integer.valueOf(R.layout.run_dialog_ranking_tip));
            map.put("layout/run_dialog_share_0", Integer.valueOf(R.layout.run_dialog_share));
            map.put("layout/run_dialog_sunshine_run_share_0", Integer.valueOf(R.layout.run_dialog_sunshine_run_share));
            map.put("layout/run_foot_sunshine_rank_0", Integer.valueOf(R.layout.run_foot_sunshine_rank));
            map.put("layout/run_fragment_activity_run_list_0", Integer.valueOf(R.layout.run_fragment_activity_run_list));
            map.put("layout/run_fragment_custom_calories_0", Integer.valueOf(R.layout.run_fragment_custom_calories));
            map.put("layout/run_fragment_custom_distance_0", Integer.valueOf(R.layout.run_fragment_custom_distance));
            map.put("layout/run_fragment_geo_fence_v3_0", Integer.valueOf(R.layout.run_fragment_geo_fence_v3));
            map.put("layout/run_fragment_guide_video_0", Integer.valueOf(R.layout.run_fragment_guide_video));
            map.put("layout/run_fragment_sunshine_ranking_0", Integer.valueOf(R.layout.run_fragment_sunshine_ranking));
            map.put("layout/run_head_activity_rule_0", Integer.valueOf(R.layout.run_head_activity_rule));
            map.put("layout/run_head_sunshine_rank_0", Integer.valueOf(R.layout.run_head_sunshine_rank));
            map.put("layout/run_item_activity_rule_0", Integer.valueOf(R.layout.run_item_activity_rule));
            map.put("layout/run_item_activity_run_list_0", Integer.valueOf(R.layout.run_item_activity_run_list));
            map.put("layout/run_item_ai_deduction_detail_0", Integer.valueOf(R.layout.run_item_ai_deduction_detail));
            map.put("layout/run_item_detail_face_machine_0", Integer.valueOf(R.layout.run_item_detail_face_machine));
            map.put("layout/run_item_geofence_list_v2_0", Integer.valueOf(R.layout.run_item_geofence_list_v2));
            map.put("layout/run_item_index_record_0", Integer.valueOf(R.layout.run_item_index_record));
            map.put("layout/run_item_outside_attend_deduction_detail_0", Integer.valueOf(R.layout.run_item_outside_attend_deduction_detail));
            map.put("layout/run_item_run_face_detect_0", Integer.valueOf(R.layout.run_item_run_face_detect));
            map.put("layout/run_item_run_record_face_thumb_0", Integer.valueOf(R.layout.run_item_run_record_face_thumb));
            map.put("layout/run_item_run_record_status_0", Integer.valueOf(R.layout.run_item_run_record_status));
            map.put("layout/run_item_run_time_period_0", Integer.valueOf(R.layout.run_item_run_time_period));
            map.put("layout/run_item_sunshine_ranking_0", Integer.valueOf(R.layout.run_item_sunshine_ranking));
            map.put("layout/run_item_sunshine_run_success_mood_0", Integer.valueOf(R.layout.run_item_sunshine_run_success_mood));
            map.put("layout/run_item_venue_deduction_detail_0", Integer.valueOf(R.layout.run_item_venue_deduction_detail));
            map.put("layout/run_item_wearable_deduction_detail_0", Integer.valueOf(R.layout.run_item_wearable_deduction_detail));
            map.put("layout/run_layout_calories_costed_target_0", Integer.valueOf(R.layout.run_layout_calories_costed_target));
            map.put("layout/run_layout_distance_target_0", Integer.valueOf(R.layout.run_layout_distance_target));
            map.put("layout/run_layout_duration_target_0", Integer.valueOf(R.layout.run_layout_duration_target));
            map.put("layout/run_layout_index_header_0", Integer.valueOf(R.layout.run_layout_index_header));
            map.put("layout/run_layout_metrics_0", Integer.valueOf(R.layout.run_layout_metrics));
            map.put("layout/run_layout_metrics_content_0", Integer.valueOf(R.layout.run_layout_metrics_content));
            map.put("layout/run_layout_pace_list_0", Integer.valueOf(R.layout.run_layout_pace_list));
            map.put("layout/run_layout_pause_header_0", Integer.valueOf(R.layout.run_layout_pause_header));
            map.put("layout/run_layout_run_face_detect_0", Integer.valueOf(R.layout.run_layout_run_face_detect));
            map.put("layout/run_layout_run_face_machine_0", Integer.valueOf(R.layout.run_layout_run_face_machine));
            map.put("layout/run_layout_run_guide_customer_service_0", Integer.valueOf(R.layout.run_layout_run_guide_customer_service));
            map.put("layout/run_layout_run_guide_tip_0", Integer.valueOf(R.layout.run_layout_run_guide_tip));
            map.put("layout/run_layout_run_record_status_0", Integer.valueOf(R.layout.run_layout_run_record_status));
            map.put("layout/run_layout_run_status_sheet_0", Integer.valueOf(R.layout.run_layout_run_status_sheet));
            map.put("layout/run_layout_run_vision_0", Integer.valueOf(R.layout.run_layout_run_vision));
            map.put("layout/run_layout_share_action_panel_0", Integer.valueOf(R.layout.run_layout_share_action_panel));
            map.put("layout/run_layout_statics_0", Integer.valueOf(R.layout.run_layout_statics));
            map.put("layout/run_layout_step_list_0", Integer.valueOf(R.layout.run_layout_step_list));
            map.put("layout/run_layout_sun_run_debug_info_0", Integer.valueOf(R.layout.run_layout_sun_run_debug_info));
            map.put("layout/run_layout_sun_run_pace_info_0", Integer.valueOf(R.layout.run_layout_sun_run_pace_info));
            map.put("layout/run_layout_sun_run_qualify_conditions_0", Integer.valueOf(R.layout.run_layout_sun_run_qualify_conditions));
            map.put("layout/run_layout_sun_run_side_toolbar_0", Integer.valueOf(R.layout.run_layout_sun_run_side_toolbar));
            map.put("layout/run_run_activity_activity_ready_0", Integer.valueOf(R.layout.run_run_activity_activity_ready));
            map.put("layout/run_run_activity_ready_0", Integer.valueOf(R.layout.run_run_activity_ready));
            map.put("layout/run_run_activity_run_reward_0", Integer.valueOf(R.layout.run_run_activity_run_reward));
            map.put("layout/run_run_fragment_run_reward_list_0", Integer.valueOf(R.layout.run_run_fragment_run_reward_list));
            map.put("layout/run_run_item_run_reward_0", Integer.valueOf(R.layout.run_run_item_run_reward));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(85);
        f11392a = sparseIntArray;
        sparseIntArray.put(R.layout.run_activity_activity_rule, 1);
        sparseIntArray.put(R.layout.run_activity_activity_run_list, 2);
        sparseIntArray.put(R.layout.run_activity_ai_deduction_detail, 3);
        sparseIntArray.put(R.layout.run_activity_appeal, 4);
        sparseIntArray.put(R.layout.run_activity_camera_run_success, 5);
        sparseIntArray.put(R.layout.run_activity_detail, 6);
        sparseIntArray.put(R.layout.run_activity_detail_route, 7);
        sparseIntArray.put(R.layout.run_activity_free_run_experience, 8);
        sparseIntArray.put(R.layout.run_activity_gps_diagnosis, 9);
        sparseIntArray.put(R.layout.run_activity_index, 10);
        sparseIntArray.put(R.layout.run_activity_more_permission, 11);
        sparseIntArray.put(R.layout.run_activity_outside_attend_deduction_detail, 12);
        sparseIntArray.put(R.layout.run_activity_run_geo_guide_v3, 13);
        sparseIntArray.put(R.layout.run_activity_run_mode_guide, 14);
        sparseIntArray.put(R.layout.run_activity_school_activity_run_success, 15);
        sparseIntArray.put(R.layout.run_activity_school_rule_v3, 16);
        sparseIntArray.put(R.layout.run_activity_sunshine_ranking, 17);
        sparseIntArray.put(R.layout.run_activity_sunshine_run, 18);
        sparseIntArray.put(R.layout.run_activity_sunshine_run_success, 19);
        sparseIntArray.put(R.layout.run_activity_venue_deduction_detail, 20);
        sparseIntArray.put(R.layout.run_activity_wearable_deduction_detail, 21);
        sparseIntArray.put(R.layout.run_activity_webview_gift, 22);
        sparseIntArray.put(R.layout.run_dialog_activity_rule, 23);
        sparseIntArray.put(R.layout.run_dialog_all_fence_list, 24);
        sparseIntArray.put(R.layout.run_dialog_danmu, 25);
        sparseIntArray.put(R.layout.run_dialog_face_recognition_tip, 26);
        sparseIntArray.put(R.layout.run_dialog_fence_open_time_list, 27);
        sparseIntArray.put(R.layout.run_dialog_gps_error, 28);
        sparseIntArray.put(R.layout.run_dialog_more_distance, 29);
        sparseIntArray.put(R.layout.run_dialog_pause, 30);
        sparseIntArray.put(R.layout.run_dialog_quit_confirm, 31);
        sparseIntArray.put(R.layout.run_dialog_ranking_tip, 32);
        sparseIntArray.put(R.layout.run_dialog_share, 33);
        sparseIntArray.put(R.layout.run_dialog_sunshine_run_share, 34);
        sparseIntArray.put(R.layout.run_foot_sunshine_rank, 35);
        sparseIntArray.put(R.layout.run_fragment_activity_run_list, 36);
        sparseIntArray.put(R.layout.run_fragment_custom_calories, 37);
        sparseIntArray.put(R.layout.run_fragment_custom_distance, 38);
        sparseIntArray.put(R.layout.run_fragment_geo_fence_v3, 39);
        sparseIntArray.put(R.layout.run_fragment_guide_video, 40);
        sparseIntArray.put(R.layout.run_fragment_sunshine_ranking, 41);
        sparseIntArray.put(R.layout.run_head_activity_rule, 42);
        sparseIntArray.put(R.layout.run_head_sunshine_rank, 43);
        sparseIntArray.put(R.layout.run_item_activity_rule, 44);
        sparseIntArray.put(R.layout.run_item_activity_run_list, 45);
        sparseIntArray.put(R.layout.run_item_ai_deduction_detail, 46);
        sparseIntArray.put(R.layout.run_item_detail_face_machine, 47);
        sparseIntArray.put(R.layout.run_item_geofence_list_v2, 48);
        sparseIntArray.put(R.layout.run_item_index_record, 49);
        sparseIntArray.put(R.layout.run_item_outside_attend_deduction_detail, 50);
        sparseIntArray.put(R.layout.run_item_run_face_detect, 51);
        sparseIntArray.put(R.layout.run_item_run_record_face_thumb, 52);
        sparseIntArray.put(R.layout.run_item_run_record_status, 53);
        sparseIntArray.put(R.layout.run_item_run_time_period, 54);
        sparseIntArray.put(R.layout.run_item_sunshine_ranking, 55);
        sparseIntArray.put(R.layout.run_item_sunshine_run_success_mood, 56);
        sparseIntArray.put(R.layout.run_item_venue_deduction_detail, 57);
        sparseIntArray.put(R.layout.run_item_wearable_deduction_detail, 58);
        sparseIntArray.put(R.layout.run_layout_calories_costed_target, 59);
        sparseIntArray.put(R.layout.run_layout_distance_target, 60);
        sparseIntArray.put(R.layout.run_layout_duration_target, 61);
        sparseIntArray.put(R.layout.run_layout_index_header, 62);
        sparseIntArray.put(R.layout.run_layout_metrics, 63);
        sparseIntArray.put(R.layout.run_layout_metrics_content, 64);
        sparseIntArray.put(R.layout.run_layout_pace_list, 65);
        sparseIntArray.put(R.layout.run_layout_pause_header, 66);
        sparseIntArray.put(R.layout.run_layout_run_face_detect, 67);
        sparseIntArray.put(R.layout.run_layout_run_face_machine, 68);
        sparseIntArray.put(R.layout.run_layout_run_guide_customer_service, 69);
        sparseIntArray.put(R.layout.run_layout_run_guide_tip, 70);
        sparseIntArray.put(R.layout.run_layout_run_record_status, 71);
        sparseIntArray.put(R.layout.run_layout_run_status_sheet, 72);
        sparseIntArray.put(R.layout.run_layout_run_vision, 73);
        sparseIntArray.put(R.layout.run_layout_share_action_panel, 74);
        sparseIntArray.put(R.layout.run_layout_statics, 75);
        sparseIntArray.put(R.layout.run_layout_step_list, 76);
        sparseIntArray.put(R.layout.run_layout_sun_run_debug_info, 77);
        sparseIntArray.put(R.layout.run_layout_sun_run_pace_info, 78);
        sparseIntArray.put(R.layout.run_layout_sun_run_qualify_conditions, 79);
        sparseIntArray.put(R.layout.run_layout_sun_run_side_toolbar, 80);
        sparseIntArray.put(R.layout.run_run_activity_activity_ready, 81);
        sparseIntArray.put(R.layout.run_run_activity_ready, 82);
        sparseIntArray.put(R.layout.run_run_activity_run_reward, 83);
        sparseIntArray.put(R.layout.run_run_fragment_run_reward_list, 84);
        sparseIntArray.put(R.layout.run_run_item_run_reward, 85);
    }

    public final ViewDataBinding a(DataBindingComponent component, View view, int internalId, Object tag) {
        switch (internalId) {
            case 1:
                if ("layout/run_activity_activity_rule_0".equals(tag)) {
                    return new RunActivityActivityRuleBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_activity_activity_rule is invalid. Received: " + tag);
            case 2:
                if ("layout/run_activity_activity_run_list_0".equals(tag)) {
                    return new RunActivityActivityRunListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_activity_activity_run_list is invalid. Received: " + tag);
            case 3:
                if ("layout/run_activity_ai_deduction_detail_0".equals(tag)) {
                    return new RunActivityAiDeductionDetailBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_activity_ai_deduction_detail is invalid. Received: " + tag);
            case 4:
                if ("layout/run_activity_appeal_0".equals(tag)) {
                    return new RunActivityAppealBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_activity_appeal is invalid. Received: " + tag);
            case 5:
                if ("layout/run_activity_camera_run_success_0".equals(tag)) {
                    return new RunActivityCameraRunSuccessBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_activity_camera_run_success is invalid. Received: " + tag);
            case 6:
                if ("layout/run_activity_detail_0".equals(tag)) {
                    return new RunActivityDetailBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_activity_detail is invalid. Received: " + tag);
            case 7:
                if ("layout/run_activity_detail_route_0".equals(tag)) {
                    return new RunActivityDetailRouteBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_activity_detail_route is invalid. Received: " + tag);
            case 8:
                if ("layout/run_activity_free_run_experience_0".equals(tag)) {
                    return new RunActivityFreeRunExperienceBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_activity_free_run_experience is invalid. Received: " + tag);
            case 9:
                if ("layout/run_activity_gps_diagnosis_0".equals(tag)) {
                    return new RunActivityGpsDiagnosisBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_activity_gps_diagnosis is invalid. Received: " + tag);
            case 10:
                if ("layout/run_activity_index_0".equals(tag)) {
                    return new RunActivityIndexBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_activity_index is invalid. Received: " + tag);
            case 11:
                if ("layout/run_activity_more_permission_0".equals(tag)) {
                    return new RunActivityMorePermissionBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_activity_more_permission is invalid. Received: " + tag);
            case 12:
                if ("layout/run_activity_outside_attend_deduction_detail_0".equals(tag)) {
                    return new RunActivityOutsideAttendDeductionDetailBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_activity_outside_attend_deduction_detail is invalid. Received: " + tag);
            case 13:
                if ("layout/run_activity_run_geo_guide_v3_0".equals(tag)) {
                    return new RunActivityRunGeoGuideV3BindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_activity_run_geo_guide_v3 is invalid. Received: " + tag);
            case 14:
                if ("layout/run_activity_run_mode_guide_0".equals(tag)) {
                    return new RunActivityRunModeGuideBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_activity_run_mode_guide is invalid. Received: " + tag);
            case 15:
                if ("layout/run_activity_school_activity_run_success_0".equals(tag)) {
                    return new RunActivitySchoolActivityRunSuccessBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_activity_school_activity_run_success is invalid. Received: " + tag);
            case 16:
                if ("layout/run_activity_school_rule_v3_0".equals(tag)) {
                    return new RunActivitySchoolRuleV3BindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_activity_school_rule_v3 is invalid. Received: " + tag);
            case 17:
                if ("layout/run_activity_sunshine_ranking_0".equals(tag)) {
                    return new RunActivitySunshineRankingBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_activity_sunshine_ranking is invalid. Received: " + tag);
            case 18:
                if ("layout/run_activity_sunshine_run_0".equals(tag)) {
                    return new RunActivitySunshineRunBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_activity_sunshine_run is invalid. Received: " + tag);
            case 19:
                if ("layout/run_activity_sunshine_run_success_0".equals(tag)) {
                    return new RunActivitySunshineRunSuccessBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_activity_sunshine_run_success is invalid. Received: " + tag);
            case 20:
                if ("layout/run_activity_venue_deduction_detail_0".equals(tag)) {
                    return new RunActivityVenueDeductionDetailBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_activity_venue_deduction_detail is invalid. Received: " + tag);
            case 21:
                if ("layout/run_activity_wearable_deduction_detail_0".equals(tag)) {
                    return new RunActivityWearableDeductionDetailBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_activity_wearable_deduction_detail is invalid. Received: " + tag);
            case 22:
                if ("layout/run_activity_webview_gift_0".equals(tag)) {
                    return new RunActivityWebviewGiftBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_activity_webview_gift is invalid. Received: " + tag);
            case 23:
                if ("layout/run_dialog_activity_rule_0".equals(tag)) {
                    return new RunDialogActivityRuleBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_dialog_activity_rule is invalid. Received: " + tag);
            case 24:
                if ("layout/run_dialog_all_fence_list_0".equals(tag)) {
                    return new RunDialogAllFenceListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_dialog_all_fence_list is invalid. Received: " + tag);
            case 25:
                if ("layout/run_dialog_danmu_0".equals(tag)) {
                    return new RunDialogDanmuBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_dialog_danmu is invalid. Received: " + tag);
            case 26:
                if ("layout/run_dialog_face_recognition_tip_0".equals(tag)) {
                    return new RunDialogFaceRecognitionTipBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_dialog_face_recognition_tip is invalid. Received: " + tag);
            case 27:
                if ("layout/run_dialog_fence_open_time_list_0".equals(tag)) {
                    return new RunDialogFenceOpenTimeListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_dialog_fence_open_time_list is invalid. Received: " + tag);
            case 28:
                if ("layout/run_dialog_gps_error_0".equals(tag)) {
                    return new RunDialogGpsErrorBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_dialog_gps_error is invalid. Received: " + tag);
            case 29:
                if ("layout/run_dialog_more_distance_0".equals(tag)) {
                    return new RunDialogMoreDistanceBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_dialog_more_distance is invalid. Received: " + tag);
            case 30:
                if ("layout/run_dialog_pause_0".equals(tag)) {
                    return new RunDialogPauseBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_dialog_pause is invalid. Received: " + tag);
            case 31:
                if ("layout/run_dialog_quit_confirm_0".equals(tag)) {
                    return new RunDialogQuitConfirmBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_dialog_quit_confirm is invalid. Received: " + tag);
            case 32:
                if ("layout/run_dialog_ranking_tip_0".equals(tag)) {
                    return new RunDialogRankingTipBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_dialog_ranking_tip is invalid. Received: " + tag);
            case 33:
                if ("layout/run_dialog_share_0".equals(tag)) {
                    return new RunDialogShareBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_dialog_share is invalid. Received: " + tag);
            case 34:
                if ("layout/run_dialog_sunshine_run_share_0".equals(tag)) {
                    return new RunDialogSunshineRunShareBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_dialog_sunshine_run_share is invalid. Received: " + tag);
            case 35:
                if ("layout/run_foot_sunshine_rank_0".equals(tag)) {
                    return new RunFootSunshineRankBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_foot_sunshine_rank is invalid. Received: " + tag);
            case 36:
                if ("layout/run_fragment_activity_run_list_0".equals(tag)) {
                    return new RunFragmentActivityRunListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_fragment_activity_run_list is invalid. Received: " + tag);
            case 37:
                if ("layout/run_fragment_custom_calories_0".equals(tag)) {
                    return new RunFragmentCustomCaloriesBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_fragment_custom_calories is invalid. Received: " + tag);
            case 38:
                if ("layout/run_fragment_custom_distance_0".equals(tag)) {
                    return new RunFragmentCustomDistanceBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_fragment_custom_distance is invalid. Received: " + tag);
            case 39:
                if ("layout/run_fragment_geo_fence_v3_0".equals(tag)) {
                    return new RunFragmentGeoFenceV3BindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_fragment_geo_fence_v3 is invalid. Received: " + tag);
            case 40:
                if ("layout/run_fragment_guide_video_0".equals(tag)) {
                    return new RunFragmentGuideVideoBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_fragment_guide_video is invalid. Received: " + tag);
            case 41:
                if ("layout/run_fragment_sunshine_ranking_0".equals(tag)) {
                    return new RunFragmentSunshineRankingBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_fragment_sunshine_ranking is invalid. Received: " + tag);
            case 42:
                if ("layout/run_head_activity_rule_0".equals(tag)) {
                    return new RunHeadActivityRuleBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_head_activity_rule is invalid. Received: " + tag);
            case 43:
                if ("layout/run_head_sunshine_rank_0".equals(tag)) {
                    return new RunHeadSunshineRankBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_head_sunshine_rank is invalid. Received: " + tag);
            case 44:
                if ("layout/run_item_activity_rule_0".equals(tag)) {
                    return new RunItemActivityRuleBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_item_activity_rule is invalid. Received: " + tag);
            case 45:
                if ("layout/run_item_activity_run_list_0".equals(tag)) {
                    return new RunItemActivityRunListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_item_activity_run_list is invalid. Received: " + tag);
            case 46:
                if ("layout/run_item_ai_deduction_detail_0".equals(tag)) {
                    return new RunItemAiDeductionDetailBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_item_ai_deduction_detail is invalid. Received: " + tag);
            case 47:
                if ("layout/run_item_detail_face_machine_0".equals(tag)) {
                    return new RunItemDetailFaceMachineBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_item_detail_face_machine is invalid. Received: " + tag);
            case 48:
                if ("layout/run_item_geofence_list_v2_0".equals(tag)) {
                    return new RunItemGeofenceListV2BindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_item_geofence_list_v2 is invalid. Received: " + tag);
            case 49:
                if ("layout/run_item_index_record_0".equals(tag)) {
                    return new RunItemIndexRecordBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_item_index_record is invalid. Received: " + tag);
            case 50:
                if ("layout/run_item_outside_attend_deduction_detail_0".equals(tag)) {
                    return new RunItemOutsideAttendDeductionDetailBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_item_outside_attend_deduction_detail is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    public final ViewDataBinding b(DataBindingComponent component, View view, int internalId, Object tag) {
        switch (internalId) {
            case 51:
                if ("layout/run_item_run_face_detect_0".equals(tag)) {
                    return new RunItemRunFaceDetectBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_item_run_face_detect is invalid. Received: " + tag);
            case 52:
                if ("layout/run_item_run_record_face_thumb_0".equals(tag)) {
                    return new RunItemRunRecordFaceThumbBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_item_run_record_face_thumb is invalid. Received: " + tag);
            case 53:
                if ("layout/run_item_run_record_status_0".equals(tag)) {
                    return new RunItemRunRecordStatusBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_item_run_record_status is invalid. Received: " + tag);
            case 54:
                if ("layout/run_item_run_time_period_0".equals(tag)) {
                    return new RunItemRunTimePeriodBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_item_run_time_period is invalid. Received: " + tag);
            case 55:
                if ("layout/run_item_sunshine_ranking_0".equals(tag)) {
                    return new RunItemSunshineRankingBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_item_sunshine_ranking is invalid. Received: " + tag);
            case 56:
                if ("layout/run_item_sunshine_run_success_mood_0".equals(tag)) {
                    return new RunItemSunshineRunSuccessMoodBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_item_sunshine_run_success_mood is invalid. Received: " + tag);
            case 57:
                if ("layout/run_item_venue_deduction_detail_0".equals(tag)) {
                    return new RunItemVenueDeductionDetailBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_item_venue_deduction_detail is invalid. Received: " + tag);
            case 58:
                if ("layout/run_item_wearable_deduction_detail_0".equals(tag)) {
                    return new RunItemWearableDeductionDetailBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_item_wearable_deduction_detail is invalid. Received: " + tag);
            case 59:
                if ("layout/run_layout_calories_costed_target_0".equals(tag)) {
                    return new RunLayoutCaloriesCostedTargetBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_layout_calories_costed_target is invalid. Received: " + tag);
            case 60:
                if ("layout/run_layout_distance_target_0".equals(tag)) {
                    return new RunLayoutDistanceTargetBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_layout_distance_target is invalid. Received: " + tag);
            case 61:
                if ("layout/run_layout_duration_target_0".equals(tag)) {
                    return new RunLayoutDurationTargetBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_layout_duration_target is invalid. Received: " + tag);
            case 62:
                if ("layout/run_layout_index_header_0".equals(tag)) {
                    return new RunLayoutIndexHeaderBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_layout_index_header is invalid. Received: " + tag);
            case 63:
                if ("layout/run_layout_metrics_0".equals(tag)) {
                    return new RunLayoutMetricsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_layout_metrics is invalid. Received: " + tag);
            case 64:
                if ("layout/run_layout_metrics_content_0".equals(tag)) {
                    return new RunLayoutMetricsContentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_layout_metrics_content is invalid. Received: " + tag);
            case 65:
                if ("layout/run_layout_pace_list_0".equals(tag)) {
                    return new RunLayoutPaceListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_layout_pace_list is invalid. Received: " + tag);
            case 66:
                if ("layout/run_layout_pause_header_0".equals(tag)) {
                    return new RunLayoutPauseHeaderBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_layout_pause_header is invalid. Received: " + tag);
            case 67:
                if ("layout/run_layout_run_face_detect_0".equals(tag)) {
                    return new RunLayoutRunFaceDetectBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_layout_run_face_detect is invalid. Received: " + tag);
            case 68:
                if ("layout/run_layout_run_face_machine_0".equals(tag)) {
                    return new RunLayoutRunFaceMachineBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_layout_run_face_machine is invalid. Received: " + tag);
            case 69:
                if ("layout/run_layout_run_guide_customer_service_0".equals(tag)) {
                    return new RunLayoutRunGuideCustomerServiceBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_layout_run_guide_customer_service is invalid. Received: " + tag);
            case 70:
                if ("layout/run_layout_run_guide_tip_0".equals(tag)) {
                    return new RunLayoutRunGuideTipBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_layout_run_guide_tip is invalid. Received: " + tag);
            case 71:
                if ("layout/run_layout_run_record_status_0".equals(tag)) {
                    return new RunLayoutRunRecordStatusBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_layout_run_record_status is invalid. Received: " + tag);
            case 72:
                if ("layout/run_layout_run_status_sheet_0".equals(tag)) {
                    return new RunLayoutRunStatusSheetBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_layout_run_status_sheet is invalid. Received: " + tag);
            case 73:
                if ("layout/run_layout_run_vision_0".equals(tag)) {
                    return new RunLayoutRunVisionBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_layout_run_vision is invalid. Received: " + tag);
            case 74:
                if ("layout/run_layout_share_action_panel_0".equals(tag)) {
                    return new RunLayoutShareActionPanelBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_layout_share_action_panel is invalid. Received: " + tag);
            case 75:
                if ("layout/run_layout_statics_0".equals(tag)) {
                    return new RunLayoutStaticsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_layout_statics is invalid. Received: " + tag);
            case 76:
                if ("layout/run_layout_step_list_0".equals(tag)) {
                    return new RunLayoutStepListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_layout_step_list is invalid. Received: " + tag);
            case 77:
                if ("layout/run_layout_sun_run_debug_info_0".equals(tag)) {
                    return new RunLayoutSunRunDebugInfoBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_layout_sun_run_debug_info is invalid. Received: " + tag);
            case 78:
                if ("layout/run_layout_sun_run_pace_info_0".equals(tag)) {
                    return new RunLayoutSunRunPaceInfoBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_layout_sun_run_pace_info is invalid. Received: " + tag);
            case 79:
                if ("layout/run_layout_sun_run_qualify_conditions_0".equals(tag)) {
                    return new RunLayoutSunRunQualifyConditionsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_layout_sun_run_qualify_conditions is invalid. Received: " + tag);
            case 80:
                if ("layout/run_layout_sun_run_side_toolbar_0".equals(tag)) {
                    return new RunLayoutSunRunSideToolbarBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_layout_sun_run_side_toolbar is invalid. Received: " + tag);
            case 81:
                if ("layout/run_run_activity_activity_ready_0".equals(tag)) {
                    return new RunRunActivityActivityReadyBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_run_activity_activity_ready is invalid. Received: " + tag);
            case 82:
                if ("layout/run_run_activity_ready_0".equals(tag)) {
                    return new RunRunActivityReadyBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_run_activity_ready is invalid. Received: " + tag);
            case 83:
                if ("layout/run_run_activity_run_reward_0".equals(tag)) {
                    return new RunRunActivityRunRewardBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_run_activity_run_reward is invalid. Received: " + tag);
            case 84:
                if ("layout/run_run_fragment_run_reward_list_0".equals(tag)) {
                    return new RunRunFragmentRunRewardListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_run_fragment_run_reward_list is invalid. Received: " + tag);
            case 85:
                if ("layout/run_run_item_run_reward_0".equals(tag)) {
                    return new RunRunItemRunRewardBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for run_run_item_run_reward is invalid. Received: " + tag);
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
        arrayList.add(new com.huachenjie.step.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.works.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.coroutines.DataBinderMapper
    public String convertBrIdToString(int localId) {
        return a.f35427a.get(localId);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
        int i2 = f11392a.get(layoutId);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        int i3 = (i2 - 1) / 50;
        if (i3 == 0) {
            return a(component, view, i2, tag);
        }
        if (i3 != 1) {
            return null;
        }
        return b(component, view, i2, tag);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public int getLayoutId(String tag) {
        Integer num;
        if (tag == null || (num = b.f35428a.get(tag)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
        if (views == null || views.length == 0 || f11392a.get(layoutId) <= 0 || views[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
