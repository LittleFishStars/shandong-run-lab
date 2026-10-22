package com.huachenjie.works.page.user;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.works.bean.publish.PubWorksMenuPageEntity;
import com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002R#\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/works/page/user/InputSelectUserModel;", "Lcom/huachenjie/works/page/publish/menu/base/BasePubWorkMenuModel;", "", "isRefreshData", "", "w", "", "type", "L", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/works/bean/publish/PubWorksMenuPageEntity;", "Lcom/huachenjie/base/bean/UserInfoBean;", "m", "Landroidx/lifecycle/MutableLiveData;", "J", "()Landroidx/lifecycle/MutableLiveData;", "followUserList", "n", "K", "friendUserList", "<init>", "()V", "a", "works_release"}, k = 1, mv = {1, 8, 0})
public final class InputSelectUserModel extends BasePubWorkMenuModel {
    public static final int L = 1;
    public static final int M = 2;
    public static final int N = 3;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<PubWorksMenuPageEntity<UserInfoBean>> followUserList = new MutableLiveData<>();

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<PubWorksMenuPageEntity<UserInfoBean>> friendUserList = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<PubWorksMenuPageEntity<UserInfoBean>> J() {
        return this.followUserList;
    }

    @NotNull
    public final MutableLiveData<PubWorksMenuPageEntity<UserInfoBean>> K() {
        return this.friendUserList;
    }

    public final void L(boolean isRefreshData, int type) {
        if (isRefreshData) {
            z(1);
            return;
        }
        if (type == 1) {
            PubWorksMenuPageEntity<UserInfoBean> value = this.followUserList.getValue();
            if (value != null) {
                z(value.getPageNum());
                A(value.getRefreshTime());
                return;
            }
            return;
        }
        if (type == 2) {
            PubWorksMenuPageEntity<UserInfoBean> value2 = this.friendUserList.getValue();
            if (value2 != null) {
                z(value2.getPageNum());
                A(value2.getRefreshTime());
                return;
            }
            return;
        }
        PubWorksMenuPageEntity<?> value3 = E().getValue();
        if (value3 != null) {
            z(value3.getPageNum());
            A(value3.getRefreshTime());
        }
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel
    public void w(boolean isRefreshData) {
        Integer value = C().getValue();
        if (value == null) {
            value = 1;
        }
        int iIntValue = value.intValue();
        L(isRefreshData, iIntValue);
        super.w(isRefreshData);
        String value2 = H().getValue();
        if (value2 == null) {
            value2 = "";
        }
        BaseViewModelExtKt.b(this, iIntValue != 1 && isRefreshData, false, q(), null, new InputSelectUserModel$loadMoreData$1(value2, this, iIntValue, null), 10, null);
    }
}
