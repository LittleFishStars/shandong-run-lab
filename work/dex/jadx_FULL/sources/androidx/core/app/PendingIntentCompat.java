package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public final class PendingIntentCompat {

    @RequiresApi(16)
    public static class Api16Impl {
        private Api16Impl() {
        }

        @NonNull
        @DoNotInline
        public static PendingIntent getActivities(@NonNull Context context, int i, @NonNull @SuppressLint({"ArrayReturn"}) Intent[] intentArr, int i2, @NonNull Bundle bundle) {
            return PendingIntent.getActivities(context, i, intentArr, i2, bundle);
        }

        @NonNull
        @DoNotInline
        public static PendingIntent getActivity(@NonNull Context context, int i, @NonNull Intent intent, int i2, @NonNull Bundle bundle) {
            return PendingIntent.getActivity(context, i, intent, i2, bundle);
        }
    }

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static PendingIntent getForegroundService(Context context, int i, Intent intent, int i2) {
            return PendingIntent.getForegroundService(context, i, intent, i2);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private PendingIntentCompat() {
    }

    private static int addMutabilityFlags(boolean z, int i) {
        int i2;
        if (!z) {
            i2 = TTAdConstant.KEY_CLICK_AREA;
        } else {
            if (Build.VERSION.SDK_INT < 31) {
                return i;
            }
            i2 = 33554432;
        }
        return i | i2;
    }

    @NonNull
    public static PendingIntent getActivities(@NonNull Context context, int i, @NonNull @SuppressLint({"ArrayReturn"}) Intent[] intentArr, int i2, @NonNull Bundle bundle, boolean z) {
        return Api16Impl.getActivities(context, i, intentArr, addMutabilityFlags(z, i2), bundle);
    }

    @NonNull
    public static PendingIntent getActivity(@NonNull Context context, int i, @NonNull Intent intent, int i2, boolean z) {
        return PendingIntent.getActivity(context, i, intent, addMutabilityFlags(z, i2));
    }

    @NonNull
    public static PendingIntent getBroadcast(@NonNull Context context, int i, @NonNull Intent intent, int i2, boolean z) {
        return PendingIntent.getBroadcast(context, i, intent, addMutabilityFlags(z, i2));
    }

    @NonNull
    @RequiresApi(26)
    public static PendingIntent getForegroundService(@NonNull Context context, int i, @NonNull Intent intent, int i2, boolean z) {
        return Api26Impl.getForegroundService(context, i, intent, addMutabilityFlags(z, i2));
    }

    @NonNull
    public static PendingIntent getService(@NonNull Context context, int i, @NonNull Intent intent, int i2, boolean z) {
        return PendingIntent.getService(context, i, intent, addMutabilityFlags(z, i2));
    }

    @NonNull
    public static PendingIntent getActivities(@NonNull Context context, int i, @NonNull @SuppressLint({"ArrayReturn"}) Intent[] intentArr, int i2, boolean z) {
        return PendingIntent.getActivities(context, i, intentArr, addMutabilityFlags(z, i2));
    }

    @NonNull
    public static PendingIntent getActivity(@NonNull Context context, int i, @NonNull Intent intent, int i2, @NonNull Bundle bundle, boolean z) {
        return Api16Impl.getActivity(context, i, intent, addMutabilityFlags(z, i2), bundle);
    }
}
