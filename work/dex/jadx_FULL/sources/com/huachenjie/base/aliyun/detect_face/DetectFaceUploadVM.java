package com.huachenjie.base.aliyun.detect_face;

import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.igexin.push.g.o;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/DetectFaceUploadVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "faceImg", "", "k", "Landroidx/lifecycle/MutableLiveData;", "b", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", TRiverConstants.ORANGE_KEY_TRIVER_UPDATE_URL, "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class DetectFaceUploadVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> updateUrl = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<String> j() {
        return this.updateUrl;
    }

    public final void k(@NotNull String faceImg) {
        Intrinsics.checkNotNullParameter(faceImg, "faceImg");
        BaseViewModelExtKt.b(this, true, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.base.aliyun.detect_face.DetectFaceUploadVM$updateUserFace$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.j().setValue("error");
                return Boolean.FALSE;
            }
        }, null, new DetectFaceUploadVM$updateUserFace$2(faceImg, this, null), 10, null);
    }
}
