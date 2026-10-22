package com.zj.adlib;

import com.huachenjie.common.util.media_picker.MediaPickerConstants;
import com.kuaishou.weapon.p0.t;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.zj.adlib.qh9, reason: from toString */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J-\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0002R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u001a\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/zj/adlib/qh9;", "", "", "a", "b", "c", "mimeType", "displayName", "lastPathSegment", "d", "toString", "", "hashCode", "other", "", "equals", "name", t.d, "j", "Ljava/lang/String;", y6b.g, "()Ljava/lang/String;", "f", y6b.f, "i", "()Z", "isGif", "k", "isVideo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "common_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class UriMetadata {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    public final String mimeType;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    @Nullable
    public final String displayName;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    @Nullable
    public final String lastPathSegment;

    public UriMetadata(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.mimeType = str;
        this.displayName = str2;
        this.lastPathSegment = str3;
    }

    public static /* synthetic */ UriMetadata e(UriMetadata uriMetadata, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uriMetadata.mimeType;
        }
        if ((i & 2) != 0) {
            str2 = uriMetadata.displayName;
        }
        if ((i & 4) != 0) {
            str3 = uriMetadata.lastPathSegment;
        }
        return uriMetadata.d(str, str2, str3);
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    @Nullable
    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    @Nullable
    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getLastPathSegment() {
        return this.lastPathSegment;
    }

    @NotNull
    public final UriMetadata d(@Nullable String mimeType, @Nullable String displayName, @Nullable String lastPathSegment) {
        return new UriMetadata(mimeType, displayName, lastPathSegment);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UriMetadata)) {
            return false;
        }
        UriMetadata uriMetadata = (UriMetadata) other;
        return Intrinsics.areEqual(this.mimeType, uriMetadata.mimeType) && Intrinsics.areEqual(this.displayName, uriMetadata.displayName) && Intrinsics.areEqual(this.lastPathSegment, uriMetadata.lastPathSegment);
    }

    @Nullable
    public final String f() {
        return this.displayName;
    }

    @Nullable
    public final String g() {
        return this.lastPathSegment;
    }

    @Nullable
    public final String h() {
        return this.mimeType;
    }

    public int hashCode() {
        String str = this.mimeType;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.displayName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.lastPathSegment;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final boolean i() {
        return Intrinsics.areEqual(this.mimeType, "image/gif") || j(this.displayName) || j(this.lastPathSegment);
    }

    public final boolean j(String name) {
        String lowerCase;
        String strSubstringAfterLast;
        if (name == null || (strSubstringAfterLast = StringsKt.substringAfterLast(name, '.', "")) == null) {
            lowerCase = null;
        } else {
            lowerCase = strSubstringAfterLast.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        }
        return MediaPickerConstants.f8905a.a().contains(lowerCase != null ? lowerCase : "");
    }

    public final boolean k() {
        String str = this.mimeType;
        return (str != null && StringsKt.startsWith$default(str, "video/", false, 2, (Object) null)) || l(this.displayName) || l(this.lastPathSegment);
    }

    public final boolean l(String name) {
        String lowerCase;
        String strSubstringAfterLast;
        if (name == null || (strSubstringAfterLast = StringsKt.substringAfterLast(name, '.', "")) == null) {
            lowerCase = null;
        } else {
            lowerCase = strSubstringAfterLast.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        }
        return MediaPickerConstants.f8905a.c().contains(lowerCase != null ? lowerCase : "");
    }

    @NotNull
    public String toString() {
        return "UriMetadata(mimeType=" + this.mimeType + ", displayName=" + this.displayName + ", lastPathSegment=" + this.lastPathSegment + ")";
    }
}
