package com.byazt.te;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.byazt.sa.n;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 14, 13})
public class tt extends com.byazt.xj.ve<CycleCountDownView> {
    public String c;
    public String kz;
    public String vp;
    public String yo;

    public tt(@NonNull Context context) {
        super(context);
    }

    @Override // com.byazt.xj.ve
    /* JADX INFO: renamed from: sp, reason: merged with bridge method [inline-methods] */
    public CycleCountDownView c() {
        return new CycleCountDownView(this.tt);
    }

    @Override // com.byazt.xj.ve
    public void tt() {
        super.tt();
    }

    @Override // com.byazt.xj.ve
    public void c(String str, String str2) {
        super.c(str, str2);
        str.hashCode();
        switch (str) {
            case "boxImage":
                ((CycleCountDownView) this.n).setBoxImage(null);
                n.c().tt().c(this.i, str2, new com.byazt.sa.c.InterfaceC0516c() { // from class: com.byazt.te.tt.1
                    @Override // com.byazt.sa.c.InterfaceC0516c
                    public void c(Bitmap bitmap) {
                        ((CycleCountDownView) tt.this.n).setBoxImage(bitmap);
                    }
                });
                break;
            case "before":
                this.c = str2;
                break;
            case "finish":
                this.kz = str2;
                break;
            case "text":
                this.vp = str2;
                break;
            case "after":
                this.yo = str2;
                break;
            case "boxFinishImage":
                n.c().tt().c(this.i, str2, new com.byazt.sa.c.InterfaceC0516c() { // from class: com.byazt.te.tt.2
                    @Override // com.byazt.sa.c.InterfaceC0516c
                    public void c(Bitmap bitmap) {
                        ((CycleCountDownView) tt.this.n).setBoxFinish(bitmap);
                    }
                });
                break;
        }
        ((CycleCountDownView) this.n).c(this.c, this.yo, this.vp, this.kz);
    }

    public void c(int i, int i2, int i3, boolean z) {
        T t = this.n;
        if (t != 0) {
            ((CycleCountDownView) t).c(i, i2, i3);
            ((CycleCountDownView) this.n).setCanSkip(z);
            ((CycleCountDownView) this.n).setClickable(z);
            ((CycleCountDownView) this.n).setEnabled(z);
        }
    }
}
