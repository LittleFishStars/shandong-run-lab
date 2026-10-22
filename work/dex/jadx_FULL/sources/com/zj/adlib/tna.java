package com.zj.adlib;

import android.content.Context;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import com.alibaba.android.arouter.utils.Consts;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.amap.api.col.p0003l.gx(a = "update_item", b = true)
public class tna extends wna {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f44967a;
    public String i = "";

    public tna() {
    }

    public static String l(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject == null || !jSONObject.has(str) || "[]".equals(jSONObject.getString(str))) ? "" : jSONObject.optString(str).trim();
    }

    public final String k() {
        return this.i;
    }

    public final void m(String str) {
        this.i = str;
    }

    public final void n() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("title", ((wna) this).f20477a);
            jSONObject2.put("code", ((wna) this).f20480c);
            jSONObject2.put("url", ((wna) this).f20479b);
            jSONObject2.put("fileName", this.d);
            jSONObject2.put("lLocalLength", ((wna) this).f20476a);
            jSONObject2.put("lRemoteLength", ((wna) this).f20478b);
            jSONObject2.put("mState", ((wna) this).c);
            jSONObject2.put("version", this.e);
            jSONObject2.put("localPath", this.f);
            String str = this.i;
            if (str != null) {
                jSONObject2.put("vMapFileNames", str);
            }
            jSONObject2.put("isSheng", ((wna) this).f45641a);
            jSONObject2.put("mCompleteCode", ((wna) this).b);
            jSONObject2.put("mCityCode", this.g);
            jSONObject2.put("pinyin", this.h);
            jSONObject.put("file", jSONObject2);
            File file = new File(this.d + ".dt");
            file.delete();
            OutputStreamWriter outputStreamWriter = null;
            try {
                try {
                    OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file, true), "utf-8");
                    try {
                        outputStreamWriter2.write(jSONObject.toString());
                        try {
                            outputStreamWriter2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (IOException e2) {
                        e = e2;
                        outputStreamWriter = outputStreamWriter2;
                        a7b.m(e, "UpdateItem", "saveJSONObjectToFile");
                        e.printStackTrace();
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        outputStreamWriter = outputStreamWriter2;
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e5) {
                e = e5;
            }
        } catch (Throwable th3) {
            a7b.m(th3, "UpdateItem", "saveJSONObjectToFile parseJson");
            th3.printStackTrace();
        }
    }

    public final void o(String str) {
        JSONObject jSONObject;
        if (str != null) {
            try {
                if ("".equals(str) || (jSONObject = new JSONObject(str).getJSONObject("file")) == null) {
                    return;
                }
                ((wna) this).f20477a = jSONObject.optString("title");
                ((wna) this).f20480c = jSONObject.optString("code");
                ((wna) this).f20479b = jSONObject.optString("url");
                this.d = jSONObject.optString("fileName");
                ((wna) this).f20476a = jSONObject.optLong("lLocalLength");
                ((wna) this).f20478b = jSONObject.optLong("lRemoteLength");
                ((wna) this).c = jSONObject.optInt("mState");
                this.e = jSONObject.optString("version");
                this.f = jSONObject.optString("localPath");
                this.i = jSONObject.optString("vMapFileNames");
                ((wna) this).f45641a = jSONObject.optInt("isSheng");
                ((wna) this).b = jSONObject.optInt("mCompleteCode");
                this.g = jSONObject.optString("mCityCode");
                String strL = l(jSONObject, "pinyin");
                this.h = strL;
                if ("".equals(strL)) {
                    String str2 = ((wna) this).f20479b;
                    String strSubstring = str2.substring(str2.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1);
                    this.h = strSubstring.substring(0, strSubstring.lastIndexOf(Consts.DOT));
                }
            } catch (Throwable th) {
                a7b.m(th, "UpdateItem", "readFileToJSONObject");
                th.printStackTrace();
            }
        }
    }

    public final void p() {
        this.d = zwa.f0(this.f44967a) + this.h + ".zip.tmp";
    }

    public tna(OfflineMapCity offlineMapCity, Context context) {
        this.f44967a = context;
        ((wna) this).f20477a = offlineMapCity.getCity();
        ((wna) this).f20480c = offlineMapCity.getAdcode();
        ((wna) this).f20479b = offlineMapCity.getUrl();
        ((wna) this).f20478b = offlineMapCity.getSize();
        this.e = offlineMapCity.getVersion();
        this.g = offlineMapCity.getCode();
        ((wna) this).f45641a = 0;
        ((wna) this).c = offlineMapCity.getState();
        ((wna) this).b = offlineMapCity.getcompleteCode();
        this.h = offlineMapCity.getPinyin();
        p();
    }

    public tna(OfflineMapProvince offlineMapProvince, Context context) {
        this.f44967a = context;
        ((wna) this).f20477a = offlineMapProvince.getProvinceName();
        ((wna) this).f20480c = offlineMapProvince.getProvinceCode();
        ((wna) this).f20479b = offlineMapProvince.getUrl();
        ((wna) this).f20478b = offlineMapProvince.getSize();
        this.e = offlineMapProvince.getVersion();
        ((wna) this).f45641a = 1;
        ((wna) this).c = offlineMapProvince.getState();
        ((wna) this).b = offlineMapProvince.getcompleteCode();
        this.h = offlineMapProvince.getPinyin();
        p();
    }
}
