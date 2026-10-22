package com.byazt.euv;

import android.R;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatViewInflater;
import com.byazt.bog.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.ComponentManager;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.activity.IPluginActivity;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_LOADCONTROL_BUFFERINGTIMEOUT, 54})
public class ve {
    /* JADX WARN: Multi-variable type inference failed */
    public static void c(tt ttVar, Bundle bundle) {
        List<String> list;
        if (!Zeus.hasInit()) {
            a.n(ZeusLogger.TAG_INIT, "ProxyActivityUtils.onCreate finish. AppApplication == null.");
            ttVar.zeusSuperOnCreate(null);
            ttVar.finish();
            return;
        }
        Intent intent = ttVar.getIntent();
        String pluginPkgName = ttVar.getPluginPkgName();
        Plugin plugin = ttVar.getPlugin();
        if (plugin == null) {
            a.n(ZeusLogger.TAG_INIT, "ProxyActivityUtils.onCreate finish. plugin == null");
            ttVar.zeusSuperOnCreate(null);
            ttVar.finish();
            return;
        }
        intent.setExtrasClassLoader(plugin.mClassLoader);
        IntentUtils.c(intent);
        String stringExtra = intent.getStringExtra("targetPlugin");
        if (TextUtils.isEmpty(stringExtra) && (list = ComponentManager.stubActivity2TargetActivities.get(ttVar.getClass().getName())) != null && list.size() == 1) {
            stringExtra = list.get(0);
            intent.putExtra("targetPlugin", stringExtra);
        }
        if (!plugin.isLoaded() || TextUtils.isEmpty(stringExtra)) {
            try {
                ttVar.zeusSuperOnCreate(null);
                ZeusLogger.w(ZeusLogger.TAG_ACTIVITY, "Cant start pluginActivity, plugin load failed! pluginPkgName: " + pluginPkgName + " targetActivity: " + stringExtra);
                ttVar.finish();
                return;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        ActivityInfo activityInfo = plugin.pluginActivities.get(stringExtra);
        if (activityInfo == null) {
            ZeusLogger.w(ZeusLogger.TAG_ACTIVITY, "Have you declared " + stringExtra + " in plugin's AndroidManifest.xml!");
            ttVar.zeusSuperOnCreate(null);
            ttVar.finish();
            c(stringExtra, "activityInfo null", plugin);
            return;
        }
        try {
            IPluginActivity iPluginActivity = (IPluginActivity) plugin.mClassLoader.loadClass(stringExtra).newInstance();
            FieldUtils.writeField(iPluginActivity, "mApplication", ttVar.getApplication());
            ttVar.setTargetActivity(iPluginActivity);
            iPluginActivity.setPluginProxyActivity(ttVar, plugin);
            ttVar.zeusSuperSetTheme(activityInfo.theme);
            TypedArray typedArrayObtainStyledAttributes = ((Activity) ttVar).getTheme().obtainStyledAttributes(new int[]{R.attr.windowIsTranslucent});
            if (typedArrayObtainStyledAttributes.getBoolean(typedArrayObtainStyledAttributes.getIndex(0), false)) {
                c((Activity) ttVar);
            }
            typedArrayObtainStyledAttributes.recycle();
            iPluginActivity.attachBaseContext(ttVar.getBaseContext());
            try {
                int requestedOrientation = ((Activity) ttVar).getRequestedOrientation();
                int i = activityInfo.screenOrientation;
                if (requestedOrientation != i) {
                    ((Activity) ttVar).setRequestedOrientation(i);
                }
            } catch (IllegalStateException unused) {
            }
            iPluginActivity.onCreate(bundle);
        } catch (Exception e2) {
            c(stringExtra, Log.getStackTraceString(e2), plugin);
        }
    }

    private static void c(String str, String str2, Plugin plugin) {
        try {
            com.byazt.blh.c reporter = GlobalParam.getInstance().getReporter();
            if (reporter == null || plugin == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("t_act", str);
            jSONObject.putOpt("p_pkg", plugin.mPkgName);
            jSONObject.putOpt("p_vc", Integer.valueOf(plugin.getVersion()));
            jSONObject.putOpt("p_avc", Integer.valueOf(plugin.getApiVersionCode()));
            jSONObject.putOpt("msg", str2);
            reporter.c(com.byazt.gvs.tt.sl, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public static void c(tt ttVar, Context context) {
        if (!Zeus.hasInit()) {
            a.n(ZeusLogger.TAG_INIT, "ProxyActivityUtils.attachBaseContext. AppApplication == null.");
            ttVar.zeusSuperAttachBaseContext(context);
            return;
        }
        String pluginPkgName = ttVar.getPluginPkgName();
        boolean zLoadPlugin = PluginManager.getInstance().loadPlugin(pluginPkgName);
        try {
            ttVar.setPlugin(PluginManager.getInstance().getPlugin(pluginPkgName));
            if (zLoadPlugin) {
                ttVar.zeusSuperAttachBaseContext(ZeusTransformUtils.wrapperContext(context, pluginPkgName));
                FieldUtils.writeField(ttVar, "mResources", (Object) null);
            } else {
                ttVar.zeusSuperAttachBaseContext(context);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void c(Activity activity, View view) {
        Object field;
        if (view == null) {
            return;
        }
        try {
            Object field2 = FieldUtils.readField(view, "mListenerInfo");
            if (field2 != null && (field = FieldUtils.readField(field2, "mOnClickListener")) != null) {
                String name = field.getClass().getName();
                if (name.startsWith(AppCompatViewInflater.class.getName()) || name.startsWith(View.class.getName())) {
                    view.setOnClickListener(new c(activity, view.getId(), (String) FieldUtils.readField(field, "mMethodName")));
                }
            }
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_ACTIVITY, "checkOnClickListener failed!".concat(String.valueOf(view)));
            a.c(e);
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return;
            }
            c(activity, viewGroup.getChildAt(i));
            i++;
        }
    }

    private static Class c() {
        Class<?> cls = null;
        for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
            if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                cls = cls2;
            }
        }
        return cls;
    }

    private static void c(Activity activity) {
        try {
            MethodUtils.getAccessibleMethod(Activity.class, "convertToTranslucent", c(), ActivityOptions.class).invoke(activity, null, MethodUtils.getAccessibleMethod(Activity.class, "getActivityOptions", new Class[0]).invoke(activity, new Object[0]));
        } catch (Throwable unused) {
        }
    }
}
