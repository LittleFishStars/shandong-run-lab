package com.byazt.pct;

import com.zj.adlib.bv9;
import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 124, 71})
public final class x {
    public t c;

    private x(t tVar) {
        this.c = tVar;
    }

    public static x c(t tVar) {
        return new x(tVar);
    }

    public <T> T c(String str, Type type) throws JSONException {
        c(str);
        return (type.equals(JSONObject.class) || ((type instanceof Class) && JSONObject.class.isAssignableFrom((Class) type))) ? (T) new JSONObject(str) : (T) this.c.c(str, type);
    }

    public <T> String c(T t) {
        String string;
        if (t == null) {
            return "{}";
        }
        if (!(t instanceof JSONObject) && !(t instanceof JSONArray)) {
            string = this.c.c(t);
        } else {
            string = t.toString();
        }
        c(string);
        return string;
    }

    private static void c(String str) {
        if (str.startsWith(bv9.b) && str.endsWith("}")) {
            return;
        }
        i.c(new IllegalArgumentException("Param is not allowed to be List or JSONArray, rawString:\n ".concat(str)));
    }
}
