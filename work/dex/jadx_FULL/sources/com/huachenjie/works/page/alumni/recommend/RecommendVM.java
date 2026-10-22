package com.huachenjie.works.page.alumni.recommend;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.works.bean.RecommendWorksBean;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002R-\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00070\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/works/page/alumni/recommend/RecommendVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", t.d, "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/ArrayList;", "Lcom/huachenjie/works/bean/RecommendWorksBean;", "Lkotlin/collections/ArrayList;", "a", "Landroidx/lifecycle/MutableLiveData;", "i", "()Landroidx/lifecycle/MutableLiveData;", "mTabList", "", "b", "j", "selectedLogo", "", "Z", "k", "()Z", "m", "(Z)V", "isRequesting", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class RecommendVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean isRequesting;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<ArrayList<RecommendWorksBean>> mTabList = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> selectedLogo = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<ArrayList<RecommendWorksBean>> i() {
        return this.mTabList;
    }

    @NotNull
    public final MutableLiveData<String> j() {
        return this.selectedLogo;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final boolean getIsRequesting() {
        return this.isRequesting;
    }

    public final void l() {
        if (this.isRequesting) {
            return;
        }
        this.isRequesting = true;
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.works.page.alumni.recommend.RecommendVM$queryRecommendTabList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.m(false);
                return Boolean.FALSE;
            }
        }, null, new RecommendVM$queryRecommendTabList$2(this, null), 11, null);
    }

    public final void m(boolean z) {
        this.isRequesting = z;
    }
}
