package com.huachenjie.works.page.alumni.find_alumni;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.works.bean.InterestTag;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0014\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/works/page/alumni/find_alumni/SettingInterestTagsVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "m", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/works/page/alumni/find_alumni/SettingInterestTagsAdapter;", "b", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "", "Lcom/huachenjie/works/bean/InterestTag;", "a", "Ljava/util/List;", "k", "()Ljava/util/List;", "selectTags", "", "c", t.d, "settingResult", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class SettingInterestTagsVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SettingInterestTagsAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final List<InterestTag> selectTags = new ArrayList();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> settingResult = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<SettingInterestTagsAdapter> j() {
        return this.adapter;
    }

    @NotNull
    public final List<InterestTag> k() {
        return this.selectTags;
    }

    @NotNull
    public final MutableLiveData<Boolean> l() {
        return this.settingResult;
    }

    public final void m() {
        BaseViewModelExtKt.b(this, true, false, null, null, new SettingInterestTagsVM$settingTags$1(this, null), 14, null);
    }
}
