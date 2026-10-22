package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import com.zj.adlib.u15;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class RawResourceDataSource extends BaseDataSource {
    public static final String b = "rawresource";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f31121a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public AssetFileDescriptor f5067a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Resources f5068a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Uri f5069a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public InputStream f5070a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f5071a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f5072b;

    public static class RawResourceDataSourceException extends DataSourceException {
        @Deprecated
        public RawResourceDataSourceException(String str) {
            super(str, null, 2000);
        }

        @Deprecated
        public RawResourceDataSourceException(Throwable th) {
            super(th, 2000);
        }

        public RawResourceDataSourceException(@Nullable String str, @Nullable Throwable th, int i) {
            super(str, th, i);
        }
    }

    public RawResourceDataSource(Context context) {
        super(false);
        this.f5068a = context.getResources();
        this.f5071a = context.getPackageName();
    }

    public static Uri buildRawResourceUri(int i) {
        return Uri.parse("rawresource:///" + i);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long a(DataSpec dataSpec) throws RawResourceDataSourceException {
        int identifier;
        String str;
        Uri uri = dataSpec.f5026a;
        this.f5069a = uri;
        if (TextUtils.equals("rawresource", uri.getScheme()) || (TextUtils.equals(c.h, uri.getScheme()) && uri.getPathSegments().size() == 1 && ((String) sb0.g(uri.getLastPathSegment())).matches("\\d+"))) {
            try {
                identifier = Integer.parseInt((String) sb0.g(uri.getLastPathSegment()));
            } catch (NumberFormatException unused) {
                throw new RawResourceDataSourceException("Resource identifier must be an integer.", null, 1004);
            }
        } else {
            if (!TextUtils.equals(c.h, uri.getScheme())) {
                throw new RawResourceDataSourceException("URI must either use scheme rawresource or android.resource", null, 1004);
            }
            String strSubstring = (String) sb0.g(uri.getPath());
            if (strSubstring.startsWith(WVNativeCallbackUtil.SEPERATER)) {
                strSubstring = strSubstring.substring(1);
            }
            String host = uri.getHost();
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(host)) {
                str = "";
            } else {
                str = host + u15.f19942b;
            }
            sb.append(str);
            sb.append(strSubstring);
            identifier = this.f5068a.getIdentifier(sb.toString(), "raw", this.f5071a);
            if (identifier == 0) {
                throw new RawResourceDataSourceException("Resource not found.", null, 2005);
            }
        }
        transferInitializing(dataSpec);
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = this.f5068a.openRawResourceFd(identifier);
            this.f5067a = assetFileDescriptorOpenRawResourceFd;
            if (assetFileDescriptorOpenRawResourceFd == null) {
                throw new RawResourceDataSourceException("Resource is compressed: " + uri, null, 2000);
            }
            long length = assetFileDescriptorOpenRawResourceFd.getLength();
            FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenRawResourceFd.getFileDescriptor());
            this.f5070a = fileInputStream;
            if (length != -1) {
                try {
                    if (dataSpec.f5032c > length) {
                        throw new RawResourceDataSourceException(null, null, 2008);
                    }
                } catch (RawResourceDataSourceException e) {
                    throw e;
                } catch (IOException e2) {
                    throw new RawResourceDataSourceException(null, e2, 2000);
                }
            }
            long startOffset = assetFileDescriptorOpenRawResourceFd.getStartOffset();
            long jSkip = fileInputStream.skip(dataSpec.f5032c + startOffset) - startOffset;
            if (jSkip != dataSpec.f5032c) {
                throw new RawResourceDataSourceException(null, null, 2008);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                if (channel.size() == 0) {
                    this.f31121a = -1L;
                } else {
                    long size = channel.size() - channel.position();
                    this.f31121a = size;
                    if (size < 0) {
                        throw new RawResourceDataSourceException(null, null, 2008);
                    }
                }
            } else {
                long j = length - jSkip;
                this.f31121a = j;
                if (j < 0) {
                    throw new DataSourceException(2008);
                }
            }
            long jMin = dataSpec.f5033d;
            if (jMin != -1) {
                long j2 = this.f31121a;
                if (j2 != -1) {
                    jMin = Math.min(j2, jMin);
                }
                this.f31121a = jMin;
            }
            this.f5072b = true;
            transferStarted(dataSpec);
            long j3 = dataSpec.f5033d;
            return j3 != -1 ? j3 : this.f31121a;
        } catch (Resources.NotFoundException e3) {
            throw new RawResourceDataSourceException(null, e3, 2005);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0037 */
    /* JADX WARN: Bottom block not found for handler: all -> 0x0055 */
    @Override // com.google.android.exoplayer2.upstream.DataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void close() throws RawResourceDataSourceException {
        this.f5069a = null;
        try {
            InputStream inputStream = this.f5070a;
            if (inputStream != null) {
                inputStream.close();
            }
            this.f5070a = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor = this.f5067a;
                    if (assetFileDescriptor != null) {
                        assetFileDescriptor.close();
                    }
                    this.f5067a = null;
                    if (this.f5072b) {
                        this.f5072b = false;
                        transferEnded();
                    }
                } catch (IOException e) {
                    throw new RawResourceDataSourceException(null, e, 2000);
                }
            } catch (Throwable th) {
                this.f5067a = null;
                if (this.f5072b) {
                    this.f5072b = false;
                    transferEnded();
                }
                throw th;
            }
        } catch (IOException e2) {
            throw new RawResourceDataSourceException(null, e2, 2000);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f5069a;
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws RawResourceDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f31121a;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new RawResourceDataSourceException(null, e, 2000);
            }
        }
        int i3 = ((InputStream) gj9.k(this.f5070a)).read(bArr, i, i2);
        if (i3 == -1) {
            if (this.f31121a == -1) {
                return -1;
            }
            throw new RawResourceDataSourceException("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
        long j2 = this.f31121a;
        if (j2 != -1) {
            this.f31121a = j2 - ((long) i3);
        }
        bytesTransferred(i3);
        return i3;
    }
}
