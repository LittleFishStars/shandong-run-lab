package com.huachenjie.works.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/works/bean/BuddyTypeScopeTypeBean;", "", "buddyTypeCode", "", "buddyTypeName", "iconURL", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBuddyTypeCode", "()Ljava/lang/String;", "getBuddyTypeName", "getIconURL", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BuddyTypeScopeTypeBean {

    @NotNull
    private final String buddyTypeCode;

    @NotNull
    private final String buddyTypeName;

    @NotNull
    private final String iconURL;

    public BuddyTypeScopeTypeBean() {
        this(null, null, null, 7, null);
    }

    public BuddyTypeScopeTypeBean(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "buddyTypeCode");
        Intrinsics.checkNotNullParameter(str2, "buddyTypeName");
        Intrinsics.checkNotNullParameter(str3, "iconURL");
        this.buddyTypeCode = str;
        this.buddyTypeName = str2;
        this.iconURL = str3;
    }

    public static /* synthetic */ BuddyTypeScopeTypeBean copy$default(BuddyTypeScopeTypeBean buddyTypeScopeTypeBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = buddyTypeScopeTypeBean.buddyTypeCode;
        }
        if ((i & 2) != 0) {
            str2 = buddyTypeScopeTypeBean.buddyTypeName;
        }
        if ((i & 4) != 0) {
            str3 = buddyTypeScopeTypeBean.iconURL;
        }
        return buddyTypeScopeTypeBean.copy(str, str2, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBuddyTypeCode() {
        return this.buddyTypeCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBuddyTypeName() {
        return this.buddyTypeName;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getIconURL() {
        return this.iconURL;
    }

    @NotNull
    public final BuddyTypeScopeTypeBean copy(@NotNull String buddyTypeCode, @NotNull String buddyTypeName, @NotNull String iconURL) {
        Intrinsics.checkNotNullParameter(buddyTypeCode, "buddyTypeCode");
        Intrinsics.checkNotNullParameter(buddyTypeName, "buddyTypeName");
        Intrinsics.checkNotNullParameter(iconURL, "iconURL");
        return new BuddyTypeScopeTypeBean(buddyTypeCode, buddyTypeName, iconURL);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BuddyTypeScopeTypeBean)) {
            return false;
        }
        BuddyTypeScopeTypeBean buddyTypeScopeTypeBean = (BuddyTypeScopeTypeBean) other;
        return Intrinsics.areEqual(this.buddyTypeCode, buddyTypeScopeTypeBean.buddyTypeCode) && Intrinsics.areEqual(this.buddyTypeName, buddyTypeScopeTypeBean.buddyTypeName) && Intrinsics.areEqual(this.iconURL, buddyTypeScopeTypeBean.iconURL);
    }

    @NotNull
    public final String getBuddyTypeCode() {
        return this.buddyTypeCode;
    }

    @NotNull
    public final String getBuddyTypeName() {
        return this.buddyTypeName;
    }

    @NotNull
    public final String getIconURL() {
        return this.iconURL;
    }

    public int hashCode() {
        return (((this.buddyTypeCode.hashCode() * 31) + this.buddyTypeName.hashCode()) * 31) + this.iconURL.hashCode();
    }

    @NotNull
    public String toString() {
        return "BuddyTypeScopeTypeBean(buddyTypeCode=" + this.buddyTypeCode + ", buddyTypeName=" + this.buddyTypeName + ", iconURL=" + this.iconURL + ')';
    }

    public /* synthetic */ BuddyTypeScopeTypeBean(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }
}
