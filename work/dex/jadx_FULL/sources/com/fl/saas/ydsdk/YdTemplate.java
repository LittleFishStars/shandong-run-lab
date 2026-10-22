package com.fl.saas.ydsdk;

import android.content.Context;
import com.fl.saas.base.annotation.API;
import com.fl.saas.base.base.BaseAPI;
import com.fl.saas.base.base.builder.InnerTemplateBuilder;
import com.fl.saas.base.interfaces.AdViewTemplateListener;
import com.fl.saas.base.manager.AdViewTemplateManager;
import com.fl.saas.base.type.AdType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@API(AdType.Template)
@Deprecated
public class YdTemplate extends BaseAPI<InnerTemplateBuilder<?>, AdViewTemplateManager> {

    @Deprecated
    public static class Builder extends InnerTemplateBuilder.Builder<Builder, YdTemplate> {
        /* JADX WARN: Multi-variable type inference failed */
        @Deprecated
        public Builder(Context context) {
            super(context);
            this.builder = this;
        }

        @Override // com.fl.saas.base.base.Build
        @Deprecated
        public YdTemplate build() {
            return new YdTemplate(this);
        }

        @Deprecated
        public Builder setTemplateListener(AdViewTemplateListener adViewTemplateListener) {
            this.listener = adViewTemplateListener;
            return this;
        }
    }

    @Deprecated
    public YdTemplate(InnerTemplateBuilder<?> innerTemplateBuilder) {
        super(innerTemplateBuilder);
    }

    @Deprecated
    public void requestAD() {
        request();
    }
}
