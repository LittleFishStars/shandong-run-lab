package com.huachenjie.college.page.popcorn;

import com.huachenjie.college.api.CollegeModel;
import com.huachenjie.common.webview.WebViewVM;
import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.n76;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/huachenjie/college/page/popcorn/PopcornWebVm;", "Lcom/huachenjie/common/webview/WebViewVM;", "", "adCode", "", "durationTime", "startTime", "thirdUserId", "", "i", "<init>", "()V", "college_release"}, k = 1, mv = {1, 8, 0})
public final class PopcornWebVm extends WebViewVM {

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/college/page/popcorn/PopcornWebVm$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "", bo.g, "", "onCCSuccess", "college_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<Object> {
        public a(PopcornWebVm popcornWebVm) {
            super(popcornWebVm, true);
        }

        public void onCCSuccess(@Nullable Object p0) {
        }
    }

    public final void i(@NotNull String adCode, long durationTime, long startTime, @NotNull String thirdUserId) {
        Intrinsics.checkNotNullParameter(adCode, "adCode");
        Intrinsics.checkNotNullParameter(thirdUserId, "thirdUserId");
        n76.e(this, new CollegeModel().a(adCode, 1, durationTime, startTime, thirdUserId)).p5(new a(this));
    }
}
