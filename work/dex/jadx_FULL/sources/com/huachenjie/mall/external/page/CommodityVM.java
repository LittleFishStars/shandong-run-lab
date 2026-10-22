package com.huachenjie.mall.external.page;

import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.mall.api.MallModel;
import com.huachenjie.mall.external.adapter.CommodityAdapter;
import com.huachenjie.mall.external.bean.CommodityBean;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import huachenjie.sdk.http.PageEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0004\u001a\u00020\u0002J-\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\u0002H\u0002R%\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u000e8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e8\u0006¢\u0006\f\n\u0004\b&\u0010\u0012\u001a\u0004\b'\u0010\u0014R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8\u0006¢\u0006\f\n\u0004\b)\u0010\u0012\u001a\u0004\b*\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lcom/huachenjie/mall/external/page/CommodityVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "q", j.b, "", "pageNum", "", "refreshTime", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/mall/external/bean/CommodityBean;", "r", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "p", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "a", "Landroidx/lifecycle/MutableLiveData;", "n", "()Landroidx/lifecycle/MutableLiveData;", "isRefreshing", "Lcom/huachenjie/mall/external/adapter/CommodityAdapter;", "b", "i", "adapter", "K", "I", "k", "()I", "s", "(I)V", "f", "Ljava/lang/String;", t.d, "()Ljava/lang/String;", "t", "(Ljava/lang/String;)V", "c", "m", "shopNo", "d", "j", CommodityFragment.COMMODITY_TYPE, "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class CommodityVM extends BaseViewModel {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public String refreshTime;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<CommodityAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> shopNo = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> commodityType = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<CommodityAdapter> i() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Integer> j() {
        return this.commodityType;
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
    public final MutableLiveData<String> m() {
        return this.shopNo;
    }

    @NotNull
    public final MutableLiveData<Boolean> n() {
        return this.isRefreshing;
    }

    public final void o() {
        this.pageNum++;
        p();
    }

    public final void p() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.mall.external.page.CommodityVM$queryPageList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                BaseLoadMoreModule loadMoreModule;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (this.this$0.getPageNum() == 1) {
                    this.this$0.n().setValue(Boolean.FALSE);
                    CommodityAdapter value = this.this$0.i().getValue();
                    if (value != null) {
                        value.setList(null);
                    }
                    CommodityAdapter value2 = this.this$0.i().getValue();
                    if (value2 != null) {
                        value2.q();
                    }
                } else {
                    CommodityVM commodityVM = this.this$0;
                    commodityVM.s(commodityVM.getPageNum() - 1);
                }
                CommodityAdapter value3 = this.this$0.i().getValue();
                if (value3 != null && (loadMoreModule = value3.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
                return Boolean.FALSE;
            }
        }, null, new CommodityVM$queryPageList$2(this, null), 11, null);
    }

    public void q() {
        this.isRefreshing.setValue(Boolean.TRUE);
        this.pageNum = 1;
        this.refreshTime = null;
        p();
    }

    @Nullable
    public Object r(int i, @Nullable String str, @NotNull Continuation<? super PageEntity<CommodityBean>> continuation) {
        MallModel mallModel = MallModel.f34763a;
        String value = this.shopNo.getValue();
        if (value == null) {
            value = "";
        }
        Integer value2 = this.commodityType.getValue();
        if (value2 == null) {
            value2 = Boxing.boxInt(0);
        }
        return mallModel.J(value, value2.intValue(), i, str == null ? "" : str, continuation);
    }

    public final void s(int i) {
        this.pageNum = i;
    }

    public final void t(@Nullable String str) {
        this.refreshTime = str;
    }
}
