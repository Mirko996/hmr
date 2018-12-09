import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Connections {

	public static boolean validateLogIn(String pass, String username) {
		Session session = LogInFrame.factory.openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			List<Branch> branches = (List<Branch>) session.createCriteria(Branch.class).list();
			for(Iterator iterator = branches.iterator(); iterator.hasNext();) {
				Branch b = (Branch) iterator.next();
				if(b.getName().equals(username) && b.getPassword().equals(pass)) {
					tx.commit();
					return true;
				}
			}
			tx.commit();
			return false;
		}catch(HibernateException ex) {
			if(tx != null) tx.rollback();
			ex.printStackTrace();
		}finally {
			session.close();
		}
		return false;
	}
	
	public List<Worker> getWorkers(){
		Session session = LogInFrame.factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			List<Worker> workers = (List<Worker>) session.createSQLQuery("SELECT w.id, w.fk_branc_id, b.name as branch_name, w.name, w.last_name, w.email, w.password, w.active FROM workers w, branches b where w.fk_branc_id = b.id").addEntity(Worker.class).list();
			tx.commit();
			return workers;
		}catch(HibernateException ex){
			if(tx != null) tx.rollback();
			ex.printStackTrace();
			return null;
		}finally {
			session.close();
		}
	}

	public List<Shift> getShifts() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Worker> getWorkersByBranch(int id) {
		Session session = LogInFrame.factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			String sql = "SELECT * FROM workers WHERE fk_branc_id = '" + id + "'";
			List<Worker> workers = (List<Worker>)session.createCriteria(sql);
			return workers;
			
		}catch(HibernateException ex){
			ex.printStackTrace();
		}finally {
			
		}
		return null;
	}
}
