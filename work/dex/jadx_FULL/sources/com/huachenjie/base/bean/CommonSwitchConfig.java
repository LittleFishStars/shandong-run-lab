package com.huachenjie.base.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\t\u0010&\u001a\u00020\u0013HÖ\u0001J\u0019\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0011\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016¨\u0006,"}, d2 = {"Lcom/huachenjie/base/bean/CommonSwitchConfig;", "Landroid/os/Parcelable;", "homeMetaEntryList", "", "Lcom/huachenjie/base/bean/CommonSwitchEntranceConfig;", "uploadRefreshTime", "", "refreshMyTab", "", "publicRoomId", "", "visionEnable", "faceEnable", "mySchoolEnable", "dedicatedSupportSwitch", "dedicatedSupportLinkUrl", "deskEntryList", "buddyEnable", "taskDisplayCount", "", "(Ljava/util/List;JZLjava/lang/String;ZZZZLjava/lang/String;Ljava/util/List;ZI)V", "getBuddyEnable", "()Z", "getDedicatedSupportLinkUrl", "()Ljava/lang/String;", "getDedicatedSupportSwitch", "getDeskEntryList", "()Ljava/util/List;", "getFaceEnable", "getHomeMetaEntryList", "getMySchoolEnable", "getPublicRoomId", "getRefreshMyTab", "getTaskDisplayCount", "()I", "getUploadRefreshTime", "()J", "getVisionEnable", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CommonSwitchConfig implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<CommonSwitchConfig> CREATOR = new Creator();
    private final boolean buddyEnable;

    @NotNull
    private final String dedicatedSupportLinkUrl;
    private final boolean dedicatedSupportSwitch;

    @NotNull
    private final List<CommonSwitchEntranceConfig> deskEntryList;
    private final boolean faceEnable;

    @NotNull
    private final List<CommonSwitchEntranceConfig> homeMetaEntryList;
    private final boolean mySchoolEnable;

    @NotNull
    private final String publicRoomId;
    private final boolean refreshMyTab;
    private final int taskDisplayCount;
    private final long uploadRefreshTime;
    private final boolean visionEnable;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CommonSwitchConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CommonSwitchConfig createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(CommonSwitchEntranceConfig.CREATOR.createFromParcel(parcel));
            }
            long j = parcel.readLong();
            boolean z = parcel.readInt() != 0;
            String string = parcel.readString();
            boolean z2 = parcel.readInt() != 0;
            boolean z3 = parcel.readInt() != 0;
            boolean z4 = parcel.readInt() != 0;
            boolean z5 = parcel.readInt() != 0;
            String string2 = parcel.readString();
            int i3 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(i3);
            for (int i4 = 0; i4 != i3; i4++) {
                arrayList2.add(CommonSwitchEntranceConfig.CREATOR.createFromParcel(parcel));
            }
            return new CommonSwitchConfig(arrayList, j, z, string, z2, z3, z4, z5, string2, arrayList2, parcel.readInt() != 0, parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CommonSwitchConfig[] newArray(int i) {
            return new CommonSwitchConfig[i];
        }
    }

    public CommonSwitchConfig() {
        this(null, 0L, false, null, false, false, false, false, null, null, false, 0, 4095, null);
    }

    public CommonSwitchConfig(@NotNull List<CommonSwitchEntranceConfig> list, long j, boolean z, @NotNull String str, boolean z2, boolean z3, boolean z4, boolean z5, @NotNull String str2, @NotNull List<CommonSwitchEntranceConfig> list2, boolean z6, int i) {
        Intrinsics.checkNotNullParameter(list, "homeMetaEntryList");
        Intrinsics.checkNotNullParameter(str, "publicRoomId");
        Intrinsics.checkNotNullParameter(str2, "dedicatedSupportLinkUrl");
        Intrinsics.checkNotNullParameter(list2, "deskEntryList");
        this.homeMetaEntryList = list;
        this.uploadRefreshTime = j;
        this.refreshMyTab = z;
        this.publicRoomId = str;
        this.visionEnable = z2;
        this.faceEnable = z3;
        this.mySchoolEnable = z4;
        this.dedicatedSupportSwitch = z5;
        this.dedicatedSupportLinkUrl = str2;
        this.deskEntryList = list2;
        this.buddyEnable = z6;
        this.taskDisplayCount = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean getBuddyEnable() {
        return this.buddyEnable;
    }

    @NotNull
    public final String getDedicatedSupportLinkUrl() {
        return this.dedicatedSupportLinkUrl;
    }

    public final boolean getDedicatedSupportSwitch() {
        return this.dedicatedSupportSwitch;
    }

    @NotNull
    public final List<CommonSwitchEntranceConfig> getDeskEntryList() {
        return this.deskEntryList;
    }

    public final boolean getFaceEnable() {
        return this.faceEnable;
    }

    @NotNull
    public final List<CommonSwitchEntranceConfig> getHomeMetaEntryList() {
        return this.homeMetaEntryList;
    }

    public final boolean getMySchoolEnable() {
        return this.mySchoolEnable;
    }

    @NotNull
    public final String getPublicRoomId() {
        return this.publicRoomId;
    }

    public final boolean getRefreshMyTab() {
        return this.refreshMyTab;
    }

    public final int getTaskDisplayCount() {
        return this.taskDisplayCount;
    }

    public final long getUploadRefreshTime() {
        return this.uploadRefreshTime;
    }

    public final boolean getVisionEnable() {
        return this.visionEnable;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<CommonSwitchEntranceConfig> list = this.homeMetaEntryList;
        parcel.writeInt(list.size());
        Iterator<CommonSwitchEntranceConfig> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
        parcel.writeLong(this.uploadRefreshTime);
        parcel.writeInt(this.refreshMyTab ? 1 : 0);
        parcel.writeString(this.publicRoomId);
        parcel.writeInt(this.visionEnable ? 1 : 0);
        parcel.writeInt(this.faceEnable ? 1 : 0);
        parcel.writeInt(this.mySchoolEnable ? 1 : 0);
        parcel.writeInt(this.dedicatedSupportSwitch ? 1 : 0);
        parcel.writeString(this.dedicatedSupportLinkUrl);
        List<CommonSwitchEntranceConfig> list2 = this.deskEntryList;
        parcel.writeInt(list2.size());
        Iterator<CommonSwitchEntranceConfig> it2 = list2.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.buddyEnable ? 1 : 0);
        parcel.writeInt(this.taskDisplayCount);
    }

    public /* synthetic */ CommonSwitchConfig(List list, long j, boolean z, String str, boolean z2, boolean z3, boolean z4, boolean z5, String str2, List list2, boolean z6, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? CollectionsKt.emptyList() : list, (i2 & 2) != 0 ? 5L : j, (i2 & 4) != 0 ? true : z, (i2 & 8) != 0 ? "" : str, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? false : z3, (i2 & 64) != 0 ? false : z4, (i2 & 128) != 0 ? false : z5, (i2 & 256) == 0 ? str2 : "", (i2 & 512) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 1024) == 0 ? z6 : false, (i2 & 2048) != 0 ? 3 : i);
    }
}
