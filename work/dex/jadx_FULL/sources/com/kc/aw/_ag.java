package com.kc.aw;

import android.text.TextUtils;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.Error;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class _ag {
    /* JADX WARN: Code duplicated, block: B:23:0x0046 A[Catch: all -> 0x00c7, TryCatch #0 {, blocks: (B:7:0x0015, B:9:0x0019, B:10:0x001d, B:16:0x0026, B:18:0x0030, B:19:0x0038, B:23:0x0046, B:24:0x004b, B:27:0x0059, B:31:0x007b, B:32:0x008e, B:34:0x0094, B:36:0x00a2, B:37:0x00aa, B:30:0x0077, B:21:0x003d), top: B:52:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x004b A[Catch: all -> 0x00c7, TryCatch #0 {, blocks: (B:7:0x0015, B:9:0x0019, B:10:0x001d, B:16:0x0026, B:18:0x0030, B:19:0x0038, B:23:0x0046, B:24:0x004b, B:27:0x0059, B:31:0x007b, B:32:0x008e, B:34:0x0094, B:36:0x00a2, B:37:0x00aa, B:30:0x0077, B:21:0x003d), top: B:52:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x0057  */
    /* JADX WARN: Code duplicated, block: B:27:0x0059 A[Catch: all -> 0x00c7, TryCatch #0 {, blocks: (B:7:0x0015, B:9:0x0019, B:10:0x001d, B:16:0x0026, B:18:0x0030, B:19:0x0038, B:23:0x0046, B:24:0x004b, B:27:0x0059, B:31:0x007b, B:32:0x008e, B:34:0x0094, B:36:0x00a2, B:37:0x00aa, B:30:0x0077, B:21:0x003d), top: B:52:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0075  */
    /* JADX WARN: Code duplicated, block: B:30:0x0077 A[Catch: all -> 0x00c7, TryCatch #0 {, blocks: (B:7:0x0015, B:9:0x0019, B:10:0x001d, B:16:0x0026, B:18:0x0030, B:19:0x0038, B:23:0x0046, B:24:0x004b, B:27:0x0059, B:31:0x007b, B:32:0x008e, B:34:0x0094, B:36:0x00a2, B:37:0x00aa, B:30:0x0077, B:21:0x003d), top: B:52:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0094 A[Catch: all -> 0x00c7, TryCatch #0 {, blocks: (B:7:0x0015, B:9:0x0019, B:10:0x001d, B:16:0x0026, B:18:0x0030, B:19:0x0038, B:23:0x0046, B:24:0x004b, B:27:0x0059, B:31:0x007b, B:32:0x008e, B:34:0x0094, B:36:0x00a2, B:37:0x00aa, B:30:0x0077, B:21:0x003d), top: B:52:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x008e A[SYNTHETIC] */
    public static _ck _a(_ch _chVar, AdSlot adSlot) {
        Object obj;
        List<_cl> list;
        _cm _cmVar;
        _ck _ckVar;
        Integer num;
        int iIntValue;
        _ck _ckVar_a;
        if (adSlot.getCurrentReqLayer() > 10) {
            return null;
        }
        String ptgSlotID = adSlot.getPtgSlotID();
        int currentReqLayer = adSlot.getCurrentReqLayer();
        synchronized (_chVar._e) {
            _cj _cjVar = _chVar._c;
            if (_cjVar == null) {
                _ckVar_a = _ch._a();
            } else {
                if (currentReqLayer == 0 || currentReqLayer == 1) {
                    obj = _cjVar._a.get(ptgSlotID);
                } else {
                    Map map = (Map) _cjVar._b.get(ptgSlotID);
                    if (map != null) {
                        obj = map.get(Integer.valueOf(currentReqLayer));
                    } else {
                        list = null;
                    }
                    if (list == null) {
                        _ckVar_a = _ch._a();
                    } else {
                        _cmVar = (_cm) _chVar._c._e.get(ptgSlotID);
                        if (_cmVar == null) {
                            _ckVar_a = null;
                        } else {
                            int i = _cmVar._e;
                            boolean z = ((_cj._a) _chVar._c._c.get(ptgSlotID))._a;
                            num = (Integer) _chVar._c._d.get(ptgSlotID);
                            if (num == null) {
                                iIntValue = 0;
                            } else {
                                iIntValue = num.intValue();
                            }
                            _ckVar = new _ck(i, z, iIntValue, ((_cj._a) _chVar._c._c.get(ptgSlotID))._b);
                            for (_cl _clVar : list) {
                                if (_chVar._b._a(_clVar)) {
                                    int i2 = _clVar._e;
                                    _ckVar._c.add(_clVar);
                                }
                            }
                            _ckVar_a = _ckVar;
                        }
                    }
                }
                list = (List) obj;
                if (list == null) {
                    _ckVar_a = _ch._a();
                } else {
                    _cmVar = (_cm) _chVar._c._e.get(ptgSlotID);
                    if (_cmVar == null) {
                        _ckVar_a = null;
                    } else {
                        int i3 = _cmVar._e;
                        boolean z2 = ((_cj._a) _chVar._c._c.get(ptgSlotID))._a;
                        num = (Integer) _chVar._c._d.get(ptgSlotID);
                        if (num == null) {
                            iIntValue = 0;
                        } else {
                            iIntValue = num.intValue();
                        }
                        _ckVar = new _ck(i3, z2, iIntValue, ((_cj._a) _chVar._c._c.get(ptgSlotID))._b);
                        while (r0.hasNext()) {
                            if (_chVar._b._a(_clVar)) {
                                int i4 = _clVar._e;
                                _ckVar._c.add(_clVar);
                            }
                        }
                        _ckVar_a = _ckVar;
                    }
                }
            }
        }
        if (_ckVar_a != null && !_ckVar_a._c.isEmpty()) {
            return _ckVar_a;
        }
        int i_b = _b(_chVar, adSlot);
        if (i_b <= 0) {
            return null;
        }
        adSlot.setNextLayer(i_b);
        return _a(_chVar, adSlot);
    }

    public static _ck _a(_ch _chVar, AdSlot adSlot, Error error) {
        if (TextUtils.isEmpty(adSlot.getPtgSlotID())) {
            Logger.e("ptgSlotId 为空, 请确认AdSlot参数");
            error.onError(new AdErrorImpl(PtgErrorCode.SDK_NULL_COEDID, "ptgSlotId 为空, 请确认AdSlot参数", (Object) null));
            return null;
        }
        _ck _ckVar_a = _a(_chVar, adSlot);
        if (_ckVar_a != null && !_ckVar_a._c.isEmpty()) {
            return _ckVar_a;
        }
        error.onError(new AdErrorImpl(PtgErrorCode.SDK_NULL_PROVIDER, "No provider", (Object) null));
        return null;
    }

    public static int _b(_ch _chVar, AdSlot adSlot) {
        int i;
        Map map;
        String ptgSlotID = adSlot.getPtgSlotID();
        synchronized (_chVar._e) {
            _cj _cjVar = _chVar._c;
            i = 0;
            if (_cjVar != null && (map = (Map) _cjVar._b.get(ptgSlotID)) != null && !map.isEmpty()) {
                for (int currentReqLayer = adSlot.getCurrentReqLayer() + 1; currentReqLayer <= 10; currentReqLayer++) {
                    List list = (List) map.get(Integer.valueOf(currentReqLayer));
                    if (list != null && !list.isEmpty()) {
                        i = currentReqLayer;
                        break;
                    }
                }
            }
        }
        return i;
    }
}
