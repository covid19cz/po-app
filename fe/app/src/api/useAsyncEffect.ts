import { DependencyList, useEffect } from "react";

export function useAsyncEffect(effect: () => Promise<void> | (() => Promise<void | undefined>), deps?: DependencyList) {
	useEffect(() => {
		effect();
	}, deps);
}
