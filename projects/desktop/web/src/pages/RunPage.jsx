import React from 'react';
import { Button } from 'antd';
import MapCanvas from '../MapCanvas';
import Joystick from '../Joystick';
import { fmtPaceShort } from '../format';

export default function RunPage({ mapProps, walk, planDistance, actions }) {
  const st = (walk && walk.state) || {};
  const dist = Number(st.dist_m) || 0;
  const dur = Number(st.elapsed_sec || st.move_sec) || 0;
  const speed = Number(st.speed_mps) || 0;
  // 配速优先用当前速度（跑起来才准）；没速度时再退回全程平均，避免刚起步显示 70 多分钟
  const pace = speed > 0.1 ? 1000 / speed : (dist > 0 ? dur / (dist / 1000) : 0);
  return (
    <div className="run-layout">
      <div className="map-card"><MapCanvas {...mapProps} /></div>
      <aside className="side-panel">
        <div className="live-stats">
          <div className="live-line"><span>距离</span><b>{dist.toFixed(0)} m</b></div>
          <div className="live-line"><span>配速</span><b>{pace ? fmtPaceShort(pace) : '--'}</b></div>
          <div className="live-line"><span>计划距离</span><b>{Math.round(Number(planDistance) || 0)} m</b></div>
        </div>
        <div className="run-ctl">
          <Joystick onMove={actions.joystick} onEnd={actions.joystickEnd} />
        </div>
        <Button
          type="primary"
          shape="circle"
          className="btn-end"
          disabled={!walk || !walk.running}
          onClick={actions.endRun}
        >
          结束
        </Button>
      </aside>
    </div>
  );
}
