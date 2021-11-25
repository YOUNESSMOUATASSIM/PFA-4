import hammer from '../SVGs/hammer.svg'
import edit from '../SVGs/edit.svg'
import trash from '../SVGs/trash.svg'
import times from '../SVGs/times.svg'
import { Modal, Button } from 'react-bootstrap'
import '../Styles/ShowOfferModal.css'

function ShowOfferModal(props) {
    console.log(props.data.lable)
    return (
      <Modal
        {...props}
        size="lg"
        aria-labelledby="contained-modal-title-vcenter"
        centered
      >
        <div className="show-offer-modal">
            <div className="header">
                <span className="expire">Expire le: {props.data.expire}</span>
                <img className="x" src={times} alt="times" onClick={props.onHide} />
            </div>
            <div className="body">
                <span className="lable">{props.data.lable}</span>
                <span className="speciality"><img src={hammer} alt="hammer" /> {props.data.speciality}</span>
                <span className="desc">{props.data.desc}</span>
            </div>
            <div className="footer">
                <div className="notif">Consulter les propositions <div>{props.data.notif}</div></div>
                <div className="icons">
                    <img className="trash" src={trash} alt="trash" />
                    <img className="edit" src={edit} alt="edit" onClick={props.handleUpdate}/>
                </div>
            </div>
        </div>
      </Modal>
    );
  }
export default ShowOfferModal