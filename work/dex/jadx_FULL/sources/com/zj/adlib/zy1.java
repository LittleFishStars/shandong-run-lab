package com.zj.adlib;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class zy1 extends CursorWrapper implements CrossProcessCursor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbstractWindowedCursor f46366a;

    @KeepForSdk
    public zy1(@NonNull Cursor cursor) {
        super(cursor);
        for (int i = 0; i < 10 && (cursor instanceof CursorWrapper); i++) {
            cursor = ((CursorWrapper) cursor).getWrappedCursor();
        }
        if (!(cursor instanceof AbstractWindowedCursor)) {
            throw new IllegalArgumentException("Unknown type: ".concat(cursor.getClass().getName()));
        }
        this.f46366a = (AbstractWindowedCursor) cursor;
    }

    @KeepForSdk
    public void a(@Nullable CursorWindow cursorWindow) {
        this.f46366a.setWindow(cursorWindow);
    }

    @Override // android.database.CrossProcessCursor
    @KeepForSdk
    public void fillWindow(int i, @NonNull CursorWindow cursorWindow) {
        this.f46366a.fillWindow(i, cursorWindow);
    }

    @Override // android.database.CrossProcessCursor
    @Nullable
    @KeepForSdk
    public CursorWindow getWindow() {
        return this.f46366a.getWindow();
    }

    @Override // android.database.CursorWrapper
    @NonNull
    public final /* synthetic */ Cursor getWrappedCursor() {
        return this.f46366a;
    }

    @Override // android.database.CrossProcessCursor
    public final boolean onMove(int i, int i2) {
        return this.f46366a.onMove(i, i2);
    }
}
