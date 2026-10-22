package com.fl.saas.adx.base.base;

import android.content.Context;
import android.text.TextUtils;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.interfaces.AdViewListener;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BaseBuilder<T> implements AdViewListener {
    protected T builder;
    private final WeakReference<Context> contextRef;
    private boolean isHot = false;
    private String key;
    private String linkId;

    public BaseBuilder(Context context) {
        this.contextRef = new WeakReference<>(context);
    }

    public T getBuilder() {
        return this.builder;
    }

    public WeakReference<Context> getContextRef() {
        return this.contextRef;
    }

    public String getKey() {
        return this.key;
    }

    public String getLinkId() {
        return this.linkId;
    }

    public boolean isHot() {
        return this.isHot;
    }

    public boolean isValid() {
        return (this.contextRef.get() == null || TextUtils.isEmpty(this.key)) ? false : true;
    }

    @Override // com.fl.saas.adx.base.interfaces.AdViewListener
    public abstract void onAdFailed(FLError fLError);

    public T setIsHot(boolean z) {
        this.isHot = z;
        return this.builder;
    }

    public T setKey(String str) {
        this.key = str;
        return this.builder;
    }

    public T setLinkId(String str) {
        this.linkId = str;
        return this.builder;
    }
}
