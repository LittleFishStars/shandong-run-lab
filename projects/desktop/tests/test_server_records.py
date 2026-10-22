# -*- coding: utf-8 -*-
"""服务端记录接口测试：run/pageSunRunRecord 分页 + run/runRecordDetail 详情

覆盖 App.server_records / App.server_record_detail 的对外契约：
  · 未登录时 ok=False 且 error=未登录（不会抛异常）
  · 登录并结算一次后，列表里能拿到这条记录，字段已规整成界面结构
  · 详情能按 runRecordCode 拿到同一条记录
整条链路走本地 Mock 服务端，不碰真实网络。
"""
import shutil
import tempfile
import time
import unittest
from pathlib import Path

from shandong_school_cracked.app import App

超时上限 = 120.0


class 服务端记录测试(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.tmp = Path(tempfile.mkdtemp(prefix="shandong-school_cracked-records-"))
        cls.app = App(data_dir=cls.tmp, config_path=cls.tmp / "config.json", mode="mock")
        cls.错误 = []
        try:
            cls.app.login("13800138000", "any-password", False)
            cls.app.run_prepare()
            r = cls.app.run_auto(target_m=600)
            if r.get("code") != 0:
                cls.错误.append(f"run_auto 返回 {r}")
            cls.等完()
        except Exception as e:  # noqa: BLE001 —— 让用例给出可读失败
            cls.错误.append(f"{type(e).__name__}: {e}")

    @classmethod
    def tearDownClass(cls):
        try:
            cls.app.close()
        finally:
            shutil.rmtree(cls.tmp, ignore_errors=True)

    @classmethod
    def 等完(cls, 上限=超时上限):
        t0 = time.time()
        while cls.app.running() and time.time() - t0 < 上限:
            time.sleep(0.2)

    def 前置(self):
        if self.错误:
            self.skipTest("前置跑步失败：" + "；".join(self.错误))

    def test_未登录时返回错误而不是抛异常(self):
        tmp = Path(tempfile.mkdtemp(prefix="shandong-school_cracked-records-anon-"))
        app = App(data_dir=tmp, config_path=tmp / "config.json", mode="mock")
        try:
            r = app.server_records()
            self.assertFalse(r["ok"])
            self.assertEqual(r["error"], "未登录")
            self.assertEqual(r["items"], [])
            d = app.server_record_detail("SOME-CODE")
            self.assertFalse(d["ok"])
            self.assertEqual(d["error"], "未登录")
        finally:
            app.close()
            shutil.rmtree(tmp, ignore_errors=True)

    def test_列表返回已结算记录(self):
        self.前置()
        r = self.app.server_records(page=1, size=20)
        self.assertTrue(r["ok"], r.get("error"))
        self.assertGreaterEqual(len(r["items"]), 1)
        item = r["items"][0]
        # 字段是界面直接用的那套名字
        for k in ("run_code", "distance_m", "duration_s", "pace_s_per_km",
                  "total_step", "start_ms", "end_ms", "state", "state_kind"):
            self.assertIn(k, item)
        self.assertTrue(item["run_code"])
        self.assertGreater(item["distance_m"], 0)
        self.assertEqual(item["state_kind"], "ok")
        # 分页元信息：第一页且记录数不足一页时没有下一页
        self.assertEqual(r["page"], 1)
        self.assertFalse(r["has_next"])

    def test_详情按runRecordCode返回同一条(self):
        self.前置()
        r = self.app.server_records(page=1, size=20)
        self.assertTrue(r["ok"], r.get("error"))
        code = r["items"][0]["run_code"]
        d = self.app.server_record_detail(code)
        self.assertTrue(d["ok"], d.get("error"))
        self.assertEqual(d["record"]["run_code"], code)
        self.assertEqual(d["record"]["distance_m"], r["items"][0]["distance_m"])
        # 详情专属字段
        for k in ("invalid_reasons", "audit_detail", "point_count"):
            self.assertIn(k, d)

    def test_空runRecordCode被拒绝(self):
        self.前置()
        d = self.app.server_record_detail("")
        self.assertFalse(d["ok"])
        self.assertIn("runRecordCode", d["error"])

    def test_分页参数越界会被夹紧(self):
        self.前置()
        r = self.app.server_records(page=0, size=999)
        self.assertTrue(r["ok"])
        self.assertEqual(r["page"], 1)          # page 至少 1
        self.assertLessEqual(len(r["items"]), 50)  # size 上限 50
