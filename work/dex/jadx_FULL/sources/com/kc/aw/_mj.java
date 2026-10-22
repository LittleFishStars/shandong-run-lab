package com.kc.aw;

import android.text.TextUtils;
import android.util.Pair;
import com.google.common.base.a;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.model.AppInfo;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class _mj<T> implements _l {
    public static final WeakHashMap<Object, _o> _b = new WeakHashMap<>();
    public static final Pattern _c = Pattern.compile("^[a-zA-Z][0-9a-zA-Z+_\\\\-\\\\.]*:((//[#0-9a-zA-Z;/?:@&=+$\\\\.\\\\-_!~*'()%]+)|([#0-9a-zA-Z;?:@&=+$\\\\.\\\\-_!~*'()%]+[#0-9a-zA-Z/;?:@&=+$\\\\.\\\\-_!~*'()%]*)|(/[#0-9a-zA-Z;?:@&=+$\\\\.\\\\-_!~*'()%]+[#0-9a-zA-Z/;?:@&=+$\\\\.\\\\-_!~*'()%]*))");
    public T _a;

    public _mj(T t) {
        this._a = t;
    }

    /* JADX WARN: Code duplicated, block: B:171:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:189:0x02cf A[SYNTHETIC] */
    /* JADX WARN: Failed to find 'out' block for switch in B:79:0x0134. Please report as an issue. */
    public final _n _a(HashSet hashSet, int i) {
        _o _oVar;
        HashMap map;
        _av _avVar;
        Pair pair_a;
        String str;
        String str2;
        String str3;
        byte b;
        ArrayList arrayList;
        _o _oVar_a = _a();
        if (hashSet.size() > 0 && _oVar_a != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                _av _avVar2 = (_av) it.next();
                if (_avVar2._a()) {
                    ArrayList arrayList2 = _avVar2._a;
                    HashMap map2 = new HashMap();
                    try {
                        Collections.emptyList();
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            String str4 = (String) it2.next();
                            String str5 = "imgList";
                            it2 = it2;
                            it = it;
                            _avVar2 = _avVar2;
                            HashMap map3 = map2;
                            _o _oVar2 = _oVar_a;
                            String str6 = "slotId";
                            switch (str4.hashCode()) {
                                case -1086538152:
                                    str = "source";
                                    str2 = "consumerSlotId";
                                    str3 = "slotType";
                                    b = str4.equals(str3) ? (byte) 3 : (byte) -1;
                                    break;
                                case -899454023:
                                    str = "source";
                                    str2 = "consumerSlotId";
                                    if (str4.equals(str6)) {
                                        b = 2;
                                        str6 = str6;
                                        str3 = "slotType";
                                    } else {
                                        str6 = str6;
                                        str3 = "slotType";
                                    }
                                    break;
                                case -896505829:
                                    str = "source";
                                    if (str4.equals(str)) {
                                        b = 12;
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    }
                                    str2 = "consumerSlotId";
                                    str3 = "slotType";
                                    break;
                                case -841439820:
                                    if (str4.equals("consumerAdId")) {
                                        str = "source";
                                        b = 1;
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    } else {
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    }
                                    break;
                                case -840852400:
                                    if (str4.equals("consumerType")) {
                                        b = 5;
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    } else {
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    }
                                    break;
                                case -794136500:
                                    if (str4.equals("appName")) {
                                        b = 13;
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    } else {
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    }
                                    break;
                                case -645952689:
                                    if (str4.equals("consumerSlotId")) {
                                        b = 4;
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    } else {
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    }
                                    break;
                                case -441921776:
                                    if (str4.equals("appPackageName")) {
                                        b = a.p;
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    } else {
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    }
                                    break;
                                case 2988190:
                                    if (str4.equals("adId")) {
                                        b = 0;
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    } else {
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    }
                                    break;
                                case 3079825:
                                    if (str4.equals("desc")) {
                                        b = 7;
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    } else {
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    }
                                    break;
                                case 110371416:
                                    if (str4.equals("title")) {
                                        b = 6;
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    } else {
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    }
                                    break;
                                case 122999369:
                                    if (str4.equals("landingPageUrl")) {
                                        b = 10;
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    } else {
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    }
                                    break;
                                case 629233382:
                                    if (str4.equals("deeplink")) {
                                        b = 11;
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    } else {
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    }
                                    break;
                                case 940773407:
                                    if (str4.equals("mediaId")) {
                                        b = a.r;
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    } else {
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    }
                                    break;
                                case 1733138150:
                                    if (str4.equals("appDownloadUrl")) {
                                        b = a.q;
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    } else {
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    }
                                    break;
                                case 1916674817:
                                    if (str4.equals("imgList")) {
                                        b = 8;
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    } else {
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    }
                                    break;
                                case 1938508697:
                                    if (str4.equals("industryId")) {
                                        b = 9;
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    } else {
                                        str = "source";
                                        str2 = "consumerSlotId";
                                        str3 = "slotType";
                                    }
                                    break;
                                default:
                                    str = "source";
                                    str2 = "consumerSlotId";
                                    str3 = "slotType";
                                    break;
                            }
                            try {
                                switch (b) {
                                    case 0:
                                        _oVar = _oVar2;
                                        arrayList = new ArrayList();
                                        str5 = "adId";
                                        map = map3;
                                        try {
                                            map.put(str5, arrayList);
                                            map2 = map;
                                            _oVar_a = _oVar;
                                        } catch (Exception e) {
                                            e = e;
                                            e.printStackTrace();
                                            if (!map.isEmpty()) {
                                                _avVar = _avVar2;
                                                pair_a = _kx._a(map, _avVar._c, _oVar, i);
                                                if (pair_a != null) {
                                                    StringBuilder sb_a = _jf._a(" [Filter] Be intercepted ，because the key contains rule ");
                                                    sb_a.append(_avVar._c);
                                                    Logger.e(sb_a.toString());
                                                    return new _n(true, (String) pair_a.first);
                                                }
                                            }
                                            _oVar_a = _oVar;
                                            it = it;
                                        }
                                        break;
                                    case 1:
                                        _oVar = _oVar2;
                                        arrayList = new ArrayList();
                                        String str7 = _oVar._o;
                                        if (str7 != null) {
                                            arrayList.add(str7);
                                        }
                                        str5 = "consumerAdId";
                                        map = map3;
                                        map.put(str5, arrayList);
                                        map2 = map;
                                        _oVar_a = _oVar;
                                        break;
                                    case 2:
                                        _oVar = _oVar2;
                                        arrayList = new ArrayList();
                                        String str8 = _oVar._a;
                                        if (str8 != null) {
                                            arrayList.add(str8);
                                        }
                                        str5 = str6;
                                        map = map3;
                                        map.put(str5, arrayList);
                                        map2 = map;
                                        _oVar_a = _oVar;
                                        break;
                                    case 3:
                                        _oVar = _oVar2;
                                        ArrayList arrayList3 = new ArrayList();
                                        arrayList3.add(String.valueOf(_oVar._b));
                                        str5 = str3;
                                        arrayList = arrayList3;
                                        map = map3;
                                        map.put(str5, arrayList);
                                        map2 = map;
                                        _oVar_a = _oVar;
                                        break;
                                    case 4:
                                        _oVar = _oVar2;
                                        arrayList = new ArrayList();
                                        String str9 = _oVar._c;
                                        if (str9 != null) {
                                            arrayList.add(str9);
                                        }
                                        str5 = str2;
                                        map = map3;
                                        map.put(str5, arrayList);
                                        map2 = map;
                                        _oVar_a = _oVar;
                                        break;
                                    case 5:
                                        _oVar = _oVar2;
                                        arrayList = new ArrayList();
                                        String str10 = _oVar._d;
                                        if (str10 != null) {
                                            arrayList.add(str10);
                                        }
                                        str5 = "consumerType";
                                        map = map3;
                                        map.put(str5, arrayList);
                                        map2 = map;
                                        _oVar_a = _oVar;
                                        break;
                                    case 6:
                                        _oVar = _oVar2;
                                        arrayList = new ArrayList();
                                        String str11 = _oVar._f;
                                        if (str11 != null) {
                                            arrayList.add(str11);
                                        }
                                        str5 = "title";
                                        map = map3;
                                        map.put(str5, arrayList);
                                        map2 = map;
                                        _oVar_a = _oVar;
                                        break;
                                    case 7:
                                        _oVar = _oVar2;
                                        arrayList = new ArrayList();
                                        String str12 = _oVar._g;
                                        if (str12 != null) {
                                            arrayList.add(str12);
                                        }
                                        str5 = "desc";
                                        map = map3;
                                        map.put(str5, arrayList);
                                        map2 = map;
                                        _oVar_a = _oVar;
                                        break;
                                    case 8:
                                        _oVar = _oVar2;
                                        arrayList = new ArrayList();
                                        List<String> list = _oVar._e;
                                        if (list != null && !list.isEmpty()) {
                                            for (String str13 : _oVar._e) {
                                                if (!TextUtils.isEmpty(str13)) {
                                                    arrayList.add(str13);
                                                }
                                            }
                                        }
                                        map = map3;
                                        map.put(str5, arrayList);
                                        map2 = map;
                                        _oVar_a = _oVar;
                                        break;
                                    case 9:
                                        _oVar = _oVar2;
                                        arrayList = new ArrayList();
                                        String str14 = _oVar._n;
                                        if (str14 != null) {
                                            arrayList.add(str14);
                                        }
                                        str5 = "industryId";
                                        map = map3;
                                        map.put(str5, arrayList);
                                        map2 = map;
                                        _oVar_a = _oVar;
                                        break;
                                    case 10:
                                        _oVar = _oVar2;
                                        arrayList = new ArrayList();
                                        String str15 = _oVar._i;
                                        if (str15 != null) {
                                            arrayList.add(str15);
                                        }
                                        str5 = "landingPageUrl";
                                        map = map3;
                                        map.put(str5, arrayList);
                                        map2 = map;
                                        _oVar_a = _oVar;
                                        break;
                                    case 11:
                                        _oVar = _oVar2;
                                        arrayList = new ArrayList();
                                        String str16 = _oVar._j;
                                        if (str16 != null) {
                                            arrayList.add(str16);
                                        }
                                        str5 = "deeplink";
                                        map = map3;
                                        map.put(str5, arrayList);
                                        map2 = map;
                                        _oVar_a = _oVar;
                                        break;
                                    case 12:
                                        _oVar = _oVar2;
                                        arrayList = new ArrayList();
                                        String str17 = _oVar._h;
                                        if (str17 != null) {
                                            arrayList.add(str17);
                                        }
                                        str5 = str;
                                        map = map3;
                                        map.put(str5, arrayList);
                                        map2 = map;
                                        _oVar_a = _oVar;
                                        break;
                                    case 13:
                                        _oVar = _oVar2;
                                        arrayList = new ArrayList();
                                        String str18 = _oVar._k;
                                        if (str18 != null) {
                                            arrayList.add(str18);
                                        }
                                        str5 = "appName";
                                        map = map3;
                                        map.put(str5, arrayList);
                                        map2 = map;
                                        _oVar_a = _oVar;
                                        break;
                                    case 14:
                                        _oVar = _oVar2;
                                        arrayList = new ArrayList();
                                        String str19 = _oVar._m;
                                        if (str19 != null) {
                                            arrayList.add(str19);
                                        }
                                        str5 = "appPackageName";
                                        map = map3;
                                        map.put(str5, arrayList);
                                        map2 = map;
                                        _oVar_a = _oVar;
                                        break;
                                    case 15:
                                        try {
                                            arrayList = new ArrayList();
                                            _oVar = _oVar2;
                                            try {
                                                String str20 = _oVar._l;
                                                if (str20 != null) {
                                                    arrayList.add(str20);
                                                }
                                                str5 = "appDownloadUrl";
                                                map = map3;
                                                map.put(str5, arrayList);
                                                map2 = map;
                                                _oVar_a = _oVar;
                                            } catch (Exception e2) {
                                                e = e2;
                                                map = map3;
                                                e.printStackTrace();
                                                if (!map.isEmpty()) {
                                                    _avVar = _avVar2;
                                                    pair_a = _kx._a(map, _avVar._c, _oVar, i);
                                                    if (pair_a != null) {
                                                        StringBuilder sb_a2 = _jf._a(" [Filter] Be intercepted ，because the key contains rule ");
                                                        sb_a2.append(_avVar._c);
                                                        Logger.e(sb_a2.toString());
                                                        return new _n(true, (String) pair_a.first);
                                                    }
                                                }
                                                _oVar_a = _oVar;
                                                it = it;
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            _oVar = _oVar2;
                                        }
                                        break;
                                    case 16:
                                        arrayList = new ArrayList();
                                        if (PtgAdSdk.getConfig() != null && PtgAdSdk.getConfig()._a != null) {
                                            arrayList.add(PtgAdSdk.getConfig()._a);
                                        }
                                        str5 = "mediaId";
                                        _oVar = _oVar2;
                                        map = map3;
                                        map.put(str5, arrayList);
                                        map2 = map;
                                        _oVar_a = _oVar;
                                        break;
                                    default:
                                        map2 = map3;
                                        _oVar_a = _oVar2;
                                        break;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                map = map3;
                                _oVar = _oVar2;
                            }
                            if (!map.isEmpty()) {
                                _avVar = _avVar2;
                                pair_a = _kx._a(map, _avVar._c, _oVar, i);
                                if (pair_a != null) {
                                    StringBuilder sb_a3 = _jf._a(" [Filter] Be intercepted ，because the key contains rule ");
                                    sb_a3.append(_avVar._c);
                                    Logger.e(sb_a3.toString());
                                    return new _n(true, (String) pair_a.first);
                                }
                            }
                            _oVar_a = _oVar;
                            it = it;
                        }
                        _oVar = _oVar_a;
                        it = it;
                        _avVar2 = _avVar2;
                        map = map2;
                    } catch (Exception e5) {
                        e = e5;
                        _oVar = _oVar_a;
                        it = it;
                        _avVar2 = _avVar2;
                        map = map2;
                    }
                    if (!map.isEmpty()) {
                        _avVar = _avVar2;
                        pair_a = _kx._a(map, _avVar._c, _oVar, i);
                        if (pair_a != null) {
                            StringBuilder sb_a4 = _jf._a(" [Filter] Be intercepted ，because the key contains rule ");
                            sb_a4.append(_avVar._c);
                            Logger.e(sb_a4.toString());
                            return new _n(true, (String) pair_a.first);
                        }
                    }
                    _oVar_a = _oVar;
                    it = it;
                }
            }
        }
        return new _n(false, null);
    }

    public final _o _a() {
        _o _oVar;
        String name;
        String package_name;
        String str;
        String str2;
        _o _oVar2 = null;
        if (this._a == null) {
            return null;
        }
        WeakHashMap<Object, _o> weakHashMap = _b;
        synchronized (weakHashMap) {
            _oVar = weakHashMap.get(this._a);
        }
        if (_oVar != null) {
            return _oVar;
        }
        _ic _icVar = (_ic) this;
        _h _hVar = (_h) this._a;
        try {
            ArrayList arrayList = new ArrayList();
            AppInfo appInfo = _hVar._c;
            if (appInfo != null) {
                name = appInfo.getName() == null ? "" : _hVar._c.getName();
                package_name = _hVar._c.getPackage_name() == null ? "" : _hVar._c.getPackage_name();
                if (_hVar._c.getIcon_url() != null) {
                    _hVar._c.getIcon_url();
                }
            } else {
                name = "";
                package_name = "";
            }
            String str3 = name;
            String str4 = package_name;
            if (_hVar._a == 0) {
                str2 = _hVar._i;
                str = "";
            } else {
                str = _hVar._i;
                str2 = "";
            }
            String str5 = _hVar._d;
            if (str5 == null) {
                str5 = "";
            }
            String str6 = str5;
            _k8 _k8Var_l = _hVar._l();
            if (_k8Var_l != null) {
                arrayList.add(_k8Var_l._a);
            }
            List<_j9> list_h = _hVar._h();
            if (list_h != null) {
                Iterator<_j9> it = list_h.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next()._a);
                }
            }
            String str_e = _hVar._e() == null ? "" : _hVar._e();
            _oVar2 = new _o(_icVar._d.getTrackingData()._h, _hVar._b, _icVar._d.getPtgSlotID(), _icVar._d.getStype(), _icVar._d.getCodeId(), arrayList, _hVar._k() == null ? "" : _hVar._k(), str_e, str, str6, str3, str2, str4);
        } catch (Exception unused) {
        }
        if (_oVar2 != null) {
            WeakHashMap<Object, _o> weakHashMap2 = _b;
            synchronized (weakHashMap2) {
                weakHashMap2.put(this._a, _oVar2);
            }
        }
        return _oVar2;
    }
}
