package com.huachenjie.channel.bean.notify;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u001d\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u000eHÆ\u0003Jg\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u000eHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010'\u001a\u00020\u0003J\u0006\u0010(\u001a\u00020\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R%\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013¨\u0006,"}, d2 = {"Lcom/huachenjie/channel/bean/notify/BuddyDetailBean;", "", "buddyCode", "", "title", "buddyTypeInfo", "Lcom/huachenjie/channel/bean/notify/BuddyDetailTypeBean;", "activityTime", "", RequestParameters.SUBRESOURCE_LOCATION, "creatorInfo", "Lcom/huachenjie/channel/bean/notify/BuddyDetailUserBean;", "memberPreviewList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/lang/String;Lcom/huachenjie/channel/bean/notify/BuddyDetailTypeBean;JLjava/lang/String;Lcom/huachenjie/channel/bean/notify/BuddyDetailUserBean;Ljava/util/ArrayList;)V", "getActivityTime", "()J", "getBuddyCode", "()Ljava/lang/String;", "getBuddyTypeInfo", "()Lcom/huachenjie/channel/bean/notify/BuddyDetailTypeBean;", "getCreatorInfo", "()Lcom/huachenjie/channel/bean/notify/BuddyDetailUserBean;", "getLocation", "getMemberPreviewList", "()Ljava/util/ArrayList;", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", OperatePopupWindow.g, "equals", "", "other", "formatterActivityTime", "formatterMemberCount", "hashCode", "", "toString", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BuddyDetailBean {
    private final long activityTime;

    @NotNull
    private final String buddyCode;

    @Nullable
    private final BuddyDetailTypeBean buddyTypeInfo;

    @Nullable
    private final BuddyDetailUserBean creatorInfo;

    @NotNull
    private final String location;

    @Nullable
    private final ArrayList<BuddyDetailUserBean> memberPreviewList;

    @NotNull
    private final String title;

    public BuddyDetailBean() {
        this(null, null, null, 0L, null, null, null, 127, null);
    }

    public BuddyDetailBean(@NotNull String str, @NotNull String str2, @Nullable BuddyDetailTypeBean buddyDetailTypeBean, long j, @NotNull String str3, @Nullable BuddyDetailUserBean buddyDetailUserBean, @Nullable ArrayList<BuddyDetailUserBean> arrayList) {
        Intrinsics.checkNotNullParameter(str, "buddyCode");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, RequestParameters.SUBRESOURCE_LOCATION);
        this.buddyCode = str;
        this.title = str2;
        this.buddyTypeInfo = buddyDetailTypeBean;
        this.activityTime = j;
        this.location = str3;
        this.creatorInfo = buddyDetailUserBean;
        this.memberPreviewList = arrayList;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBuddyCode() {
        return this.buddyCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final BuddyDetailTypeBean getBuddyTypeInfo() {
        return this.buddyTypeInfo;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getActivityTime() {
        return this.activityTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final BuddyDetailUserBean getCreatorInfo() {
        return this.creatorInfo;
    }

    @Nullable
    public final ArrayList<BuddyDetailUserBean> component7() {
        return this.memberPreviewList;
    }

    @NotNull
    public final BuddyDetailBean copy(@NotNull String buddyCode, @NotNull String title, @Nullable BuddyDetailTypeBean buddyTypeInfo, long activityTime, @NotNull String location, @Nullable BuddyDetailUserBean creatorInfo, @Nullable ArrayList<BuddyDetailUserBean> memberPreviewList) {
        Intrinsics.checkNotNullParameter(buddyCode, "buddyCode");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(location, RequestParameters.SUBRESOURCE_LOCATION);
        return new BuddyDetailBean(buddyCode, title, buddyTypeInfo, activityTime, location, creatorInfo, memberPreviewList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BuddyDetailBean)) {
            return false;
        }
        BuddyDetailBean buddyDetailBean = (BuddyDetailBean) other;
        return Intrinsics.areEqual(this.buddyCode, buddyDetailBean.buddyCode) && Intrinsics.areEqual(this.title, buddyDetailBean.title) && Intrinsics.areEqual(this.buddyTypeInfo, buddyDetailBean.buddyTypeInfo) && this.activityTime == buddyDetailBean.activityTime && Intrinsics.areEqual(this.location, buddyDetailBean.location) && Intrinsics.areEqual(this.creatorInfo, buddyDetailBean.creatorInfo) && Intrinsics.areEqual(this.memberPreviewList, buddyDetailBean.memberPreviewList);
    }

    @NotNull
    public final String formatterActivityTime() {
        if (this.activityTime <= 0) {
            return "";
        }
        try {
            String str = new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(this.activityTime));
            Intrinsics.checkNotNullExpressionValue(str, "{\n            SimpleDate…(activityTime))\n        }");
            return str;
        } catch (Exception unused) {
            return "";
        }
    }

    @NotNull
    public final String formatterMemberCount() {
        StringBuilder sb = new StringBuilder();
        ArrayList<BuddyDetailUserBean> arrayList = this.memberPreviewList;
        sb.append(arrayList != null ? arrayList.size() : 0);
        sb.append((char) 20154);
        return sb.toString();
    }

    public final long getActivityTime() {
        return this.activityTime;
    }

    @NotNull
    public final String getBuddyCode() {
        return this.buddyCode;
    }

    @Nullable
    public final BuddyDetailTypeBean getBuddyTypeInfo() {
        return this.buddyTypeInfo;
    }

    @Nullable
    public final BuddyDetailUserBean getCreatorInfo() {
        return this.creatorInfo;
    }

    @NotNull
    public final String getLocation() {
        return this.location;
    }

    @Nullable
    public final ArrayList<BuddyDetailUserBean> getMemberPreviewList() {
        return this.memberPreviewList;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = ((this.buddyCode.hashCode() * 31) + this.title.hashCode()) * 31;
        BuddyDetailTypeBean buddyDetailTypeBean = this.buddyTypeInfo;
        int iHashCode2 = (((((iHashCode + (buddyDetailTypeBean == null ? 0 : buddyDetailTypeBean.hashCode())) * 31) + Long.hashCode(this.activityTime)) * 31) + this.location.hashCode()) * 31;
        BuddyDetailUserBean buddyDetailUserBean = this.creatorInfo;
        int iHashCode3 = (iHashCode2 + (buddyDetailUserBean == null ? 0 : buddyDetailUserBean.hashCode())) * 31;
        ArrayList<BuddyDetailUserBean> arrayList = this.memberPreviewList;
        return iHashCode3 + (arrayList != null ? arrayList.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "BuddyDetailBean(buddyCode=" + this.buddyCode + ", title=" + this.title + ", buddyTypeInfo=" + this.buddyTypeInfo + ", activityTime=" + this.activityTime + ", location=" + this.location + ", creatorInfo=" + this.creatorInfo + ", memberPreviewList=" + this.memberPreviewList + ')';
    }

    public /* synthetic */ BuddyDetailBean(String str, String str2, BuddyDetailTypeBean buddyDetailTypeBean, long j, String str3, BuddyDetailUserBean buddyDetailUserBean, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : buddyDetailTypeBean, (i & 8) != 0 ? 0L : j, (i & 16) == 0 ? str3 : "", (i & 32) != 0 ? null : buddyDetailUserBean, (i & 64) == 0 ? arrayList : null);
    }
}
