package com.zj.adlib;

import android.content.Context;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J*\u0010\f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J:\u0010\u0010\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u001a\u0010\u0011\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0007R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/zj/adlib/mq5;", "", "Landroid/content/Context;", "context", "", "goodPosition", "goodUrl", "", "b", "tabName", "browsingTime", "browsingNum", "c", "goodId", "goodName", "goodPrice", "a", "d", "Ljava/lang/String;", "CLICK_HOME_GOOD_STUFF_EVENT_ID", "GOOD_BROWSING_EVENT_ID", "CLICK_GOOD_EVENT_ID", "SHOW_GOOD_DETAIL_EVENT_ID", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class mq5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final mq5 f43365a = new mq5();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String CLICK_HOME_GOOD_STUFF_EVENT_ID = "click_home_good_stuff_header";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final String GOOD_BROWSING_EVENT_ID = "mall_good_browsing";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public static final String CLICK_GOOD_EVENT_ID = "click_good_item";

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public static final String SHOW_GOOD_DETAIL_EVENT_ID = "show_good_detail";

    @JvmStatic
    public static final void a(@Nullable Context context, @NotNull String tabName, @NotNull String goodId, @NotNull String goodName, @NotNull String goodPrice, @NotNull String goodPosition) {
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        Intrinsics.checkNotNullParameter(goodId, "goodId");
        Intrinsics.checkNotNullParameter(goodName, "goodName");
        Intrinsics.checkNotNullParameter(goodPrice, "goodPrice");
        Intrinsics.checkNotNullParameter(goodPosition, "goodPosition");
        try {
            HashMap map = new HashMap();
            map.put("tabName", tabName);
            map.put("goodId", goodId);
            map.put("goodName", goodName);
            map.put("goodPrice", goodPrice);
            map.put("goodPosition", goodPosition);
            kq5.b(context, CLICK_GOOD_EVENT_ID, map);
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final void b(@Nullable Context context, @NotNull String goodPosition, @NotNull String goodUrl) {
        Intrinsics.checkNotNullParameter(goodPosition, "goodPosition");
        Intrinsics.checkNotNullParameter(goodUrl, "goodUrl");
        try {
            HashMap map = new HashMap();
            map.put("goodPosition", goodPosition);
            map.put("goodUrl", goodUrl);
            kq5.b(context, CLICK_HOME_GOOD_STUFF_EVENT_ID, map);
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final void c(@Nullable Context context, @NotNull String tabName, @NotNull String browsingTime, @NotNull String browsingNum) {
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        Intrinsics.checkNotNullParameter(browsingTime, "browsingTime");
        Intrinsics.checkNotNullParameter(browsingNum, "browsingNum");
        try {
            HashMap map = new HashMap();
            map.put("tabName", tabName);
            map.put("browsingTime", browsingTime);
            map.put("browsingNum", browsingNum);
            kq5.b(context, GOOD_BROWSING_EVENT_ID, map);
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final void d(@Nullable Context context, @NotNull String goodId) {
        Intrinsics.checkNotNullParameter(goodId, "goodId");
        try {
            HashMap map = new HashMap();
            map.put("goodId", goodId);
            kq5.b(context, SHOW_GOOD_DETAIL_EVENT_ID, map);
        } catch (Exception unused) {
        }
    }
}
