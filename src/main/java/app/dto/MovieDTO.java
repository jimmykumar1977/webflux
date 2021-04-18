package app.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO implements Serializable {
    private String title;
    private int year;
}
