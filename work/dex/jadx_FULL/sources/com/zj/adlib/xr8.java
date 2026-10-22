package com.zj.adlib;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class xr8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    @GuardedBy("sLk")
    public static xr8 f45885a;
    public static final Lock b = new ReentrantLock();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("mLk")
    public final SharedPreferences f20714a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Lock f20715a = new ReentrantLock();

    @VisibleForTesting
    public xr8(Context context) {
        this.f20714a = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    @NonNull
    @KeepForSdk
    public static xr8 b(@NonNull Context context) {
        yw6.l(context);
        b.lock();
        try {
            if (f45885a == null) {
                f45885a = new xr8(context.getApplicationContext());
            }
            return f45885a;
        } finally {
            b.unlock();
        }
    }

    public static final String h(String str, String str2) {
        return str + u15.f19942b + str2;
    }

    @KeepForSdk
    public void a() {
        this.f20715a.lock();
        try {
            this.f20714a.edit().clear().apply();
        } finally {
            this.f20715a.unlock();
        }
    }

    @Nullable
    @KeepForSdk
    public GoogleSignInAccount c() {
        String strZaa;
        String strZaa2 = zaa("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strZaa2) || (strZaa = zaa(h("googleSignInAccount", strZaa2))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.zab(strZaa);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Nullable
    @KeepForSdk
    public GoogleSignInOptions d() {
        String strZaa;
        String strZaa2 = zaa("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strZaa2) || (strZaa = zaa(h("googleSignInOptions", strZaa2))) == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.zab(strZaa);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Nullable
    @KeepForSdk
    public String e() {
        return zaa("refreshToken");
    }

    @KeepForSdk
    public void f(@NonNull GoogleSignInAccount googleSignInAccount, @NonNull GoogleSignInOptions googleSignInOptions) {
        yw6.l(googleSignInAccount);
        yw6.l(googleSignInOptions);
        zad("defaultGoogleSignInAccount", googleSignInAccount.zac());
        yw6.l(googleSignInAccount);
        yw6.l(googleSignInOptions);
        String strZac = googleSignInAccount.zac();
        zad(h("googleSignInAccount", strZac), googleSignInAccount.zad());
        zad(h("googleSignInOptions", strZac), googleSignInOptions.zaf());
    }

    public final void g() {
        String strZaa = zaa("defaultGoogleSignInAccount");
        zab("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strZaa)) {
            return;
        }
        zab(h("googleSignInAccount", strZaa));
        zab(h("googleSignInOptions", strZaa));
    }

    @Nullable
    public final String zaa(@NonNull String str) {
        this.f20715a.lock();
        try {
            return this.f20714a.getString(str, null);
        } finally {
            this.f20715a.unlock();
        }
    }

    public final void zab(@NonNull String str) {
        this.f20715a.lock();
        try {
            this.f20714a.edit().remove(str).apply();
        } finally {
            this.f20715a.unlock();
        }
    }

    public final void zad(@NonNull String str, @NonNull String str2) {
        this.f20715a.lock();
        try {
            this.f20714a.edit().putString(str, str2).apply();
        } finally {
            this.f20715a.unlock();
        }
    }
}
