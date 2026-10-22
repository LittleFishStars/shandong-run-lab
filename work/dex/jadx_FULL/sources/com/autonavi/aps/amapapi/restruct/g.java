package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.text.TextUtils;
import com.zj.adlib.m4b;
import com.zj.adlib.mhb;
import com.zj.adlib.phb;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class g {
    private File b;
    private Handler d;
    private String e;
    private boolean f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedList<f> f26187a = new LinkedList<>();
    private boolean c = false;
    private Runnable g = new Runnable() { // from class: com.autonavi.aps.amapapi.restruct.g.1
        @Override // java.lang.Runnable
        public final void run() {
            if (g.this.c) {
                return;
            }
            if (g.this.f) {
                g.this.b();
                g.d(g.this);
            }
            if (g.this.d != null) {
                g.this.d.postDelayed(g.this.g, 60000L);
            }
        }
    };

    public g(Context context, Handler handler) {
        this.e = null;
        this.d = handler;
        String path = context.getFilesDir().getPath();
        if (this.e == null) {
            this.e = com.autonavi.aps.amapapi.utils.i.l(context);
        }
        try {
            this.b = new File(path, "hisloc");
        } catch (Throwable th) {
            phb.a(th);
        }
        a();
        Handler handler2 = this.d;
        if (handler2 != null) {
            handler2.removeCallbacks(this.g);
            this.d.postDelayed(this.g, 60000L);
        }
    }

    public static /* synthetic */ boolean d(g gVar) {
        gVar.f = false;
        return false;
    }

    public final void a(boolean z) {
        if (!z) {
            this.g.run();
        }
        Handler handler = this.d;
        if (handler != null) {
            handler.removeCallbacks(this.g);
        }
        this.c = true;
    }

    public final void b(f fVar) {
        if (this.f26187a.size() > 0) {
            int i = fVar.f26186a;
            if (i != 6 && i != 5) {
                if (this.f26187a.contains(fVar)) {
                    return;
                }
                if (this.f26187a.size() >= 10) {
                    this.f26187a.removeFirst();
                }
                this.f26187a.add(fVar);
                this.f = true;
                return;
            }
            f last = this.f26187a.getLast();
            if (last.c == fVar.c && last.b == fVar.b && last.e == fVar.e) {
                return;
            }
            if (this.f26187a.size() >= 10) {
                this.f26187a.removeFirst();
            }
            this.f26187a.add(fVar);
            this.f = true;
        }
    }

    public final void a(f fVar) {
        f fVar2 = null;
        f fVar3 = null;
        int i = 0;
        for (f fVar4 : this.f26187a) {
            if (fVar4.f26186a == 1) {
                if (fVar3 == null) {
                    fVar3 = fVar4;
                }
                i++;
                fVar2 = fVar4;
            }
        }
        if (fVar2 != null) {
            new Location("gps");
            if (fVar.d - fVar2.d < 20000 && com.autonavi.aps.amapapi.utils.i.a(new double[]{fVar.b, fVar.c, fVar2.b, fVar2.c}) < 20.0f) {
                return;
            }
        }
        if (i >= 5) {
            this.f26187a.remove(fVar3);
        }
        if (this.f26187a.size() >= 10) {
            this.f26187a.removeFirst();
        }
        this.f26187a.add(fVar);
        this.f = true;
    }

    private static boolean b(ArrayList<d> arrayList, ArrayList<mhb> arrayList2) {
        return arrayList == null || arrayList.size() <= 0 || arrayList2 == null || arrayList2.size() <= 0 || (((long) arrayList.size()) < 4 && ((long) arrayList2.size()) < 20);
    }

    public final List<f> a(ArrayList<d> arrayList, ArrayList<mhb> arrayList2) {
        if (!b(arrayList, arrayList2)) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList3 = new ArrayList();
        int i = 0;
        for (f fVar : this.f26187a) {
            if (jCurrentTimeMillis - fVar.d < 21600000000L) {
                arrayList3.add(fVar);
                i++;
            }
            if (i == 10) {
                break;
            }
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        StringBuilder sb = new StringBuilder();
        Iterator<f> it = this.f26187a.iterator();
        while (it.hasNext()) {
            try {
                sb.append(m4b.f(com.autonavi.aps.amapapi.security.a.a(it.next().a().getBytes("UTF-8"), this.e)) + "\n");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String string = sb.toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        com.autonavi.aps.amapapi.utils.i.a(this.b, string);
    }

    private void a() {
        LinkedList<f> linkedList = this.f26187a;
        if (linkedList == null || linkedList.size() <= 0) {
            Iterator<String> it = com.autonavi.aps.amapapi.utils.i.a(this.b).iterator();
            while (it.hasNext()) {
                try {
                    String str = new String(com.autonavi.aps.amapapi.security.a.b(m4b.g(it.next()), this.e), "UTF-8");
                    f fVar = new f();
                    fVar.a(new JSONObject(str));
                    this.f26187a.add(fVar);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
