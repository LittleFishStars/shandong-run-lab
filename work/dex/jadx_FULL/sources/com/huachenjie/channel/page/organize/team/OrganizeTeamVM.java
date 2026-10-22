package com.huachenjie.channel.page.organize.team;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.channel.bean.OrganizeBean;
import com.huachenjie.channel.bean.OrganizeTeamBean;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006R%\u0010\u0012\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000b8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R%\u0010\u001a\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00170\u00170\u000b8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/channel/page/organize/team/OrganizeTeamVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "Lcom/huachenjie/channel/bean/OrganizeBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "", "n", "", "channelNo", "clubCode", "teamTitle", "j", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/channel/page/organize/team/OrganizeTeamAdapter;", "kotlin.jvm.PlatformType", "b", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "Lcom/huachenjie/channel/bean/OrganizeTeamBean;", "c", "m", "teamInfo", "", "d", t.d, "finishAndNotify", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class OrganizeTeamVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<OrganizeTeamAdapter> adapter = new MutableLiveData<>(new OrganizeTeamAdapter());

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<OrganizeTeamBean> teamInfo = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> finishAndNotify = new MutableLiveData<>(Boolean.FALSE);

    public final void j(@NotNull String channelNo, @NotNull String clubCode, @NotNull String teamTitle) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intrinsics.checkNotNullParameter(clubCode, "clubCode");
        Intrinsics.checkNotNullParameter(teamTitle, "teamTitle");
        BaseViewModelExtKt.b(this, true, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.channel.page.organize.team.OrganizeTeamVM$createOrganizeTeam$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                boolean z;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (resultException.getCode() == 10100) {
                    fv5.b(resultException.getMessage());
                    this.this$0.l().setValue(Boolean.TRUE);
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }, null, new OrganizeTeamVM$createOrganizeTeam$2(channelNo, clubCode, teamTitle, this, null), 10, null);
    }

    @NotNull
    public final MutableLiveData<OrganizeTeamAdapter> k() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Boolean> l() {
        return this.finishAndNotify;
    }

    @NotNull
    public final MutableLiveData<OrganizeTeamBean> m() {
        return this.teamInfo;
    }

    public final void n(@NotNull OrganizeBean bean) {
        Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
        if (bean.getClubTeamList().isEmpty()) {
            OrganizeTeamAdapter value = this.adapter.getValue();
            if (value != null) {
                value.h();
                return;
            }
            return;
        }
        OrganizeTeamAdapter value2 = this.adapter.getValue();
        if (value2 != null) {
            value2.f();
        }
        OrganizeTeamAdapter value3 = this.adapter.getValue();
        if (value3 != null) {
            value3.setList(bean.getClubTeamList());
        }
    }
}
