package pl.Shop.Database.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.Shop.Database.HibernateUtil.Util;
import pl.Shop.Database.Models.Brand;
import pl.Shop.Database.Models.Cloth;
import pl.Shop.Database.Models.Size;
import pl.Shop.Database.Models.Type;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ClothDao {

    public int createNewCloth(String name, Type type, Brand brand, BigDecimal price, Size size, int quantity){
        Cloth cloth = new Cloth();
        cloth.setName(name);
        cloth.setType(type);
        cloth.setBrand(brand);
        cloth.setPrice(price);
        cloth.setSize(size);
        cloth.setQuantity(quantity);
        int clothID = -1;
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            clothID = (int) session.save(cloth);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return clothID;

    }

    public void updateClothQuantity(){

    }

    public void updateClothName(){

    }

    public void updateClothPrice(){

    }


    public void printAllClothes(){
        StringBuilder output = new StringBuilder();
        try (Session session = Util.getSessionFactory().openSession()) {
            List< Cloth > clothes = session.createQuery("from Cloth", Cloth.class).list();
            clothes.forEach(s -> output.append(
                    "Name: " + s.getName() + "\n"
                            + "Type: " + s.getType().getName() + "\n"
                            + "Brand: " + s.getBrand().getName() + "\n"
                            + "Price: " + s.getPrice() + "\n"
                            + "Size: " + s.getSize() + "\n"
                            + "Quantity: " + s.getQuantity() + "\n"
                            + "-----------------------------" + "\n"
            ));
            System.out.println(output.toString());
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Cloth> getAllClothes(){
        List< Cloth > clothes = new ArrayList<>();
        try (Session session = Util.getSessionFactory().openSession()) {
            clothes = session.createQuery("from Cloth", Cloth.class).list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clothes;
    }

    public List<Cloth> getClothesOfType(Type type){
        List< Cloth > clothes = new ArrayList<>();
        try(Session session = Util.getSessionFactory().openSession()){
            clothes = session.createQuery("FROM Cloth C WHERE C.type = :type", Cloth.class)
                    .setParameter("type", type)
                    .list();
            session.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return  clothes;
    }

    public List< Cloth > getClothesOfBrand(Brand brand){
        List< Cloth > clothes = new ArrayList<>();
        try(Session session = Util.getSessionFactory().openSession()){
            clothes = session.createQuery("FROM  Cloth C where  C.brand = :brand", Cloth.class)
                    .setParameter("brand", brand)
                    .list();
            session.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return clothes;
    }

}
