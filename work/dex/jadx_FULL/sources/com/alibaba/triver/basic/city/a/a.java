package com.alibaba.triver.basic.city.a;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.basic.city.b.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<b> f24691a;

    public static List<b> a() {
        ArrayList arrayList = new ArrayList();
        f24691a = arrayList;
        if (!arrayList.isEmpty()) {
            return f24691a;
        }
        JSONObject object = JSON.parseObject(IOUtils.readAsset(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getResources(null), "tr_china_cities.json"));
        Iterator<Map.Entry<String, Object>> it = object.entrySet().iterator();
        while (it.hasNext()) {
            String string = it.next().getKey().toString();
            JSONObject jSONObject = object.getJSONObject(string);
            f24691a.add(new b(jSONObject.getString("name"), "", jSONObject.getString("spell"), string));
        }
        Collections.sort(f24691a, new Comparator<b>() { // from class: com.alibaba.triver.basic.city.a.a.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(b bVar, b bVar2) {
                return bVar.c().charAt(0) - bVar2.c().charAt(0);
            }
        });
        return f24691a;
    }

    public static List<b> a(String str) {
        ArrayList arrayList = new ArrayList();
        List<b> list = f24691a;
        if (list != null) {
            for (b bVar : list) {
                if (bVar.b().indexOf(str) >= 0) {
                    arrayList.add(bVar);
                }
                if (bVar.c().indexOf(str) >= 0) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }
}
