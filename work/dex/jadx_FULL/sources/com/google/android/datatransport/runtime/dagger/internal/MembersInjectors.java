package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.MembersInjector;
import com.zj.adlib.xw6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class MembersInjectors {

    public enum NoOpMembersInjector implements MembersInjector<Object> {
        INSTANCE;

        @Override // com.google.android.datatransport.runtime.dagger.MembersInjector
        public void injectMembers(Object obj) {
            xw6.c(obj, "Cannot inject members into a null reference");
        }
    }

    public static <T> MembersInjector<T> a() {
        return NoOpMembersInjector.INSTANCE;
    }
}
