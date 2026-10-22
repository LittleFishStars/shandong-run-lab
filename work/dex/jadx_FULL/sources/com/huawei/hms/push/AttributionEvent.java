package com.huawei.hms.push;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public enum AttributionEvent {
    APP_START_COMPLETE(1),
    OPEN_PRIVACY_PAGE(2),
    REJECT_PRIVACY(3),
    AGREED_PRIVACY(4),
    PERMISSION_GRANTED(5),
    PERMISSION_DENIED(6),
    OPEN_LANDING_PAGE(7);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f37605a;

    AttributionEvent(int i) {
        this.f37605a = i;
    }

    public int getEventId() {
        return this.f37605a;
    }
}
