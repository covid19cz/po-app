import { useParams } from "react-router-dom";
import { PathParameterNames } from "../components/Routes";

interface PathParams extends Partial<Record<PathParameterNames, any>> {
  patientId?: string;
}

export function usePathParams(): PathParams {
  const { patientId } = useParams();

  return {
    patientId
  };
}
