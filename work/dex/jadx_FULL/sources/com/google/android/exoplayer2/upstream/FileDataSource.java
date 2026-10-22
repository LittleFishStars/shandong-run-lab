package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class FileDataSource extends BaseDataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f31107a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Uri f5041a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public RandomAccessFile f5042a;
    public boolean b;

    public static class FileDataSourceException extends DataSourceException {
        @Deprecated
        public FileDataSourceException(Exception exc) {
            super(exc, 2000);
        }

        @Deprecated
        public FileDataSourceException(String str, IOException iOException) {
            super(str, iOException, 2000);
        }

        public FileDataSourceException(Throwable th, int i) {
            super(th, i);
        }

        public FileDataSourceException(@Nullable String str, @Nullable Throwable th, int i) {
            super(str, th, i);
        }
    }

    @RequiresApi(21)
    public static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        @DoNotInline
        public static boolean b(@Nullable Throwable th) {
            return (th instanceof ErrnoException) && ((ErrnoException) th).errno == OsConstants.EACCES;
        }
    }

    public static final class b implements DataSource.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public TransferListener f31108a;

        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public FileDataSource a() {
            FileDataSource fileDataSource = new FileDataSource();
            TransferListener transferListener = this.f31108a;
            if (transferListener != null) {
                fileDataSource.b(transferListener);
            }
            return fileDataSource;
        }

        public b e(@Nullable TransferListener transferListener) {
            this.f31108a = transferListener;
            return this;
        }
    }

    public FileDataSource() {
        super(false);
    }

    public static RandomAccessFile g(Uri uri) throws FileDataSourceException {
        try {
            return new RandomAccessFile((String) sb0.g(uri.getPath()), "r");
        } catch (FileNotFoundException e) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new FileDataSourceException(e, (gj9.f41922a < 21 || !a.b(e.getCause())) ? 2005 : 2006);
            }
            throw new FileDataSourceException(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e, 1004);
        } catch (SecurityException e2) {
            throw new FileDataSourceException(e2, 2006);
        } catch (RuntimeException e3) {
            throw new FileDataSourceException(e3, 2000);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long a(DataSpec dataSpec) throws FileDataSourceException {
        Uri uri = dataSpec.f5026a;
        this.f5041a = uri;
        transferInitializing(dataSpec);
        RandomAccessFile randomAccessFileG = g(uri);
        this.f5042a = randomAccessFileG;
        try {
            randomAccessFileG.seek(dataSpec.f5032c);
            long length = dataSpec.f5033d;
            if (length == -1) {
                length = this.f5042a.length() - dataSpec.f5032c;
            }
            this.f31107a = length;
            if (length < 0) {
                throw new FileDataSourceException(null, null, 2008);
            }
            this.b = true;
            transferStarted(dataSpec);
            return this.f31107a;
        } catch (IOException e) {
            throw new FileDataSourceException(e, 2000);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0017 */
    @Override // com.google.android.exoplayer2.upstream.DataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void close() throws FileDataSourceException {
        this.f5041a = null;
        try {
            RandomAccessFile randomAccessFile = this.f5042a;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.f5042a = null;
            if (this.b) {
                this.b = false;
                transferEnded();
            }
        } catch (IOException e) {
            throw new FileDataSourceException(e, 2000);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f5041a;
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws FileDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        if (this.f31107a == 0) {
            return -1;
        }
        try {
            int i3 = ((RandomAccessFile) gj9.k(this.f5042a)).read(bArr, i, (int) Math.min(this.f31107a, i2));
            if (i3 > 0) {
                this.f31107a -= (long) i3;
                bytesTransferred(i3);
            }
            return i3;
        } catch (IOException e) {
            throw new FileDataSourceException(e, 2000);
        }
    }
}
