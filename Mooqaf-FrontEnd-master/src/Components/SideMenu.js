import '../Styles/SideMenu.css'
import HandHoldingDollar from '../SVGs/hand-holding-dollar.svg'
import Hand from '../SVGs/hand.svg'
import HandHoldingDollarWhite from '../SVGs/hand-holding-dollar-white.svg'
import HandWhite from '../SVGs/hand-white.svg'
import AngleDown from '../SVGs/angle-down.svg'
import AngleDownWhite from '../SVGs/angle-down-white.svg'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import '../Icons/Menu.icons'
import { Link } from "react-router-dom"
import Chart from '../SVGs/chart.svg'
import { Component } from 'react'
import axios from 'axios'

class SideMenu extends Component{
    constructor(props){
        super(props)

        this.state = {
            currentUser: {},
            isToggled: this.props.isToggled,
            config: {
                headers: {
                    Authorization: "Bearer " + localStorage.getItem("token")
                }
            }
        }
    }
    componentDidMount = () => {
        let { config } = this.state
        axios("currentUser", config)
            .then(res => {
                console.log("res", res)
                this.setState({
                    currentUser: res.data
                })
            })
    }
    render() {
        let {isToggled, currentUser} = this.state
        let classes = isToggled?"SideMenu Toggled":"SideMenu";
        let buttons = undefined
        if (currentUser == undefined || Object.keys(currentUser).length === 0){
            return <></>
        } else if (currentUser.specialite != undefined){
            buttons = (
                <>
                    <li className="Main"><img className="icon" src={Hand} alt="hand"/>Proposition<img className="toggle" src={AngleDown} /></li>
                    <li className="Sub"><FontAwesomeIcon className="icon" icon="cog"/><Link to="/manage/propositions">Gérer les propositions</Link></li>
                    <li className="Sub"><FontAwesomeIcon className="icon" icon="plus"/><Link to="/manage/propositions/add">Placer une proposition</Link></li>
                </>
            )
        } else {
            buttons = (
                <>
                    <li className="Main"><img className="icon" src={HandHoldingDollar} alt="hand holding dollar"/>Offres<img className="toggle" src={AngleDown} /></li>
                    <li className="Sub"><FontAwesomeIcon className="icon" icon="cog"/><Link to="/manage/offers">Gérer les offres</Link></li>
                    <li className="Sub"><FontAwesomeIcon className="icon" icon="plus"/><Link to="/manage/offers/add">Placer une offre</Link></li>
                </>
            )

        }
        return (
            <div className={classes}>
                <ul>
                    <li className="Main"><img className="icon" src={Chart} alt="hand holding dollar"/><Link to="/dashboard/pro">Tableau de bord</Link></li>
                    {buttons}
                </ul>
            </div>
        )
    }
}
export default SideMenu