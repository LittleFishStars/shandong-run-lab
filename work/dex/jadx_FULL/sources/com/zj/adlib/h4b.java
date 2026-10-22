package com.zj.adlib;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.LBSTraceClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class h4b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile h4b f42051a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, a> f16932a;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f42052a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public HashMap<Integer, List<LatLng>> f16934a;
        public int b;
        public int d;
        public int c = 0;
        public int e = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public List<LatLng> f16935a = new ArrayList();

        public a(int i, int i2, int i3, HashMap<Integer, List<LatLng>> map) {
            this.f42052a = 0;
            this.b = 0;
            this.d = 0;
            this.f42052a = i2;
            this.f16934a = map;
            this.b = i;
            this.d = i3;
        }

        public final HashMap<Integer, List<LatLng>> a() {
            return this.f16934a;
        }

        public final void b(Handler handler) {
            List<LatLng> list;
            for (int i = this.c; i <= this.f42052a && (list = this.f16934a.get(Integer.valueOf(i))) != null; i++) {
                this.f16935a.addAll(list);
                c(handler, list);
            }
            if (this.c == this.f42052a + 1) {
                d(handler);
            }
        }

        public final void c(Handler handler, List<LatLng> list) {
            Message messageObtainMessage = handler.obtainMessage();
            messageObtainMessage.obj = list;
            messageObtainMessage.what = 100;
            messageObtainMessage.arg1 = this.c;
            Bundle bundle = new Bundle();
            bundle.putInt("lineID", this.b);
            messageObtainMessage.setData(bundle);
            handler.sendMessage(messageObtainMessage);
            this.c++;
            this.e++;
        }

        public final void d(Handler handler) {
            if (this.e <= 0) {
                h4b.c(handler, this.b, LBSTraceClient.MIN_GRASP_POINT_ERROR);
                return;
            }
            int iA = c4b.a(this.f16935a);
            Message messageObtainMessage = handler.obtainMessage();
            messageObtainMessage.obj = this.f16935a;
            messageObtainMessage.what = 101;
            messageObtainMessage.arg1 = iA;
            messageObtainMessage.arg2 = this.d;
            Bundle bundle = new Bundle();
            bundle.putInt("lineID", this.b);
            messageObtainMessage.setData(bundle);
            handler.sendMessage(messageObtainMessage);
        }
    }

    public h4b() {
        this.f16932a = null;
        this.f16932a = Collections.synchronizedMap(new HashMap());
    }

    public static h4b b() {
        if (f42051a == null) {
            synchronized (h4b.class) {
                if (f42051a == null) {
                    f42051a = new h4b();
                }
            }
        }
        return f42051a;
    }

    public static void c(Handler handler, int i, String str) {
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.obj = str;
        messageObtainMessage.what = 102;
        Bundle bundle = new Bundle();
        bundle.putInt("lineID", i);
        messageObtainMessage.setData(bundle);
        handler.sendMessage(messageObtainMessage);
    }

    public final synchronized a a(String str) {
        Map<String, a> map = this.f16932a;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public final synchronized void d(String str, int i, int i2, int i3) {
        Map<String, a> map = this.f16932a;
        if (map != null) {
            map.put(str, new a(i, i2, i3, new HashMap(16)));
        }
    }

    public final synchronized void e(String str, int i, List<LatLng> list) {
        Map<String, a> map = this.f16932a;
        if (map != null) {
            map.get(str).a().put(Integer.valueOf(i), list);
        }
    }
}
