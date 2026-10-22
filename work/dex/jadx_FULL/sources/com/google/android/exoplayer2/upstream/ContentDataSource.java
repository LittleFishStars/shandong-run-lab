package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.zj.adlib.gj9;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ContentDataSource extends BaseDataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f31104a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ContentResolver f5021a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public AssetFileDescriptor f5022a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Uri f5023a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public FileInputStream f5024a;
    public boolean b;

    public static class ContentDataSourceException extends DataSourceException {
        @Deprecated
        public ContentDataSourceException(IOException iOException) {
            this(iOException, 2000);
        }

        public ContentDataSourceException(@Nullable IOException iOException, int i) {
            super(iOException, i);
        }
    }

    public ContentDataSource(Context context) {
        super(false);
        this.f5021a = context.getContentResolver();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long a(DataSpec dataSpec) throws ContentDataSourceException {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        try {
            Uri uri = dataSpec.f5026a;
            this.f5023a = uri;
            transferInitializing(dataSpec);
            if ("content".equals(dataSpec.f5026a.getScheme())) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                assetFileDescriptorOpenAssetFileDescriptor = this.f5021a.openTypedAssetFileDescriptor(uri, "*/*", bundle);
            } else {
                assetFileDescriptorOpenAssetFileDescriptor = this.f5021a.openAssetFileDescriptor(uri, "r");
            }
            this.f5022a = assetFileDescriptorOpenAssetFileDescriptor;
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                throw new ContentDataSourceException(new IOException("Could not open file descriptor for: " + uri), 2000);
            }
            long length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
            FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
            this.f5024a = fileInputStream;
            if (length != -1 && dataSpec.f5032c > length) {
                throw new ContentDataSourceException(null, 2008);
            }
            long startOffset = assetFileDescriptorOpenAssetFileDescriptor.getStartOffset();
            long jSkip = fileInputStream.skip(dataSpec.f5032c + startOffset) - startOffset;
            if (jSkip != dataSpec.f5032c) {
                throw new ContentDataSourceException(null, 2008);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                long size = channel.size();
                if (size == 0) {
                    this.f31104a = -1L;
                } else {
                    long jPosition = size - channel.position();
                    this.f31104a = jPosition;
                    if (jPosition < 0) {
                        throw new ContentDataSourceException(null, 2008);
                    }
                }
            } else {
                long j = length - jSkip;
                this.f31104a = j;
                if (j < 0) {
                    throw new ContentDataSourceException(null, 2008);
                }
            }
            long jMin = dataSpec.f5033d;
            if (jMin != -1) {
                long j2 = this.f31104a;
                if (j2 != -1) {
                    jMin = Math.min(j2, jMin);
                }
                this.f31104a = jMin;
            }
            this.b = true;
            transferStarted(dataSpec);
            long j3 = dataSpec.f5033d;
            return j3 != -1 ? j3 : this.f31104a;
        } catch (ContentDataSourceException e) {
            throw e;
        } catch (IOException e2) {
            throw new ContentDataSourceException(e2, e2 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0037 */
    /* JADX WARN: Bottom block not found for handler: all -> 0x0055 */
    @Override // com.google.android.exoplayer2.upstream.DataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void close() throws ContentDataSourceException {
        this.f5023a = null;
        try {
            FileInputStream fileInputStream = this.f5024a;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            this.f5024a = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor = this.f5022a;
                    if (assetFileDescriptor != null) {
                        assetFileDescriptor.close();
                    }
                    this.f5022a = null;
                    if (this.b) {
                        this.b = false;
                        transferEnded();
                    }
                } catch (IOException e) {
                    throw new ContentDataSourceException(e, 2000);
                }
            } catch (Throwable th) {
                this.f5022a = null;
                if (this.b) {
                    this.b = false;
                    transferEnded();
                }
                throw th;
            }
        } catch (IOException e2) {
            throw new ContentDataSourceException(e2, 2000);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f5023a;
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws ContentDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f31104a;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new ContentDataSourceException(e, 2000);
            }
        }
        int i3 = ((FileInputStream) gj9.k(this.f5024a)).read(bArr, i, i2);
        if (i3 == -1) {
            return -1;
        }
        long j2 = this.f31104a;
        if (j2 != -1) {
            this.f31104a = j2 - ((long) i3);
        }
        bytesTransferred(i3);
        return i3;
    }
}
