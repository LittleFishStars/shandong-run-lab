package com.byazt.nr;

import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 130})
public final class m {
    public static boolean c = false;
    public static int tt = 4;
    public static String uj = "";
    public static com.byazt.ak.c ve;

    public static void c(com.byazt.ak.c cVar) {
        ve = cVar;
    }

    public static void tt() {
        c = true;
        c(3);
    }

    public static void uj(String str, String str2) {
        com.byazt.ak.c cVar = ve;
        if (cVar != null) {
            cVar.ve(uj(str), str2);
        }
        if (c && str2 != null && tt <= 6) {
            Log.e(uj(str), str2);
        }
    }

    public static boolean ve() {
        return c;
    }

    public static void c(int i) {
        tt = i;
    }

    public static void ve(String str, String str2) {
        com.byazt.ak.c cVar = ve;
        if (cVar != null) {
            cVar.c(uj(str), str2);
        }
        if (str2 == null) {
            return;
        }
        if (str == null) {
            str = "Logger";
        }
        Log.i(uj(str), str2);
    }

    public static boolean c() {
        return tt <= 3;
    }

    public static void tt(String str) {
        if (c) {
            tt("Logger", str);
        }
    }

    public static void c(String str) {
        if (c) {
            c("Logger", str);
        }
    }

    public static void tt(String str, String str2) {
        com.byazt.ak.c cVar = ve;
        if (cVar != null) {
            cVar.tt(uj(str), str2);
        }
        if (c && str2 != null && tt <= 5) {
            Log.w(uj(str), str2);
        }
    }

    public static void ve(String str) {
        if (c) {
            uj("Logger", str);
        }
    }

    public static void c(String str, String str2) {
        com.byazt.ak.c cVar = ve;
        if (cVar != null) {
            cVar.c(uj(str), str2);
        }
        if (c && str2 != null && tt <= 4) {
            Log.i(uj(str), str2);
        }
    }

    public static String uj(String str) {
        if (TextUtils.isEmpty(uj)) {
            return str;
        }
        return c("[" + uj + "]-[" + str + "]");
    }

    public static void ve(String str, String str2, Throwable th) {
        com.byazt.ak.c cVar = ve;
        if (cVar != null) {
            cVar.tt(uj(str), str2, th);
        }
        if (c) {
            if (!(str2 == null && th == null) && tt <= 6) {
                Log.e(uj(str), str2, th);
            }
        }
    }

    public static void tt(String str, String str2, Throwable th) {
        com.byazt.ak.c cVar = ve;
        if (cVar != null) {
            cVar.c(uj(str), str2, th);
        }
        if (c) {
            if (!(str2 == null && th == null) && tt <= 5) {
                Log.w(uj(str), str2, th);
            }
        }
    }

    public static void c(String str, String str2, Throwable th) {
        com.byazt.ak.c cVar = ve;
        if (cVar != null) {
            cVar.c(uj(str), str2 + Log.getStackTraceString(th));
        }
        if (c) {
            if (!(str2 == null && th == null) && tt <= 4) {
                Log.i(uj(str), str2, th);
            }
        }
    }

    public static void ve(String str, Object... objArr) {
        com.byazt.ak.c cVar = ve;
        if (cVar != null) {
            cVar.ve(uj(str), c(objArr));
        }
        if (c && objArr != null && tt <= 6) {
            Log.e(uj(str), c(objArr));
        }
    }

    public static void tt(String str, Object... objArr) {
        com.byazt.ak.c cVar = ve;
        if (cVar != null) {
            cVar.tt(uj(str), c(objArr));
        }
        if (c && objArr != null && tt <= 5) {
            Log.w(uj(str), c(objArr));
        }
    }

    public static void c(String str, Object... objArr) {
        com.byazt.ak.c cVar = ve;
        if (cVar != null) {
            cVar.c(uj(str), c(objArr));
        }
        if (c && objArr != null && tt <= 4) {
            Log.i(uj(str), c(objArr));
        }
    }

    private static String c(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            } else {
                sb.append(" null ");
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void c(Throwable th) {
        tt(uj, "", th);
    }

    public static void c(int i, String str, String str2) {
        c(str, str2);
    }
}
