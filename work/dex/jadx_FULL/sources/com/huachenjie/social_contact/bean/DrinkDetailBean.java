package com.huachenjie.social_contact.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003JY\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010$\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\tHÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011¨\u0006("}, d2 = {"Lcom/huachenjie/social_contact/bean/DrinkDetailBean;", "", "drinkId", "", "imageUrl", "name", "description", "digestTimeDesc", "charmValue", "", "price", "affordable", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)V", "getAffordable", "()Z", "getCharmValue", "()I", "consumeStr", "getConsumeStr", "()Ljava/lang/String;", "getDescription", "getDigestTimeDesc", "getDrinkId", "getImageUrl", "getName", "getPrice", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DrinkDetailBean {
    private final boolean affordable;
    private final int charmValue;

    @NotNull
    private final String description;

    @NotNull
    private final String digestTimeDesc;

    @NotNull
    private final String drinkId;

    @NotNull
    private final String imageUrl;

    @NotNull
    private final String name;
    private final int price;

    public DrinkDetailBean() {
        this(null, null, null, null, null, 0, 0, false, 255, null);
    }

    public DrinkDetailBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "drinkId");
        Intrinsics.checkNotNullParameter(str2, "imageUrl");
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(str4, "description");
        Intrinsics.checkNotNullParameter(str5, "digestTimeDesc");
        this.drinkId = str;
        this.imageUrl = str2;
        this.name = str3;
        this.description = str4;
        this.digestTimeDesc = str5;
        this.charmValue = i;
        this.price = i2;
        this.affordable = z;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDrinkId() {
        return this.drinkId;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
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

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDigestTimeDesc() {
        return this.digestTimeDesc;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getCharmValue() {
        return this.charmValue;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getAffordable() {
        return this.affordable;
    }

    @NotNull
    public final DrinkDetailBean copy(@NotNull String drinkId, @NotNull String imageUrl, @NotNull String name, @NotNull String description, @NotNull String digestTimeDesc, int charmValue, int price, boolean affordable) {
        Intrinsics.checkNotNullParameter(drinkId, "drinkId");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(digestTimeDesc, "digestTimeDesc");
        return new DrinkDetailBean(drinkId, imageUrl, name, description, digestTimeDesc, charmValue, price, affordable);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DrinkDetailBean)) {
            return false;
        }
        DrinkDetailBean drinkDetailBean = (DrinkDetailBean) other;
        return Intrinsics.areEqual(this.drinkId, drinkDetailBean.drinkId) && Intrinsics.areEqual(this.imageUrl, drinkDetailBean.imageUrl) && Intrinsics.areEqual(this.name, drinkDetailBean.name) && Intrinsics.areEqual(this.description, drinkDetailBean.description) && Intrinsics.areEqual(this.digestTimeDesc, drinkDetailBean.digestTimeDesc) && this.charmValue == drinkDetailBean.charmValue && this.price == drinkDetailBean.price && this.affordable == drinkDetailBean.affordable;
    }

    public final boolean getAffordable() {
        return this.affordable;
    }

    public final int getCharmValue() {
        return this.charmValue;
    }

    @NotNull
    public final String getConsumeStr() {
        return "消化耗时：" + this.digestTimeDesc + "  |  魅力值：可获得" + this.charmValue + "魅力值";
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getDigestTimeDesc() {
        return this.digestTimeDesc;
    }

    @NotNull
    public final String getDrinkId() {
        return this.drinkId;
    }

    @NotNull
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getPrice() {
        return this.price;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    public int hashCode() {
        int iHashCode = ((((((((((((this.drinkId.hashCode() * 31) + this.imageUrl.hashCode()) * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.digestTimeDesc.hashCode()) * 31) + Integer.hashCode(this.charmValue)) * 31) + Integer.hashCode(this.price)) * 31;
        boolean z = this.affordable;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    @NotNull
    public String toString() {
        return "DrinkDetailBean(drinkId=" + this.drinkId + ", imageUrl=" + this.imageUrl + ", name=" + this.name + ", description=" + this.description + ", digestTimeDesc=" + this.digestTimeDesc + ", charmValue=" + this.charmValue + ", price=" + this.price + ", affordable=" + this.affordable + ')';
    }

    public /* synthetic */ DrinkDetailBean(String str, String str2, String str3, String str4, String str5, int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) == 0 ? str5 : "", (i3 & 32) != 0 ? 0 : i, (i3 & 64) != 0 ? 0 : i2, (i3 & 128) == 0 ? z : false);
    }
}
