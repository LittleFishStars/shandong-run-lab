package com.huachenjie.home.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/home/bean/ReceiveRewardBean;", "", "reward", "", "(I)V", "getReward", "()I", "component1", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ReceiveRewardBean {
    private final int reward;

    public ReceiveRewardBean(int i) {
        this.reward = i;
    }

    public static /* synthetic */ ReceiveRewardBean copy$default(ReceiveRewardBean receiveRewardBean, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = receiveRewardBean.reward;
        }
        return receiveRewardBean.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getReward() {
        return this.reward;
    }

    @NotNull
    public final ReceiveRewardBean copy(int reward) {
        return new ReceiveRewardBean(reward);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ReceiveRewardBean) && this.reward == ((ReceiveRewardBean) other).reward;
    }

    public final int getReward() {
        return this.reward;
    }

    public int hashCode() {
        return Integer.hashCode(this.reward);
    }

    @NotNull
    public String toString() {
        return "ReceiveRewardBean(reward=" + this.reward + ')';
    }
}
