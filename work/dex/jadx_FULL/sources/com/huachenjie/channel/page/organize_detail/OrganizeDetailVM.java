package com.huachenjie.channel.page.organize_detail;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.channel.adapter.ClubMessageAdapter;
import com.huachenjie.channel.bean.OrganizeBean;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00078\u0006¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00078\u0006¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u0016\u0010\u0017\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/channel/page/organize_detail/OrganizeDetailVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "Lcom/huachenjie/channel/bean/OrganizeBean;", "organizeBean", "", j.b, "p", "Landroidx/lifecycle/MutableLiveData;", "b", "Landroidx/lifecycle/MutableLiveData;", "m", "()Landroidx/lifecycle/MutableLiveData;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "", "c", "n", "messageCount", "Lcom/huachenjie/channel/adapter/ClubMessageAdapter;", "d", t.d, "adapter", "K", "I", "pageNum", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class OrganizeDetailVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<OrganizeBean> bean = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> messageCount = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ClubMessageAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    @NotNull
    public final MutableLiveData<ClubMessageAdapter> l() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<OrganizeBean> m() {
        return this.bean;
    }

    @NotNull
    public final MutableLiveData<Integer> n() {
        return this.messageCount;
    }

    public final void o(@Nullable OrganizeBean organizeBean) {
        if (organizeBean == null) {
            return;
        }
        this.bean.setValue(organizeBean);
    }

    public final void p() {
        if (this.bean.getValue() == null) {
            return;
        }
        BaseViewModelExtKt.b(this, false, false, null, null, new OrganizeDetailVM$loadMessageList$1(this, null), 15, null);
    }
}
