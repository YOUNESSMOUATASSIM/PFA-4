import HandHoldingDollar from '../SVGs/hand-holding-dollar.svg'
import edit from '../SVGs/edit.svg'
import trash from '../SVGs/trash.svg'
import times from '../SVGs/times.svg'
import { Modal, Button } from 'react-bootstrap'
import '../Styles/ShowPropositionModal.css'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import '../Icons/Shared.icons'


function ShowPropositionModal(props) {
    console.log(props.data.lable)
    return (
      <Modal
        {...props}
        size="lg"
        aria-labelledby="contained-modal-title-vcenter"
        centered
      >
        <div className="show-proposition-modal">
            <div className="header">
                <img className="icon" src={HandHoldingDollar} alt="hand-holding-usd"/>
                <span className="lable">Proposition pour l’offre : {props.data.lable}</span>
                <img className="x" src={times} alt="times" onClick={props.onHide} />
            </div>
            <hr/>
            <div className="body">
                <div className="info">
                  <span className="name">{props.data.name}</span>
                  <span className="speciality"> <FontAwesomeIcon icon="hammer" /> {props.data.speciality}</span>
                  <span className="city"> <FontAwesomeIcon icon="map-marker-alt" /> {props.data.city}</span>
                  <span className="expire">Expire le: {props.data.expire}</span>
                </div>
                <span className="desc">{props.data.desc}</span>
            </div>
            <div className="footer">
                <div className="notif">
                  <span className="price" ><FontAwesomeIcon icon="coins" /> {props.data.price} DH</span>
                  <span className="duration" ><FontAwesomeIcon icon="calendar-check" /> {props.data.duration} JOURS</span>
                </div>
                <div className="icons">
                    <img className="trash" src={trash} alt="trash" />
                    <img className="edit" src={edit} alt="edit" onClick={props.handleUpdate}/>
                </div>
            </div>
        </div>
      </Modal>
    );
  }
export default ShowPropositionModal