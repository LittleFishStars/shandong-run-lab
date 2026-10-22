package com.zj.adlib;

import android.widget.CheckedTextView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import rx.functions.Action1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class vn7 {

    public static class a implements Action1<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CheckedTextView f45393a;

        public a(CheckedTextView checkedTextView) {
            this.f45393a = checkedTextView;
        }

        public void call(Boolean bool) {
            this.f45393a.setChecked(bool.booleanValue());
        }
    }

    public vn7() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> a(@NonNull CheckedTextView checkedTextView) {
        zw6.b(checkedTextView, "view == null");
        return new a(checkedTextView);
    }
}
