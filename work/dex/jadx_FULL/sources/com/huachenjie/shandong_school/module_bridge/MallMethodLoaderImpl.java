package com.huachenjie.shandong_school.module_bridge;

import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.byazt.hv.TTDownloadField;
import com.huachenjie.base.module_bridge.interfaces.MallMethodLoader;
import com.huachenjie.common.callback.ValueCallback;
import com.huachenjie.mall.dialog.pay.PayDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010JF\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0016¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/shandong_school/module_bridge/MallMethodLoaderImpl;", "Lcom/huachenjie/base/module_bridge/interfaces/MallMethodLoader;", "Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "", "price", "tradeNo", "", "payRemainTime", "orderNo", "shopNo", "Lcom/huachenjie/common/callback/ValueCallback;", RenderCallContext.TYPE_CALLBACK, "", "b", "<init>", "()V", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
public final class MallMethodLoaderImpl implements MallMethodLoader {
    @Override // com.huachenjie.base.module_bridge.interfaces.MallMethodLoader
    public /* bridge */ /* synthetic */ void a(FragmentActivity fragmentActivity, String str, String str2, Integer num, String str3, String str4, ValueCallback valueCallback) {
        b(fragmentActivity, str, str2, num.intValue(), str3, str4, valueCallback);
    }

    public void b(@NotNull FragmentActivity activity, @NotNull String price, @NotNull String tradeNo, int payRemainTime, @NotNull String orderNo, @NotNull String shopNo, @NotNull final ValueCallback<Integer> callback) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(tradeNo, "tradeNo");
        Intrinsics.checkNotNullParameter(orderNo, "orderNo");
        Intrinsics.checkNotNullParameter(shopNo, "shopNo");
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        PayDialog.Companion.e(PayDialog.INSTANCE, activity, price, tradeNo, payRemainTime, orderNo, shopNo, false, new Function1<Integer, Unit>() { // from class: com.huachenjie.shandong_school.module_bridge.MallMethodLoaderImpl$showPayDialog$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                callback.onCallback(Integer.valueOf(i));
            }
        }, new Function1<Integer, Unit>() { // from class: com.huachenjie.shandong_school.module_bridge.MallMethodLoaderImpl$showPayDialog$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                callback.onCallback(Integer.valueOf(i));
            }
        }, 64, null);
    }
}
