package com.byazt.vf;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.byazt.zqa.c;
import com.bytedance.sdk.openadsdk.ITTProvider;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@c(c = {0, 1, 944, 945})
public class TTMultiProvider extends ContentProvider {
    private ITTProvider c(Uri uri) {
        if (TTAdSdk.getAdManager() == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("proto2_ittprovider", true);
        bundle.putInt("layerType", tt(uri));
        return new com.byazt.gxc.c(TTAdSdk.getAdManager().getExtra(Function.class, bundle));
    }

    private int tt(Uri uri) {
        try {
            return Integer.parseInt(uri.getQueryParameter("layerType"));
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        if (c(uri) != null) {
            return c(uri).delete(uri, str, strArr);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return c(uri) != null ? c(uri).getType(uri) : "";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (c(uri) != null) {
            return c(uri).insert(uri, contentValues);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (c(uri) != null) {
            return c(uri).query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (c(uri) != null) {
            return c(uri).update(uri, contentValues, str, strArr);
        }
        return 0;
    }
}
