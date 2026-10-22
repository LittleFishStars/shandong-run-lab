package com.huachenjie.works.page.share;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.igexin.push.g.o;
import com.zj.adlib.yj7;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002R%\u0010\u0012\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/works/page/share/ShareWorksVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", yj7.g.WORKS_NO, "", "targetType", "authorNo", "shareAppUserCode", "targetNo", "", "i", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "a", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "shareSuccess", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class ShareWorksVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> shareSuccess = new MutableLiveData<>(Boolean.FALSE);

    public final void i(@NotNull String worksNo, int targetType, @NotNull String authorNo, @NotNull String shareAppUserCode, @Nullable String targetNo) {
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
        Intrinsics.checkNotNullParameter(authorNo, "authorNo");
        Intrinsics.checkNotNullParameter(shareAppUserCode, "shareAppUserCode");
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.works.page.share.ShareWorksVM$countShareWork$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                MutableLiveData<Boolean> mutableLiveDataJ = this.this$0.j();
                Boolean bool = Boolean.TRUE;
                mutableLiveDataJ.setValue(bool);
                return bool;
            }
        }, null, new ShareWorksVM$countShareWork$2(worksNo, targetType, authorNo, shareAppUserCode, targetNo, this, null), 11, null);
    }

    @NotNull
    public final MutableLiveData<Boolean> j() {
        return this.shareSuccess;
    }
}
