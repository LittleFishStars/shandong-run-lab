package com.huachenjie.works.page.search.hot_spot;

import androidx.p002lifecycle.MutableLiveData;
import com.google.gson.Gson;
import com.huachenjie.common.bean.UserActivityInfo;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.works.adapter.search.SearchHotSpotAdapter;
import com.huachenjie.works.bean.search.SearchHotSpotBean;
import com.huachenjie.works.bean.search.SearchHotSpotItemBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.r90;
import com.zj.adlib.y6b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b3\u00104J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\f8\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u00168\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001bR\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020!0\u00168\u0006¢\u0006\f\n\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010\u001bR\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020%0\u00168\u0006¢\u0006\f\n\u0004\b&\u0010\u0019\u001a\u0004\b'\u0010\u001bR\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020%0\u00168\u0006¢\u0006\f\n\u0004\b)\u0010\u0019\u001a\u0004\b*\u0010\u001bR\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020%0\u00168\u0006¢\u0006\f\n\u0004\b,\u0010\u0019\u001a\u0004\b-\u0010\u001bR\u001d\u00102\u001a\b\u0012\u0004\u0012\u00020/0\u00168\u0006¢\u0006\f\n\u0004\b0\u0010\u0019\u001a\u0004\b1\u0010\u001b¨\u00065"}, d2 = {"Lcom/huachenjie/works/page/search/hot_spot/SearchHotSpotModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseStateRequestModel;", "", "L", "N", "M", "Lcom/google/gson/Gson;", "c", "Lkotlin/Lazy;", "F", "()Lcom/google/gson/Gson;", "gson", "", "", "a", "Ljava/util/List;", "H", "()Ljava/util/List;", "historyList", "", "G", "historyIdList", "Landroidx/lifecycle/MutableLiveData;", "", "f", "Landroidx/lifecycle/MutableLiveData;", "D", "()Landroidx/lifecycle/MutableLiveData;", "delHistoryStatus", "Lcom/huachenjie/common/bean/UserActivityInfo;", y6b.f, "B", "activityInfo", "Lcom/huachenjie/works/bean/search/SearchHotSpotBean;", y6b.g, "I", "hotSpotBean", "Lcom/huachenjie/works/bean/search/SearchHotSpotItemBean;", "i", "E", "firstHotSpot", "j", "J", "secondHotSpot", "k", "K", "thirdHotSpot", "Lcom/huachenjie/works/adapter/search/SearchHotSpotAdapter;", t.d, "C", "adapter", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class SearchHotSpotModel extends BaseStateRequestModel {

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy gson = LazyKt.lazy(new Function0<Gson>() { // from class: com.huachenjie.works.page.search.hot_spot.SearchHotSpotModel$gson$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Gson m970invoke() {
            return new Gson();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final List<String> historyList = new ArrayList();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final List<Integer> historyIdList = new ArrayList();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> delHistoryStatus = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<UserActivityInfo> activityInfo = new MutableLiveData<>();

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SearchHotSpotBean> hotSpotBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SearchHotSpotItemBean> firstHotSpot = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SearchHotSpotItemBean> secondHotSpot = new MutableLiveData<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SearchHotSpotItemBean> thirdHotSpot = new MutableLiveData<>();

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SearchHotSpotAdapter> adapter = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<UserActivityInfo> B() {
        return this.activityInfo;
    }

    @NotNull
    public final MutableLiveData<SearchHotSpotAdapter> C() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Boolean> D() {
        return this.delHistoryStatus;
    }

    @NotNull
    public final MutableLiveData<SearchHotSpotItemBean> E() {
        return this.firstHotSpot;
    }

    public final Gson F() {
        return (Gson) this.gson.getValue();
    }

    @NotNull
    public final List<Integer> G() {
        return this.historyIdList;
    }

    @NotNull
    public final List<String> H() {
        return this.historyList;
    }

    @NotNull
    public final MutableLiveData<SearchHotSpotBean> I() {
        return this.hotSpotBean;
    }

    @NotNull
    public final MutableLiveData<SearchHotSpotItemBean> J() {
        return this.secondHotSpot;
    }

    @NotNull
    public final MutableLiveData<SearchHotSpotItemBean> K() {
        return this.thirdHotSpot;
    }

    public final void L() {
        String[] strArr = (String[]) F().fromJson(r90.v(), String[].class);
        if (strArr != null) {
            if (strArr.length == 0) {
                return;
            }
            this.historyList.clear();
            CollectionsKt.addAll(this.historyList, strArr);
        }
    }

    public final void M() {
        BaseViewModelExtKt.b(this, false, false, q(), null, new SearchHotSpotModel$requestHotSpot$1(this, null), 11, null);
    }

    public final void N() {
        r90.Z(F().toJson(this.historyList));
    }
}
