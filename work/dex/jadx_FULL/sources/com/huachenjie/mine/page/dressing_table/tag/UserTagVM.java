package com.huachenjie.mine.page.dressing_table.tag;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.works.bean.InterestTag;
import com.huachenjie.works.page.alumni.find_alumni.SettingInterestTagsAdapter;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00058\u0006¢\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0014\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/mine/page/dressing_table/tag/UserTagVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", t.d, "m", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/works/page/alumni/find_alumni/SettingInterestTagsAdapter;", "a", "Landroidx/lifecycle/MutableLiveData;", "i", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "", "Lcom/huachenjie/works/bean/InterestTag;", "Ljava/util/List;", "j", "()Ljava/util/List;", "selectTags", "", "b", "k", "settingResult", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
public final class UserTagVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<SettingInterestTagsAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final List<InterestTag> selectTags = new ArrayList();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> settingResult = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<SettingInterestTagsAdapter> i() {
        return this.adapter;
    }

    @NotNull
    public final List<InterestTag> j() {
        return this.selectTags;
    }

    @NotNull
    public final MutableLiveData<Boolean> k() {
        return this.settingResult;
    }

    public final void l() {
        BaseViewModelExtKt.b(this, false, false, null, null, new UserTagVM$loadData$1(this, null), 15, null);
    }

    public final void m() {
        BaseViewModelExtKt.b(this, true, false, null, null, new UserTagVM$settingTags$1(this, null), 14, null);
    }
}
