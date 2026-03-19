package com.org.jpa.hibernateProject1;

import java.util.List;
import org.hibernate.*;
import org.hibernate.query.Query;

public class UserDao {

    private SessionFactory factory = HibernateUtil.getFactory();

    // 1. Save User
    public void saveUser(User user) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();
    }

    // 2. Update User
    public void updateUser(User user) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
        session.close();
    }

    // 3. Find by ID
    public User findById(int id) {
        Session session = factory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    // 4. Verify by phone & password
    public User verifyByPhone(long phone, String password) {
        Session session = factory.openSession();
        Query<User> q = session.createQuery(
            "from User where phone=?1 and password=?2", User.class);
        q.setParameter(1, phone);
        q.setParameter(2, password);
        return q.uniqueResult();
    }

    // 5. Verify by email & password
    public User verifyByEmail(String email, String password) {
        Session session = factory.openSession();
        Query<User> q = session.createQuery(
            "from User where email=?1 and password=?2", User.class);
        q.setParameter(1, email);
        q.setParameter(2, password);
        return q.uniqueResult();
    }

    // 6. Verify by id & password
    public User verifyById(int id, String password) {
        Session session = factory.openSession();
        Query<User> q = session.createQuery(
            "from User where id=?1 and password=?2", User.class);
        q.setParameter(1, id);
        q.setParameter(2, password);
        return q.uniqueResult();
    }

    // 7. Delete by ID
    public void deleteUser(int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        User user = session.get(User.class, id);
        if (user != null) session.delete(user);
        tx.commit();
        session.close();
    }

    // 8. Find by name
    public List<User> findByName(String name) {
        Session session = factory.openSession();
        Query<User> q = session.createQuery(
            "from User where name=?1", User.class);
        q.setParameter(1, name);
        return q.list();
    }

    // 9. Find by phone
    public User findByPhone(long phone) {
        Session session = factory.openSession();
        Query<User> q = session.createQuery(
            "from User where phone=?1", User.class);
        q.setParameter(1, phone);
        return q.uniqueResult();
    }

    // 10. Find by email
    public User findByEmail(String email) {
        Session session = factory.openSession();
        Query<User> q = session.createQuery(
            "from User where email=?1", User.class);
        q.setParameter(1, email);
        return q.uniqueResult();
    }

    // 11. Fetch all phone numbers
    public List<Long> getAllPhones() {
        Session session = factory.openSession();
        Query<Long> q = session.createQuery(
            "select phone from User", Long.class);
        return q.list();
    }

    // 12. Fetch all users
    public List<User> getAllUsers() {
        Session session = factory.openSession();
        Query<User> q = session.createQuery("from User", User.class);
        return q.list();
    }

    // 13. Fetch all emails
    public List<String> getAllEmails() {
        Session session = factory.openSession();
        Query<String> q = session.createQuery(
            "select email from User", String.class);
        return q.list();
    }
}