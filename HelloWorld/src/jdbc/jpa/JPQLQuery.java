package jdbc.jpa;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jdbc.jpa.entity.Artist;
import org.hibernate.engine.spi.PersistenceContext;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JPQLQuery {
    public static void main(String[] args) {
        List<Artist> artists = null;
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "jdbc.jpa");
             EntityManager em = emf.createEntityManager();
        ) {
            var transaction = em.getTransaction();
            transaction.begin();
            artists = getArtistJPQL(em, "Greatest Hits%");
            artists.forEach(System.out::println);
            System.out.println("-----------------------------");
            Stream<Artist> sartists = getArtistBuilder(em, "Bl%");
            var map = sartists.limit(10)
                    .collect(
                            Collectors.toMap(
                                    Artist::getArtistName,
                                    (a) -> a.getAlbums().size(),
                                    Integer::sum,
                                    TreeMap::new
                            )
                    );

            map.forEach((k, v) -> System.out.println(k + " : " + v ));

            System.out.println("-----------------------------");
            Stream<Artist> sqlartists = getArtistBuilder(em, "Bl%");
            var mapSql = sartists.limit(10)
                    .collect(
                            Collectors.toMap(
                                    Artist::getArtistName,
                                    (a) -> a.getAlbums().size(),
                                    Integer::sum,
                                    TreeMap::new
                            )
                    );

            mapSql.forEach((k, v) -> System.out.println(k + " : " + v ));
//            var names = getArtistNames(em,"%Stev%");
//            names
//                    .map( a -> new Artist(
//                            a.get("id", Integer.class),
//                            (String) a.get("name")))
//                            .forEach(System.out::println);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static List<Artist> getArtistJPQL(EntityManager em, String matchedValue) {
     //   String jpql = "SELECT a FROM Artist a WHERE a.artistName LIKE :partialName"; // we can replace :partialName with ?1

      String jpql = "SELECT a From Artist a JOIN a.albums album " +
              "WHERE album.albumName LIKE ?1 OR album.albumName LIKE ?2";
        var query = em.createQuery(jpql, Artist.class);
        query.setParameter(1, matchedValue);
        query.setParameter(2, "%Best of%");// we can replace query.setParameter(1, matchedValue);
        return query.getResultList();
    }

    private static Stream<Tuple> getArtistNames(EntityManager em, String matchedValue) {
        String jpql = "SELECT a.artistId id, a.artistName as name FROM Artist a " +
                "WHERE a.artistName LIKE ?1"; // can replace query ?1
        var query = em.createQuery(jpql, Tuple.class);
        query.setParameter(1, matchedValue);
        return query.getResultStream();
    }


    private static Stream<Artist> getArtistBuilder(EntityManager em,
                                                   String matchedValue){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Artist> criteriaQuery = builder.createQuery(Artist.class);
        Root<Artist> root = criteriaQuery.from(Artist.class);
        criteriaQuery.select(root)
                .where(builder.like(root.get("artistName"), matchedValue))
                .orderBy(builder.asc(root.get("artistName"))); // chaining the method for better readability
                                                            //  old-fashioned way criteriaQuery.where(builder.like(root.get("artistName"), matchedValue));
                                                          //  criteriaQuery.orderBy(builder.asc(root.get("artistName")));
        return em.createQuery(criteriaQuery).getResultStream();

    }


    private static Stream<Artist> getArtistSQL(EntityManager em, String matchedValue){
        var query = em.createQuery(
                "SELECT * FROM music.artists WHERE artist_name like ?1", Artist.class);
        query.setParameter(1, matchedValue);
        return query.getResultStream();
    }
}
