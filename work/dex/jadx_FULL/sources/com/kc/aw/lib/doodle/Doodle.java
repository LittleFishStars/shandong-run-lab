package com.kc.aw.lib.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.kc.aw._az;
import com.kc.aw._b5;
import com.kc.aw._bn;
import com.kc.aw._br;
import com.kc.aw._bx;
import com.kc.aw._fq;
import com.kc.aw._fv;
import com.kc.aw._g5;
import com.kc.aw._l2;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class Doodle {
    private static volatile boolean isLibraryLoaded;
    private static final Object libraryLoadLock = new Object();

    public static void cacheBitmap(String str, Bitmap bitmap, boolean z) {
        _g5._a(new _az(str), bitmap, z);
    }

    public static native int checkImage(Context context, String str, String[] strArr);

    public static native int checkLink(Context context, String[] strArr);

    public static int checkLinkNew(Context context, String[] strArr) {
        try {
            ensureLibraryLoaded();
            if (isLibraryLoaded) {
                return checkLink(context, strArr);
            }
            return -3;
        } catch (Throwable unused) {
            return -4;
        }
    }

    public static void clear(ImageView imageView) {
        if (imageView != null) {
            _br._b(imageView);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void clear(_bx _bxVar) {
        if (_bxVar instanceof View) {
            _br._b((View) _bxVar);
        }
    }

    public static native String clearCrashHistory();

    public static void clearMemory() {
        synchronized (_fv.class) {
            try {
                _fv._a(0L);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static _bn config() {
        return _bn._e;
    }

    public static File downloadOnly(String str) {
        return _b._a(str);
    }

    public static void ensureLibraryLoaded() {
        if (com.kc.aw.lib.utils._a._e() && !isLibraryLoaded) {
            synchronized (libraryLoadLock) {
                if (!isLibraryLoaded) {
                    loadNativeLibrary();
                    isLibraryLoaded = true;
                }
            }
        }
    }

    public static Bitmap getCacheBitmap(String str) {
        return _g5._a(new _az(str));
    }

    public static File getCacheFile(String str) {
        String str_c;
        _az _azVar = new _az(str);
        _a _aVar = _b._a;
        synchronized (_aVar) {
            if (_aVar._a()) {
                _a._b _bVar = (_a._b) _aVar._h.get(_azVar);
                if (_bVar != null) {
                    int i = _aVar._e;
                    _bVar._c = i;
                    _aVar._g.putInt(_bVar._b, i);
                    _aVar._e++;
                }
                str_c = _bVar != null ? _aVar._c(_azVar) : null;
            } else {
                str_c = null;
            }
        }
        if (str_c == null || !new File(str_c).exists()) {
            _aVar._a(_azVar);
            str_c = null;
        }
        if (str_c != null) {
            return new File(str_c);
        }
        return null;
    }

    public static native int getCrashCounts(long j);

    public static float getScale(int i, int i2, int i3, int i4, _b5 _b5Var, boolean z) {
        return Decoder.getScale(i, i2, i3, i4, _b5Var, z);
    }

    public static _l2 load(int i) {
        return new _l2(i);
    }

    public static _l2 load(Uri uri) {
        return new _l2(uri);
    }

    public static _l2 load(File file) {
        return new _l2(file != null ? file.getPath() : "");
    }

    public static _l2 load(String str) {
        return new _l2(str);
    }

    private static void loadNativeLibrary() {
        try {
            System.loadLibrary("ssplayer");
            isLibraryLoaded = true;
        } catch (Throwable unused) {
        }
    }

    public static void notifyDestroy(Object obj) {
        _fq._a(obj, 3);
    }

    public static void notifyPause(Object obj) {
        _fq._a(obj, 1);
    }

    public static void notifyResume(Object obj) {
        _fq._a(obj, 2);
    }

    public static void pauseRequests() {
        _br._a = true;
    }

    public static void resumeRequests() {
        if (_br._a) {
            _br._a = false;
            synchronized (_br.class) {
                try {
                    Iterator<_l2> it = _br._b.values().iterator();
                    while (it.hasNext()) {
                        _br._a(it.next());
                    }
                    _br._b.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static native String setCrashFilePath(String str);

    public static String setCrashFilePathNew(String str) {
        try {
            ensureLibraryLoaded();
            return !isLibraryLoaded ? "" : setCrashFilePath(str);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void trimMemory(int i) {
        synchronized (_fv.class) {
            try {
                if (i >= 60) {
                    _fv._a(0L);
                } else if (i >= 40 || i == 15) {
                    _fv._a(Math.max(_fv._b >> 1, _fv._a));
                } else {
                    LinkedHashMap linkedHashMap = _fv._c;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
