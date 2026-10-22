package com.huachenjie.base.aliyun.detect_face;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR%\u0010\u000f\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00020\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\nR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u0011\u0010\nR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00068\u0006¢\u0006\f\n\u0004\b\u0014\u0010\b\u001a\u0004\b\u0015\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/DetectFaceAuthVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "compareFaceUrl", "", "j", "Landroidx/lifecycle/MutableLiveData;", "b", "Landroidx/lifecycle/MutableLiveData;", "m", "()Landroidx/lifecycle/MutableLiveData;", "detectText", "kotlin.jvm.PlatformType", "c", t.d, "countdownText", "d", "k", "authFaceUrl", "", "e", "n", "showButton", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class DetectFaceAuthVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> detectText = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> countdownText = new MutableLiveData<>("");

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> authFaceUrl = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showButton = new MutableLiveData<>();

    public final void j(@NotNull String compareFaceUrl) {
        Intrinsics.checkNotNullParameter(compareFaceUrl, "compareFaceUrl");
        BaseViewModelExtKt.b(this, true, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.base.aliyun.detect_face.DetectFaceAuthVM$authUserFace$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.k().setValue("error");
                return Boolean.FALSE;
            }
        }, null, new DetectFaceAuthVM$authUserFace$2(this, compareFaceUrl, null), 10, null);
    }

    @NotNull
    public final MutableLiveData<String> k() {
        return this.authFaceUrl;
    }

    @NotNull
    public final MutableLiveData<String> l() {
        return this.countdownText;
    }

    @NotNull
    public final MutableLiveData<String> m() {
        return this.detectText;
    }

    @NotNull
    public final MutableLiveData<Boolean> n() {
        return this.showButton;
    }
}
