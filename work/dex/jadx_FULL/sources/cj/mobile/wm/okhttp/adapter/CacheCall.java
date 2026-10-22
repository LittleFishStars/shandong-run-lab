package cj.mobile.wm.okhttp.adapter;

import cj.mobile.wm.dexc;
import cj.mobile.wm.okhttp.cache.CacheMode;
import cj.mobile.wm.okhttp.cache.policy.CachePolicy;
import cj.mobile.wm.okhttp.cache.policy.DefaultCachePolicy;
import cj.mobile.wm.okhttp.cache.policy.FirstCacheRequestPolicy;
import cj.mobile.wm.okhttp.cache.policy.NoCachePolicy;
import cj.mobile.wm.okhttp.cache.policy.NoneCacheRequestPolicy;
import cj.mobile.wm.okhttp.cache.policy.RequestFailedCachePolicy;
import cj.mobile.wm.okhttp.callback.Callback;
import cj.mobile.wm.okhttp.model.Response;
import cj.mobile.wm.okhttp.request.base.Request;
import cj.mobile.wm.okhttp.utils.HttpUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CacheCall<T> implements Call<T> {
    public CachePolicy<T> policy;
    public Request<T, ? extends Request> request;

    /* JADX INFO: renamed from: cj.mobile.wm.okhttp.adapter.CacheCall$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$cj$mobile$wm$okhttp$cache$CacheMode;

        static {
            int[] iArr = new int[CacheMode.values().length];
            $SwitchMap$cj$mobile$wm$okhttp$cache$CacheMode = iArr;
            try {
                iArr[CacheMode.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cj$mobile$wm$okhttp$cache$CacheMode[CacheMode.IF_NONE_CACHE_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cj$mobile$wm$okhttp$cache$CacheMode[CacheMode.FIRST_CACHE_THEN_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cj$mobile$wm$okhttp$cache$CacheMode[CacheMode.REQUEST_FAILED_READ_CACHE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$cj$mobile$wm$okhttp$cache$CacheMode[CacheMode.NO_CACHE.ordinal()] = 5;
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
        int i = AnonymousClass1.$SwitchMap$cj$mobile$wm$okhttp$cache$CacheMode[this.request.getCacheMode().ordinal()];
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
        HttpUtils.checkNotNull(this.policy, dexc.dexa("qpmjdz!>>!ovmm"));
        return this.policy;
    }

    @Override // cj.mobile.wm.okhttp.adapter.Call
    public void cancel() {
        this.policy.cancel();
    }

    @Override // cj.mobile.wm.okhttp.adapter.Call
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Call<T> m79clone() {
        return new CacheCall(this.request);
    }

    @Override // cj.mobile.wm.okhttp.adapter.Call
    public Response<T> execute() {
        return this.policy.requestSync(this.policy.prepareCache());
    }

    @Override // cj.mobile.wm.okhttp.adapter.Call
    public void execute(Callback<T> callback) {
        HttpUtils.checkNotNull(callback, dexc.dexa("dbmmcbdl!>>!ovmm"));
        this.policy.requestAsync(this.policy.prepareCache(), callback);
    }

    @Override // cj.mobile.wm.okhttp.adapter.Call
    public Request getRequest() {
        return this.request;
    }

    @Override // cj.mobile.wm.okhttp.adapter.Call
    public boolean isCanceled() {
        return this.policy.isCanceled();
    }

    @Override // cj.mobile.wm.okhttp.adapter.Call
    public boolean isExecuted() {
        return this.policy.isExecuted();
    }
}
