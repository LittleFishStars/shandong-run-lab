package com.zj.adlib;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.huachenjie.base.internal.AdCancelInterface;
import com.huachenjie.base.util.ThirdUtil;
import com.huachenjie.channel.page.notify.broad_build.NotifyBroadBuildActivity;
import com.huachenjie.channel.page.notify.fans.NotifyFansActivity;
import com.huachenjie.channel.page.notify.favorites.NotifyFavoritesActivity;
import com.huachenjie.channel.page.notify.friend_apply.FriendApplyListActivity;
import com.huachenjie.channel.page.notify.mailbox.NotifyMailBoxActivity;
import com.huachenjie.channel.page.notify.post.NotifyPostActivity;
import com.huachenjie.common.constants.Environment;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.huachenjie.mall.page.order_detail.OrderDetailActivity;
import com.huachenjie.mall.page.refund_detail.RefundDetailActivity;
import com.huachenjie.push.interfaces.PushMessageListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002¨\u0006\u000e"}, d2 = {"Lcom/zj/adlib/q47;", "Lcom/huachenjie/push/interfaces/PushMessageListener;", "Landroid/app/Activity;", "context", "", "json", "", "a", "", "c", CachedContentIndex.a.e, "b", "<init>", "()V", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
public final class q47 implements PushMessageListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f44122a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final a f18998a = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final String f18999a = "notifyType";
    public static final int b = 2;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NotNull
    public static final String f19000b = "extendParam";
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 6;
    public static final int g = 7;
    public static final int h = 8;
    public static final int i = 9;
    public static final int j = 10;
    public static final int k = 11;
    public static final int l = 12;
    public static final int m = 13;
    public static final int n = 14;
    public static final int o = 15;
    public static final int p = 16;
    public static final int q = 17;
    public static final int r = 18;
    public static final int s = 19;
    public static final int t = 20;
    public static final int u = 21;
    public static final int v = 22;
    public static final int w = 23;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\bR\u0014\u0010\u0012\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\bR\u0014\u0010\u0014\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\bR\u0014\u0010\u0015\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\bR\u0014\u0010\u0016\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\bR\u0014\u0010\u0017\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\bR\u0014\u0010\u0018\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\bR\u0014\u0010\u0019\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\bR\u0014\u0010\u001a\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\bR\u0014\u0010\u001b\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\bR\u0014\u0010\u001c\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\bR\u0014\u0010\u001d\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\bR\u0014\u0010\u001e\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\b¨\u0006!"}, d2 = {"Lcom/zj/adlib/q47$a;", "", "", "KEY_EXTEND_PARAM", "Ljava/lang/String;", "KEY_TYPE", "", "TYPE_AFTER_SALE", "I", "TYPE_BROADCAST_AT", "TYPE_BROADCAST_COMMENT", "TYPE_BROADCAST_LIKE", "TYPE_CHANNEL_AUDIT", "TYPE_FRIEND_APPLE", "TYPE_FRIEND_DYNAMIC", "TYPE_NEW_ATTENTION", "TYPE_ORDER_DETAIL", "TYPE_POST_COMMENT", "TYPE_POST_LIKE", "TYPE_RECEIVE_INSPIRATION", "TYPE_RUNNING_APPEAL", "TYPE_RUNNING_RECORD", "TYPE_SHOPPING", "TYPE_SMALL_PAGE", "TYPE_STADIUM_MESSAGE", "TYPE_TASK_DONE", "TYPE_WORKS_AT", "TYPE_WORKS_AUDIT", "TYPE_WORKS_COLLECTION", "TYPE_WORKS_COMMENT", "TYPE_WORKS_LIKE", "<init>", "()V", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.huachenjie.push.interfaces.PushMessageListener
    public void a(@NotNull Activity context, @NotNull String json) {
        int iC;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(json, "json");
        ThirdUtil thirdUtil = ThirdUtil.f7255a;
        Application application = context.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "context.application");
        thirdUtil.h(application);
        if (!ai9.l()) {
            if (com.blankj.utilcode.util.a.D().size() == 1) {
                ActivityLifecycleManager.l().j(zj7.f.LOGIN);
            }
            return;
        }
        if (ai9.o(ai9.e().getUserType()) || (ActivityLifecycleManager.l().q() instanceof AdCancelInterface) || (iC = c(json)) <= 0) {
            return;
        }
        switch (iC) {
            case 1:
            case 2:
                ARouter.getInstance().build(RoutePathConstants.Sport.j).navigation();
                break;
            case 4:
            case 5:
                context.startActivity(new Intent(context, (Class<?>) NotifyFavoritesActivity.class));
                break;
            case 6:
            case 7:
                ARouter.getInstance().build(zj7.i.COMMENT_ON_ME_LIST).navigation();
                break;
            case 8:
            case 9:
            case 10:
                NotifyBroadBuildActivity.INSTANCE.a(context, iC == 8 ? 0 : 1);
                break;
            case 11:
                context.startActivity(new Intent(context, (Class<?>) NotifyFansActivity.class));
                break;
            case 12:
                context.startActivity(new Intent(context, (Class<?>) FriendApplyListActivity.class));
                break;
            case 14:
            case 15:
                context.startActivity(new Intent(context, (Class<?>) NotifyMailBoxActivity.class));
                break;
            case 16:
            case 17:
                NotifyPostActivity.INSTANCE.a(context, iC == 16 ? 0 : 1);
                break;
            case 18:
                su9.v(context, Environment.c + "/#/mall/mall-flash-sale?activityNo=" + b(json, "activityNo"));
                break;
            case 19:
                OrderDetailActivity.INSTANCE.a(context, b(json, "orderNo"));
                break;
            case 20:
                context.startActivity(RefundDetailActivity.INSTANCE.a(context, b(json, "refundOrderNo")));
                break;
            case 21:
                su9.u(context, b(json, "bizNo"));
                break;
            case 22:
            case 23:
                ARouter.getInstance().build(zj7.a.HOME).withString(yj7.a.HOME_TAB_NAME, fe9.b.FLASH_COINS).navigation();
                break;
        }
    }

    public final String b(String json, String key) {
        try {
            String strOptString = new JSONObject(new JSONObject(json).optString(f19000b)).optString(key);
            Intrinsics.checkNotNullExpressionValue(strOptString, "jsonObject.optString(key)");
            return strOptString;
        } catch (Exception unused) {
            return "";
        }
    }

    public final int c(String json) {
        try {
            return new JSONObject(json).getInt(f18999a);
        } catch (Exception unused) {
            return -1;
        }
    }
}
