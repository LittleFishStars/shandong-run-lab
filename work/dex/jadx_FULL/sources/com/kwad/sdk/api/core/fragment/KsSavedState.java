package com.kwad.sdk.api.core.fragment;

import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class KsSavedState {
    final Fragment.SavedState mSaveState;

    public KsSavedState(Fragment.SavedState savedState) {
        this.mSaveState = savedState;
    }

    public Fragment.SavedState getBase() {
        return this.mSaveState;
    }
}
