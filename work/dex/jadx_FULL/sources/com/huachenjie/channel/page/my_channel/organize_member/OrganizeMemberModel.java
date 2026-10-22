package com.huachenjie.channel.page.my_channel.organize_member;

import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.utils.TextUtils;
import com.huachenjie.channel.adapter.OrganizeMemberAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R%\u0010\r\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R%\u0010\u0017\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u000e0\u000e0\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0016\u0010\fR\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00068\u0006¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/organize_member/OrganizeMemberModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseStateRequestModel;", "", "isRefreshData", "", "w", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/channel/adapter/OrganizeMemberAdapter;", "kotlin.jvm.PlatformType", "f", "Landroidx/lifecycle/MutableLiveData;", "B", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "", y6b.f, "Ljava/lang/String;", "C", "()Ljava/lang/String;", "F", "(Ljava/lang/String;)V", "clubCode", "E", "searchName", "", y6b.g, "D", "memberSize", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class OrganizeMemberModel extends BaseStateRequestModel {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<OrganizeMemberAdapter> adapter = new MutableLiveData<>(new OrganizeMemberAdapter());

    /* JADX INFO: renamed from: g, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public String clubCode = "";

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> searchName = new MutableLiveData<>("");

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> memberSize = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<OrganizeMemberAdapter> B() {
        return this.adapter;
    }

    @NotNull
    /* JADX INFO: renamed from: C, reason: from getter */
    public final String getClubCode() {
        return this.clubCode;
    }

    @NotNull
    public final MutableLiveData<Integer> D() {
        return this.memberSize;
    }

    @NotNull
    public final MutableLiveData<String> E() {
        return this.searchName;
    }

    public final void F(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.clubCode = str;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel
    public void w(boolean isRefreshData) {
        super.w(isRefreshData);
        BaseViewModelExtKt.b(this, !TextUtils.isEmpty(this.searchName.getValue()), false, q(), null, new OrganizeMemberModel$loadMoreData$1(this, null), 10, null);
    }
}
