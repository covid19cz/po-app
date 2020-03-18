package cz.covid.po.api.bl.service;

import cz.covid.po.api.domain.model.codebook.CodebookItemBase;
import java.util.List;

public interface CodebookService {
    List<CodebookItemBase> getCodebookItems(String codebook);
}
