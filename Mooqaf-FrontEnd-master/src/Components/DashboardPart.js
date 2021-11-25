import BreadCrumb from './BreadCrumb'
import { Container, Row, Col } from 'react-bootstrap'
import '../Styles/Dashboard.css'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import '../Icons/Shared.icons'

function SmallListItem({title, name, speciality, expire, price, duration}){
    return (
        <div className="small-list-item-border">
            <div className="content">
                <div className="top">
                    <span className="title">{title}</span>
                    <div className="middle">
                        <div className="user">
                            <span className="name">{name}</span>
                            <span className="speciality"><FontAwesomeIcon icon="hammer" /> {speciality}</span>
                        </div>
                        <span className="expire">Expire le: {expire}</span>
                    </div>
                </div>
                <div className="bottom">
                    <span className="price"><FontAwesomeIcon icon="coins" /> {price} DH</span>
                    <span className="duration"><FontAwesomeIcon icon="calendar-check" /> {duration} JOUR </span>
                </div>
            </div>
        </div>
    )
}
function BigListItem({title, name, speciality, expire}){
    return (
        <div className="big-list-item-border">
            <div className="content">
                <div className="top">
                    <span className="title">{title}</span>
                    <div className="middle">
                        <div className="user">
                            {/* <span className="name">{name}</span> */}
                            <span className="speciality"><FontAwesomeIcon icon="hammer" /> {speciality}</span>
                        </div>
                        <span className="expire">Expire le: {expire}</span>
                    </div>
                </div>
            </div>
            <hr/>
        </div>
    )
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

function Dashboard(){
    return (
        <>
            <BreadCrumb crumbs={["Tableau de bord"]} />
            <div className="cont">
                <div className="left-column">
                    <div className="cards-wrapper">
                        <CardItem icon="hand-paper" title="Nombre d'offres" subTitle="Pour le dernier mois" value="5" date="15 mai - 15 juil" />
                        <CardItem icon="hand-paper" title="Nombre d'offres" subTitle="Pour la dernière semaine" value="1" date="09 juin - 15 juin" />
                    </div>
                    <div className="list">
                        <div className="list-title">
                            VOS DERNIERES OFFRES
                        </div>
                        <hr/>
                        <div className="big-list-items-wrapper">
                            <BigListItem 
                                title="Changement des prises électriques pour une chambre et une cuisine."
                                name="Omar JIBAR"
                                speciality="Électricien"
                                expire="01/07/2021"/>
                            <BigListItem 
                                title="Changement des prises électriques pour une chambre et une cuisine."
                                name="Omar JIBAR"
                                speciality="Électricien"
                                expire="01/07/2021"/>
                            <BigListItem 
                                title="Changement des prises électriques pour une chambre et une cuisine."
                                name="Omar JIBAR"
                                speciality="Électricien"
                                expire="01/07/2021"/>
                            <BigListItem 
                                title="Changement des prises électriques pour une chambre et une cuisine."
                                name="Omar JIBAR"
                                speciality="Électricien"
                                expire="01/07/2021"/>
                            <BigListItem 
                                title="Changement des prises électriques pour une chambre et une cuisine."
                                name="Omar JIBAR"
                                speciality="Électricien"
                                expire="01/07/2021"/>
                            <BigListItem 
                                title="Changement des prises électriques pour une chambre et une cuisine."
                                name="Omar JIBAR"
                                speciality="Électricien"
                                expire="01/07/2021"/>
                            <BigListItem 
                                title="Changement des prises électriques pour une chambre et une cuisine."
                                name="Omar JIBAR"
                                speciality="Électricien"
                                expire="01/07/2021"/>
                            <BigListItem 
                                title="Changement des prises électriques pour une chambre et une cuisine."
                                name="Omar JIBAR"
                                speciality="Électricien"
                                expire="01/07/2021"/>
                            <BigListItem 
                                title="Changement des prises électriques pour une chambre et une cuisine."
                                name="Omar JIBAR"
                                speciality="Électricien"
                                expire="01/07/2021"/>
                        </div>
                    </div>
                </div>
                <div className="right-column">
                    <div className="list-title">
                        DERNIERES PROPOSITONS POUR VOS OFFRES 
                    </div>
                    <hr/>
                    <div className="small-list-items-wrapper">
                        <SmallListItem  
                            title="Changement des prises électriques pour une chambre et une cuisine."
                            name="Omar JIBAR"
                            speciality="Électricien"
                            expire="01/07/2021"
                            price="200"
                            duration="1"/>
                        <SmallListItem  
                            title="Changement des prises électriques pour une chambre et une cuisine."
                            name="Omar JIBAR"
                            speciality="Électricien"
                            expire="01/07/2021"
                            price="200"
                            duration="1"/>
                        <SmallListItem  
                            title="Changement des prises électriques pour une chambre et une cuisine."
                            name="Omar JIBAR"
                            speciality="Électricien"
                            expire="01/07/2021"
                            price="200"
                            duration="1"/>
                        <SmallListItem  
                            title="Changement des prises électriques pour une chambre et une cuisine."
                            name="Omar JIBAR"
                            speciality="Électricien"
                            expire="01/07/2021"
                            price="200"
                            duration="1"/>
                        <SmallListItem  
                            title="Changement des prises électriques pour une chambre et une cuisine."
                            name="Omar JIBAR"
                            speciality="Électricien"
                            expire="01/07/2021"
                            price="200"
                            duration="1"/>
                        <SmallListItem  
                            title="Changement des prises électriques pour une chambre et une cuisine."
                            name="Omar JIBAR"
                            speciality="Électricien"
                            expire="01/07/2021"
                            price="200"
                            duration="1"/>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Dashboard;