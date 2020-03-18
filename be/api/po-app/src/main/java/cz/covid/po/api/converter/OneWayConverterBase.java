package cz.covid.po.api.converter;

import java.util.List;
import java.util.stream.Collectors;

public abstract class OneWayConverterBase<TSrc, TDest> {

    public TDest convert(TSrc src) {
        if (src == null) {
            return null;
        }
        return convertInternal(src);
    }

    public List<TDest> convert(List<TSrc> src) {
        if (src == null) {
            return null;
        }

        return src.stream().map(this::convert).collect(Collectors.toList());
    }

    protected abstract TDest convertInternal(TSrc src);
}
