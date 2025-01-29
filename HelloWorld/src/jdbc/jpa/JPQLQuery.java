package jdbc.jpa;

import jakarta.persistence.EntityManager;
import jdbc.jpa.entity.Artist;

import java.util.List;

public class JPQLQuery {
    public static void main(String[] args) {

    }

    private static List<Artist> getArtistJPQL(EntityManager em, String matchedValue){
        String jpql = "SELECT a FROM Artist a";
        var query = em.createQuery(jpql, Artist.class);
        return query.getResultList();
    }
}
