package com.kc.aw;

import android.text.TextUtils;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.utils.Logger;
import com.kc.aw.lib.utils.TextUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _o1 {
    public static ScheduledFuture<?> _d;
    public static final AtomicBoolean _a = new AtomicBoolean(true);
    public static final AtomicBoolean _b = new AtomicBoolean(false);
    public static final ScheduledExecutorService _c = Executors.newScheduledThreadPool(1);
    public static final CopyOnWriteArraySet _e = new CopyOnWriteArraySet();
    public static final CopyOnWriteArraySet _f = new CopyOnWriteArraySet();
    public static final ConcurrentHashMap<String, String> _g = new ConcurrentHashMap<>(4);

    public static void _a() {
        StringBuilder sb = new StringBuilder();
        for (String str : _f) {
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
                sb.append("@");
            }
        }
        _jw._a(PtgAdSdk.getContext(), "ru_hi_de_li", sb.toString());
    }

    public static boolean _a(boolean z) {
        if (z) {
            long j = PtgAdSdk.getConfig()._v;
            if (j < 1) {
                j = 60;
            }
            long j_a = _jw._a(PtgAdSdk.getContext(), "ru_la_bu_ti");
            if (j_a <= 0) {
                j_a = System.currentTimeMillis();
                _jw._a(PtgAdSdk.getContext(), "ru_la_bu_ti", j_a);
            }
            if (System.currentTimeMillis() - j_a >= j * 60 * 1000) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x005b  */
    public static void _b(boolean z) {
        JSONArray jSONArrayOptJSONArray;
        ArrayList arrayList;
        if (_a.compareAndSet(true, false)) {
            ArrayList arrayList2 = null;
            if (_e.isEmpty()) {
                String str_c = _jw._c(PtgAdSdk.getContext(), "ru_hi_de_to");
                if (TextUtils.isEmpty(str_c)) {
                    arrayList = null;
                } else {
                    StringBuilder sb_a = _jf._a("(?<!\\\\)");
                    sb_a.append(Pattern.quote("@"));
                    String[] strArrSplit = str_c.split(sb_a.toString());
                    if (strArrSplit.length > 0) {
                        arrayList = new ArrayList();
                        for (String str : strArrSplit) {
                            if (!str.isEmpty()) {
                                arrayList.add(str.replace("\\@", "@"));
                            }
                        }
                    } else {
                        arrayList = null;
                    }
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    _e.addAll(arrayList);
                }
            }
            if (_f.isEmpty()) {
                String str_c2 = _jw._c(PtgAdSdk.getContext(), "ru_hi_de_li");
                if (!TextUtils.isEmpty(str_c2)) {
                    StringBuilder sb_a2 = _jf._a("(?<!\\\\)");
                    sb_a2.append(Pattern.quote("@"));
                    String[] strArrSplit2 = str_c2.split(sb_a2.toString());
                    if (strArrSplit2.length > 0) {
                        arrayList2 = new ArrayList();
                        for (String str2 : strArrSplit2) {
                            if (!str2.isEmpty()) {
                                arrayList2.add(str2.replace("\\@", "@"));
                            }
                        }
                    }
                }
                if (TextUtil.isNotEmpty(arrayList2)) {
                    _f.addAll(arrayList2);
                }
            }
        }
        if (z) {
            _e.clear();
            _jw._a(PtgAdSdk.getContext(), "ru_la_bu_ti", System.currentTimeMillis());
        }
        try {
            String str3 = PtgAdSdk.getConfig()._u;
            if (!TextUtils.isEmpty(str3)) {
                JSONArray jSONArray = new JSONArray(str3);
                int iMin = Math.min(jSONArray.length(), 100);
                for (int i = 0; i < iMin; i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    String strOptString = jSONObjectOptJSONObject.optString("tagId");
                    if (!TextUtils.isEmpty(strOptString) && !_e.contains(strOptString) && !_g.containsValue(strOptString) && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(ALPParamConstant.PACKAGENAME)) != null) {
                        int length = jSONArrayOptJSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            String string = jSONArrayOptJSONArray.getString(i2);
                            if (!TextUtils.isEmpty(string)) {
                                _g.put(string, strOptString);
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (PtgAdSdk.getConfig()._w != 2) {
            try {
                if (_b.compareAndSet(false, true)) {
                    ScheduledFuture<?> scheduledFuture = _d;
                    if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                        _d.cancel(false);
                    }
                    if (_g.isEmpty()) {
                        return;
                    }
                    _d = _c.scheduleWithFixedDelay(new _o0(new CopyOnWriteArraySet(), z), 0L, 1000L, TimeUnit.MILLISECONDS);
                    return;
                }
                return;
            } catch (Exception e) {
                StringBuilder sb_a3 = _jf._a("ru_err: ");
                sb_a3.append(e.getMessage());
                Logger.e(sb_a3.toString());
                return;
            }
        }
        ConcurrentHashMap<String, String> concurrentHashMap = _g;
        if (!TextUtil.isEmpty(concurrentHashMap) && _b.compareAndSet(false, true)) {
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            try {
                for (Map.Entry<String, String> entry : concurrentHashMap.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtil.isEmpty(key) && !TextUtil.isEmpty(value)) {
                        _e.add(value);
                        if (_cb._a(PtgAdSdk.getContext(), key)) {
                            copyOnWriteArraySet.add(value);
                        }
                    }
                }
                CopyOnWriteArraySet copyOnWriteArraySet2 = _f;
                copyOnWriteArraySet2.clear();
                copyOnWriteArraySet2.addAll(copyOnWriteArraySet);
                _a();
                StringBuilder sb = new StringBuilder();
                for (String str4 : _e) {
                    if (!TextUtils.isEmpty(str4)) {
                        sb.append(str4);
                        sb.append("@");
                    }
                }
                _jw._a(PtgAdSdk.getContext(), "ru_hi_de_to", sb.toString());
            } catch (Exception unused2) {
            } finally {
                _b.set(false);
                _g.clear();
                copyOnWriteArraySet.clear();
            }
        }
    }
}
