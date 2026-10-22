package androidx.core.content;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public final class MimeTypeFilter {
    private MimeTypeFilter() {
    }

    public static boolean matches(@Nullable String str, @NonNull String str2) {
        if (str == null) {
            return false;
        }
        return mimeTypeAgainstFilter(str.split(WVNativeCallbackUtil.SEPERATER), str2.split(WVNativeCallbackUtil.SEPERATER));
    }

    @NonNull
    public static String[] matchesMany(@Nullable String[] strArr, @NonNull String str) {
        if (strArr == null) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        String[] strArrSplit = str.split(WVNativeCallbackUtil.SEPERATER);
        for (String str2 : strArr) {
            if (mimeTypeAgainstFilter(str2.split(WVNativeCallbackUtil.SEPERATER), strArrSplit)) {
                arrayList.add(str2);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static boolean mimeTypeAgainstFilter(@NonNull String[] strArr, @NonNull String[] strArr2) {
        if (strArr2.length != 2) {
            throw new IllegalArgumentException("Ill-formatted MIME type filter. Must be type/subtype.");
        }
        if (strArr2[0].isEmpty() || strArr2[1].isEmpty()) {
            throw new IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
        }
        if (strArr.length != 2) {
            return false;
        }
        if ("*".equals(strArr2[0]) || strArr2[0].equals(strArr[0])) {
            return "*".equals(strArr2[1]) || strArr2[1].equals(strArr[1]);
        }
        return false;
    }

    @Nullable
    public static String matches(@Nullable String str, @NonNull String[] strArr) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split(WVNativeCallbackUtil.SEPERATER);
        for (String str2 : strArr) {
            if (mimeTypeAgainstFilter(strArrSplit, str2.split(WVNativeCallbackUtil.SEPERATER))) {
                return str2;
            }
        }
        return null;
    }

    @Nullable
    public static String matches(@Nullable String[] strArr, @NonNull String str) {
        if (strArr == null) {
            return null;
        }
        String[] strArrSplit = str.split(WVNativeCallbackUtil.SEPERATER);
        for (String str2 : strArr) {
            if (mimeTypeAgainstFilter(str2.split(WVNativeCallbackUtil.SEPERATER), strArrSplit)) {
                return str2;
            }
        }
        return null;
    }
}
