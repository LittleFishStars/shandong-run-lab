package android.taobao.windvane.extra.a;

import android.text.TextUtils;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e f21220a;
    private Hashtable<String, Hashtable<String, String>> b = null;

    public static e a() {
        if (f21220a == null) {
            synchronized (e.class) {
                if (f21220a == null) {
                    f21220a = new e();
                }
            }
        }
        return f21220a;
    }

    public JSONObject b() throws JSONException {
        if (this.b == null) {
            return new JSONObject();
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.b.keySet().iterator();
        while (it.hasNext()) {
            Hashtable<String, String> hashtable = this.b.get(it.next());
            JSONObject jSONObject = new JSONObject();
            Enumeration<String> enumerationKeys = hashtable.keys();
            while (enumerationKeys.hasMoreElements()) {
                String strNextElement = enumerationKeys.nextElement();
                jSONObject.put(strNextElement, hashtable.get(strNextElement));
            }
            jSONArray.put(jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("resources", jSONArray);
        return jSONObject2;
    }

    public void c() {
        Hashtable<String, Hashtable<String, String>> hashtable = this.b;
        if (hashtable != null) {
            hashtable.clear();
        }
    }

    public void a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.b == null) {
            this.b = new Hashtable<>();
        }
        Hashtable<String, String> hashtable = this.b.get(str);
        if (hashtable == null) {
            hashtable = new Hashtable<>();
            this.b.put(str, hashtable);
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        hashtable.put(str2, str3);
    }

    public String a(String str, String str2) {
        Hashtable<String, String> hashtable;
        Hashtable<String, Hashtable<String, String>> hashtable2 = this.b;
        if (hashtable2 == null || (hashtable = hashtable2.get(str)) == null) {
            return null;
        }
        return hashtable.get(str2);
    }

    public boolean a(String str) {
        Hashtable<String, Hashtable<String, String>> hashtable = this.b;
        if (hashtable == null) {
            return false;
        }
        return hashtable.containsKey(str);
    }
}
