package com.huachenjie.social_contact.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/social_contact/bean/SkillInfo;", "", "skillName", "", "skillImg", "(Ljava/lang/String;Ljava/lang/String;)V", "getSkillImg", "()Ljava/lang/String;", "setSkillImg", "(Ljava/lang/String;)V", "getSkillName", "setSkillName", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SkillInfo {

    @Nullable
    private String skillImg;

    @Nullable
    private String skillName;

    /* JADX WARN: Illegal instructions before constructor call */
    public SkillInfo() {
        String str = null;
        this(str, str, 3, str);
    }

    public SkillInfo(@Nullable String str, @Nullable String str2) {
        this.skillName = str;
        this.skillImg = str2;
    }

    public static /* synthetic */ SkillInfo copy$default(SkillInfo skillInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = skillInfo.skillName;
        }
        if ((i & 2) != 0) {
            str2 = skillInfo.skillImg;
        }
        return skillInfo.copy(str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSkillName() {
        return this.skillName;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSkillImg() {
        return this.skillImg;
    }

    @NotNull
    public final SkillInfo copy(@Nullable String skillName, @Nullable String skillImg) {
        return new SkillInfo(skillName, skillImg);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkillInfo)) {
            return false;
        }
        SkillInfo skillInfo = (SkillInfo) other;
        return Intrinsics.areEqual(this.skillName, skillInfo.skillName) && Intrinsics.areEqual(this.skillImg, skillInfo.skillImg);
    }

    @Nullable
    public final String getSkillImg() {
        return this.skillImg;
    }

    @Nullable
    public final String getSkillName() {
        return this.skillName;
    }

    public int hashCode() {
        String str = this.skillName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.skillImg;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setSkillImg(@Nullable String str) {
        this.skillImg = str;
    }

    public final void setSkillName(@Nullable String str) {
        this.skillName = str;
    }

    @NotNull
    public String toString() {
        return "SkillInfo(skillName=" + this.skillName + ", skillImg=" + this.skillImg + ')';
    }

    public /* synthetic */ SkillInfo(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}
