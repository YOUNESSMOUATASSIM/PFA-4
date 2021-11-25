import HandHoldingDollar from '../SVGs/hand-holding-dollar.svg'
import times from '../SVGs/times.svg'
import { Modal } from 'react-bootstrap'
import '../Styles/AddPropositionModal.css'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import '../Icons/Shared.icons'
import TextInput from './TextInput'

function UpdatePropositionModal(props) {
    console.log(props.data.lable)
    return (
      <Modal
        {...props}
        size="lg"
        aria-labelledby="contained-modal-title-vcenter"
        centered
      >
        <div className="add-proposition-modal">
            <div className="header">
                <img className="icon" src={HandHoldingDollar} alt="hand-holding-usd"/>
                <span className="lable">{props.data.lable}</span>
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
            <div className="header">
              <FontAwesomeIcon icon="plus" />
              <span className="lable">PLACER UNE PROPOSITION</span>
            </div>
            <hr/>
            <div className="footer">
                <div className="inputs">
                    <TextInput classes="xs" icon="coins" placeholder="Prix" type="number" text="DH" />
                    <TextInput classes="md" icon="calendar-check" placeholder="Durée avant livraison." type="number" text="JOURS"/>
                </div>
                <div className="buttons">
                  <button className="button">Ajouter</button>
                  <button className="button">Réinitialiser</button>
                </div>
            </div>
        </div>
      </Modal>
    );
  }
export default UpdatePropositionModal