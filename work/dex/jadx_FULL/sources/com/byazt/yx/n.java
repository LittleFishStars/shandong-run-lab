package com.byazt.yx;

import com.byazt.eg.h;
import com.byazt.eg.my;
import com.byazt.eg.rh;
import com.byazt.eg.u;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.common.net.b;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, 46})
public final class n {
    public static final Pattern c = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    public static long c(h hVar) {
        return c(hVar.sp());
    }

    public static Set<String> tt(rh rhVar) {
        Set<String> setEmptySet = Collections.emptySet();
        int iC = rhVar.c();
        for (int i = 0; i < iC; i++) {
            if (b.K0.equalsIgnoreCase(rhVar.c(i))) {
                String strTt = rhVar.tt(i);
                if (setEmptySet.isEmpty()) {
                    setEmptySet = new TreeSet<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : strTt.split(",")) {
                    setEmptySet.add(str.trim());
                }
            }
        }
        return setEmptySet;
    }

    public static boolean ve(h hVar) {
        if (hVar.c().tt().equals(com.ipd.dsp.internal.g0.c.f38307a)) {
            return false;
        }
        int iVe = hVar.ve();
        return (((iVe >= 100 && iVe < 200) || iVe == 204 || iVe == 304) && c(hVar) == -1 && !com.ipd.dsp.internal.g0.c.k.equalsIgnoreCase(hVar.c("Transfer-Encoding"))) ? false : true;
    }

    public static long c(rh rhVar) {
        return c(rhVar.c("Content-Length"));
    }

    private static long c(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static rh c(rh rhVar, rh rhVar2) {
        Set<String> setTt = tt(rhVar2);
        if (setTt.isEmpty()) {
            return new rh.c().c();
        }
        rh.c cVar = new rh.c();
        int iC = rhVar.c();
        for (int i = 0; i < iC; i++) {
            String strC = rhVar.c(i);
            if (setTt.contains(strC)) {
                cVar.c(strC, rhVar.tt(i));
            }
        }
        return cVar.c();
    }

    public static rh tt(h hVar) {
        return c(hVar.da().c().ve(), hVar.sp());
    }

    public static void c(u uVar, my myVar, rh rhVar) {
        if (uVar == u.c) {
            return;
        }
        com.byazt.eg.t.c(myVar, rhVar).isEmpty();
    }

    public static int tt(String str, int i) {
        try {
            long j = Long.parseLong(str);
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j < 0) {
                return 0;
            }
            return (int) j;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static int c(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int c(String str, int i) {
        char cCharAt;
        while (i < str.length() && ((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\t')) {
            i++;
        }
        return i;
    }
}
