import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import "../Icons/Shared.icons"
import "../Styles/TextArea.css"

function TextInput({ placeholder, onChange, value="" }) {
    return (
        <div className="text-area-wrapper ">
            <div className="content">
                <textarea placeholder={placeholder} value={value} onChange={(v) => onChange(v.target.value)} />
            </div>
        </div>
    )
}

export default TextInput