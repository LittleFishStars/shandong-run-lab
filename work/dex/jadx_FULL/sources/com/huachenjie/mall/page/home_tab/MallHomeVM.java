package com.huachenjie.mall.page.home_tab;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.college.bean.PointActivityBean;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.mall.bean.MallBannerBean;
import com.huachenjie.mall.bean.MallNavigationBean;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002R#\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\f0\u000b8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R#\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\f0\u000b8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R%\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a0\u000b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010R#\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\f0\u000b8\u0006¢\u0006\f\n\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\u0010¨\u0006%"}, d2 = {"Lcom/huachenjie/mall/page/home_tab/MallHomeVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "s", "t", "q", "", "Lcom/huachenjie/mall/bean/MallNavigationBean;", "j", "p", "r", "Landroidx/lifecycle/MutableLiveData;", "", "a", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", "navigationList", "Lcom/huachenjie/mall/bean/MallBannerBean;", "b", "k", "bannerList", "", "c", j.b, "searchBannerList", "", "kotlin.jvm.PlatformType", "d", "m", "noSearchBanner", "Lcom/huachenjie/college/bean/PointActivityBean;", "e", "n", "pointMallActivityList", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class MallHomeVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<MallNavigationBean>> navigationList = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<MallBannerBean>> bannerList = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<String>> searchBannerList = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> noSearchBanner = new MutableLiveData<>(Boolean.TRUE);

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<PointActivityBean>> pointMallActivityList = new MutableLiveData<>();

    public final List<MallNavigationBean> j() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MallNavigationBean("推荐", null, 2, null));
        return arrayList;
    }

    @NotNull
    public final MutableLiveData<List<MallBannerBean>> k() {
        return this.bannerList;
    }

    @NotNull
    public final MutableLiveData<List<MallNavigationBean>> l() {
        return this.navigationList;
    }

    @NotNull
    public final MutableLiveData<Boolean> m() {
        return this.noSearchBanner;
    }

    @NotNull
    public final MutableLiveData<List<PointActivityBean>> n() {
        return this.pointMallActivityList;
    }

    @NotNull
    public final MutableLiveData<List<String>> o() {
        return this.searchBannerList;
    }

    public final void p() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.mall.page.home_tab.MallHomeVM$queryMallBanner$1
            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                return Boolean.FALSE;
            }
        }, null, new MallHomeVM$queryMallBanner$2(this, null), 11, null);
    }

    public final void q() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.mall.page.home_tab.MallHomeVM$queryMallNavigation$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.l().setValue(this.this$0.j());
                return Boolean.FALSE;
            }
        }, null, new MallHomeVM$queryMallNavigation$2(this, null), 11, null);
    }

    public final void r() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.mall.page.home_tab.MallHomeVM$queryMallSearchBanner$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.m().setValue(Boolean.TRUE);
                this.this$0.o().setValue(CollectionsKt.mutableListOf(new String[]{"请输入搜索词"}));
                return Boolean.FALSE;
            }
        }, null, new MallHomeVM$queryMallSearchBanner$2(this, null), 11, null);
    }

    public final void s() {
        p();
        q();
        r();
    }

    public final void t() {
        BaseViewModelExtKt.b(this, false, false, null, null, new MallHomeVM$requestPointActivityList$1(this, null), 15, null);
    }
}
