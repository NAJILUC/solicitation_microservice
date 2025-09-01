package co.com.pragma.model.utils;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BasicLongSet {
    private Set<Long> ids;
}
