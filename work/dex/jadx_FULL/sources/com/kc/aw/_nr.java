package com.kc.aw;

import android.text.TextUtils;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.Error;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _nr {
    public String _a;
    public String _b;
    public String _c;
    public _c9 _d;
    public _a6 _e;
    public int _f;
    public String _g;
    public String _h;
    public String _i;
    public String _j;
    public String _k;
    public String _l;
    public String _m;
    public String _n;
    public int _q;
    public String _r;
    public long _o = 0;
    public boolean _p = true;
    public HashMap _s = new HashMap();
    public _nq _t = new _nq(0);

    public _nr(_c9 _c9Var) {
        this._d = _c9Var;
    }

    public _nr(String str, String str2, AdSlot adSlot) {
        String str_a = "";
        String ptgSlotID = adSlot == null ? "" : adSlot.getPtgSlotID();
        long randomTime = adSlot != null ? adSlot.getRandomTime() : 0L;
        int randomToken = adSlot != null ? adSlot.getRandomToken() : 0;
        _c9 deviceInfo = adSlot == null ? null : adSlot.getDeviceInfo();
        if (adSlot != null && adSlot.getBidAdm() != null) {
            str_a = adSlot.getBidAdm()._a();
        }
        this._b = str2;
        this._r = str;
        this._a = ptgSlotID;
        this._d = deviceInfo;
        if (TextUtils.isEmpty(str_a)) {
            this._h = _a(randomToken, randomTime, this._a);
        } else {
            this._h = str_a;
        }
    }

    public static String _a(int i, long j, String str) {
        return String.format("%s-%d-%d", str, Long.valueOf(j), Integer.valueOf(i));
    }

    public static String _a(String str) {
        if (str != null) {
            try {
                byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes());
                StringBuilder sb = new StringBuilder(40);
                for (byte b : bArrDigest) {
                    int i = b & 255;
                    if ((i >> 4) == 0) {
                        sb.append("0");
                    }
                    sb.append(Integer.toHexString(i));
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public final String _a() {
        int i;
        _nq _nqVar = this._t;
        if (_nqVar == null) {
            return "0";
        }
        try {
            i = Integer.parseInt(_nqVar._a("consumerPrice"));
        } catch (Exception unused) {
            i = 0;
        }
        return String.valueOf(i);
    }

    public final void _a(int i) {
        this._q = i;
        this._t._a(i);
    }

    public final void _a(AdError adError) {
        this._f = adError.getErrorCode();
        this._g = adError.getMessage();
        this._t._e(adError.getErrorCode());
        this._t._g(adError.getMessage());
        if (adError instanceof AdErrorImpl) {
            _nq _nqVar = this._t;
            StringBuilder sb = new StringBuilder();
            AdErrorImpl adErrorImpl = (AdErrorImpl) adError;
            sb.append(adErrorImpl.getConsumerErrCode());
            sb.append("（");
            sb.append(adErrorImpl.getConsumerErrMsg());
            sb.append("）");
            String string = sb.toString();
            _nqVar.getClass();
            try {
                synchronized (_nqVar._a) {
                    _nqVar._a.put("customerErrorMessage", string);
                }
            } catch (Exception e) {
                Error error = _nqVar._b;
                if (error != null) {
                    error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
                }
            }
        }
    }

    public final String _b() {
        synchronized (this._s) {
            if (TextUtils.isEmpty("iReportM")) {
                return "";
            }
            return (String) this._s.get("iReportM");
        }
    }

    public final _nq _c() {
        this._e = _cc._a();
        _nq _nqVar = this._t;
        _nqVar._j(PtgAdSdk.getConfig()._g);
        _c9 _c9Var = this._d;
        if (_c9Var != null) {
            this._m = _c9Var._q;
            this._i = _a(_c9Var._c);
            _c9 _c9Var2 = this._d;
            this._k = _c9Var2._d;
            this._j = _a(_c9Var2._e);
            _dz _dzVar = this._d._m;
            this._n = _dzVar != null ? _dzVar.toString() : null;
            _c9 _c9Var3 = this._d;
            this._l = _c9Var3._a;
            _nqVar._b(_c9Var3._s);
            _nqVar._c(this._d._r);
            this._d.getClass();
            _nqVar._k(PtgAdSdk.getConfig().getSdkVersionCode());
            this._d.getClass();
            _nqVar._l(PtgAdSdk.getConfig().getSdkVersionName());
        }
        if ("inAppClick".equals(this._c)) {
            boolean z = Boolean.parseBoolean(_b());
            try {
                synchronized (_nqVar._a) {
                    _nqVar._a.put("iReportM", z);
                }
            } catch (Exception e) {
                Error error = _nqVar._b;
                if (error != null) {
                    error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
                }
            }
        }
        return _nqVar;
    }

    public final void _d() {
        this._f = 0;
        this._t._e(0);
    }
}
