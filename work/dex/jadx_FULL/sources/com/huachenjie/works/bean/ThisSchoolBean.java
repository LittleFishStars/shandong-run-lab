package com.huachenjie.works.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0012\u001a\u00020\u0003J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\t\u0010\u0017\u001a\u00020\u0016HÖ\u0001J\u0006\u0010\u0018\u001a\u00020\u0010J\u0006\u0010\u0019\u001a\u00020\u0010J\t\u0010\u001a\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/works/bean/ThisSchoolBean;", "", "officialChannel", "Lcom/huachenjie/works/bean/OfficialChannelBean;", "bannerList", "", "Lcom/huachenjie/works/bean/SchoolBannerBean;", "(Lcom/huachenjie/works/bean/OfficialChannelBean;Ljava/util/List;)V", "getBannerList", "()Ljava/util/List;", "getOfficialChannel", "()Lcom/huachenjie/works/bean/OfficialChannelBean;", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "findOfficialChannel", "findUserAvatar", "", "index", "", "hashCode", "showBanner", "showOfficialChannel", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ThisSchoolBean {

    @NotNull
    private final List<SchoolBannerBean> bannerList;

    @Nullable
    private final OfficialChannelBean officialChannel;

    /* JADX WARN: Multi-variable type inference failed */
    public ThisSchoolBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public ThisSchoolBean(@Nullable OfficialChannelBean officialChannelBean, @NotNull List<SchoolBannerBean> list) {
        Intrinsics.checkNotNullParameter(list, "bannerList");
        this.officialChannel = officialChannelBean;
        this.bannerList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ThisSchoolBean copy$default(ThisSchoolBean thisSchoolBean, OfficialChannelBean officialChannelBean, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            officialChannelBean = thisSchoolBean.officialChannel;
        }
        if ((i & 2) != 0) {
            list = thisSchoolBean.bannerList;
        }
        return thisSchoolBean.copy(officialChannelBean, list);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final OfficialChannelBean getOfficialChannel() {
        return this.officialChannel;
    }

    @NotNull
    public final List<SchoolBannerBean> component2() {
        return this.bannerList;
    }

    @NotNull
    public final ThisSchoolBean copy(@Nullable OfficialChannelBean officialChannel, @NotNull List<SchoolBannerBean> bannerList) {
        Intrinsics.checkNotNullParameter(bannerList, "bannerList");
        return new ThisSchoolBean(officialChannel, bannerList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThisSchoolBean)) {
            return false;
        }
        ThisSchoolBean thisSchoolBean = (ThisSchoolBean) other;
        return Intrinsics.areEqual(this.officialChannel, thisSchoolBean.officialChannel) && Intrinsics.areEqual(this.bannerList, thisSchoolBean.bannerList);
    }

    @NotNull
    public final OfficialChannelBean findOfficialChannel() {
        OfficialChannelBean officialChannelBean = this.officialChannel;
        return officialChannelBean == null ? new OfficialChannelBean(null, null, null, null, null, null, null, null, false, 511, null) : officialChannelBean;
    }

    @NotNull
    public final String findUserAvatar(int index) {
        OfficialChannelBean officialChannelBean = this.officialChannel;
        if (officialChannelBean == null || officialChannelBean.getAvatarList() == null) {
            return "";
        }
        boolean z = false;
        if (index >= 0 && index < this.officialChannel.getAvatarList().size()) {
            z = true;
        }
        return !z ? "" : this.officialChannel.getAvatarList().get(index);
    }

    @NotNull
    public final List<SchoolBannerBean> getBannerList() {
        return this.bannerList;
    }

    @Nullable
    public final OfficialChannelBean getOfficialChannel() {
        return this.officialChannel;
    }

    public int hashCode() {
        OfficialChannelBean officialChannelBean = this.officialChannel;
        return ((officialChannelBean == null ? 0 : officialChannelBean.hashCode()) * 31) + this.bannerList.hashCode();
    }

    public final boolean showBanner() {
        List<SchoolBannerBean> list = this.bannerList;
        return list != null && list.size() > 0;
    }

    public final boolean showOfficialChannel() {
        return this.officialChannel != null;
    }

    @NotNull
    public String toString() {
        return "ThisSchoolBean(officialChannel=" + this.officialChannel + ", bannerList=" + this.bannerList + ')';
    }

    public /* synthetic */ ThisSchoolBean(OfficialChannelBean officialChannelBean, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : officialChannelBean, (i & 2) != 0 ? new ArrayList() : list);
    }
}
