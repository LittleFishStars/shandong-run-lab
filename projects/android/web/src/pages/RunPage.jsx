import React, { useEffect, useState } from 'react';
import { Button, Input } from '../ui';
import MapCanvas from '../MapCanvas';
import Joystick from '../Joystick';
import { fmtPaceShort } from '../format';

/* 跑步页：顶部「距离 / 计划距离 / 配速 / 实时配速」+ 全屏地图；下方摇杆或拖动提示；
   右下「结束」小圆钮 + 「摇杆/拖动」切换按钮（§4）+ 配速输入（回车生效，v2.1.0） */
export default function RunPage({ mapProps, walk, params, planDistance, actions, dragMode }) {
  // 配速输入只在回车时生效：草稿存在本地，回车才交给 actions.setPace
  const [paceDraft, setPaceDraft] = useState((params && params.pace) || '');
  useEffect(() => { setPaceDraft((params && params.pace) || ''); }, [params && params.pace]);
  const st = (walk && walk.state) || {};
  const dist = Number(st.dist_m) || 0;
  const dur = Number(st.elapsed_sec || st.move_sec) || 0;
  // 配速 = 用时 / 距离（平均配速，和记录页口径一致）；刚起步距离太小时不显示
  const pace = (dist > 5 && dur > 0) ? dur / (dist / 1000) : 0;
  // 实时配速 = 当前速度换算（1 km 需要多少秒）
  const speed = Number(st.speed_mps) || 0;
  const livePace = speed > 0.1 ? 1000 / speed : 0;


  return (
    <div className="run-layout">
      <div className="map-card"><MapCanvas {...mapProps} /></div>
      <aside className="side-panel">
        <div className="live-stats">
          <div className="live-line"><span>距离</span><b>{dist.toFixed(0)} m</b></div>
          <div className="live-line"><span>计划距离</span><b>{Math.round(Number(planDistance) || 0)} m</b></div>
          <div className="live-line"><span>配速</span><b>{pace ? fmtPaceShort(pace) : '--'}</b></div>
          <div className="live-line"><span>实时配速</span><b>{livePace ? fmtPaceShort(livePace) : '--'}</b></div>
        </div>
        <div className="run-ctl">
          {dragMode ? (
            <div className="drag-hint">拖动模式 · 单指在地图上按住拖动规划轨迹</div>
          ) : (
            <Joystick onMove={actions.joystick} onEnd={actions.joystickEnd} />
          )}
        </div>
        <div className="run-pace">
          <span>配速</span>
          <Input
            value={paceDraft}
            placeholder={'6\'40"'}
            onChange={(e) => setPaceDraft(e.target.value)}
            onPressEnter={() => setPaceDraft(actions.setPace(paceDraft) || paceDraft)}
          />
        </div>
        <div className="run-ctl-row">
          <Button
            type="primary"
            shape="circle"
            className="btn-end"
            disabled={!walk || !walk.running}
            onClick={actions.endRun}
          >
            结束
          </Button>
          <Button
            shape="circle"
            className={`btn-mode${dragMode ? ' active' : ''}`}
            onClick={() => actions.setDragMode(!dragMode)}
          >
            {dragMode ? '拖动' : '摇杆'}
          </Button>
        </div>
      </aside>
    </div>
  );
}