package com.huachenjie.mine.page;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.mine.adapter.FansAndAttentionsAdapter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/mine/page/FansAndAttentionsModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseStateRequestModel;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/mine/adapter/FansAndAttentionsAdapter;", "f", "Landroidx/lifecycle/MutableLiveData;", "B", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
public class FansAndAttentionsModel extends BaseStateRequestModel {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<FansAndAttentionsAdapter> adapter = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<FansAndAttentionsAdapter> B() {
        return this.adapter;
    }
}
