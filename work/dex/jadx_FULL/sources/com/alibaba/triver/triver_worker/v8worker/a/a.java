package com.alibaba.triver.triver_worker.v8worker.a;

import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.kernel.api.node.Node;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Set<InterfaceC0180a> f25262a = new HashSet();

    /* JADX INFO: renamed from: com.alibaba.triver.triver_worker.v8worker.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0180a {
        void a(Worker worker);

        void a(Worker worker, Node node);
    }

    public static synchronized void a(InterfaceC0180a interfaceC0180a) {
        f25262a.add(interfaceC0180a);
    }

    public static synchronized void a(Worker worker) {
        for (InterfaceC0180a interfaceC0180a : f25262a) {
            if (interfaceC0180a != null) {
                try {
                    interfaceC0180a.a(worker);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static synchronized void a(Worker worker, Node node) {
        for (InterfaceC0180a interfaceC0180a : f25262a) {
            if (interfaceC0180a != null) {
                try {
                    interfaceC0180a.a(worker, node);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }
}
