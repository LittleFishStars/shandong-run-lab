package com.huachenjie.works.page.search.fast_lenovo;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.adapter.search.SearchFastLenovoAdapter;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/works/page/search/fast_lenovo/SearchFastLenovoModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "k", "Landroidx/lifecycle/MutableLiveData;", "", "a", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "searchValue", "Lcom/huachenjie/works/adapter/search/SearchFastLenovoAdapter;", "b", "i", "adapter", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class SearchFastLenovoModel extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> searchValue = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SearchFastLenovoAdapter> adapter = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<SearchFastLenovoAdapter> i() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<String> j() {
        return this.searchValue;
    }

    public final void k() {
        SearchFastLenovoAdapter value = this.adapter.getValue();
        if (value != null) {
            value.setList(CollectionsKt.mutableListOf(new String[]{this.searchValue.getValue() + '1', this.searchValue.getValue() + '2', this.searchValue.getValue() + '3', "联想2", "联想3"}));
        }
    }
}
