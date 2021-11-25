import HandHoldingDollar from '../SVGs/hand-holding-dollar.svg'
import edit from '../SVGs/edit.svg'
import trash from '../SVGs/trash.svg'
import times from '../SVGs/times.svg'
import { Modal, Button } from 'react-bootstrap'
import '../Styles/UpdateOfferModal.css'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import '../Icons/Shared.icons'
import TextInput from './TextInput'
import Select from './Select'
import Calendar from './DateSelector'
import TextArea from './TextArea'

function UpdateOfferModal(props) {
    console.log(props.data.lable)
    return (
      <Modal
        {...props}
        size="lg"
        aria-labelledby="contained-modal-title-vcenter"
        centered
      >
        <div className="update-offer-modal">
            <div className="header">
                <img className="icon" src={HandHoldingDollar} alt="hand-holding-usd"/>
                <span className="lable">Offre : {props.data.lable}</span>
                <img className="x" src={times} alt="times" onClick={props.onHide} />
            </div>
            <hr/>
            <div className="body">
                <TextInput icon="tag" placeholder="Titre de l'offre"/>
                <Select classes="md" icon="hammer" placeholder="Sélectionnez une spécialité"/>
                <Calendar classes="xs" icon="calendar-times" placeholder="01/07/2021"/>
                <TextArea placeholder="Description de l'offre"/>
                <div className="footer">
                    <button className="button">Mettre à jour</button>
                    <button className="button">Réinitialiser</button>
                </div>
            </div>
        </div>
      </Modal>
    );
  }
export default UpdateOfferModal