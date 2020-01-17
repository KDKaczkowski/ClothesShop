package pl.Shop.Database.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.Shop.Database.HibernateUtil.Util;
import pl.Shop.Database.Models.Brand;
import pl.Shop.Database.Models.Type;

import java.util.ArrayList;
import java.util.List;

public class TypeDao {

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
