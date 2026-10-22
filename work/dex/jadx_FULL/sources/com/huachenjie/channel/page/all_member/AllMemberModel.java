package com.huachenjie.channel.page.all_member;

import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.utils.TextUtils;
import com.huachenjie.channel.adapter.AllMemberAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R%\u0010\r\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR%\u0010\u0018\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00120\u00120\u00068\u0006¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0017\u0010\fR\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00068\u0006¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/channel/page/all_member/AllMemberModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseStateRequestModel;", "", "isRefreshData", "", "w", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/channel/adapter/AllMemberAdapter;", "kotlin.jvm.PlatformType", "f", "Landroidx/lifecycle/MutableLiveData;", "B", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "", y6b.f, "getType", "type", "", y6b.g, "C", "code", "i", "E", "searchName", "j", "D", "memberSize", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class AllMemberModel extends BaseStateRequestModel {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<AllMemberAdapter> adapter = new MutableLiveData<>(new AllMemberAdapter());

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> type = new MutableLiveData<>();

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> code = new MutableLiveData<>();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> searchName = new MutableLiveData<>("");

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> memberSize = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<AllMemberAdapter> B() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<String> C() {
        return this.code;
    }

    @NotNull
    public final MutableLiveData<Integer> D() {
        return this.memberSize;
    }

    @NotNull
    public final MutableLiveData<String> E() {
        return this.searchName;
    }

    @NotNull
    public final MutableLiveData<Integer> getType() {
        return this.type;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel
    public void w(boolean isRefreshData) {
        super.w(isRefreshData);
        BaseViewModelExtKt.b(this, !TextUtils.isEmpty(this.searchName.getValue()), false, q(), null, new AllMemberModel$loadMoreData$1(this, null), 10, null);
    }
}
