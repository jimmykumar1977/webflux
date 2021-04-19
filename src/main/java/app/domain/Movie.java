package app.domain;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
