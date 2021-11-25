import BreadCrumb from './BreadCrumb'
import '../Styles/ManagePropositions.css'
import hammer from '../SVGs/hammer.svg'
import tag from '../SVGs/tag.svg'
import hand from '../SVGs/hand.svg'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import React from 'react'

import '../Icons/Shared.icons'
import ShowPropositionModal from './ShowPropositionModal'
import UpdatePropositionModal from './UpdatePropositionModal'

function ListItem({ lable, notif, name, speciality, city, desc, expire, price, duration, handleClick }){
    return (
        <>
            <div className="list-item3" onClick={() => handleClick(lable, notif, name, speciality, city, desc, expire, price, duration)}>
                <div className="left">
                    <div className="title">
                        <span className="notif">{notif}</span>
                        <span className="lable">{lable}</span>
                    </div>
                    <div className="speciality">
                        <img src={hammer} alt="hammer" /> {speciality}
                    </div>
                    <span className="desc">{desc}</span>
                    <span className="expire">Expire le: {expire}</span>
                </div>
                <div className="right">
                <span className="price"><FontAwesomeIcon icon="coins" /> {price} DH</span>
                    <span className="duration"><FontAwesomeIcon icon="calendar-check" /> {duration} JOUR </span>
                </div>
            </div>
            <hr/>
        </>
    )
}

function ManageOffers(){
    const [showModalShow, setShowModalShow] = React.useState(false);
    const [updateModalShow, setUpdateModalShow] = React.useState(false);
    const [data, setData] = React.useState({});

    const showProposition = (lable, notif, name, speciality, city, desc, expire, price, duration) => {
        const data = {}
        data.lable = lable
        data.notif = notif
        data.name = name
        data.speciality = speciality
        data.city = city
        data.desc = desc
        data.expire = expire
        data.price = price
        data.duration = duration
        setData(data)
        setShowModalShow(true)
    }
    const updateProposition = (data) =>{
        setData(data)
        setUpdateModalShow(true)
    }
    return (
        <>
            <BreadCrumb crumbs={["Tableau de bord", "Gérer les propositions"]} />
            <div className="single-container">
                <div className="title">
                    <img src={hand} alt="hand-paper"/> LISTE DES PROPOSITIONS
                </div>
                <hr/>
                <div className="list">
                    <ListItem 
                        handleClick={showProposition} 
                        lable="Changement des prises électriques pour une chambre et une cuisine."
                        notif="1"
                        city="Tétouan"
                        name="Omar JIBAR"
                        speciality="Électricien"
                        desc="Nisl, aliquam tincidunt non eros, sed diam habitant. In sed proin dolor, pellentesque est blandit nibh. Vehicula purus senectus cursus ac nec purus. Dignissim porttitor neque feugiat non eros, sed diam habitant. In sed proin dolor, pellentesque est blandit nibh. Vehicula purus senectus cursus ac nec purus. Dignissim porttitor neque feugiat venenatis mauris lacus porus."
                        expire="01/07/2021"
                        price="200"
                        duration="1"
                    />
                    <ListItem 
                        handleClick={showProposition} 
                        lable="Changement des prises électriques pour une chambre et une cuisine."
                        notif="2"
                        city="Tétouan"
                        name="Omar JIBAR"
                        speciality="Électricien"
                        desc="Nisl, aliquam tincidunt non eros, sed diam habitant. In sed proin dolor, pellentesque est blandit nibh. Vehicula purus senectus cursus ac nec purus. Dignissim porttitor neque feugiat non eros, sed diam habitant. In sed proin dolor, pellentesque est blandit nibh. Vehicula purus senectus cursus ac nec purus. Dignissim porttitor neque feugiat venenatis mauris lacus porus."
                        expire="01/07/2021"
                        price="200"
                        duration="1"
                    />
                    <ListItem 
                        handleClick={showProposition} 
                        lable="Changement des prises électriques pour une chambre et une cuisine."
                        notif="3"
                        city="Tétouan"
                        name="Omar JIBAR"
                        speciality="Électricien"
                        desc="Nisl, aliquam tincidunt non eros, sed diam habitant. In sed proin dolor, pellentesque est blandit nibh. Vehicula purus senectus cursus ac nec purus. Dignissim porttitor neque feugiat non eros, sed diam habitant. In sed proin dolor, pellentesque est blandit nibh. Vehicula purus senectus cursus ac nec purus. Dignissim porttitor neque feugiat venenatis mauris lacus porus."
                        expire="01/07/2021"
                        price="200"
                        duration="1"
                    />
                    <ListItem 
                        handleClick={showProposition} 
                        lable="Changement des prises électriques pour une chambre et une cuisine."
                        notif="4"
                        city="Tétouan"
                        name="Omar JIBAR"
                        speciality="Électricien"
                        desc="Nisl, aliquam tincidunt non eros, sed diam habitant. In sed proin dolor, pellentesque est blandit nibh. Vehicula purus senectus cursus ac nec purus. Dignissim porttitor neque feugiat non eros, sed diam habitant. In sed proin dolor, pellentesque est blandit nibh. Vehicula purus senectus cursus ac nec purus. Dignissim porttitor neque feugiat venenatis mauris lacus porus."
                        expire="01/07/2021"
                        price="200"
                        duration="1"
                    />
                    <ListItem 
                        handleClick={showProposition} 
                        lable="Changement des prises électriques pour une chambre et une cuisine."
                        notif="1"
                        city="Tétouan"
                        name="Omar JIBAR"
                        speciality="Électricien"
                        desc="Nisl, aliquam tincidunt non eros, sed diam habitant. In sed proin dolor, pellentesque est blandit nibh. Vehicula purus senectus cursus ac nec purus. Dignissim porttitor neque feugiat non eros, sed diam habitant. In sed proin dolor, pellentesque est blandit nibh. Vehicula purus senectus cursus ac nec purus. Dignissim porttitor neque feugiat venenatis mauris lacus porus."
                        expire="01/07/2021"
                        price="200"
                        duration="1"
                    />
                    <ListItem 
                        handleClick={showProposition} 
                        lable="Changement des prises électriques pour une chambre et une cuisine."
                        notif="1"
                        city="Tétouan"
                        name="Omar JIBAR"
                        speciality="Électricien"
                        desc="Nisl, aliquam tincidunt non eros, sed diam habitant. In sed proin dolor, pellentesque est blandit nibh. Vehicula purus senectus cursus ac nec purus. Dignissim porttitor neque feugiat non eros, sed diam habitant. In sed proin dolor, pellentesque est blandit nibh. Vehicula purus senectus cursus ac nec purus. Dignissim porttitor neque feugiat venenatis mauris lacus porus."
                        expire="01/07/2021"
                        price="200"
                        duration="1"
                    />
                    <ListItem 
                        handleClick={showProposition} 
                        lable="Changement des prises électriques pour une chambre et une cuisine."
                        notif="1"
                        city="Tétouan"
                        name="Omar JIBAR"
                        speciality="Électricien"
                        desc="Nisl, aliquam tincidunt non eros, sed diam habitant. In sed proin dolor, pellentesque est blandit nibh. Vehicula purus senectus cursus ac nec purus. Dignissim porttitor neque feugiat non eros, sed diam habitant. In sed proin dolor, pellentesque est blandit nibh. Vehicula purus senectus cursus ac nec purus. Dignissim porttitor neque feugiat venenatis mauris lacus porus."
                        expire="01/07/2021"
                        price="200"
                        duration="1"
                    />
                    <ListItem 
                        handleClick={showProposition} 
                        lable="Changement des prises électriques pour une chambre et une cuisine."
                        notif="1"
                        city="Tétouan"
                        name="Omar JIBAR"
                        speciality="Électricien"
                        desc="Nisl, aliquam tincidunt non eros, sed diam habitant. In sed proin dolor, pellentesque est blandit nibh. Vehicula purus senectus cursus ac nec purus. Dignissim porttitor neque feugiat non eros, sed diam habitant. In sed proin dolor, pellentesque est blandit nibh. Vehicula purus senectus cursus ac nec purus. Dignissim porttitor neque feugiat venenatis mauris lacus porus."
                        expire="01/07/2021"
                        price="200"
                        duration="1"
                    />
                    <ListItem 
                        handleClick={showProposition} 
                        lable="Changement des prises électriques pour une chambre et une cuisine."
                        notif="1"
                        city="Tétouan"
                        name="Omar JIBAR"
                        speciality="Électricien"
                        desc="Nisl, aliquam tincidunt non eros, sed diam habitant. In sed proin dolor, pellentesque est blandit nibh. Vehicula purus senectus cursus ac nec purus. Dignissim porttitor neque feugiat non eros, sed diam habitant. In sed proin dolor, pellentesque est blandit nibh. Vehicula purus senectus cursus ac nec purus. Dignissim porttitor neque feugiat venenatis mauris lacus porus."
                        expire="01/07/2021"
                        price="200"
                        duration="1"
                    />
                </div>
            </div>
            <ShowPropositionModal
                show={showModalShow}
                onHide={() => setShowModalShow(false)}
                handleUpdate={() => updateProposition(data)}
                data={data}
            />
            <UpdatePropositionModal
                show={updateModalShow}
                onHide={() => setUpdateModalShow(false)}
                data={data}
            />
        </>
    )
}

export default ManageOffers