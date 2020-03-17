package cz.covid.po.api.converter;

import java.util.List;
import java.util.stream.Collectors;

public abstract class TwoWayConverterBase<TSrc, TDest> {

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

    public TSrc convertBack(TDest src) {
        if (src == null) {
            return null;
        }
        return convertBackInternal(src);
    }

    protected abstract TDest convertInternal(TSrc src);

    protected abstract TSrc convertBackInternal(TDest src);
}
