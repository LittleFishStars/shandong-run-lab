
/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void FUN_0009fb70(undefined1 param_1 [16],undefined1 param_2 [16],undefined8 param_3,
                 undefined8 param_4,long param_5)

{
  undefined8 uVar1;
  undefined2 uVar2;
  long lVar3;
  undefined6 uVar4;
  undefined1 in_ZR;
  undefined1 uVar5;
  char cVar6;
  byte bVar7;
  int iVar8;
  uint uVar9;
  int iVar10;
  long *plVar11;
  undefined8 uVar12;
  undefined8 uVar13;
  long lVar14;
  undefined8 uVar15;
  undefined8 uVar16;
  undefined8 uVar17;
  undefined8 uVar18;
  undefined8 uVar19;
  ulong *puVar20;
  long lVar21;
  undefined1 *puVar22;
  undefined8 *puVar23;
  undefined8 *puVar24;
  long lVar25;
  long lVar26;
  long lVar27;
  long lVar28;
  long lVar29;
  undefined8 extraout_x1;
  undefined8 extraout_x1_00;
  undefined8 extraout_x1_01;
  undefined8 extraout_x1_02;
  undefined8 extraout_x1_03;
  undefined8 extraout_x1_04;
  undefined8 extraout_x1_05;
  undefined8 extraout_x1_06;
  undefined8 extraout_x1_07;
  undefined8 extraout_x1_08;
  undefined8 extraout_x1_09;
  undefined8 extraout_x1_10;
  undefined8 extraout_x1_11;
  undefined8 extraout_x1_12;
  undefined8 extraout_x1_13;
  undefined8 extraout_x1_14;
  long extraout_x1_15;
  undefined8 extraout_x1_16;
  undefined8 extraout_x1_17;
  undefined8 extraout_x1_18;
  undefined8 extraout_x1_19;
  undefined8 extraout_x1_20;
  char *pcVar30;
  undefined4 extraout_w8;
  undefined4 uVar31;
  undefined4 extraout_w8_00;
  long extraout_x8;
  long extraout_x8_00;
  code *extraout_x8_01;
  undefined8 extraout_x8_02;
  code *extraout_x8_03;
  undefined8 extraout_x8_04;
  undefined8 extraout_x8_05;
  long extraout_x8_06;
  code *extraout_x8_07;
  code *extraout_x8_08;
  long extraout_x8_09;
  long extraout_x8_10;
  ulong extraout_x8_11;
  ulong *extraout_x8_12;
  ulong extraout_x8_13;
  long extraout_x8_14;
  long extraout_x8_15;
  ulong extraout_x8_16;
  long extraout_x8_17;
  code *extraout_x8_18;
  code *extraout_x8_19;
  ulong extraout_x8_20;
  code *extraout_x8_21;
  long extraout_x8_22;
  undefined8 extraout_x8_23;
  ulong extraout_x8_24;
  ulong extraout_x9;
  ulong extraout_x9_00;
  undefined8 extraout_x9_01;
  undefined8 extraout_x9_02;
  ulong extraout_x9_03;
  ulong extraout_x9_04;
  undefined8 extraout_x9_05;
  ulong extraout_x9_06;
  undefined8 extraout_x9_07;
  ulong extraout_x9_08;
  ulong extraout_x9_09;
  ulong extraout_x9_10;
  ulong extraout_x9_11;
  ulong extraout_x9_12;
  undefined8 extraout_x9_13;
  ulong extraout_x9_14;
  undefined8 extraout_x9_15;
  ulong extraout_x9_16;
  ulong extraout_x10;
  undefined8 extraout_x10_00;
  ulong extraout_x10_01;
  undefined8 extraout_x10_02;
  undefined8 extraout_x10_03;
  ulong extraout_x10_04;
  undefined8 extraout_x10_05;
  ulong extraout_x10_06;
  undefined4 extraout_w11;
  ulong extraout_x11;
  ulong extraout_x11_00;
  ulong extraout_x12;
  ulong extraout_x12_00;
  bool bVar32;
  ulong unaff_x21;
  ulong uVar33;
  ulong uVar34;
  ulong uVar35;
  int iVar36;
  uint uVar37;
  uint uVar38;
  undefined8 extraout_d0;
  undefined1 auVar39 [16];
  undefined8 extraout_var;
  undefined1 auVar40 [16];
  undefined1 auVar41 [16];
  undefined1 local_178 [24];
  undefined8 local_160;
  undefined2 uStack_158;
  undefined3 uStack_156;
  undefined2 uStack_153;
  undefined1 uStack_151;
  undefined2 uStack_150;
  undefined3 uStack_14e;
  undefined2 uStack_14b;
  undefined1 uStack_149;
  undefined2 uStack_148;
  undefined3 uStack_146;
  undefined2 uStack_143;
  undefined1 uStack_141;
  undefined8 *local_138;
  undefined8 local_130;
  long local_128;
  undefined8 *local_120;
  undefined8 local_118;
  undefined8 local_110;
  undefined8 *puStack_108;
  undefined8 local_100;
  undefined8 uStack_f8;
  int local_f0;
  ulong local_e0;
  undefined1 uStack_d8;
  undefined1 uStack_d7;
  undefined2 uStack_d6;
  undefined2 uStack_d4;
  undefined2 uStack_d2;
  undefined6 uStack_d0;
  undefined2 uStack_ca;
  undefined1 auStack_bc [12];
  ulong local_b0;
  undefined8 uStack_a8;
  ulong local_a0;
  undefined1 local_90 [16];
  ulong local_80;
  undefined7 uStack_78;
  undefined1 uStack_71;
  undefined4 uStack_70;
  undefined4 uStack_6c;
  long local_68;
  
  uVar15 = param_2._8_8_;
  uVar12 = param_2._0_8_;
  auVar40 = FUN_000cff2c();
  plVar11 = auVar40._0_8_;
  lVar3 = tpidr_el0;
  local_68 = *(long *)(lVar3 + 0x28);
  if (*(char *)(param_5 + 0xea) == '\0') {
    auVar39 = FUN_000d7a14(0x1f5e9);
    uStack_158 = auVar39._8_2_;
    uStack_156 = auVar39._10_3_;
    uStack_153 = auVar39._13_2_;
    local_160._0_1_ = auVar39[0];
    local_160._1_6_ = auVar39._1_6_;
    local_160._7_1_ = auVar39[7];
    uStack_149 = (undefined1)uVar15;
    uStack_148 = (undefined2)((ulong)uVar15 >> 8);
    uStack_146 = (undefined3)((ulong)uVar15 >> 0x18);
    uStack_143 = (undefined2)((ulong)uVar15 >> 0x30);
    uStack_151 = (undefined1)uVar12;
    uStack_150 = (undefined2)((ulong)uVar12 >> 8);
    uStack_14e = (undefined3)((ulong)uVar12 >> 0x18);
    uStack_14b = (undefined2)((ulong)uVar12 >> 0x30);
    FUN_00083510(&local_160,&local_e0);
    FUN_000d5b54(&local_80,&local_e0);
    uVar12 = FUN_000d5cb0(*plVar11);
    uVar33 = unaff_x21 | 1;
    if ((extraout_x9 & 1) != 0) {
      uVar33 = extraout_x10;
    }
    uVar13 = FUN_000d0e74(*(undefined8 *)(extraout_x8 + 0x30),uVar12,uVar33);
    FUN_000d0c98();
    local_160._0_1_ = 0xc2;
    local_160._1_6_ = 0xd5c9d1c5c6d0;
    local_160._7_1_ = 0x88;
    FUN_00076d64(&local_160,&local_e0);
    FUN_000d1dfc(&local_80);
    uVar12 = _DAT_0001692c;
    uVar15 = uRam0000000000016934;
    auVar39 = FUN_000d4800(local_80 & 0xff,_DAT_0001691c);
    uStack_158 = auVar39._8_2_;
    uStack_156 = auVar39._10_3_;
    uStack_153 = auVar39._13_2_;
    uStack_151 = auVar39[0xf];
    local_160._0_1_ = auVar39[0];
    local_160._1_6_ = auVar39._1_6_;
    local_160._7_1_ = auVar39[7];
    uStack_148 = (undefined2)uVar15;
    uStack_146 = (undefined3)((ulong)uVar15 >> 0x10);
    uStack_143 = (undefined2)((ulong)uVar15 >> 0x28);
    uStack_141 = (undefined1)((ulong)uVar15 >> 0x38);
    uStack_150 = (undefined2)uVar12;
    uStack_14e = (undefined3)((ulong)uVar12 >> 0x10);
    uStack_14b = (undefined2)((ulong)uVar12 >> 0x28);
    uStack_149 = (undefined1)((ulong)uVar12 >> 0x38);
    FUN_000b653c();
    FUN_0006e06c(&local_b0,&local_e0);
    FUN_000d804c();
    in_ZR = (extraout_x9_00 & 1) == 0;
    lVar14 = FUN_000d0610(*(undefined8 *)(extraout_x8_00 + 0x480),plVar11,uVar13);
    FUN_000d03c0();
    FUN_000d0c98();
    if (lVar14 != 0) {
      FUN_000d6ac8(*plVar11,plVar11);
      lVar14 = FUN_000d46bc();
      if (lVar14 != 0) {
        FUN_000d33f4(*plVar11);
        FUN_000d045c();
        uVar15 = FUN_000d3244(0x1f608);
        FUN_00072294(&local_e0,&local_80);
        FUN_0006e06c(&local_160,&local_80);
        auVar39 = FUN_000d79cc((byte)local_160);
        local_80 = auVar39._0_8_;
        uVar12 = extraout_x10_00;
        if (!(bool)in_ZR) {
          uVar12 = extraout_x9_01;
        }
        uStack_78 = auVar39._8_7_;
        uStack_71 = auVar39[0xf];
        uStack_70 = extraout_w11;
        FUN_0007ec48(&local_80,&local_b0);
        FUN_000d2d74(&local_e0);
        uVar16 = FUN_000d3418(*plVar11);
        auVar39 = (*extraout_x8_01)(uVar16,uVar15,uVar12);
        FUN_000d33f4(auVar39._0_8_,auVar39._8_8_,auVar39._0_8_);
        uVar17 = FUN_00080334();
        FUN_000d03b8();
        FUN_000cfee0();
        FUN_000d045c(*plVar11,plVar11,uVar17);
        uVar18 = FUN_000d3250(0x1f625);
        local_160._0_1_ = (byte)extraout_x9_02;
        local_160._1_6_ = (undefined6)((ulong)extraout_x9_02 >> 8);
        local_160._7_1_ = (undefined1)extraout_x8_02;
        uStack_158 = (undefined2)((ulong)extraout_x8_02 >> 8);
        uStack_156 = (undefined3)((ulong)extraout_x8_02 >> 0x18);
        uStack_153 = (undefined2)((ulong)extraout_x8_02 >> 0x30);
        FUN_00072124(&local_160,&local_e0);
        FUN_000d1dfc(&local_80);
        uVar12 = CONCAT26(uRam000000000001f644,_DAT_0001f63e);
        uVar34 = (ulong)&local_80 | 1;
        uVar16 = uRam000000000001f646;
        auVar39 = FUN_000d4800(local_80 & 0xff,_DAT_0001f634);
        uVar33 = uVar34;
        if (!(bool)in_ZR) {
          uVar33 = extraout_x9_03;
        }
        uStack_158 = auVar39._8_2_;
        uVar2 = uStack_158;
        local_160._0_1_ = auVar39[0];
        bVar7 = (byte)local_160;
        local_160._1_6_ = auVar39._1_6_;
        uVar4 = local_160._1_6_;
        local_160._7_1_ = auVar39[7];
        uVar5 = local_160._7_1_;
        uStack_14e = (undefined3)uVar16;
        uStack_14b = (undefined2)((ulong)uVar16 >> 0x18);
        uStack_149 = (undefined1)((ulong)uVar16 >> 0x28);
        uStack_148 = (undefined2)((ulong)uVar16 >> 0x30);
        uStack_156 = (undefined3)uVar12;
        uStack_153 = (undefined2)((ulong)uVar12 >> 0x18);
        uStack_151 = (undefined1)((ulong)uVar12 >> 0x28);
        uStack_150 = (undefined2)((ulong)uVar12 >> 0x30);
        FUN_00088f0c();
        FUN_000d1dfc(&local_b0);
        uVar16 = FUN_000d41e4(*(undefined8 *)(*plVar11 + 0x108));
        auVar41 = (*extraout_x8_03)(uVar16,uVar18,uVar33);
        FUN_000d4b18(auVar41._0_8_,auVar41._8_8_,auVar41._0_8_);
        uVar16 = FUN_00080334();
        FUN_000d03c0();
        FUN_000d0c98();
        FUN_000b0bc8(&local_80,plVar11,uVar16);
        auVar41 = FUN_000d322c(0x1f64e);
        local_e0 = auVar41._0_8_;
        uStack_d8 = auVar41[8];
        uStack_d7 = auVar41[9];
        uStack_d6 = auVar41._10_2_;
        uStack_d4 = auVar41._12_2_;
        uStack_d2 = (undefined2)extraout_x8_04;
        uStack_d0 = (undefined6)((ulong)extraout_x8_04 >> 0x10);
        FUN_000829d8(&local_e0,&local_b0);
        FUN_000d2d74(&local_160);
        uVar19 = FUN_000d0a50(*plVar11);
        FUN_000cfee0();
        auVar41 = FUN_000d23dc(0x1f664);
        uStack_158 = auVar41._8_2_;
        uStack_156 = auVar41._10_3_;
        local_160._0_1_ = auVar41[0];
        local_160._1_6_ = auVar41._1_6_;
        local_160._7_1_ = auVar41[7];
        uStack_153 = (undefined2)extraout_x8_05;
        uStack_151 = (undefined1)((ulong)extraout_x8_05 >> 0x10);
        uStack_150 = (undefined2)((ulong)extraout_x8_05 >> 0x18);
        uStack_14e = (undefined3)((ulong)extraout_x8_05 >> 0x28);
        FUN_00082b84(&local_160,&local_e0);
        FUN_000d1dfc(&local_b0);
        uStack_156 = auVar39._10_3_;
        uStack_153 = auVar39._13_2_;
        uStack_151 = auVar39[0xf];
        local_160._0_1_ = bVar7;
        local_160._1_6_ = uVar4;
        local_160._7_1_ = uVar5;
        uStack_158 = uVar2;
        auVar39 = FUN_000d4800(local_b0 & 0xff,uVar12);
        uStack_14e = auVar39._8_3_;
        uStack_14b = auVar39._11_2_;
        uStack_149 = auVar39[0xd];
        uStack_148 = auVar39._14_2_;
        uStack_156 = auVar39._0_3_;
        uStack_153 = auVar39._3_2_;
        uStack_151 = auVar39[5];
        uStack_150 = auVar39._6_2_;
        FUN_00088f0c();
        FUN_0006e06c(local_178,&local_e0);
        FUN_000d7910(*plVar11);
        uVar5 = (extraout_x9_04 & 1) == 0;
        FUN_000d76d4(*(undefined8 *)(extraout_x8_06 + 0x388),plVar11);
        (*extraout_x8_07)();
        FUN_000cffb8();
        FUN_000d03c0();
        FUN_000d76d4(plVar11);
        uVar12 = FUN_0007e40c();
        FUN_000b0bc8(&local_160,plVar11,uVar12);
        FUN_000d5cb0(_DAT_000e8a38);
        FUN_000d52c8();
        if (!(bool)uVar5) {
          uVar34 = extraout_x10_01;
        }
        uVar33 = (ulong)&local_160 | 1;
        in_ZR = (extraout_x11 & 1) == 0;
        if (!(bool)in_ZR) {
          uVar33 = extraout_x12;
        }
        iVar8 = (*extraout_x8_08)(uVar34,uVar33);
        if (iVar8 == 0) {
          FUN_000d0720(0x1f679);
          FUN_000d7a6c(&local_b0,auStack_bc);
          FUN_000d8304(&local_e0);
          FUN_000d1ccc();
          FUN_000d3488();
          uVar1 = extraout_x10_02;
          if (!(bool)in_ZR) {
            uVar1 = extraout_x9_05;
          }
          FUN_000cfe20(uVar1,&DAT_0001535c);
          FUN_000d03b8();
        }
        FUN_000cfb64(*plVar11,plVar11,uVar15);
        FUN_000cfb64(*plVar11,plVar11,uVar17);
        FUN_000cfb64(*plVar11,plVar11,uVar18);
        FUN_000cfb64(*plVar11,plVar11,uVar16);
        FUN_000cfb64(*plVar11,plVar11,uVar19);
        FUN_000cfb64(*plVar11,plVar11,uVar12);
        FUN_000cfb64(*plVar11,plVar11,lVar14);
        FUN_000cfee0();
        FUN_000d0c98();
      }
    }
    FUN_000cfb64(*plVar11,plVar11,uVar13);
  }
  FUN_0008b234(&local_160,&DAT_0001b332);
  iVar8 = FUN_00070dc8(param_5 + 0x30,&local_160);
  FUN_000cfee0();
  if (iVar8 == 0) {
LAB_000a00f4:
    uVar37 = 1;
  }
  else {
    FUN_000d1cb0();
    FUN_0006e06c(&local_80);
    if (*(char *)(param_5 + 0xd0) == '\0') {
      FUN_000d7e4c(&local_160);
      FUN_00070ad0(&local_80,&local_160);
      puVar20 = &local_160;
    }
    else {
      FUN_000d48b4(&local_160);
      FUN_000ae94c();
      FUN_000af134(&local_e0,&local_160);
      FUN_000d04e0(local_e0 & 0xff);
      if (extraout_x8_09 == 0) {
        FUN_000d7e4c(&local_b0);
      }
      else {
        uStack_a8 = CONCAT26(uStack_d2,
                             CONCAT24(uStack_d4,CONCAT22(uStack_d6,CONCAT11(uStack_d7,uStack_d8))));
        local_a0 = CONCAT26(uStack_ca,uStack_d0);
        local_b0 = local_e0;
        FUN_0006f178(&local_e0);
      }
      FUN_000d03b8();
      FUN_000cfee0();
      FUN_00070ad0(&local_80,&local_b0);
      puVar20 = &local_b0;
    }
    FUN_0004e170(puVar20);
    FUN_000d1b28(param_5 + 0x30,&local_80);
    if (!(bool)in_ZR) {
      FUN_000d0c98();
      goto LAB_000a00f4;
    }
    uVar12 = FUN_000d4750(0x1b337);
    uStack_d8 = (undefined1)extraout_w8;
    uStack_d7 = (undefined1)((uint)extraout_w8 >> 8);
    uStack_d6 = (undefined2)((uint)extraout_w8 >> 0x10);
    local_e0 = extraout_x9_06;
    FUN_00073578(uVar12,&local_b0);
    FUN_0006e06c(&local_160,&local_b0);
    FUN_000d0a30();
    FUN_000d20ec();
    uVar33 = (ulong)&local_80 | 1;
    uVar12 = extraout_x10_03;
    if (!(bool)in_ZR) {
      uVar12 = extraout_x9_07;
    }
    if ((extraout_x11_00 & 1) != 0) {
      uVar33 = extraout_x12_00;
    }
    FUN_000cfe20(uVar12,uVar33);
    FUN_000cfee0();
    FUN_000d0c98();
    FUN_0008b234(&local_160,&DAT_0001b343);
    FUN_0007e604(plVar11,&local_160);
    FUN_000cfee0();
    uVar37 = 0;
  }
  uVar9 = FUN_0008b3b8(plVar11,*(undefined1 *)(param_5 + 0xac));
  FUN_000d1274();
  uVar33 = FUN_0008b438();
  if (uVar37 == 0) {
    _DAT_000e93ec = 1;
    if ((uVar9 & 1) == 0) goto LAB_000a0198;
LAB_000a01d4:
    _DAT_000e93cc = 1;
    if ((uVar33 & 1) != 0) goto LAB_000a019c;
LAB_000a01e4:
    if (((uVar9 | uVar37 ^ 0xffffffff) & 1) != 0) {
      uVar31 = 3;
      if (uVar37 == 0) {
        uVar31 = 0;
      }
      goto LAB_000a01f8;
    }
  }
  else {
    if ((uVar9 & 1) != 0) goto LAB_000a01d4;
LAB_000a0198:
    if ((uVar33 & 1) == 0) goto LAB_000a01e4;
LAB_000a019c:
    uVar31 = 3;
    if (uVar37 == 0) {
      uVar31 = 0;
    }
    _DAT_000e93e4 = 1;
    if (((uVar9 | uVar37 ^ 0xffffffff) & 1) == 0) {
      uVar31 = 4;
    }
LAB_000a01f8:
    FUN_000d58f0(uVar33,uVar31);
  }
  FUN_000a9a08();
  auVar39 = FUN_000d04c4();
  uVar12 = auVar39._8_8_;
  cVar6 = *(char *)(auVar39._0_8_ + 0xe6);
  if (*(char *)(auVar39._0_8_ + 0xc1) != '\0') {
    FUN_000d57e0(&LAB_00081464,uVar12,2,1);
    iVar8 = FUN_000d6050(_DAT_000e8a38,&local_160,extraout_x1,&LAB_00081988);
    uVar12 = extraout_x1_00;
    if (iVar8 == 0) {
      FUN_000d8ff0(CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160)));
      uVar12 = extraout_x1_01;
    }
  }
  if (cVar6 != '\0') {
    FUN_00080dec(&local_160,&DAT_0001a358);
    uVar12 = FUN_000d3084(*plVar11);
    uVar33 = (ulong)&local_160 | 1;
    if ((extraout_x9_08 & 1) != 0) {
      uVar33 = extraout_x10_04;
    }
    lVar14 = FUN_000d0e74(*(undefined8 *)(extraout_x8_10 + 0x30),uVar12,uVar33);
    FUN_000cfee0();
    if (lVar14 != 0) {
      FUN_00080dec(&local_160,&DAT_0001a369);
      FUN_000d0a30();
      FUN_00080dec(&local_e0,&DAT_0001a37d);
      FUN_000d81c4(*plVar11);
      lVar21 = FUN_000d1734(plVar11,lVar14);
      FUN_000d03b8();
      FUN_000cfee0();
      if (lVar21 == 0) {
        FUN_000cfb64(*plVar11,plVar11,lVar14);
      }
      else {
        FUN_000d7ff4(plVar11);
        cVar6 = FUN_00081374();
        FUN_000cfb64(*plVar11,plVar11,lVar14);
        if (cVar6 != '\0') {
          uVar12 = FUN_000d4750(0x1a399);
          uStack_d8 = (undefined1)extraout_w8_00;
          uStack_d7 = (undefined1)((uint)extraout_w8_00 >> 8);
          uStack_d6 = (undefined2)((uint)extraout_w8_00 >> 0x10);
          local_e0 = extraout_x9_09;
          FUN_00073578(uVar12,auStack_bc);
          FUN_0006e06c(&local_160,auStack_bc);
          FUN_000d0a30();
          uVar33 = (ulong)&local_160 | 1;
          if ((extraout_x8_11 & 1) != 0) {
            uVar33 = extraout_x9_10;
          }
          FUN_000cfe20(uVar33,&DAT_0001535c);
          uVar12 = FUN_000cfee0();
          FUN_000d58f0(uVar12,2);
          uVar12 = extraout_x1_02;
          goto LAB_000a04b8;
        }
      }
    }
    FUN_000d7e80();
    uVar34 = *extraout_x8_12;
    uVar2 = (undefined2)extraout_x8_12[1];
    uStack_d8 = (undefined1)uVar2;
    uStack_d7 = (undefined1)((ushort)uVar2 >> 8);
    local_e0 = uVar34;
    FUN_000817d4(&local_e0,&local_b0);
    FUN_000d2d74(&local_160);
    uVar33 = (ulong)&local_160 | 1;
    if (((byte)local_160 & 1) != 0) {
      uVar33 = CONCAT17(uStack_149,CONCAT25(uStack_14b,CONCAT32(uStack_14e,uStack_150)));
    }
    uStack_78 = uRam000000000001a3ad;
    local_80 = _DAT_0001a3a5;
    uStack_71 = (undefined1)DAT_0001a3b4;
    uStack_70 = (undefined4)DAT_0001a3b4._1_7_;
    uStack_6c._0_3_ = (undefined3)((uint7)DAT_0001a3b4._1_7_ >> 0x20);
    FUN_000817fc(&local_80,&local_b0);
    FUN_000d2d74(&local_e0);
    FUN_000d1ccc();
    uVar35 = (ulong)&local_e0 | 1;
    FUN_000d32c0(uVar33);
    lVar14 = FUN_000aac6c();
    FUN_000d03b8();
    uVar12 = FUN_000cfee0();
    if (lVar14 != 0) {
      FUN_000d8670(uVar12,FUN_00081824,0xe88a8);
    }
    local_160._0_1_ = (byte)uVar34;
    local_160._1_6_ = (undefined6)(uVar34 >> 8);
    local_160._7_1_ = (undefined1)(uVar34 >> 0x38);
    uStack_158 = uVar2;
    FUN_000817d4(&local_160,&local_b0);
    FUN_000d2d74(&local_e0);
    FUN_000d1ccc();
    for (uVar33 = 0; uVar33 != 0x71; uVar33 = uVar33 + 1) {
      *(byte *)((long)&local_160 + uVar33) =
           ((&DAT_0001a3bc)[uVar33] ^ (byte)(&DAT_0001693c)[uVar33 & 7]) & 0x7f;
    }
    if ((extraout_x8_13 & 1) != 0) {
      uVar35 = extraout_x9_11;
    }
    FUN_0006e06c(&local_80,&local_160);
    FUN_000d2fe0();
    lVar14 = FUN_000d1eb8(uVar35);
    FUN_000d0c98();
    auVar39 = FUN_000d03b8();
    uVar12 = auVar39._8_8_;
    if (lVar14 != 0) {
      FUN_000d8670(auVar39._0_8_,&LAB_000818dc,0xe88b0);
      uVar12 = extraout_x1_03;
    }
  }
LAB_000a04b8:
  if (*(char *)(param_5 + 0xb3) != '\0') {
    FUN_000d11a0(FUN_00083560,uVar12,1);
    uVar12 = extraout_x1_04;
  }
  if ((*(char *)(param_5 + 0xbb) != '\0') || (*(char *)(param_5 + 0xbc) != '\0')) {
    FUN_000d8000(&local_160,uVar12,&LAB_000994b0);
    uVar12 = extraout_x1_05;
  }
  uVar5 = DAT_000e8478;
  if (*(char *)(param_5 + 0xcf) != '\0') {
    puVar22 = (undefined1 *)FUN_000d8780(1);
    *puVar22 = uVar5;
    FUN_000d3920(FUN_000c7a40,puVar22,5);
    uVar12 = extraout_x1_06;
  }
  if (*(char *)(param_5 + 0xbe) != '\0') {
    FUN_000d11a0(FUN_000ac8e0,uVar12,8);
  }
  if (*(char *)(param_5 + 0xe3) == '\0') {
    auVar39 = FUN_000d24ac();
    FUN_00081af8(auVar39._0_8_,auVar39._8_8_,param_5);
  }
  lVar14 = FUN_0008c920();
  if (*(long *)(lVar14 + 0x1f8) == *(long *)(lVar14 + 0x1f0)) {
    auVar39 = FUN_0008c920();
    uVar12 = auVar39._8_8_;
    if (*(long *)(auVar39._0_8_ + 0x1e0) != *(long *)(auVar39._0_8_ + 0x1d8)) goto LAB_000a0574;
  }
  else {
LAB_000a0574:
    puVar23 = (undefined8 *)FUN_000afa90(_DAT_000e8a68);
    uVar12 = FUN_000d1d04(*puVar23,puVar23,auVar40._8_8_);
    FUN_000d8d80(&local_160,0,FUN_000929d8,uVar12);
    uVar12 = extraout_x1_07;
  }
  if (*(char *)(param_5 + 0xcc) != '\0') {
    FUN_000d3920(FUN_000c5850,0,0xb);
    uVar12 = extraout_x1_08;
  }
  if (*(char *)(param_5 + 0xf8) != '\0') {
    FUN_000d3920(FUN_000c6438,0,0x10);
    uVar12 = extraout_x1_09;
  }
  if (*(char *)(param_5 + 0x102) != '\0') {
    FUN_000d11a0(FUN_000adbfc,uVar12,5);
    uVar12 = extraout_x1_10;
  }
  if (0 < *(int *)(param_5 + 0xa8)) {
    FUN_000b5c84();
    uVar12 = extraout_x1_11;
  }
  if (*(char *)(param_5 + 0xae) != '\0') {
    FUN_000b3ea8(&local_160,&DAT_0001f3b0);
    FUN_000d3084(*plVar11);
    lVar14 = FUN_000d0a50();
    FUN_000cfee0();
    if (lVar14 == 0) {
      FUN_000cff60(*plVar11,plVar11);
      uVar12 = extraout_x1_13;
    }
    else {
      local_160._0_1_ = (byte)DAT_0001f3ce;
      local_160._1_6_ = (undefined6)((ulong)DAT_0001f3ce >> 8);
      local_160._7_1_ = (undefined1)((ulong)DAT_0001f3ce >> 0x38);
      uStack_158 = DAT_0001f3d6;
      FUN_000817d4(&local_160,&local_b0);
      FUN_000d5b54(&local_80,&local_b0);
      uVar12 = CONCAT53(uRam000000000001f3e8,_DAT_0001f3e5);
      uVar15 = uRam000000000001f3ed;
      uVar13 = FUN_000d46e4(local_80 & 0xff,_DAT_0001f3d8);
      uStack_158 = (undefined2)extraout_var;
      uStack_156 = (undefined3)((ulong)extraout_var >> 0x10);
      local_160._0_1_ = (byte)extraout_d0;
      local_160._1_6_ = (undefined6)((ulong)extraout_d0 >> 8);
      local_160._7_1_ = (undefined1)((ulong)extraout_d0 >> 0x38);
      uStack_14b = (undefined2)uVar15;
      uStack_149 = (undefined1)((ulong)uVar15 >> 0x10);
      uStack_148 = (undefined2)((ulong)uVar15 >> 0x18);
      uStack_146 = (undefined3)((ulong)uVar15 >> 0x28);
      uStack_153 = (undefined2)uVar12;
      uStack_151 = (undefined1)((ulong)uVar12 >> 0x10);
      uStack_150 = (undefined2)((ulong)uVar12 >> 0x18);
      uStack_14e = (undefined3)((ulong)uVar12 >> 0x28);
      FUN_0008304c(uVar13,&local_e0);
      FUN_000d1dfc(&local_b0);
      FUN_000d804c();
      lVar21 = FUN_000d1734(*(undefined8 *)(extraout_x8_14 + 0x388),plVar11,lVar14);
      FUN_000d03c0();
      FUN_000d0c98();
      if (lVar21 == 0) {
        FUN_000cff60(*plVar11,plVar11);
        FUN_000cfb64(*plVar11,plVar11,lVar14);
        uVar12 = extraout_x1_14;
      }
      else {
        FUN_000d7ff4(plVar11);
        cVar6 = FUN_00081374();
        auVar40 = FUN_000cfb64(*plVar11,plVar11,lVar14);
        uVar12 = auVar40._8_8_;
        if (cVar6 != '\0') {
          FUN_000d58f0(auVar40._0_8_,0xc);
          uVar12 = extraout_x1_12;
        }
      }
    }
  }
  if (*(char *)(param_5 + 0xd6) == '\0') goto LAB_000a1258;
  FUN_0006f178(&uStack_150);
  local_120 = &local_118;
  puStack_108 = &local_100;
  local_118 = 0;
  local_130 = 0;
  local_128 = 0;
  local_110 = 0;
  local_100 = 0;
  uStack_f8 = 0;
  uStack_158 = (undefined2)_DAT_000e8a70;
  uStack_156 = (undefined3)((ulong)_DAT_000e8a70 >> 0x10);
  uStack_153 = (undefined2)((ulong)_DAT_000e8a70 >> 0x28);
  uStack_151 = (undefined1)((ulong)_DAT_000e8a70 >> 0x38);
  local_f0 = 0;
  local_138 = &local_130;
  FUN_000a2288(&local_e0);
  FUN_00070ad0(&uStack_150,&local_e0);
  FUN_000d03b8();
  local_f0 = 0;
  FUN_000708e0(local_130);
  local_130 = 0;
  local_128 = 0;
  local_138 = &local_130;
  FUN_0006e06c(&local_e0,s_com_android_00015dfa);
  FUN_000d0648();
  uVar12 = FUN_000d03b8();
  FUN_000d128c(uVar12,s_com_qiku__000140f1);
  FUN_000d0648();
  uVar12 = FUN_000d03b8();
  FUN_000d128c(uVar12,s_com_miui__000156c3);
  FUN_000d0648();
  uVar12 = FUN_000d03b8();
  FUN_000d128c(uVar12,s_com_meizu__00015a93);
  FUN_000d0648();
  uVar12 = FUN_000d03b8();
  FUN_000d128c(uVar12,s_com_iflytek__00015be3);
  FUN_000d0648();
  uVar12 = FUN_000d03b8();
  FUN_000d128c(uVar12,s_com_sohu__000153f6);
  FUN_000d0648();
  uVar12 = FUN_000d03b8();
  FUN_000d128c(uVar12,s_com_qihoo_000158d6);
  FUN_000d0648();
  uVar12 = FUN_000d03b8();
  FUN_000d128c(uVar12,s_com_wandoujia__00013a55);
  FUN_000d0648();
  uVar12 = FUN_000d03b8();
  FUN_000d128c(uVar12,s_com_baidu__000138b2);
  FUN_000d0648();
  uVar12 = FUN_000d03b8();
  FUN_000d128c(uVar12,s_com_tencent__00013a64);
  FUN_000d0648();
  uVar12 = FUN_000d03b8();
  FUN_000d128c(uVar12,s_com_komoxo__000156cd);
  FUN_000d0648();
  uVar12 = FUN_000d03b8();
  FUN_000d128c(uVar12,s_com_gionee__00012f39);
  FUN_000d0648();
  uVar12 = FUN_000d03b8();
  FUN_000d128c(uVar12,s_com_samsung__0001353a);
  FUN_000d0648();
  uVar12 = FUN_000d03b8();
  FUN_000d128c(uVar12,s_com_pp_assistant_00013786);
  FUN_000d0648();
  uVar12 = FUN_000d03b8();
  FUN_000d128c(uVar12,s_com_sonymobile__0001457f);
  FUN_000d0648();
  uVar12 = FUN_000d03b8();
  FUN_000d128c(uVar12,s_com_singulariti__00013a71);
  FUN_000d0648();
  uVar12 = FUN_000d03b8();
  FUN_000d128c(uVar12,s_im_weshine__00015400);
  FUN_000d0648();
  uVar12 = FUN_000d03b8();
  FUN_000d128c(uVar12,s_com_yingyonghui_market_00015bf0);
  FUN_000d0648();
  uVar12 = FUN_000d03b8();
  FUN_000d128c(uVar12,s_com_amigo__000138bd);
  FUN_000d0648();
  uVar12 = FUN_000d03b8();
  FUN_000d128c(uVar12,s_com_google__00013ccf);
  FUN_000d0648();
  uVar12 = FUN_000d03b8();
  FUN_000d443c(uVar12,&DAT_0001b311);
  FUN_000d74d4();
  uVar12 = FUN_000d03b8();
  FUN_000d4f68(uVar12,&DAT_0001b32a);
  FUN_000d74d4();
  FUN_000d03b8();
  puVar24 = (undefined8 *)FUN_000d6ef4();
  local_160._0_1_ = (byte)puVar24;
  local_160._1_6_ = (undefined6)((ulong)puVar24 >> 8);
  local_160._7_1_ = (undefined1)((ulong)puVar24 >> 0x38);
  puVar23 = (undefined8 *)0x0;
  if (puVar24 == (undefined8 *)0x0) {
LAB_000a116c:
    if (local_128 != 0) {
      uVar33 = (ulong)&local_80 | 1;
      puVar24 = local_138;
      while (puVar24 != &local_130) {
        FUN_0004e08c(&local_e0,puVar24 + 4);
        if (local_f0 != 4) {
          FUN_000d1ccc();
          FUN_000d54d4(&local_120);
          uVar34 = FUN_000ae420();
          if ((uVar34 & 1) != 0) {
            FUN_000d0720(0x1b1b6);
            local_f0 = 3;
            FUN_000d7a6c(&local_b0,auStack_bc);
            FUN_000d8304(&local_80);
            FUN_000d2fe0();
            if ((extraout_x8_24 & 1) != 0) {
              uVar33 = extraout_x9_16;
            }
            uVar34 = (ulong)&local_e0 | 1;
            if ((local_e0 & 1) != 0) {
              uVar34 = CONCAT26(uStack_ca,uStack_d0);
            }
            FUN_000cfe20(uVar33,uVar34);
            FUN_000d0c98();
            puVar23 = (undefined8 *)FUN_000d03b8();
            break;
          }
        }
        FUN_000d03b8();
        puVar23 = (undefined8 *)FUN_000727e0(puVar24);
        puVar24 = puVar23;
      }
    }
  }
  else {
    FUN_000d443c(puVar24,&DAT_0001b298);
    uVar12 = FUN_000d2cb8(*puVar24);
    uVar15 = FUN_000d03b8();
    puVar23 = (undefined8 *)CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160));
    FUN_000d443c(uVar15,&DAT_0001b2b0);
    FUN_000d1ccc();
    FUN_0008aff4(&local_80,&DAT_0001b2c1);
    FUN_000d5cb0(*puVar23);
    uVar5 = (extraout_x9_12 & 1) == 0;
    lVar14 = FUN_000d264c(*(undefined8 *)(extraout_x8_15 + 0x108),puVar23,uVar12);
    FUN_000d0c98();
    FUN_000d03b8();
    puVar23 = (undefined8 *)CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160));
    if (lVar14 == 0) {
      FUN_000d4ca4();
      lVar14 = 0;
    }
    else {
      FUN_0008aff4(&local_e0,&DAT_0001b2e8);
      FUN_000d1ccc();
      uVar5 = (extraout_x8_16 & 1) == 0;
      FUN_0008aff4(&local_80,&DAT_0001b2fe);
      FUN_000d5cb0(*puVar23);
      uVar15 = FUN_000d46c4(puVar23);
      lVar21 = FUN_000d3100(uVar15,uVar12);
      FUN_000d0c98();
      FUN_000d03b8();
      puVar23 = (undefined8 *)CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160));
      if (lVar21 == 0) {
        FUN_000ae3ec();
        lVar14 = 0;
      }
      else {
        uVar15 = FUN_000d46bc(*puVar23,puVar23,uVar12,lVar21);
        lVar14 = FUN_00080334(CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160)),
                              CONCAT17(uStack_151,
                                       CONCAT25(uStack_153,CONCAT32(uStack_156,uStack_158))),lVar14,
                              uVar15);
        plVar11 = (long *)CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160));
        (**(code **)(*plVar11 + 0xb8))(plVar11,uVar15);
      }
    }
    puVar23 = (undefined8 *)CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160));
    puVar23 = (undefined8 *)FUN_000cfb64(*puVar23,puVar23,uVar12);
    if (lVar14 == 0) goto LAB_000a116c;
    puVar23 = (undefined8 *)CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160));
    uVar15 = FUN_000d045c(*puVar23,puVar23,lVar14);
    puVar23 = (undefined8 *)CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160));
    FUN_000d4f68(uVar15,&DAT_0001b1c2);
    uVar12 = FUN_000d1ccc();
    FUN_000d1b1c(uVar12,&DAT_0001b000);
    uVar12 = extraout_x10_05;
    if (!(bool)uVar5) {
      uVar12 = extraout_x9_13;
    }
    FUN_0008aff4(&local_80,extraout_x1_15 + 0x1cc);
    FUN_000d5cb0(*puVar23);
    uVar13 = FUN_000d2f60(*(undefined8 *)(extraout_x8_17 + 0x108));
    lVar21 = (*extraout_x8_18)(uVar13,uVar15,uVar12);
    FUN_000d0c98();
    FUN_000d03b8();
    uVar12 = CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160));
    if (lVar21 == 0) {
      FUN_000ae3ec(uVar12);
      bVar32 = false;
    }
    else {
      bVar7 = FUN_0007e5d8(uVar12,lVar14,lVar21);
      uVar33 = FUN_000d8320(CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160)));
      bVar32 = false;
      if ((bVar7 != 0) && ((uVar33 & 1) == 0)) {
        puVar23 = (undefined8 *)CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160));
        FUN_000d4f68(uVar33,&DAT_0001b1d0);
        uVar33 = (ulong)bVar7 | 1;
        lVar21 = FUN_000d2cb8(*puVar23);
        uVar12 = FUN_000d03b8();
        puVar23 = (undefined8 *)CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160));
        if (lVar21 == 0) {
          FUN_000d4ca4();
        }
        else {
          FUN_000d443c(uVar12,&DAT_0001b206);
          pcVar30 = s_0011111001111111111_00013ff0 + 0x10;
          FUN_000d46c4(*puVar23);
          if (!(bool)uVar5) {
            uVar33 = extraout_x10_06;
          }
          lVar25 = (*extraout_x8_19)(puVar23,lVar21,uVar33,pcVar30 + 0xbee);
          FUN_000d03b8();
          puVar23 = (undefined8 *)
                    CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160));
          if (lVar25 == 0) {
            FUN_000ae3ec();
            uVar9 = 0xffffffff;
          }
          else {
            iVar8 = FUN_000d7790(*puVar23,puVar23,lVar21,lVar25);
            plVar11 = (long *)CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160));
            FUN_0008aff4(&local_e0,&DAT_0001b217);
            FUN_000d1ccc();
            FUN_000d1308(&local_80);
            FUN_000d5b54();
            FUN_0008aff4(local_178,&DAT_0001b23a);
            FUN_000d0108();
            FUN_000d1308(&local_b0);
            FUN_0006e06c();
            uVar33 = (ulong)&local_e0 | 1;
            if ((local_80 & 1) != 0) {
              uVar33 = CONCAT44(uStack_6c,uStack_70);
            }
            uVar34 = (ulong)&local_b0 | 1;
            if ((local_b0 & 1) != 0) {
              uVar34 = local_a0;
            }
            uVar12 = (**(code **)(*plVar11 + 0x108))(plVar11,uVar15,uVar33,uVar34);
            if (iVar8 == -1) {
              lVar25 = FUN_00080334(plVar11,lVar14,uVar12);
            }
            else {
              lVar25 = FUN_00080334(plVar11,lVar14,uVar12,iVar8);
            }
            FUN_000d03c0();
            FUN_000cffb8();
            FUN_000d0c98();
            FUN_0004e170(&local_e0);
            uVar9 = 0;
            if (lVar25 != 0) {
              puVar23 = (undefined8 *)
                        CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160));
              uVar12 = FUN_000d045c(*puVar23,puVar23,lVar25);
              puVar23 = (undefined8 *)
                        CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160));
              FUN_0008aff4(&local_e0,&DAT_0001b24e);
              FUN_000d1ccc();
              uVar33 = (ulong)&local_e0 | 1;
              if ((extraout_x8_20 & 1) != 0) {
                uVar33 = extraout_x9_14;
              }
              FUN_0008aff4(local_178,&DAT_0001b253);
              FUN_000d7910(*puVar23);
              FUN_000d31fc();
              uVar16 = FUN_000d264c(puVar23,uVar12);
              FUN_000cffb8();
              uVar13 = FUN_000d03b8();
              puVar23 = (undefined8 *)
                        CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160));
              FUN_000d443c(uVar13,&DAT_0001b257);
              uVar13 = FUN_000d1ccc();
              FUN_000d6614(uVar13,&DAT_0001b25b);
              uVar13 = FUN_000d31fc(*puVar23,puVar23);
              uVar17 = (*extraout_x8_21)(uVar13,uVar12,uVar33);
              FUN_000cffb8();
              uVar13 = FUN_000d03b8();
              puVar23 = (undefined8 *)
                        CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160));
              FUN_000d443c(uVar13,&DAT_0001b271);
              uVar13 = FUN_000d1ccc();
              FUN_000d6614(uVar13,&DAT_0001b277);
              uVar13 = FUN_000d31fc(*puVar23,puVar23);
              lVar26 = FUN_000d264c(uVar13,lVar21);
              FUN_000cffb8();
              FUN_000d03b8();
              uVar13 = CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160));
              if (lVar26 == 0) {
                FUN_000ae3ec(uVar13);
                uVar9 = 0;
              }
              else {
                uVar9 = FUN_00087054(uVar13,lVar25,uVar16);
                for (uVar38 = 0; uVar38 != (uVar9 & ((int)uVar9 >> 0x1f ^ 0xffffffffU));
                    uVar38 = uVar38 + 1) {
                  lVar27 = FUN_00080334(CONCAT17(local_160._7_1_,
                                                 CONCAT61(local_160._1_6_,(byte)local_160)),lVar25,
                                        uVar17,uVar38);
                  if (lVar27 != 0) {
                    puVar23 = (undefined8 *)
                              CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160));
                    lVar28 = FUN_000d70a8(*puVar23,puVar23,lVar21,s_packageNames_00015279,
                                          s__Ljava_lang_String__00015a7f);
                    plVar11 = (long *)CONCAT17(local_160._7_1_,
                                               CONCAT61(local_160._1_6_,(byte)local_160));
                    if (lVar28 == 0) {
                      FUN_000d8320();
                      iVar8 = -1;
                    }
                    else {
                      lVar28 = (**(code **)(*plVar11 + 0x2f8))(plVar11,lVar27,lVar28);
                      if (lVar28 == 0) {
                        iVar8 = 0;
                      }
                      else {
                        puVar23 = (undefined8 *)
                                  CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160)
                                          );
                        iVar10 = FUN_000d077c(*puVar23,puVar23,lVar28);
                        iVar36 = 0;
                        iVar8 = -1;
                        while( true ) {
                          plVar11 = (long *)CONCAT17(local_160._7_1_,
                                                     CONCAT61(local_160._1_6_,(byte)local_160));
                          uVar5 = iVar36 < iVar10 && iVar8 == -1;
                          if (iVar36 >= iVar10 || iVar8 != -1) break;
                          lVar29 = (**(code **)(*plVar11 + 0x568))(plVar11,lVar28,iVar36);
                          if (lVar29 == 0) {
                            iVar8 = -1;
                          }
                          else {
                            FUN_000d0fbc(&local_e0,
                                         CONCAT17(local_160._7_1_,
                                                  CONCAT61(local_160._1_6_,(byte)local_160)),lVar29)
                            ;
                            FUN_000d04e0(local_e0 & 0xff);
                            if (extraout_x8_22 == 0) {
                              iVar8 = -1;
                            }
                            else {
                              FUN_000d1b28(&local_e0,&uStack_150);
                              iVar8 = 1;
                              if ((bool)uVar5) {
                                iVar8 = -1;
                              }
                            }
                            puVar23 = (undefined8 *)
                                      CONCAT17(local_160._7_1_,
                                               CONCAT61(local_160._1_6_,(byte)local_160));
                            FUN_000cfb64(*puVar23,puVar23,lVar29);
                            FUN_000d03b8();
                          }
                          iVar36 = iVar36 + 1;
                        }
                        (**(code **)(*plVar11 + 0xb8))(plVar11,lVar28);
                      }
                    }
                    lVar28 = FUN_00080334(CONCAT17(local_160._7_1_,
                                                   CONCAT61(local_160._1_6_,(byte)local_160)),lVar27
                                          ,lVar26);
                    if (lVar28 != 0) {
                      FUN_000d0fbc(&local_e0,
                                   CONCAT17(local_160._7_1_,
                                            CONCAT61(local_160._1_6_,(byte)local_160)),lVar28);
                      uVar33 = local_e0 >> 1 & 0x7f;
                      if ((local_e0 & 1) != 0) {
                        uVar33 = CONCAT26(uStack_d2,
                                          CONCAT24(uStack_d4,
                                                   CONCAT22(uStack_d6,CONCAT11(uStack_d7,uStack_d8))
                                                  ));
                      }
                      if (uVar33 != 0) {
                        uVar5 = iVar8 == 1;
                        if ((bool)uVar5) {
                          FUN_000d7e98();
                          FUN_000d27c8();
                          local_f0 = 4;
                          FUN_00073578(local_90,auStack_bc);
                          FUN_000d8304(local_178);
                          FUN_000d0108();
                          FUN_000d6624();
                          uVar13 = extraout_x8_23;
                          if (!(bool)uVar5) {
                            uVar13 = extraout_x9_15;
                          }
                          FUN_000d6f9c((ulong)&local_e0 | 1,uVar13,extraout_x1_16,0,0);
                          FUN_000cffb8();
                        }
                        else if (iVar8 == 0) {
                          uVar33 = (ulong)&local_e0 | 1;
                          if ((local_e0 & 1) != 0) {
                            uVar33 = CONCAT26(uStack_ca,uStack_d0);
                          }
                          uVar33 = FUN_000ae420(&puStack_108,uVar33);
                          if ((uVar33 & 1) == 0) {
                            FUN_000d7e98();
                          }
                        }
                      }
                      puVar23 = (undefined8 *)
                                CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160));
                      FUN_000cfb64(*puVar23,puVar23,lVar28);
                      FUN_000d03b8();
                    }
                    puVar23 = (undefined8 *)
                              CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160));
                    FUN_000cfb64(*puVar23,puVar23,lVar27);
                  }
                }
              }
              puVar23 = (undefined8 *)
                        CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160));
              FUN_000cfb64(*puVar23,puVar23,uVar12);
              puVar23 = (undefined8 *)
                        CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160));
              FUN_000cfb64(*puVar23,puVar23,lVar25);
            }
          }
          puVar23 = (undefined8 *)
                    CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160));
          FUN_000cfb64(*puVar23,puVar23,lVar21);
          if (uVar9 == 0) {
            local_f0 = 2;
            bVar32 = true;
            goto LAB_000a1148;
          }
        }
        bVar32 = false;
      }
    }
LAB_000a1148:
    puVar23 = (undefined8 *)CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160));
    FUN_000cfb64(*puVar23,puVar23,uVar15);
    puVar23 = (undefined8 *)CONCAT17(local_160._7_1_,CONCAT61(local_160._1_6_,(byte)local_160));
    puVar23 = (undefined8 *)FUN_000cfb64(*puVar23,puVar23,lVar14);
    if (!bVar32) goto LAB_000a116c;
  }
  if (local_f0 - 3U < 2) {
    FUN_000d58f0(puVar23,0xe);
  }
  FUN_000708e0(local_100);
  FUN_000708e0(local_118);
  FUN_000708e0(local_130);
  FUN_0004e170(&uStack_150);
  uVar12 = extraout_x1_17;
LAB_000a1258:
  if (*(char *)(param_5 + 0xda) != '\0') {
    auVar40 = FUN_000d8cb0(s_libnechecker_so_0001372e,2);
    uVar12 = auVar40._8_8_;
    if (auVar40._0_8_ != 0) {
      auVar40 = FUN_000d8cc0(auVar40._0_8_,s___gnu_thumb1_case_acc_00013897);
      uVar12 = auVar40._8_8_;
      if (auVar40._0_8_ != Reset) {
        (*auVar40._0_8_)();
        uVar12 = extraout_x1_18;
      }
    }
  }
  if (*(char *)(param_5 + 0xf7) != '\0') {
    auVar40 = FUN_000a1348();
    uVar12 = auVar40._8_8_;
    if ((auVar40._0_8_ & 1) != 0) {
      FUN_000d58f0(auVar40._0_8_,0x13);
      uVar12 = extraout_x1_19;
    }
  }
  if (*(char *)(param_5 + 0xf9) != '\0') {
    FUN_000d11a0(FUN_000cb5d4,uVar12,0xf);
    uVar12 = extraout_x1_20;
  }
  if (*(char *)(param_5 + 0xfe) != '\0') {
    FUN_000d5e7c(&DAT_000c8efc,uVar12,0x14,5,0xffffffff);
  }
  lVar14 = FUN_0008c920();
  auVar40 = FUN_0008c920();
  if ((*(long *)(lVar14 + 0x270) != *(long *)(lVar14 + 0x268)) ||
     (*(long *)(auVar40._0_8_ + 0x288) != *(long *)(auVar40._0_8_ + 0x280))) {
    FUN_000d5e7c(FUN_000cc740,auVar40._8_8_,0xd,2,0x96);
  }
  if (*(long *)(lVar3 + 0x28) != local_68) {
                    /* WARNING: Subroutine does not return */
    FUN_000d8770();
  }
  FUN_000cfdf0(uVar37);
  return;
}

