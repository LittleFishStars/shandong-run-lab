package com.kc.aw.lib.doodle;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.View;
import com.kc.aw._9;
import com.kc.aw._az;
import com.kc.aw._bn;
import com.kc.aw._br;
import com.kc.aw._c1;
import com.kc.aw._c4;
import com.kc.aw._fu;
import com.kc.aw._g5;
import com.kc.aw._i8;
import com.kc.aw._jf;
import com.kc.aw._l2;
import com.kc.aw._o2;
import com.kc.aw._oa;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _f extends _c {
    public static final _a _m = new _a(8192, _bn._b, "/doodle/result/");
    public static final AtomicInteger _n = new AtomicInteger();
    public final _l2 _i;
    public boolean _j = false;
    public boolean _k = false;
    public long _l;

    public _f(_l2 _l2Var, View view, boolean z) {
        this._i = _l2Var;
        this._g = z;
        if (_fu._a()) {
            StringBuilder sb_a = _jf._a("Loading start, count:");
            sb_a.append(_n.incrementAndGet());
            Log.d("Worker", sb_a.toString());
        }
        if (view != null) {
            _l2Var._p = new WeakReference<>(this);
            view.setTag(R.id.aw_doodle_view_tag, _l2Var);
        }
    }

    public static Object _a(_c4 _c4Var) {
        Iterator it = _bn._d.iterator();
        while (it.hasNext()) {
            Object obj_a = ((_9) it.next())._a(_c4Var);
            if (obj_a != null) {
                return obj_a instanceof BitmapDrawable ? ((BitmapDrawable) obj_a).getBitmap() : obj_a;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0097, code lost:
    
        throw r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void _a(_az _azVar, Bitmap bitmap, Bitmap.CompressFormat compressFormat, boolean z) {
        boolean z2;
        boolean z3;
        File parentFile;
        try {
            _a _aVar = _m;
            synchronized (_aVar) {
                z2 = false;
                z3 = _aVar._a() && !_aVar._h.containsKey(_azVar);
            }
            if (z3) {
                String str_c = _aVar._c(_azVar);
                File file = new File(str_c + ".tmp");
                if (file.isFile() || ((parentFile = file.getParentFile()) != null && ((parentFile.isDirectory() || parentFile.mkdirs()) && file.createNewFile()))) {
                    z2 = true;
                }
                if (z2) {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    try {
                        bitmap.compress(compressFormat, compressFormat == Bitmap.CompressFormat.WEBP ? 100 : 95, bufferedOutputStream);
                        bufferedOutputStream.flush();
                        fileOutputStream.getFD().sync();
                        _o2._a(bufferedOutputStream);
                        File file2 = new File(str_c);
                        if (file2.exists()) {
                            _o2._a(file2);
                        }
                        if (file.renameTo(file2)) {
                            _aVar._a(_azVar, file2, z);
                        }
                    } catch (Throwable th) {
                        _o2._a(bufferedOutputStream);
                        throw th;
                    }
                }
            }
        } catch (Throwable th2) {
            _fu._a("Worker", th2);
        }
    }

    public static void _a(_l2 _l2Var, final Bitmap bitmap, _c1 _c1Var) {
        final _az _azVar_a = _l2Var._a();
        int i_c = 1;
        final boolean z = _l2Var._g == 2;
        if (!z && _c1Var != null) {
            try {
                i_c = _c1Var._c();
            } catch (Throwable unused) {
            }
        }
        final Bitmap.CompressFormat compressFormat = (z || i_c == 7 || i_c == 9 || i_c == 11 || i_c == 13 || i_c == 2 || i_c == 3 || i_c == 4 || i_c == 5) ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
        _d._d.execute(new Runnable(_azVar_a, bitmap, compressFormat, z) { // from class: com.kc.aw.lib.doodle._f$$ExternalSyntheticLambda0
            public final _az f$0;
            public final Bitmap f$1;
            public final Bitmap.CompressFormat f$2;
            public final boolean f$3;

            {
                this.f$0 = _azVar_a;
                this.f$1 = bitmap;
                this.f$2 = compressFormat;
                this.f$3 = z;
            }

            @Override // java.lang.Runnable
            public final void run() {
                _f._a(this.f$0, this.f$1, this.f$2, this.f$3);
            }
        });
    }

    public final Bitmap _a(_a.C0955_a c0955_a) {
        Bitmap bitmapDecodeFile;
        try {
            bitmapDecodeFile = Decoder.decodeFile(c0955_a._a, c0955_a._b ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888);
        } catch (Throwable th) {
            _fu._a("Worker", th);
            bitmapDecodeFile = null;
        }
        if (bitmapDecodeFile == null) {
            this._k = false;
            _m._a(this._i._a());
        }
        return bitmapDecodeFile;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
    
        if (r6 == null) goto L12;
     */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x01fb: IF  (r9 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:148:0x0202, block:B:146:0x01fb */
    @Override // com.kc.aw.lib.doodle._c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object _a() {
        _c4 _c4Var;
        _c4 _c4Var2;
        Object obj;
        boolean z;
        Object obj_a;
        long jNanoTime = System.nanoTime();
        _az _azVar_a = this._i._a();
        try {
            try {
                WeakReference<View> weakReference = this._i._o;
                if (weakReference != null) {
                    View view = weakReference.get();
                    if (view == null || view.getTag(R.id.aw_doodle_view_tag) != this._i) {
                        view = null;
                    }
                }
                Bitmap bitmap_a = _g5._a(_azVar_a);
                boolean z2 = true;
                if (bitmap_a != null) {
                    this._j = true;
                } else {
                    _oa _oaVar = _g5._d;
                    synchronized (_oaVar) {
                        Reference<? extends Object> referencePoll = _oaVar._b.poll();
                        while (true) {
                            _oa._a _aVar = (_oa._a) referencePoll;
                            if (_aVar == null) {
                                break;
                            }
                            _oa._a _aVar2 = (_oa._a) _oaVar._a.get(_aVar._a);
                            if (_aVar2 != null && _aVar2.get() == null) {
                                _oaVar._a.remove(_aVar._a);
                            }
                            referencePoll = _oaVar._b.poll();
                        }
                        _oa._a _aVar3 = (_oa._a) _oaVar._a.get(_azVar_a);
                        obj = _aVar3 != null ? _aVar3.get() : null;
                    }
                    if (obj != null) {
                        this._j = true;
                        this._l = (System.nanoTime() - jNanoTime) / 1000000;
                        return obj;
                    }
                    _g5._a();
                    _a.C0955_a c0955_a_b = _m._b(_azVar_a);
                    boolean z3 = c0955_a_b != null;
                    this._k = z3;
                    if (z3) {
                        bitmap_a = _a(c0955_a_b);
                    }
                    if (bitmap_a == null) {
                        _c4Var = new _c4(this._i);
                        try {
                            this._i.getClass();
                            if (bitmap_a == null && this._i._h && _bn._d != null && (obj_a = _a(_c4Var)) != null) {
                                if (!(obj_a instanceof Bitmap)) {
                                    if (this._i._j != 1) {
                                        synchronized (_oaVar) {
                                            Reference<? extends Object> referencePoll2 = _oaVar._b.poll();
                                            while (true) {
                                                _oa._a _aVar4 = (_oa._a) referencePoll2;
                                                if (_aVar4 == null) {
                                                    break;
                                                }
                                                _oa._a _aVar5 = (_oa._a) _oaVar._a.get(_aVar4._a);
                                                if (_aVar5 != null && _aVar5.get() == null) {
                                                    _oaVar._a.remove(_aVar4._a);
                                                }
                                                referencePoll2 = _oaVar._b.poll();
                                            }
                                            _oa._a _aVar6 = (_oa._a) _oaVar._a.get(_azVar_a);
                                            if (_aVar6 == null || _aVar6.get() != obj_a) {
                                                _oaVar._a.put(_azVar_a, new _oa._a(_azVar_a, obj_a, _oaVar._b));
                                            }
                                        }
                                    }
                                    _o2._a(_c4Var._d);
                                    this._l = (System.nanoTime() - jNanoTime) / 1000000;
                                    return obj_a;
                                }
                                bitmap_a = Decoder.handleScaleAndCrop((Bitmap) obj_a, this._i);
                            }
                            if (bitmap_a == null) {
                                String str = _bn._a;
                            }
                            if (bitmap_a == null) {
                                bitmap_a = Decoder.decode(_c4Var._b(), this._i);
                            }
                        } catch (InterruptedIOException e) {
                            e = e;
                            if (_fu._a()) {
                                Log.d("Worker", "Interrupted reason: " + e.getClass().getSimpleName());
                            }
                            if (_c4Var != null) {
                                _o2._a(_c4Var._d);
                            }
                            this._l = (System.nanoTime() - jNanoTime) / 1000000;
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            _c1 _c1Var = _c4Var != null ? _c4Var._d : null;
                            if (_c1Var != null && _c1Var._c) {
                                _b._a._a(_azVar_a);
                            }
                            _fu._a("Worker", new Exception("Load bitmap failed, path: " + this._i._b, th));
                            if (_c4Var != null) {
                                _o2._a(_c4Var._d);
                            }
                            this._l = (System.nanoTime() - jNanoTime) / 1000000;
                            return null;
                        }
                    } else {
                        _c4Var = null;
                    }
                    if (bitmap_a != null && !(z = this._k)) {
                        _l2 _l2Var = this._i;
                        if (!z) {
                            _l2Var.getClass();
                        }
                    }
                    if (bitmap_a != null) {
                        int i = this._i._j;
                        if (i != 1) {
                            _g5._a(_azVar_a, bitmap_a, i == 2);
                        }
                        if (!this._k) {
                            int i2 = this._i._k;
                            _i8._a(i2);
                            if (i2 != 4 && i2 != 3) {
                                z2 = false;
                            }
                            if (z2) {
                                _a(this._i, bitmap_a, _c4Var != null ? _c4Var._d : null);
                            }
                        }
                    }
                    if (_c4Var != null) {
                        _o2._a(_c4Var._d);
                    }
                }
                this._l = (System.nanoTime() - jNanoTime) / 1000000;
                return bitmap_a;
            } catch (Throwable th2) {
                if (_c4Var2 != null) {
                    _o2._a(_c4Var2._d);
                }
                this._l = (System.nanoTime() - jNanoTime) / 1000000;
                throw th2;
            }
        } catch (InterruptedIOException e2) {
            e = e2;
            _c4Var = null;
        } catch (Throwable th3) {
            th = th3;
            _c4Var = null;
        }
    }

    @Override // com.kc.aw.lib.doodle._c
    public final void _b(Object obj) {
        View view;
        if (_fu._a()) {
            Log.d("Worker", "Loading finish, path:" + this._i._b + ", time:" + this._l + "ms, remain:" + _n.decrementAndGet());
        }
        WeakReference<View> weakReference = this._i._o;
        if (weakReference == null || (view = weakReference.get()) == null || view.getTag(R.id.aw_doodle_view_tag) != this._i) {
            view = null;
        }
        if (view != null) {
            view.setTag(R.id.aw_doodle_view_tag, null);
            _br._c(view);
        }
        try {
            _br._a(this._i, view, obj, this._j);
        } catch (Throwable th) {
            _fu._a("Worker", th);
        }
    }

    @Override // com.kc.aw.lib.doodle._c
    public final void _c() {
        View view;
        if (_fu._a()) {
            Log.d("Worker", "Loading cancel, path:" + this._i._b + ", time:" + this._l + "ms, remain:" + _n.decrementAndGet());
        }
        WeakReference<View> weakReference = this._i._o;
        if (weakReference == null || (view = weakReference.get()) == null || view.getTag(R.id.aw_doodle_view_tag) != this._i) {
            view = null;
        }
        if (view != null) {
            view.setTag(R.id.aw_doodle_view_tag, null);
            _br._c(view);
        }
        _l2 _l2Var = this._i;
        _l2Var._n = null;
        _l2Var._o = null;
        _l2Var._p = null;
    }

    public final _az _d() {
        return this._i._b.startsWith("http") ? new _az(this._i._b) : this._i._a();
    }
}
