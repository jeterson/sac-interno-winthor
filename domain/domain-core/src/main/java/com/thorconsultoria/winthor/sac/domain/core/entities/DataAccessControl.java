package com.thorconsultoria.winthor.sac.domain.core.entities;

import com.thorconsultoria.winthor.sac.domain.core.valueobjects.DataAccessControlTable;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class DataAccessControl {
    private List<String> alphaCode = new ArrayList<>();
    private List<Integer> numberCode = new ArrayList<>();
    private DataAccessControlTable table;
    private User user;

    public boolean isEmpty() {
        return alphaCode.isEmpty() || numberCode.isEmpty();
    }
    public boolean containsAlphaCodes() {
        return !alphaCode.isEmpty();
    }
    public boolean containsNumberCodes() {
        return !numberCode.isEmpty();
    }

    public List<Integer> getNumberCode() {
        if(numberCode == null)
            return new ArrayList<>();
        return numberCode.stream().filter(x -> x != 0).collect(Collectors.toList());
    }
    public boolean isAlphaValues() {
        return getNumberCode().isEmpty() && !getAlphaCode().isEmpty();
    }
    public boolean isNumberValues() {
        return !getNumberCode().isEmpty() && getAlphaCode().isEmpty();
    }
}
