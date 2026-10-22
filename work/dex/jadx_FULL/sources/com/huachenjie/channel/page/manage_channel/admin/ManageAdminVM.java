package com.huachenjie.channel.page.manage_channel.admin;

import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.channel.bean.ChannelAdminBean;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.SubAdminTitle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\tJ\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004H\u0002R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/admin/ManageAdminVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "channelNo", "", "isSubAdmin", "", j.b, "memberUserCode", "", "position", "k", "Lcom/huachenjie/channel/bean/ChannelAdminBean;", "channelAdminBean", "j", "m", "isAdd", "p", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/channel/page/manage_channel/admin/ManageAdminAdapter;", "a", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", "adapter", "b", "n", "updateFlag", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class ManageAdminVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<ManageAdminAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> updateFlag = new MutableLiveData<>();

    public final void j(@NotNull ChannelAdminBean channelAdminBean) {
        Intrinsics.checkNotNullParameter(channelAdminBean, "channelAdminBean");
        ManageAdminAdapter value = this.adapter.getValue();
        if (value != null) {
            if (value.getData().size() == 6) {
                value.setData(value.getData().size() - 1, channelAdminBean);
            } else {
                value.addData(value.getData().size() - 1, channelAdminBean);
            }
            p(true);
            this.updateFlag.setValue(Boolean.TRUE);
        }
    }

    public final void k(@NotNull String channelNo, @NotNull String memberUserCode, int position) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intrinsics.checkNotNullParameter(memberUserCode, "memberUserCode");
        BaseViewModelExtKt.b(this, true, false, null, null, new ManageAdminVM$cancelSubAdmin$1(channelNo, memberUserCode, this, position, null), 14, null);
    }

    @NotNull
    public final MutableLiveData<ManageAdminAdapter> l() {
        return this.adapter;
    }

    public final int m() {
        ManageAdminAdapter value = this.adapter.getValue();
        MultiItemEntity multiItemEntity = value != null ? (MultiItemEntity) value.getItem(2) : null;
        SubAdminTitle subAdminTitle = multiItemEntity instanceof SubAdminTitle ? (SubAdminTitle) multiItemEntity : null;
        if (subAdminTitle != null) {
            return subAdminTitle.d();
        }
        return 0;
    }

    @NotNull
    public final MutableLiveData<Boolean> n() {
        return this.updateFlag;
    }

    public final void o(@NotNull String channelNo, boolean isSubAdmin) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        BaseViewModelExtKt.b(this, true, false, null, null, new ManageAdminVM$loadData$1(channelNo, this, isSubAdmin, null), 14, null);
    }

    public final void p(boolean isAdd) {
        ManageAdminAdapter value = this.adapter.getValue();
        MultiItemEntity multiItemEntity = value != null ? (MultiItemEntity) value.getItem(2) : null;
        SubAdminTitle subAdminTitle = multiItemEntity instanceof SubAdminTitle ? (SubAdminTitle) multiItemEntity : null;
        if (subAdminTitle == null) {
            return;
        }
        if (isAdd) {
            subAdminTitle.e(subAdminTitle.d() + 1);
        } else {
            subAdminTitle.e(subAdminTitle.d() - 1);
        }
        ManageAdminAdapter value2 = this.adapter.getValue();
        if (value2 != null) {
            value2.notifyItemChanged(2);
        }
    }
}
