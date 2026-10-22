package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _kb {
    public final HashMap _a = new HashMap();

    public final void _a(_h _hVar, long j) {
        Map<String, List<String>> map;
        Boolean bool;
        List<String> list;
        List<String> list2;
        Map<String, List<String>> map2;
        if (j == -1) {
            if (_hVar != null && (map2 = _hVar._h) != null && !map2.isEmpty()) {
                String str = (String) Collections.max(new ArrayList(map2.keySet()), new _ka());
                Boolean bool2 = (Boolean) this._a.get(str);
                if (bool2 == null || !bool2.booleanValue()) {
                    this._a.put(String.valueOf(str), Boolean.TRUE);
                    list = map2.get(str);
                    list2 = list;
                }
            }
            list2 = null;
        } else {
            String strValueOf = String.valueOf(Integer.parseInt(String.valueOf(j / 1000)));
            if (_hVar == null || (map = _hVar._h) == null || map.isEmpty() || ((bool = (Boolean) this._a.get(strValueOf)) != null && bool.booleanValue())) {
                list2 = null;
            } else {
                this._a.put(strValueOf, Boolean.TRUE);
                list = map.get(strValueOf);
                list2 = list;
            }
        }
        _k5._a(_hVar, list2);
    }
}
