import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;
import org.hibernate.query.NativeQuery;

import com.mysql.cj.log.Log;

public class Connections {

//	private LocalDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

	public static boolean validateLogIn(String pass, String email) {
		Session session = LogInFrame.factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<Branch> branches = (List<Branch>) session.createCriteria(Branch.class).list();
			for (Iterator iterator = branches.iterator(); iterator.hasNext();) {
				Branch b = (Branch) iterator.next();
				if (b.getEmail().equals(email) && b.getPassword().equals(pass)) {
					tx.commit();
					return true;
				}
			}
			tx.commit();
			return false;
		} catch (HibernateException ex) {
			System.out.println("Problem validate login: " + ex.getMessage());
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	public static boolean validateLoginManager(String email, String pass, String emailBranch) {
		Session session = LogInFrame.factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String sql = "SELECT m.* FROM managers m, branches b WHERE b.email = '"+emailBranch+"' AND b.id = m.id";
			List<Manager> managers = session.createSQLQuery(sql).addEntity(Manager.class).list();
			for (Manager m : managers) {
				if (m.getEmail().equals(email) && m.getPasswrod().equals(pass)) {
					tx.commit();
					return true;
				}
			}
			tx.commit();
			return false;
		} catch (HibernateException ex) {
			System.out.println("Problem validate login manager: " + ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}
	
	public static boolean validateLoginAdmin(String email, String pass) {
		Session session = LogInFrame.factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			String sql = "SELECT * FROM admin";
			List<Admin> admins = session.createSQLQuery(sql).addEntity(Admin.class).list();
			for (Admin a : admins) {				
				if (a.getEmail().equals(email) && a.getPassword().equals(pass)) {
					tx.commit();
					return true;
				}
			}
			tx.commit();
			return false;
		} catch (HibernateException ex) {
			System.out.println("Problem validate login: " + ex.getMessage());
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}
	

	public List<Worker> getWorkers() {
		Session session = LogInFrame.factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<Worker> workers = (List<Worker>) session.createSQLQuery(
					"SELECT w.id, w.fk_branc_id, b.name as branch_name, w.name, w.last_name, w.email, w.password, w.active FROM workers w, branches b where w.fk_branc_id = b.id")
					.addEntity(Worker.class).list();
			tx.commit();
			return workers;
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	public List<Branch> getBranches() {
		Session session = LogInFrame.factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<Branch> branches = (List<Branch>) session.createSQLQuery("SELECT * FROM branches")
					.addEntity(Branch.class).list();
			tx.commit();
			return branches;
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
			return null;
		} finally {
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
			List<Worker> workers = (List<Worker>) session.createSQLQuery(sql).addEntity(Worker.class).list();
			tx.commit();
			return workers;
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public int getBranchId(String email) {
		Session session = LogInFrame.factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String sql = "select * from `branches` WHERE email = '" + email + "'";
			List<Branch> branch = (List<Branch>) session.createSQLQuery(sql).addEntity(Branch.class).list();

			if (branch != null) {
				tx.commit();
				return branch.get(0).getId();
			} else {
				tx.commit();
				return -1;
			}
		} catch (HibernateException ex) {
			System.out.println("Problem get branch id :" + ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
			return -1;
		} finally {
			session.close();
		}
	}

	public boolean duplicateEntryBranch(String email) {
		Session session = LogInFrame.factory.openSession();
		Transaction tx = null;
		try {
			String sql = "SELECT email FROM branches";
			List<String> branch = (List<String>) session.createSQLQuery(sql).list();
			tx = session.beginTransaction();
			for (String aa : branch) {
				if (aa.equals(email)) {
					return true;
				}
			}
			tx.commit();
			return false;
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			return false;
		} finally {
			session.close();
		}
	}

	public boolean insertBranch(Branch b) {
		Session session = LogInFrame.factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(b);
			tx.commit();
			return true;
		} catch (HibernateException ex) {
			System.out.println("Problem insert branch: " + ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	public boolean insertEmployee(Worker w) {
		Session session = LogInFrame.factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(w);
			tx.commit();
			System.out.println(w.toString());
			return true;
		} catch (HibernateException ex) {
			System.out.println("Problem insert employee: " + ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	public boolean removeWorker(int id) {
		Session session = LogInFrame.factory.openSession();
		Transaction tx = null;
		Worker w = session.find(Worker.class, id);
		w.setActive(0);
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(w);
			tx.commit();
			return true;
		} catch (HibernateException ex) {
			System.out.println("Problem remove worker: " + ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	public boolean editWorker(Worker w) {
		Session session = LogInFrame.factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(w);
			tx.commit();
			return true;
		} catch (HibernateException ex) {
			System.out.println("Problem edit worker: " + ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	public boolean restoreWorker(int id) {
		Session session = LogInFrame.factory.openSession();
		Transaction tx = null;
		Worker w = session.find(Worker.class, id);
		w.setActive(1);
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(w);
			tx.commit();
			return true;
		} catch (HibernateException ex) {
			System.out.println("Problem restore worker: " + ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	public boolean editBranch(Branch b) {
		Session session = LogInFrame.factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(b);
			tx.commit();
			return true;
		} catch (HibernateException ex) {
			System.out.println("Problem edit branch: " + ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	public boolean removeBranch(int id) {
		Session session = LogInFrame.factory.openSession();
		Transaction tx = null;
		Branch b = session.find(Branch.class, id);
		b.setActive(0);
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(b);
			tx.commit();
			return true;
		} catch (HibernateException ex) {
			System.out.println("Problem remove branch: " + ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	public boolean restoreBranch(int id) {
		Session session = LogInFrame.factory.openSession();
		Transaction tx = null;
		Branch b = session.find(Branch.class, id);
		b.setActive(1);
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(b);
			tx.commit();
			return true;
		} catch (HibernateException ex) {
			System.out.println("Problem restore branch: " + ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	public boolean updateWorkersBranch(int workersId, int branchIdNew) {
		Session session = LogInFrame.factory.openSession();
		Transaction tx = null;
		Worker w = session.find(Worker.class, workersId);
		w.setFrBranch(branchIdNew);
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(w);
			tx.commit();
			return true;
		} catch (HibernateException ex) {
			System.out.println("Problem update workers branch : " + ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	public int getShiftIdByWorkerId(int worker_id) {
		Session session = MainFrame.factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String sql = "SELECT s.id FROM shifts s WHERE s.id = '" + worker_id + "'";
			List<Shift> shifts = (List<Shift>) session.createSQLQuery(sql).addEntity(Shift.class).list();
			tx = session.beginTransaction();
			int shiftId = 0;
			for (Shift s : shifts) {
				shiftId = s.getId();
			}
			tx.commit();
			return shiftId;
		} catch (HibernateException ex) {
			System.out.println("Problem get shifts by worker id: " + ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
			return -1;
		} finally {
			session.close();
		}
	}

	public boolean insertWokrerShift(Worker_shift ws) {
		Session session = LogInFrame.factory.openSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.persist(ws);
			tx.commit();
			return true;
		} catch (HibernateException ex) {
			System.out.println("Problem insert worker_shift: " + ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	public boolean insertWorker_shift(List<Worker_shift> ws, List<Integer> nonWorkingDays, String numDays,
			int branchId) {

		Session session = LogInFrame.factory.openSession();
		Transaction tx = null;
		String sql = null;
		try {
			tx = session.beginTransaction();
			for (Worker_shift worker_shift : ws) {
				LocalDate date = worker_shift.getDate();
				LocalDate endDate = date.plusDays(Integer.parseInt(numDays));
				for (LocalDate date1 = date; date.isBefore(endDate); date = date.plusDays(1)) {
					worker_shift.setDate(date);
					session.createNativeQuery(
							"INSERT INTO worker_shift (worker_id, shift_id, branch_id, " + "date) VALUES (?, ?, ?, ?)")
							.setParameter(1, worker_shift.getWorker_id()).setParameter(2, worker_shift.getShift_id())
							.setParameter(3, branchId).setParameter(4, date).executeUpdate();
				}
			}
			tx.commit();

		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return true;
	}
	
	
	public boolean isAdmin(String email) {
		Session session = LogInFrame.factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			String sql = "SELECT * FROM admin";
			List<Admin> admins = session.createSQLQuery(sql).addEntity(Admin.class).list();
			for(Admin a: admins) {
				if(a.getEmail().equals(email)) {
					tx.commit();
					return true;
				}
			}
			tx.commit();
			return false;
		}catch(HibernateException ex) {
			System.out.println("Problem is admin: " +ex.getMessage());
			if(tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
			return false;
		}finally {
			session.close();
		}
		
	}
	
	
}
