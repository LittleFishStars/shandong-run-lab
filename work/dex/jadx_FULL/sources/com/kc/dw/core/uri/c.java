package com.kc.dw.core.uri;

import android.content.Context;
import android.net.Uri;
import com.kc.dw.core.ad.AdSlot;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c {
    public static c c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f39334a = c.class.getSimpleName();
    public ArrayList<b> b = new ArrayList<>();

    public c() {
        a("com.kc.dw.core.uri.LiveProcessor");
        this.b.add(new a());
    }

    public void a(Context context, String str, AdSlot adSlot) {
        boolean z;
        Uri uri = Uri.parse(str);
        if (uri.getScheme() == null) {
            LogUtil.e(this.f39334a, "uri scheme error");
            return;
        }
        Iterator<b> it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (it.next().a(context, uri, adSlot)) {
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        LogUtil.e(this.f39334a, "uri cannot process: " + str);
    }

    public final void a(String str) {
        try {
            this.b.add((b) Class.forName(str).newInstance());
        } catch (Exception unused) {
        }
    }
}
