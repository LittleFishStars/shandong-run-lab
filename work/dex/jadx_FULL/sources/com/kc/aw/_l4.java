package com.kc.aw;

import android.text.TextUtils;
import android.util.Base64;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.model.PtgAdLoadType;
import com.kc.aw.oaid.OaidManager;
import com.kc.aw.provider.PtgApiProvider;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _l4 {

    @Keep
    public final class _a implements _a3 {
        public final AdSlot _a;
        public final _b3 _b;

        public _a(AdSlot adSlot, _b3 _b3Var) {
            this._a = adSlot;
            this._b = _b3Var;
        }

        @Override // com.kc.aw._a3
        public final void _a(String str) {
            _l4._a(this._a, this._b);
        }
    }

    @Keep
    public final class _b implements _eb {
        public final String _a;
        public final _b3 _b;
        public final AdSlot _c;

        public _b(AdSlot adSlot, _b3 _b3Var, String str) {
            this._a = str;
            this._b = _b3Var;
            this._c = adSlot;
        }

        @Override // com.kc.aw._eb
        public final void _a(_ee _eeVar) {
            _l3 _l3Var = _l3._b;
            String str = this._a;
            _l3Var.getClass();
            if (str == null || _eeVar == null) {
                return;
            }
            _l3Var._a.put(str, _eeVar);
        }

        /* JADX WARN: Code duplicated, block: B:38:0x00a4 A[Catch: all -> 0x00c5, TryCatch #0 {all -> 0x00c5, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x0010, B:9:0x001a, B:13:0x0023, B:16:0x0038, B:18:0x003e, B:20:0x0042, B:21:0x0051, B:24:0x0059, B:26:0x0063, B:28:0x0067, B:30:0x0073, B:32:0x007a, B:34:0x0080, B:35:0x0088, B:37:0x0093, B:38:0x00a4, B:39:0x00ac, B:40:0x00b2, B:42:0x00b6, B:7:0x0015), top: B:47:0x0000 }] */
        @Override // com.kc.aw._eb
        public final void _a(_ee _eeVar, int i, String str) {
            _b3 _b3Var;
            AdErrorImpl adErrorImpl;
            String str_a;
            try {
                _l3 _l3Var = _l3._b;
                String str2 = this._a;
                if (str2 != null) {
                    _ee _eeVar2 = (_ee) _l3Var._a.remove(str2);
                    if (_eeVar2 != null) {
                        _eeVar2._h = _h1._a;
                    }
                } else {
                    _l3Var.getClass();
                }
                if (i == 0 || TextUtils.isEmpty(str)) {
                    _b3Var = this._b;
                    if (_b3Var != null) {
                        adErrorImpl = new AdErrorImpl();
                        adErrorImpl._a = 10000;
                        adErrorImpl._b = PtgErrorCode.SDK_NO_AD_1;
                        _b3Var.onError(adErrorImpl);
                    }
                } else {
                    try {
                        str_a = com.kc.aw.lib.utils._a._a(Base64.decode(str.getBytes("UTF-8"), 2), _nj._a());
                    } catch (Exception unused) {
                        str_a = null;
                    }
                    if (TextUtils.isEmpty(str_a)) {
                        _b3Var = this._b;
                        if (_b3Var != null) {
                            adErrorImpl = new AdErrorImpl();
                            adErrorImpl._a = PtgErrorCode.SDK_AD_DATA_ERR;
                            adErrorImpl._b = "解析失败";
                            _b3Var.onError(adErrorImpl);
                        }
                    } else {
                        _z._a _aVar_a = _z._a(this._c, str_a);
                        _b3 _b3Var2 = this._b;
                        if (_b3Var2 != null) {
                            if (!_aVar_a._a) {
                                _b3Var2.onError(_aVar_a._c);
                            } else if (this._c.getBasePrice() > 0) {
                                List<_h> list = _aVar_a._b._a;
                                int i2 = 0;
                                if (list != null && !list.isEmpty()) {
                                    i2 = list.get(0)._l;
                                }
                                if (i2 < this._c.getBasePrice()) {
                                    this._b.onError(new AdErrorImpl(PtgErrorCode.SDK_BELOW_BASE_PRICE, PtgErrorCode.SDK_BELOW_BASE_PRICE_STR, (Object) null));
                                } else {
                                    _l4._a(this._b, this._c, _aVar_a);
                                }
                            } else {
                                _l4._a(this._b, this._c, _aVar_a);
                            }
                        }
                    }
                }
            } finally {
                _eeVar._h = _h1._a;
            }
        }
    }

    @Keep
    public final class _c implements _i4._b {
        public final _z._a _a;

        public _c(_z._a _aVar) {
            this._a = _aVar;
        }

        @Override // com.kc.aw._i4._b
        public final void _a() {
        }

        @Override // com.kc.aw._i4._b
        public final void _b() {
            _q _qVar;
            List<_h> list;
            _h _hVar;
            _z._a _aVar = this._a;
            if (_aVar == null || (_qVar = _aVar._b) == null || (list = _qVar._a) == null || list.isEmpty() || (_hVar = list.get(0)) == null) {
                return;
            }
            _hVar._H = true;
        }
    }

    public static void _a(_b3<_q> _b3Var, AdSlot adSlot, _z._a _aVar) {
        List<_h> list;
        _h _hVar;
        if ((adSlot != null ? adSlot.getAdLoadType() : PtgAdLoadType.UNKNOWN) == PtgAdLoadType.PRELOAD) {
            _i4 _i4Var = _i4._c._a;
            _c _cVar = new _c(_aVar);
            _i4Var.getClass();
            try {
                _q _qVar = _aVar._b;
                _i6 _i6Var = (_qVar == null || (list = _qVar._a) == null || list.isEmpty() || (_hVar = list.get(0)) == null) ? null : _hVar._z;
                if (_i6Var != null) {
                    if (_i6Var._a()) {
                        _k8 _k8Var = _i6Var._f;
                        String str = _k8Var._b;
                        if (TextUtils.isEmpty(str)) {
                            _i4Var._a(_k8Var._a, true, _cVar);
                        } else {
                            _i4Var._a(str, false, _cVar);
                        }
                    } else {
                        List<_j9> list2 = _i6Var._e;
                        if (list2 != null && !list2.isEmpty()) {
                            int size = list2.size();
                            int i = 0;
                            while (i < size) {
                                _i4Var._a(list2.get(i)._a, false, i == 0 ? _cVar : null);
                                i++;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
        _b3Var._a(_aVar._b);
    }

    public static void _a(AdSlot adSlot, _b3<_q> _b3Var) {
        String str = PtgAdSdk.getConfig()._e;
        StringBuilder sb = new StringBuilder(str);
        String vendorId = adSlot.getVendorId();
        if (TextUtils.isEmpty(vendorId) || "0".equals(vendorId)) {
            vendorId = PtgAdSdk.getConfig()._b;
        }
        String str_a = "";
        sb.append(str.contains("?") ? str.endsWith("?") ? "" : "&" : "?");
        sb.append("mid=");
        if (vendorId == null) {
            vendorId = "";
        }
        try {
            vendorId = URLEncoder.encode(vendorId, "UTF-8");
        } catch (Exception unused) {
        }
        sb.append(vendorId);
        sb.append("&mt=1");
        String string = sb.toString();
        LinkedHashMap linkedHashMap_a = _au._a(adSlot);
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : linkedHashMap_a.entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
            str_a = com.kc.aw.lib.utils._a._a(jSONObject.toString(), _nj._a());
        } catch (Exception unused2) {
        }
        int timeoutMs = adSlot.getTimeoutMs();
        StringBuilder sb_a = _jf._a("ad_request_");
        sb_a.append(adSlot.hashCode());
        _b _bVar = new _b(adSlot, _b3Var, sb_a.toString());
        _h1._f _fVar = _h1._a;
        _ee _eeVar = new _ee(string);
        if (!TextUtils.isEmpty(str_a)) {
            _eeVar._e = str_a;
            _eeVar._d = "POST";
        }
        _eeVar._g = timeoutMs;
        _eeVar._h = _bVar;
        _h1._b.offer(_eeVar);
    }

    /* JADX WARN: Code duplicated, block: B:52:0x0108 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x0109  */
    public static void _b(AdSlot adSlot, _b3<_q> _b3Var) {
        AdError adErrorImpl;
        if (TextUtils.isEmpty(adSlot.getCodeId()) && TextUtils.isEmpty(adSlot.getPtgSlotID())) {
            if (_b3Var != null) {
                AdErrorImpl adErrorImpl2 = new AdErrorImpl();
                adErrorImpl2._a = 50000;
                adErrorImpl2._b = PtgErrorCode.APP_SLOT_ERROR();
                adErrorImpl2._c = PtgApiProvider.providerName;
                adErrorImpl2._d = 50000;
                adErrorImpl2._e = PtgErrorCode.APP_SLOT_ERROR();
                _b3Var.onError(adErrorImpl2);
                return;
            }
            return;
        }
        boolean z = true;
        int i = 0;
        if (!(-1 != _h2._b(PtgAdSdk.getContext()))) {
            if (_b3Var != null) {
                AdErrorImpl adErrorImpl3 = new AdErrorImpl();
                adErrorImpl3._a = PtgErrorCode.SDK_NET_ERR;
                adErrorImpl3._b = PtgErrorCode.APP_NETWORK_ERROR();
                adErrorImpl3._c = PtgApiProvider.providerName;
                adErrorImpl3._d = PtgErrorCode.SDK_NET_ERR;
                adErrorImpl3._e = PtgErrorCode.APP_NETWORK_ERROR();
                _b3Var.onError(adErrorImpl3);
                return;
            }
            return;
        }
        try {
            _at bidAdm = adSlot.getBidAdm();
            if (bidAdm != null) {
                String str = bidAdm._b;
                if (!TextUtils.isEmpty(str)) {
                    String str_a = com.kc.aw.lib.utils._a._a(Base64.decode(str, 2), _nj._a());
                    if (!TextUtils.isEmpty(str_a)) {
                        String str2 = bidAdm._c;
                        if (!"__PRICE__".equals(str2)) {
                            str_a = str_a.replaceAll("__PRICE__", com.kc.aw.lib.utils._a._b(str2));
                        }
                        _z._a _aVar_a = _z._a(adSlot, str_a);
                        if (_b3Var != null) {
                            if (_aVar_a._a) {
                                if (adSlot.getBasePrice() > 0) {
                                    List<_h> list = _aVar_a._b._a;
                                    if (list != null && !list.isEmpty()) {
                                        i = list.get(0)._l;
                                    }
                                    if (i < adSlot.getBasePrice()) {
                                        adErrorImpl = new AdErrorImpl(PtgErrorCode.SDK_BELOW_BASE_PRICE, PtgErrorCode.SDK_BELOW_BASE_PRICE_STR, (Object) null);
                                    }
                                }
                                _a(_b3Var, adSlot, _aVar_a);
                            } else {
                                adErrorImpl = _aVar_a._c;
                            }
                            _b3Var.onError(adErrorImpl);
                        }
                    } else if (_b3Var != null) {
                        AdErrorImpl adErrorImpl4 = new AdErrorImpl();
                        adErrorImpl4._a = PtgErrorCode.SDK_AD_DATA_ERR;
                        adErrorImpl4._b = "adm 数据异常！";
                        adErrorImpl = adErrorImpl4;
                        _b3Var.onError(adErrorImpl);
                    }
                }
                if (z) {
                    return;
                }
                if (adSlot.getDeviceInfo() == null && TextUtils.isEmpty(adSlot.getDeviceInfo()._a)) {
                    OaidManager.getOaidAsync(PtgAdSdk.getContext(), new _a(adSlot, _b3Var));
                    return;
                } else {
                    _a(adSlot, _b3Var);
                }
            }
            z = false;
        } catch (Exception unused) {
            if (_b3Var != null) {
                AdErrorImpl adErrorImpl5 = new AdErrorImpl();
                adErrorImpl5._a = PtgErrorCode.SDK_AD_DATA_ERR;
                adErrorImpl5._b = "adm 数据异常！";
                _b3Var.onError(adErrorImpl5);
            }
        }
        if (z) {
            return;
        }
        if (adSlot.getDeviceInfo() == null) {
        }
        _a(adSlot, _b3Var);
    }
}
