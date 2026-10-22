package com.zj.adlib;

import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.common.dialog.OnItemClickListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B+\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u001a\u001a\u00020\u0014\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b!\u0010\"B-\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u001a\u001a\u00020\u0014\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b!\u0010#R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u001a\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u0010\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/zj/adlib/lz0;", "", "", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", y6b.f, "(Ljava/lang/String;)V", "text", "", "I", "()I", "f", "(I)V", ALPParamConstant.ITMEID, "b", "d", y6b.g, "textColor", "", "F", "e", "()F", "i", "(F)V", "textSize", "Lcom/huachenjie/common/dialog/OnItemClickListener;", "Lcom/huachenjie/common/dialog/OnItemClickListener;", "()Lcom/huachenjie/common/dialog/OnItemClickListener;", "setListener", "(Lcom/huachenjie/common/dialog/OnItemClickListener;)V", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "<init>", "(Ljava/lang/String;IFI)V", "(Ljava/lang/String;IFLcom/huachenjie/common/dialog/OnItemClickListener;)V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class lz0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public float textSize;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public int itemId;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public OnItemClickListener listener;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public String text;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public int textColor;

    public lz0(@Nullable String str, int i, float f, int i2) {
        this.text = str;
        this.textColor = i;
        this.textSize = f;
        this.itemId = i2;
        this.listener = null;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getItemId() {
        return this.itemId;
    }

    @Nullable
    /* JADX INFO: renamed from: b, reason: from getter */
    public final OnItemClickListener getListener() {
        return this.listener;
    }

    @Nullable
    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getTextColor() {
        return this.textColor;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final float getTextSize() {
        return this.textSize;
    }

    public final void f(int i) {
        this.itemId = i;
    }

    public final void g(@Nullable String str) {
        this.text = str;
    }

    public final void h(int i) {
        this.textColor = i;
    }

    public final void i(float f) {
        this.textSize = f;
    }

    public final void setListener(@Nullable OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }

    public lz0(@Nullable String str, int i, float f, @Nullable OnItemClickListener onItemClickListener) {
        this.text = str;
        this.textColor = i;
        this.textSize = f;
        this.itemId = 0;
        this.listener = onItemClickListener;
    }
}
