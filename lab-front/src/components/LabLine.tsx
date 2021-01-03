import React,{Component} from "react";
import HttpUtil from "../util/HttpUtil";

class LabLine extends Component<any, any>{
  constructor(props: any) {
    super(props);
    this.state = {
      num: 0,
      tables: []
    }
  }

  componentDidMount() {
    HttpUtil.request({
      url: '/lab',
      success: data => {
        this.setState({
          num: data.length
        })
      }
    })
  }

  render() {
    return (
        <div className={"row"}>
          <span className="sum">当前共有 {this.state.num} 个实验场景</span>
        </div>
    );
  }
}

export default LabLine