package com.huachenjie.works.bean;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.ai9;
import com.zj.adlib.j64;
import com.zj.adlib.s72;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b4\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BÁ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u0011\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0007¢\u0006\u0002\u0010\u001aJ\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\u000f\u00107\u001a\b\u0012\u0004\u0012\u00020\r0\u0011HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0007HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0007HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0007HÆ\u0003J\u000f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011HÆ\u0003JÅ\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00072\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00052\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u0007HÆ\u0001J\u0013\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010H\u001a\u00020\u0007J\u0006\u0010I\u001a\u00020\u0007J\u0006\u0010J\u001a\u00020\u0007J\u0006\u0010K\u001a\u00020\u0007J\u0006\u0010L\u001a\u00020\u0007J\u0006\u0010M\u001a\u00020\u0007J\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011J\u0006\u0010O\u001a\u00020\u0007J\t\u0010P\u001a\u00020\u0005HÖ\u0001J\u0006\u0010Q\u001a\u00020FJ\u0006\u0010R\u001a\u00020FJ\t\u0010S\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001eR\u0011\u0010\u0013\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001eR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u0011¢\u0006\b\n\u0000\u001a\u0004\b.\u0010*R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001cR\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001eR\u0011\u0010\u0019\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b2\u0010 ¨\u0006T"}, d2 = {"Lcom/huachenjie/works/bean/BuddyCardBean;", "", "activityTime", "", "appliedFlag", "", "buddyCode", "", "buddyTypeInfo", "Lcom/huachenjie/works/bean/BuddyTypeScopeTypeBean;", "chatInfo", "Lcom/huachenjie/works/bean/BuddyChatInfoBean;", "creatorInfo", "Lcom/huachenjie/works/bean/BuddyUserBean;", "currentMemberCount", "description", "imageList", "", "joinedFlag", RequestParameters.SUBRESOURCE_LOCATION, "maxMemberCount", "memberPreviewList", "relationFlag", "publishTime", "status", "title", "(JILjava/lang/String;Lcom/huachenjie/works/bean/BuddyTypeScopeTypeBean;Lcom/huachenjie/works/bean/BuddyChatInfoBean;Lcom/huachenjie/works/bean/BuddyUserBean;ILjava/lang/String;Ljava/util/List;ILjava/lang/String;ILjava/util/List;IJILjava/lang/String;)V", "getActivityTime", "()J", "getAppliedFlag", "()I", "getBuddyCode", "()Ljava/lang/String;", "getBuddyTypeInfo", "()Lcom/huachenjie/works/bean/BuddyTypeScopeTypeBean;", "getChatInfo", "()Lcom/huachenjie/works/bean/BuddyChatInfoBean;", "getCreatorInfo", "()Lcom/huachenjie/works/bean/BuddyUserBean;", "getCurrentMemberCount", "getDescription", "getImageList", "()Ljava/util/List;", "getJoinedFlag", "getLocation", "getMaxMemberCount", "getMemberPreviewList", "getPublishTime", "getRelationFlag", "getStatus", "getTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "", "other", "formatterActivityTime", "formatterDescription", "formatterJoinButtonText", "formatterJoinedMemberCount", "formatterMemberCount", "formatterPublishTime", "formatterTagList", "formatterTitle", "hashCode", "isJoinButtonEnabled", "isJoinButtonVisible", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBuddyBean.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuddyBean.kt\ncom/huachenjie/works/bean/BuddyCardBean\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,286:1\n1#2:287\n*E\n"})
public final /* data */ class BuddyCardBean {
    private final long activityTime;
    private final int appliedFlag;

    @NotNull
    private final String buddyCode;

    @Nullable
    private final BuddyTypeScopeTypeBean buddyTypeInfo;

    @Nullable
    private final BuddyChatInfoBean chatInfo;

    @Nullable
    private final BuddyUserBean creatorInfo;
    private final int currentMemberCount;

    @NotNull
    private final String description;

    @NotNull
    private final List<String> imageList;
    private final int joinedFlag;

    @NotNull
    private final String location;
    private final int maxMemberCount;

    @NotNull
    private final List<BuddyUserBean> memberPreviewList;
    private final long publishTime;
    private final int relationFlag;
    private final int status;

    @NotNull
    private final String title;

    public BuddyCardBean() {
        this(0L, 0, null, null, null, null, 0, null, null, 0, null, 0, null, 0, 0L, 0, null, 131071, null);
    }

    public BuddyCardBean(long j, int i, @NotNull String str, @Nullable BuddyTypeScopeTypeBean buddyTypeScopeTypeBean, @Nullable BuddyChatInfoBean buddyChatInfoBean, @Nullable BuddyUserBean buddyUserBean, int i2, @NotNull String str2, @NotNull List<String> list, int i3, @NotNull String str3, int i4, @NotNull List<BuddyUserBean> list2, int i5, long j2, int i6, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "buddyCode");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(list, "imageList");
        Intrinsics.checkNotNullParameter(str3, RequestParameters.SUBRESOURCE_LOCATION);
        Intrinsics.checkNotNullParameter(list2, "memberPreviewList");
        Intrinsics.checkNotNullParameter(str4, "title");
        this.activityTime = j;
        this.appliedFlag = i;
        this.buddyCode = str;
        this.buddyTypeInfo = buddyTypeScopeTypeBean;
        this.chatInfo = buddyChatInfoBean;
        this.creatorInfo = buddyUserBean;
        this.currentMemberCount = i2;
        this.description = str2;
        this.imageList = list;
        this.joinedFlag = i3;
        this.location = str3;
        this.maxMemberCount = i4;
        this.memberPreviewList = list2;
        this.relationFlag = i5;
        this.publishTime = j2;
        this.status = i6;
        this.title = str4;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getActivityTime() {
        return this.activityTime;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getJoinedFlag() {
        return this.joinedFlag;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getMaxMemberCount() {
        return this.maxMemberCount;
    }

    @NotNull
    public final List<BuddyUserBean> component13() {
        return this.memberPreviewList;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getRelationFlag() {
        return this.relationFlag;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final long getPublishTime() {
        return this.publishTime;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    @NotNull
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getAppliedFlag() {
        return this.appliedFlag;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBuddyCode() {
        return this.buddyCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final BuddyTypeScopeTypeBean getBuddyTypeInfo() {
        return this.buddyTypeInfo;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final BuddyChatInfoBean getChatInfo() {
        return this.chatInfo;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final BuddyUserBean getCreatorInfo() {
        return this.creatorInfo;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getCurrentMemberCount() {
        return this.currentMemberCount;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final List<String> component9() {
        return this.imageList;
    }

    @NotNull
    public final BuddyCardBean copy(long activityTime, int appliedFlag, @NotNull String buddyCode, @Nullable BuddyTypeScopeTypeBean buddyTypeInfo, @Nullable BuddyChatInfoBean chatInfo, @Nullable BuddyUserBean creatorInfo, int currentMemberCount, @NotNull String description, @NotNull List<String> imageList, int joinedFlag, @NotNull String location, int maxMemberCount, @NotNull List<BuddyUserBean> memberPreviewList, int relationFlag, long publishTime, int status, @NotNull String title) {
        Intrinsics.checkNotNullParameter(buddyCode, "buddyCode");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(imageList, "imageList");
        Intrinsics.checkNotNullParameter(location, RequestParameters.SUBRESOURCE_LOCATION);
        Intrinsics.checkNotNullParameter(memberPreviewList, "memberPreviewList");
        Intrinsics.checkNotNullParameter(title, "title");
        return new BuddyCardBean(activityTime, appliedFlag, buddyCode, buddyTypeInfo, chatInfo, creatorInfo, currentMemberCount, description, imageList, joinedFlag, location, maxMemberCount, memberPreviewList, relationFlag, publishTime, status, title);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BuddyCardBean)) {
            return false;
        }
        BuddyCardBean buddyCardBean = (BuddyCardBean) other;
        return this.activityTime == buddyCardBean.activityTime && this.appliedFlag == buddyCardBean.appliedFlag && Intrinsics.areEqual(this.buddyCode, buddyCardBean.buddyCode) && Intrinsics.areEqual(this.buddyTypeInfo, buddyCardBean.buddyTypeInfo) && Intrinsics.areEqual(this.chatInfo, buddyCardBean.chatInfo) && Intrinsics.areEqual(this.creatorInfo, buddyCardBean.creatorInfo) && this.currentMemberCount == buddyCardBean.currentMemberCount && Intrinsics.areEqual(this.description, buddyCardBean.description) && Intrinsics.areEqual(this.imageList, buddyCardBean.imageList) && this.joinedFlag == buddyCardBean.joinedFlag && Intrinsics.areEqual(this.location, buddyCardBean.location) && this.maxMemberCount == buddyCardBean.maxMemberCount && Intrinsics.areEqual(this.memberPreviewList, buddyCardBean.memberPreviewList) && this.relationFlag == buddyCardBean.relationFlag && this.publishTime == buddyCardBean.publishTime && this.status == buddyCardBean.status && Intrinsics.areEqual(this.title, buddyCardBean.title);
    }

    @NotNull
    public final String formatterActivityTime() {
        long j = this.activityTime;
        if (j <= 0) {
            return "";
        }
        try {
            String strC = s72.c(j, "MM月dd日 HH:mm");
            Intrinsics.checkNotNullExpressionValue(strC, "{\n            DateUtil.f…\"MM月dd日 HH:mm\")\n        }");
            return strC;
        } catch (Exception unused) {
            return "";
        }
    }

    @NotNull
    public final String formatterDescription() {
        String string = StringsKt.trim(this.description).toString();
        return ((string.length() == 0) || StringsKt.isBlank(this.title)) ? "" : string;
    }

    @NotNull
    public final String formatterJoinButtonText() {
        if (this.status == 2) {
            return "已满员";
        }
        int i = this.relationFlag;
        if (i == 2) {
            return "已加入";
        }
        return i == 1 ? "已申请" : "加入";
    }

    @NotNull
    public final String formatterJoinedMemberCount() {
        return this.currentMemberCount + "人已加入";
    }

    @NotNull
    public final String formatterMemberCount() {
        if (this.maxMemberCount <= 0) {
            return this.currentMemberCount + "/∞";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.currentMemberCount);
        sb.append('/');
        sb.append(this.maxMemberCount);
        return sb.toString();
    }

    @NotNull
    public final String formatterPublishTime() {
        long j = this.publishTime;
        if (j <= 0) {
            return "";
        }
        String strC = j64.c(j);
        Intrinsics.checkNotNullExpressionValue(strC, "convertTime(publishTime)");
        return strC;
    }

    @NotNull
    public final List<String> formatterTagList() {
        String buddyTypeName;
        ArrayList arrayList = new ArrayList();
        BuddyTypeScopeTypeBean buddyTypeScopeTypeBean = this.buddyTypeInfo;
        if (buddyTypeScopeTypeBean != null && (buddyTypeName = buddyTypeScopeTypeBean.getBuddyTypeName()) != null) {
            if (!(!StringsKt.isBlank(buddyTypeName))) {
                buddyTypeName = null;
            }
            if (buddyTypeName != null) {
                arrayList.add(buddyTypeName);
            }
        }
        String str = formatterActivityTime();
        if (!(!StringsKt.isBlank(str))) {
            str = null;
        }
        if (str != null) {
            arrayList.add(str);
        }
        String str2 = this.location;
        String str3 = StringsKt.isBlank(str2) ^ true ? str2 : null;
        if (str3 != null) {
            arrayList.add(str3);
        }
        return arrayList;
    }

    @NotNull
    public final String formatterTitle() {
        return this.title.length() == 0 ? this.description : this.title;
    }

    public final long getActivityTime() {
        return this.activityTime;
    }

    public final int getAppliedFlag() {
        return this.appliedFlag;
    }

    @NotNull
    public final String getBuddyCode() {
        return this.buddyCode;
    }

    @Nullable
    public final BuddyTypeScopeTypeBean getBuddyTypeInfo() {
        return this.buddyTypeInfo;
    }

    @Nullable
    public final BuddyChatInfoBean getChatInfo() {
        return this.chatInfo;
    }

    @Nullable
    public final BuddyUserBean getCreatorInfo() {
        return this.creatorInfo;
    }

    public final int getCurrentMemberCount() {
        return this.currentMemberCount;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final List<String> getImageList() {
        return this.imageList;
    }

    public final int getJoinedFlag() {
        return this.joinedFlag;
    }

    @NotNull
    public final String getLocation() {
        return this.location;
    }

    public final int getMaxMemberCount() {
        return this.maxMemberCount;
    }

    @NotNull
    public final List<BuddyUserBean> getMemberPreviewList() {
        return this.memberPreviewList;
    }

    public final long getPublishTime() {
        return this.publishTime;
    }

    public final int getRelationFlag() {
        return this.relationFlag;
    }

    public final int getStatus() {
        return this.status;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = ((((Long.hashCode(this.activityTime) * 31) + Integer.hashCode(this.appliedFlag)) * 31) + this.buddyCode.hashCode()) * 31;
        BuddyTypeScopeTypeBean buddyTypeScopeTypeBean = this.buddyTypeInfo;
        int iHashCode2 = (iHashCode + (buddyTypeScopeTypeBean == null ? 0 : buddyTypeScopeTypeBean.hashCode())) * 31;
        BuddyChatInfoBean buddyChatInfoBean = this.chatInfo;
        int iHashCode3 = (iHashCode2 + (buddyChatInfoBean == null ? 0 : buddyChatInfoBean.hashCode())) * 31;
        BuddyUserBean buddyUserBean = this.creatorInfo;
        return ((((((((((((((((((((((iHashCode3 + (buddyUserBean != null ? buddyUserBean.hashCode() : 0)) * 31) + Integer.hashCode(this.currentMemberCount)) * 31) + this.description.hashCode()) * 31) + this.imageList.hashCode()) * 31) + Integer.hashCode(this.joinedFlag)) * 31) + this.location.hashCode()) * 31) + Integer.hashCode(this.maxMemberCount)) * 31) + this.memberPreviewList.hashCode()) * 31) + Integer.hashCode(this.relationFlag)) * 31) + Long.hashCode(this.publishTime)) * 31) + Integer.hashCode(this.status)) * 31) + this.title.hashCode();
    }

    public final boolean isJoinButtonEnabled() {
        return this.status == 1 && this.relationFlag == 0;
    }

    public final boolean isJoinButtonVisible() {
        BuddyUserBean buddyUserBean;
        String appUserCode;
        if (this.status == 2 || (buddyUserBean = this.creatorInfo) == null || (appUserCode = buddyUserBean.getAppUserCode()) == null || StringsKt.isBlank(appUserCode)) {
            return true;
        }
        String userId = ai9.e().getUserId();
        if (StringsKt.isBlank(userId)) {
            return true;
        }
        return !Intrinsics.areEqual(appUserCode, userId);
    }

    @NotNull
    public String toString() {
        return "BuddyCardBean(activityTime=" + this.activityTime + ", appliedFlag=" + this.appliedFlag + ", buddyCode=" + this.buddyCode + ", buddyTypeInfo=" + this.buddyTypeInfo + ", chatInfo=" + this.chatInfo + ", creatorInfo=" + this.creatorInfo + ", currentMemberCount=" + this.currentMemberCount + ", description=" + this.description + ", imageList=" + this.imageList + ", joinedFlag=" + this.joinedFlag + ", location=" + this.location + ", maxMemberCount=" + this.maxMemberCount + ", memberPreviewList=" + this.memberPreviewList + ", relationFlag=" + this.relationFlag + ", publishTime=" + this.publishTime + ", status=" + this.status + ", title=" + this.title + ')';
    }

    public /* synthetic */ BuddyCardBean(long j, int i, String str, BuddyTypeScopeTypeBean buddyTypeScopeTypeBean, BuddyChatInfoBean buddyChatInfoBean, BuddyUserBean buddyUserBean, int i2, String str2, List list, int i3, String str3, int i4, List list2, int i5, long j2, int i6, String str4, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this((i7 & 1) != 0 ? 0L : j, (i7 & 2) != 0 ? 0 : i, (i7 & 4) != 0 ? "" : str, (i7 & 8) != 0 ? null : buddyTypeScopeTypeBean, (i7 & 16) != 0 ? null : buddyChatInfoBean, (i7 & 32) == 0 ? buddyUserBean : null, (i7 & 64) != 0 ? 0 : i2, (i7 & 128) != 0 ? "" : str2, (i7 & 256) != 0 ? new ArrayList() : list, (i7 & 512) != 0 ? 0 : i3, (i7 & 1024) != 0 ? "" : str3, (i7 & 2048) != 0 ? 0 : i4, (i7 & 4096) != 0 ? new ArrayList() : list2, (i7 & 8192) != 0 ? 0 : i5, (i7 & 16384) != 0 ? 0L : j2, (32768 & i7) != 0 ? 0 : i6, (i7 & 65536) != 0 ? "" : str4);
    }
}
