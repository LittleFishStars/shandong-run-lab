package com.huachenjie.channel.page.organize.menu;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.channel.bean.ChannelMemberBean;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuModel;
import com.igexin.push.g.o;
import com.zj.adlib.fv5;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J&\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bR%\u0010\u0007\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00060\u00060\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R%\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00060\u00060\u000e8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R%\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00020\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/channel/page/organize/menu/OrganizeMenuMemberVM;", "Lcom/huachenjie/works/page/publish/menu/base/BasePubWorkMenuModel;", "", "isRefreshData", "", "w", "", "channelNo", "Lcom/huachenjie/channel/bean/ChannelMemberBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "clubCode", "", "position", "M", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "m", "Landroidx/lifecycle/MutableLiveData;", "J", "()Landroidx/lifecycle/MutableLiveData;", "n", "K", "clubAdminUserCode", j.b, "L", "finishAndNotify", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class OrganizeMenuMemberVM extends BasePubWorkMenuModel {

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> channelNo = new MutableLiveData<>("");

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> clubAdminUserCode = new MutableLiveData<>("");

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> finishAndNotify = new MutableLiveData<>(Boolean.FALSE);

    public OrganizeMenuMemberVM() {
        C().setValue(0);
    }

    @NotNull
    public final MutableLiveData<String> J() {
        return this.channelNo;
    }

    @NotNull
    public final MutableLiveData<String> K() {
        return this.clubAdminUserCode;
    }

    @NotNull
    public final MutableLiveData<Boolean> L() {
        return this.finishAndNotify;
    }

    public final void M(@NotNull String channelNo, @NotNull ChannelMemberBean bean, @NotNull String clubCode, int position) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
        Intrinsics.checkNotNullParameter(clubCode, "clubCode");
        BaseViewModelExtKt.b(this, true, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.channel.page.organize.menu.OrganizeMenuMemberVM$setOrganizeAdminUser$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                boolean z;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (resultException.getCode() == 10100) {
                    fv5.b(resultException.getMessage());
                    this.this$0.L().setValue(Boolean.TRUE);
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }, null, new OrganizeMenuMemberVM$setOrganizeAdminUser$2(channelNo, bean, clubCode, this, position, null), 10, null);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel
    public void w(boolean isRefreshData) {
        super.w(isRefreshData);
        String value = H().getValue();
        if (value == null) {
            value = "";
        }
        BaseViewModelExtKt.b(this, false, false, q(), null, new OrganizeMenuMemberVM$loadMoreData$1(this, value, null), 11, null);
    }
}
