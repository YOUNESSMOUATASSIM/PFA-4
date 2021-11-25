import BreadCrumb from './BreadCrumb'
import '../Styles/ManageOffers.css'
import hammer from '../SVGs/hammer.svg'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import React from 'react'
import ShowOfferModal from './ShowOfferModal'
import UpdateOfferModal from './UpdateOfferModal'

function ListItem({ lable, notif, speciality, desc, expire, handleClick }){
    
    return (
        <>
            <div className="list-item" onClick={() => handleClick(lable, notif, speciality, desc, expire)}>
                <div className="title">
                    <span className="lable">{lable}</span>
                    <span className="notif">{notif}</span>
                </div>
                <div className="speciality">
                    <img src={hammer} alt="hammer" /> {speciality}
                </div>
                <span className="desc">{desc}</span>
                <span className="expire">Expire le: {expire}</span>
            </div>
            <hr/>
        </>
    )
}

function ManageOffers(){
    const [showModalShow, setShowModalShow] = React.useState(false);
    const [updateModalShow, setUpdateModalShow] = React.useState(false);
    const [data, setData] = React.useState({});

    const showOffer = (lable, notif, speciality, desc, expire) => {
        const data = {}
        data.lable = lable
        data.notif = notif
        data.speciality = speciality
        data.desc = desc
        data.expire = expire
        setData(data)
        setShowModalShow(true)
    }
    const updateOffer = (data) => {
        setData(data)
        setUpdateModalShow(true)
    }

    return (
        <>
            <BreadCrumb crumbs={["Tableau de bord", "Gérer les offres"]} />
            <div className="single-container">
                <div className="title">
                    <FontAwesomeIcon icon="cog" /> LISTE DES OFFRES
                </div>
                <hr/>
                <div className="list">
                    <ListItem 
                        handleClick={showOffer}
                        lable="Changement des prises électriques pour une chambre et une cuisine."
                        notif="1"
                        speciality="Électricien"
                        desc="Nisl, aliquam tincidunt non eros, sed diam habitant. In sed proin dolor, pellentesque est blandit nibh. Vehicula purus senectus cursus ac nec purus. Dignissim porttitor neque feugiat non eros, sed diam habitant. In sed proin dolor, pellentesque est blandit nibh. Vehicula purus senectus cursus ac nec purus. Dignissim porttitor neque feugiat venenatis mauris lacus porus."
                        expire="01/07/2021"
                        />
                    <ListItem 
                        handleClick={showOffer}
                        lable="Changement des prises électriques pour une chambre et une cuisine."
                        notif="2"
                        speciality="Électricien"
                        desc="Nisl, aliquam tincidunt non eros, sed diam habitant. In sed proin dolor, pellentesque est blandit nibh. Vehicula purus senectus cursus ac nec purus. Dignissim porttitor neque feugiat non eros, sed diam habitant. In sed proin dolor, pellentesque est blandit nibh. Vehicula purus senectus cursus ac nec purus. Dignissim porttitor neque feugiat venenatis mauris lacus porus."
                        expire="01/07/2021"
                    />
                </div>
            </div>
            <ShowOfferModal
                show={showModalShow}
                onHide={() => setShowModalShow(false)}
                handleUpdate={() => updateOffer(data)}
                data={data}
            />
            <UpdateOfferModal
                show={updateModalShow}
                onHide={() => setUpdateModalShow(false)}
                data={data}
            />
        </>
    )
}

export default ManageOffers