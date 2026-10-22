package com.byazt.pct;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LruCache;
import com.alibaba.android.arouter.utils.Consts;
import com.bytedance.component.sdk.annotation.WorkerThread;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 124, 117})
public class rl {
    public final Map<String, List<tt>> c = new ConcurrentHashMap();
    public volatile boolean n = false;
    public final LruCache<String, ve> tt;
    public final String uj;
    public final sl.c ve;

    @com.byazt.zqa.c(c = {0, 1, 124, 782})
    public static class c extends IllegalStateException {
        public c(String str) {
            super(str);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 124, 1957})
    public static final class tt {
        public Pattern c;
        public gu tt;
        public List<String> uj;
        public List<String> ve;

        private tt() {
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 124, 1995})
    public static final class ve {
        public gu c = gu.PUBLIC;
        public Set<String> tt = new HashSet();
        public Set<String> ve = new HashSet();
    }

    @WorkerThread
    public rl(String str, int i, sl.c cVar, final Executor executor, JSONObject jSONObject) {
        this.uj = str;
        if (i <= 0) {
            this.tt = new LruCache<>(16);
        } else {
            this.tt = new LruCache<>(i);
        }
        this.ve = cVar;
        if (jSONObject != null) {
            update(jSONObject);
        } else {
            uj(str);
            new Object() { // from class: com.byazt.pct.rl.1
            };
        }
    }

    private static String tt(String str) {
        String[] strArrSplit;
        int length;
        if (str == null || (length = (strArrSplit = str.split("[.]")).length) < 2) {
            return null;
        }
        if (length == 2) {
            return str;
        }
        return strArrSplit[length - 2] + Consts.DOT + strArrSplit[length - 1];
    }

    private static String uj(String str) {
        return "com.bytedance.ies.web.jsbridge2.PermissionConfig.".concat(String.valueOf(str));
    }

    private List<tt> ve(String str) throws c {
        if (this.n) {
            return this.c.get(str);
        }
        throw new c("Permission config is outdated!");
    }

    public ve c(String str, Set<String> set) {
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        String authority = uri.getAuthority();
        String string = new Uri.Builder().scheme(scheme).authority(authority).path(uri.getPath()).toString();
        ve veVar = new ve();
        if (authority == null || authority.isEmpty()) {
            veVar.c = gu.PUBLIC;
            return veVar;
        }
        for (String str2 : set) {
            if (authority.equals(str2) || authority.endsWith(Consts.DOT.concat(String.valueOf(str2)))) {
                veVar.c = gu.PRIVATE;
                return veVar;
            }
        }
        ve veVar2 = this.tt.get(string);
        return veVar2 != null ? veVar2 : c(string);
    }

    public void update(JSONObject jSONObject) {
        c(jSONObject);
        uj(this.uj);
    }

    @WorkerThread
    private static tt tt(JSONObject jSONObject) throws JSONException {
        tt ttVar = new tt();
        ttVar.c = Pattern.compile(jSONObject.getString("pattern"));
        ttVar.tt = gu.c(jSONObject.getString("group"));
        ttVar.ve = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("included_methods");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                ttVar.ve.add(jSONArrayOptJSONArray.getString(i));
            }
        }
        ttVar.uj = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("excluded_methods");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                ttVar.uj.add(jSONArrayOptJSONArray2.getString(i2));
            }
        }
        return ttVar;
    }

    @WorkerThread
    private void c(JSONObject jSONObject) {
        this.c.clear();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONArray jSONArray = jSONObject2.getJSONArray(next);
                LinkedList linkedList = new LinkedList();
                this.c.put(next, linkedList);
                for (int i = 0; i < jSONArray.length(); i++) {
                    linkedList.add(tt(jSONArray.getJSONObject(i)));
                }
            }
        } catch (JSONException e) {
            i.tt("Parse configurations failed, response: " + jSONObject.toString(), e);
        }
        this.n = true;
    }

    private ve c(String str) throws c {
        ve veVar = new ve();
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        String authority = uri.getAuthority();
        String strTt = tt(authority);
        if (!TextUtils.isEmpty(scheme) && !TextUtils.isEmpty(authority) && strTt != null) {
            List<tt> listVe = ve(strTt);
            if (listVe == null) {
                return veVar;
            }
            for (tt ttVar : listVe) {
                if (ttVar.c.matcher(str).find()) {
                    if (ttVar.tt.compareTo(veVar.c) >= 0) {
                        veVar.c = ttVar.tt;
                    }
                    veVar.tt.addAll(ttVar.ve);
                    veVar.ve.addAll(ttVar.uj);
                }
            }
            this.tt.put(str, veVar);
            return veVar;
        }
        veVar.c = gu.PUBLIC;
        return veVar;
    }
}
