import React, { useState, useEffect } from 'react'
import TextInput from './TextInput'
import Select from './Select'
import '../Styles/Auth.css'
import axios from 'axios'
import { useHistory } from 'react-router-dom'



function Auth({onUser, onAuth}) {
    const histo = useHistory()
    const [role, setRole] = useState(0)
    const [firstName, setFirstName] = useState("")
    const [lastName, setLastName] = useState("")
    const [speciality, setSpeciality] = useState({})
    const [spties, setSpties] = useState([])
    const [city, setCity] = useState({})
    const [number, setNumber] = useState("")
    const [password, setPassword] = useState("")
    const [num, setNum] = useState("")
    const [pass, setPass] = useState("")
    const [confirmPassword, setConfirmPassword] = useState("")
    console.log("heelo")
    const handleSignup = () => {
        let data = {
            prenom:firstName,
            nom:lastName,
            tel:number,
            ville:1,
            role:role==0?"PROFESSIONNEL":"PARTICULIER",
            password:password,
            specialite:1,
            confirmedPassword:confirmPassword
        }
        // console.log(data)
        axios.post("register", data)
        .then(res => {
            console.log(res)
        })
        .catch(err => {
            console.error(err)
        })
    }

    const handleLogin = () => {
        let data = {
            tel:num,
            password:pass
        }
        // console.log(data)
        axios.post("login", data)
        .then(res => {
            localStorage.setItem("token", res.headers.authorization)
            console.log(res.headers.authorization)
            let config = {
                headers: {
                    Authorization: "Bearer " + localStorage.getItem("token")
                }
            }
            axios.get("currentUser", config)
                .then(res => {
                    onUser(res.data)
                    onAuth(true)
                    histo.push(res.data.specialite==undefined?"/dashboard/part":"/dashboard/pro")
                })
                .catch(err => console.error(err))


        })
        .catch(err => {
            console.error(err)
        })
    }

    let proactive = role==0? "pro active" : "pro"
    let partactive = role == 1? "part active" : "part"
    return (
        <div className="auth-background">
            <div className="cont">
                <div className="register">
                    <div className="title">S’INSCRIRE</div>
                    <div className="sub-title">Inscrivez-vous gratuitement et trouvez plein d’offre correspondant à votre profil</div>
                    <div className="switch-container">
                        <div className="switch">
                            <div className={proactive} onClick={() => setRole(0)}>M3alem</div>
                            <div className={partactive} onClick={() => setRole(1)}>Particulier</div>
                        </div>
                    </div>
                    <TextInput classes="md" icon="user" placeholder="Nom" value={lastName} onChange={(v) => setLastName(v.target.value)}/>
                    <TextInput classes="md" icon="user" placeholder="Prenom" value={firstName} onChange={(v) => setFirstName(v.target.value)} />
                    {/* <Select classes="md" icon="hammer" placeholder="Sélectionner votre spécialité" list={spties} value={speciality!=undefined&&speciality.intitule} onChange={(v) => setSpeciality(v.target.value)} /> */}
                    {/* <Select classes="md" icon="map-marker-alt" placeholder="Sélectionner une ville" value={city} onChange={(v) => setCity(v.value)} /> */}
                    <TextInput classes="md" icon="phone-alt" placeholder="Numéro de téléphone" value={number} onChange={(v) => setNumber(v.target.value)} />
                    <TextInput classes="md" icon="lock" placeholder="Mot de passe" value={password} onChange={(v) => setPassword(v.target.value)}/>
                    <TextInput classes="md" icon="lock" placeholder="Confirmer le mot de passe" value={confirmPassword} onChange={(v) => setConfirmPassword(v.target.value)} />
                    <button className="button" onClick={handleSignup}>S'inscrire</button>
                </div>
                <div className="login">
                    <div className="title">SE CONNECTER</div>
                    <div className="sub-title">Plein d’offres/propositions vous attendent</div>
                    <TextInput classes="md" icon="phone-alt" placeholder="Numéro de téléphone" value={num} onChange={(v) => setNum(v.target.value)} />
                    <TextInput classes="md" icon="lock" placeholder="Mot de passe" value={pass} onChange={(v) => setPass(v.target.value)} />
                    <button className="button" onClick={handleLogin}>Se connecter</button>
                </div>
            </div>
        </div>
    )
}
export default Auth