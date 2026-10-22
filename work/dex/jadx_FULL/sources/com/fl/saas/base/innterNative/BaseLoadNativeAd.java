package com.fl.saas.base.innterNative;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.common.util.Check;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import com.ipd.dsp.internal.e1.i;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BaseLoadNativeAd<T> extends BaseNativeAd<T> {
    private final String TAG;

    @NonNull
    private final NativeLoadListener mLoadListener;

    public BaseLoadNativeAd(@NonNull Context context, @NonNull NativeLoadListener nativeLoadListener) {
        super(context);
        this.TAG = CommConstant.getObjTag(i.g, this);
        this.mLoadListener = nativeLoadListener;
    }

    public void handleAd(T t) {
        handleAd(t, null);
    }

    public void handleAd(T t, @Nullable Function<T, Boolean> function) {
        boolean z;
        if (t == null) {
            LogcatUtil.e(this.TAG, "onLoadFailed, native is empty");
        }
        if (function == null || function.apply(t).booleanValue()) {
            z = true;
        } else {
            LogcatUtil.e(this.TAG, "onLoadFailed, native is invalid");
            z = false;
        }
        if (z) {
            bindNativeAd(t);
            this.mLoadListener.onNativeAdLoaded(this);
            return;
        }
        LogcatUtil.e(this.TAG, "onLoadFailed, native is empty");
        this.mLoadListener.onAdFailed(YdError.create(20405, this.TAG + ",native is empty"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handleListAd(List<T> list) {
        handleAd(Check.findFirstNonNull(list), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handleListAd(List<T> list, @Nullable Function<T, Boolean> function) {
        handleAd(Check.findFirstNonNull(list), function);
    }

    public void onLoadFailed(YdError ydError) {
        this.mLoadListener.onAdFailed(ydError);
    }
}
