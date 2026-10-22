package com.getui.gtc.g;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.getui.gtc.api.SdkInfo;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.util.ScheduleQueue;
import com.getui.gtc.f.e;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f30366a;
    String b;
    final Map<String, com.getui.gtc.entity.a.C0657a> c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f30372a = new c(0);
    }

    private c() {
        this.c = new HashMap();
        try {
            this.f30366a = GtcProvider.context().getFilesDir().getAbsolutePath();
            File file = new File(this.f30366a);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.b = this.f30366a + File.separator + "libs";
            File file2 = new File(this.b);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            HashSet<String> hashSet = new HashSet(com.getui.gtc.e.c.a.f30351a.f30350a.n);
            for (String str : hashSet) {
                if (a(str)) {
                    com.getui.gtc.e.c.a.f30351a.f30350a.f(str);
                    com.getui.gtc.i.c.a.a("remove: ".concat(String.valueOf(hashSet)));
                }
            }
            com.getui.gtc.dyc.b.a.a(GtcProvider.context(), new e() { // from class: com.getui.gtc.g.c.1
                @Override // com.getui.gtc.f.e
                public final void a(String str2) {
                }

                @Override // com.getui.gtc.f.e
                public final void a(Map<String, String> map, Map<String, String> map2) {
                    if (map == null || map2 == null) {
                        return;
                    }
                    com.getui.gtc.entity.a aVarA = com.getui.gtc.entity.a.a(map2);
                    com.getui.gtc.entity.a aVarA2 = com.getui.gtc.entity.a.a(map);
                    if (aVarA2 != null) {
                        int size = aVarA2.f30354a.size();
                        HashSet hashSet2 = new HashSet();
                        for (int i = 0; i < size; i++) {
                            com.getui.gtc.entity.a.C0657a c0657aA = aVarA2.a(i);
                            if (aVarA == null || aVarA.b(c0657aA.f30355a) == null || !aVarA.b(c0657aA.f30355a).b.equalsIgnoreCase(c0657aA.b) || !aVarA.b(c0657aA.f30355a).c.equalsIgnoreCase(c0657aA.c)) {
                                hashSet2.add(c0657aA.c);
                            }
                        }
                        com.getui.gtc.i.c.a.a("wait remove: ".concat(String.valueOf(hashSet2)));
                        com.getui.gtc.e.c.a.f30351a.f30350a.a(hashSet2);
                    }
                    if (aVarA != null) {
                        int size2 = aVarA.f30354a.size();
                        for (int i2 = 0; i2 < size2; i2++) {
                            com.getui.gtc.entity.a.C0657a c0657aA2 = aVarA.a(i2);
                            if (!c.this.a(c0657aA2)) {
                                try {
                                    com.getui.gtc.h.b.a(c0657aA2, c.this.b + File.separator + c0657aA2.c);
                                } catch (Exception e) {
                                    com.getui.gtc.i.c.a.b(e);
                                }
                            }
                        }
                    }
                }
            }.c);
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c(th);
        }
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    private void b(SdkInfo sdkInfo) {
        List<com.getui.gtc.entity.a.C0657a> stubs = sdkInfo.getStubs();
        for (int i = 0; i < stubs.size(); i++) {
            final com.getui.gtc.entity.a.C0657a c0657a = stubs.get(i);
            if (!b(c0657a)) {
                this.c.put(c0657a.d, c0657a);
                if (c0657a.j) {
                    b.a(GtcProvider.context(), null, null, c0657a.d, sdkInfo.getAppid(), sdkInfo.getCid(), new com.getui.gtc.g.a.b() { // from class: com.getui.gtc.g.c.2
                        @Override // com.getui.gtc.g.a.b
                        public final void a(boolean z) {
                            if (z) {
                                return;
                            }
                            c.this.c.remove(c0657a.d);
                        }
                    });
                } else {
                    try {
                        b.a(GtcProvider.context(), c0657a.d, sdkInfo.getAppid(), sdkInfo.getCid());
                    } catch (Throwable th) {
                        this.c.remove(c0657a.d);
                        com.getui.gtc.i.c.a.b("local gtcFile failed: ".concat(String.valueOf(th)));
                    }
                }
            }
        }
    }

    private boolean b(com.getui.gtc.entity.a.C0657a c0657a) {
        return this.c.containsKey(c0657a.d);
    }

    private com.getui.gtc.entity.a c(final SdkInfo sdkInfo) {
        Map<String, String> mapA = com.getui.gtc.f.c.a(sdkInfo, new com.getui.gtc.f.c.a() { // from class: com.getui.gtc.g.c.3
            @Override // com.getui.gtc.f.c.a
            public final void a(Map<String, String> map) {
                c.this.a(sdkInfo, com.getui.gtc.entity.a.a(map));
            }
        });
        if (mapA == null) {
            return null;
        }
        return com.getui.gtc.entity.a.a(mapA);
    }

    private static boolean c(com.getui.gtc.entity.a.C0657a c0657a) {
        c0657a.d.endsWith(".gws.stub.PushExtension");
        return false;
    }

    public final String a(SdkInfo sdkInfo, com.getui.gtc.entity.a.C0657a c0657a) {
        com.getui.gtc.entity.a aVarA;
        com.getui.gtc.entity.a.C0657a c0657aB;
        File file = new File(this.b + File.separator + c0657a.c);
        if (a(c0657a)) {
            return file.getAbsolutePath();
        }
        try {
            Map<String, String> mapA = com.getui.gtc.dyc.b.a.a(GtcProvider.context(), sdkInfo.getModuleName());
            if (mapA == null || (aVarA = com.getui.gtc.entity.a.a(mapA)) == null || (c0657aB = aVarA.b(c0657a.f30355a)) == null || !c0657aB.e.equals(c0657a.e)) {
                return null;
            }
            com.getui.gtc.h.b.a(c0657a, file.getAbsolutePath());
            if (com.getui.gtc.i.b.a.a(file.getAbsolutePath()).equals(c0657a.e)) {
                return file.getAbsolutePath();
            }
            com.getui.gtc.i.b.a.a(file);
            throw new Exception("The net gtcFile save failed or has a wrong checksum");
        } catch (Exception e) {
            com.getui.gtc.i.c.a.b(e);
            return null;
        }
    }

    public final void a(SdkInfo sdkInfo) {
        b(sdkInfo);
        a(sdkInfo, c(sdkInfo));
    }

    public final void a(final SdkInfo sdkInfo, com.getui.gtc.entity.a aVar) {
        if (aVar == null) {
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList();
        for (int i = 0; i < aVar.f30354a.size(); i++) {
            final com.getui.gtc.entity.a.C0657a c0657aA = aVar.a(i);
            if (!aVar.b && c(c0657aA)) {
                com.getui.gtc.i.c.a.a("no push, no gws");
            } else if (!b(c0657aA)) {
                final long jA = com.getui.gtc.e.c.a.f30351a.b.a(c0657aA.f30355a);
                if ((c0657aA.g <= 0 || jA <= 0 || System.currentTimeMillis() - jA <= c0657aA.g) && (jA <= 0 || !c0657aA.i)) {
                    this.c.put(c0657aA.d, c0657aA);
                    ScheduleQueue.getInstance().addSchedule(new Runnable() { // from class: com.getui.gtc.g.c.4
                        @Override // java.lang.Runnable
                        public final void run() throws Throwable {
                            String strA = c.this.a(sdkInfo, c0657aA);
                            if (strA == null) {
                                c.this.c.remove(c0657aA.d);
                                return;
                            }
                            File file = new File(strA);
                            final File file2 = new File(strA + com.getui.gtc.c.a.b);
                            com.getui.gtc.i.a.a.a(file, file2, c0657aA.f);
                            if (c0657aA.j) {
                                b.a(GtcProvider.context(), file2.getAbsolutePath(), c.this.f30366a, c0657aA.d, sdkInfo.getAppid(), sdkInfo.getCid(), new com.getui.gtc.g.a.b() { // from class: com.getui.gtc.g.c.4.1
                                    @Override // com.getui.gtc.g.a.b
                                    public final void a(boolean z) {
                                        com.getui.gtc.i.b.a.a(file2);
                                        if (!z) {
                                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                            c.this.c.remove(c0657aA.d);
                                        } else if (jA == 0) {
                                            com.getui.gtc.e.c.a.f30351a.b.a(c0657aA.f30355a, System.currentTimeMillis());
                                        }
                                    }
                                });
                                return;
                            }
                            try {
                                b.a(GtcProvider.context(), file2.getAbsolutePath(), c.this.f30366a, c0657aA.d, sdkInfo.getAppid(), sdkInfo.getCid());
                                if (jA == 0) {
                                    com.getui.gtc.e.c.a.f30351a.b.a(c0657aA.f30355a, System.currentTimeMillis());
                                }
                                com.getui.gtc.i.b.a.a(file2);
                            } catch (Throwable th) {
                                try {
                                    c.this.c.remove(c0657aA.d);
                                    com.getui.gtc.i.c.a.b("net gtcFile filed: ".concat(String.valueOf(th)));
                                } finally {
                                    com.getui.gtc.i.b.a.a(file2);
                                }
                            }
                        }
                    });
                } else {
                    arrayList.add(Integer.valueOf(i));
                }
            }
        }
        for (Integer num : arrayList) {
            a(aVar.a(num.intValue()).c);
            aVar.c(num.intValue());
        }
    }

    public final boolean a(com.getui.gtc.entity.a.C0657a c0657a) {
        File file = new File(this.b + File.separator + c0657a.c);
        if (file.exists() && file.isFile()) {
            return com.getui.gtc.i.b.a.a(file.getAbsolutePath()).equals(c0657a.e);
        }
        return false;
    }

    public final boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            com.getui.gtc.i.b.a.a(this.f30366a, str);
            String strA = com.getui.gtc.g.a.a(str);
            if (TextUtils.isEmpty(strA)) {
                return true;
            }
            com.getui.gtc.i.b.a.a(new File(this.f30366a + WVNativeCallbackUtil.SEPERATER + strA));
            return true;
        } catch (Exception e) {
            com.getui.gtc.i.c.a.c(e);
            return false;
        }
    }
}
