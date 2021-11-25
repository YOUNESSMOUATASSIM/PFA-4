import BreadCrumb from './BreadCrumb'
import { Container, Row, Col } from 'react-bootstrap'
import '../Styles/Dashboard.css'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import '../Icons/Shared.icons'
import axios from 'axios'
import { Component, useEffect, useState } from 'react'

class SmallListItem extends Component{
    constructor(props) {
        super(props)
        this.state = {
            proposition: this.props.proposition,
            appelOffre: [],
            user: {},
            ville: {},
            config: {
                headers: {
                    Authorization: "Bearer " + localStorage.getItem("token")
                }
            }
        }
    }

    componentDidMount = () => {
        let { proposition, config } = this.state

        axios(`/propositions/${proposition.id}/appelOffre`, config)
            .then(res => {
                let appelOffre = res.data
                axios(appelOffre["_links"].particulier.href, config)
                    .then(res => {
                        let user = res.data
                        axios(user["_links"].ville.href, config)
                            .then(res => {
                                let ville = res.data
                                this.setState({
                                    appelOffre,
                                    user,
                                    ville
                                })
                            })
                    })
            })
    }

    render () {

        let { appelOffre, proposition, user, ville, config } = this.state

        proposition = proposition == undefined ? {} : proposition
        appelOffre = appelOffre == undefined ? {} : appelOffre
        user = user == undefined ? {} : user
        ville = ville == undefined ? {} : ville
        return (
            <div className="small-list-item-border">
                <div className="content">
                    <div className="top">
                        <span className="title">{appelOffre.titre}</span>
                        <div className="middle">
                            <div className="user">
                                <span className="name">{user.nom + " " + user.prenom}</span>
                                <span className="city"><FontAwesomeIcon icon="map-marker-alt" /> {ville.nom}</span>
                            </div>
                            <span className="expire">Expire le: {new Date(appelOffre.dateExpiration).toLocaleDateString("fr-FR")}</span>
                        </div>
                    </div>
                    <div className="bottom">
                        <span className="price"><FontAwesomeIcon icon="coins" /> {proposition.prix} DH</span>
                        <span className="duration"><FontAwesomeIcon icon="calendar-check" /> {new Date(proposition.dateExpiration).toLocaleDateString("fr-FR")} JOUR </span>
                    </div>
                </div>
            </div>
        )
    }
}

class BigListItem extends Component{
    constructor(props) {
        super(props)
        this.state = {
            appelOffre: this.props.appelOffre,
            user: {},
            ville: {},
            config: {
                headers: {
                    Authorization: "Bearer " + localStorage.getItem("token")
                }
            }
        }
    }
    componentDidMount = () => {
        let {appelOffre, config} = this.state
        console.log("appelOffre", appelOffre)

        axios(appelOffre["_links"].particulier.href, config)
                    .then(res => {
                        let user = res.data
                        axios(user["_links"].ville.href, config)
                            .then(res => {
                                let ville = res.data
                                this.setState({
                                    user,
                                    ville
                                })
                            })
                    })
    }
    render(){
        let { appelOffre, user, ville } = this.state
        if (appelOffre == undefined || Object.keys(appelOffre).length === 0 || user == undefined || Object.keys(user).length === 0 || ville == undefined || Object.keys(ville).length === 0) {
            return <></>
        }
        return (
            <div className="big-list-item-border">
                <div className="content">
                    <div className="top">
                        <span className="title">{appelOffre.titre}</span>
                        <div className="middle">
                            <div className="user">
                                <span className="name">{user.nom + " " + user.prenom}</span>
                                <span className="city"><FontAwesomeIcon icon="map-marker-alt" /> {ville.nom}</span>
                            </div>
                            <span className="expire">Expire le: {new Date(appelOffre.dateExpiration).toLocaleDateString("fr-FR")}</span>
                        </div>
                    </div>
                </div>
                <hr/>
            </div>
        )
    }
}

function CardItem({icon, title, subTitle, value, date}){
    return (
        <div className="card-item">
            <div className="left">
                <FontAwesomeIcon className="icon" icon={icon} />
                <span className="title">{title}</span>
                <span className="sub-title">{subTitle}</span>
            </div>
            <div className="right">
                <span className="value">{value}</span>
                <span className="date">{date}</span>
            </div>
        </div>
    )
}

class Dashboard extends Component{
    constructor(props){
        super(props)
        this.state = {
            currentUser: {},
            propositons: [],
            appelOffres: [],
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
                let currentUser = res.data
                axios(`professionnels/${currentUser.id}/propositions`, config)
                    .then(res => {
                        let propositions = res.data["_embedded"].propositions
                        axios(`specialites/${currentUser.specialite.id}/appelOffres`, config)
                            .then(res => {
                                let appelOffres = res.data["_embedded"].appelOffres
                                this.setState({
                                    appelOffres,
                                    propositions,
                                    currentUser
                                })
                            })
                    })
            })

    }
    render() {
        let {propositions, appelOffres} = this.state
        propositions = propositions == undefined ? [] : propositions
        appelOffres = appelOffres == undefined ? [] : appelOffres
        return (
            <>
                <BreadCrumb crumbs={["Tableau de bord"]} />
                <div className="cont">
                    <div className="left-column">
                        <div className="cards-wrapper">
                            <CardItem icon="hand-holding-usd" title="Nombre de propositions" subTitle="Pour le dernier mois" value={propositions.length} date="15 mai - 15 juil" />
                            <CardItem icon="hand-holding-usd" title="Nombre de propositions" subTitle="Pour la dernière semaine" value={propositions.length} date="09 juin - 15 juin" />
                        </div>
                        <div className="list">
                            <div className="list-title">
                                OFFRES SUGGEREES POUR VOUS
                            </div>
                            <hr/>
                            <div className="big-list-items-wrapper">
                                {appelOffres.map((ao, idx) => (
                                    <BigListItem appelOffre={ao} />
                                ))}
                            </div>
                        </div>
                    </div>
                    <div className="right-column">
                        <div className="list-title">
                            VOS DERNIERES PROPOSITIONS
                        </div>
                        <hr/>
                        <div className="small-list-items-wrapper">
                            {propositions.map((p,idx) => {
                                return (
                                    <SmallListItem 
                                        proposition={p} />
                                )})}
                        </div>
                    </div>
                </div>
            </>
        )
    }
}

export default Dashboard;