package pl.dsyou.movierating.rating.domain;

import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Table;
import pl.dsyou.domaindrivendesign.annotation.AggregateRoot;
import pl.dsyou.domaindrivendesign.entity.AggregateRootAbstract;
import pl.dsyou.movierating.movie.domain.Movie;

import static pl.dsyou.movierating.rating.infrastructure.persistence.RatingTableNames.RATE;

@AggregateRoot
@Table(RATE)
@EqualsAndHashCode(callSuper = false)
public class Rate extends AggregateRootAbstract {
    @Id
    private long id;

    private AggregateReference<Movie, Long> movie;
    private float score;

    Rate(long movieId) {
        this.movie = AggregateReference.to(movieId);
        this.score = 0.00f;
    }

    Rate(long movieId, float score) {
        this.movie = AggregateReference.to(movieId);
        this.score = score;
    }

}
