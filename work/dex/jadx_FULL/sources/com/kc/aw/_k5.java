package com.kc.aw;

import android.text.TextUtils;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _k5 {
    public static void _a(_h _hVar, List<String> list) {
        if (_hVar == null || list == null || list.isEmpty()) {
            return;
        }
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(_hVar._p)) {
            map.put("User-Agent", _hVar._p);
            map.put("Referer", "");
        }
        _h1._a(list, (HashMap<String, String>) map);
        Logger.d("PtgAdTrackManager", "AdTrackManager do videoImp ", list);
    }
}
