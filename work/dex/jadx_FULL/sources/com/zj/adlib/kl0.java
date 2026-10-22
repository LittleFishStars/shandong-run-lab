package com.zj.adlib;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.Lifecycle;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.byazt.hv.TTDownloadField;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.ad.interfaces.BannerAdListener;
import com.huachenjie.ad.interfaces.NativeAdListener;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013JJ\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007¨\u0006\u0014"}, d2 = {"Lcom/zj/adlib/kl0;", "", "Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "", "posId", "compliancePosId", "Landroidx/lifecycle/Lifecycle;", RequestParameters.SUBRESOURCE_LIFECYCLE, "Landroid/view/ViewGroup;", "container", "", "widthPixels", "heightPixels", "Lcom/huachenjie/ad/interfaces/BannerAdListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "", "a", "<init>", "()V", "ad_release"}, k = 1, mv = {1, 8, 0})
public final class kl0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final kl0 f42845a = new kl0();

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000e"}, d2 = {"com/zj/adlib/kl0$a", "Lcom/huachenjie/ad/interfaces/NativeAdListener;", "", "loadSupplier", "", "d", "", "platform", "e", "b", "a", "code", "message", "c", "ad_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends NativeAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BannerAdListener f42846a;

        public a(BannerAdListener bannerAdListener) {
            this.f42846a = bannerAdListener;
        }

        @Override // com.huachenjie.ad.interfaces.NativeAdListener
        public void a(int loadSupplier, @Nullable String platform) {
            BannerAdListener bannerAdListener = this.f42846a;
            if (bannerAdListener != null) {
                bannerAdListener.c(loadSupplier);
            }
        }

        @Override // com.huachenjie.ad.interfaces.NativeAdListener
        public void b(int loadSupplier) {
            BannerAdListener bannerAdListener = this.f42846a;
            if (bannerAdListener != null) {
                bannerAdListener.a(loadSupplier);
            }
        }

        @Override // com.huachenjie.ad.interfaces.NativeAdListener
        public void c(int loadSupplier, @Nullable String code, @Nullable String message) {
            BannerAdListener bannerAdListener = this.f42846a;
            if (bannerAdListener != null) {
                bannerAdListener.d(loadSupplier, code, message);
            }
        }

        @Override // com.huachenjie.ad.interfaces.NativeAdListener
        public void d(int loadSupplier) {
            BannerAdListener bannerAdListener = this.f42846a;
            if (bannerAdListener != null) {
                bannerAdListener.b(loadSupplier);
            }
        }

        @Override // com.huachenjie.ad.interfaces.NativeAdListener
        public void e(int loadSupplier, @Nullable String platform) {
            BannerAdListener bannerAdListener = this.f42846a;
            if (bannerAdListener != null) {
                bannerAdListener.e(loadSupplier, platform);
            }
        }
    }

    @JvmStatic
    public static final void a(@NotNull FragmentActivity activity, @NotNull String posId, @NotNull String compliancePosId, @NotNull Lifecycle lifecycle, @NotNull ViewGroup container, int widthPixels, int heightPixels, @Nullable BannerAdListener listener) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(posId, "posId");
        Intrinsics.checkNotNullParameter(compliancePosId, "compliancePosId");
        Intrinsics.checkNotNullParameter(lifecycle, RequestParameters.SUBRESOURCE_LIFECYCLE);
        Intrinsics.checkNotNullParameter(container, "container");
        if (r90.c()) {
            ew.l().e(compliancePosId, activity, container, new a(listener));
        } else {
            ew.j().f(posId, activity, lifecycle, container, widthPixels, heightPixels, listener);
        }
    }
}
