package com.kc.aw;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.ipd.dsp.internal.n.a;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _c1 implements Closeable {
    public final String _a;
    public final _a _b;
    public final boolean _c;
    public int _d;
    public byte[] _e;
    public byte[] _f;

    @Keep
    public interface _a extends Closeable {
        int _a();

        Bitmap _a(BitmapFactory.Options options);

        Bitmap _a(Rect rect, BitmapFactory.Options options);

        void _a(MediaMetadataRetriever mediaMetadataRetriever);

        void _a(byte[] bArr);

        byte[] _b();
    }

    @Keep
    public static final class _b implements _a {
        public final RandomAccessFile _a;
        public final FileDescriptor _b;

        public _b(File file) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            this._a = randomAccessFile;
            this._b = randomAccessFile.getFD();
            file.getPath();
        }

        @Override // com.kc.aw._c1._a
        public final int _a() throws IOException {
            int i_a = _dk._a(new FileInputStream(this._b));
            this._a.seek(0L);
            return i_a;
        }

        @Override // com.kc.aw._c1._a
        public final Bitmap _a(BitmapFactory.Options options) throws IOException {
            if (!options.inJustDecodeBounds) {
                return BitmapFactory.decodeFileDescriptor(this._b, null, options);
            }
            BitmapFactory.decodeFileDescriptor(this._b, null, options);
            this._a.seek(0L);
            return null;
        }

        @Override // com.kc.aw._c1._a
        public final Bitmap _a(Rect rect, BitmapFactory.Options options) {
            return BitmapRegionDecoder.newInstance(this._b, false).decodeRegion(rect, options);
        }

        @Override // com.kc.aw._c1._a
        public final void _a(MediaMetadataRetriever mediaMetadataRetriever) {
            mediaMetadataRetriever.setDataSource(this._b);
        }

        @Override // com.kc.aw._c1._a
        public final void _a(byte[] bArr) throws IOException {
            this._a.readFully(bArr);
            this._a.seek(0L);
        }

        @Override // com.kc.aw._c1._a
        public final byte[] _b() throws Throwable {
            byte[] bArr_a = _o2._a((InputStream) new FileInputStream(this._b));
            this._a.seek(0L);
            return bArr_a;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            this._a.close();
        }
    }

    @Keep
    public static final class _c implements _a {
        public final InputStream _a;
        public final String _b;
        public final Uri _c;
        public AssetFileDescriptor _d = null;
        public File _e = null;
        public RandomAccessFile _f = null;

        public _c(String str, InputStream inputStream, Uri uri) {
            this._b = str;
            this._a = inputStream.markSupported() ? inputStream : new _kv(inputStream);
            this._c = uri;
        }

        @Override // com.kc.aw._c1._a
        public final int _a() throws IOException {
            this._a.mark(Integer.MAX_VALUE);
            int i_a = _dk._a(this._a);
            InputStream inputStream = this._a;
            if (inputStream instanceof _kv) {
                _kv _kvVar = (_kv) inputStream;
                _kvVar._d = 0;
                _kvVar._e = -1;
                _kvVar._f = 0;
            } else {
                inputStream.reset();
            }
            return i_a;
        }

        @Override // com.kc.aw._c1._a
        public final Bitmap _a(BitmapFactory.Options options) throws IOException {
            if (!options.inJustDecodeBounds) {
                return BitmapFactory.decodeStream(this._a, null, options);
            }
            this._a.mark(Integer.MAX_VALUE);
            BitmapFactory.decodeStream(this._a, null, options);
            InputStream inputStream = this._a;
            if (inputStream instanceof _kv) {
                _kv _kvVar = (_kv) inputStream;
                _kvVar._d = 0;
                _kvVar._e = -1;
                _kvVar._f = 0;
            } else {
                inputStream.reset();
            }
            return null;
        }

        @Override // com.kc.aw._c1._a
        public final Bitmap _a(Rect rect, BitmapFactory.Options options) {
            return BitmapRegionDecoder.newInstance(this._a, false).decodeRegion(rect, options);
        }

        @Override // com.kc.aw._c1._a
        public final void _a(MediaMetadataRetriever mediaMetadataRetriever) throws Throwable {
            FileDescriptor fileDescriptor;
            Uri uri = this._c;
            if (uri != null) {
                mediaMetadataRetriever.setDataSource(_o2._a, uri);
                return;
            }
            if (this._b.startsWith("http")) {
                InputStream inputStream = this._a;
                if (!(inputStream instanceof _kv)) {
                    StringBuilder sb_a = _jf._a("Wrong stream type: ");
                    sb_a.append(this._a.getClass());
                    throw new IllegalStateException(sb_a.toString());
                }
                _kv _kvVar = (_kv) inputStream;
                _kvVar._d = 0;
                _kvVar._e = -1;
                _kvVar._f = 0;
                String str = this._b;
                com.kc.aw.lib.doodle._a _aVar = com.kc.aw.lib.doodle._b._a;
                File file_a = com.kc.aw.lib.doodle._b._a(inputStream, new _az(str), false);
                this._e = file_a;
                if (!file_a.exists()) {
                    throw new IOException("Download failed");
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(this._e, "r");
                this._f = randomAccessFile;
                fileDescriptor = randomAccessFile.getFD();
            } else {
                if (!this._b.startsWith(a.d)) {
                    throw new IllegalStateException("Not support");
                }
                AssetFileDescriptor assetFileDescriptorOpenFd = _o2._a.getAssets().openFd(this._b.substring(22));
                this._d = assetFileDescriptorOpenFd;
                fileDescriptor = assetFileDescriptorOpenFd.getFileDescriptor();
            }
            mediaMetadataRetriever.setDataSource(fileDescriptor);
        }

        @Override // com.kc.aw._c1._a
        public final void _a(byte[] bArr) throws IOException {
            this._a.mark(Integer.MAX_VALUE);
            InputStream inputStream = this._a;
            int length = bArr.length;
            int i = 0;
            do {
                int i2 = inputStream.read(bArr, i, length - i);
                if (i2 <= 0) {
                    break;
                } else {
                    i += i2;
                }
            } while (i < length);
            InputStream inputStream2 = this._a;
            if (!(inputStream2 instanceof _kv)) {
                inputStream2.reset();
                return;
            }
            _kv _kvVar = (_kv) inputStream2;
            _kvVar._d = 0;
            _kvVar._e = -1;
            _kvVar._f = 0;
        }

        @Override // com.kc.aw._c1._a
        public final byte[] _b() throws Throwable {
            this._a.mark(Integer.MAX_VALUE);
            byte[] bArr_a = _o2._a(this._a);
            InputStream inputStream = this._a;
            if (inputStream instanceof _kv) {
                _kv _kvVar = (_kv) inputStream;
                _kvVar._d = 0;
                _kvVar._e = -1;
                _kvVar._f = 0;
            } else {
                inputStream.reset();
            }
            return bArr_a;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            _o2._a(this._d);
            _o2._a(this._f);
            _o2._a(this._e);
            this._a.close();
        }
    }

    public _c1(String str, _a _aVar, boolean z) {
        this._a = str;
        this._b = _aVar;
        this._c = z;
    }

    public final Bitmap _b(BitmapFactory.Options options) {
        byte[] bArr = this._f;
        return bArr != null ? BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options) : this._b._a(options);
    }

    /* JADX WARN: Code duplicated, block: B:69:0x00d5  */
    public final int _c() {
        int i;
        if (this._d == 0) {
            if (this._e == null) {
                byte[] bArr = new byte[26];
                this._e = bArr;
                byte[] bArr2 = this._f;
                if (bArr2 != null) {
                    System.arraycopy(bArr2, 0, bArr, 0, 26);
                } else {
                    this._b._a(bArr);
                }
            }
            byte[] bArr3 = this._e;
            int i_a = _g3._a(0, bArr3);
            int i2 = i_a >>> 8;
            if (i2 == 16767231) {
                i = 7;
            } else if (i_a == -1991225785) {
                i = (bArr3[25] & 255) >= 3 ? 8 : 9;
            } else if (i2 == 4671814) {
                i = 6;
            } else {
                int i_a2 = _g3._a(2, bArr3);
                if (i_a == 1380533830 && i_a2 == 1464156752) {
                    int i_a3 = _g3._a(3, bArr3);
                    byte b = bArr3[20];
                    if (i_a3 != 1448097880) {
                        i = (i_a3 == 1448097868 && (b & 8) == 0) ? 13 : 12;
                    } else if ((b & 2) != 0) {
                        i = 14;
                    } else {
                        i = (b & com.google.common.base.a.r) != 0 ? 10 : 11;
                    }
                } else if ((i_a >>> 16) == 16973) {
                    i = 15;
                } else if (i_a == 440786851) {
                    i = 5;
                } else if (_g3._a(1, bArr3) == 1718909296) {
                    int i3 = i_a2 >>> 8;
                    int i4 = i_a2 >>> 16;
                    if (i3 == 6910831 || i3 == 7172148 || i4 == 20036) {
                        i = 2;
                    } else if (i4 == 29044) {
                        i = 3;
                    } else if (i4 == 13159) {
                        i = 4;
                    } else if (((-16711681) & i_a2) == 1828742705 || i4 == 26725) {
                        i = 16;
                    } else {
                        i = 1;
                    }
                } else {
                    i = 1;
                }
            }
            this._d = i;
        }
        return this._d;
    }

    public final boolean _d() {
        if (this._e == null) {
            byte[] bArr = new byte[26];
            this._e = bArr;
            byte[] bArr2 = this._f;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, 26);
            } else {
                this._b._a(bArr);
            }
        }
        byte[] bArr3 = this._e;
        int i = (bArr3[1] & 255) | ((bArr3[0] & 255) << 8);
        return (i & 65496) == 65496 || i == 19789 || i == 18761;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this._b.close();
    }
}
