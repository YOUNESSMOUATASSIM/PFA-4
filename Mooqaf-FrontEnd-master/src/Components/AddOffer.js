import BreadCrumb from './BreadCrumb'
import '../Styles/AddOffer.css'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import TextInput from './TextInput'
import TextArea from './TextArea'
import Select from './Select'
import Calendar from './DateSelector'
import { Component } from 'react'
import axios from 'axios'

class AddOffer extends Component{
    constructor(props) {
        super(props)

        this.state = {
            titre: "",
            specialites: [],
            specialite: {},
            dateExpiration: new Date(),
            description: "",
            config: {
                headers: {
                    Authorization: "Bearer " + localStorage.getItem("token")
                }
            }
        }
    }
    componentDidMount= ()=> {
        let {config} = this.state
        axios("specialites", config)
            .then(res => {
                let specialites = res.data["_embedded"].specialites
                this.setState({
                    specialites
                })
            })
    }
    handleAdd = () => {
        let { config, titre, specialite, dateExpiration, description } = this.state
        let data = {
            titre,
            specialite,
            dateExpiration,
            description
        }
        console.log(data)
        axios.post("addAppelOffre", data, config)
            .then(res => console.log(res))
    }
    handleReset = () => {
        this.setState({
            titre: "",
            specialite: {},
            dateExpiration: new Date(),
            description: "",
        })
    }
    render() {
        let {specialites, specialite, titre, dateExpiration, description} = this.state
        if (specialites == undefined){
            return <></>
        }
        return (
            <>
                <BreadCrumb crumbs={["Tableau de bord", "Placer une offre"]} />
                <div className="single-container">
                    <div className="title">
                        <FontAwesomeIcon icon="plus" /> PLACER UNE OFFRE
                    </div>
                    <hr/>
                    <div className="form">
                        <TextInput icon="tag" placeholder="Titre de l'offre" value={titre} onChange={(v) => this.setState({titre: v.target.value})} />
                        <Select classes="md" icon="hammer" placeholder="Sélectionnez une spécialité" value={specialite.value} list={specialites.map(s=> ({id:s.id, value: s.intitule}))} onChange={(v) => this.setState({specialite: v})}/>
                        <Calendar classes="xs" icon="calendar-times" placeholder="01/07/2021" value={new Date(dateExpiration)} onChange={(v) => this.setState({dateExpiration: v})}/>
                        <TextArea placeholder="Description de l'offre" value={description} onChange={(v) => this.setState({description: v})}/>
                        <div className="form-footer">
                            <button className="button" onClick={this.handleAdd}>Ajouter</button>
                            <button className="button" onClick={this.handleReset}>Réinitialiser</button>
                        </div>
                    </div>
                </div>
            </>
        )
    }
}

export default AddOffer