package com.byazt.zg;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import com.zj.adlib.c49;
import com.zj.adlib.u15;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public enum ve implements n {
    QUESTION("?", 0),
    COLON(u15.f19942b, 0),
    DOUBLE_AMP("&&", 1),
    DOUBLE_BAR("||", 1),
    EQ("==", 2),
    GT(">", 2),
    LT("<", 2),
    LT_EQ("<=", 2),
    GT_EQ(">=", 2),
    NOT_EQ("!=", 2),
    PLUS("+", 3),
    MINUS(c49.f40900a, 3),
    MULTI("*", 4),
    DIVISION(WVNativeCallbackUtil.SEPERATER, 4),
    MOD("%", 4);

    public final int my;
    public final String rh;
    public static final Map<String, ve> m = new HashMap(128);
    public static final Set<ve> nu = new HashSet();

    static {
        for (ve veVar : values()) {
            m.put(veVar.c(), veVar);
            nu.add(veVar);
        }
    }

    ve(String str, int i) {
        this.rh = str;
        this.my = i;
    }

    public static ve c(String str) {
        return m.get(str);
    }

    public int tt() {
        return this.my;
    }

    public static boolean c(n nVar) {
        return nVar instanceof ve;
    }

    public String c() {
        return this.rh;
    }
}
