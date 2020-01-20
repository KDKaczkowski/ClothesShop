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
/**
 * klasa odpowiedzialna za komunikacje z baza danych dla zdarzen dotyczacych ubran
 */
public class ClothDao {

    /**
     * funkcja dodajaca nowe ubranie do bazy danych
     * @return
     */
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

    /**
     * funkcja wypisujaca wszystkie ubrania w konsoli
     */
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

    /**
     * funkcja zwracająca liste wszytkich ubran dostepnych w bazie danych
     * @return
     */
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

    /**
     * funkcja zwracajaca wszystkie ubrania o danym typie z bazy danych
     * @param type - typ ubran ktore chcemy otrzymac
     * @return
     */
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

    /**
     * funkcja zwracajaca wszystkie ubrania o danej marki z bazy danych
     * @param brand - marka ubran ktore chcemy otrzymac
     * @return
     */
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

    /**
     * funkcja zwracajaca wszystkie ubrania o danym typie i marce z bazy danych
     * @param type - typ ubran ktore chcemy otrzymac
     * @param brand = marka ubran ktore chcemy otrzymac
     * @return
     */
    public List< Cloth > getClothesOfTypeAndBrand(Type type, Brand brand){
        List< Cloth > clothes = new ArrayList<>();
        try(Session session = Util.getSessionFactory().openSession()){
            clothes = session.createQuery("FROM  Cloth C where  C.type = :type AND C.brand = :brand", Cloth.class)
                    .setParameter("type", type)
                    .setParameter("brand", brand)
                    .list();
            session.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return clothes;
    }

}
