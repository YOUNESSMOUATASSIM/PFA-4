import React from 'react'
import './App.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import SideMenu from './Components/SideMenu'
import TopMenu from './Components/TopMenu'
import DashboardPart from './Components/DashboardPart'
import DashboardPro from './Components/DashboardPro'
import ManageOffers from './Components/ManageOffers'
import AddProposition from './Components/AddProposition'
import ManagePropositions from './Components/ManagePropositions'
import AddOffer from './Components/AddOffer'
import Auth from './Components/Auth'
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link,
  useHistory
} from "react-router-dom";
import axios from 'axios'



class App extends React.Component {
  constructor(props){
    super(props)
    
    this.state = {
      user: {},
      specialities: {},
      cities: {},
      currentUser: {},
      isAuthenticated: false,
      isToggled: true
    }
  }

  componentDidUpdate(prevProps, prevStat){
    if (Object.keys(prevStat.user) === 0){
      let config = {
        headers: {
          authorization : localStorage.getItem("token")
        }
      }
      let appelOffres = axios.get("appelOffres", config)
      let propositions = axios.get("propositions", config)
      let specialites = axios.get("specialites", config)
      let villes = axios.get("villes", config)

      console.log("appelOffres", appelOffres)
      console.log("propositions", propositions)
      console.log("specialites", specialites)
      console.log("villes", villes)

    }
  }

  ToggleMenu = () => {
    this.setState({
      isToggled: !this.state.isToggled
    })
  }

  render(){
    let { isAuthenticated, isToggled } = this.state
    let classes = isAuthenticated?isToggled? "Master Toggled" : "Master NotToggled" : "Master"
    return (
      <div className="App">
        <Router>
          <TopMenu isToggled={isToggled}  isAuthenticated={isAuthenticated} onToggleMenu={this.ToggleMenu} />
          {isAuthenticated
            ? <SideMenu isToggled={isToggled} />
            : null
          }
          <div className={classes}>
            <Switch>
              <Route path="/login">
                <Auth onUser={(user) => this.setState({user: user})} onAuth={(auth) => this.setState({isAuthenticated: auth})} />
              </Route>
              <Route path="/dashboard/pro">
                <DashboardPro user={this.state.user} />
              </Route>
              <Route path="/dashboard/part">
                <DashboardPart user={this.state.user} />
              </Route>
              <Route path="/manage/offers/add">
                <AddOffer user={this.state.user} />
              </Route>
              <Route path="/manage/offers">
                <ManageOffers user={this.state.user} />
              </Route>
              <Route path="/manage/propositions/add">
                <AddProposition user={this.state.user} />
              </Route>
              <Route path="/manage/propositions">
                <ManagePropositions user={this.state.user} />
              </Route>
            </Switch>
          </div>
        </Router>
        
      </div>
    );
  }
}

export default App;
