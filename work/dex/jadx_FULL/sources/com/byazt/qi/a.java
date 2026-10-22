package com.byazt.qi;

import android.app.Application;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import com.byakv.z.SoftDecTool;
import com.byazt.nr.m;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.coremedia.iso.boxes.TimeToSampleBox;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 527, 34})
public class a {
    public static String c;
    public static sp sl;
    public static AtomicBoolean tt = new AtomicBoolean(false);
    public static final AtomicBoolean ve = new AtomicBoolean(false);
    public static final AtomicBoolean uj = new AtomicBoolean(false);
    public static String n = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f28976a = 0;
    public static int sp = 0;
    public static tt x = null;
    public static volatile DisplayManager.DisplayListener i = null;
    public static volatile boolean da = false;
    public static final AtomicBoolean t = new AtomicBoolean(false);

    public static x a() {
        sp spVar = sl;
        if (spVar != null) {
            return spVar.uj();
        }
        return null;
    }

    public static String n() {
        sp spVar = sl;
        if (spVar != null) {
            return spVar.tt();
        }
        return null;
    }

    public static long sp() {
        return f28976a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public static void tt(Handler handler) {
        if (!i.tt() || da || ve() == null) {
            return;
        }
        da = true;
        if (i == null) {
            i = new DisplayManager.DisplayListener() { // from class: com.byazt.qi.a.2
                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayAdded(int i2) {
                    if (i2 != 0) {
                        try {
                            a.c(1003, new Object[]{Integer.valueOf(i2), a.ve()});
                        } catch (Throwable th) {
                            m.c(th);
                        }
                    }
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayChanged(int i2) {
                    if (i2 != 0) {
                        try {
                            a.c(1005, new Object[]{Integer.valueOf(i2), a.ve()});
                        } catch (Throwable th) {
                            m.c(th);
                        }
                    }
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayRemoved(int i2) {
                    if (i2 != 0) {
                        try {
                            a.c(1004, new Object[]{Integer.valueOf(i2), a.ve()});
                        } catch (Throwable th) {
                            m.c(th);
                        }
                    }
                }
            };
        }
        ((DisplayManager) ve().getSystemService("display")).registerDisplayListener(i, handler);
    }

    public static boolean uj() {
        sp spVar = sl;
        if (spVar != null) {
            return spVar.ve();
        }
        return false;
    }

    public static Context ve() {
        sp spVar = sl;
        if (spVar != null) {
            return spVar.c();
        }
        return null;
    }

    public static int x() {
        return sp;
    }

    public static void c(sp spVar) {
        sl = spVar;
    }

    public static void c() {
        try {
            Context contextVe = ve();
            if (!uj() || ve.getAndSet(true) || contextVe == null) {
                return;
            }
            if (x != null) {
                tt.c((Application) contextVe).tt((Application) contextVe);
                x = null;
            }
            if (i != null) {
                ((DisplayManager) contextVe.getSystemService("display")).unregisterDisplayListener(i);
                da = false;
                i = null;
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public static String tt(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TimeToSampleBox.TYPE, 3);
            jSONObject.put("exception:", th.toString());
            jSONObject.put("stacktrace:", Arrays.toString(th.getStackTrace()));
            jSONObject.put("cause:", String.valueOf(th.getCause()));
            n = Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 0);
        } catch (Throwable th2) {
            m.c(th2);
            n = "eyJzdHRzIjozfQ==";
        }
        return n;
    }

    public static String tt() {
        if (c == null) {
            Object objC = c(1011, new Object[0]);
            if (objC instanceof String) {
                c = (String) objC;
            }
        }
        String str = c;
        return str != null ? str : "";
    }

    @DungeonFlag
    public static String c(final long j) {
        if (i.tt() && sl != null) {
            final Handler handlerC = com.byazt.nr.da.c();
            final x xVarA = a();
            AtomicBoolean atomicBoolean = t;
            if (atomicBoolean.get()) {
                if (TextUtils.isEmpty(n)) {
                    String strGc = SoftDecTool.gc();
                    if (!TextUtils.isEmpty(strGc)) {
                        n = strGc;
                    }
                }
                return TextUtils.isEmpty(n) ? "eyJzdHRzIjoxfQ==" : n;
            }
            atomicBoolean.set(true);
            handlerC.post(new Runnable() { // from class: com.byazt.qi.a.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObjectT;
                    try {
                        if (!a.ve.get()) {
                            tt unused = a.x = tt.c((Application) a.sl.c());
                            a.tt(handlerC);
                        }
                        n.c(a.sl.c());
                        if (SoftDecTool.acs == -1.0d) {
                            SoftDecTool.ua();
                        }
                        AtomicLong atomicLong = new AtomicLong(j);
                        if (xVarA != null && !a.uj.getAndSet(true)) {
                            atomicLong.set(xVarA.c());
                        }
                        Object objC = a.c(1001, new Object[]{a.sl.c(), Long.valueOf(atomicLong.get())});
                        if (objC instanceof String) {
                            String unused2 = a.n = (String) objC;
                        }
                        if (xVarA != null && !a.tt.getAndSet(true)) {
                            JSONObject jSONObjectC = com.byazt.ig.c.c().c(a.sl.c(), a.sl.tt());
                            if (jSONObjectC != null && jSONObjectC.length() > 0) {
                                xVarA.c("detailed_app_info", jSONObjectC);
                            }
                            a.tt.set(false);
                        }
                        if (xVarA != null && (jSONObjectT = SoftDecTool.t()) != null && jSONObjectT.length() > 0) {
                            xVarA.c("tc_info", jSONObjectT);
                        }
                    } catch (Throwable th) {
                        try {
                            String unused3 = a.n = a.tt(th);
                        } finally {
                            a.t.set(false);
                        }
                    }
                }
            });
        }
        if (TextUtils.isEmpty(n)) {
            String strGc2 = SoftDecTool.gc();
            if (!TextUtils.isEmpty(strGc2)) {
                n = strGc2;
            }
        }
        return TextUtils.isEmpty(n) ? "eyJzdHRzIjoxfQ==" : n;
    }

    @DungeonFlag
    public static Object c(int i2, Object[] objArr) {
        return SoftDecTool.cn(i2, objArr);
    }

    @DungeonFlag
    public static void c(final MotionEvent motionEvent) {
        if (motionEvent == null || !i.tt() || ve() == null) {
            return;
        }
        if (motionEvent.getRawX() > 0.0f || motionEvent.getRawY() > 0.0f) {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.qi.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.c(1002, new Object[]{Integer.valueOf(motionEvent.getDeviceId()), a.ve()});
                }
            });
        }
    }

    @DungeonFlag
    public static void c(long j, int i2) {
        f28976a = j;
        sp = i2;
    }

    public static String c(String str, long j, int i2, boolean z) {
        try {
            tt ttVar = x;
            if (ttVar != null) {
                return ttVar.c(str, j, i2, z);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c(String str, String str2) {
        Object objC = c(1010, new String[]{str, str2});
        return objC instanceof String ? (String) objC : str2;
    }
}
