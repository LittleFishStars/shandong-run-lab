package com.byazt.eti;

import android.text.TextUtils;
import com.byazt.aas.eo;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 384, 15})
public class uj implements tt {
    public static final com.byazt.iy.n c = eo.c("open_ad_sdk_union_meta_cache_kv");

    private String ve(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return "sp_reward_video_cache_".concat(String.valueOf(str));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.byazt.eti.tt
    public void c(String str, sp.tt ttVar, a aVar, sp.c cVar, com.byazt.eti.c cVar2) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(c.get(ve(str), copyOnWriteArraySet));
        if (cVar.uj() <= 0) {
            return;
        }
        if (cVar.uj() > 0 && copyOnWriteArraySet.size() >= cVar.uj()) {
            c cVar3 = null;
            long j = 0;
            String str2 = null;
            for (String str3 : copyOnWriteArraySet) {
                c cVarC = c.c(str3);
                if (str2 == null || j < cVarC.c) {
                    j = cVarC.c;
                    str2 = str3;
                    cVar3 = cVarC;
                }
            }
            if (cVar3 != null) {
                cVar2.c(new sp.tt(cVar3.uj, cVar3.c, cVar3.tt, cVar3.f28529a));
            }
            copyOnWriteArraySet.remove(str2);
        }
        copyOnWriteArraySet.add(new c(ttVar.ve, ttVar.c, ttVar.tt, aVar.c, ttVar.n, aVar.tt, aVar.ve).toString());
        c.put(ve(str), copyOnWriteArraySet);
    }

    @Override // com.byazt.eti.tt
    public void tt(String str) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(c.get(ve(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            c cVarC = c.c((String) it.next());
            cVarC.ve = false;
            copyOnWriteArraySet2.add(cVarC.toString());
        }
        c.put(ve(str), copyOnWriteArraySet2);
    }

    @com.byazt.zqa.c(c = {0, 1, 384, 123})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f28529a;
        public long c;
        public int n;
        public long sp;
        public long tt;
        public String uj;
        public boolean ve;
        public int x;

        public c(String str, long j, long j2, boolean z, String str2, long j3, int i, int i2) {
            this.c = j;
            this.tt = j2;
            this.ve = z;
            this.uj = str;
            this.f28529a = str2;
            this.sp = j3;
            this.x = i;
            this.n = i2;
        }

        public static c c(String str) {
            long jOptLong;
            long jOptLong2;
            int iOptInt;
            String str2;
            long j;
            String str3;
            String str4;
            long j2;
            int iOptInt2;
            boolean z;
            long j3;
            long j4;
            String strOptString = "";
            long jOptLong3 = 0;
            boolean zOptBoolean = true;
            try {
                JSONObject jSONObject = new JSONObject(str);
                jOptLong = jSONObject.optLong("create_time", 0L);
                try {
                    jOptLong2 = jSONObject.optLong("expire_time", 0L);
                    try {
                        zOptBoolean = jSONObject.optBoolean("is_using", false);
                        String strOptString2 = jSONObject.optString("material_data", "");
                        try {
                            iOptInt = jSONObject.optInt("save_version", 0);
                            try {
                                strOptString = jSONObject.optString("uuid", "");
                                jOptLong3 = jSONObject.optLong("priority", 0L);
                                str4 = strOptString;
                                j2 = jOptLong3;
                                z = zOptBoolean;
                                iOptInt2 = jSONObject.optInt("index", 0);
                                j3 = jOptLong;
                                j4 = jOptLong2;
                                str3 = strOptString2;
                            } catch (JSONException unused) {
                                j = jOptLong3;
                                str2 = strOptString;
                                strOptString = strOptString2;
                                str3 = strOptString;
                                str4 = str2;
                                j2 = j;
                                iOptInt2 = 0;
                                z = zOptBoolean;
                                j3 = jOptLong;
                                j4 = jOptLong2;
                            }
                        } catch (JSONException unused2) {
                            iOptInt = 0;
                        }
                    } catch (JSONException unused3) {
                        zOptBoolean = zOptBoolean;
                        iOptInt = 0;
                        j = 0;
                        str2 = "";
                    }
                } catch (JSONException unused4) {
                    jOptLong2 = 0;
                    zOptBoolean = true;
                    iOptInt = 0;
                    str2 = "";
                    j = jOptLong2;
                    str3 = strOptString;
                    str4 = str2;
                    j2 = j;
                    iOptInt2 = 0;
                    z = zOptBoolean;
                    j3 = jOptLong;
                    j4 = jOptLong2;
                    return new c(str3, j3, j4, z, str4, j2, iOptInt2, iOptInt);
                }
            } catch (JSONException unused5) {
                jOptLong = 0;
                jOptLong2 = 0;
            }
            return new c(str3, j3, j4, z, str4, j2, iOptInt2, iOptInt);
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("create_time", this.c);
                jSONObject.put("expire_time", this.tt);
                jSONObject.put("is_using", this.ve);
                jSONObject.put("material_data", this.uj);
                jSONObject.put("save_version", this.n);
                jSONObject.put("uuid", this.f28529a);
                jSONObject.put("priority", this.sp);
                jSONObject.put("index", this.x);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }

        public boolean tt(sp.c cVar) {
            if (System.currentTimeMillis() <= this.tt && !TextUtils.isEmpty(this.uj)) {
                return cVar.ve() && 7611 != this.n;
            }
            return true;
        }

        public c(String str, long j, long j2, boolean z, String str2, long j3, int i) {
            this(str, j, j2, z, str2, j3, i, 7611);
        }

        public boolean c(sp.c cVar) {
            return (tt(cVar) || this.ve) ? false : true;
        }
    }

    @Override // com.byazt.eti.tt
    public sp.tt c(String str, sp.c cVar, long j, List<String> list) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        copyOnWriteArraySet.addAll(c.get(ve(str), copyOnWriteArraySet));
        return c(copyOnWriteArraySet, cVar, j, list);
    }

    private sp.tt c(CopyOnWriteArraySet<String> copyOnWriteArraySet, sp.c cVar, long j, List<String> list) {
        int i;
        int i2;
        Iterator<String> it = copyOnWriteArraySet.iterator();
        c cVar2 = null;
        while (it.hasNext()) {
            c cVarC = c.c(it.next());
            if (cVarC.c(cVar)) {
                String str = cVarC.f28529a;
                if (list == null || str == null || !list.contains(str)) {
                    if (j <= 0 || cVarC.c >= j) {
                        int iN = cVar.n();
                        if (iN != 1) {
                            if (iN != 2) {
                                if (iN != 3) {
                                    return new sp.tt(cVarC.uj, cVarC.c, cVarC.tt, cVarC.f28529a);
                                }
                                if (cVar2 == null || (i = cVar2.x) > (i2 = cVarC.x) || (i == i2 && cVar2.c < cVarC.c)) {
                                    cVar2 = cVarC;
                                }
                            } else if (cVar2 == null || cVar2.sp < cVarC.sp) {
                                cVar2 = cVarC;
                            }
                        } else if (cVar2 == null || cVar2.c < cVarC.c) {
                            cVar2 = cVarC;
                        }
                    }
                }
            }
        }
        if (cVar2 != null) {
            return new sp.tt(cVar2.uj, cVar2.c, cVar2.tt, cVar2.f28529a);
        }
        return null;
    }

    @Override // com.byazt.eti.tt
    public void c(String str) {
        c.remove(ve(str));
    }

    @Override // com.byazt.eti.tt
    public void c(sp.c cVar) {
        c.clear();
    }

    @Override // com.byazt.eti.tt
    public void c(String str, sp.c cVar, com.byazt.eti.c cVar2) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(c.get(ve(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            c cVarC = c.c((String) it.next());
            if (!cVarC.tt(cVar)) {
                copyOnWriteArraySet2.add(cVarC.toString());
            } else if (cVar2 != null) {
                cVar2.c(new sp.tt(cVarC.uj, cVarC.c, cVarC.tt, cVarC.f28529a));
            }
        }
        c.put(ve(str), copyOnWriteArraySet2);
    }

    @Override // com.byazt.eti.tt
    public void c(String str, String str2) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(c.get(ve(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        for (String str3 : copyOnWriteArraySet) {
            if (!TextUtils.equals(c.c(str3).f28529a, str2)) {
                copyOnWriteArraySet2.add(str3);
            }
        }
        c.put(ve(str), copyOnWriteArraySet2);
    }

    @Override // com.byazt.eti.tt
    public void c(String str, String str2, boolean z) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(c.get(ve(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        for (String str3 : copyOnWriteArraySet) {
            c cVarC = c.c(str3);
            if (TextUtils.equals(cVarC.f28529a, str2)) {
                cVarC.ve = z;
                copyOnWriteArraySet2.add(cVarC.toString());
            } else {
                copyOnWriteArraySet2.add(str3);
            }
        }
        c.put(ve(str), copyOnWriteArraySet2);
    }

    @Override // com.byazt.eti.tt
    public boolean c(String str, sp.c cVar) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(c.get(ve(str), copyOnWriteArraySet));
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            if (c.c((String) it.next()).c(cVar)) {
                return true;
            }
        }
        return false;
    }
}
