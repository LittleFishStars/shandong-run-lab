package com.fl.saas.adx.api;

import com.fl.saas.adx.base.base.builder.InnerBuilder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLParamConfig {
    private final InnerBuilder<?, ?> mBuilder;

    public static final class Builder extends InnerBuilder<Builder, FLParamConfig> {
        /* JADX WARN: Multi-variable type inference failed */
        public Builder() {
            this.builder = this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.fl.saas.adx.base.base.builder.InnerBuilder
        public FLParamConfig build() {
            return new FLParamConfig(this);
        }
    }

    public FLParamConfig(InnerBuilder<?, ?> innerBuilder) {
        this.mBuilder = innerBuilder;
    }

    public InnerBuilder<?, ?> getBuilder() {
        return this.mBuilder;
    }
}
