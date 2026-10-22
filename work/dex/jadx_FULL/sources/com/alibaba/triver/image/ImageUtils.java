package com.alibaba.triver.image;

import android.content.Intent;
import androidx.collection.ArrayMap;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.utils.FileUtils;
import com.desgemini.mini_media_common.JSContextAdapter;
import com.hjq.permissions.Permission;
import com.taobao.android.miniimage.ui.SimpleImagePreviewActivity;
import com.taobao.android.pissarro.external.AspectRatio;
import com.taobao.android.pissarro.external.Callback;
import com.taobao.android.pissarro.external.Config;
import com.taobao.android.pissarro.external.Image;
import com.taobao.android.tao.pissarro.WrapperPissarroService;
import com.taobao.windmill.module.base.Status;
import com.taobao.windmill.rt.runtimepermission.PermissionProposer;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ImageUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24961a = "ImageUtils";
    private static final int b = 100;
    private static final int c = 90;
    private static final int d = 75;
    private static final int e = 50;

    public static class ImageChooseCallback implements Callback, Serializable {
        private JSContextAdapter mContext;

        public ImageChooseCallback(JSContextAdapter jSContextAdapter) {
            this.mContext = jSContextAdapter;
        }

        public void onCancel() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("error", (Object) 11);
            this.mContext.failed(Status.USER_CANCELED, jSONObject);
        }

        public void onComplete(List<Image> list) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Iterator<Image> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.add(FileUtils.filePathToApUrl(it.next().getPath(), "image"));
            }
            jSONObject.put("apFilePaths", (Object) jSONArray);
            this.mContext.success(jSONObject);
        }
    }

    public static void a(JSContextAdapter jSContextAdapter, JSONArray jSONArray, int i) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("imgIndex", (Object) Integer.valueOf(i));
        jSONObject.put("imgPath", (Object) jSONArray);
        Intent intent = new Intent(jSContextAdapter.getContext(), (Class<?>) SimpleImagePreviewActivity.class);
        intent.putExtra("imageData", jSONObject.toJSONString());
        jSContextAdapter.getContext().startActivity(intent);
        jSContextAdapter.success(new ArrayMap());
    }

    public static void a(final JSContextAdapter jSContextAdapter, boolean z, final boolean z2, boolean z3, boolean z4, int i, int i2, int i3) {
        final WrapperPissarroService wrapperPissarroService = new WrapperPissarroService(jSContextAdapter.getContext());
        final Config configBuild = new Config.Builder().setMultiple(i3 != 1).setDefinitionMode(2).setEnableFilter(z3).setAspectRatio(new AspectRatio(i, i2)).setEnableSticker(false).setEnableGraffiti(false).setEnableMosaic(false).setEnableClip(z4).setMaxSelectCount(i3).build();
        if (z) {
            PermissionProposer.buildPermissionTask(jSContextAdapter.getContext(), new String[]{Permission.CAMERA}).setTaskOnPermissionGranted(new Runnable() { // from class: com.alibaba.triver.image.ImageUtils.2
                @Override // java.lang.Runnable
                public void run() {
                    if (z2) {
                        wrapperPissarroService.openCameraOrAlbum(configBuild, new ImageChooseCallback(jSContextAdapter));
                    } else {
                        wrapperPissarroService.openCamera(configBuild, new ImageChooseCallback(jSContextAdapter));
                    }
                }
            }).setTaskOnPermissionDenied(new Runnable() { // from class: com.alibaba.triver.image.ImageUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    jSContextAdapter.failed(Status.NO_PERMISSION, new JSONObject());
                }
            }).execute();
        } else {
            if (z2) {
                wrapperPissarroService.openAlbum(configBuild, new ImageChooseCallback(jSContextAdapter));
                return;
            }
            HashMap map = new HashMap();
            map.put("msg", "sourceType is wrong, neither of camera or album is detected");
            jSContextAdapter.failed(Status.PARAM_ERR, map);
        }
    }
}
