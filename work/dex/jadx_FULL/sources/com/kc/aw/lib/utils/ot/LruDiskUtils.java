package com.kc.aw.lib.utils.ot;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Process;
import com.ali.auth.third.login.LoginConstants;
import com.kc.aw._jf;
import com.kc.aw.lib.utils._d;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.c49;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class LruDiskUtils {
    public static final String CACHE_CONFIG_KEY = "aw_sdk_config_for_policy";
    private static final int MAX_COUNT = Integer.MAX_VALUE;
    private static final int MAX_SIZE = 50000000;
    public static final int TIME_DAY = 86400;
    public static final int TIME_HOUR = 3600;
    private static final String TMP_FILE = ".tmp";
    private static final Map<String, LruDiskUtils> mInstanceMap = new HashMap();
    private _a mCache;
    private final Map<String, _b> transactionMap = new ConcurrentHashMap();

    @Keep
    public final class _a {
        public final AtomicLong _a;
        public final AtomicInteger _b;
        public final long _c;
        public final int _d;
        public final Map<File, Long> _e;
        public File _f;
        public AtomicBoolean _g;

        /* JADX INFO: renamed from: com.kc.aw.lib.utils.ot.LruDiskUtils$_a$_a, reason: collision with other inner class name */
        @Keep
        public final class RunnableC0958_a implements Runnable {
            public final _a _a;

            public RunnableC0958_a(_a _aVar) {
                this._a = _aVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                File[] fileArrListFiles = this._a._f.listFiles();
                if (fileArrListFiles != null) {
                    int length = 0;
                    int i = 0;
                    for (File file : fileArrListFiles) {
                        if (file.getName().endsWith(".tmp")) {
                            file.delete();
                        } else {
                            this._a.getClass();
                            length = (int) (file.length() + ((long) length));
                            i++;
                            this._a._e.put(file, Long.valueOf(file.lastModified()));
                        }
                    }
                    this._a._a.set(length);
                    this._a._b.set(i);
                }
                try {
                    this._a._g.set(true);
                } catch (Exception unused) {
                }
            }
        }

        public _a(File file, long j, int i) {
            this._e = Collections.synchronizedMap(new HashMap());
            this._g = new AtomicBoolean();
            this._f = file;
            this._c = j;
            this._d = i;
            this._a = new AtomicLong();
            this._b = new AtomicInteger();
            _a();
        }

        public /* synthetic */ _a(File file, long j, int i, int i2) {
            this(file, j, i);
        }

        public static void _a(_a _aVar, File file) {
            int iAddAndGet = _aVar._b.get();
            while (iAddAndGet + 1 > _aVar._d) {
                _aVar._a.addAndGet(-_aVar._b());
                iAddAndGet = _aVar._b.addAndGet(-1);
            }
            _aVar._b.addAndGet(1);
            long length = file.length();
            long jAddAndGet = _aVar._a.get();
            while (jAddAndGet + length > _aVar._c) {
                jAddAndGet = _aVar._a.addAndGet(-_aVar._b());
            }
            _aVar._a.addAndGet(length);
            Long lValueOf = Long.valueOf(System.currentTimeMillis());
            file.setLastModified(lValueOf.longValue());
            _aVar._e.put(file, lValueOf);
        }

        public final void _a() {
            _d._b(new RunnableC0958_a(this));
        }

        public final long _b() {
            File key;
            if (this._e.isEmpty()) {
                return 0L;
            }
            Set<Map.Entry<File, Long>> setEntrySet = this._e.entrySet();
            synchronized (this._e) {
                key = null;
                Long value = null;
                for (Map.Entry<File, Long> entry : setEntrySet) {
                    if (key == null) {
                        key = entry.getKey();
                        value = entry.getValue();
                    } else {
                        Long value2 = entry.getValue();
                        if (value2.longValue() < value.longValue()) {
                            key = entry.getKey();
                            value = value2;
                        }
                    }
                }
            }
            long length = key.length();
            if (key.delete()) {
                this._e.remove(key);
            }
            return length;
        }
    }

    @Keep
    public final class _b {
        public File _a;
        public File _b;
        public boolean _c;
        public boolean _d = false;
        public final LruDiskUtils _e;

        public _b(LruDiskUtils lruDiskUtils, String str) {
            this._e = lruDiskUtils;
            this._c = false;
            File file = new File(lruDiskUtils.mCache._f, str + ".tmp");
            this._a = file;
            if (file.exists()) {
                this._c = true;
            }
            this._b = new File(lruDiskUtils.mCache._f, str);
        }

        public final File _a() {
            synchronized (this._e.transactionMap) {
                if (this._d || this._c || this._b.exists() || !this._a.renameTo(this._b) || !this._b.exists()) {
                    this._e.transactionMap.remove(this._b.getAbsolutePath());
                    return null;
                }
                this._d = true;
                _a._a(this._e.mCache, this._b);
                return this._b;
            }
        }
    }

    @Keep
    public static final class _c {
        /* JADX WARN: Code duplicated, block: B:18:0x0027  */
        public static boolean _a(byte[] bArr) {
            boolean z;
            String[] strArr;
            int i = -1;
            if (bArr == null || bArr.length <= 15 || bArr[13] != 45) {
                z = false;
            } else {
                int i2 = 0;
                while (true) {
                    if (i2 >= bArr.length) {
                        i2 = -1;
                        break;
                    }
                    if (bArr[i2] == 32) {
                        break;
                    }
                    i2++;
                }
                if (i2 > 14) {
                    z = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                String str = new String(_a(bArr, 0, 13));
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    if (bArr[i3] == 32) {
                        i = i3;
                        break;
                    }
                }
                strArr = new String[]{str, new String(_a(bArr, 14, i))};
            } else {
                strArr = null;
            }
            if (strArr != null && strArr.length == 2) {
                String strSubstring = strArr[0];
                while (strSubstring.startsWith("0")) {
                    strSubstring = strSubstring.substring(1, strSubstring.length());
                }
                if (System.currentTimeMillis() > (Long.valueOf(strArr[1]).longValue() * 1000) + Long.valueOf(strSubstring).longValue()) {
                    return true;
                }
            }
            return false;
        }

        public static byte[] _a(byte[] bArr, int i, int i2) {
            int i3 = i2 - i;
            if (i3 >= 0) {
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, i, bArr2, 0, Math.min(bArr.length - i, i3));
                return bArr2;
            }
            throw new IllegalArgumentException(i + " > " + i2);
        }
    }

    private LruDiskUtils(File file, long j, int i) {
        if (file.exists() || file.mkdirs()) {
            this.mCache = new _a(file, j, i, 0);
        } else {
            StringBuilder sb_a = _jf._a("can't make dirs in ");
            sb_a.append(file.getAbsolutePath());
            throw new RuntimeException(sb_a.toString());
        }
    }

    public static LruDiskUtils get(Context context) {
        return get(context, "aw_ad_cache");
    }

    public static LruDiskUtils get(Context context, long j, int i) {
        return get(new File(context.getCacheDir(), "aw_ad_cache"), j, i);
    }

    public static LruDiskUtils get(Context context, String str) {
        return get(new File(context.getCacheDir(), str), 50000000L, Integer.MAX_VALUE);
    }

    public static LruDiskUtils get(File file) {
        return get(file, 50000000L, Integer.MAX_VALUE);
    }

    public static LruDiskUtils get(File file, long j, int i) {
        Map<String, LruDiskUtils> map = mInstanceMap;
        LruDiskUtils lruDiskUtils = map.get(file.getAbsoluteFile() + myPid());
        if (lruDiskUtils != null && file.exists()) {
            return lruDiskUtils;
        }
        LruDiskUtils lruDiskUtils2 = new LruDiskUtils(file, j, i);
        map.put(file.getAbsolutePath() + myPid(), lruDiskUtils2);
        return lruDiskUtils2;
    }

    private static String myPid() {
        StringBuilder sb_a = _jf._a(LoginConstants.UNDER_LINE);
        sb_a.append(Process.myPid());
        return sb_a.toString();
    }

    public Set<String> allKey() {
        _a _aVar = this.mCache;
        while (!_aVar._g.get()) {
            try {
                Thread.sleep(100L);
            } catch (Exception unused) {
            }
        }
        HashSet hashSet = new HashSet();
        synchronized (_aVar._e) {
            hashSet.addAll(_aVar._e.keySet());
        }
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            hashSet2.add(((File) it.next()).getName());
        }
        return hashSet2;
    }

    public void clear() {
        _a _aVar = this.mCache;
        _aVar._e.clear();
        _aVar._a.set(0L);
        File[] fileArrListFiles = _aVar._f.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                file.delete();
            }
        }
    }

    public File commit(File file) {
        synchronized (this.transactionMap) {
            String absolutePath = file.getAbsolutePath();
            String string = absolutePath.endsWith(".tmp") ? absolutePath.subSequence(0, absolutePath.indexOf(".tmp")).toString() : null;
            if (this.transactionMap.containsKey(string)) {
                return this.transactionMap.get(string)._a();
            }
            return null;
        }
    }

    public void fail(File file) {
        synchronized (this.transactionMap) {
            String absolutePath = file.getAbsolutePath();
            String string = absolutePath.endsWith(".tmp") ? absolutePath.subSequence(0, absolutePath.indexOf(".tmp")).toString() : null;
            if (this.transactionMap.containsKey(string)) {
                _b _bVar = this.transactionMap.get(string);
                synchronized (_bVar._e.transactionMap) {
                    if (!_bVar._c) {
                        _bVar._a.deleteOnExit();
                        if (!_bVar._d) {
                            _bVar._b.deleteOnExit();
                        }
                    }
                    _bVar._e.transactionMap.remove(_bVar._b.getAbsolutePath());
                }
            }
        }
    }

    public File file(String str) {
        _a _aVar = this.mCache;
        _aVar.getClass();
        File file = new File(_aVar._f, str);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0062  */
    /* JADX WARN: Code duplicated, block: B:64:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public byte[] getAsBinary(String str) throws Throwable {
        RandomAccessFile randomAccessFile;
        boolean z;
        RandomAccessFile randomAccessFile2 = null;
        try {
            _a _aVar = this.mCache;
            _aVar.getClass();
            File file = new File(_aVar._f, str);
            Long lValueOf = Long.valueOf(System.currentTimeMillis());
            file.setLastModified(lValueOf.longValue());
            _aVar._e.put(file, lValueOf);
            if (!file.exists()) {
                return null;
            }
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                try {
                    int length = (int) randomAccessFile.length();
                    byte[] bArr_a = new byte[length];
                    randomAccessFile.read(bArr_a);
                    if (_c._a(bArr_a)) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        remove(str);
                        return null;
                    }
                    int i = -1;
                    if (length <= 15 || bArr_a[13] != 45) {
                        z = false;
                    } else {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                i2 = -1;
                                break;
                            }
                            if (bArr_a[i2] == 32) {
                                break;
                            }
                            i2++;
                        }
                        if (i2 > 14) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    if (z) {
                        for (int i3 = 0; i3 < length; i3++) {
                            if (bArr_a[i3] == 32) {
                                i = i3;
                                break;
                            }
                        }
                        bArr_a = _c._a(bArr_a, i + 1, length);
                    }
                    try {
                        randomAccessFile.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return bArr_a;
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                randomAccessFile2 = randomAccessFile;
            }
            th = th;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        } catch (Exception e6) {
            e = e6;
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
        }
        e.printStackTrace();
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
        return null;
    }

    public Bitmap getAsBitmap(String str) throws Throwable {
        byte[] asBinary = getAsBinary(str);
        if (asBinary == null || asBinary.length == 0) {
            return null;
        }
        return BitmapFactory.decodeByteArray(asBinary, 0, asBinary.length);
    }

    public JSONArray getAsJSONArray(String str) {
        try {
            return new JSONArray(getAsString(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject getAsJSONObject(String str) {
        try {
            return new JSONObject(getAsString(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:57:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:? A[SYNTHETIC] */
    public Object getAsObject(String str) throws Throwable {
        ObjectInputStream objectInputStream;
        Exception e;
        ObjectInputStream objectInputStream2;
        ByteArrayInputStream byteArrayInputStream;
        byte[] asBinary = getAsBinary(str);
        ByteArrayInputStream byteArrayInputStream2 = null;
        ObjectInputStream objectInputStream3 = null;
        if (asBinary == null) {
            return null;
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(asBinary);
            try {
                objectInputStream2 = new ObjectInputStream(byteArrayInputStream);
                try {
                    try {
                        Object object = objectInputStream2.readObject();
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        try {
                            objectInputStream2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        return object;
                    } catch (Exception e4) {
                        e = e4;
                        e.printStackTrace();
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (objectInputStream2 != null) {
                            try {
                                objectInputStream2.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    ByteArrayInputStream byteArrayInputStream3 = byteArrayInputStream;
                    objectInputStream = objectInputStream2;
                    th = th;
                    byteArrayInputStream2 = byteArrayInputStream3;
                    ObjectInputStream objectInputStream4 = objectInputStream;
                    byteArrayInputStream = byteArrayInputStream2;
                    objectInputStream3 = objectInputStream4;
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (objectInputStream3 == null) {
                        throw th;
                    }
                    try {
                        objectInputStream3.close();
                        throw th;
                    } catch (IOException e8) {
                        e8.printStackTrace();
                        throw th;
                    }
                }
            } catch (Exception e9) {
                e = e9;
                objectInputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                if (objectInputStream3 == null) {
                    throw th;
                }
                objectInputStream3.close();
                throw th;
            }
        } catch (Exception e10) {
            e = e10;
            objectInputStream2 = null;
            byteArrayInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            objectInputStream = null;
            ObjectInputStream objectInputStream5 = objectInputStream;
            byteArrayInputStream = byteArrayInputStream2;
            objectInputStream3 = objectInputStream5;
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            if (objectInputStream3 == null) {
                throw th;
            }
            objectInputStream3.close();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.BufferedReader] */
    public String getAsString(String str) throws Throwable {
        BufferedReader bufferedReader;
        _a _aVar = this.mCache;
        _aVar.getClass();
        File file = new File(_aVar._f, str);
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        file.setLastModified(lValueOf.longValue());
        _aVar._e.put(file, lValueOf);
        ?? Exists = file.exists();
        ?? r2 = 0;
        try {
            if (Exists == 0) {
                return null;
            }
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                String strSubstring = "";
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        strSubstring = strSubstring + line;
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        return null;
                    }
                }
                if (_c._a(strSubstring.getBytes())) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    remove(str);
                    return null;
                }
                byte[] bytes = strSubstring.getBytes();
                boolean z = false;
                if (bytes != null && bytes.length > 15 && bytes[13] == 45) {
                    int i = 0;
                    while (true) {
                        if (i >= bytes.length) {
                            i = -1;
                            break;
                        }
                        if (bytes[i] == 32) {
                            break;
                        }
                        i++;
                    }
                    if (i > 14) {
                        z = true;
                    }
                }
                if (z) {
                    strSubstring = strSubstring.substring(strSubstring.indexOf(32) + 1, strSubstring.length());
                }
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return strSubstring;
            } catch (IOException e5) {
                e = e5;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                if (r2 != 0) {
                    try {
                        r2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            r2 = Exists;
        }
    }

    public void put(String str, Bitmap bitmap) throws Throwable {
        byte[] byteArray;
        if (bitmap == null) {
            byteArray = null;
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        put(str, byteArray);
    }

    public void put(String str, Bitmap bitmap, int i) throws Throwable {
        byte[] byteArray;
        if (bitmap == null) {
            byteArray = null;
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        put(str, byteArray, i);
    }

    public void put(String str, Drawable drawable) throws Throwable {
        Bitmap bitmap;
        if (drawable == null) {
            bitmap = null;
        } else {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            bitmap = bitmapCreateBitmap;
        }
        put(str, bitmap);
    }

    public void put(String str, Drawable drawable, int i) throws Throwable {
        Bitmap bitmap;
        if (drawable == null) {
            bitmap = null;
        } else {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            bitmap = bitmapCreateBitmap;
        }
        put(str, bitmap, i);
    }

    public void put(String str, Serializable serializable) throws Throwable {
        put(str, serializable, -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.ObjectOutputStream] */
    public void put(String str, Serializable serializable, int i) throws Throwable {
        ?? objectOutputStream;
        ?? r0 = 0;
        ?? r1 = 0;
        try {
            try {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    try {
                        objectOutputStream.writeObject(serializable);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        r0 = -1;
                        if (i != -1) {
                            put(str, byteArray, i);
                        } else {
                            put(str, byteArray);
                        }
                        objectOutputStream.close();
                    } catch (Exception e) {
                        e = e;
                        r1 = objectOutputStream;
                        e.printStackTrace();
                        r1.close();
                        r0 = r1;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            objectOutputStream.close();
                        } catch (IOException unused) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    objectOutputStream = r0;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (IOException unused2) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void put(String str, String str2) throws Throwable {
        Throwable th;
        BufferedWriter bufferedWriter;
        _a _aVar = this.mCache;
        _aVar.getClass();
        File file = new File(_aVar._f, str);
        _a _aVar2 = null;
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                try {
                    bufferedWriter = new BufferedWriter(new FileWriter(file), 1024);
                    try {
                        bufferedWriter.write(str2);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                    } catch (IOException e) {
                        e = e;
                        bufferedWriter2 = bufferedWriter;
                        e.printStackTrace();
                        if (bufferedWriter2 != null) {
                            bufferedWriter2.flush();
                            bufferedWriter2.close();
                        }
                        _aVar2 = this.mCache;
                        _a._a(_aVar2, file);
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedWriter != 0) {
                            try {
                                bufferedWriter.flush();
                                bufferedWriter.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        _a._a(this.mCache, file);
                        throw th;
                    }
                } catch (Throwable th3) {
                    _a _aVar3 = _aVar2;
                    th = th3;
                    bufferedWriter = _aVar3;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        _aVar2 = this.mCache;
        _a._a(_aVar2, file);
    }

    public void put(String str, String str2, int i) throws Throwable {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(System.currentTimeMillis());
        sb2.append("");
        while (true) {
            String string = sb2.toString();
            if (string.length() >= 13) {
                sb.append(string + c49.f40900a + i + ' ');
                sb.append(str2);
                put(str, sb.toString());
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("0");
            sb3.append(string);
            sb2 = sb3;
        }
    }

    public void put(String str, JSONArray jSONArray) throws Throwable {
        put(str, jSONArray.toString());
    }

    public void put(String str, JSONArray jSONArray, int i) throws Throwable {
        put(str, jSONArray.toString(), i);
    }

    public void put(String str, JSONObject jSONObject) throws Throwable {
        put(str, jSONObject.toString());
    }

    public void put(String str, JSONObject jSONObject, int i) throws Throwable {
        put(str, jSONObject.toString(), i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void put(String str, byte[] bArr) throws Throwable {
        Throwable th;
        FileOutputStream fileOutputStream;
        _a _aVar = this.mCache;
        _aVar.getClass();
        File file = new File(_aVar._f, str);
        _a _aVar2 = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream2 = fileOutputStream;
                        e.printStackTrace();
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                        }
                        _aVar2 = this.mCache;
                        _a._a(_aVar2, file);
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != 0) {
                            try {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        _a._a(this.mCache, file);
                        throw th;
                    }
                } catch (Throwable th3) {
                    _a _aVar3 = _aVar2;
                    th = th3;
                    fileOutputStream = _aVar3;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        _aVar2 = this.mCache;
        _a._a(_aVar2, file);
    }

    public void put(String str, byte[] bArr, int i) throws Throwable {
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        sb.append("");
        while (true) {
            String string = sb.toString();
            if (string.length() >= 13) {
                byte[] bytes = (string + c49.f40900a + i + ' ').getBytes();
                byte[] bArr2 = new byte[bytes.length + bArr.length];
                System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
                System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
                put(str, bArr2);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("0");
            sb2.append(string);
            sb = sb2;
        }
    }

    public boolean remove(String str) {
        _a _aVar = this.mCache;
        _aVar.getClass();
        File file = new File(_aVar._f, str);
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        file.setLastModified(lValueOf.longValue());
        _aVar._e.put(file, lValueOf);
        return file.delete();
    }

    public _b transaction(String str) {
        _b _bVar;
        synchronized (this.transactionMap) {
            _bVar = new _b(this, str);
            String absolutePath = _bVar._b.getAbsolutePath();
            if (this.transactionMap.get(absolutePath) == null) {
                this.transactionMap.put(absolutePath, _bVar);
            }
        }
        return _bVar;
    }
}
