package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public final class ServiceSpecificExtraArgs {

    @KeepForSdk
    public interface CastExtraArgs {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        @KeepForSdk
        public static final String f31291a = "listener";
    }

    @KeepForSdk
    public interface GamesExtraArgs {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        @KeepForSdk
        public static final String f31292a = "com.google.android.gms.games.key.gamePackageName";

        @NonNull
        @KeepForSdk
        public static final String b = "com.google.android.gms.games.key.desiredLocale";

        @NonNull
        @KeepForSdk
        public static final String c = "com.google.android.gms.games.key.popupWindowToken";

        @NonNull
        @KeepForSdk
        public static final String d = "com.google.android.gms.games.key.signInOptions";
    }

    @KeepForSdk
    public interface PlusExtraArgs {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        @KeepForSdk
        public static final String f31293a = "auth_package";
    }
}
