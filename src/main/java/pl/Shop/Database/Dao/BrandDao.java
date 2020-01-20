package pl.Shop.Database.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.Shop.Database.HibernateUtil.Util;
import pl.Shop.Database.Models.Brand;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
/**
 * klasa odpowiedzialna za komunikacje z baza danych dla zdarzen dotyczacych marki ubran
 */
public class BrandDao {
    /**
     * funkcja tworzaca nowa marke ubran
     * @param name
     */
    public void createNewBrand(String name){
        Brand brand = new Brand();
        brand.setName(name);

        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(brand);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * funkcja zwracajaca instancje marki dla danej nazwy
     * @param name nazwa marki ktorej szukamy
     * @return obiekt Brand
     */
    public Brand getBrandByName(String name){
        Brand brand = new Brand();
        try (Session session = Util.getSessionFactory().openSession()) {
            Query query = session.createQuery("from Brand E WHERE E.name = :name", Brand.class);
            query.setParameter("name", name);
            brand = (Brand) query.list().get(0);
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return brand;
    }

    /**
     * funkcja zwracająca listę wszyskich marek ubran
     * @return
     */
    public List<Brand> getAllBrands(){
        List< Brand > brands = new ArrayList<>();
        try (Session session = Util.getSessionFactory().openSession()) {
            brands = session.createQuery("from Brand", Brand.class).list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return brands;
    }
}
