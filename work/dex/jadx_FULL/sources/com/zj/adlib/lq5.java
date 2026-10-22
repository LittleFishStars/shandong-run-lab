package com.zj.adlib;

import android.content.Context;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J:\u0010\f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J*\u0010\u000e\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0007J*\u0010\u0010\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0007R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0011R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/zj/adlib/lq5;", "", "Landroid/content/Context;", "context", "", "tabId", "tabName", "", "d", "goodTitle", "goodUrl", "goodPosition", "c", "browsingNum", "a", "browsingTime", "b", "Ljava/lang/String;", "GOOD_STUFF_TAB_EVENT_ID", "GOOD_STUFF_CLICK_EVENT_ID", "GOOD_STUFF_BROWSING_NUM_EVENT_ID", "GOOD_STUFF_BROWSING_TIME_EVENT_ID", "", "", "Ljava/util/Map;", "tabUploadTimeMap", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class lq5 {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String GOOD_STUFF_TAB_EVENT_ID = "click_good_stuff_tab";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final String GOOD_STUFF_CLICK_EVENT_ID = "click_good_stuff";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public static final String GOOD_STUFF_BROWSING_NUM_EVENT_ID = "good_stuff_browsing_num";

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public static final String GOOD_STUFF_BROWSING_TIME_EVENT_ID = "good_stuff_browsing_time";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final lq5 f43130a = new lq5();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final Map<String, Long> tabUploadTimeMap = new LinkedHashMap();

    @JvmStatic
    public static final void a(@Nullable Context context, @NotNull String tabId, @NotNull String tabName, @NotNull String browsingNum) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        Intrinsics.checkNotNullParameter(browsingNum, "browsingNum");
        try {
            HashMap map = new HashMap();
            map.put("tabId", tabId);
            map.put("tabName", tabName);
            map.put("browsingNum", browsingNum);
            kq5.b(context, GOOD_STUFF_BROWSING_NUM_EVENT_ID, map);
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final void b(@Nullable Context context, @NotNull String tabId, @NotNull String tabName, @NotNull String browsingTime) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        Intrinsics.checkNotNullParameter(browsingTime, "browsingTime");
        try {
            HashMap map = new HashMap();
            map.put("tabId", tabId);
            map.put("tabName", tabName);
            map.put("browsingTime", browsingTime);
            kq5.b(context, GOOD_STUFF_BROWSING_TIME_EVENT_ID, map);
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final void c(@Nullable Context context, @NotNull String tabId, @NotNull String tabName, @NotNull String goodTitle, @NotNull String goodUrl, @NotNull String goodPosition) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        Intrinsics.checkNotNullParameter(goodTitle, "goodTitle");
        Intrinsics.checkNotNullParameter(goodUrl, "goodUrl");
        Intrinsics.checkNotNullParameter(goodPosition, "goodPosition");
        try {
            HashMap map = new HashMap();
            map.put("tabId", tabId);
            map.put("tabName", tabName);
            map.put("goodTitle", goodTitle);
            map.put("goodUrl", goodUrl);
            map.put("goodPosition", goodPosition);
            kq5.b(context, GOOD_STUFF_CLICK_EVENT_ID, map);
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final void d(@Nullable Context context, @NotNull String tabId, @NotNull String tabName) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        try {
            Map<String, Long> map = tabUploadTimeMap;
            Long l = map.get(tabId);
            long jLongValue = l != null ? l.longValue() : 0L;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - jLongValue > 30000) {
                map.put(tabId, Long.valueOf(jCurrentTimeMillis));
                HashMap map2 = new HashMap();
                map2.put("tabId", tabId);
                map2.put("tabName", tabName);
                kq5.b(context, GOOD_STUFF_TAB_EVENT_ID, map2);
                return;
            }
            i4a.a(tabId + '-' + tabName + " 上报间隔小于30s");
        } catch (Exception unused) {
        }
    }
}
