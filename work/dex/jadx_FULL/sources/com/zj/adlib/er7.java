package com.zj.adlib;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.android.arouter.launcher.ARouter;
import com.czhj.sdk.common.Constants;
import com.huachenjie.home.page.change_reward.ChangeRewardActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006¨\u0006\u000e"}, d2 = {"Lcom/zj/adlib/er7;", "", "Landroid/content/Context;", "context", "", Constants.CLICK_TYPE, "", "clickTarget", "", "b", "url", "a", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
public final class er7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final er7 f41510a = new er7();

    public final void a(@NotNull Context context, @NotNull String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        if (TextUtils.isEmpty(url)) {
            return;
        }
        if (!StringsKt.startsWith$default(url, "http", false, 2, (Object) null)) {
            url = "https://" + url;
        }
        il0.f42382a.d(context, url);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void b(@NotNull Context context, int clickType, @NotNull String clickTarget) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(clickTarget, "clickTarget");
        switch (clickType) {
            case 2:
                a(context, clickTarget);
                break;
            case 3:
                ARouter.getInstance().build(zj7.g.GOOD_DETAIL).withString("goodsNo", clickTarget).navigation();
                break;
            case 4:
                su9.l(context, clickTarget);
                break;
            case 5:
                su9.q(context, clickTarget);
                break;
            case 6:
                switch (clickTarget.hashCode()) {
                    case -1129499806:
                        if (clickTarget.equals("shandong://task/dayTask/list")) {
                            ARouter.getInstance().build(zj7.a.HOME).withString(yj7.a.HOME_TAB_NAME, fe9.b.FLASH_COINS).navigation();
                            break;
                        }
                        break;
                    case -732508227:
                        if (clickTarget.equals("shandong://jackpot/award/list")) {
                            context.startActivity(new Intent(context, (Class<?>) ChangeRewardActivity.class));
                            break;
                        }
                        break;
                    case 1041942492:
                        if (clickTarget.equals("shandong://alumnus/post/hot/firstTab")) {
                            ARouter.getInstance().build(zj7.a.HOME).withString(yj7.a.HOME_SUB_INDEX, fe9.a.HOT).navigation();
                            break;
                        }
                        break;
                    case 1106185760:
                        if (clickTarget.equals("shandong://school/locallife") && dq1.e().getMySchoolEnable()) {
                            ARouter.getInstance().build(zj7.a.HOME).withString(yj7.a.HOME_SUB_INDEX, fe9.a.THIS_SCHOOL).navigation();
                            j14.f(context, clickTarget);
                        }
                        break;
                }
                break;
            case 7:
                ARouter.getInstance().build(zj7.g.GOOD_DETAIL).withString("goodsNo", clickTarget).navigation();
                break;
        }
    }
}
