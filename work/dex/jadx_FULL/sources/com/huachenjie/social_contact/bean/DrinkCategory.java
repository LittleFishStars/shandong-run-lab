package com.huachenjie.social_contact.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/social_contact/bean/DrinkCategory;", "", "code", "", "name", "", "(ILjava/lang/String;)V", "getCode", "()I", "getName", "()Ljava/lang/String;", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DrinkCategory {
    private final int code;

    @NotNull
    private final String name;

    /* JADX WARN: Illegal instructions before constructor call */
    public DrinkCategory() {
        String str = null;
        this(0, str, 3, str);
    }

    public DrinkCategory(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.code = i;
        this.name = str;
    }

    public static /* synthetic */ DrinkCategory copy$default(DrinkCategory drinkCategory, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = drinkCategory.code;
        }
        if ((i2 & 2) != 0) {
            str = drinkCategory.name;
        }
        return drinkCategory.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final DrinkCategory copy(int code, @NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new DrinkCategory(code, name);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DrinkCategory)) {
            return false;
        }
        DrinkCategory drinkCategory = (DrinkCategory) other;
        return this.code == drinkCategory.code && Intrinsics.areEqual(this.name, drinkCategory.name);
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (Integer.hashCode(this.code) * 31) + this.name.hashCode();
    }

    @NotNull
    public String toString() {
        return "DrinkCategory(code=" + this.code + ", name=" + this.name + ')';
    }

    public /* synthetic */ DrinkCategory(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str);
    }
}
