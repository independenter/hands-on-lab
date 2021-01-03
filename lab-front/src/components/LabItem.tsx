import React,{Component} from "react";

class LabItem extends Component<any, any>{
  render() {
    return (
      <div className={"item"}>
        <span className="title">{ this.props.title }</span>
        <div className={"infos"}>
          <div className={"info"}>
            <img src={"https://img.alicdn.com/tfs/TB1_fWxNbr1gK0jSZFDXXb9yVXa-30-28.png"} alt={"加载失败"}/>
            <span>难度：{this.props.difficulty}</span>
          </div>
          <div className={"info"}>
            <img src={"https://img.alicdn.com/tfs/TB1gfkUdQ9l0K4jSZFKXXXFjpXa-28-28.png"} alt={"加载失败"}/>
            <span>预估需要时间：{this.props.time}</span>
          </div>
        </div>
        <span className="desc">{ this.props.desc }</span>
        <div className={["action",this.props.open?'':'action-pre'].join(' ')}>
          {this.props.open ? <span><a href={this.props.href} target="_blank" rel="noopener noreferrer" >开始实验 </a></span> : <span>敬请期待</span>}
        </div>
      </div>
    );
  }
}
export default LabItem;