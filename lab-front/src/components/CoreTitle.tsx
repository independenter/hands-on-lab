import React, {Component} from "react";
import "../style/LabCore.scss"

class CoreTitle extends Component<any, any>{
  render() {
    return (
      <div className={"ant-row"} style={{height: "55px",boxShadow: "rgba(0, 0, 0, 0.1) 0px 2px 4px 0px",boxSizing: "border-box",marginBottom: "2px"}}>
          <div className={["ant-col","ant-col-8"].join(" ")} style={{padding: "16px 0px 0px 48px"}}>
            <img src="https://img.alicdn.com/tfs/TB1Ly5oS3HqK1RjSZFPXXcwapXa-238-54.png" alt={"加载失败"} style={{height: "25px", float: "left", marginRight: "24px"}}/>
            <img src="https://img.alicdn.com/tfs/TB1q9Ezpsieb18jSZFvXXaI3FXa-712-214.png" alt={"加载失败"} style={{height: "35px", float: "left", marginTop: "-5px", marginRight: "30px"}}/>
          </div>
          <div className="ant-col ant-col-8" style={{padding: "18px 0px 0px 48px"}}>
            <div className="links">
              <span><a href="/labCore">实验室首页</a></span>
              <span><a href="/labHome">实验列表</a></span>
              <span><a href="/bootstrap.html">Java工程脚手架</a></span>
            </div>
            <div className="ant-row ant-row-end" style={{marginTop: "16px"}}></div>
          </div>
      </div>
    );
  }
}

export default CoreTitle