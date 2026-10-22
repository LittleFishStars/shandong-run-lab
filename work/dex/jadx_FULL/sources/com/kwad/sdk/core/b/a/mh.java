package com.kwad.sdk.core.b.a;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class mh implements com.kwad.sdk.core.d<SplashMonitorInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((SplashMonitorInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((SplashMonitorInfo) bVar, jSONObject);
    }

    private static void a(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashMonitorInfo.status = jSONObject.optInt("status");
        splashMonitorInfo.type = jSONObject.optInt("type");
        splashMonitorInfo.preloadId = jSONObject.optString("preload_id");
        if (JSONObject.NULL.toString().equals(splashMonitorInfo.preloadId)) {
            splashMonitorInfo.preloadId = "";
        }
        splashMonitorInfo.checkStatus = jSONObject.optInt("check_status");
        splashMonitorInfo.loadDataTime = jSONObject.optLong("load_data_duration_ms");
        splashMonitorInfo.beforeLoadDataTime = jSONObject.optLong("before_load_data_duration_ms");
        splashMonitorInfo.checkDataTime = jSONObject.optLong("check_data_duration_ms");
        splashMonitorInfo.loadAndCheckDataTime = jSONObject.optLong("load_and_check_data_duration_ms");
        splashMonitorInfo.costTime = jSONObject.optLong("duration_ms");
        splashMonitorInfo.ids = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ids");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                splashMonitorInfo.ids.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
        splashMonitorInfo.count = jSONObject.optInt("count");
        splashMonitorInfo.cacheValidTime = jSONObject.optLong("validity_period_ms");
        splashMonitorInfo.size = jSONObject.optLong("size");
        splashMonitorInfo.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(splashMonitorInfo.url)) {
            splashMonitorInfo.url = "";
        }
        splashMonitorInfo.creativeId = jSONObject.optLong("creative_id");
        splashMonitorInfo.materialType = jSONObject.optInt("material_type");
        splashMonitorInfo.totalCount = jSONObject.optInt("total_count");
        splashMonitorInfo.creativeIds = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("creative_ids");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                splashMonitorInfo.creativeIds.add((String) jSONArrayOptJSONArray2.opt(i2));
            }
        }
        splashMonitorInfo.preloadIds = new ArrayList();
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("preload_ids");
        if (jSONArrayOptJSONArray3 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                splashMonitorInfo.preloadIds.add((String) jSONArrayOptJSONArray3.opt(i3));
            }
        }
        splashMonitorInfo.materialTypes = new ArrayList();
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("material_types");
        if (jSONArrayOptJSONArray4 != null) {
            for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                splashMonitorInfo.materialTypes.add((Integer) jSONArrayOptJSONArray4.opt(i4));
            }
        }
        splashMonitorInfo.updateType = jSONObject.optInt(HiAnalyticsConstant.BI_KEY_UPDATE_TYPE);
        splashMonitorInfo.clearCount = jSONObject.optInt("clear_count");
        splashMonitorInfo.clearImageCount = jSONObject.optInt("clear_image_count");
        splashMonitorInfo.clearVideoCount = jSONObject.optInt("clear_video_count");
        splashMonitorInfo.requestType = jSONObject.optInt("request_type");
        splashMonitorInfo.loadType = jSONObject.optInt("load_type");
        splashMonitorInfo.posId = jSONObject.optLong("pos_Id");
        splashMonitorInfo.viewSource = jSONObject.optInt("view_source");
        splashMonitorInfo.elementTypes = new ArrayList();
        JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("element_types");
        if (jSONArrayOptJSONArray5 != null) {
            for (int i5 = 0; i5 < jSONArrayOptJSONArray5.length(); i5++) {
                splashMonitorInfo.elementTypes.add((Integer) jSONArrayOptJSONArray5.opt(i5));
            }
        }
        splashMonitorInfo.interactiveStyle = jSONObject.optString("interactive_style");
        if (JSONObject.NULL.toString().equals(splashMonitorInfo.interactiveStyle)) {
            splashMonitorInfo.interactiveStyle = "";
        }
        splashMonitorInfo.interactivityDefaultStyle = jSONObject.optString("interactivity_default_style");
        if (JSONObject.NULL.toString().equals(splashMonitorInfo.interactivityDefaultStyle)) {
            splashMonitorInfo.interactivityDefaultStyle = "";
        }
        splashMonitorInfo.showEndTime = jSONObject.optLong("show_end_time");
        splashMonitorInfo.isRotateComposeTimeout = jSONObject.optBoolean("is_rotate_compose_timeout");
        splashMonitorInfo.tkDefaultTimeout = jSONObject.optLong("tk_default_timeout");
        splashMonitorInfo.soSource = jSONObject.optInt("so_source");
        splashMonitorInfo.soLoadTime = jSONObject.optLong("so_load_time");
        splashMonitorInfo.offlineSource = jSONObject.optInt("offline_source");
        splashMonitorInfo.offlineLoadTime = jSONObject.optLong("offline_load_time");
        splashMonitorInfo.tkFileLoadTime = jSONObject.optLong("tk_file_load_time");
        splashMonitorInfo.tkInitTime = jSONObject.optLong("tk_init_time");
        splashMonitorInfo.tkRenderTime = jSONObject.optLong("tk_render_time");
        splashMonitorInfo.nativeLoadTime = jSONObject.optLong("native_load_time");
        splashMonitorInfo.isWebTimeout = jSONObject.optBoolean("is_web_timeout");
        splashMonitorInfo.webLoadTime = jSONObject.optLong("web_load_time");
        splashMonitorInfo.templateId = jSONObject.optString("template_id");
        if (JSONObject.NULL.toString().equals(splashMonitorInfo.templateId)) {
            splashMonitorInfo.templateId = "";
        }
        splashMonitorInfo.templateVersionCode = jSONObject.optInt("template_version_code");
        splashMonitorInfo.tkTotalTime = jSONObject.optLong("tk_total_time");
        splashMonitorInfo.actionType = jSONObject.optInt("action_type");
        splashMonitorInfo.callbackType = jSONObject.optInt("callback_type");
        splashMonitorInfo.tkRenderType = jSONObject.optLong("tk_render_type");
        splashMonitorInfo.loadProcessType = jSONObject.optLong("load_process_type");
        splashMonitorInfo.rootVisible = jSONObject.optBoolean("root_visible");
        splashMonitorInfo.parentVisible = jSONObject.optBoolean("parent_visible");
        splashMonitorInfo.addLoadTime = jSONObject.optLong("add_load_time");
        splashMonitorInfo.buriedPointOptimizeType = jSONObject.optInt("buried_point_optimize_type");
        splashMonitorInfo.visibleCheckDelayTime = jSONObject.optLong("visible_check_delay_time");
        splashMonitorInfo.requestLoadTime = jSONObject.optLong("request_load_Time");
        splashMonitorInfo.showType = jSONObject.optInt("show_type");
        splashMonitorInfo.showDurationMs = jSONObject.optLong("show_duration_ms");
        splashMonitorInfo.hasUnbind = jSONObject.optBoolean("has_unbind");
    }

    private static JSONObject b(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = splashMonitorInfo.status;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", i);
        }
        int i2 = splashMonitorInfo.type;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "type", i2);
        }
        String str = splashMonitorInfo.preloadId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "preload_id", splashMonitorInfo.preloadId);
        }
        int i3 = splashMonitorInfo.checkStatus;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "check_status", i3);
        }
        long j = splashMonitorInfo.loadDataTime;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "load_data_duration_ms", j);
        }
        long j2 = splashMonitorInfo.beforeLoadDataTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "before_load_data_duration_ms", j2);
        }
        long j3 = splashMonitorInfo.checkDataTime;
        if (j3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "check_data_duration_ms", j3);
        }
        long j4 = splashMonitorInfo.loadAndCheckDataTime;
        if (j4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "load_and_check_data_duration_ms", j4);
        }
        long j5 = splashMonitorInfo.costTime;
        if (j5 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "duration_ms", j5);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "ids", splashMonitorInfo.ids);
        int i4 = splashMonitorInfo.count;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "count", i4);
        }
        long j6 = splashMonitorInfo.cacheValidTime;
        if (j6 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "validity_period_ms", j6);
        }
        long j7 = splashMonitorInfo.size;
        if (j7 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "size", j7);
        }
        String str2 = splashMonitorInfo.url;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "url", splashMonitorInfo.url);
        }
        long j8 = splashMonitorInfo.creativeId;
        if (j8 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "creative_id", j8);
        }
        int i5 = splashMonitorInfo.materialType;
        if (i5 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "material_type", i5);
        }
        int i6 = splashMonitorInfo.totalCount;
        if (i6 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "total_count", i6);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "creative_ids", splashMonitorInfo.creativeIds);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "preload_ids", splashMonitorInfo.preloadIds);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "material_types", splashMonitorInfo.materialTypes);
        int i7 = splashMonitorInfo.updateType;
        if (i7 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, HiAnalyticsConstant.BI_KEY_UPDATE_TYPE, i7);
        }
        int i8 = splashMonitorInfo.clearCount;
        if (i8 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "clear_count", i8);
        }
        int i9 = splashMonitorInfo.clearImageCount;
        if (i9 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "clear_image_count", i9);
        }
        int i10 = splashMonitorInfo.clearVideoCount;
        if (i10 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "clear_video_count", i10);
        }
        int i11 = splashMonitorInfo.requestType;
        if (i11 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "request_type", i11);
        }
        int i12 = splashMonitorInfo.loadType;
        if (i12 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "load_type", i12);
        }
        long j9 = splashMonitorInfo.posId;
        if (j9 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pos_Id", j9);
        }
        int i13 = splashMonitorInfo.viewSource;
        if (i13 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "view_source", i13);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "element_types", splashMonitorInfo.elementTypes);
        String str3 = splashMonitorInfo.interactiveStyle;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "interactive_style", splashMonitorInfo.interactiveStyle);
        }
        String str4 = splashMonitorInfo.interactivityDefaultStyle;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "interactivity_default_style", splashMonitorInfo.interactivityDefaultStyle);
        }
        long j10 = splashMonitorInfo.showEndTime;
        if (j10 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "show_end_time", j10);
        }
        boolean z = splashMonitorInfo.isRotateComposeTimeout;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "is_rotate_compose_timeout", z);
        }
        long j11 = splashMonitorInfo.tkDefaultTimeout;
        if (j11 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "tk_default_timeout", j11);
        }
        int i14 = splashMonitorInfo.soSource;
        if (i14 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "so_source", i14);
        }
        long j12 = splashMonitorInfo.soLoadTime;
        if (j12 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "so_load_time", j12);
        }
        int i15 = splashMonitorInfo.offlineSource;
        if (i15 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "offline_source", i15);
        }
        long j13 = splashMonitorInfo.offlineLoadTime;
        if (j13 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "offline_load_time", j13);
        }
        long j14 = splashMonitorInfo.tkFileLoadTime;
        if (j14 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "tk_file_load_time", j14);
        }
        long j15 = splashMonitorInfo.tkInitTime;
        if (j15 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "tk_init_time", j15);
        }
        long j16 = splashMonitorInfo.tkRenderTime;
        if (j16 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "tk_render_time", j16);
        }
        long j17 = splashMonitorInfo.nativeLoadTime;
        if (j17 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "native_load_time", j17);
        }
        boolean z2 = splashMonitorInfo.isWebTimeout;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "is_web_timeout", z2);
        }
        long j18 = splashMonitorInfo.webLoadTime;
        if (j18 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "web_load_time", j18);
        }
        String str5 = splashMonitorInfo.templateId;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "template_id", splashMonitorInfo.templateId);
        }
        int i16 = splashMonitorInfo.templateVersionCode;
        if (i16 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "template_version_code", i16);
        }
        long j19 = splashMonitorInfo.tkTotalTime;
        if (j19 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "tk_total_time", j19);
        }
        int i17 = splashMonitorInfo.actionType;
        if (i17 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "action_type", i17);
        }
        int i18 = splashMonitorInfo.callbackType;
        if (i18 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "callback_type", i18);
        }
        long j20 = splashMonitorInfo.tkRenderType;
        if (j20 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "tk_render_type", j20);
        }
        long j21 = splashMonitorInfo.loadProcessType;
        if (j21 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "load_process_type", j21);
        }
        boolean z3 = splashMonitorInfo.rootVisible;
        if (z3) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "root_visible", z3);
        }
        boolean z4 = splashMonitorInfo.parentVisible;
        if (z4) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "parent_visible", z4);
        }
        long j22 = splashMonitorInfo.addLoadTime;
        if (j22 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "add_load_time", j22);
        }
        int i19 = splashMonitorInfo.buriedPointOptimizeType;
        if (i19 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "buried_point_optimize_type", i19);
        }
        long j23 = splashMonitorInfo.visibleCheckDelayTime;
        if (j23 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "visible_check_delay_time", j23);
        }
        long j24 = splashMonitorInfo.requestLoadTime;
        if (j24 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "request_load_Time", j24);
        }
        int i20 = splashMonitorInfo.showType;
        if (i20 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "show_type", i20);
        }
        long j25 = splashMonitorInfo.showDurationMs;
        if (j25 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "show_duration_ms", j25);
        }
        boolean z5 = splashMonitorInfo.hasUnbind;
        if (z5) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "has_unbind", z5);
        }
        return jSONObject;
    }
}
