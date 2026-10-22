package com.huachenjie.works.page.details.picture;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.works.bean.WorkDetailBean;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.yj7;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/works/page/details/picture/PicturePromotionModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", yj7.g.WORKS_NO, "", "k", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/works/bean/WorkDetailBean;", "b", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", "worksDetailBean", "Lcom/huachenjie/common/reconfig/net/exception/ResultException;", "c", "j", "errorResult", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class PicturePromotionModel extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<WorkDetailBean> worksDetailBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ResultException> errorResult = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<ResultException> j() {
        return this.errorResult;
    }

    public final void k(@NotNull String worksNo) {
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.works.page.details.picture.PicturePromotionModel$getWorksDetail$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.j().setValue(resultException);
                return Boolean.TRUE;
            }
        }, null, new PicturePromotionModel$getWorksDetail$2(worksNo, this, null), 11, null);
    }

    @NotNull
    public final MutableLiveData<WorkDetailBean> l() {
        return this.worksDetailBean;
    }
}
