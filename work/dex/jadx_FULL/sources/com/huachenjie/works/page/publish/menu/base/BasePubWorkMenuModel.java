package com.huachenjie.works.page.publish.menu.base;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.works.adapter.publish.BasePubWorkMenuAdapter;
import com.huachenjie.works.bean.publish.PubWorksMenuPageEntity;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000bR%\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00160\u00068\u0006¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u000bR\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u001b\u0010\u000bR!\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001d0\u00068\u0006¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001f\u0010\u000b¨\u0006#"}, d2 = {"Lcom/huachenjie/works/page/publish/menu/base/BasePubWorkMenuModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseStateRequestModel;", "", "type", "", "I", "Landroidx/lifecycle/MutableLiveData;", "", "f", "Landroidx/lifecycle/MutableLiveData;", "D", "()Landroidx/lifecycle/MutableLiveData;", "menuName", y6b.f, "G", "searchIcon", y6b.g, "F", "searchHint", "i", "H", "searchValue", "Lcom/huachenjie/works/adapter/publish/BasePubWorkMenuAdapter;", "j", "B", "adapter", "k", "C", "currentType", "Lcom/huachenjie/works/bean/publish/PubWorksMenuPageEntity;", t.d, "E", "moreListValue", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public class BasePubWorkMenuModel extends BaseStateRequestModel {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> menuName = new MutableLiveData<>();

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> searchIcon = new MutableLiveData<>();

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> searchHint = new MutableLiveData<>();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> searchValue = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BasePubWorkMenuAdapter<?, ?>> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> currentType = new MutableLiveData<>();

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<PubWorksMenuPageEntity<?>> moreListValue = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<BasePubWorkMenuAdapter<?, ?>> B() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Integer> C() {
        return this.currentType;
    }

    @NotNull
    public final MutableLiveData<String> D() {
        return this.menuName;
    }

    @NotNull
    public final MutableLiveData<PubWorksMenuPageEntity<?>> E() {
        return this.moreListValue;
    }

    @NotNull
    public final MutableLiveData<String> F() {
        return this.searchHint;
    }

    @NotNull
    public final MutableLiveData<Integer> G() {
        return this.searchIcon;
    }

    @NotNull
    public final MutableLiveData<String> H() {
        return this.searchValue;
    }

    public final boolean I(int type) {
        Integer value = this.currentType.getValue();
        return value != null && value.intValue() == type;
    }
}
