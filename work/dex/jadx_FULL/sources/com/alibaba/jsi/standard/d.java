package com.alibaba.jsi.standard;

import android.util.Log;
import com.alibaba.jsi.standard.js.aa;
import com.alibaba.jsi.standard.js.g;
import com.alibaba.jsi.standard.js.i;
import com.alibaba.jsi.standard.js.j;
import com.alibaba.jsi.standard.js.k;
import com.alibaba.jsi.standard.js.n;
import com.alibaba.jsi.standard.js.r;
import com.alibaba.jsi.standard.js.t;
import com.alibaba.jsi.standard.js.u;
import com.alibaba.jsi.standard.js.v;
import com.alibaba.jsi.standard.js.w;
import com.alibaba.jsi.standard.js.z;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<com.alibaba.jsi.standard.js.b> f24575a = new HashSet();
    private static AtomicInteger b = new AtomicInteger(0);
    private static boolean c = false;

    public static void a(boolean z) {
        c = b.addAndGet(z ? 1 : -1) > 0;
    }

    public static void b(b bVar, com.alibaba.jsi.standard.js.b bVar2) {
        if (c && bVar != null) {
            bVar.f().b(bVar2);
        }
    }

    public static void a(b bVar, com.alibaba.jsi.standard.js.b bVar2) {
        if (c) {
            if (bVar != null) {
                bVar.f().a(bVar2);
            } else {
                throw new NullPointerException("Pass null JSContext with object: " + bVar2);
            }
        }
    }

    public static void b(aa aaVar) {
        c cVarB;
        if (c && (cVarB = c.b()) != null) {
            cVarB.b(aaVar);
        }
    }

    public static void a(aa aaVar) {
        if (c) {
            c cVarB = c.b();
            if (cVarB == null) {
                Log.w("jsi", "Can not get JSEngine for Template: " + aaVar);
                return;
            }
            cVarB.a(aaVar);
        }
    }

    public static void b(com.alibaba.jsi.standard.js.b bVar) {
        if (c) {
            Set<com.alibaba.jsi.standard.js.b> set = f24575a;
            synchronized (set) {
                set.remove(bVar);
            }
        }
    }

    public static void a(com.alibaba.jsi.standard.js.b bVar) {
        if (c) {
            Set<com.alibaba.jsi.standard.js.b> set = f24575a;
            synchronized (set) {
                set.add(bVar);
            }
        }
    }

    private static void b(b bVar, Set<com.alibaba.jsi.standard.js.b> set, String str) {
        if (set.size() == 0) {
            return;
        }
        Locale locale = Locale.US;
        Object[] objArr = new Object[3];
        int i = 0;
        objArr[0] = str;
        objArr[1] = Integer.valueOf(set.size() > 20 ? 20 : set.size());
        objArr[2] = Integer.valueOf(set.size());
        Log.w("jsi", String.format(locale, "%s (%d of %d):", objArr));
        for (com.alibaba.jsi.standard.js.b bVar2 : set) {
            i++;
            if (i > 20) {
                return;
            }
            String str2 = "  * " + bVar2.toString();
            if (bVar != null && (bVar2 instanceof w)) {
                str2 = str2 + " (" + ((w) bVar2).a_(bVar) + ")";
            }
            Log.w("jsi", str2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public static void a(b bVar, Set<com.alibaba.jsi.standard.js.b> set, String str) {
        c cVarF;
        com.alibaba.jsi.standard.js.c cVar;
        HashSet hashSet;
        HashSet hashSet2;
        if (c) {
            HashSet hashSet3 = new HashSet();
            HashSet hashSet4 = new HashSet();
            HashSet hashSet5 = new HashSet();
            HashSet hashSet6 = new HashSet();
            HashSet hashSet7 = new HashSet();
            HashSet hashSet8 = new HashSet();
            HashSet hashSet9 = new HashSet();
            HashSet hashSet10 = new HashSet();
            HashSet hashSet11 = new HashSet();
            HashSet hashSet12 = new HashSet();
            HashSet hashSet13 = new HashSet();
            int size = set.size();
            for (com.alibaba.jsi.standard.js.b bVar2 : set) {
                if (bVar2 instanceof u) {
                    hashSet3.add(bVar2);
                } else if (bVar2 instanceof com.alibaba.jsi.standard.js.d) {
                    hashSet4.add(bVar2);
                } else if (bVar2 instanceof com.alibaba.jsi.standard.js.e) {
                    hashSet5.add(bVar2);
                } else if (bVar2 instanceof j) {
                    hashSet6.add(bVar2);
                } else if (bVar2 instanceof k) {
                    hashSet7.add(bVar2);
                } else if (bVar2 instanceof r) {
                    hashSet8.add(bVar2);
                } else if (!(bVar2 instanceof g) && !(bVar2 instanceof n) && !(bVar2 instanceof t) && !(bVar2 instanceof v)) {
                    if (bVar2 instanceof z) {
                        hashSet10.add(bVar2);
                    } else if (bVar2 instanceof i) {
                        hashSet13.add(bVar2);
                    } else if (bVar2 instanceof aa) {
                        hashSet12.add(bVar2);
                    } else {
                        hashSet11.add(bVar2);
                    }
                } else {
                    hashSet9.add(bVar2);
                }
            }
            if (bVar != null) {
                cVarF = bVar.f();
                cVar = new com.alibaba.jsi.standard.js.c(cVarF);
            } else {
                cVarF = null;
                cVar = null;
            }
            com.alibaba.jsi.standard.js.c cVar2 = cVar;
            try {
                Log.w("jsi", " ");
                Log.w("jsi", "*** *** *** *** ***  Alive Java JS Objects  *** *** *** *** ***");
                Log.w("jsi", "JSEngine: " + str);
                if (cVarF != null) {
                    List<b> listF = cVarF.f();
                    int size2 = 20;
                    if (listF.size() <= 20) {
                        size2 = listF.size();
                    }
                    if (listF.size() > 0) {
                        hashSet2 = hashSet13;
                        hashSet = hashSet12;
                        int i = 0;
                        Log.w("jsi", String.format(Locale.US, "JSContext (%d of %d):", Integer.valueOf(size2), Integer.valueOf(listF.size())));
                        Iterator<b> it = listF.iterator();
                        while (it.hasNext()) {
                            b next = it.next();
                            int i2 = i + 1;
                            if (i2 > size2) {
                                break;
                            }
                            Log.w("jsi", "  * " + next.d());
                            it = it;
                            i = i2;
                        }
                    } else {
                        hashSet = hashSet12;
                        hashSet2 = hashSet13;
                        Log.w("jsi", "JSContext: none");
                    }
                } else {
                    hashSet = hashSet12;
                    hashSet2 = hashSet13;
                }
                Log.w("jsi", "Objects count: " + size);
                b(bVar, hashSet3, "JSSymbol");
                b(bVar, hashSet4, "JSArray");
                b(bVar, hashSet5, "JSArrayBuffer");
                b(bVar, hashSet6, "JSFunction");
                b(bVar, hashSet7, "JSMap");
                b(bVar, hashSet8, "JSSet");
                b(bVar, hashSet9, "JSPrimitiveObject");
                b(bVar, hashSet11, "JSObject");
                b(bVar, hashSet10, "JSWeakValue");
                b(bVar, hashSet, "Template");
                b(bVar, hashSet2, "JSException");
                Set<com.alibaba.jsi.standard.js.b> set2 = f24575a;
                synchronized (set2) {
                    b(null, set2, "OutOfEngineObjects");
                }
                Log.w("jsi", "*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***");
                Log.w("jsi", " ");
                if (cVar2 != null) {
                    cVar2.b();
                }
            } catch (Throwable th) {
                if (cVar2 != null) {
                    cVar2.b();
                }
                throw th;
            }
        }
    }
}
