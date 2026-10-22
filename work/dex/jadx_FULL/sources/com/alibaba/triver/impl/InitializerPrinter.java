package com.alibaba.triver.impl;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.baichuan.log.TLog;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class InitializerPrinter implements RVProxy.Printer {
    private static boolean b = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<String> f24967a = new ArrayList<>();

    public List<String> getHint() {
        return this.f24967a;
    }

    @Override // com.alibaba.ariver.kernel.common.RVProxy.Printer
    public void print(String str) {
        if (b) {
            TLog.logd("Ariver:RVInitializer", str);
        }
        if (str.contains(c.f25231a) || str.contains("error") || str.contains("duplicate")) {
            this.f24967a.add(str);
        }
    }
}
