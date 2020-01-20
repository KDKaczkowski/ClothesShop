package pl.Shop.Database.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.Shop.Database.HibernateUtil.Util;
import pl.Shop.Database.Models.Brand;
import pl.Shop.Database.Models.Type;

import java.util.ArrayList;
import java.util.List;
/**
 * klasa odpowiedzialna za komunikacje z baza danych dla zdarzen dotyczacych typow ubran
 */
public class TypeDao {

    /**
     * funkcja tworzaca nowy typ ubran w bazie danych
     */
    public void createNewType(String name){
        Type type = new Type();
        type.setName(name);

        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(type);
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
     * funkcja zwracajaca instacje klasy Type o podanej nazwie
     * @param name - nazwa typu ktora szukamy
     * @return
     */
    public Type getTypeByName(String name){
        Type type = new Type();
        try (Session session = Util.getSessionFactory().openSession()) {
            Query query = session.createQuery("from Type E WHERE E.name = :name", Type.class);
            query.setParameter("name", name);
            type = (Type) query.list().get(0);
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return type;
    }

    /**
     * funkcja zwracajaca liste wszystkich typów ubran w bazie danych
     * @return
     */
    public List<Type> getAllTypes(){
        List< Type > types = new ArrayList<>();
        try (Session session = Util.getSessionFactory().openSession()) {
            types = session.createQuery("from Type", Type.class).list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return types;
    }
}
