package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.errorprone.annotations.DoNotMock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@DoNotMock("Use Escapers.nullEscaper() or another methods from the *Escapers classes")
@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class Escaper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function<String, String> f32015a = new a();

    public class a implements Function<String, String> {
        public a() {
        }

        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(String str) {
            return Escaper.this.b(str);
        }
    }

    public final Function<String, String> a() {
        return this.f32015a;
    }

    public abstract String b(String str);
}
