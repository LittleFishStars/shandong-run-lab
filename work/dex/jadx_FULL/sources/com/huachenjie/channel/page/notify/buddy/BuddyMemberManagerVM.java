package com.huachenjie.channel.page.notify.buddy;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.channel.bean.notify.BuddyDetailUserBean;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.liveData.SingleLiveEvent;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.kuaishou.weapon.p0.t;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R%\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00020\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R%\u0010\t\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\b0\b0\u00108\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/huachenjie/channel/page/notify/buddy/BuddyMemberManagerVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "buddyCode", "buddyTitle", "", "Lcom/huachenjie/channel/bean/notify/BuddyDetailUserBean;", BuddyMemberManagerActivity.y, "", BuddyMemberManagerActivity.z, "", "n", "p", "", "memberCount", "q", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/channel/page/notify/buddy/BuddyMemberAdapter;", "b", "Landroidx/lifecycle/MutableLiveData;", "m", "()Landroidx/lifecycle/MutableLiveData;", "previewAdapter", "kotlin.jvm.PlatformType", "c", "k", "d", j.b, "Lcom/huachenjie/common/reconfig/liveData/SingleLiveEvent;", "", "a", "Lcom/huachenjie/common/reconfig/liveData/SingleLiveEvent;", t.d, "()Lcom/huachenjie/common/reconfig/liveData/SingleLiveEvent;", "leaveSuccessEvent", "f", "Ljava/lang/String;", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class BuddyMemberManagerVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BuddyMemberAdapter> previewAdapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> buddyTitle = new MutableLiveData<>("");

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isMine = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final SingleLiveEvent leaveSuccessEvent = new SingleLiveEvent();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public String buddyCode = "";

    @NotNull
    public final MutableLiveData<String> k() {
        return this.buddyTitle;
    }

    @NotNull
    /* JADX INFO: renamed from: l, reason: from getter */
    public final SingleLiveEvent getLeaveSuccessEvent() {
        return this.leaveSuccessEvent;
    }

    @NotNull
    public final MutableLiveData<BuddyMemberAdapter> m() {
        return this.previewAdapter;
    }

    public final void n(@NotNull String buddyCode, @NotNull String buddyTitle, @NotNull List<BuddyDetailUserBean> members, boolean isMine) {
        Intrinsics.checkNotNullParameter(buddyCode, "buddyCode");
        Intrinsics.checkNotNullParameter(buddyTitle, "buddyTitle");
        Intrinsics.checkNotNullParameter(members, BuddyMemberManagerActivity.y);
        this.buddyCode = buddyCode;
        this.buddyTitle.setValue(buddyTitle);
        this.isMine.setValue(Boolean.valueOf(isMine));
        BuddyMemberAdapter value = this.previewAdapter.getValue();
        if (value != null) {
            value.setList(members);
        }
        q(members.size());
    }

    @NotNull
    public final MutableLiveData<Boolean> o() {
        return this.isMine;
    }

    public final void p() {
        if (this.buddyCode.length() == 0) {
            return;
        }
        BaseViewModelExtKt.b(this, true, false, null, null, new BuddyMemberManagerVM$leaveBuddy$1(this, null), 14, null);
    }

    public final void q(int memberCount) {
        BindingTitleBean value = i().getValue();
        if (value == null) {
            return;
        }
        value.setTitleName("成员管理（" + memberCount + (char) 65289);
        i().setValue(value);
    }
}
