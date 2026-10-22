
int FUN_00178f70(undefined8 param_1,int param_2)

{
  uint uVar1;
  long lVar2;
  undefined *puVar3;
  long *plVar4;
  uint *puVar5;
  long lVar6;
  ulong uVar7;
  int iVar8;
  ulong uVar9;
  uint uVar10;
  ulong uVar11;
  ulong uVar12;
  byte *pbVar13;
  byte local_88 [8];
  ulong local_80;
  byte *local_78;
  undefined8 local_70;
  undefined8 local_68;
  ulong local_60 [4];
  
  lVar2 = tpidr_el0;
  local_60[3] = *(long *)(lVar2 + 0x28);
  local_60[0] = 0;
  local_60[1] = 0;
  local_60[2] = 0;
  local_70 = 0;
  local_68 = 0;
  if (param_2 == -10) {
    FUN_00473cdc(local_88,0xfffffff6);
    uVar9 = (ulong)(local_88[0] >> 1);
    pbVar13 = (byte *)((ulong)local_88 | 1);
    if ((local_88[0] & 1) != 0) {
      uVar9 = local_80;
      pbVar13 = local_78;
    }
    FUN_001239d0(local_60,pbVar13,uVar9);
  }
  else if (param_2 == 0) {
    FUN_00473cdc(local_88,0);
    uVar9 = (ulong)(local_88[0] >> 1);
    pbVar13 = (byte *)((ulong)local_88 | 1);
    if ((local_88[0] & 1) != 0) {
      uVar9 = local_80;
      pbVar13 = local_78;
    }
    FUN_001239d0(local_60,pbVar13,uVar9);
  }
  else {
    if (param_2 != -1) goto LAB_00179080;
    plVar4 = (long *)FUN_003758ac();
    (**(code **)(*plVar4 + 0x90))(plVar4,&local_68,&local_70);
    FUN_00474064(local_88,local_68);
    uVar9 = (ulong)(local_88[0] >> 1);
    pbVar13 = (byte *)((ulong)local_88 | 1);
    if ((local_88[0] & 1) != 0) {
      uVar9 = local_80;
      pbVar13 = local_78;
    }
    FUN_001239d0(local_60,pbVar13,uVar9);
  }
  if ((local_88[0] & 1) != 0) {
    FUN_00478110(local_78);
  }
LAB_00179080:
  plVar4 = (long *)FUN_003758ac();
  (**(code **)(*plVar4 + 0x40))();
  FUN_00473ea0(local_88);
  uVar9 = (ulong)(local_88[0] >> 1);
  pbVar13 = (byte *)((ulong)local_88 | 1);
  if ((local_88[0] & 1) != 0) {
    uVar9 = local_80;
    pbVar13 = local_78;
  }
  FUN_001239d0(local_60,pbVar13,uVar9);
  if ((local_88[0] & 1) != 0) {
    FUN_00478110(local_78);
  }
  FUN_00347394(local_88,local_60);
  uVar9 = (ulong)(local_88[0] >> 1);
  pbVar13 = (byte *)((ulong)local_88 | 1);
  if ((local_88[0] & 1) != 0) {
    uVar9 = local_80;
    pbVar13 = local_78;
  }
  puVar5 = (uint *)FUN_004780a8(0xc);
  puVar3 = PTR_DAT_00577ea0;
  lVar6 = *(long *)PTR_DAT_00577ea0;
  *(undefined8 *)puVar5 = DAT_00492888;
  puVar5[2] = 0x473b1fd4;
  lVar6 = (**(code **)(lVar6 + 0x160))(0x400);
  if (lVar6 == 0) {
    iVar8 = 0;
  }
  else {
    uVar7 = 0;
    do {
      iVar8 = 8;
      uVar11 = uVar7 & 0xffffffff;
      do {
        uVar12 = uVar11 >> 1;
        if ((uVar11 & 1) != 0) {
          uVar12 = (ulong)(*puVar5 ^ (uint)uVar12);
        }
        iVar8 = iVar8 + -1;
        uVar11 = uVar12;
      } while (iVar8 != 0);
      *(int *)(lVar6 + uVar7 * 4) = (int)uVar12;
      uVar7 = uVar7 + 1;
    } while (uVar7 != 0x100);
    if ((int)uVar9 < 1) {
      uVar10 = 0;
    }
    else {
      uVar9 = uVar9 & 0xffffffff;
      uVar10 = 0xffffffff;
      do {
        uVar9 = uVar9 - 1;
        uVar10 = (*(uint *)(lVar6 + (ulong)(uVar10 & 0xff ^ (uint)*pbVar13) * 4) ^ uVar10 >> 8) +
                 puVar5[1];
        pbVar13 = pbVar13 + 1;
      } while (uVar9 != 0);
      uVar10 = ~uVar10;
    }
    uVar1 = puVar5[2];
    (**(code **)(*(long *)puVar3 + 0x168))();
    iVar8 = uVar1 + uVar10;
  }
  FUN_00478110(puVar5);
  if ((local_88[0] & 1) != 0) {
    FUN_00478110(local_78);
  }
  if ((local_60[0] & 1) != 0) {
    FUN_00478110(local_60[2]);
  }
  if (*(long *)(lVar2 + 0x28) != local_60[3]) {
                    /* WARNING: Subroutine does not return */
    __stack_chk_fail();
  }
  return iVar8;
}

