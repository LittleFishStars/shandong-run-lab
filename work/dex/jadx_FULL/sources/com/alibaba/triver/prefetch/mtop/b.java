package com.alibaba.triver.prefetch.mtop;

import com.alibaba.triver.kit.api.model.RequestParams;
import com.alibaba.triver.kit.api.network.SyncRequestClient;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements com.alibaba.triver.prefetch.a.c<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f25116a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private RequestParams f25117a;
        private SyncRequestClient b;

        public SyncRequestClient a() {
            return this.b;
        }

        public RequestParams b() {
            return this.f25117a;
        }

        public void a(SyncRequestClient syncRequestClient) {
            this.b = syncRequestClient;
        }

        public void a(RequestParams requestParams) {
            this.f25117a = requestParams;
        }
    }

    public b(a aVar) {
        this.f25116a = aVar;
    }

    @Override // com.alibaba.triver.prefetch.a.c
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a a() {
        return this.f25116a;
    }
}
