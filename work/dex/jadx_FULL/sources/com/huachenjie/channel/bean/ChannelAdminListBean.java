package com.huachenjie.channel.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/channel/bean/ChannelAdminListBean;", "", "admin", "Lcom/huachenjie/channel/bean/ChannelAdminBean;", GoodsSpecificationPreviewActivity.z, "", "(Lcom/huachenjie/channel/bean/ChannelAdminBean;Ljava/util/List;)V", "getAdmin", "()Lcom/huachenjie/channel/bean/ChannelAdminBean;", "getList", "()Ljava/util/List;", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ChannelAdminListBean {

    @NotNull
    private final ChannelAdminBean admin;

    @NotNull
    private final List<ChannelAdminBean> list;

    public ChannelAdminListBean(@NotNull ChannelAdminBean channelAdminBean, @NotNull List<ChannelAdminBean> list) {
        Intrinsics.checkNotNullParameter(channelAdminBean, "admin");
        Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
        this.admin = channelAdminBean;
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChannelAdminListBean copy$default(ChannelAdminListBean channelAdminListBean, ChannelAdminBean channelAdminBean, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            channelAdminBean = channelAdminListBean.admin;
        }
        if ((i & 2) != 0) {
            list = channelAdminListBean.list;
        }
        return channelAdminListBean.copy(channelAdminBean, list);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ChannelAdminBean getAdmin() {
        return this.admin;
    }

    @NotNull
    public final List<ChannelAdminBean> component2() {
        return this.list;
    }

    @NotNull
    public final ChannelAdminListBean copy(@NotNull ChannelAdminBean admin, @NotNull List<ChannelAdminBean> list) {
        Intrinsics.checkNotNullParameter(admin, "admin");
        Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
        return new ChannelAdminListBean(admin, list);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelAdminListBean)) {
            return false;
        }
        ChannelAdminListBean channelAdminListBean = (ChannelAdminListBean) other;
        return Intrinsics.areEqual(this.admin, channelAdminListBean.admin) && Intrinsics.areEqual(this.list, channelAdminListBean.list);
    }

    @NotNull
    public final ChannelAdminBean getAdmin() {
        return this.admin;
    }

    @NotNull
    public final List<ChannelAdminBean> getList() {
        return this.list;
    }

    public int hashCode() {
        return (this.admin.hashCode() * 31) + this.list.hashCode();
    }

    @NotNull
    public String toString() {
        return "ChannelAdminListBean(admin=" + this.admin + ", list=" + this.list + ')';
    }
}
