package com.kc.aw.lib.doodle;

import com.alibaba.ariver.resource.parser.a.e;
import com.ipd.dsp.internal.d.a;
import com.kc.aw._az;
import com.kc.aw._fu;
import com.kc.aw._o2;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _a {
    public static final byte[] _j = {100, 105, 115, 107};
    public final String _a;
    public final int _b;
    public final long _c;
    public long _d = 0;
    public int _e = 1;
    public FileChannel _f;
    public MappedByteBuffer _g;
    public HashMap _h;
    public int _i;

    /* JADX INFO: renamed from: com.kc.aw.lib.doodle._a$_a, reason: collision with other inner class name */
    @Keep
    public static final class C0955_a {
        public final String _a;
        public final boolean _b;

        public C0955_a(String str, boolean z) {
            this._a = str;
            this._b = z;
        }
    }

    @Keep
    public static final class _b implements Comparable<_b> {
        public final _az _a;
        public int _b;
        public int _c;
        public int _d;

        public _b(_az _azVar, int i, int i2, int i3) {
            this._a = _azVar;
            this._b = i;
            this._c = i2;
            this._d = i3;
        }

        @Override // java.lang.Comparable
        public final int compareTo(_b _bVar) {
            return Integer.compare(this._c, _bVar._c);
        }
    }

    public _a(int i, long j, String str) {
        this._a = _o2._b() + str;
        this._b = i;
        this._c = j;
    }

    public final void _a(int i) {
        this._g.position(i);
        int iCapacity = this._g.capacity() - i;
        for (int i2 = 0; i2 < (iCapacity >>> 3); i2++) {
            this._g.putLong(0L);
        }
        for (int i3 = 0; i3 < (iCapacity & 7); i3++) {
            this._g.put((byte) 0);
        }
    }

    public final void _a(_az _azVar) {
        synchronized (this) {
            if (_a()) {
                _b _bVar = (_b) this._h.get(_azVar);
                if (_bVar != null) {
                    this._h.remove(_azVar);
                    try {
                        File file = new File(_c(_azVar));
                        if (!file.exists() || _o2._a(file)) {
                            this._g.putInt(_bVar._b, 0);
                        }
                    } catch (Throwable th) {
                        _fu._a("DiskCache", th);
                    }
                }
            }
        }
    }

    public final void _a(_az _azVar, int i, boolean z) {
        int i2 = z ? Integer.MIN_VALUE | i : i;
        int i3 = this._i;
        int iCapacity = this._g.capacity();
        int i4 = i3 + 24;
        if (i4 > iCapacity) {
            this._g = this._f.map(FileChannel.MapMode.READ_WRITE, 0L, (iCapacity < 16384 ? 4096 : 8192) + iCapacity);
            _a(iCapacity);
        }
        this._g.position(i3);
        this._g.putLong(_azVar._a);
        this._g.putLong(_azVar._b);
        this._g.putInt(this._e);
        this._g.putInt(i2);
        this._i = i4;
        this._h.put(_azVar, new _b(_azVar, i3 + 16, this._e, i2));
        this._d += (long) i;
        this._e++;
    }

    public final void _a(_az _azVar, File file, boolean z) {
        synchronized (this) {
            if (_a()) {
                if (_azVar._a == 0 && _azVar._b == 0) {
                    return;
                }
                try {
                    _b _bVar = (_b) this._h.get(_azVar);
                    if (_bVar != null) {
                        int i = this._e;
                        _bVar._c = i;
                        this._g.putInt(_bVar._b, i);
                        this._e++;
                    }
                    if (_bVar == null && file.exists()) {
                        long length = file.length();
                        if (length > 0 && length < this._c && length <= 2147483647L) {
                            _a(_azVar, (int) length, z);
                            _b();
                        }
                    }
                } catch (Throwable th) {
                    _fu._a("DiskCache", th);
                }
            }
        }
    }

    public final void _a(List<_b> list) {
        this._e = 1;
        this._g.position(8);
        for (_b _bVar : list) {
            this._g.putLong(_bVar._a._a);
            this._g.putLong(_bVar._a._b);
            _bVar._b = this._g.position();
            int i = this._e;
            this._e = i + 1;
            _bVar._c = i;
            this._g.putInt(i);
            this._g.putInt(_bVar._d);
        }
        int iPosition = this._g.position();
        this._i = iPosition;
        _a(iPosition);
    }

    public final boolean _a() {
        if (this._c > 0 && this._b > 0) {
            if (this._h == null) {
                this._h = new HashMap();
                try {
                    _c();
                } catch (Throwable th) {
                    _fu._a("DiskCache", th);
                }
            }
            if (this._g != null) {
                return true;
            }
        }
        return false;
    }

    public final C0955_a _b(_az _azVar) {
        synchronized (this) {
            C0955_a c0955_a = null;
            if (!_a()) {
                return null;
            }
            _b _bVar = (_b) this._h.get(_azVar);
            boolean z = true;
            if (_bVar != null) {
                int i = this._e;
                _bVar._c = i;
                this._g.putInt(_bVar._b, i);
                this._e++;
            }
            if (_bVar != null) {
                String str_c = _c(_azVar);
                if ((_bVar._d & Integer.MIN_VALUE) == 0) {
                    z = false;
                }
                c0955_a = new C0955_a(str_c, z);
            }
            return c0955_a;
        }
    }

    public final void _b() {
        if (this._d > this._c || this._h.size() > this._b) {
            ArrayList arrayList = new ArrayList(this._h.values());
            ArrayList arrayList2 = new ArrayList();
            Collections.sort(arrayList);
            long j = (this._c * 7) / 8;
            int i = (this._b * 7) / 8;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size && (this._d > j || this._h.size() > i)) {
                _b _bVar = (_b) arrayList.get(i2);
                if (_o2._a(new File(_c(_bVar._a)))) {
                    this._h.remove(_bVar._a);
                    this._d -= (long) (_bVar._d & Integer.MAX_VALUE);
                } else {
                    arrayList2.add(_bVar);
                }
                i2++;
            }
            boolean zIsEmpty = arrayList2.isEmpty();
            List<_b> listSubList = arrayList.subList(i2, size);
            if (zIsEmpty) {
                _a(listSubList);
            } else {
                arrayList2.addAll(listSubList);
                _a(arrayList2);
            }
        }
    }

    public final String _c(_az _azVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(this._a);
        char[] cArr = new char[32];
        long j = _azVar._a;
        for (int i = 7; i >= 0; i--) {
            int i2 = (i << 1) + 0;
            int i3 = (int) (255 & j);
            char[] cArr2 = _az._c;
            cArr[i2] = cArr2[(i3 >> 4) & 15];
            cArr[i2 + 1] = cArr2[i3 & 15];
            j >>>= 8;
        }
        long j2 = _azVar._b;
        for (int i4 = 7; i4 >= 0; i4--) {
            int i5 = (i4 << 1) + 16;
            int i6 = (int) (j2 & 255);
            char[] cArr3 = _az._c;
            cArr[i5] = cArr3[(i6 >> 4) & 15];
            cArr[i5 + 1] = cArr3[i6 & 15];
            j2 >>>= 8;
        }
        sb.append(new String(cArr));
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:116:0x024a  */
    /* JADX WARN: Code duplicated, block: B:118:0x0255  */
    /* JADX WARN: Code duplicated, block: B:120:0x0266  */
    /* JADX WARN: Code duplicated, block: B:125:0x027c  */
    /* JADX WARN: Code duplicated, block: B:126:0x027f  */
    /* JADX WARN: Code duplicated, block: B:30:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:37:0x00e5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:40:0x0105  */
    /* JADX WARN: Code duplicated, block: B:44:0x0123  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v23 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v11 */
    /* JADX WARN: Type inference failed for: r18v12 */
    /* JADX WARN: Type inference failed for: r18v13 */
    /* JADX WARN: Type inference failed for: r18v14 */
    /* JADX WARN: Type inference failed for: r18v15 */
    /* JADX WARN: Type inference failed for: r18v16 */
    /* JADX WARN: Type inference failed for: r18v17 */
    /* JADX WARN: Type inference failed for: r18v18 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r18v9 */
    public final void _c() throws IOException {
        FileChannel.MapMode mapMode;
        ?? r18;
        int i;
        int i2;
        String[] list;
        ?? r15;
        _b _bVar;
        ?? r19;
        ?? r16;
        ?? r110;
        ?? r17;
        _az _azVar;
        NumberFormatException numberFormatException;
        int i3;
        int i4;
        NumberFormatException numberFormatException2;
        int i5;
        int i6;
        long j;
        File file;
        long length;
        long j2;
        long j3;
        _az _azVar2;
        int iPosition;
        int i7;
        File parentFile;
        File file2 = new File(this._a + a.t);
        int i8 = 0;
        if (file2.isFile() || ((parentFile = file2.getParentFile()) != null && ((parentFile.isDirectory() || parentFile.mkdirs()) && file2.createNewFile()))) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
            this._f = randomAccessFile.getChannel();
            long length2 = randomAccessFile.length();
            long j4 = 0;
            ?? r12 = 4;
            ?? r13 = 8;
            if (length2 != 0 && (4095 & length2) == 0) {
                MappedByteBuffer map = this._f.map(FileChannel.MapMode.READ_WRITE, 0L, length2);
                this._g = map;
                byte[] bArr = new byte[4];
                map.get(bArr);
                byte[] bArr2 = _j;
                if (!Arrays.equals(bArr, bArr2)) {
                    this._g.position(0);
                    this._g.put(bArr2);
                }
                this._g.position(8);
                this._i = 8;
                i = 0;
                i2 = 0;
                while (this._i + 24 <= this._g.capacity()) {
                    j2 = this._g.getLong();
                    j3 = this._g.getLong();
                    if (j2 != 0 && j3 == 0) {
                        break;
                    }
                    _azVar2 = new _az(j2, j3);
                    iPosition = this._g.position();
                    i7 = this._g.getInt();
                    if (i7 > 0) {
                        if (i7 > i) {
                            i = i7;
                        }
                        _b _bVar2 = new _b(_azVar2, iPosition, i7, this._g.getInt());
                        this._h.put(_azVar2, _bVar2);
                        this._d += (long) (_bVar2._d & Integer.MAX_VALUE);
                    } else {
                        MappedByteBuffer mappedByteBuffer = this._g;
                        mappedByteBuffer.position(mappedByteBuffer.position() + 4);
                        i2++;
                    }
                    this._i = this._g.position();
                }
                this._e = i + 1;
                if (i2 * 24 > 4096) {
                    ArrayList arrayList = new ArrayList(this._h.values());
                    Collections.sort(arrayList);
                    _a(arrayList);
                }
                list = new File(this._a).list();
                if (list != null || list.length == 0) {
                }
                HashSet hashSet = new HashSet(((list.length * 4) / 3) + 1);
                int length3 = list.length;
                int i9 = 0;
                while (i9 < length3) {
                    String str = list[i9];
                    if (a.t.equals(str)) {
                        r15 = mapMode;
                        r110 = r12;
                        r17 = r13;
                        j = j4;
                    } else {
                        byte[] bytes = str.getBytes();
                        if (bytes.length != 32) {
                            r15 = mapMode;
                            r19 = r12;
                            r16 = r13;
                        } else {
                            r15 = mapMode;
                            long j5 = j4;
                            int i10 = i8;
                            ?? r14 = r13;
                            while (true) {
                                byte b = e.i;
                                byte b2 = 97;
                                if (i10 < r14) {
                                    int i11 = (i10 << 1) + 0;
                                    byte b3 = bytes[i11];
                                    try {
                                        if (b3 >= 48 && b3 <= 57) {
                                            i5 = b3 - 48;
                                        } else {
                                            if (b3 < 97 || b3 > 102) {
                                                numberFormatException2 = new NumberFormatException("invalid hex number");
                                                throw numberFormatException2;
                                            }
                                            i5 = (b3 - 97) + 10;
                                        }
                                        byte b4 = bytes[i11 + 1];
                                        if (b4 >= 48 && b4 <= 57) {
                                            i6 = b4 - 48;
                                        } else {
                                            if (b4 < 97 || b4 > 102) {
                                                numberFormatException2 = new NumberFormatException("invalid hex number");
                                                throw numberFormatException2;
                                            }
                                            i6 = (b4 - 97) + 10;
                                        }
                                        j5 = (j5 << 8) | ((long) ((i5 << 4) | i6));
                                        i10++;
                                        r14 = 8;
                                    } catch (Exception unused) {
                                        r16 = 8;
                                        r19 = 4;
                                    }
                                } else {
                                    ?? r11 = r14;
                                    int i12 = 0;
                                    long j6 = 0;
                                    r16 = r15;
                                    r19 = r18;
                                    while (i12 < r11) {
                                        int i13 = (i12 << 1) + 16;
                                        byte b5 = bytes[i13];
                                        if (b5 >= b && b5 <= 57) {
                                            i3 = b5 - 48;
                                        } else {
                                            if (b5 < b2 || b5 > 102) {
                                                r16 = 8;
                                                r19 = 4;
                                                numberFormatException = new NumberFormatException("invalid hex number");
                                                throw numberFormatException;
                                            }
                                            i3 = (b5 - 97) + 10;
                                        }
                                        byte b6 = bytes[i13 + 1];
                                        if (b6 >= 48 && b6 <= 57) {
                                            i4 = b6 - 48;
                                        } else {
                                            if (b6 < b2 || b6 > 102) {
                                                r16 = 8;
                                                r19 = 4;
                                                numberFormatException = new NumberFormatException("invalid hex number");
                                                throw numberFormatException;
                                            }
                                            i4 = (b6 - 97) + 10;
                                        }
                                        r19 = 4;
                                        i12++;
                                        r16 = 8;
                                        j6 = (j6 << 8) | ((long) (i4 | (i3 << 4)));
                                        r11 = 8;
                                        j5 = j5;
                                        b = e.i;
                                        b2 = 97;
                                    }
                                    try {
                                        r110 = 4;
                                        r17 = r11;
                                        _azVar = new _az(j5, j6);
                                        break;
                                    } catch (Exception unused2) {
                                        _azVar = null;
                                        r17 = r16;
                                        r110 = r19;
                                    }
                                }
                            }
                            if (_azVar != null) {
                                hashSet.add(_azVar);
                                if (this._h.containsKey(_azVar)) {
                                    j = 0;
                                } else {
                                    file = new File(this._a, str);
                                    length = file.length();
                                    j = 0;
                                    if (length > 0) {
                                        if (length >= this._c && length < 2147483647L) {
                                            _a(_azVar, (int) length, false);
                                            _b();
                                        }
                                    }
                                }
                            } else {
                                j = 0;
                                file = new File(this._a, str);
                            }
                            _o2._a(file);
                        }
                        _azVar = null;
                        r17 = r16;
                        r110 = r19;
                        if (_azVar != null) {
                            hashSet.add(_azVar);
                            if (this._h.containsKey(_azVar)) {
                                file = new File(this._a, str);
                                length = file.length();
                                j = 0;
                                if (length > 0) {
                                    if (length >= this._c) {
                                    }
                                }
                            } else {
                                j = 0;
                            }
                        } else {
                            j = 0;
                            file = new File(this._a, str);
                        }
                        _o2._a(file);
                    }
                    i9++;
                    j4 = j;
                    r13 = r17;
                    r12 = r110;
                    i8 = 0;
                    r15 = r17;
                    r18 = r110;
                }
                r15 = mapMode;
                HashSet<_az> hashSet2 = new HashSet(this._h.keySet());
                hashSet2.removeAll(hashSet);
                if (hashSet2.isEmpty()) {
                    return;
                }
                for (_az _azVar3 : hashSet2) {
                    if (!new File(_c(_azVar3)).exists() && (_bVar = (_b) this._h.get(_azVar3)) != null) {
                        this._h.remove(_azVar3);
                        this._g.putInt(_bVar._b, 0);
                    }
                }
                return;
            }
            FileChannel fileChannel = this._f;
            mapMode = FileChannel.MapMode.READ_WRITE;
            r18 = 4096;
            MappedByteBuffer map2 = fileChannel.map(mapMode, 0L, 4096L);
            this._g = map2;
            map2.position(0);
            this._g.put(_j);
            this._g.putInt(1);
            _a(8);
            this._g.position(8);
            this._i = 8;
            i = 0;
            i2 = 0;
            while (this._i + 24 <= this._g.capacity()) {
                j2 = this._g.getLong();
                j3 = this._g.getLong();
                if (j2 != 0) {
                }
                _azVar2 = new _az(j2, j3);
                iPosition = this._g.position();
                i7 = this._g.getInt();
                if (i7 > 0) {
                    if (i7 > i) {
                        i = i7;
                    }
                    _b _bVar3 = new _b(_azVar2, iPosition, i7, this._g.getInt());
                    this._h.put(_azVar2, _bVar3);
                    this._d += (long) (_bVar3._d & Integer.MAX_VALUE);
                } else {
                    MappedByteBuffer mappedByteBuffer2 = this._g;
                    mappedByteBuffer2.position(mappedByteBuffer2.position() + 4);
                    i2++;
                }
                this._i = this._g.position();
            }
            this._e = i + 1;
            if (i2 * 24 > 4096) {
                ArrayList arrayList2 = new ArrayList(this._h.values());
                Collections.sort(arrayList2);
                _a(arrayList2);
            }
            list = new File(this._a).list();
            if (list != null) {
            }
        }
    }
}
