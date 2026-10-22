package com.beizi.fusion;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.camera.video.AudioStats;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.TwistView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class jm {
    private static final String q = "jm";
    private static SensorManager r;
    private static String s;
    private static String t;
    private static String u;
    private static String v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27441a;
    private long h;
    private double i;
    private double j;
    private TwistView k;
    private Boolean o;
    private long b = 0;
    private double c = -999.0d;
    private double d = -999.0d;
    private boolean e = false;
    private boolean f = false;
    private int g = 0;
    private boolean l = false;
    private boolean m = false;
    private e n = null;
    private final SensorEventListener p = new a();

    public class a implements SensorEventListener {
        public a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        /* JADX WARN: Code duplicated, block: B:101:0x0265 A[Catch: Exception -> 0x02dd, TryCatch #0 {Exception -> 0x02dd, blocks: (B:3:0x0002, B:6:0x0015, B:8:0x0047, B:10:0x004c, B:12:0x005a, B:14:0x005f, B:18:0x0094, B:20:0x00a7, B:23:0x00b1, B:25:0x00bb, B:30:0x00c7, B:42:0x00ee, B:38:0x00df, B:45:0x0117, B:47:0x0121, B:63:0x0195, B:65:0x019d, B:49:0x0129, B:51:0x0139, B:53:0x0152, B:55:0x015c, B:57:0x0166, B:59:0x016e, B:61:0x017e, B:67:0x01b0, B:69:0x01ba, B:71:0x01c4, B:76:0x01d0, B:88:0x01f7, B:84:0x01e8, B:91:0x0220, B:93:0x022a, B:109:0x029e, B:111:0x02c4, B:95:0x0232, B:97:0x0242, B:99:0x025b, B:101:0x0265, B:103:0x026f, B:105:0x0277, B:107:0x0287, B:113:0x02d3, B:13:0x005d, B:9:0x004a), top: B:118:0x0002 }] */
        /* JADX WARN: Code duplicated, block: B:103:0x026f A[Catch: Exception -> 0x02dd, TryCatch #0 {Exception -> 0x02dd, blocks: (B:3:0x0002, B:6:0x0015, B:8:0x0047, B:10:0x004c, B:12:0x005a, B:14:0x005f, B:18:0x0094, B:20:0x00a7, B:23:0x00b1, B:25:0x00bb, B:30:0x00c7, B:42:0x00ee, B:38:0x00df, B:45:0x0117, B:47:0x0121, B:63:0x0195, B:65:0x019d, B:49:0x0129, B:51:0x0139, B:53:0x0152, B:55:0x015c, B:57:0x0166, B:59:0x016e, B:61:0x017e, B:67:0x01b0, B:69:0x01ba, B:71:0x01c4, B:76:0x01d0, B:88:0x01f7, B:84:0x01e8, B:91:0x0220, B:93:0x022a, B:109:0x029e, B:111:0x02c4, B:95:0x0232, B:97:0x0242, B:99:0x025b, B:101:0x0265, B:103:0x026f, B:105:0x0277, B:107:0x0287, B:113:0x02d3, B:13:0x005d, B:9:0x004a), top: B:118:0x0002 }] */
        /* JADX WARN: Code duplicated, block: B:105:0x0277 A[Catch: Exception -> 0x02dd, TryCatch #0 {Exception -> 0x02dd, blocks: (B:3:0x0002, B:6:0x0015, B:8:0x0047, B:10:0x004c, B:12:0x005a, B:14:0x005f, B:18:0x0094, B:20:0x00a7, B:23:0x00b1, B:25:0x00bb, B:30:0x00c7, B:42:0x00ee, B:38:0x00df, B:45:0x0117, B:47:0x0121, B:63:0x0195, B:65:0x019d, B:49:0x0129, B:51:0x0139, B:53:0x0152, B:55:0x015c, B:57:0x0166, B:59:0x016e, B:61:0x017e, B:67:0x01b0, B:69:0x01ba, B:71:0x01c4, B:76:0x01d0, B:88:0x01f7, B:84:0x01e8, B:91:0x0220, B:93:0x022a, B:109:0x029e, B:111:0x02c4, B:95:0x0232, B:97:0x0242, B:99:0x025b, B:101:0x0265, B:103:0x026f, B:105:0x0277, B:107:0x0287, B:113:0x02d3, B:13:0x005d, B:9:0x004a), top: B:118:0x0002 }] */
        /* JADX WARN: Code duplicated, block: B:111:0x02c4 A[Catch: Exception -> 0x02dd, TryCatch #0 {Exception -> 0x02dd, blocks: (B:3:0x0002, B:6:0x0015, B:8:0x0047, B:10:0x004c, B:12:0x005a, B:14:0x005f, B:18:0x0094, B:20:0x00a7, B:23:0x00b1, B:25:0x00bb, B:30:0x00c7, B:42:0x00ee, B:38:0x00df, B:45:0x0117, B:47:0x0121, B:63:0x0195, B:65:0x019d, B:49:0x0129, B:51:0x0139, B:53:0x0152, B:55:0x015c, B:57:0x0166, B:59:0x016e, B:61:0x017e, B:67:0x01b0, B:69:0x01ba, B:71:0x01c4, B:76:0x01d0, B:88:0x01f7, B:84:0x01e8, B:91:0x0220, B:93:0x022a, B:109:0x029e, B:111:0x02c4, B:95:0x0232, B:97:0x0242, B:99:0x025b, B:101:0x0265, B:103:0x026f, B:105:0x0277, B:107:0x0287, B:113:0x02d3, B:13:0x005d, B:9:0x004a), top: B:118:0x0002 }] */
        /* JADX WARN: Code duplicated, block: B:120:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:123:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:124:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:127:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:34:0x00d5  */
        /* JADX WARN: Code duplicated, block: B:40:0x00ea  */
        /* JADX WARN: Code duplicated, block: B:45:0x0117 A[Catch: Exception -> 0x02dd, TryCatch #0 {Exception -> 0x02dd, blocks: (B:3:0x0002, B:6:0x0015, B:8:0x0047, B:10:0x004c, B:12:0x005a, B:14:0x005f, B:18:0x0094, B:20:0x00a7, B:23:0x00b1, B:25:0x00bb, B:30:0x00c7, B:42:0x00ee, B:38:0x00df, B:45:0x0117, B:47:0x0121, B:63:0x0195, B:65:0x019d, B:49:0x0129, B:51:0x0139, B:53:0x0152, B:55:0x015c, B:57:0x0166, B:59:0x016e, B:61:0x017e, B:67:0x01b0, B:69:0x01ba, B:71:0x01c4, B:76:0x01d0, B:88:0x01f7, B:84:0x01e8, B:91:0x0220, B:93:0x022a, B:109:0x029e, B:111:0x02c4, B:95:0x0232, B:97:0x0242, B:99:0x025b, B:101:0x0265, B:103:0x026f, B:105:0x0277, B:107:0x0287, B:113:0x02d3, B:13:0x005d, B:9:0x004a), top: B:118:0x0002 }] */
        /* JADX WARN: Code duplicated, block: B:53:0x0152 A[Catch: Exception -> 0x02dd, TryCatch #0 {Exception -> 0x02dd, blocks: (B:3:0x0002, B:6:0x0015, B:8:0x0047, B:10:0x004c, B:12:0x005a, B:14:0x005f, B:18:0x0094, B:20:0x00a7, B:23:0x00b1, B:25:0x00bb, B:30:0x00c7, B:42:0x00ee, B:38:0x00df, B:45:0x0117, B:47:0x0121, B:63:0x0195, B:65:0x019d, B:49:0x0129, B:51:0x0139, B:53:0x0152, B:55:0x015c, B:57:0x0166, B:59:0x016e, B:61:0x017e, B:67:0x01b0, B:69:0x01ba, B:71:0x01c4, B:76:0x01d0, B:88:0x01f7, B:84:0x01e8, B:91:0x0220, B:93:0x022a, B:109:0x029e, B:111:0x02c4, B:95:0x0232, B:97:0x0242, B:99:0x025b, B:101:0x0265, B:103:0x026f, B:105:0x0277, B:107:0x0287, B:113:0x02d3, B:13:0x005d, B:9:0x004a), top: B:118:0x0002 }] */
        /* JADX WARN: Code duplicated, block: B:55:0x015c A[Catch: Exception -> 0x02dd, TryCatch #0 {Exception -> 0x02dd, blocks: (B:3:0x0002, B:6:0x0015, B:8:0x0047, B:10:0x004c, B:12:0x005a, B:14:0x005f, B:18:0x0094, B:20:0x00a7, B:23:0x00b1, B:25:0x00bb, B:30:0x00c7, B:42:0x00ee, B:38:0x00df, B:45:0x0117, B:47:0x0121, B:63:0x0195, B:65:0x019d, B:49:0x0129, B:51:0x0139, B:53:0x0152, B:55:0x015c, B:57:0x0166, B:59:0x016e, B:61:0x017e, B:67:0x01b0, B:69:0x01ba, B:71:0x01c4, B:76:0x01d0, B:88:0x01f7, B:84:0x01e8, B:91:0x0220, B:93:0x022a, B:109:0x029e, B:111:0x02c4, B:95:0x0232, B:97:0x0242, B:99:0x025b, B:101:0x0265, B:103:0x026f, B:105:0x0277, B:107:0x0287, B:113:0x02d3, B:13:0x005d, B:9:0x004a), top: B:118:0x0002 }] */
        /* JADX WARN: Code duplicated, block: B:57:0x0166 A[Catch: Exception -> 0x02dd, TryCatch #0 {Exception -> 0x02dd, blocks: (B:3:0x0002, B:6:0x0015, B:8:0x0047, B:10:0x004c, B:12:0x005a, B:14:0x005f, B:18:0x0094, B:20:0x00a7, B:23:0x00b1, B:25:0x00bb, B:30:0x00c7, B:42:0x00ee, B:38:0x00df, B:45:0x0117, B:47:0x0121, B:63:0x0195, B:65:0x019d, B:49:0x0129, B:51:0x0139, B:53:0x0152, B:55:0x015c, B:57:0x0166, B:59:0x016e, B:61:0x017e, B:67:0x01b0, B:69:0x01ba, B:71:0x01c4, B:76:0x01d0, B:88:0x01f7, B:84:0x01e8, B:91:0x0220, B:93:0x022a, B:109:0x029e, B:111:0x02c4, B:95:0x0232, B:97:0x0242, B:99:0x025b, B:101:0x0265, B:103:0x026f, B:105:0x0277, B:107:0x0287, B:113:0x02d3, B:13:0x005d, B:9:0x004a), top: B:118:0x0002 }] */
        /* JADX WARN: Code duplicated, block: B:59:0x016e A[Catch: Exception -> 0x02dd, TryCatch #0 {Exception -> 0x02dd, blocks: (B:3:0x0002, B:6:0x0015, B:8:0x0047, B:10:0x004c, B:12:0x005a, B:14:0x005f, B:18:0x0094, B:20:0x00a7, B:23:0x00b1, B:25:0x00bb, B:30:0x00c7, B:42:0x00ee, B:38:0x00df, B:45:0x0117, B:47:0x0121, B:63:0x0195, B:65:0x019d, B:49:0x0129, B:51:0x0139, B:53:0x0152, B:55:0x015c, B:57:0x0166, B:59:0x016e, B:61:0x017e, B:67:0x01b0, B:69:0x01ba, B:71:0x01c4, B:76:0x01d0, B:88:0x01f7, B:84:0x01e8, B:91:0x0220, B:93:0x022a, B:109:0x029e, B:111:0x02c4, B:95:0x0232, B:97:0x0242, B:99:0x025b, B:101:0x0265, B:103:0x026f, B:105:0x0277, B:107:0x0287, B:113:0x02d3, B:13:0x005d, B:9:0x004a), top: B:118:0x0002 }] */
        /* JADX WARN: Code duplicated, block: B:65:0x019d A[Catch: Exception -> 0x02dd, TryCatch #0 {Exception -> 0x02dd, blocks: (B:3:0x0002, B:6:0x0015, B:8:0x0047, B:10:0x004c, B:12:0x005a, B:14:0x005f, B:18:0x0094, B:20:0x00a7, B:23:0x00b1, B:25:0x00bb, B:30:0x00c7, B:42:0x00ee, B:38:0x00df, B:45:0x0117, B:47:0x0121, B:63:0x0195, B:65:0x019d, B:49:0x0129, B:51:0x0139, B:53:0x0152, B:55:0x015c, B:57:0x0166, B:59:0x016e, B:61:0x017e, B:67:0x01b0, B:69:0x01ba, B:71:0x01c4, B:76:0x01d0, B:88:0x01f7, B:84:0x01e8, B:91:0x0220, B:93:0x022a, B:109:0x029e, B:111:0x02c4, B:95:0x0232, B:97:0x0242, B:99:0x025b, B:101:0x0265, B:103:0x026f, B:105:0x0277, B:107:0x0287, B:113:0x02d3, B:13:0x005d, B:9:0x004a), top: B:118:0x0002 }] */
        /* JADX WARN: Code duplicated, block: B:80:0x01de  */
        /* JADX WARN: Code duplicated, block: B:86:0x01f3  */
        /* JADX WARN: Code duplicated, block: B:91:0x0220 A[Catch: Exception -> 0x02dd, TryCatch #0 {Exception -> 0x02dd, blocks: (B:3:0x0002, B:6:0x0015, B:8:0x0047, B:10:0x004c, B:12:0x005a, B:14:0x005f, B:18:0x0094, B:20:0x00a7, B:23:0x00b1, B:25:0x00bb, B:30:0x00c7, B:42:0x00ee, B:38:0x00df, B:45:0x0117, B:47:0x0121, B:63:0x0195, B:65:0x019d, B:49:0x0129, B:51:0x0139, B:53:0x0152, B:55:0x015c, B:57:0x0166, B:59:0x016e, B:61:0x017e, B:67:0x01b0, B:69:0x01ba, B:71:0x01c4, B:76:0x01d0, B:88:0x01f7, B:84:0x01e8, B:91:0x0220, B:93:0x022a, B:109:0x029e, B:111:0x02c4, B:95:0x0232, B:97:0x0242, B:99:0x025b, B:101:0x0265, B:103:0x026f, B:105:0x0277, B:107:0x0287, B:113:0x02d3, B:13:0x005d, B:9:0x004a), top: B:118:0x0002 }] */
        /* JADX WARN: Code duplicated, block: B:99:0x025b A[Catch: Exception -> 0x02dd, TryCatch #0 {Exception -> 0x02dd, blocks: (B:3:0x0002, B:6:0x0015, B:8:0x0047, B:10:0x004c, B:12:0x005a, B:14:0x005f, B:18:0x0094, B:20:0x00a7, B:23:0x00b1, B:25:0x00bb, B:30:0x00c7, B:42:0x00ee, B:38:0x00df, B:45:0x0117, B:47:0x0121, B:63:0x0195, B:65:0x019d, B:49:0x0129, B:51:0x0139, B:53:0x0152, B:55:0x015c, B:57:0x0166, B:59:0x016e, B:61:0x017e, B:67:0x01b0, B:69:0x01ba, B:71:0x01c4, B:76:0x01d0, B:88:0x01f7, B:84:0x01e8, B:91:0x0220, B:93:0x022a, B:109:0x029e, B:111:0x02c4, B:95:0x0232, B:97:0x0242, B:99:0x025b, B:101:0x0265, B:103:0x026f, B:105:0x0277, B:107:0x0287, B:113:0x02d3, B:13:0x005d, B:9:0x004a), top: B:118:0x0002 }] */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00ec, code lost:
        
            if (r8 <= 180.0d) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x01f5, code lost:
        
            if (r5 <= 180.0d) goto L88;
         */
        @Override // android.hardware.SensorEventListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onSensorChanged(SensorEvent sensorEvent) {
            jm jmVar;
            double d;
            double d2;
            String str;
            jm jmVar2;
            double d3;
            double d4;
            jm jmVar3;
            double d5;
            double d6;
            jm jmVar4;
            double d7;
            double d8;
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                jm jmVar5 = jm.this;
                if (jCurrentTimeMillis - jmVar5.b < 80) {
                    return;
                }
                jmVar5.b = System.currentTimeMillis();
                float[] fArr = sensorEvent.values;
                double d9 = ((double) fArr[0]) / 9.8d;
                double d10 = ((double) fArr[1]) / 9.8d;
                double d11 = ((double) fArr[2]) / 9.8d;
                double degrees = Math.toDegrees(Math.atan2(d9, d10));
                double d12 = degrees <= AudioStats.AUDIO_AMPLITUDE_NONE ? (-degrees) - 180.0d : 180.0d - degrees;
                double degrees2 = Math.toDegrees(Math.atan2(d9, d11));
                double d13 = degrees2 <= AudioStats.AUDIO_AMPLITUDE_NONE ? (-degrees2) - 180.0d : 180.0d - degrees2;
                double degrees3 = Math.toDegrees(Math.atan2(d11, Math.sqrt((d9 * d9) + (d10 * d10)))) + 90.0d;
                if (degrees3 > 45.0d && degrees3 < 135.0d && (Math.abs((Math.sin(d10) / 3.141592653589793d) * 180.0d) >= 45.0d || !jm.this.e)) {
                    jm jmVar6 = jm.this;
                    double d14 = jmVar6.d;
                    if (d14 != -999.0d && jmVar6.f) {
                        if (d12 < d14) {
                            if (d12 < d14) {
                                d8 = (360.0d - d14) + d12;
                                if (d8 > jmVar6.i) {
                                }
                            }
                            if (d12 >= d14) {
                                jmVar3 = jm.this;
                                d5 = jmVar3.d;
                                if (d12 >= d5) {
                                    d6 = d12 - d5;
                                    if (d6 < jmVar3.j) {
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                return;
                            }
                            d7 = d12 - d14;
                            if (d7 < jmVar6.j) {
                                jmVar3 = jm.this;
                                d5 = jmVar3.d;
                                if (d12 >= d5) {
                                    d6 = d12 - d5;
                                    if (d6 < jmVar3.j) {
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                return;
                            }
                            jmVar3 = jm.this;
                            d5 = jmVar3.d;
                            if (d12 >= d5) {
                                d6 = d12 - d5;
                                if (d6 < jmVar3.j) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                            return;
                            jmVar4 = jm.this;
                            if (jmVar4.g == 1) {
                                jmVar4.g = 2;
                                jh.a(jm.q, "发生垂直状态回滚");
                                jm.this.d();
                                return;
                            }
                            return;
                        }
                        double d15 = d12 - d14;
                        if (d15 <= jmVar6.i || d15 > 180.0d) {
                            if (d12 < d14 && d14 > AudioStats.AUDIO_AMPLITUDE_NONE) {
                                d8 = (360.0d - d14) + d12;
                                if (d8 > jmVar6.i) {
                                }
                            }
                            if (d12 >= d14) {
                                jmVar3 = jm.this;
                                d5 = jmVar3.d;
                                if (d12 >= d5) {
                                    d6 = d12 - d5;
                                    if (d6 < jmVar3.j) {
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                return;
                            }
                            d7 = d12 - d14;
                            if ((d7 < jmVar6.j || Math.abs(d7) > 180.0d) && (Math.abs(d12 - jm.this.d) < 180.0d || (-(360.0d - Math.abs(d12 - jm.this.d))) >= jm.this.j)) {
                                jmVar3 = jm.this;
                                d5 = jmVar3.d;
                                if (d12 >= d5) {
                                    return;
                                }
                                d6 = d12 - d5;
                                if ((d6 < jmVar3.j || Math.abs(d6) > 180.0d) && (Math.abs(d12 - jm.this.d) < 180.0d || 360.0d - Math.abs(d12 - jm.this.d) >= jm.this.j)) {
                                    return;
                                }
                            }
                            jmVar4 = jm.this;
                            if (jmVar4.g == 1) {
                                jmVar4.g = 2;
                                jh.a(jm.q, "发生垂直状态回滚");
                                jm.this.d();
                                return;
                            }
                            return;
                        }
                        jh.b(jm.q, "11111发生垂直状态滚动 rollStatus:" + jm.this.g);
                        jm jmVar7 = jm.this;
                        jmVar7.g = 1;
                        jmVar7.d();
                        return;
                    }
                    jmVar6.d = d12;
                    jmVar6.f = true;
                    jmVar6.e = false;
                    return;
                }
                jm jmVar8 = jm.this;
                double d16 = jmVar8.c;
                if (d16 != -999.0d && jmVar8.e) {
                    if (d13 < d16) {
                        if (d13 < d16) {
                            d4 = (360.0d - d16) + d13;
                            if (d4 > jmVar8.i) {
                            }
                        }
                        if (d13 >= d16) {
                            jmVar = jm.this;
                            d = jmVar.c;
                            if (d13 >= d) {
                                d2 = d13 - d;
                                if (d2 < jmVar.j) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                            return;
                        }
                        d3 = d13 - d16;
                        if (d3 < jmVar8.j) {
                            jmVar = jm.this;
                            d = jmVar.c;
                            if (d13 >= d) {
                                d2 = d13 - d;
                                if (d2 < jmVar.j) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                            return;
                        }
                        jmVar = jm.this;
                        d = jmVar.c;
                        if (d13 >= d) {
                            d2 = d13 - d;
                            if (d2 < jmVar.j) {
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                        str = jm.q;
                        jh.a(str, "2222发生水平状态回滚 rollStatus:" + jm.this.g);
                        jmVar2 = jm.this;
                        if (jmVar2.g == 1) {
                            jmVar2.g = 2;
                            jh.a(str, "发生水平状态回滚");
                            jm.this.d();
                            return;
                        }
                        return;
                    }
                    double d17 = d13 - d16;
                    if (d17 <= jmVar8.i || d17 > 180.0d) {
                        if (d13 < d16 && d16 > AudioStats.AUDIO_AMPLITUDE_NONE) {
                            d4 = (360.0d - d16) + d13;
                            if (d4 > jmVar8.i) {
                            }
                        }
                        if (d13 >= d16) {
                            jmVar = jm.this;
                            d = jmVar.c;
                            if (d13 >= d) {
                                d2 = d13 - d;
                                if (d2 < jmVar.j) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                            return;
                        }
                        d3 = d13 - d16;
                        if ((d3 < jmVar8.j || Math.abs(d3) > 180.0d) && (Math.abs(d13 - jm.this.c) < 180.0d || (-(360.0d - Math.abs(d13 - jm.this.c))) >= jm.this.j)) {
                            jmVar = jm.this;
                            d = jmVar.c;
                            if (d13 >= d) {
                                return;
                            }
                            d2 = d13 - d;
                            if ((d2 < jmVar.j || Math.abs(d2) > 180.0d) && (Math.abs(d13 - jm.this.c) < 180.0d || 360.0d - Math.abs(d13 - jm.this.c) >= jm.this.j)) {
                                return;
                            }
                        }
                        str = jm.q;
                        jh.a(str, "2222发生水平状态回滚 rollStatus:" + jm.this.g);
                        jmVar2 = jm.this;
                        if (jmVar2.g == 1) {
                            jmVar2.g = 2;
                            jh.a(str, "发生水平状态回滚");
                            jm.this.d();
                            return;
                        }
                        return;
                    }
                    jh.b(jm.q, "11111发生水平状态滚动 rollStatus:" + jm.this.g);
                    jm jmVar9 = jm.this;
                    jmVar9.g = 1;
                    jmVar9.d();
                    return;
                }
                jmVar8.c = d13;
                jmVar8.e = true;
                jmVar8.f = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            jm jmVar = jm.this;
            if (jmVar.m) {
                return;
            }
            jmVar.m = true;
            e eVar = jmVar.n;
            if (eVar != null) {
                eVar.a(jm.s, jm.t, jm.u, jm.v, jm.s, jm.t, jm.u, jm.v);
            }
        }
    }

    public class c implements View.OnTouchListener {
        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            try {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                jm.s = motionEvent.getX() + "";
                jm.t = motionEvent.getY() + "";
                jm.u = motionEvent.getRawX() + "";
                jm.v = motionEvent.getRawY() + "";
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public class d implements TwistView.i {
        public d() {
        }

        @Override // com.beizi.fusion.widget.TwistView.i
        public void a() {
            jm jmVar = jm.this;
            if (jmVar.l) {
                return;
            }
            jmVar.l = true;
            e eVar = jmVar.n;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    public interface e {
        void a();

        void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public jm(Context context) {
        this.f27441a = context;
        r = (SensorManager) context.getApplicationContext().getSystemService("sensor");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        TwistView twistView = this.k;
        if (twistView != null) {
            twistView.updateRollStatus(this.g);
        }
    }

    public void a(ViewGroup viewGroup, int i, int i2, AdSpacesBean.BuyerBean.RollViewBean rollViewBean) {
        AdSpacesBean.BuyerBean.PercentPositionBean position;
        String downloadSubTitle;
        jh.a("BeiZis", "enter addRollView");
        if (this.f27441a == null || viewGroup == null || rollViewBean == null || (position = rollViewBean.getPosition()) == null) {
            return;
        }
        this.k = new TwistView(this.f27441a);
        String centerX = position.getCenterX();
        String centerY = position.getCenterY();
        String width = position.getWidth();
        String height = position.getHeight();
        if (TextUtils.isEmpty(centerX) || "0".equals(centerX)) {
            centerX = "85%";
        }
        if (TextUtils.isEmpty(centerY) || "0".equals(centerY)) {
            centerY = "50%";
        }
        if (TextUtils.isEmpty(width) || "0".equals(width)) {
            width = "340";
        }
        if (TextUtils.isEmpty(height) || "0".equals(height)) {
            height = "70";
        }
        float fI = so.i(this.f27441a);
        int i3 = centerX.endsWith("%") ? (Integer.parseInt(centerX.substring(0, centerX.indexOf("%"))) * i) / 100 : Integer.parseInt(centerX);
        int i4 = centerY.endsWith("%") ? (Integer.parseInt(centerY.substring(0, centerY.indexOf("%"))) * i2) / 100 : Integer.parseInt(centerY);
        int i5 = 400;
        if (width.endsWith("%")) {
            int i6 = Integer.parseInt(width.substring(0, width.indexOf("%")));
            i5 = fI >= 400.0f ? (i6 * 400) / 100 : (((int) fI) * i6) / 100;
        } else {
            int i7 = Integer.parseInt(width);
            if (i7 < 400) {
                i5 = i7;
            }
        }
        int i8 = height.endsWith("%") ? (Integer.parseInt(height.substring(0, height.indexOf("%"))) * i5) / 100 : Integer.parseInt(height);
        int iA = so.a(this.f27441a, i5);
        int iA2 = so.a(this.f27441a, i8 + 95);
        int iA3 = so.a(this.f27441a, i3);
        int iA4 = so.a(this.f27441a, i4);
        jh.a("BeiZis", "widthInt = " + iA + ",heightInt = " + iA2);
        int iA5 = so.a(this.f27441a, 340.0f);
        int iA6 = so.a(this.f27441a, 165.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA5, iA6);
        jh.a("BeiZis", "centerYInt = " + iA4 + ",centerXInt = " + iA3 + ",adWidthDp = " + i + ",adHeightDp = " + i2);
        if (iA4 == 0) {
            iA4 = so.a(this.f27441a, i2) / 2;
        }
        if (iA3 == 0) {
            iA3 = so.a(this.f27441a, i) / 2;
        }
        layoutParams.topMargin = iA4 - (iA6 / 2);
        layoutParams.leftMargin = iA3 - (iA5 / 2);
        this.k.setTwistTotalLayoutWidthAndHeight(iA5, iA6);
        this.k.setLayoutParams(layoutParams);
        this.k.setTwistTotalLayoutBg(rollViewBean.getBgColor());
        this.k.setMainTitleText(rollViewBean.getTitle());
        if (this.o.booleanValue()) {
            downloadSubTitle = rollViewBean.getDownloadSubTitle();
            if (TextUtils.isEmpty(downloadSubTitle)) {
                downloadSubTitle = "下载应用";
            }
        } else {
            downloadSubTitle = rollViewBean.getSubTitle();
        }
        this.k.setDescribeText(downloadSubTitle);
        this.k.setJumpClickListener(new b());
        this.k.setJumpOnTouchListener(new c());
        this.k.setRotationEndCallback(new d());
        viewGroup.addView(this.k, layoutParams);
    }

    public void b() {
        this.m = false;
    }

    public void c() {
        SensorManager sensorManager = r;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.p);
        }
        TwistView twistView = this.k;
        if (twistView != null) {
            twistView.destroyView();
            this.k = null;
        }
        this.m = false;
        this.l = false;
    }

    public void b(double d2) {
        this.i = d2;
    }

    public void a() {
        SensorManager sensorManager = r;
        if (sensorManager != null) {
            sensorManager.registerListener(this.p, sensorManager.getDefaultSensor(1), 100000);
        }
    }

    public void a(AdSpacesBean.BuyerBean.RollViewBean rollViewBean) {
        if (rollViewBean == null) {
            return;
        }
        try {
            jh.a(q, "setRollParams getRollTime:" + rollViewBean.getRollTime() + ";getRollPlusAmplitude:" + rollViewBean.getRollPlusAmplitude() + ";getRollMinusAmplitude:" + rollViewBean.getRollMinusAmplitude());
            a(rollViewBean.getRollTime());
            b(rollViewBean.getRollPlusAmplitude());
            a(rollViewBean.getRollMinusAmplitude());
            TwistView twistView = this.k;
            if (twistView != null) {
                twistView.setDurationAnimation(rollViewBean.getRollTime());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(AdSpacesBean.BuyerBean.CoolRollViewBean coolRollViewBean) {
        if (coolRollViewBean == null) {
            return;
        }
        try {
            jh.a(q, "setRollCoolParams getRollTime:" + coolRollViewBean.getRollTime() + ";getRollPlusAmplitude:" + coolRollViewBean.getRollPlusAmplitude() + ";getRollMinusAmplitude:" + coolRollViewBean.getRollMinusAmplitude());
            a(coolRollViewBean.getRollTime());
            b(coolRollViewBean.getRollPlusAmplitude());
            a(coolRollViewBean.getRollMinusAmplitude());
            TwistView twistView = this.k;
            if (twistView != null) {
                twistView.setDurationAnimation(coolRollViewBean.getRollTime());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(long j) {
        this.h = j;
    }

    public void a(double d2) {
        this.j = d2;
    }

    public void a(e eVar) {
        this.n = eVar;
    }

    public void a(Boolean bool) {
        this.o = bool;
    }
}
