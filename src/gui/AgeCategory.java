package gui;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AgeCategory {
    final private int id;
    final private String text;

    @Override
    public String toString() {
        return text;
    }
}
