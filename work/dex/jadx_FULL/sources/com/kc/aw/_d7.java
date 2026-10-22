package com.kc.aw;

import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import com.byazt.omf.h;
import com.kc.aw.download.DownloadResult;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _d7 {
    public static final _d7 _b = new _d7();
    public static final HashMap _c = new HashMap();
    public static final HashMap _d = new HashMap();
    public final ConcurrentHashMap _a = new ConcurrentHashMap();

    @Keep
    public static final class _a implements Handler.Callback, _cs {
        public final String _a;
        public final HashSet _b = new HashSet();
        public final Messenger _c = new Messenger(new Handler(this));

        public _a(String str) {
            this._a = str;
        }

        @Override // com.kc.aw._cs
        public final void _a(DownloadResult downloadResult) {
            HashSet hashSet = new HashSet();
            synchronized (this._b) {
                hashSet.addAll(this._b);
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((_cs) it.next())._a(downloadResult);
            }
        }

        @Override // com.kc.aw._cs
        public final void _a(DownloadResult downloadResult, int i) {
            HashSet hashSet = new HashSet();
            synchronized (this._b) {
                hashSet.addAll(this._b);
                this._b.clear();
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((_cs) it.next())._a(downloadResult, i);
            }
        }

        @Override // com.kc.aw._cs
        public final void _a(DownloadResult downloadResult, Throwable th) {
            HashSet hashSet = new HashSet();
            synchronized (this._b) {
                hashSet.addAll(this._b);
                this._b.clear();
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((_cs) it.next())._a(downloadResult, th);
            }
        }

        @Override // com.kc.aw._cs
        public final void _b(DownloadResult downloadResult) {
            HashSet hashSet = new HashSet();
            synchronized (this._b) {
                hashSet.addAll(this._b);
                this._b.clear();
                _d7._d.remove(com.kc.aw.lib.utils._a._c(downloadResult._b));
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((_cs) it.next())._b(downloadResult);
            }
        }

        @Override // com.kc.aw._cs
        public final void _b(DownloadResult downloadResult, int i) {
            HashSet hashSet = new HashSet();
            synchronized (this._b) {
                hashSet.addAll(this._b);
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((_cs) it.next())._b(downloadResult, i);
            }
        }

        @Override // com.kc.aw._cs
        public final void _c(DownloadResult downloadResult) {
            HashSet hashSet = new HashSet();
            synchronized (this._b) {
                hashSet.addAll(this._b);
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((_cs) it.next())._c(downloadResult);
            }
        }

        @Override // com.kc.aw._cs
        public final void _d(DownloadResult downloadResult) {
            HashSet hashSet = new HashSet();
            synchronized (this._b) {
                hashSet.addAll(this._b);
                this._b.clear();
                _d7._d.remove(com.kc.aw.lib.utils._a._c(downloadResult._b));
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((_cs) it.next())._d(downloadResult);
            }
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.getData() == null) {
                return false;
            }
            int i = message.getData().getInt("download_status_extra");
            int i2 = message.getData().getInt("download_progress");
            String string = message.getData().getString("download_path_extra");
            long j = message.getData().getLong("download_current_bytes");
            long j2 = message.getData().getLong("download_total_bytes");
            String string2 = message.getData().getString("download_file_name");
            switch (i) {
                case 42:
                    _c(new DownloadResult(string2, j2, j, this._a, string));
                    break;
                case 43:
                    _a(new DownloadResult(string2, j2, j, this._a, string));
                    break;
                case 44:
                    _b(new DownloadResult(string2, j2, j, this._a, string), i2);
                    break;
                case 45:
                    _a(new DownloadResult(string2, j2, j, this._a, string), i2);
                    break;
                case 46:
                    _d(new DownloadResult(string2, j2, j, this._a, string));
                    break;
                case 47:
                    _a(new DownloadResult(string2, j2, j, this._a, string), message.getData() != null ? (Throwable) message.getData().getSerializable("error_extra") : new RuntimeException(h.UNKNOWN_ERR_MSG));
                    break;
                case 48:
                    _b(new DownloadResult(string2, j2, j, this._a, string));
                    break;
            }
            return false;
        }
    }

    public final void _a(int i, int i2, String str, String str2, _h _hVar, _d2._b _bVar) {
        synchronized (this._a) {
            this._a.remove(str2);
        }
        if (_hVar != null) {
            _hVar._k = i;
        }
        if (_bVar != null) {
            ((_cx) _bVar)._a(i, i2, str);
        }
    }
}
