import BreadCrumb from './BreadCrumb'
import '../Styles/AddProposition.css'
import hammer from '../SVGs/hammer.svg'
import tag from '../SVGs/tag.svg'
import handHoldingUsd from '../SVGs/hand-holding-dollar.svg'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import '../Icons/Shared.icons'
import React from 'react'
import AddPropositionModal from './AddPropositionModal'

function ListItem({ lable, notif, name, speciality, city, desc, expire, handleClick }){
    return (
        <>
            <div className="list-item2" onClick={() => handleClick(lable, notif, name, speciality, city, desc, expire)}>
                <div className="title">
                    <div className="speciality">
                    </div>
                    <img src={hammer} alt="hammer" /> {speciality} <img src={tag} alt="hammer" /> <span className="lable">{lable}</span>
                    <span className="notif">{notif}</span>
                </div>
                <span className="desc">{desc}</span>
                <div className="bottom">
                    <div className="user">
                            <span className="name">{name}</span>
                            <span className="city"><FontAwesomeIcon icon="map-marker-alt" /> {city}</span>
                    </div>
                    <span className="expire">Expire le: {expire}</span>

                </div>
            </div>
            <hr/>
        </>
    )
}

function ManageOffers(){
    const [modalShow, setModalShow] = React.useState(false);
    const [data, setData] = React.useState({});

    const addProposition = (lable, notif, name, speciality, city, desc, expire) => {
        const data = {}
        data.lable = lable
        data.notif = notif
        data.name = name
        data.speciality = speciality
        data.city = city
        data.desc = desc
        data.expire = expire
        setData(data)
        setModalShow(true)
    }
    return (
        <>
            <BreadCrumb crumbs={["Tableau de bord", "Placer une proposition"]} />
            <div className="single-container">
                <div className="title">
                    <img src={handHoldingUsd} alt="hand-holding-usd"/> LISTE DES OFFRES
                </div>
                <hr/>
                <div className="list">
                    <ListItem 
                        handleClick={addProposition} 
                        lable="Changement des prises électriques pour une chambre et une cuisine."
                        notif="1"
                        name="Omar JIBAR"
                        speciality="Électricien"
                        city="Tétouan"
                        desc="Nisl, aliquam tincidunt non eros, sed diam habitant. In sed proin dolor, pellentesque est blandit nibh. Vehicula purus senectus cursus ac nec purus. Dignissim porttitor neque feugiat non eros, sed diam habitant. In sed proin dolor, pellentesque est blandit nibh. Vehicula purus senectus cursus ac nec purus. Dignissim porttitor neque feugiat venenatis mauris lacus porus."
                        expire="01/07/2021"
                    />
                    <ListItem 
                        handleClick={addProposition} 
                        lable="Changement des prises électriques pour une chambre et une cuisine."
                        notif="1"
                        name="Omar JIBAR"
                        speciality="Électricien"
                        city="Tétouan"
                        desc="Nisl, aliquam tincidunt non eros, sed diam habitant. In sed proin dolor, pellentesque est blandit nibh. Vehicula purus senectus cursus ac nec purus. Dignissim porttitor neque feugiat non eros, sed diam habitant. In sed proin dolor, pellentesque est blandit nibh. Vehicula purus senectus cursus ac nec purus. Dignissim porttitor neque feugiat venenatis mauris lacus porus."
                        expire="01/07/2021"
                    />
                </div>
            </div>
            <AddPropositionModal
                show={modalShow}
                onHide={() => setModalShow(false)}
                data={data}
            />
        </>
    )
}

export default ManageOffers