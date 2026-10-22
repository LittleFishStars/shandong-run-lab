package com.byazt.wr;

import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.android.arouter.utils.Consts;
import com.byazt.dna.nu;
import com.byazt.dna.z;
import com.byazt.nr.m;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1361, 13})
public class tt implements com.byazt.yy.c, com.byazt.yy.tt {
    public com.byazt.iy.ve c;
    public final com.byazt.iy.ve tt;
    public final boolean ve;

    public tt(com.byazt.iy.ve veVar, boolean z) {
        this.c = veVar;
        this.tt = veVar;
        this.ve = z;
    }

    private void c(String str) {
        int i;
        nu nuVar;
        com.byazt.iy.ve encrypt;
        if (TextUtils.isEmpty(str)) {
            i = 0;
        } else {
            try {
                i = Integer.parseInt(str);
            } catch (Throwable unused) {
                i = 0;
            }
        }
        if (i == 0) {
            this.c = null;
            return;
        }
        com.byazt.iy.ve veVar = this.c;
        if ((veVar != null && veVar.type() == i) || (nuVar = (nu) com.byazt.ut.uj.getService("kv_store_factory")) == null || (encrypt = nuVar.getEncrypt(i)) == null) {
            return;
        }
        this.c = encrypt;
    }

    private Pair<String, String> getType(String str) {
        if (str.contains(Consts.DOT)) {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length >= 2) {
                return new Pair<>(strArrSplit[0], strArrSplit[1]);
            }
        }
        return new Pair<>("s", str);
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00e0  */
    @Override // com.byazt.yy.c
    public Map<String, Object> c(File file) {
        FileReader fileReader;
        byte b;
        if (file == null || !file.exists()) {
            return null;
        }
        if (!file.canRead()) {
            m.tt("PropReaderWriter", "can't read file ".concat(String.valueOf(file)));
            return null;
        }
        Properties properties = new Properties();
        try {
            fileReader = new FileReader(file);
            try {
                properties.load(fileReader);
                Object obj = properties.get(".i.tt_ect");
                if (obj != null) {
                    c(String.valueOf(obj));
                }
                Enumeration<?> enumerationPropertyNames = properties.propertyNames();
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(properties.size());
                while (enumerationPropertyNames.hasMoreElements()) {
                    String strDecrypt = (String) enumerationPropertyNames.nextElement();
                    String property = properties.getProperty(strDecrypt);
                    if (strDecrypt != null && !strDecrypt.startsWith(".i.tt_ect")) {
                        if (this.ve) {
                            strDecrypt = this.c.decrypt(strDecrypt);
                        }
                        com.byazt.iy.ve veVar = this.c;
                        if (veVar != null) {
                            property = veVar.decrypt(property);
                        }
                        Pair<String, String> type = getType(strDecrypt);
                        String str = (String) type.second;
                        String str2 = (String) type.first;
                        int iHashCode = str2.hashCode();
                        if (iHashCode != 98) {
                            if (iHashCode != 102) {
                                if (iHashCode != 105) {
                                    if (iHashCode != 108) {
                                        if (iHashCode != 115) {
                                            if (iHashCode == 3680 && str2.equals("ss")) {
                                                b = 4;
                                            } else {
                                                b = -1;
                                            }
                                        } else if (str2.equals("s")) {
                                            b = 6;
                                        } else {
                                            b = -1;
                                        }
                                    } else if (str2.equals(t.d)) {
                                        b = 1;
                                    } else {
                                        b = -1;
                                    }
                                } else if (str2.equals("i")) {
                                    b = 0;
                                } else {
                                    b = -1;
                                }
                            } else if (str2.equals("f")) {
                                b = 2;
                            } else {
                                b = -1;
                            }
                        } else if (str2.equals("b")) {
                            b = 3;
                        } else {
                            b = -1;
                        }
                        if (b == 0) {
                            concurrentHashMap.put(str, Integer.valueOf(Integer.parseInt(property)));
                        } else if (b == 1) {
                            concurrentHashMap.put(str, Long.valueOf(Long.parseLong(property)));
                        } else if (b == 2) {
                            concurrentHashMap.put(str, Float.valueOf(Float.parseFloat(property)));
                        } else if (b == 3) {
                            concurrentHashMap.put(str, Boolean.valueOf(Boolean.parseBoolean(property)));
                        } else if (b != 4) {
                            concurrentHashMap.put(str, property);
                        } else {
                            JSONArray jSONArray = new JSONArray(property);
                            HashSet hashSet = new HashSet((int) (((double) jSONArray.length()) / 0.75d));
                            for (int i = 0; i < jSONArray.length(); i++) {
                                hashSet.add(jSONArray.optString(i));
                            }
                            concurrentHashMap.put(str, hashSet);
                        }
                    }
                }
                try {
                    fileReader.close();
                } catch (Throwable unused) {
                }
                return concurrentHashMap;
            } catch (Throwable th) {
                th = th;
                try {
                    boolean zDelete = file.delete();
                    z zVar = (z) com.byazt.ut.uj.getService("event");
                    if (zVar != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("file", file.getAbsolutePath());
                            jSONObject.put("delete", zDelete);
                            jSONObject.put("msg", "read failed");
                            jSONObject.put(bolts.c.f, "PropReaderWriter");
                        } catch (JSONException unused2) {
                        }
                        zVar.onExceptionEvent("kv", jSONObject, th);
                    }
                    m.tt("PropReader", "read failed， try delete = " + zDelete + "," + file.getAbsolutePath(), th);
                    if (fileReader == null) {
                        return null;
                    }
                    try {
                        return null;
                    } catch (Throwable unused3) {
                        return null;
                    }
                } finally {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused4) {
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileReader = null;
        }
    }

    @Override // com.byazt.yy.tt
    public void c(Map<String, Object> map, File file) throws Throwable {
        FileWriter fileWriter;
        Throwable th;
        String strConcat;
        if (file == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        Properties properties = new Properties();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null) {
                if (entry.getValue() instanceof Set) {
                    Set set = (Set) entry.getValue();
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        jSONArray.put((String) it.next());
                    }
                    strConcat = "ss.".concat(key);
                    value = jSONArray.toString();
                } else if (entry.getValue() instanceof Boolean) {
                    strConcat = "b.".concat(key);
                } else if (entry.getValue() instanceof Integer) {
                    strConcat = "i.".concat(key);
                } else if (entry.getValue() instanceof Long) {
                    strConcat = "l.".concat(key);
                } else if ((entry.getValue() instanceof Float) || (entry.getValue() instanceof Double)) {
                    strConcat = "f.".concat(key);
                } else {
                    strConcat = "s.".concat(key);
                }
                String strValueOf = String.valueOf(value);
                if (this.ve) {
                    strConcat = this.tt.encrypt(strConcat);
                }
                com.byazt.iy.ve veVar = this.tt;
                if (veVar != null) {
                    strValueOf = veVar.encrypt(strValueOf);
                }
                properties.put(strConcat, strValueOf);
            }
        }
        try {
            fileWriter = new FileWriter(file);
            try {
                com.byazt.iy.ve veVar2 = this.tt;
                properties.put(".i.tt_ect", veVar2 != null ? String.valueOf(veVar2.type()) : "0");
                properties.store(fileWriter, (String) null);
                fileWriter.flush();
                try {
                    fileWriter.close();
                } catch (Exception unused2) {
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            fileWriter = null;
            th = th3;
        }
    }
}
