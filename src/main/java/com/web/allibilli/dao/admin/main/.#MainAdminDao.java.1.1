package com.dao.admin.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.beans.hibernate.Accordians;
import com.beans.hibernate.TreeElements;

@Repository
public class MainAdminDao {

	@Autowired
	private SessionFactory sessionFactory;

	public int saveTreeElement(TreeElements bean) {

		Session session = sessionFactory.openSession();
		int sBean = (Integer)session.save(bean);
		session.flush();
		session.close();
	
		return sBean;
	}

	public void updateTreeElement(TreeElements bean) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(bean);
		session.flush();
		session.close();
	}

	public void deleteTreeElement(TreeElements bean) {
		Session session = sessionFactory.openSession();
		session.delete(bean);
		session.flush();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Accordians> loadAccordians(int panelId) {

		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Accordians a where a.panelId = :panleId")
				.setInteger("panleId", panelId);
		List<Accordians> l = query.list();
		session.close();
		return l;
	}
	@SuppressWarnings("unchecked")
	public List<TreeElements> loadTreeRoots(int accdId) {

		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from TreeElements a where a.accdId = :accdId and a.leaf=0")
				.setInteger("accdId", accdId);
		List<TreeElements> l = query.list();
		session.close();
		return l;
	}
	@SuppressWarnings("unchecked")
	public List<TreeElements> loadTreeElements(int treeRootId) {

		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from TreeElements a where a.rootId = :treeRootId and a.leaf=1")
				.setInteger("treeRootId", treeRootId);
		List<TreeElements> l = query.list();
		session.close();
		return l;
	}
	@SuppressWarnings("unchecked")
	public List<TreeElements> loadTreeElement(int eleId) {

		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from TreeElements a where a.eleId = :eleId and a.leaf=1")
				.setInteger("eleId", eleId);
		List<TreeElements> l = query.list();
		session.close();
		return l;
	}
}
