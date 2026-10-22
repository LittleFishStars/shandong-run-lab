package com.byazt.qu;

import android.text.TextUtils;
import com.byazt.it.ve;
import com.byazt.vif.uj;
import com.byazt.whk.tt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 898, 20})
public class c implements tt {
    public static volatile c c;

    public static c c() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    @Override // com.byazt.whk.tt
    public String tt() {
        return "ugen_render";
    }

    @Override // com.byazt.whk.tt
    public String c(String str, String str2) {
        int i = uj.c(str2, tt()).get(str, 0);
        return (i == 0 && (str.equals("h5_render_success") || str.equals("h5_render_fail") || str.equals("native_render_success") || str.equals("native_render_fail"))) ? "0" : String.valueOf(i);
    }

    @Override // com.byazt.whk.tt
    public void c(String str, String str2, String str3) {
        ve veVarC = uj.c(str3, tt());
        synchronized (veVarC) {
            if (str.equals("h5_render_success") || str.equals("h5_render_fail")) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(veVarC.get("key_h5_render_result_list", new HashSet()));
                if (linkedHashSet.size() >= 100) {
                    Iterator it = linkedHashSet.iterator();
                    while (it.hasNext()) {
                        String str4 = (String) it.next();
                        if (TextUtils.isEmpty(str4)) {
                            it.remove();
                        } else {
                            if ((System.currentTimeMillis() - Long.parseLong(str4.substring(0, str4.length() - 1))) / 3600000.0d <= 168.0d && linkedHashSet.size() < 100) {
                                break;
                            }
                            it.remove();
                            if (str4.endsWith("0")) {
                                veVarC.put("h5_render_success", veVarC.get("h5_render_success", 0) - 1);
                            } else if (str4.endsWith("1")) {
                                veVarC.put("h5_render_fail", veVarC.get("h5_render_fail", 0) - 1);
                            }
                        }
                    }
                }
                if (str.equals("h5_render_success")) {
                    veVarC.put("h5_render_success", veVarC.get("h5_render_success", 0) + 1);
                } else {
                    veVarC.put("h5_render_fail", veVarC.get("h5_render_fail", 0) + 1);
                }
                linkedHashSet.add(str2);
                veVarC.put("key_h5_render_result_list", new HashSet(new ArrayList(linkedHashSet)));
            }
            if (str.equals("native_render_success") || str.equals("native_render_fail")) {
                LinkedHashSet linkedHashSet2 = new LinkedHashSet(veVarC.get("native_key_render_result_list", new HashSet()));
                if (linkedHashSet2.size() >= 100) {
                    Iterator it2 = linkedHashSet2.iterator();
                    while (it2.hasNext()) {
                        String str5 = (String) it2.next();
                        if (TextUtils.isEmpty(str5)) {
                            it2.remove();
                        } else {
                            if ((System.currentTimeMillis() - Long.parseLong(str5.substring(0, str5.length() - 1))) / 3600000.0d <= 168.0d && linkedHashSet2.size() < 100) {
                                break;
                            }
                            it2.remove();
                            if (str5.endsWith("0")) {
                                veVarC.put("native_render_success", veVarC.get("native_render_success", 0) - 1);
                            } else if (str5.endsWith("1")) {
                                veVarC.put("native_render_fail", veVarC.get("native_render_fail", 0) - 1);
                            }
                        }
                    }
                }
                if (str.equals("native_render_success")) {
                    veVarC.put("native_render_success", veVarC.get("native_render_success", 0) + 1);
                } else {
                    veVarC.put("native_render_fail", veVarC.get("native_render_fail", 0) + 1);
                }
                linkedHashSet2.add(str2);
                veVarC.put("native_key_render_result_list", new HashSet(new ArrayList(linkedHashSet2)));
            }
        }
    }
}
