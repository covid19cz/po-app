import { useState } from "react";

export function useToggler(defaultValue: boolean = false): [boolean, () => void, () => void] {
    const [toggled, setToggled] = useState<boolean>(defaultValue);

    function setToggledOn() {
        setToggled(true);
    }

    function setToggledOff() {
        setToggled(false);
    }

    return [toggled, setToggledOn, setToggledOff];
}
