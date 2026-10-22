package com.alibaba.ariver.jsapi.font;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.app.AppDestroyPoint;
import com.alibaba.ariver.app.api.point.app.AppStartPoint;
import com.alibaba.ariver.app.api.service.font.FontSizeSetting;
import com.alibaba.ariver.app.api.service.font.FontSizeSettingProxy;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.b;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FontSizeSettingExtension implements AppDestroyPoint, AppStartPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24146a = "AriverAPI:FontSizeSettingExtension";
    private FontSizeSettingProxy.OnFontSizeSettingChangeListener b;

    @Override // com.alibaba.ariver.app.api.point.app.AppDestroyPoint
    public void onAppDestroy(App app) {
        final FontSizeSettingProxy fontSizeSettingProxy = (FontSizeSettingProxy) RVProxy.get(FontSizeSettingProxy.class);
        final FontSizeSettingProxy.OnFontSizeSettingChangeListener onFontSizeSettingChangeListener = this.b;
        if (fontSizeSettingProxy == null || onFontSizeSettingChangeListener == null) {
            return;
        }
        RVLogger.d(f24146a, "unRegiseterFontSizeChangeListener");
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.jsapi.font.FontSizeSettingExtension.3
            @Override // java.lang.Runnable
            public void run() {
                fontSizeSettingProxy.unRegiseterFontSizeChangeListener(onFontSizeSettingChangeListener);
            }
        });
        this.b = null;
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppStartPoint
    public void onAppStart(final App app) {
        String string = BundleUtils.getString(app.getStartParams(), RVParams.FONT_SIZE_SETTING_FITABLE, "NO");
        RVLogger.d(f24146a, "onAppStart fontSizeSetting Fitalbe" + string);
        if ("YES".equalsIgnoreCase(string)) {
            final FontSizeSettingProxy fontSizeSettingProxy = (FontSizeSettingProxy) RVProxy.get(FontSizeSettingProxy.class);
            RVLogger.d(f24146a, "get FontSizeSettingProxy " + fontSizeSettingProxy);
            if (fontSizeSettingProxy != null) {
                if (this.b == null) {
                    this.b = new FontSizeSettingProxy.OnFontSizeSettingChangeListener() { // from class: com.alibaba.ariver.jsapi.font.FontSizeSettingExtension.1
                        @Override // com.alibaba.ariver.app.api.service.font.FontSizeSettingProxy.OnFontSizeSettingChangeListener
                        public void onChange(FontSizeSetting fontSizeSetting) {
                            RVLogger.d(FontSizeSettingExtension.f24146a, "FontSizeSetting onChange\t " + fontSizeSetting);
                            Page activePage = app.getActivePage();
                            if (activePage == null) {
                                RVLogger.d(FontSizeSettingExtension.f24146a, "fontSizeSettingFitable change notify,while active page is null");
                            }
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("scale", (Object) Float.valueOf(fontSizeSetting.getScale()));
                            jSONObject.put(b.b, (Object) Integer.valueOf(fontSizeSetting.getLevel()));
                            EngineUtils.sendToRender(activePage.getRender(), "fontSizeSettingChange", jSONObject, null);
                        }
                    };
                }
                final FontSizeSettingProxy.OnFontSizeSettingChangeListener onFontSizeSettingChangeListener = this.b;
                ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.jsapi.font.FontSizeSettingExtension.2
                    @Override // java.lang.Runnable
                    public void run() {
                        fontSizeSettingProxy.registerFontSizeChangeListener(onFontSizeSettingChangeListener);
                    }
                });
            }
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }
}
