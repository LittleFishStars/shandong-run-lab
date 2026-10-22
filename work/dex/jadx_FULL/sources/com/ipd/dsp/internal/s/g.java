package com.ipd.dsp.internal.s;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.d0.m;
import com.ipd.dsp.internal.f.i;
import com.ipd.dsp.internal.f.k;
import com.ipd.dsp.internal.i.v;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class g implements k<Uri, Drawable> {
    public static final com.ipd.dsp.internal.f.h<Resources.Theme> b = com.ipd.dsp.internal.f.h.a("com.ipd.dsp.internal.components.glide.load.resource.bitmap.Downsampler.Theme");
    public static final String c = "android";
    public static final int d = 0;
    public static final int e = 2;
    public static final int f = 0;
    public static final int g = 1;
    public static final int h = 1;
    public static final int i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f38534a;

    public g(Context context) {
        this.f38534a = context.getApplicationContext();
    }

    @DrawableRes
    public final int b(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return a(context, uri);
        }
        if (pathSegments.size() == 1) {
            return a(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    @Override // com.ipd.dsp.internal.f.k
    public boolean a(@NonNull Uri uri, @NonNull i iVar) {
        String scheme = uri.getScheme();
        return scheme != null && scheme.equals(com.google.android.exoplayer2.upstream.c.h);
    }

    @Override // com.ipd.dsp.internal.f.k
    @Nullable
    public v<Drawable> a(@NonNull Uri uri, int i2, int i3, @NonNull i iVar) {
        Drawable drawableA;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            Context contextA = a(uri, authority);
            int iB = b(contextA, uri);
            Resources.Theme theme = ((String) m.a(authority)).equals(this.f38534a.getPackageName()) ? (Resources.Theme) iVar.a(b) : null;
            if (theme == null) {
                drawableA = c.a(this.f38534a, contextA, iB);
            } else {
                drawableA = c.a(this.f38534a, iB, theme);
            }
            return f.a(drawableA);
        }
        throw new IllegalStateException("Package name for " + uri + " is null or empty");
    }

    @NonNull
    public final Context a(Uri uri, @NonNull String str) {
        if (str.equals(this.f38534a.getPackageName())) {
            return this.f38534a;
        }
        try {
            return this.f38534a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            if (str.contains(this.f38534a.getPackageName())) {
                return this.f38534a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e2);
        }
    }

    @DrawableRes
    public final int a(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    @DrawableRes
    public final int a(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e2);
        }
    }
}
