package com.huachenjie.ad.util;

import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.ad.api.AdModel;
import com.huachenjie.common.bean.AdPlatformSwitch;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.reconfig.coroutine.CoroutineExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/ad/util/SDAdUtil;", "", "Lcom/huachenjie/common/bean/AdPlatformSwitch;", "config", "", "c", "", "advertisementPlanCode", "adPosition", "e", "d", "Lcom/huachenjie/ad/api/AdModel;", "a", "Lkotlin/Lazy;", "b", "()Lcom/huachenjie/ad/api/AdModel;", "adModel", "<init>", "()V", "ad_release"}, k = 1, mv = {1, 8, 0})
public final class SDAdUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SDAdUtil f32744a = new SDAdUtil();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final Lazy adModel = LazyKt.lazy(new Function0<AdModel>() { // from class: com.huachenjie.ad.util.SDAdUtil$adModel$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final AdModel m185invoke() {
            return new AdModel();
        }
    });

    public final AdModel b() {
        return (AdModel) adModel.getValue();
    }

    public final void c(@Nullable AdPlatformSwitch config) {
        if (config != null) {
            String linkUrl = config.getLinkUrl();
            if (linkUrl == null || linkUrl.length() == 0) {
                return;
            }
            ARouter.getInstance().build(RoutePathConstants.Common.c).withString("url", config.getLinkUrl()).navigation();
            CoroutineExtKt.c(CoroutineExtKt.a(this), false, null, null, new SDAdUtil$onAdClick$1(config, null), 7, null);
        }
    }

    public final void d(@Nullable AdPlatformSwitch config) {
        if ((config != null ? config.getAdvertisementPlanCode() : null) == null) {
            return;
        }
        CoroutineExtKt.c(CoroutineExtKt.a(this), false, null, null, new SDAdUtil$onAdShow$1(config, null), 7, null);
    }

    public final void e(@Nullable String advertisementPlanCode, @NotNull String adPosition) {
        Intrinsics.checkNotNullParameter(adPosition, "adPosition");
        if (advertisementPlanCode == null) {
            return;
        }
        CoroutineExtKt.c(CoroutineExtKt.a(this), false, null, null, new SDAdUtil$onBannerAdClick$1(advertisementPlanCode, adPosition, null), 7, null);
    }
}
