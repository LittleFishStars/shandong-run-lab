package com.alibaba.ariver.app.api.service.font;

import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface FontSizeSettingProxy extends Proxiable {

    public interface OnFontSizeSettingChangeListener {
        void onChange(FontSizeSetting fontSizeSetting);
    }

    FontSizeSetting getFontSizeSetting();

    void registerFontSizeChangeListener(OnFontSizeSettingChangeListener onFontSizeSettingChangeListener);

    void unRegiseterFontSizeChangeListener(OnFontSizeSettingChangeListener onFontSizeSettingChangeListener);
}
