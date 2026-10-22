package com.baidu.mshield.rp.f;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mshield.utility.b;
import com.baidu.mshield.utility.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f26717a;
    public HandlerC0280a b = new HandlerC0280a(e.a());
    public com.baidu.mshield.sharedpreferences.a c;
    public Context d;
    public com.baidu.mshield.rp.e.a.a e;

    /* JADX INFO: renamed from: com.baidu.mshield.rp.f.a$a, reason: collision with other inner class name */
    public class HandlerC0280a extends Handler {
        public HandlerC0280a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        a.this.f();
                        break;
                    case 1:
                        com.baidu.mshield.rp.c.a.a(a.this.d).a((com.baidu.mshield.rp.d.a) message.obj);
                        com.baidu.mshield.b.c.a.b("sj-trigger report f ACTION_REPORT_RECORD");
                        Message message2 = new Message();
                        message2.what = 10;
                        sendMessage(message2);
                        break;
                    case 2:
                        com.baidu.mshield.b.c.a.b("sj-trigger reportACTION_REPORT_DATA");
                        a.this.a();
                        a.this.f();
                        a.this.b(0, com.baidu.mshield.utility.a.d(a.this.d));
                        break;
                    case 3:
                        com.baidu.mshield.rp.b.a aVar = (com.baidu.mshield.rp.b.a) message.obj;
                        if (aVar != null) {
                            a.this.b(aVar);
                            break;
                        }
                        break;
                    case 4:
                        String strValueOf = String.valueOf(message.obj);
                        if (!TextUtils.isEmpty(strValueOf)) {
                            com.baidu.mshield.rp.c.a.a(a.this.d).a(com.baidu.mshield.b.f.e.a(strValueOf));
                            break;
                        }
                        break;
                    case 5:
                        a.this.a();
                        a.this.d();
                        Message message3 = new Message();
                        message3.what = 10;
                        sendMessage(message3);
                        break;
                    case 6:
                        a aVar2 = a.this;
                        aVar2.b(1, com.baidu.mshield.utility.a.d(aVar2.d));
                        break;
                    case 7:
                        a.this.f();
                        a aVar3 = a.this;
                        aVar3.b(1, com.baidu.mshield.utility.a.d(aVar3.d));
                        break;
                    case 8:
                        a aVar4 = a.this;
                        aVar4.b(3, com.baidu.mshield.utility.a.d(aVar4.d));
                        break;
                    case 9:
                        a.this.b(0, 2);
                        break;
                    case 10:
                        int iD = com.baidu.mshield.utility.a.d(a.this.d);
                        if (2 == iD) {
                            com.baidu.mshield.b.c.a.b("sj-trigger report wifi ");
                            if (com.baidu.mshield.rp.c.a.a(a.this.d).b() < com.baidu.mshield.sharedpreferences.a.a(a.this.d).g()) {
                                List<com.baidu.mshield.rp.d.a> listA = com.baidu.mshield.rp.c.a.a(a.this.d).a(true, iD);
                                com.baidu.mshield.b.c.a.b("sj-trigger report Dela " + listA.size());
                                if (listA.size() > 0) {
                                    com.baidu.mshield.b.c.a.b("sj-trigger reportde condi");
                                    a.this.b(0, iD);
                                }
                            } else {
                                com.baidu.mshield.b.c.a.b("sj-trigger reportrc condi");
                                a.this.b(0, iD);
                            }
                        } else if (1 == iD) {
                            com.baidu.mshield.b.c.a.b("sj-trigger reportde re");
                            a.this.b(4, iD);
                        }
                        break;
                    case 11:
                        String strValueOf2 = String.valueOf(message.obj);
                        if (!a.this.e.a(new JSONArray().put(com.baidu.mshield.utility.a.a(a.this.d, new JSONObject(strValueOf2))).toString(), a.this.a(new JSONObject(strValueOf2)), "3")) {
                            com.baidu.mshield.utility.a.b(a.this.d, strValueOf2);
                        }
                        break;
                    default:
                        break;
                }
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
            }
        }
    }

    public a(Context context) {
        this.d = context.getApplicationContext();
        this.c = com.baidu.mshield.sharedpreferences.a.a(context);
        this.e = new com.baidu.mshield.rp.e.a.a(this.d);
    }

    public final void f() {
        try {
            List<com.baidu.mshield.rp.b.a> listP = this.c.p();
            if (listP == null) {
                return;
            }
            Iterator<com.baidu.mshield.rp.b.a> it = listP.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public final void b(int i, int i2) {
        List<com.baidu.mshield.rp.d.a> listB;
        try {
            if (i2 == 0) {
                com.baidu.mshield.b.c.a.b("sj-trigger EVENT_NETWORK_NONE ");
                return;
            }
            if (i == 1) {
                listB = com.baidu.mshield.rp.c.a.a(this.d).c();
                if (1 == i2) {
                    com.baidu.mshield.b.c.a.b("sj-trigger report 3g " + listB.size());
                }
            } else if (i == 3) {
                listB = com.baidu.mshield.rp.c.a.a(this.d).a(false, i2);
            } else if (i == 4) {
                listB = com.baidu.mshield.rp.c.a.a(this.d).a(true, i2);
                com.baidu.mshield.b.c.a.b("sj-trigger report 3g to report " + listB.size());
            } else {
                listB = com.baidu.mshield.rp.c.a.a(this.d).b(i2);
            }
            if (listB != null && listB.size() > 0) {
                long jD = this.c.d();
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jC = this.c.c();
                int iD = this.c.D();
                if (jC == 0) {
                    this.c.c(jCurrentTimeMillis);
                    jC = jCurrentTimeMillis;
                }
                com.baidu.mshield.b.c.a.b("begintime : " + jCurrentTimeMillis);
                com.baidu.mshield.b.c.a.b("last rp len : " + jD);
                if (jCurrentTimeMillis - jC < 86400000) {
                    if (i == 3) {
                        int iE = this.c.E();
                        if (iE >= 5) {
                            return;
                        } else {
                            this.c.g(iE + 1);
                        }
                    }
                    if (jD > iD * 1048576) {
                        com.baidu.mshield.b.c.a.b("rp over limit : maxday :  : " + jD);
                        return;
                    }
                } else {
                    this.c.d(0L);
                    this.c.c(jCurrentTimeMillis);
                    if (i == 3) {
                        this.c.g(0);
                    }
                }
                a(listB, i2, jD);
                List<com.baidu.mshield.rp.d.a> listA = a(i, i2);
                while (listA != null && listA.size() != 0) {
                    a(listA, i2, jD);
                    if (!b()) {
                        com.baidu.mshield.b.c.a.b("324 checkReportFail");
                        return;
                    }
                    listA = a(i, i2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void c() {
        this.e.a();
        this.c.a(System.currentTimeMillis());
    }

    public final void d() {
        try {
            com.baidu.mshield.sharedpreferences.a aVarA = com.baidu.mshield.sharedpreferences.a.a(this.d);
            int iJ = aVarA.J();
            com.baidu.mshield.b.c.a.b(" 2" + Integer.toString(iJ));
            long jCurrentTimeMillis = System.currentTimeMillis() - aVarA.G();
            long j = (long) (iJ * 3600000);
            if (jCurrentTimeMillis >= j) {
                b.a(this.d).d();
                com.baidu.mshield.utility.a.a(this.d, j);
                aVarA.b(System.currentTimeMillis());
            } else {
                com.baidu.mshield.utility.a.a(this.d, j - jCurrentTimeMillis);
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public void e() {
        Message message = new Message();
        message.what = 7;
        a(message);
    }

    public void a(boolean z) {
        Message message = new Message();
        message.what = 5;
        a(message);
    }

    public void a(Message message) {
        this.b.sendMessage(message);
    }

    public final String a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("Common_section");
            if (jSONObject2 != null && jSONObject2.has("12")) {
                return jSONObject2.optString("12", "");
            }
            return null;
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return null;
        }
    }

    public final void a() {
        if (System.currentTimeMillis() - this.c.B() < 86400000) {
            return;
        }
        c();
    }

    public final List<com.baidu.mshield.rp.d.a> a(int i, int i2) {
        if (i == 0 && i2 == 2) {
            return com.baidu.mshield.rp.c.a.a(this.d).b(i2);
        }
        return null;
    }

    public final void a(List<com.baidu.mshield.rp.d.a> list, int i, long j) {
        try {
            int iH = this.c.H();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i2 = 0;
            for (com.baidu.mshield.rp.d.a aVar : list) {
                try {
                    String string = com.baidu.mshield.utility.a.a(this.d, new JSONObject(aVar.d)).toString();
                    try {
                        JSONObject jSONObject = new JSONObject(string);
                        int length = string.length() + i2;
                        if (length >= 1048576 * iH) {
                            com.baidu.mshield.b.c.a.b("rp once over limit : maxOnece : " + iH + " : " + length);
                            break;
                        }
                        arrayList.add(Integer.valueOf(aVar.f26714a));
                        arrayList2.add(new com.baidu.mshield.rp.d.b(jSONObject, aVar.j, aVar.f26714a));
                        i2 = length;
                    } catch (Throwable th) {
                        com.baidu.mshield.utility.a.a(th);
                    }
                } catch (Throwable th2) {
                    com.baidu.mshield.utility.a.a(th2);
                }
            }
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            JSONArray jSONArray = new JSONArray();
            ArrayList arrayList3 = new ArrayList();
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                com.baidu.mshield.rp.d.b bVar = (com.baidu.mshield.rp.d.b) arrayList2.get(i3);
                if (bVar != null) {
                    String strC = bVar.c();
                    if (TextUtils.isEmpty(strC)) {
                        jSONArray.put(bVar.b());
                        arrayList3.add(Integer.valueOf(bVar.a()));
                    } else {
                        if (map.containsKey(strC)) {
                            JSONArray jSONArray2 = (JSONArray) map.get(strC);
                            if (jSONArray2 == null) {
                                jSONArray2 = new JSONArray();
                            }
                            jSONArray2.put(bVar.b());
                            map.put(strC, jSONArray2);
                        } else {
                            JSONArray jSONArray3 = new JSONArray();
                            jSONArray3.put(bVar.b());
                            map.put(strC, jSONArray3);
                        }
                        ArrayList arrayList4 = (ArrayList) map2.get(strC);
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList4.add(Integer.valueOf(bVar.a()));
                        map2.put(strC, arrayList4);
                    }
                }
            }
            if (jSONArray.length() > 0) {
                if (this.e.a(jSONArray.toString(), null, "1")) {
                    com.baidu.mshield.rp.c.a.a(this.d).a(arrayList3);
                } else {
                    f26717a = System.currentTimeMillis();
                    com.baidu.mshield.b.c.a.b("427 report fail,sFailTime = " + f26717a);
                }
            }
            if (map.size() > 0) {
                for (String str : map.keySet()) {
                    JSONArray jSONArray4 = (JSONArray) map.get(str);
                    if (jSONArray4 != null && jSONArray4.length() > 0) {
                        if (this.e.a(jSONArray4.toString(), str, "2")) {
                            com.baidu.mshield.rp.c.a.a(this.d).a((List<Integer>) map2.get(str));
                        } else {
                            f26717a = System.currentTimeMillis();
                            com.baidu.mshield.b.c.a.b("441 report fail,sFailTime = " + f26717a);
                        }
                    }
                }
            }
            com.baidu.mshield.rp.c.a.a(this.d).a();
            if (2 != i) {
                this.c.d(((long) i2) + j);
            }
        } catch (Throwable th3) {
            com.baidu.mshield.utility.a.a(th3);
        }
    }

    public final boolean b() {
        com.baidu.mshield.b.c.a.b("checkReportFail,sFailTime=" + f26717a);
        if (f26717a > 0) {
            if (System.currentTimeMillis() - f26717a < 300000) {
                com.baidu.mshield.b.c.a.b("checkReportFail:false");
                return false;
            }
            f26717a = 0L;
        }
        com.baidu.mshield.b.c.a.b("checkReportFail:true");
        return true;
    }

    public final void b(com.baidu.mshield.rp.b.a aVar) {
        try {
            String strB = this.c.b(aVar.e);
            com.baidu.mshield.rp.d.a aVar2 = new com.baidu.mshield.rp.d.a();
            aVar2.b = aVar.e;
            aVar2.g = 0;
            aVar2.c = 1;
            aVar2.e = System.currentTimeMillis();
            aVar2.f = 1;
            aVar2.d = com.baidu.mshield.utility.a.a(this.d, aVar, strB, false).toString();
            com.baidu.mshield.rp.c.a.a(this.d).a(aVar2);
            this.c.a(aVar.e, true);
            String strA = com.baidu.mshield.b.f.e.a(com.baidu.mshield.utility.a.b(this.d).toString());
            if (com.baidu.mshield.rp.c.a.a(this.d).b(strA)) {
                aVar2.b = "1067001";
                Context context = this.d;
                aVar2.d = com.baidu.mshield.utility.a.a(context, aVar.f26712a, aVar.c, "1067001", com.baidu.mshield.utility.a.b(context).toString()).toString();
                com.baidu.mshield.rp.c.a.a(this.d).a(aVar2);
                com.baidu.mshield.rp.c.a.a(this.d).a(strA);
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public final void a(com.baidu.mshield.rp.b.a aVar) {
        try {
            String strA = com.baidu.mshield.utility.a.a();
            if ("4.2.6".equals(this.c.C())) {
                com.baidu.mshield.b.c.a.b("same version=4.2.6");
                if (this.c.d(aVar.d).equals(strA)) {
                    com.baidu.mshield.b.c.a.b("same version has reported!");
                    return;
                }
                com.baidu.mshield.b.c.a.b("same version new report");
            } else {
                com.baidu.mshield.b.c.a.b("new version set=4.2.6");
                this.c.n("4.2.6");
            }
            String strB = this.c.b(aVar.d);
            com.baidu.mshield.rp.d.a aVar2 = new com.baidu.mshield.rp.d.a();
            aVar2.b = aVar.d;
            aVar2.g = 0;
            aVar2.c = 2;
            aVar2.e = System.currentTimeMillis();
            aVar2.f = 1;
            aVar2.i = 5;
            aVar2.d = com.baidu.mshield.utility.a.a(this.d, aVar, strB, true).toString();
            com.baidu.mshield.rp.c.a.a(this.d).a(aVar2);
            String strA2 = com.baidu.mshield.b.f.e.a(com.baidu.mshield.utility.a.b(this.d).toString());
            if (com.baidu.mshield.rp.c.a.a(this.d).b(strA2)) {
                aVar2.b = "1067001";
                aVar2.i = 0;
                Context context = this.d;
                aVar2.d = com.baidu.mshield.utility.a.a(context, aVar.f26712a, aVar.c, "1067001", com.baidu.mshield.utility.a.b(context).toString()).toString();
                com.baidu.mshield.rp.c.a.a(this.d).a(aVar2);
                com.baidu.mshield.rp.c.a.a(this.d).a(strA2);
            }
            this.c.c(aVar.d, strA);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }
}
