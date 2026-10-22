package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import androidx.annotation.Nullable;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class AssetDataSource extends BaseDataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f31100a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AssetManager f5013a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Uri f5014a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public InputStream f5015a;
    public boolean b;

    public static final class AssetDataSourceException extends DataSourceException {
        @Deprecated
        public AssetDataSourceException(IOException iOException) {
            super(iOException, 2000);
        }

        public AssetDataSourceException(@Nullable Throwable th, int i) {
            super(th, i);
        }
    }

    public AssetDataSource(Context context) {
        super(false);
        this.f5013a = context.getAssets();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long a(DataSpec dataSpec) throws AssetDataSourceException {
        try {
            Uri uri = dataSpec.f5026a;
            this.f5014a = uri;
            String strSubstring = (String) sb0.g(uri.getPath());
            if (strSubstring.startsWith("/android_asset/")) {
                strSubstring = strSubstring.substring(15);
            } else if (strSubstring.startsWith(WVNativeCallbackUtil.SEPERATER)) {
                strSubstring = strSubstring.substring(1);
            }
            transferInitializing(dataSpec);
            InputStream inputStreamOpen = this.f5013a.open(strSubstring, 1);
            this.f5015a = inputStreamOpen;
            if (inputStreamOpen.skip(dataSpec.f5032c) < dataSpec.f5032c) {
                throw new AssetDataSourceException(null, 2008);
            }
            long j = dataSpec.f5033d;
            if (j != -1) {
                this.f31100a = j;
            } else {
                long jAvailable = this.f5015a.available();
                this.f31100a = jAvailable;
                if (jAvailable == 2147483647L) {
                    this.f31100a = -1L;
                }
            }
            this.b = true;
            transferStarted(dataSpec);
            return this.f31100a;
        } catch (AssetDataSourceException e) {
            throw e;
        } catch (IOException e2) {
            throw new AssetDataSourceException(e2, e2 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0017 */
    @Override // com.google.android.exoplayer2.upstream.DataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void close() throws AssetDataSourceException {
        this.f5014a = null;
        try {
            InputStream inputStream = this.f5015a;
            if (inputStream != null) {
                inputStream.close();
            }
            this.f5015a = null;
            if (this.b) {
                this.b = false;
                transferEnded();
            }
        } catch (IOException e) {
            throw new AssetDataSourceException(e, 2000);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f5014a;
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws AssetDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f31100a;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new AssetDataSourceException(e, 2000);
            }
        }
        int i3 = ((InputStream) gj9.k(this.f5015a)).read(bArr, i, i2);
        if (i3 == -1) {
            return -1;
        }
        long j2 = this.f31100a;
        if (j2 != -1) {
            this.f31100a = j2 - ((long) i3);
        }
        bytesTransferred(i3);
        return i3;
    }
}
