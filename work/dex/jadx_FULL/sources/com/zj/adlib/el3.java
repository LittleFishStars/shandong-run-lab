package com.zj.adlib;

import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class el3 implements RequestListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41463a = "ForwardingRequestListener";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<RequestListener> f16346a;

    public el3(Set<RequestListener> set) {
        this.f16346a = new ArrayList(set.size());
        Iterator<RequestListener> it = set.iterator();
        while (it.hasNext()) {
            this.f16346a.add(it.next());
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void a(String str) {
        int size = this.f16346a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f16346a.get(i).a(str);
            } catch (Exception e) {
                k("InternalListener exception in onRequestCancellation", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void b(ImageRequest imageRequest, String str, boolean z) {
        int size = this.f16346a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f16346a.get(i).b(imageRequest, str, z);
            } catch (Exception e) {
                k("InternalListener exception in onRequestSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void c(String str, String str2, @Nullable Map<String, String> map) {
        int size = this.f16346a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f16346a.get(i).c(str, str2, map);
            } catch (Exception e) {
                k("InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void d(String str, String str2, String str3) {
        int size = this.f16346a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f16346a.get(i).d(str, str2, str3);
            } catch (Exception e) {
                k("InternalListener exception in onIntermediateChunkStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void e(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        int size = this.f16346a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f16346a.get(i).e(imageRequest, str, th, z);
            } catch (Exception e) {
                k("InternalListener exception in onRequestFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void f(ImageRequest imageRequest, Object obj, String str, boolean z) {
        int size = this.f16346a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f16346a.get(i).f(imageRequest, obj, str, z);
            } catch (Exception e) {
                k("InternalListener exception in onRequestStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void g(String str, String str2) {
        int size = this.f16346a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f16346a.get(i).g(str, str2);
            } catch (Exception e) {
                k("InternalListener exception in onProducerStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public boolean h(String str) {
        int size = this.f16346a.size();
        for (int i = 0; i < size; i++) {
            if (this.f16346a.get(i).h(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void i(String str, String str2, @Nullable Map<String, String> map) {
        int size = this.f16346a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f16346a.get(i).i(str, str2, map);
            } catch (Exception e) {
                k("InternalListener exception in onProducerFinishWithCancellation", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void j(String str, String str2, Throwable th, @Nullable Map<String, String> map) {
        int size = this.f16346a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f16346a.get(i).j(str, str2, th, map);
            } catch (Exception e) {
                k("InternalListener exception in onProducerFinishWithFailure", e);
            }
        }
    }

    public final void k(String str, Throwable th) {
        ad3.v(f41463a, str, th);
    }
}
