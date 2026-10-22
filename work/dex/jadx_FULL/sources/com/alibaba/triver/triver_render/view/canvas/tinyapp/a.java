package com.alibaba.triver.triver_render.view.canvas.tinyapp;

import com.alibaba.mobile.canvas.plugin.CanvasPluginManager;
import com.alibaba.mobile.tinycanvas.plugin.TinyPluginManager;
import com.taobao.gcanvas.GCanvasJNI;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static synchronized void a() {
        GCanvasJNI.load();
        b();
    }

    public static void b() {
        GCanvasJNI.addGCanvasInitCallback(new Runnable() { // from class: com.alibaba.triver.triver_render.view.canvas.tinyapp.a.1
            @Override // java.lang.Runnable
            public void run() {
                TinyPluginManager.getInstance().registerImagePlugin(new d());
                CanvasPluginManager.getInstance().registerTracePlugin(new c());
            }
        });
    }
}
