package com.getui.gtc.i.d;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.getui.gtc.a.a.e;
import com.getui.gtc.a.a.f;
import com.getui.gtc.api.OnDycEnableChangedListener;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.util.CommonUtil;
import com.getui.gtc.base.util.ScheduleQueue;
import com.getui.gtc.dim.AllowSysCall;
import com.getui.gtc.dim.DimManager;
import com.getui.gtc.f.c;
import com.zj.adlib.u15;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f30384a;

    public static class a extends f {
        public a(e eVar) {
            this.e = eVar;
        }

        @Override // com.getui.gtc.a.a.f
        public final void a() {
            e eVar = this.e;
            if (eVar != null) {
                try {
                    eVar.a(null);
                } catch (Throwable th) {
                    com.getui.gtc.i.c.a.c(th);
                }
            }
        }

        @Override // com.getui.gtc.a.a.f
        public final void a(int i) {
            e eVar = this.e;
            if (eVar != null) {
                try {
                    eVar.a(null);
                } catch (Throwable th) {
                    com.getui.gtc.i.c.a.c(th);
                }
            }
        }

        @Override // com.getui.gtc.a.a.f
        public final void a(Map<String, List<String>> map, byte[] bArr) {
            try {
                if (this.e != null) {
                    HashMap map2 = new HashMap();
                    map2.put("header", map);
                    map2.put("data", new String(bArr, "utf-8"));
                    this.e.a(map2);
                }
            } catch (Throwable th) {
                com.getui.gtc.i.c.a.c(th);
            }
        }
    }

    /* JADX INFO: renamed from: com.getui.gtc.i.d.b$b, reason: collision with other inner class name */
    public static class C0659b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f30388a = new b(0);
    }

    private b() {
        this.f30384a = new AtomicBoolean(false);
        final Map<String, String> mapA = c.a(com.heytap.mcssdk.constant.a.g, new com.getui.gtc.f.e() { // from class: com.getui.gtc.i.d.b.1
            @Override // com.getui.gtc.f.e
            public final void a(String str) {
            }

            /* JADX WARN: Code duplicated, block: B:110:0x0201  */
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            @Override // com.getui.gtc.f.e
            public final void a(Map<String, String> map, Map<String, String> map2) {
                OnDycEnableChangedListener[] onDycEnableChangedListenerArr;
                String str;
                Boolean bool;
                byte b;
                AllowSysCall allowSysCall;
                b.this.a(map2);
                com.getui.gtc.f.b bVarA = com.getui.gtc.f.b.a();
                if (map2 != null) {
                    if (bVarA.b.compareAndSet(false, true)) {
                        try {
                            synchronized (bVarA.b) {
                                onDycEnableChangedListenerArr = (OnDycEnableChangedListener[]) bVarA.f30356a.toArray(new OnDycEnableChangedListener[0]);
                                bVarA.f30356a.clear();
                            }
                            com.getui.gtc.i.c.a.a("dycEnable changed start check");
                            HashMap map3 = new HashMap();
                            String[] strArr = {"dim-2-1-1-1", "dim-2-1-1-3", "dim-2-1-1-4", "dim-2-1-2-1", "dim-2-1-2-3", "dim-2-1-2-4", "dim-2-1-3-1", "dim-2-1-3-2", "dim-2-1-4-1", "dim-2-1-5-1", "dim-2-1-5-2", "dim-2-1-6-1", "dim-2-1-6-3", "dim-2-1-6-4", "dim-2-1-7-1", "dim-2-1-8-1", "dim-2-1-9-1", "dim-2-1-10-1", "dim-2-1-11-1", "dim-2-1-12-1", "dim-2-1-13-1", "dim-2-1-14-1", "dim-2-1-15-1", "dim-2-1-16-1", "dim-2-1-16-2", "dim-2-1-17-1", "dim-2-1-17-2", "dim-2-1-17-3", "dim-2-1-17-4", "dim-2-1-18-1", "dim-2-1-18-2", "dim-2-1-18-3", "dim-2-1-18-4", "dim-2-1-19-1", "dim-2-1-19-2", "dim-2-1-21-1", "dim-2-1-21-2", "dim-2-1-21-3", "dim-2-1-21-5"};
                            for (int i = 0; i < 39; i++) {
                                String str2 = strArr[i];
                                switch (str2.hashCode()) {
                                    case 320892099:
                                        if (str2.equals("dim-2-1-14-1")) {
                                            b = com.google.common.base.a.H;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 320894021:
                                        if (str2.equals("dim-2-1-16-1")) {
                                            b = com.google.common.base.a.F;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 320894022:
                                        if (str2.equals("dim-2-1-16-2")) {
                                            b = com.google.common.base.a.G;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 320894982:
                                        if (str2.equals("dim-2-1-17-1")) {
                                            b = 4;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 320894983:
                                        if (str2.equals("dim-2-1-17-2")) {
                                            b = 5;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 320894984:
                                        if (str2.equals("dim-2-1-17-3")) {
                                            b = 6;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 320894985:
                                        if (str2.equals("dim-2-1-17-4")) {
                                            b = 7;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 320895943:
                                        if (str2.equals("dim-2-1-18-1")) {
                                            b = 8;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 320895944:
                                        if (str2.equals("dim-2-1-18-2")) {
                                            b = 10;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 320895945:
                                        if (str2.equals("dim-2-1-18-3")) {
                                            b = 9;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 320895946:
                                        if (str2.equals("dim-2-1-18-4")) {
                                            b = 11;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 320896904:
                                        if (str2.equals("dim-2-1-19-1")) {
                                            b = 12;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 320896905:
                                        if (str2.equals("dim-2-1-19-2")) {
                                            b = 13;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 320919007:
                                        if (str2.equals("dim-2-1-21-1")) {
                                            b = 1;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 320919008:
                                        if (str2.equals("dim-2-1-21-2")) {
                                            b = 0;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 320919009:
                                        if (str2.equals("dim-2-1-21-3")) {
                                            b = 2;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 320919011:
                                        if (str2.equals("dim-2-1-21-5")) {
                                            b = 3;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 1672919129:
                                        if (str2.equals("dim-2-1-1-1")) {
                                            b = com.google.common.base.a.p;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 1672919131:
                                        if (str2.equals("dim-2-1-1-3")) {
                                            b = com.google.common.base.a.q;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 1672919132:
                                        if (str2.equals("dim-2-1-1-4")) {
                                            b = com.google.common.base.a.r;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 1672920090:
                                        if (str2.equals("dim-2-1-2-1")) {
                                            b = 17;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 1672920092:
                                        if (str2.equals("dim-2-1-2-3")) {
                                            b = com.google.common.base.a.u;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 1672920093:
                                        if (str2.equals("dim-2-1-2-4")) {
                                            b = 19;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 1672921051:
                                        if (str2.equals("dim-2-1-3-1")) {
                                            b = com.google.common.base.a.C;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 1672921052:
                                        if (str2.equals("dim-2-1-3-2")) {
                                            b = com.google.common.base.a.D;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 1672922012:
                                        if (str2.equals("dim-2-1-4-1")) {
                                            b = com.google.common.base.a.A;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 1672923934:
                                        if (str2.equals("dim-2-1-6-1")) {
                                            b = com.google.common.base.a.x;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 1672923936:
                                        if (str2.equals("dim-2-1-6-3")) {
                                            b = com.google.common.base.a.y;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 1672923937:
                                        if (str2.equals("dim-2-1-6-4")) {
                                            b = com.google.common.base.a.z;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 1672924895:
                                        if (str2.equals("dim-2-1-7-1")) {
                                            b = com.google.common.base.a.E;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case 1672925856:
                                        if (str2.equals("dim-2-1-8-1")) {
                                            b = com.google.common.base.a.B;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    default:
                                        b = -1;
                                        break;
                                }
                                switch (b) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                    case 14:
                                    case 15:
                                    case 16:
                                    case 17:
                                    case 18:
                                    case 19:
                                    case 20:
                                    case 21:
                                    case 22:
                                    case 23:
                                    case 24:
                                    case 25:
                                    case 26:
                                    case 27:
                                    case 28:
                                    case 29:
                                    case 30:
                                        allowSysCall = AllowSysCall.NOT_ALLOW;
                                        break;
                                    default:
                                        allowSysCall = AllowSysCall.ALL_ALLOW;
                                        break;
                                }
                                map3.put(str2, Boolean.valueOf(allowSysCall != AllowSysCall.NOT_ALLOW));
                            }
                            HashMap map4 = new HashMap(map3);
                            if (map == null) {
                                com.getui.gtc.i.c.a.a("dycEnable this new user");
                            } else {
                                Map<String, Boolean> mapB = com.getui.gtc.f.b.b(map);
                                Boolean bool2 = mapB.get("dim-2-2-0-1");
                                for (int i2 = 0; i2 < 39; i2++) {
                                    String str3 = strArr[i2];
                                    Boolean bool3 = mapB.get(str3);
                                    if (bool3 != null) {
                                        map4.put(str3, bool3);
                                    } else if (bool2 != null) {
                                        map4.put(str3, bool2);
                                    }
                                }
                            }
                            HashMap map5 = new HashMap(map3);
                            Map<String, Boolean> mapB2 = com.getui.gtc.f.b.b(map2);
                            Boolean bool4 = mapB2.get("dim-2-2-0-1");
                            for (int i3 = 0; i3 < 39; i3++) {
                                String str4 = strArr[i3];
                                Boolean bool5 = mapB2.get(str4);
                                if (bool5 != null) {
                                    map5.put(str4, bool5);
                                } else if (bool4 != null) {
                                    map5.put(str4, bool4);
                                }
                            }
                            HashMap map6 = new HashMap();
                            for (int i4 = 0; i4 < 39; i4++) {
                                String str5 = strArr[i4];
                                Boolean bool6 = (Boolean) map4.get(str5);
                                Boolean bool7 = (Boolean) map5.get(str5);
                                if (bool6 != null && bool7 != null && !bool6.equals(bool7)) {
                                    map6.put(str5, bool7);
                                }
                            }
                            String strA = com.getui.gtc.f.b.a(map4);
                            String strA2 = com.getui.gtc.f.b.a(map5);
                            if (!strA.equals(strA2)) {
                                if (strA2.contains("1")) {
                                    str = "dim-2-1-21-4";
                                    bool = Boolean.TRUE;
                                } else {
                                    str = "dim-2-1-21-4";
                                    bool = Boolean.FALSE;
                                }
                                map6.put(str, bool);
                            }
                            if (map6.isEmpty()) {
                                com.getui.gtc.i.c.a.a("dycEnable not changed");
                            } else {
                                com.getui.gtc.i.c.a.a("dycEnable changed listener size: " + onDycEnableChangedListenerArr.length + ", result: " + map6);
                                for (OnDycEnableChangedListener onDycEnableChangedListener : onDycEnableChangedListenerArr) {
                                    onDycEnableChangedListener.onDycEnableChanged(map6);
                                }
                            }
                        } catch (Throwable th) {
                            com.getui.gtc.i.c.a.c(th);
                        }
                    } else {
                        com.getui.gtc.i.c.a.a("dycEnable listener only once");
                    }
                }
                com.getui.gtc.i.c.b.a(map2);
            }
        });
        a(mapA);
        ScheduleQueue.getInstance().addSchedule(new Runnable() { // from class: com.getui.gtc.i.d.b.2
            @Override // java.lang.Runnable
            public final void run() {
                com.getui.gtc.i.c.b.a((Map<String, String>) mapA);
            }
        });
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    private void a() {
        if (this.f30384a.getAndSet(true) || a(GtcProvider.context())) {
            return;
        }
        a aVar = new a(new e() { // from class: com.getui.gtc.i.d.b.3
            @Override // com.getui.gtc.a.a.e
            public final void a(Object obj) throws Throwable {
                Map map;
                List<String> list;
                if (obj instanceof HashMap) {
                    HashMap map2 = (HashMap) obj;
                    if (map2.size() <= 0 || (map = (Map) map2.get("header")) == null || map.size() <= 0 || (list = (List) map.get("Date")) == null) {
                        return;
                    }
                    for (String str : list) {
                        if (str.contains(u15.f19942b) && str.contains("GMT")) {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy hh:mm:ss z", Locale.ENGLISH);
                            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                            Date date = simpleDateFormat.parse(str);
                            long time = date.getTime();
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            if (jCurrentTimeMillis != time) {
                                long j = time - jCurrentTimeMillis;
                                com.getui.gtc.i.c.a.a("serverDate:" + date + ", localTimeByServerTimeDiff:" + j);
                                DimManager.getInstance().set("dim-2-2-4-1", "dim-2-2-4-1", String.valueOf(j));
                            }
                        }
                    }
                }
            }
        });
        aVar.f30246a = "https://sdk-open-phone.getui.com/";
        ScheduleQueue.getInstance().addSchedule(new com.getui.gtc.a.a.b(aVar));
    }

    private static boolean a(Context context) {
        return CommonUtil.isAppForeground() && Settings.System.getInt(context.getContentResolver(), "auto_time", 1) == 1;
    }

    public final void a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        try {
            DimManager.getInstance().set("dim-2-2-1-1", "dim-2-2-1-1", new JSONObject(map).toString());
            String str = map.get("sdk.gtc.dim.halfclosed.enable");
            if (TextUtils.isEmpty(str) || "none".equals(str)) {
                return;
            }
            a();
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.b(th);
        }
    }
}
