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
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003Ji\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010¨\u0006,"}, d2 = {"Lcom/huachenjie/works/bean/BroadcastFloorBean;", "", "topic", "", "name", "description", "coverImages", "", "surveyNo", "surveyName", "surveyCoverImage", "broadcastNo", "handled", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getBroadcastNo", "()Ljava/lang/String;", "getCoverImages", "()Ljava/util/List;", "getDescription", "getHandled", "()Z", "setHandled", "(Z)V", "getName", "getSurveyCoverImage", "getSurveyName", "getSurveyNo", "getTopic", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "other", "hashCode", "", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BroadcastFloorBean {

    @NotNull
    private final String broadcastNo;

    @NotNull
    private final List<String> coverImages;

    @NotNull
    private final String description;
    private boolean handled;

    @NotNull
    private final String name;

    @NotNull
    private final String surveyCoverImage;

    @NotNull
    private final String surveyName;

    @NotNull
    private final String surveyNo;

    @NotNull
    private final String topic;

    public BroadcastFloorBean() {
        this(null, null, null, null, null, null, null, null, false, 511, null);
    }

    public BroadcastFloorBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull List<String> list, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, boolean z) {
        Intrinsics.checkNotNullParameter(str, "topic");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(list, "coverImages");
        Intrinsics.checkNotNullParameter(str4, "surveyNo");
        Intrinsics.checkNotNullParameter(str5, "surveyName");
        Intrinsics.checkNotNullParameter(str6, "surveyCoverImage");
        Intrinsics.checkNotNullParameter(str7, "broadcastNo");
        this.topic = str;
        this.name = str2;
        this.description = str3;
        this.coverImages = list;
        this.surveyNo = str4;
        this.surveyName = str5;
        this.surveyCoverImage = str6;
        this.broadcastNo = str7;
        this.handled = z;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTopic() {
        return this.topic;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final List<String> component4() {
        return this.coverImages;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSurveyNo() {
        return this.surveyNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSurveyName() {
        return this.surveyName;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getSurveyCoverImage() {
        return this.surveyCoverImage;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getBroadcastNo() {
        return this.broadcastNo;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getHandled() {
        return this.handled;
    }

    @NotNull
    public final BroadcastFloorBean copy(@NotNull String topic, @NotNull String name, @NotNull String description, @NotNull List<String> coverImages, @NotNull String surveyNo, @NotNull String surveyName, @NotNull String surveyCoverImage, @NotNull String broadcastNo, boolean handled) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(coverImages, "coverImages");
        Intrinsics.checkNotNullParameter(surveyNo, "surveyNo");
        Intrinsics.checkNotNullParameter(surveyName, "surveyName");
        Intrinsics.checkNotNullParameter(surveyCoverImage, "surveyCoverImage");
        Intrinsics.checkNotNullParameter(broadcastNo, "broadcastNo");
        return new BroadcastFloorBean(topic, name, description, coverImages, surveyNo, surveyName, surveyCoverImage, broadcastNo, handled);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BroadcastFloorBean)) {
            return false;
        }
        BroadcastFloorBean broadcastFloorBean = (BroadcastFloorBean) other;
        return Intrinsics.areEqual(this.topic, broadcastFloorBean.topic) && Intrinsics.areEqual(this.name, broadcastFloorBean.name) && Intrinsics.areEqual(this.description, broadcastFloorBean.description) && Intrinsics.areEqual(this.coverImages, broadcastFloorBean.coverImages) && Intrinsics.areEqual(this.surveyNo, broadcastFloorBean.surveyNo) && Intrinsics.areEqual(this.surveyName, broadcastFloorBean.surveyName) && Intrinsics.areEqual(this.surveyCoverImage, broadcastFloorBean.surveyCoverImage) && Intrinsics.areEqual(this.broadcastNo, broadcastFloorBean.broadcastNo) && this.handled == broadcastFloorBean.handled;
    }

    @NotNull
    public final String getBroadcastNo() {
        return this.broadcastNo;
    }

    @NotNull
    public final List<String> getCoverImages() {
        return this.coverImages;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    public final boolean getHandled() {
        return this.handled;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getSurveyCoverImage() {
        return this.surveyCoverImage;
    }

    @NotNull
    public final String getSurveyName() {
        return this.surveyName;
    }

    @NotNull
    public final String getSurveyNo() {
        return this.surveyNo;
    }

    @NotNull
    public final String getTopic() {
        return this.topic;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    public int hashCode() {
        int iHashCode = ((((((((((((((this.topic.hashCode() * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.coverImages.hashCode()) * 31) + this.surveyNo.hashCode()) * 31) + this.surveyName.hashCode()) * 31) + this.surveyCoverImage.hashCode()) * 31) + this.broadcastNo.hashCode()) * 31;
        boolean z = this.handled;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final void setHandled(boolean z) {
        this.handled = z;
    }

    @NotNull
    public String toString() {
        return "BroadcastFloorBean(topic=" + this.topic + ", name=" + this.name + ", description=" + this.description + ", coverImages=" + this.coverImages + ", surveyNo=" + this.surveyNo + ", surveyName=" + this.surveyName + ", surveyCoverImage=" + this.surveyCoverImage + ", broadcastNo=" + this.broadcastNo + ", handled=" + this.handled + ')';
    }

    public /* synthetic */ BroadcastFloorBean(String str, String str2, String str3, List list, String str4, String str5, String str6, String str7, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? new ArrayList() : list, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5, (i & 64) != 0 ? "" : str6, (i & 128) == 0 ? str7 : "", (i & 256) != 0 ? false : z);
    }
}
