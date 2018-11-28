package repository;

import model.Users;
import org.hibernate.Session;


import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import java.util.List;

public class UsersRepository {

    public List<Users> getAllUsers() {
        Session session = DataSource.getSessionFactory().openSession();
        List<Users> usersList = session.createQuery("from Users").list();
        session.close();
        return usersList;
    }

    public void addUser(String userName, String pasportData) {
        Session session = DataSource.getSessionFactory().openSession();
        Users user = new Users();
        user.setUserName(userName);
        user.setPasportData(pasportData);
        session.save(user);
        session.close();

    }

    public void deleteUser(String userName)  {
        Session session = DataSource.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from Users where userName=?1");
        query.setParameter(1,userName);
        query.executeUpdate();

        session.close();
    }





}
