package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.zj.adlib.i76;
import com.zj.adlib.yw6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public abstract class DataBufferRef {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @KeepForSdk
    public int f31273a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public final DataHolder f5632a;
    public int b;

    @KeepForSdk
    public DataBufferRef(@NonNull DataHolder dataHolder, int i) {
        this.f5632a = (DataHolder) yw6.l(dataHolder);
        zaa(i);
    }

    @KeepForSdk
    public boolean a(@NonNull String str) {
        return this.f5632a.hasColumn(str);
    }

    @KeepForSdk
    public boolean b() {
        return !this.f5632a.isClosed();
    }

    @KeepForSdk
    public void copyToBuffer(@NonNull String str, @NonNull CharArrayBuffer charArrayBuffer) {
        this.f5632a.zac(str, this.f31273a, this.b, charArrayBuffer);
    }

    @KeepForSdk
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof DataBufferRef) {
            DataBufferRef dataBufferRef = (DataBufferRef) obj;
            if (i76.b(Integer.valueOf(dataBufferRef.f31273a), Integer.valueOf(this.f31273a)) && i76.b(Integer.valueOf(dataBufferRef.b), Integer.valueOf(this.b)) && dataBufferRef.f5632a == this.f5632a) {
                return true;
            }
        }
        return false;
    }

    @KeepForSdk
    public boolean getBoolean(@NonNull String str) {
        return this.f5632a.getBoolean(str, this.f31273a, this.b);
    }

    @NonNull
    @KeepForSdk
    public byte[] getByteArray(@NonNull String str) {
        return this.f5632a.getByteArray(str, this.f31273a, this.b);
    }

    @KeepForSdk
    public int getDataRow() {
        return this.f31273a;
    }

    @KeepForSdk
    public double getDouble(@NonNull String str) {
        return this.f5632a.zaa(str, this.f31273a, this.b);
    }

    @KeepForSdk
    public float getFloat(@NonNull String str) {
        return this.f5632a.zab(str, this.f31273a, this.b);
    }

    @KeepForSdk
    public int getInteger(@NonNull String str) {
        return this.f5632a.getInteger(str, this.f31273a, this.b);
    }

    @KeepForSdk
    public long getLong(@NonNull String str) {
        return this.f5632a.getLong(str, this.f31273a, this.b);
    }

    @NonNull
    @KeepForSdk
    public String getString(@NonNull String str) {
        return this.f5632a.getString(str, this.f31273a, this.b);
    }

    @KeepForSdk
    public boolean hasNull(@NonNull String str) {
        return this.f5632a.hasNull(str, this.f31273a, this.b);
    }

    @KeepForSdk
    public int hashCode() {
        return i76.c(Integer.valueOf(this.f31273a), Integer.valueOf(this.b), this.f5632a);
    }

    @Nullable
    @KeepForSdk
    public Uri parseUri(@NonNull String str) {
        String string = this.f5632a.getString(str, this.f31273a, this.b);
        if (string == null) {
            return null;
        }
        return Uri.parse(string);
    }

    public final void zaa(int i) {
        boolean z = false;
        if (i >= 0 && i < this.f5632a.getCount()) {
            z = true;
        }
        yw6.r(z);
        this.f31273a = i;
        this.b = this.f5632a.getWindowIndex(i);
    }
}
