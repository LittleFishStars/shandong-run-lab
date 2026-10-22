package com.kc.aw;

import android.content.Context;
import com.kc.aw.download.DownloadResult;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.interf.PtgAppDownloadListener;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _d0 implements _cs {
    public final _h _a;
    public final Context _b;

    @Keep
    public final class _a implements Runnable {
        public final DownloadResult _a;
        public final Throwable _b;

        public _a(DownloadResult downloadResult, Throwable th) {
            this._a = downloadResult;
            this._b = th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgAppDownloadListener ptgAppDownloadListener_a = _d2._a(this._a._b);
            if (ptgAppDownloadListener_a != null) {
                ptgAppDownloadListener_a.onDownloadFailed(this._b.getMessage());
            }
            StringBuilder sb_a = _jf._a("DownloadManager error [");
            sb_a.append(this._a._a);
            sb_a.append("]");
            Logger.d(sb_a.toString());
        }
    }

    @Keep
    public final class _b implements Runnable {
        public final DownloadResult _a;

        public _b(DownloadResult downloadResult) {
            this._a = downloadResult;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgAppDownloadListener ptgAppDownloadListener_a = _d2._a(this._a._b);
            if (ptgAppDownloadListener_a != null) {
                ptgAppDownloadListener_a.onIdle();
            }
            StringBuilder sb_a = _jf._a("DownloadManager waiting [");
            sb_a.append(this._a._a);
            sb_a.append("]");
            Logger.d(sb_a.toString());
        }
    }

    @Keep
    public final class _c implements Runnable {
        public final DownloadResult _a;

        public _c(DownloadResult downloadResult) {
            this._a = downloadResult;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgAppDownloadListener ptgAppDownloadListener_a = _d2._a(this._a._b);
            if (ptgAppDownloadListener_a != null) {
                DownloadResult downloadResult = this._a;
                ptgAppDownloadListener_a.onDownloadActive(downloadResult._d, downloadResult._e, downloadResult._a);
            }
            StringBuilder sb_a = _jf._a("DownloadManager start [");
            sb_a.append(this._a._a);
            sb_a.append("]");
            Logger.d(sb_a.toString());
        }
    }

    @Keep
    public final class _d implements Runnable {
        public final DownloadResult _a;

        public _d(DownloadResult downloadResult) {
            this._a = downloadResult;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgAppDownloadListener ptgAppDownloadListener_a = _d2._a(this._a._b);
            if (ptgAppDownloadListener_a != null) {
                DownloadResult downloadResult = this._a;
                ptgAppDownloadListener_a.onDownloadActive(downloadResult._d, downloadResult._e, downloadResult._a);
            }
            StringBuilder sb_a = _jf._a("DownloadManager downloading [");
            sb_a.append(this._a._a);
            sb_a.append("]");
            Logger.d(sb_a.toString());
        }
    }

    @Keep
    public final class _e implements Runnable {
        public final DownloadResult _a;

        public _e(DownloadResult downloadResult) {
            this._a = downloadResult;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgAppDownloadListener ptgAppDownloadListener_a = _d2._a(this._a._b);
            if (ptgAppDownloadListener_a != null) {
                DownloadResult downloadResult = this._a;
                ptgAppDownloadListener_a.onDownloadActive(downloadResult._d, downloadResult._e, downloadResult._a);
            }
            StringBuilder sb_a = _jf._a("DownloadManager pause [");
            sb_a.append(this._a._a);
            sb_a.append("]");
            Logger.d(sb_a.toString());
        }
    }

    @Keep
    public final class _f implements Runnable {
        public final DownloadResult _a;

        public _f(DownloadResult downloadResult) {
            this._a = downloadResult;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgAppDownloadListener ptgAppDownloadListener_a = _d2._a(this._a._b);
            if (ptgAppDownloadListener_a != null) {
                ptgAppDownloadListener_a.onDownloadFinished(this._a._a);
            }
            StringBuilder sb_a = _jf._a("DownloadManager completed [");
            sb_a.append(this._a._a);
            sb_a.append("]");
            Logger.d(sb_a.toString());
        }
    }

    @Keep
    public final class _g implements Runnable {
        public final DownloadResult _a;

        public _g(DownloadResult downloadResult) {
            this._a = downloadResult;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgAppDownloadListener ptgAppDownloadListener_a = _d2._a(this._a._b);
            if (ptgAppDownloadListener_a != null) {
                ptgAppDownloadListener_a.onDownloadCancel();
            }
            Logger.d("DownloadManager cancel");
        }
    }

    public _d0(_h _hVar, Context context, _cz _czVar) {
        this._a = _hVar;
        this._b = context;
    }

    @Override // com.kc.aw._cs
    public final void _a(DownloadResult downloadResult) {
        com.kc.aw.lib.utils._d._c(new _c(downloadResult));
    }

    @Override // com.kc.aw._cs
    public final void _a(DownloadResult downloadResult, int i) {
        com.kc.aw.lib.utils._d._c(new _e(downloadResult));
    }

    @Override // com.kc.aw._cs
    public final void _a(DownloadResult downloadResult, Throwable th) {
        com.kc.aw.lib.utils._d._c(new _a(downloadResult, th));
    }

    @Override // com.kc.aw._cs
    public final void _b(DownloadResult downloadResult) {
        com.kc.aw.lib.utils._d._c(new _g(downloadResult));
    }

    @Override // com.kc.aw._cs
    public final void _b(DownloadResult downloadResult, int i) {
        com.kc.aw.lib.utils._d._c(new _d(downloadResult));
    }

    @Override // com.kc.aw._cs
    public final void _c(DownloadResult downloadResult) {
        com.kc.aw.lib.utils._d._c(new _b(downloadResult));
    }

    @Override // com.kc.aw._cs
    public final void _d(DownloadResult downloadResult) {
        com.kc.aw.lib.utils._d._c(new _f(downloadResult));
        if (this._a != null) {
            if (!_fp._a(this._b)) {
                _d2._a(PtgAdSdk.getContext(), downloadResult._c);
                return;
            }
            Context context = this._b;
            _h _hVar = this._a;
            String str = _hVar._i;
            String str_d = _hVar._d();
            String str2 = downloadResult._c;
            if (context == null) {
                return;
            }
            _jw._a(context, "uninstall_apk_download_url", str);
            _jw._a(context, "uninstall_apk_app_name", str_d);
            _jw._a(context, "uninstall_apk_path", str2);
        }
    }
}
