package com.huachenjie.works.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.mine.page.dressing_table.avatar.AvatarFragment;
import com.huachenjie.works.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b&\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u000eHÆ\u0003J_\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u00100\u001a\u00020\u000e2\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\bHÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0011R\u0011\u0010\u001e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011R\u0011\u0010 \u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b!\u0010\u0011R\u0011\u0010\"\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b#\u0010\u0011R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0011¨\u00064"}, d2 = {"Lcom/huachenjie/works/bean/SchoolMateBean;", "", "appUserCode", "", "userName", AvatarFragment.AVATAR_URL, "gradeName", "sex", "", "tagList", "", "Lcom/huachenjie/works/bean/InterestTag;", "accId", "isApplied", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Z)V", "getAccId", "()Ljava/lang/String;", "getAppUserCode", "getAvatarUrl", "getGradeName", "()Z", "setApplied", "(Z)V", "getSex", "()I", "sexIcon", "getSexIcon", "sexStr", "getSexStr", "tag1", "getTag1", "tag2", "getTag2", "tag3", "getTag3", "getTagList", "()Ljava/util/List;", "getUserName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SchoolMateBean {

    @NotNull
    private final String accId;

    @NotNull
    private final String appUserCode;

    @NotNull
    private final String avatarUrl;

    @NotNull
    private final String gradeName;
    private boolean isApplied;
    private final int sex;

    @NotNull
    private final List<InterestTag> tagList;

    @NotNull
    private final String userName;

    public SchoolMateBean() {
        this(null, null, null, null, 0, null, null, false, 255, null);
    }

    public SchoolMateBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i, @NotNull List<InterestTag> list, @NotNull String str5, boolean z) {
        Intrinsics.checkNotNullParameter(str, "appUserCode");
        Intrinsics.checkNotNullParameter(str2, "userName");
        Intrinsics.checkNotNullParameter(str3, AvatarFragment.AVATAR_URL);
        Intrinsics.checkNotNullParameter(str4, "gradeName");
        Intrinsics.checkNotNullParameter(list, "tagList");
        Intrinsics.checkNotNullParameter(str5, "accId");
        this.appUserCode = str;
        this.userName = str2;
        this.avatarUrl = str3;
        this.gradeName = str4;
        this.sex = i;
        this.tagList = list;
        this.accId = str5;
        this.isApplied = z;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAppUserCode() {
        return this.appUserCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getGradeName() {
        return this.gradeName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getSex() {
        return this.sex;
    }

    @NotNull
    public final List<InterestTag> component6() {
        return this.tagList;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getAccId() {
        return this.accId;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsApplied() {
        return this.isApplied;
    }

    @NotNull
    public final SchoolMateBean copy(@NotNull String appUserCode, @NotNull String userName, @NotNull String avatarUrl, @NotNull String gradeName, int sex, @NotNull List<InterestTag> tagList, @NotNull String accId, boolean isApplied) {
        Intrinsics.checkNotNullParameter(appUserCode, "appUserCode");
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(avatarUrl, AvatarFragment.AVATAR_URL);
        Intrinsics.checkNotNullParameter(gradeName, "gradeName");
        Intrinsics.checkNotNullParameter(tagList, "tagList");
        Intrinsics.checkNotNullParameter(accId, "accId");
        return new SchoolMateBean(appUserCode, userName, avatarUrl, gradeName, sex, tagList, accId, isApplied);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SchoolMateBean)) {
            return false;
        }
        SchoolMateBean schoolMateBean = (SchoolMateBean) other;
        return Intrinsics.areEqual(this.appUserCode, schoolMateBean.appUserCode) && Intrinsics.areEqual(this.userName, schoolMateBean.userName) && Intrinsics.areEqual(this.avatarUrl, schoolMateBean.avatarUrl) && Intrinsics.areEqual(this.gradeName, schoolMateBean.gradeName) && this.sex == schoolMateBean.sex && Intrinsics.areEqual(this.tagList, schoolMateBean.tagList) && Intrinsics.areEqual(this.accId, schoolMateBean.accId) && this.isApplied == schoolMateBean.isApplied;
    }

    @NotNull
    public final String getAccId() {
        return this.accId;
    }

    @NotNull
    public final String getAppUserCode() {
        return this.appUserCode;
    }

    @NotNull
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    @NotNull
    public final String getGradeName() {
        return this.gradeName;
    }

    public final int getSex() {
        return this.sex;
    }

    public final int getSexIcon() {
        return this.sex == 1 ? R.drawable.works_ic_find_albumni_girl : R.drawable.works_ic_find_albumni_boy;
    }

    @NotNull
    public final String getSexStr() {
        int i = this.sex;
        if (i != 1) {
            return i != 2 ? "未知" : "男";
        }
        return "女";
    }

    @NotNull
    public final String getTag1() {
        String tagName;
        InterestTag interestTag = (InterestTag) CollectionsKt.getOrNull(this.tagList, 0);
        return (interestTag == null || (tagName = interestTag.getTagName()) == null) ? "" : tagName;
    }

    @NotNull
    public final String getTag2() {
        String tagName;
        InterestTag interestTag = (InterestTag) CollectionsKt.getOrNull(this.tagList, 1);
        return (interestTag == null || (tagName = interestTag.getTagName()) == null) ? "" : tagName;
    }

    @NotNull
    public final String getTag3() {
        String tagName;
        InterestTag interestTag = (InterestTag) CollectionsKt.getOrNull(this.tagList, 2);
        return (interestTag == null || (tagName = interestTag.getTagName()) == null) ? "" : tagName;
    }

    @NotNull
    public final List<InterestTag> getTagList() {
        return this.tagList;
    }

    @NotNull
    public final String getUserName() {
        return this.userName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    public int hashCode() {
        int iHashCode = ((((((((((((this.appUserCode.hashCode() * 31) + this.userName.hashCode()) * 31) + this.avatarUrl.hashCode()) * 31) + this.gradeName.hashCode()) * 31) + Integer.hashCode(this.sex)) * 31) + this.tagList.hashCode()) * 31) + this.accId.hashCode()) * 31;
        boolean z = this.isApplied;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean isApplied() {
        return this.isApplied;
    }

    public final void setApplied(boolean z) {
        this.isApplied = z;
    }

    @NotNull
    public String toString() {
        return "SchoolMateBean(appUserCode=" + this.appUserCode + ", userName=" + this.userName + ", avatarUrl=" + this.avatarUrl + ", gradeName=" + this.gradeName + ", sex=" + this.sex + ", tagList=" + this.tagList + ", accId=" + this.accId + ", isApplied=" + this.isApplied + ')';
    }

    public /* synthetic */ SchoolMateBean(String str, String str2, String str3, String str4, int i, List list, String str5, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? new ArrayList() : list, (i2 & 64) == 0 ? str5 : "", (i2 & 128) == 0 ? z : false);
    }
}
