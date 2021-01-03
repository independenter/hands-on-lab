import './App.scss';
import React,{ Component } from 'react';
import { BrowserRouter as Router,Route} from 'react-router-dom';

import LabHome from "./views/LabHome";
import CoreTitle from "./components/CoreTitle";
import CoreMain from "./components/CoreMain";

import labHome from './style/LabHome.scss'

class App extends Component{
  render() {
    return (
      <Router >
        <Route path="/LabHome" className={"labHome"} component={ LabHome } />
        <Route path="/LabCore" className={"labCore"} component={ CoreTitle } />
        <Route path="/LabCore" className={"labCore"}  component={ CoreMain } />
      </Router>
    )
  }
}

export default App;
