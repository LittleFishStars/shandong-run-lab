package android.taobao.windvane.extra.uc;

import android.content.Context;
import android.taobao.windvane.d.a;
import android.taobao.windvane.util.DPUtil;
import android.taobao.windvane.util.ScreenUtil;
import android.taobao.windvane.util.TaoLog;
import android.util.AttributeSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class WVPTRUCWebView extends WVUCWebView {
    private a attachBottom;
    private int bottomLevel;
    private int bottomLevelDP;
    private boolean isBottom;
    private boolean isBottomLevelUp;
    private int screenHeight;

    public WVPTRUCWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.screenHeight = ScreenUtil.getScreenHeight();
        this.bottomLevelDP = 50;
        this.bottomLevel = DPUtil.dip2px(50.0f);
        this.isBottom = false;
        this.isBottomLevelUp = false;
    }

    @Override // android.taobao.windvane.extra.uc.WVUCWebView
    public void OnScrollChanged(int i, int i2, int i3, int i4) {
        super.OnScrollChanged(i, i2, i3, i4);
        if (this.screenHeight + i2 <= getContentHeight() - this.bottomLevel) {
            this.isBottomLevelUp = false;
            this.isBottom = false;
            return;
        }
        if (i2 < i4) {
            this.isBottomLevelUp = true;
        }
        if (!this.isBottom) {
            TaoLog.e("scroll", "attach bottom level");
            this.isBottom = true;
            if (this.attachBottom != null) {
                TaoLog.e("scroll", "attach bottom callback");
                this.attachBottom.a();
                return;
            }
            return;
        }
        if (this.isBottomLevelUp && i2 + this.screenHeight == getContentHeight()) {
            TaoLog.e("scroll", "attach bottom level");
            if (this.attachBottom != null) {
                TaoLog.e("scroll", "attach bottom callback");
                this.attachBottom.a();
            }
        }
    }

    public void setAttachBottomListener(a aVar) {
        this.attachBottom = aVar;
    }

    public void setBottomLevelDP(int i) {
        this.bottomLevelDP = i;
    }

    public WVPTRUCWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.screenHeight = ScreenUtil.getScreenHeight();
        this.bottomLevelDP = 50;
        this.bottomLevel = DPUtil.dip2px(50.0f);
        this.isBottom = false;
        this.isBottomLevelUp = false;
    }

    public WVPTRUCWebView(Context context) {
        super(context);
        this.screenHeight = ScreenUtil.getScreenHeight();
        this.bottomLevelDP = 50;
        this.bottomLevel = DPUtil.dip2px(50.0f);
        this.isBottom = false;
        this.isBottomLevelUp = false;
    }
}
