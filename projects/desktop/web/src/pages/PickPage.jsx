import React from 'react';
import { Button } from 'antd';
import MapCanvas from '../MapCanvas';

export default function PickPage({ mapProps, actions }) {
  return (
    <div className="pick-page">
      <div className="pick-head">
        <span className="pick-title">选择起始点</span>
        <Button type="primary" onClick={actions.confirmPick}>确认</Button>
      </div>
      <div className="pick-map"><MapCanvas {...mapProps} /></div>
    </div>
  );
}
