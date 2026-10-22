package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.zj.adlib.ft3;
import com.zj.adlib.gt3;
import com.zj.adlib.ht3;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class GenericDraweeView extends DraweeView<ft3> {
    public GenericDraweeView(Context context, ft3 ft3Var) {
        super(context);
        setHierarchy(ft3Var);
    }

    public void inflateHierarchy(Context context, @Nullable AttributeSet attributeSet) {
        gt3 gt3VarD = ht3.d(context, attributeSet);
        setAspectRatio(gt3VarD.g());
        setHierarchy(gt3VarD.a());
    }

    public GenericDraweeView(Context context) {
        super(context);
        inflateHierarchy(context, null);
    }

    public GenericDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflateHierarchy(context, attributeSet);
    }

    public GenericDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        inflateHierarchy(context, attributeSet);
    }

    @TargetApi(21)
    public GenericDraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        inflateHierarchy(context, attributeSet);
    }
}
