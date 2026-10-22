package com.huachenjie.sport.page.mine.qrcode;

import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.sport.api.SportModel;
import com.zj.adlib.n76;
import com.zj.adlib.y6b;
import com.zj.adlib.ze1;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/sport/page/mine/qrcode/QRCodeVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "j", "Lcom/huachenjie/sport/api/SportModel;", "a", "Lcom/huachenjie/sport/api/SportModel;", y6b.g, "()Lcom/huachenjie/sport/api/SportModel;", ze1.k, "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "()Landroidx/lifecycle/MutableLiveData;", "k", "(Landroidx/lifecycle/MutableLiveData;)V", "qrCodeStr", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class QRCodeVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final SportModel model = new SportModel();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<String> qrCodeStr = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/mine/qrcode/QRCodeVM$a", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lcom/alibaba/fastjson/JSONObject;", "data", "", "onCCSuccess", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends BizSubscriber<JSONObject> {
        public a() {
            super(true);
        }

        public void onCCSuccess(@Nullable JSONObject data) {
            String string;
            if (data != null) {
                QRCodeVM qRCodeVM = QRCodeVM.this;
                if (!data.containsKey("qrCode") || (string = data.getString("qrCode")) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(string, "getString(\"qrCode\")");
                qRCodeVM.i().setValue(string);
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: h, reason: from getter */
    public final SportModel getModel() {
        return this.model;
    }

    @NotNull
    public final MutableLiveData<String> i() {
        return this.qrCodeStr;
    }

    public final void j() {
        n76.e(this, this.model.K()).p5(new a());
    }

    public final void k(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.qrCodeStr = mutableLiveData;
    }
}
