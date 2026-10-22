package com.bytedance.pangle.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Keep
public abstract class PluginContentProvider extends ContentProvider {
    public Uri pluginUri;

    @Override // android.content.ContentProvider
    public abstract int delete(Uri uri, String str, String[] strArr);

    @Override // android.content.ContentProvider
    public abstract String getType(Uri uri);

    @Override // android.content.ContentProvider
    public abstract Uri insert(Uri uri, ContentValues contentValues);

    @Override // android.content.ContentProvider
    public abstract Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    @Override // android.content.ContentProvider
    public abstract int update(Uri uri, ContentValues contentValues, String str, String[] strArr);
}
