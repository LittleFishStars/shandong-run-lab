package com.kc.aw;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Messenger;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.byazt.tk.AdBaseConstants;
import com.kc.aw.download.DownloadService;
import com.kc.aw.download.beans.RequestInfo;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.interf.PtgAppDownloadListener;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _d2 {
    public static final HashMap _a = new HashMap();
    public static AtomicBoolean _b = new AtomicBoolean(false);
    public static AtomicBoolean _c = new AtomicBoolean(false);
    public static final Handler _d = new Handler(Looper.getMainLooper());
    public static final _a _e = new _a();

    @Keep
    public final class _a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            Context context = PtgAdSdk.getContext();
            String str_c = context == null ? "" : _jw._c(context, "uninstall_apk_path");
            Context context2 = PtgAdSdk.getContext();
            String str_c2 = context2 != null ? _jw._c(context2, "uninstall_apk_download_url") : "";
            Context context3 = PtgAdSdk.getContext();
            if (context3 != null) {
                _jw._c(context3, "uninstall_apk_app_name");
            }
            if (!TextUtils.isEmpty(str_c2) && !TextUtils.isEmpty(str_c2)) {
                _d2._a(PtgAdSdk.getContext(), str_c);
            }
            _hi._a(PtgAdSdk.getContext());
        }
    }

    @Keep
    public interface _b {
    }

    public static PtgAppDownloadListener _a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (PtgAppDownloadListener) _a.get(com.kc.aw.lib.utils._a._c(str));
    }

    public static void _a(Context context, _h _hVar, AdSlot adSlot, _lg._d _dVar) {
        String str;
        String str2;
        if (_hVar._a != 0) {
            str2 = "资源数据异常！[action]";
        } else {
            String str3 = _hVar._i;
            if (!TextUtils.isEmpty(str3)) {
                String str_d = _hVar._d();
                String str_a = _da._a(str_d, ".apk");
                File file_a = _da._a(context, str_a);
                if (_da._a(file_a)) {
                    String absolutePath = file_a.getAbsolutePath();
                    if (context == null || TextUtils.isEmpty(absolutePath)) {
                        return;
                    }
                    _hi._a(context);
                    try {
                        File file = new File(absolutePath);
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        intent.setFlags(268435456);
                        intent.addFlags(1);
                        intent.addFlags(2);
                        intent.setDataAndType(FileProvider.getUriForFile(context, context.getPackageName() + ".fileProvider", file), AdBaseConstants.MIME_APK);
                        context.startActivity(intent);
                        _b.set(true);
                        return;
                    } catch (Exception e) {
                        _b.set(false);
                        Logger.e(e.getMessage());
                        return;
                    }
                }
                _cx _cxVar = new _cx(_dVar, str_a, str3, context, _hVar, str_d, adSlot);
                if (_hVar._a != 0) {
                    str = "资源数据异常！[action]";
                } else {
                    if (!TextUtils.isEmpty(_hVar._i)) {
                        int i = _hVar._k;
                        if (i != 0) {
                            _cxVar._a(i, -1, "");
                            return;
                        }
                        _d7 _d7Var = _d7._b;
                        _d7Var.getClass();
                        String str4 = _hVar._i;
                        String str_c = com.kc.aw.lib.utils._a._c(str4);
                        synchronized (_d7Var._a) {
                            if (!_d7Var._a.containsKey(str_c)) {
                                _d7Var._a.put(str_c, str_c);
                                try {
                                    new _cw(str4, new _d6(_d7Var, str_c, _hVar, _cxVar));
                                } catch (Exception e2) {
                                    _d7Var._a(0, PtgErrorCode.SDK_RESOURCE_ERROR, e2.getMessage(), str_c, _hVar, _cxVar);
                                }
                            }
                        }
                        return;
                    }
                    str = "资源数据异常！[url]";
                }
                _cxVar._a(0, PtgErrorCode.SDK_RESOURCE_ERROR, str);
                return;
            }
            str2 = "资源数据异常！[url]";
        }
        _dVar._a(str2);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x009a A[Catch: all -> 0x00c7, TryCatch #3 {, blocks: (B:31:0x0092, B:33:0x009a, B:35:0x00b0, B:37:0x00b6, B:38:0x00b7, B:39:0x00bb, B:45:0x00c5, B:46:0x00c6, B:34:0x00ab, B:36:0x00b1), top: B:69:0x0092, outer: #2, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00ab A[Catch: all -> 0x00c7, TryCatch #3 {, blocks: (B:31:0x0092, B:33:0x009a, B:35:0x00b0, B:37:0x00b6, B:38:0x00b7, B:39:0x00bb, B:45:0x00c5, B:46:0x00c6, B:34:0x00ab, B:36:0x00b1), top: B:69:0x0092, outer: #2, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x00b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x008f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x0051 A[SYNTHETIC] */
    public static void _a(Context context, _h _hVar, String str, String str2) {
        _d7._a _aVar;
        boolean z;
        _cs _csVar;
        HashMap map;
        _d7._a _aVar2;
        Messenger messenger;
        _cz _czVar = new _cz();
        _d7 _d7Var = _d7._b;
        _d0 _d0Var = new _d0(_hVar, context, _czVar);
        _d7Var.getClass();
        RequestInfo requestInfo = new RequestInfo(str2);
        requestInfo._d = 10;
        requestInfo._g = _d0Var;
        requestInfo._a = str;
        requestInfo._b = ".apk";
        requestInfo._f = new _d5(str2, str);
        requestInfo._h = true;
        HashMap map2 = _d7._c;
        map2.put(com.kc.aw.lib.utils._a._c(str2), requestInfo);
        synchronized (_d7Var) {
            if (!map2.isEmpty()) {
                Intent intent = new Intent(context, (Class<?>) DownloadService.class);
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                for (RequestInfo requestInfo2 : map2.values()) {
                    if (requestInfo2 != null) {
                        HashMap map3 = _d7._d;
                        synchronized (map3) {
                            _aVar = (_d7._a) map3.get(com.kc.aw.lib.utils._a._c(requestInfo2._c));
                        }
                        if (_aVar != null && (!_aVar._b.isEmpty())) {
                            z = true;
                        }
                        if (requestInfo2._h || !z) {
                            _csVar = requestInfo2._g;
                            if (_csVar != null) {
                                map = _d7._d;
                                synchronized (map) {
                                    _aVar2 = (_d7._a) map.get(requestInfo2);
                                    if (_aVar2 == null) {
                                        _aVar2 = new _d7._a(requestInfo2._c);
                                        map.put(com.kc.aw.lib.utils._a._c(requestInfo2._c), _aVar2);
                                    } else {
                                        Logger.e("download seed has exist");
                                    }
                                    synchronized (_aVar2) {
                                        _aVar2._b.add(_csVar);
                                    }
                                    messenger = _aVar2._c;
                                    requestInfo2._e = messenger;
                                }
                                if (messenger == null && !z) {
                                    arrayList.add(requestInfo2);
                                }
                            } else {
                                continue;
                            }
                        } else {
                            Logger.d("skip single download task");
                        }
                    }
                    z = false;
                    if (requestInfo2._h) {
                    }
                    _csVar = requestInfo2._g;
                    if (_csVar != null) {
                        map = _d7._d;
                        synchronized (map) {
                            _aVar2 = (_d7._a) map.get(requestInfo2);
                            if (_aVar2 == null) {
                                _aVar2 = new _d7._a(requestInfo2._c);
                                map.put(com.kc.aw.lib.utils._a._c(requestInfo2._c), _aVar2);
                            } else {
                                Logger.e("download seed has exist");
                            }
                            synchronized (_aVar2) {
                                _aVar2._b.add(_csVar);
                                messenger = _aVar2._c;
                                requestInfo2._e = messenger;
                                if (messenger == null) {
                                }
                            }
                        }
                    } else {
                        continue;
                    }
                }
                if (!arrayList.isEmpty()) {
                    intent.putParcelableArrayListExtra("service_intent_extra", arrayList);
                    try {
                        context.startService(intent);
                    } catch (Exception unused) {
                    }
                }
                _d7._c.clear();
            }
        }
    }

    public static boolean _a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            _hi._a(context);
            try {
                File file = new File(str);
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setFlags(268435456);
                intent.addFlags(1);
                intent.addFlags(2);
                intent.setDataAndType(FileProvider.getUriForFile(context, context.getPackageName() + ".fileProvider", file), AdBaseConstants.MIME_APK);
                context.startActivity(intent);
                _b.set(true);
                return true;
            } catch (Exception e) {
                _b.set(false);
                Logger.e(e.getMessage());
            }
        }
        return false;
    }
}
