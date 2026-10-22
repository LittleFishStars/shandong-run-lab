package com.huachenjie.works.page.activity;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.works.adapter.ActivityListAdapter;
import com.huachenjie.works.bean.MultipleActivityData;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00068\u0006¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/works/page/activity/ActivityListModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", ActivityListActivity.t, "", t.d, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/works/adapter/ActivityListAdapter;", "a", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "Lcom/huachenjie/common/bean/BindingTitleBean;", "b", "k", "titleBean", "Lcom/huachenjie/works/bean/MultipleActivityData;", "c", "i", "activityData", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class ActivityListModel extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<ActivityListAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<MultipleActivityData> activityData = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<MultipleActivityData> i() {
        return this.activityData;
    }

    @NotNull
    public final MutableLiveData<ActivityListAdapter> j() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> k() {
        return this.titleBean;
    }

    public final void l(int promotionPlace) {
        BaseViewModelExtKt.b(this, true, false, null, null, new ActivityListModel$queryActivityList$1(promotionPlace, this, null), 14, null);
    }
}
