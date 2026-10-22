package com.kc.aw;

import android.util.Pair;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _kx {
    public static final ConcurrentHashMap _a = new ConcurrentHashMap();
    public static final _b _b = new _b(TimeUnit.SECONDS, new ArrayBlockingQueue(30), new _a(), new ThreadPoolExecutor.DiscardOldestPolicy());

    @Keep
    public final class _a implements ThreadFactory {
        public final AtomicInteger _a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            StringBuilder sb_a = _jf._a("ClassRegular-");
            sb_a.append(this._a.getAndIncrement());
            Thread thread = new Thread(runnable, sb_a.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    @Keep
    public final class _b extends ThreadPoolExecutor {
        public _b(TimeUnit timeUnit, ArrayBlockingQueue arrayBlockingQueue, _a _aVar, ThreadPoolExecutor.DiscardOldestPolicy discardOldestPolicy) {
            super(4, 8, 30L, timeUnit, arrayBlockingQueue, _aVar, discardOldestPolicy);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public final void beforeExecute(Thread thread, Runnable runnable) {
            super.beforeExecute(thread, runnable);
            allowCoreThreadTimeOut(true);
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00ac  */
    public static Pair _a(HashMap map, String str, _o _oVar, int i) {
        String strGroup;
        Matcher matcher;
        Pattern patternCompile;
        for (Map.Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            List<String> list = (List) entry.getValue();
            if (list != null) {
                for (String str3 : list) {
                    if (str == null || str.isEmpty() || str3 == null || str3.isEmpty()) {
                        strGroup = "";
                    } else {
                        try {
                            String str_c = com.kc.aw.lib.utils._a._c(str);
                            ConcurrentHashMap concurrentHashMap = _a;
                            Pattern pattern = (Pattern) concurrentHashMap.get(str_c);
                            if (pattern == null) {
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                try {
                                    String str_c2 = com.kc.aw.lib.utils._a._c(str);
                                    if (concurrentHashMap.containsKey(str_c2)) {
                                        pattern = null;
                                    } else {
                                        patternCompile = Pattern.compile(str);
                                        if (patternCompile != null) {
                                            try {
                                                concurrentHashMap.put(str_c2, patternCompile);
                                            } catch (Exception e) {
                                                e = e;
                                                e.printStackTrace();
                                            }
                                        }
                                        pattern = patternCompile;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    patternCompile = null;
                                }
                                Logger.e("miss Pattern, cost parse rule time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                            }
                            if (pattern == null || (matcher = pattern.matcher(str3)) == null || !matcher.find()) {
                                strGroup = "";
                            } else {
                                strGroup = matcher.group(1);
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            Logger.e(e3.getMessage());
                        }
                    }
                    if (strGroup != null && strGroup.length() > 0) {
                        if (2 == i) {
                            _oVar._q = str2;
                            _oVar._r = strGroup;
                        } else if (1 == i) {
                            _oVar._s = strGroup;
                        }
                        return new Pair(str2, list);
                    }
                }
            }
        }
        return null;
    }
}
