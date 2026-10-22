package com.huachenjie.social_contact.bean;

import com.huachenjie.base.bean.UnlockMode;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b'\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f¢\u0006\u0002\u0010\u0013J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000fHÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\fHÆ\u0003J\t\u00100\u001a\u00020\fHÆ\u0003J\u0087\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000fHÆ\u0001J\u0006\u00102\u001a\u00020\bJ\u0013\u00103\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\bHÖ\u0001J\u0006\u00106\u001a\u00020\bJ\u0006\u00107\u001a\u00020\bJ\t\u00108\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u001a\u0010\r\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!¨\u00069"}, d2 = {"Lcom/huachenjie/social_contact/bean/GameBean;", "", "metaverseGameIconCode", "", "metaverseModelCode", "name", "description", "freeFlag", "", "unlockRemark", "imgUrl", "unlockFlag", "", "wearFlag", "attributeList", "", "Lcom/huachenjie/social_contact/bean/AttributeBean;", "unlockMode", "Lcom/huachenjie/base/bean/UnlockMode;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZZLjava/util/List;Ljava/util/List;)V", "getAttributeList", "()Ljava/util/List;", "getDescription", "()Ljava/lang/String;", "getFreeFlag", "()I", "getImgUrl", "getMetaverseGameIconCode", "getMetaverseModelCode", "getName", "getUnlockFlag", "()Z", "setUnlockFlag", "(Z)V", "getUnlockMode", "getUnlockRemark", "getWearFlag", "setWearFlag", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "crystalValue", "equals", "other", "hashCode", "skinVoucher", "starDrill", "toString", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGameDataBean.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GameDataBean.kt\ncom/huachenjie/social_contact/bean/GameBean\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,31:1\n1#2:32\n*E\n"})
public final /* data */ class GameBean {

    @Nullable
    private final List<AttributeBean> attributeList;

    @NotNull
    private final String description;
    private final int freeFlag;

    @NotNull
    private final String imgUrl;

    @NotNull
    private final String metaverseGameIconCode;

    @NotNull
    private final String metaverseModelCode;

    @NotNull
    private final String name;
    private boolean unlockFlag;

    @Nullable
    private final List<UnlockMode> unlockMode;

    @NotNull
    private final String unlockRemark;
    private boolean wearFlag;

    public GameBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i, @NotNull String str5, @NotNull String str6, boolean z, boolean z2, @Nullable List<AttributeBean> list, @Nullable List<UnlockMode> list2) {
        Intrinsics.checkNotNullParameter(str, "metaverseGameIconCode");
        Intrinsics.checkNotNullParameter(str2, "metaverseModelCode");
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(str4, "description");
        Intrinsics.checkNotNullParameter(str5, "unlockRemark");
        Intrinsics.checkNotNullParameter(str6, "imgUrl");
        this.metaverseGameIconCode = str;
        this.metaverseModelCode = str2;
        this.name = str3;
        this.description = str4;
        this.freeFlag = i;
        this.unlockRemark = str5;
        this.imgUrl = str6;
        this.unlockFlag = z;
        this.wearFlag = z2;
        this.attributeList = list;
        this.unlockMode = list2;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMetaverseGameIconCode() {
        return this.metaverseGameIconCode;
    }

    @Nullable
    public final List<AttributeBean> component10() {
        return this.attributeList;
    }

    @Nullable
    public final List<UnlockMode> component11() {
        return this.unlockMode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMetaverseModelCode() {
        return this.metaverseModelCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getFreeFlag() {
        return this.freeFlag;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getUnlockRemark() {
        return this.unlockRemark;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getImgUrl() {
        return this.imgUrl;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getUnlockFlag() {
        return this.unlockFlag;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getWearFlag() {
        return this.wearFlag;
    }

    @NotNull
    public final GameBean copy(@NotNull String metaverseGameIconCode, @NotNull String metaverseModelCode, @NotNull String name, @NotNull String description, int freeFlag, @NotNull String unlockRemark, @NotNull String imgUrl, boolean unlockFlag, boolean wearFlag, @Nullable List<AttributeBean> attributeList, @Nullable List<UnlockMode> unlockMode) {
        Intrinsics.checkNotNullParameter(metaverseGameIconCode, "metaverseGameIconCode");
        Intrinsics.checkNotNullParameter(metaverseModelCode, "metaverseModelCode");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(unlockRemark, "unlockRemark");
        Intrinsics.checkNotNullParameter(imgUrl, "imgUrl");
        return new GameBean(metaverseGameIconCode, metaverseModelCode, name, description, freeFlag, unlockRemark, imgUrl, unlockFlag, wearFlag, attributeList, unlockMode);
    }

    public final int crystalValue() {
        Object next;
        boolean z;
        List<UnlockMode> list = this.unlockMode;
        if (list == null) {
            return 0;
        }
        Iterator<T> it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            z = true;
            if (((UnlockMode) next).getType() != 1) {
                z = false;
            }
        } while (!z);
        UnlockMode unlockMode = (UnlockMode) next;
        if (unlockMode != null) {
            return unlockMode.getValue();
        }
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameBean)) {
            return false;
        }
        GameBean gameBean = (GameBean) other;
        return Intrinsics.areEqual(this.metaverseGameIconCode, gameBean.metaverseGameIconCode) && Intrinsics.areEqual(this.metaverseModelCode, gameBean.metaverseModelCode) && Intrinsics.areEqual(this.name, gameBean.name) && Intrinsics.areEqual(this.description, gameBean.description) && this.freeFlag == gameBean.freeFlag && Intrinsics.areEqual(this.unlockRemark, gameBean.unlockRemark) && Intrinsics.areEqual(this.imgUrl, gameBean.imgUrl) && this.unlockFlag == gameBean.unlockFlag && this.wearFlag == gameBean.wearFlag && Intrinsics.areEqual(this.attributeList, gameBean.attributeList) && Intrinsics.areEqual(this.unlockMode, gameBean.unlockMode);
    }

    @Nullable
    public final List<AttributeBean> getAttributeList() {
        return this.attributeList;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    public final int getFreeFlag() {
        return this.freeFlag;
    }

    @NotNull
    public final String getImgUrl() {
        return this.imgUrl;
    }

    @NotNull
    public final String getMetaverseGameIconCode() {
        return this.metaverseGameIconCode;
    }

    @NotNull
    public final String getMetaverseModelCode() {
        return this.metaverseModelCode;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final boolean getUnlockFlag() {
        return this.unlockFlag;
    }

    @Nullable
    public final List<UnlockMode> getUnlockMode() {
        return this.unlockMode;
    }

    @NotNull
    public final String getUnlockRemark() {
        return this.unlockRemark;
    }

    public final boolean getWearFlag() {
        return this.wearFlag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    public int hashCode() {
        int iHashCode = ((((((((((((this.metaverseGameIconCode.hashCode() * 31) + this.metaverseModelCode.hashCode()) * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + Integer.hashCode(this.freeFlag)) * 31) + this.unlockRemark.hashCode()) * 31) + this.imgUrl.hashCode()) * 31;
        boolean z = this.unlockFlag;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.wearFlag;
        int i2 = (i + (z2 ? 1 : z2)) * 31;
        List<AttributeBean> list = this.attributeList;
        int iHashCode2 = (i2 + (list == null ? 0 : list.hashCode())) * 31;
        List<UnlockMode> list2 = this.unlockMode;
        return iHashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setUnlockFlag(boolean z) {
        this.unlockFlag = z;
    }

    public final void setWearFlag(boolean z) {
        this.wearFlag = z;
    }

    public final int skinVoucher() {
        Object next;
        List<UnlockMode> list = this.unlockMode;
        if (list == null) {
            return 0;
        }
        Iterator<T> it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((UnlockMode) next).getType() == 3));
        UnlockMode unlockMode = (UnlockMode) next;
        if (unlockMode != null) {
            return unlockMode.getValue();
        }
        return 0;
    }

    public final int starDrill() {
        Object next;
        List<UnlockMode> list = this.unlockMode;
        if (list == null) {
            return 0;
        }
        Iterator<T> it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((UnlockMode) next).getType() == 2));
        UnlockMode unlockMode = (UnlockMode) next;
        if (unlockMode != null) {
            return unlockMode.getValue();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "GameBean(metaverseGameIconCode=" + this.metaverseGameIconCode + ", metaverseModelCode=" + this.metaverseModelCode + ", name=" + this.name + ", description=" + this.description + ", freeFlag=" + this.freeFlag + ", unlockRemark=" + this.unlockRemark + ", imgUrl=" + this.imgUrl + ", unlockFlag=" + this.unlockFlag + ", wearFlag=" + this.wearFlag + ", attributeList=" + this.attributeList + ", unlockMode=" + this.unlockMode + ')';
    }
}
