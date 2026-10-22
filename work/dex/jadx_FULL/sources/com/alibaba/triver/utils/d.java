package com.alibaba.triver.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25269a = "TriverRes";
    private static final String b = "triver";

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f25270a;
        public JSONObject b;
    }

    public static String a(@NonNull String str) {
        return new File(a(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext()), c(str)).getAbsolutePath();
    }

    public static String b(String str) {
        return new File(b(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext()), c(str)).getAbsolutePath();
    }

    public static String c(@NonNull String str) {
        return CommonUtils.MD5(str);
    }

    public static String a(Context context) {
        File file = new File(context.getFilesDir() + File.separator + b);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String b(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir());
        String str = File.separator;
        sb.append(str);
        sb.append(b);
        sb.append(str);
        sb.append("plugin");
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static void a(Context context, String str) {
        String strC = c(str);
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        File file = new File(a(context), strC);
        if (file.exists()) {
            a(file);
        }
    }

    public static void a(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                a(file2);
            }
            file.delete();
            return;
        }
        file.delete();
    }

    public static HashMap<String, JSONObject> a(AppModel appModel) {
        JSONObject jSONObject;
        JSONObject extendInfos = appModel.getExtendInfos();
        HashMap<String, JSONObject> map = new HashMap<>();
        if (extendInfos != null && (jSONObject = extendInfos.getJSONObject("cacheInfo")) != null && jSONObject.keySet().size() != 0) {
            String next = jSONObject.keySet().iterator().next();
            map.put(next, jSONObject.getJSONObject(next));
        }
        return map;
    }

    public static HashMap<String, JSONObject> a(List<PluginModel> list) {
        HashMap<String, JSONObject> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            a aVarA = a(list.get(i));
            if (aVarA != null) {
                map.put(aVarA.f25270a, aVarA.b);
            }
        }
        return map;
    }

    public static a a(PluginModel pluginModel) {
        JSONObject jSONObject;
        JSONObject extendInfo = pluginModel.getExtendInfo();
        if (extendInfo == null || (jSONObject = extendInfo.getJSONObject("cacheInfo")) == null || jSONObject.keySet().size() == 0) {
            return null;
        }
        a aVar = new a();
        String next = jSONObject.keySet().iterator().next();
        aVar.f25270a = next;
        aVar.b = jSONObject.getJSONObject(next);
        return aVar;
    }
}
