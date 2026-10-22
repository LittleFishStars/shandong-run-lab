package com.alibaba.ariver.engine;

import android.text.TextUtils;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.engine.api.bridge.EngineRouter;
import com.alibaba.ariver.kernel.common.utils.CollectionUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DefaultEngineRouter implements EngineRouter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24045a = "AriverEngine:" + DefaultEngineRouter.class.getSimpleName();
    private final Object b = new Object();
    private final Map<String, Worker> c = new ConcurrentHashMap();
    private final Stack<Worker> d = new Stack<>();
    private final Map<String, Render> e = new ConcurrentHashMap();
    private final Stack<Render> f = new Stack<>();
    private Map<String, List<EngineRouter.RenderInitListener>> g;

    private void a(Render render) {
        if (render != null) {
            String renderId = render.getRenderId();
            if (TextUtils.isEmpty(renderId)) {
                return;
            }
            synchronized (this.b) {
                if (!CollectionUtils.isEmpty(this.g)) {
                    List<EngineRouter.RenderInitListener> list = this.g.get(renderId);
                    if (!CollectionUtils.isEmpty(list)) {
                        Iterator<EngineRouter.RenderInitListener> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onRenderInit(render);
                        }
                    }
                    this.g.remove(renderId);
                }
            }
        }
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public void destroy() {
        Collection<Worker> collectionValues = this.c.values();
        Iterator<Worker> it = collectionValues.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
        this.c.clear();
        this.e.clear();
        this.f.clear();
        collectionValues.clear();
        synchronized (this.b) {
            Map<String, List<EngineRouter.RenderInitListener>> map = this.g;
            if (map != null) {
                map.clear();
            }
            this.g = null;
        }
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public List<Render> getRegisteredRender() {
        ArrayList arrayList;
        synchronized (this.f) {
            arrayList = new ArrayList(this.f);
        }
        return arrayList;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public Render getRenderById(String str) {
        synchronized (this.f) {
            if (!TextUtils.isEmpty(str)) {
                return this.e.get(str);
            }
            if (this.f.size() <= 0) {
                return null;
            }
            return this.f.peek();
        }
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public Worker getWorkerById(String str) {
        synchronized (this.d) {
            if (!TextUtils.isEmpty(str)) {
                return this.c.get(str);
            }
            if (this.d.size() <= 0) {
                return null;
            }
            return this.d.peek();
        }
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public void registerRender(String str, Render render) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f) {
            if (this.e.containsKey(str)) {
                RVLogger.d(f24045a, "DefaultEngineRouter has sample worker " + str);
            } else {
                this.e.put(str, render);
                this.f.push(render);
            }
            a(render);
        }
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public void registerRenderInitListener(String str, EngineRouter.RenderInitListener renderInitListener) {
        synchronized (this.b) {
            if (this.g == null) {
                this.g = new HashMap();
            }
            if (!this.g.containsKey(str)) {
                this.g.put(str, new LinkedList());
            }
            this.g.get(str).add(renderInitListener);
            Render renderById = getRenderById(str);
            if (renderById != null) {
                a(renderById);
            }
        }
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public void registerWorker(String str, Worker worker) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.d) {
            if (this.c.containsKey(str)) {
                RVLogger.d(f24045a, "DefaultEngineRouter has sample worker " + str);
            } else {
                this.c.put(str, worker);
                this.d.push(worker);
            }
        }
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public void resetRenderToTop(Render render) {
        RVLogger.d(f24045a, "resetRenderToTop: " + render);
        if (render == null) {
            return;
        }
        synchronized (this.f) {
            if (this.f.remove(render)) {
                this.f.push(render);
            }
        }
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public void unRegisterRender(String str) {
        RVLogger.d(f24045a, "unRegisterRender: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f) {
            Render render = this.e.get(str);
            if (render != null) {
                this.e.remove(str);
                this.f.remove(render);
            }
        }
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public void unRegisterWorker(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.d) {
            RVLogger.d(f24045a, "unRegisterWorker: " + str);
            Worker worker = this.c.get(str);
            if (worker != null) {
                this.c.remove(str);
                this.d.remove(worker);
            }
        }
    }
}
