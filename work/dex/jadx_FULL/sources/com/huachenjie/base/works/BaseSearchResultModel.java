package com.huachenjie.base.works;

import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR'\u0010\t\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u00038\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/base/works/BaseSearchResultModel;", "T", "Lcom/huachenjie/common/reconfig/mvvm/BaseStateRequestModel;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "f", "Landroidx/lifecycle/MutableLiveData;", "B", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "", y6b.f, "C", "keyword", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public class BaseSearchResultModel<T> extends BaseStateRequestModel {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BaseQuickAdapter<T, ?>> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> keyword = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<BaseQuickAdapter<T, ?>> B() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<String> C() {
        return this.keyword;
    }
}
