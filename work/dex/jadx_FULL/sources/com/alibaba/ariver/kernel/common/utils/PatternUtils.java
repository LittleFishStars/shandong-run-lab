package com.alibaba.ariver.kernel.common.utils;

import android.util.LruCache;
import androidx.annotation.Nullable;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PatternUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24281a = "PatternUtils";
    private static final boolean b = RVKernelUtils.isDebug();
    private static LruCache<String, Pattern> c = new LruCache<>(20);

    @Nullable
    public static Pattern compile(String str) {
        if (str == null) {
            return null;
        }
        Pattern pattern = c.get(str);
        if (pattern != null) {
            if (b) {
                RVLogger.d(f24281a, "pattern cache hit: " + str);
            }
            return pattern;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Pattern patternCompile = Pattern.compile(str);
            c.put(str, patternCompile);
            if (b) {
                RVLogger.d(f24281a, "pattern cache miss, use time: " + (System.currentTimeMillis() - jCurrentTimeMillis) + " " + str);
            }
            return patternCompile;
        } catch (PatternSyntaxException e) {
            RVLogger.e(f24281a, "pattern " + str + " compile error!", e);
            return null;
        }
    }

    public static boolean matchRegex(String str, String str2) {
        Pattern patternCompile;
        if (str == null || str2 == null || (patternCompile = compile(str)) == null) {
            return false;
        }
        return patternCompile.matcher(str2).matches();
    }
}
