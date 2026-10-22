package com.zj.adlib;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class chd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f40972a = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f15817a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final ComponentName f15818a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final String f15819a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f15820a;

    @Nullable
    public final String b;

    public chd(ComponentName componentName, int i) {
        this.f15819a = null;
        this.b = null;
        yw6.l(componentName);
        this.f15818a = componentName;
        this.f15817a = i;
        this.f15820a = false;
    }

    public final int a() {
        return this.f15817a;
    }

    @Nullable
    public final ComponentName b() {
        return this.f15818a;
    }

    public final Intent c(Context context) {
        Bundle bundleCall;
        if (this.f15819a == null) {
            return new Intent().setComponent(this.f15818a);
        }
        Intent intent = null;
        if (this.f15820a) {
            Bundle bundle = new Bundle();
            bundle.putString("serviceActionBundleKey", this.f15819a);
            try {
                bundleCall = context.getContentResolver().call(f40972a, "serviceIntentCall", (String) null, bundle);
            } catch (IllegalArgumentException e) {
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
                bundleCall = null;
            }
            intent = bundleCall != null ? (Intent) bundleCall.getParcelable("serviceResponseIntentKey") : null;
            if (intent == null) {
                Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(this.f15819a)));
            }
        }
        return intent != null ? intent : new Intent(this.f15819a).setPackage(this.b);
    }

    @Nullable
    public final String d() {
        return this.b;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof chd)) {
            return false;
        }
        chd chdVar = (chd) obj;
        return i76.b(this.f15819a, chdVar.f15819a) && i76.b(this.b, chdVar.b) && i76.b(this.f15818a, chdVar.f15818a) && this.f15817a == chdVar.f15817a && this.f15820a == chdVar.f15820a;
    }

    public final int hashCode() {
        return i76.c(this.f15819a, this.b, this.f15818a, Integer.valueOf(this.f15817a), Boolean.valueOf(this.f15820a));
    }

    public final String toString() {
        String str = this.f15819a;
        if (str != null) {
            return str;
        }
        yw6.l(this.f15818a);
        return this.f15818a.flattenToString();
    }

    public chd(String str, int i, boolean z) {
        this(str, "com.google.android.gms", i, false);
    }

    public chd(String str, String str2, int i, boolean z) {
        yw6.h(str);
        this.f15819a = str;
        yw6.h(str2);
        this.b = str2;
        this.f15818a = null;
        this.f15817a = i;
        this.f15820a = z;
    }
}
