package com.zj.adlib;

import android.content.Context;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0017\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 J2\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007J\u001a\u0010\f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u001a\u0010\u000e\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u001a\u0010\u0010\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\u0012\u0010\u0011\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u001a\u0010\u0012\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u001a\u0010\u0015\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\bH\u0007R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0016R\u0014\u0010\u001c\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/zj/adlib/j14;", "", "Landroid/content/Context;", "context", "", "clickName", "daziId", "daziType", "", "daziPosition", "", "c", "b", "bannerName", y6b.f, "lotteryType", "e", "a", "f", "d", "pageNum", y6b.g, "Ljava/lang/String;", "CLICK_HOME_EVENT_ID", "CLICK_SEA_VIEW_EVENT_ID", "CLICK_LOTTERY_EVENT_ID", "CLICK_CHARACTER_EVENT_ID", "CLICK_SCHOOL_WALL_EVENT_ID", "CLICK_HOME_SPACE_EVENT_ID", "VIEW_RECOMMEND_EVENT_ID", "CLICK_HOME_DAZI_EVENT_ID", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class j14 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j14 f42486a = new j14();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String CLICK_HOME_EVENT_ID = "click_home_event";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final String CLICK_SEA_VIEW_EVENT_ID = "click_sea_view_banner";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public static final String CLICK_LOTTERY_EVENT_ID = "click_lottery_draw";

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public static final String CLICK_CHARACTER_EVENT_ID = "click_character_user";

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public static final String CLICK_SCHOOL_WALL_EVENT_ID = "click_sea_jump_school_wall";

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public static final String CLICK_HOME_SPACE_EVENT_ID = "click_home_space";

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public static final String VIEW_RECOMMEND_EVENT_ID = "view_recommend_page_number";

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public static final String CLICK_HOME_DAZI_EVENT_ID = "click_home_dazi";

    @JvmStatic
    public static final void a(@Nullable Context context) {
        try {
            kq5.b(context, CLICK_CHARACTER_EVENT_ID, null);
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final void b(@Nullable Context context, @NotNull String clickName) {
        Intrinsics.checkNotNullParameter(clickName, "clickName");
        try {
            HashMap map = new HashMap();
            map.put("clickName", clickName);
            kq5.b(context, CLICK_HOME_EVENT_ID, map);
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final void c(@Nullable Context context, @NotNull String clickName, @NotNull String daziId, @NotNull String daziType, int daziPosition) {
        Intrinsics.checkNotNullParameter(clickName, "clickName");
        Intrinsics.checkNotNullParameter(daziId, "daziId");
        Intrinsics.checkNotNullParameter(daziType, "daziType");
        try {
            HashMap map = new HashMap();
            map.put("clickName", clickName);
            map.put("daziId", daziId);
            map.put("daziType", daziType);
            map.put("daziPosition", String.valueOf(daziPosition));
            kq5.b(context, CLICK_HOME_DAZI_EVENT_ID, map);
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final void d(@Nullable Context context) {
        try {
            kq5.b(context, CLICK_HOME_SPACE_EVENT_ID, null);
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final void e(@Nullable Context context, @NotNull String lotteryType) {
        Intrinsics.checkNotNullParameter(lotteryType, "lotteryType");
        try {
            HashMap map = new HashMap();
            map.put("lotteryType", lotteryType);
            kq5.b(context, CLICK_LOTTERY_EVENT_ID, map);
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final void f(@Nullable Context context, @NotNull String bannerName) {
        Intrinsics.checkNotNullParameter(bannerName, "bannerName");
        try {
            HashMap map = new HashMap();
            map.put("bannerName", bannerName);
            kq5.b(context, CLICK_SCHOOL_WALL_EVENT_ID, map);
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final void g(@Nullable Context context, @NotNull String bannerName) {
        Intrinsics.checkNotNullParameter(bannerName, "bannerName");
        try {
            HashMap map = new HashMap();
            map.put("bannerName", bannerName);
            kq5.b(context, CLICK_SEA_VIEW_EVENT_ID, map);
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final void h(@Nullable Context context, int pageNum) {
        try {
            HashMap map = new HashMap();
            map.put("pageNum", String.valueOf(pageNum));
            kq5.b(context, VIEW_RECOMMEND_EVENT_ID, map);
        } catch (Exception unused) {
        }
    }
}
