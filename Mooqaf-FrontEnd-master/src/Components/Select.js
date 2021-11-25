import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import "../Icons/Shared.icons"
import "../Styles/Select.css"
import AngleDown from '../SVGs/angle-down.svg'
import React,  { useState } from "react"

function Select({ classes, icon, value="", placeholder, list=[], onChange}) {
    let [isToggled, setToggled] = useState(false);

    let arr = ["omar", "khawla", "hamza"]
    let itemClasses = isToggled?"items active": "items"

    return (
        <div className={"select-wrapper " + classes}>
            <div className="icon">
                <FontAwesomeIcon icon={icon} />
            </div>
            <div className="content">
                <input placeholder={placeholder} onClick={()=> setToggled(!isToggled)} value={value} />
            </div>
            <img src={AngleDown} alt="angle" onClick={()=> setToggled(!isToggled)} />
            <div className={itemClasses}>
                {list != undefined && list.map(i => <div onClick={() => onChange(i)}>{i.value}</div>)}
            </div>
        </div>
    )
}

export default Select