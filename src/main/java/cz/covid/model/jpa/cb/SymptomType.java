package cz.covid.model.jpa.cb;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SYMPTOM_TYPE")
public class SymptomType extends CodebookValue {
}
