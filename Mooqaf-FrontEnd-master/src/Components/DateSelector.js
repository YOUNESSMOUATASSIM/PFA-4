import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import "../Icons/Shared.icons"
import "../Styles/DateSelector.css"
import 'react-date-range/dist/styles.css'; // main style file
import 'react-date-range/dist/theme/default.css'; // theme css file
import { Calendar } from 'react-date-range';
import React, {useState} from 'react'

function DateSelector({ classes, icon, placeholder, onChange, value}) {
    // const [date, setDate] = useState(new Date())
    const [isToggled, setToggled] = useState(false)
    let calendarClasses = isToggled?"calendar-container active":"calendar-container"
    return (
        <div className={"calendar-wrapper " + classes}>
            <div className="icon">
                <FontAwesomeIcon icon={icon} />
            </div>
            <div className="content">
                <input placeholder={placeholder} value={new Date(value).toLocaleDateString('fr-FR')} onClick={() => setToggled(!isToggled)} />
            </div>
            <div className={calendarClasses}>
                <Calendar
                    date={new Date()}
                    onChange={onChange}
                />
            </div>
        </div>
    )
}

export default DateSelector