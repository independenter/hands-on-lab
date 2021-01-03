import React, { Component } from 'react';

class LabTitle extends Component {
  render() {
    return (
      <div className={"row"} style={{overflow: "auto"}}>
        <span className="label">场景类型：</span>
        <div className="btn btn-selected"><span>全部</span></div>
        <div className="btn "><span>微服务</span></div>
        <div className="btn "><span>k8s</span></div>
      </div>
    );
  }
}
export default LabTitle