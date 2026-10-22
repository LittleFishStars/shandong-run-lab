package com.alibaba.ariver.app.api.ui.darkmode;

import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ColorSchemeDecider {
    public static final String TAG = "AriverApp:ColorSchemeDecider";

    public static class DefaultDecider implements ColorSchemeDecider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private JSONArray f23825a;

        public DefaultDecider(@Nullable JSONArray jSONArray) {
            this.f23825a = jSONArray;
            RVLogger.d(ColorSchemeDecider.TAG, "initialize ColorDecider by supportColorScheme: " + jSONArray);
        }

        @Override // com.alibaba.ariver.app.api.ui.darkmode.ColorSchemeDecider
        public ColorSchemeType getCurrentColorScheme() {
            JSONArray jSONArray = this.f23825a;
            if (jSONArray == null || jSONArray.size() == 0) {
                return ColorSchemeType.DEFAULT;
            }
            if (ThemeUtils.isDarkMode(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext()) && this.f23825a.contains("dark")) {
                return ColorSchemeType.DARK;
            }
            return this.f23825a.contains("light") ? ColorSchemeType.LIGHT : ColorSchemeType.DEFAULT;
        }
    }

    ColorSchemeType getCurrentColorScheme();
}
