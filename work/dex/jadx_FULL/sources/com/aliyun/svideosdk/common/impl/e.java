package com.aliyun.svideosdk.common.impl;

import android.graphics.Rect;
import com.aliyun.svideosdk.common.AliyunIThumbnailFetcher;
import com.aliyun.svideosdk.common.struct.common.MediaType;
import com.aliyun.svideosdk.common.struct.common.VideoDisplayMode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f25641a;
    private long b;
    private long c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private AliyunIThumbnailFetcher.CropMode i;
    private VideoDisplayMode j = VideoDisplayMode.SCALE;

    public long a() {
        return this.c;
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(long j) {
        this.c = j;
    }

    public void a(Rect rect) {
    }

    public void a(AliyunIThumbnailFetcher.CropMode cropMode) {
        this.i = cropMode;
    }

    public void a(MediaType mediaType) {
    }

    public void a(VideoDisplayMode videoDisplayMode) {
        this.j = videoDisplayMode;
    }

    public void a(String str) {
        this.f25641a = str;
    }

    public AliyunIThumbnailFetcher.CropMode b() {
        return this.i;
    }

    public void b(int i) {
        this.g = i;
    }

    public void b(long j) {
    }

    public int c() {
        return this.h;
    }

    public void c(int i) {
        this.e = i;
    }

    public void c(long j) {
        this.b = j;
    }

    public int d() {
        return this.g;
    }

    public void d(int i) {
        this.d = i;
    }

    public String e() {
        return this.f25641a;
    }

    public void e(int i) {
        this.f = i;
    }

    public int f() {
        return this.e;
    }

    public int g() {
        return this.d;
    }

    public long h() {
        return this.b;
    }

    public int i() {
        return this.f;
    }

    public VideoDisplayMode j() {
        return this.j;
    }
}
