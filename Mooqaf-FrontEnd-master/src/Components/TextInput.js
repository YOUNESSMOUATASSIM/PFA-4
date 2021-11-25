import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import "../Icons/Shared.icons"
import "../Styles/TextInput.css"

function TextInput({ classes, icon, placeholder, type="text", value="", text="", onChange}) {
    return (
        <div className={"text-input-wrapper " + classes}>
            <div className="icon">
                <FontAwesomeIcon icon={icon} />
            </div>
            <div className="content">
                <input type={type} placeholder={placeholder} value={value} onChange={onChange}/>
            </div>
            <div className="text">
                {text}
            </div>
        </div>
    )
}

export default TextInput