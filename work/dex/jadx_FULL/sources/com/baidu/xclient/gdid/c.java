package com.baidu.xclient.gdid;

import android.content.Context;
import android.util.Base64;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.google.android.exoplayer2.source.rtsp.j;
import com.zj.adlib.y6b;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c f26824a;
    public Context b;

    public static c a() {
        if (f26824a == null) {
            synchronized (c.class) {
                if (f26824a == null) {
                    f26824a = new c();
                }
            }
        }
        return f26824a;
    }

    public void a(Context context) {
        this.b = context;
        b();
    }

    public void b() {
        long jF = e.e().f();
        if (System.currentTimeMillis() - jF < e.e().g()) {
            return;
        }
        c();
    }

    public final void c() {
        String strB;
        try {
            if (com.baidu.xclient.gdid.j.d.a(this.b) && com.baidu.mshield.b.e.a.d(this.b) && (strB = new com.baidu.xclient.gdid.g.a(this.b, null).b()) != null) {
                e.e().a(System.currentTimeMillis());
                if ("".equals(strB)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(strB);
                e.e().a(jSONObject.optInt("1", 1));
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("2");
                if (jSONObjectOptJSONObject != null) {
                    long jOptLong = jSONObjectOptJSONObject.optLong("j");
                    if (jOptLong >= 0) {
                        e.e().d(jOptLong * com.baidu.xclient.gdid.d.a.f26827a);
                    }
                    int iOptInt = jSONObjectOptJSONObject.optInt("m", -1);
                    if (iOptInt != -1) {
                        if (iOptInt == 1) {
                            e.e().a(true);
                        } else {
                            e.e().a(false);
                        }
                    }
                    int iOptInt2 = jSONObjectOptJSONObject.optInt("e", -1);
                    if (iOptInt2 != -1) {
                        if (iOptInt2 == 1) {
                            e.e().b(true);
                        } else {
                            e.e().b(false);
                        }
                    }
                    int iOptInt3 = jSONObjectOptJSONObject.optInt("d", -1);
                    if (iOptInt3 == 1) {
                        e.e().c(true);
                    } else if (iOptInt3 == 0) {
                        e.e().c(false);
                    }
                    int iOptInt4 = jSONObjectOptJSONObject.optInt("i", -1);
                    if (iOptInt4 != -1) {
                        if (iOptInt4 == 1) {
                            e.e().g(true);
                        } else {
                            e.e().g(false);
                        }
                    }
                    int iOptInt5 = jSONObjectOptJSONObject.optInt("w", -1);
                    if (iOptInt5 != -1) {
                        if (iOptInt5 == 1) {
                            e.e().i(true);
                        } else {
                            e.e().i(false);
                        }
                    }
                    String strOptString = jSONObjectOptJSONObject.optString("p", "-1");
                    if (!strOptString.equals("-1")) {
                        e.e().f(strOptString);
                    }
                    e.e().b(Base64.encodeToString(jSONObjectOptJSONObject.toString().getBytes(), 1));
                    int iOptInt6 = jSONObjectOptJSONObject.optInt(j.b, -1);
                    if (iOptInt6 == 1) {
                        e.e().h(true);
                    } else if (iOptInt6 == 0) {
                        e.e().h(false);
                    }
                    int iOptInt7 = jSONObjectOptJSONObject.optInt("a", -1);
                    if (iOptInt7 == 1) {
                        e.e().j(true);
                    } else if (iOptInt7 == 0) {
                        e.e().j(false);
                    }
                    int iOptInt8 = jSONObjectOptJSONObject.optInt("t", -1);
                    if (iOptInt8 == 1) {
                        e.e().k(true);
                    } else if (iOptInt8 == 0) {
                        e.e().k(false);
                    }
                    int iOptInt9 = jSONObjectOptJSONObject.optInt("n", -1);
                    if (iOptInt9 == 1) {
                        e.e().l(true);
                    } else if (iOptInt9 == 0) {
                        e.e().l(false);
                    }
                    int iOptInt10 = jSONObjectOptJSONObject.optInt(y6b.g, -1);
                    if (iOptInt10 == 1) {
                        e.e().e(true);
                    } else if (iOptInt10 == 0) {
                        e.e().e(false);
                    }
                    int iOptInt11 = jSONObjectOptJSONObject.optInt("f", -1);
                    if (iOptInt11 == 1) {
                        e.e().f(true);
                    } else if (iOptInt11 == 0) {
                        e.e().f(false);
                    }
                    int iOptInt12 = jSONObjectOptJSONObject.optInt("aa", -1);
                    if (iOptInt12 == 1) {
                        e.e().d(true);
                    } else if (iOptInt12 == 0) {
                        e.e().d(false);
                    }
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("6");
                if (jSONObjectOptJSONObject2 != null) {
                    e.e().b(((long) jSONObjectOptJSONObject2.optInt("1", 0)) * com.baidu.xclient.gdid.d.a.f26827a);
                    e.e().f(((long) jSONObjectOptJSONObject2.optInt("2", 0)) * com.baidu.xclient.gdid.d.a.f26827a);
                    e.e().h(((long) jSONObjectOptJSONObject2.optInt("4", 0)) * com.baidu.xclient.gdid.d.a.f26827a);
                }
                JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("7");
                if (jSONObjectOptJSONObject3 != null) {
                    e.e().e(jSONObjectOptJSONObject3.optInt("s", -1));
                    e.e().b(jSONObjectOptJSONObject3.optInt("d", -1));
                    e.e().c(jSONObjectOptJSONObject3.optInt("j", -1));
                    e.e().d(jSONObjectOptJSONObject3.optInt("c", -1));
                    e.e().f(jSONObjectOptJSONObject3.optInt(j.b, -1));
                }
                String strOptString2 = jSONObject.optString("5");
                if (e.e().j().equals(strOptString2)) {
                    return;
                }
                e.e().a(strOptString2);
                String strOptString3 = jSONObject.optString("3", "");
                String strOptString4 = jSONObject.optString("4", "");
                String strOptString5 = jSONObject.optString(PrepareException.ERROR_AUTH_FAIL, "");
                e.e().d(strOptString3);
                e.e().e(strOptString4);
                e.e().g(strOptString5);
            }
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
    }
}
