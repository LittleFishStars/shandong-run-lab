package com.kc.aw;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.view.WindowManager;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _o2 {
    public static Context _a;
    public static ContentResolver _b;
    public static volatile String _c;
    public static volatile Point _d;

    public static int _a(Bitmap bitmap) {
        if (bitmap != null) {
            return bitmap.getAllocationByteCount();
        }
        return 0;
    }

    public static String _a(int i) {
        if (i == 0) {
            return "";
        }
        try {
            Resources resources = _a.getResources();
            return "android.resource://" + resources.getResourcePackageName(i) + WVNativeCallbackUtil.SEPERATER + resources.getResourceTypeName(i) + WVNativeCallbackUtil.SEPERATER + resources.getResourceEntryName(i);
        } catch (Exception e) {
            _fu._a("Doodle", e);
            return "";
        }
    }

    public static void _a() {
        try {
            WindowManager windowManager = (WindowManager) _a.getSystemService("window");
            if (windowManager != null) {
                Point point = new Point();
                windowManager.getDefaultDisplay().getSize(point);
                if (point.x > 0 && point.y > 0) {
                    _d = point;
                }
            }
        } catch (Exception unused) {
        }
        if (_d == null) {
            _d = new Point(1080, 1920);
        }
    }

    public static void _a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static boolean _a(File file) {
        if (file == null) {
            return false;
        }
        try {
            return file.delete();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean _a(InputStream inputStream, File file) {
        File parentFile;
        if (inputStream == null) {
            return false;
        }
        if (!(file.isFile() || ((parentFile = file.getParentFile()) != null && ((parentFile.isDirectory() || parentFile.mkdirs()) && file.createNewFile())))) {
            _a((Closeable) inputStream);
            return false;
        }
        byte[] bArr_a = _ax._a();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        while (true) {
            try {
                int i = inputStream.read(bArr_a, 0, bArr_a.length);
                if (i <= 0) {
                    break;
                }
                fileOutputStream.write(bArr_a, 0, i);
            } catch (Throwable th) {
                _a(fileOutputStream);
                _a((Closeable) inputStream);
                if (bArr_a != null) {
                    byte[][] bArr = _ax._b;
                    synchronized (bArr) {
                        int i2 = _ax._a;
                        if (i2 < 10) {
                            _ax._a = i2 + 1;
                            bArr[i2] = bArr_a;
                        }
                    }
                }
                throw th;
            }
        }
        fileOutputStream.getFD().sync();
        _a(fileOutputStream);
        _a((Closeable) inputStream);
        byte[][] bArr2 = _ax._b;
        synchronized (bArr2) {
            int i3 = _ax._a;
            if (i3 < 10) {
                _ax._a = i3 + 1;
                bArr2[i3] = bArr_a;
            }
        }
        return true;
    }

    public static byte[] _a(InputStream inputStream) throws Throwable {
        int iAvailable = inputStream.available();
        if (iAvailable > 134217728) {
            throw new IOException("File too large:" + iAvailable);
        }
        byte[] bArr_a = _ax._a(iAvailable);
        int length = bArr_a.length;
        int i = 0;
        while (true) {
            try {
                int i2 = inputStream.read(bArr_a, i, length - i);
                if (i2 <= 0) {
                    byte[] bArrCopyOf = Arrays.copyOf(bArr_a, i);
                    _ax._a(bArr_a);
                    return bArrCopyOf;
                }
                i += i2;
                if (i == length) {
                    int i3 = length << 1;
                    if (i3 > 134217728) {
                        throw new IOException("Required buffer too large:" + i3);
                    }
                    byte[] bArr_a2 = _ax._a(i3);
                    try {
                        System.arraycopy(bArr_a, 0, bArr_a2, 0, length);
                        length = bArr_a2.length;
                        _ax._a(bArr_a);
                        bArr_a = bArr_a2;
                    } catch (Throwable th) {
                        th = th;
                        bArr_a = bArr_a2;
                        _ax._a(bArr_a);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static String _b() {
        if (_c == null) {
            synchronized (_o2.class) {
                try {
                    if (_c == null) {
                        String path = _bn._a;
                        if (path == null || path.isEmpty()) {
                            File cacheDir = _a.getCacheDir();
                            if (cacheDir != null) {
                                path = cacheDir.getPath();
                            } else {
                                path = "/data/data/" + _a.getPackageName() + "/cache";
                            }
                        } else {
                            int length = path.length() - 1;
                            if (path.charAt(length) == '/') {
                                path = path.substring(0, length);
                            }
                        }
                        _c = path;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return _c;
    }
}
