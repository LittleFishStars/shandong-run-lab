package androidx.camera.core;

import android.support.v4.media.MediaDescriptionCompat;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Logger {
    static final int DEFAULT_MIN_LOG_LEVEL = 3;
    private static final int MAX_TAG_LENGTH = 23;
    private static int sMinLogLevel = 3;

    private Logger() {
    }

    public static void d(@NonNull String str, @NonNull String str2) {
        String strTruncateTag = truncateTag(str);
        if (isLogLevelEnabled(strTruncateTag, 3)) {
            Log.d(strTruncateTag, str2);
        }
    }

    public static void e(@NonNull String str, @NonNull String str2) {
        String strTruncateTag = truncateTag(str);
        if (isLogLevelEnabled(strTruncateTag, 6)) {
            Log.e(strTruncateTag, str2);
        }
    }

    public static int getMinLogLevel() {
        return sMinLogLevel;
    }

    public static void i(@NonNull String str, @NonNull String str2) {
        String strTruncateTag = truncateTag(str);
        if (isLogLevelEnabled(strTruncateTag, 4)) {
            Log.i(strTruncateTag, str2);
        }
    }

    public static boolean isDebugEnabled(@NonNull String str) {
        return isLogLevelEnabled(truncateTag(str), 3);
    }

    public static boolean isErrorEnabled(@NonNull String str) {
        return isLogLevelEnabled(truncateTag(str), 6);
    }

    public static boolean isInfoEnabled(@NonNull String str) {
        return isLogLevelEnabled(truncateTag(str), 4);
    }

    private static boolean isLogLevelEnabled(@NonNull String str, int i) {
        return sMinLogLevel <= i || Log.isLoggable(str, i);
    }

    public static boolean isWarnEnabled(@NonNull String str) {
        return isLogLevelEnabled(truncateTag(str), 5);
    }

    public static void resetMinLogLevel() {
        sMinLogLevel = 3;
    }

    public static void setMinLogLevel(@IntRange(from = MediaDescriptionCompat.BT_FOLDER_TYPE_ARTISTS, to = MediaDescriptionCompat.BT_FOLDER_TYPE_YEARS) int i) {
        sMinLogLevel = i;
    }

    @NonNull
    private static String truncateTag(@NonNull String str) {
        return str;
    }

    public static void w(@NonNull String str, @NonNull String str2) {
        String strTruncateTag = truncateTag(str);
        if (isLogLevelEnabled(strTruncateTag, 5)) {
            Log.w(strTruncateTag, str2);
        }
    }

    public static void d(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        String strTruncateTag = truncateTag(str);
        if (isLogLevelEnabled(strTruncateTag, 3)) {
            Log.d(strTruncateTag, str2, th);
        }
    }

    public static void e(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        String strTruncateTag = truncateTag(str);
        if (isLogLevelEnabled(strTruncateTag, 6)) {
            Log.e(strTruncateTag, str2, th);
        }
    }

    public static void i(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        String strTruncateTag = truncateTag(str);
        if (isLogLevelEnabled(strTruncateTag, 4)) {
            Log.i(strTruncateTag, str2, th);
        }
    }

    public static void w(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        String strTruncateTag = truncateTag(str);
        if (isLogLevelEnabled(strTruncateTag, 5)) {
            Log.w(strTruncateTag, str2, th);
        }
    }
}
