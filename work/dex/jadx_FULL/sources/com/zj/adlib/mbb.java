package com.zj.adlib;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003l.it;
import com.amap.api.col.p0003l.z;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class mbb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f43264a = 20;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static WeakReference<k9b> f18169a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f18170a = false;
    public static int b = 20;
    public static int c;

    public static void b(Context context) {
        z.g().b(new a(context, a.N));
    }

    public static /* synthetic */ void c(Context context, byte[] bArr) throws IOException {
        k9b k9bVarA = nbb.a(f18169a);
        nbb.f(context, k9bVarA, y6b.h, 1000, 307200, "2");
        if (k9bVarA.f17613a == null) {
            k9bVarA.f17613a = new t8b();
        }
        try {
            l9b.c(Integer.toString(new Random().nextInt(100)) + Long.toString(System.nanoTime()), bArr, k9bVarA);
        } catch (Throwable th) {
            a7b.m(th, "stm", "wts");
        }
    }

    public static synchronized void d(lbb lbbVar, Context context) {
        z.g().b(new a(context, a.L, lbbVar));
    }

    public static synchronized void e(List<lbb> list, Context context) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    z.g().b(new a(context, a.M, list));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void f(boolean z, int i) {
        f18170a = z;
        c = Math.max(0, i);
    }

    public static synchronized void h(List<lbb> list, Context context) {
        try {
            List<lbb> listQ = g9b.q();
            if (listQ != null && listQ.size() > 0) {
                list.addAll(listQ);
            }
        } catch (Throwable unused) {
        }
        e(list, context);
    }

    public static class a extends it {
        public static int L = 1;
        public static int M = 2;
        public static int N = 3;
        public int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f43265a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public lbb f18171a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public List<lbb> f18172a;

        public a(Context context, int i) {
            this.f43265a = context;
            this.K = i;
        }

        @Override // com.amap.api.col.p0003l.it
        public final void runTask() {
            lbb lbbVar;
            Throwable th;
            int i = this.K;
            if (i == 1) {
                try {
                    if (this.f43265a != null && this.f18171a != null) {
                        synchronized (mbb.class) {
                            Context context = this.f43265a;
                            if (context != null && (lbbVar = this.f18171a) != null) {
                                mbb.c(context, lbbVar.b());
                                return;
                            }
                            return;
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    a7b.m(th2, "stm", "as");
                    return;
                }
            }
            if (i != 2) {
                if (i == 3) {
                    try {
                        if (this.f43265a == null) {
                            return;
                        }
                        k9b k9bVarA = nbb.a(mbb.f18169a);
                        nbb.f(this.f43265a, k9bVarA, y6b.h, 1000, 307200, "2");
                        if (k9bVarA.f17614a == null) {
                            k9bVarA.f17614a = new obb(new ubb(this.f43265a, new pbb(new vbb(new wbb()))));
                        }
                        k9bVarA.b = 3600000;
                        if (TextUtils.isEmpty(k9bVarA.c)) {
                            k9bVarA.c = "cKey";
                        }
                        if (k9bVarA.f17615a == null) {
                            Context context2 = this.f43265a;
                            k9bVarA.f17615a = new acb(context2, k9bVarA.b, k9bVarA.c, new xbb(k9bVarA.f17616a, new ybb(context2, mbb.f18170a, mbb.b * 1024, mbb.f43264a * 1024, "staticUpdate", mbb.c * 1024)));
                        }
                        l9b.a(k9bVarA);
                        return;
                    } catch (Throwable th3) {
                        a7b.m(th3, "stm", "usd");
                        return;
                    }
                }
                return;
            }
            try {
                synchronized (mbb.class) {
                    if (this.f18172a != null && this.f43265a != null) {
                        byte[] byteArray = new byte[0];
                        ByteArrayOutputStream byteArrayOutputStream = null;
                        try {
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                            try {
                                for (lbb lbbVar2 : this.f18172a) {
                                    if (lbbVar2 != null) {
                                        byteArrayOutputStream2.write(lbbVar2.b());
                                    }
                                }
                                byteArray = byteArrayOutputStream2.toByteArray();
                                try {
                                    byteArrayOutputStream2.close();
                                } catch (Throwable th4) {
                                    th = th4;
                                    th.printStackTrace();
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                try {
                                    a7b.m(th, "stm", "aStB");
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Throwable th6) {
                                            th = th6;
                                            th.printStackTrace();
                                        }
                                    }
                                } catch (Throwable th7) {
                                    if (byteArrayOutputStream == null) {
                                        throw th7;
                                    }
                                    try {
                                        byteArrayOutputStream.close();
                                        throw th7;
                                    } catch (Throwable th8) {
                                        th8.printStackTrace();
                                        throw th7;
                                    }
                                }
                            }
                        } catch (Throwable th9) {
                            th = th9;
                        }
                        mbb.c(this.f43265a, byteArray);
                    }
                }
            } catch (Throwable th10) {
                a7b.m(th10, "stm", "apb");
            }
        }

        public a(Context context, int i, List<lbb> list) {
            this(context, i);
            this.f18172a = list;
        }

        public a(Context context, int i, lbb lbbVar) {
            this(context, i);
            this.f18171a = lbbVar;
        }
    }
}
