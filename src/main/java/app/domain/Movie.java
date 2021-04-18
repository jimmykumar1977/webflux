package app.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Document
@Data
@AllArgsConstructor
public class Movie {

    @NonNull
    private String id;

    @NonNull
    private String title;

    private int year;
}
