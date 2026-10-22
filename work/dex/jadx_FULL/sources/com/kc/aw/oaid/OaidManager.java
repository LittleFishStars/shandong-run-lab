package com.kc.aw.oaid;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kc.aw._a2;
import com.kc.aw._a3;
import com.kc.aw._c9;
import com.kc.aw._cc;
import com.kc.aw._dw;
import com.kc.aw._ga;
import com.kc.aw._hb;
import com.kc.aw._jw;
import com.kc.aw._m4;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.interf.PtgCustomController;
import com.kc.aw.lib.utils._d;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class OaidManager {
    public static final String TAG = "OaidHelperTag";
    private static final AtomicBoolean isRequstedOaid = new AtomicBoolean(false);

    @Keep
    public final class _a implements Runnable {
        public final Context _a;

        /* JADX INFO: renamed from: com.kc.aw.oaid.OaidManager$_a$_a, reason: collision with other inner class name */
        @Keep
        public final class C0959_a implements _a3 {
            public final long _a;
            public final _a _b;

            /* JADX INFO: renamed from: com.kc.aw.oaid.OaidManager$_a$_a$_a, reason: collision with other inner class name */
            @Keep
            public final class C0960_a implements _a3 {
                public final C0959_a _a;

                public C0960_a(C0959_a c0959_a) {
                    this._a = c0959_a;
                }

                @Override // com.kc.aw._a3
                public final void _a(String str) {
                    OaidManager.printD("[MsaOaidHelper] oaid = " + str + "，cost = " + (System.currentTimeMillis() - this._a._a));
                    if (TextUtils.isEmpty(str)) {
                        str = OaidManager.getMediaOaid();
                    }
                    OaidManager.oaidCallback(str);
                    _a2 _a2Var_a = _a2._a();
                    Context context = this._a._b._a;
                    _a2Var_a.getClass();
                    _a2._b = str;
                    try {
                        _jw._a(context, "ptg_ids_sp_oaid", str);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }

            public C0959_a(_a _aVar, long j) {
                this._b = _aVar;
                this._a = j;
            }

            @Override // com.kc.aw._a3
            public final void _a(String str) {
                try {
                    if (TextUtils.isEmpty(str)) {
                        OaidManager.printD("[OaidHelper] oaid为空, 尝试[MsaOaidHelper]方式获取oaid");
                        _ga._a(this._b._a, new C0960_a(this));
                    } else {
                        OaidManager.printD("[OaidHelper] oaid = " + str + "，cost = " + (System.currentTimeMillis() - this._a));
                        OaidManager.oaidCallback(str);
                        _a2 _a2Var_a = _a2._a();
                        Context context = this._b._a;
                        _a2Var_a.getClass();
                        _a2._b = str;
                        try {
                            _jw._a(context, "ptg_ids_sp_oaid", str);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }

        @Keep
        public final class _b implements _a3 {
            public final long _a;
            public final _a _b;

            public _b(_a _aVar, long j) {
                this._b = _aVar;
                this._a = j;
            }

            @Override // com.kc.aw._a3
            public final void _a(String str) {
                OaidManager.printD("[GMSADIDHelper] gaid = " + str + "，cost = " + (System.currentTimeMillis() - this._a));
                OaidManager.gaidCallback(str);
                _a2 _a2Var_a = _a2._a();
                Context context = this._b._a;
                _a2Var_a.getClass();
                _a2._c = str;
                try {
                    _jw._a(context, "ptg_ids_sp_gaid", str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public _a(Context context) {
            this._a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String str_c;
            String str;
            String str_c2 = "";
            if (OaidManager.canGetOaid()) {
                try {
                    _a2 _a2Var_a = _a2._a();
                    Context context = this._a;
                    _a2Var_a.getClass();
                    if (TextUtils.isEmpty(_a2._b)) {
                        try {
                            str_c = _jw._c(context, "ptg_ids_sp_oaid");
                        } catch (Throwable th) {
                            th.printStackTrace();
                            str_c = "";
                        }
                        _a2._b = str_c;
                    } else {
                        str_c = _a2._b;
                    }
                    if (!TextUtils.isEmpty(str_c)) {
                        OaidManager.oaidCallback(str_c);
                    }
                    if (TextUtils.isEmpty(str_c)) {
                        String mediaOaid = OaidManager.getMediaOaid();
                        if (!TextUtils.isEmpty(mediaOaid)) {
                            OaidManager.oaidCallback(mediaOaid);
                        }
                    }
                    OaidManager.printD("[OaidHelper] 获取oaid");
                    MyOaidHelper.getOAid(this._a, new C0959_a(this, System.currentTimeMillis()));
                } catch (Exception unused) {
                }
            } else {
                OaidManager.oaidCallback("");
            }
            try {
                _a2 _a2Var_a2 = _a2._a();
                Context context2 = this._a;
                _a2Var_a2.getClass();
                if (TextUtils.isEmpty(_a2._c)) {
                    try {
                        str_c2 = _jw._c(context2, "ptg_ids_sp_gaid");
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    _a2._c = str_c2;
                    str = str_c2;
                } else {
                    str = _a2._c;
                }
                if (!TextUtils.isEmpty(str)) {
                    OaidManager.gaidCallback(str);
                }
                new _dw(this._a)._a(new _b(this, System.currentTimeMillis()));
            } catch (Exception unused2) {
            }
        }
    }

    @Keep
    public final class _b implements _a3 {
        public final Context _a;
        public final _a3 _b;

        @Keep
        public final class _a implements _a3 {
            public final _b _a;

            public _a(_b _bVar) {
                this._a = _bVar;
            }

            @Override // com.kc.aw._a3
            public final void _a(String str) {
                _a2 _a2Var_a = _a2._a();
                Context context = this._a._a;
                _a2Var_a.getClass();
                _a2._b = str;
                try {
                    _jw._a(context, "ptg_ids_sp_oaid", str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                _cc._b()._a = str;
                this._a._b._a(str);
            }
        }

        public _b(Context context, _a3 _a3Var) {
            this._a = context;
            this._b = _a3Var;
        }

        @Override // com.kc.aw._a3
        public final void _a(String str) {
            if (TextUtils.isEmpty(str)) {
                _ga._a(this._a, new _a(this));
                return;
            }
            _a2 _a2Var_a = _a2._a();
            Context context = this._a;
            _a2Var_a.getClass();
            _a2._b = str;
            try {
                _jw._a(context, "ptg_ids_sp_oaid", str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            _cc._b()._a = str;
            this._b._a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean canGetOaid() {
        return Build.VERSION.SDK_INT > 28;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void gaidCallback(String str) {
        _c9 _c9Var = _m4._a;
        if (_c9Var != null) {
            _c9Var._b = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getMediaOaid() {
        PtgCustomController ptgCustomController = PtgAdSdk.getConfig()._m;
        return ptgCustomController != null ? ptgCustomController.getMediaDeviceOaId() : "";
    }

    public static void getOaidAsync(Context context, _a3 _a3Var) {
        String str_c;
        if (!canGetOaid()) {
            _a3Var._a("");
            return;
        }
        PtgCustomController ptgCustomController = PtgAdSdk.getConfig()._m;
        if (ptgCustomController != null && !ptgCustomController.isAllowSDKObtainOaId()) {
            _a3Var._a("");
            return;
        }
        _a2._a().getClass();
        if (TextUtils.isEmpty(_a2._b)) {
            try {
                str_c = _jw._c(context, "ptg_ids_sp_oaid");
            } catch (Throwable th) {
                th.printStackTrace();
                str_c = "";
            }
            _a2._b = str_c;
        } else {
            str_c = _a2._b;
        }
        if (!TextUtils.isEmpty(str_c)) {
            _a3Var._a(str_c);
            return;
        }
        AtomicBoolean atomicBoolean = isRequstedOaid;
        if (!atomicBoolean.get()) {
            try {
                atomicBoolean.compareAndSet(false, true);
                MyOaidHelper.getOAid(context, new _b(context, _a3Var));
                return;
            } catch (Exception unused) {
            }
        }
        _a3Var._a("");
    }

    public static void init(Context context) {
        synchronized (OaidManager.class) {
            try {
                _d._b(new _a(context));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void oaidCallback(String str) {
        _hb._a = str;
        _c9 _c9Var = _m4._a;
        if (_c9Var != null) {
            _c9Var._a = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void printD(String str) {
    }
}
