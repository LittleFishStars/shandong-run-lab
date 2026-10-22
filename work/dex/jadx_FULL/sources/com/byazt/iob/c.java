package com.byazt.iob;

import android.util.SparseArray;
import com.byazt.mm.n;
import com.byazt.mm.uj;
import com.byazt.rl.tt;
import com.byazt.rl.ve;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1548, 20})
public class c {
    public static Result c(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        ValueSet valueSetTt = ve.c(sparseArray).tt();
        return tt.c().c(valueSetTt.intValue(-999900)).c(valueSetTt.stringValue(-999901)).c(valueSetTt.booleanValue(-999903)).c(tt((SparseArray<Object>) valueSetTt.objectValue(-999902, SparseArray.class))).tt();
    }

    public static ValueSet tt(SparseArray<Object> sparseArray) {
        SparseArray<Object> sparseArrayC;
        if (sparseArray == null) {
            return null;
        }
        ve veVarC = ve.c();
        for (int i = 0; i < sparseArray.size(); i++) {
            int iKeyAt = sparseArray.keyAt(i);
            c(veVarC, iKeyAt, sparseArray.get(iKeyAt));
        }
        if ((sparseArray instanceof com.byazt.yxi.c) && (sparseArrayC = ((com.byazt.yxi.c) sparseArray).c()) != null && sparseArrayC.size() > 0) {
            for (int i2 = 0; i2 < sparseArrayC.size(); i2++) {
                int iKeyAt2 = sparseArrayC.keyAt(i2);
                c(veVarC, iKeyAt2, sparseArrayC.get(iKeyAt2));
            }
        }
        return veVarC.tt();
    }

    public static Object uj(Object obj) {
        final HashMap map = new HashMap();
        ((Map) obj).forEach(new BiConsumer<Object, Object>() { // from class: com.byazt.iob.c.3
            @Override // java.util.function.BiConsumer
            public void accept(Object obj2, Object obj3) {
                if (obj3 instanceof Bridge) {
                    map.put(obj2, new com.byazt.mm.ve((Bridge) obj3));
                    return;
                }
                if (obj3 instanceof ValueSet) {
                    map.put(obj2, new com.byazt.mm.c((ValueSet) obj3));
                    return;
                }
                if (obj3 instanceof EventListener) {
                    map.put(obj2, new uj((EventListener) obj3));
                    return;
                }
                if (obj3 == Bridge.class) {
                    map.put(obj2, Function.class);
                } else if (obj3 == ValueSet.class) {
                    map.put(obj2, SparseArray.class);
                } else {
                    map.put(obj2, obj3);
                }
            }
        });
        return map;
    }

    public static Object ve(Object obj) {
        final HashMap map = new HashMap();
        ((Map) obj).forEach(new BiConsumer<Object, Object>() { // from class: com.byazt.iob.c.2
            @Override // java.util.function.BiConsumer
            public void accept(Object obj2, Object obj3) {
                if (obj3 instanceof Function) {
                    if ((obj3 instanceof LongSupplier) && ((LongSupplier) obj3).getAsLong() == -99999981) {
                        map.put(obj2, new n((Function) obj3));
                        return;
                    } else {
                        map.put(obj2, new com.byazt.mm.tt((Function) obj3));
                        return;
                    }
                }
                if (obj3 instanceof SparseArray) {
                    map.put(obj2, c.tt((SparseArray<Object>) obj3));
                    return;
                }
                if (obj3 == Function.class) {
                    map.put(obj2, Bridge.class);
                } else if (obj3 == SparseArray.class) {
                    map.put(obj2, ValueSet.class);
                } else {
                    map.put(obj2, obj3);
                }
            }
        });
        return map;
    }

    private static void c(ve veVar, int i, final Object obj) {
        boolean z = obj instanceof Function;
        if (z) {
            if ((obj instanceof LongSupplier) && ((LongSupplier) obj).getAsLong() == -99999981) {
                veVar.c(i, new n((Function) obj));
                return;
            } else {
                veVar.c(i, new com.byazt.mm.tt((Function) obj));
                return;
            }
        }
        if (obj instanceof SparseArray) {
            if (i == -99999979) {
                veVar.c(i, c((SparseArray<Object>) obj));
                return;
            } else {
                veVar.c(i, tt((SparseArray<Object>) obj));
                return;
            }
        }
        if ((obj instanceof Supplier) && !z && !(obj instanceof ValueSet)) {
            veVar.c(i, new Supplier<Object>() { // from class: com.byazt.iob.c.1
                @Override // java.util.function.Supplier
                public Object get() {
                    return c.tt(((Supplier) obj).get());
                }
            });
            return;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (!list.isEmpty() && (list.get(0) instanceof Function)) {
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.byazt.mm.tt((Function) it.next()));
                }
                veVar.c(i, arrayList);
                return;
            }
            veVar.c(i, obj);
            return;
        }
        if (obj instanceof Map) {
            veVar.c(i, ve(obj));
        } else {
            veVar.c(i, obj);
        }
    }

    public static Object tt(Object obj) {
        if (obj instanceof Function) {
            return new com.byazt.mm.tt((Function) obj);
        }
        if (obj instanceof SparseArray) {
            return tt((SparseArray<Object>) obj);
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.isEmpty() || !(list.get(0) instanceof Function)) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.byazt.mm.tt((Function) it.next()));
            }
            return arrayList;
        }
        if (obj instanceof Map) {
            return ve(obj);
        }
        if (obj == Function.class) {
            return Bridge.class;
        }
        return obj == SparseArray.class ? ValueSet.class : obj;
    }

    public static SparseArray<Object> c(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return new SparseArray<>();
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        Object objApply = function.apply(sparseArray);
        if (objApply instanceof SparseArray) {
            return (SparseArray) objApply;
        }
        return new SparseArray<>();
    }

    public static Object c(Object obj) {
        if (obj instanceof Bridge) {
            return new com.byazt.mm.ve((Bridge) obj);
        }
        if (obj instanceof ValueSet) {
            return new com.byazt.mm.c((ValueSet) obj);
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.isEmpty() || !(list.get(0) instanceof Bridge)) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.byazt.mm.ve((Bridge) it.next()));
            }
            return arrayList;
        }
        if (obj instanceof Map) {
            return uj(obj);
        }
        if (obj == Bridge.class) {
            return Function.class;
        }
        return obj == ValueSet.class ? SparseArray.class : obj;
    }

    public static SparseArray<Object> c(Result result) {
        if (result == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-999900, Integer.valueOf(result.code()));
        sparseArray.put(-999901, result.message());
        sparseArray.put(-999903, Boolean.valueOf(result.isSuccess()));
        sparseArray.put(-999902, new com.byazt.mm.c(result.values()));
        return sparseArray;
    }
}
