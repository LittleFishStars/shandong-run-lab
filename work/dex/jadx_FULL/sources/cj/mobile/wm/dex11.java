package cj.mobile.wm;

import java.io.Closeable;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dex11 implements Closeable {
    public final c dexa;
    public a dexb;
    public String dexc;
    public DateFormat dexd;
    public final dex13 dexe;
    public dex20 dexf;
    public dex20[] dexg;
    public int dexh;
    public List<dexa> dexi;
    public int dexj;
    public List<g> dexk;
    public List<f> dexl;
    public i dexm;

    public static class dexa {
        public final dex20 dexa;
        public final String dexb;
        public h dexc;
        public dex20 dexd;

        public dexa(dex20 dex20Var, String str) {
            this.dexa = dex20Var;
            this.dexb = str;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public dex11(dex13 dex13Var, a aVar) throws com.wangmai.insightvision.openadsdk.d.d {
        int i;
        this.dexc = dex04.d;
        this.dexh = 0;
        this.dexj = 0;
        this.dexk = null;
        this.dexl = null;
        this.dexm = null;
        this.dexe = dex13Var;
        this.dexb = aVar;
        this.dexa = aVar.dexb;
        char c = dex13Var.dexd;
        if (c == '{') {
            int i2 = dex13Var.dexe + 1;
            dex13Var.dexe = i2;
            dex13Var.dexd = i2 < dex13Var.dexr ? dex13Var.dexq.charAt(i2) : (char) 26;
            i = 12;
        } else {
            if (c != '[') {
                dex13Var.dexk();
                return;
            }
            int i3 = dex13Var.dexe + 1;
            dex13Var.dexe = i3;
            dex13Var.dexd = i3 < dex13Var.dexr ? dex13Var.dexq.charAt(i3) : (char) 26;
            i = 14;
        }
        dex13Var.dexa = i;
    }

    public dex11(String str, a aVar, int i) {
        this(new dex13(str, i), aVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            dex13 dex13Var = this.dexe;
            if (dex13Var.dexa == 20) {
                dex13Var.dexb();
                return;
            }
            throw new com.wangmai.insightvision.openadsdk.d.d("not close json text, token : " + dex14.dexa(this.dexe.dexa));
        } catch (Throwable th) {
            this.dexe.dexb();
            throw th;
        }
    }

    public dex20 dexa(dex20 dex20Var, Object obj, Object obj2) {
        if (this.dexe.dext) {
            return null;
        }
        this.dexf = new dex20(dex20Var, obj, obj2);
        int i = this.dexh;
        this.dexh = i + 1;
        dex20[] dex20VarArr = this.dexg;
        if (dex20VarArr == null) {
            this.dexg = new dex20[8];
        } else if (i >= dex20VarArr.length) {
            dex20[] dex20VarArr2 = new dex20[(dex20VarArr.length * 3) / 2];
            System.arraycopy(dex20VarArr, 0, dex20VarArr2, 0, dex20VarArr.length);
            this.dexg = dex20VarArr2;
        }
        dex20[] dex20VarArr3 = this.dexg;
        dex20 dex20Var2 = this.dexf;
        dex20VarArr3[i] = dex20Var2;
        return dex20Var2;
    }

    public <T> T dexa(Class<T> cls) {
        return (T) dexa(cls, (Object) null);
    }

    public <T> T dexa(Type type) {
        return (T) dexa(type, (Object) null);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> T dexa(Type type, Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        dex13 dex13Var = this.dexe;
        int i = dex13Var.dexa;
        if (i == 8) {
            dex13Var.dexk();
            return null;
        }
        if (i == 4) {
            if (type == byte[].class) {
                T t = (T) dex13Var.dexa();
                this.dexe.dexk();
                return t;
            }
            if (type == char[].class) {
                String strDext = dex13Var.dext();
                this.dexe.dexk();
                return (T) strDext.toCharArray();
            }
        }
        try {
            return (T) this.dexb.dexa(type).dexa(this, type, obj);
        } catch (com.wangmai.insightvision.openadsdk.d.d e) {
            throw e;
        } catch (Exception e2) {
            throw new com.wangmai.insightvision.openadsdk.d.d(e2.getMessage(), e2);
        }
    }

    public DateFormat dexa() {
        if (this.dexd == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dexc, this.dexe.dexn);
            this.dexd = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.dexe.dexm);
        }
        return this.dexd;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public final void dexa(int i) throws com.wangmai.insightvision.openadsdk.d.d {
        dex13 dex13Var = this.dexe;
        if (dex13Var.dexa == i) {
            dex13Var.dexk();
            return;
        }
        throw new com.wangmai.insightvision.openadsdk.d.d("syntax error, expect " + dex14.dexa(i) + ", actual " + dex14.dexa(this.dexe.dexa));
    }

    public void dexa(dexa dexaVar) {
        if (this.dexi == null) {
            this.dexi = new ArrayList(2);
        }
        this.dexi.add(dexaVar);
    }

    public void dexa(dex20 dex20Var) {
        if (this.dexe.dext) {
            return;
        }
        this.dexf = dex20Var;
    }

    public void dexa(Object obj) {
        List<dexa> list = this.dexi;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            dexa dexaVar = this.dexi.get(i);
            h hVar = dexaVar.dexc;
            if (hVar != null) {
                dex20 dex20Var = dexaVar.dexd;
                Object obj2 = null;
                Object obj3 = dex20Var != null ? dex20Var.dexa : null;
                String str = dexaVar.dexb;
                if (str.startsWith("$")) {
                    for (int i2 = 0; i2 < this.dexh; i2++) {
                        if (str.equals(this.dexg[i2].toString())) {
                            obj2 = this.dexg[i2].dexa;
                        }
                    }
                } else {
                    obj2 = dexaVar.dexa.dexa;
                }
                hVar.dexa(obj3, obj2);
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public void dexa(Type type, Collection collection) throws com.wangmai.insightvision.openadsdk.d.d {
        dexa(type, collection, (Object) null);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Code duplicated, block: B:18:0x0040  */
    /* JADX WARN: Code duplicated, block: B:28:0x005a A[Catch: all -> 0x00ad, TRY_ENTER, TryCatch #0 {all -> 0x00ad, blocks: (B:20:0x0044, B:22:0x004c, B:28:0x005a, B:30:0x005f, B:46:0x00a1, B:48:0x00a7, B:33:0x006d, B:38:0x0082, B:34:0x0077, B:37:0x007e, B:41:0x008a, B:43:0x0096, B:45:0x009e, B:42:0x008e), top: B:55:0x0044 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x005f A[Catch: all -> 0x00ad, TryCatch #0 {all -> 0x00ad, blocks: (B:20:0x0044, B:22:0x004c, B:28:0x005a, B:30:0x005f, B:46:0x00a1, B:48:0x00a7, B:33:0x006d, B:38:0x0082, B:34:0x0077, B:37:0x007e, B:41:0x008a, B:43:0x0096, B:45:0x009e, B:42:0x008e), top: B:55:0x0044 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0069 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x006b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:33:0x006d A[Catch: all -> 0x00ad, TryCatch #0 {all -> 0x00ad, blocks: (B:20:0x0044, B:22:0x004c, B:28:0x005a, B:30:0x005f, B:46:0x00a1, B:48:0x00a7, B:33:0x006d, B:38:0x0082, B:34:0x0077, B:37:0x007e, B:41:0x008a, B:43:0x0096, B:45:0x009e, B:42:0x008e), top: B:55:0x0044 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0077 A[Catch: all -> 0x00ad, TryCatch #0 {all -> 0x00ad, blocks: (B:20:0x0044, B:22:0x004c, B:28:0x005a, B:30:0x005f, B:46:0x00a1, B:48:0x00a7, B:33:0x006d, B:38:0x0082, B:34:0x0077, B:37:0x007e, B:41:0x008a, B:43:0x0096, B:45:0x009e, B:42:0x008e), top: B:55:0x0044 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x007d  */
    /* JADX WARN: Code duplicated, block: B:37:0x007e A[Catch: all -> 0x00ad, TryCatch #0 {all -> 0x00ad, blocks: (B:20:0x0044, B:22:0x004c, B:28:0x005a, B:30:0x005f, B:46:0x00a1, B:48:0x00a7, B:33:0x006d, B:38:0x0082, B:34:0x0077, B:37:0x007e, B:41:0x008a, B:43:0x0096, B:45:0x009e, B:42:0x008e), top: B:55:0x0044 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0086  */
    /* JADX WARN: Code duplicated, block: B:41:0x008a A[Catch: all -> 0x00ad, TryCatch #0 {all -> 0x00ad, blocks: (B:20:0x0044, B:22:0x004c, B:28:0x005a, B:30:0x005f, B:46:0x00a1, B:48:0x00a7, B:33:0x006d, B:38:0x0082, B:34:0x0077, B:37:0x007e, B:41:0x008a, B:43:0x0096, B:45:0x009e, B:42:0x008e), top: B:55:0x0044 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x008e A[Catch: all -> 0x00ad, TryCatch #0 {all -> 0x00ad, blocks: (B:20:0x0044, B:22:0x004c, B:28:0x005a, B:30:0x005f, B:46:0x00a1, B:48:0x00a7, B:33:0x006d, B:38:0x0082, B:34:0x0077, B:37:0x007e, B:41:0x008a, B:43:0x0096, B:45:0x009e, B:42:0x008e), top: B:55:0x0044 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x009e A[Catch: all -> 0x00ad, TryCatch #0 {all -> 0x00ad, blocks: (B:20:0x0044, B:22:0x004c, B:28:0x005a, B:30:0x005f, B:46:0x00a1, B:48:0x00a7, B:33:0x006d, B:38:0x0082, B:34:0x0077, B:37:0x007e, B:41:0x008a, B:43:0x0096, B:45:0x009e, B:42:0x008e), top: B:55:0x0044 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00a7 A[Catch: all -> 0x00ad, TRY_LEAVE, TryCatch #0 {all -> 0x00ad, blocks: (B:20:0x0044, B:22:0x004c, B:28:0x005a, B:30:0x005f, B:46:0x00a1, B:48:0x00a7, B:33:0x006d, B:38:0x0082, B:34:0x0077, B:37:0x007e, B:41:0x008a, B:43:0x0096, B:45:0x009e, B:42:0x008e), top: B:55:0x0044 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0050 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x004c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x0054 A[SYNTHETIC] */
    public void dexa(Type type, Collection collection, Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        j jVarDexa;
        int i;
        dex20 dex20Var;
        int i2;
        dex13 dex13Var;
        int i3;
        Object objDexa;
        Object objDexe;
        dex13 dex13Var2;
        dex13 dex13Var3 = this.dexe;
        int i4 = dex13Var3.dexa;
        if (i4 == 21 || i4 == 22) {
            dex13Var3.dexk();
        }
        dex13 dex13Var4 = this.dexe;
        if (dex13Var4.dexa != 14) {
            throw new com.wangmai.insightvision.openadsdk.d.d("exepct '[', but " + dex14.dexa(this.dexe.dexa) + ", " + this.dexe.dexd());
        }
        if (Integer.TYPE == type) {
            jVarDexa = x.dexa;
            i = 2;
        } else {
            if (String.class == type) {
                jVarDexa = m.dexa;
                dex13Var4.dexb(4);
            } else {
                jVarDexa = this.dexb.dexa(type);
                dex13Var4 = this.dexe;
                i = 12;
            }
            dex20Var = this.dexf;
            if (!this.dexe.dext) {
                dexa(dex20Var, collection, obj);
            }
            i2 = 0;
            while (true) {
                try {
                    dex13Var = this.dexe;
                    i3 = dex13Var.dexa;
                    if (i3 == 16) {
                        dex13Var.dexk();
                    } else {
                        if (i3 == 15) {
                            this.dexf = dex20Var;
                            dex13Var.dexb(16);
                            return;
                        }
                        objDexa = null;
                        if (Integer.TYPE == type) {
                            collection.add(x.dexa.dexa(this, null, null));
                        } else if (String.class == type) {
                            if (i3 == 4) {
                                objDexa = dex13Var.dext();
                                this.dexe.dexb(16);
                            } else {
                                objDexe = dexe();
                                if (objDexe == null) {
                                    objDexa = objDexe.toString();
                                }
                            }
                            collection.add(objDexa);
                        } else {
                            if (i3 == 8) {
                                dex13Var.dexk();
                            } else {
                                objDexa = jVarDexa.dexa(this, type, Integer.valueOf(i2));
                            }
                            collection.add(objDexa);
                            if (this.dexj == 1) {
                                dexa(collection);
                            }
                        }
                        dex13Var2 = this.dexe;
                        if (dex13Var2.dexa == 16) {
                            dex13Var2.dexk();
                        }
                        i2++;
                    }
                } catch (Throwable th) {
                    this.dexf = dex20Var;
                    throw th;
                }
            }
        }
        dex13Var4.dexb(i);
        dex20Var = this.dexf;
        if (!this.dexe.dext) {
            dexa(dex20Var, collection, obj);
        }
        i2 = 0;
        while (true) {
            dex13Var = this.dexe;
            i3 = dex13Var.dexa;
            if (i3 == 16) {
                dex13Var.dexk();
            } else {
                if (i3 == 15) {
                    this.dexf = dex20Var;
                    dex13Var.dexb(16);
                    return;
                }
                objDexa = null;
                if (Integer.TYPE == type) {
                    collection.add(x.dexa.dexa(this, null, null));
                } else if (String.class == type) {
                    if (i3 == 4) {
                        objDexa = dex13Var.dext();
                        this.dexe.dexb(16);
                    } else {
                        objDexe = dexe();
                        if (objDexe == null) {
                            objDexa = objDexe.toString();
                        }
                    }
                    collection.add(objDexa);
                } else {
                    if (i3 == 8) {
                        dex13Var.dexk();
                    } else {
                        objDexa = jVarDexa.dexa(this, type, Integer.valueOf(i2));
                    }
                    collection.add(objDexa);
                    if (this.dexj == 1) {
                        dexa(collection);
                    }
                }
                dex13Var2 = this.dexe;
                if (dex13Var2.dexa == 16) {
                    dex13Var2.dexk();
                }
                i2++;
            }
        }
    }

    public void dexa(Collection collection) {
        dexa dexaVarDexd;
        b bVar;
        if (collection instanceof List) {
            dexaVarDexd = dexd();
            bVar = new b(this, (List) collection, collection.size() - 1);
        } else {
            dexaVarDexd = dexd();
            bVar = new b(collection);
        }
        dexaVarDexd.dexc = bVar;
        dexaVarDexd.dexd = this.dexf;
        this.dexj = 0;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Code duplicated, block: B:100:0x016e A[Catch: all -> 0x021b, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:102:0x0174 A[Catch: all -> 0x021b, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x018c A[Catch: all -> 0x021b, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x0197 A[Catch: all -> 0x021b, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:108:0x01a1 A[Catch: all -> 0x021b, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x01ae A[Catch: all -> 0x021b, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x01b4 A[Catch: all -> 0x021b, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x01bc A[Catch: all -> 0x021b, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x01d0 A[Catch: all -> 0x021b, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:120:0x01d9 A[Catch: all -> 0x021b, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x01dd A[Catch: all -> 0x021b, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:125:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:128:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:130:0x01f9 A[Catch: all -> 0x021b, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x0204  */
    /* JADX WARN: Code duplicated, block: B:133:0x0207 A[Catch: all -> 0x021b, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x0210 A[Catch: all -> 0x021b, TRY_LEAVE, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x00b8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:145:0x0132 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:146:0x0118 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:149:0x0213 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:153:0x00ef A[EDGE_INSN: B:153:0x00ef->B:63:0x00ef BREAK  A[LOOP:1: B:60:0x00e3->B:62:0x00e9], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:154:? A[PHI: r5
      PHI (r5v4 boolean) = (r5v3 boolean), (r5v3 boolean), (r5v3 boolean), (r5v8 boolean) binds: [B:32:0x0078, B:34:0x007e, B:59:0x00e0, B:46:0x00af] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x007a A[Catch: all -> 0x021b, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0080 A[Catch: all -> 0x021b, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x008c A[Catch: all -> 0x021b, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0095  */
    /* JADX WARN: Code duplicated, block: B:40:0x0098 A[Catch: all -> 0x021b, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00a7 A[Catch: all -> 0x021b, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:46:0x00af A[Catch: all -> 0x021b, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00b6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c4 A[Catch: all -> 0x021b, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00d3 A[Catch: all -> 0x021b, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:59:0x00e0 A[Catch: all -> 0x021b, TRY_ENTER, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x00e9 A[Catch: all -> 0x021b, LOOP:1: B:60:0x00e3->B:62:0x00e9, LOOP_END, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:67:0x00f5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:70:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:72:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:74:0x0101 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:75:0x0103  */
    /* JADX WARN: Code duplicated, block: B:77:0x0107  */
    /* JADX WARN: Code duplicated, block: B:79:0x010b  */
    /* JADX WARN: Code duplicated, block: B:81:0x010f  */
    /* JADX WARN: Code duplicated, block: B:83:0x0113 A[Catch: all -> 0x021b, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x011f  */
    /* JADX WARN: Code duplicated, block: B:88:0x0122 A[Catch: all -> 0x021b, TRY_ENTER, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x012f  */
    /* JADX WARN: Code duplicated, block: B:92:0x013b A[Catch: all -> 0x021b, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0148 A[Catch: all -> 0x021b, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0153 A[Catch: all -> 0x021b, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x0169 A[Catch: all -> 0x021b, TryCatch #0 {all -> 0x021b, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:24:0x005d, B:33:0x007a, B:35:0x0080, B:37:0x008c, B:41:0x009e, B:43:0x00a7, B:46:0x00af, B:40:0x0098, B:48:0x00b8, B:52:0x00ca, B:54:0x00d3, B:55:0x00d6, B:51:0x00c4, B:59:0x00e0, B:60:0x00e3, B:62:0x00e9, B:83:0x0113, B:115:0x01c9, B:117:0x01d0, B:118:0x01d3, B:120:0x01d9, B:122:0x01dd, B:127:0x01ed, B:130:0x01f9, B:134:0x020d, B:133:0x0207, B:135:0x0210, B:84:0x0118, B:88:0x0122, B:90:0x0132, B:91:0x013a, B:92:0x013b, B:94:0x0148, B:96:0x0158, B:95:0x0153, B:98:0x0162, B:99:0x0169, B:112:0x01b9, B:114:0x01c6, B:100:0x016e, B:102:0x0174, B:104:0x018c, B:106:0x0197, B:107:0x019d, B:108:0x01a1, B:110:0x01ae, B:111:0x01b4, B:113:0x01bc, B:23:0x0057, B:25:0x0064, B:26:0x0068, B:29:0x0073), top: B:143:0x0028 }] */
    public final void dexa(Collection collection, Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        boolean z;
        int i;
        int i2;
        Object objDexf;
        Object obj2;
        dex13 dex13Var;
        char c;
        int i3;
        char cCharAt;
        dex13 dex13Var2;
        String strDext;
        dex13 dex13Var3;
        Object time;
        Object objDexb;
        Boolean bool;
        com.wangmai.insightvision.openadsdk.d.e eVar;
        dex13 dex13Var4;
        String strDexb;
        dex13 dex13Var5;
        char c2;
        int i4;
        char cCharAt2;
        int i5;
        char cCharAt3;
        dex13 dex13Var6 = this.dexe;
        int i6 = dex13Var6.dexa;
        if (i6 == 21 || i6 == 22) {
            dex13Var6.dexk();
            i6 = this.dexe.dexa;
        }
        if (i6 != 14) {
            throw new com.wangmai.insightvision.openadsdk.d.d("syntax error, expect [, actual " + dex14.dexa(i6) + ", pos " + this.dexe.dexb);
        }
        boolean z2 = this.dexe.dext;
        dex20 dex20Var = this.dexf;
        if (!z2) {
            dexa(dex20Var, collection, obj);
        }
        try {
            dex13 dex13Var7 = this.dexe;
            char c3 = dex13Var7.dexd;
            if (c3 == '\"') {
                if ((dex13Var7.dexc & com.wangmai.insightvision.openadsdk.d.i.d.f.t) == 0) {
                    z = true;
                } else {
                    dex13Var7.dexb(4);
                }
                i = 0;
                while (true) {
                    if (z) {
                        dex13Var4 = this.dexe;
                        if (dex13Var4.dexd == '\"') {
                            strDexb = dex13Var4.dexb('\"');
                            dex13Var5 = this.dexe;
                            c2 = dex13Var5.dexd;
                            if (c2 == ',') {
                                i5 = dex13Var5.dexe + 1;
                                dex13Var5.dexe = i5;
                                if (i5 >= dex13Var5.dexr) {
                                    cCharAt3 = 26;
                                } else {
                                    cCharAt3 = dex13Var5.dexq.charAt(i5);
                                }
                                dex13Var5.dexd = cCharAt3;
                                collection.add(strDexb);
                                if (this.dexj == 1) {
                                    dexa(collection);
                                }
                                if (cCharAt3 == '\"') {
                                    this.dexe.dexk();
                                    z = false;
                                }
                            } else {
                                if (c2 == ']') {
                                    i4 = dex13Var5.dexe + 1;
                                    dex13Var5.dexe = i4;
                                    if (i4 >= dex13Var5.dexr) {
                                        cCharAt2 = 26;
                                    } else {
                                        cCharAt2 = dex13Var5.dexq.charAt(i4);
                                    }
                                    dex13Var5.dexd = cCharAt2;
                                    collection.add(strDexb);
                                    if (this.dexj == 1) {
                                        dexa(collection);
                                    }
                                    this.dexe.dexb(16);
                                    if (z2) {
                                        return;
                                    }
                                    this.dexf = dex20Var;
                                    return;
                                }
                                dex13Var5.dexk();
                            }
                            while (true) {
                                i2 = this.dexe.dexa;
                                if (i2 == 16) {
                                    break;
                                } else {
                                    this.dexe.dexk();
                                }
                            }
                            if (i2 != 2) {
                                objDexf = this.dexe.dexf();
                            } else if (i2 != 3) {
                                if (i2 != 4) {
                                    if (i2 != 6) {
                                        bool = Boolean.TRUE;
                                    } else if (i2 != 7) {
                                        bool = Boolean.FALSE;
                                    } else if (i2 == 8) {
                                        this.dexe.dexb(4);
                                        objDexb = null;
                                    } else if (i2 != 12) {
                                        if ((this.dexe.dexc & com.wangmai.insightvision.openadsdk.d.i.d.o.t) != 0) {
                                            eVar = new com.wangmai.insightvision.openadsdk.d.e(new LinkedHashMap());
                                        } else {
                                            eVar = new com.wangmai.insightvision.openadsdk.d.e();
                                        }
                                        objDexb = dexb(eVar, Integer.valueOf(i));
                                    } else {
                                        if (i2 != 20) {
                                            throw new com.wangmai.insightvision.openadsdk.d.d("unclosed jsonArray");
                                        }
                                        if (i2 != 23) {
                                            this.dexe.dexb(4);
                                            objDexb = null;
                                        } else if (i2 != 14) {
                                            com.wangmai.insightvision.openadsdk.d.b bVar = new com.wangmai.insightvision.openadsdk.d.b();
                                            dexa((Collection) bVar, (Object) Integer.valueOf(i));
                                            objDexb = bVar;
                                        } else {
                                            if (i2 != 15) {
                                                this.dexe.dexb(16);
                                                if (z2) {
                                                    return;
                                                }
                                                this.dexf = dex20Var;
                                                return;
                                            }
                                            objDexb = dexe();
                                        }
                                    }
                                    objDexf = bool;
                                } else {
                                    strDext = this.dexe.dext();
                                    this.dexe.dexb(16);
                                    if ((this.dexe.dexc & com.wangmai.insightvision.openadsdk.d.i.d.f.t) != 0) {
                                        dex13Var3 = new dex13(strDext);
                                        if (dex13Var3.dexb(true)) {
                                            objDexb = strDext;
                                            time = strDext;
                                            time = dex13Var3.dexo.getTime();
                                        }
                                        objDexb = strDext;
                                        time = strDext;
                                        dex13Var3.dexb();
                                        objDexb = time;
                                    }
                                }
                                objDexb = strDext;
                                obj2 = objDexb;
                                collection.add(obj2);
                                if (this.dexj == 1) {
                                    dexa(collection);
                                }
                                dex13Var = this.dexe;
                                if (dex13Var.dexa != 16) {
                                    c = dex13Var.dexd;
                                    if (c == '\"') {
                                        dex13Var.dexb = dex13Var.dexe;
                                        dex13Var.dexq();
                                    } else if (c < '0' && c <= '9') {
                                        dex13Var.dexb = dex13Var.dexe;
                                        dex13Var.dexo();
                                    } else if (c == '{') {
                                        dex13Var.dexa = 12;
                                        i3 = dex13Var.dexe + 1;
                                        dex13Var.dexe = i3;
                                        if (i3 >= dex13Var.dexr) {
                                            cCharAt = 26;
                                        } else {
                                            cCharAt = dex13Var.dexq.charAt(i3);
                                        }
                                        dex13Var.dexd = cCharAt;
                                    } else {
                                        dex13Var.dexk();
                                    }
                                }
                            } else {
                                dex13Var2 = this.dexe;
                                if ((dex13Var2.dexc & com.wangmai.insightvision.openadsdk.d.i.d.h.t) != 0) {
                                    objDexf = dex13Var2.dexa(true);
                                } else {
                                    objDexf = dex13Var2.dexa(false);
                                }
                            }
                            this.dexe.dexb(16);
                            obj2 = objDexf;
                            collection.add(obj2);
                            if (this.dexj == 1) {
                                dexa(collection);
                            }
                            dex13Var = this.dexe;
                            if (dex13Var.dexa != 16) {
                                c = dex13Var.dexd;
                                if (c == '\"') {
                                    dex13Var.dexb = dex13Var.dexe;
                                    dex13Var.dexq();
                                } else if (c < '0') {
                                    if (c == '{') {
                                        dex13Var.dexa = 12;
                                        i3 = dex13Var.dexe + 1;
                                        dex13Var.dexe = i3;
                                        if (i3 >= dex13Var.dexr) {
                                            cCharAt = 26;
                                        } else {
                                            cCharAt = dex13Var.dexq.charAt(i3);
                                        }
                                        dex13Var.dexd = cCharAt;
                                    } else {
                                        dex13Var.dexk();
                                    }
                                } else if (c == '{') {
                                    dex13Var.dexa = 12;
                                    i3 = dex13Var.dexe + 1;
                                    dex13Var.dexe = i3;
                                    if (i3 >= dex13Var.dexr) {
                                        cCharAt = 26;
                                    } else {
                                        cCharAt = dex13Var.dexq.charAt(i3);
                                    }
                                    dex13Var.dexd = cCharAt;
                                } else {
                                    dex13Var.dexk();
                                }
                            }
                        } else {
                            while (true) {
                                i2 = this.dexe.dexa;
                                if (i2 == 16) {
                                    break;
                                    break;
                                }
                                this.dexe.dexk();
                            }
                            if (i2 != 2) {
                                objDexf = this.dexe.dexf();
                            } else if (i2 != 3) {
                                if (i2 != 4) {
                                    if (i2 != 6) {
                                        bool = Boolean.TRUE;
                                    } else if (i2 != 7) {
                                        bool = Boolean.FALSE;
                                    } else if (i2 == 8) {
                                        this.dexe.dexb(4);
                                        objDexb = null;
                                    } else if (i2 != 12) {
                                        if ((this.dexe.dexc & com.wangmai.insightvision.openadsdk.d.i.d.o.t) != 0) {
                                            eVar = new com.wangmai.insightvision.openadsdk.d.e(new LinkedHashMap());
                                        } else {
                                            eVar = new com.wangmai.insightvision.openadsdk.d.e();
                                        }
                                        objDexb = dexb(eVar, Integer.valueOf(i));
                                    } else {
                                        if (i2 != 20) {
                                            throw new com.wangmai.insightvision.openadsdk.d.d("unclosed jsonArray");
                                        }
                                        if (i2 != 23) {
                                            this.dexe.dexb(4);
                                            objDexb = null;
                                        } else if (i2 != 14) {
                                            com.wangmai.insightvision.openadsdk.d.b bVar2 = new com.wangmai.insightvision.openadsdk.d.b();
                                            dexa((Collection) bVar2, (Object) Integer.valueOf(i));
                                            objDexb = bVar2;
                                        } else {
                                            if (i2 != 15) {
                                                this.dexe.dexb(16);
                                                if (z2) {
                                                    this.dexf = dex20Var;
                                                    return;
                                                }
                                                return;
                                            }
                                            objDexb = dexe();
                                        }
                                    }
                                    objDexf = bool;
                                } else {
                                    strDext = this.dexe.dext();
                                    this.dexe.dexb(16);
                                    if ((this.dexe.dexc & com.wangmai.insightvision.openadsdk.d.i.d.f.t) != 0) {
                                        dex13Var3 = new dex13(strDext);
                                        if (dex13Var3.dexb(true)) {
                                            objDexb = strDext;
                                            time = strDext;
                                            time = dex13Var3.dexo.getTime();
                                        }
                                        objDexb = strDext;
                                        time = strDext;
                                        dex13Var3.dexb();
                                        objDexb = time;
                                    }
                                }
                                objDexb = strDext;
                                obj2 = objDexb;
                                collection.add(obj2);
                                if (this.dexj == 1) {
                                    dexa(collection);
                                }
                                dex13Var = this.dexe;
                                if (dex13Var.dexa != 16) {
                                    c = dex13Var.dexd;
                                    if (c == '\"') {
                                        dex13Var.dexb = dex13Var.dexe;
                                        dex13Var.dexq();
                                    } else if (c < '0') {
                                        if (c == '{') {
                                            dex13Var.dexa = 12;
                                            i3 = dex13Var.dexe + 1;
                                            dex13Var.dexe = i3;
                                            if (i3 >= dex13Var.dexr) {
                                                cCharAt = 26;
                                            } else {
                                                cCharAt = dex13Var.dexq.charAt(i3);
                                            }
                                            dex13Var.dexd = cCharAt;
                                        } else {
                                            dex13Var.dexk();
                                        }
                                    } else if (c == '{') {
                                        dex13Var.dexa = 12;
                                        i3 = dex13Var.dexe + 1;
                                        dex13Var.dexe = i3;
                                        if (i3 >= dex13Var.dexr) {
                                            cCharAt = 26;
                                        } else {
                                            cCharAt = dex13Var.dexq.charAt(i3);
                                        }
                                        dex13Var.dexd = cCharAt;
                                    } else {
                                        dex13Var.dexk();
                                    }
                                }
                            } else {
                                dex13Var2 = this.dexe;
                                if ((dex13Var2.dexc & com.wangmai.insightvision.openadsdk.d.i.d.h.t) != 0) {
                                    objDexf = dex13Var2.dexa(true);
                                } else {
                                    objDexf = dex13Var2.dexa(false);
                                }
                            }
                            this.dexe.dexb(16);
                            obj2 = objDexf;
                            collection.add(obj2);
                            if (this.dexj == 1) {
                                dexa(collection);
                            }
                            dex13Var = this.dexe;
                            if (dex13Var.dexa != 16) {
                                c = dex13Var.dexd;
                                if (c == '\"') {
                                    dex13Var.dexb = dex13Var.dexe;
                                    dex13Var.dexq();
                                } else if (c < '0') {
                                    if (c == '{') {
                                        dex13Var.dexa = 12;
                                        i3 = dex13Var.dexe + 1;
                                        dex13Var.dexe = i3;
                                        if (i3 >= dex13Var.dexr) {
                                            cCharAt = 26;
                                        } else {
                                            cCharAt = dex13Var.dexq.charAt(i3);
                                        }
                                        dex13Var.dexd = cCharAt;
                                    } else {
                                        dex13Var.dexk();
                                    }
                                } else if (c == '{') {
                                    dex13Var.dexa = 12;
                                    i3 = dex13Var.dexe + 1;
                                    dex13Var.dexe = i3;
                                    if (i3 >= dex13Var.dexr) {
                                        cCharAt = 26;
                                    } else {
                                        cCharAt = dex13Var.dexq.charAt(i3);
                                    }
                                    dex13Var.dexd = cCharAt;
                                } else {
                                    dex13Var.dexk();
                                }
                            }
                        }
                    } else {
                        while (true) {
                            i2 = this.dexe.dexa;
                            if (i2 == 16) {
                                break;
                                break;
                            }
                            this.dexe.dexk();
                        }
                        if (i2 != 2) {
                            objDexf = this.dexe.dexf();
                        } else if (i2 != 3) {
                            if (i2 != 4) {
                                if (i2 != 6) {
                                    bool = Boolean.TRUE;
                                } else if (i2 != 7) {
                                    bool = Boolean.FALSE;
                                } else if (i2 == 8) {
                                    this.dexe.dexb(4);
                                    objDexb = null;
                                } else if (i2 != 12) {
                                    if ((this.dexe.dexc & com.wangmai.insightvision.openadsdk.d.i.d.o.t) != 0) {
                                        eVar = new com.wangmai.insightvision.openadsdk.d.e(new LinkedHashMap());
                                    } else {
                                        eVar = new com.wangmai.insightvision.openadsdk.d.e();
                                    }
                                    objDexb = dexb(eVar, Integer.valueOf(i));
                                } else {
                                    if (i2 != 20) {
                                        throw new com.wangmai.insightvision.openadsdk.d.d("unclosed jsonArray");
                                    }
                                    if (i2 != 23) {
                                        this.dexe.dexb(4);
                                        objDexb = null;
                                    } else if (i2 != 14) {
                                        com.wangmai.insightvision.openadsdk.d.b bVar3 = new com.wangmai.insightvision.openadsdk.d.b();
                                        dexa((Collection) bVar3, (Object) Integer.valueOf(i));
                                        objDexb = bVar3;
                                    } else {
                                        if (i2 != 15) {
                                            this.dexe.dexb(16);
                                            if (z2) {
                                                this.dexf = dex20Var;
                                                return;
                                            }
                                            return;
                                        }
                                        objDexb = dexe();
                                    }
                                }
                                objDexf = bool;
                            } else {
                                strDext = this.dexe.dext();
                                this.dexe.dexb(16);
                                if ((this.dexe.dexc & com.wangmai.insightvision.openadsdk.d.i.d.f.t) != 0) {
                                    dex13Var3 = new dex13(strDext);
                                    if (dex13Var3.dexb(true)) {
                                        objDexb = strDext;
                                        time = strDext;
                                        time = dex13Var3.dexo.getTime();
                                    }
                                    objDexb = strDext;
                                    time = strDext;
                                    dex13Var3.dexb();
                                    objDexb = time;
                                }
                            }
                            objDexb = strDext;
                            obj2 = objDexb;
                            collection.add(obj2);
                            if (this.dexj == 1) {
                                dexa(collection);
                            }
                            dex13Var = this.dexe;
                            if (dex13Var.dexa != 16) {
                                c = dex13Var.dexd;
                                if (c == '\"') {
                                    dex13Var.dexb = dex13Var.dexe;
                                    dex13Var.dexq();
                                } else if (c < '0') {
                                    if (c == '{') {
                                        dex13Var.dexa = 12;
                                        i3 = dex13Var.dexe + 1;
                                        dex13Var.dexe = i3;
                                        if (i3 >= dex13Var.dexr) {
                                            cCharAt = 26;
                                        } else {
                                            cCharAt = dex13Var.dexq.charAt(i3);
                                        }
                                        dex13Var.dexd = cCharAt;
                                    } else {
                                        dex13Var.dexk();
                                    }
                                } else if (c == '{') {
                                    dex13Var.dexa = 12;
                                    i3 = dex13Var.dexe + 1;
                                    dex13Var.dexe = i3;
                                    if (i3 >= dex13Var.dexr) {
                                        cCharAt = 26;
                                    } else {
                                        cCharAt = dex13Var.dexq.charAt(i3);
                                    }
                                    dex13Var.dexd = cCharAt;
                                } else {
                                    dex13Var.dexk();
                                }
                            }
                        } else {
                            dex13Var2 = this.dexe;
                            if ((dex13Var2.dexc & com.wangmai.insightvision.openadsdk.d.i.d.h.t) != 0) {
                                objDexf = dex13Var2.dexa(true);
                            } else {
                                objDexf = dex13Var2.dexa(false);
                            }
                        }
                        this.dexe.dexb(16);
                        obj2 = objDexf;
                        collection.add(obj2);
                        if (this.dexj == 1) {
                            dexa(collection);
                        }
                        dex13Var = this.dexe;
                        if (dex13Var.dexa != 16) {
                            c = dex13Var.dexd;
                            if (c == '\"') {
                                dex13Var.dexb = dex13Var.dexe;
                                dex13Var.dexq();
                            } else if (c < '0') {
                                if (c == '{') {
                                    dex13Var.dexa = 12;
                                    i3 = dex13Var.dexe + 1;
                                    dex13Var.dexe = i3;
                                    if (i3 >= dex13Var.dexr) {
                                        cCharAt = 26;
                                    } else {
                                        cCharAt = dex13Var.dexq.charAt(i3);
                                    }
                                    dex13Var.dexd = cCharAt;
                                } else {
                                    dex13Var.dexk();
                                }
                            } else if (c == '{') {
                                dex13Var.dexa = 12;
                                i3 = dex13Var.dexe + 1;
                                dex13Var.dexe = i3;
                                if (i3 >= dex13Var.dexr) {
                                    cCharAt = 26;
                                } else {
                                    cCharAt = dex13Var.dexq.charAt(i3);
                                }
                                dex13Var.dexd = cCharAt;
                            } else {
                                dex13Var.dexk();
                            }
                        }
                    }
                    i++;
                }
            } else {
                if (c3 == ']') {
                    dex13Var7.dexi();
                    this.dexe.dexb(16);
                    if (z2) {
                        return;
                    }
                    this.dexf = dex20Var;
                    return;
                }
                if (c3 == '{') {
                    int i7 = dex13Var7.dexe + 1;
                    dex13Var7.dexe = i7;
                    dex13Var7.dexd = i7 >= dex13Var7.dexr ? (char) 26 : dex13Var7.dexq.charAt(i7);
                    this.dexe.dexa = 12;
                } else {
                    dex13Var7.dexb(12);
                }
            }
            z = false;
            i = 0;
            while (true) {
                if (z) {
                    dex13Var4 = this.dexe;
                    if (dex13Var4.dexd == '\"') {
                        strDexb = dex13Var4.dexb('\"');
                        dex13Var5 = this.dexe;
                        c2 = dex13Var5.dexd;
                        if (c2 == ',') {
                            i5 = dex13Var5.dexe + 1;
                            dex13Var5.dexe = i5;
                            if (i5 >= dex13Var5.dexr) {
                                cCharAt3 = 26;
                            } else {
                                cCharAt3 = dex13Var5.dexq.charAt(i5);
                            }
                            dex13Var5.dexd = cCharAt3;
                            collection.add(strDexb);
                            if (this.dexj == 1) {
                                dexa(collection);
                            }
                            if (cCharAt3 == '\"') {
                                this.dexe.dexk();
                                z = false;
                            }
                        } else {
                            if (c2 == ']') {
                                i4 = dex13Var5.dexe + 1;
                                dex13Var5.dexe = i4;
                                if (i4 >= dex13Var5.dexr) {
                                    cCharAt2 = 26;
                                } else {
                                    cCharAt2 = dex13Var5.dexq.charAt(i4);
                                }
                                dex13Var5.dexd = cCharAt2;
                                collection.add(strDexb);
                                if (this.dexj == 1) {
                                    dexa(collection);
                                }
                                this.dexe.dexb(16);
                                if (z2) {
                                    this.dexf = dex20Var;
                                    return;
                                }
                                return;
                            }
                            dex13Var5.dexk();
                        }
                        while (true) {
                            i2 = this.dexe.dexa;
                            if (i2 == 16) {
                                break;
                                break;
                            }
                            this.dexe.dexk();
                        }
                        if (i2 != 2) {
                            objDexf = this.dexe.dexf();
                        } else if (i2 != 3) {
                            if (i2 != 4) {
                                if (i2 != 6) {
                                    bool = Boolean.TRUE;
                                } else if (i2 != 7) {
                                    bool = Boolean.FALSE;
                                } else if (i2 == 8) {
                                    this.dexe.dexb(4);
                                    objDexb = null;
                                } else if (i2 != 12) {
                                    if ((this.dexe.dexc & com.wangmai.insightvision.openadsdk.d.i.d.o.t) != 0) {
                                        eVar = new com.wangmai.insightvision.openadsdk.d.e(new LinkedHashMap());
                                    } else {
                                        eVar = new com.wangmai.insightvision.openadsdk.d.e();
                                    }
                                    objDexb = dexb(eVar, Integer.valueOf(i));
                                } else {
                                    if (i2 != 20) {
                                        throw new com.wangmai.insightvision.openadsdk.d.d("unclosed jsonArray");
                                    }
                                    if (i2 != 23) {
                                        this.dexe.dexb(4);
                                        objDexb = null;
                                    } else if (i2 != 14) {
                                        com.wangmai.insightvision.openadsdk.d.b bVar4 = new com.wangmai.insightvision.openadsdk.d.b();
                                        dexa((Collection) bVar4, (Object) Integer.valueOf(i));
                                        objDexb = bVar4;
                                    } else {
                                        if (i2 != 15) {
                                            this.dexe.dexb(16);
                                            if (z2) {
                                                this.dexf = dex20Var;
                                                return;
                                            }
                                            return;
                                        }
                                        objDexb = dexe();
                                    }
                                }
                                objDexf = bool;
                            } else {
                                strDext = this.dexe.dext();
                                this.dexe.dexb(16);
                                if ((this.dexe.dexc & com.wangmai.insightvision.openadsdk.d.i.d.f.t) != 0) {
                                    dex13Var3 = new dex13(strDext);
                                    if (dex13Var3.dexb(true)) {
                                        objDexb = strDext;
                                        time = strDext;
                                        time = dex13Var3.dexo.getTime();
                                    }
                                    objDexb = strDext;
                                    time = strDext;
                                    dex13Var3.dexb();
                                    objDexb = time;
                                }
                            }
                            objDexb = strDext;
                            obj2 = objDexb;
                            collection.add(obj2);
                            if (this.dexj == 1) {
                                dexa(collection);
                            }
                            dex13Var = this.dexe;
                            if (dex13Var.dexa != 16) {
                                c = dex13Var.dexd;
                                if (c == '\"') {
                                    dex13Var.dexb = dex13Var.dexe;
                                    dex13Var.dexq();
                                } else if (c < '0') {
                                    if (c == '{') {
                                        dex13Var.dexa = 12;
                                        i3 = dex13Var.dexe + 1;
                                        dex13Var.dexe = i3;
                                        if (i3 >= dex13Var.dexr) {
                                            cCharAt = 26;
                                        } else {
                                            cCharAt = dex13Var.dexq.charAt(i3);
                                        }
                                        dex13Var.dexd = cCharAt;
                                    } else {
                                        dex13Var.dexk();
                                    }
                                } else if (c == '{') {
                                    dex13Var.dexa = 12;
                                    i3 = dex13Var.dexe + 1;
                                    dex13Var.dexe = i3;
                                    if (i3 >= dex13Var.dexr) {
                                        cCharAt = 26;
                                    } else {
                                        cCharAt = dex13Var.dexq.charAt(i3);
                                    }
                                    dex13Var.dexd = cCharAt;
                                } else {
                                    dex13Var.dexk();
                                }
                            }
                        } else {
                            dex13Var2 = this.dexe;
                            if ((dex13Var2.dexc & com.wangmai.insightvision.openadsdk.d.i.d.h.t) != 0) {
                                objDexf = dex13Var2.dexa(true);
                            } else {
                                objDexf = dex13Var2.dexa(false);
                            }
                        }
                        this.dexe.dexb(16);
                        obj2 = objDexf;
                        collection.add(obj2);
                        if (this.dexj == 1) {
                            dexa(collection);
                        }
                        dex13Var = this.dexe;
                        if (dex13Var.dexa != 16) {
                            c = dex13Var.dexd;
                            if (c == '\"') {
                                dex13Var.dexb = dex13Var.dexe;
                                dex13Var.dexq();
                            } else if (c < '0') {
                                if (c == '{') {
                                    dex13Var.dexa = 12;
                                    i3 = dex13Var.dexe + 1;
                                    dex13Var.dexe = i3;
                                    if (i3 >= dex13Var.dexr) {
                                        cCharAt = 26;
                                    } else {
                                        cCharAt = dex13Var.dexq.charAt(i3);
                                    }
                                    dex13Var.dexd = cCharAt;
                                } else {
                                    dex13Var.dexk();
                                }
                            } else if (c == '{') {
                                dex13Var.dexa = 12;
                                i3 = dex13Var.dexe + 1;
                                dex13Var.dexe = i3;
                                if (i3 >= dex13Var.dexr) {
                                    cCharAt = 26;
                                } else {
                                    cCharAt = dex13Var.dexq.charAt(i3);
                                }
                                dex13Var.dexd = cCharAt;
                            } else {
                                dex13Var.dexk();
                            }
                        }
                    } else {
                        while (true) {
                            i2 = this.dexe.dexa;
                            if (i2 == 16) {
                                break;
                                break;
                            }
                            this.dexe.dexk();
                        }
                        if (i2 != 2) {
                            objDexf = this.dexe.dexf();
                        } else if (i2 != 3) {
                            if (i2 != 4) {
                                if (i2 != 6) {
                                    bool = Boolean.TRUE;
                                } else if (i2 != 7) {
                                    bool = Boolean.FALSE;
                                } else if (i2 == 8) {
                                    this.dexe.dexb(4);
                                    objDexb = null;
                                } else if (i2 != 12) {
                                    if ((this.dexe.dexc & com.wangmai.insightvision.openadsdk.d.i.d.o.t) != 0) {
                                        eVar = new com.wangmai.insightvision.openadsdk.d.e(new LinkedHashMap());
                                    } else {
                                        eVar = new com.wangmai.insightvision.openadsdk.d.e();
                                    }
                                    objDexb = dexb(eVar, Integer.valueOf(i));
                                } else {
                                    if (i2 != 20) {
                                        throw new com.wangmai.insightvision.openadsdk.d.d("unclosed jsonArray");
                                    }
                                    if (i2 != 23) {
                                        this.dexe.dexb(4);
                                        objDexb = null;
                                    } else if (i2 != 14) {
                                        com.wangmai.insightvision.openadsdk.d.b bVar5 = new com.wangmai.insightvision.openadsdk.d.b();
                                        dexa((Collection) bVar5, (Object) Integer.valueOf(i));
                                        objDexb = bVar5;
                                    } else {
                                        if (i2 != 15) {
                                            this.dexe.dexb(16);
                                            if (z2) {
                                                this.dexf = dex20Var;
                                                return;
                                            }
                                            return;
                                        }
                                        objDexb = dexe();
                                    }
                                }
                                objDexf = bool;
                            } else {
                                strDext = this.dexe.dext();
                                this.dexe.dexb(16);
                                if ((this.dexe.dexc & com.wangmai.insightvision.openadsdk.d.i.d.f.t) != 0) {
                                    dex13Var3 = new dex13(strDext);
                                    if (dex13Var3.dexb(true)) {
                                        objDexb = strDext;
                                        time = strDext;
                                        time = dex13Var3.dexo.getTime();
                                    }
                                    objDexb = strDext;
                                    time = strDext;
                                    dex13Var3.dexb();
                                    objDexb = time;
                                }
                            }
                            objDexb = strDext;
                            obj2 = objDexb;
                            collection.add(obj2);
                            if (this.dexj == 1) {
                                dexa(collection);
                            }
                            dex13Var = this.dexe;
                            if (dex13Var.dexa != 16) {
                                c = dex13Var.dexd;
                                if (c == '\"') {
                                    dex13Var.dexb = dex13Var.dexe;
                                    dex13Var.dexq();
                                } else if (c < '0') {
                                    if (c == '{') {
                                        dex13Var.dexa = 12;
                                        i3 = dex13Var.dexe + 1;
                                        dex13Var.dexe = i3;
                                        if (i3 >= dex13Var.dexr) {
                                            cCharAt = 26;
                                        } else {
                                            cCharAt = dex13Var.dexq.charAt(i3);
                                        }
                                        dex13Var.dexd = cCharAt;
                                    } else {
                                        dex13Var.dexk();
                                    }
                                } else if (c == '{') {
                                    dex13Var.dexa = 12;
                                    i3 = dex13Var.dexe + 1;
                                    dex13Var.dexe = i3;
                                    if (i3 >= dex13Var.dexr) {
                                        cCharAt = 26;
                                    } else {
                                        cCharAt = dex13Var.dexq.charAt(i3);
                                    }
                                    dex13Var.dexd = cCharAt;
                                } else {
                                    dex13Var.dexk();
                                }
                            }
                        } else {
                            dex13Var2 = this.dexe;
                            if ((dex13Var2.dexc & com.wangmai.insightvision.openadsdk.d.i.d.h.t) != 0) {
                                objDexf = dex13Var2.dexa(true);
                            } else {
                                objDexf = dex13Var2.dexa(false);
                            }
                        }
                        this.dexe.dexb(16);
                        obj2 = objDexf;
                        collection.add(obj2);
                        if (this.dexj == 1) {
                            dexa(collection);
                        }
                        dex13Var = this.dexe;
                        if (dex13Var.dexa != 16) {
                            c = dex13Var.dexd;
                            if (c == '\"') {
                                dex13Var.dexb = dex13Var.dexe;
                                dex13Var.dexq();
                            } else if (c < '0') {
                                if (c == '{') {
                                    dex13Var.dexa = 12;
                                    i3 = dex13Var.dexe + 1;
                                    dex13Var.dexe = i3;
                                    if (i3 >= dex13Var.dexr) {
                                        cCharAt = 26;
                                    } else {
                                        cCharAt = dex13Var.dexq.charAt(i3);
                                    }
                                    dex13Var.dexd = cCharAt;
                                } else {
                                    dex13Var.dexk();
                                }
                            } else if (c == '{') {
                                dex13Var.dexa = 12;
                                i3 = dex13Var.dexe + 1;
                                dex13Var.dexe = i3;
                                if (i3 >= dex13Var.dexr) {
                                    cCharAt = 26;
                                } else {
                                    cCharAt = dex13Var.dexq.charAt(i3);
                                }
                                dex13Var.dexd = cCharAt;
                            } else {
                                dex13Var.dexk();
                            }
                        }
                    }
                } else {
                    while (true) {
                        i2 = this.dexe.dexa;
                        if (i2 == 16) {
                            break;
                            break;
                        }
                        this.dexe.dexk();
                    }
                    if (i2 != 2) {
                        objDexf = this.dexe.dexf();
                    } else if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 6) {
                                bool = Boolean.TRUE;
                            } else if (i2 != 7) {
                                bool = Boolean.FALSE;
                            } else if (i2 == 8) {
                                this.dexe.dexb(4);
                                objDexb = null;
                            } else if (i2 != 12) {
                                if ((this.dexe.dexc & com.wangmai.insightvision.openadsdk.d.i.d.o.t) != 0) {
                                    eVar = new com.wangmai.insightvision.openadsdk.d.e(new LinkedHashMap());
                                } else {
                                    eVar = new com.wangmai.insightvision.openadsdk.d.e();
                                }
                                objDexb = dexb(eVar, Integer.valueOf(i));
                            } else {
                                if (i2 != 20) {
                                    throw new com.wangmai.insightvision.openadsdk.d.d("unclosed jsonArray");
                                }
                                if (i2 != 23) {
                                    this.dexe.dexb(4);
                                    objDexb = null;
                                } else if (i2 != 14) {
                                    com.wangmai.insightvision.openadsdk.d.b bVar6 = new com.wangmai.insightvision.openadsdk.d.b();
                                    dexa((Collection) bVar6, (Object) Integer.valueOf(i));
                                    objDexb = bVar6;
                                } else {
                                    if (i2 != 15) {
                                        this.dexe.dexb(16);
                                        if (z2) {
                                            this.dexf = dex20Var;
                                            return;
                                        }
                                        return;
                                    }
                                    objDexb = dexe();
                                }
                            }
                            objDexf = bool;
                        } else {
                            strDext = this.dexe.dext();
                            this.dexe.dexb(16);
                            if ((this.dexe.dexc & com.wangmai.insightvision.openadsdk.d.i.d.f.t) != 0) {
                                dex13Var3 = new dex13(strDext);
                                if (dex13Var3.dexb(true)) {
                                    objDexb = strDext;
                                    time = strDext;
                                    time = dex13Var3.dexo.getTime();
                                }
                                objDexb = strDext;
                                time = strDext;
                                dex13Var3.dexb();
                                objDexb = time;
                            }
                        }
                        objDexb = strDext;
                        obj2 = objDexb;
                        collection.add(obj2);
                        if (this.dexj == 1) {
                            dexa(collection);
                        }
                        dex13Var = this.dexe;
                        if (dex13Var.dexa != 16) {
                            c = dex13Var.dexd;
                            if (c == '\"') {
                                dex13Var.dexb = dex13Var.dexe;
                                dex13Var.dexq();
                            } else if (c < '0') {
                                if (c == '{') {
                                    dex13Var.dexa = 12;
                                    i3 = dex13Var.dexe + 1;
                                    dex13Var.dexe = i3;
                                    if (i3 >= dex13Var.dexr) {
                                        cCharAt = 26;
                                    } else {
                                        cCharAt = dex13Var.dexq.charAt(i3);
                                    }
                                    dex13Var.dexd = cCharAt;
                                } else {
                                    dex13Var.dexk();
                                }
                            } else if (c == '{') {
                                dex13Var.dexa = 12;
                                i3 = dex13Var.dexe + 1;
                                dex13Var.dexe = i3;
                                if (i3 >= dex13Var.dexr) {
                                    cCharAt = 26;
                                } else {
                                    cCharAt = dex13Var.dexq.charAt(i3);
                                }
                                dex13Var.dexd = cCharAt;
                            } else {
                                dex13Var.dexk();
                            }
                        }
                    } else {
                        dex13Var2 = this.dexe;
                        if ((dex13Var2.dexc & com.wangmai.insightvision.openadsdk.d.i.d.h.t) != 0) {
                            objDexf = dex13Var2.dexa(true);
                        } else {
                            objDexf = dex13Var2.dexa(false);
                        }
                    }
                    this.dexe.dexb(16);
                    obj2 = objDexf;
                    collection.add(obj2);
                    if (this.dexj == 1) {
                        dexa(collection);
                    }
                    dex13Var = this.dexe;
                    if (dex13Var.dexa != 16) {
                        c = dex13Var.dexd;
                        if (c == '\"') {
                            dex13Var.dexb = dex13Var.dexe;
                            dex13Var.dexq();
                        } else if (c < '0') {
                            if (c == '{') {
                                dex13Var.dexa = 12;
                                i3 = dex13Var.dexe + 1;
                                dex13Var.dexe = i3;
                                if (i3 >= dex13Var.dexr) {
                                    cCharAt = 26;
                                } else {
                                    cCharAt = dex13Var.dexq.charAt(i3);
                                }
                                dex13Var.dexd = cCharAt;
                            } else {
                                dex13Var.dexk();
                            }
                        } else if (c == '{') {
                            dex13Var.dexa = 12;
                            i3 = dex13Var.dexe + 1;
                            dex13Var.dexe = i3;
                            if (i3 >= dex13Var.dexr) {
                                cCharAt = 26;
                            } else {
                                cCharAt = dex13Var.dexq.charAt(i3);
                            }
                            dex13Var.dexd = cCharAt;
                        } else {
                            dex13Var.dexk();
                        }
                    }
                }
                i++;
            }
        } catch (Throwable th) {
            if (!z2) {
                this.dexf = dex20Var;
            }
            throw th;
        }
    }

    public void dexa(Map map, Object obj) {
        b bVar = new b(map, obj);
        dexa dexaVarDexd = dexd();
        dexaVarDexd.dexc = bVar;
        dexaVarDexd.dexd = this.dexf;
        this.dexj = 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:0x00ba  */
    public Object dexb(Object obj) {
        Collection bVar;
        dex13 dex13Var = this.dexe;
        int i = dex13Var.dexa;
        if (i == 2) {
            Number numberDexf = dex13Var.dexf();
            this.dexe.dexk();
            return numberDexf;
        }
        if (i == 3) {
            Number numberDexa = dex13Var.dexa((dex13Var.dexc & com.wangmai.insightvision.openadsdk.d.i.d.h.t) != 0);
            this.dexe.dexk();
            return numberDexa;
        }
        if (i == 4) {
            String strDext = dex13Var.dext();
            this.dexe.dexb(16);
            if ((this.dexe.dexc & com.wangmai.insightvision.openadsdk.d.i.d.f.t) != 0) {
                dex13 dex13Var2 = new dex13(strDext);
                try {
                    if (dex13Var2.dexb(true)) {
                        return dex13Var2.dexo.getTime();
                    }
                } finally {
                    dex13Var2.dexb();
                }
            }
            return strDext;
        }
        if (i == 12) {
            return dexb((dex13Var.dexc & com.wangmai.insightvision.openadsdk.d.i.d.o.t) != 0 ? new com.wangmai.insightvision.openadsdk.d.e(new LinkedHashMap()) : new com.wangmai.insightvision.openadsdk.d.e(), obj);
        }
        if (i != 14) {
            switch (i) {
                case 6:
                    dex13Var.dexb(16);
                    return Boolean.TRUE;
                case 7:
                    dex13Var.dexb(16);
                    return Boolean.FALSE;
                case 8:
                    dex13Var.dexk();
                    return null;
                case 9:
                    dex13Var.dexb(18);
                    dex13 dex13Var3 = this.dexe;
                    if (dex13Var3.dexa != 18) {
                        throw new com.wangmai.insightvision.openadsdk.d.d("syntax error, " + this.dexe.dexd());
                    }
                    dex13Var3.dexb(10);
                    dexa(10);
                    long jLongValue = this.dexe.dexf().longValue();
                    dexa(2);
                    dexa(11);
                    return new Date(jLongValue);
                default:
                    switch (i) {
                        case 20:
                            if (dex13Var.dexg()) {
                                return null;
                            }
                            throw new com.wangmai.insightvision.openadsdk.d.d("syntax error, " + this.dexe.dexd());
                        case 21:
                            dex13Var.dexk();
                            bVar = new HashSet();
                            break;
                        case 22:
                            dex13Var.dexk();
                            bVar = new TreeSet();
                            break;
                        case 23:
                            dex13Var.dexk();
                            return null;
                        default:
                            throw new com.wangmai.insightvision.openadsdk.d.d("syntax error, " + this.dexe.dexd());
                    }
                    break;
            }
        } else {
            bVar = new com.wangmai.insightvision.openadsdk.d.b();
        }
        dexa(bVar, obj);
        return bVar;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x007e A[Catch: all -> 0x03ef, TryCatch #2 {all -> 0x03ef, blocks: (B:21:0x006c, B:24:0x0076, B:28:0x0082, B:27:0x007e, B:32:0x0090, B:34:0x009a, B:37:0x00a2, B:38:0x00c0, B:97:0x01c8, B:101:0x01da, B:117:0x01f9, B:120:0x0206, B:123:0x020d, B:125:0x0215, B:126:0x021e, B:128:0x0224, B:133:0x0231, B:137:0x0239, B:140:0x0247, B:141:0x0253, B:143:0x025c, B:144:0x025f, B:146:0x0269, B:147:0x0277, B:149:0x027d, B:151:0x028b, B:153:0x0293, B:158:0x02a2, B:159:0x02a8, B:161:0x02b0, B:162:0x02b5, B:167:0x02bf, B:168:0x02c6, B:169:0x02c7, B:171:0x02ce, B:173:0x02d2, B:174:0x02d5, B:176:0x02db, B:180:0x02e9, B:182:0x02f7, B:189:0x0306, B:191:0x030e, B:193:0x0315, B:195:0x0324, B:197:0x032c, B:200:0x0331, B:202:0x0335, B:222:0x0373, B:224:0x0377, B:228:0x0381, B:229:0x0399, B:203:0x0338, B:205:0x0340, B:208:0x0346, B:220:0x036c, B:209:0x034c, B:212:0x0355, B:215:0x035b, B:218:0x0360, B:219:0x0367, B:230:0x039a, B:231:0x03b6, B:234:0x03bb, B:240:0x03cd, B:242:0x03d3, B:244:0x03df, B:245:0x03e5, B:247:0x03ea, B:351:0x056f, B:355:0x0579, B:358:0x0582, B:362:0x0595, B:361:0x058f, B:366:0x05a1, B:370:0x05b4, B:372:0x05bd, B:376:0x05d0, B:377:0x05d4, B:394:0x0616, B:375:0x05ca, B:380:0x05db, B:384:0x05ee, B:383:0x05e8, B:387:0x05f7, B:391:0x060a, B:390:0x0604, B:392:0x0611, B:369:0x05ae, B:398:0x0620, B:399:0x0638, B:350:0x056c, B:256:0x03fe, B:259:0x0407, B:263:0x041e, B:265:0x0427, B:270:0x0434, B:271:0x0437, B:273:0x0441, B:275:0x0448, B:277:0x044c, B:284:0x045d, B:285:0x0475, B:274:0x0445, B:262:0x0418, B:288:0x047a, B:292:0x048d, B:294:0x049e, B:298:0x04b2, B:300:0x04b8, B:303:0x04be, B:305:0x04c4, B:307:0x04cc, B:310:0x04dc, B:313:0x04e4, B:314:0x04e6, B:316:0x04eb, B:318:0x04f4, B:321:0x04fd, B:322:0x0500, B:324:0x0506, B:326:0x050d, B:333:0x051a, B:334:0x0532, B:319:0x04f8, B:295:0x04a9, B:291:0x0487, B:337:0x0537, B:339:0x053c, B:341:0x0544, B:345:0x0555, B:347:0x0559, B:349:0x0561, B:400:0x0639, B:402:0x064a, B:403:0x064e, B:405:0x0657, B:412:0x066e, B:413:0x0686, B:100:0x01d4, B:119:0x0202, B:42:0x00c8, B:46:0x00d9, B:45:0x00d3, B:52:0x00ec, B:54:0x00f6, B:55:0x00f9, B:58:0x00fe, B:59:0x0114, B:69:0x0127, B:70:0x012d, B:72:0x0132, B:75:0x013f, B:76:0x0143, B:79:0x0149, B:80:0x0163, B:73:0x0137, B:81:0x0164, B:82:0x017e, B:88:0x0188, B:91:0x0197, B:92:0x019d, B:93:0x01bb, B:94:0x01bc, B:414:0x0687, B:415:0x069f, B:416:0x06a0, B:417:0x06b8), top: B:424:0x006c, inners: #0, #1 }] */
    /* JADX WARN: Path cross not found for [B:24:0x0076, B:25:0x007a], limit reached: 459 */
    /* JADX WARN: Path cross not found for [B:25:0x007a, B:23:0x0074], limit reached: 459 */
    /* JADX WARN: Path cross not found for [B:25:0x007a, B:24:0x0076], limit reached: 459 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007e -> B:24:0x0076). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object dexb(java.util.Map r19, java.lang.Object r20) {
        /*
            Method dump skipped, instruction units count: 1726
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cj.mobile.wm.dex11.dexb(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public List<f> dexb() {
        if (this.dexl == null) {
            this.dexl = new ArrayList(2);
        }
        return this.dexl;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public final void dexb(Collection collection) throws com.wangmai.insightvision.openadsdk.d.d {
        dexa(collection, (Object) null);
    }

    public List<g> dexc() {
        if (this.dexk == null) {
            this.dexk = new ArrayList(2);
        }
        return this.dexk;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Code duplicated, block: B:41:0x00bc  */
    public void dexc(Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        Object objDexa;
        Class<?> cls = obj.getClass();
        j jVarDexa = this.dexb.dexa((Type) cls);
        dex15 dex15Var = jVarDexa instanceof dex15 ? (dex15) jVarDexa : null;
        int i = this.dexe.dexa;
        if (i != 12 && i != 16) {
            throw new com.wangmai.insightvision.openadsdk.d.d("syntax error, expect {, actual " + dex14.dexa(i));
        }
        while (true) {
            String strDexa = this.dexe.dexa(this.dexa);
            if (strDexa == null) {
                dex13 dex13Var = this.dexe;
                int i2 = dex13Var.dexa;
                if (i2 == 13) {
                    dex13Var.dexb(16);
                    return;
                } else if (i2 == 16) {
                    continue;
                }
            }
            h hVarDexa = dex15Var != null ? dex15Var.dexa(strDexa) : null;
            if (hVarDexa == null) {
                dex13 dex13Var2 = this.dexe;
                if ((dex13Var2.dexc & com.wangmai.insightvision.openadsdk.d.i.d.i.t) == 0) {
                    throw new com.wangmai.insightvision.openadsdk.d.d("setter not found, class " + cls.getName() + ", property " + strDexa);
                }
                dex13Var2.dexa(com.google.common.net.c.b);
                dexe();
                dex13 dex13Var3 = this.dexe;
                if (dex13Var3.dexa == 13) {
                    dex13Var3.dexk();
                    return;
                }
            } else {
                n0 n0Var = hVarDexa.dexa;
                Class<?> cls2 = n0Var.dexg;
                Type type = n0Var.dexh;
                if (cls2 == Integer.TYPE) {
                    this.dexe.dexa(com.google.common.net.c.b);
                    objDexa = x.dexa.dexa(this, type, null);
                } else if (cls2 == String.class) {
                    this.dexe.dexa(com.google.common.net.c.b);
                    objDexa = dexg();
                } else if (cls2 == Long.TYPE) {
                    this.dexe.dexa(com.google.common.net.c.b);
                    objDexa = x.dexa.dexa(this, type, null);
                } else {
                    j jVarDexa2 = this.dexb.dexa(cls2, type);
                    this.dexe.dexa(com.google.common.net.c.b);
                    objDexa = jVarDexa2.dexa(this, type, null);
                }
                hVarDexa.dexa(obj, objDexa);
                dex13 dex13Var4 = this.dexe;
                int i3 = dex13Var4.dexa;
                if (i3 != 16 && i3 == 13) {
                    dex13Var4.dexb(16);
                    return;
                }
            }
        }
    }

    public dexa dexd() {
        List<dexa> list = this.dexi;
        return list.get(list.size() - 1);
    }

    public Object dexe() {
        return dexb((Object) null);
    }

    public com.wangmai.insightvision.openadsdk.d.e dexf() {
        return (com.wangmai.insightvision.openadsdk.d.e) dexb((this.dexe.dexc & com.wangmai.insightvision.openadsdk.d.i.d.o.t) != 0 ? new com.wangmai.insightvision.openadsdk.d.e(new LinkedHashMap()) : new com.wangmai.insightvision.openadsdk.d.e(), null);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public String dexg() throws com.wangmai.insightvision.openadsdk.d.d {
        dex13 dex13Var;
        int i;
        dex13 dex13Var2 = this.dexe;
        int i2 = dex13Var2.dexa;
        if (i2 != 4) {
            if (i2 == 2) {
                String strDexl = dex13Var2.dexl();
                this.dexe.dexb(16);
                return strDexl;
            }
            Object objDexe = dexe();
            if (objDexe == null) {
                return null;
            }
            return objDexe.toString();
        }
        String strDext = dex13Var2.dext();
        dex13 dex13Var3 = this.dexe;
        char c = dex13Var3.dexd;
        if (c == ',') {
            int i3 = dex13Var3.dexe + 1;
            dex13Var3.dexe = i3;
            dex13Var3.dexd = i3 < dex13Var3.dexr ? dex13Var3.dexq.charAt(i3) : (char) 26;
            this.dexe.dexa = 16;
        } else {
            if (c == ']') {
                int i4 = dex13Var3.dexe + 1;
                dex13Var3.dexe = i4;
                dex13Var3.dexd = i4 < dex13Var3.dexr ? dex13Var3.dexq.charAt(i4) : (char) 26;
                dex13Var = this.dexe;
                i = 15;
            } else if (c == '}') {
                int i5 = dex13Var3.dexe + 1;
                dex13Var3.dexe = i5;
                dex13Var3.dexd = i5 < dex13Var3.dexr ? dex13Var3.dexq.charAt(i5) : (char) 26;
                dex13Var = this.dexe;
                i = 13;
            } else {
                dex13Var3.dexk();
            }
            dex13Var.dexa = i;
        }
        return strDext;
    }

    public void dexh() {
        this.dexf = this.dexf.dexb;
        dex20[] dex20VarArr = this.dexg;
        int i = this.dexh - 1;
        dex20VarArr[i] = null;
        this.dexh = i;
    }
}
