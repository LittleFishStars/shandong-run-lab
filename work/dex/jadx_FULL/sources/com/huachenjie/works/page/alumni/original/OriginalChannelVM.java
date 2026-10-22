package com.huachenjie.works.page.alumni.original;

import androidx.collection.ArrayMap;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.works.bean.OriginalCategoryListBean;
import com.huachenjie.works.bean.OriginalPageEntity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR#\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/works/page/alumni/original/OriginalChannelVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "k", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/works/bean/OriginalCategoryListBean;", "a", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "category", "Landroidx/collection/ArrayMap;", "", "Lcom/huachenjie/works/bean/OriginalPageEntity;", "Landroidx/collection/ArrayMap;", "i", "()Landroidx/collection/ArrayMap;", "cacheBeanMap", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class OriginalChannelVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<OriginalCategoryListBean> category = new MutableLiveData<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ArrayMap<String, OriginalPageEntity> cacheBeanMap = new ArrayMap<>();

    @NotNull
    public final ArrayMap<String, OriginalPageEntity> i() {
        return this.cacheBeanMap;
    }

    @NotNull
    public final MutableLiveData<OriginalCategoryListBean> j() {
        return this.category;
    }

    public final void k() {
        BaseViewModelExtKt.b(this, true, false, null, null, new OriginalChannelVM$queryCategory$1(this, null), 14, null);
    }
}
