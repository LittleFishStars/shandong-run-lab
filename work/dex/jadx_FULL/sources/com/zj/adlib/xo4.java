package com.zj.adlib;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.Gson;
import com.huachenjie.common.webview.JsCallback;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class xo4 {
    public static final String c = "JsCallJava";
    public static final String d = "{\"code\": %d, \"result\": %s}";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Gson f45862a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f20690a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap<String, Method> f20691a;
    public String b;

    public xo4(String injectedName, Class injectedCls) {
        String strA;
        try {
            if (TextUtils.isEmpty(injectedName)) {
                throw new Exception("injected name can not be null");
            }
            this.f20690a = injectedName;
            this.f20691a = new HashMap<>();
            Method[] declaredMethods = injectedCls.getDeclaredMethods();
            StringBuilder sb = new StringBuilder("javascript:(function(b){console.log(\"");
            sb.append(this.f20690a);
            sb.append(" initialization begin\");var a={queue:[],callback:function(){var d=Array.prototype.slice.call(arguments,0);var c=d.shift();var e=d.shift();this.queue[c].apply(this,d);if(!e){delete this.queue[c]}}};");
            for (Method method : declaredMethods) {
                if (method.getModifiers() == 9 && (strA = a(method)) != null) {
                    this.f20691a.put(strA, method);
                    sb.append(String.format("a.%s=", method.getName()));
                }
            }
            sb.append("function(){var f=Array.prototype.slice.call(arguments,0);if(f.length<1){throw\"");
            sb.append(this.f20690a);
            sb.append(" call error, message:miss method name\"}var e=[];for(var h=1;h<f.length;h++){var c=f[h];var j=typeof c;e[e.length]=j;if(j==\"function\"){var d=a.queue.length;a.queue[d]=c;f[h]=d}}var g=JSON.parse(prompt(JSON.stringify({method:f.shift(),types:e,args:f})));if(g.code!=200){throw\"");
            sb.append(this.f20690a);
            sb.append(" call error, code:\"+g.code+\", message:\"+g.result}return g.result};Object.getOwnPropertyNames(a).forEach(function(d){var c=a[d];if(typeof c===\"function\"&&d!==\"callback\"){a[d]=function(){return c.apply(a,[d].concat(Array.prototype.slice.call(arguments,0)))}}});b.");
            sb.append(this.f20690a);
            sb.append("=a;console.log(\"");
            sb.append(this.f20690a);
            sb.append(" initialization end\")})(window);");
            this.b = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final String a(Method method) {
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        int length = parameterTypes.length;
        if (length < 1 || parameterTypes[0] != WebView.class) {
            Log.w(c, "method(" + name + ") must use webview to be first parameter, will be pass");
            return null;
        }
        for (int i = 1; i < length; i++) {
            Class<?> cls = parameterTypes[i];
            if (cls == String.class) {
                name = name + "_S";
            } else if (cls == Integer.TYPE || cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE) {
                name = name + "_N";
            } else if (cls == Boolean.TYPE) {
                name = name + "_B";
            } else if (cls == JSONObject.class) {
                name = name + "_O";
            } else if (cls == JsCallback.class) {
                name = name + "_F";
            } else {
                name = name + "_P";
            }
        }
        return name;
    }

    public String b() {
        return this.b;
    }

    public final String c(String reqJson, int stateCode, Object result) {
        String strValueOf;
        if (result == null) {
            strValueOf = "null";
        } else if (result instanceof String) {
            strValueOf = "\"" + ((Object) ((String) result).replace("\"", "\\\"")) + "\"";
        } else if ((result instanceof Integer) || (result instanceof Long) || (result instanceof Boolean) || (result instanceof Float) || (result instanceof Double) || (result instanceof JSONObject)) {
            strValueOf = String.valueOf(result);
        } else {
            if (this.f45862a == null) {
                this.f45862a = new Gson();
            }
            strValueOf = this.f45862a.toJson(result);
        }
        String str = String.format(d, Integer.valueOf(stateCode), strValueOf);
        Log.d(c, this.f20690a + " call json: " + reqJson + " result:" + str);
        return str;
    }

    public String call(WebView webView, String jsonStr) {
        if (TextUtils.isEmpty(jsonStr)) {
            return c(jsonStr, 500, "call data empty");
        }
        try {
            JSONObject jSONObject = new JSONObject(jsonStr);
            String string = jSONObject.getString("method");
            JSONArray jSONArray = jSONObject.getJSONArray("types");
            JSONArray jSONArray2 = jSONObject.getJSONArray("args");
            int length = jSONArray.length();
            Object[] objArr = new Object[length + 1];
            int i = 0;
            objArr[0] = webView;
            int i2 = 0;
            while (true) {
                Object jSONObject2 = null;
                if (i >= length) {
                    break;
                }
                String strOptString = jSONArray.optString(i);
                if (TypedValues.Custom.S_STRING.equals(strOptString)) {
                    string = string + "_S";
                    int i3 = i + 1;
                    if (!jSONArray2.isNull(i)) {
                        jSONObject2 = jSONArray2.getString(i);
                    }
                    objArr[i3] = jSONObject2;
                } else if ("number".equals(strOptString)) {
                    string = string + "_N";
                    i2 = (i2 * 10) + i + 1;
                } else if (TypedValues.Custom.S_BOOLEAN.equals(strOptString)) {
                    string = string + "_B";
                    objArr[i + 1] = Boolean.valueOf(jSONArray2.getBoolean(i));
                } else if ("object".equals(strOptString)) {
                    string = string + "_O";
                    int i4 = i + 1;
                    if (!jSONArray2.isNull(i)) {
                        jSONObject2 = jSONArray2.getJSONObject(i);
                    }
                    objArr[i4] = jSONObject2;
                } else if ("function".equals(strOptString)) {
                    string = string + "_F";
                    objArr[i + 1] = new JsCallback(webView, this.f20690a, jSONArray2.getInt(i));
                } else {
                    string = string + "_P";
                }
                i++;
            }
            Method method = this.f20691a.get(string);
            if (method == null) {
                return c(jsonStr, 500, "not found method(" + string + ") with valid parameters");
            }
            if (i2 > 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                while (i2 > 0) {
                    int i5 = i2 - ((i2 / 10) * 10);
                    Class<?> cls = parameterTypes[i5];
                    if (cls == Integer.TYPE) {
                        objArr[i5] = Integer.valueOf(jSONArray2.getInt(i5 - 1));
                    } else if (cls == Long.TYPE) {
                        objArr[i5] = Long.valueOf(Long.parseLong(jSONArray2.getString(i5 - 1)));
                    } else {
                        objArr[i5] = Double.valueOf(jSONArray2.getDouble(i5 - 1));
                    }
                    i2 /= 10;
                }
            }
            return c(jsonStr, 200, method.invoke(null, objArr));
        } catch (Exception e) {
            if (e.getCause() != null) {
                return c(jsonStr, 500, "method execute error:" + e.getCause().getMessage());
            }
            return c(jsonStr, 500, "method execute error:" + e.getMessage());
        }
    }
}
