package com.getui.gtc.a;

import android.text.TextUtils;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f30264a;
    private boolean b = true;
    private long c = 10000;

    @Override // java.lang.Runnable
    public final void run() {
        Map<String, String> mapA = com.getui.gtc.f.c.a(com.heytap.mcssdk.constant.a.g, (com.getui.gtc.f.e) null);
        if (mapA != null && mapA.size() > 0) {
            try {
                if (mapA.containsKey("sdk.gtc.type301.enable")) {
                    this.b = Boolean.parseBoolean(mapA.get("sdk.gtc.type301.enable"));
                }
            } catch (Exception e) {
                com.getui.gtc.i.c.a.b(e);
            }
            try {
                if (mapA.containsKey("sdk.gtc.type301.interval")) {
                    this.c = Long.parseLong(mapA.get("sdk.gtc.type301.interval")) * 1000;
                }
            } catch (Exception e2) {
                com.getui.gtc.i.c.a.b(e2);
            }
        }
        if (!this.b) {
            com.getui.gtc.i.c.a.b("type 301 is not enabled");
            return;
        }
        String str = com.getui.gtc.e.c.a.f30351a.f30350a.f30352a;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] strArrSplit = str.split("\n");
                if (System.currentTimeMillis() - new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse(strArrSplit[0].split("\\|")[0]).getTime() > 604800000 || strArrSplit.length > 300) {
                    com.getui.gtc.e.c.a.f30351a.f30350a.d("");
                    com.getui.gtc.i.c.a.a("type 301 clean stored samples");
                }
            } catch (Exception e3) {
                com.getui.gtc.i.c.a.b("type 301 clean samples error: " + e3.toString());
            }
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        StringBuilder sb = new StringBuilder();
        sb.append(a.a(simpleDateFormat.format(new Date())));
        sb.append("|");
        sb.append(a.a(com.getui.gtc.c.b.d));
        sb.append("|");
        sb.append(a.a(com.getui.gtc.c.b.f30289a));
        sb.append("|android|");
        com.getui.gtc.i.d.b unused = com.getui.gtc.i.d.b.C0659b.f30388a;
        Calendar calendar = Calendar.getInstance();
        double d = ((double) (calendar.get(15) + calendar.get(16))) / 3600000.0d;
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        numberInstance.setMaximumFractionDigits(2);
        sb.append(a.a(numberInstance.format(d)));
        String string = sb.toString();
        com.getui.gtc.e.d dVar = com.getui.gtc.e.c.a.f30351a.f30350a;
        if (!TextUtils.isEmpty(string)) {
            if (!TextUtils.isEmpty(dVar.f30352a)) {
                string = dVar.f30352a + "\n" + string;
            }
            if (dVar.a(7, string)) {
                dVar.f30352a = string;
            }
        }
        this.f30264a = com.getui.gtc.e.c.a.f30351a.f30350a.f30352a;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - com.getui.gtc.e.c.a.f30351a.f30350a.c < this.c) {
                return;
            }
            com.getui.gtc.h.a.a(this.f30264a, 301);
            com.getui.gtc.e.d dVar2 = com.getui.gtc.e.c.a.f30351a.f30350a;
            if (dVar2.a(6, jCurrentTimeMillis)) {
                dVar2.c = jCurrentTimeMillis;
            }
            com.getui.gtc.e.c.a.f30351a.f30350a.d("");
        } catch (Exception e4) {
            com.getui.gtc.i.c.a.c("type 301 report error: " + e4.toString());
        }
    }
}
