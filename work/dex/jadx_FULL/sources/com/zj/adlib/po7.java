package com.zj.adlib;

import android.widget.TextSwitcher;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import rx.functions.Action1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class po7 {

    public static class a implements Action1<CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextSwitcher f44029a;

        public a(TextSwitcher textSwitcher) {
            this.f44029a = textSwitcher;
        }

        public void call(CharSequence charSequence) {
            this.f44029a.setText(charSequence);
        }
    }

    public static class b implements Action1<CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextSwitcher f44030a;

        public b(TextSwitcher textSwitcher) {
            this.f44030a = textSwitcher;
        }

        public void call(CharSequence charSequence) {
            this.f44030a.setCurrentText(charSequence);
        }
    }

    public po7() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Action1<? super CharSequence> a(@NonNull TextSwitcher textSwitcher) {
        zw6.b(textSwitcher, "view == null");
        return new b(textSwitcher);
    }

    @NonNull
    @CheckResult
    public static Action1<? super CharSequence> b(@NonNull TextSwitcher textSwitcher) {
        zw6.b(textSwitcher, "view == null");
        return new a(textSwitcher);
    }
}
