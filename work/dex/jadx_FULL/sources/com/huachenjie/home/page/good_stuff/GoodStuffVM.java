package com.huachenjie.home.page.good_stuff;

import androidx.p002lifecycle.MutableLiveData;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.home.bean.GoodStuffBannerBean;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b+\u0010,J\u001c\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0006\u0010\b\u001a\u00020\u0005J&\u0010\u000b\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0002R%\u0010\u0012\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00020\u00020\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\f8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010*\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%¨\u0006-"}, d2 = {"Lcom/huachenjie/home/page/good_stuff/GoodStuffVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "isFirst", "Lkotlin/Function0;", "", "afterRefresh", "r", j.b, "Lcom/huachenjie/home/bean/GoodStuffBannerBean;", MediationConstant.RIT_TYPE_BANNER, "p", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "a", "Landroidx/lifecycle/MutableLiveData;", "n", "()Landroidx/lifecycle/MutableLiveData;", "isRefreshing", "Lcom/huachenjie/home/page/good_stuff/GoodStuffAdapter;", "b", "j", "adapter", "", "K", "I", "k", "()I", "s", "(I)V", "pageNum", "", "f", "Ljava/lang/String;", t.d, "()Ljava/lang/String;", "t", "(Ljava/lang/String;)V", "refreshTime", y6b.f, "m", "u", "zoneNo", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
public final class GoodStuffVM extends BaseViewModel {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public String refreshTime;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>(Boolean.TRUE);

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<GoodStuffAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public String zoneNo = "";

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void q(GoodStuffVM goodStuffVM, Function0 function0, GoodStuffBannerBean goodStuffBannerBean, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        if ((i & 2) != 0) {
            goodStuffBannerBean = null;
        }
        goodStuffVM.p(function0, goodStuffBannerBean);
    }

    @NotNull
    public final MutableLiveData<GoodStuffAdapter> j() {
        return this.adapter;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    @Nullable
    /* JADX INFO: renamed from: l, reason: from getter */
    public final String getRefreshTime() {
        return this.refreshTime;
    }

    @NotNull
    /* JADX INFO: renamed from: m, reason: from getter */
    public final String getZoneNo() {
        return this.zoneNo;
    }

    @NotNull
    public final MutableLiveData<Boolean> n() {
        return this.isRefreshing;
    }

    public final void o() {
        this.pageNum++;
        q(this, null, null, 3, null);
    }

    public final void p(final Function0<Unit> afterRefresh, GoodStuffBannerBean banner) {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.home.page.good_stuff.GoodStuffVM$queryPageList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                BaseLoadMoreModule loadMoreModule;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (this.this$0.getPageNum() == 1) {
                    this.this$0.n().setValue(Boolean.FALSE);
                    GoodStuffAdapter value = this.this$0.j().getValue();
                    if (value != null) {
                        value.setList(null);
                    }
                    GoodStuffAdapter value2 = this.this$0.j().getValue();
                    if (value2 != null) {
                        value2.u();
                    }
                } else {
                    GoodStuffVM goodStuffVM = this.this$0;
                    goodStuffVM.s(goodStuffVM.getPageNum() - 1);
                }
                GoodStuffAdapter value3 = this.this$0.j().getValue();
                if (value3 != null && (loadMoreModule = value3.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
                Function0<Unit> function0 = afterRefresh;
                if (function0 != null) {
                    function0.invoke();
                }
                return Boolean.FALSE;
            }
        }, null, new GoodStuffVM$queryPageList$2(this, banner, afterRefresh, null), 11, null);
    }

    public final void r(boolean isFirst, @NotNull final Function0<Unit> afterRefresh) {
        Intrinsics.checkNotNullParameter(afterRefresh, "afterRefresh");
        this.isRefreshing.setValue(Boolean.TRUE);
        this.pageNum = 1;
        this.refreshTime = null;
        if (isFirst) {
            BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.home.page.good_stuff.GoodStuffVM$refreshList$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @NotNull
                public final Boolean invoke(@NotNull ResultException resultException) {
                    Intrinsics.checkNotNullParameter(resultException, o.f);
                    this.this$0.p(afterRefresh, null);
                    return Boolean.TRUE;
                }
            }, null, new GoodStuffVM$refreshList$2(this, afterRefresh, null), 11, null);
        } else {
            p(afterRefresh, null);
        }
    }

    public final void s(int i) {
        this.pageNum = i;
    }

    public final void t(@Nullable String str) {
        this.refreshTime = str;
    }

    public final void u(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.zoneNo = str;
    }
}
