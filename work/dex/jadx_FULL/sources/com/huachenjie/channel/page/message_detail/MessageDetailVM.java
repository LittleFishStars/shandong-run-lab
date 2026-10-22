package com.huachenjie.channel.page.message_detail;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.channel.bean.ClubMessageBean;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/channel/page/message_detail/MessageDetailVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "j", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/channel/bean/ClubMessageBean;", "b", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "", "c", t.d, "deleteFlag", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class MessageDetailVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ClubMessageBean> bean = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> deleteFlag = new MutableLiveData<>();

    public final void j() {
        if (this.bean.getValue() == null) {
            return;
        }
        BaseViewModelExtKt.b(this, true, false, null, null, new MessageDetailVM$deleteMessage$1(this, null), 14, null);
    }

    @NotNull
    public final MutableLiveData<ClubMessageBean> k() {
        return this.bean;
    }

    @NotNull
    public final MutableLiveData<Boolean> l() {
        return this.deleteFlag;
    }
}
