package com.huachenjie.works.page.alumni.good_stuff;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.works.bean.GoodStuffTabBean;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR#\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/works/page/alumni/good_stuff/GoodStuffVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "k", "", "a", "Z", "j", "()Z", t.d, "(Z)V", "isRequesting", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/huachenjie/works/bean/GoodStuffTabBean;", "Landroidx/lifecycle/MutableLiveData;", "i", "()Landroidx/lifecycle/MutableLiveData;", "mTabList", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class GoodStuffVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<GoodStuffTabBean>> mTabList = new MutableLiveData<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean isRequesting;

    @NotNull
    public final MutableLiveData<List<GoodStuffTabBean>> i() {
        return this.mTabList;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final boolean getIsRequesting() {
        return this.isRequesting;
    }

    public final void k() {
        if (this.isRequesting) {
            return;
        }
        this.isRequesting = true;
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.works.page.alumni.good_stuff.GoodStuffVM$queryGoodStuffTabList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.l(false);
                return Boolean.FALSE;
            }
        }, null, new GoodStuffVM$queryGoodStuffTabList$2(this, null), 11, null);
    }

    public final void l(boolean z) {
        this.isRequesting = z;
    }
}
