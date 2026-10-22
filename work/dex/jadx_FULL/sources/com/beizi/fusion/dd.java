package com.beizi.fusion;

import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface dd extends ya {

    public enum a implements xa {
        CLICK_INTERACTIVE_TRIGGER(1, "click_interactive_trigger"),
        GESTURE_INTERACTIVE_TRIGGER(2, "gesture_interactive_trigger"),
        SHAKE_INTERACTIVE_TRIGGER(3, "shake_interactive_trigger"),
        EULER_INTERACTIVE_TRIGGER(4, "euler_interactive_trigger"),
        OPTIMIZE_INTERACTIVE_TRIGGER(5, "optimize_interactive_trigger"),
        INVOKE_INTERACTIVE_TRIGGER(6, "invoke_interactive_trigger"),
        LANDING_PAGE_INTERACTIVE_TRIGGER(7, "landing_page_interactive_trigger"),
        LANDING_PAGE_ENDCARD_INTERACTIVE_TRIGGER(8, "landing_page_endcard_interactive_trigger");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f27174a;
        private final String b;

        a(int i, String str) {
            this.f27174a = i;
            this.b = str;
        }

        @Override // com.beizi.fusion.xa
        public int getEventCode() {
            return this.f27174a;
        }
    }

    void a(View view, a aVar);
}
