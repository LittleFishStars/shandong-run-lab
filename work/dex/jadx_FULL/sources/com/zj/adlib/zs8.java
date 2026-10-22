package com.zj.adlib;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@VisibleForTesting
@KeepForSdk
public class zs8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f46334a = Pattern.compile("\\$\\{(.*?)\\}");

    @Nullable
    @KeepForSdk
    public static String a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = false)
    @KeepForSdk
    public static boolean b(@Nullable String str) {
        return str == null || str.trim().isEmpty();
    }
}
