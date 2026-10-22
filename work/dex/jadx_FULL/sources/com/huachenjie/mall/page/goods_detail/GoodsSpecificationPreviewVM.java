package com.huachenjie.mall.page.goods_detail;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailSpecValue;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R#\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/GoodsSpecificationPreviewVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "Landroidx/lifecycle/MutableLiveData;", "", "a", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "indicatorMargin", "b", "i", "currentIndex", "", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailSpecValue;", "c", "k", GoodsSpecificationPreviewActivity.z, "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class GoodsSpecificationPreviewVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> indicatorMargin = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> currentIndex = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<GoodsDetailSpecValue>> list = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<Integer> i() {
        return this.currentIndex;
    }

    @NotNull
    public final MutableLiveData<Integer> j() {
        return this.indicatorMargin;
    }

    @NotNull
    public final MutableLiveData<List<GoodsDetailSpecValue>> k() {
        return this.list;
    }
}
