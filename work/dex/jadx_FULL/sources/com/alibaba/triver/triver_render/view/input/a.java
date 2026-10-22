package com.alibaba.triver.triver_render.view.input;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.text.method.NumberKeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.embedview.IEmbedCallback;
import com.alibaba.ariver.integration.embedview.BaseEmbedView;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.zj.adlib.un1;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends BaseEmbedView implements TextWatcher, View.OnClickListener, TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25238a = "input";
    public static final String b = "InputEmbed";
    private static final String x = "returnType";
    private String A;
    private String B;
    private String C;
    private TBEditText c;
    private Context d;
    private String f;
    private String g;
    private String h;
    private boolean i;
    private String j;
    private String k;
    private String l;
    private boolean m;
    private String y;
    private String z;
    private int e = 1;
    private int n = 140;
    private boolean o = true;
    private String p = "done";
    private boolean q = false;
    private int r = 0;
    private int s = -1;
    private int t = -1;
    private boolean u = false;
    private boolean v = false;
    private String w = "text";

    private void b() {
        if (this.p != null && "text".equalsIgnoreCase(this.h)) {
            String str = this.p;
            str.hashCode();
            switch (str) {
                case "search":
                    this.c.setImeOptions(3);
                    break;
                case "go":
                    this.c.setImeOptions(2);
                    break;
                case "done":
                    this.c.setImeOptions(6);
                    break;
                case "next":
                    this.c.setImeOptions(5);
                    break;
                case "send":
                    this.c.setImeOptions(4);
                    break;
            }
        }
    }

    private void c() {
        float fB = b(this.B);
        b(this.C);
        this.c.setTextSize(2, fB);
    }

    private void d() {
        int iA = a(this.A, Color.rgb(255, 255, 255));
        int iA2 = a(this.y, Color.rgb(0, 0, 0));
        int iA3 = a(this.z, Color.rgb(0, 0, 0));
        this.c.setHintTextColor(iA2);
        this.c.setTextColor(iA3);
        this.c.setBackgroundColor(iA);
    }

    private void e() {
        int i = this.r;
        if (i <= 0 || i >= this.c.getText().length()) {
            return;
        }
        this.c.setSelection(this.r);
    }

    private void f() {
        int i;
        int i2 = this.s;
        if (i2 == -1 || i2 >= this.c.getText().length() || (i = this.t) == -1 || i >= this.c.getText().length()) {
            return;
        }
        this.c.setSelection(this.s, this.t);
    }

    private void g() {
        if (this.i) {
            this.c.setInputType(128);
            return;
        }
        if (TextUtils.isEmpty(this.w)) {
            return;
        }
        String str = this.w;
        str.hashCode();
        switch (str) {
            case "idcardpad":
            case "idcard":
                this.c.setKeyListener(new NumberKeyListener() { // from class: com.alibaba.triver.triver_render.view.input.a.2
                    @Override // android.text.method.NumberKeyListener
                    public char[] getAcceptedChars() {
                        return "0123456789Xx".toCharArray();
                    }

                    @Override // android.text.method.KeyListener
                    public int getInputType() {
                        return 1;
                    }
                });
                break;
            case "number":
            case "digit":
            case "numberpad":
                this.c.setInputType(2);
                this.c.setRawInputType(3);
                this.c.setKeyListener(DigitsKeyListener.getInstance("0123456789."));
                break;
            case "text":
                this.c.setInputType(1);
                break;
        }
    }

    private void h() {
        TBEditText tBEditText = this.c;
        if (tBEditText == null || tBEditText.hasFocus()) {
            return;
        }
        this.c.setFocusable(true);
        this.c.setFocusableInTouchMode(true);
        this.c.requestFocus();
        ((InputMethodManager) this.d.getSystemService("input_method")).showSoftInput(this.c, 0);
        e();
        f();
        a("focus", 0, "0", "");
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public Bitmap getSnapshot() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public String getType() {
        return f25238a;
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public View getView(int i, int i2, String str, String str2, Map<String, String> map) {
        a(map.toString());
        a(map);
        if (this.d == null) {
            return null;
        }
        TBEditText tBEditText = new TBEditText(this.d);
        this.c = tBEditText;
        tBEditText.setWidth(i);
        this.c.setHeight(i2);
        a();
        return this.c;
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onAttachedToWebView() {
        a("attached");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h();
    }

    @Override // com.alibaba.ariver.integration.embedview.BaseEmbedView, com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onCreate(Map<String, String> map) {
        super.onCreate(map);
        App app = this.mOuterApp;
        if (app != null && app.getAppContext() != null) {
            this.d = this.mOuterApp.getAppContext().getContext();
        }
        a(map);
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onDetachedToWebView() {
        a("detached");
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onEmbedViewVisibilityChanged(int i) {
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onReceivedMessage(String str, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        a("action is " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(jSONObject);
        if (str.equalsIgnoreCase("focus")) {
            h();
        } else if (str.equalsIgnoreCase("blur")) {
            a(false);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("success", "true");
        bridgeCallback.sendJSONResponse(jSONObject2);
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onReceivedRender(JSONObject jSONObject, BridgeCallback bridgeCallback) {
        a("onReceiveRender : " + jSONObject);
        a(jSONObject);
        a();
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String strSubstring;
        int i4;
        try {
            String string = charSequence.toString();
            String str = "";
            if (i3 == 0) {
                i4 = 46;
                a("keydown", 46, "", "");
                a("keyup", 46, "", "");
                a(f25238a, 46, "", "");
            } else {
                if (i3 == 1) {
                    strSubstring = String.valueOf(string.charAt(i));
                    a("keydown", -1, strSubstring, "");
                    a("keyup", -1, strSubstring, "");
                    a(f25238a, -1, strSubstring, "");
                } else {
                    if (i3 > 1) {
                        strSubstring = string.substring(i, i3 + i);
                        a(f25238a, -1, strSubstring, "");
                    }
                    i4 = -1;
                }
                str = strSubstring;
                i4 = -1;
            }
            TBEditText tBEditText = this.c;
            if (tBEditText == null || this.e == tBEditText.getLineCount()) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            int lineCount = this.c.getLineCount();
            this.e = lineCount;
            jSONObject.put("lineCount", (Object) Integer.valueOf(lineCount));
            jSONObject.put("height", (Object) Integer.valueOf(this.c.getHeight()));
            a("linechange", i4, str, jSONObject.toString());
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onWebViewPause() {
        a("Pause");
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onWebViewResume() {
        a("Resume");
    }

    private void a() {
        TBEditText tBEditText = this.c;
        if (tBEditText == null) {
            return;
        }
        tBEditText.setPadding(0, 0, 0, 0);
        this.c.setMaxLines(1);
        g();
        this.c.setText(this.f);
        this.c.setHint(this.j);
        if (this.m) {
            this.c.setEnabled(false);
            this.c.setOnClickListener(null);
        } else {
            this.c.setEnabled(true);
            this.c.setOnClickListener(this);
        }
        this.c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.n)});
        this.c.setFocusable(this.o);
        d();
        c();
        b();
        this.c.setKeyBordHideListener(new TBEditText.a() { // from class: com.alibaba.triver.triver_render.view.input.a.1
            @Override // com.alibaba.triver.triver_render.view.input.TBEditText.a
            public void a() {
                a.this.c.clearFocus();
            }
        });
    }

    private float b(String str) {
        try {
            if (TextUtils.isEmpty(str) || str.length() <= 2) {
                return 18.0f;
            }
            return Float.parseFloat(str.substring(0, str.length() - 2));
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
            return 18.0f;
        }
    }

    public void a(String str, int i, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("keyCode", (Object) Integer.valueOf(i));
        jSONObject.put("strKey", (Object) str2);
        jSONObject.put("extData", (Object) str3);
        jSONObject.put("value", (Object) this.c.getText().toString());
        jSONObject.put("element", (Object) this.mViewId);
        jSONObject.put("type", f25238a);
        super.sendEvent(str, jSONObject, new IEmbedCallback() { // from class: com.alibaba.triver.triver_render.view.input.a.3
            @Override // com.alibaba.ariver.engine.api.embedview.IEmbedCallback
            public void onResponse(JSONObject jSONObject2) {
            }
        });
    }

    private void a(String str) {
        RVLogger.e(b, str);
    }

    private void a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        this.f = map.containsKey("value") ? map.get("value") : "";
        this.g = map.containsKey("name") ? map.get("name") : "";
        this.h = map.containsKey("type") ? map.get("type") : "";
        this.j = map.containsKey("placeHolderValue") ? map.get("placeHolderValue") : "text";
        this.k = map.containsKey("placeHolderStyle") ? map.get("placeHolderStyle") : "";
        this.l = map.containsKey("placeHolderClass") ? map.get("placeHolderClass") : "";
        this.p = map.containsKey(x) ? map.get(x) : "done";
        this.y = map.containsKey("placeHolderColor") ? map.get("placeHolderColor") : "";
        this.z = map.containsKey("color") ? map.get("color") : "";
        this.A = map.containsKey("backgroundColor") ? map.get("backgroundColor") : "";
        this.B = map.containsKey("fontSize") ? map.get("fontSize") : "";
        this.C = map.containsKey("placeHolderSize") ? map.get("placeHolderSize") : "";
        this.i = map.containsKey("password") && map.get("password").equalsIgnoreCase("true");
        this.m = map.containsKey("disabled") && map.get("disabled").equalsIgnoreCase("true");
        this.o = map.containsKey("focus") && map.get("focus").equalsIgnoreCase("true");
        this.q = map.containsKey("confirmHold") && map.get("confirmHold").equalsIgnoreCase("true");
        this.u = map.containsKey("randomNumber") && map.get("randomNumber").equalsIgnoreCase("true");
        this.v = map.containsKey("controlled") && map.get("controlled").equalsIgnoreCase("true");
        this.n = map.containsKey("maxlength") ? a(map, "maxlength", 140) : 140;
        this.r = map.containsKey("cursor") ? a(map, "cursor", 0) : 0;
        this.s = map.containsKey("selectionStart") ? a(map, "selectionStart", -1) : -1;
        this.t = map.containsKey("selectionEnd") ? a(map, "selectionEnd", -1) : -1;
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.w = jSONObject.containsKey("keyboard") ? jSONObject.getString("keyboard") : "text";
        this.f = jSONObject.containsKey("value") ? jSONObject.getString("value") : "";
        this.g = jSONObject.containsKey("name") ? jSONObject.getString("name") : "";
        this.h = jSONObject.containsKey("type") ? jSONObject.getString("type") : "text";
        this.j = jSONObject.containsKey("placeHolderValue") ? jSONObject.getString("placeHolderValue") : "";
        this.k = jSONObject.containsKey("placeHolderStyle") ? jSONObject.getString("placeHolderStyle") : "";
        this.l = jSONObject.containsKey("placeHolderClass") ? jSONObject.getString("placeHolderClass") : "";
        this.p = jSONObject.containsKey(x) ? jSONObject.getString(x) : "done";
        this.y = jSONObject.containsKey("placeHolderColor") ? jSONObject.getString("placeHolderColor") : "";
        this.z = jSONObject.containsKey("color") ? jSONObject.getString("color") : "";
        this.A = jSONObject.containsKey("backgroundColor") ? jSONObject.getString("backgroundColor") : "";
        this.B = jSONObject.containsKey("fontSize") ? jSONObject.getString("fontSize") : "";
        this.C = jSONObject.containsKey("placeHolderSize") ? jSONObject.getString("placeHolderSize") : "";
        this.i = jSONObject.containsKey("password") && jSONObject.getString("password").equalsIgnoreCase("true");
        this.m = jSONObject.containsKey("disabled") && jSONObject.getString("disabled").equalsIgnoreCase("true");
        this.o = jSONObject.containsKey("focus") && jSONObject.getString("focus").equalsIgnoreCase("true");
        this.q = jSONObject.containsKey("confirmHold") && jSONObject.getString("confirmHold").equalsIgnoreCase("true");
        this.u = jSONObject.containsKey("randomNumber") && jSONObject.getString("randomNumber").equalsIgnoreCase("true");
        this.v = jSONObject.containsKey("controlled") && jSONObject.getString("controlled").equalsIgnoreCase("true");
        this.n = jSONObject.containsKey("maxlength") ? a(jSONObject, "maxlength", 140) : 140;
        this.r = jSONObject.containsKey("cursor") ? a(jSONObject, "cursor", 0) : 0;
        this.s = jSONObject.containsKey("selectionStart") ? a(jSONObject, "selectionStart", -1) : -1;
        this.t = jSONObject.containsKey("selectionEnd") ? a(jSONObject, "selectionEnd", -1) : -1;
    }

    private int a(Map<String, String> map, String str, int i) {
        try {
            return Integer.parseInt(map.get(str), 10);
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
            return i;
        }
    }

    private int a(JSONObject jSONObject, String str, int i) {
        try {
            return Integer.parseInt(jSONObject.getString(str), 10);
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
            return i;
        }
    }

    private int a(String str, int i) {
        int iRgb;
        try {
            if (TextUtils.isEmpty(str)) {
                return i;
            }
            if (str.startsWith(un1.b)) {
                int iIndexOf = str.indexOf(40);
                int iLastIndexOf = str.lastIndexOf(41);
                if (iIndexOf == -1 || iLastIndexOf == -1 || iLastIndexOf <= iIndexOf) {
                    return i;
                }
                String[] strArrSplit = str.substring(iIndexOf + 1, iLastIndexOf).split(",");
                if (strArrSplit.length != 4) {
                    return i;
                }
                iRgb = Color.argb(Integer.parseInt(strArrSplit[3]), Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]));
            } else if (str.startsWith(un1.f45182a)) {
                int iIndexOf2 = str.indexOf(40);
                int iLastIndexOf2 = str.lastIndexOf(41);
                if (iIndexOf2 == -1 || iLastIndexOf2 == -1 || iLastIndexOf2 <= iIndexOf2) {
                    return i;
                }
                String[] strArrSplit2 = str.substring(iIndexOf2 + 1, iLastIndexOf2).split(",");
                if (strArrSplit2.length != 3) {
                    return i;
                }
                iRgb = Color.rgb(Integer.parseInt(strArrSplit2[0]), Integer.parseInt(strArrSplit2[1]), Integer.parseInt(strArrSplit2[2]));
            } else {
                RVLogger.e(b, "Parse unsupported color string : " + str);
                return i;
            }
            return iRgb;
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
            RVLogger.e(b, "Parse color exception happened : " + e.getMessage());
            return i;
        }
    }

    private void a(boolean z) {
        TBEditText tBEditText = this.c;
        if (tBEditText == null || !tBEditText.hasFocus()) {
            return;
        }
        this.c.clearFocus();
        try {
            App app = this.mOuterApp;
            if (app != null && app.getAppContext() != null) {
                ((InputMethodManager) this.mOuterApp.getAppContext().getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.c.getWindowToken(), 0);
            }
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
        a("blur", 0, z ? "r" : "0", "");
    }
}
