package com.huachenjie.works.page.search;

import com.google.gson.Gson;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.r90;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b8\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/works/page/search/SearchVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", t.d, "m", "Lcom/google/gson/Gson;", "c", "Lkotlin/Lazy;", "i", "()Lcom/google/gson/Gson;", "gson", "", "", "a", "Ljava/util/List;", "k", "()Ljava/util/List;", "historyList", "", "j", "historyIdList", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class SearchVM extends BaseViewModel {

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy gson = LazyKt.lazy(new Function0<Gson>() { // from class: com.huachenjie.works.page.search.SearchVM$gson$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Gson m966invoke() {
            return new Gson();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final List<String> historyList = new ArrayList();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final List<Integer> historyIdList = new ArrayList();

    public final Gson i() {
        return (Gson) this.gson.getValue();
    }

    @NotNull
    public final List<Integer> j() {
        return this.historyIdList;
    }

    @NotNull
    public final List<String> k() {
        return this.historyList;
    }

    public final void l() {
        String[] strArr = (String[]) i().fromJson(r90.v(), String[].class);
        if (strArr != null) {
            if (strArr.length == 0) {
                return;
            }
            this.historyList.clear();
            CollectionsKt.addAll(this.historyList, strArr);
        }
    }

    public final void m() {
        r90.Z(i().toJson(this.historyList));
    }
}
