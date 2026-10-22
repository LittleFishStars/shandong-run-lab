package com.kc.bw.okhttp.adapter;

import com.kc.bw.dexg;
import com.kc.bw.okhttp.cache.CacheMode;
import com.kc.bw.okhttp.cache.policy.CachePolicy;
import com.kc.bw.okhttp.cache.policy.DefaultCachePolicy;
import com.kc.bw.okhttp.cache.policy.FirstCacheRequestPolicy;
import com.kc.bw.okhttp.cache.policy.NoCachePolicy;
import com.kc.bw.okhttp.cache.policy.NoneCacheRequestPolicy;
import com.kc.bw.okhttp.cache.policy.RequestFailedCachePolicy;
import com.kc.bw.okhttp.callback.Callback;
import com.kc.bw.okhttp.model.Response;
import com.kc.bw.okhttp.request.base.Request;
import com.kc.bw.okhttp.utils.HttpUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CacheCall<T> implements Call<T> {
    public CachePolicy<T> policy;
    public Request<T, ? extends Request> request;

    /* JADX INFO: renamed from: com.kc.bw.okhttp.adapter.CacheCall$1, reason: invalid class name */
    @Keep
    public static /* synthetic */ class AnonymousClass1 {
        public static final int[] $SwitchMap$com$kc$bw$okhttp$cache$CacheMode;

        static {
            int[] iArr = new int[CacheMode.values().length];
            $SwitchMap$com$kc$bw$okhttp$cache$CacheMode = iArr;
            try {
                iArr[CacheMode.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kc$bw$okhttp$cache$CacheMode[CacheMode.IF_NONE_CACHE_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$kc$bw$okhttp$cache$CacheMode[CacheMode.FIRST_CACHE_THEN_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$kc$bw$okhttp$cache$CacheMode[CacheMode.REQUEST_FAILED_READ_CACHE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$kc$bw$okhttp$cache$CacheMode[CacheMode.NO_CACHE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public CacheCall(Request<T, ? extends Request> request) {
        this.policy = null;
        this.request = request;
        this.policy = preparePolicy();
    }

    private CachePolicy<T> preparePolicy() {
        CachePolicy<T> defaultCachePolicy;
        if (this.request.getCacheMode() == null) {
            this.request.cacheMode(CacheMode.NO_CACHE);
        }
        int i = AnonymousClass1.$SwitchMap$com$kc$bw$okhttp$cache$CacheMode[this.request.getCacheMode().ordinal()];
        if (i == 1) {
            defaultCachePolicy = new DefaultCachePolicy<>(this.request);
        } else if (i == 2) {
            defaultCachePolicy = new NoneCacheRequestPolicy<>(this.request);
        } else if (i != 3) {
            defaultCachePolicy = i != 4 ? new NoCachePolicy<>(this.request) : new RequestFailedCachePolicy<>(this.request);
        } else {
            defaultCachePolicy = new FirstCacheRequestPolicy<>(this.request);
        }
        this.policy = defaultCachePolicy;
        if (this.request.getCachePolicy() != null) {
            this.policy = this.request.getCachePolicy();
        }
        HttpUtils.checkNotNull(this.policy, dexg.dexa("qpmjdz!>>!ovmm"));
        return this.policy;
    }

    @Override // com.kc.bw.okhttp.adapter.Call
    public void cancel() {
        this.policy.cancel();
    }

    @Override // com.kc.bw.okhttp.adapter.Call
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Call<T> m1001clone() {
        return new CacheCall(this.request);
    }

    @Override // com.kc.bw.okhttp.adapter.Call
    public Response<T> execute() {
        return this.policy.requestSync(this.policy.prepareCache());
    }

    @Override // com.kc.bw.okhttp.adapter.Call
    public void execute(Callback<T> callback) {
        HttpUtils.checkNotNull(callback, dexg.dexa("dbmmcbdl!>>!ovmm"));
        this.policy.requestAsync(this.policy.prepareCache(), callback);
    }

    @Override // com.kc.bw.okhttp.adapter.Call
    public Request getRequest() {
        return this.request;
    }

    @Override // com.kc.bw.okhttp.adapter.Call
    public boolean isCanceled() {
        return this.policy.isCanceled();
    }

    @Override // com.kc.bw.okhttp.adapter.Call
    public boolean isExecuted() {
        return this.policy.isExecuted();
    }
}
