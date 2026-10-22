package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _dr implements _ay {
    public final _ce _a;
    public File _b;
    public RandomAccessFile _c;

    public _dr(File file, _ce _ceVar) throws _hs {
        File file2;
        try {
            if (_ceVar == null) {
                throw new NullPointerException();
            }
            this._a = _ceVar;
            _dt._a(file.getParentFile());
            boolean zExists = file.exists();
            if (zExists) {
                file2 = file;
            } else {
                file2 = new File(file.getParentFile(), file.getName() + ".download");
            }
            this._b = file2;
            this._c = new RandomAccessFile(this._b, zExists ? "r" : "rw");
        } catch (IOException e) {
            throw new _hs("Error using file " + file + " as disc cache", e);
        }
    }

    @Override // com.kc.aw._ay
    public final int _a(byte[] bArr, long j) {
        int i;
        synchronized (this) {
            try {
                this._c.seek(j);
                i = this._c.read(bArr, 0, 8192);
            } catch (IOException e) {
                throw new _hs(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", 8192, Long.valueOf(j), Long.valueOf(available()), Integer.valueOf(bArr.length)), e);
            }
        }
        return i;
    }

    @Override // com.kc.aw._ay
    public final void _a(int i, byte[] bArr) {
        synchronized (this) {
            try {
                if (_a()) {
                    throw new _hs("Error append cache: cache file " + this._b + " is completed!");
                }
                this._c.seek(available());
                this._c.write(bArr, 0, i);
            } catch (IOException e) {
                throw new _hs(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this._c, Integer.valueOf(bArr.length)), e);
            }
        }
    }

    @Override // com.kc.aw._ay
    public final boolean _a() {
        boolean zEndsWith;
        synchronized (this) {
            zEndsWith = this._b.getName().endsWith(".download");
        }
        return !zEndsWith;
    }

    @Override // com.kc.aw._ay
    public final void _b() {
        synchronized (this) {
            if (_a()) {
                return;
            }
            close();
            File file = new File(this._b.getParentFile(), this._b.getName().substring(0, this._b.getName().length() - 9));
            if (!this._b.renameTo(file)) {
                StringBuilder sb_a = _jf._a("Error renaming file ");
                sb_a.append(this._b);
                sb_a.append(" to ");
                sb_a.append(file);
                sb_a.append(" for completion!");
                throw new _hs(sb_a.toString());
            }
            this._b = file;
            try {
                this._c = new RandomAccessFile(this._b, "r");
                _ce _ceVar = this._a;
                File file2 = this._b;
                _fw _fwVar = (_fw) _ceVar;
                _fwVar.getClass();
                _fw._a.submit(new _fw._c(_fwVar, file2));
            } catch (IOException e) {
                StringBuilder sb_a2 = _jf._a("Error opening ");
                sb_a2.append(this._b);
                sb_a2.append(" as disc cache");
                throw new _hs(sb_a2.toString(), e);
            }
        }
    }

    @Override // com.kc.aw._ay
    public final long available() {
        long length;
        synchronized (this) {
            try {
                length = (int) this._c.length();
            } catch (IOException e) {
                StringBuilder sb_a = _jf._a("Error reading length of file ");
                sb_a.append(this._b);
                throw new _hs(sb_a.toString(), e);
            }
        }
        return length;
    }

    @Override // com.kc.aw._ay
    public final void close() {
        synchronized (this) {
            try {
                this._c.close();
                _ce _ceVar = this._a;
                File file = this._b;
                _fw _fwVar = (_fw) _ceVar;
                _fwVar.getClass();
                _fw._a.submit(new _fw._c(_fwVar, file));
            } catch (IOException e) {
                StringBuilder sb_a = _jf._a("Error closing file ");
                sb_a.append(this._b);
                throw new _hs(sb_a.toString(), e);
            }
        }
    }
}
