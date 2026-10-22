package com.kc.aw;

import android.content.Context;
import com.ali.auth.third.login.LoginConstants;
import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _i1 {
    public static final _i1 _c = new _i1();
    public final WeakHashMap _a = new WeakHashMap();
    public final Object _b = new Object();

    public final List<_hw> _a(Context context, String str, AdSlot adSlot) {
        List<_hw> listEmptyList;
        synchronized (this._b) {
            try {
                Map map = (Map) this._a.get(context);
                if (map == null) {
                    map = new HashMap();
                    this._a.put(context, map);
                }
                String str2 = str + LoginConstants.UNDER_LINE + adSlot.getStype() + LoginConstants.UNDER_LINE + adSlot.getCodeId();
                if (str2 != null) {
                    listEmptyList = (List) map.get(str2);
                    if (listEmptyList == null) {
                        listEmptyList = new ArrayList<>();
                        map.put(str2, listEmptyList);
                    }
                } else {
                    listEmptyList = null;
                }
                synchronized (this._b) {
                    if (listEmptyList != null) {
                        Iterator<_hw> it = listEmptyList.iterator();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        while (it.hasNext()) {
                            _hw next = it.next();
                            if (next == null || next._c <= jCurrentTimeMillis) {
                                it.remove();
                            }
                        }
                    }
                }
                if (listEmptyList == null) {
                    listEmptyList = Collections.emptyList();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return listEmptyList;
    }
}
