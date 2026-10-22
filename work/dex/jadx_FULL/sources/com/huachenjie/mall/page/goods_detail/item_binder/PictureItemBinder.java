package com.huachenjie.mall.page.goods_detail.item_binder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.commonability.device.jsapi.wifi.WifiManagerBridgeExtension;
import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.chad.library.adapter.base.binder.BaseItemBinder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.base.view.RoundImageView;
import com.huachenjie.common.util.PicturePreviewUtil;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailPicture;
import com.noober.background.drawable.DrawableCreator;
import com.zj.adlib.fx7;
import com.zj.adlib.ju3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016J(\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u0002H\u0002R\u0014\u0010\u0017\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001c\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001b\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/item_binder/PictureItemBinder;", "Lcom/chad/library/adapter/base/binder/BaseItemBinder;", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailPicture;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "holder", "data", "", "a", "Landroid/view/View;", "view", "position", "c", "Lcom/huachenjie/base/view/RoundImageView;", "ivPic", "b", "Landroid/widget/ImageView;", "d", "I", "px8", "px12", "picWidth", "maxPixelWidth", "e", "maxPixelHeight", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPictureItemBinder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PictureItemBinder.kt\ncom/huachenjie/mall/page/goods_detail/item_binder/PictureItemBinder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,141:1\n800#2,11:142\n1549#2:153\n1620#2,3:154\n*S KotlinDebug\n*F\n+ 1 PictureItemBinder.kt\ncom/huachenjie/mall/page/goods_detail/item_binder/PictureItemBinder\n*L\n135#1:142,11\n137#1:153\n137#1:154,3\n*E\n"})
public final class PictureItemBinder extends BaseItemBinder<GoodsDetailPicture, BaseViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int px8 = SizeUtils.b(8.0f);

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final int px12 = SizeUtils.b(12.0f);

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final int picWidth = fx7.j() - SizeUtils.b(56.0f);

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final int maxPixelWidth = 1080;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final int maxPixelHeight = WifiManagerBridgeExtension.ERROR_12000;

    public PictureItemBinder() {
        addChildClickViewIds(R.id.iv_pic);
    }

    @Override // com.chad.library.adapter.base.binder.BaseItemBinder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void convert(@NotNull BaseViewHolder holder, @NotNull GoodsDetailPicture data) {
        int i;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        RoundImageView roundImageView = (RoundImageView) holder.getView(R.id.iv_pic);
        b(roundImageView, data);
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
        DrawableCreator.Builder solidColor = new DrawableCreator.Builder().setSolidColor(-1);
        int positionType = data.getPositionType();
        if (positionType == 0) {
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = 0;
            solidColor.setCornersRadius(0.0f);
            roundImageView.setRadius(0, 0, 0, 0);
        } else {
            if (positionType != 1) {
                if (positionType == 2) {
                    int i2 = this.px12;
                    ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = i2;
                    solidColor.setCornersRadius(i2, i2, 0.0f, 0.0f);
                    i = this.px12;
                    int i3 = this.px8;
                    roundImageView.setRadius(0, 0, i3, i3);
                } else if (positionType == 3) {
                    int i4 = this.px12;
                    ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = i4;
                    solidColor.setCornersRadius(i4, i4, 0.0f, 0.0f);
                    i = this.px12;
                    int i5 = this.px8;
                    roundImageView.setRadius(i5, i5, i5, i5);
                }
                holder.itemView.setLayoutParams(layoutParams2);
                holder.itemView.setBackground(solidColor.build());
                View view = holder.itemView;
                int i6 = this.px12;
                view.setPadding(i6, 0, i6, i);
                if (data.getWidth() != 0 || data.getHeight() == 0) {
                    Glide.with(roundImageView).load(data.getUrl()).apply((BaseRequestOptions<?>) ju3.h).into(roundImageView);
                } else {
                    d(roundImageView, data);
                    return;
                }
            }
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = 0;
            solidColor.setCornersRadius(0.0f);
            int i7 = this.px8;
            roundImageView.setRadius(i7, i7, 0, 0);
        }
        i = 0;
        holder.itemView.setLayoutParams(layoutParams2);
        holder.itemView.setBackground(solidColor.build());
        View view2 = holder.itemView;
        int i8 = this.px12;
        view2.setPadding(i8, 0, i8, i);
        if (data.getWidth() != 0) {
        }
        Glide.with(roundImageView).load(data.getUrl()).apply((BaseRequestOptions<?>) ju3.h).into(roundImageView);
    }

    public final void b(RoundImageView ivPic, GoodsDetailPicture data) {
        if (data.getWidth() == 0 || data.getHeight() == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = ivPic.getLayoutParams();
        int i = this.picWidth;
        layoutParams.width = i;
        layoutParams.height = (i * data.getHeight()) / data.getWidth();
        ivPic.setLayoutParams(layoutParams);
    }

    @Override // com.chad.library.adapter.base.binder.BaseItemBinder
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onChildClick(@NotNull BaseViewHolder holder, @NotNull View view, @NotNull GoodsDetailPicture data, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        List<Object> data2 = getAdapter().getData();
        ArrayList arrayList = new ArrayList();
        for (Object obj : data2) {
            if (obj instanceof GoodsDetailPicture) {
                arrayList.add(obj);
            }
        }
        int iIndexOf = arrayList.indexOf(data);
        Context context = getContext();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((GoodsDetailPicture) it.next()).getUrl());
        }
        PicturePreviewUtil.h(context, arrayList2, iIndexOf, new Function1<Integer, View>() { // from class: com.huachenjie.mall.page.goods_detail.item_binder.PictureItemBinder.onChildClick.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                return invoke(((Number) obj2).intValue());
            }

            @Nullable
            public final View invoke(int i) {
                return PictureItemBinder.this.getAdapter().getViewByPosition(i, R.id.iv_pic);
            }
        });
    }

    public final void d(ImageView ivPic, GoodsDetailPicture data) {
        int width = data.getWidth();
        int height = data.getHeight();
        int i = this.maxPixelWidth;
        if (width > i || height > this.maxPixelHeight) {
            float f = width;
            float f2 = f / i;
            float f3 = height;
            int i2 = this.maxPixelHeight;
            float f4 = f3 / i2;
            if (f2 > f4) {
                height = (int) (f3 / f2);
                width = i;
            } else {
                width = (int) (f / f4);
                height = i2;
            }
        }
        Glide.with(ivPic).load(data.getUrl()).apply((BaseRequestOptions<?>) ju3.h).override(width, height).into(ivPic);
    }

    @Override // com.chad.library.adapter.base.binder.BaseItemBinder
    @NotNull
    public BaseViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.mall_item_goods_detail_picture, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "view");
        return new BaseViewHolder(viewInflate);
    }
}
