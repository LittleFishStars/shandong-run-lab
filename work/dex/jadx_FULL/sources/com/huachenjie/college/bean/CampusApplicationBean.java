package com.huachenjie.college.bean;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.college.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u001a\u001a\u00020\u001bJ\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/college/bean/CampusApplicationBean;", "", "title", "", "iconUrl", "type", "", "subType", "linkUrl", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getIconUrl", "()Ljava/lang/String;", "getLinkUrl", "getSubType", "()I", "getTitle", "getType", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "", "other", "getIconOptions", "Lcom/bumptech/glide/request/RequestOptions;", "hashCode", "toString", "college_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CampusApplicationBean {

    @NotNull
    private final String iconUrl;

    @NotNull
    private final String linkUrl;
    private final int subType;

    @NotNull
    private final String title;
    private final int type;

    public CampusApplicationBean() {
        this(null, null, 0, 0, null, 31, null);
    }

    public CampusApplicationBean(@NotNull String str, @NotNull String str2, int i, int i2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "iconUrl");
        Intrinsics.checkNotNullParameter(str3, "linkUrl");
        this.title = str;
        this.iconUrl = str2;
        this.type = i;
        this.subType = i2;
        this.linkUrl = str3;
    }

    public static /* synthetic */ CampusApplicationBean copy$default(CampusApplicationBean campusApplicationBean, String str, String str2, int i, int i2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = campusApplicationBean.title;
        }
        if ((i3 & 2) != 0) {
            str2 = campusApplicationBean.iconUrl;
        }
        String str4 = str2;
        if ((i3 & 4) != 0) {
            i = campusApplicationBean.type;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = campusApplicationBean.subType;
        }
        int i5 = i2;
        if ((i3 & 16) != 0) {
            str3 = campusApplicationBean.linkUrl;
        }
        return campusApplicationBean.copy(str, str4, i4, i5, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getSubType() {
        return this.subType;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLinkUrl() {
        return this.linkUrl;
    }

    @NotNull
    public final CampusApplicationBean copy(@NotNull String title, @NotNull String iconUrl, int type, int subType, @NotNull String linkUrl) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(linkUrl, "linkUrl");
        return new CampusApplicationBean(title, iconUrl, type, subType, linkUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CampusApplicationBean)) {
            return false;
        }
        CampusApplicationBean campusApplicationBean = (CampusApplicationBean) other;
        return Intrinsics.areEqual(this.title, campusApplicationBean.title) && Intrinsics.areEqual(this.iconUrl, campusApplicationBean.iconUrl) && this.type == campusApplicationBean.type && this.subType == campusApplicationBean.subType && Intrinsics.areEqual(this.linkUrl, campusApplicationBean.linkUrl);
    }

    @NotNull
    public final RequestOptions getIconOptions() {
        int i;
        int i2 = this.subType;
        if (i2 == -1) {
            i = R.drawable.college_ic_application_scan;
        } else if (i2 == 10) {
            i = R.drawable.college_ic_application_my_apply;
        } else if (i2 == 11) {
            i = R.drawable.college_ic_application_club;
        } else if (i2 == 20) {
            i = R.drawable.college_ic_application_video_teaching;
        } else if (i2 != 21) {
            switch (i2) {
                case 1:
                    i = R.drawable.college_ic_application_attention;
                    break;
                case 2:
                    i = R.drawable.college_ic_application_choose_classes;
                    break;
                case 3:
                    i = R.drawable.college_ic_application_mine_sport_test;
                    break;
                case 4:
                    i = R.drawable.college_ic_application_mine_exam_list;
                    break;
                case 5:
                    i = R.drawable.college_ic_application_sports_achievement;
                    break;
                case 6:
                    i = R.drawable.college_ic_application_my_huodong;
                    break;
                case 7:
                    i = R.drawable.college_ic_application_venue_reservation;
                    break;
                case 8:
                    i = R.drawable.college_ic_application_competition_entry;
                    break;
                default:
                    i = 0;
                    break;
            }
        } else {
            i = R.drawable.college_ic_application_pegrade;
        }
        if (i == 0) {
            RequestOptions requestOptionsDiskCacheStrategy = RequestOptions.centerCropTransform().diskCacheStrategy(DiskCacheStrategy.ALL);
            Intrinsics.checkNotNullExpressionValue(requestOptionsDiskCacheStrategy, "{\n            RequestOpt…heStrategy.ALL)\n        }");
            return requestOptionsDiskCacheStrategy;
        }
        RequestOptions requestOptionsDiskCacheStrategy2 = RequestOptions.placeholderOf(i).error(i).diskCacheStrategy(DiskCacheStrategy.ALL);
        Intrinsics.checkNotNullExpressionValue(requestOptionsDiskCacheStrategy2, "{\n            RequestOpt…heStrategy.ALL)\n        }");
        return requestOptionsDiskCacheStrategy2;
    }

    @NotNull
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @NotNull
    public final String getLinkUrl() {
        return this.linkUrl;
    }

    public final int getSubType() {
        return this.subType;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((this.title.hashCode() * 31) + this.iconUrl.hashCode()) * 31) + Integer.hashCode(this.type)) * 31) + Integer.hashCode(this.subType)) * 31) + this.linkUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "CampusApplicationBean(title=" + this.title + ", iconUrl=" + this.iconUrl + ", type=" + this.type + ", subType=" + this.subType + ", linkUrl=" + this.linkUrl + ')';
    }

    public /* synthetic */ CampusApplicationBean(String str, String str2, int i, int i2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2, (i3 & 16) != 0 ? "" : str3);
    }
}
