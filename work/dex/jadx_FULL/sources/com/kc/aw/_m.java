package com.kc.aw;

import android.text.TextUtils;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.u15;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _m {
    /* JADX WARN: Code duplicated, block: B:101:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:155:0x01ba A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:160:0x0104 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:96:0x019a  */
    /* JADX WARN: Code duplicated, block: B:98:0x01a2  */
    public static boolean _a(_l _lVar, _nr _nrVar) {
        _mj _mjVar;
        _o _oVar_a;
        _ch _chVar;
        boolean z;
        HashSet hashSet;
        HashSet hashSet2;
        boolean z2;
        boolean zFind;
        StringBuilder sb;
        String str;
        boolean z3;
        if (_lVar == null || (_oVar_a = (_mjVar = (_mj) _lVar)._a()) == null) {
            return true;
        }
        String str2 = _oVar_a._a;
        String str3 = _oVar_a._c;
        String str4 = _oVar_a._d;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || (_chVar = _i2._f._b) == null) {
            return true;
        }
        _cj _cjVar = _chVar._c;
        List<_cl> listEmptyList = _cjVar == null ? null : (List) _cjVar._a.get(str2);
        if (listEmptyList == null) {
            listEmptyList = Collections.emptyList();
        }
        for (_cl _clVar : listEmptyList) {
            if (_clVar != null && str4.equals(_clVar._c) && str3.equals(_clVar._Q)) {
                HashSet hashSet3 = _clVar._N;
                HashSet hashSet4 = _clVar._O;
                if (hashSet3 == null || hashSet3.isEmpty()) {
                    z = true;
                } else {
                    _o _oVar_a2 = _mjVar._a();
                    if (hashSet3.size() <= 0 || _oVar_a2 == null) {
                        z3 = false;
                        break;
                    }
                    Iterator it = hashSet3.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z3 = false;
                            break;
                        }
                        String str5 = (String) it.next();
                        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(_oVar_a2._m) && str5.equalsIgnoreCase(_oVar_a2._m)) {
                            StringBuilder sb_a = _jf._a(" [Filter] Be intercepted ，because the packageName is ");
                            sb_a.append(_oVar_a2._m);
                            Logger.e(sb_a.toString());
                            z3 = true;
                            break;
                        }
                    }
                    if (z3) {
                        Logger.e("ad（" + str4 + u15.f19942b + str3 + ") is intercepted [app black list]");
                        _nrVar._t._g(2);
                        _nrVar._t._h("blackAppList");
                        z = false;
                    } else {
                        z = true;
                    }
                }
                if (z && hashSet4 != null && !hashSet4.isEmpty()) {
                    _o _oVar_a3 = _mjVar._a();
                    if (hashSet4.size() <= 0 || _oVar_a3 == null) {
                        z2 = false;
                    } else {
                        Iterator it2 = hashSet4.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                String str6 = (String) it2.next();
                                if (!TextUtils.isEmpty(str6)) {
                                    if (!TextUtils.isEmpty(_oVar_a3._f) && _oVar_a3._f.contains(str6)) {
                                        sb = new StringBuilder();
                                        str = " [Filter] Be intercepted ，because the title contains keywords ";
                                    } else if (TextUtils.isEmpty(_oVar_a3._g) || !_oVar_a3._g.contains(str6)) {
                                        try {
                                            zFind = _mj._c.matcher(str6).find();
                                        } catch (Exception unused) {
                                            zFind = false;
                                        }
                                        if (zFind) {
                                            List<String> list = _oVar_a3._e;
                                            if (list != null && !list.isEmpty()) {
                                                Iterator<String> it3 = _oVar_a3._e.iterator();
                                                while (true) {
                                                    if (it3.hasNext()) {
                                                        String next = it3.next();
                                                        if (next != null && TextUtils.equals(next, str6)) {
                                                            sb = new StringBuilder();
                                                            str = " [Filter] Be intercepted ，because the image url contains keywords ";
                                                        }
                                                    } else if (!TextUtils.isEmpty(_oVar_a3._j)) {
                                                        if (!TextUtils.isEmpty(_oVar_a3._i)) {
                                                            if (TextUtils.isEmpty(_oVar_a3._l)) {
                                                                continue;
                                                            }
                                                        } else if (TextUtils.isEmpty(_oVar_a3._l)) {
                                                            continue;
                                                        }
                                                    } else if (!TextUtils.isEmpty(_oVar_a3._i)) {
                                                        if (TextUtils.isEmpty(_oVar_a3._l)) {
                                                            continue;
                                                        }
                                                    } else if (TextUtils.isEmpty(_oVar_a3._l)) {
                                                        continue;
                                                    }
                                                }
                                            } else if (!TextUtils.isEmpty(_oVar_a3._j) && _oVar_a3._j.contains(str6)) {
                                                sb = new StringBuilder();
                                                str = " [Filter] Be intercepted ，because the deep link contains keywords ";
                                            } else if (!TextUtils.isEmpty(_oVar_a3._i) && _oVar_a3._i.contains(str6)) {
                                                sb = new StringBuilder();
                                                str = " [Filter] Be intercepted ，because the page url contains keywords ";
                                            } else if (TextUtils.isEmpty(_oVar_a3._l) && _oVar_a3._l.contains(str6)) {
                                                sb = new StringBuilder();
                                                str = " [Filter] Be intercepted ，because the download url contains keywords ";
                                            }
                                        } else {
                                            continue;
                                        }
                                    } else {
                                        sb = new StringBuilder();
                                        str = " [Filter] Be intercepted ，because the description contains keywords ";
                                    }
                                    sb.append(str);
                                    sb.append(str6);
                                    Logger.e(sb.toString());
                                    z2 = true;
                                }
                            } else {
                                z2 = false;
                            }
                        }
                    }
                    if (z2) {
                        Logger.e("ad（" + str4 + u15.f19942b + str3 + ") is intercepted [keyword black list]");
                        _nrVar._t._g(2);
                        _nrVar._t._h("blackKeywordList");
                        z = false;
                    }
                }
                if (z && (hashSet2 = _clVar._L) != null && !hashSet2.isEmpty()) {
                    _n _nVar_a = _mjVar._a(hashSet2, 1);
                    if (_nVar_a._a) {
                        Logger.e("ad（" + str4 + u15.f19942b + str3 + ") is intercepted [app white list]");
                        _nrVar._t._g(1);
                        _nrVar._t._h(_nVar_a._b);
                        return true;
                    }
                }
                if (z && (hashSet = _clVar._M) != null && !hashSet.isEmpty()) {
                    _n _nVar_a2 = _mjVar._a(hashSet, 2);
                    if (_nVar_a2._a) {
                        Logger.e("ad（" + str4 + u15.f19942b + str3 + ") is intercepted [app block packet list]");
                        _nrVar._t._g(2);
                        _nrVar._t._h(_nVar_a2._b);
                        return false;
                    }
                }
                return z;
            }
        }
        return true;
    }
}
