package com.byazt.mm;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1704, 20})
public class c<E> extends SparseArray<E> {
    public final ValueSet c;
    public final PluginValueSet tt;

    public c(ValueSet valueSet) {
        this.c = valueSet == null ? com.byazt.rl.ve.c : valueSet;
        this.tt = com.byazt.rl.c.c;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [E, java.util.ArrayList, java.util.List] */
    private E c(int i) {
        List list = (E) this.c.objectValue(i, Object.class);
        if (list == null) {
            list = (E) this.tt.objectValue(i, Object.class);
        }
        if (list != null) {
            if (i == 9) {
                if (list == Bridge.class) {
                    return Function.class;
                }
                if (list == ValueSet.class) {
                    return SparseArray.class;
                }
            } else {
                if (list instanceof Bridge) {
                    return (E) new ve((Bridge) list);
                }
                if (list instanceof ValueSet) {
                    return (E) new c((ValueSet) list);
                }
                if (list instanceof EventListener) {
                    return (E) new uj((EventListener) list);
                }
                if (list instanceof Result) {
                    return (E) com.byazt.iob.c.c((Result) list);
                }
                if (list instanceof List) {
                    List list2 = list;
                    if (!list2.isEmpty() && (list2.get(0) instanceof Bridge)) {
                        ?? r0 = (E) new ArrayList();
                        Iterator<E> it = list2.iterator();
                        while (it.hasNext()) {
                            r0.add(new ve((Bridge) it.next()));
                        }
                        return r0;
                    }
                } else if (list instanceof Map) {
                    return (E) com.byazt.iob.c.uj(list);
                }
            }
        }
        return (E) list;
    }

    @Override // android.util.SparseArray
    public boolean contains(int i) {
        return super.contains(i) || this.c.containsKey(i) || this.tt.containsKey(i);
    }

    @Override // android.util.SparseArray
    public E get(int i, E e) {
        E e2 = (E) super.get(i, null);
        if (e2 != null) {
            return e2;
        }
        E eC = c(i);
        return eC != null ? eC : e;
    }

    public c(PluginValueSet pluginValueSet) {
        this.tt = pluginValueSet == null ? com.byazt.rl.c.c : pluginValueSet;
        this.c = com.byazt.rl.ve.c;
    }
}
