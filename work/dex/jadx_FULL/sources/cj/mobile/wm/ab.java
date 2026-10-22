package cj.mobile.wm;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.kc.openset.constant.DeviceIdType;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ab {
    public static int dex01 = 0;
    public static int dex02 = 0;
    public static int dex03 = 0;
    public static Context dexb = null;
    public static Object dexc = new Object();
    public static boolean dexd = false;
    public static bb dexe;
    public static bb dexf;
    public static bb dexg;
    public static HandlerThread dexh;
    public static Handler dexi;
    public static String dexj;
    public static String dexk;
    public static String dexl;
    public static String dexm;
    public static String dexn;
    public static String dexo;
    public static volatile ab dexp;
    public static volatile za dexq;
    public static int dexr;
    public static int dexs;
    public static int dext;
    public static int dexu;
    public static int dexv;
    public static int dexw;
    public static int dexx;
    public static int dexy;
    public static int dexz;
    public final int dexa = dexc(dexb);

    public class dexa implements Runnable {
        public dexa() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ab.dexr + ab.dexs + ab.dexx + ab.dex01 + ab.dext + ab.dexu + ab.dexz + ab.dex01 + ab.dexv + ab.dexw + ab.dex02 + ab.dex03 > 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DeviceIdType.OAID, ab.this.dexa(ab.dexr, ab.dexs, ab.dexx, ab.dexy));
                contentValues.put("vaid", ab.this.dexa(ab.dext, ab.dexu, ab.dexz, ab.dex01));
                contentValues.put("aaid", ab.this.dexa(ab.dexv, ab.dexw, ab.dex02, ab.dex03));
                ab.dexq.dexa(7, "vivo", new ContentValues[]{contentValues});
                int unused = ab.dexr = ab.dexs = ab.dext = ab.dexu = ab.dexv = ab.dexw = 0;
                int unused2 = ab.dexx = ab.dexy = ab.dexz = ab.dex01 = ab.dex02 = ab.dex03 = 0;
            }
        }
    }

    public static class dexb extends Handler {
        public dexb(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Code duplicated, block: B:49:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            int i;
            String str2;
            String str3;
            if (message.what != 11) {
                Log.e("VMS_SDK_Client", "message type valid");
                return;
            }
            int i2 = message.getData().getInt("type");
            try {
                String strDexa = ab.dexq.dexa(i2, message.getData().getString("appid"));
                if (i2 == 0) {
                    String unused = ab.dexj = strDexa;
                    str = ab.dexj;
                    i = 8;
                } else {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            if (strDexa != null) {
                                String unused2 = ab.dexl = strDexa;
                            } else {
                                Log.e("VMS_SDK_Client", "get aaid failed");
                            }
                            str = ab.dexl;
                            i = 10;
                        } else if (i2 != 3) {
                            if (i2 == 4) {
                                String unused3 = ab.dexn = strDexa;
                            } else if (i2 == 5) {
                                if (strDexa != null) {
                                    String unused4 = ab.dexo = strDexa;
                                } else {
                                    str2 = "VMS_SDK_Client";
                                    str3 = "get guid failed";
                                    Log.e(str2, str3);
                                }
                            }
                        } else if (strDexa != null) {
                            String unused5 = ab.dexm = strDexa;
                        } else {
                            str2 = "VMS_SDK_Client";
                            str3 = "get udid failed";
                            Log.e(str2, str3);
                        }
                        synchronized (ab.dexc) {
                            ab.dexc.notify();
                        }
                    }
                    if (strDexa != null) {
                        String unused6 = ab.dexk = strDexa;
                    } else {
                        Log.e("VMS_SDK_Client", "get vaid failed");
                    }
                    str = ab.dexk;
                    i = 9;
                }
                ab.dexc(i, str);
            } catch (Exception e) {
                Log.e("VMS_SDK_Client", "readException:" + e.toString());
            }
            synchronized (ab.dexc) {
                ab.dexc.notify();
            }
        }
    }

    public ab() {
        dext();
        dexq = new za(dexb);
    }

    public static ab dexa(Context context) {
        if (dexu()) {
            return dexb(context);
        }
        return null;
    }

    public static String dexa(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod(com.acse.ottn.p3.f, String.class, String.class).invoke(cls, str, "0");
            } catch (Exception e) {
                Log.e("VMS_SDK_Client", "getProperty: invoke is error" + e.getMessage());
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static synchronized void dexa(Context context, int i, String str) {
        try {
            if (i == 0) {
                if (dexe == null) {
                    dexe = new bb(dexp, 0, null);
                    context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, dexe);
                    return;
                }
                return;
            }
            if (i == 1) {
                if (dexf == null) {
                    dexf = new bb(dexp, 1, str);
                    context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, dexf);
                    return;
                }
                return;
            }
            if (i != 2) {
                return;
            }
            if (dexg == null) {
                dexg = new bb(dexp, 2, str);
                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/" + context.getPackageName()), false, dexg);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static ab dexb(Context context) {
        if (dexb == null) {
            if (context == null) {
                return null;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            dexb = context;
        }
        if (dexp == null) {
            synchronized (ab.class) {
                if (dexp == null) {
                    dexp = new ab();
                    dexp.dexv();
                }
            }
        }
        return dexp;
    }

    private void dexb(int i, String str) {
        synchronized (dexc) {
            dexa(i, str);
            long jUptimeMillis = SystemClock.uptimeMillis();
            try {
                dexc.wait(2000L);
            } catch (InterruptedException unused) {
                Log.e("VMS_SDK_Client", "queryId: lock error");
            }
            if (SystemClock.uptimeMillis() - jUptimeMillis >= 2000) {
                Log.d("VMS_SDK_Client", "query timeout");
            }
        }
    }

    public static int dexc(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.vivo.vms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void dexc(int i, String str) {
        if (i == 0) {
            if (str == null) {
                dexs++;
                return;
            } else {
                dexr++;
                return;
            }
        }
        if (i == 1) {
            if (str == null) {
                dexu++;
                return;
            } else {
                dext++;
                return;
            }
        }
        if (i == 2) {
            if (str == null) {
                dexw++;
                return;
            } else {
                dexv++;
                return;
            }
        }
        switch (i) {
            case 8:
                if (str != null) {
                    dexx++;
                } else {
                    dexy++;
                }
                break;
            case 9:
                if (str != null) {
                    dexz++;
                } else {
                    dex01++;
                }
                break;
            case 10:
                if (str != null) {
                    dex02++;
                } else {
                    dex03++;
                }
                break;
        }
    }

    public static void dexs() {
        dexd = "1".equals(dexa(com.alipay.sdk.m.u0.c.c, "0")) || "1".equals(dexa("persist.sys.identifierid", "0"));
    }

    public static void dext() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        dexh = handlerThread;
        handlerThread.start();
        dexi = new dexb(dexh.getLooper());
    }

    public static boolean dexu() {
        if (!dexd) {
            dexs();
        }
        return dexd;
    }

    private void dexv() {
        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(new dexa(), 600L, 600L, TimeUnit.SECONDS);
    }

    public String dexa() {
        String str = dexj;
        if (str == null) {
            dexb(0, null);
            if (dexe == null) {
                dexa(dexb, 0, null);
            }
            str = dexj;
        }
        dexc(0, str);
        return dexj;
    }

    public String dexa(int i, int i2, int i3, int i4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i);
        stringBuffer.append(",");
        stringBuffer.append(i2);
        stringBuffer.append(com.alipay.sdk.m.y.l.b);
        stringBuffer.append(i3);
        stringBuffer.append(",");
        stringBuffer.append(i4);
        return stringBuffer.toString();
    }

    public void dexa(int i, String str) {
        Message messageObtainMessage = dexi.obtainMessage();
        messageObtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        if (i == 1 || i == 2 || i == 6) {
            bundle.putString("appid", str);
        }
        messageObtainMessage.setData(bundle);
        dexi.sendMessage(messageObtainMessage);
    }
}
