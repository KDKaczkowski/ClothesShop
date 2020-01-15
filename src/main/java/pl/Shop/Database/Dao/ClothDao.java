package pl.Shop.Database.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.Shop.Database.HibernateUtil.Util;
import pl.Shop.Database.Models.Cloth;

import java.math.BigDecimal;
import java.util.List;

public class ClothDao {

    public int createNewCloth(String name, String type, String brand, BigDecimal price, String size, int quantity){
        Cloth cloth = new Cloth();
        cloth.setName(name);
        cloth.setType(type);
        cloth.setBrand(brand);
        cloth.setPrice(price);
        cloth.setSize(size);
        cloth.setQuantity(quantity);
        int clothID = 0;
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            clothID = (int) session.save(cloth);
            transaction.commit();
            if(clothID == 0)
                throw new Exception();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return clothID;
    }

    public void printAllUsers(){
        Transaction transaction = null;
        StringBuilder output = new StringBuilder();
        try (Session session = Util.getSessionFactory().openSession()) {
            List< Cloth > clothes = session.createQuery("from User", Cloth.class).list();
            clothes.forEach(s -> output.append(
                    "Name: " + s.getName() + "\n"
                            + "Type: " + s.getType() + "\n"
                            + "Brand: " + s.getBrand() + "\n"
                            + "Price: " + s.getPrice() + "\n"
                            + "Size: " + s.getSize() + "\n"
                            + "Quantity: " + s.getQuantity() + "\n"
                            + "-----------------------------" + "\n"
            ));
            System.out.println(output.toString());
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
