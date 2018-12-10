import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mysql.cj.log.Log;

public class Connections {

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
			if(tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}
}
