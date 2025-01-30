package jdbc.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jdbc.jpa.entity.Artist;

public class JPAProject {
    public static void main(String[] args) {
        try (var sessionFactory =
                     Persistence.createEntityManagerFactory(
                             "jdbc.jpa");
             EntityManager entityManager = sessionFactory.createEntityManager();


        ) {

            var transaction = entityManager.getTransaction();
            transaction.begin();


            Artist artist = entityManager.find(Artist.class, 103);
            System.out.println(artist);

//
//            artist.addAlbums("The Best of Muddy Water");
//
//            System.out.println(artist);





            //artist.removeDuplicates();
            //  Artist artist = new Artist(202, "Muddy Water");
            // artist.setArtistName("Muddy Waters");
            // entityManager.persist(new Artist("Muddy Water"));
            // entityManager.remove(artist);
            //  entityManager.merge(artist);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
