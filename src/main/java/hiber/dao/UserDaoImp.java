package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private static final String HQL_USERS_BY_CAR_STATEMENT = "from User u where u.car is not null and u.car.model = :model and u.car.series = :series";

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      if (user.getCar() != null) {
         sessionFactory.getCurrentSession().save(user.getCar());
      }
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public User getUserByCarStatement(String model, int series) {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(HQL_USERS_BY_CAR_STATEMENT);
      query.setMaxResults(1);
      query.setParameter("model", model);
      query.setParameter("series", series);
      return query.getSingleResult();
   }

}
