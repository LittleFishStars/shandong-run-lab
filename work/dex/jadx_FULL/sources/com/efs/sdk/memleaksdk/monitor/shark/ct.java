package com.efs.sdk.memleaksdk.monitor.shark;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0003*\u00020\u0003H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0003H\u0000\u001a\u0014\u0010\t\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"UTF_8", "Ljava/nio/charset/Charset;", "createHash", "", "text", "algorithm", "createSHA1Hash", "getBytes", "", "lastSegment", "segmentingChar", "", "memleaksdk_release"}, k = 2, mv = {1, 4, 1})
public final class ct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final Charset f29856a;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "Charset.forName(\"UTF-8\")");
        f29856a = charsetForName;
    }

    @NotNull
    public static final String a(@NotNull String str, char c) {
        Intrinsics.checkNotNullParameter(str, "$this$lastSegment");
        int iLastIndexOf$default = StringsKt.lastIndexOf$default(str, c, 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return str;
        }
        String strSubstring = str.substring(iLastIndexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    @NotNull
    public static final byte[] b(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$getBytes");
        byte[] bytes = str.getBytes(f29856a);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @NotNull
    public static final String a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$createSHA1Hash");
        return a(str, "SHA-1");
    }

    private static final String a(String str, String str2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            messageDigest.update(b(str));
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString(b & 255));
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "hexString.toString()");
            return string;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError("Unable to construct MessageDigest for " + str2);
        }
    }
}
