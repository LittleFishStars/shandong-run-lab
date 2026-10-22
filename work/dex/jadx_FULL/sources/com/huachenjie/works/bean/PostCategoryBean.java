package com.huachenjie.works.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.mine.page.dressing_table.nickName.NicknameFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\u0006\u0010\u001e\u001a\u00020\u0003J\t\u0010\u001f\u001a\u00020\u0019HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006&"}, d2 = {"Lcom/huachenjie/works/bean/PostCategoryBean;", "Landroid/os/Parcelable;", "typeCode", "", "tagCode", "name", NicknameFragment.NICKNAME, "logo", "description", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getLogo", "getName", "getNickname", "getTagCode", "getTypeCode", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "getTagName", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PostCategoryBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<PostCategoryBean> CREATOR = new Creator();

    @NotNull
    private final String description;

    @NotNull
    private final String logo;

    @NotNull
    private final String name;

    @NotNull
    private final String nickname;

    @NotNull
    private final String tagCode;

    @NotNull
    private final String typeCode;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PostCategoryBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PostCategoryBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PostCategoryBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PostCategoryBean[] newArray(int i) {
            return new PostCategoryBean[i];
        }
    }

    public PostCategoryBean() {
        this(null, null, null, null, null, null, 63, null);
    }

    public PostCategoryBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "typeCode");
        Intrinsics.checkNotNullParameter(str2, "tagCode");
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(str4, NicknameFragment.NICKNAME);
        Intrinsics.checkNotNullParameter(str5, "logo");
        Intrinsics.checkNotNullParameter(str6, "description");
        this.typeCode = str;
        this.tagCode = str2;
        this.name = str3;
        this.nickname = str4;
        this.logo = str5;
        this.description = str6;
    }

    public static /* synthetic */ PostCategoryBean copy$default(PostCategoryBean postCategoryBean, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = postCategoryBean.typeCode;
        }
        if ((i & 2) != 0) {
            str2 = postCategoryBean.tagCode;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = postCategoryBean.name;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = postCategoryBean.nickname;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = postCategoryBean.logo;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = postCategoryBean.description;
        }
        return postCategoryBean.copy(str, str7, str8, str9, str10, str6);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTypeCode() {
        return this.typeCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTagCode() {
        return this.tagCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLogo() {
        return this.logo;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final PostCategoryBean copy(@NotNull String typeCode, @NotNull String tagCode, @NotNull String name, @NotNull String nickname, @NotNull String logo, @NotNull String description) {
        Intrinsics.checkNotNullParameter(typeCode, "typeCode");
        Intrinsics.checkNotNullParameter(tagCode, "tagCode");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(nickname, NicknameFragment.NICKNAME);
        Intrinsics.checkNotNullParameter(logo, "logo");
        Intrinsics.checkNotNullParameter(description, "description");
        return new PostCategoryBean(typeCode, tagCode, name, nickname, logo, description);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostCategoryBean)) {
            return false;
        }
        PostCategoryBean postCategoryBean = (PostCategoryBean) other;
        return Intrinsics.areEqual(this.typeCode, postCategoryBean.typeCode) && Intrinsics.areEqual(this.tagCode, postCategoryBean.tagCode) && Intrinsics.areEqual(this.name, postCategoryBean.name) && Intrinsics.areEqual(this.nickname, postCategoryBean.nickname) && Intrinsics.areEqual(this.logo, postCategoryBean.logo) && Intrinsics.areEqual(this.description, postCategoryBean.description);
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getLogo() {
        return this.logo;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getNickname() {
        return this.nickname;
    }

    @NotNull
    public final String getTagCode() {
        return this.tagCode;
    }

    @NotNull
    public final String getTagName() {
        return '#' + this.name;
    }

    @NotNull
    public final String getTypeCode() {
        return this.typeCode;
    }

    public int hashCode() {
        return (((((((((this.typeCode.hashCode() * 31) + this.tagCode.hashCode()) * 31) + this.name.hashCode()) * 31) + this.nickname.hashCode()) * 31) + this.logo.hashCode()) * 31) + this.description.hashCode();
    }

    @NotNull
    public String toString() {
        return "PostCategoryBean(typeCode=" + this.typeCode + ", tagCode=" + this.tagCode + ", name=" + this.name + ", nickname=" + this.nickname + ", logo=" + this.logo + ", description=" + this.description + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.typeCode);
        parcel.writeString(this.tagCode);
        parcel.writeString(this.name);
        parcel.writeString(this.nickname);
        parcel.writeString(this.logo);
        parcel.writeString(this.description);
    }

    public /* synthetic */ PostCategoryBean(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6);
    }
}
